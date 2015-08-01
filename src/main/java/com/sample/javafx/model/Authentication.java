package com.sample.javafx.model;

/**
 * Created by matt on 31/07/2015.
 */
public class Authentication
{
    private final String username;
    private final String password;
    private final String url;

    public Authentication(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }

     String getUsername() {
        return username;
    }

     String getPassword() {
        return password;
    }

     String getUrl() {
        return url;
    }
}