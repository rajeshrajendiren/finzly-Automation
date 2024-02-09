package com.fxoffice.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.fxoffice.ui.pages.EntityManagerPage;
import com.fxoffice.ui.pages.HomePage;
import com.fxoffice.ui.pages.LoginPage;
import com.fxoffice.ui.pages.WebDriverManager1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {
	
	public WebDriver driver = getDriver();
	public HomePage homePage;
	public LoginPage loginPage;
	
	public WebDriver getDriver() {
		return WebDriverManager1.driver;
	}
	
	
	@Then("I Verify Home Page Loaded Successfully")
	public void verify_ApplicationHomePage() throws Throwable {
		homePage = new HomePage(driver);
		boolean result = homePage.verifyHomePage();
		Assert.assertTrue("Problem in Loading Application Home Page.", result);
		
		
	}
	

	@Then("I Verify Boss Home Page Loaded Successfully")
	public void verify_BossApplicationHomePage() throws Throwable {
		homePage = new HomePage(driver);
		boolean result = homePage.verifyBossHomePage();
		Assert.assertTrue("Problem in Loading Application Home Page.", result);
		
		
	}
	
	
	
	@And("I Click on Admin Tab; in Home page")
    public void click_AdminTab() {
	    homePage = new HomePage(driver);
	    homePage.clickAdminTab();
	}
	
	@And("I Click on Beneficiary Tab")
    public void clickBenificiariesTab() {
	    homePage = new HomePage(driver);
	    homePage.clickBeneficiariesTab();;
	}

	@And("I Click On Relationship Manager from Admin Tab; in Home Page")
    public void click_RelationshipManagerButton() {
	    homePage = new HomePage(driver);
	    homePage.clickRelationshipManagerBtn();
	 }
	
	@And("I click on Logout Button; from Home Page") 
    public void clickbtnLogout() throws Exception {
		homePage = new HomePage(driver);
	    homePage.clickbtnLogout();
	    loginPage = new LoginPage(driver);
		boolean result = loginPage.verifyLoginPage();
		Assert.assertTrue("Problem in Loading FXOffice Application Login Page.", result);
	
		/*
		 * try { //Thread.sleep(5000); } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } System.out.println("333333");
		 */
	 }
}
	



	
	
  
