package com.casestudy.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Utility.Example.helper;

import Selenium_Alert_Example.alert_demo_test;

public class Case_study_task_74 {
	@Test

	public void popup() throws Exception {

        WebDriver driver = helper.startbrowser("Chrome");
        driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[3]/form/button")).click();
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        String msg=alert.getText();
        System.out.println("Message from the alert: "+msg);
        alert.accept();
       driver.quit();

	}
}
