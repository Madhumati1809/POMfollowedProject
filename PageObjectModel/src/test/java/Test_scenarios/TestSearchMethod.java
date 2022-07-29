package Test_scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.Facebookpage;
import objects.GoogleSearchpage;



public class TestSearchMethod {

	WebDriver driver;
	GoogleSearchpage objectGoogle;
	Facebookpage objectFacebook;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
	}
	
	@Test(priority = 0)
	public void search() {
		objectGoogle = new GoogleSearchpage(driver);
		objectGoogle.searchGoogle("facebook");
	}
	
	@Test(priority = 1)
	public void verifyFacebookLink()  {
		objectGoogle = new GoogleSearchpage(driver);
		objectGoogle.clickOnFacebook();
	
	}
	
	@Test(priority = 2)
	public void logintoFacebook()  {
		objectFacebook =new Facebookpage(driver);
		objectFacebook.enterUsername();
		objectFacebook.enterPassword();
		objectFacebook.clickOnLoginBtn();
	
	}
	

	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
