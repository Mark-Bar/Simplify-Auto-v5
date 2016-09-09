/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Testing;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Reporting.ReportGenerator;
import KeywordDrivenTestFramework.Reporting.TestReportEmailerUtility;
import KeywordDrivenTestFramework.Testing.TestClasses.*;
import KeywordDrivenTestFramework.Utilities.ApplicationConfig;
import KeywordDrivenTestFramework.Utilities.CSVReportUtility;
import KeywordDrivenTestFramework.Utilities.ExcelReaderUtility;
import KeywordDrivenTestFramework.Utilities.SeleniumDriverUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brendan
 */
public class TestMarshall extends BaseClass {

    // Handles calling test methods based on test parameters , instantiates Selenium Driver object
    ExcelReaderUtility excelInputReader;
    CSVReportUtility cSVReportUtility;
    TestReportEmailerUtility reportEmailer;
    PrintStream errorOutputStream;
    PrintStream infoOutputStream;
    private String dateTime;

    public TestMarshall(String inputFilePathIn, Enums.BrowserType browserTypeOverride) {
        inputFilePath = inputFilePathIn;
        testDataList = new ArrayList<>();
        excelInputReader = new ExcelReaderUtility();
        cSVReportUtility = new CSVReportUtility(inputFilePath);
        cSVReportUtility.createCSVReportDirectoryAndFile();
        browserType = browserTypeOverride;
        reportGenerator = new ReportGenerator(inputFilePath, ApplicationConfig.ReportFileDirectory());
        SeleniumDriverInstance = new SeleniumDriverUtility(browserType);
    }

    public void runKeywordDrivenTests() throws Exception
    {


        testDataList = loadTestData(inputFilePath);
        this.generateReportDirectory();
        this.redirectOutputStreams();

        if (testDataList.size() < 1) {
            System.err.println("Test data object is empty - spreadsheet not found or is empty");
        } else {
            // Each case represents a test keyword found in the excel spreadsheet
            for (TestEntity testData : testDataList) {
                testCaseId = testData.TestCaseId;
                // Make sure browser is not null - could have thrown an exception and terminated
                //CheckBrowserExists();
                // Skip test methods and test case id's starting with ';'
                if (!testData.TestMethod.startsWith(";") && !testData.TestCaseId.startsWith(";")) {
                    System.out.println("Executing test - " + testData.TestMethod);
                    switch (testData.TestMethod)
                    {
                        // A login test starts with a fresh Driver instance

                        case "NavigateToSpree":
                        {
                            //ensureNewBrowserInstance();
                            EnsureOpenInstance();
                             TC1_class navTest = new TC1_class(testData);
                            reportGenerator.addResult(navTest.executeTest());
                            break;
                        }
                        case "AddItemToCart": {
                            //ensureNewBrowserInstance();
                            TC2_class navTest = new TC2_class(testData);
                            reportGenerator.addResult(navTest.executeTest());
                            break;
                        }
                        case "ViewCart": {
                            //ensureNewBrowserInstance();
                            TC3_class navTest = new TC3_class(testData);
                            reportGenerator.addResult(navTest.executeTest());
                            break;
                        }
                        case "CheckoutProcess": {
                            //ensureNewBrowserInstance();
                            TC4_class navTest = new TC4_class(testData);
                            reportGenerator.addResult(navTest.executeTest());
                            break;
                        }
                        case "ValidateOrder": {
                            //ensureNewBrowserInstance();
                            TC5_class navTest = new TC5_class(testData);
                            reportGenerator.addResult(navTest.executeTest());
                            break;
                        }
                        case "SnapScan": {
                            //ensureNewBrowserInstance();
                            TC7_class navTest = new TC7_class(testData);
                            reportGenerator.addResult(navTest.executeTest());
                            break;
                        }

                    }
                    System.out.println("Continuing to next test method");
                }
            }
        }

        SeleniumDriverInstance.shutDown();

        reportGenerator.generateTestReport();
        reportEmailer = new TestReportEmailerUtility(reportGenerator.testResults);
        reportEmailer.SendResultsEmail();

        this.flushOutputStreams();

    }

    private List<TestEntity> loadTestData(String inputFilePath) {
        return excelInputReader.getTestDataFromExcelFile(inputFilePath);
    }

    public static void CheckBrowserExists() {
        if (SeleniumDriverInstance == null) {
            SeleniumDriverInstance = new SeleniumDriverUtility(browserType);
            try {
                SeleniumDriverInstance.startDriver();
            } catch (MalformedURLException ex) {
                Logger.getLogger(TestMarshall.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void ensureNewBrowserInstance() {
        if (SeleniumDriverInstance.isDriverRunning()) {
            SeleniumDriverInstance.shutDown();
        }
        try {
            SeleniumDriverInstance.startDriver();
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestMarshall.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void EnsureOpenInstance() {
        try {
            SeleniumDriverInstance.startDriver();
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestMarshall.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String generateDateTimeString() {
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
        dateTime = dateFormat.format(dateNow);
        return dateTime;
    }

    public void generateReportDirectory() {
        reportDirectory = ApplicationConfig.ReportFileDirectory() + "\\" + resolveScenarioName() + "_" + this.generateDateTimeString();
        String[] reportsFolderPathSplit = TestMarshall.reportDirectory.split("\\\\");
        TestMarshall.currentTestDirectory = ApplicationConfig.ReportFileDirectory() + "\\" + reportsFolderPathSplit[reportsFolderPathSplit.length - 1];
    }

    public void redirectOutputStreams() {
        try {
            File reportDirectoryFile = new File(reportDirectory);
            File errorFile = new File(reportDirectory + "\\" + "ErrorTestLog.txt");
            File infoFile = new File(reportDirectory + "\\" + "InfoTestLog.txt");

            reportDirectoryFile.mkdirs();

            errorOutputStream = new PrintStream(errorFile);
            infoOutputStream = new PrintStream(infoFile);

            System.setOut(infoOutputStream);
            System.setErr(errorOutputStream);
        } catch (FileNotFoundException ex) {
            System.err.println("[Error] could not create log files - " + ex.getMessage());
        }
    }

    public void flushOutputStreams() {

        errorOutputStream.flush();
        infoOutputStream.flush();

        errorOutputStream.close();
        infoOutputStream.close();

    }
}
