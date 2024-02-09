package com.fxoffice.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.fxoffice.ui.pages.RelationshipManagerPage;
import com.fxoffice.ui.pages.EntitlementsPage;
import com.fxoffice.ui.pages.EntityManagerPage;
import com.fxoffice.ui.pages.HomePage;
import com.fxoffice.ui.pages.WebDriverManager1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EntityManagerPageSteps {
	
	public WebDriver driver = getDriver();
	public EntityManagerPage entityManagerPage;
	
	public WebDriver getDriver() { 
		return WebDriverManager1.driver;
	}
	
	 @And("I Click on Legal Entities from Entity Manager Tab; in Home Page")
		public void click_legalEntitiesButton() throws Exception {
			entityManagerPage = new EntityManagerPage(driver);
			entityManagerPage.clickBtnLegalEntities();
		}
	
	 @And("I Enter Legal Entity general details for credit {string} {string} {string} {string} {string} {string} {string} {string}")
		public void createLegalEntityAddlegalEntityPopupforcredit(String legalname,String shortname,String processingOrg,String entityType,String Relationship,String OriginatingOfficer,String costCenterType,String creditClient) throws Exception {
			entityManagerPage = new EntityManagerPage(driver);
			//entityManagerPage.clickBtnLegalEntities(); 
			entityManagerPage.clickAddbuttonfromLegalEntities();
			entityManagerPage.clickGeneralbuttonfromlegalEntityPopup();
			entityManagerPage.createLegalEntityAddlegalEntityPopupforcredit(legalname, shortname, processingOrg, entityType, Relationship,OriginatingOfficer, costCenterType,creditClient);
			entityManagerPage.WebclientCheckBox();
			entityManagerPage.btnCredit(); 
			entityManagerPage.txtCustomerNotes();  
		} 
	 
	 @And("I Enter Legal Entity general details for cash {string} {string} {string} {string} {string} {string} {string} {string}")
		public void createLegalEntityAddlegalEntityPopupforcash(String legalName, String shortName, String processingOrg,String entityType,String Relation,String OriginatingOfficer,String costCenterType,String cashClient) throws Exception {
			entityManagerPage = new EntityManagerPage(driver);
			//entityManagerPage.clickBtnLegalEntities(); 
			entityManagerPage.clickAddbuttonfromLegalEntities();
			entityManagerPage.clickGeneralbuttonfromlegalEntityPopup();
			entityManagerPage.createLegalEntityAddlegalEntityPopupforcash(legalName, shortName, processingOrg, entityType, Relation,OriginatingOfficer, costCenterType, cashClient);
			entityManagerPage.WebclientCheckBox();
			entityManagerPage.btnCash(); 
			entityManagerPage.txtCustomerNotes();  
		}
	
	 @When("I Enter Legal Entity address details {string} {string} {string} {string} {string}")
	 public void createLegalEntityAddressDetails(String address,String city,String state,String pincode,String country) throws Exception {
		 entityManagerPage.clickAddressbuttonfromLegalEntitiesPopUp();
		 entityManagerPage.enterAddressfromLegalAddressTab(address, city, state, pincode,country);
		}
	 
	 @And("I Enter {string} as Short name and {string} as Entity Type; in Legal Entity Browser Search Panel")
		public void enterdetailsLegalEntityBrowserletfside(String shortName, String entityType) throws InterruptedException {
	    entityManagerPage.enterdetailsLegalEntityBrowserletfside(shortName,entityType);
	    entityManagerPage.clickSearchbtnLeftside(); 
	 }
	 
	 @Then("I Verify Legal Entity Created for {string} with {string} as Entity Typeand {string} as Status; in Entity Manager tab Successfully")
		public void verifyLECreation(String shortName,String entityType,String status) throws InterruptedException {
			entityManagerPage = new EntityManagerPage(driver);
			boolean result = entityManagerPage.verifyLECreation(shortName, entityType, status);
			Assert.assertTrue("Problem in Loading Legal Entity creation.", result);
	 }
	  
	 @And("I Click Legal Entity Created for {string} with {string} as Entity Type and {string} as Status")
		public void selectLE(String shortName,String entityType,String status) throws InterruptedException {
			Thread.sleep(15000); 
		    entityManagerPage = new EntityManagerPage(driver);
			entityManagerPage.selectLE(shortName, entityType, status);
	 } 
	 
	  @Then("I validate the Record Audit and Activities {string} {string}")
	  public void dropdownAuditbutton(String entityType,String legalName) throws InterruptedException {
	    	entityManagerPage = new EntityManagerPage(driver);
	    	entityManagerPage.clickAudit();
	    	entityManagerPage.clickAuditOption("Record Audit"); 
	    	String actual1=entityManagerPage.verifyAuditLogs(entityType,legalName);
	    	//Assert.assertTrue(actual1);
	    	entityManagerPage.clickAudit(); 
	    	entityManagerPage.clickAuditOption("Activities"); 
	    	String actual=entityManagerPage.verifyAuditActivitiesLogs(entityType,legalName);
	    	//Assert.assertTrue(actual);
	 }
	  
	
	 
	 
		 
	 
	 
	 
	 
	 
	
	 
	 
	 
	
	 
	 
	
	
	/*@And("I Click On Add button; in Legal Entities")
    public void click_AddButton() {
		entityManagerPage = new EntityManagerPage(driver);

		entityManagerPage.clickAddbuttonfromLegalEntities();
	}
	
	@And("I Click On General in Legal Entity PopUp")
    public void click_GneralButton() {
		entityManagerPage = new EntityManagerPage(driver);
		entityManagerPage.clickGeneralbuttonfromlegalEntityPopup();
	}
	
	@And("I Enter {string} {string} {string} {string} {string} {string}  for creating Legal Entity; in Add Legal Entity Popup")
    public void createLegalEntity11(String legalname,String shortname,String processingOrg,String entityType,String userName,String costCenterType) throws InterruptedException {
		entityManagerPage = new EntityManagerPage(driver);
		entityManagerPage.createLegalEntityAddlegalEntityPopup(legalname, shortname, processingOrg, entityType, userName, costCenterType);
    }
	@And ("I Click Checkbox Enabled; in legal Entity Popup")
	   public void click_WebclientCheckBox() {
			entityManagerPage = new EntityManagerPage(driver);
			entityManagerPage.WebclientCheckBox();
	}
	
	@And("I Click On Credit Client; in legal Entity Popup")
    public void click_btncredit() {
		entityManagerPage = new EntityManagerPage(driver);
		entityManagerPage.btnCredit();
    }
	
	@And("I Enter Customer Notes; in legal Entity Popup")
    public void click_txtCustomerNotes() {
		entityManagerPage = new EntityManagerPage(driver);
		entityManagerPage.txtCustomerNotes();
    }
	
	@And("I Click On Address in Legal Entity PopUp")
    public void click_btnAddress() {
		entityManagerPage = new EntityManagerPage(driver);
		entityManagerPage.clickAddressbuttonfromLegalEntitiesPopUp();
    }
	
	/*@And("I Enter {string} {string} {string} {string} {string} for Legal Address; in Address Popup")
    public void enterAddressfromLegalAddressTab(String address,String city,String state,String postalCode,String country) throws InterruptedException {
		entityManagerPage = new EntityManagerPage(driver);
		entityManagerPage.enterAddressfromLegalAddressTab(address, city, state, postalCode,country);
    
	}
	
    @And("I Enter {string} as Short name and {string} as Entity Type; in Legal Entity Browser Search Panel")
	public void enterdetailsLegalEntityBrowserletfside11(String shortName, String entityType) throws InterruptedException {
		entityManagerPage = new EntityManagerPage(driver);
		entityManagerPage.enterdetailsLegalEntityBrowserletfside(shortName,entityType);
    }
	
	@When("I Click on Search Button; in Legal Entity Browser Search Panel")
	public void clickSearchbtnLeftside() throws InterruptedException {
		entityManagerPage = new EntityManagerPage(driver);
		entityManagerPage.clickSearchbtnLeftside();
    }
	
	@Then("I Verify Legal Entity Created for {string} with {string} as Entity Type and {string} as RM and {string} as Status; in Entity Manager tab Successfully")
	public void verifyLECreation1(String shortName,String entityType,String relationshipManager,String status) throws InterruptedException {
		entityManagerPage = new EntityManagerPage(driver);
		boolean result = entityManagerPage.verifyLECreation(shortName, entityType, relationshipManager,  status);
		Assert.assertTrue("Problem in Loading Legal Entity creation.", result);
    }
	
	@And("I Click Legal Entity Created for {string} with {string} as Entity Type and {string} as RM and {string} as Status")
	public void selectLE1(String shortName,String entityType,String relationshipManager,String status) throws InterruptedException {
		entityManagerPage = new EntityManagerPage(driver);
		entityManagerPage.selectLE(shortName, entityType, relationshipManager, status);
    }
	
	@And("I Click on Audit;in Entity Manager Tab")
	public void dropdownAuditbutton1() throws InterruptedException {
		entityManagerPage = new EntityManagerPage(driver);
		entityManagerPage.clickAudit();
    }
	
	@When("I Click On {string} from Audit Tab; in Entity Manager Tab")
	public void clickonAudit(String option1) throws InterruptedException {
		entityManagerPage = new EntityManagerPage(driver);
		entityManagerPage.clickAuditOption(option1);   
	}
	
	@Then("I Verified AuditLogs {string} {string} from Audit Tab; in Entity Manager Tab Successfully")
	public void verifyAuditLogs(String entityType, String legalName) throws InterruptedException {
		entityManagerPage = new EntityManagerPage(driver);
		boolean result = entityManagerPage.verifyAuditLogs(entityType, legalName);
		Assert.assertTrue("Problem in Loading AuditLogs.", result);	
    }
	
    @Then("I Verify Audit Activities Logs {string} {string} from Audit Tab; in Entity Manager Tab Successfully")
	public void verifyAuditActivitiesLogs(String entityType, String legalName) throws InterruptedException {
		entityManagerPage = new EntityManagerPage(driver);
		boolean result = entityManagerPage.verifyAuditActivitiesLogs(entityType, legalName);
		Assert.assertTrue("Problem in Loading AuditLogs.", result);	
    } */
}
	
	
	
	
	




	
	
        
    /*@And("I Click On Logout Button; in Home Page")
    public void click_LogoutButton() {
    	homePage = new HomePage(driver);
    	homePage.clickLogoutBtn();
    }

    @And("I Click On Payment Galaxy Option; in Applications Menu; in Home Page")
    public void click_PaymentGalaxyAppMenu() {
    	homePage = new HomePage(driver);
    	homePage.clickPaymentGalaxyMenu();
    }

    @And("I Click On Payment Galaxy Option; in Home Page")
    public void click_PaymentGalaxyMenu() {
    	homePage = new HomePage(driver);
    	homePage.clickPaymentGalaxyApplicationMenu();
    }

    @And("I Click On Fee Service Option; in Home Page")
    public void click_FeeServiceMenu() {
    	homePage = new HomePage(driver);
    	homePage.clickFeeApplicationMenu();
    }

    @And("I Click On Complaince Option; in Home Page")
    public void click_ComplainceMenu() {
    	homePage = new HomePage(driver);
    	homePage.clickComplainceApplicationMenu();
    }
    */

