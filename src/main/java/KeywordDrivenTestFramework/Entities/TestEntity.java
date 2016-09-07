/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Brendan
 */
public class TestEntity {

    // Properties -
    // TestMethod
    // TestParameters
    // Methods - 
    // constructors
    // addParameter
    // -----------------------------------------------------------------------
    // Serves as a container for each test found in the spreadsheet/test input 
    // document.
    public String TestCaseId;
    public String TestMethod;
    public String TestDescription;
    public Map<String, String> TestParameters;
    public Map<String, ArrayList<String>> ExtractedParameters;

    public TestEntity() {

    }

    public TestEntity(String testCaseId, String testMethod, String testDescription, LinkedHashMap<String, ArrayList<String>> extractedParameters) {
        this.TestCaseId = testCaseId;
        this.TestMethod = testMethod;
        this.TestDescription = testDescription;
        this.ExtractedParameters = extractedParameters;

    }

    public String getData(String parameterName) {
        String returnedValue = this.TestParameters.get(parameterName);

        if (returnedValue == null) {
            System.err.println("[Error] Parameter ' " + parameterName + " ' not found");
            returnedValue = "";
        }

        return returnedValue;
    }

    public void addParameter(String parameterName, String parameterValue) {
        if (TestParameters == null) {
            this.TestParameters = new HashMap<>();
        }
        this.TestParameters.put(parameterName, parameterValue);
    }

    public void updateParameter(String parameterName, String newParameterValue) {
        this.TestParameters.put(parameterName, newParameterValue);
    }

    public void addParameterAsFirst(String parameterName, String parameterValue) {
        Map<String, String> tempParamList = new HashMap<>();

        tempParamList.put(parameterName, parameterValue);

        tempParamList.putAll(this.TestParameters);

        this.TestParameters = tempParamList;
    }

    @SuppressWarnings("rawtypes")
    public String testParametersToString() {
        if (TestParameters != null && TestParameters.size() > 0) {
            String parameters = "";
            Iterator<Entry<String, String>> paramIterator = TestParameters.entrySet().iterator();
            while (paramIterator.hasNext()) {
                Map.Entry pairs = (Map.Entry) paramIterator.next();
                parameters = parameters + pairs.getKey() + "|" + pairs.getValue() + ",";
                paramIterator.remove();
            }
            return parameters;
        } else {
            return "No test parameters";
        }
    }

    //HTML Detailed View
    public void extractParameter(String parameterName, String parameterValue, String parameterStatus) {
        if (ExtractedParameters == null) {
            this.ExtractedParameters = new LinkedHashMap<>();
        }
        ArrayList tempList = new ArrayList();
        tempList.add(parameterValue);
        tempList.add(parameterStatus);

        this.ExtractedParameters.put(parameterName, tempList);
    }

    public String getExtractedParameter(String parameterName) {
        String returnedValue = "";
        try 
        {
            ArrayList returnedList = this.ExtractedParameters.get(parameterName);
            returnedValue = returnedList.get(0).toString();

            if (returnedValue == null) 
            {
                System.err.println("[Error] Extracted parameter ' " + parameterName + " ' not found");
                returnedValue = "";
            }
        } 
        catch (Exception e) 
        {
            System.err.println("[Error] Failed to find node by name: " + parameterName + "' - " + e.getMessage());
            return returnedValue;
        }

        return returnedValue;
    }

}
