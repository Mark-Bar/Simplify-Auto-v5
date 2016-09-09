///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package KeywordDrivenTestFramework.Testing.KeywordDrivenTestFramework.Testing.TestClasses;
//
//import KeywordDrivenTestFramework.Core.BaseClass;
//import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
//import KeywordDrivenTestFramework.Entities.Enums;
//import KeywordDrivenTestFramework.Entities.TestEntity;
//import KeywordDrivenTestFramework.Entities.TestResult;
//import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author Abongile Bonga Maso
// */
//public class TC6_class extends BaseClass {
//
//    TestEntity testData;
//    int counter = 1;
//    int extractCounter = 1;
//    List<String> FieldName = new ArrayList<>();
//    List<String> CardField = new ArrayList<>();
//    List<String> ExpireDateField = new ArrayList<>();
//
//    public TC6_class(TestEntity testData) {
//        this.testData = testData;
//
//    }
//
//    public TestResult executeTest() {
//
//        this.setStartTime();
//        if (!logoutPage()) {
//            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to logout", true);
//            counter++;
//            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to logout", this.getTotalExecutionTime());//, SeleniumDriverInstance.errorScreenshotPath);
//        }
//        if (!ValidateEmptyFields()) {
//            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to login page", true);
//            counter++;
//            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed Login Pge", this.getTotalExecutionTime());//, SeleniumDriverInstance.errorScreenshotPath);
//        }
//
//        //SeleniumDriverInstance.pause(200
//        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully Denied Access", this.getTotalExecutionTime());//, SeleniumDriverInstance.errorScreenshotPath);
//    }
//
//    public boolean logoutPage() {
//        //mouse hover over new user
//        if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.NewUserXpath())) {
//            if (!SeleniumDriverInstance.moveToElementByXpath(Main_Object.NewUserXpath())) {
//                return false;
//            }
//            //click my oders xpath
//            if (SeleniumDriverInstance.waitForElementByXpath(Main_Object.LogoutXpath())) {
//                if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LogoutXpath())) {
//                    return false;
//                }
//
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//        }
//        SeleniumDriverInstance.takeScreenShot("Successfully logout as Registered User", false);
//        return true;
//    }
//
//    public boolean ValidateEmptyFields() {
//        
//        SeleniumDriverInstance.takeScreenShot("Successfully landed to login page", false);
//
//        //click login button lto retrive message 
////        if (!SeleniumDriverInstance.clickElementByXpath(Main_Object.LoginButtonXpath())) {
////            return false;
////        }
////        String emailMessage = SeleniumDriverInstance.retrieveTextByXpath(Main_Object.EmailMessage());
////        String passwordfields = SeleniumDriverInstance.retrieveTextByXpath(Main_Object.passwordMessage());
////        if (!emailMessage.isEmpty() && !passwordfields.isEmpty()) {
////            testData.extractParameter("Empty email textbox field message ", emailMessage, "PASS");
////            testData.extractParameter("Empty password textbox field message ", passwordfields, "PASS");
////        } else {
////            testData.extractParameter("Empty email textbox field message ", emailMessage, "FAIL");
////            testData.extractParameter("Empty password textbox field message ", passwordfields, "FAIL");
////        }
//        return true;
//    }
//
//}
