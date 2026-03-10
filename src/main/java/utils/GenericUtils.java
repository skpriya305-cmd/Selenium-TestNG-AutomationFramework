package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.helpers.Reporter;

public class GenericUtils {
	
public static void applyImplicitWait(WebDriver driver)
{
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}

public static void writeToReporterLogs(String message)
{
    Reporter.info(message);
}

public static WebElement waitForElementVisible(WebDriver driver, By locator)
{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

}



}
