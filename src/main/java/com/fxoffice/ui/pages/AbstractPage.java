package com.fxoffice.ui.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPage.class);
	WebDriverWait driverWait;

	protected boolean waitForSpinner(WebDriver driver, By waitSpinnerLoc, int maxWaitMinutes) {
		boolean isWaitingComplete = false;
		int sleepTimeSeconds = 5;
		int maxNumberOfTrials = maxWaitMinutes * 60 / sleepTimeSeconds;
		LOGGER.info("Waiting for loading bar/spinner ...");
		LOGGER.info("Sleeping... maxTimeOut=" + maxWaitMinutes + " minutes.");
		try {
			for (int i = 0; !isWaitingComplete && i < maxNumberOfTrials; i++) {
				waitSeconds(sleepTimeSeconds);
				try {
					isWaitingComplete = !this.isAtLeastOneElementDisplayed(driver, waitSpinnerLoc);
				} catch (StaleElementReferenceException e) {
					waitSeconds(2);
					isWaitingComplete = !this.isAtLeastOneElementDisplayed(driver, waitSpinnerLoc);
				} catch (Exception e) {
					LOGGER.info("Failed to find atleast one element");
				}
			}
		} catch (StaleElementReferenceException e) {
			isWaitingComplete = true;
		}
		if (!isWaitingComplete) {
			LOGGER.warn("Waited for " + maxWaitMinutes + " minutes, But still the operation/page load is in progress.");
			return false;
		}
		LOGGER.info("Loading spinner is closed.");
		return true;
	}

	public void waitForPageLoad(WebDriver driver) {
		waitForSpinner(driver, By.cssSelector(".spinner-container"), 3);
	}

	public void waitForSpinnerIcon(WebDriver driver) {
		waitForSpinner(driver, By.xpath("(//div[contains(@class,'ball-spin-clockwise')])[1]"), 3);
	}

	protected boolean isAtLeastOneElementDisplayed(WebDriver driver, By by) {
		List<WebElement> webElements = driver.findElements(by);
		for (WebElement webElement : webElements) {
			if (webElement.isDisplayed())
				return true;
		}
		return false;
	}

	public void jsClick(WebDriver driver, WebElement element) { 
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(40));
		driverWait.until(ExpectedConditions.visibilityOf(element));
		driverWait.until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}
	
	protected void clickWithRetry(WebDriver driver, WebElement element) {
		boolean needToRetry = true;
		int i=0;
		
		while(needToRetry && i<=5)
		{
			try
			{
				element.click();
				needToRetry = false;
			}
			catch (Exception e)
			{
				LOGGER.info("Clicking element failed due to exception. Waiting and trying again...");
				e.printStackTrace();
				waitSeconds(5);
			}
			
			i++;
		}
		
		if(needToRetry)
		{
			LOGGER.info("Clicking element failed. Waiting and trying again...");
			waitSeconds(5);
			element.click();
		}
	}

	protected void moveToElement(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).build().perform();
	}

	protected void scrollIntoViewAndClick(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();arguments[0].click();", element);
	}
	
	protected void scrollIntoView(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	 
	public void selectDropdownValue(WebDriver driver,WebElement element,String sValue)throws Throwable{
		Select dropdown = new Select(element);
		List<WebElement> Options = dropdown.getOptions();
		for (WebElement option : Options) {
			if (option.getText().equals(sValue)) {
				option.click();
				break;
			}
		}
	}

	public void staleElementHandleByID(WebDriver driver, WebElement elementID, int maxCount) {
		int count = 0;
		while (count < maxCount) {
			try {
				elementID.click();
			} catch (StaleElementReferenceException e) {
				this.waitSeconds(1);
				e.toString();
				LOGGER.info("Trying to recover from a stale element :" + e.getMessage());
				count = count + 1;
			}
			count = count + maxCount;
		}
	}

	protected void popupButtonClick(WebDriver driver, String popupName, String buttonName) {
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By buttonSel = By.xpath("");
		driverWait.until(ExpectedConditions.elementToBeClickable(buttonSel));
		driver.findElement(buttonSel).click();
	}

	protected void errorAlertClose(WebDriver driver) {
		LOGGER.info("Checking for Error Alert ...");
		try {
			List<WebElement> errorAlerts = driver.findElements(By
					.xpath(""));
			for (int i = errorAlerts.size() - 1; i >= 0; i--) {
				if (errorAlerts.get(i).isDisplayed()) {
					if (errorAlerts.get(i).isEnabled()) {
						errorAlerts.get(i).click();
						LOGGER.info("Error/Session Alert Found");
						waitForPageLoad(driver);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.info("No Error Alert Found");
		}
	}

	protected boolean breadCrumbOption(List<WebElement> elementList, String elementName) {
		for (WebElement element : elementList) {
			LOGGER.info("Bread Crumb Option " + element.getText());
			if (element.getText().matches(elementName)) {
				LOGGER.info("found Bread Crumb Option " + element.getText());
				element.click();
				return true;
			}
		}
		return false;
	}

	protected void waitSeconds(int sec) {
		try {
			LOGGER.info("Sleeping for " + sec + " seconds");
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	protected boolean isElementDisplayed(WebDriver driver, WebElement locator) {
		try {
				driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
				return driverWait.until(ExpectedConditions.visibilityOf(locator)).isDisplayed();
		} catch (NoSuchElementException e) {
				return false;
		}
	}

	protected void enterText(WebDriver driver, WebElement locator, String keysToSend) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(locator));
		driverWait.until(ExpectedConditions.elementToBeClickable(locator));
		locator.clear();
		locator.sendKeys(keysToSend);
	}

	protected void clickElement(WebDriver driver, WebElement locator) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(40));
		driverWait.until(ExpectedConditions.visibilityOf(locator));
		driverWait.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	
	protected void clickSearchElement(WebDriver driver, WebElement locator) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

	protected void clickElementUsingBy(WebDriver driver, By locator) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driverWait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	protected void mouseClick(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).click().build().perform();
    }
	protected void mouseDoubleClick(WebDriver driver, WebElement element) {
        new Actions(driver).moveToElement(element).doubleClick().build().perform();
    }

	public void waitForPageLoadedByUsingElement(WebDriver driver, WebElement element) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(element));
		driverWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementToDisplayedUsingBy(WebDriver driver, By locator) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driverWait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void clickWithRetryUsingByLocator(WebDriver driver, By locator) {
		boolean needToRetry = true;
		int count = 0;
		
		while(needToRetry && count<=5)
		{
			try
			{
				driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
				driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				driverWait.until(ExpectedConditions.elementToBeClickable(locator));
				WebElement webelementLocator = driver.findElement(locator);
				jsClick(driver, webelementLocator);
				waitSeconds(2);
				needToRetry = false;
			}
			catch (Exception e)
			{
				LOGGER.info("Clicking element failed. Waiting and trying again...");
				waitSeconds(5);
			}
			count++;
		}

		if(needToRetry)
		{
			LOGGER.info("Clicking element failed. Waiting and trying again...");
			waitSeconds(5);
			WebElement webelementLocator = driver.findElement(locator);
			jsClick(driver, webelementLocator);
		}
	} 

}