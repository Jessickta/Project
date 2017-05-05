package Selenium.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Selenium.Project.Home;
import Selenium.Project.Login;
import Selenium.Project.Account;

public class Scenario1 {

	//Logging into account to look at account information//
	
  	static ExtentReports report;
	static ExtentTest test;
	
	static WebDriver driver;
	
	static Home homepage;
	Login loginpage;
	Account accountpage;
	
	@Test(priority = 1, enabled = true)
	public void login() {
		
		report = new ExtentReports("C:\\Users\\Administrator\\workspace\\Project\\Reports\\automationreport.html", true);
		test = report.startTest("Verify Homepage Searchbar");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Chrome started");
		
		driver.get("http://automationpractice.com/index.php");
		homepage = new Home(driver);
		
		if ((homepage).search()) {
			test.log(LogStatus.PASS, "Verify Homepage Searchbar");
		} else {
			test.log(LogStatus.FAIL, "Verify Homepage Searchbar");
		}
		
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority = 2, enabled = true)
	public void loginpage() {
		
		test = report.startTest("Verify Login Page");
		homepage.clicklogin();
		loginpage = new Login(driver);
		
		if ((loginpage).createAccBtn()) {
			test.log(LogStatus.PASS, "Verify Login Page");
		} else {
			test.log(LogStatus.FAIL, "Verify Login Page");
		}
		
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority = 3, enabled = true)
	public void enterdetails() {
		
		test = report.startTest("Login to Account");
		loginpage.email.sendKeys("jt-ashley@hotmail.co.uk");
		loginpage.password.sendKeys("cheesecake");
		loginpage.signIn.click();
		
		accountpage = new Account(driver);
		
		if ((accountpage).info()) {
			test.log(LogStatus.PASS, "Login to Account");
		} else {
			test.log(LogStatus.FAIL, "Login to Account");
		}
		
		report.endTest(test);
		report.flush();
	}
	
	@AfterTest
	public void close() {
		
		try {
			driver.close();
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
