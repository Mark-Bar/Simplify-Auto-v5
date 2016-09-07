/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Testing.TestClasses;

import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abongile Bonga Maso
 */
public class TC5_Test extends BaseClass {

    TestEntity testData;
    int counter = 1;
    int extractCounter = 1;
    List<String> FieldName = new ArrayList<>();
    List<String> CardField = new ArrayList<>();
    List<String> ExpireDateField = new ArrayList<>();

    public TC5_Test(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!ValidateOrder()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to validate Order", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to validate Oder", this.getTotalExecutionTime());//, SeleniumDriverInstance.errorScreenshotPath);
        }

        //SeleniumDriverInstance.pause(200
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully validate the oder history", this.getTotalExecutionTime());//, SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean ValidateOrder() {
        //mouse hover over new user
        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.NewUserXpath())) {
            if (!SeleniumDriverInstance.moveToElementByXpath(Main_Object.NewUserXpath())) {
                return false;
            }
            //click my oders xpath
            if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.MyOrdersXpath())) {
                if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.MyOrdersXpath())) {
                    return false;
                }

            } else {
                return false;
            }
        } else {
            return false;
        }
        for (int i = 1; i < 5; i++) {
            String OrderHeader = SeleniumDriverInstance.retrieveTextByXpath(Main_Object.OrderHeadingXpath(i));
            String OrderContent = SeleniumDriverInstance.retrieveTextByXpath(Main_Object.OrderContent(i));
            if (!OrderHeader.isEmpty()) {
                testData.extractParameter(OrderHeader, OrderContent, "PASS");
                SeleniumDriverInstance.takeScreenShot("Successfully display Order History", false);
            } else {
                testData.extractParameter(OrderHeader, OrderContent, "FAIL");
                SeleniumDriverInstance.takeScreenShot("failed to display Order History", true);
                return false;
            }
        }

        return true;
    }

}
