package com.demowebshop.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    @FindBy(id = "small-searchterms")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@class='button-1 search-box-button']")
    private WebElement searchButton;

    @FindBy(linkText = "Log out")
    private WebElement logoutLink;

    @FindBy(xpath = "//img[@alt='Tricentis Demo Web Shop']")
    private WebElement siteLogo;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement accountLink;

    @FindBy(xpath = "//a[@class='ico-cart']")
    private WebElement cartLink;

    @FindBy(xpath = "//span[@class='cart-qty']")
    private WebElement cartQuantity;

    @FindBy(linkText = "Log in")
    private WebElement loginLink;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(xpath = "//div[@class='product-item']")
    private List<WebElement> productItems;

    @FindBy(xpath = "//h2[@class='product-title']/a")
    private List<WebElement> productTitles;

    @FindBy(xpath = "//div[@class='topic-block-title']/h2")
    private WebElement welcomeMessage;

    public HomePage(WebDriver driver) {
        super(driver);
        logger.info("HomePage initialized");
    }

    public void searchProduct(String productName) {
        logger.info("Searching for product: {}", productName);
        enterText(searchBox, productName);
        clickElement(searchButton);
        logger.info("Search submitted for: {}", productName);
    }

    public void logout() {
        logger.info("Clicking Logout");
        clickElement(logoutLink);
        logger.info("Logout completed");
    }

    public boolean isLogoDisplayed() {
        logger.info("Verifying site logo");
        boolean displayed = isElementDisplayed(siteLogo);
        logger.info("Logo displayed: {}", displayed);
        return displayed;
    }

    public String verifyTitle() {
        String title = getPageTitle();
        logger.info("Page title verified: {}", title);
        return title;
    }

    public CartPage goToCart() {
        logger.info("Navigating to Cart");
        clickElement(cartLink);
        return new CartPage(driver);
    }

    public String getCartQuantity() {
        String qty = getText(cartQuantity);
        logger.info("Cart quantity: {}", qty);
        return qty;
    }

    public LoginPage goToLogin() {
        logger.info("Navigating to Login page");
        clickElement(loginLink);
        return new LoginPage(driver);
    }

    public RegisterPage goToRegister() {
        logger.info("Navigating to Register page");
        clickElement(registerLink);
        return new RegisterPage(driver);
    }

    public String getAccountEmail() {
        String email = getText(accountLink);
        logger.info("Logged-in account: {}", email);
        return email;
    }

    public int getProductCount() {
        int count = productItems.size();
        logger.info("Products displayed: {}", count);
        return count;
    }

    public void clickProduct(String productName) {
        logger.info("Clicking product: {}", productName);
        try {
            WebElement productLink = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable(
                    org.openqa.selenium.By.xpath("//h2[@class='product-title']/a[text()='" + productName + "']")));
            productLink.click();
            logger.info("Product '{}' clicked", productName);
        } catch (Exception e) {
            logger.warn("Product '{}' not found on page: {}", productName, e.getMessage());
        }
    }

    public boolean isUserLoggedIn() {
        boolean loggedIn = isElementDisplayed(accountLink);
        logger.info("User logged in: {}", loggedIn);
        return loggedIn;
    }

    public String getWelcomeMessage() {
        String message = getText(welcomeMessage);
        logger.info("Welcome message: {}", message);
        return message;
    }
}
