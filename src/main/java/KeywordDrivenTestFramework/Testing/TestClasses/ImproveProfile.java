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

public class ImproveProfile extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public ImproveProfile(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!ImproveProfile()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean ImproveProfile(){



//        if (!SeleniumDriverInstance.waitForElementByXpath(Main_Object.Login())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.Login())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Email(), "marktestman100@mailinator.com")) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Password(), "1234")) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LoginButton())) {
//            return false;
//        }
//        SeleniumDriverInstance.takeScreenShot("Test", false);
//
//        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.navigateTo(Main_Object.ProfileLinURL())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ProfileImproveLink())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ImprovementJobTitle(), "Job Title")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ImprovementCompany(), "Comp1234")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ImprovementLocation(), "Cape Town")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementSectorDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementSectorDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementContractDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementContractDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ImprovementDuties(), "These are my duties")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementStartMonthDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementStartMonthDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementStartYearDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementStartYearDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementEndMonthDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementEndMonthDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementEndYearDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementEndYearDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ImprovementSalary(), "20000")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ImprovementLeaving(), "20000")) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);


        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementSave1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementQualificationLevelDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementQualificationLevelDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ImprovementQualification(), "Another winner")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ImprovementInstitution(), "My House")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementYearCompleteDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementYearCompleteDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ImprovementMajors(), "The Winner")) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovementSave2())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ImproveSkill(), "The Winner")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImproveLevelDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImproveLevelDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImproveExperienceDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImproveExperienceDrop1())) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot("Test", false);


        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImproveSave3())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImproveCoverSkip())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ImproveDesiredJob(), "Tester")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImproveJobType())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImproveDesiredSalaryMin())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImproveDesiredSalaryMax())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImproveDesiredSalaryTimesDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImproveDesiredSalaryTimesDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImproveSave4())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ImprovePhotoFinish())) {
            return false;
        }


        SeleniumDriverInstance.takeScreenShot("Test", false);

      return true;
    }
}
