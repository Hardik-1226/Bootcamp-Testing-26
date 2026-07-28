package com.seleniumfirefoxtest;

import org.openqa.selenium.firefox.FirefoxDriver;

public class firefoxtest {

	public static void main(String[] args) {
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.selenium.dev/about/");
		driver.manage().window().maximize();
		// TODO Auto-generated method stub

	}

}
