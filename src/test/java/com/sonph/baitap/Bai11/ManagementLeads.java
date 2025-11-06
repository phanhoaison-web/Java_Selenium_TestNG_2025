package com.sonph.baitap.Bai11;

import com.sonph.common.BaseTest;
import com.sonph.common.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ManagementLeads extends BaseTest {

    @Test(priority = 1)
    @Parameters(value = {"name"})
    public static void testAddNewLead(String name) throws InterruptedException {
        driver.get(LocatorsCRM.URL);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).getText(),"Login","Login page is not displayed");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys(LocatorsCRM.EMAIL);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys(LocatorsCRM.PASSWORD);
        driver.findElement(By.xpath(LocatorsCRM.btnLogin)).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.verifyDashboardOption)).isDisplayed(),"Dashboard option is not displayed");
        driver.findElement(By.xpath(LocatorsCRM.menuLeads)).click();
        driver.findElement(By.xpath(LocatorsCRM.btnLeadsSummery)).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLeadsSummary)).getText(),"Leads Summary","Leads page is not displayed");
        driver.findElement(By.xpath(LocatorsCRM.btnNewLead)).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerAddNewLead)).getText().trim(),"Add new lead","Add new Leads page is not displayed");

        driver.findElement(By.xpath(LocatorsCRM.dropdownStatus)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchStatus)).clear();
        Thread.sleep(1000);
        WebElement elementStatus = driver.findElement(By.xpath(LocatorsCRM.inputSearchStatus));
        elementStatus.sendKeys("Active");
        elementStatus.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath(LocatorsCRM.dropdownSource)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchSource)).clear();
        Thread.sleep(1000);
        WebElement elementSource  =  driver.findElement(By.xpath(LocatorsCRM.inputSearchSource));
        elementSource.sendKeys("Facebook");
        elementSource.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath(LocatorsCRM.dropdownAssigned)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchAssigned)).clear();
        Thread.sleep(1000);
        WebElement elementAssigned = driver.findElement(By.xpath(LocatorsCRM.inputSearchAssigned));
        elementAssigned.sendKeys("Admin Anh Tester");
        elementAssigned.sendKeys(Keys.ENTER);

        WebElement elementTag = driver.findElement(By.xpath(LocatorsCRM.leadDropdownTags));
        elementTag.click();
        elementTag.sendKeys("Selenium");
        elementTag.sendKeys(Keys.TAB);

        driver.findElement(By.xpath(LocatorsCRM.inputName)).clear();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String nameLead = name + " " +now.format(formatter);

        driver.findElement(By.xpath(LocatorsCRM.inputName)).sendKeys(nameLead);

        driver.findElement(By.xpath(LocatorsCRM.inputAddress)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputAddress)).sendKeys("Đại Mỗ - Hà Nội");

        driver.findElement(By.xpath(LocatorsCRM.inputPosition)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPosition)).sendKeys("123456");

        driver.findElement(By.xpath(LocatorsCRM.inputCity)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("Tp Hà Nội");

        driver.findElement(By.xpath(LocatorsCRM.inputEmailAddress)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmailAddress)).sendKeys("tphn@gmail.com");

        driver.findElement(By.xpath(LocatorsCRM.inputState)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("Hà Nội");

        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("tphn.test.com.vn");

        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        WebElement elementCountry = driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry));
        elementCountry.click();
        elementCountry.sendKeys("Vietnam");
        elementCountry.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath(LocatorsCRM.inputPhone)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPhone)).sendKeys("0987654321");

        driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputZipCode)).sendKeys("100000");

        driver.findElement(By.xpath(LocatorsCRM.inputLeadValue)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputLeadValue)).sendKeys("100");

        driver.findElement(By.xpath(LocatorsCRM.dropdownDefaultLanguage)).click();
        Thread.sleep(1000);
        WebElement elementDefaultLanguage = driver.findElement(By.xpath(LocatorsCRM.inputSearchDefaultLanguage));
        elementDefaultLanguage.click();
        elementDefaultLanguage.sendKeys("Vietnamese");
        elementDefaultLanguage.sendKeys(Keys.ENTER);

        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys("TpHNJSC");

        driver.findElement(By.xpath(LocatorsCRM.inputDescription)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputDescription)).sendKeys("Test thêm mới new lead");

        driver.findElement(By.xpath(LocatorsCRM.btnSaveLead)).click();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerNewLeadSuccess)).getText(),"Lead Information","Lead Information page is not displayed");

    }

    @Test(priority = 2)
    @Parameters(value = {"name"})
    public static void testEditNewLead(String name) throws InterruptedException {
        driver.get(LocatorsCRM.URL);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).getText(),"Login","Login page is not displayed");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys(LocatorsCRM.EMAIL);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys(LocatorsCRM.PASSWORD);
        driver.findElement(By.xpath(LocatorsCRM.btnLogin)).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.verifyDashboardOption)).isDisplayed(),"Dashboard option is not displayed");
        driver.findElement(By.xpath(LocatorsCRM.menuLeads)).click();
        driver.findElement(By.xpath(LocatorsCRM.btnLeadsSummery)).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLeadsSummary)).getText(),"Leads Summary","Leads page is not displayed");
        driver.findElement(By.xpath(LocatorsCRM.inputSearchLeads)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchLeads)).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchLeads)).sendKeys(name);
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement( driver.findElement(By.xpath(LocatorsCRM.firstRowLeadsTable))).click().perform();
        driver.findElement(By.xpath(LocatorsCRM.btnEditLead)).click();
        Thread.sleep(1000);
        String currentName = driver.findElement(By.xpath(LocatorsCRM.inputName)).getAttribute("value");
        Assert.assertTrue(currentName.contains(name),"The lead name does not match the searched name");
        driver.findElement(By.xpath(LocatorsCRM.inputName)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputName)).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputName)).sendKeys(name);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.btnSaveLead)).click();
        Thread.sleep(1000);
        String label = driver.findElement(By.xpath("//div[@id='leadViewWrapper']//h4[normalize-space()='Lead Information']")).getText();
        Assert.assertEquals(label,"Lead Information","Lead Information page is not displayed after edit lead");
        driver.findElement(By.xpath(LocatorsCRM.btnCloseLead)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchLeads)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchLeads)).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchLeads)).sendKeys(name);
        Thread.sleep(1000);
        Assert.assertEquals( driver.findElement(By.xpath(LocatorsCRM.firstRowLeadsTable)).getText(),name);
    }
}
