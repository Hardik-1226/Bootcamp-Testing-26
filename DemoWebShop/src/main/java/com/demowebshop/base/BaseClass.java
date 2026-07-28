package com.demowebshop.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.demowebshop.utils.BrowserFactory;
import com.demowebshop.utils.ConfigDataProvider;
import com.demowebshop.utils.ScreenshotHelper;

import io.qameta.allure.Allure;

public class BaseClass {

    private static final Logger logger = LogManager.getLogger(BaseClass.class);
    public WebDriver driver;
    public ConfigDataProvider config;

    @BeforeSuite
    public void beforeSuite() {
        logger.info("========================================");
        logger.info("DemoWebShop Automation Suite - STARTED");
        logger.info("========================================");
    }

    @BeforeClass
    public void beforeClass() {
        logger.info("Loading configuration for test class: {}", this.getClass().getSimpleName());
        config = new ConfigDataProvider();
        logger.info("Configuration loaded - Browser: {}, URL: {}", config.getBrowser(), config.getUrl());
    }

    @BeforeMethod
    public void setup() {
        logger.info("--- Test Setup Started ---");
        config = new ConfigDataProvider();
        driver = BrowserFactory.startBrowser(config.getBrowser());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getTimeout()));
        driver.get(config.getUrl());
        logger.info("Browser launched and navigated to: {}", config.getUrl());
        logger.info("--- Test Setup Completed ---");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        logger.info("--- Test Teardown Started ---");

        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("TEST FAILED: {}", result.getName());
            logger.error("Failure reason: {}", result.getThrowable().getMessage());

            String screenshotPath = ScreenshotHelper.captureScreenshot(driver, result.getName());
            logger.info("Failure screenshot saved: {}", screenshotPath);

            byte[] screenshotBytes = ScreenshotHelper.captureScreenshotAsBytes(driver);
            if (screenshotBytes.length > 0) {
                Allure.getLifecycle().addAttachment(
                        "Screenshot on Failure - " + result.getName(),
                        "image/png",
                        "png",
                        screenshotBytes
                );
                logger.info("Screenshot attached to Allure report");
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("TEST PASSED: {}", result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.warn("TEST SKIPPED: {}", result.getName());
        }

        BrowserFactory.quitBrowser(driver);
        logger.info("--- Test Teardown Completed ---");
    }

    @AfterClass
    public void afterClass() {
        logger.info("Test class completed: {}", this.getClass().getSimpleName());
    }

    @AfterSuite
    public void afterSuite() {
        logger.info("========================================");
        logger.info("DemoWebShop Automation Suite - FINISHED");
        logger.info("========================================");
    }
}
