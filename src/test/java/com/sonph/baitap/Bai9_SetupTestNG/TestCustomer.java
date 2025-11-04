package com.sonph.baitap.Bai9_SetupTestNG;

import com.sonph.common.LocatorsCRM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestCustomer {

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
        driver.get(LocatorsCRM.URL);
    }

    @AfterMethod
    public void closeDriver() {
        if(driver != null){
            driver.quit();
            System.out.println("Closing Driver...");
        }
    }

    @Parameters(value = {"cusName"})
    @Test(priority = 2)
    public void addNewCustomer(String cusName) throws InterruptedException {
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).isDisplayed(), true);
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys(LocatorsCRM.EMAIL);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys(LocatorsCRM.PASSWORD);
        driver.findElement(By.xpath(LocatorsCRM.btnLogin)).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.verifyDashboardOption)).isDisplayed(), true);

        driver.findElement(By.xpath(LocatorsCRM.menuCustomer)).click();
        int totalCustomer = Integer.parseInt( driver.findElement(By.xpath(LocatorsCRM.totalCustomers)).getText());
        System.out.println("Total Customer : " + totalCustomer);
        driver.findElement(By.xpath(LocatorsCRM.addNewCustomer)).click();

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String date= localDateTime.format(formatter);
        String customerName = cusName + " " + date;

        driver.findElement(By.xpath(LocatorsCRM.inputCompanyC)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputCompanyC)).sendKeys(customerName);
        driver.findElement(By.xpath(LocatorsCRM.inputVATC)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputVATC)).sendKeys("10");
        driver.findElement(By.xpath(LocatorsCRM.inputPhoneC)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPhoneC)).sendKeys("0987654123");
        driver.findElement(By.xpath(LocatorsCRM.inputWebsiteC)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputWebsiteC)).sendKeys("https://tester.com");


        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroups)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroups)).sendKeys("Group Maison", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();


        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys("USD", Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchOption("German"))).click();

        driver.findElement(By.xpath(LocatorsCRM.inputAddresC)).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputAddresC)).sendKeys("Hoàng Liệt");

        driver.findElement(By.xpath(LocatorsCRM.inputCityC)).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputCityC)).sendKeys("Hà Nội");

        driver.findElement(By.xpath(LocatorsCRM.inputStateC)).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputStateC)).sendKeys("Hà Nội");

        driver.findElement(By.xpath(LocatorsCRM.inputZipcode)).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputZipcode)).sendKeys("100000");


        driver.findElement(By.xpath(LocatorsCRM.dropdownCountryC)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountryC)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountryC)).sendKeys("China", Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.btnSaveCustomer)).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath(LocatorsCRM.menuCustomer)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCustomer)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCustomer)).sendKeys(customerName);
        Thread.sleep(2000);

        int totalCustomerAfterAddNew = Integer.parseInt( driver.findElement(By.xpath(LocatorsCRM.totalCustomers)).getText());
        System.out.println("Total Customer after add new : " + totalCustomerAfterAddNew);
        Assert.assertEquals(totalCustomerAfterAddNew, totalCustomer + 1,"Customer total is correct!");

        String comapyNameAddNew = driver.findElement(By.xpath(LocatorsCRM.firstRowCustomerTable)).getText();
        Assert.assertEquals(comapyNameAddNew, customerName,"ustomer new is correct!");
    }


}
