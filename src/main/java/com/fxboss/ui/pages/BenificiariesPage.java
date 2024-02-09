package com.fxboss.ui.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fxoffice.ui.pages.AbstractPage;

public class BenificiariesPage extends AbstractPage{
	private static final Logger LOGGER = LoggerFactory.getLogger(BenificiariesPage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;
	@FindBy(xpath="//a[contains(@id,'FXWEB_OPEN_TRADES')]/ancestor::li")
	private WebElement openTradesLink;

	@FindBy(xpath="//a[contains(@id,'AWAITING')]/ancestor::li")
	private WebElement awaitingLink;
	
	@FindBy(xpath="//span[text()='Add Beneficiary']")
	private WebElement addBeneficiary;
	
	@FindBy(xpath="//a[contains(text(),'International Beneficiary')]")
	private WebElement internationalBeneficiaries;
	
	@FindBy(xpath="//label[text()='Recipient Type*']/following-sibling::div//input[@value='Individual']")
	private WebElement individualType;
	
	@FindBy(xpath="//label[text()='Recipient Type*']/following-sibling::div//input[@value='Entity']")
	private WebElement entityType;
	
	@FindBy(xpath="//label[text()='Account Number*']/following-sibling::div/input")
	private WebElement accountNumber;
	
	@FindBy(xpath="//label[text()='IBAN*']/following-sibling::div/input")
	private WebElement iban;
	@FindBy(xpath="//label[text()='Reenter IBAN*']/following-sibling::div/input")
	private WebElement reenterIban;
	
	@FindBy(xpath="//label[text()='Reenter Account Number*']/following-sibling::div/input")
	private WebElement reenterAccountNumber;
	
	
	@FindBy(xpath="//label[text()='Country Where Bank is located*']/following-sibling::div/input")
	private WebElement locationOfBank;
	
	@FindBy(xpath="//label[text()='Swift/ Bic*']/following-sibling::div/input")
	private WebElement bicValue;
	
	@FindBy(xpath="//label[text()='Beneficiary Name*']/following-sibling::div/input")
	private WebElement beneficiaryName;
	
	@FindBy(xpath="//label[text()='Phone Number']/following-sibling::div/div/input")
	private WebElement phoneNumber;
	
	@FindBy(xpath="//label[text()='Template Name*']/following-sibling::div/input")
	private WebElement templateName;
	
	@FindBy(xpath="//label[text()='Address 1*']/following-sibling::div/input")
	private WebElement address1;
	
	@FindBy(xpath="//label[text()='Address 2']/following-sibling::div/input")
	private WebElement address2;
	
	@FindBy(xpath="//label[text()='Country*']/following-sibling::div/input")
	private WebElement country;
	
	@FindBy(xpath="//label[text()='City*']/following-sibling::div/input")
	private WebElement city;
	
	@FindBy(xpath="//label[text()='Email Address']/following-sibling::div/input")
	private WebElement emailAddress;
	
	@FindBy(xpath="//div[@class='iti__selected-flag']")
	private WebElement countryCode;
	
	@FindBy(xpath="//button[text()='Add Beneficiary']")
	private WebElement addBeneficiaryButton;
	
	@FindBy(xpath="//button[text()='Confirm']")
	private WebElement confirmBtnForBeneficiary;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public BenificiariesPage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Home Page of FXOffice Application.");
		driverWait.until(ExpectedConditions.titleContains("Galaxy Treasury"));
	}

	public boolean verifyBeneficiariesTab() {
		boolean flag = false;
		if (flag == false) {
			

		
			WebElement bulkUploadElementLocator = driver.findElement(By.xpath("//span[text()='Bulk Upload']"));
			WebElement AddBeneficiaryElementLocator = driver.findElement(By.xpath("//span[text()='Add Beneficiary']"));
			WebElement ManageBeneficiariesElementLocator = driver.findElement(By.xpath("//span[text()='Manage Beneficiaries']"));

			// Array of By locators
			WebElement[] elements = { 
					bulkUploadElementLocator, AddBeneficiaryElementLocator,ManageBeneficiariesElementLocator };
			driverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
			flag = true;
			waitSeconds(5);
			
		}
		return flag;
		
	}
	
	public void clickInternationalBeneficiary() {
		jsClick(driver, addBeneficiary);
		jsClick(driver, internationalBeneficiaries);
		//WebElement beneficiaryTabText=driver.findElement(By.xpath("//span[contains(text(),'Add International Beneficiary')]"));
		//driverWait.until(ExpectedConditions.visibilityOf(beneficiaryTabText));
		waitSeconds(20);
		
	}
	
	public void addBeneficiary() {
	
	}
	
	public void providePersonalDetail(String beneName,String tempName,String addressTxt,String countryTxt, String cityTxt, String email,String country_Code,String PhoneNumber) {
		waitSeconds(5);
		enterText(driver, beneficiaryName, beneName);
		enterText(driver, templateName,tempName);
		enterText(driver, address1,addressTxt);
		//enterText(driver, address2, null);
		enterText(driver, country, countryTxt);
		
		enterText(driver, city,cityTxt);
		enterText(driver, emailAddress,email);
		jsClick(driver, countryCode);
		WebElement chooseCountryCode=driver.findElement(By.xpath("//span[text()='"+country_Code+"' and @class='iti__country-name']"));
		jsClick(driver, chooseCountryCode);
		enterText(driver,phoneNumber, PhoneNumber);
		waitSeconds(10);
	}
	
	public void provideBeneficiaryBankDetail(String bankLocation, String accountCurrency, String lookUp, String bic, String accno) {
	    enterText(driver, locationOfBank, bankLocation);
	    locationOfBank.sendKeys(Keys.RETURN);

	   WebElement lookUpElement = driver.findElement(By.name("lookupMethod"));
	   Select lookupDropdown = new Select(lookUpElement);
	    lookupDropdown.selectByValue(lookUp);

	    WebElement accountCurrencyElement = driver.findElement(By.xpath("//label[text()='Account Currency*']/following-sibling::div/select"));
	    Select currencyDropdown = new Select(accountCurrencyElement);
	    currencyDropdown.selectByValue(accountCurrency);
	    waitSeconds(5);
	    /*if (accountNumber.isDisplayed()) {
	    	enterText(driver,accountNumber, accno);
		    enterText(driver, reenterAccountNumber, accno);
        } else if (iban.isDisplayed()) {
        	enterText(driver,iban, accno);
		    enterText(driver,reenterIban, accno);
        } else {
            System.out.println("Neither 'Account Number' nor 'IBAN' field is visible.");
            // Handle the case when neither field is visible
        }
	    */
	    try {
	    	enterText(driver,accountNumber, accno);
		    enterText(driver, reenterAccountNumber, accno);
            System.out.println("Input successfully fed to Account Number field");
        } catch (NoSuchElementException e1) {
            try {
            	enterText(driver,iban, accno);
    		    enterText(driver,reenterIban, accno);
            } catch (NoSuchElementException e2) {
                System.out.println("Neither 'Account Number' nor 'IBAN' field is visible.");
                // Handle the case when neither field is visible
            }
	    waitSeconds(2);
	    enterText(driver, bicValue,bic);
	    waitSeconds(30);
	    WebElement bicDropDown=driver.findElement(By.xpath("//strong[text()='"+bic+"']//parent::a"));
	    driverWait.until(ExpectedConditions.visibilityOf(bicDropDown));
	    jsClick(driver,bicDropDown);
	   waitSeconds(3);
	   
	   
	    System.out.println("Clicking Add Beneficiary Button----------------------------------------");}
	   
	}
	public void clickAddBeneficiary() {
		waitSeconds(5);
		 jsClick(driver, addBeneficiaryButton);
		 waitSeconds(5);
	}

	public void clickConfirmToSaveBeneficiary() {
		
		waitSeconds(5);
		 jsClick(driver,confirmBtnForBeneficiary);
		 waitSeconds(5);
	}





}
