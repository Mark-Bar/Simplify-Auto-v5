package KeywordDrivenTestFramework.Testing.TestClasses;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import org.jetbrains.uast.values.UBooleanConstant;
//import javafx.scene.layout.Priority;
//import org.junit.Assert;
//import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.NoSuchElementException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SimplifyAutomationApplication extends BaseClass {

    private WebDriver driver;
    private String baseUrl;
    ExtentReports report;
    ExtentTest test;


    @BeforeClass
    public void beforeClass() {

        baseUrl = "http://www.simplify.hr";
        report = new ExtentReports("C://Users//Mark.Barfoot//Desktop//SimplifyAutomationResults.html");
        test = report.startTest("SIMPLIFY TEST SUITE STARTED");
        driver = new ChromeDriver();
        //driver = new ChromeDriver(new ChromeOptions{Proxy = null});
        test.log(LogStatus.INFO, "Browser Started...");

        // Maximize the browser's window
        driver.manage().window().maximize();
        test.log(LogStatus.INFO, "Browser Maximized");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        test.log(LogStatus.INFO, "Web application opened");

    }

    Date date = new Date();
    String newDate =  new SimpleDateFormat("yyMMddHHmmss").format(date);


    //@Test(priority=1)
    public void ATSrecruiterRegistration() throws Exception {

//        Date date = new Date();
//        String newDate =  new SimpleDateFormat("yyMMddHHmmss").format(date);
        int newDate = 1234;

        test = report.startTest("1) Simplify Recruiter Registration");

        Main_Object.navigateTo(driver, Main_Object.SimplifyRegUrl());
        test.log(LogStatus.PASS, "Simplify Registration: URL Navigation");

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyRegFirstName())){
            Main_Object.enterTextByXpath(driver, Main_Object.SimplifyRegFirstName(), "Mark");
            test.log(LogStatus.PASS, "Simplify Registration: Enter First Name");
        }
        else {test.log(LogStatus.FAIL, "Simplify Registration: Enter First Name"); }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyRegLastName())){
            Main_Object.enterTextByXpath(driver, Main_Object.SimplifyRegLastName(), "Foot");
            test.log(LogStatus.PASS, "Simplify Registration: Enter Last Name");
        }
        else {test.log(LogStatus.FAIL, "Simplify Registration: Enter Last Name"); }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyRegCompanyEmail())){
            Main_Object.enterTextByXpath(driver, Main_Object.SimplifyRegCompanyEmail(), "MarkAtsMaster" + newDate + "@ats.com");
            test.log(LogStatus.PASS, "Simplify Registration: Enter Email Address");
        }
        else {test.log(LogStatus.FAIL, "Simplify Registration: Enter Email Address"); }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyRegPassword())){
            Main_Object.enterTextByXpath(driver, Main_Object.SimplifyRegPassword(), "Andr3w@100");
            test.log(LogStatus.PASS, "Simplify Registration: Enter Password");
        }
        else {test.log(LogStatus.FAIL, "Simplify Registration: Enter Password"); }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyRegNowButton())){
            Main_Object.clickElementbyXpath(driver, Main_Object.SimplifyRegNowButton());
            test.log(LogStatus.PASS, "Simplify Registration: Click Register Button");
        }
        else {test.log(LogStatus.FAIL, "Simplify Registration: Click Register Button"); }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyCompanyName())){
            Main_Object.enterTextByXpath(driver, Main_Object.SimplifyCompanyName(), "Company" + newDate);
            test.log(LogStatus.PASS, "Simplify Registration: Enter Company");
        }
        else {test.log(LogStatus.FAIL, "Simplify Registration: Enter Company"); }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyCompanyWeb())){
            Main_Object.enterTextByXpath(driver, Main_Object.SimplifyCompanyWeb(), "http://www.company" + newDate +".com");
            test.log(LogStatus.PASS, "Simplify Registration: Enter Company Website");
        }
        else {test.log(LogStatus.FAIL, "Simplify Registration: Enter Company Website"); }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyTel())){
            Main_Object.enterTextByXpath(driver, Main_Object.SimplifyTel(), "1234567890");
            test.log(LogStatus.PASS, "Simplify Registration: Enter Telephone Number");
        }
        else {test.log(LogStatus.FAIL, "Simplify Registration: Enter Telephone Number"); }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyCompanyIndustryDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.SimplifyCompanyIndustryDrop());
            Main_Object.clickElementbyXpath(driver, Main_Object.SimplifyCompanyIndustryDrop1());
            test.log(LogStatus.PASS, "Simplify Registration: Select Industry");;
        }
        else {test.log(LogStatus.FAIL, "Simplify Registration: Select Industry"); }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyEmployeesDrop())){

            Main_Object.clickElementbyXpath(driver, Main_Object.SimplifyEmployeesDrop());
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Main_Object.SimplifyEmployeesDrop())));
            Main_Object.clickElementbyXpath(driver, Main_Object.SimplifyEmployeesDrop1());
            test.log(LogStatus.PASS, "Simplify Registration: Select Number Of Employees");
        }
        else {test.log(LogStatus.FAIL, "Simplify Registration: Select Number Of Employees"); }

//        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyGetStartedBtn())){
//            Main_Object.clickElementbyXpath(driver, Main_Object.SimplifyGetStartedBtn());
//            test.log(LogStatus.PASS, "Simplify Registration: Clicked On Get Started Button");
//        }
        //else {test.log(LogStatus.FAIL, "Simplify Registration: Clicked On Get Started Button"); }

        String path = Screenshots.takeScreenshot(driver, "Hello");
        String imagePath = test.addScreenCapture(path);
        test.log(LogStatus.PASS, "Verify Welcome Text Failed", imagePath);

        test.log(LogStatus.PASS, "---SIMPLIFY REGISTRATION COMPLETED---");

    }

    @Test(priority=2)
    public void ATSloginPageTest() throws Exception {


        test = report.startTest("2) Simplify Log In Test");

        Main_Object.navigateTo(driver, Main_Object.SimplifyLoginUrl());
        test.log(LogStatus.PASS, "Simplify Login: URL Navigation");

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyLoginEmail())){
            Main_Object.enterTextByXpath(driver, Main_Object.SimplifyLoginEmail(), "mark.barfoot@media24.com");
            test.log(LogStatus.PASS, "Simplify Login: Email Address Input");
        }
        else {test.log(LogStatus.FAIL, "Simplify Login: Email Address Input"); }


        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyLoginPassword())){
            Main_Object.enterTextByXpath(driver, Main_Object.SimplifyLoginPassword(), "Andr3w@100");
            test.log(LogStatus.PASS, "Simplify Login: Password Input");
        }
        else {test.log(LogStatus.FAIL, "Simplify Login: Password Input"); }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyLoginBtn())){
            Main_Object.clickElementbyXpath(driver, Main_Object.SimplifyLoginBtn());
            test.log(LogStatus.PASS, "Simplify Login: Login Button Clicked");
        }
        else {test.log(LogStatus.FAIL, "Simplify Login: Login Button Clicked"); }

        String path = Screenshots.takeScreenshot(driver, "Hello");
        String imagePath = test.addScreenCapture(path);
        test.log(LogStatus.PASS, "Verify Welcome Text Failed", imagePath);

        test.log(LogStatus.PASS, "---SIMPLIFY LOGIN TEST COMPLETED---");

        }

    @Test(priority=3)
    public void ATSaddCandidate()throws Exception{

        test = report.startTest("3) Simplify Add Candidate Manually");

        Main_Object.navigateTo(driver, Main_Object.CandidateDashURL());
        test.log(LogStatus.PASS, "Simplify Candidate Dash: URL Navigation");

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidateDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.AddCandidateDrop());
            Main_Object.clickElementbyXpath(driver, Main_Object.AddCandidateManually());

            test.log(LogStatus.PASS, "Simplify Add Candidate: Manual Entry Select");
        }
        else {
            test.log(LogStatus.FAIL, "Simplify Add Candidate: Manual Entry Select");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidateFirstName())){
            Main_Object.enterTextByXpath(driver, Main_Object.AddCandidateFirstName(), "Kyle");

            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: First Name Entry");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidateLastName())){
            Main_Object.enterTextByXpath(driver, Main_Object.AddCandidateLastName(), "Myle" + newDate);

            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: Last Name Entry");
        }
        else {test.log(LogStatus.FAIL, "Simplify Add Candidate Manually: Last Name Entry");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidateEmail())){
            Main_Object.enterTextByXpath(driver, Main_Object.AddCandidateEmail(), "kylemyle" + newDate + "@mailinator.com");

            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: Email Entry");
        }
        else {test.log(LogStatus.FAIL, "Simplify Add Candidate Manually: Email Entry");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidateCountryDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.AddCandidateCountryDrop());

            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: Select Country");
        }
        else {
            test.log(LogStatus.FAIL, "Simplify Add Candidate Manually: Select Country");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidateProvince())){
            Main_Object.enterTextByXpath(driver, Main_Object.AddCandidateProvince(), "Western Cape");

            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: Enter Province");
        }
        else {
            test.log(LogStatus.FAIL, "Simplify Add Candidate Manually: Enter Province");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidateCity())){
            Main_Object.enterTextByXpath(driver, Main_Object.AddCandidateCity(), "Cape Town");

            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: Enter City");
        }
        else {
            test.log(LogStatus.FAIL, "Simplify Add Candidate Manually: Enter City");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidatePostCode())){
            Main_Object.enterTextByXpath(driver, Main_Object.AddCandidatePostCode(), "1234");

            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: Enter Post Code");
        }
        else {
            test.log(LogStatus.FAIL, "Simplify Add Candidate Manually: Enter Post Code");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidatePhone())){
            Main_Object.enterTextByXpath(driver, Main_Object.AddCandidatePhone(), "123456789");

            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: Enter Contact Number");
        }
        else {
            test.log(LogStatus.FAIL, "Simplify Add Candidate Manually: Enter Contact Number");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidateEthnicityDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.AddCandidateEthnicityDrop());
            Main_Object.clickElementbyXpath(driver, Main_Object.AddCandidateEthnicityDrop1());

            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: Select Ethnicity");
        }
        else {
            test.log(LogStatus.FAIL, "Simplify Add Candidate Manually: Select Ethnicity");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidateGenderDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.AddCandidateGenderDrop());
            Main_Object.clickElementbyXpath(driver, Main_Object.AddCandidateGenderDrop1());

            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: Select Gender");
        }
        else {
            test.log(LogStatus.FAIL, "Simplify Add Candidate Manually: Select Gender");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidateNationalityDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.AddCandidateNationalityDrop());
            Main_Object.clickElementbyXpath(driver, Main_Object.AddCandidateNationalityDrop1());
            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: Select Nationality");
        }
        else {
            test.log(LogStatus.FAIL, "Simplify Add Candidate Manually: Select Nationality");
        }
        if(Main_Object.enterTextByTmce(driver)){
            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: Enter Description");
        }
        else{test.log(LogStatus.FAIL, "Simplify Add Candidate Manually: Enter Description");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddCandidateSubmitBtn())){
            Main_Object.clickElementbyXpath(driver, Main_Object.AddCandidateSubmitBtn());

            test.log(LogStatus.PASS, "Simplify Add Candidate Manually: Submit Button Clicked");
        }
        else {
            test.log(LogStatus.FAIL, "Simplify Add Candidate Manually: Select Button Clicked");
        }

        String path = Screenshots.takeScreenshot(driver, "Hello");
        String imagePath = test.addScreenCapture(path);
        test.log(LogStatus.PASS, "Verify Welcome Text Failed", imagePath);

        test.log(LogStatus.PASS, "---SIMPLIFY ADD CANDIDATE MANUALLY TEST COMPLETED---");
    }

    //@Test(priority=4)
    public void ATSCreateVacancy1()throws Exception{

        test = report.startTest("4) Simplify Create Vacancy");

        Main_Object.navigateTo(driver, Main_Object.SimplifyPostUrl());
        test.log(LogStatus.PASS, "Simplify Create Vacancy:  URL Navigation");

        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyJobTitle())){
            Main_Object.enterTextByXpath(driver, Main_Object.SimplifyJobTitle(), "Test Vac" + newDate);

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Enter Job Title");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Enter Job Title");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyDepartmentDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.SimplifyDepartmentDrop());
            pause(2000);
            Main_Object.clickElementbyXpath(driver, Main_Object.SimplifyDepartmentDrop1());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Select Department");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Select Department");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.SimplifyBusinessUnitDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.SimplifyBusinessUnitDrop());
            pause(2000);
            Main_Object.clickElementbyXpath(driver, Main_Object.SimplifyBusinessUnitDrop1());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Select Business Unit");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Select Business Unit");
        }
        if(Main_Object.enterTextByTmce(driver)){
            test.log(LogStatus.PASS, "Simplify Create Vacancy: Enter Description");
        }
        else{test.log(LogStatus.FAIL, "Simplify Create Vacancy: Enter Description");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.EmployTypeDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.EmployTypeDrop());
            Main_Object.clickElementbyXpath(driver, Main_Object.EmployTypeDrop1());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Select Employment Type");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Select Employment Type");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.MinExperienceDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.MinExperienceDrop());
            Main_Object.clickElementbyXpath(driver, Main_Object.MinExperienceDrop1());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Select Minimum Experience");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Select Minimum Experience");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.PrimaryIndustryDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.PrimaryIndustryDrop());
            Main_Object.clickElementbyXpath(driver, Main_Object.PrimaryIndustryDrop1());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Select Primary Industry");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Select Primary Industry");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.JobFunctionDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.JobFunctionDrop());
            Main_Object.clickElementbyXpath(driver, Main_Object.JobFunctionDrop1());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Select Job Function");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Select Job Function");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.MinSalary())){
            Main_Object.enterTextByXpath(driver, Main_Object.MinSalary(), "20000");

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Enter Min Salary");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Enter Min Salary");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.MaxSalary())){
            Main_Object.enterTextByXpath(driver, Main_Object.MaxSalary(), "30000");

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Enter Max Salary");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Enter Max Salary");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.LocationState())){
            Main_Object.enterTextByXpath(driver, Main_Object.LocationState(), "Western Cape");
            test.log(LogStatus.PASS, "Simplify Create Vacancy: Enter Province");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Enter Province");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.LocationCity())){
            Main_Object.enterTextByXpath(driver, Main_Object.LocationCity(), "Cape Town");

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Enter City");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Enter City");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.PostCode())){
            Main_Object.enterTextByXpath(driver, Main_Object.PostCode(), "1234");

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Enter Post Code");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Enter Post Code");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.SensitiveMinSalary())){
            Main_Object.enterTextByXpath(driver, Main_Object.SensitiveMinSalary(), "21000");

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Enter Sensitive Min Salary");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Enter Sensitive Min Salary");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.SensitiveMaxSalary())){
            Main_Object.enterTextByXpath(driver, Main_Object.SensitiveMaxSalary(), "31000");

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Enter Sensitive Max Salary");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Enter Sensitive Max Salary");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.InternalNotes())){
            Main_Object.enterTextByXpath(driver, Main_Object.InternalNotes(), "This is a test of the internal note functionality");

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Enter Internal Note");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Enter Internal Note");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.SaveAndContinue())){
            Main_Object.clickElementbyXpath(driver, Main_Object.SaveAndContinue());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Save and Continue");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Save and Continue");
        }
        pause(1000);
        if (Main_Object.findElementsByXpath(driver, Main_Object.SaveAndContinue())){
            Main_Object.clickElementbyXpath(driver, Main_Object.SaveAndContinue());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Save and Continue");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Save and Continue");
        }
        pause(1000);
        if (Main_Object.findElementsByXpath(driver, Main_Object.SaveAndContinue())){
            Main_Object.clickElementbyXpath(driver, Main_Object.SaveAndContinue());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Save and Continue");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Save and Continue");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddNewMemDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.AddNewMemDrop());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Add Member Open");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Add Member Open");
        }
        pause(1000);
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddNewMemFirstName())){
            Main_Object.enterTextByXpath(driver, Main_Object.AddNewMemFirstName(), "Member");

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Add Member First Name");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Add Member First Name");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddNewMemLastName())){
            Main_Object.enterTextByXpath(driver, Main_Object.AddNewMemLastName(), "Test" + " " + newDate);

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Add Member Last Name");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Add Member Last Name");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddNewMemEmail())){
            Main_Object.enterTextByXpath(driver, Main_Object.AddNewMemEmail(), "MemberTest" +  newDate + "@simplify.hr");

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Add Member Last Name");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Add Member Last Name");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.SendInvite())){
            Main_Object.clickElementbyXpath(driver, Main_Object.SendInvite());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Click Invite Button");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Click Invite Button");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.InviteExternalRecruitersDrop())){
            Main_Object.clickElementbyXpath(driver, Main_Object.InviteExternalRecruitersDrop());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Add New External Member Open");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Add New External Member Open");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.InviteExternalFullName())){
            Main_Object.enterTextByXpath(driver, Main_Object.InviteExternalFullName(), "ExtMemberTest" +  newDate);

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Add New External Member Full Name");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Add New External Member Full Name");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.InviteExternalEmail())){
            Main_Object.enterTextByXpath(driver, Main_Object.InviteExternalEmail(), "ExtMemberTest" +  newDate + "@mailinator.com");

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Add New External Member Email");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Add New External Member Email");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.InviteExternalCompany())){
            Main_Object.enterTextByXpath(driver, Main_Object.InviteExternalCompany(), "ExtCompanyTest");

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Add New External Company");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Add New External Company");
        }
//        if (Main_Object.findElementsByXpath(driver, Main_Object.InviteExternalBtn())){
//            Main_Object.clickElementbyXpath(driver, Main_Object.InviteExternalBtn());
//
//            test.log(LogStatus.PASS, "Simplify Create Vacancy: Click Invite Button");
//        }
//        else{
//            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Click Invite Button");
//        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.PublishBtn())){
            Main_Object.clickElementbyXpath(driver, Main_Object.PublishBtn());

            test.log(LogStatus.PASS, "Simplify Create Vacancy: Publish Vacancy");
        }
        else{
            test.log(LogStatus.FAIL, "Simplify Create Vacancy: Publish Vacancy");
        }
        Main_Object.navigateTo(driver, Main_Object.RecDashURL());
        test.log(LogStatus.PASS, "Simplify Create Vacancy:  Navigate to Recruiter Dashboard");

        pause(5000);

    }

    //@Test(priority=5)
    public void ATSCreateTask()throws Exception{

        test = report.startTest("5) Simplify Create Tasks");

        Main_Object.navigateTo(driver, Main_Object.TasksURL());
        test.log(LogStatus.PASS, "Simplify Tasks:  URL Navigation");

        int i = 0;

while (i < 5) {

    Date dates = new Date();
    String taskDate = new SimpleDateFormat("yyMMddHHmmss").format(dates);

    if (Main_Object.findElementsByXpath(driver, Main_Object.AddNewTask())) {
        Main_Object.clickElementbyXpath(driver, Main_Object.AddNewTask());

        test.log(LogStatus.PASS, "Simplify Create Task: New Task Click");
    } else {
        test.log(LogStatus.FAIL, "Simplify Create Task: New Task Click");
    }
    if (Main_Object.findElementsByXpath(driver, Main_Object.AddNewTaskName())) {
        Main_Object.enterTextByXpath(driver, Main_Object.AddNewTaskName(), "Task" + taskDate);
        test.log(LogStatus.PASS, "Simplify Create Task: Enter Task Name");
    } else {
        test.log(LogStatus.FAIL, "Simplify Create Task: Enter Task Name");
    }
    if (Main_Object.findElementsByXpath(driver, Main_Object.AddNewTaskDescription())) {
        Main_Object.enterTextByXpath(driver, Main_Object.AddNewTaskDescription(), "This is a description of the task");
        test.log(LogStatus.PASS, "Simplify Create Task: Enter Description");
    } else {
        test.log(LogStatus.FAIL, "Simplify Create Task: Enter Description");
    }
    if (Main_Object.findElementsByXpath(driver, Main_Object.AddNewTaskAssignToUserDrop())) {
        Main_Object.clickElementbyXpath(driver, Main_Object.AddNewTaskAssignToUserDrop());
        Main_Object.clickElementbyXpath(driver, Main_Object.AddNewTaskAssignToUserDrop1());

        test.log(LogStatus.PASS, "Simplify Create Task: Assign User");
    } else {
        test.log(LogStatus.FAIL, "Simplify Create Task: Assign User");
    }
    if (Main_Object.findElementsByXpath(driver, Main_Object.AddNewTaskDueDate())) {
        Main_Object.enterTextByXpath(driver, Main_Object.AddNewTaskDueDate(), "31/12/2018");
        test.log(LogStatus.PASS, "Simplify Create Task: Enter Due Date");
    } else {
        test.log(LogStatus.FAIL, "Simplify Create Task: Enter Due Date");
    }
    if (Main_Object.findElementsByXpath(driver, Main_Object.AddNewTaskSave())) {
        Main_Object.clickElementbyXpath(driver, Main_Object.AddNewTaskSave());

        test.log(LogStatus.PASS, "Simplify Create Task: Save Task");
    } else {
        test.log(LogStatus.FAIL, "Simplify Create Task: Save Task");
    }

    i++;
}

    }

    @Test(priority=6)
    public void AtsCandidateFunction()throws Exception{

        test = report.startTest("6) Simplify Candidate Functions");

        Main_Object.navigateTo(driver, Main_Object.CandidateDashURL());
        test.log(LogStatus.PASS, "Simplify Candidate Page:  URL Navigation");

        if (Main_Object.findElementsByXpath(driver, Main_Object.CandidateSelect())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.CandidateSelect());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Select Candidate");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Select Candidate");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.VacancyAssignClick())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.VacancyAssignClick());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Assign Vacancy");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Assign Vacancy");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.VacancyAssignSelect())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.VacancyAssignSelect());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Vacancy Select");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Vacancy Select");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.VacancyAssignSubmitBtn())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.VacancyAssignSubmitBtn());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Vacancy Assign Submit Btn");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Vacancy Assign Submit Btn");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddTag())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.AddTag());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Add Tag");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Add Tag");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.InputTags())) {
            Main_Object.enterTextByXpath(driver, Main_Object.InputTags(), "Skill 1");
            test.log(LogStatus.PASS, "Simplify Create Task: Enter Skill");
        } else {
            test.log(LogStatus.FAIL, "Simplify Create Task: Enter Skill");
        }
        Main_Object.enterPressTags(driver);
        pause(2000);

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddTag())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.AddTag());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Add Tag");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Add Tag");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.InputTags())) {
            Main_Object.enterTextByXpath(driver, Main_Object.InputTags(), "Skill 2");
            test.log(LogStatus.PASS, "Simplify Create Task: Enter Skill");
        } else {
            test.log(LogStatus.FAIL, "Simplify Create Task: Enter Skill");
        }
        Main_Object.enterPressTags(driver);
        pause(2000);
        if (Main_Object.findElementsByXpath(driver, Main_Object.AddTag())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.AddTag());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Add Tag");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Add Tag");
        }
        if (Main_Object.findElementsByXpath(driver, Main_Object.InputTags())) {
            Main_Object.enterTextByXpath(driver, Main_Object.InputTags(), "Skill 3");
            test.log(LogStatus.PASS, "Simplify Create Task: Enter Skill");
        } else {
            test.log(LogStatus.FAIL, "Simplify Create Task: Enter Skill");
        }
        Main_Object.enterPressTags(driver);

        if (Main_Object.findElementsByXpath(driver, Main_Object.CandidateEditBtn())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.CandidateEditBtn());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Edit Candidate Btn");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Edit Candidate Btn");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SummaryClick())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.SummaryClick());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Click Summary tinyMCE");
            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter Summary Text");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Click Summary tinyMCE");
        }
        Main_Object.enterTextByTmce(driver);

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsFirstName())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsFirstName());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Name field exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Name field exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsLastName())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsLastName());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Last Name field exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Last Name field exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsEmail())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsEmail());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Email field exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Email field exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsCurrentJobTitle())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsCurrentJobTitle());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Current job title field exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Current job title field exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsProvince())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsProvince());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Province field exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Province field exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsCity())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsCity());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: City field exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: City field exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsPhone())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsPhone());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Details field exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Details field exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsEthnicityDrop())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsEthnicityDrop());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Ethnicity drop down exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Ethnicity drop down exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsGenderDrop())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsGenderDrop());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Gender drop down exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Gender drop down exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsFacebook())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsFacebook());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Facebook field exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Facebook field exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsTwitter())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsTwitter());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Twitter field exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Twitter field exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsLinkedIn())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsLinkedIn());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: LinkedIn field exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: LinkedIn field exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsGoolePlus())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsGoolePlus());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: GooglePlus field exists and is functional");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: GooglePlus field exists and is functional");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.DetailsSaveBtn())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.DetailsSaveBtn());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Click Save Button");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Click Save Button");
        }
        pause(2000);

        if (Main_Object.findElementsByXpath(driver, Main_Object.CandidateExperienceTab())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.CandidateExperienceTab());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Click on Experience Tab");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Click on Experience Tab");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddExperienceBtn())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.AddExperienceBtn());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Click Add New Work Experience Btn");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Click Add New Work Experience Btn");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddExperienceJobTitle())) {
            Main_Object.enterTextByXpath(driver, Main_Object.AddExperienceJobTitle(), "Test Job Title");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter Job Title");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter Job Title");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddExperienceCompany())) {
            Main_Object.enterTextByXpath(driver, Main_Object.AddExperienceCompany(), "Test Company Name");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter Company Name");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter Company Name");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddExperienceStartDate())) {
            Main_Object.enterTextByXpath(driver, Main_Object.AddExperienceStartDate(), "15 May 2017");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter Start/From Date");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter Start/From Date");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddExperienceEndDate())) {
            Main_Object.enterTextByXpath(driver, Main_Object.AddExperienceEndDate(), "15 Feb 2018");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter End/To Date");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter End/To Date");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddExperienceSummary())) {
            Main_Object.enterTextByXpath(driver, Main_Object.AddExperienceSummary(), "This is a test ");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter Summary");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter Summary");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddExperienceSaveBtn())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.AddExperienceSaveBtn());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Click Save Btn");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Click Save Btn");
        }

        pause(2000);

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddEducationBtn())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.AddEducationBtn());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Click Add New Education Btn");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Click Add New Education Btn");
        }

        pause(2000);

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddEducationFieldOfStudy())) {
            Main_Object.enterTextByXpath(driver, Main_Object.AddEducationFieldOfStudy(), "This is a test ");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter Field Of Study");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter Field Of Study");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddEducationSchool())) {
            Main_Object.enterTextByXpath(driver, Main_Object.AddEducationSchool(), "This is a test ");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter School");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter School");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddEducationStartDate())) {
            Main_Object.enterTextByXpath(driver, Main_Object.AddEducationStartDate(), "15 Feb 2017");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter Start/From Date");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter Start/From");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddEducationEndDate())) {
            Main_Object.enterTextByXpath(driver, Main_Object.AddEducationEndDate(), "15 Feb 2018");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter End/To Date");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter End/To Date");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddEducationSaveBtn())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.AddEducationSaveBtn());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Click Save Education Btn");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Click Save Education Btn");
        }


        Main_Object.navigateTo(driver, Main_Object.CandidateDashURL());
        test.log(LogStatus.PASS, "Simplify Candidate Page:  URL Navigation");

        if (Main_Object.findElementsByXpath(driver, Main_Object.CandidateSelect())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.CandidateSelect());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Select Candidate");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Select Candidate");
        }


        if (Main_Object.findElementsByXpath(driver, Main_Object.ResumeTab())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.ResumeTab());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Click Resume Tab");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Click Resume Tab");
        }



        pause(2000);

        if (Main_Object.findElementsByXpath(driver, Main_Object.QuestionnaireTab())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.QuestionnaireTab());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Click Questionnaire Tab");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Click Questionnaire Tab");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SelectQuestionnaireDrop())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.SelectQuestionnaireDrop());
            Main_Object.clickElementbyXpath(driver, Main_Object.SelectQuestionnaireDrop1());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Select existing Questionnaire");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Select existing Questionnaire");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.SendQuestionnaireBtn())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.SendQuestionnaireBtn());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Click Send Questionnaire Tab");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Click Send Questionnaire Tab");
        }

        pause(2000);

        if (Main_Object.findElementsByXpath(driver, Main_Object.CreateNewQuestionnaire())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.CreateNewQuestionnaire());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Click create New Questionnaire link");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Click create New Questionnaire link");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.QuestionnaireName())) {
            Main_Object.enterTextByXpath(driver, Main_Object.QuestionnaireName(), "Test Questionnaire 1");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter Questionnaire Name");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter Questionnaire Name");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.Question())) {
            Main_Object.enterTextByXpath(driver, Main_Object.Question(), "Question 1");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter Question");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter Question");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.QuestionTypeDrop())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.QuestionTypeDrop());
            Main_Object.clickElementbyXpath(driver, Main_Object.QuestionTypeDropMultiChoice());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Select multiple choice");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Select multiple choice");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.QuestionChoiceOption1())) {
            Main_Object.enterTextByXpath(driver, Main_Object.QuestionChoiceOption1(), "Option 1");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter Option 1");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter Option 1");
        }

        pause(2000);

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddOption())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.AddOption());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Add Option");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Add Option");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.QuestionChoiceOption2())) {
            Main_Object.enterTextByXpath(driver, Main_Object.QuestionChoiceOption2(), "Option 2");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter Option 2");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter Option 2");
        }

        pause(2000);

        if (Main_Object.findElementsByXpath(driver, Main_Object.AddOption())) {
            Main_Object.clickElementbyXpath(driver, Main_Object.AddOption());

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Add Option");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Add Option");
        }

        if (Main_Object.findElementsByXpath(driver, Main_Object.QuestionChoiceOption3())) {
            Main_Object.enterTextByXpath(driver, Main_Object.QuestionChoiceOption3(), "Option 3");

            test.log(LogStatus.PASS, "Simplify Candidate Functions: Enter Option 3");
        } else {
            test.log(LogStatus.FAIL, "Simplify Candidate Functions: Enter Option 3");
        }


        pause(10000);


    }




    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String path = Screenshots.takeScreenshot(driver, testResult.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "Verify Welcome Text Failed", imagePath);
        }

        //driver.quit();
        report.endTest(test);
        report.flush();
     }

     @AfterTest
    public void afterTest(){
         Main_Object.navigateTo(driver, "file:///C:/Users/Mark.Barfoot/Desktop/SimplifyAutomationResults.html#!");
     }

    }
