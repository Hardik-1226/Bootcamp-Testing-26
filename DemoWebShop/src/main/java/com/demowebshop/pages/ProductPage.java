package com.demowebshop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
	protected void waitForInvisibility(WebElement element) {
	    wait.until(ExpectedConditions.invisibilityOf(element));
	}

    private static final Logger logger = LogManager.getLogger(ProductPage.class);

    @FindBy(css = "input.button-1.add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(css = "p.content")
    private WebElement successMessage;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCart() {

        logger.info("Clicking Add To Cart");

        clickElement(addToCartButton);

        waitForVisibility(successMessage);

        logger.info(successMessage.getText());

        waitForInvisibility(successMessage);
    }

    public String getSuccessMessage() {
        waitForVisibility(successMessage);
        return successMessage.getText();
    }
}