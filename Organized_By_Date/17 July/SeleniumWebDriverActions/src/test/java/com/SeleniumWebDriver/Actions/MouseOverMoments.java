package com.SeleniumWebDriver.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseOverMoments {

    @Test
    public void mouseover() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.easycalculation.com/");

        WebElement ele = driver.findElement(By.xpath("//a[contains(.,'Others')]"));
        Actions act = new Actions(driver);
        act.moveToElement(ele).build().perform();

        Thread.sleep(6000);

        WebElement ele2 = driver.findElement(By.xpath("//a[contains(.,'Download')]"));
        ele2.click();
        
        Thread.sleep(6000);


        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}

