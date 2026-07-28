package com.Utility.Example;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class helper {
	public static WebDriver startbrowser(String browser) {
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("Chrome")||browser.equalsIgnoreCase("Ch")||browser.equalsIgnoreCase("Google chrome")) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("Edge")||browser.equalsIgnoreCase("Ed")) {
			driver=new EdgeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("FireFox")||browser.equalsIgnoreCase("Fx")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("Safari") || browser.equalsIgnoreCase("Sf")) {
			driver=new SafariDriver();
		}
		else {
			System.out.println("Sorry we do not suppoet the other browser");
		}
		return driver;
	}
	public static void closing(WebDriver driver) {
		driver.quit();
	}
}
