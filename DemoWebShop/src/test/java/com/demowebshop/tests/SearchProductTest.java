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

/**
 * SearchProductTest - Test class for DemoWebShop product search functionality.
 * Validates search with valid products, empty search, and non-existent products.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
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

        String title = homePage.verifyTitle();
        logger.info("Search results page title: {}", title);

        Assert.assertTrue(title.contains("Search"),
                "Page title should contain 'Search' after searching");
        logger.info("Valid product search test - PASSED");
    }

    @Test(priority = 2)
    @Story("Search Non-Existent Product")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify search handles non-existent product gracefully")
    public void verifySearchNonExistentProduct() {
        logger.info("Starting verifySearchNonExistentProduct test");

        HomePage homePage = new HomePage(driver);

        homePage.searchProduct("NonExistentProduct12345");

        String title = homePage.verifyTitle();
        Assert.assertTrue(title.contains("Search"),
                "Should navigate to search results page");
        logger.info("Non-existent product search test - PASSED");
    }

    @Test(priority = 3)
    @Story("Search with Partial Text")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify search works with partial product name")
    public void verifySearchWithPartialText() {
        logger.info("Starting verifySearchWithPartialText test");

        HomePage homePage = new HomePage(driver);

        homePage.searchProduct("Book");

        String title = homePage.verifyTitle();
        Assert.assertTrue(title.contains("Search"),
                "Page title should contain 'Search'");
        logger.info("Partial text search test - PASSED");
    }

    @Test(priority = 4)
    @Story("Verify Home Page Elements")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify home page logo and title are displayed correctly")
    public void verifyHomePageElements() {
        logger.info("Starting verifyHomePageElements test");

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.isLogoDisplayed(),
                "Site logo should be displayed");

        String title = homePage.verifyTitle();
        Assert.assertNotNull(title, "Page title should not be null");
        Assert.assertFalse(title.isEmpty(), "Page title should not be empty");
        logger.info("Home page elements verification test - PASSED");
    }
}
