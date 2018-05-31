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

public class ATSaddCandidate extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public ATSaddCandidate(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!ATSaddCandidate()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean ATSaddCandidate() {

        Date date = new Date();
        String newDate =  new SimpleDateFormat("yyMMddHHmmss").format(date);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CandidateDashURL())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddCandidateDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddCandidateManually())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddCandidateFirstName(), "John" + newDate)) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddCandidateLastName(), "Myle" + newDate)) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddCandidateEmail(), "kylemyle" + newDate +"@mailinator.com")) {
            return false;
        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddCandidateCountryDrop())) {
//            return false;
//        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddCandidateProvince(), "Western Cape")) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddCandidateCity(), "Cape Town")) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddCandidateAddress(), "123 Street")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddCandidatePostCode(), "1234")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddCandidatePhone(), "1234567890")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddCandidateEthnicityDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddCandidateEthnicityDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddCandidateGenderDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddCandidateGenderDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByTmce()) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddCandidateSubmitBtn())) {
            return false;
        }

        SeleniumDriverInstance.pause(2000);
        return true;

    }


}
