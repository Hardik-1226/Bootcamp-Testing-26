package com.NavigationCommand.Example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class navigation_demo {
//	@Test(priority = 0)
//	public void navigate() {
//		ChromeDriver driver=new ChromeDriver();
//		driver.navigate().to("https://google.com");
//		driver.navigate().back();
////		driver.navigate().forward();
////		driver.navigate().refresh();
//		driver.quit();
//	}
//	@Test(priority = 1)
//	public void navigate_with_back() {
//		ChromeDriver driver=new ChromeDriver();
//		driver.navigate().to("https://google.com");
//		String curr_url=driver.getCurrentUrl();
//		driver.navigate().back();
//		String after_back_url=driver.getCurrentUrl();
//		System.out.println("Url before back: "+curr_url);
//		System.out.println("Url after back: "+after_back_url);
//		driver.quit();
//	}
//	@Test(priority = 2)
//	public void navigate_with_forward() {
//		ChromeDriver driver=new ChromeDriver();
//		driver.navigate().to("https://testng.org/#_testng_documentation");
//		String curr_url=driver.getCurrentUrl();
//		driver.navigate().forward();
//		String after_url=driver.getCurrentUrl();
//		System.out.println("Url before forwarding: "+curr_url);
//		System.out.println("Url after forwarding: "+after_url);
//		driver.quit();
//		}
	
	@Test
	public void refreshMethod() {
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("https://testng.org/#_testng_documentation");
		String curr_url=driver.getCurrentUrl();
		driver.navigate().refresh();
		String new_url=driver.getCurrentUrl();
		if(curr_url.equals(new_url))
			System.out.println("Both url are equal");
		else {
			System.out.println("Both are not equal");
		}
		driver.quit();
	}
}
