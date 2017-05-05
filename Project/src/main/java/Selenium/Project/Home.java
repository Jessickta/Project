package Selenium.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

	WebDriver driver;

	@FindBy(className = "login")
	WebElement loginBtn;

	@FindBy(xpath = "//*[@id=\"search_query_top\"]")
	WebElement searchbar;

	@FindBy(xpath = "//*[@id=\"home-page-tabs\"]/li[1]/a")
	WebElement popular;
	
	@FindBy(xpath = "//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[2]")
	WebElement dressLink;
	
	@FindBy(className = "shopping_cart")
	WebElement cart;

	@FindBy(className = "cat-title")
	WebElement cats;

	@FindBy(className = "menu-mobile-grover")
	WebElement women;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[3]/a")
	WebElement summer;

	public Home(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
	public void clicklogin() {
		driver.get(loginBtn.getAttribute("href"));
	}

	public boolean search() {
		if (searchbar != null)
			return true;
		else
			return false;
	}
	
	public boolean popularLink() {
		if (popular != null)
			return true;
		else
			return false;
	}
	
	public void clickmore() {
		driver.get(dressLink.getAttribute("href"));
	}
}
