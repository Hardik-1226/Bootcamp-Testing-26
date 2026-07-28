package ParameterizationUsingCSVFile;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import Utility.CSVReaderUtility;

public class CSVRegistration {
	
	@Test
    public void RegisterUser() {

        List<String[]> users = CSVReaderUtility.getCSVData("/Users/arunima/Desktop/task_csv.UserDetails.csv");

        for (String[] user : users) {

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get("https://demo.opencart.com/");

            // Verify Title
            Assert.assertEquals(driver.getTitle(), "Your Store");

            // My Account
            driver.findElement(By.xpath("//span[text()='My Account']")).click();

            // Register
            driver.findElement(By.linkText("Register")).click();

            // Verify Heading
            Assert.assertTrue(driver.getPageSource().contains("Register Account"));

            // Fill Details
            driver.findElement(By.id("input-firstname")).sendKeys(user[0]);

            driver.findElement(By.id("input-lastname")).sendKeys(user[1]);

            driver.findElement(By.id("input-email")).sendKeys(user[2]);

            driver.findElement(By.id("input-telephone")).sendKeys(user[3]);

            driver.findElement(By.id("input-password")).sendKeys(user[4]);

            driver.findElement(By.id("input-confirm")).sendKeys(user[5]);

            // Privacy Policy
            driver.findElement(By.name("agree")).click();

            // Continue
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            // Verify Account Created
            Assert.assertTrue(driver.getPageSource().contains("Your Account Has Been Created"));

            driver.quit();
        }

    }

}
