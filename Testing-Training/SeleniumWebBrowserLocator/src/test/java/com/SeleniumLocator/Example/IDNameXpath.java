package com.SeleniumLocator.Example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IDNameXpath {
	WebDriver driver;
	String base_url="https://practicetestautomation.com/practice-test-login/";
	@Test
	public void locators() {
		driver =new ChromeDriver();
		driver.navigate().to(base_url);
		driver.manage().window().maximize();
		String curr_url=driver.getCurrentUrl();
		System.out.println("Curent url: "+curr_url);
		
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		String actual_value=driver.getTitle();
		String expected_value="Logged In Successfully";
		String after_url=driver.getCurrentUrl();
		System.out.println("After the url: "+after_url);
		
		if(actual_value.contentEquals(expected_value)) {
			System.out.println("Both value are equal");
		}
		else {
			System.out.println("Both value are not equal");
			System.out.println("Actual Value: "+actual_value);
			System.out.println("Expected Value: "+expected_value);
		}
		driver.quit();
	}
}
