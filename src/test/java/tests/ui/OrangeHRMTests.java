package tests.ui;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.model.LoginPageModel;
import com.ui.pages.DashboardPage;
import com.ui.pages.LoginPage;

public class OrangeHRMTests extends BaseSetup{
    private final String URL = "https://opensource-demo.orangehrmlive.com";
    public LoginPageModel loginPageModel;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;

    @BeforeMethod
    public void setup(){
        makeConnection();
        page.navigate(URL);
        page.setDefaultTimeout(8000);
        loginPage = new LoginPage(page);
        dashboardPage = new DashboardPage(page);
    }

    @AfterMethod
    public void tearDown() {
        page.close();
        playwright.close();
}

    @Test
    public void validLoginTest(){
        loginPageModel = new LoginPageModel("Admin","admin123");
        loginPage.login(loginPageModel);

        Assert.assertEquals(dashboardPage.getHeader(), "Dashboard");
    }

    @Test
    public void invalidLoginTest(){
        loginPageModel = new LoginPageModel("Admin","admin12345");
        loginPage.login(loginPageModel);
        Assert.assertEquals(loginPage.invalidMessage(), "Invalid credentials");
    }

    @Test
    public void successfulLogoutTest(){
        loginPageModel = new LoginPageModel("Admin","admin123");
        loginPage.login(loginPageModel);

        dashboardPage.clickProfileIcon();
        dashboardPage.clickLogout();
        Assert.assertTrue(loginPage.isLogoutSuccessful());
    }

}