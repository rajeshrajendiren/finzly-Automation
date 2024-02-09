package com.fxoffice.stepDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fxoffice.ui.pages.RelationshipManagerPage;
import com.fxoffice.ui.pages.HomePage;
import com.fxoffice.ui.pages.WebDriverManager1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RelationshipManagerStepDef {
	
	public WebDriver driver = getDriver();
	public RelationshipManagerPage relationshipManagerObj=new RelationshipManagerPage(driver);;
	public HomePage homePage = new HomePage(driver);
	
	public WebDriver getDriver() {
		return WebDriverManager1.driver;
	}
	

	@Then("I Create and verify the RM with {string} {string} {string}")
	public void i_create_the_rm(String username,String type,String respCode) throws Throwable {
		homePage.clickAdminTab();
		homePage.clickRelationshipManagerButton();
		relationshipManagerObj.clickNewBtnFromRelationshipManagerTab();
		relationshipManagerObj.createAddRelationshipManager(username,type,respCode);
		relationshipManagerObj.verifyRMCreation(type,respCode);
	}
	

	@Then("I Create RM with {string} {string} {string}")
	public void i_create_the_legal_entity(String username,String type,String respCode) throws Throwable {
		homePage.clickAdminTab();
		homePage.clickRelationshipManagerButton();
		relationshipManagerObj.clickNewBtnFromRelationshipManagerTab();
		relationshipManagerObj.addLegalEntityManager(username,type,respCode);
		//relationshipManagerObj.verifyLegalEntityCreation(type,respCode); 
	}
	
	@Then("I Edit RM with {string} {string} {string} and verify {string} message")
	public void i_edit_the_legal_entity(String username,String type,String respCode,String msg) throws Throwable {
		//homePage.clickAdminTab();
		//homePage.clickRelationshipManagerButton();
		//relationshipManagerObj.clickNewBtnFromRelationshipManagerTab();
		relationshipManagerObj.updateLegalEntityManager(username,type,respCode,msg);
		//relationshipManagerObj.verifyLegalEntityCreation(type,respCode);
	}
	
	//@When("I Edit Costcenter with {string} {string} {string} and verify {string} message")
	//public void i_edit_the_legal_entity(String MarketSector,String GeographicRegion,String CostCenter,String msg) throws Throwable {
		//homePage.clickAdminTab(); 
		//homePage.clickRelationshipManagerButton();
		//relationshipManagerObj.clickNewBtnFromRelationshipManagerTab();
		//relationshipManagerObj.updateAddcostCenter(MarketSector,GeographicRegion,CostCenter,msg);
		//relationshipManagerObj.verifyLegalEntityCreation(type,respCode);
	//}
	
	@Then("I Search Created RM {string}")
	public void i_create_the_legal_entity(String username) throws Throwable {
		homePage.clickAdminTab();
		homePage.clickRelationshipManagerButton();
		relationshipManagerObj.searchRM(username);
		
	}
	
	@Then("I Search Created Costcenter {string}")
	public void i_searchCostCenter(String costsentrenum) throws Throwable {
		homePage.clickAdminTab();
		homePage.clickbtnCostCenters();
		relationshipManagerObj.searchCostCentre(costsentrenum);
		
	}
	
	@Then("I verify RM {string} {string}")
	public void i_verify_legal_entity(String username,String type) throws Throwable {
		relationshipManagerObj.verifyRMinList(username,type);
	}
	
	@Then("I verify updated cost center {string}")
	public void i_verify_updated_cost_center(String username) throws Throwable {
		relationshipManagerObj.verifyCostinList(username);
	}
	
	
	@Then("I verify Cost Center {string}")
	public void i_verify_legal_entity(String costnum) throws Throwable {
		relationshipManagerObj.verifyCostinList(costnum);
	}
	
	@Then("I Select and edit cost center {string} {string}")
	public void i_select_cost_center(String costnum,String updatedVal) throws Throwable {
		relationshipManagerObj.edit(costnum,updatedVal);
	}
	
	
	@Then("Select RM {string} {string} {string}")
	public void select_RM(String username,String type,String respCode ) throws Throwable {
		relationshipManagerObj.selectRM(username,type,respCode);
	}
	

	@Then("I Select the cost center {string}")
	public void select_RM(String costCenter ) throws Throwable {
		relationshipManagerObj.selecCostCenter(costCenter);
	}
	
	
	@And("I Click Upade Button")
	public void iClick_UpdateButton() throws Exception {
	relationshipManagerObj.btnUpdate();
	}
	
	@And("I Delete and verify the user {string}")
	public void iClick_DeleteButton(String user) throws Exception {
		relationshipManagerObj.btnDelete();
		relationshipManagerObj.deleteUser();
		int count=relationshipManagerObj.verifyDeletedUser(user);
		Assert.assertEquals(count, 0);
	}
	
	@Then("I Create and verify the Cost Centre with {string} {string} {string}")
	public void i_create_the_cost_centre(String marketSector,String geographicRegion,String costCenter) throws Throwable {
		//homePage.clickAdminTab(); 
		homePage.clickCostCentersBtn();
		relationshipManagerObj.clickbtnNewCostCenters();
		relationshipManagerObj.createAddcostCenter(marketSector,geographicRegion,costCenter);
		relationshipManagerObj.verifyCostCentersCreation(marketSector,geographicRegion,costCenter);
	}
	 
	
	@And("I click on Relationship Manager Tab;in Admin Tab")
    public void clickRelationshipManagerButton() throws InterruptedException {
	    relationshipManagerObj = new RelationshipManagerPage(driver);
	    relationshipManagerObj.clickRelationshipManagerButton(); 
	}
	
	@And("I Click On New button; in Relationship Manager Tab")
    public void click_NewRelationshipManager() throws InterruptedException {
	    relationshipManagerObj = new RelationshipManagerPage(driver);
	    relationshipManagerObj.clickNewBtnFromRelationshipManagerTab(); 
	}
	
	@When("I Enter Valid Inputs from Property File for creating Relationship Manager; in Add Relationship Manager Popup")
    public void createAddRelationshipManager() throws InterruptedException, IOException {
		relationshipManagerObj = new RelationshipManagerPage(driver);
		relationshipManagerObj.clickNewBtnFromRelationshipManagerTab(); 
		//relationshipManagerObj.createAddRelationshipManager();
	}
		
	@And("I Click on Save button; Add Relationship Manager Popup")
	public void click_SavebuttonAddRelationshipManager() {
	    relationshipManagerObj = new RelationshipManagerPage(driver);
	    relationshipManagerObj.clickSave();
	}
	
	
	@Then("I Verify RM Created with {string} {string} {string}; in Add Relationship Manager tab successfully")
	public void verifyRMCreation(String userid, String type, String respcode) throws InterruptedException {
		relationshipManagerObj = new RelationshipManagerPage(driver);
	    relationshipManagerObj.verifyRMCreation(type, respcode);
	}
	
	@When("I Enter {string} {string} {string} {string} for creating Originating Officer; in Add Relationship Manager Popup")
    public void createAddOriginatingOfficer(String userid, String username, String type, String respcode) throws InterruptedException {
	    relationshipManagerObj = new RelationshipManagerPage(driver);
	    relationshipManagerObj.createAddOriginatingOfficer(userid,username,respcode);
	}

	@Then("I Verify Originating Officer Created with {string} {string} {string}; in Add Relationship Manager tab successfully")
	public void verifyOriginatingOfficerCreation(String userid, String type, String respcode) throws InterruptedException {
		relationshipManagerObj = new RelationshipManagerPage(driver);
	    relationshipManagerObj.verifyOriginatingOfficerCreation(userid, type, respcode);
	}
	
	@And("I Click on Cost Centers from Admin Tab; in Home Page" )
    public void clickCostCentersBtn() {
	    relationshipManagerObj = new RelationshipManagerPage(driver);
	    relationshipManagerObj.clickCostCentersBtn();
	}
 
	@And("I Click On New button; in Cost centers Tab")
    public void clickbtnNewCostCenters() {
	    relationshipManagerObj = new RelationshipManagerPage(driver);
	    relationshipManagerObj.clickbtnNewCostCenters();
	}
	
	@When("I Enter {string} {string} {string} for creating CostCenters; in Add CostCenters")
    public void createCostCenters(String marketSector, String geographicRegion, String costCenter) throws InterruptedException {
	    relationshipManagerObj = new RelationshipManagerPage(driver);
	    relationshipManagerObj.createAddcostCenter(marketSector,geographicRegion,costCenter);
	}
	

	@Then("I Verify Cost Centers Created with {string} {string} {string}; in CostCenters tab successfully")
	public void verifyCreatedCostCenters(String marketSector, String geographicRegion, String costCenter) throws InterruptedException {
	    relationshipManagerObj = new RelationshipManagerPage(driver);
	    relationshipManagerObj.verifyCostCentersCreation(marketSector,geographicRegion,costCenter);
	}
}
	
	




	
	
        
  

