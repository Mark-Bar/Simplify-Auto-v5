/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Utilities.IDGenerator;

/**
 *
 * @author Micah
 */
public class GenerateGender {

    String gender;

    
    public GenerateGender(String gender) {
        this.gender = gender;
    }

    public String getGenderNumber() {
        GenerateRandBetween rand = new GenerateRandBetween();
        int genderNumber;
        if (gender.contains("Male") || gender.toLowerCase().contains("m") || gender.contains("male")) {
            genderNumber = rand.getRandBetween(9999, 5000);
        } else {
            genderNumber = rand.getRandBetween(4999, 1);
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

}
