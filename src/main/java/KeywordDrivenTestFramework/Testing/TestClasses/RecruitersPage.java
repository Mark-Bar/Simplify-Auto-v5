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

public class RecruitersPage extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public RecruitersPage(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!RecruitersPage()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean RecruitersPage(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.RecruitersPageUrl())) {
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("RecruitersPageUrl", false);







        return true;



    }
}