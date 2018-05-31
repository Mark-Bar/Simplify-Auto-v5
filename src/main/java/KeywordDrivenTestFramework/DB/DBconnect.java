package KeywordDrivenTestFramework.DB;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Mark.Barfoot on 2016-11-07.
 */

//STEP 1. Import required packages


public class DBconnect {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://24cpt-devsql04;DatabaseName=Careers24";

    //  Database credentials
    static final String USER = "dev";
    static final String PASS = "dev";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected to database...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT [guid]\n" +
                    "      ,[candidateid]\n" +
                    "      ,[jobtitle]\n" +
                    "      ,[employer]\n" +
                    "      ,[description]\n" +
                    "      ,[jobtypeid]\n" +
                    "      ,[salary]\n" +
                    "      ,[startmonth]\n" +
                    "      ,[startyear]\n" +
                    "      ,[endmonth]\n" +
                    "      ,[endyear]\n" +
                    "      ,[sectorid] FROM [CandidateWorkHistory] WHERE id IN (2,5)";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String guid = rs.getString("guid");
                int candidateid  = rs.getInt("candidateid");
                String jobtitle = rs.getString("jobtitle");
                String employer = rs.getString("employer");
                String description = rs.getString("description");
                int jobtypeid = rs.getInt("jobtypeid");
                int salary = rs.getInt("salary");
                int startmonth = rs.getInt("startmonth");
                int startyear = rs.getInt("startyear");
                int endmonth = rs.getInt("endmonth");
                int endyear = rs.getInt("endyear");
                int sectorid = rs.getInt("sectorid");





//                String first = rs.getString("first");
//                String last = rs.getString("last");

                //Display values
                System.out.print("Guid: " + guid);
                System.out.print("\n");
                System.out.print("Candidate ID: " + candidateid);
                System.out.print("\n");
                System.out.print("Job Title: " + jobtitle);
                System.out.print("\n");
                System.out.print("Employer: " + employer);
                System.out.print("\n");
                System.out.print("Description: " + description);
                System.out.print("\n");
                System.out.print("Job Type ID: " + jobtypeid);
                System.out.print("\n");
                System.out.print("Salary: " + salary);
                System.out.print("\n");
                System.out.print("Start Month: " + startmonth);
                System.out.print("\n");
                System.out.print("Start Year: " + startyear);
                System.out.print("\n");
                System.out.print("End Month: " + endmonth);
                System.out.print("\n");
                System.out.print("End Year: " + endyear);
                System.out.print("\n");
                System.out.print("Sector ID: " + sectorid);
                System.out.print("\n");




            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("");
    }//end main
}//end FirstExample




//public class DBconnect {
//
//    public DBconnect() throws SQLException {
//
//         public class FirstExample {
//            // JDBC driver name and database URL
//            static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//            static final String DB_URL = "jdbc:mysql://";
//
//            //  Database credentials
//            static final String USER = "username";
//            static final String PASS = "password";
//
//            public void main(String[] args) {
//                Connection conn = null;
//                try{
//                    //STEP 2: Register JDBC driver
//                    Class.forName("com.mysql.jdbc.Driver");
//
//                    //STEP 3: Open a connection
//                    System.out.println("Connecting to database...");
//                    conn = DriverManager.getConnection(DB_URL,USER,PASS);
//                }catch(SQLException se){
//                    //Handle errors for JDBC
//                    se.printStackTrace();
//                }catch(Exception e){
//                    //Handle errors for Class.forName
//                    e.printStackTrace();
//                }finally{
//                    try{
//                        if(conn!=null)
//                            conn.close();
//                    }catch(SQLException se){
//                        se.printStackTrace();
//                    }//end finally try
//                }//end try
//                System.out.println("Closed Connection");
//            }//end main
//        }//end FirstExample
//    }
//}
