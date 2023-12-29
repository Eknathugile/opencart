package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginClass;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_03LoginusingDDT extends BaseClass{

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	
	public void LoginDDT_test(String username ,String password, String exp) {
		
   LoginClass l= new LoginClass(driver);
		try {
		String text = l.logintext();
		logger.info("validate text");
		Assert.assertEquals(text, "Login");
		
		logger.info("enter user data");
		l.username(username);
		l.password(password);
		logger.info("user data entered succesfully");
		
		l.loginbutton();
		logger.info("Login button clicked");
		
		l.dashboardtext();
		logger.info("user logged in succesfully");
		
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
		LoginClass macc=new LoginClass(driver);
		String dashboardText = macc.dashboardtext();// this method is created MyAccountPage
		 try {
		if (exp.equals("valid")) {
			if (dashboardText == "Dashboard") {
				macc.clickLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

		if (exp.equals("invalid")) {
			if (dashboardText == "Dashboard") {
				LoginClass macc1=new LoginClass(driver);
				macc1.clickLogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}

	} 
	catch (Exception e) {
		Assert.fail();
	}
		 logger.info(" Finished TC_003_LoginDataDrivenTest");
	}

	}

