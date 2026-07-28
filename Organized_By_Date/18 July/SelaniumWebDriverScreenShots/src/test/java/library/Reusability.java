package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Reusability {

    public static void capturedScreenShot(WebDriver driver, String fileName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        File dest = new File("./ScreenShots/" + fileName + ".png");
        FileUtils.copyFile(src, dest);

        System.out.println("Screenshot saved: " + fileName);
    }
}