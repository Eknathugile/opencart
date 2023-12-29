package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginClass extends BasePage{
	
	public LoginClass(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath="//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
	WebElement logintext;
	
	@FindBy (xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy (xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement loginbutton;
	
	@FindBy (xpath="//h6[contains(text(),'')]")
	WebElement dashboardtext;
	
	@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/i")
	WebElement logoutmenu;
	
	@FindBy (xpath="//a[contains(text(),'general.logout')]")
	WebElement clickLogout;
	
	
	public String logintext() {
		return logintext.getText();
		
	}
	
	public void username(String uname) {
		username.sendKeys(uname);
		
	}
	
	public void password(String pass) {
		password.sendKeys(pass);
		
	}
	
	public void loginbutton() {
		loginbutton.click();
		
	}
	
	public String dashboardtext() {
		return(dashboardtext.getText());
		
	}
	
	public void clickLogout() {
		 logoutmenu.click();
		clickLogout.click();
		
	}

	
	
}
