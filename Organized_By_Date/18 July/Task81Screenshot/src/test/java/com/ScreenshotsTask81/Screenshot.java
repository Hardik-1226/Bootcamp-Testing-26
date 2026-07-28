package com.ScreenshotsTask81;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Screenshot {

    WebDriver driver;
    String baseURL = "https://www.demoblaze.com/";

    public void takeScreenshot(String stepName) throws IOException {

        File folder = new File("./ScreenShots");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        File destination = new File(folder, stepName + ".png");

        FileUtils.copyFile(source, destination);

        System.out.println(stepName + " Screenshot Captured");
    }

  
    @Test
    public void PurchaseProduct() throws Exception {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        takeScreenshot("Step01_LaunchBrowser");

        driver.get(baseURL);

        takeScreenshot("Step02_HomePage");

        driver.findElement(By.id("login2")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("loginusername")).sendKeys("Brahm23");
        driver.findElement(By.id("loginpassword")).sendKeys("brahm@123");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        Thread.sleep(4000);

        takeScreenshot("Step03_Login");

        driver.findElement(By.linkText("Samsung galaxy s6")).click();

        Thread.sleep(3000);

        takeScreenshot("Step04_Product");

        System.out.println("Product Details Opened");

        takeScreenshot("Step05_ProductDetails");

        driver.findElement(By.linkText("Add to cart")).click();

        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        alert.accept();

        Thread.sleep(2000);

        takeScreenshot("Step06_AddToCart");

        driver.findElement(By.id("cartur")).click();

        Thread.sleep(3000);

        if (driver.getPageSource().contains("Samsung galaxy s6")) {
            System.out.println("Cart Verified");
        } else {
            System.out.println("Cart Verification Failed");
        }

        takeScreenshot("Step07_Cart");

        System.out.println("Coupon Feature Not Available");

        takeScreenshot("Step08_Coupon");

        driver.findElement(By.xpath("//button[text()='Place Order']")).click();

        Thread.sleep(2000);

        takeScreenshot("Step09_Checkout");

        driver.findElement(By.id("name")).sendKeys("Brahm");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Delhi");
        driver.findElement(By.id("card")).sendKeys("69696969696969");
        driver.findElement(By.id("month")).sendKeys("July");
        driver.findElement(By.id("year")).sendKeys("2026");

        takeScreenshot("Step10_Address");

        System.out.println("Delivery Option Not Available");

        takeScreenshot("Step11_DeliveryOption");

        System.out.println("Credit Card Selected");

        takeScreenshot("Step12_PaymentMethod");

        driver.findElement(By.xpath("//button[text()='Purchase']")).click();

        Thread.sleep(3000);

        takeScreenshot("Step13_PaymentCompleted");

        String actual = driver.findElement(By.xpath("//h2")).getText();
        String expected = "Thank you for your purchase!";

        if (actual.equals(expected)) {
            System.out.println("Order Placed Successfully");
        } else {
            System.out.println("Order Failed");
        }

        takeScreenshot("Step14_OrderConfirmation");

        System.out.println("My Orders Feature Not Available");

        takeScreenshot("Step15_MyOrders");

        driver.findElement(By.xpath("//button[text()='OK']")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("logout2")).click();

        Thread.sleep(3000);

        takeScreenshot("Step16_Logout");

        driver.quit();
    }}