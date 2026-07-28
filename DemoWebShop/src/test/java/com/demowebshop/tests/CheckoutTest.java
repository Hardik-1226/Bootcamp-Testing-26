package com.demowebshop.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.CartPage;
import com.demowebshop.pages.CheckoutPage;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.ProductPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("DemoWebShop Automation")
@Feature("Checkout")
public class CheckoutTest extends BaseClass {

    private static final Logger logger = LogManager.getLogger(CheckoutTest.class);

    private CartPage loginAndAddProductToCart() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = homePage.goToLogin();

        homePage = loginPage.login(config.getUsername(), config.getPassword());

        Assert.assertTrue(homePage.isUserLoggedIn(), "Login failed.");

        homePage.searchProduct("Computing and Internet");

        homePage.clickProduct("Computing and Internet");

        ProductPage productPage = new ProductPage(driver);

        productPage.clickAddToCart();

        logger.info("Cart Quantity : {}", homePage.getCartQuantity());

        CartPage cartPage = homePage.goToCart();

        Assert.assertTrue(cartPage.isCartNotEmpty(),
                "Product was not added to cart.");

        return cartPage;
    }

    @Test(priority = 1)
    @Story("Complete Checkout Flow")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify user can complete checkout successfully")
    public void verifyCompleteCheckoutFlow() {

        logger.info("Starting Complete Checkout Test");

        CartPage cartPage = loginAndAddProductToCart();

        CheckoutPage checkoutPage = cartPage.proceedToCheckout();

        String confirmationMessage = checkoutPage.completeCheckout();

        Assert.assertTrue(
                confirmationMessage.contains("Your order has been successfully processed"),
                "Order should be completed successfully.");

        logger.info("Checkout completed successfully.");
    }

    @Test(priority = 2)
    @Story("Checkout Page Verification")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify checkout page opens correctly")
    public void verifyCheckoutPageLoads() {

        logger.info("Starting Checkout Page Test");

        CartPage cartPage = loginAndAddProductToCart();

        CheckoutPage checkoutPage = cartPage.proceedToCheckout();

        Assert.assertTrue(
                checkoutPage.getPageTitle().contains("Checkout"),
                "Checkout page should open.");

        logger.info("Checkout page verified.");
    }

    @Test(priority = 3)
    @Story("Order Continuation")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify Continue button after successful order")
    public void verifyOrderContinuation() {

        logger.info("Starting Continue Shopping Test");

        CartPage cartPage = loginAndAddProductToCart();

        CheckoutPage checkoutPage = cartPage.proceedToCheckout();

        checkoutPage.completeCheckout();

        HomePage homePage = checkoutPage.clickOrderContinue();

        Assert.assertTrue(homePage.isLogoDisplayed(),
                "User should return to Home Page.");

        logger.info("Continue shopping verified.");
    }
}