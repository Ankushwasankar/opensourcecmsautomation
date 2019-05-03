package com.csg.tau.prj.opensourcecms;
import com.csg.tau.prj.opensourcecms.po.AddNewPostPO;
import com.csg.tau.prj.opensourcecms.po.HomePagePO;
import com.csg.tau.prj.opensourcecms.utils.PropertyKeysReader;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.io.IOException;


public class SampleTest extends BasicMobileAndWebTest {

    @Test
    public void LoginTest() throws InterruptedException {

        final Logger LOGGER = LoggerFactory.getLogger(SampleTest.class);

        HomePagePO HomePagePO = new HomePagePO();
        AddNewPostPO AddNewPostPO = new AddNewPostPO();

        HomePagePO.validateSuccessfulLogin();
        waitTillPageLoad();
        HomePagePO.enterLoginDetails();
        waitTillPageLoad();
        AddNewPostPO.mouseHoverAndClickTab();
        waitTillPageLoad();
        HomePagePO.closeApplication();
    }
}