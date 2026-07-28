package com.demowebshop.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage - Abstract base class for all Page Objects.
 * Provides common functionality shared across all page classes including
 * PageFactory initialization, waits, JavaScript utilities, and dropdown handling.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public abstract class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor - Initializes the Page Object with WebDriver and PageFactory.
     *
     * @param driver WebDriver instance
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        logger.debug("PageFactory initialized for: {}", this.getClass().getSimpleName());
    }

    /**
     * Gets the current page title.
     *
     * @return page title
     */
    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Current page title: {}", title);
        return title;
    }

    /**
     * Gets the current page URL.
     *
     * @return current URL
     */
    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        logger.info("Current URL: {}", url);
        return url;
    }

    /**
     * Waits for an element to be visible on the page.
     *
     * @param element WebElement to wait for
     * @return the visible element
     */
    protected WebElement waitForVisibility(WebElement element) {
        logger.debug("Waiting for element visibility");
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for an element to be clickable.
     *
     * @param element WebElement to wait for
     * @return the clickable element
     */
    protected WebElement waitForClickable(WebElement element) {
        logger.debug("Waiting for element to be clickable");
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Clicks an element using JavaScript executor.
     *
     * @param element WebElement to click
     */
    protected void jsClick(WebElement element) {
        logger.debug("Performing JS click");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * Scrolls the page to bring the element into view.
     *
     * @param element WebElement to scroll to
     */
    protected void scrollToElement(WebElement element) {
        logger.debug("Scrolling to element");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    /**
     * Enters text into a field after clearing it.
     *
     * @param element WebElement input field
     * @param text    text to enter
     */
    protected void enterText(WebElement element, String text) {
        logger.debug("Entering text into field");
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Clicks an element after waiting for it to be clickable.
     *
     * @param element WebElement to click
     */
    protected void clickElement(WebElement element) {
        logger.debug("Clicking element");
        waitForClickable(element);
        element.click();
    }

    /**
     * Gets text from an element after waiting for visibility.
     *
     * @param element WebElement to get text from
     * @return text content of the element
     */
    protected String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    /**
     * Selects a dropdown option by visible text.
     *
     * @param element     dropdown WebElement
     * @param visibleText option text to select
     */
    protected void selectByVisibleText(WebElement element, String visibleText) {
        logger.debug("Selecting dropdown: {}", visibleText);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    /**
     * Selects a dropdown option by value attribute.
     *
     * @param element dropdown WebElement
     * @param value   value attribute to select
     */
    protected void selectByValue(WebElement element, String value) {
        logger.debug("Selecting dropdown by value: {}", value);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * Checks if an element is displayed on the page.
     *
     * @param element WebElement to check
     * @return true if element is displayed
     */
    protected boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            logger.debug("Element not displayed: {}", e.getMessage());
            return false;
        }
    }
}
