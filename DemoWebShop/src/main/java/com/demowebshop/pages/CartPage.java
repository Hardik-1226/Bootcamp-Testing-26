package com.demowebshop.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CartPage.class);

    @FindBy(xpath = "//input[@name='removefromcart']")
    private List<WebElement> removeCheckboxes;

    @FindBy(xpath = "//input[@class='qty-input']")
    private List<WebElement> quantityInputs;

    @FindBy(name = "updatecart")
    private WebElement updateCartButton;

    @FindBy(name = "continueshopping")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//td[@class='product']/a")
    private List<WebElement> productNames;

    @FindBy(xpath = "//span[@class='product-unit-price']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//span[@class='product-subtotal']")
    private List<WebElement> productSubtotals;

    @FindBy(xpath = "//span[@class='value-summary']//span")
    private WebElement orderTotal;

    @FindBy(id = "termsofservice")
    private WebElement termsCheckbox;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='order-summary-content']")
    private WebElement cartSummary;

    @FindBy(xpath = "//div[@class='no-data']")
    private WebElement emptyCartMessage;

    public CartPage(WebDriver driver) {
        super(driver);
        logger.info("CartPage initialized");
    }

    public void removeFirstProduct() {
        logger.info("Removing first product from cart");
        if (!removeCheckboxes.isEmpty()) {
            WebElement concreteUpdateBtn = driver.findElement(org.openqa.selenium.By.name("updatecart"));
            clickElement(removeCheckboxes.get(0));
            clickElement(updateCartButton);
            try { wait.until(ExpectedConditions.stalenessOf(concreteUpdateBtn)); } catch (Exception e) {}
            logger.info("First product removed from cart");
        } else {
            logger.warn("No products found in cart to remove");
        }
    }

    public void removeProduct(int index) {
        logger.info("Removing product at index: {}", index);
        if (index >= 0 && index < removeCheckboxes.size()) {
            WebElement concreteUpdateBtn = driver.findElement(org.openqa.selenium.By.name("updatecart"));
            clickElement(removeCheckboxes.get(index));
            clickElement(updateCartButton);
            try { wait.until(ExpectedConditions.stalenessOf(concreteUpdateBtn)); } catch (Exception e) {}
            logger.info("Product at index {} removed", index);
        } else {
            logger.warn("Invalid product index: {}", index);
        }
    }

    public void updateQuantity(int quantity) {
        logger.info("Updating first product quantity to: {}", quantity);
        if (!quantityInputs.isEmpty()) {
            WebElement concreteUpdateBtn = driver.findElement(org.openqa.selenium.By.name("updatecart"));
            WebElement qtyInput = quantityInputs.get(0);
            qtyInput.clear();
            qtyInput.sendKeys(String.valueOf(quantity));
            clickElement(updateCartButton);
            try { wait.until(ExpectedConditions.stalenessOf(concreteUpdateBtn)); } catch (Exception e) {}
            logger.info("Quantity updated to: {}", quantity);
        } else {
            logger.warn("No quantity inputs found");
        }
    }

    public void updateQuantity(int index, int quantity) {
        logger.info("Updating product at index {} quantity to: {}", index, quantity);
        if (index >= 0 && index < quantityInputs.size()) {
            WebElement concreteUpdateBtn = driver.findElement(org.openqa.selenium.By.name("updatecart"));
            WebElement qtyInput = quantityInputs.get(index);
            qtyInput.clear();
            qtyInput.sendKeys(String.valueOf(quantity));
            clickElement(updateCartButton);
            try { wait.until(ExpectedConditions.stalenessOf(concreteUpdateBtn)); } catch (Exception e) {}
            logger.info("Quantity at index {} updated to: {}", index, quantity);
        } else {
            logger.warn("Invalid product index: {}", index);
        }
    }

    public boolean isCartNotEmpty() {
        boolean hasProducts = !productNames.isEmpty();
        logger.info("Cart has products: {}", hasProducts);
        return hasProducts;
    }

    public int getCartItemCount() {
        int count = productNames.size();
        logger.info("Cart item count: {}", count);
        return count;
    }

    public String getFirstProductName() {
        if (!productNames.isEmpty()) {
            String name = getText(productNames.get(0));
            logger.info("First product in cart: {}", name);
            return name;
        }
        logger.warn("No products in cart");
        return "";
    }

    public String getOrderTotal() {
        String total = getText(orderTotal);
        logger.info("Order total: {}", total);
        return total;
    }

    public CheckoutPage proceedToCheckout() {
        logger.info("Proceeding to checkout");
        scrollToElement(termsCheckbox);
        if (!termsCheckbox.isSelected()) {
            clickElement(termsCheckbox);
        }
        clickElement(checkoutButton);
        logger.info("Navigated to checkout");
        return new CheckoutPage(driver);
    }

    public HomePage continueShopping() {
        logger.info("Continuing shopping");
        clickElement(continueShoppingButton);
        return new HomePage(driver);
    }

    public boolean isCartEmpty() {
        boolean empty = isElementDisplayed(emptyCartMessage);
        logger.info("Cart is empty: {}", empty);
        return empty;
    }

    public String getProductName(int index) {
        if (index >= 0 && index < productNames.size()) {
            return getText(productNames.get(index));
        }
        logger.warn("Invalid product index: {}", index);
        return "";
    }
}
