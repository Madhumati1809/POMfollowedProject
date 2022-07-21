package Test_scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.GoogleSearchpage;

public class TestSearchMethod {

	WebDriver driver;
	GoogleSearchpage objectRepo;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		
	}
	
	@Test
	public void search() {
		objectRepo = new GoogleSearchpage(driver);
		objectRepo.searchGoogle("facebook");
	}
	
	@Test
	public void verifyFacebookLink() {
		objectRepo = new GoogleSearchpage(driver);
		objectRepo.clickOnFacebook();
	}
	
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
