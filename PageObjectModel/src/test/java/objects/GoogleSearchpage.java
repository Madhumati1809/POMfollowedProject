package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchpage {

	WebDriver driver;

	public GoogleSearchpage(WebDriver driver) {
		this.driver = driver;

	}

	By searchbox = By.xpath("//input[@name='q']");
	By searchBtn = By.xpath("(//input[@name=\"btnK\"])[1]");
	By Facebook_link = By.xpath("//a//h3[text()=\"Facebook - log in or sign up\"]");

	public void searchGoogle(String searchinput) {
		try {
			driver.findElement(searchbox).sendKeys(searchinput);
			driver.findElement(searchBtn).click();
		} catch (Exception e) {
			System.out.println("Exception caught "+ e.getMessage());
		}
	}

	public void clickOnFacebook() {
		try {
			driver.findElement(Facebook_link).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("exception caught "+e.getMessage());
		}
		
	}
}
