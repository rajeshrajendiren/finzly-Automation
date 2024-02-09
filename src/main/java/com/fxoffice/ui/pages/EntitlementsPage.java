package com.fxoffice.ui.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.Scenario;

public class EntitlementsPage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(EntitlementsPage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;

	@FindBy(xpath = "//span[text()='Entitlements']/following-sibling::span")
	private WebElement clickentitlementsButton;

	// @FindBy(xpath= "//span[text()='AutomationLE1 Permissions']")
	// private WebElement AutomationLE1Permissions;

	@FindBy(xpath = "(//table[@class='x-container x-form-fieldcontainer x-table-plain x-form-item x-box-item x-container-default x-hbox-form-item'])[1]//ul/li")
	private WebElement clickActiveNotificationPreference;

	@FindBy(xpath = "//span[@class='x-btn-icon-el x-form-itemselector-add ']")
	private WebElement clickAddtoSelected;
	
	@FindBy(xpath = "(//table[@class='x-container x-form-fieldcontainer x-table-plain x-form-item x-box-item x-container-default x-hbox-form-item'])[2]//ul/li")
	private WebElement clickRightToLeftDataPreference;
	
	@FindBy(xpath = "//span[@class='x-btn-icon-el x-form-itemselector-remove ']")
	private WebElement clickRemovetoSelected;
	
	@FindBy(xpath = "//span[text()='Save']/following-sibling::span")
	private WebElement clickSave;
	
	@FindBy(xpath = "//span[text()='OK']/following-sibling::span")
	private WebElement clickokbtn;
	
	@FindBy(xpath = "//span[text()='Edit']") 
	private WebElement clickEditbtn;
	
	@FindBy(xpath = "//span[text()='Activate']") 
	private WebElement clickActivateLE;

	@FindBy(xpath = "//span[text()='Yes']") 
	private WebElement clickOkPopup;
	
	// @FindBy(xpath = "//li[text()='Boss Bill Pay Module']")
	// private WebElement clickBossBillPayModule;
    @FindBy(xpath = "//span[text()='Contacts']/following-sibling::span") 
	private WebElement clickContact;
	
	@FindBy(xpath = "(//span[text()='Add']/following-sibling::span)[2]")
	private  WebElement clickAdd;
	  
	@FindBy(xpath = "(//label[contains(text(),'First Name')]/following::input)[1]")
	private WebElement txtFirstName;
	  
	@FindBy(xpath = "(//label[contains(text(),'Last Name')]/following::input)[1]")
	private  WebElement txtLastname;
	
	@FindBy(xpath = "(//label[contains(text(),'User Id (FXWeb Login Id)')]/following::input)[1]")
	private  WebElement txtUserId;
	
	@FindBy(xpath = "//input[@type='password']")
	private  WebElement txtPassword;
	 
	@FindBy(xpath = "(//label[contains(text(),'Email Address')]/following::input)[1]")
	private WebElement txtEmailAddress;
	  
	@FindBy(xpath = "(//label[contains(text(),'Phone Number')]/following::input)[1]")
	private WebElement txtPhoneNumber;
	
	@FindBy(xpath = "(//label[contains(text(),'Cell Phone')]/following::input)[1]")
	private WebElement txtCellNumber;
	  
	@FindBy(xpath = "//span[text()='Save']/following-sibling::span") 
	private WebElement clickSavebtn;
	 
	@FindBy(xpath = "(//img[@role='presentation'])[3]") 
	private WebElement clickClosebtn;
	
	@FindBy(xpath = "//span[text()='Activate']/following-sibling::span") 
	private WebElement clickActivatebtn;
	
    @FindBy(xpath = "//span[contains(text(),'All Activities')]/parent::div/following-sibling::div[contains(@class,'x-tool')]/img")
    private WebElement btnCloseAuditActivitiesPopup;
    
    @FindBy(xpath = "//span[text()='Yes']/following-sibling::span") 
	private WebElement clickYesbtn;
	
    @FindBy(xpath = "(//img[@role='presentation'])[3]") 
  	private WebElement closebtn;
    
    @FindBy(xpath = "(//span[text()='Entitlements']/following-sibling::span)[2]") 
  	private WebElement  clickEntitlementsforcontact;
	
	// Constructor

	public EntitlementsPage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Home Page of FXOffice Application.");
		driverWait.until(ExpectedConditions.titleContains("FX STAR"));
	}

	// Page Objects
 
	public void clickentitlementsButton() {
		LOGGER.info("Clicking Entitlements Tab");
		jsClick(driver, clickentitlementsButton);
	}

	public void clickActiveNotificationPreference() throws AWTException, InterruptedException {
		Thread.sleep(5000);
		LOGGER.info("Clicking Active Notification Preference Button");
		clickElement(driver, clickActiveNotificationPreference);
		WebElement key_down = driver.findElement(By.xpath(
				"(//table[@class='x-container x-form-fieldcontainer x-table-plain x-form-item x-box-item x-container-default x-hbox-form-item'])[1]//ul/li"));
		clickElement(driver, key_down);
		Robot r = new Robot();
		Actions actions = new Actions(driver);
		List<WebElement> Entitlements_List = driver.findElements(By.xpath(
				"(//table[@class='x-container x-form-fieldcontainer x-table-plain x-form-item x-box-item x-container-default x-hbox-form-item'])[1]//ul/li"));
		for (int i = 1; i < Entitlements_List.size(); i++) {
			actions.keyDown(Keys.LEFT_CONTROL).click(Entitlements_List.get(i)).build().perform();
			scrollIntoView(driver,Entitlements_List.get(i));
			Thread.sleep(1000);
	   }
	}

	public void clickAddtoSelected() {
		LOGGER.info("Clicking AddtoSelected");
		clickElement(driver, clickAddtoSelected);
	}
	
	public void clickRightToLeftDataPreference() throws AWTException {
		LOGGER.info("Clicking Active Notification Preference Button");
		clickElement(driver, clickRightToLeftDataPreference);
		WebElement key_down = driver.findElement(By.xpath(
				"(//table[@class='x-container x-form-fieldcontainer x-table-plain x-form-item x-box-item x-container-default x-hbox-form-item'])[2]//ul/li"));
		clickElement(driver, key_down);
	    Robot r = new Robot();
		Actions actions = new Actions(driver);
	    List<WebElement> Entitlements_List = driver.findElements(By.xpath(
				"(//table[@class='x-container x-form-fieldcontainer x-table-plain x-form-item x-box-item x-container-default x-hbox-form-item'])[2]//ul/li"));
		for (int i = 1; i < Entitlements_List.size(); i++) {
			
			actions.keyDown(Keys.LEFT_CONTROL).click(Entitlements_List.get(i)).build().perform();
			scrollIntoView(driver,Entitlements_List.get(i));
			}
		}
	
	public void clickRemovetoSelectedBtn() {
		LOGGER.info("Clicking AddtoSelected");
		clickElement(driver, clickRemovetoSelected);
	}
	
	public void clickSave() throws Exception {
		LOGGER.info("Clicking Save button");
		Thread.sleep(5000);
		jsClick(driver, clickSave);
	}
	
	public void clickokbtn() {
		LOGGER.info("Clicking Save button");
		clickElement(driver, clickokbtn);
	}
 
	public void clickEditbtn() {
		LOGGER.info("Clicking Edit button");
		jsClick(driver, clickEditbtn);
	}
	
	public void clickActivateLE() {
		LOGGER.info("Clicking Edit button");
		jsClick(driver, clickActivateLE);
		jsClick(driver, clickOkPopup);
	}
	

	 
    public void clickContact() { 
       LOGGER.info("Clicking Contact Button");
       clickElement(driver, clickContact); 
    }
 
    public void clickAdd() throws InterruptedException { 
       LOGGER.info("Clicking Add Button");
       jsClick(driver, clickAdd); 
       Thread.sleep(5000);
    }
 
    public void setFirstName(String firstName) {
       LOGGER.info("Entering txtFirstName : " + firstName); 
       enterText(driver, txtFirstName, firstName);
    }
 
    public void setLastname(String lastname) {
       LOGGER.info("Entering txtLastname : " + lastname); 
       enterText(driver,txtLastname, lastname); 
    }
    
    public void setUserId(String userId) {
        LOGGER.info("Entering txtUserId : " + userId); 
        enterText(driver,txtUserId, userId); 
    }
    
    public void setPassword(String password) {
        LOGGER.info("Entering txtPassword : " + password); 
        enterText(driver,txtPassword, password); 
    }
 
    public void setEmailAddress(String emailAddress) {
        LOGGER.info("Entering txtEmailAddress : " + emailAddress);
        enterText(driver,txtEmailAddress, emailAddress);
    }
  
    public void setPhoneNumber(String phoneNumber) {
        LOGGER.info("Entering txtPhoneNumber : " + phoneNumber); 
        enterText(driver,txtPhoneNumber, phoneNumber); 
    }
    
    public void setCellNumber(String cellNumber) {
        LOGGER.info("Entering txtCellNumber : " + cellNumber); 
        enterText(driver,txtCellNumber, cellNumber); 
    }
 
    public void clickSavebtn() throws InterruptedException { 
    	LOGGER.info("Clicking Save Button");
        clickElement(driver, clickSavebtn); 
        Thread.sleep(5000);
    }
    public void clickClosebtn()throws InterruptedException {  
        LOGGER.info("Clicking Close button Popup");
        Thread.sleep(7000);
        clickElement(driver, clickClosebtn);
        //Thread.sleep(5000);
     }
    
    public void selectContact(String userId,String firstName,String lastname,String emailAddress,String phoneNumber,String status) throws Exception {
		LOGGER.info("Selecting Contact");
		Thread.sleep(5000);
	    By contactCreationXPath = By.xpath("//div[text()='"+userId+"']//parent::td//following-sibling::td//div[text()='"+firstName+"']//parent::td//following-sibling::td//div[text()='"+lastname+"']//parent::td//following-sibling::td//div[text()='"+status+"']");
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(contactCreationXPath));
		driverWait.until(ExpectedConditions.elementToBeClickable(contactCreationXPath)).click();
	
    } 
    

	public void clickEntitlementsforcontact() {
		LOGGER.info("Clicking Entitlements Tab");
		jsClick(driver, clickEntitlementsforcontact);
	}
    
    public void clickActivatebtn() throws InterruptedException { 
        LOGGER.info("Clicking Activate Button");
        jsClick(driver, clickActivatebtn); 
        Thread.sleep(5000);
     }
 
    public void clickYesbtn() throws InterruptedException { 
        LOGGER.info("Clicking Yes Button");
        clickElement(driver, clickYesbtn); 
        Thread.sleep(5000);
     }
    
    public void closebtn() throws InterruptedException { 
        LOGGER.info("Clicking Yes Button");
        clickElement(driver, closebtn); 
        Thread.sleep(5000);
     }

  // endregion : Page Objects
  
  // Methods(mutliple actions only)
 
     public void addDetailsforContacts(String firstName, String lastname,String userId, String password, String emailAddress,String phoneNumber, String cellNumber) throws InterruptedException {
    	  setFirstName(firstName); 
    	  setLastname(lastname);
    	  setUserId(userId);
    	  setPassword(password);
    	  setEmailAddress(emailAddress); 
    	  setPhoneNumber(phoneNumber);
    	  setCellNumber(cellNumber);
    	  clickSavebtn();
   }
     
     public boolean verifyContactCreation(String userId,String firstName,String lastname,String emailAddress,String phoneNumber,String status) throws InterruptedException {
 		LOGGER.info("Checking for Contact Creation...!!! ");
 		boolean flag = false;
 		if (flag == false) {
 			By contactCreationXPath = By.xpath("//div[text()='"+userId+"']//parent::td//following-sibling::td//div[text()='"+firstName+"']//parent::td//following-sibling::td//div[text()='"+lastname+"']//parent::td//following-sibling::td//div[text()='"+emailAddress+"']//parent::td//following-sibling::td//parent::td//following-sibling::td//div[text()='"+status+"']");
 			driverWait.until(ExpectedConditions.visibilityOfElementLocated(contactCreationXPath));
 			LOGGER.info("Contact Created Verified successfully....!!!! ");
 			flag = true;
 		}
 		return flag;	
 	}
     
     @SuppressWarnings("finally")
    	public boolean verifyAuditEntitlementActivitiesLogs(String entityType, String legalName) throws InterruptedException {
    	    	boolean flag,flag1,flag2 = false;
    	    	String text;
    	    
    	    			LOGGER.info("Verifying System Logs from Activities Popup");
    	    			By detailTextXPath = By.xpath("//span[contains(text(),'Detail')]/ancestor::div/following-sibling::div//div[contains(text(),'Legal Entity "+entityType+" "+legalName+"')]");
    					flag = driverWait.until(ExpectedConditions.visibilityOfElementLocated(detailTextXPath)).isDisplayed();
    					By entitleTextXPath = By.xpath("//span[contains(text(),'Detail')]/ancestor::div/following-sibling::div//div[contains(text(),'The added entitlements are Activate')]");
    					flag1 = driverWait.until(ExpectedConditions.visibilityOfElementLocated(entitleTextXPath)).isDisplayed();
    					
    					text = driver.findElement(By.xpath("//span[@class='x-header-text x-window-header-text x-window-header-text-default']/ancestor::div/following-sibling::div//*[contains(@id,'gridview')]/table")).getText();
    					System.out.println("text : " + text);
    					//By detailXPath = By.xpath("(//div[@class = 'x-panel-body x-grid-body x-panel-body-default x-layout-fit x-panel-body-default'])[4]");
    				//String text = driverWait.until(ExpectedConditions.visibilityOfElementLocated(detailXPath)).getText();
    					//System.out.println("newtext" +text);
    	    	
    				    clickElement(driver, btnCloseAuditActivitiesPopup);
    				    //return flag;
    			
    				    if(flag==true && flag1==true) {
    				    	flag2=true;
    				    }
    				    
    	    	return flag2;
    	    	
    	    } 
     
     public boolean VerifiedLegalEntityActivated (String shortName,String entityType,String status) {
 		LOGGER.info("verifiy created LE");
 		By leCreationLocatorXPath = By.xpath("//div[text()='"+shortName+"']//parent::td//following-sibling::td//div[text()='"+entityType+"']//parent::td//following-sibling::td//div[text()='"+status+"']");
 		driverWait.until(ExpectedConditions.visibilityOfElementLocated(leCreationLocatorXPath));
 		return driverWait.until(ExpectedConditions.elementToBeClickable(leCreationLocatorXPath)).isDisplayed();
 	}
     
     public boolean VerifiedLegalEntityPending (String shortName,String entityType,String status) {
  		LOGGER.info("verifiy Legal Entity Pending");
  		By leCreationLocatorXPath = By.xpath("//div[text()='"+shortName+"']//parent::td//following-sibling::td//div[text()='"+entityType+"']//parent::td//following-sibling::td//div[text()='"+status+"']");
  		driverWait.until(ExpectedConditions.visibilityOfElementLocated(leCreationLocatorXPath));
  		return driverWait.until(ExpectedConditions.elementToBeClickable(leCreationLocatorXPath)).isDisplayed();
  	}
}
 
// endregion : Methods
