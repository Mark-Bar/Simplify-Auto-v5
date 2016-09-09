/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Testing.TestClasses;

import KeywordDrivenTestFramework.Core.BaseClass;

import static KeywordDrivenTestFramework.Entities.Enums.ResultStatus.*;

import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Abongile Bonga Maso
 */
public class TC3_class extends BaseClass {

    TestEntity testData;
    int counter = 1;
    int extractCounter = 1;

    public TC3_class(TestEntity testData) {
        this.testData = testData;

    }

    public TC3_class() {
    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!CartLinkHeader()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to View cart", true);
            counter++;
            return new TestResult(testData, FAIL, "Failed to View cart", this.getTotalExecutionTime());
        }
        return new TestResult(testData, PASS, "Successfully View cart", this.getTotalExecutionTime());
    }

    public boolean CartLinkHeader() {
        //2. Click on the Cart link in the header
        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.CartLinkHeader())) {
            // User is navigated to the cart page
            if (!SeleniumDriverInstance.moveToElementByXpath(Main_Object.CartLinkHeader())) {
                return true;
            }
            //1. Click on VIEW CART
            if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CartLinkHeader())) {
                return true;
            }
        } else {
            return false;
        }
        //   String timeStamp = SeleniumDriverInstance.generateDateTimeStampValue();

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar cal = Calendar.getInstance();
        String TimeStamp = dateFormat.format(cal.getTime());
        SeleniumDriverInstance.pause(3000);
        //2. Populate First Name Field = John
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CustomerNameXpath(), "Test" + TimeStamp)) 
        {
            return true;
        }
       
        //3. Populate Last Name Field = Doe
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CustomerSurnameXpath(), "Heroes" + TimeStamp))
        {
            return true;
        }
        //4. Populate email field = john@testheroes.co.za
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CutomerEmailXpath(), "heroes" + TimeStamp + "@testheroes.co.za")) 
        {
            return true;
        }

        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.DateOfBirthXpath(1))) {
            if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.DateOfBirthXpath(1), "10")) {
                return false;
            }
            if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.DateOfBirthXpath(2), "04")) {
                return false;
            }
            if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.DateOfBirthXpath(3), "1972")) {
                return false;
            }
        }
        //Gender radio button 
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.GenderMaleRadioButtonXpath())) {
            return true;
        }
        //enter password and confirm textbox 
        if (SeleniumDriverInstance.enterTextByXpath(Main_Object.PasswordTextboxXpath(), "testing123")) {
            if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ConfirmPasswordTextBoxXpath(), "testing123")) {
                return true;
            }
        } else {
            return false;
        }
        //9. Select All button 
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AllCheckBoxXpath())) {
            return true;
        }
        SeleniumDriverInstance.takeScreenShot("Registration form", false);
        //10. Click on Register
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.RegsterCustomerXpath())) {
            return true;
        }
        SeleniumDriverInstance.pause(1000);
        String NewUser = SeleniumDriverInstance.retrieveTextByXpath(Main_Object.NewUserXpath());

        if (!NewUser.isEmpty()) {
            testData.extractParameter("New Registered User Name:", "Extracted:" + NewUser + "", "PASS");
        } else {
            testData.extractParameter("New Registered User Name:", "Extracted:" + NewUser + "", "FAIL");
            return false;
        }
        SeleniumDriverInstance.pause(1000);
        return true;
    }

    public void GenerateTimeStamp(String cal1) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal1 = dateFormat.format(cal.getTime());
    }

}
