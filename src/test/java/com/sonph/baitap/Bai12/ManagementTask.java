package com.sonph.baitap.Bai12;

import com.sonph.common.BaseTest;
import com.sonph.common.LocatorsCRM;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class ManagementTask extends BaseTest {

    @Test
    public void testOpenMenuTask() throws InterruptedException {
        driver.get(LocatorsCRM.URL);
        System.out.println("Verify header login :" + driver.findElement(By.xpath(LocatorsCRM.headerLogin)).isDisplayed());
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys(LocatorsCRM.EMAIL);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys(LocatorsCRM.PASSWORD);
        driver.findElement(By.xpath(LocatorsCRM.btnLogin)).click();
        Thread.sleep(2000);
        System.out.println("Verify dashboard option :" + driver.findElement(By.xpath(LocatorsCRM.verifyDashboardOption)).isDisplayed());
        driver.findElement(By.xpath(LocatorsCRM.menuTasks)).click();
        Thread.sleep(2000);
        System.out.println("Verify header Leads Summary :" + driver.findElement(By.xpath(LocatorsCRM.headerTasksSummary)).isDisplayed());

    }

    @Test(priority = 1)
    @Parameters(value = {"taskName"})
    public void testAddNewTask(String taskName) throws InterruptedException, AWTException, URISyntaxException {
        driver.get(LocatorsCRM.URL);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerLogin)).getText(), "Login", "Login page is not displayed");
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys(LocatorsCRM.EMAIL);
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys(LocatorsCRM.PASSWORD);
        driver.findElement(By.xpath(LocatorsCRM.btnLogin)).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorsCRM.verifyDashboardOption)).isDisplayed(), "Dashboard option is not displayed");

        //add new Lead
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

        WebElement elementTagLead = driver.findElement(By.xpath(LocatorsCRM.leadDropdownTags));
        elementTagLead.click();
        elementTagLead.sendKeys("Selenium");
        elementTagLead.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath(String.format(LocatorsCRM.leadSelectedTags,"Selenium"))).click();

        driver.findElement(By.xpath(LocatorsCRM.inputName)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputName)).sendKeys("JSC_LEAD");

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
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.alertLeadUpdateSuccess)).getText(),"Lead added successfully.","Lead add failed");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerNewLeadSuccess)).getText(),"Lead Information","Lead Information page is not displayed");
        driver.findElement(By.xpath(LocatorsCRM.btnCloseLead)).click();
        Thread.sleep(1000);
        //add new Task
        driver.findElement(By.xpath(LocatorsCRM.menuTasks)).click();
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerTasksSummary)).getText(), "Tasks Summary", "Tasks page is not displayed");
        driver.findElement(By.xpath(LocatorsCRM.btnNewTask)).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerAddNewTask)).getText().trim(), "Add new task", "Add new Task page is not displayed");
        WebElement checkBockPublic = driver.findElement(By.xpath(LocatorsCRM.taskCheckBoxPublic));
        if (!checkBockPublic.isSelected()) {
            checkBockPublic.click();
        }
        WebElement checkBoxBillable = driver.findElement(By.xpath(LocatorsCRM.checkBoxBillable));
        if (!checkBoxBillable.isSelected()) {
            checkBoxBillable.click();
        }

        driver.findElement(By.xpath(LocatorsCRM.linkTextAttachFiles)).click();
        Thread.sleep(3000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(LocatorsCRM.btnChooseFile))).click().perform();
        Thread.sleep(2000);

        Path path = Paths.get(Objects.requireNonNull(classLoader.getResource("uploadFile/1TTR_001.pdf")).toURI());
        String fullFilePath = path.toFile().getAbsolutePath();
        Assert.assertNotNull(fullFilePath, "File upload is not exists");
        StringSelection selection = new StringSelection(fullFilePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);

        Robot robotUpload = new Robot();
        robotUpload.keyPress(KeyEvent.VK_CONTROL);
        robotUpload.keyPress(KeyEvent.VK_V);
        robotUpload.keyRelease(KeyEvent.VK_V);
        robotUpload.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(500);
        robotUpload.keyPress(KeyEvent.VK_ENTER);
        robotUpload.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.inputSubject)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputSubject)).sendKeys(taskName);

        driver.findElement(By.xpath(LocatorsCRM.inputHourlyRate)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputHourlyRate)).sendKeys("12");

        driver.findElement(By.xpath(LocatorsCRM.inputStartDate)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputStartDate)).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputStartDate)).sendKeys("30-10-2025");
        driver.findElement(By.xpath(LocatorsCRM.inputStartDate)).sendKeys(Keys.TAB);

        driver.findElement(By.xpath(LocatorsCRM.inputDuaDate)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputDuaDate)).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputDuaDate)).sendKeys("30-10-2026");
        driver.findElement(By.xpath(LocatorsCRM.inputDuaDate)).sendKeys(Keys.TAB);

        driver.findElement(By.xpath(LocatorsCRM.dropdownPriority)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(String.format(LocatorsCRM.selectedPriority, "High"))).click();

        actions.moveToElement( driver.findElement(By.xpath(LocatorsCRM.dropdownRepeatEvery))).click().perform();
        Thread.sleep(1000);
        actions.moveToElement(driver.findElement(By.xpath(String.format(LocatorsCRM.selectedRepeatEvery, "Week")))).click().perform();

        WebElement checkBoxInfinity = driver.findElement(By.xpath(LocatorsCRM.checkBoxInfinity));
        if (checkBoxInfinity.isSelected()) {
            checkBoxInfinity.click();
            driver.findElement(By.xpath(LocatorsCRM.inputTotalCycles)).click();
            driver.findElement(By.xpath(LocatorsCRM.inputTotalCycles)).clear();
            Thread.sleep(1000);
            driver.findElement(By.xpath(LocatorsCRM.inputTotalCycles)).sendKeys("4");
        }

        driver.findElement(By.xpath(LocatorsCRM.dropdownRelatedTo)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(String.format(LocatorsCRM.selectedRelatedTo, "Lead"))).click();
        Thread.sleep(2000);

        WebElement leadElement = driver.findElement(By.xpath(LocatorsCRM.dropdownLead));
        if(leadElement.isDisplayed()){
            leadElement.click();
            Thread.sleep(1000);
            actions.moveToElement(driver.findElement(By.xpath(LocatorsCRM.inputLead))).sendKeys("JSC_LEAD",Keys.ENTER).perform();
            actions.moveToElement(driver.findElement(By.xpath(String.format(LocatorsCRM.selectedLead,"JSC_LEAD")))).click().perform();
        }

        driver.findElement(By.xpath(LocatorsCRM.dropdownAssignees)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchAssignees)).clear();
        Thread.sleep(1000);
        WebElement elementAssignees = driver.findElement(By.xpath(LocatorsCRM.inputSearchAssignees));
        elementAssignees.sendKeys("Admin Anh Tester");
        driver.findElement(By.xpath(LocatorsCRM.dropdownAssignees)).click();

        driver.findElement(By.xpath(LocatorsCRM.dropdownFollowers)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchFollowers)).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchFollowers)).sendKeys("Admin Anh Tester", Keys.ENTER);
        driver.findElement(By.xpath(LocatorsCRM.dropdownFollowers)).click();

        WebElement elementTagTask = driver.findElement(By.xpath(LocatorsCRM.taskDropdownTags));
        elementTagTask.click();
        elementTagTask.clear();
        Thread.sleep(1000);
        elementTagTask.sendKeys("JSC_NEW", Keys.TAB);
        driver.findElement(By.xpath(String.format(LocatorsCRM.taskSelectedTags, "JSC_NEW"))).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.clickTaskDescription)).click();
        WebElement iframe = driver.findElement(By.id("description_ifr"));
        driver.switchTo().frame(iframe);
        WebElement body = driver.findElement(By.id("tinymce"));
        body.clear();
        body.sendKeys("Test thêm mới new Task");
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath(LocatorsCRM.btnSaveTask)).click();
        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.alertNewTaskAddSuccess)).getText().trim(),"Task added successfully.","New task was not added successfully");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorsCRM.headerNewTaskSuccess)).getText().trim(),"Task Info","New task was not created successfully");

        actions.moveToElement(driver.findElement(By.xpath(LocatorsCRM.btnCloseTask))).click().perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchTask)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchTask)).clear();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchTask)).sendKeys(taskName);
        Thread.sleep(2000);
        Assert.assertEquals( driver.findElement(By.xpath(LocatorsCRM.firstRowTasksTable)).getText().trim(),taskName);
    }

}
