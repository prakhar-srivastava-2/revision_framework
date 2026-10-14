package com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse{

    private UserData data;

    public UserResponse(){}

    public UserData getData(){
        return data;
    }

}
