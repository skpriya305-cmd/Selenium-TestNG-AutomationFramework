package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class GenericUtils {
	
public static void applyImplicitWait(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}

public static void writeToReporterLogs(String message)
{
    Reporter.log(message);
}

public static WebElement waitForElementVisible(WebDriver driver, By locator)
{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

}

public static void TakeScreenshot(WebDriver driver, String test)
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(src, new File("screenshots/" + test + ".png"));
	}catch (IOException e)
	{
		e.printStackTrace();
	}

}

}
