/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Testing.TestClasses;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import KeywordDrivenTestFramework.Utilities.SeleniumDriverUtility;

/**
 *
 * @author Abongile Bonga Maso
 */
public class TC2_class extends BaseClass {

    TestEntity testData;
    int counter = 1;
    public TC2_class(TestEntity testData) {
        this.testData = testData;

    }
    public TestResult executeTest() {

        this.setStartTime();
        if (!OpenSimplify()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Careers", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Careers", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Careers MARK IS GHHEEIIIIIII", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    //navigate to careers24
    public boolean OpenSimplify() {
        if (!SeleniumDriverInstance.navigateTo(Main_Object.NavigateToSimplifyUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverUtility.Driver.getTitle().equals(Main_Object.PageTitle)) {
            return false;
        }

        return true;
    }
}
