package com.api.clients;

import com.api.base.BaseSetup;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserClient extends BaseSetup{

    public UserClient(RequestSpecification requestSpec){
        super(requestSpec);
    }

    public Response getUsers(String page){
        return given()
        .spec(requestSpec)
        .queryParam("page",page)
        .when()
        .get("api/users");
    }

    public Response getUser(int id){
        return given()
        .spec(requestSpec)
        .pathParam("id",id)
        .when()
        .get("/api/users/{id}");
    }
}