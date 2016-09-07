/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Utilities;

import KeywordDrivenTestFramework.Core.BaseClass;
import static KeywordDrivenTestFramework.Core.BaseClass.SeleniumDriverInstance;
import static KeywordDrivenTestFramework.Core.BaseClass.SikuliDriverInstance;
import KeywordDrivenTestFramework.Entities.TestEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brendan
 */
public class OtpSmsUtility extends BaseClass {
    String otpString = "";
    String username;
    String password;
    String submitButtonImagePath;
    String messagesButtonImagePath;
    String numberNormalImagePath;
    String numberHighlighedImagePath;
    String whitePaneImagePath;
    String messageCornerImagePath;
    String airdroidSikuliFolder;
    int otpStart;
    int otpEnd;
    int counter = 1;
    TestEntity testData;
    
    //Variables of pageObjects:
    String airdroidURL = "http://web.airdroid.com/";
    String airdroidHeadClass = "widget-login-head";
    String accountTextBoxClass = "widget-login-account-input";
    String passwordTextBoxClass = "widget-login-pwd-input";
    String closeBtnClass = "widget-upgradeGuide-btnClose";
    String messagesTitleClass = "window_title_text over-ellipsis";
    
    

    public OtpSmsUtility(String username, String password, String submitButtonImagePath, String messagesButtonImagePath, String numberNormalImagePath, String numberHighlighedImagePath, String whitePaneImagePath, String messageCornerImagePath, String airdroidSikuliFolder, int otpStart, int otpEnd) {
        this.username = username;
        this.password = password;
        this.submitButtonImagePath = submitButtonImagePath;
        this.messagesButtonImagePath = messagesButtonImagePath;
        this.numberNormalImagePath = numberNormalImagePath;
        this.numberHighlighedImagePath = numberHighlighedImagePath;
        this.whitePaneImagePath = whitePaneImagePath;
        this.messageCornerImagePath = messageCornerImagePath;
        this.airdroidSikuliFolder = airdroidSikuliFolder;
        this.otpStart = otpStart;
        this.otpEnd = otpEnd;
        SikuliDriverInstance = new SikuliDriverUtility(this.airdroidSikuliFolder);
        
    }

    public boolean populateOtp() {

        if (!NavigateAirdroidPage()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Airdroid Home Page", true);
            counter++;
            //return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Airdroid Home Page", this.getTotalExecutionTime());
        }

        if (!waitForCloseImage()) {
            SeleniumDriverInstance.takeScreenShot("Failed to validate that Airdroid has loaded", true);
            //return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to validate that Airdroid has loaded", this.getTotalExecutionTime());
        }

        if (!clickClose()) {
            SeleniumDriverInstance.takeScreenShot("Failed to click Sign In - ", true);
            //return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click Sign In - ", this.getTotalExecutionTime());
        }

        if (!waitForSignInHead()) {
            SeleniumDriverInstance.takeScreenShot("Failed to validate that Airdroid has loaded", true);
            //return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to validate that Airdroid has loaded", this.getTotalExecutionTime());
        }

        if (!enterAccount()) {
            SeleniumDriverInstance.takeScreenShot("Failed to enter account details - ", true);
            //return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter account details - ", this.getTotalExecutionTime());
        }

        if (!enterPassword()) {
            SeleniumDriverInstance.takeScreenShot("Failed to enter password - ", true);
            //return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to enter password - ", this.getTotalExecutionTime());
        }

        if (!clickSignIn()) {
            SeleniumDriverInstance.takeScreenShot("Failed to click Sign In - ", true);
            //return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click Sign In - ", this.getTotalExecutionTime());
        }

        if (!waitForAirdroidToLoad()) {
            SeleniumDriverInstance.takeScreenShot("Failed to falidate that the Sign In was successfull - ", true);
            // new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to falidate that the Sign In was successfull - ", this.getTotalExecutionTime());
        }

        if (!clickMessages()) {
            SeleniumDriverInstance.takeScreenShot("Failed to click messages icon - ", true);
            //return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click messages icon - ", this.getTotalExecutionTime());
        }

        if (!waitForNumber()) {
            SeleniumDriverInstance.takeScreenShot("Failed to click on the number  - ", true);
            //return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the number - ", this.getTotalExecutionTime());
        }

        if (!clickNumber()) {
            SeleniumDriverInstance.takeScreenShot("Failed to click on the number  - ", true);
            //return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to click on the number - ", this.getTotalExecutionTime());
        }

        if (!getText()) {
            SeleniumDriverInstance.takeScreenShot("Failed to validate that Airdroid has loaded", true);
            //return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to validate that Airdroid has loaded", this.getTotalExecutionTime());
        }

        SeleniumDriverInstance.pause(2000);
        
        return true;
        //return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully signed into Airdroid and clicked on messages", this.getTotalExecutionTime());
    }

    public boolean NavigateAirdroidPage() {

        if (!SeleniumDriverInstance.navigateTo(airdroidURL)) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot(counter + " - Navigation to Airdroid Home Page successful", false);
        counter++;

        return true;
    }

    public boolean waitForCloseImage() {
        return SeleniumDriverInstance.waitForElementByClassName(closeBtnClass);
    }

    public boolean clickClose() {
        return SeleniumDriverInstance.clickElementbyClassName(closeBtnClass);
    }

    public boolean waitForSignInHead() {
        return SeleniumDriverInstance.waitForElementByClassName(airdroidHeadClass);
    }

    public boolean enterAccount() {

        return SeleniumDriverInstance.enterTextByClassName(accountTextBoxClass, this.username);
    }

    public boolean enterPassword() {
        return SeleniumDriverInstance.enterTextByClassName(passwordTextBoxClass, this.password);
    }

    public boolean clickSignIn() {
        return SikuliDriverInstance.MouseClickElement(submitButtonImagePath);
    }

    public boolean waitForAirdroidToLoad() {
        if (!SeleniumDriverInstance.waitForElementNoLongerPresentByClass(airdroidHeadClass, 100)) {
            return false;
        }

        SeleniumDriverInstance.takeScreenShot(counter + " - Sign in to Airdroid Page successful", false);
        counter++;
        return true;
    }

    List<String> listNames = new ArrayList<>();

    public boolean clickMessages() {
        return SikuliDriverInstance.MouseClickElement(messagesButtonImagePath);
    }

    public boolean clickNumber() {
        if (!SikuliDriverInstance.MouseClickHighlightedOrNormal(numberNormalImagePath, numberHighlighedImagePath)) {

            return false;
        }

        SeleniumDriverInstance.takeScreenShot(counter + "Successfully clicked number", false);
        counter++;
        return true;
    }

    public boolean waitForNumber() {
        if (!SikuliDriverInstance.WaitForEitherImageToAppear(numberNormalImagePath, numberHighlighedImagePath)) {

            return false;
        }

        SeleniumDriverInstance.takeScreenShot(counter + "Messages loaded successfully", false);
        counter++;
        return true;
    }

    public boolean getText() {
        if (SikuliDriverInstance.MouseTripleClickElement(messageCornerImagePath, whitePaneImagePath, 0, -30)) {

            SeleniumDriverInstance.copyKeys();

            otpString = SikuliDriverInstance.getClipboardContents();

            return true;
        }
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getOtpCode(){
        String otpCode = isolateOtpCode(this.otpStart, this.otpEnd);
        return otpCode;
    }
    
    public void writeReportOtpCode(){
        testData.addParameter("OtpCode", isolateOtpCode(this.otpStart, this.otpEnd));
    }
    
    private String isolateOtpCode(int iOtpStart, int iOtpEnd){
        return otpString.substring(iOtpStart, iOtpEnd);
    }

}
