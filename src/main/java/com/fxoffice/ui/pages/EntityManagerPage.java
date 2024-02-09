package com.fxoffice.ui.pages;

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

import io.cucumber.java.Scenario;

public class EntityManagerPage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(EntityManagerPage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver; 
	private WebDriverManager1 webDriverManager;

	@FindBy(id = "FXOFFICE_ENTITY_MANAGER-btnInnerEl")
	private WebElement entityManagerTab;
	
	@FindBy(id = "FXOFFICE_LEGAL_ENTITY_VIEW-textEl")
	private WebElement btnlegalEntities;

	@FindBy(xpath = "//span[text()='Add']/following-sibling::span")
	private WebElement btnAdd;
	
	@FindBy(xpath = "//span[contains(text(),'General')]")
	private WebElement btnGeneral;
	
	@FindBy(xpath = "(//label[contains(text(),'Legal Name')]/following::input)[1]")
	private WebElement txtLegalname;
	
	@FindBy(xpath = "(//input[@name='shortName'])[2]")
	private WebElement txtShortname;
	
	@FindBy(xpath = "(//label[contains(text(),'Processing Org')]/following::input)[1]")
	private WebElement dropdownProcessingOrg;
	
	@FindBy(xpath = "(//input[@name='entityType'])[2]")
	private WebElement dropdownEntityType;
	
   @FindBy(xpath = "//input[@name='relationshipManager']")
	private WebElement dropdownRelationshipManagerType;

	@FindBy(xpath = "//input[@name='originatingOfficer']")
	private WebElement dropdownOriginatingOfficerType;
	
	@FindBy(xpath = "//input[@name='costCenter']")
	private WebElement dropdownCostCenterType;
	
	@FindBy(xpath = "//input[@type='button']")
	private WebElement WebclientCheckBox;
	
	@FindBy(xpath = "(//input[@type='button'])[2]")
	private WebElement btncredit;
	
	@FindBy(xpath = "(//input[@type='button'])[3]")
	private WebElement btncash;
	
	@FindBy(xpath = "//label[text()='Customer Notes:']/following::textarea")
	private WebElement txtCustomerNotes;
	
	@FindBy(xpath = "(//span[text()='Address'])[2]")
	private WebElement btnAddress;
	
	@FindBy(xpath = "//input[@name='legalAddress.address1']")
	private WebElement txtAddress;
	
	@FindBy(xpath = "//input[@name='legalAddress.city']")
	private WebElement txtCity;
	
	@FindBy(xpath = "//input[@name='legalAddress.state']")
	private WebElement txtState;

	@FindBy(xpath = "//input[@name='legalAddress.postalCode']")
	private WebElement txtPostalcode;
	
	@FindBy(xpath = "//input[@name='legalAddress.country']")
	private WebElement dropdownCountry;
	
	@FindBy(xpath = "//span[text()='Save']/following-sibling::span")
	private WebElement btnSave1;
	
	@FindBy(xpath = "//span[text()='OK']/following-sibling::span")
	private WebElement btnOk;
	
	@FindBy(xpath = "(//label[text()='Short Name:']/following::input)[1]")
	private WebElement txtShortNameLeftside;
	
	@FindBy(xpath = "//input[@name='entityType']")
	private WebElement dropdownEntityTypeLeftside;

	@FindBy(xpath = "//div[@id='EntityManager-body']//span[text()='Search']/following-sibling::span")
	private WebElement clickSearchbtnLeftside;
	
	@FindBy(xpath = "//span[text()='Audit']/following-sibling::span")
	private WebElement dropdownAuditbutton;
	
	@FindBy(xpath = "(//span[text()='Audit']/following-sibling::span)[2]")
	private WebElement dropdownContactAuditbutton;
	
	@FindBy(xpath = "//span[text()='Record Audit']")
	private WebElement clickRecordAudit;
	
	@FindBy(xpath = "//span[contains(text(),'Detail')]/ancestor::div/following-sibling::div//div[contains(text(),'Credit limit for the client is initialized')]")
	private WebElement txtAuditASystemLog;
	
	@FindBy(xpath = "//span[contains(text(),'Detail')]/ancestor::div/following-sibling::div//div[contains(text(),'Legal Entity Corporate Automation4')]")
	private WebElement txtAuditBSystemLog;
	
	@FindBy(xpath = "//span[contains(text(),'Activities')]/parent::div/following-sibling::div[contains(@class,'x-tool')]/img")
	private WebElement btnCloseAuditPopup;
	
	@FindBy(xpath = "//span[contains(text(),'Field Audit')]/parent::div/following-sibling::div[contains(@class,'x-tool')]/img")
	private WebElement btnCloseFieldPopup;
	
	@FindBy(xpath = "//span[text()='Activities']")
	private WebElement legalEntitytableActivites;
	
	@FindBy(xpath = "//span[contains(text(),'Detail')]/ancestor::div/following-sibling::div//div[contains(text(),'added Legal Entity Corporate Automation1')]")
	private WebElement txtAuditActicitesSystemLog;
	
	@FindBy(xpath = "//span[contains(text(),'All Activities')]/parent::div/following-sibling::div[contains(@class,'x-tool')]/img")
    private WebElement btnCloseAuditActivitiesPopup;
	
	// Constructor 
	
	public EntityManagerPage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On EntityManager Page of FXOffice Application.");
		driverWait.until(ExpectedConditions.titleContains("FX STAR"));
	}

	// Page Objects

	public void clickEntityManagerTab() throws Exception {
		LOGGER.info("Clicking Entity Manager Tab");
		TimeUnit.SECONDS.sleep(5);
	   clickElement(driver, entityManagerTab);
	}

	public void clickLegalEntitiesButton() throws Exception {
		LOGGER.info("Clicking Legal Entities Button");
		TimeUnit.SECONDS.sleep(5);
		clickElement(driver, btnlegalEntities);
	}
	
	public void clickAddbuttonfromLegalEntities() {
		LOGGER.info("Clicking Add button from Legal Entities ");
		clickElement(driver,btnAdd);
	}
	
	public void clickGeneralbuttonfromlegalEntityPopup() {
		LOGGER.info("Clicking General button from legal Entity Popup ");
		clickElement(driver,btnGeneral); 
	} 
	
	public void setLegalname(String legalName) {
		LOGGER.info("Entering txtLegalname : " + legalName);
		enterText(driver, txtLegalname, legalName); 
	}
	
	public void setShortname(String shortName) throws InterruptedException {
		LOGGER.info("Entering txtShortname : " + shortName);
		enterText(driver,txtShortname, shortName); 
		TimeUnit.SECONDS.sleep(7); 
	}
    
	public void setProcessingOrg(String processingOrg) throws InterruptedException {
		LOGGER.info("Select processingOrg Type: " + processingOrg);
		clickElement(driver, dropdownProcessingOrg);
		TimeUnit.SECONDS.sleep(2);
		By setProcessingOrgLocator = By.xpath("//li[text()='"+processingOrg+"']");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(setProcessingOrgLocator)).click();
    }
	
	public void setEntityType(String entityType) throws InterruptedException {
		LOGGER.info("Select EntityType: " + entityType);
		clickElement(driver, dropdownEntityType);
		TimeUnit.SECONDS.sleep(2);
		By setEntityTypeLocator = By.xpath("//li[text()='"+entityType+"']");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(setEntityTypeLocator)).click();
    }
	
	public void setRelationshipManagerType(String relationshipManagerType) throws InterruptedException {
		LOGGER.info("Select RelationshipManagerType: " + relationshipManagerType);
		enterText(driver, dropdownRelationshipManagerType,relationshipManagerType);
		TimeUnit.SECONDS.sleep(2);
		By setRelationshipManagerTypeLocator = By.xpath("(//li[text()='"+relationshipManagerType+"'])[1]");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(setRelationshipManagerTypeLocator)).click();
    }
	
	public void setOriginatingOfficerType(String originatingOfficerType) throws InterruptedException {
		LOGGER.info("Select OriginatingOfficerType: " + originatingOfficerType);
		//enterText(driver, dropdownOriginatingOfficerType,originatingOfficerType);
		By setOriginatingOfficerTypeLocatorDropdown = By.xpath("//label[text()='Originating Officer:']/../..//div[@role='button']");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(setOriginatingOfficerTypeLocatorDropdown)).click();
        TimeUnit.SECONDS.sleep(5);
		By setOriginatingOfficerTypeLocator = By.xpath("//li[text()='"+originatingOfficerType+"']");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(setOriginatingOfficerTypeLocator)).click();
    }
	
	public void setCostCenterType(String costCenterType) throws InterruptedException {
		LOGGER.info("Select costCenterType: " + costCenterType);
		enterText(driver, dropdownCostCenterType,costCenterType);
		TimeUnit.SECONDS.sleep(4);
		By setCostCenterTypeLocator = By.xpath("//li[text()='"+costCenterType+"']");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(setCostCenterTypeLocator)).click();
    }
	
	public void WebclientCheckBox() {
		LOGGER.info("Clicking  WebclientCheckBox");
		driver.findElement(By.xpath("//input[@type='button']")).click();
	}
	
	public void btnCredit() {
		LOGGER.info("Clicking btncredit");
		jsClick(driver,btncredit);
	}
	
	public void btnCash() {
		LOGGER.info("Clicking btncredit");
		jsClick(driver,btncash);
	}
	
	public void txtCustomerNotes() {
		LOGGER.info("Clicking  txtCustomerNotes");
		driver.findElement(By.xpath("//label[text()='Customer Notes:']/following::textarea")).sendKeys("Automation Testing");
	}	
	
	
	public void clickAddressbuttonfromLegalEntitiesPopUp() {
		LOGGER.info("Clicking Address button from Legal Entities ");
		clickElement(driver,btnAddress);
	}

	public void setAddress(String address) throws InterruptedException {
		LOGGER.info("Entering txtAddress : " + address);
		enterText(driver,txtAddress, address);
		TimeUnit.SECONDS.sleep(2);
	}
	
	public void setCity(String city) throws InterruptedException {
		LOGGER.info("Entering txtCity : " + city);
		enterText(driver,txtCity, city);
		TimeUnit.SECONDS.sleep(2);
	}
	
	public void setState(String state) throws InterruptedException {
		LOGGER.info("Entering txtState : " + state);
		enterText(driver,txtState, state);
		TimeUnit.SECONDS.sleep(2);
	}
	
	public void setPostalcode(String postalcode) throws InterruptedException {
		LOGGER.info("Entering txtPostalcode : " + postalcode);
		enterText(driver,txtPostalcode, postalcode);
		TimeUnit.SECONDS.sleep(2);
	}

	public void setCountry(String country) throws InterruptedException {
		LOGGER.info("Entering txtCountry : " + country);
		enterText(driver,dropdownCountry, country);
		TimeUnit.SECONDS.sleep(3);
		By setCountryLocator = By.xpath("//span[text()='"+country+"']");
	    driverWait.until(ExpectedConditions.visibilityOfElementLocated(setCountryLocator)).click();
	}
	
	  public void clickSave1() throws InterruptedException {
			LOGGER.info("Clicking Save btn");
			jsClick(driver, btnSave1);
			TimeUnit.SECONDS.sleep(5);
		}
	
	public void clickOK() {
		LOGGER.info("Clicking OK btn");
		waitForPageLoadedByUsingElement(driver, btnOk);
		jsClick(driver, btnOk);
	}
	
	public void setShortNameleftside(String shortName) throws InterruptedException {
		LOGGER.info("Entering ShortNameLeftside : " + shortName);
		enterText(driver,txtShortNameLeftside, shortName);
		TimeUnit.SECONDS.sleep(5);
	}
	
    public void setEntityTypeleftside(String entityType) throws InterruptedException {
		LOGGER.info("Select EntityTypeLeftside: " + entityType);
		enterText(driver, dropdownEntityTypeLeftside, entityType);
		TimeUnit.SECONDS.sleep(2);
		By setEntityTypeleftsideLocator = By.xpath("//li[text()='"+entityType+"']");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(setEntityTypeleftsideLocator)).click();
    }

    public void clickSearchbtnLeftside() throws InterruptedException {
		LOGGER.info("Clicking Search btn");
		driverWait.until(ExpectedConditions.visibilityOf(clickSearchbtnLeftside));
		driverWait.until(ExpectedConditions.elementToBeClickable(clickSearchbtnLeftside));
		jsClick(driver, clickSearchbtnLeftside); 	
	}
	
    public void selectLE(String shortName,String entityType,String status) {
		LOGGER.info("Selecting LE");
		By leCreationLocatorXPath = By.xpath("//div[text()='"+shortName+"']//parent::td//following-sibling::td//div[text()='"+entityType+"']//parent::td//following-sibling::td//div[text()='"+status+"']");
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(leCreationLocatorXPath));
		driverWait.until(ExpectedConditions.elementToBeClickable(leCreationLocatorXPath)).click();
	} 
    
    public void clickAudit() {
		LOGGER.info("Clicking Audit");
        clickElement(driver, dropdownAuditbutton); 
	}
    
    public void clickContactAudit() {
		LOGGER.info("Clicking Contact Audit");
        clickElement(driver, dropdownContactAuditbutton); 
	}
    
    public void clickAuditOption(String option) throws InterruptedException {
  		LOGGER.info("Select Audit Option : " + option);
  		TimeUnit.SECONDS.sleep(5);
        By setAuditLocator = By.xpath("//span[text()='"+option+"']");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(setAuditLocator)).click();
     }
     
    public void clickContactAuditOption(String option) throws InterruptedException {
  		LOGGER.info("Select Audit Option : " + option);
  		TimeUnit.SECONDS.sleep(5);
        By setAuditLocator = By.xpath("//span[text()='"+option+"']");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(setAuditLocator)).click();
     }
     
 
	// endregion : Page Objects

	// Methods(mutliple actions only) 

	public boolean verifyHomePage() throws InterruptedException {
		LOGGER.info("Checking for Home Page loading...!!! ");
		waitForPageLoad(driver);
		boolean flag = false;
		if (flag == false) {
			driverWait.until(ExpectedConditions.visibilityOf(entityManagerTab));
			driverWait.until(ExpectedConditions.elementToBeClickable(entityManagerTab));
            LOGGER.info("Home Page loaded successfully....!!!! ");
			flag = true;
		}
		return flag;
	}
	
	public void clickBtnLegalEntities() throws Exception {
		clickEntityManagerTab();
		clickLegalEntitiesButton();	
	}
	
	public void createLegalEntityAddlegalEntityPopupforcredit(String legalName, String shortName, String processingOrg,String entityType,String Relation,String OriginatingOfficer,String costCenterType,String creditClient) throws InterruptedException {
		setLegalname(legalName); 
		setShortname(shortName);
		setProcessingOrg(processingOrg); 
		setEntityType(entityType);
		setRelationshipManagerType(Relation);
		setOriginatingOfficerType(OriginatingOfficer);
		setCostCenterType(costCenterType);
		btnCredit();
		/*if(creditClient.equals("CASH")) {
			btnCash();
		}else {} */
	}
	
	public void createLegalEntityAddlegalEntityPopupforcash(String legalName, String shortName, String processingOrg,String entityType,String Relation,String OriginatingOfficer,String costCenterType,String cashClient) throws InterruptedException {
		setLegalname(legalName); 
		setShortname(shortName);
		setProcessingOrg(processingOrg); 
		setEntityType(entityType);
		setRelationshipManagerType(Relation);
		setOriginatingOfficerType(OriginatingOfficer);
		setCostCenterType(costCenterType);
		btnCredit();
		/*if(creditClient.equals("CASH")) {
			btnCash();
		}else {} */
	}
	
   public void enterAddressfromLegalAddressTab(String address, String city, String state,String postalCode,String country) throws InterruptedException {
		setAddress(address);
		setCity(city);
	    setState(state);
	    setPostalcode(postalCode);
	    setCountry(country);
	    clickSave1();
	    clickOK();
	}
	

	
	public void enterdetailsLegalEntityBrowserletfside(String shortName, String entityType) throws InterruptedException {
		setShortNameleftside(shortName);
		setEntityTypeleftside(entityType);
	 }
	
	public boolean verifyLECreation(String shortName,String entityType,String status) throws InterruptedException {
		LOGGER.info("Checking for LE Creation...!!! ");
		boolean flag = false;
		if (flag == false) {
			By leCreationLocatorXPath = By.xpath("//div[text()='"+shortName+"']//parent::td//following-sibling::td//div[text()='"+entityType+"']//parent::td//following-sibling::td//div[text()='"+status+"']");
			driverWait.until(ExpectedConditions.visibilityOfElementLocated(leCreationLocatorXPath));
			LOGGER.info("LE Verified successfully....!!!! ");
			flag = true;
		}
		return flag;	
	}
	
	@SuppressWarnings("finally")
	public String verifyAuditLogs(String entityType, String legalName) throws InterruptedException {
	    	boolean flag = false;
	    	String text;
	    	
	    			LOGGER.info("Verifying Detail texts from Record Audit Popup");
			        By detailTextXPath = By.xpath("//span[contains(text(),'Detail')]/ancestor::div/following-sibling::div//div[contains(text(),'Legal Entity "+entityType+" "+legalName+"')]");
			        flag = driverWait.until(ExpectedConditions.visibilityOfElementLocated(detailTextXPath)).isDisplayed();
		            text = driver.findElement(By.xpath("//span[@class='x-header-text x-window-header-text x-window-header-text-default']/ancestor::div/following-sibling::div//*[contains(@id,'gridview')]/table")).getText();
		            System.out.println("text : " + text);
			        Thread.sleep(5000);
				    clickElement(driver, btnCloseAuditPopup);
				    return text;
			}
	
	public String verifyContactAuditLogs(String entityType, String legalName) throws InterruptedException {
    	boolean flag = false;
    	String text;
    	
    			LOGGER.info("Verifying Detail texts from Record Audit Popup");
		        By detailTextXPath = By.xpath("//div[contains(text(),'The added entitlements')]");
		        flag = driverWait.until(ExpectedConditions.visibilityOfElementLocated(detailTextXPath)).isDisplayed();
                text = driver.findElement(By.xpath("//span[@class='x-header-text x-window-header-text x-window-header-text-default']/ancestor::div/following-sibling::div//*[contains(@id,'gridview')]/table")).getText();
	            System.out.println("text : " + text);
		        Thread.sleep(5000);
			    clickElement(driver, btnCloseAuditPopup);
			    return text;
		
 }
	
	@SuppressWarnings("finally")
	public String verifyFieldLogs(String entityType, String legalName) throws InterruptedException {
	    	boolean flag = false;
	    	String text;
	    	
	    			LOGGER.info("Verifying Detail texts from Record Audit Popup");
			        text = driver.findElement(By.xpath("(//span[contains(text(),'Field Audit')])[2]/ancestor::div//tbody")).getText();
		            System.out.println("Field text : " + text);
			        TimeUnit.SECONDS.sleep(2);
				    clickElement(driver, btnCloseFieldPopup);
				    return text; 
 }
	
	@SuppressWarnings("finally")
	public String verifyFieldLogsRight(String entityType, String legalName) throws InterruptedException {
	    	boolean flag = false;
	    	String text;
	    	
	    			LOGGER.info("Verifying Detail texts from Record Audit Popup");
			        text = driver.findElement(By.xpath("(//span[contains(text(),'Field Audit')])[2]/ancestor::div//tbody")).getText();
		            System.out.println("Field text : " + text);
			        TimeUnit.SECONDS.sleep(2);
				    clickElement(driver, btnCloseFieldPopup);
				    return text;
 }
 
    @SuppressWarnings("finally")
	public String verifyAuditActivitiesLogs(String entityType, String legalName) throws InterruptedException {
	    	boolean flag = false;
	    	String text;
	    
	    			LOGGER.info("Verifying System Logs from Activities Popup");
	    			By detailTextXPath = By.xpath("//span[contains(text(),'Detail')]/ancestor::div/following-sibling::div//div[contains(text(),'Legal Entity "+entityType+" "+legalName+"')]");
					flag = driverWait.until(ExpectedConditions.visibilityOfElementLocated(detailTextXPath)).isDisplayed();
					text = driver.findElement(By.xpath("//span[@class='x-header-text x-window-header-text x-window-header-text-default']/ancestor::div/following-sibling::div//*[contains(@id,'gridview')]/table")).getText();
					System.out.println("text : " + text);
				    clickElement(driver, btnCloseAuditActivitiesPopup);
				    return text;
}  
	
	@SuppressWarnings("finally")
	public String verifyContactAuditActivitiesLogs(String entityType, String legalName) throws InterruptedException {
	    	boolean flag = false;
	    	String text;
	    
	    			LOGGER.info("Verifying System Logs from Activities Popup");
	                text = driver.findElement(By.xpath("//span[@class='x-header-text x-window-header-text x-window-header-text-default']/ancestor::div/following-sibling::div//*[contains(@id,'gridview')]/table")).getText();
					System.out.println("text : " + text);
				    clickElement(driver, btnCloseAuditActivitiesPopup);
		    return text;
	    	
	    } 
	
	
	@SuppressWarnings("finally")
	public String verifyFieldLogscontact(String entityType, String legalName) throws InterruptedException {
	    	boolean flag = false;
	    	String text;
	    	
	    			LOGGER.info("Verifying Detail texts from Record Audit Popup");
			      
			        By detailXPath = By.xpath("//span[@class='x-header-text x-window-header-text x-window-header-text-default']/ancestor::div/following-sibling::div//*[contains(@id,'gridview')]//tr[1]//td[1]");
	    			flag = driverWait.until(ExpectedConditions.visibilityOfElementLocated(detailXPath)).isDisplayed();
	    			text = driver.findElement(By.xpath("(//span[contains(text(),'Field Audit')])[2]/ancestor::div//tbody")).getText();
		            System.out.println("Field text : " + text);
			        TimeUnit.SECONDS.sleep(2);
				    clickElement(driver, btnCloseFieldPopup);
				    return text;
}
    
    public void closePopup() throws Exception {
    	
   }

}
		 
	
// endregion : Methods


