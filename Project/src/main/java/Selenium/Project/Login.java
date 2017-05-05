package Selenium.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;
	
	@FindBy(id = "SubmitCreate")
	WebElement createaccount;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "passwd")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
	WebElement signIn;
	
	public Login(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	public boolean createAccBtn() {
		if (createaccount != null)
			return true;
		else
			return false;
	}
}