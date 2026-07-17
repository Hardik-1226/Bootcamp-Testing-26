/*
 * This class demonstrates Selenium WebElement commands such as clear(),
 * isDisplayed(), isEnabled(), isSelected(), getTagName(), and getAttribute()
 * using the EasyCalculation website and a checkbox demo page.
 */

package com.casestudy.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Utility.Example.helper;

public class WebElement_Commands_Demo {

    // Demonstrates the clear() method
    @Test(priority = 1)
    public void clearMethod() throws Exception {

        WebDriver driver = helper.startbrowser("Chrome");

        // Open EasyCalculation website
        driver.get("https://www.easycalculation.com/");

        // Navigate to BMI Calculator
        driver.findElement(By.linkText("BMI Calculator")).click();

        // Enter Height and Weight
        driver.findElement(By.name("height")).sendKeys("170");
        driver.findElement(By.name("weight")).sendKeys("65");

        Thread.sleep(2000);

        // Clear the entered values
        driver.findElement(By.name("height")).clear();
        driver.findElement(By.name("weight")).clear();

        Thread.sleep(2000);

        driver.quit();
    }

    // Demonstrates the isDisplayed() method
    @Test(priority = 2)
    public void isDisplayedMethod() {

        WebDriver driver = helper.startbrowser("Chrome");

        driver.get("https://www.easycalculation.com/");

        WebElement searchBox = driver.findElement(By.name("search"));

        System.out.println("Search Box Displayed : " + searchBox.isDisplayed());

        driver.quit();
    }

    // Demonstrates the isEnabled() method
    @Test(priority = 3)
    public void isEnabledMethod() {

        WebDriver driver = helper.startbrowser("Chrome");

        driver.get("https://www.easycalculation.com/");

        WebElement searchBox = driver.findElement(By.name("search"));

        System.out.println("Search Box Enabled : " + searchBox.isEnabled());

        driver.quit();
    }

    // Demonstrates the isSelected() method
    @Test(priority = 4)
    public void isSelectedMethod() {

        WebDriver driver = helper.startbrowser("Chrome");

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

        System.out.println("Before Selection : " + checkbox.isSelected());

        checkbox.click();

        System.out.println("After Selection : " + checkbox.isSelected());

        driver.quit();
    }

    // Demonstrates the getTagName() method
    @Test(priority = 5)
    public void getTagNameMethod() {

        WebDriver driver = helper.startbrowser("Chrome");

        driver.get("https://www.easycalculation.com/");

        WebElement searchBox = driver.findElement(By.name("search"));

        System.out.println("Tag Name : " + searchBox.getTagName());

        driver.quit();
    }

    // Demonstrates the getAttribute() method
    @Test(priority = 6)
    public void getAttributeMethod() {

        WebDriver driver = helper.startbrowser("Chrome");

        driver.get("https://www.easycalculation.com/");

        WebElement searchBox = driver.findElement(By.name("search"));

        System.out.println("Name Attribute : " + searchBox.getAttribute("name"));
        System.out.println("Type Attribute : " + searchBox.getAttribute("type"));
        System.out.println("Class Attribute : " + searchBox.getAttribute("class"));

        driver.quit();
    }
}