package com.demowebshop.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.demowebshop.base.BaseClass;
import com.demowebshop.pages.CartPage;
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
@Feature("Shopping Cart")
public class CartTest extends BaseClass {

    private static final Logger logger = LogManager.getLogger(CartTest.class);

    private HomePage loginToApplication() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLogin();

        homePage = loginPage.login(config.getUsername(), config.getPassword());

        System.out.println("Logged In: " + homePage.isUserLoggedIn());

        Assert.assertTrue(homePage.isUserLoggedIn(), "Login failed before Cart Test");

        return homePage;
    }

    private CartPage addProductToCart() {

        HomePage homePage = loginToApplication();

        homePage.searchProduct("Computing and Internet");
        homePage.clickProduct("Computing and Internet");

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();

        HomePage updatedHomePage = new HomePage(driver);

        return updatedHomePage.goToCart();
    }

    @Test(priority = 1)
    @Story("Navigate to Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify user can navigate to shopping cart page")
    public void verifyNavigateToCart() {

        logger.info("Starting verifyNavigateToCart test");

        HomePage homePage = loginToApplication();

        CartPage cartPage = homePage.goToCart();

        Assert.assertTrue(
                cartPage.getPageTitle().contains("Shopping Cart"),
                "Shopping Cart page should open."
        );

        logger.info("verifyNavigateToCart PASSED");
    }

    @Test(priority = 2)
    @Story("Add Product to Cart")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify product can be added to shopping cart")
    public void verifyAddProductToCart() {

        logger.info("Starting verifyAddProductToCart test");

        CartPage cartPage = addProductToCart();

        Assert.assertTrue(
                cartPage.isCartNotEmpty(),
                "Product should be present in cart."
        );

        logger.info("verifyAddProductToCart PASSED");
    }

    @Test(priority = 3)
    @Story("Update Cart Quantity")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify quantity can be updated")
    public void verifyUpdateCartQuantity() {

        logger.info("Starting verifyUpdateCartQuantity test");

        CartPage cartPage = addProductToCart();

        cartPage.updateQuantity(2);

        Assert.assertTrue(
                cartPage.isCartNotEmpty(),
                "Cart should still contain product after quantity update."
        );

        logger.info("verifyUpdateCartQuantity PASSED");
    }

    @Test(priority = 4)
    @Story("Remove Product from Cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify product can be removed from shopping cart")
    public void verifyRemoveProductFromCart() {

        logger.info("Starting verifyRemoveProductFromCart test");

        CartPage cartPage = addProductToCart();

        int initialCount = cartPage.getCartItemCount();

        cartPage.removeFirstProduct();

        int updatedCount = cartPage.getCartItemCount();

        Assert.assertTrue(
                updatedCount < initialCount || cartPage.isCartEmpty(),
                "Product should be removed from cart."
        );

        logger.info("verifyRemoveProductFromCart PASSED");
    }
}