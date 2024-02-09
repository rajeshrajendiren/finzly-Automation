package com.fxoffice.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fxoffice.ui.pages.HomePage;
import com.fxoffice.ui.pages.LoginPage;
import com.fxoffice.ui.pages.WebDriverManager1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	public WebDriver driver = getDriver();
	public LoginPage loginPage;
	public HomePage homePage;

	public WebDriver getDriver() {
		return WebDriverManager1.driver;
	}

	@Given("I Launch FXOffice Application in Browser")
	public void launch_ApplicationURLInBrowser() throws Throwable {
		loginPage = new LoginPage(driver); 
		loginPage.launchApplicationURL(); 
	}

	@Then("I Verify Login Page Loaded Successfully")
	public void verify_LoginPage() throws Throwable {
		loginPage = new LoginPage(driver);
		boolean result = loginPage.verifyLoginPage();
		Assert.assertTrue("Problem in Loading FXOffice Application Login Page.", result);
	}

	@When("I Enter Credentials in Login Page")
    public void set_Credentials() throws Exception {
    	loginPage = new LoginPage(driver);
        loginPage.setCredentials();
        loginPage.clickLoginBtn();
    }
	
	@When("I Enter Approver Credentials in Login Page")
    public void set_ApproverCredentials() throws Exception { 
    	loginPage = new LoginPage(driver);
    	loginPage.setApproverCredentials();
        loginPage.clickLoginBtn();
    }
	
	@When("I Enter Approver Credentials in Login Page {string} {string}") 
    public void set_ApproverCredentials1(String userId,String password) throws Exception {
		//Thread.sleep(7000);
		loginPage = new LoginPage(driver);
		loginPage.launchApplicationURL();
		//driver.findElement(By.id("lf.btn.reset-btnInnerEl")).click();
		Thread.sleep(3000);
		loginPage.jsClick(driver,driver.findElement(By.id("lf.btn.reset-btnInnerEl")));
		//Thread.sleep(7000);
		
		//driver.navigate().refresh();
		
		 WebElement element = driver.findElement(By.xpath("//label[text()='User Id:']/../..//input"));
		    element.clear();
		    //Thread.sleep(1000);

		    String val=userId;
		    for (int i = 0; i < val.length(); i++){
		    	//Thread.sleep(i);
		    	System.out.println("===>"+i);
		        char c = val.charAt(i);
		        System.out.println("===>"+c);
		        String s = new StringBuilder().append(c).toString();
		        
		        //Thread.sleep(1000);
		        if( i==0) {
		        	String value_entered=element.getAttribute("value");
		        	System.out.println("===value_entered>"+value_entered);
		        	System.out.println("===value_entered>"+s);
		        	//if(!value_entered.equals("f")) {
		        	//	s="f";
		        	//}
		        }
		        element.sendKeys(s);
		        String value_entered=element.getAttribute("value");
		        if(value_entered.equals("")) {
		        	element.sendKeys(s);
		        }
	        	System.out.println("===value_entered>"+value_entered);
	        	System.out.println("===value_entered>"+s);
	        	
		    }      
		
	//	driver.findElement(By.name("j_username")).sendKeys("flevia2");
		
		System.out.println("password");
	//	driver.findElement(By.name("j_password")).clear();
	//	driver.findElement(By.name("j_password")).sendKeys("Finzly@123");
		
		String val1=password;
		 WebElement element1 = driver.findElement(By.xpath("//label[text()='Password:']/../..//input"));
		    element1.clear();

		    for (int i = 0; i < val1.length(); i++){
		    	//Thread.sleep(i);
		        char c = val1.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        //Thread.sleep(1000);
		        element1.sendKeys(s);
		    }   
		
		//loginPage.clickLoginBtn();
		System.out.println("111isDisplayed11");
		
		loginPage.clickLoginBtn();
		/*
		 * try { if(driver.findElement(By.xpath("//div[text()='Password is empty']")).
		 * isDisplayed() ||
		 * driver.findElement(By.xpath("//*[text()='Bad credentials']")).isDisplayed() )
		 * { System.out.println("111isDisplayed11");
		 * loginPage.jsClick(driver,driver.findElement(By.xpath("//span[text()='OK']")))
		 * ; //Thread.sleep(2000);
		 * loginPage.jsClick(driver,driver.findElement(By.id("lf.btn.reset-btnInnerEl"))
		 * ); // driver.findElement(By.name("j_username")).clear();
		 * System.out.println("username"); String val11="flevia2"; WebElement element11
		 * = driver.findElement(By.xpath("//label[text()='User Id:']/../..//input"));
		 * element.clear();
		 * 
		 * for (int i = 0; i < val11.length(); i++){ char c = val11.charAt(i); String s
		 * = new StringBuilder().append(c).toString(); Thread.sleep(1000);
		 * element11.sendKeys(s); }
		 * 
		 * // driver.findElement(By.name("j_username")).sendKeys("flevia2");
		 * 
		 * System.out.println("password"); //
		 * driver.findElement(By.name("j_password")).clear(); //
		 * driver.findElement(By.name("j_password")).sendKeys("Finzly@123");
		 * 
		 * String val12="Finzly@123"; WebElement element12 =
		 * driver.findElement(By.xpath("//label[text()='Password:']/../..//input"));
		 * element12.clear();
		 * 
		 * for (int i = 0; i < val12.length(); i++){ char c = val12.charAt(i); String s
		 * = new StringBuilder().append(c).toString(); Thread.sleep(1000);
		 * element12.sendKeys(s); }
		 * 
		 * loginPage.clickLoginBtn(); System.out.println("111isDisplayed11"); }
		 * }catch(Exception e) {}
		 */
		homePage = new HomePage(driver);
		boolean result = homePage.verifyHomePage();
		Assert.assertTrue("Problem in Loading Application Home Page.", result);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		Thread.sleep(5000);
		
			//WebElement submenuEle=driver.findElement(By.xpath("//div[@id='Dashboard-innerCt']//span[text()='Confirmations']"));
		//	wait.until(ExpectedConditions.visibilityOf(submenuEle));
			
		
   }

	@When("I Click On Login Button; in Login Page")
    public void click_LoginButton() throws Exception {
    	loginPage = new LoginPage(driver);
    	loginPage.clickLoginBtn();
    }

	@Given("I login to the FXoffice with valid credentials")
	public void launchApplicationAndLoginWithUser() throws Throwable { 
		loginPage = new LoginPage(driver);
		loginPage.launchApplicationURL(); 
		//loginPage.verifyLoginPage();
		loginPage.setCredentials();
        loginPage.clickLoginBtn();
		homePage = new HomePage(driver);
		boolean result = homePage.verifyHomePage();
		Assert.assertTrue("Problem in Loading Application Home Page.", result);
	} 

	@Given("I login to the FXoffice with valid credentials {string} {string}")
	public void launchApplicationWithValidCredential(String username,String pass) throws Throwable {
		loginPage = new LoginPage(driver);
		loginPage.launchApplicationURL(); 
		//loginPage.verifyLoginPage();
		loginPage.setCredentialswithUserAndPass(username,pass);
        loginPage.clickLoginBtn();
		homePage = new HomePage(driver);
		boolean result = homePage.verifyHomePage();
		Assert.assertTrue("Problem in Loading Application Home Page.", result);
	} 
	@And("I Enter Credentials in Login Page {string} {string} for other env")
    public void enterCredentials(String userId,String password) throws Exception {
		loginPage = new LoginPage(driver);
		loginPage.jsClick(driver,driver.findElement(By.id("lf.btn.reset-btnInnerEl")));
	    WebElement element = driver.findElement(By.xpath("//label[text()='User Id:']/../..//input"));
		    element.clear();
		   
		    String val=userId;
		    for (int i = 0; i < val.length(); i++){
		    	
		    	
		        char c = val.charAt(i);
		       
		        String s = new StringBuilder().append(c).toString();
		         
		        if( i==0) {
		        	String value_entered=element.getAttribute("value");
		    }
		        element.sendKeys(s);
		        String value_entered=element.getAttribute("value");
		        if(value_entered.equals("")) {
		        	element.sendKeys(s);
		        }
	        	System.out.println("===value_entered>"+value_entered);
	        	System.out.println("===value_entered>"+s);
		    }      
		
		System.out.println("password");
		
		String val1=password;
		 WebElement element1 = driver.findElement(By.xpath("//label[text()='Password:']/../..//input"));
		    element1.clear();
 
		    for (int i = 0; i < val1.length(); i++){
		   
		        char c = val1.charAt(i);
		        String s = new StringBuilder().append(c).toString();
		        element1.sendKeys(s);
		    }   
		System.out.println("111isDisplayed11");
		
		loginPage.clickLoginBtn();
		
		homePage = new HomePage(driver);
		boolean result = homePage.verifyHomePage();
		Assert.assertTrue("Problem in Loading Application Home Page.", result);
		
		WebDriverWait wait = new WebDriverWait(driver,40);
		Thread.sleep(5000);
		
		
		
   }
	@And("I Enter Credentials in Login Page {string} {string} for Boss Portal")
    public void enterCredentialsInBoss(String userId,String password) throws Exception {
		loginPage = new LoginPage(driver);
	    loginPage.setCredentialswithUserAndPass(userId, password);
	    loginPage.clickBossLoginBtn();
		
		
		
   }
	@Given("I navigate to the Boss Portal login page")
	public void launchBossApplicationAndLoginWithUser() throws Throwable {
		loginPage = new LoginPage(driver);
		loginPage.launchApplicationURL();  
		
		  loginPage.setCredentials();
		  loginPage.clickBossLoginBtn();
		  homePage = new HomePage(driver);
		  boolean result = homePage.verifyBossHomePage();
		  Assert.assertTrue("Problem in Loading Application Home Page.", result);
		
	}

}


