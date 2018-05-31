package KeywordDrivenTestFramework.Testing.TestClasses;

/**
 * Created by Mark.Barfoot on 2016-10-25.
 */
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import org.openqa.selenium.Keys;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ATScandidateFunctions extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public ATScandidateFunctions(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!ATScandidateFunctions()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean ATScandidateFunctions() {

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CandidateDashURL())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CandidateSelect())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.VacancyAssignClick())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.VacancyAssignSelect())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.VacancyAssignSubmitBtn())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddTag())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.InputTags(), "Tag 1")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterPressTags()) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddTag())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.InputTags(), "Tag 2")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterPressTags()) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddTag())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.InputTags(), "Tag 3")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterPressTags()) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddSkill())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.EnterSkill(), "Skill 4")) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterPressSkills()) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddSkill())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.EnterSkill(), "Skill 5")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterPressSkills()) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddSkill())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.EnterSkill(), "Skill 6")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterPressSkills()) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CandidateEditBtn())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.HeadlineClick())) {
//            return false;
//        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByTmce()) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SummaryClick())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByTmce()) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CoverNoteClick())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByTmce()) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.DetailsFirstName(), "Johnny")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.DetailsLastName(), "Doey")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.DetailsEmail(), "")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.DetailsCurrentJobTitle(), "Winner")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.DetailsProvince(), "Western Cape")) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.DetailsCity(), "Cape Town")) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.DetailsPhone(), "0123456789")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DetailsEthnicityDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DetailsEthnicityDrop1())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DetailsGenderDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DetailsGenderDrop1())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DetailsSaveBtn())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CandidateExperienceTab())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddExperienceBtn())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddExperienceJobTitle(), "Winner")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddExperienceCompany(), "Win Inc")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddExperienceStartDate(), "01 Jan 2017")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddExperienceEndDate(), "01 Jan 2018")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.AddExperienceSummary(), "This is my Summary test")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddExperienceSaveBtn())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ResumeTab())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.QuestionnaireTab())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SelectQuestionnaireDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SelectQuestionnaireDrop1())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SendQuestionnaireBtn())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.CreateNewQuestionnaire())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.QuestionnaireName(), "Hello World")) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.Question(), "Hello World Q1")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.QuestionTypeDrop())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.QuestionTypeDropMultiChoice())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.QuestionChoiceOption1(), "Hello World Q1 Choice1")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddOption())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.QuestionChoiceOption2(), "Hello World Q1 Choice2")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddOption())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.QuestionChoiceOption3(), "Hello World Q1 Choice3")) {
            return false;
        }
            SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SaveQuestionnaire())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.DocumentsTab())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.TimeLineTab())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EmailCandidateBtn())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.EmailBody(), "This is a test email to a candidate generated through test automation")) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SendEmailBtn())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.NotesTab())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.NoteDetails(), "This is a test note generated through test automation")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.AddNoteBtn())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EvaluationTab())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SubmitEvaluationBtn())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.EvaluationDetails(), "This is a test evaluation generated through test automation")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.EvaluationRatingExcellent())) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SaveEvaluationBtn())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReferencesTab())) {
            return false;
        }
        SeleniumDriverInstance.pause(2000);
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReferencesFullName(), "Dude Rude")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReferencesEmail(), "dude@email.com")) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReferencesPhone(), "021123456789")) {
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReferencesProfessional())) {
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReferencesOccupation(), "CEO")) {
            return false;
        }
//        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReferencesCompany(), "Company X")) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SendRequest())) {
//            return false;
//        }
//        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.LocateCandidateFunctionBar())) {
//            return false;
//        }


        SeleniumDriverInstance.pause(10000);


        return true;

    }


}