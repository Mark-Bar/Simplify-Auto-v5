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

public class RecruiterApplicantsQuality extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public RecruiterApplicantsQuality(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!RecruiterApplicantsQuality()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean RecruiterApplicantsQuality(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAadminURL())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Navigate to Admin SA", false);

        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AdminLoginUserSA(), "admin@admin.com")) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Enter User Name", false);

        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AdminLoginPassSA(), "Password123")) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Enter Password", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AdminLoginButton())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Button Click", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.RecruiterApplicantsQuality())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Navigate to RAQ", false);



        return true;



    }
}
