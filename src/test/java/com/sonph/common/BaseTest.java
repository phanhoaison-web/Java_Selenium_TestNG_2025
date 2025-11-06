package com.sonph.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    @Parameters(value = {"browser"})
    public static void createDriver(@Optional("chrome") String browser) {
        switch (browser.trim().toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                System.out.println("Lauching Chrome browser...");
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                System.out.println("Lauching FireFox browser...");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.out.println("Lauching Edge browser...");
                WebDriverManager.edgedriver().setup(); //
                driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                System.out.println("Browser: " + browser + " is invalid, Launching Chrome as browser of choice...");
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public static void closeDriver() {
        if(driver != null){
            driver.quit();
        }
    }

}
