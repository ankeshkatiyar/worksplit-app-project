package com.worksplit.controllers.interfaces;

import com.worksplit.Constants;
import com.worksplit.models.ErrorResponse;
import com.worksplit.tables.GroupConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = Constants.PATH_GROUPS)
@Api(value="Group Configuration " , description = "Manage Group Configurations")
public interface GroupController {
    /**
     * <h2>Create Groups <h2/>
     * <p> This end point is responsible to create the groups in the application.This URL
     * will be invoked externally and internally it will invoke the method to create the groups
     * <p/>
     *
     * @param groups
     *         : The Group Model is passed to the request with all the descriptions
     * @return GroupConfig : The response will return the list of groups that were created with the new creates ID
     * @throws java.io.IOException : Throws a generic IO Exception
     *
     */

    @RequestMapping(path = "/creategroups", method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create Groups" , notes = "Create Groups")
    @ApiResponses( value = {
            @ApiResponse(code = 200 , message = "Group created successfully"),
            @ApiResponse(code = 401 , message = "User is unauthorized to access this method" ,response = ErrorResponse.class),
            @ApiResponse(code = 403 , message = "Forbidden to access this method", response = ErrorResponse.class),
            @ApiResponse(code = 404 , message = "Requested details not found" , response = ErrorResponse.class),
            @ApiResponse(code = 500 , message = "Internal error ,not able to perform this operation" , response = ErrorResponse.class),

    })
    //Specific method to create the group configuration
    @ResponseBody
    ResponseEntity<List<GroupConfig>> createGroups(@RequestBody List<GroupConfig> groups) throws IOException;

    @RequestMapping(path = "groups/deletegroups" ,method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete Groups" , notes = "Delete the groups")
    @ApiResponses( value = {
            @ApiResponse(code = 200 , message = "Group deleted successfully"),
            @ApiResponse(code = 401 , message = "User is unauthorized to access this method" ,response = ErrorResponse.class),
            @ApiResponse(code = 403 , message = "Forbidden to access this method", response = ErrorResponse.class),
            @ApiResponse(code = 404 , message = "Requested details not found" , response = ErrorResponse.class),
            @ApiResponse(code = 500 , message = "Internal error ,not able to perform this operation" , response = ErrorResponse.class),

    })
    //Method to delete the groups
    @ResponseBody
    ResponseEntity<List<GroupConfig>> deleteGroups(@RequestBody List<GroupConfig> groups);


}

