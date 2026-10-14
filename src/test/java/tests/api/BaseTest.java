package tests.api;

import org.testng.annotations.BeforeClass;

import com.api.clients.PostClient;
import com.api.clients.UserClient;
import com.api.config.ApiConfig;

public class BaseTest{
    protected PostClient postClient;
    protected UserClient userClient;

    @BeforeClass
    public void makeConnection(){
        postClient = new PostClient(ApiConfig.getRequestSpec());
        userClient = new UserClient(ApiConfig.getRequestSpec());

    }
}