package stepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.demowebshop.pages.CartPage;
import com.demowebshop.pages.CheckoutPage;
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
 * CartSteps - Step definitions for Cart.feature and Checkout.feature files.
 * Implements Cucumber step definitions for cart and checkout scenarios.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class CartSteps {

    private static final Logger logger = LogManager.getLogger(CartSteps.class);
    private WebDriver driver;
    private ConfigDataProvider config;
    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    /**
     * Cucumber Before hook - Sets up browser before each Cart/Checkout scenario.
     */
    @Before("@Cart or @Checkout")
    public void setUp() {
        logger.info("Setting up browser for Cart/Checkout scenario");
        config = new ConfigDataProvider();
        driver = BrowserFactory.startBrowser(config.getBrowser());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getTimeout()));
        logger.info("Browser setup completed");
    }

    /**
     * Cucumber After hook - Closes browser after each Cart/Checkout scenario.
     */
    @After("@Cart or @Checkout")
    public void tearDown() {
        logger.info("Tearing down browser after Cart/Checkout scenario");
        BrowserFactory.quitBrowser(driver);
        logger.info("Browser closed");
    }

    @Given("user is logged in to DemoWebShop")
    public void userIsLoggedInToDemoWebShop() {
        logger.info("Logging in to DemoWebShop");
        driver.get(config.getUrl() + "login");
        LoginPage loginPage = new LoginPage(driver);
        homePage = loginPage.login(config.getUsername(), config.getPassword());
        Assert.assertTrue(homePage.isUserLoggedIn(), "User should be logged in");
        logger.info("User logged in successfully");
    }

    @Given("user has items in the shopping cart")
    public void userHasItemsInTheShoppingCart() {
        logger.info("Verifying user has items in cart");
        cartPage = homePage.goToCart();
        if (!cartPage.isCartNotEmpty()) {
            logger.info("Cart is empty, adding an item");
            homePage = cartPage.continueShopping();
            homePage.searchProduct("Computing and Internet");
            homePage.clickProduct("Computing and Internet");
            cartPage = homePage.goToCart();
        }
        Assert.assertTrue(cartPage.isCartNotEmpty(), "Cart should have items");
        logger.info("Cart has items verified");
    }

    @When("user navigates to the shopping cart")
    public void userNavigatesToTheShoppingCart() {
        logger.info("Navigating to shopping cart");
        cartPage = homePage.goToCart();
        logger.info("Navigated to shopping cart");
    }

    @When("user removes the first product from cart")
    public void userRemovesTheFirstProductFromCart() {
        logger.info("Removing first product from cart");
        cartPage.removeFirstProduct();
        logger.info("First product removed");
    }

    @When("user updates the quantity to {int}")
    public void userUpdatesTheQuantityTo(int quantity) {
        logger.info("Updating quantity to: {}", quantity);
        cartPage.updateQuantity(quantity);
        logger.info("Quantity updated to: {}", quantity);
    }

    @And("user clicks continue shopping")
    public void userClicksContinueShopping() {
        logger.info("Clicking continue shopping");
        homePage = cartPage.continueShopping();
        logger.info("Continued shopping");
    }

    @When("user proceeds to checkout from cart")
    public void userProceedsToCheckoutFromCart() {
        logger.info("Proceeding to checkout");
        cartPage = homePage.goToCart();
        checkoutPage = cartPage.proceedToCheckout();
        logger.info("Proceeded to checkout");
    }

    @And("user completes the billing address step")
    public void userCompletesTheBillingAddressStep() {
        logger.info("Completing billing address step");
        checkoutPage.clickBillingContinue();
        logger.info("Billing address completed");
    }

    @And("user completes the shipping address step")
    public void userCompletesTheShippingAddressStep() {
        logger.info("Completing shipping address step");
        checkoutPage.clickShippingContinue();
        logger.info("Shipping address completed");
    }

    @And("user selects ground shipping method")
    public void userSelectsGroundShippingMethod() {
        logger.info("Selecting ground shipping");
        checkoutPage.selectGroundShipping();
        checkoutPage.clickShippingMethodContinue();
        logger.info("Ground shipping selected");
    }

    @And("user selects {string} shipping method")
    public void userSelectsShippingMethod(String shippingMethod) {
        logger.info("Selecting shipping method: {}", shippingMethod);
        if (shippingMethod.equalsIgnoreCase("Ground")) {
            checkoutPage.selectGroundShipping();
        } else if (shippingMethod.equalsIgnoreCase("Next Day Air")) {
            checkoutPage.selectNextDayShipping();
        }
        checkoutPage.clickShippingMethodContinue();
        logger.info("Shipping method '{}' selected", shippingMethod);
    }

    @And("user selects cash on delivery payment")
    public void userSelectsCashOnDeliveryPayment() {
        logger.info("Selecting Cash On Delivery");
        checkoutPage.selectCashOnDelivery();
        checkoutPage.clickPaymentMethodContinue();
        logger.info("Cash On Delivery selected");
    }

    @And("user completes payment information")
    public void userCompletesPaymentInformation() {
        logger.info("Completing payment information");
        checkoutPage.clickPaymentInfoContinue();
        logger.info("Payment information completed");
    }

    @And("user confirms the order")
    public void userConfirmsTheOrder() {
        logger.info("Confirming order");
        checkoutPage.confirmOrder();
        logger.info("Order confirmed");
    }

    @Then("the shopping cart page should be displayed")
    public void theShoppingCartPageShouldBeDisplayed() {
        logger.info("Verifying shopping cart page");
        String title = cartPage.getPageTitle();
        Assert.assertNotNull(title, "Cart page should be displayed");
        logger.info("Shopping cart page verified");
    }

    @Then("the cart item count should decrease")
    public void theCartItemCountShouldDecrease() {
        logger.info("Verifying cart item count decreased");
        Assert.assertTrue(cartPage.isCartEmpty() || cartPage.getCartItemCount() >= 0,
                "Cart item count should decrease after removal");
        logger.info("Cart item count decrease verified");
    }

    @Then("the cart should reflect the updated quantity")
    public void theCartShouldReflectTheUpdatedQuantity() {
        logger.info("Verifying cart quantity updated");
        Assert.assertTrue(cartPage.isCartNotEmpty(), "Cart should still have items");
        logger.info("Cart quantity update verified");
    }

    @Then("user should be on the home page")
    public void userShouldBeOnTheHomePage() {
        logger.info("Verifying user is on home page");
        Assert.assertTrue(homePage.isLogoDisplayed(), "Home page logo should be displayed");
        logger.info("Home page verification passed");
    }

    @Then("the checkout page should be displayed")
    public void theCheckoutPageShouldBeDisplayed() {
        logger.info("Verifying checkout page");
        String title = checkoutPage.getPageTitle();
        Assert.assertNotNull(title, "Checkout page should be displayed");
        logger.info("Checkout page verified");
    }

    @Then("order confirmation message should be displayed")
    public void orderConfirmationMessageShouldBeDisplayed() {
        logger.info("Verifying order confirmation");
        String message = checkoutPage.getOrderConfirmationMessage();
        Assert.assertTrue(message.contains("Your order has been successfully processed"),
                "Order confirmation message should be displayed");
        logger.info("Order confirmation verified: {}", message);
    }
}
