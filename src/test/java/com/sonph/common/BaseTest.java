package com.sonph.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    public static WebDriver driver;
    public ClassLoader classLoader;

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void createDriver(@Optional("chrome") String browser) {
        switch (browser.trim().toLowerCase()) {
            case "chrome":
                System.out.println("Lauching Chrome browser...");
                driver = new ChromeDriver(setupChromeOption());
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
                driver = new ChromeDriver(setupChromeOption());
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        classLoader = getClass().getClassLoader();
    }

    @AfterMethod
    public void closeDriver() {
        if(driver != null){
            driver.quit();
        }
    }

    public ChromeOptions setupChromeOption(){
        ChromeOptions options = new ChromeOptions();

        // Thêm arguments cơ bản cho automation
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-web-security");
        options.addArguments("--no-proxy-server");

        // Disable popup Save Password/Address – KHÔNG CẦN THIẾT NHẤT!
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);  // Tắt credentials (save address/password)
        prefs.put("profile.password_manager_enabled", false);  // Tắt password manager

        // TẮT AUTOFILL ADDRESS – QUAN TRỌNG NHẤT!
        prefs.put("autofill.profile_enabled", false);                   // Tắt Autofill cho địa chỉ
        prefs.put("autofill.credit_card_enabled", false);


        options.setExperimentalOption("prefs", prefs);
        return options;
    }

}
