package com.demowebshop.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {

    private static final Logger logger = LogManager.getLogger(ScreenshotHelper.class);
    private static final String SCREENSHOT_DIR = "./screenshots/";

    public static String captureScreenshot(WebDriver driver, String testName) {
        logger.info("Capturing screenshot for test: {}", testName);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timestamp + ".png";
        String filePath = SCREENSHOT_DIR + fileName;

        try {
            File screenshotDir = new File(SCREENSHOT_DIR);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
                logger.debug("Created screenshots directory: {}", SCREENSHOT_DIR);
            }

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath);
            FileUtils.copyFile(source, destination);
            logger.info("Screenshot saved successfully: {}", destination.getAbsolutePath());
            return destination.getAbsolutePath();
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: {}", e.getMessage());
            return "";
        }
    }

    public static byte[] captureScreenshotAsBytes(WebDriver driver) {
        logger.debug("Capturing screenshot as byte array for Allure report");
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            return ts.getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            logger.error("Failed to capture screenshot as bytes: {}", e.getMessage());
            return new byte[]{};
        }
    }

    public static String captureScreenshot(WebDriver driver, String testName, String directory) {
        logger.info("Capturing screenshot for test: {} in directory: {}", testName, directory);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timestamp + ".png";
        String filePath = directory + fileName;

        try {
            File screenshotDir = new File(directory);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
                logger.debug("Created custom screenshots directory: {}", directory);
            }

            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File destination = new File(filePath);
            FileUtils.copyFile(source, destination);
            logger.info("Screenshot saved to custom path: {}", destination.getAbsolutePath());
            return destination.getAbsolutePath();
        } catch (IOException e) {
            logger.error("Failed to capture screenshot to custom path: {}", e.getMessage());
            return "";
        }
    }
}
