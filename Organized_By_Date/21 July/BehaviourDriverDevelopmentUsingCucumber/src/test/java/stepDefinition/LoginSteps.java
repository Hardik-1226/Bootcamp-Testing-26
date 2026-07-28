package stepDefinition;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginSteps {
	WebDriver driver;
	String url = "https://practicetestautomation.com/practice-test-login/";
	
	
	@Given("User Should Open Chrome Browser")
	public void user_should_open_chrome_browser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
				
	    // Write code here that turns the phrase above into concrete actions
		}

	@When("User Should enter Url in Browser")
	public void user_should_enter_url_in_browser(){
		
		driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
		
	    // Write code here that turns the phrase above into concrete actions
		}

	@When("User Should Navigate Homepage")
	public void user_should_navigate_homepage() {
		
		String HomePage = driver.getTitle();
		System.out.println(HomePage);
		
	    // Write code here that turns the phrase above into concrete actions
		}

	@When("User Enter Username and Password in Edit Box")
	public void user_enter_username_and_password_in_edit_box() {
		
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.id("password")).sendKeys("Password123");
		
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("Click On Login PushButton")
	public void click_on_login_push_button() {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.findElement(By.id("submit")).click();
		
	}

	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		
		
		
	}
}
