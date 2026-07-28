package com.Alerts.Demo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Utility.Demo.Helper;

public class A_AlertsTypes {
	WebDriver driver;
	
	
	@Test
	
	public void alerts() throws InterruptedException {
		WebDriver driver = Helper.start("GC");
		driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
		String result = driver.findElement(By.cssSelector("#result")).getText();
		System.out.println(result);
		Assert.assertEquals("You successfully clicked an alert", result);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.dismiss();
		result = driver.findElement(By.cssSelector("#result")).getText();
		System.out.println(result);
		Assert.assertEquals("You clicked: Cancel", result);

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();
		alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.sendKeys("GODZILLA");
		alert.accept();
		result = driver.findElement(By.cssSelector("#result")).getText();
		System.out.println(result);
		Assert.assertEquals("You entered: GODZILLA", result);
		
		

		
		
	}
}
