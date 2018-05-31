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

public class ATSloginPage extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public ATSloginPage(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!ATSloginPage()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean ATSloginPage(){


        if (!SeleniumDriverInstance.navigateTo(Main_Object.SimplifyLoginUrl())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Login page PASS", false);

        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SimplifyLoginEmail(), "mark.barfoot@media24.com")) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("PASS", false);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.SimplifyLoginPassword(), "Andr3w@100")) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("PASS", false);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SimplifyLoginBtn())) {
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("PASS", false);
        return true;
        }
}

