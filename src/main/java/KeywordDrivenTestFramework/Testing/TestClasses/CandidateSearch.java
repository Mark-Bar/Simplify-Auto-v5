package KeywordDrivenTestFramework.Testing.TestClasses;

/**
 * Created by Mark.Barfoot on 2016-10-25.
 */
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;

public class CandidateSearch extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public CandidateSearch(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!CandidateSearch()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean CandidateSearch(){

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersSAwebUrl())) {
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("CareersSAwebUrl", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LogIn())){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("LogIn Test", false);

        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.LoginRecEmail(), "test@recruiter.com")){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot(" LoginRecEmail Test", false);

        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.LoginRecPassword(), "BeatsPnet")){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot(" LoginRecPassword Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LoginRecBtn())){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("LoginRecBtn Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ModelClick())){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("ModelClick Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CandidateSearchNav())){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("CandidateSearchNav Test", false);

        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CurrentJobEntry1(), "Welder")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CurrentJobEntry2(), "Accountant")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CurrentJobEntry3(), "Developer")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CurrentJobEntry1(), "Manager")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CurrentJobEntry2(), "Personal Assistant")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CurrentJobEntry3(), "Writer")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CurrentJobEntry1(), "Plumber")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CurrentJobEntry2(), "Secretary")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CurrentJobEntry3(), "Lion tamer")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CurrentJobEntry1(), "Doctor")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CurrentJobEntry2(), "Helper")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.CurrentJobEntry3(), "Poet")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }

        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Keyword1(), "Keyword1")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Keyword2(), "Keyword2")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Keyword3(), "Keyword3")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Keyword1(), "Keyword4")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Keyword2(), "Keyword5")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Keyword3(), "Keyword6")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Keyword1(), "Keyword7")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Keyword2(), "Keyword8")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Keyword3(), "Keyword9")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Keyword1(), "Keyword10")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Keyword2(), "Keyword11")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Keyword3(), "Keyword12")){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ClickBlank())){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LocationDrop())){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LocationDrop1())){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LocationDrop())){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LocationDrop1())){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("CandidateSearchCurrent Test", false);

















        return true;



    }
}