package com.fxoffice.ui.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import junit.framework.Assert;

public class SetllementPage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(SetllementPage.class);  
	protected WebDriverWait driverWait; 
	private WebDriver driver; 
 
	@FindBy(xpath = "//span[text()='Back Office']")
	private WebElement clickBackOfficeLink;
 
	@FindBy(xpath = "(//span[text()='Settlements'])[3]")
	private WebElement setllemetLink;

	@FindBy(xpath = "//span[text()='Settlement Browser']")
	private WebElement settlementBrowserText;

	@FindBy(xpath = "//span[text()='Search']")
	private WebElement searchBtn;

	@FindBy(xpath = "//div[contains(@id,'headercontainer')]/div/div/div/div/span")
	private WebElement selectRecord;

	@FindBy(xpath = "(//label[text()='Trade Date Start:']/following::input)[1]")
	private WebElement tradingDate;

	@FindBy(xpath = "(//label[text()='Settlement Start Date:']/following::input)[1]")
	private WebElement setllementDate;
	
	@FindBy(xpath = "//label[text()='Channel:']/../..//input")
	private WebElement setllementChannel;

	@FindBy(xpath = "//label[text()='Status:']/../..//input")
	private WebElement statusChannel;

	@FindBy(xpath = "//label[text()='Channel:']/../..//div[@role='button']")
	private WebElement setllementChannelDownArrow;

	@FindBy(xpath = "//label[text()='Status:']/../..//div[@role='button']")
	private WebElement statusChannelDownArrow;

	@FindBy(xpath = "//div[contains(text(),'Displaying')]")
	private WebElement pendingVerificationTotalCount;

	@FindBy(xpath = "//span[text()='Authorize']")
	private WebElement authorizeBtn;

	@FindBy(xpath = "//span[text()='OK']/following-sibling::span")
	private WebElement clickOKBtn;
	
	@FindBy(xpath = "//span[text()='Release']")
	private WebElement releaseBtn;
	

	@FindBy(name = "inputItem")
	private WebElement inputPageNumber;

	@FindBy(xpath = "//div[contains(@id,'pagingtoolbar')]/div[3]")
	private WebElement totalPageNumber;

	public void verifySetllementSearchTitle() {
		LOGGER.info("Clicking SetllementSearchTitle");
		settlementBrowserText.isDisplayed();
	}

	public SetllementPage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Setllement Page");
	}

	public void navigateSettlement() throws Exception {
		LOGGER.info("Clicking Settlements Tab");
		Thread.sleep(5000);
		jsClick(driver, clickBackOfficeLink);
		Thread.sleep(3000);
		jsClick(driver, setllemetLink);
	}

	public void settlements(String operation,String date,Integer page_num) throws Exception {

		String val = page_num.toString();
		
		scrollIntoView(driver, tradingDate); 
		scrollIntoView(driver, setllementDate);

		tradingDate.clear();
		tradingDate.sendKeys(date);
		
	

		jsClick(driver, searchBtn);
		 
		Thread.sleep(10000);
		
		int count = driver.findElements(By.xpath("//div[text()='No data to display']")).size();

		System.out.println("===count===>"+count); 
		
		if (count == 1) {

		} else {
				
				 inputPageNumber.clear();
				 inputPageNumber.sendKeys(val);
				 inputPageNumber.sendKeys(Keys.ENTER);
				 
				 Thread.sleep(7000);
				 driver.findElement(By.xpath("//div[contains(@id,'headercontainer')]/div/div/div/div/span")).click();
				 Thread.sleep(5000);
			 
			if(operation.equals("authorize")) { 
				
				 jsClick(driver, authorizeBtn);
	
				 Thread.sleep(5000);
				 jsClick(driver, clickOKBtn);
				 Thread.sleep(10000);
				
			}else if(operation.equals("release")){
				
					 jsClick(driver, releaseBtn);
					 Thread.sleep(15000);
						
					 WebDriverWait wait = new WebDriverWait(driver,50);
					 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Ignore Duplicate & Continue']")));
						
					 jsClick(driver, driver.findElement(By.xpath("//span[text()='Ignore Duplicate & Continue']")));
					 Thread.sleep(15000);
					 

			}else {}
			
			jsClick(driver, driver.findElement(By.xpath("//span[text()='Refresh']")));
			
			Thread.sleep(10000);
			
			int row_count=driver.findElements(By.xpath("//tbody[contains(@id,'gridview')]/tr")).size();
			for(int i=1;i<row_count;i++) {
				String status=driver.findElement(By.xpath("//tbody[contains(@id,'gridview')]/tr["+i+"]/td[17]")).getText();
				
				if(operation.equals("authorise")) {
					//Assert.assertEquals(status, "PendingRelease");
				}else {
					//Assert.assertEquals(status, "Processed");
				}
			}
			
		}
	}
	


	public void settlementsOperation(String operation,String date,String page_num) throws Exception {

		String val = page_num;
		
		scrollIntoView(driver, tradingDate); 

		tradingDate.clear();
		tradingDate.sendKeys(date);
 
		jsClick(driver, searchBtn);
		 
		Thread.sleep(10000);
		
		int count = driver.findElements(By.xpath("//div[text()='No data to display']")).size();

		System.out.println("===count===>"+count); 
		
		if (count == 1) { 

		} else {
				
				 inputPageNumber.clear();
				 inputPageNumber.sendKeys(val);
				 inputPageNumber.sendKeys(Keys.ENTER);
				 
				 Thread.sleep(7000);
				 driver.findElement(By.xpath("//div[contains(@id,'headercontainer')]/div/div/div/div/span")).click();
				 Thread.sleep(5000);
			 
			if(operation.equals("authorize")) { 
				
				 jsClick(driver, authorizeBtn);
	
				 Thread.sleep(5000);
				 jsClick(driver, clickOKBtn);
				 Thread.sleep(10000);
				
			}else if(operation.equals("release")){
				
					 jsClick(driver, releaseBtn);
					 Thread.sleep(15000);
					 
					 try {
						
						 WebDriverWait wait = new WebDriverWait(driver,50);
						 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Ignore Duplicate & Continue']")));
							
						 jsClick(driver, driver.findElement(By.xpath("//span[text()='Ignore Duplicate & Continue']")));
						 Thread.sleep(15000);
						 
					 }catch(Exception e) {}
					 

			}else {}
			
			jsClick(driver, driver.findElement(By.xpath("//span[text()='Refresh']")));
			
			Thread.sleep(10000);
			
			int row_count=driver.findElements(By.xpath("//tbody[contains(@id,'gridview')]/tr")).size();
			for(int i=1;i<row_count;i++) {
				String status=driver.findElement(By.xpath("//tbody[contains(@id,'gridview')]/tr["+i+"]/td[17]")).getText();
				
				if(operation.equals("authorise")) {
					//Assert.assertEquals(status, "PendingRelease");
				}else {
					//Assert.assertEquals(status, "Processed");
				}
			}
			
		}
	}

/*
	public void settlements(String operation,String date,String page_num) throws Exception {

		String val = page_num;
		
		scrollIntoView(driver, tradingDate); 

		tradingDate.clear();
		tradingDate.sendKeys(date);

		jsClick(driver, searchBtn);
		 
		Thread.sleep(10000);
		
		int count = driver.findElements(By.xpath("//div[text()='No data to display']")).size();

		System.out.println("===count===>"+count);
		
		if (count == 1) {

		} else {
			
			if(operation.equals("authorise")) {
				
				 inputPageNumber.clear();
				 inputPageNumber.sendKeys(val);
				 inputPageNumber.sendKeys(Keys.ENTER);
				 
				 Thread.sleep(7000);
				 driver.findElement(By.xpath("//div[contains(@id,'headercontainer')]/div/div/div/div/span")).click();
				 Thread.sleep(5000);
				 
				 jsClick(driver, authorizeBtn);
	
				 Thread.sleep(5000);
				 jsClick(driver, clickOKBtn);
				 Thread.sleep(10000);
				
			}else {
				
				for(int i=1;i<=Integer.parseInt(val);i++) {
					
					 Integer enter_val=i;
					
					 inputPageNumber.clear();
					 inputPageNumber.sendKeys(enter_val.toString());
					 inputPageNumber.sendKeys(Keys.ENTER);
					
					 Thread.sleep(7000);
					 driver.findElement(By.xpath("//div[contains(@id,'headercontainer')]/div/div/div/div/span")).click();
					 Thread.sleep(5000);
					 
					 jsClick(driver, releaseBtn);
					 Thread.sleep(15000);
						
					 WebDriverWait wait = new WebDriverWait(driver,40);
					 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Ignore Duplicate & Continue']")));
						
					 jsClick(driver, driver.findElement(By.xpath("//span[text()='Ignore Duplicate & Continue']")));
					 Thread.sleep(15000);
					
				}
				
			}
			
			jsClick(driver, driver.findElement(By.xpath("//span[text()='Refresh']")));
			
			Thread.sleep(10000);
			
			int row_count=driver.findElements(By.xpath("//tbody[contains(@id,'gridview')]/tr")).size();
			for(int i=1;i<row_count;i++) {
				String status=driver.findElement(By.xpath("//tbody[contains(@id,'gridview')]/tr["+i+"]/td[17]")).getText();
				
				if(operation.equals("authorise")) {
					//Assert.assertEquals(status, "PendingRelease");
				}else {
					//Assert.assertEquals(status, "Processed");
				}
			}
			
			//for(int i=1;i<row_count;i++) {
				//String status=driver.findElement(By.xpath("//tbody[contains(@id,'gridview')]/tr["+i+"]/td[17]")).getText();
				//Assert.assertEquals(status, "PendingRelease");
			//}

		}
	}*/
	
}
