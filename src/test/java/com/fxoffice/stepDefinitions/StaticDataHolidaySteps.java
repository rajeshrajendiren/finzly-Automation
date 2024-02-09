package com.fxoffice.stepDefinitions;

import org.openqa.selenium.WebDriver;

import com.fxoffice.ui.pages.EntitlementCompareAndModifyPage;
import com.fxoffice.ui.pages.EntitlementsPage;
import com.fxoffice.ui.pages.EntityManagerPage;
import com.fxoffice.ui.pages.StaticDataHoliday;
import com.fxoffice.ui.pages.WebDriverManager1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class StaticDataHolidaySteps {

	public WebDriver driver = getDriver();
	public StaticDataHoliday staticDataHoliday;

	public WebDriver getDriver() {
		return WebDriverManager1.driver;
	}

	@And("I get Trade Date from systems Date")
	public void saveTradeDate() {
		staticDataHoliday = new StaticDataHoliday(driver);
		staticDataHoliday.getTradeDate();
	}

	@And("I Search {string} in holidays")
	public void searchCurrencyInHolidays(String currency) {
		staticDataHoliday = new StaticDataHoliday(driver);
		staticDataHoliday.SearchCurrencyInCalendarcode(currency);
	}

	@And("I Search {string} in Static Data Currency")
	public void searchCurrencyInCurrency(String currency) {
		staticDataHoliday = new StaticDataHoliday(driver);
		staticDataHoliday.SearchCurrency(currency);
	}

	@And("I close tab current tab")
	public void closeManager() {
		staticDataHoliday = new StaticDataHoliday(driver);
		staticDataHoliday.closeCurrentTab();
	}

	@And("I update the static Data currency {string} for {string}")
	public void currencyPrecisionUpdation(String precision, String currency) {
		staticDataHoliday = new StaticDataHoliday(driver);
		staticDataHoliday.staticDataCurrencyUpdation(precision, currency);
	}

	@And("I delete Holidays data from Holidays")
	public void holidayDataFromHolidays() {
		staticDataHoliday = new StaticDataHoliday(driver);
		staticDataHoliday.findDateInTable();
	}

	@And("I update the static Data currency pair {string}")
	public void currencyPrecisionUpdation(String currencyPair) {
		staticDataHoliday = new StaticDataHoliday(driver);
		staticDataHoliday.updateCurrencyPair(currencyPair);
	}

}
