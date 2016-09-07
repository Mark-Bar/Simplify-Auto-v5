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
public class GenerateRandBetween {
    int min;
    int max;

    public GenerateRandBetween(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public GenerateRandBetween() {
    }
    
    
    
    public int getRandBetween(int min, int max){
        return (min + (int) Math.round(Math.random() * (max - min)));
    }
          
}
