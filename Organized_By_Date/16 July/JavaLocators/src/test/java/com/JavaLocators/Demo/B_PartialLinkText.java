package com.JavaLocators.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class B_PartialLinkText {

WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.hollandandbarrett.com/");
		Thread.sleep(5000);
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		} catch (Exception e) {
			System.out.println("Popup did not appear");
		}
		}
	
	@Test
	public void partialLinkText() {
		driver.findElement(By.partialLinkText("Vitamins")).click();

	    Thread.sleep(3000);

	    System.out.println("Current Page Title: " + driver.getTitle());
	}
	
}
