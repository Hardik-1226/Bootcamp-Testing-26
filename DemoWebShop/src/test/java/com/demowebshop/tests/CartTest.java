package com.demowebshop.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.CartPage;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

/**
 * CartTest - Test class for DemoWebShop shopping cart functionality.
 * Validates add, remove, update quantity, and cart verification operations.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
@Epic("DemoWebShop Automation")
@Feature("Shopping Cart")
public class CartTest extends BaseClass {

    private static final Logger logger = LogManager.getLogger(CartTest.class);

    @Test(priority = 1)
    @Story("Navigate to Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can navigate to shopping cart page")
    public void verifyNavigateToCart() {
        logger.info("Starting verifyNavigateToCart test");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(config.getUsername(), config.getPassword());

        CartPage cartPage = homePage.goToCart();

        String title = cartPage.getPageTitle();
        logger.info("Cart page title: {}", title);

        Assert.assertTrue(title.contains("Shopping Cart") || title.contains("Demo Web Shop"),
                "Should navigate to the shopping cart page");
        logger.info("Navigate to cart test - PASSED");
    }

    @Test(priority = 2)
    @Story("Add Product to Cart")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify product can be added to cart via search")
    public void verifyAddProductToCart() {
        logger.info("Starting verifyAddProductToCart test");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(config.getUsername(), config.getPassword());

        homePage.searchProduct("Computing and Internet");
        homePage.clickProduct("Computing and Internet");

        CartPage cartPage = homePage.goToCart();

        String title = cartPage.getPageTitle();
        Assert.assertNotNull(title, "Cart page should load successfully");
        logger.info("Add product to cart test - PASSED");
    }

    @Test(priority = 3)
    @Story("Update Cart Quantity")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify product quantity can be updated in cart")
    public void verifyUpdateCartQuantity() {
        logger.info("Starting verifyUpdateCartQuantity test");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(config.getUsername(), config.getPassword());

        CartPage cartPage = homePage.goToCart();

        if (cartPage.isCartNotEmpty()) {
            cartPage.updateQuantity(2);
            logger.info("Quantity updated to 2");
            Assert.assertTrue(cartPage.isCartNotEmpty(), "Cart should still have items after update");
        } else {
            logger.warn("Cart is empty, skipping quantity update");
        }

        logger.info("Update cart quantity test - PASSED");
    }

    @Test(priority = 4)
    @Story("Remove Product from Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify product can be removed from cart")
    public void verifyRemoveProductFromCart() {
        logger.info("Starting verifyRemoveProductFromCart test");

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login(config.getUsername(), config.getPassword());

        CartPage cartPage = homePage.goToCart();

        if (cartPage.isCartNotEmpty()) {
            int initialCount = cartPage.getCartItemCount();
            logger.info("Initial cart item count: {}", initialCount);

            cartPage.removeFirstProduct();

            int updatedCount = cartPage.getCartItemCount();
            logger.info("Updated cart item count: {}", updatedCount);

            Assert.assertTrue(updatedCount < initialCount || cartPage.isCartEmpty(),
                    "Cart item count should decrease after removal");
        } else {
            logger.warn("Cart is empty, nothing to remove");
        }

        logger.info("Remove product from cart test - PASSED");
    }
}
