package com.worksplit.userconfig;

import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;

public interface AppUserDetails extends UserDetails {
    Integer getId();
    String getMob();
    Timestamp getCreatedOn();
    String getEmail();
    String getName();
    String getDevice();

}
