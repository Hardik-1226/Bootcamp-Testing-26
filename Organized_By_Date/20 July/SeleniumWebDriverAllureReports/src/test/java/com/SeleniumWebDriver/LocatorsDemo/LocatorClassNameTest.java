package com.SeleniumWebDriver.LocatorsDemo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorClassNameTest {
	WebDriver driver;
	
	@Test
	
	public void classTest() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hollandandbarrett.com/shop/vitamins-supplements/vitamins/vitamin-drinks/");
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();	
		} catch (Exception e) {
			System.out.println("Cookie popup did not appear");
		}
		
		Thread.sleep(1000);
		driver.findElement(By.className("ProductCard-module_title__cGT4y")).click();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.quit();
	}

}
