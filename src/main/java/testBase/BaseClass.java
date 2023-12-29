package testBase;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger; 
	public ResourceBundle rb;
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		
		rb=ResourceBundle.getBundle("config");
		//logger=LogManager.getLogger(this.getClass());
		//ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		//WebDriverManager.edgedriver().setup();
		if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(br.equals("edge")){
			driver=new EdgeDriver();
		}
		else {
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.get(rb.getString("url"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		 driver.quit();
	}
	
	public String randomString() {
		String RandomString= RandomStringUtils.randomAlphabetic(5);
		return (RandomString);
		
	}
	
	public String randomInt() {
		String RandomInt= RandomStringUtils.randomNumeric(5);
		return (RandomInt);
		
	}
	
	public String randomAlphaNumeric() {
		String str= RandomStringUtils.randomAlphabetic(5);
		String num= RandomStringUtils.randomNumeric(5);
		return (str+"@"+num);
		
	}

	public String captureScreen(String name) {
		
		DateFormat timestamp=new  SimpleDateFormat("MM/yyyy",Locale.getDefault());
		
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "\\screenshots\\" + name + " "+timestamp+"_ .png";

			try {
				FileUtils.copyFile(source, new File(destination));
			} catch (Exception e) {
				e.getMessage();
			}
			return destination;

		}
		
		
	}

