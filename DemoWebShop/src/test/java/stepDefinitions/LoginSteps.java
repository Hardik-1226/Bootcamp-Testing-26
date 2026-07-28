package stepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.utils.BrowserFactory;
import com.demowebshop.utils.ConfigDataProvider;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * LoginSteps - Step definitions for Login.feature file.
 * Implements Cucumber step definitions for login scenarios.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class LoginSteps {

    private static final Logger logger = LogManager.getLogger(LoginSteps.class);
    private WebDriver driver;
    private ConfigDataProvider config;
    private LoginPage loginPage;
    private HomePage homePage;

    /**
     * Cucumber Before hook - Sets up browser before each scenario.
     */
    @Before("@Login")
    public void setUp() {
        logger.info("Setting up browser for Login scenario");
        config = new ConfigDataProvider();
        driver = BrowserFactory.startBrowser(config.getBrowser());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getTimeout()));
        logger.info("Browser setup completed");
    }

    /**
     * Cucumber After hook - Closes browser after each scenario.
     */
    @After("@Login")
    public void tearDown() {
        logger.info("Tearing down browser after Login scenario");
        BrowserFactory.quitBrowser(driver);
        logger.info("Browser closed");
    }

    @Given("user is on the DemoWebShop login page")
    public void userIsOnTheLoginPage() {
        logger.info("Navigating to DemoWebShop login page");
        driver.get(config.getUrl() + "login");
        loginPage = new LoginPage(driver);
        logger.info("User is on the login page");
    }

    @When("user enters email {string}")
    public void userEntersEmail(String email) {
        logger.info("Entering email: {}", email);
        loginPage.enterEmail(email);
    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {
        logger.info("Entering password");
        loginPage.enterPassword(password);
    }

    @And("user clicks the login button")
    public void userClicksTheLoginButton() {
        logger.info("Clicking login button");
        loginPage.clickLogin();
    }

    @Then("user should be logged in successfully")
    public void userShouldBeLoggedInSuccessfully() {
        logger.info("Verifying successful login");
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isUserLoggedIn(), "User should be logged in");
        logger.info("Login verification passed");
    }

    @Then("login error message should be displayed")
    public void loginErrorMessageShouldBeDisplayed() {
        logger.info("Verifying login error message");
        Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                "Login error message should be displayed");
        logger.info("Login error message verification passed");
    }

    @Then("the login result should be {string}")
    public void theLoginResultShouldBe(String expectedResult) {
        logger.info("Verifying login result: {}", expectedResult);
        if (expectedResult.equalsIgnoreCase("success")) {
            homePage = new HomePage(driver);
            Assert.assertTrue(homePage.isUserLoggedIn(), "User should be logged in for success case");
            homePage.logout();
            logger.info("Login result verified: success");
        } else {
            Assert.assertTrue(loginPage.isLoginErrorDisplayed(),
                    "Error should be displayed for failure case");
            logger.info("Login result verified: failure");
        }
    }
}
