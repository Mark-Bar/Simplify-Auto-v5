package KeywordDrivenTestFramework.Entities;

/**
 * 
 * User: Brendan
 * 
 * 
 * To change this template use File | Settings | File Templates.
 */
public class Enums
{
    public enum BrowserType {
        IE, FireFox, Chrome, Safari, Headless
    }

    public enum ResultStatus
    {
        PASS, FAIL, WARNING, UNCERTAIN
    }
    
    public enum RelativePosition
    {
        Above, Below, Right, Left
    }
    
    public enum Environment
    {
        // Add environment urls here, parameter order is defined by the constructor (Environment) definition below
        // Please note that adding an addtional environment type will require you to comma-seperate them.
        // Visit http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html to learn more about Java Enum declarations. 
       
        // Here we are declaring the Dev Environment type, and passing the following two properties, a url and a connection string, 
        // which are defined below as both being string literals:
        
        // DEV[FirstPageURL,FirstDatabaseConnectionString]
        
        Spree("http://stage.spreeza.net/");
        
        
        
        // For each system (website1, database1, website2 etc.) within the defined environment (Dev, QA, Prod etc.)
        // you will have to declare the appropriate string to store its properties (URL or connection string etc.).
        
        public final String SpreeURL;
        
        
        
        
//        public final String ForgotPasswordURL;
        
        // This constructor defines and instantiates the parameters declared above. Parameter order is specified here and will 
        // define the order in which the enum types' properties are specified. 
        Environment(String pageUrl)
        {
            
            this.SpreeURL = pageUrl;
            
        }
       
                
    }


}
