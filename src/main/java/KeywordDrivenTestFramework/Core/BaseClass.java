/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Core;

import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Reporting.ReportGenerator;
import KeywordDrivenTestFramework.Utilities.*;

import org.joda.time.DateTime;
import org.joda.time.Duration;

import java.util.List;

/**
 *
 * @author Brendan
 */
// All tests inherit from base class, 
// Base class contains initialisations of all neccessary utilities and 
// entities
public class BaseClass {

    public static List<TestEntity> testDataList;
    public static Enums.BrowserType browserType;
    public static ReportGenerator reportGenerator;
    public static SeleniumDriverUtility SeleniumDriverInstance;
    public static SikuliDriverUtility SikuliDriverInstance;
    public static OtpSmsUtility otpSms;
    private DateTime startTime, endTime;
    private Duration testDuration;
    public static String testCaseId;
    public static String reportDirectory;
    public static String currentTestDirectory;
    public static Enums.Environment currentEnvironment;
    public static String failScreenshotPath;

    public static String inputFilePath;

    public BaseClass() {
        System.setProperty("java.awt.headless", "true");
    }

    public void setStartTime() {
        this.startTime = new DateTime();
    }

    public long getTotalExecutionTime() {
        this.endTime = new DateTime();
        testDuration = new Duration(this.startTime, this.endTime);
        return testDuration.getStandardSeconds();
    }

    public String resolveScenarioName() {
        String isolatedFileNameString;
        String[] splitFileName;
        String[] inputFileNameArray;
        String resolvedScenarioName = "";

        // Get file name from inputFilePath (remove file extension)
        inputFileNameArray = inputFilePath.split("\\.");
        isolatedFileNameString = inputFileNameArray[0];
        if (isolatedFileNameString.contains("/")) {
            inputFileNameArray = isolatedFileNameString.split("/");
        } else if (isolatedFileNameString.contains("\\")) {
            inputFileNameArray = isolatedFileNameString.split("\\\\");
        }

        isolatedFileNameString = inputFileNameArray[inputFileNameArray.length - 1];

        splitFileName = isolatedFileNameString.split("(?=\\p{Upper})");

        for (String word : splitFileName) {
            resolvedScenarioName += word + " ";
        }

        return resolvedScenarioName.trim();
    }

    public String retrieveTestParameterUsingTestCaseId(String testCaseId, String parameterName) {
        String defaultReturn = "parameter not found";
        for (TestEntity testEntity : BaseClass.testDataList) {
            if (testEntity.TestCaseId.toUpperCase().equals(testCaseId.toUpperCase())) {
                if (testEntity.TestParameters.containsKey(parameterName)) {
                    return testEntity.TestParameters.get(parameterName);
                } else {
                    return defaultReturn;
                }
            }
        }
        return defaultReturn;
    }
    
    public void pause(int milisecondsToWait) {
        try {
            Thread.sleep(milisecondsToWait);
        } catch (Exception e) {

        }
    }

}
