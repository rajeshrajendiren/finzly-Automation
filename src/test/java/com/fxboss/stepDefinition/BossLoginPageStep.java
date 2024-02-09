package com.fxboss.stepDefinition;

import com.fxboss.ui.pages.BossLoginPage;
import com.fxoffice.ui.pages.WebDriverManager1;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BossLoginPageStep {
	public WebDriver driver;
    private final BossLoginPage bossLoginPage;
    //private final WebDriverManager1 webDriverManager1;

    public BossLoginPageStep() {
        this.driver=getDriver();
        this.bossLoginPage = new BossLoginPage(driver);
    }
    public WebDriver getDriver() {
    	System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/OS_Windows/chromedriver.exe");

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        return driver;
	}

    @Given("I navigate to the Boss Portal login page")
    public void navigateToLoginPage() {
        bossLoginPage.launchApplicationURL("https://keycloak-poc.finzly.net/auth/realms/FXSTAR.UAT1.FINZLY.BOSS/protocol/openid-connect/auth?client_id=finzly.bossPortal.UI&redirect_uri=https%3A%2F%2Fuat1.swapstech.net%2FbossPortal%2Fhome%23!%2Fhome%2Fdashboard%2F&state=267db240-3ef3-493f-83c8-863ec8ec43dd&response_mode=fragment&response_type=code&scope=openid&nonce=48dc4bd5-bb2f-49e6-bfdd-5f70acfff26c");
        assertTrue("Login page is not loaded", bossLoginPage.isLoginPageLoaded());
    }

    @When("I login to the Boss Portal with valid credentials {string} and {string}")
    public void loginWithValidCredentials(String username, String password) {
        bossLoginPage.setCredentials(username, password);
        bossLoginPage.clickLoginButton();
    }

    @Then("I should be logged in successfully")
    public void verifyLoginSuccess() {
        // Add verification logic based on your application behavior
        // For example, check for a dashboard page or a welcome message
    }
}
