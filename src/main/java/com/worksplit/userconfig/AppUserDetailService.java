package com.worksplit.userconfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class AppUserDetailService implements UserDetailsServiceExtra {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if(user!=null){
            new AccountStatusUserDetailsChecker().check(user);
        }

        return user;
    }

    @Override
    public UserDetails loadUserByMob(String mob) {
        User user = userRepository.findByMob(mob);
        if(user!=null){
            new AccountStatusUserDetailsChecker().check(user);
        }

        return user;
    }

    @Override
    public UserDetails loadUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if(user!=null){
            new AccountStatusUserDetailsChecker().check(user);
        }

        return user;

    }

}
