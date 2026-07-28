package com.demowebshop.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WaitHelper - Provides explicit wait utility methods for Selenium WebDriver.
 * Wraps WebDriverWait with ExpectedConditions for cleaner page object usage.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class WaitHelper {

    private static final Logger logger = LogManager.getLogger(WaitHelper.class);
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor - Initializes WaitHelper with default timeout of 10 seconds.
     *
     * @param driver WebDriver instance
     */
    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.debug("WaitHelper initialized with default timeout: 10 seconds");
    }

    /**
     * Constructor - Initializes WaitHelper with a custom timeout.
     *
     * @param driver         WebDriver instance
     * @param timeoutSeconds custom timeout in seconds
     */
    public WaitHelper(WebDriver driver, long timeoutSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        logger.debug("WaitHelper initialized with custom timeout: {} seconds", timeoutSeconds);
    }

    /**
     * Waits until the element is visible on the page.
     *
     * @param element WebElement to wait for
     * @return the visible WebElement
     */
    public WebElement waitForVisibility(WebElement element) {
        logger.debug("Waiting for element to be visible: {}", element);
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error("Element not visible after timeout: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * Waits until the element is clickable.
     *
     * @param element WebElement to wait for
     * @return the clickable WebElement
     */
    public WebElement waitForClickable(WebElement element) {
        logger.debug("Waiting for element to be clickable: {}", element);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.error("Element not clickable after timeout: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * Waits until the element is present in the DOM.
     *
     * @param element WebElement to wait for
     * @return the present WebElement
     */
    public WebElement waitForPresence(WebElement element) {
        logger.debug("Waiting for element presence: {}", element);
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error("Element not present after timeout: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * Waits until the page title contains the specified text.
     *
     * @param titlePart partial title text
     * @return true if title contains the text
     */
    public boolean waitForTitle(String titlePart) {
        logger.debug("Waiting for title to contain: {}", titlePart);
        try {
            return wait.until(ExpectedConditions.titleContains(titlePart));
        } catch (Exception e) {
            logger.error("Title did not contain '{}' after timeout: {}", titlePart, e.getMessage());
            throw e;
        }
    }

    /**
     * Waits until the URL contains the specified text.
     *
     * @param urlPart partial URL text
     * @return true if URL contains the text
     */
    public boolean waitForUrl(String urlPart) {
        logger.debug("Waiting for URL to contain: {}", urlPart);
        try {
            return wait.until(ExpectedConditions.urlContains(urlPart));
        } catch (Exception e) {
            logger.error("URL did not contain '{}' after timeout: {}", urlPart, e.getMessage());
            throw e;
        }
    }

    /**
     * Waits until the element becomes invisible/hidden.
     *
     * @param element WebElement to wait for invisibility
     * @return true if element becomes invisible
     */
    public boolean waitForInvisibility(WebElement element) {
        logger.debug("Waiting for element to become invisible: {}", element);
        try {
            return wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            logger.error("Element still visible after timeout: {}", e.getMessage());
            throw e;
        }
    }

    /**
     * Waits until an alert is present.
     *
     * @return the Alert object
     */
    public org.openqa.selenium.Alert waitForAlert() {
        logger.debug("Waiting for alert to be present");
        try {
            return wait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            logger.error("Alert not present after timeout: {}", e.getMessage());
            throw e;
        }
    }
}
