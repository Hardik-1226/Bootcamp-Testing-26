package com.SeleniumLocator.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Locator_class_demo {

    WebDriver driver;

    @Test
    public void class_locator() throws Exception {

    	driver=new ChromeDriver();
		driver.navigate().to("https://www.hollandandbarrett.com/shop/vitamins-supplements/vitamins/");
		driver.manage().window().maximize();
		
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		}catch(Exception e) {
			System.out.println("Cookie popup not displayed");
		}
		driver.findElement(By.xpath("//img[@alt='Vitamin Drinks category product example']")).click();
		driver.findElement(By.className("ProductCardImage-module_innerImage__2kx-2")).click();
//        Thread.sleep(3000);

//        System.out.println("Current URL : " + driver.getCurrentUrl());
//
//        driver.navigate().back();
//        Thread.sleep(3000);
//        System.out.println("After Back : " + driver.getCurrentUrl());
//
//        driver.navigate().forward();
//        Thread.sleep(3000);
//        System.out.println("After Forward : " + driver.getCurrentUrl());
//
//        driver.navigate().refresh();
//        Thread.sleep(3000);
//        System.out.println("After Refresh : " + driver.getCurrentUrl());

        driver.quit();
    }
}