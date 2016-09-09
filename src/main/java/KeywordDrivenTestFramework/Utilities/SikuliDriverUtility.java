/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package KeywordDrivenTestFramework.Utilities;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums.RelativePosition;
import org.apache.commons.io.FileUtils;
import org.sikuli.basics.Settings;
import org.sikuli.script.Button;
import org.sikuli.script.*;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static KeywordDrivenTestFramework.Entities.Enums.RelativePosition.Right;

/**
 *
 * @author Brendan
 */
public class SikuliDriverUtility extends BaseClass 
{
    public Screen Desktop;
    
    public Region ScreenRegion;
    
    public String ScreenshotDirectory;
    
    Process seeTestManual;
    
    public SikuliDriverUtility(String screenShotDir)
    {
        this.Desktop = new Screen();
        this.ScreenshotDirectory = screenShotDir;
        Settings.OcrTextSearch = true;


    }
    
    public boolean openSeeTest()
    {
        try
        {
            Desktop = new Screen();
            
            String seeTestExecutablePath = ApplicationConfig.SeeTestExecutablePath();
            this.seeTestManual = Runtime.getRuntime().exec(seeTestExecutablePath);
            
            if(!this.WaitForElementToAppear("SeeTestManualWindowTitle.PNG"))
            {
                System.err.println("Error opening application - SeeTestManual - could not verify dialog window title");
                return false;
            }
            
            return true;
        }
        catch(Exception e)
        {
            System.err.println("Error opening application - SeeTestManual - please make sure that the application is installed and that the path is correclty set in the appConfig " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean openDevice(String deviceListingRow, String deviceWindowTitle)
    {
        try
        {
            if(this.WaitForElementToAppearAdjacentTo(deviceListingRow, "deviceOfflineStatus.png", Right))
            {
                System.err.println("Device disconnected - please connect device and confirm connection before running the test");
                return false;
            }
            
            
            
            if(!this.WaitForElementToAppearAdjacentTo(deviceListingRow,"ReadyStatus.png" , Right))
            {
                System.err.println("Device not ready for connection - please connect device and confirm connection before running the test");
                return false;
            }
            
            this.MouseClickElement(deviceListingRow);
            
            this.MouseClickElement("OpenDeviceIcon.png");
            
            this.WaitForElementToAppear(deviceWindowTitle);

            return true;
        }
        catch(Exception e)
        {
            System.err.println("Error opening device, check connection - " + e.getMessage());
            return false;
        }
    
    }
    
    public boolean verifyElementPresent(String elementImagePath, int timeOutInMiliseconds)
     {
         try
         { 
            this.ScreenRegion = Desktop.wait(elementImagePath, timeOutInMiliseconds);
            
            if(this.ScreenRegion != null)
            {
                this.ScreenRegion.highlight(1);
                return true;
            }
            else
            { 
                System.out.println("[Info] Element not present - " + elementImagePath);
                return false;
            }
         }
         catch(Exception e)
         {
             System.err.println("Error verifying element present - " + elementImagePath + " - Error - " + e.getMessage());
             return false;
         }
     }   
      
    public boolean exitSeeTest()
    {
        try
        {        
            this.seeTestManual.destroy();
            
            return true;
        }
        catch(Exception e)
        {
            System.err.println("Error closing application - SeeTest Manual - " + e.getMessage());
            return false;
        }
    
    }
    
    
    //</editor-fold>
    
    public void setScreenshotDirectory(String screenShotDir)
    {
        this.ScreenshotDirectory = screenShotDir;
    }
    
    public boolean MouseClickElement(String ImageFilePath)
    {
        try
        {
            if(this.WaitForElementToAppear(ImageFilePath))
            {
                
                this.Desktop.find(this.ScreenshotDirectory + ImageFilePath).click();
                return true;
            }
            else
                return false;     
        }
        catch(Exception e)
        {
            
            System.err.println("[Error] Failed to click element, image: {" + ImageFilePath + "}, error :" + e.getMessage());
            return false;
        }
    }
    
    public boolean MouseDoubleClickElement(String ImageFilePath)
    {
        try
        {
            if(this.WaitForElementToAppear(ImageFilePath))
            {          
                this.Desktop.find(this.ScreenshotDirectory + ImageFilePath).highlight(1).doubleClick();
                return true;
            }
            else
                return false;     
        }
        catch(Exception e)
        {
            
            System.err.println("[Error] Failed to double click element, image: {" + ImageFilePath + "}, error :" + e.getMessage());
            return false;
        }
    }
    
    public boolean MouseTripleClickElement(String ImageFilePath, String regionFile, int x, int y) {
        try {

            Region otpRegion = this.Desktop.wait(this.ScreenshotDirectory + regionFile, 30).highlight(1);

            Pattern otpPattern = new Pattern(this.ScreenshotDirectory + ImageFilePath).targetOffset(x, y);

            otpRegion.above().find(otpPattern).highlight(1).click();

            otpRegion.above().find(otpPattern).mouseDown(Button.LEFT);
            otpRegion.above().find(otpPattern).mouseUp();

            otpRegion.above().find(otpPattern).mouseDown(Button.LEFT);
            otpRegion.above().find(otpPattern).mouseUp();

            return true;

        } catch (Exception e) {

            System.err.println("[Error] Failed to click element, image: {" + ImageFilePath + "}, error :" + e.getMessage());
            return false;
        }
    }
    
    public boolean WaitForEitherImageToAppear(String imageOne, String imageTwo) {
        boolean result = false;
        if(this.WaitForElementToAppearThrowsNoError(imageOne)){
            result = true;
        }
        else if(this.WaitForElementToAppearThrowsNoError(imageTwo)){
            result = true;
        }
        
        return result;
        
    }
    
    public boolean WaitSpecificTimeElementAppear(String ImageFilePath, int timeOut) {
        try {
            this.Desktop.wait(this.ScreenshotDirectory + ImageFilePath, timeOut).highlight(1);

            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to find element on desktop, image: {" + ImageFilePath + "}, error :" + e.getMessage());
            return false;
        }
    }
    
    public boolean MouseRightClickElement(String ImageFilePath)
    {
        try
        {
            if(this.WaitForElementToAppear(ImageFilePath))
            {
                this.Desktop.find(this.ScreenshotDirectory + ImageFilePath).highlight(1).rightClick();
                return true;
            }
            else
                return false;     
        }
        catch(Exception e)
        {
            
            System.err.println("[Error] Failed to right click element, image: {" + ImageFilePath + "}, error :" + e.getMessage());
            return false;
        }
    }
    
    
    public boolean TypeTextAtElement(String ImageFilePath, String InputText)
    {
        try
        {
            if(this.WaitForElementToAppear(ImageFilePath))
            {
                this.Desktop.find(this.ScreenshotDirectory + ImageFilePath).type(InputText);
                return true;
            }
            else
                return false;     
        }
        catch(Exception e)
        {
            
            System.err.println("[Error] Failed to enter text at element, image: {" + ImageFilePath + "}, error :" + e.getMessage());
            return false;
        }
    }
    
    public boolean WaitForElementToAppear(String ImageFilePath)
    {
        try
        {
            this.Desktop.wait(this.ScreenshotDirectory + ImageFilePath, ApplicationConfig.WaitTimeout()).highlight(1);
    
            return true;
        }
        catch(Exception e)
        {
            System.err.println("[Error] Failed to find element on desktop, image: {" + ImageFilePath + "}, error :" + e.getMessage());
            return false;
        }
    }
    
    
    public void TakeScreenshot(String screenshotFileName, Boolean isError)
    {
        String imageFilePathString = "";
        try
        { 
            StringBuilder imageFilePathBuilder = new StringBuilder();
            // add date time folder and test case id folder
            imageFilePathBuilder.append(SikuliDriverUtility.reportDirectory).append("\\").append(testCaseId).append("\\") ;
            
            if(isError)
            {
                imageFilePathBuilder.append("FAILED_");
            }
            else
            {
                imageFilePathBuilder.append("TEST_STATE_");
            }

            imageFilePathBuilder.append(testCaseId).append("_");

            imageFilePathBuilder.append(screenshotFileName).append("_");

            imageFilePathBuilder.append(this.generateDateTimeString()).append(".png");
            
            imageFilePathString = imageFilePathBuilder.toString();
        
            ScreenImage screenShot = this.Desktop.capture();

            FileUtils.copyFile(new File(screenShot.getFile()), new File(imageFilePathString));
        }
        catch(Exception e)
        {
            System.err.println("[Error] could not take screenshot - " + imageFilePathString + " - " + e.getMessage());
        }
    }
    
    public String generateDateTimeString()
    {
      Date dateNow = new Date( );
      SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd_hh-mm-ss");
      
      return dateFormat.format(dateNow);
    }
    public boolean copyToClipBoard()
    {
        
        try
        {
            this.Desktop.type("c", Key.C_CTRL);
    
            return true;
        }
        catch(Exception e)
        {
            System.err.println("[Error] Failed to copy content to clipboard via ctrl + C, error :" + e.getMessage());
            return false;
        }
    }
    
    public boolean pasteFromClipBoard()
    {
        
        try
        {
            this.Desktop.type("v", Key.C_CTRL);
    
            return true;
        }
        catch(Exception e)
        {
            System.err.println("[Error] Failed to paste content from clipboard via ctrl + V , error :" + e.getMessage());
            return false;
        }
    }
    
    public boolean setClipboardContents(String aString)
    {
        try
        {
            StringSelection stringSelection = new StringSelection(aString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection , stringSelection);
    
            return true;
        }
        catch(Exception e)
        {
            System.err.println("[Error] Failed to clipboard contents , error :" + e.getMessage());
            return false;
        }
    }
    public String getClipboardContents() 
    {
      String result = "";
      Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      //odd: the Object param of getContents is not currently used
      Transferable contents = clipboard.getContents(null);
      
      if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor)) 
      {
        try 
        {
            
          result = (String)contents.getTransferData(DataFlavor.stringFlavor);
          
        }
        catch (UnsupportedFlavorException | IOException ex)
        {
          System.err.println("[ERROR] Failed to read from clipboard - " + ex);
        }
      }
      return result;
    }

    private boolean WaitForElementToAppearAdjacentTo(String anchorPoint, String adjacentImage, RelativePosition relation)
    {
        try
        {
            Region anchorPointRegion = this.Desktop.wait(this.ScreenshotDirectory + anchorPoint, ApplicationConfig.WaitTimeout()).highlight(1);
            
            if(anchorPointRegion == null)
                return false;
            
            
            switch(relation)
            {
                case Above:
                {
                    anchorPointRegion.above().find(this.ScreenshotDirectory + adjacentImage).highlight(1);
                    return true;
                }
                case Below:
                {
                    anchorPointRegion.below().find(this.ScreenshotDirectory + adjacentImage).highlight(1);
                    return true;
                }
                case Right:
                {
                    anchorPointRegion.right().find(this.ScreenshotDirectory + adjacentImage).highlight(1);
                    return true;
                }
                case Left:
                {
                    anchorPointRegion.left().find(this.ScreenshotDirectory + adjacentImage).highlight(1);
                    return true;
                }
            }
            
    
            return false;
        }
        catch(Exception e)
        {
            System.err.println("[Error] Failed to find element on desktop, image: {" + adjacentImage + "} adjacent to: {" + anchorPoint + "}, error :" + e.getMessage());
            return false;
        }
    }
    
    public boolean WaitForElementToAppearThrowsNoError(String ImageFilePath) {
        try {
            this.Desktop.wait(this.ScreenshotDirectory + ImageFilePath, ApplicationConfig.WaitTimeout()).highlight(1);

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean MouseClickHighlightedOrNormal(String normalPath, String highlightedPath) {
        try {
            if (this.WaitSpecificTimeElementAppear(normalPath, 5)) {

                this.Desktop.find(this.ScreenshotDirectory + normalPath).highlight(1).click();
                return true;

            } else if (this.WaitSpecificTimeElementAppear(highlightedPath, 5)) {

                this.Desktop.find(this.ScreenshotDirectory + highlightedPath).highlight(1).click();
                return true;

            }
            
            else{
                return false;
            }

        } catch (Exception e) {

            System.err.println("[Error] Failed to click element, image: {" + highlightedPath + "}, error :" + e.getMessage());
            return false;
        }

    }
    
}
