package com.fxoffice.stepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.fxboss.ui.pages.BenificiariesPage;
import com.fxboss.ui.pages.ManageTradePage;
import com.fxboss.ui.pages.NewTradePage;
import com.fxoffice.ui.pages.HomePage;
import com.fxoffice.ui.pages.LoginPage;
import com.fxoffice.ui.pages.WebDriverManager1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class BeneficiariesPageStep {
	public WebDriver driver = getDriver();
	public LoginPage loginPage;
    public HomePage homePage;
    public BenificiariesPage beneficiariesPage;
	

	public WebDriver getDriver() {
		return WebDriverManager1.driver;
	}
	@Then("I verify Beneficiaries Tab")
	public void verifyBeneficiariesTab() throws InterruptedException{
		beneficiariesPage = new BenificiariesPage(driver);
		Assert.assertTrue(beneficiariesPage.verifyBeneficiariesTab());
	}
	@And("I Navigate to Add International Beneficiaries")
	public void navigateToAddInternationalBeneficiary(){
		beneficiariesPage = new BenificiariesPage(driver);
		beneficiariesPage.clickInternationalBeneficiary();
	}
	
	@And("I Fill The Beneficiary Details Using {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void fillPersonalDetails(String beneName,String tempName,String address,String country,String city,String email,String countryCode,String PhoneNumber,String bankLocation,String AccountCurrency,String lookUp,String bic,String Accno){
		beneficiariesPage = new BenificiariesPage(driver);
		beneficiariesPage.providePersonalDetail(beneName,tempName,address,country,city,email,countryCode,PhoneNumber);
		beneficiariesPage.provideBeneficiaryBankDetail(bankLocation, AccountCurrency, lookUp, bic, Accno);
		beneficiariesPage.clickAddBeneficiary();
	}
	@And("I Click Confirm Button to Beneficiary")
	public void saveBeneficiary(){
		beneficiariesPage = new BenificiariesPage(driver);
		beneficiariesPage.clickConfirmToSaveBeneficiary();
	}
	
	

}
