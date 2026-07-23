package utitlity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

    public static String captureScreenshot(WebDriver driver) {

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String screenshotPath = System.getProperty("user.dir")
                + "/Screenshots/"
                + getCurrentDateTime()
                + ".png";

        try {
            FileUtils.copyFile(src, new File(screenshotPath));
            System.out.println("Screenshot captured: " + screenshotPath);
        } catch (IOException e) {
            System.out.println("Unable to capture screenshot: " + e.getMessage());
        }

        return screenshotPath;
    }

    public static String getCurrentDateTime() {

        Date date = new Date();

        SimpleDateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

        return customFormat.format(date);
    }
}