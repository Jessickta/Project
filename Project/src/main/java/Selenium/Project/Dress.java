package Selenium.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dress {

	WebDriver driver;
	
	@FindBy (id = "bigpic")
	WebElement dressimage;
	
	public Dress(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	public boolean dressImage() {
		if (dressimage != null)
			return true;
		else
			return false;
	}
}
