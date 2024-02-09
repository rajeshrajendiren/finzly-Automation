package com.fxoffice.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		/* Specify exact filename like below if need to execute selected feature */
		features = {"src/test/resources/features"},
        glue = {"com.fxoffice.stepDefinitions"},
       plugin = {"pretty", "html:target/cucumber-reports.html","json:target/cucumber.json"},
       		                                                      
        //plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
       tags="@UI and @Regression and @StaticData and @Holiday and @Case1 and @Test",
	monochrome = true,dryRun = false
) 
    
public class UITestRunner extends AbstractTestNGCucumberTests {                  
	   
}

