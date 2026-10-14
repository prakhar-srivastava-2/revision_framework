package com.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostResponse{
    public String name;
    public String job;
    public String id;
    @JsonProperty("createdAt")
    public String time;
    public PostResponse(){}

    public PostResponse(String name,String job,String id,String time){
        this.name = name;
        this.job = job;
        this.id = id;
        this.time = time;
    }

    public String getName(){
        return this.name;
    }
    public String getJob(){
        return this.job;
    }
    public String getId(){
        return this.id;
    }
    public String getTime(){
        return this.time;
    }
}