package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static void capturedScreenShot(WebDriver driver,String screenShotName) {
        try { TakesScreenshot ts=(TakesScreenshot) driver;
      
      File source=ts.getScreenshotAs(OutputType.FILE);
      
			FileUtils.copyFile(source,new File("./Screenshot/"+screenShotName+".png"));
			System.out.println("Captured Screenshot - By selenium WebDriver");
		} catch (IOException e) {
			System.out.println("Exception while taken the screensot");
		}
	}

}
