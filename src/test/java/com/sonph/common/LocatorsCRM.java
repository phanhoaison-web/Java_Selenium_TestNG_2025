package com.sonph.common;

public class LocatorsCRM {
    public static String URL= "https://crm.anhtester.com/admin/authentication";
    public static String EMAIL= "admin@example.com";
    public static String PASSWORD= "123456";

    //Xpath trang login
    public static String headerLogin = "//h1[normalize-space()='Login']";
    public static String inputEmail =  "//input[@id ='email']";
    public static String inputPassword = "//input[@name='password']";
    public static String btnLogin = "//button[normalize-space()='Login']";
    public static String checkBoxRememberMe = "//input[@id='remember']";
    public static String labelRememberMe = "//label[normalize-space()='Remember me']";
    public static String linkForgotPassword = "//a[normalize-space()='Forgot Password?']";
    public static String alertErrorMessage = "//div[contains(@class,'alert-danger')]";
    public static String alertErrorEmailRequired = "//div[normalize-space()='The Email Address field is required.']";
    public static String alertErrorPasswordRequired = "//div[normalize-space()='The Password field is required.']";
    public static String verifyDashboardOption= "//div[normalize-space()='Dashboard Options']";
    //Xpath nav bar menu
    public static String menuDashboard = "//span[normalize-space()='Dashboard' and @class='menu-text']";
    public static String menuLeads = "//span[normalize-space()='Leads' and @class='menu-text']";
    public static String menuTasks = "//span[normalize-space()='Tasks' and @class='menu-text']";

    //Xpath tương đối cách 1 - 5 trang Leads
    //Xpath trang Leads (các button, input search, header, label)
    public static String headerLeadsSummary = "//h4[contains(normalize-space(),'Leads Summary')]";
    public static String headerAddNewLead = "//h4[contains(normalize-space(),'Add new lead')]";
    public static String headerNewLeadSuccess = "//h4[contains(normalize-space(),'Lead Information')]";
    public static String alertLeadUpdateSuccess = "//div[@id='alert_float_1']//span[@class='alert-title']";

    public static String inputSearchLeads = "//div[@id='leads_filter']//input[@type='search']";
    public static String btnNewLead= "//a[contains(@href,'#') and normalize-space()='New Lead']";
    public static String btnEditLead= "//table[@id='leads']//a[contains(@href,'https://crm.anhtester.com/admin/leads/index') and normalize-space()='Edit']";
    public static String btnDeleteLead= "//table[@id='leads']//a[contains(@href,'https://crm.anhtester.com/admin/leads/delete') and normalize-space()='Delete']";
    public static String btnLeadsSummery ="//a[contains(@href,'#') and contains(@data-title,'Leads Summary')]";
    public static String btnLeadSwitchKanbanOrList ="//a[contains(@href,'switch_kanban')]";
    public static String btnCloseLead ="//div[@id='lead-modal']//button[@class='close']";
    //Xpath trang New Leads
    public static String dropdownStatus = "//div[contains(@class,'lead-edit')]//button[contains(@data-id,'status')]";
    public static String inputSearchStatus = "//div[contains(@class,'lead-edit')]//button[contains(@data-id,'status')]/following-sibling::div//input[@type='search']";
    public static String dropdownSource = "//div[contains(@class,'lead-edit')]//button[contains(@data-id,'source')]";
    public static String inputSearchSource = "//div[contains(@class,'lead-edit')]//button[contains(@data-id,'source')]/following-sibling::div//input[@type='search']";
    public static String dropdownAssigned= "//div[contains(@class,'lead-edit')]//button[contains(@data-id,'assigned')]";
    public static String inputSearchAssigned= "//div[contains(@class,'lead-edit')]//button[contains(@data-id,'assigned')]/following-sibling::div//input[@type='search']";
    public static String leadDropdownTags= "//div[@id='inputTagsWrapper']//ul/li/input[@type='text']";
    public static String leadSelectedTags= "//div[@id='inputTagsWrapper']//span[normalize-space()='%s']";

    public static String inputName = "//div[contains(@class,'lead-edit')]//input[@id='name']";
    public static String inputAddress = "//div[contains(@class,'lead-edit')]//textarea[@id='address']";
    public static String inputPosition = "//div[contains(@class,'lead-edit')]//input[@id='title']";
    public static String inputCity = "//div[contains(@class,'lead-edit')]//input[@id='city']";
    public static String inputEmailAddress = "//div[contains(@class,'lead-edit')]//input[@id='email']";
    public static String inputState = "//div[contains(@class,'lead-edit')]//input[@id='state']";
    public static String inputWebsite = "//div[contains(@class,'lead-edit')]//input[@id='website']";
    public static String dropdownCountry = "//div[contains(@class,'lead-edit')]//button[contains(@data-id,'country')]";
    public static String inputSearchCountry = "//div[contains(@class,'lead-edit')]//button[contains(@data-id,'country')]/following-sibling::div//input[@type='search']";
    public static String inputPhone = "//input[@id='phonenumber']";
    public static String inputZipCode = "//input[@id='zip']";
    public static String inputLeadValue = "//input[@name='lead_value' and @type='number']";
    public static String dropdownDefaultLanguage = "//button[contains(@data-id,'default_language')]";
    public static String inputSearchDefaultLanguage = "//button[contains(@data-id,'default_language')]/following-sibling::div//input[@type='search']";
    public static String inputCompany = "//input[@id='company']";
    public static String inputDescription = "//textarea[@id='description']";
    public static String leadCheckBoxPublic = "//input[@id='lead_public']";
    public static String leadBabelPublic = "//label[@for='lead_public']";
    public static String checkBoxContactedToday = "//input[@id='contacted_today']";
    public static String labelContactedToday= "//label[@for='contacted_today']";

    public static String btnCloseAddNewLead ="//div[@class='lead-edit']//button[normalize-space()='Close']";
    public static String btnSaveLead ="//button[@id='lead-form-submit' and normalize-space()='Save']";

    //Xpath tương đối cách 6 - 10 rang Tasks
    public static String headerTasksSummary = "//span[contains(normalize-space(),'Tasks Summary')]";
    public static String headerAddNewTask = "//h4[contains(normalize-space(),'Add new task')]";
    public static String headerNewTaskSuccess = "//h4[contains(normalize-space(),'Task Info')]";
    public static String alertNewTaskAddSuccess = "//div[@id='alert_float_1']//span[@class='alert-title']";
    public static String btnCloseTask ="//div[@id='task-modal']//button[@class='close']";

    public static String inputSearchTask = "//div[@id='tasks_filter']//input[@type='search']";
    public static String btnNewTask = "//a[contains(@href,'#') and normalize-space()='New Task']";
    public static String btnTaskSwitchKanbanOrList = "//a[contains(@href,'switch_kanban')]";
    public static String btnTaskOverview = "//a[contains(@href,'detailed_overview') and contains(text(),'Tasks Overview')]";
    public static String btnCloseAddNewTask ="//div[@id='_task_modal']//button[normalize-space()='Close']";
    public static String btnSaveTask ="//div[@id='_task_modal']//button[normalize-space()='Save']";

    public static String taskCheckBoxPublic = "//label[@for='task_is_public']/preceding::input[@id='task_is_public']";
    public static String taskLabelPublic = "//input[@id='task_is_public']/following::label[@for='task_is_public']";
    public static String checkBoxBillable = "//label[@for='task_is_billable']/preceding::input[@id='task_is_billable']";
    public static String labelBillable = "//input[@id='task_is_billable']/following::label[@for='task_is_billable']";
    public static String linkTextAttachFiles = "//a[@href='#' and normalize-space()='Attach Files']";
    public static String btnChooseFile = "//input[@type='file']";

    public static String addMoreAttachFile = "//div[@id='new-task-attachments']/descendant::button[contains(@class,'add_more_attachments')]";
    public static String removeAttachFile = "//div[@id='new-task-attachments']/descendant::button[contains(@class,'remove_attachment')]";

    public static String inputSubject = "//label[@for='name']/following::input[@id='name']";
    public static String inputHourlyRate = "//label[@for='hourly_rate']/following::input[@id='hourly_rate']";
    public static String inputStartDate = "//label[@for='startdate']/following::div/input[@id='startdate']";
    public static String inputDuaDate = "//label[@for='duedate']/following::div/input[@id='duedate']";
    public static String dropdownPriority = "//label[@for='priority']/following::div/button[@data-id='priority']";
    public static String selectedPriority = "//label[@for='priority']/following::div//span[normalize-space()='%s']";
    public static String dropdownRepeatEvery = "//label[@for='repeat_every']/following::div/button[@data-id='repeat_every']";
    public static String selectedRepeatEvery = "//label[@for='repeat_every']/following::div//span[normalize-space()='%s']";
    public static String inputTotalCycles = "//label[@for='cycles']/following::div//input[@id='cycles']";
    public static String checkBoxInfinity = "//div[@id='cycles_wrapper']/child::div//input[@id='unlimited_cycles']";
    public static String labelInfinity = "//div[@id='cycles_wrapper']/child::div//label[@for='unlimited_cycles']";

    public static String dropdownRelatedTo = "//label[@for='rel_type']/following::div/button[@data-id='rel_type']";
    public static String selectedRelatedTo = "//label[@for='rel_type']/following::div//span[normalize-space()='%s']";

    public static String dropdownLead = "//div[@id='rel_id_select']//button[@data-id='rel_id']";
    public static String inputLead = "//div[@id='rel_id_select']//button[@data-id='rel_id']/following-sibling::div//input[@type='search']";
    public static String selectedLead = "//div[@id='rel_id_select']//button[@data-id='rel_id']/following-sibling::div//span[contains(text(),'%s')][1]";


    public static String dropdownAssignees = "//label[@for='assignees']/following::div/button[@data-id='assignees']";
    public static String inputSearchAssignees = "//button[@data-id='assignees']/following-sibling::div//input[@type='search']";
    public static String dropdownFollowers = "//label[contains(@for,'followers')]/following::div/button[contains(@data-id,'followers')]";
    public static String inputSearchFollowers = "//button[contains(@data-id,'followers')]/following-sibling::div//input[@type='search']";
    public static String taskDropdownTags= "//div[@id='inputTagsWrapper']/child::ul//input[@placeholder='Tag' and @type='text']";
    public static String taskSelectedTags= "//div[@id='inputTagsWrapper']//label[@for='tags']";
    public static String clickTaskDescription = "//p[normalize-space()='Task Description']/following::div/textarea[@id='description']";
    public static String inputTaskDescription = "//p[normalize-space()='Task Description']/following::iframe[@id='description_ifr']";


    //add customer
    public static String menuCustomer = "//span[normalize-space()='Customers' and @class='menu-text']";
    public static String addNewCustomer = "//a[contains(@href,'https://crm.anhtester.com/admin/clients/client') and normalize-space()='New Customer']";
    public static String btnSaveCustomer = "//div[@id='profile-save-section']/button[normalize-space()='Save']";
    public static String inputSearchCustomer = "//div[@id='clients_filter']//input[@type='search']";
    public static String totalCustomers = "//span[normalize-space()='Total Customers']/preceding-sibling::span";

    public static String inputCompanyC = "//input[@id='company']";
    public static String inputVATC = "//input[@id='vat']";
    public static String inputPhoneC = "//input[@id='phonenumber']";
    public static String inputWebsiteC = "//input[@id='website']";
    public static String dropdownGroups = "//button[contains(@data-id,'groups_in')]";
    public static String inputSearchGroups = "//button[contains(@data-id,'groups_in')]/following-sibling::div//input[@type='search']";

    public static String dropdownCurrency = "//button[contains(@data-id,'default_currency')]";
    public static String inputSearchCurrency = "//button[contains(@data-id,'default_currency')]/following-sibling::div//input[@type='search']";

    public static String dropdownLanguage = "//button[contains(@data-id,'default_language')]";

    public static String inputSearchOption(String optionValue){
        String xpath = String.format("//span[normalize-space()='%s']",optionValue);
        return xpath;
    }

    public static String inputAddresC = "//textarea[@id='address']";
    public static String inputCityC = "//input[@id='city']";
    public static String inputStateC = "//input[@id='state']";
    public static String inputZipcode = "//input[@id='zip']";

    public static String dropdownCountryC = "//button[contains(@data-id,'country')]";
    public static String inputSearchCountryC = "//button[contains(@data-id,'country')]/following-sibling::div//input[@type='search']";
    public static String firstRowCustomerTable = "//table[@id='clients']/tbody/tr[1]/td[3]/a";
    public static String btnDeleteCustomer = "//a[normalize-space()='Delete']";
    public static String alertDeleteCustomerSuccess = "//span[@class='alert-title' and normalize-space()='Customer deleted']";


    public static String firstRowLeadsTable = "//table[@id='leads']/tbody/tr[1]/td[3]/a";
    public static String firstRowTasksTable = "//table[@id='tasks']/tbody/tr[1]/td[3]/a";
}
