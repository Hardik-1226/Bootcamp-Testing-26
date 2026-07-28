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

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLogin();

        ExcelDataProvider excel = new ExcelDataProvider();

        String username = excel.getStringData("LoginData", 1, 0);
        String password = excel.getStringData("LoginData", 1, 1);

        homePage = loginPage.login(username, password);

        logger.info("Page Title: {}", driver.getTitle());

        Assert.assertTrue(homePage.isUserLoggedIn(),
                "User should be logged in after valid login");

        logger.info("Login test with valid credentials - PASSED");
    }

    @Test(priority = 2)
    @Story("Invalid Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify login fails with invalid credentials")
    public void verifyLoginWithInvalidCredentials() {

        logger.info("Starting verifyLoginWithInvalidCredentials test");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLogin();

        loginPage.enterEmail("invalid_unregistered_9999@test.com");
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

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLogin();

        String username = config.getUsername();
        String password = config.getPassword();

        homePage = loginPage.login(username, password);

        Assert.assertTrue(homePage.isUserLoggedIn(),
                "User should be logged in using Config.properties credentials");

        logger.info("Config credentials login test - PASSED");
    }

    @Test(priority = 4)
    @Story("Empty Credentials Login")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify login fails with empty email and password")
    public void verifyLoginWithEmptyCredentials() {

        logger.info("Starting verifyLoginWithEmptyCredentials test");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLogin();

        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                "Error message should be displayed for empty credentials");

        logger.info("Empty credentials login test - PASSED");
    }
}