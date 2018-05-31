package KeywordDrivenTestFramework.Testing.TestClasses;

/**
 * Created by Mark.Barfoot on 2016-10-25.
 */
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;


import java.text.SimpleDateFormat;
import java.util.Date;

public class post extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public post(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!ATSPost()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean ATSPost() {

        if (!SeleniumDriverInstance.navigateTo(Main_Object.SimplifyPostUrl())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SimplifyJobTitle(), "Job Title goes here")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SimplifyDepartmentDrop(), "this department")) {
            return false;
        }

        if (!SeleniumDriverInstance.enterTextByTmce()) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EmployTypeDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EmployTypeDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.MinExperienceDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.MinExperienceDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.PrimaryIndustryDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.PrimaryIndustryDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.JobFunctionDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.JobFunctionDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.MinSalary(), "20000")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.MaxSalary(), "30000")) {
            return false;
        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LocationCountryDrop())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LocationCountryDrop1())) {
//            return false;
//        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.LocationState(), "Western Cape")) {
            return false;
        }
        SeleniumDriverInstance.pause(5000);
        if (!SeleniumDriverInstance.clickElementByXpath(Main_Object.LocationCity())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.LocationCity(), "Cape Town")) {
            return false;
        }
        SeleniumDriverInstance.pause(5000);
        if (!SeleniumDriverInstance.clickElementByXpath(Main_Object.PostCode())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.PostCode(), "7441")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SensitiveMinSalary(), "20000")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SensitiveMaxSalary(), "30000")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.InternalNotes(), "This is an internal note")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SaveAndContinue())) {
            return false;
        }
//        if (!SeleniumDriverInstance.clickElementbyXpathwerewrwew(Main_Object.PublishBtn())) {
//            return false;
//        }
        SeleniumDriverInstance.takeScreenShot("PASS", false);
        return true;

    }
}
