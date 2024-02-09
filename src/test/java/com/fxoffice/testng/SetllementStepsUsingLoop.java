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

public class SetllementStepsUsingLoop {
	

	
	
	
	WebDriver driver;
	LoginPage loginPage;
	SetllementPage setllementPage;
	
	static int page_num=1;
	
	@Parameters({"browser","date","operation","totalPage"})
	@Test
	public void handleSetllement(String brow,String tradeDate,String operation,String total_page) throws Exception {
		
		
		
		int total_num_page=Integer.parseInt(total_page);
		int i=1;
			while(i<total_num_page) {
			
				System.out.println("=i==>"+i);
				
				
				String[] userDetails= {
						"flevia3,Password@5",
						"flevia4,Password@5",
						/*"flevia5,Password@5",
						"flevia5,Password@5",
						"flevia5,Password@5"*/
						};
				
				for(String val:userDetails) {
					
					String[] userArr=val.split(",");
					//String page_num=userArr[0];
					String user=userArr[0];
					String pass=userArr[1];
		
					
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
					 
					 driver.get("https://qa2.swapstech.net/fxoffice/login");
					 https://fxuat3.firstcitizens.com/fxoffice/
					 //driver.get("https://qa3.finzly.net/fxoffice/login");
					 loginPage.setCredentialswithUserAndPass(user,pass); 
				     loginPage.clickLoginBtn();
				     
				     
					setllementPage.navigateSettlement();
				    setllementPage.settlements(operation,tradeDate,i);
				    
				    page_num=page_num+1;
					i=page_num;
				    
					driver.quit();
					
					
			
				}
		
			}
			    
		}
	
	
	
}
	
	