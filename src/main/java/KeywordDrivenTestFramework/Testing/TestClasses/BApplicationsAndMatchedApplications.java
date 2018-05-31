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

public class BApplicationsAndMatchedApplications extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public BApplicationsAndMatchedApplications(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!ApplicationsAndMatchedApplications()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean ApplicationsAndMatchedApplications(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.ApplicationsAndMatchedApplicationUrl())) {
            return false;
        }
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        SeleniumDriverInstance.takeScreenShot("Navigate to AMA", false);

        return true;



    }
}
