package com.SeleniumWebDriver.Actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestScrollUpandDown {

    WebDriver driver;
    String url = "https://www.spicejet.com/";

    @Test
    public void Test() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        Thread.sleep(10000);

        ((JavascriptExecutor) driver).executeScript("scroll(0,6600)");
        Thread.sleep(6000);

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-4200)", " ");
    }
}