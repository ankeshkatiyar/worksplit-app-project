package com.worksplit.service;


import com.worksplit.dao.interfaces.UsersDAO;
import com.worksplit.dto.UserDTO;
import com.worksplit.exceptions.EmailAlreadyExistException;
import com.worksplit.exceptions.MobileNumberAlreadyExistException;
import com.worksplit.exceptions.UserAlreadyExistException;
import com.worksplit.userconfig.User;
import com.worksplit.userconfig.UserDetailsServiceExtra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.worksplit.models.UserModel;
import com.worksplit.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDetailsServiceExtra userDetailsService;

    @Autowired
    UsersDAO usersDAO;

    @Override
    public UserDTO createUser(User user) throws UserAlreadyExistException{
        if(!checkUserExist(user)){
            encryptPassword(user);
           User userDetails =  usersDAO.createUserDAO(user);
           return createUserDTO(userDetails);
        }
        return null;
    }

    private void encryptPassword(User user) {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String pass = passwordEncoder.encode(user.getPassword());
        user.setPassword(pass);

    }


    private boolean checkUserExist(User user) {
        if(user != null){
            if(userDetailsService.loadUserByUsername(user.getUsername()) == null){
                if(userDetailsService.loadUserByEmail(user.getEmail()) == null){
                    if(userDetailsService.loadUserByMob(user.getMob()) == null){
                        return false ;

                    }else {
                        throw new MobileNumberAlreadyExistException(user.getMob());
                    }
                }
                else{
                    throw new EmailAlreadyExistException(user.getEmail());
                }
            }
            else{
                throw new UserAlreadyExistException(user.getUsername());
            }

        }
        return false;
    }

    @Override
    public UserModel loginUser(User user) {
        return null;
    }

    public UserDTO createUserDTO(User user){

        return  new UserDTO(user.getId() ,user.getName(), user.getUsername() , user.getEmail() , user.getMob() , user.getDevice());

    }
}
