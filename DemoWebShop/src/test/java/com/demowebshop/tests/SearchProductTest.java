package com.demowebshop.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.HomePage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DemoWebShop Automation")
@Feature("Search")
public class SearchProductTest extends BaseClass {

    private static final Logger logger = LogManager.getLogger(SearchProductTest.class);

    @Test(priority = 1)
    @Story("Search Valid Product")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can search for an existing product")
    public void verifySearchValidProduct() {

        logger.info("Starting verifySearchValidProduct test");

        HomePage homePage = new HomePage(driver);

        homePage.searchProduct("Computer");

        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("search"));

        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL : {}", currentUrl);

        Assert.assertTrue(currentUrl.toLowerCase().contains("search"),
                "Search page should open.");

        int count = homePage.getProductCount();
        Assert.assertTrue(count > 0, "At least one product should be displayed.");

        logger.info("Valid product search test PASSED");
    }

    @Test(priority = 2)
    @Story("Search Non-Existent Product")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify search handles non-existent product gracefully")
    public void verifySearchNonExistentProduct() {

        logger.info("Starting verifySearchNonExistentProduct test");

        HomePage homePage = new HomePage(driver);

        homePage.searchProduct("NonExistentProduct12345");

        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("search"));

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.toLowerCase().contains("search"),
                "Search page should open.");

        logger.info("Non-existent product search test PASSED");
    }

    @Test(priority = 3)
    @Story("Search with Partial Text")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify search works with partial product name")
    public void verifySearchWithPartialText() {

        logger.info("Starting verifySearchWithPartialText test");

        HomePage homePage = new HomePage(driver);

        homePage.searchProduct("Comp");

        org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.urlContains("search"));

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.toLowerCase().contains("search"),
                "Search page should open.");

        int count = homePage.getProductCount();
        Assert.assertTrue(count > 0, "Products should be displayed for partial match.");

        logger.info("Partial text search test PASSED");
    }

    @Test(priority = 4)
    @Story("Verify Home Page Elements")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify home page logo and title are displayed correctly")
    public void verifyHomePageElements() {

        logger.info("Starting verifyHomePageElements test");

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isLogoDisplayed(),
                "Logo should be displayed.");

        String title = driver.getTitle();

        Assert.assertNotNull(title);
        Assert.assertFalse(title.isEmpty());

        logger.info("Home page elements verification PASSED");
    }
}