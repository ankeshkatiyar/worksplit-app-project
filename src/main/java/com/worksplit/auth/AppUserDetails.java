package com.worksplit.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class AppUserDetails extends Users implements UserDetails {

    public AppUserDetails(final Users users){
        super(users);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<Role> roles = new LinkedHashSet<>();
        roles = getRoles();
        ArrayList<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE"+ role.getRole()));
        }
//        return  getRoles()
//                .stream()
//                .map(role -> new SimpleGrantedAuthority
//                        ("ROLE_"+role.getRole())).collect(Collectors.toList());
        return list;

    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
