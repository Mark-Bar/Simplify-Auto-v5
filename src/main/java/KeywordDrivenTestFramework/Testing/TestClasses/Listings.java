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

public class Listings extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public Listings(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!Listings()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - TEST FAILED", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean Listings(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.ListingUrl())) {
            return false;
        }
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        SeleniumDriverInstance.takeScreenShot("Navigate to Listings", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ListFilter())) {
            return false;
        }
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        SeleniumDriverInstance.takeScreenShot("Filter", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ByMonth())) {
            return false;
        }
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        SeleniumDriverInstance.takeScreenShot("Month Filter", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ByWeek())) {
            return false;
        }
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
//Listings: Element Exists Testing
        SeleniumDriverInstance.takeScreenShot("Week Filter", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalListingsBlock())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Total Listings SA Exists", false);
        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.NewListingSABlock())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("New Listings SA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalListingsNGBLock())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Total Listings NG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.NewListingsNGBlock())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("New Listings NG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.ComparativeListingsSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Comparative Listings SA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.ComparativeListingsNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Comparative Listings NG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalListingsSAGraph())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Total Listings Graph SA Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TotalListingsNGGraph())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Total Listings Graph NG Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.ListingsByTypeSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Listing by Type SA Graph Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.ListingByTypeNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Listing by Type NG Graph Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TopSectorsSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Top Sectors SA Graph Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TopSectorsNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Top Sectors NG Graph Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TopLocationsSA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Top Locations SA Graph Exists", false);

        if (!SeleniumDriverInstance.verifyElementAbsent(Main_Object.TopLocationsNG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Top Locations NG Graph Exists", false);

        SeleniumDriverInstance.takeScreenShot("LISTINGS PAGE PASS", false);


        return true;



    }
}
