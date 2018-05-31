package KeywordDrivenTestFramework.Testing.TestClasses;

/**
 * Created by Mark.Barfoot on 2016-10-25.
 */
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import KeywordDrivenTestFramework.Utilities.GenerateID;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mark.Barfoot on 2016-10-04.
 */
public class SignupNGweb extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public SignupNGweb(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!SignUpNGweb()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean SignUpNGweb() {

        Date time = new Date();
        String newTime =  new SimpleDateFormat("HH:mm:ss").format(time);

        Date date = new Date();
        String newDate =  new SimpleDateFormat("yyMMddHHmmss").format(date);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersNGUrl())) {
            return false;
        }
        if (!SeleniumDriverInstance.waitForElementByXpath(Main_Object.CareersNGSignup())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGSignup())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersNGemail(), "markthespark" + newDate +"@mailinator.com")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersNGpass(), "1234")) {
            return false;
        }
        if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.CareersNGexp(), true)) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGmonthDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGmonthDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGyearDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGyearDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGnext1())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersNGfirstName(), "Mark")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersNGlastName(), "Batman")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersNGnumber(), "123456789")) {
            return false;
        }
//        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Id(), "8011265246180")) {
//            return false;
//        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGdobDayDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGdobDayDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGdobMonthDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGdobMonthDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGdobYearDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGdobYearDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.CareersNGgender(), true)) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGraceDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGraceDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGlocationDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGlocationDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGeducationDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGeducationDrop1())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGnext2())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersNGjobTitle(), "Accountant")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersNGcompany(), "Company X")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersNGcity(), "Cape Town")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGsectorDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGsectorDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGcontractDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGcontractDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGstartMonthDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGstartMonthDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGstartYearDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGstartYearDrop1())) {
            return false;
        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGendMonthDrop())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGendMonthDrop1())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGendYearDrop())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGendYearDrop1())) {
//            return false;
//        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CareersNGsalary(), "20000")) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGnext3())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGaddWorkHistory())) {
            return false;
        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGWorkHere())) {
//            return false;
//        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGcompany2())) {
            return false;
        }
        if (!SeleniumDriverInstance.EnterTextByXpath(Main_Object.CareersNGcompany2(), "Company Y")) {
            return false;
        }
        if (!SeleniumDriverInstance.EnterTextByXpath(Main_Object.CareersNGcity2(), "Cape Town")) {
            return false;
        }
        if (!SeleniumDriverInstance.EnterTextByXpath(Main_Object.CareersNGjobTitle2(), "Accountant")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGsectorDrop2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGsectorDrop12())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGcontractDrop2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGcontractDrop12())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGstartMonthDrop2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGstartMonthDrop12())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGstartYearDrop2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGstartYearDrop12())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGendMonthDrop2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGendMonthDrop12())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGendYearDrop2())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGendYearDrop12())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGsalary2())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGnext32())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CareersNGnext4())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

    return true;
    }
}



