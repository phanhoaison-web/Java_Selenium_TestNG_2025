package com.sonph.baitap.Bai9_SetupTestNG;

import com.sonph.common.LocatorsCRM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestLogin {


    public WebDriver driver;

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void createDriver(@Optional("chrome") String browser) {
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
    public void closeDriver() {
        if(driver != null){
            driver.quit();
            System.out.println("Closing Driver...");
        }
    }

    @Parameters(value = {"email","password","url"})
    @Test(priority = 1)
    public void testLogin(String email, String password, String url) throws InterruptedException {
        driver.get(url);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).isDisplayed(), true);
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys(email);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys(password);
        driver.findElement(By.xpath(LocatorsCRM.btnLogin)).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.verifyDashboardOption)).isDisplayed(), true);
    }
}
