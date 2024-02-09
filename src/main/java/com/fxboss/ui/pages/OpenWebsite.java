package com.fxboss.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenWebsite {
    public static void main(String[] args) {
        // Specify the path to the ChromeDriver executable (update it according to your system)
        System.setProperty("webdriver.chrome.driver", "C:\\\\FXTestAutomation\\\\src\\\\main\\\\resources\\\\drivers\\\\OS_Windows\\\\chromedriver.exe");

        // Create a new instance of the Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the desired website URL
        String websiteUrl = "https://keycloak-poc.finzly.net/auth/realms/FXSTAR.UAT1.FINZLY.BOSS/protocol/openid-connect/auth?response_type=code&client_id=finzly.fxweb&redirect_uri=https%3A%2F%2Fuat1.swapstech.net%2Ffxweb%2Fsso%2Flogin?bank_identifier%3Dnull&state=c23806a4-c989-40ac-ad96-948a0e98efae&login=true&scope=openid";
        driver.get(websiteUrl);

        // Perform any further actions on the website as needed

        // Close the browser window
        driver.quit();
    }
}
