package com.demowebshop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * RegisterPage - Page Object for the DemoWebShop Registration page.
 * Contains all registration form elements and actions.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class RegisterPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(RegisterPage.class);

    // ==================== Web Elements ====================

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

    // ==================== Constructor ====================

    /**
     * Constructor - Initializes RegisterPage with PageFactory.
     *
     * @param driver WebDriver instance
     */
    public RegisterPage(WebDriver driver) {
        super(driver);
        logger.info("RegisterPage initialized");
    }

    // ==================== Page Methods ====================

    /**
     * Selects the Male gender radio button.
     */
    public void selectGenderMale() {
        logger.info("Selecting gender: Male");
        clickElement(genderMaleRadio);
    }

    /**
     * Selects the Female gender radio button.
     */
    public void selectGenderFemale() {
        logger.info("Selecting gender: Female");
        clickElement(genderFemaleRadio);
    }

    /**
     * Enters the first name.
     *
     * @param firstName first name to enter
     */
    public void enterFirstName(String firstName) {
        logger.info("Entering first name: {}", firstName);
        enterText(firstNameField, firstName);
    }

    /**
     * Enters the last name.
     *
     * @param lastName last name to enter
     */
    public void enterLastName(String lastName) {
        logger.info("Entering last name: {}", lastName);
        enterText(lastNameField, lastName);
    }

    /**
     * Enters the email address.
     *
     * @param email email to enter
     */
    public void enterEmail(String email) {
        logger.info("Entering email: {}", email);
        enterText(emailField, email);
    }

    /**
     * Enters the password.
     *
     * @param password password to enter
     */
    public void enterPassword(String password) {
        logger.info("Entering password");
        enterText(passwordField, password);
    }

    /**
     * Enters the confirm password.
     *
     * @param password confirm password to enter
     */
    public void enterConfirmPassword(String password) {
        logger.info("Entering confirm password");
        enterText(confirmPasswordField, password);
    }

    /**
     * Clicks the Register button.
     */
    public void clickRegister() {
        logger.info("Clicking Register button");
        clickElement(registerButton);
    }

    /**
     * Combined method - Performs complete registration flow.
     *
     * @param gender    gender selection ("Male" or "Female")
     * @param firstName first name
     * @param lastName  last name
     * @param email     email address
     * @param password  password
     * @return HomePage instance after successful registration
     */
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

    /**
     * Gets the registration result message.
     *
     * @return result message text
     */
    public String getRegistrationResult() {
        waitForVisibility(registrationResult);
        String result = registrationResult.getText();
        logger.info("Registration result: {}", result);
        return result;
    }

    /**
     * Clicks the Continue button after successful registration.
     *
     * @return HomePage instance
     */
    public HomePage clickContinue() {
        logger.info("Clicking Continue button");
        clickElement(continueButton);
        return new HomePage(driver);
    }

    /**
     * Gets the validation error message.
     *
     * @return validation error text
     */
    public String getValidationError() {
        waitForVisibility(validationError);
        String error = validationError.getText();
        logger.info("Validation error: {}", error);
        return error;
    }

    /**
     * Checks if field validation error is displayed.
     *
     * @return true if field validation error exists
     */
    public boolean isFieldValidationErrorDisplayed() {
        return isElementDisplayed(fieldValidationError);
    }
}
