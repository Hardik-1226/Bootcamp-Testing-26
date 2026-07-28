package com.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.LoginPage.Login;
import com.utility.Helper;

public class Testt {

	@Test
	public void exceute() throws InterruptedException {
		WebDriver driver=Helper.startBrowser("chrome", "http://demo.opencart.com/");
         Login log=PageFactory.initElements(driver,Login.class);
		
		log.loginAccount("brahmdang@gmail.com", "brahm@123");
		driver.quit();
		
	}
}
