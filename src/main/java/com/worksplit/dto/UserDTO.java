package com.worksplit.dto;

import java.util.List;

public class UserDTO {

    private Integer Id;

    private String name;

    private String userName;

    private String email;

    private String mob;

    private String device ;

    private boolean hasErrors;

    List<String> messages;

    public UserDTO(boolean hasErrors , List<String> messages) {
        this.messages = messages;
        this.hasErrors = hasErrors;
    }

    public UserDTO(Integer id, String name, String userName, String email, String mob, String device) {
        Id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.mob = mob;
        this.device = device;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
