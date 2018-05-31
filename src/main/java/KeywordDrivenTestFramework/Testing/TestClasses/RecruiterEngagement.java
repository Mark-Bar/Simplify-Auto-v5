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

public class RecruiterEngagement extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public RecruiterEngagement(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!RecruiterEngagement()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean RecruiterEngagement(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.RecruiterEngagementUrl())) {
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("Navigate to RE", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Filter())){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Filter Click", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalActiveRecruitersSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TotalActiveRecruitersSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalActiveRecruitersNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TotalActiveRecruitersNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalActivePayGSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TotalActivePayGSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalActivePayGNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("TotalActivePayGNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AverageJobsPostedSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AverageJobsPostedSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AverageCvDownloadSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AverageCvDownloadSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AverageJobsPostedSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AverageJobsPostedSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AverageJobsPostedNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AverageJobsPostedNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AverageCvDowloadNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AverageCvDowloadNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AverageApplicationsSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AverageApplicationsSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AverageJobsPostedSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AverageJobsPostedSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AverageClicksExternalJobsSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AverageClicksExternalJobsSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AverageApplicationsNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AverageApplicationsNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AverageClicksExternalJobsNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AverageClicksExternalJobsNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.CandidateSearchesGraphSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("CandidateSearchesGraphSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.CandidateSearchesGraphNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("CandidateSearchesGraphNG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.CvDownloadsGraphSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("CvDownloadsGraphSA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.CvDownloadsGraphNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("CvDownloadsGraphNG Exists", false);

        SeleniumDriverInstance.takeScreenShot("TEST PASSED", false);



        return true;



    }
}
