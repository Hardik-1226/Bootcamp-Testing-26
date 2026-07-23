package com.Framework.TestCase;

import org.testng.annotations.Test;

import com.Framework.Pages.BaseClass;
import com.Framework.Pages.LoginPage;

public class LoginOrganHRM extends BaseClass {

    @Test
    public void loginApp() throws Exception {

        LoginPage login = new LoginPage(driver);

        login.loginToApplication(
                excel.getStringData("LoginHRM", 1, 0),
                excel.getStringData("LoginHRM", 1, 1));

        Thread.sleep(10000);
    }
}