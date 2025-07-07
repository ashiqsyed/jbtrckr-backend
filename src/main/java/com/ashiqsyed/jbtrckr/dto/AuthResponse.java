package com.ashiqsyed.jbtrckr.dto;

import java.util.Objects;

public class AuthResponse {
    private String token;
    private String username;

    public AuthResponse() {

    }

    public AuthResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthResponse that = (AuthResponse) o;
        return Objects.equals(token, that.token) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, username);
    }
}
