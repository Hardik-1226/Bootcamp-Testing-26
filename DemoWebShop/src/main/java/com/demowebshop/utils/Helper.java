package com.demowebshop.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {

    private static final Logger logger = LogManager.getLogger(Helper.class);
    private static final Random random = new Random();
    private static final String SCREENSHOT_DIR = "./screenshots/";
    private static final String ALPHA_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMERIC_CHARS = "0123456789";

    public static String captureScreenshot(WebDriver driver, String testName) {
        logger.info("Capturing screenshot for: {}", testName);
        String timestamp = generateTimestamp();
        String fileName = testName + "_" + timestamp + ".png";
        String filePath = SCREENSHOT_DIR + fileName;

        try {
            File screenshotDir = new File(SCREENSHOT_DIR);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath);
            FileUtils.copyFile(source, destination);
            logger.info("Screenshot saved: {}", destination.getAbsolutePath());
            return destination.getAbsolutePath();
        } catch (IOException e) {
            logger.error("Screenshot capture failed: {}", e.getMessage());
            return "";
        }
    }

    public static String generateTimestamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        logger.debug("Scrolling element into view");
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            logger.info("Scrolled to element successfully");
        } catch (Exception e) {
            logger.error("Failed to scroll to element: {}", e.getMessage());
        }
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        logger.debug("Highlighting element");
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String originalStyle = element.getAttribute("style");
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element, "border: 3px solid red; background: yellow;");
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
                    element, originalStyle);
            logger.debug("Element highlighted successfully");
        } catch (Exception e) {
            logger.error("Failed to highlight element: {}", e.getMessage());
        }
    }

    public static void javascriptClick(WebDriver driver, WebElement element) {
        logger.debug("Performing JavaScript click on element");
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
            logger.info("JavaScript click performed successfully");
        } catch (Exception e) {
            logger.error("JavaScript click failed: {}", e.getMessage());
            throw new RuntimeException("JavaScript click failed: " + e.getMessage(), e);
        }
    }

    public static WebElement waitForVisibility(WebDriver driver, WebElement element, long timeoutSeconds) {
        logger.debug("Waiting for element visibility with timeout: {} seconds", timeoutSeconds);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            logger.error("Element not visible after {} seconds: {}", timeoutSeconds, e.getMessage());
            throw e;
        }
    }

    public static WebElement waitForClickable(WebDriver driver, WebElement element, long timeoutSeconds) {
        logger.debug("Waiting for element clickability with timeout: {} seconds", timeoutSeconds);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            logger.error("Element not clickable after {} seconds: {}", timeoutSeconds, e.getMessage());
            throw e;
        }
    }

    public static void selectDropdown(WebElement element, String visibleText) {
        logger.info("Selecting dropdown value: {}", visibleText);
        try {
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
            logger.info("Dropdown value '{}' selected successfully", visibleText);
        } catch (Exception e) {
            logger.error("Failed to select dropdown value '{}': {}", visibleText, e.getMessage());
            throw new RuntimeException("Dropdown selection failed: " + e.getMessage(), e);
        }
    }

    public static String randomEmail() {
        String email = "testuser" + random.nextInt(99999) + "@demowebshop.com";
        logger.debug("Generated random email: {}", email);
        return email;
    }

    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALPHA_CHARS.charAt(random.nextInt(ALPHA_CHARS.length())));
        }
        String result = sb.toString();
        logger.debug("Generated random string: {}", result);
        return result;
    }

    public static String randomPhone() {
        StringBuilder sb = new StringBuilder(10);
        sb.append(random.nextInt(9) + 1);
        for (int i = 1; i < 10; i++) {
            sb.append(NUMERIC_CHARS.charAt(random.nextInt(NUMERIC_CHARS.length())));
        }
        String phone = sb.toString();
        logger.debug("Generated random phone: {}", phone);
        return phone;
    }
}
