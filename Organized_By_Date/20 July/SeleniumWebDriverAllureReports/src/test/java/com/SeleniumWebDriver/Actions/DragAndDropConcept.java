package com.SeleniumWebDriver.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("http://jqueryui.com/droppable/");
        Thread.sleep(4000);

        driver.switchTo().frame(0); // switch to frame if its present

        Actions action = new Actions(driver);

        action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
              .moveToElement(driver.findElement(By.xpath("//*[@id='droppable']")))
              .release()
              .build()
              .perform();
    }
}