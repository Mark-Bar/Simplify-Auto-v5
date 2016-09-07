/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Reporting;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.DataColumn;
import KeywordDrivenTestFramework.Entities.DataRow;
import KeywordDrivenTestFramework.Entities.Enums;
import static KeywordDrivenTestFramework.Entities.Enums.ResultStatus.FAIL;
import static KeywordDrivenTestFramework.Entities.Enums.ResultStatus.PASS;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Utilities.CSVReportUtility;
import KeywordDrivenTestFramework.Utilities.ExcelReaderUtility;
import java.io.File;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.err;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Brendan
 */
public class ReportGenerator extends BaseClass {

    int runId = 0;

    int numberOfTestsRunCheck = 0;

    public List<TestResult> testResults;
    Map<String, Integer> KeywordMapping;
    FileOutputStream outputStream;
    Workbook workbook;
    Sheet InputSheet, OutputSheet;
    Row reportRow;
    String reportDirectory;
    String dateTimeFolder;
    String _inputFilePath;
    ExcelReaderUtility excelReader;
    public int currentRow, startColumn, totalTests, totalPasses, totalFails, shiftAmount;
    long TotalSeconds = 0;
    long TotalMinutes = 0;
    long TotalHours = 0;
    boolean wereRowsShifted = false;
    CSVReportUtility csvReportBuilder;
    CellStyle cellStyleSummary, cellStyleHeader, cellStyleHeaderSummary, cellStyleFail, cellStylePass;

    public ReportGenerator(String inputFilePath, String reportDirectory) {
        excelReader = new ExcelReaderUtility();
        _inputFilePath = inputFilePath;
        // Retrieve inputFile Workbook
        workbook = excelReader.getExcelWorkbook(_inputFilePath);
        setCellStyles();
        csvReportBuilder = new CSVReportUtility(_inputFilePath);
//        this.reportDirectory = reportDirectory;
        this.testResults = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("(yyyy-MM-dd)(HH-mm-ss)");
        dateTimeFolder = dateFormatter.format(calendar.getTime());
    }

    public ReportGenerator(){}

    public void addResult(TestResult testResult) {
        totalTests += 1;
        if (testResult.testStatus == Enums.ResultStatus.PASS || testResult.testStatus == Enums.ResultStatus.WARNING) {
            totalPasses += 1;
        } else if (testResult.testStatus == Enums.ResultStatus.FAIL) {
            totalFails += 1;
        }
        this.testResults.add(testResult);
    }

    public boolean generateTestReport() {
        try {
            // Create a new sheet within the existing workbook
            this.CreateSheet();

            // Calculate total test time for the summary section
            this.CalculateTotalTestTime();

            // Write test summary data to report
            this.WriteSummarySection();

            // Define report structure; title, columns, etc...
            this.AddReportColumnHeadings();

            // Write results to the report sheet
            this.PrintResults();

            csvReportBuilder.appendToCSVReportFile();

            try (PrintWriter pw = new PrintWriter(new File("RunId.txt"))) {
                pw.write(runId + 1 + "");
            }

            if (this.WriteTestReport())
            {
                this.CopyInputFileToReportDirectory();
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (Exception e) {
            System.out.println("Error generating report...see message and  stack trace below: " + e.getMessage());
            return false;
        }
    }

    private void CreateSheet() {
        String SheetName = "Results " + this.dateTimeFolder;
        //Adds the timestamp of execution of test pack
        //csvReportBuilder.addValue(csvReportBuilder.getTimestamp() + ",");
        this.OutputSheet = this.workbook.createSheet(SheetName);
        this.workbook.setSheetOrder(SheetName, 1);
    }

    private void PrintResults() {
        currentRow = 7;
        for (TestResult result : testResults) {
            try {
                addReportRow(result, currentRow);
                currentRow++;
            } catch (Exception e) {
                System.err.println("Error printing result - " + e.getMessage());
            }
        }
    }

    private void addReportRow(TestResult result, int rowNumber) throws FileNotFoundException {

        reportRow = OutputSheet.getRow(rowNumber);

        if (reportRow == null) {
            reportRow = OutputSheet.createRow(rowNumber);
        }

        if (null != result.testStatus)
            switch (result.testStatus) {
                case PASS:
                    AddCell(0, "Pass", false, false);
                    this.SetResultAsPassed(rowNumber);
                    break;
                case FAIL:
                    AddCell(0, "Fail", false, false);
                    this.SetResultAsFailed(rowNumber);
                    break;
                case WARNING:
                    AddCell(0, "Warning", false, false);
                    this.SetResultAsWarning(rowNumber);
                    break;
                default:
                    break;
            }

        AddCell(1, result.errorMessage, false, false);
        AddCell(2, result.calculateFormattedTestTime(), false, false);

        csvReportBuilder.addValue(csvReportBuilder.getTimestamp() + ",");
        //Retrieves the Build number, indicated in the test pack spreadsheet
        csvReportBuilder.addValue(result.testData.getData("Build") + ",");

        try (Scanner sc = new Scanner(new File("RunId.txt"))) {
            runId = sc.nextInt();
        }

        csvReportBuilder.addValue(runId + ",");
        //Retrieves test suite name from spreadsheet
        csvReportBuilder.addValue(csvReportBuilder.getTestPack() + ",");
        //Retrieves test case ID from spreadsheet
        csvReportBuilder.addValue(result.testData.TestCaseId + ",");
        //Calls getLastModifiedDate
        csvReportBuilder.addValue(getLastModifiedDate() + ",");
        //Calls getCreatedDate
        csvReportBuilder.addValue(getCreatedDate() + ",");
        //Calls getCreatedBy
        csvReportBuilder.addValue(getCreatedBy() + ",");
        //Retrieves Priority from spreadsheet
        csvReportBuilder.addValue(result.testData.getData("Priority") + ",");
        //Retrieves Functionality from spreadsheet
        csvReportBuilder.addValue(result.testData.getData("Functionality") + ",");
        //Retrieves the status of the test PASS/FAIL/WARNING
        csvReportBuilder.addValue(result.testStatus.toString() + ",");
        //Retrieves the error message of the test
        csvReportBuilder.addValue(result.errorMessage + ",");
        //Retrieves the duration of the test
        csvReportBuilder.addValue(result.testDuration + ",");
        //Hardcoded - need to code
        csvReportBuilder.addValue("null_result,");
        //Hardcoded - need to code
        csvReportBuilder.addValue("null_reqID,");

        int numberOfTestsRun;
        try (Scanner sc2 = new Scanner(new File("NumberOfTestsRun.txt"))) {
            numberOfTestsRun = sc2.nextInt();
        }

        if (numberOfTestsRun == numberOfTestsRunCheck || numberOfTestsRun == 0) {
            //csvReportBuilder.addValue("\n\n");
        } else {
            csvReportBuilder.addValue("\n");
            numberOfTestsRunCheck++;
        }

        AddTestData(result.testData, rowNumber);

    }

    private void AddReportColumnHeadings() {
        int startRow = 6;
        this.reportRow = OutputSheet.getRow(startRow);
        if (reportRow == null) {
            reportRow = OutputSheet.createRow(startRow);
        }
        AddCell(0, "Result", true, false);
        AddCell(1, "Message", true, false);
        AddCell(2, "Time Taken", true, false);
        AddCell(3, "Test Case Id", true, false);
        AddCell(4, "Keyword", true, false);
        AddCell(5, "Parameters", true, false);
    }

    private void AddSummarySectionColumnHeadings() {
        this.reportRow = OutputSheet.getRow(0);
        if (reportRow == null) {
            reportRow = OutputSheet.createRow(0);
        }
        AddCell(0, "Summary", true, true);
        AddCell(1, "Count", true, true);
        AddCell(2, "Percentage", true, true);

        this.reportRow = OutputSheet.getRow(1);
        if (reportRow == null) {
            reportRow = OutputSheet.createRow(1);
        }
        AddCell(0, "Total", true, true);

        this.reportRow = OutputSheet.getRow(2);
        if (reportRow == null) {
            reportRow = OutputSheet.createRow(2);
        }
        AddCell(0, "Pass", true, true);

        this.reportRow = OutputSheet.getRow(3);
        if (reportRow == null) {
            reportRow = OutputSheet.createRow(3);
        }
        AddCell(0, "Fail", true, true);

        this.reportRow = OutputSheet.getRow(4);
        if (reportRow == null) {
            reportRow = OutputSheet.createRow(4);
        }
        AddCell(0, "Run time (hh:mm:ss)", true, true);
    }

    private void AddSummaryData() {
        this.reportRow = OutputSheet.getRow(1);
        AddCell(1, String.valueOf(totalTests), false, true);
        AddCell(2, "", false, true);

        this.reportRow = OutputSheet.getRow(2);
        AddCell(1, String.valueOf(totalPasses), false, true);
        AddCell(2, String.valueOf(Math.round(totalPasses * 100.0 / totalTests) + "%"), false, true);

        this.reportRow = OutputSheet.getRow(3);
        AddCell(1, String.valueOf(totalFails), false, true);
        AddCell(2, String.valueOf(Math.round(totalFails * 100.0 / totalTests) + "%"), false, true);

        this.reportRow = OutputSheet.getRow(4);
        AddCell(1, TotalHours + ":" + TotalMinutes + ":" + TotalSeconds, false, true);
        AddCell(2, "", false, true);

    }

    private void setCellStyles()
    {
        this.cellStyleHeader = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        this.cellStyleHeader.setFont(headerFont);
        this.cellStyleHeader.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        this.cellStyleHeader.setFillPattern(CellStyle.SOLID_FOREGROUND);
        this.cellStyleHeader.setBorderBottom(CellStyle.BORDER_THIN);
        this.cellStyleHeader.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        this.cellStyleHeader.setBorderLeft(CellStyle.BORDER_THIN);
        this.cellStyleHeader.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        this.cellStyleHeader.setBorderRight(CellStyle.BORDER_THIN);
        this.cellStyleHeader.setRightBorderColor(IndexedColors.BLACK.getIndex());
        this.cellStyleHeader.setBorderTop(CellStyle.BORDER_THIN);
        this.cellStyleHeader.setTopBorderColor(IndexedColors.BLACK.getIndex());

        this.cellStyleSummary = workbook.createCellStyle();
        Font headerFont2 = workbook.createFont();
        headerFont2.setBoldweight(Font.BOLDWEIGHT_BOLD);
        this.cellStyleSummary.setFont(headerFont2);
        this.cellStyleSummary.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        this.cellStyleSummary.setFillPattern(CellStyle.SOLID_FOREGROUND);
        this.cellStyleSummary.setBorderBottom(CellStyle.BORDER_THIN);
        this.cellStyleSummary.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        this.cellStyleSummary.setBorderLeft(CellStyle.BORDER_THIN);
        this.cellStyleSummary.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        this.cellStyleSummary.setBorderRight(CellStyle.BORDER_THIN);
        this.cellStyleSummary.setRightBorderColor(IndexedColors.BLACK.getIndex());
        this.cellStyleSummary.setBorderTop(CellStyle.BORDER_THIN);
        this.cellStyleSummary.setTopBorderColor(IndexedColors.BLACK.getIndex());


        this.cellStyleHeaderSummary = workbook.createCellStyle();
        Font headerFont3 = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        cellStyleHeaderSummary.setFont(headerFont3);
        cellStyleHeaderSummary.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyleHeaderSummary.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleHeaderSummary.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyleHeaderSummary.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleHeaderSummary.setBorderRight(CellStyle.BORDER_THIN);
        cellStyleHeaderSummary.setRightBorderColor(IndexedColors.BLACK.getIndex());
        cellStyleHeaderSummary.setBorderTop(CellStyle.BORDER_THIN);
        cellStyleHeaderSummary.setTopBorderColor(IndexedColors.BLACK.getIndex());


        this.cellStylePass = workbook.createCellStyle();
        Font headerFont4 = workbook.createFont();
        headerFont4.setBoldweight(Font.DEFAULT_CHARSET);
        this.cellStylePass.setFont(headerFont4);
        this.cellStylePass.setFillForegroundColor(IndexedColors.LIME.getIndex());
        this.cellStylePass.setFillPattern(CellStyle.SOLID_FOREGROUND);


        this.cellStyleFail = workbook.createCellStyle();
        Font headerFont5 = workbook.createFont();
        headerFont5.setBoldweight(Font.DEFAULT_CHARSET);
        this.cellStyleFail.setFont(headerFont5);
        this.cellStyleFail.setFillForegroundColor(IndexedColors.ROSE.getIndex());
        this.cellStyleFail.setFillPattern(CellStyle.SOLID_FOREGROUND);


    }
    private void AutoSizeColumnsBeforeSave() {
        for (int i = 2; i < 50; i++) {
            this.OutputSheet.autoSizeColumn(i);
        }
    }

    private void AddCell(int columnIndex, String cellText, boolean isColumnHeader, boolean isSummaryValue) {
        Cell cell = reportRow.getCell(columnIndex);
        if (cell == null) {
            cell = reportRow.createCell(columnIndex);
        }

        cell.setCellValue(cellText);

        if (isColumnHeader && !isSummaryValue)
        {

            cell.setCellStyle(this.cellStyleHeader);
        }
        else if (isSummaryValue && isColumnHeader)
        {

            cell.setCellStyle(this.cellStyleHeaderSummary);
        }
        else if (isSummaryValue && !isColumnHeader)
        {

            cell.setCellStyle(this.cellStyleSummary);
        }


    }


    private void AddCell(int columnIndex, String cellText, Enums.ResultStatus result)
    {
        Cell cell = reportRow.getCell(columnIndex);
        if (cell == null)
        {
            cell = reportRow.createCell(columnIndex);
        }

        cell.setCellValue(cellText);

        if(result == PASS)
        {
            cell.setCellStyle(this.cellStylePass);
        }
        else if(result == FAIL)
        {

            cell.setCellStyle(this.cellStyleFail);
        }



    }

    private void AddTestData(TestEntity testData, int rowNumber) {
        Cell cell;
        CellStyle cellStyle;
        Font headerFont;

        cellStyle = workbook.createCellStyle();
        headerFont = workbook.createFont();
        //headerFont.setBoldweight(Font.BOLDWEIGHT BOLD);
        // Start column for test data parameters
        int ColumnIndex = 6;

        // Add Test Case Id
        AddCell(3, testData.TestCaseId, false, false);
        //csvReportBuilder.addValue(testData.TestCaseId + "\n");
        // Make Test Case Id bold
        cell = reportRow.getCell(3);
        cellStyle = workbook.createCellStyle();
        headerFont = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        cellStyle.setFont(headerFont);
        cell.setCellStyle(cellStyle);

        // Add Test Method (Keyword)
        AddCell(4, testData.TestMethod, false, false);

        // Make Test Method bold
        cell = reportRow.getCell(4);
        cellStyle = workbook.createCellStyle();
        headerFont = workbook.createFont();
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        cellStyle.setFont(headerFont);
        cell.setCellStyle(cellStyle);

        // Add Test Description
        AddCell(5, testData.TestDescription, false, false);
        // Make Test Description bold
        cell = reportRow.getCell(5);
        cellStyle.setFont(headerFont);
        cell.setCellStyle(cellStyle);
        if (testData.TestParameters != null) {
            Iterator it = testData.TestParameters.entrySet().iterator();

            while (it.hasNext()) {
                reportRow = OutputSheet.getRow(rowNumber);

                Map.Entry pairs = (Map.Entry) it.next();

                AddCell(ColumnIndex, pairs.getKey().toString(), false, false);

                // Make Parameters bold
                cell = reportRow.getCell(ColumnIndex);
                cellStyle = workbook.createCellStyle();
                headerFont = workbook.createFont();
                headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
                cellStyle.setFont(headerFont);
                cell.setCellStyle(cellStyle);

                reportRow = OutputSheet.getRow(rowNumber + 1);
                if (reportRow == null) {
                    reportRow = OutputSheet.createRow(rowNumber + 1);
                }

                AddCell(ColumnIndex, pairs.getValue().toString(), false, false);
                it.remove();

                ColumnIndex++;
            }
        }
        currentRow++;
    }

    private void WriteSummarySection() {
        this.AddSummarySectionColumnHeadings();
        this.AddSummaryData();
    }

    private boolean WriteTestReport() {
        try {
            try (FileOutputStream outputStream = new FileOutputStream(_inputFilePath)) {
                AutoSizeColumnsBeforeSave();
                workbook.write(outputStream);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean WriteTestReport(String filePath)
    {
        try
        {
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                AutoSizeColumnsBeforeSave();
                workbook.write(outputStream);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void GenerateExcelDataSheetReport(List<DataRow> dataRows, String fileName)
    {

        try
        {
            int columnIndex = 0;
            int currentRow = 0;
            workbook = new XSSFWorkbook();

            this.OutputSheet = workbook.createSheet();
            setCellStyles();
            // Add column headers
            reportRow = OutputSheet.getRow(currentRow);



            if(reportRow == null)
                reportRow = OutputSheet.createRow(currentRow);

            //use the first Datarow as a template for the column headers

            DataRow firstRow = dataRows.get(currentRow);


            for(DataColumn column : firstRow.DataColumns)
            {
                AddCell(columnIndex, column.columnHeader, true, false);
                columnIndex++;
            }

            //move to the next row
            currentRow++;

            for(DataRow row : dataRows)
            {
                reportRow = OutputSheet.getRow(currentRow);

                if(reportRow == null)
                    reportRow = OutputSheet.createRow(currentRow);

                columnIndex = 0;
                for(DataColumn column : row.DataColumns)
                {
                    AddCell(columnIndex, column.columnValue, column.resultStatus);

                    columnIndex++;
                }

                currentRow++;
            }

            try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
                workbook.write(outputStream);
            }
        }
        catch(Exception ex)
        {
            err.println("[ERROR] Failed to write Excel datarow report - " + ex.getMessage());
        }

    }

    private void SetResultAsPassed(int rowIndex) {
        Cell cell = OutputSheet.getRow(rowIndex).getCell(3);

        cell.setCellStyle(this.cellStylePass);
    }

    private void SetResultAsFailed(int rowIndex) {

        Cell cell = OutputSheet.getRow(rowIndex).getCell(3);
        cell.setCellStyle(this.cellStyleFail);
    }

    private void SetResultAsWarning(int rowIndex) {

        Cell cell = OutputSheet.getRow(rowIndex).getCell(3);

        cell.setCellStyle(this.cellStyleFail);
    }

    private void CalculateTotalTestTime() {
        for (TestResult result : testResults) {
            TotalSeconds += result.testDuration;
        }

        if (TotalSeconds > 60) {
            while (TotalSeconds > 60) {
                TotalMinutes += 1;
                TotalSeconds -= 60;

            }
        }

        if (TotalMinutes > 60) {
            while (TotalMinutes > 60) {
                TotalHours += 1;
                TotalMinutes -= 60;
            }
        }
    }

    private BasicFileAttributes getFileAttributes() {
        Path file = Paths.get(_inputFilePath);
        BasicFileAttributes attr = null;
        try {
            attr = Files.readAttributes(file, BasicFileAttributes.class);
        } catch (IOException ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attr;
    }

    private String getLastModifiedDate() {
        BasicFileAttributes attr = getFileAttributes();
        Date date = new Date(attr.lastModifiedTime().toMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    private String getCreatedDate() {
        BasicFileAttributes attr = getFileAttributes();
        Date date = new Date(attr.creationTime().toMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    private String getCreatedBy() {
        return System.getProperty("user.name");
    }

    private void CopyInputFileToReportDirectory()
    {
        try
        {
            String[] inputFilePathSplit = _inputFilePath.split("\\\\");
            FileUtils.copyFile(new File (_inputFilePath), new File(ReportGenerator.currentTestDirectory + "\\" + inputFilePathSplit[inputFilePathSplit.length - 1]));
        }

        catch(Exception e)
        {
            System.err.println("[Error] Unable to copy the input file to the report directory, fault - " + e.getMessage());
        }
    }
}
