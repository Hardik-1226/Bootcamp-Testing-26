package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	public static WebDriver BrowserOptions(WebDriver driver, String browserName,String AppUrl) {

		if(browserName.equalsIgnoreCase("chrome")||browserName.equalsIgnoreCase("GC")||browserName.equalsIgnoreCase("Google Chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("Edge")||browserName.equalsIgnoreCase("eg")||browserName.equalsIgnoreCase("Microsoft Edge")) {
			driver=new EdgeDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("Firefox")||browserName.equalsIgnoreCase("FF")||browserName.equalsIgnoreCase("Mozilla Firefox")) {
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}else {
			System.out.println("Sorry we do not support this browser");
		}
		driver.manage().window().maximize();
		driver.get(AppUrl);
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
