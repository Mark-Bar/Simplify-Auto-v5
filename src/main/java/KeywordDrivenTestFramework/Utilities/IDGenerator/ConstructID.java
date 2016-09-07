/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Utilities.IDGenerator;

/**
 *
 * @author Micah de Villiers
 */
public class ConstructID {

    String gender;
    String CSVOutput;
    int min;
    int max;

    public ConstructID(String gender, int min, int max) {
        this.gender = gender;
        this.min = min;
        this.max = max;

    }

    public String getID() {

        String id = ""; //without checksum
        String dob = "";
        String genderNumber = "";
        String idp13 = ""; //checksum
        String idp11 = ""; // 0 - Native or 1 - Foreign ; Position 11
        String idp12 = ""; // 8 or 9 ; Posiion 12 

        
            
                GenerateRandBetween genRand = new GenerateRandBetween();

                //DOB
                GenerateDOB genDOB = new GenerateDOB(min, max); 
                dob = genDOB.getIdDateOfBirth();
                
                CSVOutput = genDOB.getCSVOuput();
                
                //Gender Number
                GenerateGender genGender = new GenerateGender(gender); 
                genderNumber = genGender.getGenderNumber();
                
                // IDP11
                idp11 = Integer.toString(genRand.getRandBetween(0, 1));
               
                // IDP12
                idp12 = Integer.toString(genRand.getRandBetween(8, 9));
                
                // ID12 ; Thats the ID without the checksum
                id = dob + genderNumber + idp11 + idp12;
                
                //Checksum
                CheckSum checkSum = new CheckSum(id);
                idp13 = checkSum.getCheckSum();
                
                id += idp13;
            

       

        return id;
    }

}
