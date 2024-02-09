package com.fxoffice.ui.pages;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.common.io.Files;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManager1 {

	public static WebDriver driver;
	private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverManager1.class);
	public Properties defaultProp;
	
	public WebDriver getDriver(String browserName) throws MalformedURLException {
		driver = startDriver(browserName, 120);
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void closeDriver(Scenario scenario) throws Throwable {
		if (driver != null) {
			try {
				LOGGER.info("Trying to quit the WebDriver (" + driver.getTitle() + ")");
				LOGGER.info("--------------------------------------------------------");
				takeScreenShot(scenario);
				driver.close();
				driver.quit();
			} catch (Exception ex) {
				LOGGER.info("Error when quitting the WebDriver: " + ex.getMessage());
				LOGGER.info("-----------------------------------------------------");
				driver.quit();
			}
		}
	}

	public void takeScreenShot(Scenario scenario) throws Exception {
		LOGGER.info("Scenario Status" + scenario.getStatus());
		System.out.println("Scenario Status" + scenario.getStatus());
		String status = scenario.getStatus().toString().trim();
	
	if (scenario.isFailed() || status.contains("PASSED")) {
		System.out.println("Scenario Status");
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		screenshotName = scenario.getName()+timeStamp;
		LOGGER.info(screenshotName+"  screenshotName");
		System.out.println("screenshotName" + screenshotName);
		try {
			File directory = new File("test-output/Screenshots");
			FileUtils.forceMkdir(directory);
			
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// scenario.embed(screenshot, "image/png");
			
			String workingDir = System.getProperty("user.dir");
			String defaultAssetPath = workingDir+"/test-output/Screenshots/"+screenshotName+".png";

			File destinationPath = new File(defaultAssetPath);
			Files.copy(sourcePath, destinationPath);
		} catch (IOException e) {
		} 
	  }
	}	
	
	/*
	 *  Set parameters for the webDriver
	*/

	private WebDriver startDriver(String browserName, int timeout) throws MalformedURLException {
		
		String operatingsys = System.getProperty("os.name");
		System.out.println("Operating System found "+operatingsys);
		
		switch (browserName) {
        case "chrome":
        				if (operatingsys.contains("Windows"))
        				{
        					ChromeOptions options = new ChromeOptions();
        					//options.addArguments("--no-sandbox");
        				//	options.addArguments("disable-infobars");
        				//	options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        				//	options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        				//	options.addArguments("disable-infobars");
        					options.addArguments("--remote-allow-origins=*");
        				//	options.addArguments("ignore-certificate-errors"); 
        					System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/OS_Windows/chromedriver.exe");
        					//WebDriverManager.chromedriver().browserVersion("118.0.5993.118").setup();
        					driver = new ChromeDriver(options); 
        					//WebDriverManager.firefoxdriver().setup();
        					//driver = new FirefoxDriver();
        					driver.manage().window().maximize();
        					driver.manage().deleteAllCookies();
        					driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(120));
        					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
        				}else if(operatingsys.contains("Linux"))
        				{
        					System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
     					   
    				        //create object of chrome options
    				        ChromeOptions options = new ChromeOptions();
    				        options.addArguments("headless");
    				        options.addArguments("--disable-gpu");
    				        options.addArguments("disable-infobars");
    				    	options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        					options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        			        options.addArguments("--disable-extensions");
    				        options.addArguments("window-size=1200x600");
    				        options.addArguments("--no-sandbox");
    				        driver = new ChromeDriver(options);
    				    	driver.manage().window().maximize();
        					driver.manage().deleteAllCookies();
        					driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(120));
        					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
        			
        				}
        				break;

        case "firefox":
        				driver = new FirefoxDriver();
        				
        				break;

        case "ie":
        				driver = new InternetExplorerDriver();
        				break;

        
        default:
          break;
      }
		
		/*if(browserName.equals("chrome")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("disable-infobars");
			options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.addArguments("disable-infobars");
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/OS_Windows/chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(120));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
		}*/
		return driver;
	}

}