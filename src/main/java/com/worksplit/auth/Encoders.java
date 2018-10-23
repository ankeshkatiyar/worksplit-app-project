package com.worksplit.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Encoders {

    public PasswordEncoder oAuthClientPasswordEncode(){
        return new BCryptPasswordEncoder(4);
    }

    public PasswordEncoder userPasswordEncode(){
        return  new BCryptPasswordEncoder(8);
    }
}
