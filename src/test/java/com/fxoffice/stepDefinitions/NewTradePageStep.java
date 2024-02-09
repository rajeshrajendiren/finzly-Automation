package com.fxoffice.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.fxboss.ui.pages.NewTradePage;
import com.fxoffice.ui.pages.EntitlementCompareAndModifyPage;
import com.fxoffice.ui.pages.HomePage;
import com.fxoffice.ui.pages.LoginPage;
import com.fxoffice.ui.pages.SetllementPage;
import com.fxoffice.ui.pages.WebDriverManager1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class NewTradePageStep {
	public WebDriver driver = getDriver();
	public LoginPage loginPage;
    public HomePage homePage;
    public NewTradePage newTradePage;
	

	public WebDriver getDriver() {
		return WebDriverManager1.driver;
	}
	
	@And("I click New Trade Tab")
	public void clickNewTrade(){
		homePage = new HomePage(driver);
		homePage.clickNewTradeTab();
	}
	@And("I Close Announcement PopUp")
	public void closeAnnouncement(){
		homePage = new HomePage(driver);
		homePage.closeAnnouncementTab();
	}
	
	@Then("I verify New Trade Page")
	public void verifyTradePage() throws InterruptedException{
		newTradePage = new NewTradePage(driver);
		Assert.assertTrue(newTradePage.verifyNewTrade());
	}
	
	@And("I Book FX Spot trade {string} {string} {string} {string} {string}")
	public void bookTrade(String CurrencyPair,String tenor,String Amount,String Currency,String option){
		newTradePage = new NewTradePage(driver);
		newTradePage.bookFxSpotTrade1(CurrencyPair,tenor, Amount, Currency, option);
	}
	
}
