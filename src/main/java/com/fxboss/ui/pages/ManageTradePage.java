package com.fxboss.ui.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fxoffice.ui.pages.AbstractPage;
import com.fxoffice.utility.ParameterService;

public class ManageTradePage extends AbstractPage{
	private static final Logger LOGGER = LoggerFactory.getLogger(NewTradePage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;
	@FindBy(xpath="//a[contains(@id,'FXWEB_OPEN_TRADES')]/ancestor::li")
	private WebElement openTradesLink;

	@FindBy(xpath="//a[contains(@id,'AWAITING')]/ancestor::li")
	private WebElement awaitingLink;

	@FindBy(xpath="//a[contains(@id,'FXWEB_AWAITING_AUTHORIZATION')]/ancestor::li")
	private WebElement awaitingAuthorizationLink;

	@FindBy(xpath="//a[contains(@id,'FXWEB_TRADE_ECONFIRM')]/ancestor::li")
	private WebElement awaitingConfirmLink;

	@FindBy(xpath="//a[contains(@id,'FXWEB_HISTORICAL_TRADES')]/ancestor::li")
	private WebElement historicalTradesLink;

	@FindBy(xpath="//a[contains(@id,'FXWEB_POSITION_BLOTTER')]/ancestor::li")
	private WebElement positionBlotterLink;

	@FindBy(xpath="//a[contains(@id,'FXWEB_MANAGE_SETTLEMENTS')]/ancestor::li")
	private WebElement manageSettlementsLink;
	
	@FindBy(xpath="(//a[text()='Instruct'])[1]")
	private WebElement instructBtn;
	
	@FindBy(xpath="//strong[text()='Instruct']/parent::span")
	private WebElement instructBtnOfSettlementInstruction;
	
	@FindBy(xpath="(//strong[text()='OK']/parent::span)[2]")
	private WebElement okBtnForInstructSuccess;
	
	@FindBy(xpath="//textarea[@name='purpose_of_payment_text']")
	private WebElement purposeOfPayment;
	
	@FindBy(xpath="//input[@class='cb_text_paydtls_to_bene']")
	private WebElement benePhoneNumber;
	
	@FindBy(xpath="//input[@name='cb_email_paydtls_to_bene']")
	private WebElement beneEmail;
	
	@FindBy(xpath="//input[@name='myEmailList']")
	private WebElement myEmail;
	
	@FindBy(xpath="//input[@name='myTextPhoneList']")
	private WebElement myPhoneNumber;
	
	
	
	//input[@class="cb_text_paydtls_to_bene"]
	//input[@name="cb_email_paydtls_to_bene"]
	//input[@name="cb_email_paydtls_to_bene"]
	//input[@name="myTextPhoneList"]

	
	 private List<String> bankDetailOfBeneficiary=new ArrayList<String>();
	   private  List<String> personDetailOfBeneficiary=new ArrayList<String>();


	public ManageTradePage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Home Page of FXOffice Application.");
		driverWait.until(ExpectedConditions.titleContains("Galaxy Treasury"));
	}
	public boolean verifyManageTrade() {
		LOGGER.info("Checking for Home Page loading...!!! ");
		boolean flag = false;
		if (flag == false) {
			WebElement openTradesLink = driver.findElement(By.id("FXWEB_OPEN_TRADES"));
			WebElement awaitingLink = driver.findElement(By.id("AWAITING"));
			WebElement awaitingAuthorizationLink = driver.findElement(By.id("FXWEB_AWAITING_AUTHORIZATION"));
			WebElement tradeEconfirmLink = driver.findElement(By.id("FXWEB_TRADE_ECONFIRM"));
			WebElement historicalTradesLink = driver.findElement(By.id("FXWEB_HISTORICAL_TRADES"));
			WebElement positionBlotterLink = driver.findElement(By.id("FXWEB_POSITION_BLOTTER"));
			WebElement manageSettlementsLink = driver.findElement(By.id("FXWEB_MANAGE_SETTLEMENTS"));


			// Array of By locators
			WebElement[] elements = { openTradesLink, awaitingLink, awaitingAuthorizationLink,
					tradeEconfirmLink, historicalTradesLink, positionBlotterLink,manageSettlementsLink };
			driverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
			flag = true;
		}

		return true;
	}
	
	/*public void verifyBookedData() {
		 List<String> list=new ArrayList<String>();
		
		WebElement search=driver.findElement(By.xpath("(//input[@type='search'])[1]"));
		enterText(driver, search,"22422");
		search.sendKeys(Keys.RETURN);
		waitSeconds(2);
         
		  List<WebElement> columns = driver.findElements(By.xpath("//tbody[contains(@id,'load-historical-trade')]//td"));

	        
	        int columnCount = columns.size();
	        
	        System.out.println("column Count-----------------------------------"+columnCount);
	        for(int i=1;i<columnCount;i++) {
		WebElement data=driver.findElement(By.xpath("//tbody[contains(@id,'load-historical-trade')]//td['"+i+"']"));
		list.add(data.getText());
		}
	        list.contains(ParameterService.getParameter("amount1"));
	        list.contains(ParameterService.getParameter("currency"));
	        list.contains(ParameterService.getParameter("product"));
	        list.contains(ParameterService.getParameter("Rate"));
	        list.contains(ParameterService.getParameter("ValueDate"));
	        list.contains(ParameterService.getParameter("TradeDate"));
	        list.contains(ParameterService.getParameter("anotherCurrency"));
	        list.contains(ParameterService.getParameter("amount"));
	        
		
		
	}*/
	 public boolean verifyBookedData() {
	        List<String> list = new ArrayList<String>();

	        WebElement search = driver.findElement(By.xpath("(//input[@type='search'])[1]"));
	        enterText(driver, search,ParameterService.getParameter("TradeNo"));
	        search.sendKeys(Keys.RETURN);
	        waitSeconds(2);

	        List<WebElement> columns = driver.findElements(By.xpath("//tbody[contains(@aria-live,'polite')]//td"));

	        for (WebElement column : columns) {
	        	System.out.println(column.getText());
	            list.add(column.getText());
	        }

	        String[] expectedParameters = {
	            "amount1",
	            "currency",
	            "product",
	            "Rate",
	            "ValueDate",
	            "TradeDate",
	            "anotherCurrency",
	            "amount"
	        };

	        for (String parameter : expectedParameters) {
	            if (!list.contains(ParameterService.getParameter(parameter))) {
	            	System.out.println("booked data verification failed at"+ParameterService.getParameter(parameter));
	                return false;
	            }
	        }
	        System.out.println(" booked verification completed");
	        return true;
	    }
	public void clickAwaitInstruction() {
		LOGGER.info("Navigate To Awaiting Instruction");
		clickElement(driver,awaitingLink);
		
	}
	public void clickAwaitAuthorization() {
		LOGGER.info("Navigate To Awaiting Authorization");
		clickElement(driver,awaitingAuthorizationLink);
		driverWait.until(ExpectedConditions.attributeContains(awaitingAuthorizationLink, "class", "active"));
		
	}
	public void clickAwaitConfirmation() {
		LOGGER.info("Navigate To Awaiting Confirmation");
		clickElement(driver,awaitingConfirmLink);
		driverWait.until(ExpectedConditions.attributeContains(awaitingConfirmLink, "class", "active"));
		
	}
	public void settlementDetails() throws InterruptedException {
	    if(ParameterService.getParameter("Side").contains("Buy")) {
	    	settlementDetailsBuyCase();
	    }else {
	    	settlementDetailsSellCase();
	    }

	    
        
	}
	
public void settlementDetailsBuyCase() throws InterruptedException {
	    

	    List<String> list = new ArrayList<>();
	    List<String> list1 = new ArrayList<>();

	    List<WebElement> columns = driver.findElements(By.xpath("//tr[contains(@class,'odd') and not(contains(@class,'filtered'))]/td"));
	    System.out.println("---------------------------------------------------------------------------------");
	            for (WebElement column : columns) {
	            	System.out.println(column.getText());
	                list.add(column.getText());
	            }
	            
	            List<WebElement> columns1 = driver.findElements(By.xpath("//tr[contains(@class,'even') and not(contains(@class,'filtered'))]/td"));
	            for (WebElement column : columns1) {
	            	System.out.println(column.getText());
	                list1.add(column.getText());
	            }

	    System.out.println(ParameterService.getParameter("amount1"));
	    System.out.println(ParameterService.getParameter("anotherCurrency"));
	    System.out.println(ParameterService.getParameter("ValueDate"));
	    System.out.println(ParameterService.getParameter("amount"));
	    System.out.println(ParameterService.getParameter("currency"));
        if(list.contains("Bank Receives") 
        		&& list.contains(ParameterService.getParameter("amount1")) 
        		&& list.contains(ParameterService.getParameter("anotherCurrency"))
        		&& list.contains("Awaiting Instruction")
        		&& list.contains(ParameterService.getParameter("ValueDate"))) {
        	WebElement instructbtn=driver.findElement(By.xpath("//td[text()='"+ParameterService.getParameter("TradeNo")+"']/following-sibling::*[last()]/a[text()='Instruct']"));
        	WebElement splitbtn=driver.findElement(By.xpath("//td[text()='"+ParameterService.getParameter("TradeNo")+"']/following-sibling::*[last()]/a[text()='Split']"));
        	waitSeconds(5);
        	if(instructbtn.getAttribute("class").contains("btn-primary") && splitbtn.getAttribute("class").contains("disabled")) {
        		System.out.println(" row 1 verified");
        	}
        	
        	
        }
        if(list1.contains("Bank Pays") 
        		&& list1.contains(ParameterService.getParameter("amount")) 
        		&& list1.contains(ParameterService.getParameter("currency"))
        		&& list1.contains("Awaiting Instruction")
        		&& list1.contains(ParameterService.getParameter("ValueDate"))) {
        	System.out.println("111111111111111111111111111");
        	WebElement instructbtn=driver.findElement(By.xpath("(//td[text()='"+ParameterService.getParameter("TradeNo")+"']/following-sibling::*[last()]/a[text()='Instruct'])[2]"));
        	WebElement splitbtn=driver.findElement(By.xpath("(//td[text()='"+ParameterService.getParameter("TradeNo")+"']/following-sibling::*[last()]/a[text()='Split'])[2]"));
        	waitSeconds(5);
        	if(instructbtn.getAttribute("class").contains("btn-primary") && splitbtn.getAttribute("class").contains("btn-primary")) {
        		System.out.println("row 2 verified");
        	}
        	
        	
        }
        
        
        waitSeconds(5);     
        
	}
public void settlementDetailsSellCase() throws InterruptedException {
    

    List<String> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();

    List<WebElement> columns = driver.findElements(By.xpath("//tr[contains(@class,'even') and not(contains(@class,'filtered'))]/td"));
    System.out.println("---------------------------------------------------------------------------------");
            for (WebElement column : columns) {
            	System.out.println(column.getText());
                list.add(column.getText());
            }
            
            List<WebElement> columns1 = driver.findElements(By.xpath("//tr[contains(@class,'odd') and not(contains(@class,'filtered'))]/td"));
            for (WebElement column : columns1) {
            	System.out.println(column.getText());
                list1.add(column.getText());
            }

    System.out.println(ParameterService.getParameter("amount1"));
    System.out.println(ParameterService.getParameter("anotherCurrency"));
    System.out.println(ParameterService.getParameter("ValueDate"));
    System.out.println(ParameterService.getParameter("amount"));
    System.out.println(ParameterService.getParameter("currency"));
    if(list.contains("Bank Receives") 
    		&& list.contains(ParameterService.getParameter("amount1")) 
    		&& list.contains(ParameterService.getParameter("anotherCurrency"))
    		&& list.contains("Awaiting Instruction")
    		&& list.contains(ParameterService.getParameter("ValueDate"))) {
    	WebElement instructbtn=driver.findElement(By.xpath("//td[text()='"+ParameterService.getParameter("TradeNo")+"']/following-sibling::*[last()]/a[text()='Instruct']"));
    	WebElement splitbtn=driver.findElement(By.xpath("//td[text()='"+ParameterService.getParameter("TradeNo")+"']/following-sibling::*[last()]/a[text()='Split']"));
    	waitSeconds(5);
    	if(instructbtn.getAttribute("class").contains("btn-primary") && splitbtn.getAttribute("class").contains("disabled")) {
    		System.out.println(" row 1 verified");
    	}
    	
    	
    }
    if(list1.contains("Bank Pays") 
    		&& list1.contains(ParameterService.getParameter("amount")) 
    		&& list1.contains(ParameterService.getParameter("currency"))
    		&& list1.contains("Awaiting Instruction")
    		&& list1.contains(ParameterService.getParameter("ValueDate"))) {
    	System.out.println("22222222222222222222222222222222222");
    	WebElement instructbtn=driver.findElement(By.xpath("(//td[text()='"+ParameterService.getParameter("TradeNo")+"']/following-sibling::*[last()]/a[text()='Instruct'])[2]"));
    	WebElement splitbtn=driver.findElement(By.xpath("(//td[text()='"+ParameterService.getParameter("TradeNo")+"']/following-sibling::*[last()]/a[text()='Split'])[2]"));
    	waitSeconds(5);
    	if(instructbtn.getAttribute("class").contains("btn-primary") && splitbtn.getAttribute("class").contains("btn-primary")) {
    		System.out.println("row 2 verified");
    	}
    	
    	
    }
    
    
    waitSeconds(5);     
    
}
public void clickInstructButton() {
waitSeconds(3);
jsClick(driver,instructBtn);
waitSeconds(3);
driverWait.until(ExpectedConditions.attributeContains(manageSettlementsLink, "class", "active"));
	
}
public void clickPositionBlotter() {
	LOGGER.info("Navigate To Awaiting Instruction");
	clickElement(driver,positionBlotterLink);
	driverWait.until(ExpectedConditions.attributeContains(positionBlotterLink, "class", "active"));
	
}
public boolean positionBlotterDetails() {
	List<String> listTemp = new ArrayList<>();
	WebElement currencyInputForSearch=driver.findElement(By.xpath("(//input[@type='text'])[6]"));
	enterText(driver, currencyInputForSearch,ParameterService.getParameter("currency"));
	WebElement currencyPlusIcon=driver.findElement(By.xpath("//span[contains(text(),'"+ParameterService.getParameter("currency")+"')]/preceding-sibling::span"));
	jsClick(driver, currencyPlusIcon);
	waitSeconds(5);
	WebElement valueDatePlusIcon=driver.findElement(By.xpath("//span[contains(text(),'"+ParameterService.getParameter("ValueDate")+"')]/preceding-sibling::span"));
	jsClick(driver, valueDatePlusIcon);
	waitSeconds(5);
	WebElement tradeNo=driver.findElement(By.xpath("(//input[@type='text'])[8]"));
	enterText(driver, tradeNo,ParameterService.getParameter("TradeNo"));

	  waitSeconds(5);
    List<WebElement> columns = driver.findElements(By.xpath("//div[contains(text(),'"+ParameterService.getParameter("TradeNo")+"')]/parent::div/div"));

    for (WebElement column : columns) {
    	System.out.println(column.getText());
        listTemp.add(column.getText());
    }
    String[] expectedParameters = {
    		"TradeNo",
    		"TradeDate",
            "currency",
            "tenor",
            "ValueDate",
            "amount"
        };

        for (String parameter : expectedParameters) {
            if (!listTemp.contains(ParameterService.getParameter(parameter))) {
            	System.out.println("booked data verification failed at "+ParameterService.getParameter(parameter));
                return false;
            }
        }
        System.out.println(" booked verification completed");
        return true;
}
public String confirmNoTradeIsEligibleOrDisplayed(){
	WebElement noTradeMsg=driver.findElement(By.xpath("//div[contains(@id,'display_msg')]"));
	return noTradeMsg.getText();
}
public void clickManageSettlement() {
	LOGGER.info("Navigate To Manage Settlement");
	clickElement(driver,manageSettlementsLink);
	driverWait.until(ExpectedConditions.attributeContains(manageSettlementsLink, "class", "active"));
	
}

public void clickInstruct() throws InterruptedException {
	System.out.println("7777777777777777777777777777"+ParameterService.getParameter("Side"));
    
	if(ParameterService.getParameter("Side").contains("Buy")) {
		System.out.println("first-----------------------------11111111111111111--------------");
		clickInstructOnReceives();
    }else {
    	System.out.println("first++++++++++++++++++++++++++++++11111111111111111--------------");
    	clickInstructOnPays();
    }

    
    }


public void clickInstructOnReceives() throws InterruptedException {
	
    
	if(ParameterService.getParameter("Side").contains("Buy")) {
		System.out.println("second-----------------------------22222222222222222222222");
		clickInstructOnReceivesBuyCase();
    }else {
    	System.out.println("third-----------------------------------------3333333333333333333333333333333333333333333");
    	clickInstructOnReceivesSellCase();
    }

    
    }
public void clickInstructOnReceivesBuyCase() throws InterruptedException {
    

    List<String> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();

    List<WebElement> columns = driver.findElements(By.xpath("//tr[contains(@class,'odd') and not(contains(@class,'filtered'))]/td"));
    System.out.println("---------------------------------------------------------------------------------");
            for (WebElement column : columns) {
            	System.out.println(column.getText());
                list.add(column.getText());
            }
            
            List<WebElement> columns1 = driver.findElements(By.xpath("//tr[contains(@class,'even') and not(contains(@class,'filtered'))]/td"));
            for (WebElement column : columns1) {
            	System.out.println(column.getText());
                list1.add(column.getText());
            }

    System.out.println(ParameterService.getParameter("amount1"));
    System.out.println(ParameterService.getParameter("anotherCurrency"));
    System.out.println(ParameterService.getParameter("ValueDate"));
    System.out.println(ParameterService.getParameter("amount"));
    System.out.println(ParameterService.getParameter("currency"));
    System.out.println("000000000000000000000000000000000000000000");
    if(list.contains("Bank Receives")){
    	 System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    	
    	WebElement bankReceivesInstruct=driver.findElement(By.xpath("//td[contains(text(),'Bank Receives')]/following-sibling::*[last()]/a[text()='Instruct']"));
    	jsClick(driver, bankReceivesInstruct);
    	
    	
    }
    
    waitSeconds(5);
    	
    }
public void clickInstructOnReceivesSellCase() throws InterruptedException {
    

    List<String> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();

    List<WebElement> columns = driver.findElements(By.xpath("//tr[contains(@class,'even') and not(contains(@class,'filtered'))]/td"));
    System.out.println("---------------------------------------------------------------------------------");
            for (WebElement column : columns) {
            	System.out.println(column.getText());
                list.add(column.getText());
            }
            
            List<WebElement> columns1 = driver.findElements(By.xpath("//tr[contains(@class,'odd') and not(contains(@class,'filtered'))]/td"));
            for (WebElement column : columns1) {
            	System.out.println(column.getText());
                list1.add(column.getText());
            }

    System.out.println(ParameterService.getParameter("amount1"));
    System.out.println(ParameterService.getParameter("anotherCurrency"));
    System.out.println(ParameterService.getParameter("ValueDate"));
    System.out.println(ParameterService.getParameter("amount"));
    System.out.println(ParameterService.getParameter("currency"));
    if(list.contains("Bank Receives")){
    	
    	
    	WebElement bankReceivesInstruct=driver.findElement(By.xpath("//td[contains(text(),'Bank Receives')]/following-sibling::*[last()]/a[text()='Instruct']"));
    	jsClick(driver, bankReceivesInstruct);
    	
    	
    }
    
    waitSeconds(5);
    	
    }

public void clickInstructOnPays() throws InterruptedException {
    

	if(ParameterService.getParameter("Side").contains("Buy")) {
		clickInstructOnPaysBuyCase();
    }else {
    	clickInstructOnPaysSellCase();
    }
	
    	
    }
public void clickInstructOnPaysBuyCase() throws InterruptedException {
    

    List<String> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();

    List<WebElement> columns = driver.findElements(By.xpath("//tr[contains(@class,'odd') and not(contains(@class,'filtered'))]/td"));
    System.out.println("---------------------------------------------------------------------------------");
            for (WebElement column : columns) {
            	System.out.println(column.getText());
                list.add(column.getText());
            }
            
            List<WebElement> columns1 = driver.findElements(By.xpath("//tr[contains(@class,'even') and not(contains(@class,'filtered'))]/td"));
            for (WebElement column : columns1) {
            	System.out.println(column.getText());
                list1.add(column.getText());
            }

    System.out.println(ParameterService.getParameter("amount1"));
    System.out.println(ParameterService.getParameter("anotherCurrency"));
    System.out.println(ParameterService.getParameter("ValueDate"));
    System.out.println(ParameterService.getParameter("amount"));
    System.out.println(ParameterService.getParameter("currency"));
    
    if(list1.contains("Bank Pays")) {
    	WebElement bankPayInstruct=driver.findElement(By.xpath("//tr[contains(@class,'even')]//td[contains(text(),'Bank ')]/following-sibling::*[last()]/a[text()='Instruct']"));
    	jsClick(driver, bankPayInstruct);

    	}
    waitSeconds(5);
    	
    }
public void clickInstructOnPaysSellCase() throws InterruptedException {
    

    List<String> list = new ArrayList<>();
    List<String> list1 = new ArrayList<>();

    List<WebElement> columns = driver.findElements(By.xpath("//tr[contains(@class,'even') and not(contains(@class,'filtered'))]/td"));
    System.out.println("---------------------------------------------------------------------------------");
            for (WebElement column : columns) {
            	System.out.println(column.getText());
                list.add(column.getText());
            }
            
            List<WebElement> columns1 = driver.findElements(By.xpath("//tr[contains(@class,'odd') and not(contains(@class,'filtered'))]/td"));
            for (WebElement column : columns1) {
            	System.out.println(column.getText());
                list1.add(column.getText());
            }

    System.out.println(ParameterService.getParameter("amount1"));
    System.out.println(ParameterService.getParameter("anotherCurrency"));
    System.out.println(ParameterService.getParameter("ValueDate"));
    System.out.println(ParameterService.getParameter("amount"));
    System.out.println(ParameterService.getParameter("currency"));
    
    if(list1.contains("Bank Pays")) {
    	WebElement bankPayInstruct=driver.findElement(By.xpath("//tr[contains(@class,'odd')]//td[contains(text(),'Bank ')]/following-sibling::*[last()]/a[text()='Instruct']"));
    	jsClick(driver, bankPayInstruct);

    	}
    waitSeconds(5);
    	
    }

/*public void settlementInstruction() {
WebElement dropdownElement = driver.findElement(By.name("settlement_acct"));

    
    Select dropdown = new Select(dropdownElement);
String last4Digit=accountNumber.substring(accountNumber.length()-4);

String formattedAccount=accountName+"***"+last4Digit;
   
    dropdown.selectByVisibleText(formattedAccount);
    waitSeconds(5);
	
}*/

public static boolean isSubset(List<String> arr1, List<String> arr2) {
    // Convert ArrayLists to Sets for efficient membership checking
    Set<String> set1 = new HashSet<>(arr1);
    Set<String> set2 = new HashSet<>(arr2);

    // Check if set1 is a subset of set2
    return set2.containsAll(set1);
}

public void settlementInstructionOnPays(String ddaAccountName, String ddaAccountNumber, String beneficiaryAccountName, String beneficiaryAccountNumber) {
	if(ParameterService.getParameter("Side").contains("Buy")) {
WebElement dropdownElement = driver.findElement(By.name("settlement_acct"));

	   // List<String> bankDetailOfBeneficiary=new ArrayList<String>();
	   // List<String> personDetailOfBeneficiary=new ArrayList<String>();
	    Select dropdown = new Select(dropdownElement);
	String last4Digit=beneficiaryAccountNumber.substring(beneficiaryAccountNumber.length()-4);

	String formattedAccount=beneficiaryAccountName+"***"+last4Digit;
	   
	    dropdown.selectByVisibleText(formattedAccount);
	    
	    List<WebElement> bankDetail=driver.findElements(By.xpath("//label[text()='Bank Name and Address']/following-sibling::div/ul/li"));
	    for(WebElement i:bankDetail) {
	    	bankDetailOfBeneficiary.add(i.getText());
	    }
	    List<WebElement> beneficiaryDetail=driver.findElements(By.xpath("//label[text()='Beneficiary Name and Address']/following-sibling::div/ul/li"));
	    for(WebElement i:beneficiaryDetail) {
	    	personDetailOfBeneficiary.add(i.getText());
	    }
	    enterText(driver,purposeOfPayment,"Medical Expenses");
	    jsClick(driver,myEmail);
	    jsClick(driver, myPhoneNumber);
	    jsClick(driver,beneEmail);
	    jsClick(driver, benePhoneNumber);
	    
	    
	    

	}else {
		WebElement dropdownElement = driver.findElement(By.name("settlement_acct"));

	    
	    Select dropdown = new Select(dropdownElement);
	String last4Digit=ddaAccountNumber.substring(ddaAccountNumber.length()-4);

	String formattedAccount=ddaAccountName+"***"+last4Digit;
	   
	    dropdown.selectByVisibleText(formattedAccount);
		
	}
    waitSeconds(5);
	
}
public void settlementInstructionOnReceives(String ddaAccountName, String ddaAccountNumber, String beneficiaryAccountName, String beneficiaryAccountNumber) {
	if(ParameterService.getParameter("Side").contains("Buy")) {
	WebElement dropdownElement = driver.findElement(By.name("settlement_acct"));

    
    Select dropdown = new Select(dropdownElement);
String last4Digit=ddaAccountNumber.substring(ddaAccountNumber.length()-4);

String formattedAccount=ddaAccountName+"***"+last4Digit;
   
    dropdown.selectByVisibleText(formattedAccount);
	}else {
		WebElement dropdownElement = driver.findElement(By.name("settlement_acct"));

	    
	    Select dropdown = new Select(dropdownElement);
	String last4Digit=beneficiaryAccountNumber.substring(beneficiaryAccountNumber.length()-4);

	String formattedAccount=beneficiaryAccountName+"***"+last4Digit;
	   
	    dropdown.selectByVisibleText(formattedAccount);
	}
    waitSeconds(5);
	
}
public boolean verifySettlementInstructionLoaded() {
	boolean flag=false;
	if(flag==false) {
	driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h4[text()='Settlement Instructions']"))));
	flag=true;
	}
	return flag;
	
}

public void clickInstructBtnOnSettlementInstruction() {
	waitSeconds(5);
	jsClick(driver, instructBtnOfSettlementInstruction);
	jsClick(driver,okBtnForInstructSuccess);
	
}



    
         
    



}
