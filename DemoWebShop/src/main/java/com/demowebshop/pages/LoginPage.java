package com.demowebshop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(LoginPage.class);

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

    public LoginPage(WebDriver driver) {
        super(driver);
        logger.info("LoginPage initialized");
    }

    public void enterEmail(String email) {
        logger.info("Entering email: {}", email);
        enterText(emailField, email);
    }

    public void enterPassword(String password) {
        logger.info("Entering password");
        enterText(passwordField, password);
    }

    public void clickLogin() {
        logger.info("Clicking Login button");
        clickElement(loginButton);
    }

    public HomePage login(String email, String password) {

        logger.info("Logging in with {}", email);

        enterEmail(email);
        enterPassword(password);
        clickLogin();

        if (isLoginErrorDisplayed()) {
            String errorMsg = getLoginErrorMessage();
            logger.error(errorMsg);
            throw new RuntimeException("Login Failed : " + errorMsg);
        }

        waitForVisibility(accountLink);

        logger.info("Login Successful");

        return new HomePage(driver);
    }

    public RegisterPage clickRegister() {
        logger.info("Clicking Register link");
        clickElement(registerLink);
        return new RegisterPage(driver);
    }

    public void clickForgotPassword() {
        logger.info("Clicking Forgot Password link");
        clickElement(forgotPasswordLink);
    }

    public String getLoginErrorMessage() {
        logger.info("Getting login error message");
        waitForVisibility(loginErrorMessage);
        String errorText = loginErrorMessage.getText();
        logger.info("Login error message: {}", errorText);
        return errorText;
    }

    public boolean isLoginErrorDisplayed() {
        logger.debug("Checking if login error is displayed");
        return isElementDisplayed(loginErrorMessage);
    }

    public String getLoggedInAccountEmail() {
        logger.info("Getting logged-in account email");
        waitForVisibility(accountLink);
        return accountLink.getText();
    }
}
