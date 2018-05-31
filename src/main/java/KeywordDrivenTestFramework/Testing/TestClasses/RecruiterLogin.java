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

public class RecruiterLogin extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public RecruiterLogin(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!RecruiterLogin()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean RecruiterLogin(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("CareersSAwebUrl", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LogIn())){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("LogIn Test", false);

        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.LoginRecEmail(), "test@recruiter.com")){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot(" LoginRecEmail Test", false);

        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.LoginRecPassword(), "BeatsPnet")){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot(" LoginRecPassword Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LoginRecBtn())){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("LoginRecBtn Test", false);

        SeleniumDriverInstance.takeScreenShot("RecruiterLogin PASS", false);
        return true;



    }
}