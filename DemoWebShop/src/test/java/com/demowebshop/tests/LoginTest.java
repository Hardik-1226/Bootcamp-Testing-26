package com.demowebshop.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utils.ExcelDataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * LoginTest - Test class for DemoWebShop login functionality.
 * Validates login with valid/invalid credentials using Page Object Model.
 * Matches training slide implementation pattern.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
@Epic("DemoWebShop Automation")
@Feature("Login")
public class LoginTest extends BaseClass {

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test(priority = 1)
    @Story("Valid Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify user can login with valid credentials from Excel data")
    public void verifyLoginWithValidCredentials() {
        logger.info("Starting verifyLoginWithValidCredentials test");

        LoginPage loginPage = new LoginPage(driver);
        ExcelDataProvider excel = new ExcelDataProvider();

        String user = excel.getStringData("LoginData", 1, 0);
        String pass = excel.getStringData("LoginData", 1, 1);

        HomePage homePage = loginPage.login(user, pass);

        String title = driver.getTitle();
        logger.info("Page Title: {}", title);

        Assert.assertTrue(homePage.isUserLoggedIn(), "User should be logged in after valid login");
        logger.info("Login test with valid credentials - PASSED");
    }

    @Test(priority = 2)
    @Story("Invalid Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login fails with invalid credentials")
    public void verifyLoginWithInvalidCredentials() {
        logger.info("Starting verifyLoginWithInvalidCredentials test");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("invalid@test.com");
        loginPage.enterPassword("WrongPassword");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                "Login error message should be displayed for invalid credentials");
        logger.info("Invalid login test - PASSED");
    }

    @Test(priority = 3)
    @Story("Login with Config Credentials")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify login using credentials from Config.properties")
    public void verifyLoginWithConfigCredentials() {
        logger.info("Starting verifyLoginWithConfigCredentials test");

        LoginPage loginPage = new LoginPage(driver);

        String username = config.getUsername();
        String password = config.getPassword();

        HomePage homePage = loginPage.login(username, password);

        String accountEmail = homePage.getAccountEmail();
        logger.info("Logged in as: {}", accountEmail);

        Assert.assertEquals(accountEmail, username,
                "Account email should match the login email");
        logger.info("Config credentials login test - PASSED");
    }

    @Test(priority = 4)
    @Story("Empty Credentials Login")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify login fails with empty email and password")
    public void verifyLoginWithEmptyCredentials() {
        logger.info("Starting verifyLoginWithEmptyCredentials test");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                "Error message should be displayed for empty credentials");
        logger.info("Empty credentials login test - PASSED");
    }
}
