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

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * CheckoutTest - Test class for DemoWebShop end-to-end checkout flow.
 * Validates the complete purchase process from cart to order confirmation.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
@Epic("DemoWebShop Automation")
@Feature("Checkout")
public class CheckoutTest extends BaseClass {

    private static final Logger logger = LogManager.getLogger(CheckoutTest.class);

    @Test(priority = 1)
    @Story("Complete Checkout Flow")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify user can complete the full checkout process")
    public void verifyCompleteCheckoutFlow() {
        logger.info("Starting verifyCompleteCheckoutFlow test");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(config.getUsername(), config.getPassword());

        CartPage cartPage = homePage.goToCart();

        if (cartPage.isCartNotEmpty()) {
            CheckoutPage checkoutPage = cartPage.proceedToCheckout();
            String confirmationMessage = checkoutPage.completeCheckout();

            Assert.assertTrue(confirmationMessage.contains("Your order has been successfully processed"),
                    "Order confirmation message should be displayed");
            logger.info("Complete checkout flow test - PASSED");
        } else {
            logger.warn("Cart is empty, cannot proceed to checkout");
            Assert.fail("Cart must have items to complete checkout test");
        }
    }

    @Test(priority = 2)
    @Story("Checkout Page Verification")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify checkout page loads correctly from cart")
    public void verifyCheckoutPageLoads() {
        logger.info("Starting verifyCheckoutPageLoads test");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(config.getUsername(), config.getPassword());

        CartPage cartPage = homePage.goToCart();

        if (cartPage.isCartNotEmpty()) {
            CheckoutPage checkoutPage = cartPage.proceedToCheckout();

            String title = checkoutPage.getPageTitle();
            logger.info("Checkout page title: {}", title);

            Assert.assertNotNull(title, "Checkout page title should not be null");
            logger.info("Checkout page verification test - PASSED");
        } else {
            logger.warn("Cart is empty, skipping checkout page load test");
        }
    }

    @Test(priority = 3)
    @Story("Order Continuation")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify user can continue shopping after completing an order")
    public void verifyOrderContinuation() {
        logger.info("Starting verifyOrderContinuation test");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(config.getUsername(), config.getPassword());

        CartPage cartPage = homePage.goToCart();

        if (cartPage.isCartNotEmpty()) {
            CheckoutPage checkoutPage = cartPage.proceedToCheckout();
            checkoutPage.completeCheckout();
            homePage = checkoutPage.clickOrderContinue();

            Assert.assertTrue(homePage.isLogoDisplayed(),
                    "Should return to home page after order completion");
            logger.info("Order continuation test - PASSED");
        } else {
            logger.warn("Cart is empty, cannot test order continuation");
        }
    }
}
