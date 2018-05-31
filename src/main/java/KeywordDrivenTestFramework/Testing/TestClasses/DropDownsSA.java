package KeywordDrivenTestFramework.Testing.TestClasses;

/**
 * Created by Mark.Barfoot on 2016-10-25.
 */
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DropDownsSA extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public DropDownsSA(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!DropDownsSA()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean DropDownsSA(){
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.HomeLocationDrop())) {
            return false;
        }

        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.HomeSearch(), "accounting")) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.JobsNav())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EngConstNav())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EngConstLocation())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EngConstLocation1())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FinanceNav())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FinanceLocation())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FinanceLocation1())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.HospitalityNav())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.HospitalityLocation())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.HospitalityLocation1())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.MarketMediaNav())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.MarketMedLocation())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.MarketMedLocation1())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.OfficeNav())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.OfficeLocation())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.OfficeLocation1())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.TechNav())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.TechLocation())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.TechLocation1())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.GraduationNav())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.GraduateLocation())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.GraduateLocation1())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

//        if (!SeleniumDriverInstance.navigateTo(Main_Object.GraduateSubNav())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.GraduateSublocationDrop())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.GraduateSubLocationDrop1())) {
//            return false;
//        }
//
//        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersNGMainUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.JobsNavNG())) {
            return false;
        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.HomeSearchNG())) {
//            return false;
//        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EngConstNavNG())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EngConstLocationNG())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EngConstLocation1NG())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FinanceNavNG())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FinanceLocationNG())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FinanceLocation1NG())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.MarketMediaNavNG())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.MarketMedLocationNG())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.MarketMedLocation1NG())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.OfficeNavNG())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.OfficeLocationNG())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.OfficeLocation1NG())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.TechNavNG())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.TechLocationNG())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.TechLocation1NG())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Drop Down Testing Passed", false);









        return true;



    }
}
