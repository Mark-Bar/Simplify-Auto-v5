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

public class CandidatesPage extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public CandidatesPage(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!CandidatesPage()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean CandidatesPage(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CandidatePageUrl())) {
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("Navigate to CP", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FilterActiveDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FilterActiveDrop1())) {
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("FilterActiveDrop Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FilterSearchBtn())) {
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("FilterSearchBtn Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FilterPage2())) {
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("FilterPage2 Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ViewApplicationsBtn())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("ViewApplicationsBtn Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CandidatePageUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Navigate to CP", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EditCandidateBtn())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("EditCandidateBtn Test", false);

        return true;



    }
}

