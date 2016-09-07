/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestSuites;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Testing.TestMarshall;
import KeywordDrivenTestFramework.Utilities.ApplicationConfig;
import org.junit.Test;

/**
 *
 * @author Abongile Bonga Maso
 */
public class MainTest extends BaseClass{

    private static TestMarshall instance;

    public MainTest() {
        currentEnvironment = Enums.Environment.Spree;
    }

    @Test
    public void RunSpree() throws Exception {
        System.out.println("Spree Test Cases");
        instance = new TestMarshall("C:\\Users\\Brendan TestHeroes\\Desktop\\Spree-Final\\src\\test\\resources\\TestPack.xlsx", Enums.BrowserType.Chrome);
        instance.runKeywordDrivenTests();
    }

}