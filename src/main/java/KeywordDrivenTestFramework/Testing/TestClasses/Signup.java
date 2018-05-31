package KeywordDrivenTestFramework.Testing.TestClasses;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import KeywordDrivenTestFramework.Utilities.GenerateID;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mark.Barfoot on 2016-10-04.
 */
public class Signup extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public Signup(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!SignUpSA()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean SignUpSA() {

        Date time = new Date();
        String newTime =  new SimpleDateFormat("HH:mm:ss").format(time);

        Date date = new Date();
        String newDate =  new SimpleDateFormat("yyMMddHHmmss").format(date);

        if (!SeleniumDriverInstance.waitForElementByXpath(Main_Object.SignUpClient())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SignUpClient())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SignupEmail(), "marky+" + newDate +"@media24.co.za")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SignupPass(), "123456")) {
            return false;
        }
//        if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.WorkExperience(), true)) {
//            return false;
//        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.MonthDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.MonthDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.YearDropSignup())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.YearDropSignup1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SignUpClick())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.FirstName(), "Mark")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.LastName(), "Batman")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ContactNumber(), "123456789")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Id(), "8011265246180")) {
            return false;
        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DobDayDrop())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DobDayDrop1())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DobMonthDrop())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DobMonthDrop1())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DobYearDrop())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DobYearDrop1())) {
//            return false;
//        }
        if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.Gender(), true)) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Race())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Race1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Location())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Location1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Education())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Education1())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Next1())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.JobTitle(), "Accountant")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CompanyName(), "Company X")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.WorkLocation(), "Cape Town")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.WorkSectorDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.WorkSectorDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ContractTypeDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ContractTypeDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.StartMonthDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.StartMonthDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.StartYearDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.StartYearDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EndMonthDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EndMonthDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EndYearDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EndYearDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Salary(), "R20000")) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Save1())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.NewWorkHistory())) {
            return false;
        }
        if (!SeleniumDriverInstance.EnterTextByXpath(Main_Object.JobTitle2(), "Welder")) {
            return false;
        }
        if (!SeleniumDriverInstance.EnterTextByXpath(Main_Object.CompanyName2(), "Company Y")) {
            return false;
        }
        if (!SeleniumDriverInstance.EnterTextByXpath(Main_Object.WorkLocation2(), "Cape Town")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.WorkSectorDropV2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.WorkSectorDrop1V2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ContractTypeDropV2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ContractTypeDrop1V2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.StartMonthDropV2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.StartMonthDrop1V2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.StartYearDropV2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.StartYearDrop1V2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EndMonthDropV2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EndMonthDrop1V2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EndYearDropV2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EndYearDrop1V2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SalaryV2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Save1V2())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.HistoryNext())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);
        return true;


    }
}
