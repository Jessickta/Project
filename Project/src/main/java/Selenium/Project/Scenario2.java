package Selenium.Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Selenium.Project.Home;

public class Scenario2 {

	//Viewing a featured item from the home page and purchasing this item//
	

  	static ExtentReports report;
	static ExtentTest test;
	
	static WebDriver driver;
	
	static Home homepage;
	static Dress dresspage;
	
	@Test(priority = 1, enabled = true)
	public void setUp() {
		
		report = new ExtentReports("C:\\Users\\Administrator\\workspace\\Project\\Reports\\Scenario2.html", true);
		test = report.startTest("Verify Popular Items Selected");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\SeleniumFiles\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Chrome started");
		
		driver.get("http://automationpractice.com/index.php");
		homepage = new Home(driver);
		
		if ((homepage).popularLink()) {
			test.log(LogStatus.PASS, "Verify Popular Items Selected");
		}
		else
			test.log(LogStatus.FAIL, "Verify Popular Items Selected");
	
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority = 2, enabled = true)
	public void dresspage() {
		
		test = report.startTest("Verify Navigation to Dress Page");
		homepage.clickmore();
		
		dresspage = new Dress(driver);
		
		if ((dresspage).dressImage()) {
			test.log(LogStatus.PASS, "Verify Navigation to Dress Page");
		}
		else
			test.log(LogStatus.FAIL, "Verify Navigation to Dress Page");

		report.endTest(test);
		report.flush();
		}
	
}
