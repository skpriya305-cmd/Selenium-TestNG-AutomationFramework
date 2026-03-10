package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.GenericUtils;

public class LoginPage {
 
	WebDriver driver;
	
	By Username =  By.xpath("//input[@type='email']");
	By password = By.xpath("//input[@type='password']");
    By loginBtn = By.xpath("//button[@type='submit']");
    By profile = By.xpath("//p[contains( text(), 'PK')]");
    By Logout = By.xpath("//a[@href='/logout']");
    
    public LoginPage(WebDriver driver){
    	this.driver=driver;
    }
    
    public void enterUsername(String user) {
    	driver.findElement(Username).sendKeys(user);
    }
    public void EnterPassword(String pass) {
    	driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin() {
    	driver.findElement(loginBtn).click();
    }
    
    public void clickLogout() {
    	GenericUtils.waitForElementVisible(driver, profile);
    	driver.findElement(profile).click();
    	driver.findElement(Logout).click();
    }
	
	
}
