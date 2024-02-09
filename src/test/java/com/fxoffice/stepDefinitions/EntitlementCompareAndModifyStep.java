package com.fxoffice.stepDefinitions;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.fxoffice.ui.pages.RelationshipManagerPage;
import com.fxoffice.ui.pages.SetllementPage;
import com.fxoffice.ui.pages.UserRolePage;
import com.fxoffice.ui.pages.EntitlementCompareAndModifyPage;
import com.fxoffice.ui.pages.EntitlementsPage;
import com.fxoffice.ui.pages.EntityManagerPage;
import com.fxoffice.ui.pages.HomePage;
import com.fxoffice.ui.pages.LoginPage;
import com.fxoffice.ui.pages.WebDriverManager1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EntitlementCompareAndModifyStep {

	public WebDriver driver = getDriver();
	public LoginPage loginPage;
	public SetllementPage setllementPage;

//	public HomePage homePage = new HomePage(driver);
	public EntitlementCompareAndModifyPage entitlementCompareAndModifyObj ;

	public WebDriver getDriver() {
		return WebDriverManager1.driver;
	}

	
	  @And("I search Entitlement") public void i_click_searchEntitlement() throws
	  Throwable { 
		  entitlementCompareAndModifyObj.filterEntitlement();
		  entitlementCompareAndModifyObj.searchEntitlement();
	  
	  }
	 
	  @And("I search Entitlement and store the values") public void i_click_searchEntitlement_store_val() throws

	  Throwable { 
		  entitlementCompareAndModifyObj.filterEntitlement();
		  entitlementCompareAndModifyObj.searchEntitlementAndStoreVal();
	  
	  }
	  

	@And("I Click Entitlement")
	public void i_click_UserRoleManagerButton() throws Throwable {
		entitlementCompareAndModifyObj.clickEntitlementButton();
	}

	@Given("launch the url {string}")
	public void i_launch_application(String val) throws Throwable {
		entitlementCompareAndModifyObj = new EntitlementCompareAndModifyPage(driver);
		entitlementCompareAndModifyObj.launchApplication(val);
	}
	
	@And("I Click FXOffice Application")
	public void clickApplicationAndSearch() {
		entitlementCompareAndModifyObj.clickAppAndSearch();
	}
	@Then("I Search and Compare Entitlement")
	public void compareEntitlement() {
		entitlementCompareAndModifyObj.SearchAndCompare();
	}
	
}
