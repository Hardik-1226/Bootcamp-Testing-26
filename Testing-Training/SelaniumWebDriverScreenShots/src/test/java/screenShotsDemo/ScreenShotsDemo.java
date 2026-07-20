package screenShotsDemo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShotsDemo {

    public static void main(String[] args) throws Exception {
        Browser();
    }

    public static void Browser() throws IOException, InterruptedException {

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/campaign/landing.php");
        driver.manage().window().maximize();

        // Wait for 5 seconds
        Thread.sleep(5000);

        // Take Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Save Screenshot
        File destination = new File("./ScreenShots/FacebookPage.png");
        FileUtils.copyFile(source, destination);

        System.out.println("Screenshot captured successfully!");

        driver.quit();
    }
}