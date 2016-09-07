/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Testing.TestClasses;

import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import KeywordDrivenTestFramework.Entities.Enums;

import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author Abongile Bonga Maso
 */
public class TC4_Test extends BaseClass {

    TestEntity testData;
    int counter = 1;
    int extractCounter = 1;
    List<String> FieldName = new ArrayList<>();
    List<String> CardField = new ArrayList<>();
    List<String> ExpireDateField = new ArrayList<>();

    public TC4_Test() {
    }

    public TC4_Test(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!CheckoutNewRegisterUser()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to Checkout with Newly registered user", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to Checkout with Newly registered user", this.getTotalExecutionTime());//, SeleniumDriverInstance.errorScreenshotPath);
        }
        if (!paymentsMethod()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to place order", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to place order", this.getTotalExecutionTime());//, SeleniumDriverInstance.errorScreenshotPath);
        }
        //SeleniumDriverInstance.pause(2000);
        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully Checkout with Newly registered user", this.getTotalExecutionTime());//, SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean CheckoutNewRegisterUser() {
        //1. Click on CHECKOUT
        SeleniumDriverInstance.pause(1000);
        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.CheckOutButtonXpath())) {
            if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CheckOutButtonXpath())) {
                return false;
            }
        } else {
            return false;
        }
        //2. Click on PROCEED TO SECURE CHECKOUT
        //3. Click on ADD SHIPPING ADDRESS
        SeleniumDriverInstance.pause(5000);
        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.AddShippingAddressXpath())) {
            if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddShippingAddressXpath())) {
                return false;
            }
        } else {
            return false;
        }
        // SeleniumDriverInstance.pause(4000);
        for (int i = 1; i <= 4; i++) {
            FieldName.add(testData.getData("FieldName" + i));
        }
        for (int i = 1; i <= 3; i++) {

            if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FieldNameXpath(i))) {
                return false;
            }
            if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.FieldNameXpath(i), FieldName.get(i - 1))) {
                return false;
            }

        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.StreetAddressXpath(5))) {
            return false;
        }
        if (SeleniumDriverInstance.enterTextByXpath(Main_Object.StreetAddressXpath(5), testData.getData("FieldName4"))) {
            SeleniumDriverInstance.pause(2000);
            SeleniumDriverInstance.PressArrowDown();
            SeleniumDriverInstance.PressEnter();
            SeleniumDriverInstance.pause(3000);
        }
        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.SaveButtonXpath())) {
            if (!SeleniumDriverInstance.clickElementByXpath(Main_Object.SaveButtonXpath())) {
                return false;
            }
        } else {
            return false;
        }
        SeleniumDriverInstance.pause(
                500);
        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.DoorToDoorRadioButtonXpath())) {
            if (!SeleniumDriverInstance.clickElementByXpath(Main_Object.DoorToDoorRadioButtonXpath())) {
                return false;
            }
            SeleniumDriverInstance.scrollMouseWheelDownwards();
            if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.SelectPaymentMethodXppath())) {
                SeleniumDriverInstance.scrollToElement(Main_Object.SelectPaymentMethodXppath());
                if (!SeleniumDriverInstance.clickElementByXpath(Main_Object.SelectPaymentMethodXppath())) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    public boolean paymentsMethod() {

        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.ManualEFTXpath())) {
            if (!SeleniumDriverInstance.clickElementByXpath(Main_Object.ManualEFTXpath())) {
                return false;
            }
            if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.SelectManuelEft())) {
                if (!SeleniumDriverInstance.clickElementByXpath(Main_Object.SelectManuelEft())) {
                    return false;
                }
                SeleniumDriverInstance.pause(3000);
            } else {
                return false;
            }
        } else {
            return false;
        }

        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.PlaceOrderNowXpath())) {
            if (!SeleniumDriverInstance.clickElementByXpath(Main_Object.PlaceOrderNowXpath())) {
                return false;
            }
        } else {
            return false;
        }
        for (int i = 1; i <= 8; i++) {
            String ProofOfPayment = SeleniumDriverInstance.retrieveTextByXpath(Main_Object.ProofOfPaymentsHeaderXpath(i + 1));
            String OrderInfor = SeleniumDriverInstance.retrieveTextByXpath(Main_Object.ProofOfPaymentsContentXpath(i + 1));
            if (!ProofOfPayment.isEmpty()) {
                testData.extractParameter(ProofOfPayment, OrderInfor, "PASS");
                SeleniumDriverInstance.takeScreenShot("Succesefully display proof of payment ", false);
            } else {
                testData.extractParameter(ProofOfPayment, OrderInfor, "PASS");
                SeleniumDriverInstance.takeScreenShot("Succesefully display proof of payment ", true);
                return false;
            }

        }
        // SeleniumDriverInstance.pause(7000);
//        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.DebitCreditCardXpath())) {
//            if (!SeleniumDriverInstance.clickElementByXpath(Main_Object.DebitCreditCardXpath())) {
//                return false;
//            }
//        } else {
//            return false;
//        }
//        //Card Field 
//        for (int i = 1; i <= 4; i++) {
//            CardField.add(testData.getData("CardField" + i));
//            ExpireDateField.add(testData.getData("ExpireDate" + i));
//
//        }
//        for (int i = 1; i <= 3; i++) {
//
//            if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CardFieldXpath(i))) {
//                return false;
//            }
//            if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CardFieldXpath(i), CardField.get(i - 1))) {
//                return false;
//            }
//
//            if (i < 2) {
//                if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ExpireDateXpath())) {
//                    return false;
//                }
//                if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CardFieldExpireDate(i), ExpireDateField.get(i - 1))) {
//                    return false;
//                }
//            }
        // }

        SeleniumDriverInstance.pause(2000);

        return true;

    }
}
