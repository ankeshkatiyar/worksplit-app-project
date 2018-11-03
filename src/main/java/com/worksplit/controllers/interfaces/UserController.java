package com.worksplit.controllers.interfaces;


import com.worksplit.Constants;
import com.worksplit.dto.UserDTO;
import com.worksplit.models.ErrorResponse;
import com.worksplit.models.UserModel;
import com.worksplit.userconfig.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = Constants.PATH_USERS)
@Api(value="User Creation " , description = "Manage User Creation")
public interface UserController {

    /**
     * <h2>User Registration API<h2/>
     * <p>
     * This endpoint is responsible for the registration of new users.
     * This url has to be invoked externally and internally it will call
     * the methods to create users. This makes use of <b>User<b/> Model in tables package.
     * This url can be accessed by anyone without restrictions
     * <p/>
     *
     * @param user
     *      : The user details are passed in the request which is internally mapped to the <b>User</b> Model
     *
     * @return User : The response will return the List of users with the internally generated User Id.
     *
     * @throws java.io.IOException this is the generic IO Exception
     *
     *
     *
     */

    @RequestMapping(value = "/registration", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "Register User" , notes = "Register User ")
    @ApiResponses( value = {
            @ApiResponse(code = 200 , message = "User registered successfully"),
            @ApiResponse(code = 401 , message = "User is unauthorized to access this method" ,response = ErrorResponse.class),
            @ApiResponse(code = 403 , message = "Forbidden to access this method", response = ErrorResponse.class),
            @ApiResponse(code = 500 , message = "Internal error ,not able to perform this operation" , response = ErrorResponse.class),

    })
    @ResponseBody
    ResponseEntity<UserDTO> registerUser(@RequestBody @Valid User user) ;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Login User" , notes = "Login User")
    @ApiResponses( value = {
            @ApiResponse(code = 200 , message = "User Logged in successfully"),
            @ApiResponse(code = 401 , message = "User is unauthorized to access this method" ,response = ErrorResponse.class),
            @ApiResponse(code = 403 , message = "Forbidden to access this method", response = ErrorResponse.class),
            @ApiResponse(code = 404 , message = "Requested details not found" , response = ErrorResponse.class),
            @ApiResponse(code = 500 , message = "Internal error ,not able to perform this operation" , response = ErrorResponse.class),

    })
    @PreAuthorize("hasAnyAuthority('USER','ADMIN')")
    @ResponseBody
    ResponseEntity<UserModel> loginUser(@RequestBody User user);



}