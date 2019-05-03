package com.csg.tau.prj.opensourcecms.po;

import com.csg.tau.prj.opensourcecms.BaseMobilePageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddNewPostPO extends BaseMobilePageMethods {

    public AddNewPostPO(){

        this.driver = getDriver();
    }

    public void mouseHoverAndClickTab() throws InterruptedException {

        WebElement element = driver.findElement(Element.PostTab.locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(120);
        driver.findElement(By.linkText("Categories")).click();
        System.out.println("link clicked......!!!");
    }

    public enum Element{
        PostTab(By.xpath("//div[@class='wp-menu-name' and text()='Posts']"));

        private final By locator;

        Element(By locator){
            this.locator = locator;
        }
    }
}
