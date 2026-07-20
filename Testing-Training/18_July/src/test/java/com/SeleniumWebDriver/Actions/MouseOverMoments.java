package com.SeleniumWebDriver.Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
public class MouseOverMoments {
	int linkCount;
    List<WebElement> list;

    @Test
    public void mouseover() throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.easycalculation.com/");

        WebElement ele = driver.findElement(By.xpath("//a[contains(.,'Others')]"));

        Actions act = new Actions(driver);
        act.moveToElement(ele).build().perform();

        list = driver.findElements(By.tagName("a"));

        System.out.println("Number of a links-" + list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
        }

        Thread.sleep(6000);

        WebElement ele2 = driver.findElement(By.xpath("//a[contains(.,'Download')]"));
        ele2.click();

        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }

}
