package com.scaler.basicapp.Models;

public class User {
    private String name;
    private String emailId;

    // Keep this parameterless ctor for safety
    public User() {
        super();
    }

    public User(String name, String emailIdString) {
        super();
        this.name = name;
        this.emailId = emailIdString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
