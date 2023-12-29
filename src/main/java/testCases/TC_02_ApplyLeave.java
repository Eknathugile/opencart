package testCases;

import org.testng.annotations.Test;

import testBase.BaseClass;
import pageObjects.ApplyLeave;

public class TC_02_ApplyLeave extends BaseClass{

	      
	
	public void ApplyLeave() {
		
		
		logger.info("Apply Leave test case started****************");
		ApplyLeave a= new ApplyLeave(driver);
	
		a.menubutton();
		logger.info("MenuButton clicked");
		
		a.applyleavebtn();
		logger.info("ApplyLeaveButton Clicked");
		
		a.assignleave();
		logger.info("assignleave Button Clicked");
		
		a.entername(rb.getString("unam"));
		logger.info("name entered ");
		a.dropdown(rb.getString("leavet"));
		
		a.startdate(rb.getString("sdate"));
		
		a.enddate(rb.getString("edate"));
		
		logger.info("all data added");
		a.assignbtn();
		logger.info("AssignButton clicked and leave is assigned");
		logger.info("TC_02_ApplyLeave ended **************");
	}
}
