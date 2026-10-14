package com.api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiConfig{
    private final static String URL = "https://reqres.in";

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder()
            .setBaseUri(URL)
            .setContentType("application/json")
            .build();
        }
    }
