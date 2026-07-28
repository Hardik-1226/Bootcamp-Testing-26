package com.demowebshop.utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    private static final Logger logger = LogManager.getLogger(WaitHelper.class);
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        logger.debug("WaitHelper initialized with default timeout: 10 seconds");
    }

    public WaitHelper(WebDriver driver, long timeoutSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        logger.debug("WaitHelper initialized with custom timeout: {} seconds", timeoutSeconds);
    }

    public WebElement waitForVisibility(WebElement element) {
        logger.debug("Waiting for element to be visible: {}", element);
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error("Element not visible after timeout: {}", e.getMessage());
            throw e;
        }
    }

    public WebElement waitForClickable(WebElement element) {
        logger.debug("Waiting for element to be clickable: {}", element);
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.error("Element not clickable after timeout: {}", e.getMessage());
            throw e;
        }
    }

    public WebElement waitForPresence(WebElement element) {
        logger.debug("Waiting for element presence: {}", element);
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error("Element not present after timeout: {}", e.getMessage());
            throw e;
        }
    }

    public boolean waitForTitle(String titlePart) {
        logger.debug("Waiting for title to contain: {}", titlePart);
        try {
            return wait.until(ExpectedConditions.titleContains(titlePart));
        } catch (Exception e) {
            logger.error("Title did not contain '{}' after timeout: {}", titlePart, e.getMessage());
            throw e;
        }
    }

    public boolean waitForUrl(String urlPart) {
        logger.debug("Waiting for URL to contain: {}", urlPart);
        try {
            return wait.until(ExpectedConditions.urlContains(urlPart));
        } catch (Exception e) {
            logger.error("URL did not contain '{}' after timeout: {}", urlPart, e.getMessage());
            throw e;
        }
    }

    public boolean waitForInvisibility(WebElement element) {
        logger.debug("Waiting for element to become invisible: {}", element);
        try {
            return wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            logger.error("Element still visible after timeout: {}", e.getMessage());
            throw e;
        }
    }

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
