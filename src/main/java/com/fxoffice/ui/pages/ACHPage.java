package com.fxoffice.ui.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fxoffice.utility.ParameterService;

public class ACHPage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(ACHPage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;
	
	@FindBy(xpath = "//a[@title='ACH Application']")
	private WebElement ACH;
	
	@FindBy(xpath = "//span[contains(text(),'File Inquiry')]//")
	private WebElement ACH_FileInquiry;
	
	@FindBy(xpath = "//button[@title='Simple Search']")
	private WebElement ACH_SimpleSearch;
	
	@FindBy(xpath = "//label[contains(text(),'Primary Ref')]//..//..//input")
	private WebElement ACH_PrimaryRef;
	
	@FindBy(xpath = "//button[@title='Search']")
	private WebElement ACH_SearchACHTransactionButton;
	 
	@FindBy(xpath = "//span[contains(text(),'File Inquiry')]//..")
	private WebElement ACH_Fileinquiry;
	
	@FindBy(xpath = "//span[contains(text(),'Exceptions')]//..")
	private WebElement ACH_Exceptions;
	
	@FindBy(xpath = "//div[contains(text(),'IN/OUT')]//..//..//../input")
	private WebElement ACH_INOUT;
	
	@FindBy(xpath = "//label[contains(text(),'File Name')]//..//..//input ")
	private WebElement ACH_FileName;
	
	@FindBy(xpath = "//label[contains(text(),'Payment Id')]//..//..//input")
	private WebElement ACH_PaymentId;
	
	@FindBy(xpath = "//label[contains(text(),'Trace Number')]//..//..//input")
	private WebElement ACH_TraceNumber;
	

	@FindBy(xpath = "//span[contains(text(),'Transactions')]//..")
	private WebElement ACH_Transactions;
	
	@FindBy(xpath = "//input[@id='mat-radio-4-input']//..//..")
	private WebElement ACH_SelectReversalOption;
	
	
	@FindBy(xpath = "//input[@placeholder='Status']")
	private WebElement ACH_ReversalFileStatus;
	
	@FindBy(xpath = "//button[contains(text(),'Initiate Misrouted Return')]")
	private WebElement ACH_InitiateMisroutedReturn;
	
	@FindBy(xpath = "//div[contains(text(),'Return Code')]//..//input")
	private WebElement ACH_ReturnCode;
	
	@FindBy(xpath = "//div[contains(text(),'R01 - ')]")
	private WebElement ACH_ReturnCodeOption;
	
	@FindBy(xpath = "//label[contains(text(),'Corrected Company Id')]//..//..//input")
	private WebElement ACH_CompanyId;
	
	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement alertDialog;

	
	// Constructor
	public ACHPage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Login Page of Swag Labs.");
		driverWait.until(ExpectedConditions.titleContains("Portal"));
	}

	// Page Objects

	public void clickACHApplicationMenu() {
		LOGGER.info("Clicking ACH Application Menu...!!! ");
		clickElement(driver, ACH);
		waitForSpinnerIcon(driver);
		
	}
	
	public void ClickFileInquiryTab()
	{
		
			LOGGER.info("Clicking File Inquiry tab...");
			driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			driverWait.until(ExpectedConditions.visibilityOf(ACH_Fileinquiry));
			driverWait.until(ExpectedConditions.elementToBeClickable(ACH_Fileinquiry));
			waitForSpinnerIcon(driver);
			
		}
	
	public void ClickExceptionsTab()
	{
		
			LOGGER.info("Clicking ACH Exceptions tab...");
			driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			clickElement(driver, ACH_Exceptions);
			waitForSpinnerIcon(driver);
		 	waitSeconds(5);
		}
	

	public void ClickonSimpleSearch()
	{
		LOGGER.info("Clicking ACH simple search...!!! ");
		clickElement(driver, ACH_SimpleSearch);
	
	}

	public void EnterSimpleSearchCriteria(String FileName)
	{
		LOGGER.info("Clicking ACH simple search Critirea Option...!!! ");
		enterText(driver, ACH_FileName,FileName);
		waitSeconds(5);  
	}
	
	public void ClickSearchCriteriaButton()
	{
		LOGGER.info("Clicking ACH simple search Critirea Button...!!! ");
		clickElement(driver, ACH_SearchACHTransactionButton);
		waitForSpinnerIcon(driver);
	}
	
	public void ACH_SearchFileInquiry(String FileName)
	{
		ClickonSimpleSearch();
		EnterSimpleSearchCriteria(FileName);
		ClickSearchCriteriaButton();
		waitSeconds(8);
	
	}
	
	
	public void ACH_SearchReversal_ByPaymentId()
	{
		ClickonSimpleSearch();
		String PaymentId = ParameterService.getParameter("PaymentID");
		System.out.println("PaymentID to click in ACH Exceptions "+PaymentId);

		System.out.println("Select the radio button option !!! ");
		clickElement(driver, ACH_SelectReversalOption);
		
		waitSeconds(3);
		enterText(driver, ACH_PaymentId,PaymentId);
		waitSeconds(3);
		ClickSearchCriteriaButton();
		waitSeconds(5);
	
	}
	
	public void ACH_SearchReversal_ByTraceNumber()
	{
		ClickonSimpleSearch();
	//	String TraceId = ParameterService.getParameter("TraceId");
		String TraceId="202110182227529";
		System.out.println("Searching by TraceId "+TraceId);
	
		System.out.println("Select the radio button option !!! ");
		clickElement(driver, ACH_SelectReversalOption);
		waitSeconds(3);
		enterText(driver, ACH_TraceNumber,TraceId);
		waitSeconds(3);  

		ClickSearchCriteriaButton();
		waitSeconds(3);
	
	}
	
public String viewPaymentFromACHExceptions(String reversalstatus) {
		
		LOGGER.info("Clicking on View paymentid for ACH Reversal Details ");
		String filestatus=null;
		String TraceId = ParameterService.getParameter("TraceId");
	
		By ViewPaymentxpath = By.xpath("//span[contains(@title,'"+TraceId+"')]/ancestor::*/following-sibling::datatable-body-cell//div//i[contains(@title,'View')]");
		                                
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(ViewPaymentxpath)).click();
		waitSeconds(5);
		
		filestatus = ACH_ReversalFileStatus.getAttribute("value");
		System.out.println("ACH File status received "+filestatus);
		
		return filestatus;
	}
public void ClickOnInitiateMisroutedReturn()
{
	clickElement(driver, ACH_InitiateMisroutedReturn);
	
	driverWait.until(ExpectedConditions.visibilityOf(alertDialog));
	String txtAlertDialog = alertDialog.getText().trim();
	System.out.println("Misroute status : " + txtAlertDialog);
	
	waitSeconds(5);
	
}

public void UpdateReturnInfo(String ReturnCode,String achCompanyId)
{
	
	enterText(driver, ACH_ReturnCode,ReturnCode);
	clickElement(driver, ACH_ReturnCodeOption);
	enterText(driver, ACH_CompanyId,achCompanyId);
	
}

public void UpdateReturnInfo(String achCompanyId)
{
	
	enterText(driver, ACH_CompanyId,achCompanyId);
	
}

public String readReversalStatus()
{
	String filestatus = ACH_ReversalFileStatus.getAttribute("value");
	System.out.println("ACH File status received After initiate misrouted return "+filestatus);
	driver.switchTo().defaultContent();
	return filestatus;

}
}
