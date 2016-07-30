package com.luisalonso.rxandroidexample.domain;

/**
 * Create by Luis Alonso Paulino Flores <alonsopf1@gmail.com>
 */
public class User {

    static final String DEFAULT_USERNAME = "android";
    static final String DEFAULT_PASSWORD = "android";

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean exist() {
        return (this.username.equals(DEFAULT_USERNAME) && this.password.equals(DEFAULT_PASSWORD));
    }
}
