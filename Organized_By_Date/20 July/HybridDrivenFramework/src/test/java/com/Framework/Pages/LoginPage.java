package com.Framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "username")
    WebElement Username;

    @FindBy(how = How.NAME, using = "password")
    WebElement Password;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement LoginButton;

    public void loginToApplication(String user, String pass) {

        Username.sendKeys(user);
        Password.sendKeys(pass);
        LoginButton.click();
    }
}