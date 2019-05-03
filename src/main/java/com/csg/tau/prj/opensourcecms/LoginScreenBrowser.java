package com.csg.tau.prj.opensourcecms;

import com.csg.tau.prj.opensourcecms.utils.TestExecutionParameters;
/*import org.mortbay.log.Log;*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginScreenBrowser extends BaseMobilePageObject implements LoginScreen {
/*
    private static final Logger LOG = LoggerFactory.getLogger(LoginScreenBrowser.class);

    private String language;

*//*        public LoginScreenBrowser(WebDriver webDriver, ConfigProvider configProvider)
    {
        super(webDriver,configProvider);
    }*//*

    @Override
    public LoginScreen url(String url) {
        return null;
    }

    @Override
    public void doLogin() {
*//*        navigateToLogin();*//*
        Log.info("Application launch with language: "+language);
    }

*//*    private void navigateToLogin(){
        getWebDriver().manage().deleteAllCookies();
        getWebDriver().get(url);
    }*//*

    @Override
    public String getApplicationDefaultLanguage() {
        return null;
    }

    @Override
    public void setApplicationLanguage(String setApplicationLanguage) {

    }

    @Override
    public void testCaseIDs(TestExecutionParameters parameters,final int... testId) {
        String testCaseId="";
        for(int i=0;i < testId.length;i++){
            testCaseId = testCaseId+ testId[i]+",";
        }
        String bankName=parameters.bank().name().toString();
        String user = parameters.customerSegment().name().toString();

        Assert.assertTrue(true,"Test script execution is started for"+bankName+" "+user+" "+"customer"+" "+"with ALM test case ID "+testCaseId);
    }

    @Override
    public void testScriptStart(TestExecutionParameters parameters,final int... testID) {
        String testCaseId="";
        for(int i=0;i < testID.length;i++){
            testCaseId = testCaseId+ testID[i]+",";
        }
        String bankName=parameters.bank().name().toString();
        String user = parameters.customerSegment().name().toString();

        Assert.assertTrue(true,"Test script execution is started for"+bankName+" "+user+" "+"customer"+" "+"with ALM test case ID "+testCaseId);
    }

    @Override
    public void closeApp() {

    }

    private enum Element{
        applicationDefaultLanguage(By.xpath("")),
        Home(By.xpath("")),
        Next(By.xpath("")),
        End(By.xpath("")),
        Logout(By.xpath(""));

        private final By locator;

        Element(By locator){

            this.locator=locator;}
    }

    private enum Language{
        EN(By.xpath("")),
        FR(By.xpath("")),
        IT(By.xpath("")),
        DE(By.xpath(""));

        private final By locator;

        Language(By locator){

            this.locator=locator;}
    }*/
}
