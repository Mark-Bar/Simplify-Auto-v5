
package KeywordDrivenTestFramework.Testing.TestClasses;
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;

/**
 * Created by Mark.Barfoot on 2016-10-11.
 */
public class JobPosting extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public JobPosting(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!JobPost()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

public boolean JobPost() {

    if (!SeleniumDriverInstance.waitForElementByXpath(Main_Object.Login())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Login())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Email(), "test@recruiter.com")) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Password(), "BeatsPnet")) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LoginButton())) {
        return false;
    }
    if (!SeleniumDriverInstance.navigateTo(Main_Object.VancancyButtonNav())) {
        return false;
    }
    SeleniumDriverInstance.takeScreenShot("Test", false);


    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.JobAdTitle(), "New Job")) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.JobTypeTitle(), "accounting")) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.JobTypeSelect())) {
        return false;
    }
    SeleniumDriverInstance.takeScreenShot("Test", false);
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.JobAdTitle(), "New Job2")) {
        return false;
    }
    SeleniumDriverInstance.takeScreenShot("Test", false);

    return true;


    }
}
