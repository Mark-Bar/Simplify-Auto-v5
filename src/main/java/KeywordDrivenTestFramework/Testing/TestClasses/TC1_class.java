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
public class TC1_class extends BaseClass {

    TestEntity testData;
    int counter = 1;
    public TC1_class(TestEntity testData) {
        this.testData = testData;

    }
    public TestResult executeTest() {

        this.setStartTime();
        if (!OpenCareers24SAWebSite()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Careers", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Careers", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Careers MARK IS GHHEEIIIIIII", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    //navigate to careers24
    public boolean OpenCareers24SAWebSite() {
        if (!SeleniumDriverInstance.navigateTo(Main_Object.NavigateToCareers24SAUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverUtility.Driver.getTitle().equals(Main_Object.PageTitle)) {
            return false;
        }

        return true;
    }
}
