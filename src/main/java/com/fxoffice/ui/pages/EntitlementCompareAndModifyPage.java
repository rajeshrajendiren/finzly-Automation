package com.fxoffice.ui.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
//import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class EntitlementCompareAndModifyPage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(EntitlementCompareAndModifyPage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;
	
	
	@FindBy(id = "FXOFFICE_ENTITLEMENT_VIEW-textEl")
	private WebElement EntitlementMenu;
	
	@FindBy(xpath = "//span[text()='Search']")
	private WebElement search;
	
    @FindBy(xpath = "//span[text()='Approve']")
	private WebElement approveBtn;
	
	@FindBy(xpath = "//label[text()='Application:']/../..//td[2]/div")
	private WebElement entitlementApplication;

	@FindBy(xpath = "//li[text()='FXOffice']")
	private WebElement applicationDropdown;
	
	@FindBy(name = "groupName")
	private WebElement entityTypeInput;
	
	
	@FindBy(xpath="//input[@name='appCode']")
	private WebElement appCodeDropDown;
	
	
	@FindBy(xpath="//li[contains(text(),'FXOffice')]")
	private WebElement fxOfficeApp;
	
	
	static List menuArray=new ArrayList();
	static List menuNewArray=new ArrayList();
	static int count=0;
	static int count_new=0;
	JavascriptExecutor js;
	
	// Constructor
	
	public EntitlementCompareAndModifyPage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Home Page of FXOffice Application.");
//		driverWait.until(ExpectedConditions.titleContains("FX STAR"));
		js = (JavascriptExecutor) driver;
	}


// Page Objects
	
	
	public void clickEntitlementButton() {
		LOGGER.info("Clicking EntitlementButton");
		waitForPageLoad(driver);
		try { Thread.sleep(3000);} catch (InterruptedException e) {}
		clickElement(driver, EntitlementMenu);
	}
	
	public void launchApplication(String url) {
		driver.get(url);
	}
	
	
	

	public void filterEntitlement() throws Exception {
		jsClick(driver, entitlementApplication);
		Thread.sleep(3000);
		applicationDropdown.click();
		entityTypeInput.sendKeys("Group Access");
		jsClick(driver, search);
		
	}
	
	
	public void searchEntitlement() {
		LOGGER.info("Clicking Entitlenment Manager Button");
		waitForPageLoad(driver);
		try { Thread.sleep(3000);} catch (InterruptedException e) {}
		 count = driver.findElements(By.xpath("//div[@id='STATIC_ENTITLEMENT_UI_MANAGER_GRID-body']//tr//td/div[text()='General Access']")).size();
		System.out.println("count-->"+count);
		int sum=0;
		for(int i=1;i<count;i++) {
			WebElement Element = driver.findElement(By.xpath("//div[@id='STATIC_ENTITLEMENT_UI_MANAGER_GRID-body']//tr["+i+"]"));

	        // Scrolling down the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", Element);
			String value=driver.findElement(By.xpath("//div[@id='STATIC_ENTITLEMENT_UI_MANAGER_GRID-body']//tr["+i+"]/td[2]")).getText();
		//	System.out.println("value==>"+value);
			
			if(value.equals("General Access")) {
				String authority=driver.findElement(By.xpath("//div[@id='STATIC_ENTITLEMENT_UI_MANAGER_GRID-body']//tr["+i+"]/td[3]")).getText();
				String desc=driver.findElement(By.xpath("//div[@id='STATIC_ENTITLEMENT_UI_MANAGER_GRID-body']//tr["+i+"]/td[4]")).getText();
				sum=sum+1;
				System.out.println("authority==>"+authority+"desc==>"+desc);
				System.out.println("sum==>"+sum);
				menuArray.add(value+":"+authority+":"+desc);
			}  
		}
		System.out.println("====>"+menuArray);
	}
	
	public void searchEntitlementAndStoreVal() {
		LOGGER.info("Clicking Entitlenment Manager Button");
		waitForPageLoad(driver);
		try { Thread.sleep(3000);} catch (InterruptedException e) {}
	    count_new = driver.findElements(By.xpath("//div[@id='STATIC_ENTITLEMENT_UI_MANAGER_GRID-body']//tr//td/div[text()='General Access']")).size();
		System.out.println("count111-->"+count);
		int sum=0;
		for(int i=1;i<count_new;i++) {
			
			WebElement Element = driver.findElement(By.xpath("//div[@id='STATIC_ENTITLEMENT_UI_MANAGER_GRID-body']//tr["+i+"]/td/div[text()='General Access']"));

	        // Scrolling down the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", Element);
			
			String value=driver.findElement(By.xpath("//div[@id='STATIC_ENTITLEMENT_UI_MANAGER_GRID-body']//tr["+i+"]/td[2]")).getText();
		//	System.out.println("value==>"+value);
			
			if(value.equals("General Access")) {
				String authority=driver.findElement(By.xpath("//div[@id='STATIC_ENTITLEMENT_UI_MANAGER_GRID-body']//tr["+i+"]/td[3]")).getText();
				String desc=driver.findElement(By.xpath("//div[@id='STATIC_ENTITLEMENT_UI_MANAGER_GRID-body']//tr["+i+"]/td[4]")).getText();
				sum=sum+1;
				System.out.println("authority==>"+authority+"desc==>"+desc);
				System.out.println("sum==>"+sum);
				menuNewArray.add(value+":"+authority+":"+desc);
			}
		}
		System.out.println("====>"+menuNewArray);
		
		validateComparedValues();
		/*
		 * for(Object individualVal: menuArray ) {
		 * System.out.println("====>"+individualVal); boolean
		 * flag=menuNewArray.contains(individualVal); if(flag==true) {
		 * 
		 * }else { System.out.println("ELEMENT "+individualVal+" NOT PRESENT"); }
		 * 
		 * }
		 */
		
	}
	
	public void validateComparedValues() {
		System.out.println("====>"+count);
		System.out.println("====>"+count_new);
		System.out.println("====>"+menuArray);
		System.out.println("====>"+menuNewArray);
		
		menuNewArray.removeAll(menuArray);
		System.out.println("Result: " + menuNewArray);
	}
	
	
	public void clickAppAndSearch() {
		
		jsClick(driver,appCodeDropDown);
		jsClick(driver,fxOfficeApp);
		jsClick(driver,search);
		waitSeconds(5);
		
		
	}
	
	public void SearchAndCompare() {
	
        String authority[]={"FXOFFICE_ADMIN", "FXOFFICE_BACK_OFFICE", "FXOFFICE_BOOKS_ADD_EDIT", "FXOFFICE_BOOKS_DELETE", "FXOFFICE_BOOKS_FIELD_AUDIT", "FXOFFICE_BOOKS_RECORD_AUDIT", "FXOFFICE_BOOK_ROUTER_ADD_EDIT", "FXOFFICE_BOOK_ROUTER_DELETE", "FXOFFICE_BOOK_ROUTER_VIEW", "FXOFFICE_BOOK_VIEW", "FXOFFICE_BRANCH_USER_MANAGER_ACTIVATE", "FXOFFICE_BRANCH_USER_MANAGER_ADD_UPDATE", "FXOFFICE_BRANCH_USER_MANAGER_BRANCHES", "FXOFFICE_BRANCH_USER_MANAGER_DELETE", "FXOFFICE_BRANCH_USER_MANAGER_DOWNLOAD", "FXOFFICE_BRANCH_USER_MANAGER_ENTITLEMENTS", "FXOFFICE_BRANCH_USER_MANAGER_FIELD_AUDIT", "FXOFFICE_BRANCH_USER_MANAGER_RECORD_AUDIT", "FXOFFICE_BRANCH_USER_MANAGER_SUSPEND", "FXOFFICE_BRANCH_USER_MANAGER_ACTIVITES", "FXOFFICE_BRANCH_USER_VIEW", "FXOFFICE_BUNIT_FX_BRANCH_ANNOUNCEMENT", "FXOFFICE_BUNIT_FX_WEB_ANNOUNCEMENT", "FXOFFICE_BUNIT_MARKET_COMMENTARY", "FXOFFICE_BUSINESS_UNIT_VIEW", "FXOFFICE_CASE_ADD_EDIT", "FXOFFICE_CASE_ACTIVITIES", "FXOFFICE_CASE_COMPLETE_REPORT", "FXOFFICE_CASE_CLIENT_REPORT", "FXOFFICE_CASE_DOCUMENT", "FXOFFICE_CASE_DOCUMENT_DELETE", "FXOFFICE_CASE_DOCUMENT_UPLOAD", "FXOFFICE_CASE_DOWNLOAD", "FXOFFICE_CASE_FIELD_AUDIT", "FXOFFICE_CASE_FORM_RESOLVE", "FXOFFICE_CASE_INVESTIGATE", "FXOFFICE_CASE_FORM_CLOSE", "FXOFFICE_CASE_INVESTIGATION", "FXOFFICE_CASE_NOTE", "FXOFFICE_CASE_NOTE_ADD_EDIT", "FXOFFICE_CASE_RECORD_AUDIT", "FXOFFICE_CLIENT_ACCOUNT_VIEW", "FXOFFICE_CONFIRMATION_VIEW", "FXOFFICE_COST_CENTER_VIEW", "FXOFFICE_COUNTRY_ADD_EDIT", "FXOFFICE_COUNTRY_DELETE", "FXOFFICE_COUNTRY_FIELD_AUDIT", "FXOFFICE_COUNTRY_DOWNLOAD", "FXOFFICE_COUNTRY_RECORD_AUDIT", "FXOFFICE_COUNTRY_VIEW", "FXOFFICE_CS_CHANGE_TEMPLATE", "FXOFFICE_CS_CONFIRM_TRADE", "FXOFFICE_CS_FIND_MATCHING", "FXOFFICE_CS_RECORD_AUDIT", "FXOFFICE_CS_REGENERATE_CONFIRM", "FXOFFICE_CS_RETRANSMIT_CONFIRM", "FXOFFICE_CURRENCY_ADD_EDIT", "FXOFFICE_CS_UPLOAD_SIGNED_CONFIRM", "FXOFFICE_CURRENCY_DELETE", "FXOFFICE_CURRENCY_DOWNLOAD", "FXOFFICE_CURRENCY_FIELD_AUDIT", "FXOFFICE_CURRENCY_PAIR_ADD_EDIT", "FXOFFICE_CURRENCY_PAIR_DELETE", "FXOFFICE_CURRENCY_PAIR_DOWNLOAD", "FXOFFICE_CURRENCY_PAIR_FIELD_AUDIT", "FXOFFICE_CURRENCY_PAIR_RECORD_AUDIT", "FXOFFICE_CURRENCY_PAIR_VIEW", "FXOFFICE_CURRENCY_RECORD_AUDIT", "FXOFFICE_CURRENCY_VIEW", "FXOFFICE_CUSTOM_ATTRIBUTES_VIEW", "FXOFFICE_CUSTOM_ATTRIBUTE_ADD_EDIT", "FXOFFICE_CUSTOM_ATTRIBUTE_DELETE", "FXOFFICE_DASHBOARD", "FXOFFICE_DATA_IMPORTER_IMPORT", "FXOFFICE_DATA_IMPORTER_VIEW", "FXOFFICE_DOCUMENTS_RETRANSMIT", "FXOFFICE_DOCUMENT_VIEW", "FXOFFICE_DOCUMENT_CENTER", "FXOFFICE_DRAFT_CLEAR", "FXOFFICE_DRAFT_DELETE", "FXOFFICE_DRAFT_DOWNLOAD", "FXOFFICE_DRAFT_VIEW", "FXOFFICE_DTCC_REPORTING_VIEW", "FXOFFICE_DTCC_RESUBMIT", "FXOFFICE_ENTITLEMENT_ADD_EDIT", "FXOFFICE_ENTITLEMENT_VIEW", "FXOFFICE_ENTITLEMENT_DELETE", "FXOFFICE_ENTITY_ACTIVATE", "FXOFFICE_ENTITY_ACTIVITIES", "FXOFFICE_ENTITY_ADD_EDIT", "FXOFFICE_ENTITY_BANK_ACC_ACTIVATE", "FXOFFICE_ENTITY_BANK_ACC", "FXOFFICE_ENTITY_BANK_ACC_ADD_EDIT", "FXOFFICE_ENTITY_BANK_ACC_FIELD_AUDIT", "FXOFFICE_ENTITY_BANK_ACC_DELETE", "FXOFFICE_ENTITY_BANK_ACC_SUSPEND", "FXOFFICE_ENTITY_BANK_ACC_RECORD_AUDIT", "FXOFFICE_ENTITY_BENE", "FXOFFICE_ENTITY_BENE_ADD_EDIT", "FXOFFICE_ENTITY_BENE_ACTIVATE", "FXOFFICE_ENTITY_BENE_FIELD_AUDIT", "FXOFFICE_ENTITY_BENE_RECORD_AUDIT", "FXOFFICE_ENTITY_BENE_DELETE", "FXOFFICE_ENTITY_BENE_SUSPEND", "FXOFFICE_ENTITY_CONTACTS", "FXOFFICE_ENTITY_CONTACT_ACTIVITIES", "FXOFFICE_ENTITY_CONTACT_ACTIVATE", "FXOFFICE_ENTITY_CONTACT_DELETE", "FXOFFICE_ENTITY_CONTACT_ADD_EDIT", "FXOFFICE_ENTITY_CONTACT_ENTITLEMENTS", "FXOFFICE_ENTITY_CONTACT_RECORD_AUDIT", "FXOFFICE_ENTITY_CONTACT_SUSPEND", "FXOFFICE_ENTITY_CONTACT_FIELD_AUDIT", "FXOFFICE_ENTITY_CUSTOM_ATTRIBUTE", "FXOFFICE_ENTITY_DOCUMENTS", "FXOFFICE_ENTITY_FIELD_AUDIT", "FXOFFICE_ENTITY_ENTITLEMENTS", "FXOFFICE_ENTITY_MANAGER", "FXOFFICE_ENTITY_PREF", "FXOFFICE_ENTITY_PREF_ACTIVATE", "FXOFFICE_ENTITY_PREF_ADD_EDIT", "FXOFFICE_ENTITY_PREF_DELETE", "FXOFFICE_ENTITY_RECORD_AUDIT", "FXOFFICE_ENTITY_SSI", "FXOFFICE_ENTITY_SSI_ADD_EDIT", "FXOFFICE_ENTITY_SUSPEND", "FXOFFICE_ENTITY_SSI_DELETE", "FXOFFICE_ENTITY_UPLOAD_DOCUMENT", "FXOFFICE_FEE_ADD_EDIT", "FXOFFICE_FEE_CANCEL", "FXOFFICE_FEE_REVERSE", "FXOFFICE_FEE_VIEW", "FXOFFICE_FIXING_SOURCE_ADD_EDIT", "FXOFFICE_FIXING_SOURCE_DELETE", "FXOFFICE_FIXING_SOURCE_FIELD_AUDIT", "FXOFFICE_FIXING_SOURCE_VIEW", "FXOFFICE_GL_ACCOUNTS_ACTIVATE", "FXOFFICE_FIXING_SOURCE_RECORD_AUDIT", "FXOFFICE_GL_ACCOUNTS_ADD_EDIT", "FXOFFICE_GL_ACCOUNTS_DELETE", "FXOFFICE_GL_ACCOUNTS_RECORD_AUDIT", "FXOFFICE_GL_ACCOUNTS_FIELD_AUDIT", "FXOFFICE_GL_ACCOUNTS_SUSPEND", "FXOFFICE_GL_ACCOUNT_BALANCE_DOWNLOAD", "FXOFFICE_GL_ACCOUNT_BALANCE", "FXOFFICE_HOLIDAY_DELETE", "FXOFFICE_HOLIDAY_ADD_EDIT", "FXOFFICE_HOLIDAY_VIEW", "FXOFFICE_JOURNAL_ENTRY", "FXOFFICE_JOURNAL_ENTRY_ADD_MANUAL_ENTRY", "FXOFFICE_JOURNAL_ENTRY_DOWNLOAD", "FXOFFICE_JOURNAL_ENTRY_RECORD_AUDIT", "FXOFFICE_JOURNAL_ENTRY_REVERSE", "FXOFFICE_LEGAL_ENTITY_VIEW", "FXOFFICE_MANAGE_GL_ACCOUNTS", "FXOFFICE_JOURNAL_ENTRY_APPROVE", "FXOFFICE_MANAGE_MESSAGE_ANNOUNCEMENTS", "FXOFFICE_MANAGE_NOSTRO_ACCOUNTS", "FXOFFICE_MASTER_ACCOUNT_VIEW", "FXOFFICE_MCA_CLIENT_ACCOUNT_ACTIVATE", "FXOFFICE_MCA", "FXOFFICE_MCA_CLIENT_ACCOUNT_ADD_EDIT", "FXOFFICE_MCA_CLIENT_ACCOUNT_DEBIT", "FXOFFICE_MCA_CLIENT_ACCOUNT_CREDIT", "FXOFFICE_MCA_CLIENT_ACCOUNT_DOWNLOAD", "FXOFFICE_MCA_CLIENT_ACCOUNT_DELETE", "FXOFFICE_MCA_CLIENT_ACCOUNT_FIELD_AUDIT", "FXOFFICE_MCA_CLIENT_ACCOUNT_GENERATE", "FXOFFICE_MCA_CLIENT_ACCOUNT_RECORD_AUDIT", "FXOFFICE_MCA_CLIENT_ACCOUNT_SUSPEND", "FXOFFICE_MCA_MASTER_ACCOUNT_ADD_EDIT", "FXOFFICE_MCA_MASTER_ACCOUNT_DELETE", "FXOFFICE_MCA_MASTER_ACCOUNT_DOWNLOAD", "FXOFFICE_MCA_MASTER_ACCOUNT_FIELD_AUDIT", "FXOFFICE_NOSTRO_ACCOUNTS_ACTIVATE", "FXOFFICE_NOSTRO", "FXOFFICE_NOSTRO_ACCOUNTS_DELETE", "FXOFFICE_NOSTRO_ACCOUNTS_ADD_EDIT", "FXOFFICE_NOSTRO_ACCOUNTS_FIELD_AUDIT", "FXOFFICE_NOSTRO_ACCOUNTS_SUSPEND", "FXOFFICE_NOSTRO_ACCOUNTS_RECORD_AUDIT", "FXOFFICE_NOSTRO_RECON_MANAGE", "FXOFFICE_NOSTRO_TRANSFER", "FXOFFICE_NOSTRO_RECON_VIEW", "FXOFFICE_OFAC_LEVEL1_APPROVER", "FXOFFICE_OFAC_LEVEL2_APPROVER", "FXOFFICE_OFAC_SEARCH_VIEW", "FXOFFICE_OFAC_SEARCH_DOWNLOAD", "FXOFFICE_OFAC_WHITELIST_UNLIST", "FXOFFICE_OFAC_WHITELIST_VIEW_HIT", "FXOFFICE_PROCESS_MONITOR_VIEW", "FXOFFICE_PRODUCT_ADD_EDIT", "FXOFFICE_OFAC_WHITELIST_VIEW", "FXOFFICE_PRODUCT_DELETE", "FXOFFICE_PRODUCT_FIELD_AUDIT", "FXOFFICE_PRODUCT_RECORD_AUDIT", "FXOFFICE_QUEUE_MONITOR_RELEASE_ALL", "FXOFFICE_PRODUCT_VIEW", "FXOFFICE_RATE_CONFIG_ADD_EDIT", "FXOFFICE_RATE_CONFIG_DELETE", "FXOFFICE_QUEUE_MONITOR_VIEW", "FXOFFICE_RATE_CONFIG_VIEW", "FXOFFICE_RELATIONSHIP_MANAGER_VIEW", "FXOFFICE_REPORT_BUILDER_DELETE_TEMPLATE", "FXOFFICE_REPORT_BUILDER_DOWNLOAD", "FXOFFICE_REPORT_BUILDER_UPLOAD_TEMPLATE", "FXOFFICE_REPORT_BUILDER_VIEW", "FXOFFICE_RETAIL_VIEW", "FXOFFICE_RETAIL", "FXOFFICE_RM_ADD_EDIT", "FXOFFICE_RM_DELETE", "FXOFFICE_SC_ADD_OPERATIONS_NOTES", "FXOFFICE_SC_EXPORT_EXCEL", "FXOFFICE_SC_AUTHORIZE", "FXOFFICE_SC_FLAG_SETTLEMENT", "FXOFFICE_SC_FLAG_SUPPRESS_PAYMENT", "FXOFFICE_SC_INSTRUCT", "FXOFFICE_SC_MCA_RETRY_MEMOPOST", "FXOFFICE_SC_MCA_OVERRIDE_MEMOPOST", "FXOFFICE_SC_NET", "FXOFFICE_SC_OFAC_APPROVE", "FXOFFICE_SC_OFAC_REJECT", "FXOFFICE_SC_OFAC_VIEW_ERROR", "FXOFFICE_SC_OFAC_RERUN", "FXOFFICE_SC_OVERRIDE_MEMOPOST", "FXOFFICE_SC_OFAC_WHITELIST", "FXOFFICE_SC_RECORD_AUDIT", "FXOFFICE_SC_RETRY_MEMOPOST", "FXOFFICE_SC_RELEASE", "FXOFFICE_SC_REVERSE_MEMOPOST", "FXOFFICE_SC_REVERSE_SETTLEMENT", "FXOFFICE_SC_SAVE_SSI", "FXOFFICE_SC_UNNET", "FXOFFICE_SC_VERIFY", "FXOFFICE_SECURITY_SETTINGS", "FXOFFICE_SC_SPLIT", "FXOFFICE_SETTLEMENT_VIEW", "FXOFFICE_STATEMENTS_VIEW", "FXOFFICE_STATIC_DATA", "FXOFFICE_SWIFT_MESSAGE_CREATE", "FXOFFICE_SWIFT_MESSAGE_EDIT", "FXOFFICE_SWIFT_MESSAGE_UPLOAD", "FXOFFICE_SYSTEM_ALERT_VIEW", "FXOFFICE_SWIFT_MESSAGE_VIEW", "FXOFFICE_SYSTEM_DATE_UPDATE", "FXOFFICE_TRANSACTION_DOWNLOAD", "FXOFFICE_TRANSACTION_VIEW", "FXOFFICE_USER_MANAGER_ACTIVITES", "FXOFFICE_USER_MANAGER_ACTIVATE", "FXOFFICE_USER_MANAGER_ADD_EDIT", "FXOFFICE_USER_MANAGER_DOWNLOAD", "FXOFFICE_USER_MANAGER_DELETE", "FXOFFICE_USER_MANAGER_FIELD_AUDIT", "FXOFFICE_USER_MANAGER_RECORD_AUDIT", "FXOFFICE_USER_MANAGER_SUSPEND", "FXOFFICE_USER_ROLE_ADD_EDIT", "FXOFFICE_USER_ROLE_VIEW", "FXOFFICE_USER_VIEW", "FXOFFICE_VALUE_DATE_ADD_EDIT", "FXOFFICE_VALUE_DATE_DELETE", "FXOFFICE_USER_ROLE_DELETE", "FXOFFICE_VALUE_DATE_VIEW", "FXOFFICE_VAULT_ACCOUNTS_ADD_EDIT", "FXOFFICE_VAULT_ACCOUNTS_ACTIVATE", "FXOFFICE_VAULT_ACCOUNTS_DELETE", "FXOFFICE_VAULT_VIEW", "FXOFFICE_VAULT_ACCOUNTS_SUSPEND", "FXOFFICE_WORKFLOW_JOBS_VIEW", "FXOFFICE_WORKFLOW_JOB_EXECUTE", "FXOFFICE_WORKFLOW_MANAGER_CREATE_NEW_JOB", "FXOFFICE_WORKFLOW_MANAGER_DELETE", "FXOFFICE_WORKFLOW_MANAGER_FIELD_AUDIT", "FXOFFICE_WORKFLOW_MANAGER_MODIFY", "FXOFFICE_WORKFLOW_MANAGER_ADD", "FXOFFICE_WORKFLOW_MANAGER_VIEW", "FX_OFFICE_CLOSING_RATE_REPORT", "FX_OFFICE_LEGAL_ENTITY_BENEFICIARIES_REPORT", "FX_OFFICE_LEGAL_ENTITY_REPORT", "FX_OFFICE_MCA_DETAILS_REPORT", "FX_OFFICE_OFAC_RESULTS_REPORT", "FX_OFFICE_NOSTRO_TRANSACTIONS_REPORT", "FX_OFFICE_REIMBURSEMENT_REPORT", "FX_OFFICE_TRADE_REPORT_RETAIL_BRANCH", "FX_OFFICE_TRADE_REPORT_RETAIL_CLIENT", "FX_OFFICE_USER_AUDIT_REPORT", "FX_OFFICE_USER_SECURITY_REPORT", "FX_OFFICE_ALL_ENTITLEMENT_REPORT", "FXOFFICE_TEMPLATE_VIEW", "FXOFFICE_DRAFT_ADD_EDIT", "FXOFFICE_DRAFT_REVERSE", "FXOFFICE_DRAFT_REJECT", "FXOFFICE_DRAFT_ACTIVITIES", "FXOFFICE_DRAFT_FIELD_AUDIT", "FXOFFICE_DRAFT_RECORD_AUDIT", "FXOFFICE_DRAFT_ISSUANCE_VIEW", "FXOFFICE_DRAFT_SAVE", "FXOFFICE_DRAFT_NEW_EDIT", "FX_OFFICE_USER_ROLE", "FX_OFFICE_USER_ROLE2", "FX_OFFICE_USERROLES_ENTITLEMENTS_REPORT", "FXOFFICE_GL_ACCOUNTS_DOWNLOAD", "FXOFFICE_DRAFT_COLLECTIONS_VIEW", "FXOFFICE_CASE_FEE", "FXOFFICE_CASE_FEE_ADD_EDIT", "FXOFFICE_CASE_FEE_CANCEL", "FXOFFICE_DRAFT_EXPORT", "FXOFFICE_PROCESS_INCOMING_MESSAGES", "FX_OFFICE_USER_ACTIVITY_DETAILS_REPORT", "EXECUTE_MARKETING_CUSTOMER_REPORT", "EXECUTE_CASH_LINK_REPORT", "EXECUTE_ALL_INVESTIGATIONS_REPORT", "FXOFFICE_SYNC_CUSTOMER_PROFILE", "FXOFFICE_SC_ADD_SENDER_TO_RECEIVER_INFO", "EXECUTE_CHECK_DETAILS_REPORT", "EXECUTE_DRAFT_DETAILS_REPORT", "EXECUTE_FX_SPTFWD_AFFILIATE_REPORT", "EXECUTE_OPEN_MCA_REPORT", "EXECUTE_AFFILIATE_PROFIT_REPORT", "FXOFFICE_FEE_CONFIGURATION_ADD_UPDATE", "FXOFFICE_FEE_CONFIGURATION_DELETE", "FXOFFICE_FEE_CONFIGURATION_RECORD_AUDIT", "FXOFFICE_FEE_CONFIGURATION_FIELD_AUDIT", "FXOFFICE_FEE_CONFIGURATION_VIEW", "VIEW_RESULTS_OPERATIONS", "APPROVE_HIT_OPERATIONS", "REJECT_HIT_OPERATIONS", "APPROVE_SCREENING_OPERATIONS", "ESCALATE_SCREENING_OPERATIONS", "NOTIFY_SCREENING_OPERATIONS", "APPROVE_SCREENING_COMPLIANCE", "REJECT_SCREENING_COMPLIANCE", "SEIZE_SCREENING_COMPLIANCE", "SAVE_SETTINGS_COMPLIANCE", "REMOVE_WHITELIST_COMPLIANCE", "APPROVE_WHITELIST_COMPLIANCE", "FXOFFICE_COMPLIANCE", "ADD_WHITELIST_COMPLIANCE", "REVIEW_SCREENING_COMPLIANCE", "FXOFFICE_FEE_RECORD_AUDIT", "FXOFFICE_FEE_FIELD_AUDIT", "FXOFFICE_EXCLUSION_LIST_VIEW", "FXOFFICE_EXCLUSION_LIST_DELETE", "FXOFFICE_EXCLUSION_LIST_ADD_EDIT", "FXOFFICE_SC_ENABLE_COVER_MESSAGE", "FXOFFICE_EXCLUSION_LIST_DOWNLOAD", "FXOFFICE_EXCLUSION_LIST_FIELD_AUDIT", "FXOFFICE_EXCLUSION_LIST_RECORD_AUDIT", "FXOFFICE_SECURITY_SETTINGS_VIEW", "FXOFFICE_COST_CENTER_ADD_EDIT", "FXOFFICE_COST_CENTER_DELETE", "FXOFFICE_EXCLUSION_LIST_ACTIVITES"};
        
        String entitlement[]={"Access Admin Menu", "Access Back Office Menu", "Add_Edit Book", "Delete Book", "Field Audit Book", "Record Audit Book", "Add_Edit Book Router", "Delete Book Router", "Access Book Router", "Access Books", "Activate FX STAR Branch User", "Add Edit FX STAR Branch User", "Branches FX STAR Branch User", "Delete FX STAR Branch User", "Download FX STAR Branch User List", "Entitlements FX STAR Branch User", "Field Audit FX STAR Branch User", "Record Audit FX STAR Branch User", "Suspend FX STAR Branch User", "Activities FX STAR Branch User", "Access Branch Users", "Add FX STAR Branch Announcements", "Add FX STAR Web Announcements", "Add FX STAR Market Commentary", "Access Business Units", "Add/Edit Case", "Case Activities", "Create Complete Report", "Create Client Report", "Access Case Documents", "Delete Case Document", "Upload Case Document", "Download Case ", "Case Field Audit", "Resolve Case", "Investigate Case", "Close Case ", "Access Case Investigation", "Access Case Notes", "Add/Edit Case Notes", "Case Record Audit", "Access Client Accounts", "Access Confirmations", "Access Cost Center Manager", "Add_EDIT Country", "Delete Country", "Field Audit Country", "Download Country List", "Record Audit Country", "Access Country", "Change template", "Confirm trade", "Find Matching MT 300", "Audit Confirmation", "Regenerate Confirm", "Retransmit Confirmations", "Add_Edit Currency", "Upload Signed Confirm", "Delete Currency", "Download Currency List", "Field Audit Currency", "Add_Edit Currency Pair Configuration", "Delete Currency Pair Configuration", "Download Currency Pair List", "Field Audit Currency pairs", "Record Audit Currency pairs", "Access Currency Pairs", "Record Audit Currency", "Access Currency", "Access Custom Attributes", "Add_Edit Custom Attributes", "Delete Custom Attributes", "Access Dashboard Menu", "Import Data", "Access Data Importer", "Retransmit Document", "Access Documents", "Access Document Center Menu", "Clear Draft", "Delete Draft", "Download Draft", "Access Drafts", "Access DTCC Reporting", "Resubmit DTCC Reports.", "Add_Edit Entitlement", "Access Entitlement", "Delete Entitlement", "Activate Legal Entity", "LE Activities", "Add_Edit Legal Entity", "Activate Bank Account in FXOffice", "Access LE Bank Accounts", "Add_Edit Bank Account in FXOffice", "Field Audit Bank Account in FXOffice", "Delete Bank Account in FXOffice", "Suspend Bank Account in FXOffice", "Record Audit Bank Account in FXOffice", "Access LE Beneficiaries", "Add_Edit Beneficiary in FXOffice", "Activate Beneficiary in FXOffice", "Field Audit Beneficiary in FXOffice", "Record Audit Beneficiary in FXOffice", "Delete Beneficiary in FXOffice", "Suspend Beneficiary in FXOffice", "Access LE Contacts", "Legal Contact Activities", "Activate Legal Contact", "Delete Legal Contacts", "Add_Edit Legal Contact", "Manage Legal Contact Entitlements", "Legal Contact Record Audit", "Suspend Legal Contact", "Legal Contact Field Audit", "Update LE Custom Attributes", "Access LE Documents", "LE Field Audit", "Manage LE Entitlements", "Access Enttity Manager Menu", "Access LE Notification Preference", "Activate Legal Contact Preferences", "Add_Edit Legal Contact Preferences", "Delete Legal Contact Preferences", "LE Record Audit", "Access LE SSI", "Add_Edit Standing Settlement Instructions", "Suspend Legal Entity", "Delete Standing Settlement Instructions", "Upload Legal Document", "Add_Edit Fee", "Cancel Fee", "Reverse Fee", "Access Fees", "Add_Edit Fixing Source", "Delete Fixing Source", "Field Audit Fixing Source", "Access Fixing Source", "Activate GL Account", "Record Audit Fixing Source", "Add_Edit GL Account", "Delete GL Account", "Record Audit GL Account", "Field Audit GL Account", "Suspend GL Account", "Download GL Account Balance", "Access GL Account Balance", "Delete Holidays", "Add_Edit Holidays", "Access Holidays", "Access Journal Entry", "Add Manual Entry", "Download Journal entries", "Record Audit Journal Entry", "Reverse Journal Entry", "Access Legal Entities", "Manage GL Accounts", "Approve Journal Entry", "Manage Message Announcements", "Manage Nostro Accounts", "Access Master Accounts", "Activate MCA Client Account", "Access MCA Menu", "Add_Edit MCA Client Account", "Manual Debit Transaction", "Manual Credit Transaction", "Download as Excel", "Delete MCA Client Account", "Field Audit MCA Client Account", "Generate MCA Statement", "Record Audit MCA Client Account", "Suspend MCA Client Account", "Add_Edit MCA Master Account", "Delete MCA Master Account", "Download as Excel", "Field Audit MCA Master Account", "Activate Nostro Account", "Access Nostro Menu", "Delete Nostro Account", "Add_Edit Nostro Account", "Field Audit Nostro Account", "Suspend Nostro Account", "Record Audit Nostro Account", "Reconcile Nostro Accounts", "Reconcile Nostro Transfer", "Access Nostro Reconciliations", "OFAC Level 1 Approver", "OFAC Level 2 Approver", "Access OFAC Search", "Download OFAC Search", "Unlist Whitelist", "View Whitelisted Hits", "Access Process Monitor", "Add_Edit", "Access OFAC Whitelist", "Delete Products", "Field Audit Products", "Record Audit Products", "Release All Workflow Stuck Requests", "Access Products", "Add_Edit Rate Config", "Delete Rate Config", "Access Queue Monitor", "Access Rate Config", "Access Relationship Manager", "Delete Report Template", "Download Report", "Upload Report Template", "Access Report Builder", "Access Retail-Retail", "Access Retail Menu", "Add_Edit Relationship Manager", "Delete Relationship Manager", "Add Opeations Notes", "Download as Excel", "Authorize Settlements", "Flag Settlement", "Flag Suppress Payment", "Instruct Settlements", "MCA-Retry MemoPost", "MCA Override MemoPost", "Net Settlements", "OFAC Approve Payment", "OFAC Reject", "Review OFAC Error Response", "Rerun OFAC Screening", "DDA Override Memopost", "OFAC Whitelist", "View Settlement Record Audit", "DDA Retry Memopost", "Release Settlements", "DDA Reverse Memopost", "Reverse Settlement", "Save as SSI", "Un-Net Settlements", "Verify Settlement", "Security Settings", "Split Settlements", "Access Settlements", "Access Nostro Statements", "Access Static Data Menu", "Create Swift Messages", "Edit Swift Messages", "Upload Swift Messages", "Access System Alerts", "Access Messages", "Access System Dates", "Download Transaction", "Access Transactions", "Activities FX STAR User", "Activate FX STAR User", "Add_Edit FX STAR User", "Download User List", "Delete FX STAR User", "Field Audit FX STAR User", "Record Audit FX STAR User", "Suspend FX STAR User", "Add_Edit FX STAR User Role", "Access User Roles", "Access Users", "Add_Edit Value Date", "Delete Value Date", "Delete FX STAR User Role", "Access Value Date", "Add_Edit Vault Account", "Activate Vault Account", "Delete Vault Account", "Access Retail-Vault", "Suspend Vault Account", "Access Workflow Jobs", "Execute Workflow Job", "Creates New Workflow Job", "Delete Workflow", "Field Audit Workflow Manager", "Modify Workflow", "Add Workflow", "Access Workflow Manager", "Closing Rate Report", "Legal Beneficiary Report", "Legal Entity Report", "MCA Details Report", "OFAC Report", "Nostro Transactions Report", "Reimbursement template", "Access Retail Branch Report", "Access Retail Client Report", "User Audit Report", "User Security Report", "All Entitlement report", "Access Template Manager", "Add Edit Drafts", "Reverse Draft", "Reject the draft", "Draft Activities", "Field Audit", "Record Audit", "Access Draft Issuance", "Save Drafts", "Create Edit Drafts", "User Roles Entitlement", "User Roles2 Entitlement", "UserRoles Entitlements Report", "Download GL Accounts", "Access Draft Collections", "Access Case Fees", "Add/Edit Case Fees", "Cancel Case Fees", "Export Draft.", "Process Incoming Swift Messages", "User Activity Detail Report", "Execute marketing customer report", "Execute cash link report", "Execute all investigation report", "Sync Customer Profile", "Suppress/Unsuppress Sender To Receiver Info", "Execute check details report", "Execute draft details report", "Execute FX SPTFWD report", "Execute Open MCA report", "Execute Affiliate profit report", "Add Edit FX STAR Fee Configuration", "Delete FX STAR Fee Configuration", "Record Audit FX STAR Fee Configuration", "Field Audit FX STAR Fee Configuration", "Access Fee Configuration", "View Results", "Reviewer Approve Hit", "Reviewer Reject Hit", "Operations Approve Screening", "Operations Escalate Screening", "Operations Notify Screening", "Compliance Approve Screening", "Compliance Reject Screening", "Compliance Seize Screening", "Compliance Settings", "Compliance Remove Whitelist", "Compliance Approve Whitelist", "Access Compliance", "Compliance Add Whitelist", "Compliance Review Screening", "Fxoffice Fee record audit", "Fxoffice Fee Field Audit", "Access Manage Exclusion List", "Delete Exclusion", "Add Edit Exclusion", "Enable/Disable Cover Message", "Download Exclusion List", "Field Audit Exclusion List", "Record Audit Exclusion List", "Access Security Settings Manager", "Add Edit Cost Center", "Delete Cost Center", "Activities Exclusion List"};
        WebElement table = driver.findElement(By.xpath("//div[contains(text(),'Access Admin Menu')]/../../.."));
        
        // Count the number of rows in the table
        int rowCount = table.findElements(By.tagName("tr")).size();
        System.out.println("Number of rows in uat: " + rowCount);
        System.out.println("Number of rows in qa3: " + authority.length);
        HashMap<String,String> outerMap = new HashMap<>();
        for(int i=0;i<authority.length;i++) {
        	outerMap.put(authority[i],entitlement[i]);
        	}
 
        //for (String auth : authority) {
            //WebElement authorityRow = driver.findElement(By.xpath("//td//div[text()='" + auth + "']/ancestor::td/following-sibling::td/div"));

           // System.out.println("Checking element for authority: " + auth);

            //if (!authorityRow.isDisplayed()) {
             //   System.out.println("Element not displayed for authority: " + auth);
             //   System.out.println("NOT AVAILABLE ELEMENT " + outerMap.get(auth));
              //  continue;
           // }

            //System.out.println("Element is displayed for authority: " + auth);
           // waitSeconds(3);
           // scrollIntoView(driver, authorityRow);

           // if ((authorityRow.getText().trim()).equals(outerMap.get(auth).trim())) {
              //  System.out.println("pass");
           // } else {
            //    System.out.println(authorityRow.getText() + " == " + outerMap.get(auth));
           // }
      //  }

        for (String auth : authority) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, 10);
                WebElement authorityRow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td//div[text()='" + auth + "']/ancestor::td/following-sibling::td/div")));

                scrollIntoView(driver, authorityRow);

                if ((authorityRow.getText().trim()).equals(outerMap.get(auth).trim())) {
                    System.out.println("pass");
                } else {
                    System.out.println(authorityRow.getText() + " == " + outerMap.get(auth));
                }
            } catch (TimeoutException e) {
                System.out.println("Element not found for authority: " + auth + ". Skipping...");
                continue;  // Skip to the next iteration of the loop
            }
        }
        System.out.println("---------------------------------------------------------Remaining-------------------------------------------------");

        for(int k=1;k<=rowCount;k++) {
        	boolean found=false;
    		String auth=driver.findElement(By.xpath("//div[@id='STATIC_ENTITLEMENT_UI_MANAGER_GRID-body']//tr["+k+"]/td[3]")).getText();
    		String auth_grpName=driver.findElement(By.xpath("//div[@id='STATIC_ENTITLEMENT_UI_MANAGER_GRID-body']//tr["+k+"]/td[2]")).getText();
        	for(int a=0;a<authority.length;a++) {
        
        		if(auth.equals(authority[a])) {
        			found=true;
        			break;
       		}
       	}
        	if(!found) {
        		System.out.println(auth_grpName+"|"+auth);
        	}
       }
       
        
        
	}
	
	
}

	
	
	
	
	
	
	
	
	