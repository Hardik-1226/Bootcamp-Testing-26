package com.demowebshop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(RegisterPage.class);

    @FindBy(id = "gender-male")
    private WebElement genderMaleRadio;

    @FindBy(id = "gender-female")
    private WebElement genderFemaleRadio;

    @FindBy(id = "FirstName")
    private WebElement firstNameField;

    @FindBy(id = "LastName")
    private WebElement lastNameField;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "register-button")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class='result']")
    private WebElement registrationResult;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='validation-summary-errors']//li")
    private WebElement validationError;

    @FindBy(xpath = "//span[@class='field-validation-error']")
    private WebElement fieldValidationError;

    public RegisterPage(WebDriver driver) {
        super(driver);
        logger.info("RegisterPage initialized");
    }

    public void selectGenderMale() {
        logger.info("Selecting gender: Male");
        clickElement(genderMaleRadio);
    }

    public void selectGenderFemale() {
        logger.info("Selecting gender: Female");
        clickElement(genderFemaleRadio);
    }

    public void enterFirstName(String firstName) {
        logger.info("Entering first name: {}", firstName);
        enterText(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        logger.info("Entering last name: {}", lastName);
        enterText(lastNameField, lastName);
    }

    public void enterEmail(String email) {
        logger.info("Entering email: {}", email);
        enterText(emailField, email);
    }

    public void enterPassword(String password) {
        logger.info("Entering password");
        enterText(passwordField, password);
    }

    public void enterConfirmPassword(String password) {
        logger.info("Entering confirm password");
        enterText(confirmPasswordField, password);
    }

    public void clickRegister() {
        logger.info("Clicking Register button");
        clickElement(registerButton);
    }

    public HomePage register(String gender, String firstName, String lastName,
                             String email, String password) {
        logger.info("Performing registration for: {} {}", firstName, lastName);

        if (gender.equalsIgnoreCase("Male")) {
            selectGenderMale();
        } else {
            selectGenderFemale();
        }

        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(password);
        clickRegister();

        logger.info("Registration completed for: {}", email);
        return new HomePage(driver);
    }

    public String getRegistrationResult() {
        waitForVisibility(registrationResult);
        String result = registrationResult.getText();
        logger.info("Registration result: {}", result);
        return result;
    }

    public HomePage clickContinue() {
        logger.info("Clicking Continue button");
        clickElement(continueButton);
        return new HomePage(driver);
    }

    public String getValidationError() {
        waitForVisibility(validationError);
        String error = validationError.getText();
        logger.info("Validation error: {}", error);
        return error;
    }

    public boolean isFieldValidationErrorDisplayed() {
        return isElementDisplayed(fieldValidationError);
    }

    public boolean isValidationErrorDisplayed() {
        return isElementDisplayed(validationError);
    }
}