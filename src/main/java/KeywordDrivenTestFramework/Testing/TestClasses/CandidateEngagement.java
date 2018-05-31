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

public class CandidateEngagement extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public CandidateEngagement(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!CandidateEngagement()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean CandidateEngagement(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CandidateEngagementUrl())) {
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("Navigate to CE", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalRegCandidatesZA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TotalRegCandidatesZA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalCompletedProfilesZA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TotalCompletedProfilesZA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalRegCandidatesNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TotalRegCandidatesNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalCompletedProfilesNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TotalCompletedProfilesNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalRegCandidatesKE())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TotalRegCandidatesKE Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalCompletedProfilesKE())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TotalCompletedProfilesKE Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.RealTimeSessionWebZA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("RealTimeSessionWebZA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.RealTimeSessionsMobiZA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("RealTimeSessionsMobiZA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalSessionsAppZA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TotalSessionsAppZA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.RealTimeSessionsWebNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("RealTimeSessionsWebNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.RealTimeSessionsMobiNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("RealTimeSessionsMobiNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalSessionsAppNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TotalSessionsAppNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.CandidateRegSAGraph())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("CandidateRegSAGraph Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.CandidateRegNGGraph())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("CandidateRegNGGraph Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.JobApplicationsSAGraph())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("JobApplicationsSAGraph Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.SessionsSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("SessionsSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.SessionsNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("SessionsNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TimeOnSiteMinutesSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TimeOnSiteMinutesSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TimeOnSiteMinutesNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TimeOnSiteMinutesNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.PageViewsSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("PageViewsSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.PageViewsNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("PageViewsNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.PageViewsPerSessionSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("PageViewsPerSessionSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.PageViewsPerSessionNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("PageViewsPerSessionNG Exists", false);

        SeleniumDriverInstance.takeScreenShot("CANDIDATE ENGAGEMENT PASS", false);



        return true;



    }
}