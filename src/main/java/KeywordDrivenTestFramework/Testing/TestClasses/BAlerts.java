package KeywordDrivenTestFramework.Testing.TestClasses;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;

import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import KeywordDrivenTestFramework.Utilities.SeleniumDriverUtility;

/**
 * Created by Mark.Barfoot on 2016-10-10.
 */
public class BAlerts extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public BAlerts(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!Alerts1()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

public boolean Alerts1() {
//    if (!SeleniumDriverInstance.waitForElementByXpath(Main_Object.Login())) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Login())) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Email(), "marktestman100@mailinator.com")) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Password(), "1234")) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LoginButton())) {
//        return false;
//    }
//    SeleniumDriverInstance.takeScreenShot("Test", false);

    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Al1())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AlertName1(), "Alert 1 Accounting")) {
        return false;
    }

    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AlertJobTitle(), "Accounting")) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AlertLocationDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AlertLocationDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AlertSector())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AlertSector1())) {
        return false;
    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AlertJobType())) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AlertJobType1())) {
//        return false;
//    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AlertSalary(), "R20000")) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AlertCompanyDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AlertCompanyDrop1())) {
        return false;
    }
    SeleniumDriverInstance.takeScreenShot("Test", false);

    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AlertSave())) {
        return false;
    }

    SeleniumDriverInstance.takeScreenShot("Test", false);

//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.NewAlert())) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LogOut())) {
//        return false;
//    }

//    SeleniumDriverInstance.takeScreenShot("Test", false);
    return true;
  }
}

