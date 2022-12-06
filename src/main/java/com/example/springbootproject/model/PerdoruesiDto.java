package com.example.springbootproject.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.jetbrains.annotations.NotNull;

public class PerdoruesiDto {





    private String username;

    private String email;


    private String password;

    private boolean message;

    public boolean isMessage() {
        return message;
    }

    public void setMessage(boolean message) {
        this.message = message;
    }





    public String getUsername() {
        return username;
    }

    public void setUsername( String username) {
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

    @Override
    public String toString() {
        return "PerdoruesiDto{" +

                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", message=" + message +
                '}';
    }
}
