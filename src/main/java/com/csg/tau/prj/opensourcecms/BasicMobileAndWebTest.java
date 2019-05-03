package com.csg.tau.prj.opensourcecms;

import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicMobileAndWebTest extends BaseMobilePageMethods{

    WebDriverWait wait;
    public void waitTillPageLoad(){

        wait = new WebDriverWait(driver,300);
    }
}
