package com.api.clients;

import com.api.base.BaseSetup;
import com.api.model.PostRequest;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostClient extends BaseSetup{

    public PostClient(RequestSpecification requestSpec){
        super(requestSpec);
    }

    public Response createPost(PostRequest postRequest){
        return given()
        .spec(requestSpec)
        .body(postRequest)
        .when()
        .post("/api/users");
    }

}