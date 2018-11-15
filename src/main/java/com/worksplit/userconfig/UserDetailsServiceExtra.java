package com.worksplit.userconfig;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDetailsServiceExtra extends UserDetailsService {
    UserDetails loadUserByMob(String mob);
    UserDetails loadUserByEmail(String email);
}
