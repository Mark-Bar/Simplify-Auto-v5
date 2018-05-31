
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

public class ShareThis extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public ShareThis(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!ShareThis()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean ShareThis(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.JobPageNavigate())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EmailShare())) {
            return false;
        }
//        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.EmailShareName(), "Mark")) {
//            return false;
//        }

        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.JobPageNavigate())) {
            return false;
        }

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FacebookShare())) {
            return false;
        }
        if (!SeleniumDriverInstance.navigateTo(Main_Object.FacebookLink())) {
            return false;
        }

        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.JobPageNavigate())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.TwitterShare())) {
            return false;
        }
        if (!SeleniumDriverInstance.navigateTo(Main_Object.TwitterShareLink())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.JobPageNavigate())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LinkedIn())) {
            return false;
        }
        if (!SeleniumDriverInstance.navigateTo(Main_Object.LinkedInLink())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareerAdviceShareNav())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersAdviceShareFaceBook())) {
            return false;
        }
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdviceShareFaceBookLink())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareerAdviceShareNav())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersAdviceShareTwitter())) {
            return false;
        }
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdviceShareTwitterLink())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareerAdviceShareNav())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersAdviceShareLinkedIn())) {
            return false;
        }
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdviceShareLinkedInLink())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareerAdviceShareNav())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersAdviceShareGoogle())) {
            return false;
        }
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdviceShareGoogleLink())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareerAdviceShareNav())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersAdviceShareEmail())) {
            return false;
        }

        try {
            Thread.sleep(1000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);


        return true;

    }
}