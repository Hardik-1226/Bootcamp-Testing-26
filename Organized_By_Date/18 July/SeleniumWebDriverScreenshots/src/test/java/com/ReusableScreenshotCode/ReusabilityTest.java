package com.ReusableScreenshotCode;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import library.Reusability;

public class ReusabilityTest {

    @Test
    public void Browser() throws Exception {

        ChromeDriver driver1 = new ChromeDriver();
        driver1.get("https://auth.hollandandbarrett.com/u/login");
        driver1.manage().window().maximize();

        Reusability.captureSS(driver1, "A. Launch Application - TakeScreenShot");

        driver1.findElement(By.id("username")).sendKeys("raghu.astepahead@gmail.com");
        driver1.findElement(By.name("password")).sendKeys("raghuBN@123");

        Thread.sleep(5000);
        driver1.findElement(By.xpath("//button[@name='action']")).click();

        Reusability.captureSS(driver1, "B. Click Sign In Button - TakeScreenShot");

    }
}