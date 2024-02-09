package com.fxoffice.testng;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fxoffice.ui.pages.WebDriverManager1;
import com.fxoffice.utility.ParameterService;

public class BaseUIStepDefinitions {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseUIStepDefinitions.class);
	private static String envType = null;
	public WebDriver driver;
	public WebDriverManager1 webDriverManager;

	@Before("@UI")
	public void before() throws Throwable { 
		LOGGER.info("This will run before each UI Test Scenario");
		ParameterService.clearParameters();
		/* Comment below code flow if executing in local and without using mvn command. */
		/*
		String currentTag = System.getProperty("tag");
		LOGGER.info("Current Running Scenario Tag : " + currentTag);
		String tag[] = currentTag.split(" ");
		if(tag[0].contains("Test") || tag[0].contains("Sandbox") || tag[0].contains("PROD"))
	    {
			LOGGER.info("Current Execution Environment : " + tag[0].replace("@", ""));
	    	 envType = tag[0].replace("@", "");
	    }
	    */
		/* Use below code if test need to be executed without mvn command. */
		envType = "QA3";
		LOGGER.info("Source Tag Name : " + envType);
		ParameterService.setParameter("Environment", envType);
		String browserName = "chrome";
		// String browserName = System.getProperty("browserName");
		LOGGER.info("Browser Name for execution : " + browserName);
		webDriverManager = new WebDriverManager1();
		driver = webDriverManager.getDriver(browserName);
	}

	@After("@UI")
	public void after(Scenario scenario) throws Throwable {
		LOGGER.info("Running After block.");
		clickLogoutBtn();
		webDriverManager.closeDriver(scenario);
	}

	private void clickLogoutBtn() throws InterruptedException {
		try {
				LOGGER.info("Clicking My Account Tab...!!! ");
				driver.switchTo().defaultContent();
				WebElement tabMyAccount = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabMyAccount);
				TimeUnit.SECONDS.sleep(5);
				LOGGER.info("Clicking Logout button...!!! ");
				WebElement btnLogout = driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnLogout);
		} catch(Exception e) {
				LOGGER.info("Running Catch block from Logout method. Exception occurred.");
				e.printStackTrace();
		}
	}

	/*
	 * @And("I Switch To New Window Session") public void set_NewWindowSession() {
	 * driver.switchTo().newWindow(WindowType.TAB); }
	 * 
	 * @And("I Switch Back To Parent Window Session") public void
	 * set_ParentWindowSession() {
	 * driver.switchTo().window(ParameterService.getParameter(
	 * "ParentWindowSessionID")); }
	 * 
	 * @And("I Switch Back To Child Window Session") public void
	 * set_ChildWindowSession() {
	 * driver.switchTo().window(ParameterService.getParameter("ChildWindowSessionID"
	 * )); }
	 * 
	 * @And("I Close Current Focused Window Session") public void
	 * set_CloseCurrentFocusedWindowSession() { driver.close();
	 * driver.switchTo().window(ParameterService.getParameter(
	 * "ParentWindowSessionID")); }
	 */

}
