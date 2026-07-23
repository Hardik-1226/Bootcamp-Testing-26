package utitlity;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver BrowserOptions(WebDriver driver, String browserName, String appURL) {

        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } 
        else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } 
        else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } 
        else {
            System.out.println("Browser not supported.");
            return null;
        }

        driver.manage().window().maximize();
        driver.get(appURL);

        return driver;
    }

    public static void quitBrowser(WebDriver driver) {

        if (driver != null) {
            driver.quit();
        }
    }
}