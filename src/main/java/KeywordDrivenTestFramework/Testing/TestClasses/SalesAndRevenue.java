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

public class SalesAndRevenue extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public SalesAndRevenue(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!SalesAndRevenue()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean SalesAndRevenue(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.SalesAndRevenueUrl())) {
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("Navigate to SAR", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.SFliter())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("SFliter Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.NewContractTarget())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("NewContractTarget Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AdHocSales())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AdHocSales Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.ChurnRate())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("ChurnRate Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.NetAddClients())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("NetAddClients Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.SalesTeam())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("SalesTeam Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.NewContractValueMonth())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("NewContractValueMonth Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.NewContractValueAccumulated())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("NewContractValueAccumulated Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.NewContractsMonth())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("NewContractsMonth Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.NewContractsAccumulated())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("NewContractsAccumulated Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AverageContractDurationMonth())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AverageContractDurationMonth Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.AverageContractValueMonth())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("AverageContractValueMonth Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.Revenue())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Revenue Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.OperatingResult())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("OperatingResult Exists", false);

        SeleniumDriverInstance.takeScreenShot("TEST PASSED", false);







        return true;



    }
}

