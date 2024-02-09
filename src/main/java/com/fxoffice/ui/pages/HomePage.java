package com.fxoffice.ui.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);
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
	
	@FindBy(xpath = "//span[text()='Galaxy Treasury']")
	private WebElement galaxyText;
	
	
	@FindBy(xpath="//span[contains(text(),'New Trade')]")
	private WebElement newTradeTab;
	
	@FindBy(xpath="//span[contains(text(),'Manage Trade')]")
	private WebElement manageTradeTab;
	
	@FindBy(xpath="//div[@class = 'inner-need-help-box']")
	private WebElement helpBox;
	
	@FindBy(xpath="//span[contains(text(),'BUSINESS BANKING')]")
	private WebElement buisnessBanking;
	
	@FindBy(xpath="//a[@id='beneficiaries']")
	private WebElement benificiaries;
	
	
	//By pgAppPageLoadLocator = By.xpath("//div[contains(text(),'Payment Bulk File Exceptions')]/parent::div//button");

	//By feeAppPageLoadLocator = By.xpath("//button[@title='Add']");
	
	//By complainceAppPageLoadLocator = By.xpath("//a[contains(text(),' Screening')]");
	

	// Constructor
	
	public HomePage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Home Page of FXOffice Application.");
		ExpectedCondition<Boolean> titleContainsCondition = webDriver ->
        webDriver.getTitle().contains("FX STAR") || webDriver.getTitle().contains("Galaxy Treasury");
		//driverWait.until(ExpectedConditions.titleContains(titleContainsCondition));
        driverWait.until(titleContainsCondition);
	}

	// Page Objects for FxOffice

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
	//Page Object For Boss Portal
	
	
	public void clickNewTradeTab() {
		LOGGER.info("Clicking New Trade");
		waitSeconds(5); 
		  WebElement closeIcon =driver.findElement(By.xpath("//i[contains(@class,'glyph-icon fa fa-times')]")); 
		  jsClick(driver, closeIcon);
		  //clickElement(driver, closeIcon);
		  waitSeconds(5);  
		  System.out.println("close done");
		jsClick(driver,newTradeTab);
		waitSeconds(5);
	}
	
	public void closeAnnouncementTab() {
		LOGGER.info("Clicking New Trade");
		waitSeconds(5); 
		  WebElement closeIcon =driver.findElement(By.xpath("//i[contains(@class,'glyph-icon fa fa-times')]")); 
		  jsClick(driver, closeIcon);

	}
	public void clickManageTradeTab() {
		LOGGER.info("Clicking Manage Trade Tab");
		  waitSeconds(5);  
		  System.out.println("close done");
		jsClick(driver,manageTradeTab);
		waitSeconds(5);
	}
	
	public void clickBeneficiariesTab() {
		LOGGER.info("Clicking Manage Trade Tab");
		  waitSeconds(5);  
		  System.out.println("close done");
		jsClick(driver,benificiaries);
		waitSeconds(5);
	}
	
	
	
	
	
	

	// endregion : Page Objects

	public boolean verifyHomePage() throws InterruptedException {
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


	
		
	
	public boolean verifyBossHomePage() throws InterruptedException {
		LOGGER.info("Checking for Home Page loading...!!! ");
		waitForPageLoad(driver);
		boolean flag = false;
		if (flag == false) {
			driverWait.until(ExpectedConditions.visibilityOf(galaxyText));
			LOGGER.info("Home Page loaded successfully....!!!! ");
			flag = true;
		}
		return flag;
	}
	//Methods for Boss

	
		
	}
 
	
	// endregion : Methods



