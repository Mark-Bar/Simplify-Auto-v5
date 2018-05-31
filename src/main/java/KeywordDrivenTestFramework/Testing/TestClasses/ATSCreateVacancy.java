package KeywordDrivenTestFramework.Testing.TestClasses;

/**
 * Created by Mark.Barfoot on 2016-10-25.
 */
        import KeywordDrivenTestFramework.Core.BaseClass;
        import KeywordDrivenTestFramework.Entities.Enums;
        import KeywordDrivenTestFramework.Entities.TestEntity;
        import KeywordDrivenTestFramework.Entities.TestResult;
        import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
        import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;


        import java.sql.Driver;
        import java.text.SimpleDateFormat;
        import java.util.Date;

public class ATSCreateVacancy extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public ATSCreateVacancy(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!ATSCreateVacancy1()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean ATSCreateVacancy1() {

        if (!SeleniumDriverInstance.navigateTo(Main_Object.SimplifyPostUrl())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SimplifyJobTitle(), "Job Title goes here")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SimplifyDepartmentDrop())) {
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
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SaveAndContinue())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SaveAndContinue())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddNewMemDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddNewMemFirstName(), "John")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddNewMemLastName(), "Legend")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddNewMemEmail(), "Johnlegend@mailinator.com")) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SelectExistingExternalMemberDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SelectExistingExternalMemberDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddExistingExternalMemberAddBtn())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.InviteExternalRecruitersDrop())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.InviteExternalFullName(), "Pickle Rick")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.InviteExternalEmail(), "PickleRicko@mailinator.com")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.InviteExternalCompany(), "Pickle Rick Inc")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.InviteExternalBtn())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.navigateBack()) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.PublishBtn())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);

        SeleniumDriverInstance.takeScreenShot("PASS", false);
        return true;

    }


}

