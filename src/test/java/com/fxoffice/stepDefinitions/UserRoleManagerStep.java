package com.fxoffice.stepDefinitions;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.fxoffice.ui.pages.RelationshipManagerPage;
import com.fxoffice.ui.pages.SetllementPage;
import com.fxoffice.ui.pages.UserRolePage;
import com.fxoffice.ui.pages.EntitlementsPage;
import com.fxoffice.ui.pages.EntityManagerPage;
import com.fxoffice.ui.pages.HomePage;
import com.fxoffice.ui.pages.LoginPage;
import com.fxoffice.ui.pages.WebDriverManager1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRoleManagerStep {
	
	public WebDriver driver = getDriver();
	public LoginPage loginPage;
	public SetllementPage setllementPage;
	
	public HomePage homePage = new HomePage(driver);
	public UserRolePage userRoleManagerObj = new UserRolePage(driver);
	
	public WebDriver getDriver() {
		return WebDriverManager1.driver;
	} 

	
 
	@And("I Click AdminTab")
	public void i_click_admintab() throws Throwable {
		homePage.clickAdminTab();
		
	}
		
    @And("I Click UserRoleManagerButton")
	public void i_click_UserRoleManagerButton() throws Throwable {
		homePage.clickUserRoleManagerButton();
	}
	 

	@And("I Create user role {string}")
	public void i_create_user_role(String userRoleName) throws Throwable {
		userRoleManagerObj.createUserRole(userRoleName);
	}
	
	@And("I Check entitlement for user {string}")
	public void i_Check_entitlement_for_user(String entitlementName) throws Throwable {
		userRoleManagerObj.CheckEntitlement(entitlementName);
	}
	
	@And("I Uncheck all roles") 
	public void i_uncheck_all_roles() throws Throwable {
		userRoleManagerObj.UnCheckAllEntitlement();
	}
	
	@And("I Check multiple entitlement {string}") 
	public void i_Check_multiple_entitlement_for_user(String entitlementName) throws Throwable {
		userRoleManagerObj.CheckMultipleEntitlement(entitlementName);
	}
	
	@And("I UnCheck entitlement {string}") 
	public void i_UnCheck_entitlement(String entitlementName) throws Throwable {
		userRoleManagerObj.UnCheckEntitlement(entitlementName);
	}
	
	@And("I UnCheck multiple entitlement for user {string} {string}")
	public void i_UnCheck_multiple_entitlement_for_user(String userRoleName,String entitlementName) throws Throwable {
		userRoleManagerObj.UnCheckMultipleEntitlement(userRoleName,entitlementName);
	}
	
	@And ("I Click Save Button")
	public void i_Click_Save_Button() throws Throwable {
	userRoleManagerObj.saveButton();
	}
	
	@And ("I Click SuccessMessage OK button")
	public void i_Click_Ok_Button() throws Throwable {
	userRoleManagerObj.sucessMsgOkBtn();
	}
	
	@And ("I Search the user {string}")
	public void i_search_the_user(String username) throws Throwable {
	userRoleManagerObj.searchUser(username);
	}
	@And("I Click {string} and {string} with {string}")
	public void clickSubMenuNameWithOption(String menuName,String subMenuName,String option) {
		userRoleManagerObj.hoverElementToSelectOption(menuName,subMenuName,option);
	}
	
	@Then("I verify the entitlement displayed for the user {string}")
	public void i_verify_the_entitlement_displayed_for_the_user(String menuName) throws Throwable {
		boolean actual=userRoleManagerObj.VerifyPresenceOfEntitlement(menuName);
		Assert.assertTrue(actual);
	}
	 
	@Then("I verify the entitlement not displayed for the user {string}")
	public void i_verify_the_entitlement_not_displayed_for_the_user(String menuName) throws Throwable {
		boolean actual=userRoleManagerObj.VerifyAbsenceOfEntitlement(menuName);
		Assert.assertTrue(actual);
	}
	
	

	public void i_UnCheck_entitlement_for_user(String userRoleName,String entitlementName) throws Throwable {
		userRoleManagerObj.UnCheckEntitlement(userRoleName,entitlementName);
	}
	
	/*
	 * @Then("I UnCheck multiple entitlement for user {string} {string}") public
	 * void i_UnCheck_Multiple_entitlement_for_user(String userRoleName,String
	 * entitlementName) throws Throwable {
	 * userRoleManagerObj.UnCheckMultipleEntitlement(userRoleName,
	 * entitlementName);; }
	 */
	 
	@Then("I navigate to menu {string} and verify multiple submenu {string}")
	public void i_navigate_to_menu_submenu_present(String menuName,String submenu) throws Throwable {
		boolean actual=userRoleManagerObj.navigateMenuAndVerifyMultipleSubmenu(menuName,submenu);
		Assert.assertTrue(actual);
	} 
	
	@Then("I Verify {string} single submenu {string} Checked Successfully")
	public void i_navigate_to_menu_single_submenu_present(String menuName,String submenu) throws Throwable {
		boolean actual=userRoleManagerObj.VerifycheckSingleSubmenu(menuName,submenu);
		Assert.assertTrue(actual);
	}
	
	@Then("I Verify {string} single submenu {string} and {string} Checked Successfully")
	public void i_navigate_to_menu_single_submenu_present(String menuName,String submenu,String innerMenu) throws Throwable {
		boolean actual=userRoleManagerObj.VerifycheckSingleSubmenuInnerMenu(menuName,submenu,innerMenu);
		Assert.assertTrue(actual);
	} 
	
	@Then("I Verify {string} single submenu {string} and multiple {string} Checked Successfully")
	public void i_navigate_to_menu_single_submenu_multi_inner_present(String menuName,String submenu,String innerMenu) throws Throwable {
		boolean actual=userRoleManagerObj.VerifycheckSingleSubmenuMultipleInnerMenu(menuName,submenu,innerMenu);
		Assert.assertTrue(actual);
	} 
	
	@Then("I click {string} {string} {string} and click {string} and verify checked sucessfully")
	public void i_click_verify_businessunits_options_check(String menuName,String submenu,String businessuint,String innerMenu) throws Throwable {
		boolean actual=userRoleManagerObj.navigateToBusinessUnitAndVerifyOptions(menuName,submenu,businessuint,innerMenu);
		Assert.assertTrue(actual);
	} 
	@And("I Click {string} and single submenu {string}")
	public void ClickMainMenuAndSubMenu(String MainMenu,String SubMenu) {
		userRoleManagerObj.ClickMainMenuAndSubMenu(MainMenu,SubMenu);
	}
	

	@Then("I click {string} {string} {string} and click {string} and verify unchecked sucessfully")
	public void i_click_verify_businessunits_options_uncheck(String menuName,String submenu,String businessuint,String innerMenu) throws Throwable {
		boolean actual=userRoleManagerObj.navigateToBusinessUnitAndVerifyOptionsUncheck(menuName,submenu,businessuint,innerMenu);
		Assert.assertTrue(actual);
	} 
	 
	
	 
	@Then("I navigate to menu {string} and verify multiple submenu {string} not present")
	public void i_navigate_to_menu_submenu_not_present(String menuName,String submenu) throws Throwable {
		boolean actual=userRoleManagerObj.navigateMenuAndVerifyMultipleSubmenuNotPresent(menuName,submenu);
		Assert.assertTrue(actual); 
	} 

	@Then("I Verify {string} single submenu {string} UnChecked Successfully")
	public void i_navigate_to_menu_single_submenu_not_present(String menuName,String submenu) throws Throwable {
		boolean actual=userRoleManagerObj.VerifyUncheckSingleSubmenu(menuName,submenu);
		Assert.assertTrue(actual);
	}
	
	@Then("I Verify {string} single submenu {string} and {string} UnChecked Successfully")
	public void i_navigate_to_menu_single_innermenu_not_present(String menuName,String submenu,String innerMenu) throws Throwable {
		boolean actual=userRoleManagerObj.VerifyUncheckSingleInnermenu(menuName,submenu,innerMenu);
		Assert.assertTrue(actual);
	} 
	

	@Then("I Verify {string} single submenu {string} and multiple {string} UnChecked Successfully")
	public void i_navigate_to_menu_single_submenu_multi_uncheck_inner_present(String menuName,String submenu,String innerMenu) throws Throwable {
		boolean actual=userRoleManagerObj.VerifyUncheckSingleSubmenuMultipleInnerMenu(menuName,submenu,innerMenu);
		Assert.assertTrue(actual);
	}
	@Then("I Verify {string} Checked Successfully")
	public void verifyInnerMenuEnabled(String innerMenu) {
		boolean actual=userRoleManagerObj.isInnerMenuEnabled(innerMenu);
		Assert.assertTrue(actual);
		
	}
	@When("I Click Add button,if the button present in {string}")
	public void clickAddOrNewBtn(String mutipleOption) {
		userRoleManagerObj.clickAddOrNewBtn(mutipleOption);
	}
	
	
	
	@Then("I Verify {string} UnChecked Successfully")
	public void verifyInnerMenuDisabled(String innerMenu) {
		boolean actual=userRoleManagerObj.isInnerMenuDisabled(innerMenu);
		Assert.assertTrue(actual);
		
	}
	@When("I Click on One of the Existing Branch users")
	public void clickBranchUser() {
		userRoleManagerObj.clickSearchAndRow();
	}
	
	@When("I Click on One of the Existing Exclusion Manager")
	public void clickExclusionManagerData() {
		userRoleManagerObj.clickManagerExclusionListSearchAndRow();
	}
	
	@When("I Click on One of the Existing Currency Data")
	public void clickCurrencyData() {
		userRoleManagerObj.clickCurrencySearchAndRow();
	}
	
	@When("I Click on One of the Existing Cost Centers")
	public void clickCostCenter() {
		userRoleManagerObj.clickCostCenterSearchAndRow();
	}
	
	@When("I Click on One of the Existing Currency Pair")
	public void clickCurrencyPair() {
		userRoleManagerObj.clickCurrencyPairSearchAndRow();
	}
	
	@When("I Click on One of the Existing relation manager")
	public void clickRelationManager() {
		userRoleManagerObj.clickRelationShipManagerSearchAndRow();
	}
	@Then("I Verify Save Button Enabled SuccessFully")
	public void isSaveBtnEnabled() {
		boolean actual=userRoleManagerObj.isSaveBtnEnabled();
		Assert.assertTrue(actual);
	}
	@Then("I Verify Save Button Disabled SuccessFully")
	public void isSaveBtnDisabled() {
		boolean actual=userRoleManagerObj.isSaveBtnDisabled();
		Assert.assertTrue(actual);
	}
	
	
}
	
	