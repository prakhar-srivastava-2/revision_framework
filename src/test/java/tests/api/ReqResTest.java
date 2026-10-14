package tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.model.PostRequest;
import com.api.model.PostResponse;
import com.api.model.UserResponse;

import io.restassured.response.Response;

public class ReqResTest extends BaseTest{

    @Test
    public void getUsersTest(){
        Response response = userClient.getUsers("2");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("data").size()>0);
        String email = response.getBody().jsonPath().getString("data[0].email");
        String firstName = response.getBody().jsonPath().getString("data[0].first_name");
        int id = response.getBody().jsonPath().getInt("data[0].id");
        System.out.println("email id is-> "+email);
        System.out.println("First name -> "+firstName);
        System.out.println("id is -> "+id);
    }

    @Test
    public void getUserDetailTest(){
        Response response = userClient.getUser(2);
        Assert.assertEquals(response.getStatusCode(), 200);
        UserResponse userResponse = response.as(UserResponse.class);
        Assert.assertEquals(userResponse.getData().getId(), 2);
        Assert.assertTrue(userResponse.getData().getEmail().contains("@"));
        Assert.assertNotNull(userResponse.getData().getFirstName());
    }

    @Test
    public void createPostTest(){
        Response response = postClient.createPost(new PostRequest("Prakhar","SDET"));
        Assert.assertEquals(response.getStatusCode(), 201);
        PostResponse postResponse = response.as(PostResponse.class);
        Assert.assertEquals(postResponse.getName(), "Prakhar");
        Assert.assertEquals(postResponse.getJob(), "SDET");
        Assert.assertNotNull(postResponse.getId());
        Assert.assertNotNull(postResponse.getTime());

    }

    @Test
    public void incorrectUserDetailTest(){
        Response response = userClient.getUser(9999);
        Assert.assertEquals(response.getStatusCode(), 404);
    }

}