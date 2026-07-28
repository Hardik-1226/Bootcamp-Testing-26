package com.SeleniumWebDriver.ChromeBrowserTest;

import org.openqa.selenium.chrome.ChromeDriver;

public class chromebrowser {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/about/");
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		
		
		// TODO Auto-generated method stub

	}

}
