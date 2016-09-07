/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Entities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Brendan
 */

// This class contains the definition for a collection of data retrieved from the browser
// during a test run - if a test needs to store a reference number for example.
 
public class RetrievedTestValues 
{
    public Map<String,String> RetrievedValuesList; 
    
    public RetrievedTestValues()
    {

    }
    
    public void addParameter(String retrievedValueName, String retrievedValue)
	{
            if(RetrievedValuesList == null)
            {
                    this.RetrievedValuesList = new HashMap<>();
            }
            this.RetrievedValuesList.put(retrievedValueName, retrievedValue);
	}
    
}


