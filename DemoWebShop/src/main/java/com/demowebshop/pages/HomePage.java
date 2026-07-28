package com.demowebshop.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * HomePage - Page Object for the DemoWebShop Home page.
 * Provides methods for search, logout, logo verification, and navigation.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class HomePage extends BasePage {

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    // ==================== Web Elements ====================

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

    // ==================== Constructor ====================

    /**
     * Constructor - Initializes HomePage with PageFactory.
     *
     * @param driver WebDriver instance
     */
    public HomePage(WebDriver driver) {
        super(driver);
        logger.info("HomePage initialized");
    }

    // ==================== Page Methods ====================

    /**
     * Searches for a product using the search box.
     *
     * @param productName name of the product to search
     */
    public void searchProduct(String productName) {
        logger.info("Searching for product: {}", productName);
        enterText(searchBox, productName);
        clickElement(searchButton);
        logger.info("Search submitted for: {}", productName);
    }

    /**
     * Clicks the Logout link.
     */
    public void logout() {
        logger.info("Clicking Logout");
        clickElement(logoutLink);
        logger.info("Logout completed");
    }

    /**
     * Verifies if the site logo is displayed on the page.
     *
     * @return true if logo is displayed
     */
    public boolean isLogoDisplayed() {
        logger.info("Verifying site logo");
        boolean displayed = isElementDisplayed(siteLogo);
        logger.info("Logo displayed: {}", displayed);
        return displayed;
    }

    /**
     * Gets the current page title for verification.
     *
     * @return page title text
     */
    public String verifyTitle() {
        String title = getPageTitle();
        logger.info("Page title verified: {}", title);
        return title;
    }

    /**
     * Navigates to the Shopping Cart page.
     *
     * @return CartPage instance
     */
    public CartPage goToCart() {
        logger.info("Navigating to Cart");
        clickElement(cartLink);
        return new CartPage(driver);
    }

    /**
     * Gets the cart item count displayed in the header.
     *
     * @return cart quantity text
     */
    public String getCartQuantity() {
        String qty = getText(cartQuantity);
        logger.info("Cart quantity: {}", qty);
        return qty;
    }

    /**
     * Navigates to the Login page.
     *
     * @return LoginPage instance
     */
    public LoginPage goToLogin() {
        logger.info("Navigating to Login page");
        clickElement(loginLink);
        return new LoginPage(driver);
    }

    /**
     * Navigates to the Registration page.
     *
     * @return RegisterPage instance
     */
    public RegisterPage goToRegister() {
        logger.info("Navigating to Register page");
        clickElement(registerLink);
        return new RegisterPage(driver);
    }

    /**
     * Gets the logged-in user's account email.
     *
     * @return account email text
     */
    public String getAccountEmail() {
        String email = getText(accountLink);
        logger.info("Logged-in account: {}", email);
        return email;
    }

    /**
     * Gets the total number of products displayed on the page.
     *
     * @return product count
     */
    public int getProductCount() {
        int count = productItems.size();
        logger.info("Products displayed: {}", count);
        return count;
    }

    /**
     * Clicks on a product by its title text.
     *
     * @param productName exact product title to click
     */
    public void clickProduct(String productName) {
        logger.info("Clicking product: {}", productName);
        for (WebElement title : productTitles) {
            if (title.getText().equalsIgnoreCase(productName)) {
                clickElement(title);
                logger.info("Product '{}' clicked", productName);
                return;
            }
        }
        logger.warn("Product '{}' not found on page", productName);
    }

    /**
     * Checks if the user is logged in by verifying the account link.
     *
     * @return true if user is logged in
     */
    public boolean isUserLoggedIn() {
        boolean loggedIn = isElementDisplayed(accountLink);
        logger.info("User logged in: {}", loggedIn);
        return loggedIn;
    }

    /**
     * Gets the welcome message text.
     *
     * @return welcome message
     */
    public String getWelcomeMessage() {
        String message = getText(welcomeMessage);
        logger.info("Welcome message: {}", message);
        return message;
    }
}
