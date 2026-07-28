package com.Framework.TestCase;

import org.openqa.selenium.support.PageFactory;

import com.Framework.Pages.BaseClass;
import com.Framework.Pages.LoginPage;

import utility.ExcelDataReader;

public class LoginEasyCalculation extends BaseClass {

	public void loginApp() throws InterruptedException {
		ExcelDataReader excel = new ExcelDataReader();
		excel.getStringData("Sheet1", 0, 0);
		LoginPage loginHRM = PageFactory.initElements(driver, LoginPage.class);
		loginHRM.login_Page(excel.getStringData("Sheet1", 0, 0), excel.getStringData("LoginHRM", 0, 1));
		Thread.sleep(6000);
	}

}
