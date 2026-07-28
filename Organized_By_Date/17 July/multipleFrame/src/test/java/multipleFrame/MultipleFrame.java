package multipleFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MultipleFrame {
    @Test
    public void Frames() throws Exception {

        WebDriver driver = Helper.startBrowser("GC");
        driver.get("file:///E:/Bootcamp%20Testing'26/iframe.html");
        Thread.sleep(5000);

        int totalnoofframes = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Number of Frames: " + totalnoofframes);

        driver.switchTo().frame("easycalculation");
        driver.get("https://www.login.hiox.com/login?referrer=easycalculation.com");
        driver.findElement(By.id("log_email")).sendKeys("9740673180");
        driver.findElement(By.id("log_password")).sendKeys("raghubn@123");
        driver.findElement(By.xpath("//input[contains(@name,'log_submit')]")).click();
        String title = driver.getTitle();
        System.out.println(title);

        driver.navigate().to("file:///Users/raghavendrabrn/LTI%20Selenium%20Samples/frame.html");
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/a")).click();
        driver.navigate().to("https://www.selenium.dev/");
        driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[3]/a/span")).click();
        Thread.sleep(5000);
        String title1 = driver.getTitle();
        System.out.println(title1);

        driver.navigate().to("file:///Users/raghavendrabrn/LTI%20Selenium%20Samples/frame.html");
        driver.switchTo().frame("My Store");
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        String title2 = driver.getTitle();
        System.out.println(title2);

        Thread.sleep(5000);
        driver.quit();
    }
}