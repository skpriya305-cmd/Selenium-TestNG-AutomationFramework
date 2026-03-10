package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.GenericUtils;

public class PayslipPage {
	
	WebDriver driver;
	
	By Payslip = By.xpath("//a[@to='https://payroll.razorpay.com/viewMyPayslips']");
	By Yeardropdown = By.tagName("select");
	
	By Salarycolumn = By.xpath("//table/tbody/tr/td[4]");
	
	
	public  PayslipPage (WebDriver driver)
	{
		this.driver=driver;
	}

	public void clickpayslippage() {
		
		driver.findElement(Payslip).click();
	}
	public void selectYear(String year) {
        GenericUtils.writeToReporterLogs("Selecting year");
        

		WebElement dropdown = driver.findElement(Yeardropdown);
		Select select = new Select(dropdown);
		select.selectByIndex(2);
	}
	
	public int minsalary()
	{
		List<WebElement> sal = driver.findElements(Salarycolumn);
		int minimumsalary = Integer.MAX_VALUE;
		for (WebElement salary : sal)
		{
			String salaryText = salary.getText().replace("₹", "").replace(",", "").trim();
			int value = Integer.parseInt(salaryText);
			if (value < minimumsalary)
			{
				minimumsalary = value;
			}
		}
		return minimumsalary;
		
	}
}
