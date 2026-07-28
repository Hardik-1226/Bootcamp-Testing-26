package webdriver.commands;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class Browsercommands {
        @Test(priority=0)
        public void ChromeBrowserTest() {
        	ChromeDriver driver=new ChromeDriver();
        		driver.get("https://practicetestautomation.com/practice/");	
        		driver.manage().window().maximize();
        		
        		
        		String BrowserTitle=driver.getTitle();
        		System.out.println(BrowserTitle); 
        		
        		String BrowserURL=driver.getCurrentUrl();
        		System.out.println(BrowserURL);
        		
        		//String PageContent=driver.getPageSource();
        		//System.out.println(PageContent);
        		
        		if (BrowserTitle.equals("Practice | Practice Test Automation") || BrowserURL.equals("https://practicetestautomation.com/practice/") ) {
                    System.out.println("Pass");
                } else {
                    System.out.println("Fail");
                }
        		
        		driver.quit();
        }
        
        @Test(priority=2)
        public void FirefoxBrowserTest() {
        	
        	FirefoxDriver driver= new FirefoxDriver();
        	driver.get("https://www.selenium.dev/downloads/");
        	driver.manage().window().maximize();
        	
        	String BrowserTitle=driver.getTitle();
    		System.out.println(BrowserTitle);
    		
    		String BrowserURL=driver.getCurrentUrl();
    		System.out.println(BrowserURL);
    		
    		//String PageContent=driver.getPageSource();
    		//System.out.println(PageContent);
    		
    		
    		if (BrowserTitle.equals("Downloads | Selenium") || BrowserURL.equals("https://www.selenium.dev/downloads/") ) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
    		
    		driver.quit();
        	
        }
        
        @Test(priority=1)
        
        public void EdgeBrowserTest() { 
        	EdgeDriver driver = new EdgeDriver();
        	driver.get("https://mvnrepository.com/");
        	
        	String BrowserTitle=driver.getTitle();
    		System.out.println(BrowserTitle);
    		
    		String BrowserURL=driver.getCurrentUrl();
    		System.out.println(BrowserURL);
    		
    		//String PageContent=driver.getPageSource();
    		//System.out.println(PageContent);
    		
    		if (BrowserTitle.equals("Just a moment...") || BrowserURL.equals("https://mvnrepository.com/")) {
                System.out.println("Pass");
            } else {
                System.out.println("Fail");
            }
    		
    		driver.quit();
        	
        }
        
       
        
        
}
