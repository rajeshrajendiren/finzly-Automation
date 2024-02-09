package com.fxoffice.ui.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentGalaxyApplicationMenuPage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentGalaxyApplicationMenuPage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;

	@FindBy(xpath = "//a/span[contains(text(),'New Payment')]")
	private WebElement lnkNewPayment;
	
	@FindBy(xpath = "//a/span[contains(text(),'Payment Blotter')]")
	private WebElement lnkPaymentBlotter;

	@FindBy(xpath = "//li[contains(@class, 'breadcrumb-item')]//b[contains(text(),'Payment Blotter')]")
	private WebElement tabHeader;

	private String tooltipXPath = "//a/span[contains(text(),'SubMenu_Name')]";
	
	// Constructor
	public PaymentGalaxyApplicationMenuPage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Home Page of Payment Galaxy Application Page.");
		driverWait.until(ExpectedConditions.titleContains("Portal"));
	}

	// Page Objects

	public void clickOptionFromNewPayment(String substitutionValue) {
		LOGGER.info("Clicking " +substitutionValue+ " Menu Link...!!! ");
		driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		driverWait.until(ExpectedConditions.visibilityOf(lnkNewPayment));
		driverWait.until(ExpectedConditions.elementToBeClickable(lnkNewPayment));
		moveToElement(driver, lnkNewPayment);
		mouseClick(driver, driver.findElement(By.xpath(tooltipXPath.replace("SubMenu_Name", substitutionValue))));
		driver.findElement(By.xpath(tooltipXPath.replace("SubMenu_Name", substitutionValue)));
	}
	
	public void clickPaymentBlotterApplicationMenu() {
		LOGGER.info("Clicking Payment Blotter Menu Link...!!! ");
		
		driverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
		clickElement(driver, lnkPaymentBlotter);
		waitForSpinnerIcon(driver);
		driverWait.until(ExpectedConditions.visibilityOf(tabHeader));
	 	System.out.println("Clicked on Payment Blotter Menu Link...!!! ");
	 	waitSeconds(30);
	
	}

	

}
