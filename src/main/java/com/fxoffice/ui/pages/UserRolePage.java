package com.fxoffice.ui.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Arrays;
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
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class UserRolePage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRolePage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;

	@FindBy(xpath = "//div[@id='ENTITLEMENT_FORM']//span[text()='New']")
	private WebElement newRoleBtn;

	@FindBy(name = "roleName")
	private WebElement roleNameTxtbox;

	@FindBy(xpath = "//div[text()='User Role is created']")
	private WebElement sucessMsg;

	@FindBy(xpath = "//span[text()='OK']")
	private WebElement sucessMsgOkBtn;

	@FindBy(xpath = "//span[text()='Save']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "(//img[@role='presentation'])[2]")
	private WebElement closeImg;

	@FindBy(xpath = "//div[text()='User Role is updated']")
	private WebElement sucessUpdateMsg;

	@FindBy(xpath = "//div[@id='User Role Manager-body']/div[1]//tbody/tr/td/div")
	private WebElement userRow;

	@FindBy(xpath = "//div[@id='User Role Manager-body']/div[1]//tbody/tr")
	private List<WebElement> userRows;

	@FindBy(xpath = "//span[text()='FXOffice']/..//input")
	private WebElement FXOfficeCheckbox;

	@FindBy(xpath = "//span[text()='Audit']")
	private WebElement auditEle;

	@FindBy(xpath = "//span[text()='Close']")
	private WebElement dataImportCloseEle;

	@FindBy(xpath = "//div[@id='Business Units-body']//table//tr/td")
	private WebElement selectBuinessUnitRow;

	@FindBy(xpath = "(//span[contains(text(),'Login Id')]/../../../../../following-sibling::div//tbody/tr)[1]")
	private WebElement tableRow;
	
	@FindBy(xpath = "(//div[contains(@id,'COSTCENTER_GRID')]//tr)[1]")
	private WebElement CostCenterTableRow;
	
	@FindBy(xpath = "(//div[contains(@id,'EXCLUSION_LIST_GRID-body')]//tr)[1]")
	private WebElement exclusionManagerTableRow;
	
	@FindBy(xpath = "(//div[contains(@id,'RELMGR_GRID-body')]//tr)[1]")
	private WebElement relationShipManagerTableRow;
	
	@FindBy(xpath = "(//div[contains(@id,'STATIC_CURRENCY_MANAGER_GRID-body')]//tr)[1]")
	private WebElement currencyTableRow;
	
	@FindBy(xpath = "(//div[contains(@id,'CURRENCY_PAIR_GRID-body')]//tr)[1]")
	private WebElement currencyPairTableRow;

	@FindBy(xpath = "//span[text()='Search']/../../..")
	private WebElement searchBtn;
	
	private String tableRowOption= "(//span[contains(text(),'Login Id')]/../../../../../following-sibling::div//tbody/tr)[1]";

	// Constructor

	public UserRolePage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Home Page of FXOffice Application.");
		driverWait.until(ExpectedConditions.titleContains("FX STAR"));
	}
	


// Page Objects
	public void createUserRole(String userrolename) throws Exception {

		boolean flag = userRole(userrolename);

		if (flag == true) {

		} else {
			jsClick(driver, newRoleBtn);
			enterText(driver, newRoleBtn, userrolename);
			jsClick(driver, saveBtn);
			jsClick(driver, sucessMsgOkBtn);
		}

		/*
		 * Thread.sleep(20000); int
		 * roleName=driver.findElements(By.xpath("//div[text()='"+userrolename+"']")).
		 * size();
		 * 
		 * 
		 * if(roleName==0) { jsClick(driver, newRoleBtn); roleNameTxtbox.clear();
		 * roleNameTxtbox.sendKeys(userrolename); jsClick(driver, saveBtn);
		 * WebDriverWait wait = new WebDriverWait(driver,40);
		 * //wait.until(ExpectedConditions.visibilityOf(sucessMsgOkBtn));
		 * //sucessMsg.isDisplayed(); jsClick(driver, sucessMsgOkBtn); }
		 */
	}

	public boolean userRole(String userrolename) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		driverWait.until(ExpectedConditions.visibilityOf(userRow));
		boolean flag = false;
		int count = userRows.size();
		System.out.println("value===>" + count);
		for (int i = 1; i <= count; i++) {
			String value = driver
					.findElement(By.xpath("//div[@id='User Role Manager-body']/div[1]//tbody/tr[" + i + "]/td/div"))
					.getText();
			System.out.println("value===>" + value);
			if (value.equals(userrolename)) {
				System.out.println("value===>" + value);
				System.out.println("===userrolename>" + userrolename);
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void searchUser(String userrolename) throws Exception {

		boolean flag = userRole(userrolename);

		if (flag == true) {
			WebElement roleName = driver.findElement(By.xpath("//div[text()='" + userrolename + "']"));
			Actions act = new Actions(driver);
			act.moveToElement(roleName).doubleClick().build().perform();
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOf(FXOfficeCheckbox));

		} else {

		}

		/*
		 * Thread.sleep(10000); WebElement
		 * roleName=driver.findElement(By.xpath("//div[text()='"+userrolename+"']"));
		 * WebDriverWait wait = new WebDriverWait(driver,40);
		 * wait.until(ExpectedConditions.visibilityOf(roleName)); Actions act=new
		 * Actions(driver); act.moveToElement(roleName).doubleClick().build().perform();
		 * Thread.sleep(10000);
		 */
	}

	public void CheckEntitlement(String entitlementName) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 40);

		System.out.println("====>" + entitlementName);

		WebElement ele = driver.findElement(By.xpath("//span[text()='" + entitlementName + "']/..//input"));
		scrollIntoView(driver, ele);
		wait.until(ExpectedConditions.visibilityOf(ele));

		// Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[text()='" + entitlementName + "']"));
		scrollIntoView(driver, ele);
		wait.until(ExpectedConditions.visibilityOf(element));
		int count = driver
				.findElements(By.xpath("//span[text()='" + entitlementName + "']/..//input[@aria-checked='true']"))
				.size();
		System.out.println("Thread.sleep(10000);==" + count);
		if (count == 1) {

		} else {
			jsClick(driver, ele);
			count = 1;
		}
	}

	public void UnCheckEntitlement(String entitlementName) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 40);

		System.out.println("====>" + entitlementName);

		WebElement ele = driver.findElement(By.xpath("//span[text()='" + entitlementName + "']/..//input"));
		wait.until(ExpectedConditions.visibilityOf(ele));
		scrollIntoView(driver, ele);
		// Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//span[text()='" + entitlementName + "']"));
		wait.until(ExpectedConditions.visibilityOf(element));
		int count = driver
				.findElements(By.xpath("//span[text()='" + entitlementName + "']/..//input[@aria-checked='true']"))
				.size();
		System.out.println("Thread.sleep(10000);==" + count);
		if (count == 1) {
			jsClick(driver, ele);
			count = 1;
		} else {

		}
	}

	public void UnCheckAllEntitlement() throws Exception {
		int count = driver.findElements(By.xpath("//span[text()='FXOffice']/..//input[@aria-checked='true']")).size();
		System.out.println("Thread.sleep(10000);==" + count);
		if (count == 1) {

		} else {
			jsClick(driver, FXOfficeCheckbox);
			// Thread.sleep(3000);
			jsClick(driver, saveBtn);
			jsClick(driver, sucessMsgOkBtn);
			// Thread.sleep(3000);
			jsClick(driver, FXOfficeCheckbox);
			// Thread.sleep(3000);
			jsClick(driver, saveBtn);
			jsClick(driver, sucessMsgOkBtn);
		}

		/*
		 * WebElement
		 * ele=driver.findElement(By.xpath("//span[text()='FXOffice']/..//input"));
		 * scrollIntoView(driver, ele); Thread.sleep(2000); int
		 * count=driver.findElements(By.xpath(
		 * "//span[text()='FXOffice']/..//input[@aria-checked='true']")).size();
		 * System.out.println("Thread.sleep(10000);=="+count); if(count==1) {
		 * 
		 * }else { jsClick(driver, ele); Thread.sleep(3000); jsClick(driver, saveBtn);
		 * Thread.sleep(5000); sucessUpdateMsg.isDisplayed();
		 * 
		 * jsClick(driver, sucessMsgOkBtn);
		 * 
		 * Thread.sleep(10000); WebElement
		 * ele1=driver.findElement(By.xpath("//span[text()='FXOffice']/..//input"));
		 * scrollIntoView(driver, ele1);
		 * 
		 * jsClick(driver, ele1); Thread.sleep(3000); jsClick(driver, saveBtn);
		 * Thread.sleep(5000); sucessUpdateMsg.isDisplayed();
		 * 
		 * jsClick(driver, sucessMsgOkBtn); Thread.sleep(2000);
		 * 
		 * }
		 */
	}

	public void CheckMultipleEntitlement(String entitlementName) throws Exception {
		/*
		 * Thread.sleep(10000); WebElement
		 * roleName=driver.findElement(By.xpath("//div[text()='"+userrolename+"']"));
		 * WebDriverWait wait = new WebDriverWait(driver,40);
		 * wait.until(ExpectedConditions.visibilityOf(roleName)); Actions act=new
		 * Actions(driver); act.moveToElement(roleName).doubleClick().build().perform();
		 * Thread.sleep(10000);
		 */

		String[] entitlementArr = entitlementName.split(",");
		for (String singleEntitlement : entitlementArr) {
			System.out.print(singleEntitlement);
			WebElement ele = driver.findElement(By.xpath("//span[text()='" + singleEntitlement + "']/..//input"));
			scrollIntoView(driver, ele);
			// Thread.sleep(2000);
			int count = driver
					.findElements(
							By.xpath("//span[text()='" + singleEntitlement + "']/..//input[@aria-checked='true']"))
					.size();
			System.out.println("Thread.sleep(10000);==" + count);
			if (count == 1) {

			} else {
				jsClick(driver, ele);
				count = 1;
			}
		}

	}

	public void UnCheckMultipleEntitlement(String userrolename, String entitlementName) throws Exception {
		/*
		 * Thread.sleep(10000); WebElement
		 * roleName=driver.findElement(By.xpath("//div[text()='"+userrolename+"']"));
		 * WebDriverWait wait = new WebDriverWait(driver,40);
		 * wait.until(ExpectedConditions.visibilityOf(roleName)); Actions act=new
		 * Actions(driver); act.moveToElement(roleName).doubleClick().build().perform();
		 * Thread.sleep(10000);
		 */
		// (//span[text()='Enable/Disable Cover Message']/following::input)[1]
		// driver.findElement(By.xpath("(//span[text()='Enable/Disable Cover
		// Message']/following::input)[1]")).click();

		System.out.println("====>" + entitlementName);

		String[] entitlementArr = entitlementName.split(",");
		for (String singleEntitlement : entitlementArr) {

			WebElement ele = driver.findElement(By.xpath("//span[text()='" + singleEntitlement + "']/..//input"));
			scrollIntoView(driver, ele);
			Thread.sleep(2000);
			int count = driver
					.findElements(
							By.xpath("//span[text()='" + singleEntitlement + "']/..//input[@aria-checked='true']"))
					.size();
			System.out.println("Thread.sleep(10000);==" + count);
			if (count == 1) {
				jsClick(driver, ele);
			} else {

			}
			Thread.sleep(5000);
		}

	}

	public void saveButton() {
		LOGGER.info("Clicking saveBtn");
		jsClick(driver, saveBtn);

	}
	// jsClick(driver, saveBtn);
	// Thread.sleep(5000);
	// sucessUpdateMsg.isDisplayed();

	public void sucessMsgOkBtn() throws InterruptedException {
		LOGGER.info("Clicking ");
		// Thread.sleep(5000);
		jsClick(driver, sucessMsgOkBtn);
		// Assert.assertEquals(count,count);
	}

	public void UnCheckEntitlement(String userrolename, String entitlementName) throws Exception {
		/*
		 * Thread.sleep(10000); WebElement
		 * roleName=driver.findElement(By.xpath("//div[text()='"+userrolename+"']"));
		 * WebDriverWait wait = new WebDriverWait(driver,40);
		 * wait.until(ExpectedConditions.visibilityOf(roleName)); Actions act=new
		 * Actions(driver); act.moveToElement(roleName).doubleClick().build().perform();
		 * Thread.sleep(10000);
		 */

		driverWait = new WebDriverWait(driver, Duration.ofSeconds(40));

		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//span[text()='" + entitlementName + "']/..//input"));
		scrollIntoView(driver, ele);
		// Thread.sleep(2000);
		driverWait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//span[text()='" + entitlementName + "']"))));
		int count = driver
				.findElements(By.xpath("//span[text()='" + entitlementName + "']/..//input[@aria-checked='true']"))
				.size();
		// span[text()='Access Admin Menu']/..//input[@aria-checked='true']
		System.out.println("Thread.sleep(10000);==" + count);

		if (count == 1) {
			jsClick(driver, ele);
		} else {
			// jsClick(driver, ele);
			// count=1;
		}

		jsClick(driver, saveBtn);
		// Thread.sleep(5000);
		driverWait.until(ExpectedConditions.visibilityOf(sucessUpdateMsg));
		sucessUpdateMsg.isDisplayed();

		jsClick(driver, sucessMsgOkBtn);
		Assert.assertEquals(count, count);

	}

	public boolean VerifyPresenceOfEntitlement(String menu) throws Exception {

		return driver.findElement(By.xpath("//span[text()='" + menu + "']")).isDisplayed();

	}

	public boolean VerifyAbsenceOfEntitlement(String menu) throws Exception {

		return driver
				.findElement(
						By.xpath("//span[text()='" + menu + "']/../../../..//a[contains(@class,'x-item-disabled')]"))
				.isDisplayed();

	}

	public void navigateMenuAndSubmenu(String menu, String submenu) throws Exception {
		WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
		jsClick(driver, ele);
		WebDriverWait wait = new WebDriverWait(driver, 40);

		WebElement submenuEle = driver.findElement(By.xpath("(//span[text()='" + submenu + "'])[2]"));
		wait.until(ExpectedConditions.visibilityOf(submenuEle));
		jsClick(driver, submenuEle);

	}

	public boolean navigateMenuAndVerifySubmenu(String menu, String submenu) throws Exception {
		WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
		jsClick(driver, ele);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		Thread.sleep(7000);
		WebElement submenuEle = driver.findElement(By.xpath("(//span[text()='" + submenu + "'])[2]"));
		wait.until(ExpectedConditions.visibilityOf(submenuEle));
		return submenuEle.isDisplayed();
	}

	public boolean navigateMenuAndVerifySubmenuNotPresent(String menu, String submenu) throws Exception {
		boolean flag = false;
		try {
			WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
			jsClick(driver, ele);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			Thread.sleep(7000);

			WebElement submenuEle = driver.findElement(By.xpath("(//span[text()='" + submenu + "'])[2]"));
			wait.until(ExpectedConditions.visibilityOf(submenuEle));
			submenuEle.isDisplayed();
			flag = false;
		} catch (Exception e) {
			flag = true;
		}

		return flag;
	}

	public boolean VerifycheckSingleSubmenu(String menu, String submenu) throws Exception {
		boolean flag = false;
		WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
		jsClick(driver, ele);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		Thread.sleep(7000);

		WebElement submenuEle = driver.findElement(By.xpath("//span[text()='" + submenu + "']"));
		wait.until(ExpectedConditions.visibilityOf(submenuEle));
		if (submenuEle.isDisplayed()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean VerifycheckSingleSubmenuInnerMenu(String menu, String submenu, String innerMenu) throws Exception {
		boolean flag = false;
		WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
		jsClick(driver, ele);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		Thread.sleep(7000);

		WebElement submenuEle = driver.findElement(By.xpath("//span[text()='" + submenu + "']"));
		wait.until(ExpectedConditions.visibilityOf(submenuEle));

		jsClick(driver, submenuEle);
		Thread.sleep(3000);

		if (innerMenu.equals("Record Audit") || innerMenu.equals("Field Audit") || innerMenu.equals("Activities")) {
			jsClick(driver, auditEle);
		}

		WebElement innerEle = driver.findElement(By.xpath("//span[text()='" + innerMenu + "']"));
		wait.until(ExpectedConditions.visibilityOf(innerEle));

		if (innerEle.isDisplayed()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}

	public boolean VerifycheckSingleSubmenuMultipleInnerMenu(String menu, String submenu, String innerMenu)
			throws Exception {
		boolean flag = false;
		WebElement ele = driver.findElement(By.xpath("//span[text()='"+menu+"']/ancestor::a[not(contains(@class,'x-btn-disabled'))]"));
		jsClick(driver, ele);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		//// Thread.sleep(7000);

		WebElement submenuEle = driver.findElement(By.xpath("//span[text()='"+submenu+"']/ancestor::a[not(contains(@class,'x-btn-disabled'))]"));
		wait.until(ExpectedConditions.visibilityOf(submenuEle));

		jsClick(driver, submenuEle);

		//// Thread.sleep(3000);

		if (innerMenu.equals("Record Audit") || innerMenu.equals("Field Audit") || innerMenu.equals("Activities")) {
			jsClick(driver, auditEle);
		}
		////jsClick(driver, auditEle);
		if (innerMenu.contains(",")) {
			String[] entitlementArr = innerMenu.split(",");
			for (String singleEntitlement : entitlementArr) {

				WebElement innerEle = driver.findElement(By.xpath("//span[text()='"+singleEntitlement+"']/ancestor::a[not(contains(@class,'x-btn-disabled'))]"));
				//wait.until(ExpectedConditions.visibilityOf(innerEle));
				if (innerEle.isDisplayed()) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
		} else {
			WebElement innerEle = driver.findElement(By.xpath("//span[text()='"+innerMenu+"']/ancestor::a[not(contains(@class,'x-btn-disabled'))]"));
			wait.until(ExpectedConditions.visibilityOf(innerEle));
			if (innerEle.isDisplayed()) {
				flag = true;
			} else {
				flag = false;

			}
		}

		if (innerMenu.equals("Data Importer")) {
			jsClick(driver, dataImportCloseEle);
		}

		return flag;
	}

	public boolean isInnerMenuEnabled(String innerMenu) {
		boolean flag = false;
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		if (innerMenu.equals("Record Audit") || innerMenu.equals("Field Audit") || innerMenu.equals("Activities")) {
			System.out.println("Audit Passed");

		}

		if (innerMenu.contains(",")) {
			String[] entitlementArr = innerMenu.split(",");
			if(auditEle.isDisplayed()) {
	             jsClick(driver,auditEle);
	             }
			else {System.out.println("audit");}
			waitSeconds(2);
			for (String singleEntitlement : entitlementArr) {

				WebElement innerEle = driver.findElement(By.xpath("//span[text()='" + singleEntitlement + "']"));
				
				wait.until(ExpectedConditions.visibilityOf(innerEle));
				//jsClick(driver, auditEle);
				if (innerEle.isDisplayed()) {
					System.out.println("passed");
				
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
		} else {
			WebElement innerEle = driver.findElement(By.xpath("//span[text()='" + innerMenu + "']"));
			wait.until(ExpectedConditions.visibilityOf(innerEle));
			if (innerEle.isDisplayed()) {
				flag = true;
			} else {
				flag = false;

			}
		}

		if (innerMenu.equals("Data Importer")) {
			jsClick(driver, dataImportCloseEle);
		}

		return flag;

	}

	public boolean navigateToBusinessUnitAndVerifyOptions(String menu, String submenu, String operation,
			String innerMenu) throws Exception {
		boolean flag = false;
		WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
		jsClick(driver, ele);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		//// Thread.sleep(7000);

		WebElement submenuEle = driver.findElement(By.xpath("//span[text()='" + submenu + "']"));
		wait.until(ExpectedConditions.visibilityOf(submenuEle));

		jsClick(driver, submenuEle);

		wait.until(ExpectedConditions.visibilityOf(selectBuinessUnitRow));
		jsClick(driver, selectBuinessUnitRow);

		jsClick(driver, driver.findElement(By.xpath("//span[text()='" + operation + "']")));

		if (innerMenu.contains(",")) {
			String[] entitlementArr = innerMenu.split(",");
			for (String singleEntitlement : entitlementArr) {

				WebElement innerEle = driver.findElement(By.xpath("//span[text()='" + singleEntitlement + "']"));
				wait.until(ExpectedConditions.visibilityOf(innerEle));
				if (innerEle.isDisplayed()) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
		} else {
			WebElement innerEle = driver.findElement(By.xpath("//span[text()='" + innerMenu + "']"));
			wait.until(ExpectedConditions.visibilityOf(innerEle));
			if (innerEle.isDisplayed()) {
				flag = true;
			} else {
				flag = false;

			}
		}

		return flag;
	}

	public boolean navigateToBusinessUnitAndVerifyOptionsUncheck(String menu, String submenu, String operation,
			String innerMenu) throws Exception {
		boolean flag = false;
		WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
		jsClick(driver, ele);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		//// Thread.sleep(7000);

		WebElement submenuEle = driver.findElement(By.xpath("//span[text()='" + submenu + "']"));
		wait.until(ExpectedConditions.visibilityOf(submenuEle));

		jsClick(driver, submenuEle);

		wait.until(ExpectedConditions.visibilityOf(selectBuinessUnitRow));
		jsClick(driver, selectBuinessUnitRow);

		jsClick(driver, driver.findElement(By.xpath("//span[text()='" + operation + "']")));

		if (innerMenu.contains(",")) {
			String[] entitlementArr = innerMenu.split(",");
			for (String singleEntitlement : entitlementArr) {

				WebElement innerEle = driver.findElement(By.xpath("//span[text()='" + singleEntitlement + "']"));
				wait.until(ExpectedConditions.invisibilityOf(innerEle));
				flag = true;
			}
		} else {
			WebElement innerEle = driver.findElement(By.xpath("//span[text()='" + innerMenu + "']"));
			wait.until(ExpectedConditions.invisibilityOf(innerEle));
			flag = true;
		}

		return flag;
	}

	public boolean VerifyUncheckSingleSubmenu(String menu, String submenu) throws Exception {
		boolean flag = false;
		try {
			WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
			jsClick(driver, ele);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			Thread.sleep(7000);

			WebElement submenuEle = driver.findElement(By.xpath("(//span[text()='" + submenu + "'])[2]"));
			wait.until(ExpectedConditions.visibilityOf(submenuEle));
			submenuEle.isDisplayed();
			flag = false;
		} catch (Exception e) {
			flag = true;
		}

		return flag;
	}

	public boolean VerifyUncheckSingleInner(String menu, String submenu, String innermenu) throws Exception {
		boolean flag = false;
		try {
			WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
			jsClick(driver, ele);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			Thread.sleep(7000);

			WebElement submenuEle = driver.findElement(By.xpath("(//span[text()='" + submenu + "'])"));
			wait.until(ExpectedConditions.visibilityOf(submenuEle));

			jsClick(driver, submenuEle);
			Thread.sleep(5000);

			WebElement innermenuEle = driver.findElement(By.xpath("//span[text()='" + innermenu + "']"));
			wait.until(ExpectedConditions.visibilityOf(submenuEle));

			innermenuEle.isDisplayed();
			flag = false;
		} catch (Exception e) {
			flag = true;
		}

		return flag;
	}

	public boolean VerifyUncheckSingleInnermenu(String menu, String submenu, String innermenu) throws Exception {
		boolean flag = false;
		try {
			WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
			jsClick(driver, ele);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			Thread.sleep(7000);

			WebElement submenuEle = driver.findElement(By.xpath("(//span[text()='" + submenu + "'])"));
			wait.until(ExpectedConditions.visibilityOf(submenuEle));

			jsClick(driver, submenuEle);
			Thread.sleep(5000);

			WebElement innermenuEle = driver.findElement(By.xpath("//span[text()='" + innermenu + "']"));
			wait.until(ExpectedConditions.visibilityOf(submenuEle));

			innermenuEle.isDisplayed();
			flag = false;
		} catch (Exception e) {
			flag = true;
		}

		return flag;
	}

	public boolean VerifyUncheckSingleSubmenuMultipleInnerMenu(String menu, String submenu, String innermenu)
			throws Exception {
		boolean flag = false;

		WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
		jsClick(driver, ele);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		// Thread.sleep(7000);

		WebElement submenuEle = driver.findElement(By.xpath("(//span[text()='" + submenu + "'])"));
		wait.until(ExpectedConditions.visibilityOf(submenuEle));

		jsClick(driver, submenuEle);
		// Thread.sleep(5000);

		String loc = "";

		if (innermenu.equals("Record Audit") || innermenu.equals("Field Audit") || innermenu.equals("Activities")) {
			jsClick(driver, auditEle);
			loc = "/../../..//div[contains(@class,'x-menu-item-disabled')]";

		} else {
			loc = "/../../../..//a[contains(@class,'x-item-disabled x-disabled x-btn-disabled')]";
		}

		if (innermenu.contains(",")) {

			String[] entitlementArr = innermenu.split(",");
			for (String singleEntitlement : entitlementArr) {
				if (singleEntitlement.equals("Record Audit") || singleEntitlement.equals("Field Audit") || singleEntitlement.equals("Activities")) {
					jsClick(driver, auditEle);	
				}

				WebElement innermenuEle = driver
						.findElement(By.xpath("//span[text()='" + singleEntitlement + "']" + loc));
				wait.until(ExpectedConditions.invisibilityOf(submenuEle));

				// innermenuEle.isDisplayed();
				flag = true;
			}

		} else {
			if (innermenu.equals("Record Audit") || innermenu.equals("Field Audit") || innermenu.equals("Activities")) {
				jsClick(driver, auditEle);	
			}

			WebElement innermenuEle = driver.findElement(By.xpath("//span[text()='" + innermenu + "']" + loc));
			wait.until(ExpectedConditions.invisibilityOf(submenuEle));

			innermenuEle.isDisplayed();
			flag = true;
		}

		return flag;
	}

	public boolean isInnerMenuDisabled(String innerMenu) {
		boolean flag=false;	
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(80));
		String loc="";
		if(innerMenu.equals("Record Audit") || innerMenu.equals("Field Audit") || innerMenu.equals("Activities") ) {
			jsClick(driver, auditEle);
			loc="/../../..//div[contains(@class,'x-menu-item-disabled')]";
			
		}else {
			loc="/../../../..//a[contains(@class,'x-item-disabled x-disabled x-btn-disabled')]";
		}
		if(innerMenu.contains(",")) {
		
			String[] entitlementArr=innerMenu.split(",");
             System.out.println(entitlementArr.length);
             if(auditEle.isDisplayed()) {
             jsClick(driver,auditEle);
            	 }
             waitSeconds(2);
			for(String singleEntitlement:entitlementArr) {
				
				
				if(!(singleEntitlement.equals("Activities"))&&!(singleEntitlement.equals("Field Audit"))&&!(singleEntitlement.equals("Record Audit"))) {
				WebElement innermenuEle=driver.findElement(By.xpath("//span[text()='"+singleEntitlement+"']"+loc));
				//wait.until(ExpectedConditions.invisibilityOf(submenuEle));
			
				if(innermenuEle.isDisplayed()) {
					System.out.println("pass1");
				flag = true;
				} 
				else {
					flag=false;
				}
				
			}else {
				WebElement innermenuEle=driver.findElement(By.xpath("//span[text()='"+singleEntitlement+"']/../../..//div[contains(@class,'x-menu-item-disabled')]"));
				//wait.until(ExpectedConditions.invisibilityOf(submenuEle));
			   jsClick(driver, auditEle);
				if(innermenuEle.isDisplayed()) {
					
					System.out.println("pass2");
				flag = true;
				} 
				else {
					flag=false;
				}
				
			} }}
		
			
		else {

			WebElement innermenuEle=driver.findElement(By.xpath("//span[text()='"+innerMenu+"']"+loc));
			//wait.until(ExpectedConditions.invisibilityOf(submenuEle));
		
			if(innermenuEle.isDisplayed()) {
			flag = true; 
			}
		}
			
return flag;
		}

	public boolean navigateMenuAndVerifyMultipleSubmenu(String menu, String submenu) throws Exception {
		boolean flag = false;
		WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
		jsClick(driver, ele);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		Thread.sleep(7000);
		String[] entitlementArr = submenu.split(",");
		for (String singleEntitlement : entitlementArr) {
			WebElement submenuEle = driver.findElement(By.xpath("(//span[text()='" + singleEntitlement + "'])[2]"));
			wait.until(ExpectedConditions.visibilityOf(submenuEle));
			if (submenuEle.isDisplayed()) {
				flag = true;
			} else {
				flag = false;
				break;
			}

		}
		return flag;
	}

	public boolean navigateMenuAndVerifyMultipleSubmenuNotPresent(String menu, String submenu) throws Exception {
		boolean flag = false;
		try {
			WebElement ele = driver.findElement(By.xpath("//span[text()='" + menu + "']"));
			jsClick(driver, ele);
			WebDriverWait wait = new WebDriverWait(driver, 40);
			Thread.sleep(7000);

			String[] entitlementArr = submenu.split(",");
			for (String singleEntitlement : entitlementArr) {
				WebElement submenuEle = driver.findElement(By.xpath("(//span[text()='" + singleEntitlement + "'])[2]"));
				wait.until(ExpectedConditions.visibilityOf(submenuEle));
				submenuEle.isDisplayed();
				flag = false;
			}

		} catch (Exception e) {
			flag = true;
		}

		return flag;
	}

	public void hoverElementToSelectOption(String menuName, String subMenu, String subMenuWithOption) {
		String opt0 = "//Span[text()='Option']".replace("Option", menuName);
		System.out.print(opt0);
		WebElement ElementOption = driver.findElement(By.xpath(opt0));
		clickElement(driver, ElementOption);

		String opt1 = "//Span[text()='Option']".replace("Option", subMenu);
		System.out.print(opt1);
		WebElement hoverElement = driver.findElement(By.xpath(opt1));
		moveToElement(driver, hoverElement);
		String opt2 = "//Span[text()='Option']".replace("Option", subMenuWithOption);
		waitSeconds(5);
		System.out.print(opt2);
		WebElement hoverElementOption = driver.findElement(By.xpath(opt2));
		clickElement(driver, hoverElementOption);

	}

	public void selectStatus(String status) {
		String selectStatus = "";
	}

	public void clickSearchAndRow() {
		waitSeconds(10);
		clickElement(driver, searchBtn);
		waitSeconds(10);
		mouseDoubleClick(driver, tableRow);
		waitSeconds(10);
	}
	
	public void clickManagerExclusionListSearchAndRow() {
		waitSeconds(10);
		clickElement(driver, searchBtn);
		waitSeconds(10);
		mouseDoubleClick(driver, exclusionManagerTableRow);
		waitSeconds(10);
	}
	
	public void clickCostCenterSearchAndRow() {
		waitSeconds(10);
		clickElement(driver, searchBtn);
		waitSeconds(5);
		mouseDoubleClick(driver,CostCenterTableRow);
		waitSeconds(10);
	}
	
	public void clickRelationShipManagerSearchAndRow(){
		waitSeconds(10);
		clickElement(driver, searchBtn);
		waitSeconds(5);
		mouseDoubleClick(driver,relationShipManagerTableRow);
		waitSeconds(10);
	}
	
	public void clickCurrencySearchAndRow(){
		waitSeconds(10);
		clickElement(driver, searchBtn);
		waitSeconds(5);
		mouseDoubleClick(driver,currencyTableRow);
		waitSeconds(10);
	}
	
	public void clickCurrencyPairSearchAndRow(){
		waitSeconds(10);
		clickElement(driver, searchBtn);
		waitSeconds(5);
		mouseDoubleClick(driver,currencyPairTableRow);
		waitSeconds(10);
	}


	public boolean isSaveBtnDisabled() {
		boolean flag = false;
		String loc = "/../../../..//a[contains(@class,'x-item-disabled x-disabled x-btn-disabled')]";
		WebElement innermenuEle = driver.findElement(By.xpath("//span[text()='Save']" + loc));
		// wait.until(ExpectedConditions.invisibilityOf(submenuEle));
        waitSeconds(5);
		if (innermenuEle.isDisplayed()) {
			flag = true;
		} else {
			flag = false;
		}
		jsClick(driver, closeImg);
		waitSeconds(2);
		return flag;
	}

	public boolean isSaveBtnEnabled() {
		boolean flag = false;
		//String loc="/../../../..//a[contains(@class,'x-item-disabled x-disabled
		// x-btn-disabled')]";
		WebElement innermenuEle = driver.findElement(By.xpath("//span[text()='Save']/ancestor::a[not(contains(@class,'x-btn-disabled'))]"));
		// wait.until(ExpectedConditions.invisibilityOf(submenuEle));
        waitSeconds(5);
		if (innermenuEle.isDisplayed()) {
			flag = true;
		} else {
			flag = false;
		}
		jsClick(driver, closeImg);
		waitSeconds(2);
		return flag;
	}

	public void ClickMainMenuAndSubMenu(String mainMenu, String subMenu) {
		WebElement ele = driver.findElement(By.xpath("//span[text()='" + mainMenu + "']"));
		jsClick(driver, ele);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		//// Thread.sleep(7000);

		WebElement submenuEle = driver.findElement(By.xpath("//span[text()='" + subMenu + "']"));
		wait.until(ExpectedConditions.visibilityOf(submenuEle));

		jsClick(driver, submenuEle);
	}



	public void clickAddOrNewBtn(String mutipleOption) {
		 List<String> option = Arrays.asList(mutipleOption.split(","));
		for(String opt:option) {
			System.out.println(opt);
		if(opt.equals("Add") || opt.equals("New")) {
			 WebElement add=driver.findElement(By.xpath("//span[text()='"+opt+"']//ancestor::a[@role='button']"));
			 
			 //waitSeconds(20);
				jsClick(driver,add);	
				System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		
	}}

}

//endregion : Page Objects
