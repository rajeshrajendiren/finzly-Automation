package com.fxoffice.stepDefinitions;

import java.awt.AWTException;

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

public class EntitlementsPageSteps {
	
	public WebDriver driver = getDriver();
	public EntitlementsPage entitlementsPage;
	public EntityManagerPage entityManagerPage;
	
	public WebDriver getDriver() {
		return WebDriverManager1.driver;
	}
    @And("I click on Entitlements; move permission from left to right")
	public void click_EntitlementsButton() throws Exception {
    	entitlementsPage = new EntitlementsPage(driver);
    	entitlementsPage.clickentitlementsButton();
    	entitlementsPage.clickActiveNotificationPreference();
    	entitlementsPage.clickAddtoSelected();
    	entitlementsPage.clickSave();
    	entitlementsPage.clickokbtn();
	}
    
    @And("I click on Entitlements; Move Right to Left Active Notification Preference Button")
   	public void click_EntitlementsButtonRightToLeft() throws Exception {
       	entitlementsPage = new EntitlementsPage(driver);
       	entitlementsPage.clickentitlementsButton();
       	entitlementsPage.clickRightToLeftDataPreference();
       	entitlementsPage.clickRemovetoSelectedBtn();
       	entitlementsPage.clickSave();
       	entitlementsPage.clickokbtn();
   	}
     
    @And("I click on Entitlements for contact; move permission from left to right")
	public void click_Entitlements_for_contact() throws Exception {
    	entitlementsPage = new EntitlementsPage(driver);
    	entitlementsPage.clickEntitlementsforcontact();
    	entitlementsPage.clickActiveNotificationPreference();
    	entitlementsPage.clickAddtoSelected();
    	entitlementsPage.clickSave();
    	entitlementsPage.clickokbtn();
	}
    
  
    @Then("I validate the Field Audit and Record Audit and Activities {string} {string} left to right")
	public void dropdownAuditbutton(String entityType,String legalName) throws InterruptedException {
		entityManagerPage = new EntityManagerPage(driver);
		entityManagerPage.clickAudit();
		entityManagerPage.clickAuditOption("Field Audit"); 
		entityManagerPage.verifyFieldLogs(entityType,legalName);
		entityManagerPage.clickAudit(); 
		entityManagerPage.clickAuditOption("Record Audit"); 
		entityManagerPage.verifyAuditLogs(entityType,legalName);
		entityManagerPage.clickAudit();
		entityManagerPage.clickAuditOption("Activities"); 
		String actual=entityManagerPage.verifyAuditActivitiesLogs(entityType,legalName);
 }
    
    @Then("I validate the Field Audit and Record Audit and Activities {string} {string} after right to left")
 	public void dropdownAuditbuttonRightToLeft(String entityType,String legalName) throws InterruptedException {
 		entityManagerPage = new EntityManagerPage(driver);
 		entityManagerPage.clickAudit();
 		entityManagerPage.clickAuditOption("Field Audit"); 
 		entityManagerPage.verifyFieldLogsRight(entityType,legalName); 
 		entityManagerPage.clickAudit();
 		entityManagerPage.clickAuditOption("Record Audit"); 
 		entityManagerPage.verifyAuditLogs(entityType,legalName);
 		entityManagerPage.clickAudit();
 		entityManagerPage.clickAuditOption("Activities"); 
 		String actual=entityManagerPage.verifyAuditActivitiesLogs(entityType,legalName);
  }
    
    @Then("I validate the Field Audit and Record Audit and Activities {string} {string} for contact")
 	public void dropdownAuditbuttonforcontact(String entityType,String legalName) throws InterruptedException {
 		entityManagerPage = new EntityManagerPage(driver);
 		entityManagerPage.clickAudit();
 		entityManagerPage.clickAuditOption("Field Audit"); 
 		entityManagerPage.verifyFieldLogscontact(entityType,legalName); 
 		entityManagerPage.clickAudit();
 		entityManagerPage.clickAuditOption("Record Audit"); 
 		entityManagerPage.verifyAuditLogs(entityType,legalName);
 		entityManagerPage.clickAudit();
 		entityManagerPage.clickAuditOption("Activities"); 
 		String actual=entityManagerPage.verifyAuditActivitiesLogs(entityType,legalName);
  }
    
    @Then("I validate the Contact Field Audit and Record Audit and Activities {string} {string} for contact")
 	public void dropdownContactAuditbuttonforcontact(String entityType,String legalName) throws InterruptedException {
 		entityManagerPage = new EntityManagerPage(driver);
 		entityManagerPage.clickContactAudit();
 		entityManagerPage.clickContactAuditOption("Field Audit"); 
 		entityManagerPage.verifyFieldLogscontact(entityType,legalName); 
 		entityManagerPage.clickContactAudit();
 		entityManagerPage.clickContactAuditOption("Record Audit"); 
 		entityManagerPage.verifyContactAuditLogs(entityType,legalName);
 		entityManagerPage.clickContactAudit();
 		entityManagerPage.clickContactAuditOption("Activities"); 
 		String actual=entityManagerPage.verifyContactAuditActivitiesLogs(entityType,legalName);
  }
    
    @And("I Click on Edit button and activate LE")
	public void clickEditbtn() throws Exception {
    	entitlementsPage = new EntitlementsPage(driver);
    	entitlementsPage.clickEditbtn();
    	entitlementsPage.clickActivateLE();
    	
    }
    
    @Then ("I Verified Legal Entity Activated for {string} with {string} as Entity Type and {string} as Status successfully")
    public void Verified_LegalEntityActivated( String shortName,String entityType,String status) throws Exception {	
    	entitlementsPage = new EntitlementsPage(driver);
    	boolean actual=entitlementsPage.VerifiedLegalEntityActivated(shortName, entityType, status);
    	Assert.assertTrue(actual);
    }
    	
    @Then ("I Verified Legal Entity Pending for {string} with {string} as Entity Type and {string} as Status successfully")
    public void Verified_LegalEntityPending( String shortName,String entityType,String status) throws Exception {	
    	entitlementsPage = new EntitlementsPage(driver);
    	boolean actual=entitlementsPage.VerifiedLegalEntityPending(shortName, entityType, status);
    	Assert.assertTrue(actual);
    }
    	
    @And("I click on Contact; from Entity Manager tab")
    public void click_Contact() throws Exception {
		entitlementsPage = new EntitlementsPage(driver);
		entitlementsPage.clickContact();
    }
    
    @And("I click on Add button; from contact Popup")
    public void click_Add() throws Exception {
		entitlementsPage = new EntitlementsPage(driver);
		entitlementsPage.clickAdd();
    }
	
	@And("I Enter Details {string} {string} {string} {string} {string} {string} {string} for contact")
    public void addDetailsforContacts(String firstName, String lastname, String userId, String password, String emailAddress,String phoneNumber, String cellNumber) throws InterruptedException {
		entitlementsPage = new EntitlementsPage(driver);
		entitlementsPage.addDetailsforContacts(firstName, lastname, userId, password, emailAddress, phoneNumber, cellNumber);
		//entitlementsPage.closebtn();  
	}
	
	
	@Then("I Verify Contact Created {string} {string} {string} {string} {string} {string} successfully")
	public void verifyContactCreation(String userId,String firstName,String lastname,String emailAddress,String phoneNumber,String status) throws InterruptedException {
		entitlementsPage = new EntitlementsPage(driver);
		boolean result = entitlementsPage.verifyContactCreation(userId, firstName, lastname, emailAddress, phoneNumber, status);
		Assert.assertTrue("Problem in Loading AuditLogs.", result);	
    } 
	
	@And("I click on Close Button; from contact Popup")
    public void click_Closebtn() throws Exception {
		entitlementsPage = new EntitlementsPage(driver);
		entitlementsPage.clickClosebtn();
	}
	 
	@And("I Select Contact Created {string} {string} {string} {string} {string} {string}")
    public void selectContact(String userId,String firstName,String lastname,String emailAddress,String phoneNumber,String status) throws Exception {
		entitlementsPage = new EntitlementsPage(driver);
		entitlementsPage.selectContact(userId, firstName, lastname, emailAddress, phoneNumber, status);
    }
	
	@And("I click Activate; from contact popup")
    public void click_Activatebtn() throws Exception {
		entitlementsPage = new EntitlementsPage(driver); 
		entitlementsPage.clickActivatebtn();
		entitlementsPage.clickYesbtn();
		
	} 
	 
}
	
	