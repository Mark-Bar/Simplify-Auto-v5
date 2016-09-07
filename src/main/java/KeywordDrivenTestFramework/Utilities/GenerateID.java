package KeywordDrivenTestFramework.Utilities;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Brendan
 */
public class GenerateID {

    private String id12 = ""; //ID Number without checksum
    private final String gender; //the gender to spesift
    private String dateOfBirth = ""; //the generated date of birth
    private String csvOutput = ""; //a variable that stores the date of birth in the fomat: yyyy,mm,dd
    private String id= "";
    private final int ageMin; //Minimum age to be spesified in comments
    private final int ageMax; //Maximum age to be spesified in comments 
    
    
    public GenerateID(String gender, int min, int max) {
        this.gender = gender;
        this.ageMin = min;
        this.ageMax = max;
    }

    //<editor-fold defaultstate="collapsed" desc="Construct ID">
    public String getID() {
        
        
        
        String genderNumber;
        String IDP13; //With checksum
        String IDP11; // 0 - Native or 1 - Foreign ; Position 11
        String IDP12; // 8 or 9 ; Posiion 12 

        

        //DOB
        dateOfBirth = getDateOfBirth();
        
        

        //Gender Number
        genderNumber = getGenderNumber();

        // IDP11
        IDP11 = Integer.toString(getRandBetween(0, 1));

        // IDP12
        IDP12 = Integer.toString(getRandBetween(8, 9));

        // ID12 ; Thats the ID without the checksum
        id12 = dateOfBirth + genderNumber + IDP11 + IDP12;
        
        //Checksum
        IDP13 = getCheckSum();

        id = (id12 + IDP13);
        
        return id;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Generate Random Number Between">
    //Random number Generator
    private int getRandBetween(int min, int max) {
        return (min + (int) Math.round(Math.random() * (max - min)));
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Calculate Checksum">
    /*
     Checksum:
     eg: "s800101 5009 087"
     -Add all the digits in the odd positions (excluding last digit).
     8 + 0 + 0 + 5 + 0 + 0 = 13...................[1]
     -Move the even positions into a field and multiply the number by 2.
     011098 x 2 = 22196
     -Add the digits of the result in b).
     2 + 2 + 1 + 9 + 6 = 20.........................[2]
     -Add the answer in [2] to the answer in [1].
     13 + 20 = 33
    
     Subtract the second digit (i.e. 3) from 10. The number must tally with the 
     last number in the ID Number. If the result is 2 digits, the last digit is 
     used to compare against the last number in the ID Number.  If the answer 
     differs, the ID number is invalid.
     */
    private String getCheckSum() {
        Long ID12 = Long.parseLong(id12);
        int oddPositions = 0;
        String evenPostionsTogetherDoubled = "";
        String afterDoubleTogether;
        int oddAndDoubleAfter;

        String checkSum;

        for (int i = 0; i < (id12.length()); i++) {
            oddPositions += Integer.parseInt(Character.toString(id12.charAt(i)));

            i++;
        }

        for (int b = 1; b < (id12.length()); b++) {
            evenPostionsTogetherDoubled += Character.toString(id12.charAt(b));
            b++;
        }

        int temp = (Integer.parseInt(evenPostionsTogetherDoubled)) * 2;
        afterDoubleTogether = Integer.toString(temp);

        int sum = 0;
        for (int z = 0; z < afterDoubleTogether.length(); z++) {
            sum += Integer.parseInt(Character.toString(afterDoubleTogether.charAt(z)));
        }

        oddAndDoubleAfter = oddPositions + sum;

        String oddAndDStr = Integer.toString(oddAndDoubleAfter);
        oddAndDStr = oddAndDStr.substring(1, (oddAndDStr.length()));

        int checkSumInt = 10 - (Integer.parseInt(oddAndDStr));

        checkSum = Integer.toString(checkSumInt);

        if (checkSum.length() == 2) {
            checkSum = Character.toString(checkSum.charAt(1));
        }

        return checkSum;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Generate Gender Number">
    //Generates a gender number
    private String getGenderNumber() {
        int genderNumber;
        if (gender.contains("Male")) {
            genderNumber = getRandBetween(9999, 5000);
        } else {
            genderNumber = getRandBetween(4999, 1);
        }

        String genderStr = Integer.toString(genderNumber);
        switch (genderStr.length()) {
            case 1:
                genderStr = "000" + genderStr;
                break;
            case 2:
                genderStr = "00" + genderStr;
                break;
            case 3:
                genderStr = "0" + genderStr;
                break;
            default:
                break;
        }

        return genderStr;
    }

    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Generate Date of Birth:">
    //Generates a date of birth between the min and max age specified in the constuctor
    private String getDateOfBirth() {
        int yearGen;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        GregorianCalendar gc = new GregorianCalendar();

        yearGen = getRandBetween((currentYear - ageMin), (currentYear - ageMax));//Generates the random number between the min and max age spesified.

        gc.set(GregorianCalendar.YEAR, yearGen);

        int dayOfYear = getRandBetween(1, gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));
        int yearMinus = 1900;

        if (ageMin < 15 || ageMax < 15) {
            yearMinus = 2000;
        }

        dateOfBirth = Integer.toString((gc.get(GregorianCalendar.YEAR)) - yearMinus);
        if (dateOfBirth.length() == 1) { //Adds a 0 if there is only one position
            dateOfBirth = "0" + dateOfBirth;
        }
        
        int genMonth = getRandBetween(1, gc.getActualMaximum(GregorianCalendar.MONTH));
        String month = Integer.toString(genMonth);
        if (month.length() == 1) {  //Adds a 0 if there is only one position
            month = "0" + month;

        }
        
        int genDay = getRandBetween(1, gc.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
        String day = Integer.toString(genDay);
        if (day.length() == 1) {  //Adds a 0 if there is only one position
            day = "0" + day;

        }

        dateOfBirth += month;
        dateOfBirth += day;

        csvOutput = Integer.toString((gc.get(GregorianCalendar.YEAR))) + ",";
        csvOutput += month + ",";
        csvOutput += day;

        return dateOfBirth;
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters and setters:">
    public String getCsvOutput() {
        return csvOutput;
    }

    // </editor-fold>
}
