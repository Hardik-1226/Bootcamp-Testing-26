package com.Framework.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import utitlity.BrowserFactory;
import utitlity.ConfigDataProvider;
import utitlity.ExcelDataReader;
import utitlity.Helper;

public class BaseClass {

    public WebDriver driver;
    public ExcelDataReader excel;
    public ConfigDataProvider config;

    @BeforeSuite
    public void beforeSuite() {
        excel = new ExcelDataReader();
        config = new ConfigDataProvider();
    }

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.BrowserOptions(
                driver,
                config.getBrowser(),
                config.getAppURL());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Helper.captureScreenshot(driver);
        }
    }

    @AfterClass
    public void afterClass() {
        BrowserFactory.quitBrowser(driver);
    }
}