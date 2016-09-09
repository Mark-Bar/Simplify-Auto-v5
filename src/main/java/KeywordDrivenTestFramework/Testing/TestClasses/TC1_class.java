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
        if (!OpenSpreeWebSite()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Spree", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Spree", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Spree", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    //navigate to spree
    public boolean OpenSpreeWebSite() {
        if (!SeleniumDriverInstance.navigateTo(Main_Object.NavigateToSpreeUrl())) {
            return true;
        }
        if (!browserType.equals(Enums.BrowserType.IE)) {
            //waite for news letter pop.
            if (!SeleniumDriverInstance.waitForElementByXpath(Main_Object.NewsletterImage())) {
                return false;
            }
        }
        SeleniumDriverInstance.takeScreenShot("Successfully navigate to Spree", false);
        return true;
    }
}
