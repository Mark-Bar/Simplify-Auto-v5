package KeywordDrivenTestFramework.Testing.TestClasses;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Abongile Bonga Maso 
 */
public class TC7_class extends BaseClass {

    TestEntity testData;
    int counter = 1;
    int extractCounter = 1;
    List<String> FieldName = new ArrayList<>();
    List<String> CardField = new ArrayList<>();
    List<String> ExpireDateField = new ArrayList<>();

    public TC7_class(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!SnapScan()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to View cart", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to View cart", this.getTotalExecutionTime());//, SeleniumDriverInstance.errorScreenshotPath);
        }
        //SeleniumDriverInstance.pause(2000);
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully View cart", this.getTotalExecutionTime());//, SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean SnapScan() {
        TC2_class TestCase2 = new TC2_class();
        if (!TestCase2.SelectCategory()) {
            return false;
        }
        TC3_class TestCase3 = new TC3_class();
        if (!TestCase3.CartLinkHeader()) {
            return false;
        }
        if (!SeleniumDriverInstance.waitForElementByXpath(Main_Object.SnapScanXpath())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SnapScanXpath())) {
            return false;
        }
        if (!SeleniumDriverInstance.waitForElementByXpath(Main_Object.SelectSnaooScanXpath())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SelectSnaooScanXpath())) {
            return false;
        }
        if (!SeleniumDriverInstance.waitForElementByXpath(Main_Object.PlaceOrderNowXpath())) {
            return false;
        }
        return SeleniumDriverInstance.clickElementbyXpath(Main_Object.PlaceOrderNowXpath());

    }
}
