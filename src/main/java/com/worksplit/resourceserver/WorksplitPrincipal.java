package com.worksplit.resourceserver;

import java.io.Serializable;

public class WorksplitPrincipal implements Serializable {
    private String username;

    private String email;

    public WorksplitPrincipal() {
    }

    public WorksplitPrincipal(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
