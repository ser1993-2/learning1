package com.example.demo1;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Users {
    private String name;
    public  String email;

    Users(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
