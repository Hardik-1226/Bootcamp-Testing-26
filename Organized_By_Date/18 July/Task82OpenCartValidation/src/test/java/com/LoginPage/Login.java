package com.LoginPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.latest.page.model.Screenshot;
import org.openqa.selenium.support.FindBy;


public class Login {
	
	WebDriver driver;
	Screenshot sh=null;
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="(//span[normalize-space()='My Account'])[1]")
	WebElement account;
	
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Login']")
	WebElement login;
	
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement password;
	
	
	public void loginAccount(String emailLogin,String passwordLogin) throws InterruptedException {
		Thread.sleep(5000);
		account.click();
		login.click();
		Thread.sleep(4000);
		
		email.sendKeys(emailLogin);
		password.sendKeys(passwordLogin);
	}
	
	
	

}
