package com.demowebshop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * ConfigDataProvider - Reads configuration values from Config.properties file.
 * Provides getter methods for all application configuration settings.
 *
 * @author DemoWebShop Automation Team
 * @version 1.0
 */
public class ConfigDataProvider {

    private static final Logger logger = LogManager.getLogger(ConfigDataProvider.class);
    private Properties pro;

    /**
     * Constructor - Loads Config.properties file from resources directory.
     */
    public ConfigDataProvider() {
        try {
            File src = new File("./src/main/resources/Config/Config.properties");
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
            fis.close();
            logger.info("DemoWebShop configuration file loaded successfully");
        } catch (IOException e) {
            logger.error("Unable to load DemoWebShop configuration file: {}", e.getMessage());
            throw new RuntimeException("Configuration file loading failed: " + e.getMessage(), e);
        }
    }

    /**
     * Returns the browser name from configuration.
     *
     * @return browser name (chrome, firefox, edge)
     */
    public String getBrowser() {
        String browser = pro.getProperty("browser");
        logger.debug("Browser from config: {}", browser);
        return browser;
    }

    /**
     * Returns the application URL from configuration.
     *
     * @return application URL
     */
    public String getUrl() {
        String url = pro.getProperty("url");
        logger.debug("URL from config: {}", url);
        return url;
    }

    /**
     * Returns the username from configuration.
     *
     * @return username for login
     */
    public String getUsername() {
        String username = pro.getProperty("username");
        logger.debug("Username from config: {}", username);
        return username;
    }

    /**
     * Returns the password from configuration.
     *
     * @return password for login
     */
    public String getPassword() {
        String password = pro.getProperty("password");
        logger.debug("Password retrieved from config");
        return password;
    }

    /**
     * Returns the implicit wait timeout from configuration.
     *
     * @return timeout value in seconds
     */
    public long getTimeout() {
        String timeout = pro.getProperty("timeout");
        logger.debug("Timeout from config: {}", timeout);
        return Long.parseLong(timeout);
    }

    /**
     * Returns the screenshot path from configuration.
     *
     * @return screenshot directory path
     */
    public String getScreenshotPath() {
        String path = pro.getProperty("screenshot.path");
        logger.debug("Screenshot path from config: {}", path);
        return path;
    }

    /**
     * Returns any custom property value by key.
     *
     * @param key the property key
     * @return property value
     */
    public String getProperty(String key) {
        String value = pro.getProperty(key);
        logger.debug("Property '{}' = '{}'", key, value);
        return value;
    }
}
