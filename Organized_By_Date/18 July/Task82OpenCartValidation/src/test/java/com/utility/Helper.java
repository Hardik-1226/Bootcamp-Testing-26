package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Helper {
	
	public static WebDriver startBrowser(String browser,String url) {
		WebDriver driver=null;
		
		if(browser.equalsIgnoreCase("chrome")||browser.equalsIgnoreCase("GC")||browser.equalsIgnoreCase("Google Chrome")) {
			ChromeOptions options = new ChromeOptions();

		 driver = new ChromeDriver(options);
			
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("Edge")||browser.equalsIgnoreCase("eg")||browser.equalsIgnoreCase("Microsoft Edge")) {
			driver=new EdgeDriver();
			driver.manage().window().maximize();
		}else if(browser.equalsIgnoreCase("Firefox")||browser.equalsIgnoreCase("FF")||browser.equalsIgnoreCase("Mozilla Firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}else {
			System.out.println("Sorry we do not support this browser");
		}
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}

}
