package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplyLeave extends BasePage {

	public ApplyLeave(WebDriver driver) {
		super(driver);
		
	}
	   
	
	@FindBy (xpath="//*[@class='oxd-icon-button oxd-main-menu-button']")
	WebElement menubutton;
	
	@FindBy (xpath="//button[@title='Apply Leave']")
	WebElement applyleavebtn;
	
	@FindBy (xpath=" //a[contains(text(),'Assign Leave')]/ancestor::li")
	WebElement assignleave;
	
	@FindBy (xpath="//input[@placeholder='Type for hints...']")
	WebElement entername;
	
	@FindBy (xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
	WebElement dropdown;
	
	@FindBy (xpath="//input[@class='oxd-input oxd-input--active' and @placeholder='yyyy-mm-dd'][1]")
	WebElement startdate;
	
	@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/div/div/input")
	WebElement enddate;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement assignbtn;
	
	public void menubutton() {
		menubutton.click();
		
	}
	
	public void applyleavebtn(){
		applyleavebtn.click();
		
	}
	
	public void assignleave(){
		assignleave.click();
		
	}
	
	
	public void entername(String uname) {
		entername.sendKeys(uname);
		
	}
	
	public void dropdown(String leavet) {
		dropdown.sendKeys(leavet);
		
	}
	
	public void startdate(String sdate) {
		startdate.sendKeys();
		
	}
	
	public void enddate(String edate) {
		enddate.sendKeys(edate);
		
	}
	
	public void  assignbtn(){
		 assignbtn.click();
		
	}
	 
}
