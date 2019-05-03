package com.csg.tau.prj.opensourcecms.po;

import com.csg.tau.prj.opensourcecms.BaseMobilePageMethods;
import org.openqa.selenium.By;

public class HomePagePO  extends BaseMobilePageMethods {

    public HomePagePO(){

        this.driver = getDriver();
    }

    public void validateSuccessfulLogin(){
        String expectedTitle = "Log In ‹ opensourcecms — WordPress";
        String actualTitle = "";
        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
    }

    public void enterLoginDetails() throws InterruptedException {
        driver.findElement(Element.UserName.locator).clear();
        driver.findElement(Element.UserName.locator).sendKeys("opensourcecms");
        driver.findElement(Element.Password.locator).clear();
        driver.findElement(Element.Password.locator).sendKeys("opensourcecms");
        driver.findElement(Element.LoginButton.locator).click();
    }

    public void closeApplication(){

        closeBrowser();
    }

    private enum Element{

        UserName(By.xpath("//input[@id='user_login']")),
        Password(By.xpath("//input[@id='user_pass']")),
        LoginButton(By.xpath("//input[@id='wp-submit']"));

        private final By locator;

        Element(By locator){

            this.locator=locator;}
        }
}
