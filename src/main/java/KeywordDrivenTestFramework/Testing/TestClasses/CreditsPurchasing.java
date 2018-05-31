package KeywordDrivenTestFramework.Testing.TestClasses;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;


/**
 * Created by Mark.Barfoot on 2016-11-11.
 */
public class CreditsPurchasing extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public CreditsPurchasing(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!CreditPurchase()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean CreditPurchase(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersNGUrl())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        return true;
    }
}
