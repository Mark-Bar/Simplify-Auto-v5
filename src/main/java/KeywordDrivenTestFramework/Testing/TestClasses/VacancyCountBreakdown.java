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

public class VacancyCountBreakdown extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public VacancyCountBreakdown(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!VacancyCountBreakdown()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean VacancyCountBreakdown(){

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

        if (!SeleniumDriverInstance.navigateTo(Main_Object.VacancyCountNav())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Navigated to Report", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.OrderByLocation())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("OrderByLocation", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.OrderBySector())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("OrderBySector", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.OrderByCount())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("OrderByCount", false);



        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.OrderByURL())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("OrderByURL", false);

        return true;




    }
}