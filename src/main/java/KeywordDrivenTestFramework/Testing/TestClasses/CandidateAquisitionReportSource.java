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

public class CandidateAquisitionReportSource extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public CandidateAquisitionReportSource(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult  executeTest() {

        this.setStartTime();
        if (!CandidateAquisitionReportSource()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean CandidateAquisitionReportSource(){

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

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CandidateAquisitionReportSourceUrl())) {
            return false;
        }


        SeleniumDriverInstance.takeScreenShot("Navigate to Candidate Aquisition Report By Source", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DateFrom())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SeeCandidates())) {
            return false;
        }
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CandidateAquisitionReportSourceUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Navigate to Candidate Aquisition Report By Source", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SourceDrillDown())) {
            return false;
        }
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CandidateAquisitionReportSourceUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Navigate to Candidate Aquisition Report By Source", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SectorDrillDown())) {
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