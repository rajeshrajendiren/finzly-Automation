package com.fxboss.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BossLoginPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(BossLoginPage.class);
    private final WebDriverWait driverWait;
    private final WebDriver driver;

    @FindBy(id = "password")
    private WebElement passWord;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginBtn;

    public BossLoginPage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance cannot be null");
        }
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
        LOGGER.info("On Login Page of BossPortal");
    }

    public void launchApplicationURL(String url) {
        driver.get(url);
    }

    public void setCredentials(String username, String password) {
        setUserName(username);
        setPassword(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    private void setUserName(String userName) {
        LOGGER.info("Enter Username: " + userName);
        username.sendKeys(userName);
    }

    private void setPassword(String password) {
        LOGGER.info("Enter Password: " + password);
        passWord.sendKeys(password);
    }

    public boolean isLoginPageLoaded() {
        try {
            return driverWait.until(ExpectedConditions.visibilityOf(loginBtn)).isDisplayed();
        } catch (Exception e) {
            LOGGER.error("Login Page not loaded: " + e.getMessage());
            return false;
        }
    }
}
