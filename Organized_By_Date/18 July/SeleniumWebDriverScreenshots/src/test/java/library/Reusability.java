package library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusability {

	public static void captureSS(WebDriver driver, String screenshotName) {
		
		try {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./ScreenShots/" + screenshotName + ".png"));
			System.out.println("Screenshot has been captured - by selenium WebDriver");
			
		} catch(Exception e) {
			System.out.println("Exception while taking Screenshot: " + e.getMessage());

		}
	}
	
}
