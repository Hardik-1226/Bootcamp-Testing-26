package com.MFrames.Demo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CountFrames {
	WebDriver driver;
	
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void launchSite() throws InterruptedException {
        driver.get("file:/Users/av/Downloads/iframe.html");
        Thread.sleep(2000);
        
        int totalnoofframes = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames: " + totalnoofframes);
        
        driver.switchTo().frame("easycalculation");
        driver.get("https://www.login.hiox.com/login");
        driver.findElement(By.id("log_email")).sendKeys("9740673180");
        driver.findElement(By.id("log_password")).sendKeys("raghubn@123");
        driver.findElement(By.xpath("//input[contains(@name,'log_submit')]")).click();

        String title = driver.getTitle();
        System.out.println(title);

        driver.navigate().to("file:/Users/av/Downloads/iframe.html");
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/a")).click();

        driver.navigate().to("https://www.selenium.dev/");
        driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[3]/a/span")).click();
	}
	
	
	
	

}
