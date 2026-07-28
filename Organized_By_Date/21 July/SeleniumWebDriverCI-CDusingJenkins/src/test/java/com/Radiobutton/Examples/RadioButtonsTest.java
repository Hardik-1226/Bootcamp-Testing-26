package com.Radiobutton.Examples;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

	public class RadioButtonsTest {

	    @Test
	    public void SpiceJet() throws Exception {

	        WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();

	        driver.get("https://www.spicejet.com/");
	        
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[@class='css-1dbjc4n r-1niwhzg r-1jgb5lz r-r0h9e2 r-13qz1uu']/div[@class='css-1dbjc4n r-14lw9ot']/div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-vgw6uq r-156q2ks r-11ict49 r-8uuktl r-136ojw6']/div[@class='css-1dbjc4n r-1pcd2l5 r-k8qxaj r-glunga r-bnwqim']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-glunga']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj']/div[6]/div[1]/div[1]/div[1]//*[name()='svg']//*[name()='circle' and contains(@cx,'9')]")).click();

	        Thread.sleep(5000);

	        driver.findElement(By.xpath("(//*[@name()='circle'])[10]")).click();

	        Thread.sleep(5000);

	        List<WebElement> circleElements =
	                driver.findElements(By.xpath("//*[@name()='circle']"));

	        // Print each button's details
	        System.out.println("=== RATIO BUTTONS DETAILS ===");

	        for (int i = 0; i < circleElements.size(); i++) {

	            WebElement element = circleElements.get(i);

	            System.out.println("Button " + (i + 1) + ":");
	            System.out.println(" - Tag: " + element.getTagName());
	            System.out.println(" - Displayed: " + element.isDisplayed());
	            System.out.println(" - Enabled: " + element.isEnabled());
	            System.out.println(" - Class: " + element.getAttribute("class"));
	            System.out.println(" - Role: " + element.getAttribute("role"));
	            System.out.println(" - Aria-checked: " + element.getAttribute("aria-checked"));

	            System.out.println("----------------------------------------");
	        }

	        driver.quit();
	    }
	}
	
	

