/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Testing;


import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Reporting.ReportGenerator;
import KeywordDrivenTestFramework.Testing.TestClasses.*;
import KeywordDrivenTestFramework.Utilities.*;
import org.junit.Test;

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
    private ExcelReaderUtility excelInputReader;
    private CSVReportUtility cSVReportUtility;
    private PrintStream errorOutputStream;
    private PrintStream infoOutputStream;
    private String dateTime;

    public TestMarshall(String inputFilePathIn, Enums.BrowserType browserTypeOverride) {
        inputFilePath = inputFilePathIn;
        testDataList = new ArrayList<>();
        excelInputReader = new ExcelReaderUtility();
        cSVReportUtility = new CSVReportUtility(inputFilePath);
        cSVReportUtility.createCSVReportDirectoryAndFile();
        browserType = browserTypeOverride;
        reportGenerator = new ReportGenerator(inputFilePath, "\\Reports");
        SeleniumDriverInstance = new SeleniumDriverUtility(browserType);
    }
    public void runKeywordDrivenTests() throws Exception {
        testDataList = loadTestData(inputFilePath);
        this.generateReportDirectory();
        this.redirectOutputStreams();

        // Each case represents a test keyword found in the excel spreadsheet
        if (testDataList.size() < 1) {
            System.err.println("Test data object is empty - spreadsheet not found or is empty");
        } else {
            for (TestEntity testData : testDataList) {
                testCaseId = testData.TestCaseId;
                // Make sure browser is not null - could have thrown an exception and terminated
                //CheckBrowserExists();
                // Skip test methods and test case id's starting with ';'
                if (!testData.TestMethod.startsWith(";") && !testData.TestCaseId.startsWith(";")) {
                    System.out.println("Executing test - " + testData.TestMethod);
                    switch (testData.TestMethod) {
                        // A login test starts with a fresh Driver instance
//                        case "<String In Excel Column A>": {
//                            <Class Name> navTest = new <Class Name>(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }


//                        case "NavigateToCareers24": {
//                            EnsureOpenInstance();
//                            TC2_class navTest = new TC2_class(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "SignupNav": {
//                            SignupSA navTest = new SignupSA(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }


                        // JOB SEEKER MARSHALL START

//                        case "Signin": {
//                            Signin navTest = new Signin(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "BAlerts": {
//                            BAlerts navTest = new BAlerts(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "Reviews": {
//                            Reviews navTest = new Reviews(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "ContactUs": {
//                            ContactUs navTest = new ContactUs(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "ImproveProfile": {
//                            ImproveProfile navTest = new ImproveProfile(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                         }
//                        case "DropDownsSA": {
//                            DropDownsSA navTest = new DropDownsSA(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "ShareThis": {
//                            ShareThis navTest = new ShareThis(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "Footer": {
//                            Footer navTest = new Footer(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "PageTestingSA": {
//                            PageTestingSA navTest = new PageTestingSA(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "PageTestingNG": {
//                            PageTestingNG navTest = new PageTestingNG(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
                        // JOB SEEKER MARSHALL END


//                        case "JobPosting": {
//                            JobPosting navTest = new JobPosting(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//
//                        case "SignupNGweb": {
//                            SignupNGweb navTest = new SignupNGweb(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "SignupSAweb": {
//                            SignupSAweb navTest = new SignupSAweb(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "SignupSAmobi": {
//                            SignupSAmobi navTest = new SignupSAmobi(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "SignupNGmobi": {
//                            SignupNGmobi navTest = new SignupNGmobi(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "CreditsPurchasing": {
//                            CreditsPurchasing navTest = new CreditsPurchasing(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }

//                        case "VacancyCountBreakdown": {
//                            VacancyCountBreakdown navTest = new VacancyCountBreakdown(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "BActiveCompanies": {
//                            BActiveCompanies navTest = new BActiveCompanies(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "CandidateAquisitionReportSource": {
//                            CandidateAquisitionReportSource navTest = new CandidateAquisitionReportSource(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "CandidateAquisitionReportSector": {
//                            CandidateAquisitionReportSector navTest = new CandidateAquisitionReportSector(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "RecruiterApplicantsQuality": {
//                            RecruiterApplicantsQuality navTest = new RecruiterApplicantsQuality(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "RecruiterApplicantsQualityDrillDown": {
//                            RecruiterApplicantsQualityDrillDown navTest = new RecruiterApplicantsQualityDrillDown(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "BApplicationsAndMatchedApplications": {
//                            BApplicationsAndMatchedApplications navTest = new BApplicationsAndMatchedApplications(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "Listings": {
//                            Listings navTest = new Listings(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "CandidateEngagement": {
//                            CandidateEngagement navTest = new CandidateEngagement(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "RecruiterEngagement": {
//                            RecruiterEngagement navTest = new RecruiterEngagement(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "SalesAndRevenue": {
//                            SalesAndRevenue navTest = new SalesAndRevenue(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "RecruiterSignUp": {
//                            RecruiterSignUp navTest = new RecruiterSignUp(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "CandidateSearch": {
//                            CandidateSearch navTest = new CandidateSearch(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "RecruiterLogin": {
//                            RecruiterLogin navTest = new RecruiterLogin(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "CandidatesPage": {
//                            CandidatesPage navTest = new CandidatesPage(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "RecruitersPage": {
//                            RecruitersPage navTest = new RecruitersPage(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//
//                        case "ATSloginPage": {
//                            EnsureOpenInstance();
//                            ATSloginPage navTest = new ATSloginPage(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "ATSCreateVacancy": {
//                            ATSCreateVacancy navTest = new ATSCreateVacancy(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "ATSaddCandidate": {
//                            ATSaddCandidate navTest = new ATSaddCandidate(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "ATScandidateFunctions": {
//                            ATScandidateFunctions navTest = new ATScandidateFunctions(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "ATSrecruiterRegistration": {
//                            EnsureOpenInstance();
//                            ATSrecruiterRegistration navTest = new ATSrecruiterRegistration(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
//                        case "SimplifyAutomationApplication": {
//                            SimplifyAutomationApplication navTest = new SimplifyAutomationApplication(testData);
//                            reportGenerator.addResult(navTest.executeTest());
//                            break;
//                        }
                }
            }
        }
    }

        SeleniumDriverInstance.shutDown();

        reportGenerator.generateTestReport();

        this.

    flushOutputStreams();


}



    private List<TestEntity> loadTestData(String inputFilePath) {
        return excelInputReader.getTestDataFromExcelFile(inputFilePath);
    }

    public void CheckBrowserExists() {
        if (SeleniumDriverInstance == null) {
            SeleniumDriverInstance = new SeleniumDriverUtility(browserType);
            try {
                SeleniumDriverInstance.startDriver();
            } catch (MalformedURLException ex) {
                Logger.getLogger(TestMarshall.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void ensureNewBrowserInstance() {
        if (SeleniumDriverInstance.isDriverRunning()) {
            SeleniumDriverInstance.shutDown();
        }
        try {
            SeleniumDriverInstance.startDriver();
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestMarshall.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EnsureOpenInstance() {
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
        reportDirectory = "Reports" + "\\" + resolveScenarioName() + "_" + this.generateDateTimeString();
        String[] reportsFolderPathSplit = TestMarshall.reportDirectory.split("\\\\");
        TestMarshall.currentTestDirectory = "Reports" + "\\" + reportsFolderPathSplit[reportsFolderPathSplit.length - 1];
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
