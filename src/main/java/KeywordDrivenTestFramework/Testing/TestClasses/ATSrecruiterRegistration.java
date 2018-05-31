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

public class ATSrecruiterRegistration extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public ATSrecruiterRegistration(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!ATSrecruiterRegistration()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean ATSrecruiterRegistration(){

        Date time = new Date();
        String newTime =  new SimpleDateFormat("HH:mm:ss").format(time);

        Date date = new Date();
        String newDate =  new SimpleDateFormat("yyMMddHHmmss").format(date);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.SimplifyRegUrl())) {
            return false;
        }
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SimplifyRegFirstName(), "mark")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SimplifyRegLastName(), "mark")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SimplifyRegCompanyEmail(), "MarkAtsMaster" + newDate + "@ats.com")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SimplifyRegPassword(), "Andr3w100")) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SimplifyRegNowButton())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SimplifyCompanyName(), "Company" + newDate)) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SimplifyCompanyWeb(), "http://www.company" + newDate +".com")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SimplifyTel(), "1234567890")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SimplifyCompanyIndustryDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SimplifyCompanyIndustryDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SimplifyEmployeesDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SimplifyEmployeesDrop1())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SimplifyGetStartedBtn())) {
            return false;
        }
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);

        return true;



    }
}
