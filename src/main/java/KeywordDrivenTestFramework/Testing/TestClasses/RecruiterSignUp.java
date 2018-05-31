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

public class RecruiterSignUp extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public RecruiterSignUp(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!RecruiterSignUp()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean RecruiterSignUp(){

        Date time = new Date();
        String newTime =  new SimpleDateFormat("HH:mm:ss").format(time);

        Date date = new Date();
        String newDate =  new SimpleDateFormat("yyMMddHHmmss").format(date);


        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.SignUpLink())){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("SignUpLink Test", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.RegisterAsRecruiter())){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.RecFirstName(), "Mark" )){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.RecLastName(), "Recfoot" )){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.RecEmail(), "MarkRecfoot" + newDate +"@mailinator.com" )){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.RecEmailConfirm(), "MarkRecfoot" + newDate +"@mailinator.com" )){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.RecPassword(), "1234" )){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.RecContactNo(), "12345678910" )){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.RecCompanyName(), "CompanyXYZ" )){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.RecAddresss(), "123 Street" )){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.RecCity(), "Capetown" )){
            return false;
        }
        if (!SeleniumDriverInstance.enterTextByXpath(Main_Object.RecPostCode(), "1234" )){
            return false;
        }
        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.RecTC())){
            return false;
        }
        SeleniumDriverInstance.takeScreenShot(" PASS", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.RecNext1())){
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot(" RecruiterSignup PASS", false);

        if (!SeleniumDriverInstance.clickElementbyXpath(Main_Object.RecLogOut())){
            return false;
        }
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        SeleniumDriverInstance.takeScreenShot("Recruiter Logout", false);





        return true;



    }
}
