package com.SeleniumLocator.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class test {
	WebDriver driver;
	@Test
	public void ChromeTest() {
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
		
		String BrowserTitle=driver.getCurrentUrl();
		System.out.println(BrowserTitle);
		
		driver.navigate().back();
		BrowserTitle=driver.getCurrentUrl();
		System.out.println(BrowserTitle);
		
		driver.navigate().refresh();
		BrowserTitle=driver.getCurrentUrl();
		System.out.println(BrowserTitle);
		
		
		driver.navigate().forward();
		BrowserTitle=driver.getCurrentUrl();
		System.out.println(BrowserTitle);
		driver.quit();
	}
}
