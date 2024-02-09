package com.fxoffice.ui.pages;

import java.io.InputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fxoffice.utility.ParameterService;

public class LoginPage extends AbstractPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
	protected WebDriverWait driverWait;
	private WebDriver driver;
	private static String envType = null;
	public WebDriverManager1 webDriverManager;

	// Selectors  

	/*
	 * @FindBy(how = How.NAME, using = "j_username") private WebElement txtUsername;
	 * 
	 * @FindBy(how = How.NAME, using = "j_password") private WebElement txtPassword;
	 */

	@FindBy(how = How.XPATH, using = "//input[contains(@name,'username')]")
	private WebElement txtUsername;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@name,'password')]")
	private WebElement txtPassword;
	
	@FindBy(how = How.XPATH, using = "//span[contains(@id,'btn.login')][text()='Login']")
	private WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Log In']")
	private WebElement btnBossLogin;
	

	// endregion : Selectors
	
	// Constructor

	public LoginPage(WebDriver driver) {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		this.driver = driver;
		PageFactory.initElements(driver, this);
		LOGGER.info("On Login Page of FXOffice");
	}

	// Page Objects

	private void setUserName(String userName) {
		LOGGER.info("Enter Username :" + userName);
		enterText(driver, txtUsername, userName);	
	}

	private void setPassword(String password) {
		LOGGER.info("Enter Password :" + password);
		enterText(driver, txtPassword, password);	
	}

	public void clickLoginBtn() throws Exception {
		LOGGER.info("Clicking Login Button"); 
		Thread.sleep(3000);
		jsClick(driver, btnLogin);
	    waitForPageLoad(driver);
		
	}
	public void clickBossLoginBtn() throws Exception {
		LOGGER.info("Clicking Boss Login Button");
		Thread.sleep(3000);
		jsClick(driver, btnBossLogin);
	    waitForPageLoad(driver);
		
	}
	
	// endregion : Page Objects

	// Methods
	public boolean verifyLoginPage() throws InterruptedException { 
		LOGGER.info("Checking for Login Page to load successfully");
		boolean needToRetry = true;
		int i=0;
		waitForPageLoad(driver);
		while(needToRetry && i<=5) {
			try
			{
				driverWait.until(ExpectedConditions.visibilityOf(btnLogin));
				LOGGER.info("Login Page loaded successfully....!!!! ");
				return true;
			}
			catch (Exception e)
			{
				LOGGER.info("Login Page load OR Checking element visibility is/are failed. Waiting and trying again.");
				waitSeconds(5);
			}
			
			i++;
		}
		return needToRetry;
	}

	public void launchApplicationURL() {
		try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("UIEnvironmentConfigProperties.json")){
    		
			String url = null;
    	    ObjectMapper mapper = new ObjectMapper();
    	    JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
    	    String jsonString = mapper.writeValueAsString(jsonNode);

    	    JSONParser parser = new JSONParser();
    	    JSONObject json = (JSONObject) parser.parse(jsonString);
    	    
    	    String executionEnvironment = ParameterService.getParameter("Environment");
    	    LOGGER.info("Execution Environment : " + executionEnvironment);
    	    Set<?> keys = json.keySet();
    	    Iterator<?> envType = keys.iterator(); 
	    
    	    while(envType.hasNext()) {
    	        String envName = envType.next().toString();
    	        if(envName.equals(executionEnvironment)) {
    	        	   JSONObject environment = (JSONObject) json.get(envName);
    	        	   Set<?> jsonEnvironmentObjectKeys = environment.keySet();
    		    	   Iterator<?> envParametersIterator = jsonEnvironmentObjectKeys.iterator();
    		    	   while(envParametersIterator.hasNext()) {
    		    	        String envParameterKeyName = envParametersIterator.next().toString();
    		    	        if(envParameterKeyName.equals("URL")) {
    		    	        	url = (String) environment.get(envParameterKeyName);
    		    	        	LOGGER.info("URL : " + url);
    		    	        	break;
    		    	        }
    		    	   }
    		    	   break;
    	        }
    	    }
    		driver.get(url);
    		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(180));
    		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(180));
		} catch (Exception e) {
			LOGGER.info("Exception thrown..");
			e.printStackTrace();
		}
	}
	public void launchApplication(String url) {
		driver.get(url);
	}
	
	public void before() throws Throwable {
		LOGGER.info("This will run before each UI Test Scenario");
		ParameterService.clearParameters();
		envType = "Test2";
		LOGGER.info("Source Tag Name : " + envType);
		ParameterService.setParameter("Environment", envType);
		String browserName = "chrome";
		LOGGER.info("Browser Name for execution : " + browserName);
		webDriverManager = new WebDriverManager1();
		driver = webDriverManager.getDriver(browserName);
	}


	public void setCredentials() {
		try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("UIEnvironmentConfigProperties.json")){
    		/* Pass InputStream to JSON-Library i.e., using Jackson */
			String username = null, password = null; 
    	    ObjectMapper mapper = new ObjectMapper();
    	    JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
    	    String jsonString = mapper.writeValueAsString(jsonNode);

    	    JSONParser parser = new JSONParser();
    	    JSONObject json = (JSONObject) parser.parse(jsonString);
    	    
    	    String executionEnvironment = ParameterService.getParameter("Environment");
    	    Set<?> keys = json.keySet();
    	    Iterator<?> envType = keys.iterator();
	    
    	    while(envType.hasNext()) {
    	        String envName = envType.next().toString();
    	        if(envName.equals(executionEnvironment)) {
    	        	   JSONObject environment = (JSONObject) json.get(envName);
    	        	   username = (String) environment.get("username");
    	        	   password = (String) environment.get("password");
    		    	   break;
    	        }
    	    }
    	    setUserName(username);
    	    setPassword(password);
		} catch (Exception e) {
			LOGGER.info("Exception thrown..");
			e.printStackTrace();
		} 
	}
	public void setCredentialswithUserAndPass(String username,String pass) {
		setUserName(username);
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    setPassword(pass);
	}
		public void setApproverCredentials() {
			try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("UIEnvironmentConfigProperties.json")){
	    		
				String username = null, password = null;
	    	    ObjectMapper mapper = new ObjectMapper();
	    	    JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
	    	    String jsonString = mapper.writeValueAsString(jsonNode);

	    	    JSONParser parser = new JSONParser();
	    	    JSONObject json = (JSONObject) parser.parse(jsonString);
	    	    
	    	    String executionEnvironment = ParameterService.getParameter("Environment");
	    	    //String executionEnvironment = "QA3";
	    	    Set<?> keys = json.keySet();
	    	    Iterator<?> envType = keys.iterator();
		    
	    	    while(envType.hasNext()) {
	    	        String envName = envType.next().toString();
	    	        if(envName.equals(executionEnvironment)) {
	    	        	   JSONObject environment = (JSONObject) json.get(envName);
	    	        	   username = (String) environment.get("approverusername");
	    	        	   password = (String) environment.get("approverpassword");
	    		    	   break;
	    	        }
	    	    }
	    	  
	    	    setUserName(username);
	    	    setPassword(password);
			} catch (Exception e) {
				LOGGER.info("Exception thrown..");
				e.printStackTrace();
			}
		}
		
		public String setApproverCredentialsFromJson() {
			String username = null, password = null;
			try(InputStream in=Thread.currentThread().getContextClassLoader().getResourceAsStream("UIEnvironmentConfigProperties.json")){
	    		/* Pass InputStream to JSON-Library i.e., using Jackson */
				
	    	    ObjectMapper mapper = new ObjectMapper();
	    	    JsonNode jsonNode = mapper.readValue(in, JsonNode.class);
	    	    String jsonString = mapper.writeValueAsString(jsonNode);

	    	    JSONParser parser = new JSONParser();
	    	    JSONObject json = (JSONObject) parser.parse(jsonString);
	    	    
	    	    String executionEnvironment = ParameterService.getParameter("Environment");
	    	    //String executionEnvironment = "QA3";
	    	    Set<?> keys = json.keySet();
	    	    Iterator<?> envType = keys.iterator();
		    
	    	    while(envType.hasNext()) {
	    	        String envName = envType.next().toString();
	    	        if(envName.equals(executionEnvironment)) {
	    	        	   JSONObject environment = (JSONObject) json.get(envName);
	    	        	   username = (String) environment.get("approverusername");
	    	        	   password = (String) environment.get("approverpassword");
	    		    	   break;
	    	        }
	    	    }
	    	   
	    	   
	    	   
			} catch (Exception e) {
				LOGGER.info("Exception thrown..");
				e.printStackTrace();
			}
			return username+","+password;
		}
		
}

	
	

	// endregion : Methods


