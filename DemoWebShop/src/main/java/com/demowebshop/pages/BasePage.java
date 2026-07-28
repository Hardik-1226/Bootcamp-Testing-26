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

public abstract class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        logger.debug("PageFactory initialized for: {}", this.getClass().getSimpleName());
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Current page title: {}", title);
        return title;
    }

    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        logger.info("Current URL: {}", url);
        return url;
    }

    protected WebElement waitForVisibility(WebElement element) {
        logger.debug("Waiting for element visibility");
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForClickable(WebElement element) {
        logger.debug("Waiting for element to be clickable");
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void jsClick(WebElement element) {
        logger.debug("Performing JS click");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    protected void scrollToElement(WebElement element) {
        logger.debug("Scrolling to element");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    protected void enterText(WebElement element, String text) {
        logger.debug("Entering text into field");
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element) {
        logger.debug("Clicking element");
        waitForClickable(element);
        element.click();
    }

    protected String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText();
    }

    protected void selectByVisibleText(WebElement element, String visibleText) {
        logger.debug("Selecting dropdown: {}", visibleText);
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    protected void selectByValue(WebElement element, String value) {
        logger.debug("Selecting dropdown by value: {}", value);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            logger.debug("Element not displayed: {}", e.getMessage());
            return false;
        }
    }
}
