package com.demowebshop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * CheckoutPage - Page Object for the DemoWebShop Checkout page.
 * Handles the complete checkout flow including billing, shipping, payment, and order confirmation.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class CheckoutPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CheckoutPage.class);

    // ==================== Billing Address Elements ====================

    @FindBy(id = "BillingNewAddress_FirstName")
    private WebElement billingFirstName;

    @FindBy(id = "BillingNewAddress_LastName")
    private WebElement billingLastName;

    @FindBy(id = "BillingNewAddress_Email")
    private WebElement billingEmail;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement billingCountryDropdown;

    @FindBy(id = "BillingNewAddress_StateProvinceId")
    private WebElement billingStateDropdown;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement billingCity;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement billingAddress1;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement billingZipCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement billingPhone;

    @FindBy(xpath = "//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']")
    private WebElement billingContinueButton;

    // ==================== Shipping Address Elements ====================

    @FindBy(xpath = "//div[@id='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button']")
    private WebElement shippingContinueButton;

    // ==================== Shipping Method Elements ====================

    @FindBy(id = "shippingoption_0")
    private WebElement groundShipping;

    @FindBy(id = "shippingoption_1")
    private WebElement nextDayShipping;

    @FindBy(xpath = "//div[@id='shipping-method-buttons-container']//input[@class='button-1 shipping-method-next-step-button']")
    private WebElement shippingMethodContinueButton;

    // ==================== Payment Method Elements ====================

    @FindBy(id = "paymentmethod_0")
    private WebElement cashOnDelivery;

    @FindBy(id = "paymentmethod_1")
    private WebElement checkMoneyOrder;

    @FindBy(id = "paymentmethod_2")
    private WebElement creditCard;

    @FindBy(id = "paymentmethod_3")
    private WebElement purchaseOrder;

    @FindBy(xpath = "//div[@id='payment-method-buttons-container']//input[@class='button-1 payment-method-next-step-button']")
    private WebElement paymentMethodContinueButton;

    // ==================== Payment Information Elements ====================

    @FindBy(xpath = "//div[@id='payment-info-buttons-container']//input[@class='button-1 payment-info-next-step-button']")
    private WebElement paymentInfoContinueButton;

    // ==================== Order Confirmation Elements ====================

    @FindBy(xpath = "//div[@id='confirm-order-buttons-container']//input[@class='button-1 confirm-order-next-step-button']")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//div[@class='section order-completed']//div[@class='title']/strong")
    private WebElement orderConfirmationMessage;

    @FindBy(xpath = "//div[@class='section order-completed']//ul/li")
    private WebElement orderNumber;

    @FindBy(xpath = "//input[@class='button-2 order-completed-continue-button']")
    private WebElement orderContinueButton;

    // ==================== Constructor ====================

    /**
     * Constructor - Initializes CheckoutPage with PageFactory.
     *
     * @param driver WebDriver instance
     */
    public CheckoutPage(WebDriver driver) {
        super(driver);
        logger.info("CheckoutPage initialized");
    }

    // ==================== Billing Address Methods ====================

    /**
     * Fills in the billing address form.
     *
     * @param firstName first name
     * @param lastName  last name
     * @param email     email address
     * @param country   country name
     * @param city      city name
     * @param address   street address
     * @param zip       postal/zip code
     * @param phone     phone number
     */
    public void fillBillingAddress(String firstName, String lastName, String email,
                                   String country, String city, String address,
                                   String zip, String phone) {
        logger.info("Filling billing address for: {} {}", firstName, lastName);
        enterText(billingFirstName, firstName);
        enterText(billingLastName, lastName);
        enterText(billingEmail, email);
        selectByVisibleText(billingCountryDropdown, country);
        enterText(billingCity, city);
        enterText(billingAddress1, address);
        enterText(billingZipCode, zip);
        enterText(billingPhone, phone);
        logger.info("Billing address filled successfully");
    }

    /**
     * Clicks the Continue button in the billing address section.
     */
    public void clickBillingContinue() {
        logger.info("Clicking Billing Continue");
        waitForClickable(billingContinueButton);
        clickElement(billingContinueButton);
    }

    // ==================== Shipping Address Methods ====================

    /**
     * Clicks the Continue button in the shipping address section.
     */
    public void clickShippingContinue() {
        logger.info("Clicking Shipping Continue");
        waitForClickable(shippingContinueButton);
        clickElement(shippingContinueButton);
    }

    // ==================== Shipping Method Methods ====================

    /**
     * Selects Ground shipping method.
     */
    public void selectGroundShipping() {
        logger.info("Selecting Ground shipping");
        clickElement(groundShipping);
    }

    /**
     * Selects Next Day Air shipping method.
     */
    public void selectNextDayShipping() {
        logger.info("Selecting Next Day Air shipping");
        clickElement(nextDayShipping);
    }

    /**
     * Clicks Continue in the shipping method section.
     */
    public void clickShippingMethodContinue() {
        logger.info("Clicking Shipping Method Continue");
        waitForClickable(shippingMethodContinueButton);
        clickElement(shippingMethodContinueButton);
    }

    // ==================== Payment Method Methods ====================

    /**
     * Selects Cash On Delivery payment method.
     */
    public void selectCashOnDelivery() {
        logger.info("Selecting Cash On Delivery payment");
        clickElement(cashOnDelivery);
    }

    /**
     * Selects Check/Money Order payment method.
     */
    public void selectCheckMoneyOrder() {
        logger.info("Selecting Check/Money Order payment");
        clickElement(checkMoneyOrder);
    }

    /**
     * Selects Credit Card payment method.
     */
    public void selectCreditCard() {
        logger.info("Selecting Credit Card payment");
        clickElement(creditCard);
    }

    /**
     * Selects Purchase Order payment method.
     */
    public void selectPurchaseOrder() {
        logger.info("Selecting Purchase Order payment");
        clickElement(purchaseOrder);
    }

    /**
     * Clicks Continue in the payment method section.
     */
    public void clickPaymentMethodContinue() {
        logger.info("Clicking Payment Method Continue");
        waitForClickable(paymentMethodContinueButton);
        clickElement(paymentMethodContinueButton);
    }

    // ==================== Payment Information Methods ====================

    /**
     * Clicks Continue in the payment information section.
     */
    public void clickPaymentInfoContinue() {
        logger.info("Clicking Payment Info Continue");
        waitForClickable(paymentInfoContinueButton);
        clickElement(paymentInfoContinueButton);
    }

    // ==================== Order Confirmation Methods ====================

    /**
     * Clicks the Confirm Order button to place the order.
     */
    public void confirmOrder() {
        logger.info("Confirming order");
        waitForClickable(confirmOrderButton);
        clickElement(confirmOrderButton);
        logger.info("Order confirmed");
    }

    /**
     * Gets the order confirmation message.
     *
     * @return confirmation message text
     */
    public String getOrderConfirmationMessage() {
        waitForVisibility(orderConfirmationMessage);
        String message = orderConfirmationMessage.getText();
        logger.info("Order confirmation: {}", message);
        return message;
    }

    /**
     * Gets the order number text.
     *
     * @return order number text
     */
    public String getOrderNumber() {
        waitForVisibility(orderNumber);
        String number = orderNumber.getText();
        logger.info("Order number: {}", number);
        return number;
    }

    /**
     * Clicks Continue after order completion.
     *
     * @return HomePage instance
     */
    public HomePage clickOrderContinue() {
        logger.info("Clicking order continue");
        clickElement(orderContinueButton);
        return new HomePage(driver);
    }

    // ==================== Complete Checkout Flow ====================

    /**
     * Performs the complete checkout flow with Cash On Delivery and Ground Shipping.
     * Assumes billing address is already saved or auto-populated.
     *
     * @return order confirmation message
     */
    public String completeCheckout() {
        logger.info("Starting complete checkout flow");

        clickBillingContinue();
        logger.debug("Billing step completed");

        clickShippingContinue();
        logger.debug("Shipping address step completed");

        selectGroundShipping();
        clickShippingMethodContinue();
        logger.debug("Shipping method step completed");

        selectCashOnDelivery();
        clickPaymentMethodContinue();
        logger.debug("Payment method step completed");

        clickPaymentInfoContinue();
        logger.debug("Payment info step completed");

        confirmOrder();
        logger.debug("Order confirmed");

        String confirmationMessage = getOrderConfirmationMessage();
        logger.info("Checkout completed successfully. Message: {}", confirmationMessage);
        return confirmationMessage;
    }
}
