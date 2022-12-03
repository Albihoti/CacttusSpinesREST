package com.example.springbootproject.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;

public class PerdoruesiDto {


    private Integer id;


    private String username;


    private String email;


    private String password;


    private String matchingPassword;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }


    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(@NotNull String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
