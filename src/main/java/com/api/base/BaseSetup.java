package com.api.base;

import io.restassured.specification.RequestSpecification;

public class BaseSetup{
    public RequestSpecification requestSpec;

    public BaseSetup(RequestSpecification requestSpec){
        this.requestSpec = requestSpec;
    }
}