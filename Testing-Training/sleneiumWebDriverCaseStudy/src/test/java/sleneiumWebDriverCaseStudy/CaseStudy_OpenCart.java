package sleneiumWebDriverCaseStudy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CaseStudy_OpenCart {
	
	@Test
    public void validationTest() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.opencart.com/");

        // Login
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.id("input-email")).sendKeys("YOUR_EMAIL");
        driver.findElement(By.id("input-password")).sendKeys("YOUR_PASSWORD");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // Components
        driver.findElement(By.linkText("Components")).click();

        // Monitors
        driver.findElement(By.linkText("Monitors (2)")).click();

        // Show 25
        driver.findElement(By.id("input-limit")).click();
        driver.findElement(By.xpath("//select[@id='input-limit']/option[text()='25']")).click();

        // Add first monitor
        driver.findElement(By.xpath("(//button[@title='Add to Cart'])[1]")).click();

        // Apple Cinema 30
        driver.findElement(By.linkText("Apple Cinema 30\"")).click();

        // Specification
        driver.findElement(By.linkText("Specification")).click();

        // Verify specification
        Assert.assertTrue(driver.getPageSource().contains("Specification"));

        // Add to Wish List
        driver.findElement(By.xpath("//button[@data-original-title='Add to Wish List']")).click();

        // Verify success message
        String wishMsg = driver.findElement(By.cssSelector(".alert-success")).getText();

        Assert.assertTrue(wishMsg.contains("Success"));

        // Search Mobile
        WebElement search = driver.findElement(By.name("search"));
        search.clear();
        search.sendKeys("Mobile");

        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();

        // Search in descriptions
        driver.findElement(By.name("description")).click();

        driver.findElement(By.id("button-search")).click();

        // HTC Touch HD
        driver.findElement(By.linkText("HTC Touch HD")).click();

        // Quantity
        WebElement qty = driver.findElement(By.id("input-quantity"));
        qty.clear();
        qty.sendKeys("3");

        // Add to Cart
        driver.findElement(By.id("button-cart")).click();

        // Verify success
        String cartMsg = driver.findElement(By.cssSelector(".alert-success")).getText();

        Assert.assertTrue(cartMsg.contains("Success"));

        // View Cart
        driver.findElement(By.xpath("//span[text()='Shopping Cart']")).click();

        // Verify product
        Assert.assertTrue(driver.getPageSource().contains("HTC Touch HD"));

        // Checkout
        driver.findElement(By.linkText("Checkout")).click();

        // My Account
        driver.findElement(By.xpath("//span[text()='My Account']")).click();

        // Logout
        driver.findElement(By.linkText("Logout")).click();

        // Verify Logout
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Account Logout");

        // Continue
        driver.findElement(By.linkText("Continue")).click();

        driver.quit();
    }

}
