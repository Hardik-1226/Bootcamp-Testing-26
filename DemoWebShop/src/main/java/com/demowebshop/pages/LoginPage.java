package com.demowebshop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LoginPage - Page Object for the DemoWebShop Login page.
 * Uses PageFactory pattern with @FindBy annotations for element identification.
 * Matches the training slide implementation exactly.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

    // ==================== Web Elements ====================

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    private WebElement loginButton;

    @FindBy(linkText = "Register")
    private WebElement registerLink;

    @FindBy(linkText = "Forgot password?")
    private WebElement forgotPasswordLink;

    @FindBy(className = "validation-summary-errors")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//a[@class='account']")
    private WebElement accountLink;

    // ==================== Constructor ====================

    /**
     * Constructor - Initializes LoginPage with PageFactory.
     *
     * @param driver WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        logger.info("LoginPage initialized");
    }

    // ==================== Page Methods ====================

    /**
     * Enters the email address in the email field.
     *
     * @param email email address to enter
     */
    public void enterEmail(String email) {
        logger.info("Entering email: {}", email);
        enterText(emailField, email);
    }

    /**
     * Enters the password in the password field.
     *
     * @param password password to enter
     */
    public void enterPassword(String password) {
        logger.info("Entering password");
        enterText(passwordField, password);
    }

    /**
     * Clicks the Login button.
     */
    public void clickLogin() {
        logger.info("Clicking Login button");
        clickElement(loginButton);
    }

    /**
     * Combined method - Performs complete login flow.
     * Enters email, password and clicks login button.
     *
     * @param email    email address
     * @param password password
     * @return HomePage instance after successful login
     */
    public HomePage login(String email, String password) {
        logger.info("Performing login with email: {}", email);
        enterEmail(email);
        enterPassword(password);
        clickLogin();
        logger.info("Login action completed");
        return new HomePage(driver);
    }

    /**
     * Clicks the Register link to navigate to registration page.
     *
     * @return RegisterPage instance
     */
    public RegisterPage clickRegister() {
        logger.info("Clicking Register link");
        clickElement(registerLink);
        return new RegisterPage(driver);
    }

    /**
     * Clicks the Forgot Password link.
     */
    public void clickForgotPassword() {
        logger.info("Clicking Forgot Password link");
        clickElement(forgotPasswordLink);
    }

    /**
     * Gets the login error message text.
     *
     * @return error message text
     */
    public String getLoginErrorMessage() {
        logger.info("Getting login error message");
        waitForVisibility(loginErrorMessage);
        String errorText = loginErrorMessage.getText();
        logger.info("Login error message: {}", errorText);
        return errorText;
    }

    /**
     * Checks if the login error message is displayed.
     *
     * @return true if error message is displayed
     */
    public boolean isLoginErrorDisplayed() {
        logger.debug("Checking if login error is displayed");
        return isElementDisplayed(loginErrorMessage);
    }

    /**
     * Gets the logged-in account email from the header.
     *
     * @return account email text
     */
    public String getLoggedInAccountEmail() {
        logger.info("Getting logged-in account email");
        waitForVisibility(accountLink);
        return accountLink.getText();
    }
}
