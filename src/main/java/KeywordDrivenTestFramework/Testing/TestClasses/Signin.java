package KeywordDrivenTestFramework.Testing.TestClasses;
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;

/**
 * Created by Mark.Barfoot on 2016-10-10.
 */
public class Signin extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public Signin(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!SignIn()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

public boolean SignIn() {
    if (!SeleniumDriverInstance.waitForElementByXpath(Main_Object.Login())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Login())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Email(), "barfootmark@yahoo.co.uk")) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Password(), "1234")) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LoginButton())) {
        return false;
    }
    SeleniumDriverInstance.takeScreenShot("Test", false);
    return true;
    }
}
