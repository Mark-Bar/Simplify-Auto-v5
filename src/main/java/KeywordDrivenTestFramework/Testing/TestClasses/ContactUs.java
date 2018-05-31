package KeywordDrivenTestFramework.Testing.TestClasses;
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
/**
 * Created by Mark.Barfoot on 2016-10-25.
 */

public class ContactUs extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public ContactUs(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!ContactUs()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to submit to contact us", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to submit to contact us", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully submitted to contact us", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }


    public boolean ContactUs() {

        if (!SeleniumDriverInstance.navigateTo(Main_Object.ContactUsUrl())){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ContactUsName(), "QA Tester")){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ContactUsEmail(), "marktester@mailinator.com")){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ContactUsNumber(), "123456789")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ContactUsReasonDrop())){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ContactUsReasonDrop1())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ContactUsMessage(), "This is an automated test to check that our contact form is working correctly")){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ContactUsSend())){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        return true;
    }
}