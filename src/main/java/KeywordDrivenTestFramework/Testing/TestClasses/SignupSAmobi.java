package KeywordDrivenTestFramework.Testing.TestClasses;

/**
 * Created by Mark.Barfoot on 2016-10-26.
 */
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import KeywordDrivenTestFramework.Utilities.GenerateID;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SignupSAmobi extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public SignupSAmobi(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!SignupSAmobi()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }


public boolean SignupSAmobi() {

    Date time = new Date();
    String newTime =  new SimpleDateFormat("HH:mm:ss").format(time);

    Date date = new Date();
    String newDate =  new SimpleDateFormat("yyMMddHHmmss").format(date);


    if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAmobiUrl())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersSAmobiEmail(), "marky" + newDate +"@mailinator.com")) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersSAmobiPass(), "1234")) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiStartMonth())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiStartMonth1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiStartYear())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiStartYear1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiSignUp())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersSAmobiFirstName(), "Mark")) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersSAmobiLastName(), "Superman")) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersSAmobiTelephone(), "123456789")) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersSAmobiID(), "8011265246180")) {
        return false;
    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiDOBdayDrop())) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiDOBdayDrop1())) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiDOBmonthDrop())) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiDOBmonthDrop1())) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiDOByearDrop())) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiDOByearDrop1())) {
//        return false;
//    }
    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.CareersSAmobiGender(), true)) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiRaceDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiRaceDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiLocationDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiLocationDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiEduDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiEduDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiNext())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersSAmobiJobTitle(), "Developer")) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersSAmobiCompany(), "Company X")) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersSAmobiCity(), "Cape Town")) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiSectorDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiSectorDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiContractDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiContractDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiStartMonthDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiStartMonthDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiStartYearDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiStartYearDrop1())) {
        return false;
    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiEndMonthDrop1())) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiEndYearDrop())) {
//        return false;
//    }
//    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiEndYearDrop1())) {
//        return false;
//    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersSAmobiSalary(), "20000")) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiNext1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiNext2())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersSAmobiInstitute(), "School")) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersSAmobiQualification(), "Epic Winner")) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiYearCompleteDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiYearCompleteDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersSAmobiNextLast())) {
        return false;
    }

    SeleniumDriverInstance.takeScreenShot("Test", false);


        return true;
  }
}
