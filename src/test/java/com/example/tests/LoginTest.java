package com.example.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
    private WebDriver driver;
    private String baseUrl;
    
    @Parameters({"environment"})
    @BeforeMethod
    public void setUp(String environment) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        
        // Get base URL based on environment
        if ("dev11".equals(environment)) {
            baseUrl = "https://dev11.example.com";
        } else if ("qa".equals(environment)) {
            baseUrl = "https://qa.example.com";
        } else {
            baseUrl = "https://example.com";
        }
        
        driver.manage().window().maximize();
    }
    
    @Test
    public void testSuccessfulLogin() {
        driver.get(baseUrl + "/login");
        // Add your test steps here
        Assert.assertTrue(true, "Login test passed");
    }
    
    @Test
    public void testInvalidLogin() {
        driver.get(baseUrl + "/login");
        // Add your test steps here
        Assert.assertTrue(true, "Invalid login test passed");
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}