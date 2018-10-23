package com.worksplit.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@Configuration
public class ResourceConfig extends WebSecurityConfigurerAdapter {

   AuthenticationManager authenticationManager;

   @Autowired
    UserDetailsService userDetailsService;
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
       authenticationManager =  super.authenticationManagerBean();
       return authenticationManager;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.parentAuthenticationManager(authenticationManager).userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.
               authorizeRequests().
               anyRequest().
               authenticated().
               and().formLogin().
               permitAll();
    }
}
