package com.SeleniumWebDriver.LocatorsDemo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IDNameXpath {

	WebDriver driver;
	String baseURL = "https://practicetestautomation.com/practice-test-login/";
	
//	public void Testing() throws InterruptedException {
//		
//	driver = new ChromeDriver();
//	driver.navigate().to(baseURL);
//	driver.manage().window().maximize();
//	
//	driver.findElement(By.id("username")).sendKeys("student");
//	driver.findElement(By.id("password")).sendKeys("Password123");
//	driver.findElement(By.xpath("//button[@id='submit']")).click();
//	Thread.sleep(3000);
//	driver.quit();
//	
//	
//	}
	@Test
	public void URLComparison () {
		driver = new ChromeDriver();
		String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
		
		driver.get("https://practicetestautomation.com/logged-in-successfully/");
		String URL = driver.getCurrentUrl();
		
		if(URL.equalsIgnoreCase(expectedURL)) {
			System.out.println("url matched");
	
		
		String value = "Logged In Successfully | Practice Test Automation";
		String actualValue = driver.getTitle();
	
		
		if(value.equalsIgnoreCase(actualValue)) {
			System.out.println("value matched");
		}
		
		
	}
	
	}
}
