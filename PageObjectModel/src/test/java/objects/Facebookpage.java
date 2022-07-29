package objects;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Facebookpage {

	WebDriver driver;
	String url;
	

	public Facebookpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='email']") public WebElement username;
	@FindBy(xpath= "//input[@id='pass']") public WebElement password;
	@FindBy(name="login") public WebElement login_btn;
	@FindBy(tagName="a") public List<WebElement> aVals;


	public void enterUsername() {
		username.sendKeys("swamimadhumati@gmail.com");
	}
	public void enterPassword() {
		password.sendKeys("");
	}


	@SuppressWarnings("deprecation")
	public void clickOnLoginBtn() {
		
		
		System.out.println();
		login_btn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println(title);
		assertEquals(title, "Facebook – log in or sign up");
	}
}
