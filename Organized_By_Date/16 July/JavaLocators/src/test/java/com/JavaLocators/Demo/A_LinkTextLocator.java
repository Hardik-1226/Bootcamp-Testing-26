package com.JavaLocators.Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class A_LinkTextLocator {
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
	public void findElementByID() {
		driver.findElement(By.linkText("Vitamins & Supplements")).click();
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		int linkCount = links.size();
		int Total = 0;
		Total = Total + links.size();
		System.out.println("Number of Links: " + linkCount);
		for(int i = 1; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
		}
	}
	
}
