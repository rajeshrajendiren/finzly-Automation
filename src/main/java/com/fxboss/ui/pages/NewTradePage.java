package com.fxboss.ui.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fxoffice.ui.pages.AbstractPage;
import com.fxoffice.utility.ParameterService;

import io.cucumber.java.Scenario;

public class NewTradePage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(NewTradePage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;
	@FindBy(xpath="//a[contains(text(),'FX Spot')]/ancestor::li")
	private WebElement fxSpot;
	
	@FindBy(xpath="//input[contains(@placeholder,'Currency Pair')]")
	private WebElement currencyPairInput;

	@FindBy(xpath="//input[@id='tenor']")
	private WebElement tenorInput;

	@FindBy(xpath="//strong[text()='Accept']/ancestor::button")
	private WebElement acceptButton;

	@FindBy(xpath="//h3[text()='Confirmation']")
	private WebElement confirmationHeader;

	@FindBy(xpath="//strong[contains(text(),'You are Buying')]/following-sibling::span/span")
	private WebElement youAreBuyingSpan;

	@FindBy(xpath="//strong[contains(text(),'Contract Rate')]/following-sibling::span/span")
	private WebElement contractRateSpan;

	@FindBy(xpath="//strong[contains(text(),'You are Selling')]/following-sibling::span/span")
	private WebElement youAreSellingSpan;

	@FindBy(xpath="//strong[contains(text(),'Trade Date')]/following-sibling::span/span")
	private WebElement tradeDateSpan;

	@FindBy(xpath="//strong[contains(text(),'Value Date')]/following-sibling::span/span")
	private WebElement valueDateSpan;

	@FindBy(xpath="//a[text()='USD']/preceding-sibling::button")
	private WebElement usdButton;

	@FindBy(xpath="//a[contains(text(),'GBP')]")
	private WebElement gbpLink;
	
	@FindBy(xpath="//button[contains(text(),'Get Rate')]")
	private WebElement getRateButton;
	
	final private NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
	
	
	String tenorSelection="//li[@data-value='tenor']";
	String currencyClick="//a[contains(text(),'currency')]";
	String amountInput="//a[contains(text(),'currency')]/following-sibling::input";
	String optionForBuyOrSell="//a[text()='currency']/preceding-sibling::button";

	


	public NewTradePage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Home Page of FXOffice Application.");
		driverWait.until(ExpectedConditions.titleContains("Galaxy Treasury"));
	}

	// Methods
	public boolean verifyNewTrade() {
		LOGGER.info("Checking for Home Page loading...!!! ");
		boolean flag = false;
		if (flag == false) {
			WebElement spotElementLocator = driver.findElement(By.id("FXWEB_TRADE_SPOT"));
			// By spotElementLocator = By.id("FXWEB_TRADE_SPOT");

			WebElement forwardElementLocator = driver.findElement(By.id("FXWEB_TRADE_FORWARD"));
			WebElement ndfElementLocator = driver.findElement(By.id("FXWEB_TRADE_NDF"));
			WebElement windowForwardElementLocator = driver.findElement(By.id("FXWEB_TRADE_WINDOW_FORWARD"));
			WebElement swapElementLocator = driver.findElement(By.id("FXWEB_TRADE_SWAP"));
			WebElement drawdownElementLocator = driver.findElement(By.id("FXWEB_TRADE_DRAWDOWN"));

			// Array of By locators
			WebElement[] elements = { spotElementLocator, forwardElementLocator, ndfElementLocator,
					windowForwardElementLocator, swapElementLocator, drawdownElementLocator };
			driverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
			flag = true;
		}

		return true;
	}
	public void fun1(String CurrencyPair, String tenor, String amt, String currency, String option) {
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setMinimumFractionDigits(2);
	jsClick(driver, getRateButton);
	String c1 = CurrencyPair.substring(0, 3);
	String c2 = CurrencyPair.substring(3);
	System.out.println(c1+"============================="+currency);
	if (currency.equals(c1)) {
		WebElement anotherCurrency = driver.findElement(By.xpath("//a[contains(text(),'" + c2 + "')]"));
		System.out.println(anotherCurrency.getText());
		System.out.println("valueS" + anotherCurrency.getAttribute("value"));
		ParameterService.setParameter("anotherCurrency", c2);
		waitSeconds(5);
		WebElement rate = driver.findElement(By.xpath("//input[contains(@placeholder,'All in Rate')]"));
		ParameterService.setParameter("Rate", rate.getAttribute("value"));
		Double Rate=Double.parseDouble(rate.getAttribute("value"));
		Double Amt=Double.parseDouble(amt);
		Double result=Amt/Rate;
		ParameterService.setParameter("amount1",numberFormat.format(result));
		

	}
	System.out.println(c2+"===================="+currency);
	if (currency.equals(c2)) {
		//WebElement anotherCurrency = driver.findElement(By.xpath("//a[contains(text(),'" + c1 + "')]"));
		System.out.println(c1);
		System.out.println("valueS" + c1);
		ParameterService.setParameter("anotherCurrency", c1);
		waitSeconds(5);
		WebElement rate = driver.findElement(By.xpath("//input[contains(@placeholder,'All in Rate')]"));
		ParameterService.setParameter("Rate", rate.getAttribute("value"));
		Double Rate=Double.parseDouble(rate.getAttribute("value"));
		Double Amt=Double.parseDouble(amt);
		Double result=Amt/Rate;
		Double roundedNumber = Math.round(result * 100.0) / 100.0;
		ParameterService.setParameter("amount1",numberFormat.format(roundedNumber));
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+roundedNumber);}
	
	
		}
	
	public void bookFxSpotTrade1(String CurrencyPair, String tenor, String amt, String currency, String option) {
		numberFormat.setMaximumFractionDigits(2);
		numberFormat.setMinimumFractionDigits(2);
		ParameterService.setParameter("currency",currency);
		ParameterService.setParameter("amount", numberFormat.format(Double.parseDouble(amt)));
		ParameterService.setParameter("Side", option.substring(0, 1)+option.substring(1).toLowerCase());
		ParameterService.setParameter("tenor",tenor.substring(0, 1)+tenor.substring(1).toLowerCase());
		if(option.equals("BUY")) {
			ParameterService.setParameter("product","Sell");
		}else {
			ParameterService.setParameter("product","Buy");
		}
		
		if (fxSpot.getAttribute("class").contains("active")) {
			enterText(driver,currencyPairInput, CurrencyPair);
			enterText(driver, tenorInput,tenor);
			WebElement tenorSelect = driver.findElement(By.xpath(tenorSelection.replace("tenor",tenor)));
			clickElement(driver, tenorSelect);
			WebElement currencyToClick = driver.findElement(By.xpath(currencyClick.replace("currency", currency)));
			clickElement(driver, currencyToClick);
			WebElement amount = driver.findElement(By.xpath(amountInput.replace("currency", currency)));
			enterText(driver, amount, amt);
			WebElement optionButton = driver.findElement(By.xpath(optionForBuyOrSell.replace("currency", currency)));
			if (optionButton.getAttribute("value").contains(option)) {
				fun1(CurrencyPair, tenor, amt, currency, option);
			}else {
				jsClick(driver, optionButton);
				fun1(CurrencyPair, tenor, amt, currency, option);
			}
			waitSeconds(3);
			WebElement rate = driver.findElement(By.xpath("//input[contains(@placeholder,'All in Rate')]"));
			ParameterService.setParameter("Rate", rate.getAttribute("value"));
			
			WebElement acceptButton = driver.findElement(By.xpath("//strong[text()='Accept']/ancestor::button"));
			jsClick(driver, acceptButton);
			
			verifyConfirmationPage(option);
			waitSeconds(10);
		}
		
	}
	public void bookFxSpotTrade(String CurrencyPair, String tenor, String amt, String currency, String option) {

		WebElement fxSpot = driver.findElement(By.xpath("//a[contains(text(),'FX Spot')]/ancestor::li"));
		if (fxSpot.getAttribute("class").contains("active")) {
			WebElement currencyPair=driver.findElement(By.xpath("//input[contains(@placeholder,'Currency Pair')]"));
			enterText(driver, currencyPair, CurrencyPair);
			
			WebElement tenorInput = driver.findElement(By.xpath("//input[@id='tenor']"));
			enterText(driver, tenorInput, tenor);
			WebElement tenorSelect = driver.findElement(By.xpath("//li[@data-value='"+tenor+"']"));
			clickElement(driver, tenorSelect);
			
			System.out.println(ParameterService.getParameter("amount"));
			WebElement currencyToClick = driver.findElement(By.xpath("//a[contains(text(),'" + currency + "')]"));
			ParameterService.setParameter("currency", currency);

			clickElement(driver, currencyToClick);
			WebElement amount = driver
					.findElement(By.xpath("//a[contains(text(),'" + currency + "')]/following-sibling::input"));
			enterText(driver, amount, amt);
			WebElement optionButton = driver
					.findElement(By.xpath("//a[text()='currency']/preceding-sibling::button"));
			WebElement getRateButton = driver.findElement(By.xpath("//button[contains(text(),'Get Rate')]"));
			System.out.println(optionButton.getAttribute("value")+"==========================="+option);
			if (optionButton.getAttribute("value").contains(option)) {
				// WebElement getRateButton =
				// driver.findElement(By.xpath("//a[text()='//button[contains(text(),'Get
				// Rate')]']/preceding-sibling::button"));
				ParameterService.setParameter("amount", amt);
				jsClick(driver, getRateButton);
				String c1 = CurrencyPair.substring(0, 3);
				String c2 = CurrencyPair.substring(3);
				System.out.println(c1+"============================="+currency);
				if (currency.equals(c1)) {
					WebElement anotherCurrency = driver.findElement(By.xpath("//a[contains(text(),'" + c2 + "')]"));
					System.out.println(anotherCurrency.getText());
					System.out.println("valueS" + anotherCurrency.getAttribute("value"));
					ParameterService.setParameter("anotherCurrency", anotherCurrency.getText());
					WebElement anotherCurrencyValue = driver
							.findElement(By.xpath("//a[contains(text(),'"+ c2 +"')]/following-sibling::input"));
					String anotherC = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
							anotherCurrencyValue);
					;
					ParameterService.setParameter("anotherC", anotherC);

				}
				System.out.println(c2+"===================="+currency);
				if (currency.equals(c2)) {
					WebElement anotherCurrency = driver.findElement(By.xpath("//a[contains(text(),'" + c1 + "')]"));
					System.out.println(anotherCurrency.getText());
					System.out.println("valueS" + anotherCurrency.getAttribute("value"));
					ParameterService.setParameter("anotherCurrency", anotherCurrency.getText());
					WebElement anotherCurrencyValue = driver
							.findElement(By.xpath("//a[contains(text(),'" + c1 + "')]/following-sibling::input"));
					String anotherC = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
							anotherCurrencyValue);
					;
					ParameterService.setParameter("anotherC", anotherC);

				}

			} else {
				jsClick(driver, optionButton);

				jsClick(driver, getRateButton);
				String c1 = CurrencyPair.substring(0, 3);
				String c2 = CurrencyPair.substring(3);
				System.out.println(c1+"============================="+currency);
				if (currency.equals(c1)) {
					WebElement anotherCurrency = driver.findElement(By.xpath("//a[contains(text(),'" + c2 + "')]"));
					System.out.println(anotherCurrency.getText());
					System.out.println("valueS" + anotherCurrency.getAttribute("value"));
					ParameterService.setParameter("anotherCurrency", anotherCurrency.getText());
					WebElement anotherCurrencyValue = driver
							.findElement(By.xpath("//a[contains(text(),'" + c2 + "')]/following-sibling::input"));
					String anotherC = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
							anotherCurrencyValue);
					;
					ParameterService.setParameter("anotherC", anotherC);

				}
				System.out.println(c2+"============================="+currency);
				if (currency.equals(c2)) {
					WebElement anotherCurrency = driver.findElement(By.xpath("//a[contains(text(),'" + c1 + "')]"));
					System.out.println(anotherCurrency.getText());
					System.out.println("valueS" + anotherCurrency.getAttribute("value"));
					ParameterService.setParameter("anotherCurrency", anotherCurrency.getText());
					WebElement anotherCurrencyValue = driver
							.findElement(By.xpath("//a[contains(text(),'" + c1 + "')]/following-sibling::input"));
					String anotherC = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].value;",
							anotherCurrencyValue);
					ParameterService.setParameter("anotherC", anotherC);

				}

			}
			waitSeconds(3);
			WebElement rate = driver.findElement(By.xpath("//input[contains(@placeholder,'All in Rate')]"));
			ParameterService.setParameter("Rate", rate.getAttribute("value"));
			Double Rate=Double.parseDouble(rate.getAttribute("value"));
			Double Amt=Double.parseDouble(amt);
			Double result=Amt/Rate;
			ParameterService.setParameter("amount",result.toString());
			WebElement acceptButton = driver.findElement(By.xpath("//strong[text()='Accept']/ancestor::button"));
			jsClick(driver, acceptButton);
			waitSeconds(4);
			verifyConfirmationPage(option);
			System.out.println("========================================================="
					+ ParameterService.getParameter("Rate"));
			waitSeconds(10);

		}

	}
	

	public void verifyConfirmationPage(String option) {
		WebElement confirmationHeader = driver.findElement(By.xpath("//h3[text()='Confirmation']"));
		driverWait.until(ExpectedConditions.visibilityOf(confirmationHeader));
		WebElement tradeNo = driver
				.findElement(By.xpath("//strong[contains(text(),'Trade No.')]/following-sibling::span/span"));
		ParameterService.setParameter("TradeNo",tradeNo.getText());
		verifyYouAreBuying(option);
		verifyYouAreSelling(option);
		verifyContractRate();
		verifyTradeDateAndValueDate(option);
		closeConfirmationPage();
	}

	private void closeConfirmationPage() {
		WebElement closeBtn=driver.findElement(By.xpath("(//strong[text()='Close'])[2]"));
		clickElement(driver, closeBtn);
		
	}

	public void verifyYouAreBuying(String option) {
		WebElement youAreBuyingText = driver
				.findElement(By.xpath("//strong[contains(text(),'You are Buying')]/following-sibling::span/span"));

		if(option.equals("BUY")) {
			String currency=ParameterService.getParameter("currency");
			String amount=ParameterService.getParameter("amount");
			if(youAreBuyingText.getText().equals(amount+" "+currency)) {
				System.out.println(youAreBuyingText.getText()+"===================="+amount+" "+currency);
			}
			
		}else {
			String currency=ParameterService.getParameter("anotherCurrency");
			String amount=ParameterService.getParameter("amount1");
			if(youAreBuyingText.getText().equals(amount+" "+currency)) {
				System.out.println(youAreBuyingText.getText()+"===================="+amount+" "+currency);
			}
		}
	}

	public void verifyContractRate() {
		WebElement contractRateText = driver
				.findElement(By.xpath("//strong[contains(text(),'Contract Rate')]/following-sibling::span/span"));

		if (contractRateText.getText().equals(ParameterService.getParameter("Rate"))) {
			System.out.println("true2");
		}
	}

	public void verifyYouAreSelling(String option) {
		WebElement youAreSellingText = driver
				.findElement(By.xpath("//strong[contains(text(),'You are Selling')]/following-sibling::span/span"));
		if(option.equals("SELL")) {
			String currency=ParameterService.getParameter("currency");
			String amount=ParameterService.getParameter("amount");
			if(youAreSellingText.getText().equals(amount+" "+currency)) {
				System.out.println(youAreSellingText.getText()+"===================="+amount+" "+currency);
			}
			
		}else {
			String currency=ParameterService.getParameter("anotherCurrency");
			String amount=ParameterService.getParameter("amount1");
			if(youAreSellingText.getText().equals(amount+" "+currency)) {
				System.out.println(youAreSellingText.getText()+"===================="+amount+" "+currency);
			}
		}
		
	}

	public void verifyTradeDateAndValueDate(String option) {
		 WebElement tradeDateText = driver.findElement(By.xpath("//strong[contains(text(),'Trade Date')]/following-sibling::span/span"));
		 WebElement valueDateText = driver.findElement(By.xpath("//strong[contains(text(),'Value Date')]/following-sibling::span/span"));
		 System.out.println(tradeDateText.getText()+" "+ParameterService.getParameter("TradeDate"));
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
		 DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		 LocalDate date = LocalDate.parse(ParameterService.getParameter("TradeDate"), formatter);
		 String formattedDate = date.format(formatter);
		 waitSeconds(3);
		 LocalDate valueDate=date.plusDays(2);
		 ParameterService.setParameter("ValueDate",valueDate.format(formatter1));
		 System.out.println("value Date ======================"+valueDate);
		 if(valueDate.getDayOfWeek()==DayOfWeek.SATURDAY ||valueDate.getDayOfWeek()==DayOfWeek.SUNDAY) {
			 
			 valueDate=valueDate.plusDays(2);

			 ParameterService.setParameter("ValueDate",valueDate.format(formatter1));
			 System.out.println("value Date ======================"+valueDate);
		 }
		 
		      if(formattedDate.equals(tradeDateText.getText()) && (valueDateText.getText()).contains(valueDate.format(formatter).toString())) {
		     	 System.out.println(valueDate.format(formatter).toString()+"   "+valueDateText.getText());
		      }
		      
	}
	
	

}

// endregion : Methods
