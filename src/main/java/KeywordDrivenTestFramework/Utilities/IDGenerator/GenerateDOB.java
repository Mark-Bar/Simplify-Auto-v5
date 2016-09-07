package KeywordDrivenTestFramework.Utilities.IDGenerator;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Micah de Villiers
 */
public class GenerateDOB {

    int ageMin;
    int ageMax;
    String iDdateOfBirth;
    String CSVOutput;
    String dateOfBirth;
    
    public GenerateDOB(int ageMin, int ageMax) {
        this.ageMin = ageMin;
        this.ageMax = ageMax;
    }

    public String getIdDateOfBirth() {
        int yearGen;
        
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        GregorianCalendar gc = new GregorianCalendar();

        GenerateRandBetween rand = new GenerateRandBetween();
        yearGen = rand.getRandBetween((currentYear - ageMin), (currentYear - ageMax));//Generates the random number between the min and max age spesified.

        gc.set(GregorianCalendar.YEAR, yearGen);

        int dayOfYear = rand.getRandBetween(1, gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));
        int yearMinus = 1900;

        if (ageMin < 15 || ageMax < 15) { //To get the year into ID format (short year) to do that I just subtract
            yearMinus = 2000;
        }

        iDdateOfBirth = Integer.toString((gc.get(GregorianCalendar.YEAR)) - yearMinus);
        dateOfBirth = Integer.toString(gc.get(GregorianCalendar.YEAR)) + ",";
        
        if (iDdateOfBirth.length() == 1) { //Adds a 0 if there is only one position
            iDdateOfBirth = "0" + iDdateOfBirth;
        }

        String month = Integer.toString(gc.get(GregorianCalendar.MONTH));
        if (month.length() == 1) {  //Adds a 0 if there is only one position
            month = "0" + month;

        }

        String day = Integer.toString(gc.get(GregorianCalendar.DAY_OF_MONTH));
        if (day.length() == 1) {  //Adds a 0 if there is only one position
            day = "0" + day;

        }

        iDdateOfBirth += month;
        dateOfBirth += month + ",";
        iDdateOfBirth += day;
        dateOfBirth += day;

        CSVOutput = Integer.toString((gc.get(GregorianCalendar.YEAR)) - 1900) + ",";
        CSVOutput += month + ",";
        CSVOutput += day;

        return iDdateOfBirth;
    }
    
    
    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getCSVOuput() {
        return CSVOutput;
    }

}
