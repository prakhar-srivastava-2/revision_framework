package com.ui.model;

public class LoginPageModel{
    public final String userId;
    public final String password;

    public LoginPageModel(String userId,String password){
        this.userId = userId;
        this.password = password;
    }

    public String getUsername(){
        return userId;
    }

    public String getPassword(){
        return password;
    }
}