package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.PayslipPage;
import base.BaseTest;
import utils.ExcelUtils;
import utils.GenericUtils;

public class MainTest extends BaseTest{
	
    private static final Logger logger = LogManager.getLogger(MainTest.class);
    
	
	@Test	
	
	public void testLogin() throws IOException
	{
        logger.info("Starting Login Test");
		GenericUtils.applyImplicitWait(driver);

		LoginPage page = new LoginPage(driver);
		PayslipPage ps = new PayslipPage(driver);
	   


		String username = ExcelUtils.getCellData(1,0);
		String password = ExcelUtils.getCellData(1,1);
		
        page.enterUsername(username);
		page.EnterPassword(password);
		page.clickLogin();
		
		GenericUtils.writeToReporterLogs("********Login Succesful*******");
			
		ps.clickpayslippage();
        GenericUtils.writeToReporterLogs("Navigated to Payslip Page");
        logger.info("Payslip Page");

	    String year = ExcelUtils.getyear(3,0);

	    ps.selectYear(year);
	    int minsalary = ps.minsalary();
	    
        GenericUtils.writeToReporterLogs("Minimum Salary: " + minsalary);
        logger.info("Minimum Salary: " + minsalary);
        
        page.clickLogout();
        


	}
	

	

	

}
