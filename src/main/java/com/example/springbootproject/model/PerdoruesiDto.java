package com.example.springbootproject.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;

public class PerdoruesiDto {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private long id;

    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String password;





    public long getId() {
        return id;
    }

    public void setId(long id) {
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


}
