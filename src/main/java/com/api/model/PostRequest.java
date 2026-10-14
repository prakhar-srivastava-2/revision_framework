package com.api.model;
public class PostRequest{
    public String name;
    public String job;
    public PostRequest(String name,String job){
        this.name = name;
        this.job = job;
    }
    public String getName(){
        return this.name;
    }

    public String getJob(){
        return this.job;
    }
}