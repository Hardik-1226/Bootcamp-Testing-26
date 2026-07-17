package Selenium_Alert_Example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Utility.Example.helper;

public class alert_demo_test {

    @Test
    public void popup() throws Exception {

        WebDriver driver = helper.startbrowser("Chrome");
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Simple Alert
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();
        String result = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println(result);
        Assert.assertEquals(result, "You successfully clicked an alert");
        Thread.sleep(1000);
        

        // Confirm Alert - Dismiss
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert2 = driver.switchTo().alert();
        Thread.sleep(1000);
        alert2.dismiss();
        String result2 = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println(result2);
        Assert.assertEquals(result2, "You clicked: Cancel");
        Thread.sleep(1000);

        // Confirm Alert - Accept
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Alert alert4 = driver.switchTo().alert();
        Thread.sleep(1000);
        alert4.accept();
        String result4 = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println(result4);
        Assert.assertEquals(result4, "You clicked: Ok");
        Thread.sleep(1000);

        
        
        // Prompt Alert - Accept
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Welcome to my web");
        Thread.sleep(1000);
        alert3.accept();
        String result3 = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println(result3);
        Assert.assertEquals(result3, "You entered: Welcome to my web");
        Thread.sleep(1000);

        
        
        // Prompt Alert - Dismiss
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Alert alert5 = driver.switchTo().alert();
        Thread.sleep(1000);
        alert5.dismiss();
        String result5 = driver.findElement(By.cssSelector("#result")).getText();
        System.out.println(result5);
        Assert.assertEquals(result5, "You entered: null");
        Thread.sleep(1000);

        driver.quit();
    }
}