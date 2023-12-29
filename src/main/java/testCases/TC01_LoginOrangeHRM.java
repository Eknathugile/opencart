package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.ApplyLeave;
import pageObjects.LoginClass;
import testBase.BaseClass;

public class TC01_LoginOrangeHRM extends BaseClass {
	public Logger logger; 
	@Test
	public void logintest()throws InterruptedException {
		
		logger=LogManager.getLogger(this.getClass());
		logger.info("Started TC01_LoginOrangeHRM");
		
		try {
		
		LoginClass l= new LoginClass(driver);
		logger.info("Login test case started****************");
		String text = l.logintext();
		logger.info("validate text");
		Assert.assertEquals(text, "Login");
		
		logger.info("enter user data");
		l.username(rb.getString("username"));
		l.password(rb.getString("password"));
		logger.info("user data entered sucessfully");
		
		l.loginbutton();
		logger.info("Login button clicked");
		
		l.dashboardtext();
		logger.info("user logged in sucessfully");
		
		logger.info("Login test case completed****************");
		
		logger.info("Apply Leave test case started****************");
		ApplyLeave a= new ApplyLeave(driver);
	
		a.menubutton();
		logger.info("MenuButton clicked");
		
		a.applyleavebtn();
		logger.info("ApplyLeaveButton Clicked");
		
		a.assignleave();
		logger.info("assignleave Button Clicked");
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
	}
	
}
