package com.Framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	 WebDriver driver;

	    //Create Constructor
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    @FindBy(how = How.ID, using = "log_email")
	    WebElement Username;

	    @FindBy(how = How.NAME, using = "log_password")
	    WebElement Password;

	    @FindBy(how = How.XPATH, using = "//input[contains(@id,'log_password')]")
	    WebElement BtnLogin;

	    //Create Method
	    public void login_Page(String uname, String pass) throws InterruptedException {
	        Username.sendKeys(uname);
	        Password.sendKeys(pass);
	        Thread.sleep(3000);
	        BtnLogin.click();
	    }
}