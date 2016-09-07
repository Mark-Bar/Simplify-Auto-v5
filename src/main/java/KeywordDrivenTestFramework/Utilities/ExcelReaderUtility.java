/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Utilities;

import KeywordDrivenTestFramework.Entities.TestEntity;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brendan
 */
public class ExcelReaderUtility 
{
    List<TestEntity> testDataList;
    Sheet _workSheet;
    Workbook _workbook;
    public ExcelReaderUtility()
    {
        testDataList = new ArrayList<>();
        System.setProperty("java.awt.headless", "true"); 
    }
    
    public List<TestEntity> getTestDataFromExcelFile(String filePath)
    {
        _workbook = getExcelWorkbook(filePath);
        readExcelWorkSheet(_workbook);      
        retrieveTestDataFromSheet();      
        return testDataList;
    }
    
    public Workbook getExcelWorkbook(String filePath)
    {
         try(InputStream reader = new FileInputStream(filePath))
        { 
            return WorkbookFactory.create(reader);
        }
        catch(Exception e)
        {
            return null;
        } 
    }
    private boolean readExcelWorkSheet(Workbook workbook)
    {
        try
        {           
            _workSheet = workbook.getSheetAt(0);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }             
    }    
    
    private boolean retrieveTestDataFromSheet()
    {
        int lastColumn;
        if(_workSheet == null)
        {
            return false;
        }
        try
        {
            for (Row row : _workSheet) 
            {
                String firstCellValue = getCellValue(row.getCell(0));
                if(!firstCellValue.equals(""))
                {                    
                  lastColumn = row.getLastCellNum();
                  getTestParameters(row.getRowNum(), row.getRowNum() + 1,lastColumn);
                }
            }                         
             return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    
    private String getCellValue(Cell cell)
    {
        String cellValue = "";
        try
        {
            switch (cell.getCellType()) 
            {
                case Cell.CELL_TYPE_STRING:
                    cellValue = cell.getRichStringCellValue().getString();
                    break;   
                case Cell.CELL_TYPE_BLANK:
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) 
                    {
                        cellValue = cell.getDateCellValue().toString();
                    } else 
                    {
                        cellValue = NumberToTextConverter.toText(cell.getNumericCellValue());          
                    }
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    cellValue = String.valueOf(cell.getCellFormula());
                    break;
                default:            
            }
            if(cellValue == null)
                cellValue = "";
        }
        catch(Exception e)
        {
            return "";
        }
        return cellValue;
    }
    
    private void getTestParameters(int parameterRowIndex, int valueRowIndex, int lastColumn)
    {
        TestEntity testData = new TestEntity();
        Row parameterRow, valueRow;
        String testCaseId, methodName, testDescription = "";
		int testParemeterStartcolumn = 3;
        
        parameterRow = _workSheet.getRow(parameterRowIndex);
        valueRow = _workSheet.getRow(valueRowIndex);
        
        testCaseId = getCellValue(parameterRow.getCell(0)).trim();
        methodName = getCellValue(parameterRow.getCell(1)).trim();
		// Check the formatting of the inputfile, if the test description column is missing
		// and a test data parameter is present, reset the start column for data to 2.
		if(getCellValue(_workSheet.getRow(parameterRowIndex + 1).getCell(2)).equals(""))
			testDescription = getCellValue(parameterRow.getCell(2)).trim();
		else
			testParemeterStartcolumn = 2;
        testData.TestCaseId = testCaseId;
        testData.TestMethod = methodName;
		testData.TestDescription = testDescription;
        
        for(int i = testParemeterStartcolumn; i < lastColumn; i ++)
        {
            String parameter = getCellValue(parameterRow.getCell(i)).trim();
            String value = getCellValue(valueRow.getCell(i)).trim();
            if(!parameter.equals(""))
            {
                testData.addParameter(parameter, value);
            }           
        }
        if(testDataList == null)
        {
            testDataList = new ArrayList<>();
        }
        testDataList.add(testData);
    }
}
