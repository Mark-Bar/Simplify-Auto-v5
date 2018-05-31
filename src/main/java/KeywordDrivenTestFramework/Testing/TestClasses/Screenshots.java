package KeywordDrivenTestFramework.Testing.TestClasses;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class Screenshots {

    public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
        fileName = fileName + ".png";
        String directory = "C:\\Users\\Mark.Barfoot\\Desktop\\Automation Screenshots";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        String destination = directory + fileName;
        return destination;
    }
}
