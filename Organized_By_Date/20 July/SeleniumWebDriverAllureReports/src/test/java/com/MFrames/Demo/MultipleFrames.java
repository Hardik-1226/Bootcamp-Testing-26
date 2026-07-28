package com.MFrames.Demo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleFrames {
	WebDriver driver;
	
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void launchSite() {
        driver.get("file:/Users/av/Downloads/iframe.html");
        
	}
	
	
	
	

}
