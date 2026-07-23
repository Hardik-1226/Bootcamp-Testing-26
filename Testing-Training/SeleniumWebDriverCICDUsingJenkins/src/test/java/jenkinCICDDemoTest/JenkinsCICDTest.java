package jenkinCICDDemoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JenkinsCICDTest {

	   WebDriver driver;

	    @Test(priority = 0)
	    public void NavigateDemo() {

	        driver = new ChromeDriver();
	        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
	        String URL = driver.getCurrentUrl();
	        System.out.println(URL);

	        driver.quit();
	    }

	    @Test(priority = 1)
	    public void NavigateBackDemo() {

	        driver = new ChromeDriver();
	        driver.get("https://www.google.co.in");

	        String URL = driver.getCurrentUrl();
	        System.out.println(URL);

	        String Title = driver.getTitle();
	        System.out.println(Title);

	        driver.navigate().to("https://login.yahoo.com/");

	        URL = driver.getCurrentUrl();
	        System.out.println(URL);

	        driver.navigate().back();

	        URL = driver.getCurrentUrl();
	        System.out.println(URL);

	        driver.quit();
	    }

	    @Test(priority = 2)
	    public void RefreshMethod() {

	        driver = new ChromeDriver();

	        driver.get("https://www.google.co.in");

	        String URL = driver.getCurrentUrl();
	        System.out.println(URL);

	        driver.navigate().forward();
	        URL = driver.getCurrentUrl();
	        System.out.println(URL);

	    }
	}