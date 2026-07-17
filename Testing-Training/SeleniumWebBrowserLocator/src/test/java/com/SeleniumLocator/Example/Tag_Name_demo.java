package com.SeleniumLocator.Example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tag_Name_demo {

    WebDriver driver;

    @BeforeMethod
    public void tagdemo() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://saucelabs.com/");
    }

    @Test
    public void tagNameLocator() {

        // Find all links (<a> tags)
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println("Total Links: " + allLinks.size());

        for (WebElement link : allLinks) {

            System.out.println("Link Text : " + link.getText());
            System.out.println("URL       : " + link.getAttribute("href"));
            System.out.println("--------------------------------");
        }
        // Click the 4th link (if available)
        if (allLinks.size() >= 4) {
            allLinks.get(3).click();
            System.out.println("Current URL: " + driver.getCurrentUrl());
        } else {
            System.out.println("Less than 4 links are available.");
        }
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}