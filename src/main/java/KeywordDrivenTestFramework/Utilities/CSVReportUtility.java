/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Brendan
 */
public final class CSVReportUtility {

    StringBuilder rowRecords = new StringBuilder();
    File reportFile;
    private String dateTimeFolder;
    private String testPack;
    private File reportErrorLogFile;

    public CSVReportUtility(String fileName) {
        this.reportFile = getReportFile(fileName);

    }

    public File getReportFile(String fileName) {
        if (fileName != null && !fileName.equals("")) {
            String[] pathArr = fileName.split("\\\\");
            String[] fileArr = pathArr[pathArr.length - 1].split("\\.");
            setTestPack(fileArr[0]);
            fileName = "CSVReports\\KissatDashboard_MIP_Results.csv";
            String reportErrorLogFilePath = fileName.substring(0, fileName.length() - 4) + "ErrorLog.csv";
            reportErrorLogFile = new File(reportErrorLogFilePath);
            return new File(fileName);
        }
        return null;
    }

    public void createCSVReportDirectoryAndFile() {
        if (createCSVReportDirectory()) {
            createCSVReportFile();
        }
    }

    public boolean createCSVReportDirectory() {
        File reportDirectory = new File("CSVReports");
        if (reportDirectory.exists()) {
            return true;
        }
        return reportDirectory.mkdir();

    }

    public void createCSVReportFile() {
        if (!reportFile.exists()) {
            try {
                reportFile.createNewFile();
                reportErrorLogFile.createNewFile();
                BufferedWriter bufferedWriter2;
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reportFile, true))) {
                    bufferedWriter2 = new BufferedWriter(new FileWriter(getReportErrorLogFile(), true));
                    bufferedWriter.write("Timestamp,Build,Run,Test Suite,Test Case,LastMod,Created,CreatedBy,Priority,Functionality,Status,Message,Duration,Result,REQ ID");
                    bufferedWriter2.write("Timestamp,Test_Suite,Error");
                    bufferedWriter.newLine();
                    bufferedWriter2.newLine();
                }
                bufferedWriter2.close();
            } catch (IOException ex) {
                Logger.getLogger(CSVReportUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String getTimestamp() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateTimeFolder = dateFormatter.format(calendar.getTime());
    }

    public void addValue(String value) {
        rowRecords.append(value);
    }

    public void appendToCSVReportFile() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(reportFile, true));
            bufferedWriter.write(rowRecords.toString());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            Logger.getLogger(CSVReportUtility.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(CSVReportUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the testPack
     */
    public String getTestPack() {
        return testPack;
    }

    /**
     * @param testPack the testPack to set
     */
    public void setTestPack(String testPack) {
        this.testPack = testPack;
    }

    /**
     * @return the reportErrorLogFile
     */
    public File getReportErrorLogFile() {
        return reportErrorLogFile;
    }
}
