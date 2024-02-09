
package com.fxoffice.ui.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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


import groovy.transform.Final;
import io.cucumber.java.Scenario;
import io.netty.handler.timeout.TimeoutException;
import junit.framework.Assert;

public class StaticDataHoliday extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(StaticDataHoliday.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;
	public String[][] rowsData = new String[3][3];
	@FindBy(xpath = "//span[contains(text(),'System Dates')]")
	private WebElement systemDates;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]/ancestor::a[@role='button']")
	private WebElement CancelBtnForTradeDate;

	@FindBy(xpath = "//a[@data-qtip=\"Next Page\" and not(contains(@class,'x-btn-disabled'))]")
	private WebElement nextPage;
	@FindBy(xpath = "//a[@data-qtip=\"First Page\"]")
	private WebElement firstPage;
	
	@FindBy(xpath = "//span[contains(text(),'Calender Code')]/../../../../../following-sibling::div/div/table/tbody/tr/td/div[contains(text(),'/')]")
	private List<WebElement> dateElements;
	
	@FindBy(xpath="//span[contains(text(),'Save')]/ancestor::a")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[contains(text(),'OK')]/ancestor::a")
	private WebElement okBtn;
	@FindBy(xpath="//span[contains(text(),'Search')]/ancestor::a[@role='button']")
	private WebElement searchBtn;	
	public String dateString = "//div[contains(text(),'opt')]/ancestor::tr[@role='row']";
	
	public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	 public String updateCurrencyPairInput="//label[contains(text(),'Spot Days')]/ancestor::tr//input";

	
	public StaticDataHoliday(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Static data Holidays");
	}
	public void launchApplication(String url) {
		driver.get(url);
	}

	public void getTradeDate() {
		waitSeconds(2);
		jsClick(driver, systemDates);
		waitSeconds(2);

		WebElement tradeDateInput = driver.findElement(By.xpath("//input[@name='tradeDate']"));
		String tradeDateValue = tradeDateInput.getAttribute("value");
		jsClick(driver, CancelBtnForTradeDate);

		ParameterService.setParameter("TradeDate", tradeDateValue);
		LOGGER.info("TradeDate: {}", ParameterService.getParameter("TradeDate"));
	}

	public void SearchCurrencyInCalendarcode(String currency) {
		WebElement calendarCode = driver.findElement(By.xpath("//input[@name='calendarCode']"));
		enterText(driver, calendarCode, currency);
		WebElement searchBtnForCalendarCode = driver
				.findElement(By.xpath("//span[contains(text(),'Search')]/ancestor::a[@role='button']"));
		jsClick(driver, searchBtnForCalendarCode);

	}
	public void SearchCurrency(String currency) {
		WebElement currencyInput = driver.findElement(By.xpath("//input[@name='ccy']"));
		enterText(driver, currencyInput, currency);
		WebElement searchBtnForCurrency = driver
				.findElement(By.xpath("//span[contains(text(),'Search')]/ancestor::a[@role='button']"));
		waitForElementToDisplayedUsingBy(driver, By.xpath("//li[text()='"+currency+"']"));
		WebElement currencyOption = driver.findElement(By.xpath("//li[text()='"+currency+"']"));;
		try {
			
			clickElement(driver, currencyOption);
		}catch (Exception e) {
			LOGGER.info("Trying through JS Click");
			jsClick(driver, currencyOption);
		}
		jsClick(driver, searchBtnForCurrency);

	}

	/*
	 * public void deleteHolidayDataFromHolidays() { WebElement row =
	 * driver.findElement(By.xpath("//div[contains(text(),'" +
	 * ParameterService.getParameter("TradeDate") +
	 * "')]/ancestor::tr[@role='row']")); clickElement(driver, row); WebElement
	 * DeleteBtn=driver.findElement(By.xpath(
	 * "//span[contains(text(),'Delete')]/ancestor::a[@role='button']"));
	 * jsClick(driver, DeleteBtn); int i=1; do { String dateString =
	 * ParameterService.getParameter("TradeDate"); DateTimeFormatter formatter =
	 * DateTimeFormatter.ofPattern("MM/dd/yyyy"); LocalDate date =
	 * LocalDate.parse(dateString, formatter); WebElement rowtemp =
	 * driver.findElement(By.xpath("//div[contains(text(),'" + date.plusDays(i) +
	 * "')]/ancestor::tr[@role='row']")); clickElement(driver, row); jsClick(driver,
	 * DeleteBtn); i++; }while(i<=2);
	 * 
	 * 
	 * }
	 * 
	 */
	/*
	 * public void deleteHolidayDataFromHolidays() { String tradeDateString =
	 * ParameterService.getParameter("TradeDate"); DateTimeFormatter formatter =
	 * DateTimeFormatter.ofPattern("MM/dd/yyyy"); LocalDate tradeDate =
	 * LocalDate.parse(tradeDateString, formatter);
	 * 
	 * WebElement row = driver.findElement(By.xpath("//div[contains(text(),'" +
	 * tradeDateString + "')]/ancestor::tr[@role='row']")); WebElement calendarCode
	 * = driver.findElement(By.xpath("//div[contains(text(),'" + tradeDateString +
	 * "')]/ancestor::tr[@role='row']/td[1]")); WebElement date =
	 * driver.findElement(By.xpath("//div[contains(text(),'" + tradeDateString +
	 * "')]/ancestor::tr[@role='row']/td[2]")); WebElement desc =
	 * driver.findElement(By.xpath("//div[contains(text(),'" + tradeDateString +
	 * "')]/ancestor::tr[@role='row']/td[3]"));
	 * rowsData[0][1]=calendarCode.getText(); rowsData[0][2]=date.getText();
	 * rowsData[0][3]=desc.getText(); clickElement(driver, row);
	 * 
	 * WebElement deleteBtn = driver.findElement(By.xpath(
	 * "//span[contains(text(),'Delete')]/ancestor::a[@role='button']"));
	 * jsClick(driver, deleteBtn); int daysToDelete = 2; int i = 1; int count=1; do
	 * { LocalDate currentDate = tradeDate.plusDays(i);
	 * 
	 * // Check if the current date is Saturday or Sunday DayOfWeek dayOfWeek =
	 * currentDate.getDayOfWeek(); if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek
	 * != DayOfWeek.SUNDAY) { WebElement rowTemp =
	 * driver.findElement(By.xpath("//div[contains(text(),'" +
	 * currentDate.format(formatter) + "')]/ancestor::tr[@role='row']")); WebElement
	 * calendarCode = driver.findElement(By.xpath("//div[contains(text(),'" +
	 * currentDate.format(formatter) + "')]/ancestor::tr[@role='row']/td[1]"));
	 * WebElement date = driver.findElement(By.xpath("//div[contains(text(),'" +
	 * currentDate.format(formatter) + "')]/ancestor::tr[@role='row']/td[2]"));
	 * WebElement desc = driver.findElement(By.xpath("//div[contains(text(),'" +
	 * currentDate.format(formatter) + "')]/ancestor::tr[@role='row']/td[3]"));
	 * rowsData[count][1]=calendarCode.getText(); rowsData[count][2]=date.getText();
	 * rowsData[count][3]=desc.getText(); clickElement(driver, rowTemp);
	 * jsClick(driver, deleteBtn); count++; daysToDelete--; }
	 * 
	 * i++; } while (daysToDelete > 0); }
	 */
	public void deleteHolidayDataFromHolidays() {
		String tradeDateString = ParameterService.getParameter("TradeDate");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate tradeDate = LocalDate.parse(tradeDateString, formatter);

//		    WebElement row = driver.findElement(By.xpath("//div[contains(text(),'" + tradeDateString + "')]/ancestor::tr[@role='row']"));

		// Get details from the current row
//		    String calendarCodeText = row.findElement(By.xpath("./td[1]")).getText();
//		    String dateText = row.findElement(By.xpath("./td[2]")).getText();
//		    String descText = row.findElement(By.xpath("./td[3]")).getText();
//
//		    // Store details in rowsData
//		    rowsData[0][1] = calendarCodeText;
//		    rowsData[0][2] = dateText;
//		    rowsData[0][3] = descText;
//
//		    // Click on the row and then click on the Delete button
//		    clickElement(driver, row);
//		    WebElement deleteBtn = driver.findElement(By.xpath("//span[contains(text(),'Delete')]/ancestor::a[@role='button']"));
//		    jsClick(driver, deleteBtn);

		int daysToDelete = 2;
		int count = 1;
		int i = 1;

		do {
			LocalDate currentDate = tradeDate.plusDays(i);
			DayOfWeek dayOfWeek = currentDate.getDayOfWeek();

			if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
				// Locate the row based on the current date
				WebElement rowTemp = driver.findElement(By.xpath(
						"//div[contains(text(),'" + currentDate.format(formatter) + "')]/ancestor::tr[@role='row']"));

				// Get details from the current row
//				calendarCodeText = rowTemp.findElement(By.xpath("./td[1]")).getText();
//				dateText = rowTemp.findElement(By.xpath("./td[2]")).getText();
//				descText = rowTemp.findElement(By.xpath("./td[3]")).getText();
//
//				// Store details in rowsData
//				rowsData[count][1] = calendarCodeText;
//				rowsData[count][2] = dateText;
//				rowsData[count][3] = descText;
//
//				// Click on the row and then click on the Delete button
//				clickElement(driver, rowTemp);
//				jsClick(driver, deleteBtn);

				count++;
				daysToDelete--;
			}

			i++;
		} while (daysToDelete > 0);
		printRowsData();
	}

	public void printRowsData() {
		for (int i = 0; i < rowsData.length; i++) {
			for (int j = 0; j < rowsData[i].length; j++) {
				System.out.print(rowsData[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	/*1public void findDateInTable() {
	        String tradeDateString = ParameterService.getParameter("TradeDate");
	        System.out.println("Trade DAte--------------"+tradeDateString);
	        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	        Date tradeDate;
	        try {
	            tradeDate = dateFormat.parse(tradeDateString);
	        } catch (ParseException e) {
	            System.out.println("Error parsing tradeDateString: " + e.getMessage());
	            return;
	        }

	        boolean exactDate = false;
	        boolean followingDate = false;
	        boolean isFound = true;

	        while (isFound) {
	            List<WebElement> dateElements = driver.findElements(By.xpath("//span[contains(text(),'Calender Code')]/../../../../../following-sibling::div/div/table/tbody/tr/td/div[contains(text(),'/')]"));

	            for (WebElement webElement : dateElements) {
	                System.out.println(webElement.getText() + "  date");
	            }

	            for (WebElement date : dateElements) {
	                if (date.getText().equals(tradeDate.toString())) {
	                    deleteDate(tradeDateString);
	                    exactDate = true;

	                    // Create a Calendar instance to manipulate dates
	                    Calendar calendar = Calendar.getInstance();
	                    calendar.setTime(tradeDate);
	                    calendar.add(Calendar.DAY_OF_MONTH, 1);

	                    // Check if the following date is not a weekend
	                    if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
	                            && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
	                        // Assuming deleteDate deletes the following date
	                        deleteDate(dateFormat.format(calendar.getTime()));

	                        followingDate = true;
	                    }
	                    isFound = false;
	                }
	            }
	            System.out.println("Following date and exactDate: " + followingDate + " " + exactDate);
	            clickElement(driver, nextPage);
	            waitSeconds(3);
	        }
	    }*/
	public void deleteThreeDatesInSamePage() {
	    String tradeDateString = ParameterService.getParameter("TradeDate");
	    System.out.println("Trade Date--------------" + tradeDateString);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	    Date tradeDate;
	    try {
	        tradeDate = dateFormat.parse(tradeDateString);
	    } catch (ParseException e) {
	        System.out.println("Error parsing tradeDateString: " + e.getMessage());
	        return;
	    }

	    int deletedDatesCount = 0;

	    try {
	       // List<WebElement> dateElements = driver.findElements(By.xpath("//span[contains(text(),'Calender Code')]/../../../../../following-sibling::div/div/table/tbody/tr/td/div[contains(text(),'/')]"));

	        for (WebElement webElement : dateElements) {
	            System.out.println(webElement.getText() + "  date");
	        }

	        for (WebElement date : dateElements) {
	            Date currentDate;
	            try {
	                currentDate = dateFormat.parse(date.getText());
	            } catch (ParseException e) {
	                System.out.println("Error parsing date: " + e.getMessage());
	                continue;
	            }

	            if (currentDate.equals(tradeDate) || currentDate.after(tradeDate)) {
	            	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+currentDate);
	                deleteDate(dateFormat.format(currentDate));
	                deletedDatesCount++;

	                if (deletedDatesCount == 3) {
	                    // Exit the loop since we have deleted three dates
	                    break;
	                }
	            }
	        }

	        System.out.println("Deleted dates count: " + deletedDatesCount);

	    } catch (StaleElementReferenceException e) {
	        System.out.println("StaleElementReferenceException: " + e.getMessage());
	        // Handle the exception by refreshing or navigating to the page again
	        // You might need to redefine your elements here based on your specific scenario
	    }
	}

	public void findDateInTable() {
	    String tradeDateString = ParameterService.getParameter("TradeDate");
	    System.out.println("Trade Date--------------" + tradeDateString);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	    Date tradeDate;
	    try {
	        tradeDate = dateFormat.parse(tradeDateString);
	    } catch (ParseException e) {
	        System.out.println("Error parsing tradeDateString: " + e.getMessage());
	        return;
	    }

	    boolean isFound = false;

	    while (!isFound) {
	        try {
	            List<WebElement> dateElements = driver.findElements(By.xpath("//span[contains(text(),'Calender Code')]/../../../../../following-sibling::div/div/table/tbody/tr/td/div[contains(text(),'/')]"));

	            for (WebElement webElement : dateElements) {
	                System.out.println(webElement.getText() + "  date");
	            }

	            for (WebElement date : dateElements) {
	                Date currentDate;
	                try {
	                    currentDate = dateFormat.parse(date.getText());
	                } catch (ParseException e) {
	                    System.out.println("Error parsing date: " + e.getMessage());
	                    continue;
	                }

	                if (currentDate.equals(tradeDate) || currentDate.after(tradeDate)) {
	                    deleteDate(dateFormat.format(currentDate));

	                    // Check if the following date is Saturday or Sunday
	                    Calendar calendar = Calendar.getInstance();
	                    calendar.setTime(currentDate);
	                    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

	                    if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
	                        // If it's Saturday or Sunday, delete the next available Monday or Tuesday
	                        calendar.add(Calendar.DAY_OF_MONTH, 1); // Move to the next day
	                        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.TUESDAY) {
	                            calendar.add(Calendar.DAY_OF_MONTH, 1); // Move to the next day until Monday or Tuesday is found
	                        }
	                        deleteDate(dateFormat.format(calendar.getTime()));
	                    }

	                    isFound = true;
	                    break;  // Exit the loop since we have deleted the dates
	                }
	            }

	            // Continue to the next page
	            // Assuming nextPage is a button or link to go to the next page
	            clickElement(driver, nextPage);
	            waitSeconds(3);

	        } catch (StaleElementReferenceException e) {
	            System.out.println("StaleElementReferenceException: " + e.getMessage());
	            clickElement(driver, firstPage);
	        }
	    }
	}

	 /*public void findDateInTable() {
	        String tradeDateString = ParameterService.getParameter("TradeDate");
	        System.out.println("Trade Date--------------" + tradeDateString);

	        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        // Parse tradeDateString to a LocalDate object
			LocalDate tradeDate = LocalDate.parse(tradeDateString, dateFormat);

			boolean exactDate = false;
			boolean followingDate = false;
			boolean isFound = true;

			while (isFound) {
			    List<WebElement> dateElements = driver.findElements(By.xpath("//span[contains(text(),'Calender Code')]/../../../../../following-sibling::div/div/table/tbody/tr/td/div[contains(text(),'/')]"));

			    for (WebElement webElement : dateElements) {
			        System.out.println(webElement.getText() + "  date");
			    }

			    for (WebElement date : dateElements) {
			        if (date.getText().equals(tradeDate.toString())) {
			            //deleteDate(tradeDateString);
			            
			            //exactDate = true;

			            // Check if the following date is not a weekend
			           
			            
			        	int i=0,j=0;
				        //LocalDate followingDateString = tradeDate.plusDays(1);
				        String[] dateCollection = new String[2];
				        while(i<2) {
				        	LocalDate followingDateString = tradeDate.plusDays(1);
				        
			            if (followingDateString.getDayOfWeek() != DayOfWeek.SATURDAY
			                    && followingDateString.getDayOfWeek() != DayOfWeek.SUNDAY) {
			                // Assuming deleteDate deletes the following date
			            	dateCollection[i]=followingDateString.toString();
			                //deleteDate(dateFormat.format(followingDateString));
			                //followingDate = true;
			            }else {
			            	
			            	dateCollection[i]=followingDateString.plusDays(2).toString();
			            	
			            	
			            }
			            while(j<2) {
			            	deleteDate(dateCollection[j]);
			            	
			            }
			            isFound = false;
			            
			        }
			        
			        }
			    }
			    System.out.println("Following date and exactDate: " + followingDate + " " + exactDate);
			    clickElement(driver, nextPage);
			    waitSeconds(3);
			}
	    }*/

	 
	 
	 
	/*public void findDateInTable() {
		
		String tradeDateString = ParameterService.getParameter("TradeDate");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		//LocalDate tradeDate = LocalDate.parse(tradeDateString, formatter);
		Date tradeDate=dateFormat.parse(tradeDateString);
    	
    	boolean exactDate = false;
    	boolean followingDate = false;
	    
	    boolean isFound = true;
	   
	   
	    	while(isFound) {
		    	List<WebElement> dateElements = driver.findElements(By.xpath("//span[contains(text(),'Calender Code')]/../../../../../following-sibling::div/div/table/tbody/tr/td/div[contains(text(),'/')]"));
		    	
		    	for (WebElement webElement : dateElements) {
					System.out.println(webElement.getText()+"  date");
				}
		    	for (WebElement date : dateElements) {
					if(date.getText().equals(tradeDateString)) {
					deleteDate(tradeDateString);
						exactDate = true;
						if(tradeDate.plusDays(1).getDayOfWeek() != DayOfWeek.SATURDAY && tradeDate.plusDays(1).getDayOfWeek() != DayOfWeek.SUNDAY) {
						deleteDate(tradeDate.plusDays(1).toString());
							followingDate = true;
						}
						isFound = false;
					}
				}
		    	System.out.println("Following date and exactDate : "+ followingDate + " "+ exactDate);
		    	clickElement(driver, nextPage);
		    	waitSeconds(3);
		    }
	    
	   
	    

	}*/
	// ... your existing methods ...
	 private boolean isBusinessDate(String date) {
	        // Check if the day of the week is not Saturday (DayOfWeek.SATURDAY) or Sunday (DayOfWeek.SUNDAY)
		 LocalDate date1=LocalDate.parse(date);
	        DayOfWeek dayOfWeek = date1.getDayOfWeek();
	        if(dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
	        	//ParameterService.setParameter("TradeDate", date.plusDays(1).toString());
	        	return true;
	        }
	        else {
	        	//ParameterService.setParameter("TradeDate", date.plusDays(2).toString());
	        	return false;
	        }
	    }

	/* public void findAndDeleteDates() {
		    String tradeDateString = ParameterService.getParameter("TradeDate").trim();
		    System.out.println("=================================" + tradeDateString);

		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//		    LocalDate tradeDate = LocalDate.parse(tradeDateString, formatter);
		    System.out.println("=================================" + tradeDateString);

		    int datesDeleted = 0; // Track the number of dates deleted

		    do {
		        try {
		            List<WebElement> dateElements = driver.findElements(By.xpath("//span[contains(text(),'Calender Code')]/../../../../../following-sibling::div/div/table/tbody/tr/td/div[contains(text(),'/')]"));

		            for (WebElement webElement : dateElements) {
		                System.out.println(webElement.getText() + "  date");
		            }

		            for (WebElement date : dateElements) {
		            
		                    // Re-find the element to avoid StaleElementReferenceException
		                    //date = driver.findElement(By.xpath("//span[contains(text(),'Calender Code')]/../../../../../following-sibling::div/div/table/tbody/tr/td/div[contains(text(),'/')]"));

		                    //LocalDate currentDate = LocalDate.parse(date.getText(), formatter);

		                    System.out.println(date.getText().toString()+"=="+ParameterService.getParameter("TradeDate")+" "+isBusinessDate(date.getText()));

		                    if (date.getText().equals(ParameterService.getParameter("TradeDate")) && isBusinessDate(date.getText())) {
		                        deleteDate(ParameterService.getParameter("TradeDate"));
		                        jsClick(driver, firstPage);
//		                        ParameterService.setParameter("TradeDate", tradeDate.plusDays(1).toString());
		                        datesDeleted++;

		                        if (datesDeleted >= 3) {
		                            return; // Exit the method if three dates have been deleted
		                        }

		                        break;
		                    } else {
//		                        ParameterService.setParameter("TradeDate", tradeDate.plusDays(2).toString());
		                        //jsClick(driver, firstPage);
		                    }
		                
		            }

		            clickElement(driver, nextPage);
		            waitSeconds(3);
		        } catch (StaleElementReferenceException e) {
		            // Handle StaleElementReferenceException by re-finding the elements or taking appropriate action
		            System.err.println("StaleElementReferenceException occurred. Retrying...");
		        }
		        
		        
		    } while (true);
		}*/



	// ... your existing methods ...

	
/*public void findAndDeleteDate() {
		
		String tradeDateString = ParameterService.getParameter("TradeDate");
		
		String tradeDateCopy=tradeDateString;
		delete(tradeDateString);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate tradeDate = LocalDate.parse(tradeDateString, formatter);
    	
    int i=1,count=1,daysToDelete = 2;;
	   
	   do {
		   
		   if(tradeDate.plusDays(count).getDayOfWeek()!=DayOfWeek.SUNDAY && tradeDate.plusDays(count).getDayOfWeek()!=DayOfWeek.SATURDAY) {
			   tradeDateCopy=tradeDate.plusDays(count).toString();
			   delete(tradeDateCopy);
			   count++;
			   daysToDelete--;
			   
		   }
		 
	    	
		    	
	}while(daysToDelete > 0);
	   }
	
	

	public void deleteDate(String dateForDeletion) {
		
		WebElement dateToDelete=driver.findElement(By.xpath(dateString.replace("opt",dateForDeletion)));
		jsClick(driver, dateToDelete);
		
		// Get details from the current row
	    String calendarCodeText = dateToDelete.findElement(By.xpath("./td[1]")).getText();
	    String dateText = dateToDelete.findElement(By.xpath("./td[2]")).getText();
	    String descText = dateToDelete.findElement(By.xpath("./td[3]")).getText();

	   int i=0;
	   while(i<3) {
	    rowsData[i][1] = calendarCodeText;
	    rowsData[i][2] = dateText;
	    rowsData[i][3] = descText;
	    i++;
	   }
		//jsClick(driver, dateToDelete);
		  WebElement deleteBtn = driver.findElement(By.xpath("//span[contains(text(),'Delete')]/ancestor::a[@role='button']"));
		    jsClick(driver, deleteBtn);
		    WebElement yesToDelete = driver.findElement(By.xpath("//span[text()='Yes']/ancestor::a[@role='button']"));
		    jsClick(driver, yesToDelete);
		    waitSeconds(15);
		
	}
	
	
	public void delete(String date) {
		System.out.println("22222");
		int i=0;
		 do {
				System.out.println("findDate(date):"+findDate(date));
			 if(findDate(date)){

					System.out.println("2333332");
				 deleteDate(date);
				 break;
			 }
			 else {
				 System.out.println("1111111");
				 waitSeconds(10);
				 jsClick(driver,nextPage);
			 }
			 i++;
		 }while(i<14);
			 
			 
		 }
		 
		
		
	public boolean findDate(String dateToDelete) {
	    try {
	        By xpath = By.xpath("//div[contains(text(),'" + dateToDelete + "')]/ancestor::tr[@role='row']");
	        WebElement row = driverWait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

	        System.out.println("Element found: " + dateToDelete);
	        return true;
	    } catch (TimeoutException e) {
	        // Handle exceptions, log them if needed
	        System.out.println("Element not found or not visible: " + dateToDelete + " - " + e.getMessage());
	    }
	    return false;
	}*/
	/*public void findAndDeleteDate() {
        String tradeDateString = ParameterService.getParameter("TradeDate");
        
        // Copy the original trade date for reference
        String tradeDateCopy = tradeDateString;
        
        // Delete the original trade date
        delete(tradeDateString);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate tradeDate = LocalDate.parse(tradeDateString, formatter);

        int i = 1, count = 1, daysToDelete = 2;

        do {
            // Check if the current date is not Saturday or Sunday
            if (tradeDate.plusDays(count).getDayOfWeek() != DayOfWeek.SUNDAY &&
                tradeDate.plusDays(count).getDayOfWeek() != DayOfWeek.SATURDAY) {
                
                // Update the tradeDateCopy for the new date to be deleted
                tradeDateCopy = tradeDate.plusDays(count).toString();
                
                // Delete the current date
                delete(tradeDateCopy);

                count++;
                daysToDelete--;

            }

        } while (daysToDelete > 0);
    }*/

    // Other methods remain unchanged...

    public void delete(String date) {
        System.out.println("22222");
        int i = 0;
        do {
            System.out.println("findDate(date):" + findDate(date));
            if (findDate(date)) {
                System.out.println("2333332");
                deleteDate(date);
                break;
            } else {
                System.out.println("1111111");
                waitSeconds(10);
                jsClick(driver, nextPage);
            }
            i++;
        } while (i < 14);

    }

    public boolean findDate(String dateToDelete) {
        try {
            By xpath = By.xpath("//div[contains(text(),'" + dateToDelete + "')]/ancestor::tr[@role='row']");
            WebElement row = driverWait.until(ExpectedConditions.visibilityOfElementLocated(xpath));

            System.out.println("Element found: " + dateToDelete);
            return true;
        } catch (TimeoutException e) {
            // Handle exceptions, log them if needed
            System.out.println("Element not found or not visible: " + dateToDelete + " - " + e.getMessage());
        }
        return false;
    }
public void deleteDate(String dateForDeletion) {
	LocalDate inputDate = LocalDate.parse(dateForDeletion,formatter);
	String tempDate=inputDate.format(formatter);
	//scrollIntoView(driver, CancelBtnForTradeDate);
		
		WebElement dateToDelete=driver.findElement(By.xpath(dateString.replace("opt",tempDate)));
		scrollIntoView(driver,dateToDelete);
		jsClick(driver, dateToDelete);
		
		// Get details from the current row
	    /*String calendarCodeText = dateToDelete.findElement(By.xpath("./td[1]")).getText();
	    String dateText = dateToDelete.findElement(By.xpath("./td[2]")).getText();
	    String descText = dateToDelete.findElement(By.xpath("./td[3]")).getText();

	   int i=0;
	   while(i<3) {
	    rowsData[i][1] = calendarCodeText;
	    rowsData[i][2] = dateText;
	    rowsData[i][3] = descText;
	    i++;
	   }*/
		//jsClick(driver, dateToDelete);
		  WebElement deleteBtn = driver.findElement(By.xpath("//span[contains(text(),'Delete')]/ancestor::a[@role='button']"));
		    jsClick(driver, deleteBtn);
		    WebElement yesToDelete = driver.findElement(By.xpath("//span[text()='Yes']/ancestor::a[@role='button']"));
		    jsClick(driver, yesToDelete);
		   
		
	}

public void closeCurrentTab() {
	
	 WebElement closeTab = driver.findElement(By.xpath(" //span[contains(text(),'Manager')]//ancestor::span/following-sibling::span[@class='x-tab-close-btn']"));
	    jsClick(driver, closeTab);
	
}
public void staticDataCurrencyUpdation(String precision, String currency) {
	waitSeconds(3);
	
	



    waitSeconds(5);
    
    List<String> items = Arrays.asList(
        "Currency",
        "Currency Name",
        "Day Count",
        "Amount Precision",
        "Weekend Holidays",
        "Trading Disabled",
        "Indexes",
        "Wire Delivery Enabled",
        "Wire Days to Deliver",
        "Wire Cut Off Time",
        "Check Delivery Enabled",
        "Check Days to Deliver",
        "Check Cut Off Time"
    );

    WebElement recordData = driver.findElement(By.xpath("//tr[@data-recordid='" + currency + "']"));
    System.out.println("start" + precision);

    driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[@data-recordid='" + currency + "']")));
   

    int i = 1;
    while (i <= 13) {
        WebElement data = recordData.findElement(By.xpath("./td[" + i + "]"));
        System.out.println(items.get(i - 1) + ": " + data.getText());
        ParameterService.setParameter(items.get(i - 1), data.getText());
        i++;
    }
  mouseDoubleClick(driver, recordData);
  WebElement dayCountInput = driver.findElement(By.xpath("//input[@name='dayCount']"));
  checkDayCount(dayCountInput.getText());
  waitSeconds(3);
	WebElement amountPrecisionInput = driver.findElement(By.xpath("//input[@name='amountPrecision']"));
  checkAmountPrecision(amountPrecisionInput.getText(),precision);
  waitSeconds(3);
  weekendHolydayCheckBox();
  tradeDiabled();
  waitSeconds(3);
  deliveryDisable();
	WebElement saveButton = driver.findElement(By.xpath("//span[text()='Save']/ancestor::a[@role='button']"));
  clickElement(driver, saveButton);
  waitSeconds(3);
  WebElement okButton = driver.findElement(By.xpath("//span[text()='OK']/ancestor::a[@role='button']"));
  clickElement(driver, okButton);
  
    

    
    System.out.println("finish");
}



private void deliveryDisable() {
	WebElement tradingDisabledCheckbox = driver.findElement(By.xpath("//label[contains(text(),'Trading Disabled')]/ancestor::table[contains(@class,'x-form-type-checkbox')]//input[@type='button']"));
if(tradingDisabledCheckbox.isEnabled()) {
	clickElement(driver, tradingDisabledCheckbox);
}
	
}

private void tradeDiabled() {
	WebElement enableWireDelivery = driver.findElement(By.xpath("//label[contains(text(),'Enable Wire Delivery')]/ancestor::table[contains(@class,'x-form-type-checkbox')]//input[@type='button']"));
	WebElement enableCheckDelivery = driver.findElement(By.xpath("//label[contains(text(),'Enable Check Delivery')]/ancestor::table[contains(@class,'x-form-type-checkbox')]//input[@type='button']"));
	if(enableWireDelivery.isEnabled()) {
		clickElement(driver,enableWireDelivery );
	}
	if(enableCheckDelivery.isEnabled()) {
		clickElement(driver, enableCheckDelivery);
	}


	
}

private void checkAmountPrecision(String precisionValue, String precision) {
	WebElement amountPrecisionInput = driver.findElement(By.xpath("//input[@name='amountPrecision']"));
	if(!(precisionValue.equals(precision))) {
		amountPrecisionInput.clear();
		enterText(driver, amountPrecisionInput, precision);
	}
}

private void checkDayCount(String dayCount) {
	WebElement dayCountInput = driver.findElement(By.xpath("//input[@name='dayCount']"));
	if(!(dayCount.equals("360"))) {
		dayCountInput.clear();
		enterText(driver,dayCountInput, "360");
	}
	
	
}

private void checkDayCount() {
	// TODO Auto-generated method stub
	
}

// Add your waitSeconds, jsClick, and other utility methods here


public void weekendHolydayCheckBox() {

	
	WebElement Sat = driver.findElement(By.xpath("//label[contains(text(),'SAT')]/ancestor::table[contains(@class,'x-form-type-checkbox')]//input[@type='button']"));

	// Check if the checkbox is selected
	System.out.println(Sat.getAttribute("class").contains("x-form-cb-checked"));
	if (!Sat.getAttribute("class").contains("x-form-cb-checked")) {
	    System.out.println("1");
	    WebElement SatCheck = driver.findElement(By.xpath("//label[contains(text(),'SAT')]"));
	    jsClick(driver, SatCheck);
	}

	WebElement Sun = driver.findElement(By.xpath("//label[contains(text(),'SUN')]/ancestor::table[contains(@class,'x-form-type-checkbox')]//input[@type='button']"));
	System.out.println(Sun.getAttribute("class").contains("x-form-cb-checked"));
	if (!Sun.getAttribute("class").contains("x-form-cb-checked")) {
	    System.out.println("2");
	    WebElement sunCheck = driver.findElement(By.xpath("//label[contains(text(),'SUN')]"));
	    jsClick(driver, sunCheck);
	}

	WebElement Fri = driver.findElement(By.xpath("//label[contains(text(),'FRI')]//ancestor::table[contains(@class,'x-form-type-checkbox')]//input[@type='button']"));
	System.out.println(Fri.getAttribute("class").contains("x-form-cb-checked"));
	if (Fri.getAttribute("class").contains("x-form-cb-checked")) {
	    System.out.println("3");
	    WebElement friCheck = driver.findElement(By.xpath("//label[contains(text(),'FRI')]"));
	    jsClick(driver, friCheck);
	}
}
public void updateCurrencyPair(String currencyPair) {
	Map<String, String> currencyPairProperties = new LinkedHashMap<String, String>();
	String Currency1=currencyPair.substring(0, 3);
	String Currency2=currencyPair.substring(3);
	WebElement currencyPairInput=driver.findElement(By.xpath("//input[@name='ccyPair']"));
	enterText(driver, currencyPairInput,currencyPair);
	clickElement(driver, searchBtn);
	waitSeconds(3);
	WebElement currencyPairRow=driver.findElement(By.xpath("//tr[@data-recordindex='0']"));
	waitSeconds(3);
	mouseDoubleClick(driver, currencyPairRow);
	
	

    // Populate the Map with key-value pairs
    currencyPairProperties.put("Currency Pair", currencyPair);
    currencyPairProperties.put("Spot Days", "2");
    currencyPairProperties.put("Swap Factor", "10000");
    currencyPairProperties.put("Spot Rate Precision", "6");
    currencyPairProperties.put("Fwd Rate Precision", "6");
    currencyPairProperties.put("Fwd Point Precision", "6");
    currencyPairProperties.put("Base Amt Precision","2");
    currencyPairProperties.put("Quote Amt Precision", "2");
    currencyPairProperties.put("Rate Validity (seconds)", "15");
    currencyPairProperties.put("Value Date Calendar",Currency1+","+Currency2);
    currencyPairProperties.put("Fixing Date Calendar", "HKD");
    currencyPairProperties.put("Risk Group", "EM");
    currencyPairProperties.put("Rate Stale After(seconds)", "180000000");
    currencyPairProperties.put("Fixing Days", "2");
    currencyPairProperties.put("Tolerance (%)", "0");
    currencyPairProperties.put("Inverted Rate Precision", "4");
    
    
    Set<String> keys=currencyPairProperties.keySet();
    System.out.println(keys);
    for (String key : keys) {
    	WebElement inputField=driver.findElement(By.xpath(updateCurrencyPairInput.replace("Spot Days",key)));
    	waitSeconds(2);
    	System.out.println(key+"========="+inputField.getAttribute("value"));
    	
    	if(!(inputField.getAttribute("value").equals(currencyPairProperties.get(key)) && key.equals("Risk Group"))) {
    		System.out.println(key+"=="+inputField.getAttribute("value")+"==========="+currencyPairProperties.get(key));
    		enterText(driver, inputField,currencyPairProperties.get(key).toString());
    	}
    	else {
    		System.out.println(key+"=="+inputField.getAttribute("value")+"==========="+currencyPairProperties.get(key));
    		if(!inputField.getAttribute("value").equals(currencyPairProperties.get(key))) {
    		jsClick(driver, currencyPairRow);
    		waitSeconds(2);
    		WebElement riskGroup=driver.findElement(By.xpath("//li[text()='EM']"));
    		clickElement(driver, riskGroup);}
    		
    	}
    	
    	
		
	}
    jsClick(driver, saveBtn);
    jsClick(driver, okBtn);
    

}

    // Other methods remain unchanged...


	

}
