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

/**
 *
 * @author Abongile Bonga Maso
 */
public class TC2_class extends BaseClass {

    TestEntity testData;
    int counter = 1;
    int extCounter = 1;

    public TC2_class(TestEntity testData) {
        this.testData = testData;

    }

    public TC2_class() {

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!CloseNewLetter()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to close newsletter", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, " Failed to close new letter", this.getTotalExecutionTime());
        }

        if (!SelectCategory()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Scheduler Downloads page", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, " Failed tonavigate to Scheduler Downloads page", this.getTotalExecutionTime());
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully add item to cart", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean CloseNewLetter() {
        if (!browserType.equals(browserType.IE)) {
            if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CloseNewLetter())) {
                return false;
            }
        }
        return true;
    }

    public boolean SelectCategory() {
        //close new letter 

        //2. Select category = New  
        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.ParentMenuNewXpath())) {
            if (!SeleniumDriverInstance.moveToElementByXpath(Main_Object.ParentMenuNewXpath())) {
                return false;
            }

        } else {
            return false;
        }
        //3. Select sub category = Clothing
        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.SubCatergoryClothingXpath())) {
            if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SubCatergoryClothingXpath())) {
                return false;
            }
        }
        //4. Select sub sub category = Activewear
        //SeleniumDriverInstance.pause(2000);
        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.ActiveWearXpath())) {
            if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ActiveWearXpath())) {
                return false;
            }
        }
        //5. Select sub sub sub category = Bags & Accessories
        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.FoortwearXpath())) {
            if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FoortwearXpath())) {
                return false;
            }
        }
        SeleniumDriverInstance.takeScreenShot(counter + "Footwear", false);
        //6. Click on Quilted Casual Duffel Bag Grey
        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.CasualSneaker())) {
            if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CasualSneaker())) {
                return false;
            }
        }

        String CartValue1 = SeleniumDriverInstance.retrieveTextByXpath(Main_Object.CartValueXpath());
        if (!CartValue1.isEmpty()) {
            testData.extractParameter("Extracted Cart Value Befoare Add Item:", "Expected results " + CartValue1 + "", "PASS");
        } else {
            testData.extractParameter("Extracted Cart Value :", "Expected results " + CartValue1 + "", "FAIL");

            return false;
        }
        //7. Click the Add to Cart button
        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.AddToCartButtonXpath())) {
            if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SizeXpath())) {
                return false;
            }
            if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddToCartButtonXpath())) {
                return false;
            }
        }

        SeleniumDriverInstance.pause(3000);
        String CartValue2 = SeleniumDriverInstance.retrieveTextByXpath(Main_Object.CartValueXpath());
        if (CartValue2.equals(CartValue1)) {          
            testData.extractParameter(extCounter + "Extracted Cart Value :", "Expected results " + CartValue2 + "", "FAIL");
            extCounter++;            
            SeleniumDriverInstance.takeScreenShot("Failed to add item to cart", true);
            return false;
        } else {
            testData.extractParameter(extCounter + "Extracted Cart Value after Add Item:", "Expected results " + CartValue2 + "", "PASS");
            testData.extractParameter("Successfully ", "select Item selected be added to the Cart", "PASS");            
            SeleniumDriverInstance.takeScreenShot("Successfully add item to cart", false);
            extCounter++;
        }
        return true;
    }
}
