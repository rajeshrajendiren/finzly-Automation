package com.fxboss.ui.pages;



import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fxoffice.ui.pages.AbstractPage;

public class BossHomePage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(BossHomePage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;

	@FindBy(id = "FXOFFICE_ADMIN-btnInnerEl")
	private WebElement adminTab;

	@FindBy(id = "FXOFFICE_RELMGR_VIEW-textEl")
	private WebElement btnRelationshipManager;	


	@FindBy(id = "FXOFFICE_USER_ROLE_VIEW-textEl")
	private WebElement userRoleManagerMenu;

	@FindBy(xpath = "//span[text()='Logout']")
	private WebElement btnLogout;
	
	@FindBy(id = "FXOFFICE_COST_CENTER_VIEW-textEl")
	private WebElement btnCostCenters;
	
	//By pgAppPageLoadLocator = By.xpath("//div[contains(text(),'Payment Bulk File Exceptions')]/parent::div//button");

	//By feeAppPageLoadLocator = By.xpath("//button[@title='Add']");
	
	//By complainceAppPageLoadLocator = By.xpath("//a[contains(text(),' Screening')]");
	

	// Constructor
	
	public BossHomePage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Home Page of FXOffice Application.");
		driverWait.until(ExpectedConditions.titleContains("FX STAR"));
	}

	// Page Objects

	public void clickAdminTab() {
		LOGGER.info("Clicking Admin tab");
		waitForPageLoad(driver);
		clickElement(driver, adminTab);
	}

	public void clickRelationshipManagerButton() {
		LOGGER.info("Clicking Relationship Manager Button");
		waitForPageLoad(driver);
		clickElement(driver, btnRelationshipManager);
	}
	
	public void clickUserRoleManagerButton() {
		LOGGER.info("Clicking User Role Manager Button");
		waitForPageLoad(driver);
		clickElement(driver, userRoleManagerMenu);
	}
	
	
	public void clickCostCentersBtn() { 
		clickAdminTab();
		clickbtnCostCenters();	 
	}
	
	
	public void clickbtnCostCenters() {
		LOGGER.info("Clicking CostCenter tab");
	    clickElement(driver,btnCostCenters);
	}
	
	  
	public void clickbtnLogout() {
		 try {
					LOGGER.info("Clicking My Account Tab...!!! ");
					waitSeconds(1);
					driver.switchTo().defaultContent();
					
					WebElement tabMyAccount = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabMyAccount);
					TimeUnit.SECONDS.sleep(2);
					LOGGER.info("Clicking Logout button...!!! ");
					WebElement btnLogout = driver.findElement(By.xpath("//span[contains(text(),'Logout')]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", btnLogout);
			} catch(Exception e) {
					LOGGER.info("Running Catch block from Logout method. Exception occurred.");
					e.printStackTrace();
			}
		}
	
	

	// endregion : Page Objects

	public boolean verifyBossHomePage() throws InterruptedException {
		LOGGER.info("Checking for Home Page loading...!!! ");
		waitForPageLoad(driver);
		boolean flag = false;
		if (flag == false) {
			driverWait.until(ExpectedConditions.visibilityOf(adminTab));
			driverWait.until(ExpectedConditions.elementToBeClickable(adminTab));
			LOGGER.info("Home Page loaded successfully....!!!! ");
			flag = true;
		}
		return flag;
	}


	
	public void clickRelationshipManagerBtn() {
		clickAdminTab();
		clickRelationshipManagerButton();	
	}

	public void clickRelationshipManagertab() {
		clickAdminTab();
		clickRelationshipManagerButton();
	
		
	}


	
		
	

	
		
	}
 
	
	// endregion : Methods



