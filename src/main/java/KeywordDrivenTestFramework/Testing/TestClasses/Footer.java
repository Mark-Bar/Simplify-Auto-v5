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

public class Footer extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public Footer(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!Footer()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean Footer(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FooterTerms())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AboutUs())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FooterContactUs())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AdvertiseWithUS())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.News24())) {
            return false;
        }
        try {
            Thread.sleep(10000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.OLX())) {
            return false;
        }
        try {
            Thread.sleep(10000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Property24())) {
            return false;
        }
        try {
            Thread.sleep(20000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AppDown())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FAQ())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Mobile())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.RecDirectory())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SiteMap())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Testimonials())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Widgets())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FollowTwitter())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FollowFacebook())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FollowGoogle())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FollowLinkedIn())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FollowInsta())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);


        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.FooterLocationDrop())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Footer Test SA Completed", false);






        return true;



    }
}

