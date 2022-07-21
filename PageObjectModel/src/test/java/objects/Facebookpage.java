package objects;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facebookpage {

	WebDriver driver;

	public Facebookpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']") public WebElement username;
	@FindBy(xpath= "//input[@id='pass']") public WebElement password;
	@FindBy(name="login") public WebElement login_btn;


	public void enterUsername() {
		username.sendKeys("swamimadhumati@gmail.com");
	}
	public void enterPassword() {
		password.sendKeys("Tatudi@123");
	}
	public void clickOnLoginBtn()  {
		login_btn.click();
		String title = driver.getTitle();
		System.out.println(title);
		assertEquals(title, "Facebook – log in or sign up");
	}
}
