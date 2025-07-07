package com.ashiqsyed.jbtrckr.dto;

import java.util.Objects;

public class SignupAuthRequest {
    private String email;
    private String username;
    private String password;

    //no argument constructors are needed by Spring Boot
    public SignupAuthRequest() {

    }

    public SignupAuthRequest(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignupAuthRequest that = (SignupAuthRequest) o;
        return Objects.equals(email, that.email) && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, username, password);
    }
}
