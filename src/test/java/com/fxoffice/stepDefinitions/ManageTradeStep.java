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

public class ManageTradeStep {
	public WebDriver driver = getDriver();
	public LoginPage loginPage;
	public HomePage homePage;
	public BenificiariesPage beneficiariesPage;
	public BenificiariesPage ben;
	public ManageTradePage manageTradePage;


	@And("I click Manage Trade Tab")
	public void clickManageTrade() {
		homePage = new HomePage(driver);
		homePage.clickManageTradeTab();
	}

	@Then("I verify Manage Trade Tab")
	public void verifyManageTradePage() {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.verifyManageTrade();
	}

	@And("I Checked Booked Data")
	public void bookedDataVerification() {
		manageTradePage = new ManageTradePage(driver);
		assertTrue(manageTradePage.verifyBookedData(), "verify booked Data");

	}

	@And("I Navigate to Awaiting Instruction")
	public void navigateToAwaitingInstruction() {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.clickAwaitInstruction();

	}

	@And("I Navigate to Awaiting Authorization")
	public void navigateToAwaitingAuthorization() {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.clickAwaitAuthorization();
		;

	}

	@And("I Navigate to Awaiting Confirmation")
	public void navigateToAwaitingConfirmation() {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.clickAwaitConfirmation();
		;

	}

	@And("I Navigate to Position Blotter")
	public void navigateToPositionBlotter() {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.clickPositionBlotter();

	}
	@And("I navigate to Manage Settlement")
	public void navigateToManageSettlement() {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.clickManageSettlement();

	}

	@Then("I Verify Settlement Details")
	public void settlementDetails() throws InterruptedException {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.settlementDetails();
	}

	@Then("I Verify No Trade is Present")
	public void verifyNoTradeInAwaitAuthorization() {
		manageTradePage = new ManageTradePage(driver);
		try {

			assertEquals("No trades to display", manageTradePage.confirmNoTradeIsEligibleOrDisplayed());

		} catch (NoSuchElementException e) {

			System.out.println("No trade message found in await authorization, as expected");
		}
	}

	@Then("I Verify No Trade is Eligible")
	public void verifyNoTradeEligibleInAwaitConfirmation() {
		manageTradePage = new ManageTradePage(driver);
		try {

			assertEquals("You do not have any trades eligible to confirm.",
					manageTradePage.confirmNoTradeIsEligibleOrDisplayed());

		} catch (NoSuchElementException e) {

			System.out.println("No trade eligible message found in await confirmation, as expected");
		}
	}

	@Then("I Verify Position Blotter Details")
	public void positionBlotterDetails() throws InterruptedException {
		manageTradePage = new ManageTradePage(driver);
		assertTrue(manageTradePage.positionBlotterDetails(), "position Blotter Data mismatches");
	}

	@And("I click instruct button from Awaiting Instruction")
	public void clickInstructButton() {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.clickInstructButton();
	}

	public WebDriver getDriver() {
		return WebDriverManager1.driver;
	}

	public void verifyBeneficiariesTab() {
		beneficiariesPage = new BenificiariesPage(driver);
		beneficiariesPage.verifyBeneficiariesTab();
	}

	/*@Then("I Verify Settlement Details")
	public void settlementDetail() throws InterruptedException {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.settlementDetails();
	}*/

	/*@Then("I Verify Position Blotter Details")
	public void getting() throws InterruptedException {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.settlementDetails();
	}*/

	@And("I get row count")
	public void getCount() {
		manageTradePage = new ManageTradePage(driver);
		assertTrue(manageTradePage.verifyBookedData(), "verify booked Data");

	}
	@And("I click instruct on pays")
	public void clickInstructOnPays() throws InterruptedException {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.clickInstructOnPays();

	}
	
	@And("I click instruct")
	public void clickInstruct() throws InterruptedException {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.clickInstruct();

	}
	
	@And("I click instruct on receives")
	public void instructOnReceive() throws InterruptedException {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.clickInstructOnReceives();

	}
	
	@And("I Select Account for Receives from Settlement Instruction Using {string},{string},{string} and {string}")
	public void settlementInstructionOnReceives(String DDAAccountName,String DDAAccountNumber,String beneficiaryAccountName,String beneficiaryAccountNumber) {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.settlementInstructionOnReceives(DDAAccountName,DDAAccountNumber,beneficiaryAccountName,beneficiaryAccountNumber);

	}
	@And("I Select Account for Pays from Settlement Instruction Using {string},{string},{string} and {string}")
	public void settlementInstructionOnPays(String DDAAccountName,String DDAAccountNumber,String beneficiaryAccountName,String beneficiaryAccountNumber) {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.settlementInstructionOnPays(DDAAccountName,DDAAccountNumber,beneficiaryAccountName,beneficiaryAccountNumber);

	}
	@Then("I Verify Settlement Instruction PopUp Loaded Successfully")
	public void verifySettlementInstructionLoadedOrNot() {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.verifySettlementInstructionLoaded();

	}
	@And("I Click Instruct Button from Instruction Settlement PopUp")
	public void clickInstructOnSettlementConfirmation() {
		manageTradePage = new ManageTradePage(driver);
		manageTradePage.clickInstructBtnOnSettlementInstruction();
	}

}
