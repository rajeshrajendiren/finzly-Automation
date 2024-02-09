package com.fxoffice.ui.pages;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fxoffice.utility.ParameterService;

public class RelationshipManagerPage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(RelationshipManagerPage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;

	@FindBy(id = "FXOFFICE_ADMIN-btnInnerEl")
	private WebElement adminTab;

	@FindBy(id = "FXOFFICE_RELMGR_VIEW-textEl")
	private WebElement btnRelationshipManager;

	@FindBy(xpath = "//div[@id='Relationship Manager-body']//span[text()='New']")
	private WebElement btnNewRelationshipManager;
	
	@FindBy(xpath = "(//input[@name='userId'])[2]")
	private WebElement txtUserid;
	
	
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement clickSearchBtn;

	@FindBy(name = "userName")
	private WebElement txtUsername;

	@FindBy(xpath = "//label[text()='User Id:']/../..//input")
	private WebElement txtSearchUserid;
	
	@FindBy(xpath = "//label[text()='Cost Center:']/../..//input")
	private WebElement txtSearchCostCenter;
	
	
	@FindBy(xpath = "//span[text()='Yes']")
	private WebElement deleteConformBtn;
	

	@FindBy(xpath = "//label[text()='Type:']/parent::td/following-sibling::td//tr")
	private WebElement dropdownType;

	@FindBy(xpath = "//li[text()='RM']")
	private WebElement optionValueType;
	
	@FindBy(xpath = "(//span[text()='Save'])[2]")
	private WebElement clicksavebtn;

	@FindBy(xpath = "//li[text()='Originating Officer']")
	private WebElement optionOriginatingOfficerValueType;
	
	@FindBy(xpath = "(//input[@name='respCode'])[1]")
	private WebElement txtRespCode;
	
	@FindBy(xpath = "(//span[@role='img']/preceding::span[text()='Save'])[1]")
	private WebElement btnSave;

	@FindBy(xpath = "//span[text()='OK']/following-sibling::span")
	private WebElement btnOk;
	
	@FindBy(id = "FXOFFICE_COST_CENTER_VIEW-textEl")
	private WebElement btnCostCenters;
	
	@FindBy(xpath = "//div[@id='Cost Centers-body']//span[text()='New']")
	private WebElement btnNewCostCenters;
	
	@FindBy( xpath= "//input[@name='marketSector']")
	private WebElement txtMarketSector;
	
	@FindBy(xpath = "//input[@name='geographicRegion']")
	private WebElement txtGeographicRegion;
	
	@FindBy(xpath = "//input[@name='costCenter']")
	private WebElement txtCostCenter;
	
	@FindBy(xpath = "//span[text()='Update']")
	private WebElement btnUpdate;
	
	@FindBy(xpath = "//span[text()='Delete']")
	private WebElement btnDelete;
	
	@FindBy(xpath = "//span[text()='Update']")
	private WebElement btnUpdateforcostcenter; 
	
	@FindBy(xpath = "//span[text()='Save']/following-sibling::span")
	private WebElement btnSaveforcostcenter; 
	
	public static String userid="";

	//span[text()='OK']/following-sibling::span
	//By pgAppPageLoadLocator = By.xpath("//div[contains(text(),'Payment Bulk File Exceptions')]/parent::div//button");

	//By feeAppPageLoadLocator = By.xpath("//button[@title='Add']");
	
	//By complainceAppPageLoadLocator = By.xpath("//a[contains(text(),' Screening')]");
	

	// Constructor
	
	public RelationshipManagerPage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Home Page of FXOffice Application.");
		driverWait.until(ExpectedConditions.titleContains("FX STAR"));
	}

	// Page Objects

	public void clickAdminTab() {
		LOGGER.info("Clicking Admin tab");
	    clickElement(driver, adminTab);
	}

	public void clickRelationshipManagerButton() {
		LOGGER.info("Clicking Relationship Manager Button");
		clickElement(driver, btnRelationshipManager);
	}
	
	
	/*public void relationshipManagerButton() {
		LOGGER.info("searching Relationship Manager Button");
		clickElement(driver, searchbtnRelationshipManager);
	} */
	
	
	public void clickNewBtnFromRelationshipManagerTab() {
		LOGGER.info("Clicking New btn from Relationship Manager Tab");
		clickElement(driver,btnNewRelationshipManager);
	}
	
	public void setUserid(String userID) {
		LOGGER.info("Entering Userid : " + userID);
		enterText(driver, txtUserid, userID);
	}
    
	public void setUsername(String username) {
		LOGGER.info("Entering Username : " + username);
		enterText(driver, txtUsername, username);
	}
	
	public void setSearchInput(String userID) {
		LOGGER.info("Entering Userid : " + userID);
		enterText(driver, txtSearchUserid, userID);
	}
	
	public void setRMType(String type) throws InterruptedException {
		LOGGER.info("Select RM Type");
		clickElement(driver, dropdownType);
		TimeUnit.SECONDS.sleep(2);
		WebElement optionValueType=driver.findElement(By.xpath("//li[text()='"+type+"']"));
		clickElement(driver, optionValueType);
	}
	
	public void clickSaveButton() {
		LOGGER.info("Clicking Relationship Manager Button");
		jsClick(driver, clicksavebtn);
	}
	
	
	public void setOriginatingOfficerType() throws InterruptedException {
		LOGGER.info("Select Originating Officer Type");
		clickElement(driver, dropdownType);
		TimeUnit.SECONDS.sleep(2);
		clickElement(driver, optionOriginatingOfficerValueType);
	}
	
	public void setRespCode(String respcode) {
		LOGGER.info("Entering RespCode : " + respcode);
		enterText(driver, txtRespCode, respcode);	
	}
	
	public void clickSave() {
		LOGGER.info("Clicking Save btn");
		jsClick(driver, btnSave);
		// wait fr loading bar
	}
	
	public void clickOK() {
		LOGGER.info("Clicking OK btn");
		waitForPageLoadedByUsingElement(driver, btnOk);
		jsClick(driver, btnOk);
	}
	
	public void clickbtnCostCenters() {
		LOGGER.info("Clicking CostCenter tab");
	    clickElement(driver,btnCostCenters);
	}
	
	public void clickbtnbtnNewCostCenters() {
		LOGGER.info("Clicking New CostCenter tab");
	    clickElement(driver,btnNewCostCenters);
	}
	
	public void setMarketSector(String marketSector) { 
		LOGGER.info("Entering MarketSector : "  + marketSector);
		enterText(driver,txtMarketSector, marketSector);
	}

	public void setGeographicRegion(String geographicRegion) {
		LOGGER.info("Entering txtGeographicRegion : " + geographicRegion);
		enterText(driver,txtGeographicRegion, geographicRegion);
	}
	
	public void setCostCenter(String costCenter) {
		LOGGER.info("Entering txtCostCenter : " + costCenter);
		enterText(driver,txtCostCenter, costCenter);
	}
	
	public void btnUpdate() throws Exception {
		LOGGER.info("Clicking Update Button ");
		clickElement(driver,btnUpdate);
	}
	
	public void btnDelete() throws Exception {
		LOGGER.info("Clicking Update Button ");
		clickElement(driver,btnDelete);
	}
	
	// endregion : Page Objects

	// Methods(mutliple actions only)

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

	public void createAddRelationshipManager(String username,String type,String respcode) throws InterruptedException, IOException {
	
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 SimpleDateFormat sdf1 = new SimpleDateFormat("dd_MM_yyyy_HH.mm.ss");
	     String date=sdf1.format(timestamp);
	     
		userid="AUTO_RM_"+date;
		setUserid(userid);
		setUsername(username);
		setRMType(type);
		setRespCode(respcode);
		clickSave();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='UserId \""+userid+"\" added successfully!']")).isDisplayed();
		clickOK();
		
		}

		public void addLegalEntityManager(String username,String type,String respcode) throws InterruptedException, IOException {
		
			/*
			 * Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			 * SimpleDateFormat sdf1 = new SimpleDateFormat("dd_MM_yyyy_HH.mm.ss"); String
			 * date=sdf1.format(timestamp);
			 * userid="AUTO_RM_"+date;
			 */
			
			setUserid(username);
			setUsername(username);
			setRMType(type);
			setRespCode(respcode);
			clickSave();
			Thread.sleep(3000);
			WebElement userAddMsg=driver.findElement(By.xpath("//div[text()='UserId \""+username+"\" added successfully!']"));
			driverWait.until(ExpectedConditions.visibilityOf(userAddMsg));
			//driver.findElement(By.xpath("//div[text()='UserId \""+userid+"\" added successfully!']")).isDisplayed();
			userAddMsg.isDisplayed();
			clickOK();
		
		}
		
		public void updateLegalEntityManager(String username,String type,String respcode,String message) throws InterruptedException, IOException {
			
			setUsername(username);
			clickSave();
			Thread.sleep(5000);
			WebElement userAddMsg=driver.findElement(By.xpath("//div[text()='UserId \""+message+"\" updated successfully!']"));
			driverWait.until(ExpectedConditions.visibilityOf(userAddMsg));
			//driver.findElement(By.xpath("//div[text()='UserId \""+userid+"\" added successfully!']")).isDisplayed();
			userAddMsg.isDisplayed();
			clickOK();
		
		}
		
		public int verifyDeletedUser(String val) throws InterruptedException, IOException {
			Thread.sleep(5000);
			int count = driver.findElements(By.xpath("//div[text()='"+val+"']")).size();
			return count;
		}
		
		public void deleteUser() throws InterruptedException, IOException {
			//deleteConformBtn.click();
			jsClick(driver, deleteConformBtn);
		}
		
		public void searchRM(String username)
		{
			setSearchInput(username);
			jsClick(driver, clickSearchBtn);
		}
		
		public void searchCostCentre(String costnum) throws Exception
		{
			Thread.sleep(3000);
			txtSearchCostCenter.sendKeys(costnum);
			jsClick(driver, clickSearchBtn);
		} 
		
	public boolean verifyRMCreation(String type, String respcode) throws InterruptedException {
		LOGGER.info("Checking for RM Creation...!!! ");
		waitForPageLoad(driver);
		System.out.println("===>"+userid);
		System.out.println("===>"+"//div[text()='"+userid+"']/parent::td/following-sibling::td//div[text()='"+type+"']/parent::td/following-sibling::td//div[text()='"+respcode+"']");
		boolean flag = false;
		if (flag == false) {
			By rmCreationLocatorXPath = By.xpath("//div[text()='"+userid+"']/parent::td/following-sibling::td//div[text()='"+type+"']/parent::td/following-sibling::td//div[text()='"+respcode+"']");
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(rmCreationLocatorXPath));
			LOGGER.info("RM Created successfully....!!!! ");
			flag = true;
		}
		userid="";
		return flag;
	}
	
	public void createAddOriginatingOfficer(String userid, String username, String respcode) throws InterruptedException {
		setUserid(userid);
		setUsername(username);
		setOriginatingOfficerType();
		setRespCode(respcode);
		clickSave();
		clickOK();
	}
	
	public void clickCostCentersBtn() {
		clickAdminTab();
		clickbtnCostCenters();	
	}
	
	public void clickbtnNewCostCenters() {
		clickbtnbtnNewCostCenters();	
	}
	
	public void createAddcostCenter(String marketSector, String geographicRegion , String costCenter) throws InterruptedException {
		setMarketSector(marketSector);
		setGeographicRegion(geographicRegion);
		setCostCenter(costCenter);
		clickSave();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='CostCenter \""+costCenter+"\" added successfully!']")).isDisplayed();
		clickOK();
	}
	
	public void updateAddcostCenter(String marketSector, String geographicRegion , String costCenter) throws InterruptedException {
		setMarketSector(marketSector);
		setGeographicRegion(geographicRegion);
		setCostCenter(costCenter);
		clickSave();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='CostCenter \""+costCenter+"\" added successfully!']")).isDisplayed();
		clickOK();
	}
	
	public boolean verifyOriginatingOfficerCreation(String userid, String type, String respcode) throws InterruptedException {
		LOGGER.info("Checking for Originating Officer Creation...!!! ");
		waitForPageLoad(driver);
		boolean flag = false;
		if (flag == false) {
			By originatingOfficerCreationLocatorXPath = By.xpath("//div[text()='"+userid+"']/parent::td/following-sibling::td//div[text()='"+type+"']/parent::td/following-sibling::td//div[text()='"+respcode+"']");
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(originatingOfficerCreationLocatorXPath));
			LOGGER.info("Originating Officer Created successfully....!!!! ");
			flag = true;
		}
		return flag;
	}
		
	public boolean verifyCostCentersCreation(String marketSector, String geographicRegion , String costCenter) throws InterruptedException {
		LOGGER.info("Checking for Cost Centers Creation...!!! ");
		waitForPageLoad(driver);
		boolean flag = false;
		if (flag == false) {
			By CostCentersCreationLocatorXPath = By.xpath("//div[text()='"+costCenter+"']/parent::td/following-sibling::td//div[text()='"+marketSector+"']/parent::td/following-sibling::td//div[text()='"+geographicRegion+"']");
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(CostCentersCreationLocatorXPath));
			LOGGER.info("Cost Centers Created successfully....!!!! ");
			flag = true;
		}
		return flag;
	}
	

	
	public boolean verifyRMinList(String username,String type) throws InterruptedException {
		LOGGER.info("Checking for RM Creation...!!! ");
		waitForPageLoad(driver);
		System.out.println("===>"+userid);
		System.out.println("===>"+"//div[text()='"+username+"']/parent::td/following-sibling::td//div[text()='"+type+"']");
		boolean flag = false;
		if (flag == false) {
			By rmCreationLocatorXPath = By.xpath("//div[text()='"+username+"']/parent::td/following-sibling::td//div[text()='"+type+"']");
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(rmCreationLocatorXPath));
			LOGGER.info("RM Created successfully....!!!! ");
			flag = true;
		} 
		userid="";
		return flag; 
	} 
	

	public boolean verifyCostinList(String costnum) throws InterruptedException {
		LOGGER.info("Checking for RM Creation...!!! ");
		waitForPageLoad(driver);
		boolean flag = false;
		if (flag == false) {
			By rmCreationLocatorXPath = By.xpath("//div[text()='"+costnum+"']");
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(rmCreationLocatorXPath));
			LOGGER.info("Cost center updated successfully....!!!! ");
			flag = true;
		} 
		driver.findElement(By.xpath("//div[text()='"+costnum+"']")).isDisplayed();
		return flag;  
	} 
	

	public boolean edit(String costnum,String selector) throws InterruptedException {
		LOGGER.info("Checking for Costcenter Creation...!!! ");
		waitForPageLoad(driver);
		boolean flag = false;
		if (flag == false) {
			By rmCreationLocatorXPath = By.xpath("//div[text()='"+costnum+"']");
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(rmCreationLocatorXPath));
			flag = true;
		} 
		driver.findElement(By.xpath("//div[text()='"+costnum+"']")).click();
		jsClick(driver, btnUpdateforcostcenter);
		txtMarketSector.clear();
		txtMarketSector.sendKeys(selector); 
		jsClick(driver, btnSaveforcostcenter);
		clickOK();
		return flag; 
	}
	
	
	
	public void selectRM(String username,String type,String respCode) throws Exception {
	   LOGGER.info("Selecting RM ");
	   Thread.sleep(5000);
	   WebElement userAddMsg=driver.findElement(By.xpath("//div[text()='"+username+"']/parent::td/following-sibling::td//div[text()='"+type+"']/parent::td/following-sibling::td//div[text()='"+respCode+"']"));
		driverWait.until(ExpectedConditions.visibilityOf(userAddMsg)).click();
	}
	

	public void selecCostCenter(String costnum) throws Exception {
	   LOGGER.info("Selecting Cost center");
	   Thread.sleep(5000);
	   WebElement cost=driver.findElement(By.xpath("//div[text()='"+costnum+"']"));
		driverWait.until(ExpectedConditions.visibilityOf(cost)).click();
	}
		
	}
 
	
	// endregion : Methods


