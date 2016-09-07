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
public class CheckSum {
    private final String ID;

    public CheckSum(String ID) {
        this.ID = ID;
    }
    
    /*
     Checksum:
     eg: "800101 5009 087"
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
    
    public String getCheckSum(){
        Long ID12 = Long.parseLong(ID);
        int oddPositions = 0;
        String evenPostionsTogetherDoubled = "";
        String afterDoubleTogether;
        int oddAndDoubleAfter;
        
        String checkSum;
        
        for (int i = 0; i < (ID.length()); i++) {
            oddPositions += Integer.parseInt(Character.toString(ID.charAt(i)));

            i++;
        }

        for (int b = 1; b < (ID.length()); b++) {
            evenPostionsTogetherDoubled += Character.toString(ID.charAt(b));
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
    
    
}
