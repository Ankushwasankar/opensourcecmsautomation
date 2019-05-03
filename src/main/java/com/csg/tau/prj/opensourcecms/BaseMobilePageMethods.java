package com.csg.tau.prj.opensourcecms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.csg.tau.prj.opensourcecms.PropertyKeys.OPEN_SOURCE_CMS_APP_URL;

public class BaseMobilePageMethods {

    WebDriverWait wait;
    public static WebDriver driver;

    String baseUrl = OPEN_SOURCE_CMS_APP_URL;

    public BaseMobilePageMethods() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");

        if(driver == null){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        driver.get(baseUrl);
    }

    public WebDriver getDriver() {

        if(driver ==null){
            driver = new ChromeDriver();
        }
        else {
            return driver;
        }
        return driver;
    }

    public void closeBrowser(){

        driver.quit();
    }

    public void waitTillPageLoad(){

        wait = new WebDriverWait(driver,120);
    }
}
