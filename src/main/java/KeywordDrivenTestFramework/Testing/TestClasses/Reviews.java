package KeywordDrivenTestFramework.Testing.TestClasses;
import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
/**
 * Created by Mark.Barfoot on 2016-10-11.
 */
public class Reviews extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public Reviews(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!ReviewSubmit()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to submit a review", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to submit a review", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully submitted a review", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

public boolean ReviewSubmit() {

    if (!SeleniumDriverInstance.navigateTo(Main_Object.ReviewsNavigate())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewCompanyButton())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewEmployerName(), "howdy201111")){
        return false;
    }
    SeleniumDriverInstance.takeScreenShot("Test", false);

    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewContinue())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsEmployerRate())) {
        return false;
    }
    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.ReviewsEmployeeType(), true)) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewStartMonthDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewStartMonthDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsStartYearDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsStartYearDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsLastYearDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsLastYearDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsEmploymentStatusDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsEmploymentStatusDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsJobTitle(), "Accountant")){
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsCompanyTitle(), "Accountant Review")){
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsPros(), "Pro Pro Pro Pro Pro Pro")){
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsCons(), "Con Con Con Con Con Con")){
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsAdvice(), "Management should appreciate my hard work and always give monthly increases")){
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsOpportunity())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsBenefits())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsBalance())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsManagement())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsCulture())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsRecommend())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsNext())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsSalary(), "20000")){
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsSalaryTypeDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsSalaryTypeDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.ReviewsSalaryBonus(), true)) {
        return false;
    }
    SeleniumDriverInstance.takeScreenShot("Test", false);

    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsSalaryNext())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsCompanyBenefits())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsBenefitsFeedback(), "I started from the bottom now I'm here")){
        return false;
    }
    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.ReviewsEmployeeDiscount(), true)) {
        return false;
    }
    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.ReviewsWorkFromHome(), true)) {
        return false;
    }
    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.ReviewsMaternity(), true)) {
        return false;
    }

    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.ReviewsPension(), true)) {
        return false;
    }
    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.ReviewsVacation(), true)) {
        return false;
    }
    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.ReviewsDiversity(), true)) {
        return false;
    }
    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.ReviewsAssistance(), true)) {
        return false;
    }
    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.ReviewsApprenticeship(), true)) {
        return false;
    }
    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.ReviewsDisability(), true)) {
        return false;
    }

    SeleniumDriverInstance.takeScreenShot("Test", false);

    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsBenefitsNext())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsInterviewJobTitle(), "Epic Winner")){
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsInterviewDescribe(), "Epic Winner")){
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsInterviewQuestions(), "Epic Winner")){
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsInterviewDifficulty())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsInterviewDifficulty1())) {
        return false;
    }
    if (!SeleniumDriverInstance.selectRadioButtonUsingElementXpathAndBoolean(Main_Object.ReviewsInterviewOffer(), true)) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsInterviewSource())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsInterviewSource1())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsInterviewAmount(), "2")){
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsInterviewLength(), "2")){
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsInterviewLengthDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsInterviewLengthDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsInterviewWhenMonthDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsInterviewWhenMonthDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsInterviewWhenYearDrop())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsInterviewWhenYearDrop1())) {
        return false;
    }
    if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.ReviewsInterviewWhere(), "Office")){
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsInterviewStages())) {
        return false;
    }
    if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.ReviewsInterviewNext())) {
        return false;
    }



    SeleniumDriverInstance.takeScreenShot("Test", false);
    return true;
  }
}
