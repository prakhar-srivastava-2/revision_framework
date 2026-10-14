package tests.ui;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseSetup{

    protected Playwright playwright;
    private Browser browser;
    protected Page page;

    protected void makeConnection(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
        page = browser.newPage();
    }
}
