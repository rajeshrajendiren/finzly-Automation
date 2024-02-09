package com.fxoffice.ui.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fxoffice.utility.ParameterService;

public class ComplainceAppPage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComplainceAppPage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;
	
	private String activeMenu = "//a[contains(text(),' Screening')]";
	
	@FindBy(xpath = "//a[contains(text(),' Screening')]")
	private WebElement lnkScreening;

	@FindBy(xpath = "//span[contains(text(),'Compliance')]//..")
	private WebElement ComplianceApp;
	
	@FindBy(xpath = "//button[text()='Search']")
	private WebElement SearchCompliance;
	
	@FindBy(xpath = "//input[contains(@id,'transactionReference')]")
	private WebElement txtTransactionReference;
	
	@FindBy(xpath = "//label[contains(text(),'OFAC Ref No')]//..//..//../input")
	private WebElement QFAcRefNo;
	
	@FindBy(xpath = "//label[contains(text(),'Status' )]//../h2")
	private WebElement ComplianceStatus;
	
	@FindBy(xpath = "//button[text()='Review Results ']")
	private WebElement ReviewResultsButton;
		
	@FindBy(xpath = "//button[text()=' Approve']")
	private WebElement ApproveButton;
	
	@FindBy(xpath = "//label[@for='reason-main-1']")
	private WebElement selectoption;
	
	@FindBy(xpath = "//textarea[@class='ng-untouched ng-dirty ng-valid']")
	private WebElement entertextarea;
	
	@FindBy(xpath = "//span[contains(text(),'Screening')]")
	private WebElement SelectScreening;
	
	@FindBy(xpath = "//span[contains(text(),'WhiteList')]")
	private WebElement SelectWhiteList;
	
	@FindBy(xpath = "//span[contains(text(),'Test')]")
	private WebElement SelectText;
	
	@FindBy(xpath = "//button[contains(text(),'Add Name')]")
	private WebElement AddName;
	
	@FindBy(xpath = "//span[contains(text(),'Individual')]")
	private WebElement Individual;
	
	@FindBy(xpath = "//label[contains(text(),'Description' )]//../h2")
	private WebElement Description;
	
	@FindBy(xpath = "//h2[normalize-space()='Payments']")
	private WebElement SourceSystem;
	
	@FindBy(xpath = "//label[contains(text(),'Transaction Reference' )]//../h2")
	private WebElement transactionRefOfac;

	@FindBy(xpath = "//div[@id='mainApproveModal']//button[contains(text(),'Submit')]")
	private WebElement complainceApproveSubmit;

	@FindBy(xpath = "//button[contains(text(),'Notify')]")
	private WebElement complainceNotify;
	
	//By complainceApproveSubmit=By.cssSelector("body > compliance:nth-child(1) > app-main:nth-child(2) > div:nth-child(2) > div:nth-child(1) > app-screening-result:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > form:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > button:nth-child(1)");
	//By Screening=By.cssSelector("body > compliance > app-main > app-header > header > div > nav > ul > li:nth-child(2) > a");
	//By New=By.cssSelector("body > compliance > app-main > app-header > header > div > nav > ul > li:nth-child(3) > a");
	
	// Constructor
	public ComplainceAppPage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On  Page of ComplainceApp Page.");
		driverWait.until(ExpectedConditions.titleContains("Portal"));
	}
	
	public boolean verifyComplaincePage() throws InterruptedException {
		LOGGER.info("Checking for Complaince Page Load...!!! ");
		waitForSpinnerIcon(driver);
		boolean flag = false;
		driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		if (flag == false) {
			driverWait.until(ExpectedConditions.visibilityOf(lnkScreening));
			driverWait.until(ExpectedConditions.elementToBeClickable(lnkScreening));
			LOGGER.info("Complaince Page loaded successfully....!!!! ");
			flag = true;
		}
		return flag;
	}
	
	public void clickScreeningLink() {
		LOGGER.info("Clicking Screening Link");
		
		int getActiveLinkSelection = driver.findElements(By.xpath(activeMenu)).size();
		if(getActiveLinkSelection > 0)
			LOGGER.info("Already Screening link is clicked");
		else
			clickElement(driver, lnkScreening);
	}
	
	public void setTransactionReference(String PaymentId) {
		
		LOGGER.info("Enter TransactionReference number : " + PaymentId);
		clickElement(driver, txtTransactionReference);
		enterText(driver, txtTransactionReference, PaymentId);
		waitSeconds(2);
	}
	
	public void clickOnSearch() {
		LOGGER.info("Click on Search");
		clickElement(driver, SearchCompliance);
		waitSeconds(2);
	}
	public void clickOnReviewResults() {
		LOGGER.info("Click on ReviewResults");
		clickElement(driver, ReviewResultsButton);
		waitSeconds(2);
	}
	
	public void clickonReviewAllCheckBox()
	{
		//driver.switchTo().defaultContent();
		//driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-checkbox")));
		List<WebElement> AllCheckBoxes = driver.findElements(By.xpath("//mat-checkbox"));
		
		LOGGER.info("Number of Check boxes : "+ Integer.toString(AllCheckBoxes.size()));

		for(WebElement cb:AllCheckBoxes)
		{
			cb.click();
			break;
		}
	}
	
	public void clickOnApprove() 
	{
		LOGGER.info("Click on Approve");
		//driver.switchTo().defaultContent();
		
		scrollIntoViewAndClick(driver, ApproveButton);
		
		waitSeconds(2);
		
		clickElement(driver, selectoption);
			
		clickElement(driver, complainceApproveSubmit);
		waitForSpinnerIcon(driver);
		
		clickElement(driver, complainceNotify);
		waitSeconds(30);
	}
	
	public void UpdateComplianceOFACScreening() throws Throwable {
	
		 clickScreeningLink();
	 	
		 String ID = ParameterService.getParameter("PaymentID");
		 setTransactionReference(ID);
		 clickOnSearch();
		 clickOnReviewResults();
		 clickonReviewAllCheckBox();
		 clickOnApprove();
		
		}

	

	

}
