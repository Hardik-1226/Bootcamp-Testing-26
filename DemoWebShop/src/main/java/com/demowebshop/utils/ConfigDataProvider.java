package com.demowebshop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigDataProvider {

    private static final Logger logger = LogManager.getLogger(ConfigDataProvider.class);
    private Properties pro;

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

    public String getBrowser() {
        String browser = pro.getProperty("browser");
        logger.debug("Browser from config: {}", browser);
        return browser;
    }

    public String getUrl() {
        String url = pro.getProperty("url");
        logger.debug("URL from config: {}", url);
        return url;
    }

    public String getUsername() {
        String username = pro.getProperty("username");
        logger.debug("Username from config: {}", username);
        return username;
    }

    public String getPassword() {
        String password = pro.getProperty("password");
        logger.debug("Password retrieved from config");
        return password;
    }

    public long getTimeout() {
        String timeout = pro.getProperty("timeout");
        logger.debug("Timeout from config: {}", timeout);
        return Long.parseLong(timeout);
    }

    public String getScreenshotPath() {
        String path = pro.getProperty("screenshot.path");
        logger.debug("Screenshot path from config: {}", path);
        return path;
    }

    public String getProperty(String key) {
        String value = pro.getProperty(key);
        logger.debug("Property '{}' = '{}'", key, value);
        return value;
    }
}
