package com.fxoffice.stepDefinitions;

import java.awt.AWTException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.fxoffice.ui.pages.RelationshipManagerPage;
import com.fxoffice.ui.pages.EntitlementsPage;
import com.fxoffice.ui.pages.EntityManagerPage;
import com.fxoffice.ui.pages.HomePage;
import com.fxoffice.ui.pages.WebDriverManager1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DummySteps {
	
	public WebDriver driver = getDriver();
	public EntitlementsPage entitlementsPage;
	public EntityManagerPage entityManagerPage;
	
	public WebDriver getDriver() {
		return WebDriverManager1.driver;
	}
    @And("xx")
	public void click_EntitlementsButton() throws Exception {
    	System.out.println("1111");
	}
    
    @And("yy")
   	public void click_EntitlementsButtonRightToLeft() throws Exception {
    	System.out.println("222222");
   	}
     
    @And("zz")
	public void click_Entitlements_for_contact() throws Exception {
    	System.out.println("3333333");
	}
    
	 
}
	
	