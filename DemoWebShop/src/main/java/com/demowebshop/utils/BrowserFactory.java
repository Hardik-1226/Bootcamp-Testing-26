package com.demowebshop.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * BrowserFactory - Factory class to create and manage WebDriver instances.
 * Supports Chrome, Firefox, and Edge browsers using WebDriverManager.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class BrowserFactory {

    private static final Logger logger = LogManager.getLogger(BrowserFactory.class);

    /**
     * Creates and returns a WebDriver instance based on the specified browser name.
     *
     * @param browserName the name of the browser (chrome, firefox, edge)
     * @return WebDriver instance for the specified browser
     */
    public static WebDriver startBrowser(String browserName) {
        WebDriver driver = null;
        logger.info("Initializing browser: {}", browserName);

        try {
            switch (browserName.toLowerCase().trim()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--disable-notifications");
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(chromeOptions);
                    logger.info("Chrome browser launched successfully");
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--disable-notifications");
                    driver = new FirefoxDriver(firefoxOptions);
                    logger.info("Firefox browser launched successfully");
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--disable-notifications");
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    driver = new EdgeDriver(edgeOptions);
                    logger.info("Edge browser launched successfully");
                    break;

                default:
                    logger.error("Invalid browser name: {}. Defaulting to Chrome.", browserName);
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    logger.info("Chrome browser launched as default");
                    break;
            }
        } catch (Exception e) {
            logger.error("Failed to initialize browser: {}", e.getMessage());
            throw new RuntimeException("Browser initialization failed: " + e.getMessage(), e);
        }

        return driver;
    }

    /**
     * Quits the given WebDriver instance and releases resources.
     *
     * @param driver the WebDriver instance to quit
     */
    public static void quitBrowser(WebDriver driver) {
        if (driver != null) {
            try {
                driver.quit();
                logger.info("Browser closed successfully");
            } catch (Exception e) {
                logger.error("Error while closing browser: {}", e.getMessage());
            }
        }
    }
}
