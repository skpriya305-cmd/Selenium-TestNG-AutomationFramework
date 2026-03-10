package base;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	public WebDriver driver;
	protected static Logger logger = LogManager.getLogger(BaseTest.class);

	
	@BeforeMethod
	public void SetUp()
	{
		driver = new ChromeDriver();
        logger.info("Chrome browser launched");

		driver.manage().window().maximize();
		driver.get("https://payroll.razorpay.com/login");
        logger.info("Navigated to login page");

	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	
}
