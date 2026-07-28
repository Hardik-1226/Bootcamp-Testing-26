package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.RegisterPage;

public class RegistrationTest extends BaseClass {

    @Test
    public void verifyUserRegistration() {

        HomePage homePage = new HomePage(driver);

        RegisterPage registerPage = homePage.goToRegister();

        String email = "hardik" + System.currentTimeMillis() + "@gmail.com";
        String password = "Hardik@123";

        registerPage.register(
                "Male",
                "Hardik",
                "Varshney",
                email,
                password);

        Assert.assertEquals(
                registerPage.getRegistrationResult(),
                "Your registration completed");

        homePage = registerPage.clickContinue();

        Assert.assertTrue(
                homePage.isUserLoggedIn(),
                "User should be logged in successfully.");
    }
}