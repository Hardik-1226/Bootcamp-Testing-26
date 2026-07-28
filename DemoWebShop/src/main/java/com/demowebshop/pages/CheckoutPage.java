package com.demowebshop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CheckoutPage.class);

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

    @FindBy(xpath = "//div[@id='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button']")
    private WebElement shippingContinueButton;

    @FindBy(id = "shippingoption_0")
    private WebElement groundShipping;

    @FindBy(id = "shippingoption_1")
    private WebElement nextDayShipping;

    @FindBy(xpath = "//div[@id='shipping-method-buttons-container']//input[@class='button-1 shipping-method-next-step-button']")
    private WebElement shippingMethodContinueButton;

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

    @FindBy(xpath = "//div[@id='payment-info-buttons-container']//input[@class='button-1 payment-info-next-step-button']")
    private WebElement paymentInfoContinueButton;

    @FindBy(xpath = "//div[@id='confirm-order-buttons-container']//input[@class='button-1 confirm-order-next-step-button']")
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//div[@class='section order-completed']//div[@class='title']/strong")
    private WebElement orderConfirmationMessage;

    @FindBy(xpath = "//div[@class='section order-completed']//ul/li")
    private WebElement orderNumber;

    @FindBy(xpath = "//input[@class='button-2 order-completed-continue-button']")
    private WebElement orderContinueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        logger.info("CheckoutPage initialized");
    }

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

    public void clickBillingContinue() {
        logger.info("Clicking Billing Continue");
        waitForClickable(billingContinueButton);
        clickElement(billingContinueButton);
    }

    public void clickShippingContinue() {
        logger.info("Clicking Shipping Continue");
        waitForClickable(shippingContinueButton);
        clickElement(shippingContinueButton);
    }

    public void selectGroundShipping() {
        logger.info("Selecting Ground shipping");
        clickElement(groundShipping);
    }

    public void selectNextDayShipping() {
        logger.info("Selecting Next Day Air shipping");
        clickElement(nextDayShipping);
    }

    public void clickShippingMethodContinue() {
        logger.info("Clicking Shipping Method Continue");
        waitForClickable(shippingMethodContinueButton);
        clickElement(shippingMethodContinueButton);
    }

    public void selectCashOnDelivery() {
        logger.info("Selecting Cash On Delivery payment");
        clickElement(cashOnDelivery);
    }

    public void selectCheckMoneyOrder() {
        logger.info("Selecting Check/Money Order payment");
        clickElement(checkMoneyOrder);
    }

    public void selectCreditCard() {
        logger.info("Selecting Credit Card payment");
        clickElement(creditCard);
    }

    public void selectPurchaseOrder() {
        logger.info("Selecting Purchase Order payment");
        clickElement(purchaseOrder);
    }

    public void clickPaymentMethodContinue() {
        logger.info("Clicking Payment Method Continue");
        waitForClickable(paymentMethodContinueButton);
        clickElement(paymentMethodContinueButton);
    }

    public void clickPaymentInfoContinue() {
        logger.info("Clicking Payment Info Continue");
        waitForClickable(paymentInfoContinueButton);
        clickElement(paymentInfoContinueButton);
    }

    public void confirmOrder() {
        logger.info("Confirming order");
        waitForClickable(confirmOrderButton);
        clickElement(confirmOrderButton);
        logger.info("Order confirmed");
    }

    public String getOrderConfirmationMessage() {
        waitForVisibility(orderConfirmationMessage);
        String message = orderConfirmationMessage.getText();
        logger.info("Order confirmation: {}", message);
        return message;
    }

    public String getOrderNumber() {
        waitForVisibility(orderNumber);
        String number = orderNumber.getText();
        logger.info("Order number: {}", number);
        return number;
    }

    public HomePage clickOrderContinue() {
        logger.info("Clicking order continue");
        clickElement(orderContinueButton);
        return new HomePage(driver);
    }

    public String completeCheckout() {
        logger.info("Starting complete checkout flow");

        if (isElementDisplayed(billingCountryDropdown)) {
            logger.info("Billing address form is visible. Filling it out dynamically.");
            if (billingFirstName.getAttribute("value") == null || billingFirstName.getAttribute("value").isEmpty()) {
                enterText(billingFirstName, "Hardik");
            }
            if (billingLastName.getAttribute("value") == null || billingLastName.getAttribute("value").isEmpty()) {
                enterText(billingLastName, "Varshney");
            }
            if (billingEmail.getAttribute("value") == null || billingEmail.getAttribute("value").isEmpty()) {
                enterText(billingEmail, "hardik.demo.testing@gmail.com");
            }
            selectByVisibleText(billingCountryDropdown, "United States");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            selectByVisibleText(billingStateDropdown, "New York");
            enterText(billingCity, "New York");
            enterText(billingAddress1, "123 Test St");
            enterText(billingZipCode, "10001");
            enterText(billingPhone, "1234567890");
        }

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
