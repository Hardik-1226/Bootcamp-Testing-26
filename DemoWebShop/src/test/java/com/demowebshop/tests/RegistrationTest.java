package com.demowebshop.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.utils.Helper;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * RegistrationTest - Test class for DemoWebShop user registration.
 * Validates new user registration with various scenarios.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
@Epic("DemoWebShop Automation")
@Feature("Registration")
public class RegistrationTest extends BaseClass {

    private static final Logger logger = LogManager.getLogger(RegistrationTest.class);

    @Test(priority = 1)
    @Story("New User Registration")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify new user can register with valid details")
    public void verifyNewUserRegistration() {
        logger.info("Starting verifyNewUserRegistration test");

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = homePage.goToRegister();

        String randomEmail = Helper.randomEmail();
        String firstName = "Test";
        String lastName = "User";
        String password = "Password@123";

        registerPage.register("Male", firstName, lastName, randomEmail, password);

        String result = registerPage.getRegistrationResult();
        Assert.assertEquals(result, "Your registration completed",
                "Registration success message should be displayed");
        logger.info("New user registration test - PASSED");
    }

    @Test(priority = 2)
    @Story("Duplicate Email Registration")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify registration fails with already registered email")
    public void verifyDuplicateEmailRegistration() {
        logger.info("Starting verifyDuplicateEmailRegistration test");

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = homePage.goToRegister();

        String existingEmail = config.getUsername();
        registerPage.register("Female", "Duplicate", "User", existingEmail, "Password@123");

        String error = registerPage.getValidationError();
        Assert.assertTrue(error.contains("already exists"),
                "Error should indicate email already exists");
        logger.info("Duplicate email registration test - PASSED");
    }

    @Test(priority = 3)
    @Story("Registration with Login Verification")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify newly registered user can login successfully")
    public void verifyRegistrationAndLogin() {
        logger.info("Starting verifyRegistrationAndLogin test");

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = homePage.goToRegister();

        String randomEmail = Helper.randomEmail();
        String password = "SecurePass@456";

        registerPage.register("Male", "Login", "Verify", randomEmail, password);

        String result = registerPage.getRegistrationResult();
        Assert.assertEquals(result, "Your registration completed",
                "Registration should complete successfully");

        registerPage.clickContinue();

        homePage.logout();

        LoginPage loginPage = homePage.goToLogin();
        loginPage.login(randomEmail, password);

        Assert.assertTrue(homePage.isUserLoggedIn(),
                "Newly registered user should be able to login");
        logger.info("Registration and login verification test - PASSED");
    }
}
