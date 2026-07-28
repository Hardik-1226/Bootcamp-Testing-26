package com.navigationcommands.Demo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class A_NavigationCommands {

    WebDriver driver;

    @Test(priority = 0)
    public void NavigateDemo() {
        driver = new ChromeDriver();
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        String URL = driver.getCurrentUrl();
        System.out.println(URL);
        driver.navigate().back();
    }

    @Test(priority = 1)
    public void NavigateBackDemo() {
        driver = new ChromeDriver();

        driver.get("https://www.google.co.in");
        String URL = driver.getCurrentUrl();
        System.out.println(URL);

        String Title = driver.getTitle();
        System.out.println(Title);

        driver.navigate().to("https://login.yahoo.com/");
        URL = driver.getCurrentUrl();
        System.out.println(URL);

        driver.navigate().back();
        URL = driver.getCurrentUrl();
        System.out.println(URL);
    }

    @Test(priority = 2)
    public void NavigateForwardDemo() {
        driver = new ChromeDriver();

        driver.get("https://www.google.co.in");
        String URL = driver.getCurrentUrl();
        System.out.println(URL);

        driver.navigate().to("https://login.yahoo.com/");
        URL = driver.getCurrentUrl();
        System.out.println(URL);

        driver.navigate().forward();
        URL = driver.getCurrentUrl();
        System.out.println(URL);
    }

    @Test(priority = 3)
    public void NavigateRefreshDemo() {
        driver = new ChromeDriver();

        driver.get("https://www.google.co.in");
        String URL = driver.getCurrentUrl();
        System.out.println(URL);

        driver.navigate().to("https://www.google.co.in");
        driver.navigate().refresh();
    }
}