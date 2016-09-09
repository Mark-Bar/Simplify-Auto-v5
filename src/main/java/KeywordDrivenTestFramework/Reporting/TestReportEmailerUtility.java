/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Reporting;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.Enums.ResultStatus;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Utilities.ApplicationConfig;
import KeywordDrivenTestFramework.Utilities.ConversionUtility;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static KeywordDrivenTestFramework.Entities.Enums.ResultStatus.*;
import static java.lang.System.err;

/**
 *
 * @author Brendan
 */
public class TestReportEmailerUtility extends BaseClass {

    ApplicationConfig appConfig = new ApplicationConfig();
    int testCount = 0;
    int failCount = 0;
    int passCount = 0;
    long totalSeconds = 0;
    long totalMinutes = 0;
    long totalHours = 0;
    Calendar calendar = Calendar.getInstance();
    Timestamp currentTimestamp = new Timestamp(calendar.getTime().getTime());
    
    Enums.BrowserType browser = ApplicationConfig.SelectedBrowser();

    List<TestResult> testResults;
    String[] emailRecipients;
    String emailSender;
    String emailSubject;
    String emailHost;
    List<String> dataColumnName;

    long testDuration;

    StringBuilder HtmlEmailBody;
    TestResult testResult;

    public TestReportEmailerUtility(List<TestResult> _testResults/*, String inputFilePath*/) {
        this.testResults = _testResults;
        this.emailRecipients = ApplicationConfig.MailingList();
        this.emailSender = ApplicationConfig.EmailSender();
        this.emailHost = ApplicationConfig.EmailHost();
        //inputFilePath = inputFilePath;
        HtmlEmailBody = new StringBuilder();

        this.CalculateTestStatistics();
    }

    public String GenerateTestReport() {
        
        ConversionUtility convUtil = new ConversionUtility();
        GenerateDatabase();
        
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateTime = dateFormatter.format(calendar.getTime());

        HtmlEmailBody.append("<!doctype html>\n");
        HtmlEmailBody.append("<html lang='en'>\n");

        HtmlEmailBody.append("<head>\n");
        HtmlEmailBody.append("<meta charset='utf-8'>\n");
        HtmlEmailBody.append("<title style=\"font-family:verdana;\">Automation Test Report - ").append(resolveScenarioName()).append("</title>\n");
        
        HtmlEmailBody.append( "<script src=\"http://code.jquery.com/jquery-1.5.1.min.js\" type=\"text/javascript\"></script>\n");
        HtmlEmailBody.append("<script type=\"text/javascript\">\n") ;
        HtmlEmailBody.append("$(document).ready(function () {$('.testResultRowHeader').click(function () {$(this).next('.testCaseResultRows').slideToggle(200);});});\n");        
        HtmlEmailBody.append("</script>\n");
        
        HtmlEmailBody.append("</head>\n\n");

        HtmlEmailBody.append("<body>\n");

        HtmlEmailBody.append("<h1 style=\"font-family:verdana;\">Automation Test Report - ").append(resolveScenarioName()).append(" On - ").append(currentEnvironment.toString()).append(" Environment</h1>\n");
        HtmlEmailBody.append("<h3 style=\"font-family:verdana;\">Report date - ").append(dateTime).append("</h2>\n");
        HtmlEmailBody.append("<h3 style=\"font-family:verdana;\">Browser Type: ").append(browser).append("</h2>\n");
        //HtmlEmailBody.append( "<h3>Test statistics</h3>\n" );

        HtmlEmailBody.append("<table cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" style=\" border-collapse:collapse; font-family:verdana; border:1px solid black\">\n");

        HtmlEmailBody.append("<tr>\n");
        HtmlEmailBody.append("<td colspan=\"4\" style=\"background-color:#FFA500; font-size: 15pt\">Test Statistics</td>\n");
        HtmlEmailBody.append("</tr>\n");

        HtmlEmailBody.append("<tr style=\"outline: thin solid black;\">\n");
        HtmlEmailBody.append("<th style=\"border-left:1px solid black;background-color:#B2B2B2;color:#ffffff;\">Total Tests</th>\n");
        HtmlEmailBody.append("<th style=\"border-left:1px solid black;background-color:#B2B2B2;color:#ffffff;\">Total Passed</th>\n");
        HtmlEmailBody.append("<th style=\"border-left:1px solid black;background-color:#B2B2B2;color:#ffffff;\">Total Failed</th>\n");
        HtmlEmailBody.append("<th style=\"border-left:1px solid black;background-color:#B2B2B2;color:#ffffff;\">Total Runtime</th>\n");
        HtmlEmailBody.append("</tr>\n");

        HtmlEmailBody.append("<tr style=\"outline: thin solid black;\">\n");
        HtmlEmailBody.append("<td style=\"border-left:1px solid black;text-align:center;\">").append(this.testCount).append("</td>\n");
        HtmlEmailBody.append("<td style=\"border-left:1px solid black;text-align:center;\">").append(this.passCount).append("</td>\n");
        HtmlEmailBody.append("<td style=\"border-left:1px solid black;text-align:center;\">").append(this.failCount).append("</td>\n");
        HtmlEmailBody.append("<td style=\"border-left:1px solid black;text-align:center;\">" + this.totalHours + " hour(s), " + this.totalMinutes + " minute(s), " + this.totalSeconds + " second(s)</td>\n");
        HtmlEmailBody.append("</tr>\n");

        HtmlEmailBody.append("</table>\n");

        HtmlEmailBody.append("<table cellpadding=\"2\" cellspacing=\"0\" width=\"100%\" style=\" border-collapse:collapse;font-family:verdana; border:1px solid black;\">\n");

        HtmlEmailBody.append("<tr>\n");
        HtmlEmailBody.append("<td colspan=\"6\" style=\"background-color:#FFA500; font-size: 15pt\">Results Summary</td>\n");
        HtmlEmailBody.append("</tr>\n");

        HtmlEmailBody.append("<tr style=\"outline: thin solid black;\">\n");
        HtmlEmailBody.append("<th style=\"border-left:1px solid black;background-color:#B2B2B2;color:#ffffff;\">Test Case ID</th>\n");
        HtmlEmailBody.append("<th style=\"border-left:1px solid black;background-color:#B2B2B2;color:#ffffff;\">Keyword</th>\n");
        HtmlEmailBody.append("<th style=\"border-left:1px solid black;background-color:#B2B2B2;color:#ffffff;\">Test Description</th>\n");
        HtmlEmailBody.append("<th style=\"border-left:1px solid black;background-color:#B2B2B2;color:#ffffff;\">Pass \\ Fail</th>\n");
        HtmlEmailBody.append("<th style=\"border-left:1px solid black;background-color:#B2B2B2;color:#ffffff;\">Test Message</th>\n");
        HtmlEmailBody.append("<th style=\"border-left:1px solid black;background-color:#B2B2B2;color:#ffffff;\">Test Duration</th>\n");
        HtmlEmailBody.append("</tr>\n");

        for (TestResult testResult : testResults) {
            
            String bgColourString = this.getBackGroundColourForTestStatus(testResult.testStatus);  
            String testStatus = testResult.testStatus.toString();            
            String extractedCheck = "";
            String pointerStyle = "";
            
            if(testResult.testData.ExtractedParameters != null)
            {
                extractedCheck = "*";
                pointerStyle = "style=\"cursor: pointer;\"";
            }
            
            HtmlEmailBody.append("<tbody ").append(pointerStyle).append(" class=\"testResultRowHeader\" width=\"100%\">\n");
            HtmlEmailBody.append("<tr style=\"outline: thin solid black;\">\n");  
            
            HtmlEmailBody.append("<td  bgcolor=\"").append(bgColourString).append("\" style=\"border-left:1px solid black;\">").append(testResult.testData.TestCaseId).append(extractedCheck).append("</td>\n");
            HtmlEmailBody.append("<td style=\"border-left:1px solid black;\">" + testResult.testData.TestMethod + "</td>\n");
            HtmlEmailBody.append("<td style=\"border-left:1px solid black;\">").append(testResult.testData.TestDescription).append("</td>\n");
            
            
            
            if(testResult.testStatus == FAIL)
            {
                HtmlEmailBody.append("<td style=\"border-left:1px solid black;\">").append(testStatus).append(" | " + "<img style=\"min-width: 200px; min-height: 150px;\" alt=\"Failure Screenshot\" src=\"data:image/png;base64,").append("\" />"
                        + "</td>\n");
            }
            else
                HtmlEmailBody.append("<td style=\"border-left:1px solid black;\">").append(testStatus).append("</td>\n");
            
            

            HtmlEmailBody.append("<td style=\"border-left:1px solid black;\">").append(testResult.errorMessage).append("</td>\n");

            HtmlEmailBody.append("<td style=\"border-left:1px solid black;\">").append(testResult.calculateFormattedTestTime()).append("</td>\n");
            HtmlEmailBody.append("</tr>\n");
            HtmlEmailBody.append("</tbody>\n");
            
            if(testResult.testData.ExtractedParameters != null)
            {
                int extractedSize = testResult.testData.ExtractedParameters.size();
                String extractedBGColourString; 
                double cellWidth = 100/extractedSize;

                HtmlEmailBody.append("<tbody colspan=\"6\" width=\"100%\" class=\"testCaseResultRows\" style = \"display : none; border-collapse:collapse;font-family:verdana; border:1px solid black;\" cellpadding=\"2\" cellspacing=\"0\"\">\n");
                HtmlEmailBody.append("<tr>\n");
                HtmlEmailBody.append("<td colspan=\"6\">\n");
                HtmlEmailBody.append("<table colspan=\"6\" width=\"100%\"  style = \"border-collapse:collapse;font-family:verdana; border:1px solid black;\" cellpadding=\"2\" cellspacing=\"0\"\">\n");
                HtmlEmailBody.append("<tr>\n");
                HtmlEmailBody.append("<td colspan=\"").append(extractedSize).append("\" style=\"background-color:#FFA500; font-size: 15pt; border-collapse:collapse; font-family:verdana; border:2px solid black\">Extracted Test Data</td>\n");
                HtmlEmailBody.append("</tr>\n");
                
                HtmlEmailBody.append("<tr style=\"outline: thin solid black;\" colspan=\"6\">\n");
                for(Map.Entry<String,ArrayList<String>> entry : testResult.testData.ExtractedParameters.entrySet())
                {
                    extractedBGColourString = this.getBackGroundColourForParameterStatus(entry.getValue().get(1).toUpperCase());  
                    HtmlEmailBody.append("<td bgcolor = \"").append(extractedBGColourString).append("\" style=\"border-left:1px solid black;\" width=\"").append(cellWidth).append("%\">").append(entry.getKey()).append("</td>\n");
                }
                HtmlEmailBody.append("</tr>\n");
                
                HtmlEmailBody.append("<tr style=\"outline: thin solid black;\" colspan=\"6\">\n");
                for(Map.Entry<String,ArrayList<String>> entry : testResult.testData.ExtractedParameters.entrySet())
                {
                    extractedBGColourString = this.getBackGroundColourForParameterStatus(entry.getValue().get(1).toUpperCase());  
                    HtmlEmailBody.append("<td bgcolor = \"").append(extractedBGColourString).append("\" style=\"border-left:1px solid black;\" width=\"").append(cellWidth).append("\">").append(entry.getValue().get(0)).append("</td>\n");
                }
                HtmlEmailBody.append("</tr>\n");
                
                HtmlEmailBody.append("<tr>\n");
                HtmlEmailBody.append("<td colspan=\""+extractedSize+"\" style=\"background-color:#FFA500; font-size: 12pt; border-collapse:collapse; font-family:verdana; border:2px solid black\"><span style=\"background-color:#B2FCA3;\">Green = Pass</span>;<span style=\"background-color:#FF9494;\">Red = Fail</span>;<span style=\"background-color:#BDBDBD;\">Grey = Unchecked</span></td>\n");
                HtmlEmailBody.append("</tr>\n");
                
                HtmlEmailBody.append("</table>");
                HtmlEmailBody.append("</td>\n");
                HtmlEmailBody.append("</tr>\n");
                HtmlEmailBody.append("</tbody>");
                HtmlEmailBody.append("</tr>\n");
            }            
        }

        HtmlEmailBody.append("</table>\n");
        
        HtmlEmailBody.append("<p style=\"font-size: 10pt; font-family:verdana\">* Click for extracted parameters</p>\n");
        
        HtmlEmailBody.append("</body>\n\n");

        HtmlEmailBody.append("</html>\n");

        this.saveAsHTMLTestReport(resolveScenarioName() + ".html");

        return HtmlEmailBody.toString();
    }
    
    private String getBackGroundColourForTestStatus(ResultStatus testStatus)
    {
        switch(testStatus)
        {
            case PASS:
                return "#B2FCA3";
            case FAIL:
                return "#FF9494";
            case WARNING:
                return "#FF9900";
            default:
                return "#FF9900";
        }
    }
    
    private String getBackGroundColourForParameterStatus(String parameterStatus)
    {
        switch(parameterStatus)
        {
            case "PASS":
                return "#B2FCA3";
            case "FAIL":
                return "#FF9494";
            default:
                return "#BDBDBD";
        }
    }


    private void saveAsHTMLTestReport(String htmlReportFileName) {

        try {

            if (TestReportEmailerUtility.reportDirectory != null) {
                File evidenceReportFile = new File(TestReportEmailerUtility.reportDirectory + "\\" + htmlReportFileName);

                if (!evidenceReportFile.exists()) {
                    evidenceReportFile.createNewFile();
                }

                try {
                    try (BufferedWriter writerEvidence = new BufferedWriter(new FileWriter(evidenceReportFile))) {
                        writerEvidence.write(HtmlEmailBody.toString());
                        
                        evidenceReportFile = null;
                    }
                } catch (Exception ex2) {
                    err.println("[ERROR] Failed to save HTML test report to evidence folder - " + ex2.getMessage());
                }
            }

            File reportFile = new File("HTMLTestReport\\HTMLTestReport.html");

            if (!reportFile.exists()) {
                reportFile.createNewFile();
            }

            try {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile))) {
                    writer.write(HtmlEmailBody.toString());
                    
                    reportFile = null;
                }
            } catch (Exception ex1) {
                err.println("[ERROR] Failed to save HTML test report to HTML Test Report directory - " + ex1.getMessage());
            }
        } catch (Exception e) {
            System.err.println("[Error] Failed to save HTML report to - HTMLTestReport.html - Error - " + e.getMessage());
        }

    }

    public void SendResultsEmail() {
        try {
            Properties properties = System.getProperties();

            properties.setProperty("mail.smtp.host", this.emailHost);
            properties.setProperty("mail.user", "ferdinandN");
            properties.setProperty("mail.password", "password");

            Session session = Session.getDefaultInstance(properties);

            MimeMessage message = new MimeMessage(session);

            message.setSubject("SeeCrypt - Automation Test Report - " + this.resolveScenarioName());

            MimeMultipart multipartMessage = new MimeMultipart();

            MimeBodyPart messageBody = new MimeBodyPart();
            MimeBodyPart attachment = new MimeBodyPart();
            DataSource inputFile = new FileDataSource(TestReportEmailerUtility.inputFilePath);

            messageBody.setContent(this.GenerateTestReport(), "text/html");
            
            

            message.setFrom(new InternetAddress(this.emailSender));

            for (String recipient : this.emailRecipients) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            }

            attachment.setDataHandler(new DataHandler(inputFile));
            attachment.setHeader("Content-ID", "<" + UUID.randomUUID().toString() + ">");
            attachment.setFileName(inputFile.getName());

            multipartMessage.addBodyPart(messageBody);
            multipartMessage.addBodyPart(attachment);

            message.setContent(multipartMessage);

            Transport.send(message);

            System.out.println("Report Email sent...");

        } catch (Exception e) {
            System.err.println("[Error] could not send results email - " + e.getMessage());
        }

    }
    
   public void GenerateDatabase()
    {
        
       try {
           
            dataColumnName = new ArrayList<>();
            String host="jdbc:derby://localhost:1527/TestResults";
            String username= "Test";
            String userPassword="Test";
           try (Connection conn = DriverManager.getConnection(host,username,userPassword)) {
               Statement statement;
               String sql;
               String insert;
               String select;
               String newcolumn;
               String update;
               
               statement = conn.createStatement();
               
               DatabaseMetaData dbmd = conn.getMetaData();
               
               ResultSet testData = dbmd.getTables(null, null, "TESTRESULTS",null);
               
               if (!testData.next())
               {
                   sql = "CREATE TABLE TestResults ( TimeStamp varchar(255) NOT NULL PRIMARY KEY,  Total_Tests INT, Total_Passed INT, Total_Failed INT,  Total_Hours INT, Total_Minutes INT, Total_Seconds INT)";
                   statement.executeUpdate(sql);
               }
               
               ResultSet testCaseID = dbmd.getTables(null, null, "TESTDATA", null);
               
               
               
               if (!testCaseID.next())
               {
                   sql = "CREATE TABLE TestData ( TimeStamp varchar(255) NOT NULL PRIMARY KEY, TestCaseID varchar(255), Keyword varchar(255) )";
                   statement.executeUpdate(sql);
               }
               
               ResultSet testcase = dbmd.getTables(null, null, "TESTCASE", null);
               
               if (!testcase.next())
               {
                   sql = "CREATE TABLE TestCase ( TestCaseNumber INT NOT NULL PRIMARY KEY generated always as identity,TimeStamp varchar(255) ,TestCaseID varchar(255), Keyword varchar(255), TestDescription varchar(255),  TestCaseStatus varchar(255),TestMessage varchar(255), TestDuration varchar(255),FOREIGN KEY (TimeStamp) References TestData(TimeStamp) ON DELETE CASCADE)";
                   statement.executeUpdate(sql);
                   
               }
               
               ResultSet rs = statement.executeQuery("SELECT * FROM TESTDATA");
               ResultSetMetaData rsmd = rs.getMetaData();
               
               
               for(int i=1 ; i <= rsmd.getColumnCount(); i++)
               {
                   String ColumnName = rsmd.getColumnName(i);
                   dataColumnName.add(ColumnName);
               }
               
               for (TestResult testResult : testResults) 
               {
                   
                   
                   insert = "INSERT INTO TestResults VALUES ('"+currentTimestamp.toString().substring(0, 19)+"', "+this.testCount+","+this.passCount+","+this.failCount+","+this.totalHours+","+this.totalMinutes+","+this.totalSeconds+")";
                   statement.executeUpdate(insert);
                   
                   insert = "INSERT INTO TestData (TimeStamp, TestCaseID, Keyword)  VALUES ('"+currentTimestamp.toString().substring(0, 19)+"','"+testResult.testData.TestCaseId+"', '"+testResult.testData.TestMethod+"')";
                   statement.executeUpdate(insert);
                   
                   
                   insert = "INSERT INTO TestCase (TimeStamp, TestCaseID, Keyword, TestDescription, TestCaseStatus, TestMessage, TestDuration)  VALUES ('"+currentTimestamp.toString().substring(0, 19)+"', '"+testResult.testData.TestCaseId+"', '"+testResult.testData.TestMethod+"', '"+testResult.testData.TestDescription+"', '"+testResult.testStatus.toString()+"', '"+testResult.errorMessage+"', '"+testResult.calculateFormattedTestTime()+"')";
                   statement.executeUpdate(insert);
                   
                   for(Map.Entry<String,ArrayList<String>> entry : testResult.testData.ExtractedParameters.entrySet())
                   {
                       if (!dataColumnName.contains(entry.getKey().toUpperCase()))
                       {
                           newcolumn ="ALTER TABLE TestData ADD "+entry.getKey()+" varchar(255)";
                           statement.executeUpdate(newcolumn);
                       }
                       
                       update = "Update TestData set "+entry.getKey()+" = '"+entry.getValue().get(0)+"' where TimeStamp = '"+currentTimestamp.toString().substring(0, 19)+"'";
                       statement.executeUpdate(update);
                   }
                   
               }
               
               select = "SELECT TestCase.TestCaseNumber,  TestData.TestCaseID,TestCase.KEYWORD, TestData.USERNAME, TestData.PASSWORD  FROM TestCase INNER JOIN TestData ON TestCase.TestCaseID=TestData.TestCaseID ORDER BY TestCase.TestCaseNumber";
               statement.executeQuery(select);
           }
            
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
   

    private void CalculateTestStatistics() {

        for (TestResult result : testResults) {
            this.totalSeconds += result.testDuration;
            this.testCount++;

            if (result.testStatus == PASS || result.testStatus == WARNING) {
                this.passCount++;
            } else if (result.testStatus == FAIL) {
                this.failCount++;
            }
        }

        if (totalSeconds > 60) {
            while (totalSeconds > 60) {
                totalMinutes += 1;
                totalSeconds -= 60;

            }
        }

        if (totalMinutes > 60) {
            while (totalMinutes > 60) {
                totalHours += 1;
                totalMinutes -= 60;
            }
        }
    }
   
    
    
}
    


