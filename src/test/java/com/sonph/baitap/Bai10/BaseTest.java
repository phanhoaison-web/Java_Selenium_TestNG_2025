package com.sonph.baitap.Bai10;

import com.sonph.common.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest{
    public WebDriver driver;

    @BeforeSuite
    @Parameters(value = {"browser","url"})
    public void createDriver(@Optional("chrome") String browser, String url){
        switch (browser.trim().toLowerCase()) {
            case "chrome":
                System.out.println("Lauching Chrome browser...");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("Lauching FireFox browser...");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.out.println("Lauching Edge browser...");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Browser: " + browser + " is invalid, Launching Chrome as browser of choice...");
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @BeforeTest
    @Parameters(value = {"email","password"})
    public void login(String email, String password) throws InterruptedException {
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).isDisplayed(), true);
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys(email);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys(password);
        driver.findElement(By.xpath(LocatorsCRM.btnLogin)).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.verifyDashboardOption)).isDisplayed(), true);
    }

    @AfterTest
    public void closeDriver(){
        if (driver != null){
            driver.quit();
            System.out.println("Closing Driver...");
        }
    }

}
