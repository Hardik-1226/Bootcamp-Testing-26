package com.SeleniumLocator.Example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Locators_class_demo2 {

    WebDriver driver;
    int total = 0;

    @BeforeMethod
    public void ChromeTest() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.hollandandbarrett.com/");

        Thread.sleep(5000);

        try {
            driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        } catch (Exception e) {
            System.out.println("Cookie popup not displayed");
        }
    }

    @Test
    public void count_links() {

        driver.findElement(By.linkText("Vitamins & Supplements")).click();

        List<WebElement> links = driver.findElements(By.xpath("//a"));

        int linkCount = links.size();
        total += linkCount;

        System.out.println("Number of links: " + total);

        for (WebElement link : links) {
            System.out.println(link.getText());
        }

        driver.quit();
    }
}