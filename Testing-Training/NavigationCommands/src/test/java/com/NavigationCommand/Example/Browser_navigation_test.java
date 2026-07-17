package com.NavigationCommand.Example;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Browser_navigation_test {
	WebDriver driver;
	@Parameters("Browser")
	@BeforeMethod
	public void setup(String Browser) {
		if(Browser.equalsIgnoreCase("Chrome")) {
			driver= new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("FireFox")) {
			driver=new FirefoxDriver();
		}
		else {
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
	}
	@Test
	public void navigationTest() throws Exception {
		driver.get("https://practicetestautomation.com/practice-test-login/");
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
