package com.ui.pages;

import com.microsoft.playwright.Page;
import com.ui.model.LoginPageModel;

public class LoginPage{
    public Page page;
    private final String userNameLocator = "input[name='username']";
    private final String passwordLocator = "input[name='password']";
    private final String loginButton = "button[type='submit']";
    private final String invalidMessage = ".oxd-alert-content-text";
    private final String headerLocator = ".orangehrm-login-title";

    public LoginPage(Page page){
        this.page = page;
    }

    public void login(LoginPageModel loginmodel){
        page.locator(userNameLocator).fill(loginmodel.getUsername());
        page.locator(passwordLocator).fill(loginmodel.getPassword());
        page.click(loginButton);
    }

    public String invalidMessage(){
        String message = page.locator(invalidMessage).innerText();
        return message;
    }

    public boolean isLogoutSuccessful(){
        return "Login".equals(page.locator(headerLocator).innerText());
    }
}