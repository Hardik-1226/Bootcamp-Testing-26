package com.demowebshop.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * CartPage - Page Object for the DemoWebShop Shopping Cart page.
 * Provides methods for cart operations including add, remove, update, and verify.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class CartPage extends BasePage {

    private static final Logger logger = LogManager.getLogger(CartPage.class);

    // ==================== Web Elements ====================

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

    @FindBy(xpath = "//input[@class='button-2 add-to-cart-button']")
    private WebElement addToCartButton;

    // ==================== Constructor ====================

    /**
     * Constructor - Initializes CartPage with PageFactory.
     *
     * @param driver WebDriver instance
     */
    public CartPage(WebDriver driver) {
        super(driver);
        logger.info("CartPage initialized");
    }

    // ==================== Page Methods ====================

    /**
     * Removes the first product from the cart by checking the remove checkbox.
     */
    public void removeFirstProduct() {
        logger.info("Removing first product from cart");
        if (!removeCheckboxes.isEmpty()) {
            clickElement(removeCheckboxes.get(0));
            clickElement(updateCartButton);
            logger.info("First product removed from cart");
        } else {
            logger.warn("No products found in cart to remove");
        }
    }

    /**
     * Removes a product at the specified index from the cart.
     *
     * @param index product index (0-based)
     */
    public void removeProduct(int index) {
        logger.info("Removing product at index: {}", index);
        if (index >= 0 && index < removeCheckboxes.size()) {
            clickElement(removeCheckboxes.get(index));
            clickElement(updateCartButton);
            logger.info("Product at index {} removed", index);
        } else {
            logger.warn("Invalid product index: {}", index);
        }
    }

    /**
     * Updates the quantity of the first product in the cart.
     *
     * @param quantity new quantity value
     */
    public void updateQuantity(int quantity) {
        logger.info("Updating first product quantity to: {}", quantity);
        if (!quantityInputs.isEmpty()) {
            WebElement qtyInput = quantityInputs.get(0);
            qtyInput.clear();
            qtyInput.sendKeys(String.valueOf(quantity));
            clickElement(updateCartButton);
            logger.info("Quantity updated to: {}", quantity);
        } else {
            logger.warn("No quantity inputs found");
        }
    }

    /**
     * Updates the quantity of a product at the specified index.
     *
     * @param index    product index (0-based)
     * @param quantity new quantity value
     */
    public void updateQuantity(int index, int quantity) {
        logger.info("Updating product at index {} quantity to: {}", index, quantity);
        if (index >= 0 && index < quantityInputs.size()) {
            WebElement qtyInput = quantityInputs.get(index);
            qtyInput.clear();
            qtyInput.sendKeys(String.valueOf(quantity));
            clickElement(updateCartButton);
            logger.info("Quantity at index {} updated to: {}", index, quantity);
        } else {
            logger.warn("Invalid product index: {}", index);
        }
    }

    /**
     * Verifies if the cart contains products.
     *
     * @return true if cart has products
     */
    public boolean isCartNotEmpty() {
        boolean hasProducts = !productNames.isEmpty();
        logger.info("Cart has products: {}", hasProducts);
        return hasProducts;
    }

    /**
     * Gets the number of items in the cart.
     *
     * @return number of cart items
     */
    public int getCartItemCount() {
        int count = productNames.size();
        logger.info("Cart item count: {}", count);
        return count;
    }

    /**
     * Gets the name of the first product in the cart.
     *
     * @return first product name
     */
    public String getFirstProductName() {
        if (!productNames.isEmpty()) {
            String name = getText(productNames.get(0));
            logger.info("First product in cart: {}", name);
            return name;
        }
        logger.warn("No products in cart");
        return "";
    }

    /**
     * Gets the order total amount.
     *
     * @return order total as string
     */
    public String getOrderTotal() {
        String total = getText(orderTotal);
        logger.info("Order total: {}", total);
        return total;
    }

    /**
     * Accepts the terms of service and proceeds to checkout.
     *
     * @return CheckoutPage instance
     */
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

    /**
     * Clicks the Continue Shopping button.
     *
     * @return HomePage instance
     */
    public HomePage continueShopping() {
        logger.info("Continuing shopping");
        clickElement(continueShoppingButton);
        return new HomePage(driver);
    }

    /**
     * Checks if the empty cart message is displayed.
     *
     * @return true if cart is empty
     */
    public boolean isCartEmpty() {
        boolean empty = isElementDisplayed(emptyCartMessage);
        logger.info("Cart is empty: {}", empty);
        return empty;
    }

    /**
     * Gets the product name at a specific index.
     *
     * @param index product index (0-based)
     * @return product name
     */
    public String getProductName(int index) {
        if (index >= 0 && index < productNames.size()) {
            return getText(productNames.get(index));
        }
        logger.warn("Invalid product index: {}", index);
        return "";
    }
}
