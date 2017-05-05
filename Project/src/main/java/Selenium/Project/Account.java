package Selenium.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Account {

	WebDriver driver;
	
	@FindBy(linkText = "My personal information")
	WebElement personalInfo;
	
	
	public Account(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	public boolean info() {
		if (personalInfo != null)
			return true;
		else
			return false;
		}
	
}
