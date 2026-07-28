package com.ScreenshotTestNG.Demo;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class SSusingTestNG {
	
	WebDriver driver = new ChromeDriver();
	
	@Test
	public void ss() throws InterruptedException, IOException {
		driver.get("http://www.youtube.com");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/YoutubeSS.png"));
		System.out.println("Screenshot has been captured");
		driver.quit();
	}
	
	
}
