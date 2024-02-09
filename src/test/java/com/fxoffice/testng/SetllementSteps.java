package com.fxoffice.testng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.fxoffice.ui.pages.HomePage;
import com.fxoffice.ui.pages.LoginPage;
import com.fxoffice.ui.pages.SetllementPage;
import com.fxoffice.ui.pages.WebDriverManager1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetllementSteps { 
	 
	WebDriver driver; 
	LoginPage loginPage;
	SetllementPage setllementPage;
	
	@Parameters({"browser","username","password"})
	@BeforeTest
	public void setup(String brow,String user,String pass) throws Exception {
		
		if(brow.equals("chrome")) { 
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/OS_Windows/chromedriver.exe");
			driver = new ChromeDriver(options); 
		}else if(brow.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();  
			driver = new FirefoxDriver();
		}else {  
			 
		}
	
		
		
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
	
		
		
		 loginPage = new LoginPage(driver);
		 setllementPage = new SetllementPage(driver);
		 
		 driver.get("https://qa3.finzly.net/fxoffice/login");
		 //https:fxuat3.firstcitizens.com/fxoffice/
		 //driver.get("https://qa3.finzly.net/fxoffice/login");
		 loginPage.setCredentialswithUserAndPass(user,pass);
	     loginPage.clickLoginBtn();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();	 
	}
	
	@Parameters({"date","page","operation"})
    @Test
	public void authorizeSetllement(String tradeDate,String page_num,String operation) throws Exception {
			setllementPage.navigateSettlement();
	        setllementPage.settlementsOperation(operation,tradeDate,page_num);
	}	 
	
	/*@Parameters({"date","page"})
    @Test
	public void releaseSetllement(String tradeDate,String page_num) throws Exception {
			setllementPage.navigateSettlement();
			setllementPage.settlements("release",tradeDate,page_num);
	}*/ 
	
}
	
	