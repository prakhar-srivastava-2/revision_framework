package com.ui.pages;
import com.microsoft.playwright.Page;

public class DashboardPage{
    public Page page;
    public final String headerLocator = "h6:has-text('Dashboard')";
    private final String profileIconLocator = ".oxd-userdropdown";
    private final String logoutLocator = "ul li a[role='menuitem']:has-text('Logout')";

    public DashboardPage(Page page){
        this.page = page;
    }

    public String getHeader(){
        String header = page.locator(headerLocator).innerText();
        return header;
    }

    public void clickProfileIcon(){
        page.locator(profileIconLocator).click();
    }

    public void clickLogout(){
        page.locator(logoutLocator).click();
    }

}