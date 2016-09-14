/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Utilities;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.RetrievedTestValues;
import KeywordDrivenTestFramework.Entities.TestEntity;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import static java.lang.System.err;
import static java.lang.System.out;

/**
 *
 * @author Brendan
 */
// Contains logic for handling accessor methods and driver calls.
public class SeleniumDriverUtility extends BaseClass {

    public WebDriver Driver;
    public Enums.BrowserType browserType;
    private Boolean _isDriverRunning;
    public RetrievedTestValues retrievedTestValues;
    public String DriverExceptionDetail = "";
    TestEntity testData;
    private Object document;
    private static Integer screenShotCounter = 1;
    private static Integer screenShotFolderCounter = 1;
    public static final String USERNAME = "spree3";
    public static final String AUTOMATE_KEY = "coFkpCcqaYrspUvJTdoM";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static DesiredCapabilities caps = new DesiredCapabilities();

    public SeleniumDriverUtility(Enums.BrowserType selectedBrowser) {
        retrievedTestValues = new RetrievedTestValues();

        _isDriverRunning = false;
        browserType = selectedBrowser;
    }

    public boolean isDriverRunning() {
        return _isDriverRunning;
    }

    public Set getCookiesAsSet() {
        try {
            return Driver.manage().getCookies();
        } catch (Exception ex) {
            err.println("[ERROR] Failed to retrieve cookies from browser session - " + ex.getMessage());
        }

        return null;
    }

    public boolean setCookiesAsPropertySet(Set cookieSet) {
        try {
            Set<Cookie> cookSet = cookieSet;

            for (Cookie cook : cookSet) {
                Driver.manage().addCookie(cook);
            }

            return true;
        } catch (Exception ex) {
            err.println("[ERROR] Failed to add cookies to browser session - " + ex.getMessage());

            return false;
        }

    }

    public void startDriver() throws MalformedURLException {
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");

        switch (browserType) {
            case IE:
                DesiredCapabilities iecaps = new DesiredCapabilities();
                iecaps.setCapability("browser", "IE");
                iecaps.setCapability("browser_version", "11.0");
                iecaps.setCapability("os", "Windows");
                iecaps.setCapability("os_version", "7");
                iecaps.setCapability("resolution", "1024x768");
                caps = iecaps;
                _isDriverRunning = true;
                break;
            case FireFox:
                DesiredCapabilities firefoxcaps = new DesiredCapabilities();
                firefoxcaps.setCapability("browser", "Firefox");
                firefoxcaps.setCapability("browser_version", "48.0");
                firefoxcaps.setCapability("os", "Windows");
                firefoxcaps.setCapability("os_version", "7");
                firefoxcaps.setCapability("resolution", "1024x768");
                caps = firefoxcaps;
                _isDriverRunning = true;
                break;
            case Chrome:
                DesiredCapabilities chromecaps = new DesiredCapabilities();
                chromecaps.setCapability("browser", "Chrome");
                chromecaps.setCapability("browser_version", "52.0");
                chromecaps.setCapability("os", "Windows");
                chromecaps.setCapability("os_version", "7");
                chromecaps.setCapability("resolution", "1024x768");
                caps = chromecaps;
                _isDriverRunning = true;
                break;
            case Safari:
                DesiredCapabilities safaricaps = new DesiredCapabilities();
                safaricaps.setCapability("browser", "Safari");
                safaricaps.setCapability("browser_version", "9.1");
                safaricaps.setCapability("os", "OS X");
                safaricaps.setCapability("os_version", "El Capitan");
                safaricaps.setCapability("resolution", "1024x768");
                caps = safaricaps;
                _isDriverRunning = true;
                break;
        }
        Driver = new RemoteWebDriver(new URL(URL), caps);
        retrievedTestValues = new RetrievedTestValues();
    }

    public void maximizeWindow() {
        Driver.manage().window().maximize();

    }

    public boolean clickElementById(String elementId) {
        try {

            System.out.println("[Info]Attempting to click element by ID - " + elementId);
            waitForElementById(elementId);
            //Pause is needed in some cases, do not remove
            SeleniumDriverInstance.pause(100);
            Driver.findElement(By.id(elementId)).click();
            System.out.println("[Info]Element clicked successfully...proceeding");
            return true;
        } catch (Exception e) {
            System.err.println("Error clicking element by Id : '" + elementId + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean tryClickElementsByCSSSelector(String elementCSSSelector) {
        try {

            System.out.println("[Info]Finding elements by CSS Selector - " + elementCSSSelector);
            waitForElementByCSSSelector(elementCSSSelector);
            //Thread.sleep(1000);

            List<WebElement> detectedElements = Driver.findElements(By.cssSelector(elementCSSSelector));

            System.out.println("[Info]Found - " + detectedElements.size() + " matching elements");

            for (WebElement element : detectedElements) {
                if (element == null || !element.isDisplayed() || !element.isEnabled()) {
                    continue;
                }

                System.out.println("[Info]Element is valid, attempting to click...");

                element.click();

                System.out.println("[Info]Element clicked sucessfully, exiting search.");

                break;

            }

            return true;
        } catch (Exception e) {
            System.err.println("Error clicking elements by CSS Selector - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean alertHandler() {
        try {
            System.out.println("[Info]Attempting to click OK in alert pop-up");
            // Get a handle to the open alert, prompt or confirmation
            Alert alert = Driver.switchTo().alert();
            // Get the text of the alert or prompt
            alert.getText();
            // And acknowledge the alert (equivalent to clicking "OK")
            alert.accept();
            System.out.println("[Info]Ok Clicked successfully...proceeding");
            return true;
        } catch (Exception e) {
            System.err.println("Error clicking OK in alert pop-up - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickElementByCSSSelector(String elementCSSSelector) {
        try {

            System.out.println("[Info]Attempting to click element by CSS Selector - " + elementCSSSelector);
            //Thread.sleep(1000);
            waitForElementByCSSSelector(elementCSSSelector);
            Driver.findElement(By.cssSelector(elementCSSSelector)).click();
            System.out.println("[Info]Element clicked successfully...proceeding");
            return true;
        } catch (Exception e) {
            System.err.println("Error clicking element by CSS Selector - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean selectPolicyAgentCode(String agentCode) {
        try {
            System.out.println("[Info]Attempting to Select Agent code - " + agentCode);
            //Thread.sleep(1000);
            waitForElementById(agentCode);
            WebDriverWait wait = new WebDriverWait(Driver, ApplicationConfig.WaitTimeout());
            wait.until(ExpectedConditions.elementToBeClickable(By.id(agentCode)));
            WebElement agentCodeRow = Driver.findElement(By.id(agentCode));

            agentCodeRow.findElement(By.tagName("a")).click();

            System.out.println("[Info]Agent code selected successfully...proceeding");
            return true;
        } catch (Exception e) {
            System.err.println("Error selecting Agent code - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean switchToFrameById(String elementId) {
        int waitCount = 0;
        try {
            while (waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    Driver.switchTo().frame(elementId);
                    return true;
                } catch (Exception e) {
                    //Thread.sleep(500);
                    waitCount++;
                }
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error switching to frame by Id - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean switchToFrameByName(String elementName) {
        int waitCount = 0;
        try {
            while (waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    Driver.switchTo().frame(elementName);
                    return true;
                } catch (Exception e) {
                    //Thread.sleep(500);
                    waitCount++;
                }
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error switching to frame by Name - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean switchToLastDuplicateFrameById(String elementId) {
        int waitCount = 0;
        try {
            this.switchToDefaultContent();
            while (waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    List<WebElement> iframes = Driver.findElements(By.id(elementId));

                    Driver.switchTo().frame((WebElement) iframes.toArray()[iframes.size() - 1]);
                    return true;
                } catch (Exception e) {
                    //Thread.sleep(500);
                    waitCount++;
                }
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error switching to last duplicate frame by Id - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean switchToDefaultContent() {
        try {
            Driver.switchTo().defaultContent();
            return true;
        } catch (Exception e) {
            System.err.println("Error switching to default content  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean switchToNewTab() {
        try {
            String currentWindowHandle = Driver.getWindowHandle();
            //Get the list of all window handles
            ArrayList<String> windowHandles = new ArrayList<String>(Driver.getWindowHandles());

            for (String window : windowHandles) {

                //if it contains the current window we want to eliminate that from switchTo();
                if (!window.equals(currentWindowHandle)) {
                    //Now switchTo new Tab.
                    Driver.switchTo().window(window);
                    return true;
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to switch to tab - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

        return true;
    }

    public boolean closeCurrentTab() {
        try {
            Driver.close();

        } catch (Exception e) {
            System.err.println("Failed to close current tab - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
        return true;
    }

    public boolean moveToNewTab() {
        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_CONTROL);

        } catch (Exception e) {
            System.err.println("Failed to close current tab - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
        return true;
    }

    public boolean selectAllText() {
        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            pause(1500);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_CONTROL);

        } catch (Exception e) {
            System.err.println("Failed to close current tab - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
        return true;
    }

    public boolean closeWindowKeys() {
        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);

        } catch (Exception e) {
            System.err.println("Failed to close current tab - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
        return true;
    }

    public boolean moveToElementById(String elementId) {
        try {
            Actions moveTo = new Actions(Driver);
            moveTo.moveToElement(Driver.findElement(By.id(elementId)));
            moveTo.perform();
            return true;
        } catch (Exception e) {
            System.err.println("Error moving to element - " + elementId + " - " + e.getStackTrace());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean switchToDefaultContentWhenElementNoLongerVisible(String previousFrameId) {
        try {
            waitForElementNoLongerPresentById(previousFrameId);
            Driver.switchTo().defaultContent();
            System.out.println("Successfully switched to default content, current frame handle = " + Driver.getWindowHandle() + ", previous frameId - " + previousFrameId);
            return true;
        } catch (Exception e) {
            System.err.println("Error switching to default content when element is no longer visible - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean selectByValueFromDropDownListUsingId(String elementId, String valueToSelect) {
        try {
            waitForElementById(elementId);
            Select dropDownList = new Select(Driver.findElement(By.id(elementId)));
            dropDownList.selectByValue(valueToSelect);
            return true;
        } catch (Exception e) {
            System.err.println("Error selecting from dropdownlist by value using Id - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean acceptAlertDialog() {
        int waitCount = 0;
        try {
            while (waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    Driver.switchTo().alert().accept();
                    return true;
                } catch (Exception e) {
                    //Thread.sleep(500);
                    waitCount++;
                }
            }
            return false;
        } catch (Exception e) {
            System.err.println("Error accepting alert dialog - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String retrieveTextById(String elementId) {
        String retrievedText = "";
        try {
            waitForElementById(elementId);
            WebElement elementToRead = Driver.findElement(By.id(elementId));
            retrievedText = elementToRead.getText();
            return retrievedText;
        } catch (Exception e) {
            System.err.println("Error reading text from element - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveTextByClassName(String elementClassName) {
        String retrievedText = "";
        try {
            this.waitForElementByClassName(elementClassName);
            WebElement elementToRead = Driver.findElement(By.className(elementClassName));
            retrievedText = elementToRead.getText();
            return retrievedText;
        } catch (Exception e) {
            System.err.println("Error reading text from element - " + elementClassName + " error - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveTextByName(String elementName) {
        String retrievedText = "";
        try {
            this.waitForElementByName(elementName);
            WebElement elementToRead = Driver.findElement(By.name(elementName));
            retrievedText = elementToRead.getAttribute("value");
            return retrievedText;
        } catch (Exception e) {
            System.err.println("Error reading text from element - " + elementName + " error - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveTextByLinkText(String elementLinkText) {
        String retrievedText = "";
        try {
            this.waitForElementByLinkText(elementLinkText);
            WebElement elementToRead = Driver.findElement(By.linkText(elementLinkText));
            retrievedText = elementToRead.getText();
            return retrievedText;
        } catch (Exception e) {
            System.err.println("Error reading text from element - " + elementLinkText + " error - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveTextByCSS(String elementCSS) {
        String retrievedText = "";

        try {
            this.waitForElementByCSSSelector(elementCSS);
            WebElement elementToRead = Driver.findElement(By.cssSelector(elementCSS));
            retrievedText = elementToRead.getText();
            return retrievedText;
        } catch (Exception e) {
            System.err.println("[Error] Failed to read text from element CSS '" + elementCSS + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public Boolean ClickEmbeddedElementByTagNameUsingContainerId(String containerId, String tagName, String validationText)//
    {
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement DivList = SeleniumDriverInstance.Driver.findElement(By.id(containerId));

            List<WebElement> subElements = DivList.findElements(By.tagName(tagName));

            for (WebElement subElement : subElements) {
                //SeleniumDriverInstance.pause(500);
                System.out.println("Detected entry " + subElement.getText() + "        Clickable");

                if (subElement.getText().toUpperCase().trim().equals(validationText.toUpperCase().trim())) {
                    subElement.click();
                    System.out.println("Validation match  " + validationText + " = " + subElement.getText());
                    System.out.println("Validation match  " + validationText + "       FOUND!!!");
                    System.out.println("Validation match  " + subElement.getText().toUpperCase() + "   <---FOUND!!!");
                    return true;
                }
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickEmbeddedListElementByTagNameUsingContainerId(String containerId, String tagName, String validationText) {
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement DivList = SeleniumDriverInstance.Driver.findElement(By.id(containerId));

            List<WebElement> subElements = DivList.findElements(By.tagName(tagName));

            for (WebElement subElement : subElements) {
                this.pause(2000);
                System.out.println("Detected entry " + subElement.getText() + "        Clickable");

                if (subElement.getText().toUpperCase().trim().equals(validationText.toUpperCase().trim())) {
                    subElement.click();
                    System.out.println("Validation match  " + validationText + "       FOUND!!!");
                    System.out.println("Validation match  " + subElement.getText().toUpperCase() + "   <---FOUND!!!");
                    return true;
                }
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickListElementByXpath(String elementXpath, String validationText) {
        try {
            SeleniumDriverInstance.waitForElementByXpath(elementXpath);

            WebElement elementToEnter = SeleniumDriverInstance.Driver.findElement(By.xpath(elementXpath));
            elementToEnter.findElement(By.xpath(elementXpath)).sendKeys(validationText);
            elementToEnter.sendKeys(Keys.TAB);
            System.out.println("ClickListElementByXpath complete");
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickEmbeddedElementByIDUsingContainerId(String containerId, String ElementID) {
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement DivList = Driver.findElement(By.id(containerId));

            WebElement subElement = DivList.findElement(By.id(ElementID));

            System.out.println("Detected entry " + subElement.getText());

            subElement.click();

            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickEmbeddedListElementByIDUsingContainerId(String containerId, String ElementID, String ChildTagName, String validationText) {
        String ChildElementText = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement DivList = Driver.findElement(By.id(containerId));

            WebElement subElement = DivList.findElement(By.id(ElementID));

            System.out.println("Detected entry " + subElement.getText());

            subElement.click();

            List<WebElement> ChildElements = subElement.findElements(By.tagName(ChildTagName));

            for (WebElement ChildElement : ChildElements) {
                ChildElementText = ChildElement.getText();
                if (ChildElementText == null) {
                    continue;
                }

                System.out.println("Detected Child Element: " + ChildElementText);

                if (ChildElementText.equals(validationText)) {
                    System.out.println("About to click child element: " + ChildElementText);
                    ChildElement.click();
                    System.out.println("Clicked child element: " + ChildElementText);
                }
            }

            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean SelectFromEmbeddedTableElementByIDUsingContainerId(String containerId, String ParentTag, String ChildTag, String validationText, String ListContainerId, String ItemTag, String ItemText) {
        String ChildElementText = "";
        String ListItemText = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerId);
            WebElement Div = Driver.findElement(By.id(containerId));
            List<WebElement> ParentElements = Div.findElements(By.tagName(ParentTag));

            for (WebElement ParentElement : ParentElements) {
                List<WebElement> ChildElements = ParentElement.findElements(By.tagName(ChildTag));

                for (WebElement ChildElement : ChildElements) {
                    ChildElementText = ChildElement.findElement(By.tagName(ChildTag)).getText();

                    if (ChildElementText == null) {
                        continue;
                    }

                    System.out.println("Detected child element text :" + ChildElementText);

                    if (ChildElementText.equals(validationText)) {
                        System.out.println("About to click: " + ChildElementText);
                        ParentElement.click();
                        System.out.println("Clicked: " + ChildElementText);
                        WebElement ListContainer = Driver.findElement(By.id(ListContainerId));
                        System.out.println("Found Container Element: " + ListContainer.getText());
                        List<WebElement> ListItems = ListContainer.findElements(By.tagName(ItemTag));
                        System.out.println("Listing List Items");
                        SeleniumDriverInstance.pause(500);
                        for (WebElement ListItem : ListItems) {
                            ListItemText = ListItem.getText();
                            System.out.println("Found ListElement: " + ListItemText);

                            if (ListItemText.equals(ItemText)) {
                                ListItem.click();
                                System.out.println("Clicking Item :" + ListItem.getText());
                                return true;
                            }
                        }
                    }
                }
            }
            System.err.println("[ERROR] failed to find element : " + ItemText);
            return false;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickEmbeddedButtonByTagNameUsingContainerTagName(String containerId, String TableXpath, String ParentTagName, String ChildtagName, String LinkTag, String validationText) {
        String ChildElementText = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement Div = Driver.findElement(By.id(containerId));
            System.out.println("Found element DIV: " + Div.getText());
            WebElement Table = Div.findElement(By.xpath(TableXpath));
            System.out.println("Found element Table: " + Div.getText());
            List<WebElement> ParentElements = Table.findElements(By.tagName(ParentTagName));
            System.out.println("Listing parent elements");
            for (WebElement ParentElement : ParentElements) {
                System.out.println("Found element: " + ParentElement.getText());
                List<WebElement> ChildElements = ParentElement.findElements(By.tagName(ParentTagName));
                System.out.println("Listing ChildElements");
                for (WebElement ChildElement : ChildElements) {
                    System.out.println("Found Child Element: " + ChildElement.getText());
                    ChildElementText = ChildElement.getText();
                    System.out.println("Need to compare elements: " + ChildElement.getText() + " And " + validationText);
                    if (ChildElementText.toUpperCase().trim().equals(validationText.toUpperCase())) {
                        System.out.println("Found Element: " + ChildElement.getText());
                        WebElement LinkElement = ParentElement.findElement(By.tagName(LinkTag));
                        System.out.println("Found sub Element: " + LinkElement.getText());
                        LinkElement.click();

                        return true;
                    }
                }

            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickEmbeddedElementByTagNameUsingContainerTagName(String DivID, String containerTagName, String tagName, String validationText) {
        String subElementText = "";
        try {
            WebElement Div = Driver.findElement(By.id(DivID));
            List<WebElement> ParentElements = Div.findElements(By.tagName(containerTagName));

            for (WebElement ParentElement : ParentElements) {

                subElementText = ParentElement.findElement(By.tagName(tagName)).getText();

                if (subElementText == null) {
                    continue;
                }

                System.out.println("Detected child element text :" + subElementText);

                if (subElementText.equals(validationText)) {
                    ParentElement.click();
                    System.out.println("Validation match  " + validationText + " FOUND!!!");
                    return true;
                }
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean validateTextForEmbeddedElementsByTagNameUsingContainerId(String containerId, String tagName, String validationText) {
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement DivList = SeleniumDriverInstance.Driver.findElement(By.id(containerId));

            List<WebElement> subElements = DivList.findElements(By.tagName(tagName));

            for (WebElement subElement : subElements) {
                System.out.println("Detected entry " + subElement.getText());

                if (subElement.getText().equals(validationText)) {
                    System.out.println("Validation match  " + validationText + "FOUND!!!");
                    return true;
                }
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickEmbeddedElementWithinSubElementByTagNameUsingContainerId(String containerId, String Xpath, String SubTagName, String EmbeddedTagName, String FindName, String validationText) {
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement div = Driver.findElement(By.id(containerId));
            System.out.println("Found div");
            WebElement table = div.findElement(By.xpath(Xpath));
            System.out.println("Found table");
            List<WebElement> rows = table.findElements(By.tagName(SubTagName));
            System.out.println("Found rows");
            int rowCount = 1;
            for (WebElement row : rows) {
                System.out.println("Row - " + rowCount);
                List<WebElement> cells = row.findElements(By.tagName(EmbeddedTagName));

                if (cells == null || cells.size() < 1) {
                    continue;
                }
                String firstcell = cells.get(0).getText();
                System.out.println(firstcell);
                System.out.println("Checking if " + firstcell + " = " + FindName);

                if (firstcell.toUpperCase().trim().equals(FindName.toUpperCase())) {
                    System.out.println(firstcell + "=" + FindName);
                    WebElement Button = row.findElement(By.linkText(validationText));
                    Button.click();
                    System.out.println("Button Clicked successfully - " + FindName + " = " + validationText);
                    return true;
                }

                rowCount++;
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickEmbeddedItemWithinTableByAttributeUsingContainerID(String containerId, String Xpath, String SubTagName, String EmbeddedTagName, String FindName, String ButtonTag, String Attribute, String AttributeName) {
        String ButtonAttribute = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement div = Driver.findElement(By.id(containerId));
            System.out.println("Found div");
            WebElement table = div.findElement(By.xpath(Xpath));
            System.out.println("Found table");
            List<WebElement> rows = table.findElements(By.tagName(SubTagName));
            System.out.println("Found rows");
            int rowCount = 1;
            for (WebElement row : rows) {
                System.out.println("Row - " + rowCount);
                List<WebElement> cells = row.findElements(By.tagName(EmbeddedTagName));

                if (cells == null || cells.size() < 1) {
                    continue;
                }
                String firstcell = cells.get(0).getText();
                System.out.println(firstcell);
                System.out.println("Checking if " + firstcell + " = " + FindName);

                if (firstcell.toUpperCase().trim().equals(FindName.toUpperCase())) {
                    System.out.println(firstcell + "=" + FindName);
                    List<WebElement> Buttons = row.findElements(By.tagName(ButtonTag));
                    for (WebElement Button : Buttons) {
                        ButtonAttribute = Button.getAttribute(Attribute).toString();
                        if (ButtonAttribute.toUpperCase().trim().equals(AttributeName.toUpperCase())) {
                            System.out.println("About to click " + ButtonAttribute + " button.");
                            Button.click();
                            return true;
                        }
                    }
                    return true;
                }
                rowCount++;
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickEmbeddedFormButttonUsingContainerXpath(String ContainerXpath, String TagName, String ValidationText) {
        String ButtonText = "";
        try {
            SeleniumDriverInstance.waitForElementByXpath(ContainerXpath);

            WebElement div = Driver.findElement(By.xpath(ContainerXpath));
            System.out.println("Found Div");
            List<WebElement> Buttons = div.findElements(By.tagName(TagName));
            System.out.println("listing Buttons");
            for (WebElement Button : Buttons) {
                System.out.println(Button.getText());
                ButtonText = Button.getText();
                System.out.println(ButtonText);
                if (ButtonText.toUpperCase().trim().equals(ValidationText)) {
                    System.out.println("About to click button: " + Button.getText());
                    Button.click();
                }
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickEmbeddedFilterItemWithinTableUsingContainerID(String containerId, String Xpath, String SubTagName, String EmbeddedTagName, int CellNumber, String FindName, String ButtonTag) {
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement div = Driver.findElement(By.id(containerId));
            System.out.println("Found div");
            WebElement table = div.findElement(By.xpath(Xpath));
            System.out.println("Found table");
            WebElement row = table.findElement(By.tagName(SubTagName));
            System.out.println("Found rows");
            List<WebElement> cells = row.findElements(By.tagName(EmbeddedTagName));

            for (WebElement cell : cells) {
                String Neededcell = cells.get(CellNumber).getText();
                System.out.println(Neededcell);
                System.out.println("Checking if " + Neededcell + " = " + FindName);

                if (Neededcell.toUpperCase().trim().equals(FindName.toUpperCase())) {
                    System.out.println(Neededcell + "=" + FindName);
                    WebElement Button = cell.findElement(By.xpath(ButtonTag));
                    System.out.println("Button found, about to click");
                    Button.click();

                    return true;
                }
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickElementWithinTableByTagNameUsingContainerId(String containerId, String Xpath, String SubTagName, String EmbeddedTagName, int CellNumber) {
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement div = Driver.findElement(By.id(containerId));
            System.out.println("Found div");
            WebElement table = div.findElement(By.xpath(Xpath));
            System.out.println("Found table");
            List<WebElement> rows = table.findElements(By.tagName(SubTagName));
            System.out.println("Found rows");
            int rowCount = 1;
            for (WebElement row : rows) {
                System.out.println("Row - " + rowCount);
                List<WebElement> cells = row.findElements(By.tagName(EmbeddedTagName));

                if (cells == null || cells.size() < 1) {
                    continue;
                }
                WebElement firstcell = cells.get(CellNumber);
                System.out.println("Found Cells:" + cells.size());

                firstcell.click();
                System.out.println("Cell Clicked successfully");
                return true;

            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean SelectValueFromEmbeddedElementByNameAndTagNameUsingContainerId(String containerId, String tagName, String validationText, String valueToSelect) {
        try {
            this.waitForElementById(containerId);

            WebElement DivList = this.Driver.findElement(By.id(containerId));

            List<WebElement> subElements = DivList.findElements(By.tagName(tagName));

            for (WebElement subElement : subElements) {
                System.out.println("Detected entry " + subElement.getText());

                if (subElement.getText().equals(validationText)) {
                    Select dropDownList = new Select(DivList.findElement(By.name(validationText)));
                    dropDownList.selectByVisibleText(valueToSelect);
                    System.out.println("Validation match  " + validationText + "FOUND!!!");
                    return true;
                }
            }
            System.err.println("[ERROR] failed to find element : " + validationText);
            return false;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickEmbeddedParentElementByTagNameAndChildElementValidationTextUsingContainerXpath(String containerXpath, String tagName, String validationTagName, String validationText) {
        try {
            this.waitForElementByXpath(containerXpath);

            WebElement Container = this.Driver.findElement(By.xpath(containerXpath));
            System.out.println("Detected entry " + Container.getText());
            List<WebElement> subElements = Container.findElements(By.tagName(tagName));

            for (WebElement subElement : subElements) {
                System.out.println("Detected entry " + subElement.getText());
                WebElement childElement = subElement.findElement(By.tagName(validationTagName));

                if (childElement == null) {
                    continue;
                }

                System.out.println("Detected entry " + childElement.getText());

                if (childElement.getText().equals(validationText)) {
                    subElement.click();
                    System.out.println("Validation match  " + validationText + "FOUND!!!");
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickEmbeddedParentElementByTagNameAndChildElementValidationTextUsingContainerClassName(String containerClassName, String tagName, String validationTagName, String validationText) {
        try {
            this.waitForElementByClassName(containerClassName);

            List<WebElement> Containers = this.Driver.findElements(By.className(containerClassName));

            System.out.println("Detected " + Containers.size() + "container entries ");

            for (WebElement Container : Containers) {

                List<WebElement> subElements = Container.findElements(By.tagName(tagName));

                System.out.println("Detected " + subElements.size() + " subelements");

                for (WebElement subElement : subElements) {
                    System.out.println("Detected sub element entry: " + subElement.getText());

                    WebElement childElement = subElement.findElement(By.tagName(validationTagName));

                    if (childElement == null || !subElement.isDisplayed()) {
                        System.out.println("Detected entry is null or not visible");

                        continue;

                    }

                    String elementText = childElement.getText();

                    System.out.println("Detected child element entry:  " + elementText);

                    if (elementText.toUpperCase().trim().equals(validationText.toUpperCase().trim())) {
                        System.out.println("Validation match  " + validationText + "FOUND!!! Clicking element.");
                        subElement.click();
                        return true;
                    } else {
                        System.out.println("Validation failed entry text did not match expected value - " + elementText + " <> " + validationText);
                    }
                }
            }
            System.err.println("[ERROR] failed to find element : " + validationText);
            return false;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean SelectValueFromEmbeddedElementByNameUsingContainerId(String containerId, String validText, String valueToSelect) {
        try {
            this.waitForElementById(containerId);

            WebElement Div = this.Driver.findElement(By.id(containerId));

            //WebElement subElement = Div.findElement(By.id(tagID));
            Select dropDownList = new Select(Div.findElement(By.name(validText)));

            dropDownList.selectByVisibleText(valueToSelect);

            return true;
        } catch (Exception ex) {
            System.err.println("Error selecting from dropdownlist by text using Id - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public Boolean SelectValueFromEmbeddedElementByTagNameUsingContainerId(String containerId, String TagName, String valueToSelect) {
        try {
            this.waitForElementById(containerId);

            WebElement Div = this.Driver.findElement(By.id(containerId));

            //WebElement subElement = Div.findElement(By.id(tagID));
            Select dropDownList = new Select(Div.findElement(By.tagName(TagName)));
            System.out.println("[Found:] " + dropDownList.toString());
            dropDownList.selectByVisibleText(valueToSelect);

            return true;
        } catch (Exception ex) {
            System.err.println("Error selecting from dropdownlist by text using Id - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public Boolean SelectValueFromEmbeddedElementByIDUsingContainerId(String containerId, String elementID, String valueToSelect) {
        try {
            this.waitForElementById(containerId);

            WebElement Div = this.Driver.findElement(By.id(containerId));

            //WebElement subElement = Div.findElement(By.id(tagID));
            Select dropDownList = new Select(Div.findElement(By.id(elementID)));

            dropDownList.selectByVisibleText(valueToSelect);

            return true;
        } catch (Exception ex) {
            System.err.println("Error selecting from dropdownlist by text using Id - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public Boolean ClickEmbeddedTableElementByNameUsingContainerXpath(String containerXpath, String elementTagName, String childSubElementTagName, int valueToSelect) {
        try {
            WebElement table = SeleniumDriverInstance.Driver.findElement(By.xpath(containerXpath));
            List<WebElement> rows = table.findElements(By.tagName(elementTagName));
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName(childSubElementTagName));

                if (cells == null || cells.size() < 1) {
                    continue;
                }
                WebElement cellToClick = cells.get(valueToSelect);
                cellToClick.click();
                SeleniumDriverInstance.pause(2000);

            }

            return true;

        } catch (Exception ex) {
            System.err.println("Could not find second cell" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public boolean selectOrEnterTextByIdUsingParentChildTagName(String parentElementId, String childTagName, String innerChildTagName, String innerSiblingText, String babyElementName, String textToEnter) {
        try {
            WebElement parentElement = Driver.findElement(By.id(parentElementId));
            List<WebElement> children = parentElement.findElements(By.tagName(childTagName));
            for (WebElement child : children) {
                List<WebElement> innerChildren = child.findElements(By.tagName(innerChildTagName));
                for (WebElement innerChild : innerChildren) {
                    if (innerChild.getText().equals(innerSiblingText)) {
                        WebElement babyElement = child.findElement(By.name(babyElementName));
                        if (babyElement.getTagName().equalsIgnoreCase("input")) {
                            this.enterTextByName(babyElementName, textToEnter);
                            return true;
                        } else if (babyElement.getTagName().equalsIgnoreCase("select")) {
                            this.selectByTextFromDropDownListUsingName(babyElementName, textToEnter);
                            return true;
                        }
                    }
                }
            }

        } catch (Exception ex) {
            System.err.println("Could not find elements" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
        return false;
    }

    public Boolean ClickEmbeddedTableElementByNameUsingContainerXpath(String containerXpath, String elementTagName, String childSubElementTagName, String valueToSelect) {
        try {
            WebElement table = SeleniumDriverInstance.Driver.findElement(By.xpath(containerXpath));
            List<WebElement> rows = table.findElements(By.tagName(elementTagName));

            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName(childSubElementTagName));

                if (cells == null || cells.size() < 1) {
                    continue;
                }
//                WebElement cellToClick = cells.get(valueToSelect);

                WebElement Button = Driver.findElement(By.xpath(valueToSelect));
                Button.click();
                break;

            }

            return true;

        } catch (Exception ex) {
            System.err.println("Could not find second cell" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public Boolean ClickDeleteButtonEmbeddedTableElementByNameUsingContainerXpath(String containerXpath, String elementTagName, String childSubElementTagName, String childTagElementName, String ButtonToClick) {
        try {
            WebElement table = SeleniumDriverInstance.Driver.findElement(By.xpath(containerXpath));
            List<WebElement> rows = table.findElements(By.tagName(elementTagName));
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName(childSubElementTagName));

                if (cells == null || cells.size() < 1) {
                    continue;
                }
                List<WebElement> TagName = row.findElements(By.tagName(childTagElementName));

                if (TagName == null || TagName.size() < 1) {
                    continue;
                }
//                WebElement cellToClick = cells.get(valueToSelect);
                WebElement Button = Driver.findElement(By.xpath(ButtonToClick));
                Button.click();
                SeleniumDriverInstance.pause(2000);

            }

            return true;

        } catch (Exception ex) {
            System.err.println("Could not find second cell" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public Boolean ClickDeleteButtonEmbeddedTableElementByNameUsingContainerXpathAndFirstCellName(String containerXpath, String elementTagName, String childSubElementTagName, String ValidationText, int valueToSelect) {
        String FirstCellText = "";
        String CellText = "";
        try {
            WebElement table = SeleniumDriverInstance.Driver.findElement(By.xpath(containerXpath));
            List<WebElement> rows = table.findElements(By.tagName(elementTagName));
            System.out.println("Printing out rows :");
            for (WebElement row : rows) {
                System.out.println(row.getText());
                System.out.println("Printing out cells");
                List<WebElement> cells = row.findElements(By.tagName(childSubElementTagName));

                if (cells == null || cells.size() < 1) {
                    continue;
                }

                System.out.println(FirstCellText);
                for (WebElement cell : cells) {
                    FirstCellText = "FirstCellText = " + cell.getText();

                    CellText = cell.getText();
                    System.out.println("");
                    if (CellText.toUpperCase().trim().equals(ValidationText)) {
                        WebElement cellToClick = cells.get(valueToSelect);
                        cellToClick.click();
                        SeleniumDriverInstance.pause(2000);
                        return true;
                    }
                }
            }

            return true;

        } catch (Exception ex) {
            System.err.println("Could not find second cell" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public Boolean SetTextInEmbeddedElementByIdUsingContainerId(String containerId, String tagID, String textToEnter) {
        try {
            this.waitForElementById(containerId);

            WebElement Div = this.Driver.findElement(By.id(containerId));

            WebElement subElement = Div.findElement(By.id(tagID));
            //subElement.clear();

            Actions typeText = new Actions(Driver);
            typeText.moveToElement(subElement);
            typeText.click(subElement);
            typeText.sendKeys(subElement, textToEnter);
            typeText.click(subElement);
            typeText.perform();

            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to enter text : " + ex.getMessage());
            return false;
        }
    }

    public Boolean EnterTextInEmbeddedElementByIdUsingContainerId(String containerId, String tagID, String textToEnter) {
        try {
            this.waitForElementById(containerId);

            WebElement Div = this.Driver.findElement(By.id(containerId));

            WebElement subElement = Div.findElement(By.id(tagID));
            subElement.clear();

            Actions typeText = new Actions(Driver);
            typeText.moveToElement(subElement);
            typeText.click(subElement);
            typeText.sendKeys(subElement, textToEnter);
            typeText.click(subElement);
            typeText.perform();

            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to enter text : " + ex.getMessage());
            return false;
        }
    }

    public Boolean SelectValueFromEmbeddedElementByIdUsingContainerId(String containerId, String tagID, String valueToSelect) {
        try {
            this.waitForElementById(containerId);

            WebElement Div = this.Driver.findElement(By.id(containerId));

            //WebElement subElement = Div.findElement(By.id(tagID));
            Select dropDownList = new Select(Div.findElement(By.id(tagID)));

            dropDownList.selectByVisibleText(valueToSelect);

            return true;
        } catch (Exception ex) {
            System.err.println("Error selecting from dropdownlist by text using Id - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public Boolean SelectDropdownListValue(String divXpath, String tagName1, String valueToSelect) {
        System.out.println("valueToSelect: " + valueToSelect);
        try {
            this.waitForElementByXpath(divXpath);
            WebElement div = this.Driver.findElement(By.xpath(divXpath));
            WebElement aTag = div.findElement(By.xpath(tagName1));
            System.out.println("a tag created");
            aTag.click();

            if (aTag.getText().toUpperCase().trim().equals(valueToSelect.toUpperCase().trim())) {
                System.out.println("match found");
                aTag.isSelected();
                aTag.sendKeys(Keys.TAB);
                System.out.println("item selected: " + aTag.getText());
            } else {
                System.out.println("match  not found: " + aTag.getText());
                WebElement selectOption = aTag.findElement(By.xpath("//*[contains(text(),'" + valueToSelect + "')]"));
                selectOption.click();
                aTag.sendKeys(Keys.TAB);
            }
            System.out.println("Selection made");
            return true;
        } catch (Exception ex) {
            System.err.println("Error selecting from dropdownlist by text using Id - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public Boolean SelectDateFromDateTimePicker(String pickerXpath, String yearXpath, String monthXpath, int inputYear, int inputMonth, String inputDay) {

        List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

        boolean dateNotFound = true;

        System.out.println("inputYear " + inputYear);
        System.out.println("inputMonth " + inputMonth);
        System.out.println("inputDay " + inputDay);

        while (dateNotFound) {
            String pickerYear = Driver.findElement(By.xpath(yearXpath)).getText();
            System.out.println("pickerYear: " + pickerYear);
            String pickerMonth = Driver.findElement(By.xpath(monthXpath)).getText();
            System.out.println("pickerMonth: " + pickerMonth);

            if (monthList.indexOf(pickerMonth) + 1 == inputMonth) {
                if (inputYear == Integer.parseInt(pickerYear)) {
                    System.out.println("Match found: " + inputMonth + " " + inputYear);

                    selectDate(pickerXpath, inputDay);
                    System.out.println("selectDate method called");

                    dateNotFound = false;
                    System.out.println("dateNotFound status set to false");
                }
            } else if (monthList.indexOf(pickerMonth) + 1 < inputMonth && (inputYear == Integer.parseInt(pickerYear)) || inputYear > Integer.parseInt(pickerYear)) {
                System.out.println("Inside first Else If");
                Driver.findElement(By.xpath(yearXpath)).click();
            } else if (monthList.indexOf(pickerMonth) + 1 > inputMonth && (inputYear == Integer.parseInt(pickerYear)) || inputYear < Integer.parseInt(pickerYear)) {
                System.out.println("Inside second Else If");
                Driver.findElement(By.xpath(monthXpath)).click();
            }
        }
        return true;
    }

    public void selectDate(String pickerXpath, String day) {
        System.out.println("Inside selectDate method");
        WebElement dateWidget;
        List<WebElement> rows;
        List<WebElement> columns;

        System.out.println("Going inside the Try");
        try {
            dateWidget = Driver.findElement(By.xpath(pickerXpath));
            rows = dateWidget.findElements(By.tagName("tr"));
            columns = dateWidget.findElements(By.tagName("td"));

            System.out.println("Going inside the For");
            for (WebElement cell : columns) {
                System.out.println("Going inside the IF");
                if (cell.getText().equals(day)) {
                    System.out.println("Inside the IF");
                    cell.findElement(By.linkText(day)).click();
                    dateWidget.sendKeys(Keys.TAB);
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error reading text from element - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
    }

    public String retrieveTextByXpath(String elementXpath) {
        String retrievedText = "";
        try {

            this.waitForElementByXpath(elementXpath);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            retrievedText = elementToRead.getText();
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveTextAtIndexByXpath(String elementXpath, int index) {
        String retrievedText = "";
        int counter = 0;
        try {
            this.waitForElementByXpath(elementXpath, 3);

            List<WebElement> liElements = Driver.findElements(By.xpath(elementXpath));

            for (WebElement elementToRead : liElements) {
                if (counter == index) {
                    retrievedText = elementToRead.getText();
                    System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
                    break;
                }
                counter++;
            }
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveTextTimedWaitByXpath(String elementXpath) {
        String retrievedText = "";
        try {

            this.waitForElementByXpath(elementXpath, 2);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            retrievedText = elementToRead.getText();
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveDisabledByXpath(String elementXpath) {
        String retrievedText = "";
        try {

            this.waitForElementByXpath(elementXpath);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            retrievedText = elementToRead.getAttribute("disabled");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public Boolean setToNotPersistentHoveringIE() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);

        Driver = new InternetExplorerDriver(cap);

        return true;
    }

    public String retrieveEnteredTextByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            retrievedText = elementToRead.getAttribute("value");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveDateplaceholderByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            retrievedText = elementToRead.getAttribute("placeholder");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveSelectedText(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);
            Select select = new Select(Driver.findElement(By.xpath(elementXpath)));
            WebElement option = select.getFirstSelectedOption();
            retrievedText = option.getText();
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveTooltipByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);

            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            Point coordinates = elementToRead.getLocation();
            Robot robot = new Robot();
            robot.mouseMove(coordinates.getX(), coordinates.getY() + 65); //Number 65 should vary
            Thread.sleep(3000);
            retrievedText = elementToRead.getAttribute("fleet-tooltip");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveAssetTooltipByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);

            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            Point coordinates = elementToRead.getLocation();
            Robot robot = new Robot();
            robot.mouseMove(coordinates.getX(), coordinates.getY() + 65); //Number 65 should vary
            Thread.sleep(3000);
            retrievedText = elementToRead.getAttribute("fleet-tooltip");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String getElementLocation(String divXpath, String iconXpath) {

        try {

            Point p;
            this.waitForElementByXpath(iconXpath);

            int divX = 0;
            int divY = 0;
            int assetX = 0;
            int assetY = 0;
            //getting location of the div
            WebElement div = Driver.findElement((By.xpath(divXpath)));
            Point divPoints = div.getLocation();
            divX = divPoints.getX();
            divY = divPoints.getY();

            //getting the location of the asset/InnerItem
            WebElement icon = Driver.findElement((By.xpath(iconXpath)));
            Point innerLoc = icon.getLocation();
            assetX = innerLoc.getX();
            assetY = innerLoc.getY();

            //get location of innerItem in respective to the outerItem
            int centerY = assetY - divY;
            int centerX = assetX - divX;

            p = new Point(centerX, centerY);

//            Actions action = new Actions(Driver);
//            action.moveToElement(div, centerX, centerY).click().build().perform();
            return p.toString();
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return " ";
        }
    }

    public int getElementWidth(String elementXpath) {

        try {
            this.waitForElementByXpath(elementXpath);

            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            int ElementWidth = elementToRead.getSize().getWidth();
            return ElementWidth;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return 0;
        }
    }

    public int getElementHeight(String elementXpath) {

        try {
            this.waitForElementByXpath(elementXpath);

            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            int ElementHeight = elementToRead.getSize().getHeight();
            return ElementHeight;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return 0;
        }
    }

    public String retrieveSaveDisableByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);

            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            Point coordinates = elementToRead.getLocation();
            Robot robot = new Robot();
            robot.mouseMove(coordinates.getX(), coordinates.getY() + 65); //Number 65 should vary
            Thread.sleep(3000);
            retrievedText = elementToRead.getAttribute("disabled");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public boolean selectByIndexFromDropDownListUsingId(String elementId, Integer indexToSelect) {
        try {
            waitForElementById(elementId);
            Select dropDownList = new Select(Driver.findElement(By.id(elementId)));
            dropDownList.selectByIndex(indexToSelect);
            return true;
        } catch (Exception e) {
            System.err.println("[Error]Failed to select option from dropdownlist by index using Id - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean selectByIndexFromDropDownListUsingName(String elementName, String elementName2, Integer indexToSelect) {
        try {
            if (waitForElementByNameNoExceptions(elementName, 3)) {
                Select dropDownList = new Select(Driver.findElement(By.name(elementName)));
                dropDownList.selectByIndex(indexToSelect);
                return true;
            }
            if (waitForElementByNameNoExceptions(elementName2, 3)) {
                Select dropDownList = new Select(Driver.findElement(By.name(elementName2)));
                dropDownList.selectByIndex(indexToSelect);
                return true;
            }
            //waitForElementByName(elementName);
        } catch (Exception e) {
            System.err.println("[Error]Failed to select option from dropdownlist by index using Name - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
        return false;
    }

    public boolean selectByTextFromDropDownListUsingId(String elementId, String valueToSelect) {
        try {
            waitForElementById(elementId);
            Select dropDownList = new Select(Driver.findElement(By.id(elementId)));
            dropDownList.selectByVisibleText(valueToSelect);
            return true;
        } catch (Exception e) {
            System.err.println("Error selecting from dropdownlist by text using Id - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean acceptSslErrorMsg() {
        try {
            this.pause(4000);
            Driver.navigate().to("javascript:document.getElementById('overridelink').click()");
            return true;
        } catch (Exception e) {
            System.err.println("Error accepting SSL Certificate message - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean selectByValueFromDropDownListUsingName(String elementName, String valueToSelect) {
        try {
            this.waitForElementByName(elementName);
            Select dropDownList = new Select(Driver.findElement(By.name(elementName)));
            dropDownList.selectByValue(valueToSelect);
            return true;
        } catch (Exception e) {
            System.err.println("Error selecting from dropdownlist by value using Name - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public void pressKeyOnElementById(String elementId, Keys keyToPress) {
        try {
            this.waitForElementById(elementId);
            WebElement elementToAccess = Driver.findElement(By.id(elementId));
            elementToAccess.sendKeys(keyToPress);

        } catch (Exception e) {
            this.DriverExceptionDetail = e.getMessage();
            System.err.println("[Error] Failed to send keypress to element - " + elementId);
        }
    }

    public boolean selectByTextFromDropDownListUsingName(String elementName, String valueToSelect) {
        try {
            this.waitForElementByName(elementName);
            Select dropDownList = new Select(Driver.findElement(By.name(elementName)));
            dropDownList.selectByVisibleText(valueToSelect);
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Selecting from dropdownlist by text using name - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickElementByXpathUsingActionsNoExeption(String elementXpath) {
        try {
            System.out.println("[INFO] Clicking element by Xpath : " + elementXpath);
            waitForElementByXpath(elementXpath, 3);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            Actions builder = new Actions(Driver);
            builder.moveToElement(elementToClick);
            builder.click();
            builder.perform();
            return true;
        } catch (Exception e) {

        }
        return true;
    }

    public boolean selectByTextFromDropDownListUsingNameAndClick(String elementName, String valueToSelect) {
        try {
            this.waitForElementByName(elementName);
            Select ddl = new Select(Driver.findElement(By.name(elementName)));
            ddl.deselectAll();
            WebElement dropDownList = Driver.findElement(By.name(elementName));
            List<WebElement> options = dropDownList.findElements(By.tagName("option"));
            for (WebElement option : options) {
                if (option.getText().equals(valueToSelect)) {
                    option.click();
                    return true;
                }
            }

        } catch (Exception e) {
            System.err.println("Error selecting from dropdownlist by text using name - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
        return false;
    }

    public Integer getSelectedDropdownOptionIndexById(String elementId) {
        try {
            waitForElementById(elementId);
            Select dropDownList = new Select(Driver.findElement(By.id(elementId)));
            String selectedValue = dropDownList.getFirstSelectedOption().getText();

            List<WebElement> list = dropDownList.getOptions();

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getText().equals(selectedValue)) {
                    return i;
                }
            }

            return -1;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve selected dropdown option index using Id - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return -1;
        }
    }

    public String getSelectedDropdownOptionTextByXpath(String elementXpath) {
        try {
            waitForElementByXpath(elementXpath);
            Select dropDownList = new Select(Driver.findElement(By.xpath(elementXpath)));
            String selectedValue = dropDownList.getFirstSelectedOption().getText();

            return selectedValue;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve selected dropdown option index using Id - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public Integer getSelectedDropdownOptionIndexByName(String elementName, String elementName2) {
        try {

            if (waitForElementByNameNoExceptions(elementName, 3)) {
                Select dropDownList = new Select(Driver.findElement(By.name(elementName)));
                String selectedValue = dropDownList.getFirstSelectedOption().getText();

                List<WebElement> list = dropDownList.getOptions();

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getText().equals(selectedValue)) {
                        return i;
                    }
                }

                return -1;
            }
            if (waitForElementByNameNoExceptions(elementName2, 3)) {
                Select dropDownList = new Select(Driver.findElement(By.name(elementName2)));
                String selectedValue = dropDownList.getFirstSelectedOption().getText();

                List<WebElement> list = dropDownList.getOptions();

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getText().equals(selectedValue)) {
                        return i;
                    }
                }

                return -1;
            }

            //waitForElementByName(elementName);
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve selected dropdown option index using name - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return -1;
        }
        return -1;
    }

    public void waitUntilElementEnabledByID(String elementID) {
        try {
            int counter = 0;
            boolean isEnabled = false;
            WebDriverWait wait = new WebDriverWait(Driver, 1);

            while (!isEnabled && counter < ApplicationConfig.WaitTimeout()) {
                if (wait.until(ExpectedConditions.elementToBeClickable(By.id(elementID))) != null) {
                    isEnabled = true;
                    break;
                } else {
                    counter++;
                    //Thread.sleep(500);
                }

            }
        } catch (Exception e) {
            System.err.println("Error waiting for element to be enabled - " + e.getMessage());
        }

    }

    public boolean checkBoxSelectionById(String elementId, boolean mustBeSelected) {
        try {
            //Thread.sleep(2000);
            this.waitForElementById(elementId);
            this.waitUntilElementEnabledByID(elementId);
            WebDriverWait wait = new WebDriverWait(Driver, ApplicationConfig.WaitTimeout());
            wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
            WebElement checkBox = Driver.findElement(By.id(elementId));
            if (checkBox.isSelected() != mustBeSelected) {
                checkBox.click();
            }
            return true;
        } catch (Exception e) {
            System.err.println("Error selecting checkbox byId - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean checkBoxSelectionByName(String elementName, boolean mustBeSelected) {
        try {
            //Thread.sleep(2000);
            this.waitForElementById(elementName);
            this.waitUntilElementEnabledByID(elementName);
            WebDriverWait wait = new WebDriverWait(Driver, ApplicationConfig.WaitTimeout());
            wait.until(ExpectedConditions.elementToBeClickable(By.id(elementName)));
            WebElement checkBox = Driver.findElement(By.name(elementName));
            if (checkBox.isSelected() != mustBeSelected) {
                checkBox.click();
            }
            return true;
        } catch (Exception e) {
            System.err.println("Error selecting checkbox by name - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean checkBoxSelectionByXpath(String elementXpath, boolean mustBeSelected) {
        try {
            //Thread.sleep(2000);
            this.waitForElementByXpath(elementXpath);
            this.waitUntilElementEnabledByID(elementXpath);
            WebDriverWait wait = new WebDriverWait(Driver, ApplicationConfig.WaitTimeout());
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
            WebElement checkBox = Driver.findElement(By.xpath(elementXpath));
            if (checkBox.isSelected() != mustBeSelected) {
                checkBox.click();
            }
            return true;
        } catch (Exception e) {
            System.err.println("Error selecting checkbox byId - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean uncheckCheckBoxSelectionById(String elementId, boolean mustBeSelected) {
        try {
            //Thread.sleep(2000);
            this.waitForElementById(elementId);
            this.waitUntilElementEnabledByID(elementId);
            WebDriverWait wait = new WebDriverWait(Driver, ApplicationConfig.WaitTimeout());
            wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
            WebElement checkBox = Driver.findElement(By.id(elementId));
            if (checkBox.isSelected() == mustBeSelected) {
                checkBox.click();
            }
            return true;
        } catch (Exception e) {
            System.err.println("Error selecting checkbox byId - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean validateElementTextValueByClassName(String elementClassName, String elementText) {
        try {
            if (waitForElementByClassName(elementClassName)) {
                WebElement elementToValidate = Driver.findElement(By.className(elementClassName));
                String textDetected = elementToValidate.getText();
                return textDetected.contains(elementText);
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error validating element text value by class name - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean validateElementTextValueById(String elementId, String elementText) {
        try {
            if (waitForElementById(elementId)) {
                WebElement elementToValidate = Driver.findElement(By.id(elementId));
                String textDetected = elementToValidate.getText();
                return textDetected.contains(elementText);
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error validating element text value by ID - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean validateElementTextValueByXpath(String elementXpath, String elementText) {
        try {
            if (waitForElementByXpath(elementXpath)) {
                WebElement elementToValidate = Driver.findElement(By.xpath(elementXpath));
                String textDetected = elementToValidate.getText();
                return textDetected.contains(elementText);
            } else {
                return false;
            }
        } catch (Exception e) {
            System.err.println("[Error] Failed to validate element text value by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public void WaitUntilDropDownListPopulatedById(String elementId) {

        try {
            this.waitForElementById(elementId);
            int waitCount = 0;
            List<WebElement> optionsList;
            while (waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    Select dropDownList = new Select(Driver.findElement(By.id(elementId)));
                    optionsList = dropDownList.getOptions();
                    if (optionsList.size() > 0) {
                        break;
                    }
                } catch (Exception e) {

                }
                //Thread.sleep(500);
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("Error waiting for dropdownlist to be populated by ID - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
    }

    public void WaitUntilDropDownListPopulatedByName(String elementName) {

        try {
            this.waitForElementById(elementName);
            int waitCount = 0;
            List<WebElement> optionsList;
            while (waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    Select dropDownList = new Select(Driver.findElement(By.name(elementName)));
                    optionsList = dropDownList.getOptions();
                    if (optionsList.size() > 0) {
                        break;
                    }
                } catch (Exception e) {

                }
                //Thread.sleep(500);
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("Error waiting for dropdownlist to be populated by Name - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
    }

    public boolean hoverOverElementAndClickSubElementbyIdAndLinkText(String elementId, String LinkText) {
        try {
            this.waitForElementById(elementId);

            Actions actions = new Actions(Driver);
            WebElement menuHoverLink = Driver.findElement(By.id(elementId));
            actions.moveToElement(menuHoverLink);

            WebElement subLink = menuHoverLink.findElement(By.linkText(LinkText));
            actions.moveToElement(subLink);
            actions.doubleClick();
            actions.perform();
            return true;
        } catch (Exception e) {
            System.err.println("Failed to hover over element and click sub element by ID and link text  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean hoverOverElementAndClickSubElementbyIdAndXpath(String elementId, String XPath) {
        try {
            this.waitForElementById(elementId);

            Actions actions = new Actions(Driver);
            WebElement menuHoverLink = Driver.findElement(By.id(elementId));
            actions.moveToElement(menuHoverLink);

            WebElement subLink = menuHoverLink.findElement(By.xpath(XPath));
            actions.moveToElement(subLink);
            actions.doubleClick();
            actions.perform();
            return true;
        } catch (Exception e) {
            System.err.println("Failed to hover over element and click sub element by ID and Xpath  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean hoverOverElementAndClickSubElementbyXpathAndXpath(String elementXPath, String XPath) {
        try {
            this.waitForElementByXpath(elementXPath);

            Actions actions = new Actions(Driver);
            WebElement menuHoverLink = Driver.findElement(By.xpath(elementXPath));
            actions.moveToElement(menuHoverLink);

            WebElement subLink = menuHoverLink.findElement(By.xpath(XPath));
            actions.moveToElement(subLink);
            actions.click();
            actions.perform();
            System.out.println("[Info]Successfully hovered over '" + elementXPath + "' and clicked '" + XPath + "'...proceeding");
            return true;
        } catch (Exception e) {
            System.err.println("[Error]Failed to hover over element and click sub element by Xpath and Xpath  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean hoverOverAndClickElementUsingJavascript(String elementXpath, String elementToClickXpath) {
        try {
            WebElement elementToClick = Driver.findElement(By.xpath(elementToClickXpath));
            JavascriptExecutor js = (JavascriptExecutor) Driver;
            js.executeScript("onmouseover=menus['0'].exec('0',2)");
            js = (JavascriptExecutor) Driver;
            js.executeScript("arguments[0].click();", elementToClick);
            System.out.println("[Info]Successfully found and clicked element '" + elementToClickXpath + "' using javascript...proceeding");
            return true;
        } catch (Exception e) {
            System.err.println("[Error]Failed to hover over element and click sub element by Xpath and Xpath  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean hoverOverElementUsingJavascriptAndClickElementByLinkText(String elementLinkText) {
        try {
            WebElement elementToClick = Driver.findElement(By.linkText(elementLinkText));
            JavascriptExecutor js = (JavascriptExecutor) Driver;
            js.executeScript("onmouseover=menus['0'].exec('0',2)");
            js = (JavascriptExecutor) Driver;
            js.executeScript("arguments[0].click();", elementToClick);
            System.out.println("[Info]Successfully found and clicked element '" + elementLinkText + "' using javascript...proceeding");
            return true;
        } catch (Exception e) {
            System.err.println("[Error]Failed to hover over element and click sub element by Xpath and Xpath  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean hoverOverElementAndClickByXpath(String XPath) {
        try {
            //this.waitForElementByXpath(XPath);

            Actions actions = new Actions(Driver);
            WebElement closeDiv = Driver.findElement(By.xpath(XPath));
            actions.moveToElement(closeDiv);
            actions.click();
            actions.perform();
            return true;
        } catch (Exception e) {
            System.err.println("Failed to hover over element and click sub element by ID and Xpath  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean hoverOverElementByXpath(String XPath) {
        try {
            this.waitForElementByXpath(XPath);
            Actions actions = new Actions(Driver);
            WebElement closeDiv = Driver.findElement(By.xpath(XPath));
            actions.moveToElement(closeDiv);
            actions.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Failed to hover over element and click sub element by ID and Xpath  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String hoverOverElementByXpath2AndGetToolTip(String XPath, String Xpath2) {
        String textRetrieved = "";
        try {
            this.waitForElementByXpath(XPath);
            Actions actions = new Actions(Driver);
            WebElement closeDiv = Driver.findElement(By.xpath(XPath));
            actions.moveToElement(closeDiv);
            actions.build().perform();
            WebElement closeDiv2 = Driver.findElement(By.xpath(Xpath2));
            textRetrieved = closeDiv2.getText();

            if (textRetrieved.equals("")) {
                actions.moveToElement(closeDiv);
                actions.build().perform();
                actions.clickAndHold(closeDiv);
                actions.build().perform();
                textRetrieved = closeDiv2.getText();
            }

            actions.perform();

            return textRetrieved;

        } catch (Exception e) {
            System.err.println("Failed to hover over element and click sub element by ID and Xpath  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return textRetrieved;
        }
    }

    public boolean hoverOverElementByXpath(String XPath, String element2, String element3) {
        try {
            this.waitForElementByXpath(XPath);
            //Thread.sleep(5000);
            Actions actions = new Actions(Driver);
            WebElement closeDiv = Driver.findElement(By.xpath(XPath));
            actions.click(closeDiv);
            actions.perform();
            this.waitForElementByXpath(element2);
            //Thread.sleep(5000);
            WebElement SecondElement = closeDiv.findElement(By.xpath(element2));
            actions.moveToElement(SecondElement);
            actions.perform();
            this.waitForElementByXpath(element3);
            //Thread.sleep(5000);
            WebElement thirdElement = SecondElement.findElement(By.xpath(element3));
            actions.click(thirdElement);
            actions.perform();

            //Thread.sleep(5000);
            return true;
        } catch (Exception e) {
            System.err.println("Failed to hover over element and click sub element by ID and Xpath  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean hoverOverElementAndClickSubElementbyIdAndId(String elementId, String subElementId) {
        try {
            this.waitForElementById(elementId);

            Actions actions = new Actions(Driver);
            WebElement menuHoverLink = Driver.findElement(By.id(elementId));
            actions.moveToElement(menuHoverLink);

            WebElement subLink = menuHoverLink.findElement(By.id(subElementId));
            actions.moveToElement(subLink);
            actions.click();
            actions.perform();
            return true;
        } catch (Exception e) {
            System.err.println("Failed to hover over element and click sub element by ID and subElementID  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickNestedElementUsingIds(String parentElementId, String childElementId) {
        try {
            this.waitForElementById(parentElementId);
            WebElement parentElement = Driver.findElement(By.id(parentElementId));
            WebElement childElement = parentElement.findElement(By.id(childElementId));
            childElement.click();
            return true;
        } catch (Exception e) {
            System.err.println("Error clicking nested elements usind IDs  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickElementbyXpath(String elementXpath) {
        try {
            System.out.println("[INFO] Clicking element by Xpath : " + elementXpath);
            waitForElementByXpath(elementXpath);
            WebDriverWait wait = new WebDriverWait(Driver, ApplicationConfig.WaitTimeout());
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public void pressCtrl_ClickTwice(Keys keyToPress, String xpath1, String xpath2) {
        try {
            waitForElementByXpath(xpath1);
            waitForElementByXpath(xpath2);
            Actions action = new Actions(Driver);
            action.sendKeys(keyToPress);
            action.perform();
            clickElementByXpathUsingActions(xpath1);
            clickElementByXpathUsingActions(xpath2);
            action.release();
        } catch (Exception e) {
            this.DriverExceptionDetail = e.getMessage();
            System.err.println("[Error] Failed to send keypress to element - " + keyToPress);

        }
    }

    public boolean clickElementByXpathUsingActions(String elementXpath) {
        try {
            System.out.println("[INFO] Clicking element by Xpath : " + elementXpath);
            waitForElementByXpath(elementXpath, 30);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            Actions builder = new Actions(Driver);
            builder.moveToElement(elementToClick);
            builder.perform();

            builder.click();
            builder.perform();
            Thread.sleep(3000);

            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickElementByXpathUsingActions(String elementXpath, int timeout) {
        try {
            System.out.println("[INFO] Clicking element by Xpath : " + elementXpath);
            waitForElementByXpath(elementXpath, timeout);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            Actions builder = new Actions(Driver);
            builder.moveToElement(elementToClick);
            builder.click();
            builder.perform();
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickElementByXpath(String elementXpath) {
        try {
            this.waitForElementByXpath(elementXpath);
            System.out.println("[INFO] Clicking element by Xpath : " + elementXpath);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            elementToClick.click();

            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean moveToAndClickElementByNestedSiblingTagNameAndText(String parentTagName, String childTagName, String siblingTagName, String siblingImg) {
        try {
            //this.waitForElementById(elementId);
            List<WebElement> parents = Driver.findElements(By.tagName(parentTagName));

            for (WebElement parent : parents) {
                try {
                    WebElement child = parent.findElement(By.tagName(childTagName));

                    WebElement sibling = child.findElement(By.tagName(siblingTagName));

                    List<WebElement> imageList = sibling.findElements(By.tagName(siblingImg));
                    for (WebElement image : imageList) {
                        if (image.getAttribute("src").equals("//js//pixel.gif")) {
                            Actions builder = new Actions(Driver);
                            builder.moveToElement(image).perform();
                        }
                    }
                } catch (Exception ex) {

                }
            }

            return false;
        } catch (Exception e) {
            System.err.println("[Error]Failed to move to element and click by ID  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean catchCoverLimitError(String tableXpath, String childTagNameCSS, String siblingTagName) {
        try {
            WebElement parent = Driver.findElement(By.xpath(tableXpath));
            try {
                List<WebElement> children = parent.findElements(By.cssSelector(childTagNameCSS));
                for (WebElement child : children) {
                    List<WebElement> innerchildren = child.findElements(By.tagName(siblingTagName));
                    if (innerchildren.get(1).getText().contains("limit")) {
                        return false;
                    }
                    break;
                }
            } catch (Exception ex) {
                this.DriverExceptionDetail = ex.getMessage();
            }
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public boolean clickLifeAssuredByRelationshipAndNameUsingXpath(String tableXpath, String childTagNameCSS, String siblingTagName, String relationship, String personsName) {
        try {
            //this.waitForElementById(elementId);
            WebElement parent = Driver.findElement(By.xpath(tableXpath));

            try {
                List<WebElement> children = parent.findElements(By.cssSelector(childTagNameCSS));

                for (WebElement child : children) {
                    List<WebElement> innerchildren = child.findElements(By.tagName(siblingTagName));

//                    for (int i = 0; i < innerchildren.size(); i++) {
                    if (innerchildren.get(1).getText().equals(relationship) && innerchildren.get(2).getText().equals(personsName)) {
                        innerchildren.get(0).click();
                        return true;
//                        }
                    }
                }

            } catch (Exception ex) {

            }

            return false;
        } catch (Exception e) {
            System.err.println("[Error]Failed to click life assured in table with name '" + personsName + "' and relationship '" + relationship + "'  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickPersonNameByRoleAndRelationshipUsingXpath(String tableXpath, String childTagNameCSS, String siblingTagName, String role, String relationship) {
        try {
            //this.waitForElementById(elementId);
            WebElement parent = Driver.findElement(By.xpath(tableXpath));
            try {
                List<WebElement> children = parent.findElements(By.cssSelector(childTagNameCSS));

                for (WebElement child : children) {
                    List<WebElement> innerchildren = child.findElements(By.tagName(siblingTagName));
//                    for (int i = 0; i < innerchildren.size(); i++) {
                    if (innerchildren.get(0).getText().equals(role) && innerchildren.get(1).getText().equals(relationship)) {
                        this.clickElementbyLinkText(innerchildren.get(2).getText());
                        return true;
//                        }
                    }
                }

            } catch (Exception ex) {

            }

            return false;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click person with name '" + role + "' and relationship '" + relationship + "'  - " + e.getMessage());
            return false;
        }
    }

    public boolean moveToAndClickElementByXpath(String elementXpath) {
        try {
            //this.waitForElementById(elementId);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));

            Actions builder = new Actions(Driver);
            builder.moveToElement(elementToClick).click(elementToClick).perform();

            return true;
        } catch (Exception e) {
            System.err.println("[Error]Failed to move to element and click by Xpath  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickBankAccount(String tableXpath, String childClassName, String siblingTagName) {
        try {
            //this.waitForElementById(elementId);
            WebElement parent = Driver.findElement(By.xpath(tableXpath));
            try {
                List<WebElement> children = parent.findElements(By.className(childClassName));

                for (WebElement child : children) {
                    List<WebElement> innerchildren = child.findElements(By.tagName(siblingTagName));

                    this.clickElementbyLinkText(innerchildren.get(0).getText());
                    return true;

                }

            } catch (Exception ex) {

            }

            return false;
        } catch (Exception e) {
            System.err.println("[Error]Failed to move to element and click by ID  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String returnBankVerificationStatus(String tableXpath, String rowClassesName, String siblingTagName, String verificationStatus) {
        try {
            //this.waitForElementById(elementId);
            WebElement parent = Driver.findElement(By.xpath(tableXpath));
            try {
                List<WebElement> children = parent.findElements(By.className(rowClassesName));

                for (WebElement child : children) {
                    List<WebElement> innerchildren = child.findElements(By.tagName(siblingTagName));
                    for (int i = 0; i < innerchildren.size(); i++) {
                        if (innerchildren.get(i).getText().equals(verificationStatus)) {
                            return innerchildren.get(i + 1).getText();
                        }
                    }
                }

            } catch (Exception ex) {

            }

        } catch (Exception e) {
            System.err.println("[Error]Failed to move to element and click by ID  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return "no text was found";
        }
        return "no text was found";
    }

    public ArrayList storeContractNumbersToCancel(String tableXpath, String tagName, String siblingTagName) {
        ArrayList contractNumbers = new ArrayList();
        try {
            //this.waitForElementById(elementId);
            WebElement parent = Driver.findElement(By.xpath(tableXpath));
            try {
                List<WebElement> children = parent.findElements(By.tagName(tagName));
                for (WebElement child : children) {
                    if (child.getAttribute("class").contains("clXpsRw")) {
                        List<WebElement> innerchildren = child.findElements(By.tagName(siblingTagName));
                        if (innerchildren.get(7).getText().equals("")) {
                            if (innerchildren.get(5).getText().equalsIgnoreCase("Pending In Force")) {
                                //Do nothing, just move on
                            } else {
                                SeleniumDriverInstance.pause(100);
                                contractNumbers.add(innerchildren.get(2).getText());
                                SeleniumDriverInstance.pause(100);
                                //this.clickElementbyLinkText(innerchildren.get(2).getText());
                                //return contractNumbers;
                            }
                        }
                    }
                }
                return contractNumbers;
            } catch (Exception ex) {
            }
            return contractNumbers;
        } catch (Exception e) {
            System.err.println("[Error]Failed to counter elements  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return contractNumbers;
        }
    }

    public boolean moveToAndClickElementById(String elementId) {
        try {
            //this.waitForElementById(elementId);
            WebElement elementToClick = Driver.findElement(By.id(elementId));

            Actions builder = new Actions(Driver);
            builder.moveToElement(elementToClick).click(elementToClick).perform();

            return true;
        } catch (Exception e) {
            System.err.println("[Error]Failed to move to element and click by ID  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean moveToAndClickElementByLinkText(String elementLinkText) {
        try {
            //this.waitForElementById(elementId);
            WebElement elementToClick = Driver.findElement(By.linkText(elementLinkText));

            Actions builder = new Actions(Driver);
            builder.moveToElement(elementToClick);
            builder.click(elementToClick);
            builder.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Failed to move to element and click by link text  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickElementbyLinkText(String elementLinkText) {
        try {
            waitForElementByLinkText(elementLinkText);
            WebElement elementToClick = Driver.findElement(By.linkText(elementLinkText));
            elementToClick.click();

            System.out.println("[Info]Element successfully clicked by Link Text '" + elementLinkText + "'...proceeding");
            return true;
        } catch (Exception e) {
            System.err.println("[Error]Failed to click element by link text '" + elementLinkText + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean enterAllRequiredFields(List<String> valueList, String requiredFieldClassName) {
        String type = "";
        int loopCount = 0;
        try {
            List<WebElement> requiredElements = Driver.findElements(By.className(requiredFieldClassName));
            while (loopCount < valueList.size()) {
                WebElement element = requiredElements.get(loopCount);
                type = element.getTagName();
                switch (type) {
                    case "input": {
                        Actions typeText = new Actions(Driver);
                        typeText.moveToElement(element);
                        typeText.click(element);
                        typeText.sendKeys(element, valueList.get(loopCount));
                        typeText.perform();
                        loopCount++;
                    }
                    break;
                    case "select": {
                        Select dropDownList = new Select(element);
                        dropDownList.selectByVisibleText(valueList.get(loopCount));
                        loopCount++;
                    }
                    break;
                }

            }
            return true;
        } catch (Exception ex) {
            System.err.println("[Error]Failed to enter in all required data '" + "' - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public boolean Waitforloadingpresence(String elementXpath, long timeout) {
        boolean elementFound = false;

        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
                    elementFound = true;

                    System.err.println("[INFO] Found waiting for element by Xpath  - " + elementXpath);
                    break;
                } catch (Exception e) {
                    elementFound = false;
                }
                Thread.sleep(500);
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("Error waiting for element by Xpath  - " + elementXpath + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean validatePage(String elementClassName, String textToVerify) {
        try {
            WebElement span = Driver.findElement(By.className(elementClassName));
            if (span.getText().equals(textToVerify)) {
                return true;
            }
        } catch (Exception ex) {
            System.err.println("Error locating element by class name  - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
        return false;
    }

    public boolean doubleClickElementbyLinkText(String elementLinkText) {
        try {
            waitForElementByLinkText(elementLinkText);
            WebElement elementToClick = Driver.findElement(By.linkText(elementLinkText));
            elementToClick.click();

            System.out.println("[Info]Element successfully double-clicked by Link Text...proceeding");
            return true;
        } catch (Exception e) {
            System.err.println("Error double-clicking element by link text  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean doubleClickElementbyPartialLinkText(String elementLinkText) {
        try {
            //waitForElementByLinkText(elementLinkText);
            Actions act = new Actions(Driver);
            WebElement elementToClick = Driver.findElement(By.partialLinkText(elementLinkText));

            act.doubleClick(elementToClick).perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error double clicking element by link text  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean doubleClickElementbyXpath(String elementLinkText) {
        try {
            //waitForElementByLinkText(elementLinkText);
            System.out.println("[INFO] Double Clicking element by Xpath : " + elementLinkText);
            Actions act = new Actions(Driver);
            WebElement elementToClick = Driver.findElement(By.partialLinkText(elementLinkText));

            act.doubleClick(elementToClick).perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error double clicking element by link text  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean doubleClickElementByXpath(String elementXpath) {
        try {
            waitForElementByXpath(elementXpath);
            System.out.println("[INFO] Double Clicking element by Xpath : " + elementXpath);
            Actions act = new Actions(Driver);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));

            act.doubleClick(elementToClick).perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error double clicking element by xpath  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean EnterTextbyParentTagNameandChildTagnames(String parentTagName, String childTagName, String InnerChildTagName, String innerchildrenTagName, String siblingInnerTagname, String texttosearch, String TexttoEnter) {
        try {
            //this.waitForElementById(elementId);
            List<WebElement> parents = Driver.findElements(By.tagName(parentTagName));

            for (WebElement parent : parents) {
                try {
                    List<WebElement> children = parent.findElements(By.cssSelector(childTagName));

                    for (WebElement child : children) {

                        List<WebElement> InnerChildrens = child.findElements(By.tagName(InnerChildTagName));

                        for (WebElement innerchildren : InnerChildrens) {
                            List<WebElement> Spans = innerchildren.findElements(By.tagName(innerchildrenTagName));
                            for (WebElement span : Spans) {
                                String Spantext = span.getText();
                                if (Spantext.equalsIgnoreCase(texttosearch)) {
                                    WebElement Input = child.findElement(By.tagName(siblingInnerTagname));
                                    Actions typeText = new Actions(Driver);
                                    typeText.moveToElement(Input);
                                    typeText.click(Input);
                                    typeText.sendKeys(TexttoEnter);
                                    typeText.perform();

                                    out.println("[INFO] Found child and sibling in parent element, sibling text matched : " + span.getText() + " , expected : " + siblingInnerTagname);
                                    return true;
                                }
                            }

                        }

                    }

                } catch (Exception ex) {

                }
            }

            return false;
        } catch (Exception e) {
            System.err.println("Failed to move to element and click by ID  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickElementbyPartialLinkText(String elementPartialLinkText) {
        try {
            waitForElementByPartialLinkText(elementPartialLinkText);
            WebElement elementToClick = Driver.findElement(By.partialLinkText(elementPartialLinkText));
            elementToClick.click();

            return true;
        } catch (Exception e) {
            System.err.println("Error clicking element by partial link text  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickElementbyName(String elementName) {
        try {
            this.waitForElementByName(elementName);
            WebElement elementToClick = Driver.findElement(By.name(elementName));
            elementToClick.click();

            return true;
        } catch (Exception e) {
            System.err.println("Error clicking element by name  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickElementbyClassName(String elementClassName) {
        try {
            this.waitForElementByClassName(elementClassName);
            WebElement elementToClick = Driver.findElement(By.className(elementClassName));
            elementToClick.click();

            return true;
        } catch (Exception e) {
            System.err.println("Error clicking element by class name  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickElementUsingParentChildTagName(String containerXpath, String phoneNumber) {
        List<String> values = new ArrayList<>();

        try {

            WebElement container = Driver.findElement(By.xpath(containerXpath));

            List<WebElement> divs = container.findElements(By.tagName("div"));
            int i = 0;
            WebElement elementToClick = null;
            for (WebElement div : divs) {
                try {
                    if (div.getAttribute("dest").contains(phoneNumber)) {
                        elementToClick = divs.get(i);
                    }
                } catch (Exception ex) {

                }
                i++;
            }

            elementToClick.click();
            return true;
        } catch (Exception ex) {
            System.err.println("Could not find elements" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }

    }

    public String getTextOfLastElementInList(String containerXpath) {
        List<String> values = new ArrayList<>();
        try {

            WebElement container = Driver.findElement(By.xpath(containerXpath));
            List<WebElement> divs = container.findElements(By.className("mod-multiChat-smsfloat1 mod-multiChat-smsItemCon i-width100p"));
            int i = 0;
            WebElement elementOfInterest = null;
            for (WebElement div : divs) {
                try {
                    if (div.getTagName().equals("div")) {
                        elementOfInterest = divs.get(i);
                    }
                } catch (Exception ex) {

                }
                i++;
            }

            System.out.println("A: " + elementOfInterest.getText());
            return elementOfInterest.getText();
        } catch (Exception ex) {

            System.err.println("Could not find elements" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return "";
        }

    }

    public boolean elementContainsTextById(String elementId) {
        try {
            String retrievedText = "";
            this.waitForElementById(elementId);
            WebElement elementToEvaluate = Driver.findElement(By.id(elementId));
            retrievedText = elementToEvaluate.getText();
            return !retrievedText.equals("");
        } catch (Exception e) {
            System.err.println("Error checking if element contains text - " + elementId + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clearTextAndEnterValueById(String elementId, String textToEnter) {
        try {
            this.waitForElementById(elementId);
            WebElement elementToTypeIn = Driver.findElement(By.id(elementId));
            Actions clearText = new Actions(Driver);
            Actions typeText = new Actions(Driver);

            elementToTypeIn.click();
            clearText.sendKeys(Keys.DELETE);
            clearText.sendKeys(Keys.DELETE);
            clearText.sendKeys(Keys.DELETE);
            clearText.sendKeys(Keys.DELETE);
            clearText.sendKeys(Keys.DELETE);
            clearText.sendKeys(Keys.DELETE);
            clearText.sendKeys(Keys.DELETE);
            clearText.sendKeys(Keys.DELETE);
            clearText.sendKeys(Keys.DELETE);
            clearText.sendKeys(Keys.DELETE);

            clearText.perform();

            typeText.moveToElement(elementToTypeIn);
            typeText.sendKeys(elementToTypeIn, textToEnter);
            typeText.click(elementToTypeIn);
            typeText.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error entering text - " + elementId + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean selectAndDeleteTextUsingXpath(String elementXpath, String replaceText) {
        try {
            this.waitForElementByXpath(elementXpath);

            Actions action = new Actions(Driver);
            action.sendKeys(Keys.chord(Keys.CONTROL, "a"), replaceText);

            action.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error deleting text - " + elementXpath + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean selectAndDeleteTextByXpath(String elementXpath) {
        try {
            this.waitForElementByXpath(elementXpath);

            Actions action = new Actions(Driver);
            action.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            action.sendKeys(Keys.chord(Keys.DELETE));

            action.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error deleting text - " + elementXpath + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String getElementTextByXpath(String elementXpath) {
        try {
            String retrievedText;
            this.waitForElementByXpath(elementXpath);
            WebElement elementToEvaluate = Driver.findElement(By.xpath(elementXpath));
            retrievedText = elementToEvaluate.getText();

            if (retrievedText.equals("")) {
                retrievedText = elementToEvaluate.getText();
            }
            return retrievedText;
        } catch (Exception ex) {

            System.err.println("Could not find elements" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return "";
        }

    }

    public List<String> retrieveListOfElementsSpan(String elementXpath) {
        try {
            Thread.sleep(5000);

            List<String> reportData = new ArrayList<String>();
            WebElement element1 = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> divRows = element1.findElements(By.tagName("span"));

            for (WebElement _divData : divRows) {
                reportData.add(_divData.getText());
            }

            return reportData;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public String getElementToolTipTextByXpath(String elementXpath) {
        try {
            String retrievedText;
            this.waitForElementByXpath(elementXpath);
            retrievedText = Driver.findElement(By.xpath(elementXpath)).getText();

            int x = 0;
            if (retrievedText.equals("")) {
                while (x < 5) {
                    if (retrievedText.equals("")) {
                        this.waitForElementByXpath(elementXpath);
                        retrievedText = Driver.findElement(By.xpath(elementXpath)).getText();
                        x++;
                    } else {
                        x = 5;
                    }

                }
            }

            return retrievedText;
        } catch (Exception ex) {

            System.err.println("Could not find elements" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return "";
        }

    }

    public void clearTextById(String elementId) {
        try {
            this.waitForElementById(elementId);
            WebElement elementToTypeIn = Driver.findElement(By.id(elementId));
            elementToTypeIn.clear();
        } catch (Exception e) {
            System.err.println("Error clearing text - " + elementId + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
    }

    public boolean clearTextByXpath(String elementXpath) {
        try {
            Actions action = new Actions(Driver);
            action.sendKeys();
            this.waitForElementByXpath(elementXpath);
            WebElement elementToTypeIn = Driver.findElement(By.xpath(elementXpath));
            elementToTypeIn.clear();
        } catch (Exception e) {
            System.err.println("Error clearing text - " + elementXpath + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return true;
    }

    public void PressArrowDown() {
        Actions action = new Actions(Driver);
        action.sendKeys(Keys.ARROW_DOWN);//.sendKeys("keysToSend");
        action.build().perform();
        pause(1000);
    }
    public void PressEnter() {
        Actions action = new Actions(Driver);
        action.sendKeys(Keys.ENTER);//.sendKeys("keysToSend");
        action.build().perform();
        pause(1000);
    }
    public void KeyPress(String keyToPress) {
        try {
            Actions action = new Actions(Driver);
            action.sendKeys(keyToPress);
            action.perform();

        } catch (Exception e) {
            System.err.println("Error Pressing Key - " + keyToPress + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
    }

    public boolean enterTextById(String elementId, String textToEnter) {
        try {
            this.waitForElementById(elementId);
            WebElement elementToTypeIn = Driver.findElement(By.id(elementId));
            elementToTypeIn.clear();
            Actions typeText = new Actions(Driver);
            typeText.moveToElement(elementToTypeIn);
            typeText.click(elementToTypeIn);
            typeText.sendKeys(elementToTypeIn, textToEnter);
            typeText.click(elementToTypeIn);
            typeText.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error entering text - " + elementId + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean enterTextByXpath(String elementXpath, String textToEnter) {
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToTypeIn = Driver.findElement(By.xpath(elementXpath));
            elementToTypeIn.sendKeys(Keys.chord(Keys.CONTROL, "a"), textToEnter);

            return true;
        } catch (Exception e) {
            System.err.println("Error entering text - " + elementXpath + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean EnterTextByXpath(String elementXpath, String textToEnter) {
        try {
            this.waitForElementByXpath(elementXpath, 5);
            WebElement elementToTypeIn = Driver.findElement(By.xpath(elementXpath));
            elementToTypeIn.sendKeys(Keys.chord(Keys.CONTROL, "a"), textToEnter);

            return true;
        } catch (Exception e) {
            System.err.println("Error entering text - " + elementXpath + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean EnterTextByXpathNew(String elementXpath, String textToEnter) {
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToTypeIn = Driver.findElement(By.xpath(elementXpath));
//            elementToTypeIn.clear();
            Actions typeText = new Actions(Driver);
            typeText.moveToElement(elementToTypeIn);
            typeText.click(elementToTypeIn);
            typeText.sendKeys(elementToTypeIn, textToEnter);
            typeText.click(elementToTypeIn);
            typeText.perform();

            System.out.println("[Info] Entered text '" + textToEnter + "' into element '" + elementXpath + "'");

            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to enter text - " + elementXpath + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public int CheckTableType(String elementXpath) {
        int counter = 0;
        boolean found = false;

        try {
            Thread.sleep(5000);
            System.out.println("[Info]  row number where a status is foundinside a table - " + elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            String type = "";

            for (WebElement Element : liElement) {
                List<WebElement> CellElement = Element.findElements(By.tagName("td"));
                for (WebElement cellElement : CellElement) {
                    String as = cellElement.getText();
                    if (cellElement.getText().equals("Job")) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }

                counter++;
            }

            return counter;

        } catch (Exception e) {
            System.err.println("[Error] row number where a status is found inside a table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return 0;
        }

    }

    public int CheckTableTypeMessage(String elementXpath) {
        int counter = 0;
        boolean found = false;

        try {
            Thread.sleep(5000);
            System.out.println("[Info]  row number where a status is foundinside a table - " + elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            String type = "";

            for (WebElement Element : liElement) {
                List<WebElement> CellElement = Element.findElements(By.tagName("td"));
                for (WebElement cellElement : CellElement) {
                    //String as = cellElement.getText();
                    if (cellElement.getText().equals("SMS")) {
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
                counter++;
            }

            return counter;

        } catch (Exception e) {
            System.err.println("[Error] row number where a status is found inside a table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return 0;
        }

    }

    public boolean clickjobtype(String elementXpath, int rowNum) {

        int counter = 0;

        List<String> TableData = new ArrayList<>();

        try {
            Thread.sleep(5000);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                if (counter == rowNum) {
                    Element.click();
                    break;
                }
                counter++;
            }

            return true;

        } catch (Exception e) {
            System.err.println("[Error] row number where a status is found inside a table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

    }

    public boolean clearAndEnterTextByXpath(String elementXpath, String textToEnter) {
        try {
//            this.waitForElementByXpath(elementXpath);
            WebElement elementToTypeIn = Driver.findElement(By.xpath(elementXpath));
            elementToTypeIn.clear();
            Actions typeText = new Actions(Driver);
            typeText.moveToElement(elementToTypeIn);
            typeText.click(elementToTypeIn);
            typeText.keyDown(elementToTypeIn, Keys.BACK_SPACE);
            pause(2000);
            typeText.keyUp(elementToTypeIn, Keys.BACK_SPACE);
            typeText.sendKeys(elementToTypeIn, textToEnter);
            typeText.click(elementToTypeIn);
            typeText.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error entering text - " + elementXpath + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clearExistingTextByXpath(String elementXpath) {
        try {
//            this.waitForElementByXpath(elementXpath);
            WebElement elementToTypeIn = Driver.findElement(By.xpath(elementXpath));
            elementToTypeIn.clear();

            return true;
        } catch (Exception e) {
            System.err.println("Error entering text - " + elementXpath + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean moveToAndEnterTextByXpath(String elementXpath, String textToEnter) {
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToTypeIn = Driver.findElement(By.xpath(elementXpath));
            Actions typeText = new Actions(Driver);
            typeText.moveToElement(elementToTypeIn);
            typeText.click(elementToTypeIn);
            typeText.sendKeys(elementToTypeIn, textToEnter);
            typeText.click(elementToTypeIn);
            typeText.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error entering text - " + elementXpath + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public void scrollDownByOnePage(String elementId) {
        try {
            this.waitForElementById(elementId);
            WebElement scrollElement = Driver.findElement(By.id(elementId));
            scrollElement.sendKeys(Keys.PAGE_DOWN);

            System.out.println("Sucessfully scrolled down...");
        } catch (Exception e) {
            System.err.println("Error scrolling page - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
    }

    public boolean enterTextByName(String elementName, String textToEnter) {
        try {

            //Thread.sleep(500);
            this.waitForElementByName(elementName);
            WebElement elementToTypeIn = Driver.findElement(By.name(elementName));
            elementToTypeIn.clear();
            elementToTypeIn.sendKeys(textToEnter);
            elementToTypeIn.click();
            return true;
        } catch (Exception e) {
            System.err.println("Error entering text by name  - " + elementName + " Error : " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean enterTextByClassName(String elementClassName, String textToEnter) {
        try {
            //Thread.sleep(500);
            this.waitForElementByClassName(elementClassName);
            WebElement elementToTypeIn = Driver.findElement(By.className(elementClassName));
            elementToTypeIn.clear();
            elementToTypeIn.sendKeys(textToEnter);

            return true;
        } catch (Exception e) {
            System.err.println("Error entering text by class name  - " + elementClassName + " Error : " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    // Requires a fully qualified URL - eg: "http://www.myURL.com"
    public boolean navigateTo(String pageUrl) {
        try {
            Driver.navigate().to(pageUrl);

            return true;
        } catch (Exception e) {
            System.err.println("Error navigating to URL - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String getUrl() {
        try {

            String url = Driver.getCurrentUrl().toString();

            return url;
        } catch (Exception e) {
            System.err.println("Error navigating to URL - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public boolean waitForElementNoLongerPresentById(String elementId) {
        boolean elementFound = true;
        try {
            int waitCount = 0;
            while (elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementId))) == null) {
                        elementFound = false;
                        break;
                    }
                } catch (Exception e) {
                    this.DriverExceptionDetail = e.getMessage();
                    elementFound = false;
                    break;
                }

                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("Error waiting for element to be no longer present by ID  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementById(String elementId) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementId))) != null) {

                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("Error waiting for element by ID  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementById(String elementId, Integer timeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementId))) != null) {

                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("Error waiting for element by ID  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByCSSSelector(String elementCSSSelector) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementCSSSelector))) != null) {

                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("Error waiting for element by CSS Selector  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByLinkText(String elementLinkText) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {

                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(elementLinkText))) != null) {

                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] waiting for element by link text : '" + elementLinkText + "'  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByPartialLinkText(String elementPartialLinkText) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    Driver.findElement(By.partialLinkText(elementPartialLinkText));
                    elementFound = true;
                    break;
                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] waiting for element by partial link text : '" + elementPartialLinkText + "'  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByClassName(String elementClassName) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.className(elementClassName))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] waiting for element by class name : '" + elementClassName + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByClassName(String elementClassName, Integer timeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.className(elementClassName))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] waiting for element by class name : '" + elementClassName + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByName(String elementName) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.name(elementName))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("Error waiting for element by name  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementNoLongerPresentByClass(String elementClass, Integer timeout) {
        boolean elementFound = true;
        try {
            int waitCount = 0;
            while (elementFound && waitCount < timeout) {
                try {
                    Driver.findElement(By.className(elementClass));
                    elementFound = true;
                } catch (Exception e) {
                    this.DriverExceptionDetail = e.getMessage();
                    elementFound = false;
                    break;
                }
                Thread.sleep(500);
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("Error waiting for element to be no longer present by Class  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return !elementFound;
    }

    public boolean specialWaitForElementByName(String elementName, String type) {
        boolean elementFound = false;
        String elementType = "";
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.name(elementName))) != null) {
                        WebElement element = Driver.findElement(By.name(elementName));
                        try {
                            String tagName = element.getTagName();
                            if (tagName.equals("input")) {
                                elementType = "textbox";
                            } else if (tagName.equals("select")) {
                                elementType = "dropdownList";
                            }
                        } catch (Exception ex) {
//                            System.err.println("[Error] Failed to wait for element by name  - " + ex.getMessage());
                            this.DriverExceptionDetail = ex.getMessage();
                            elementFound = false;
                        }

                        elementFound = type.equals(elementType);
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("Error waiting for element by name  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByName(String elementName, int waitTimeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < waitTimeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.name(elementName))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("Error waiting for element by name  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByNameNoExceptions(String elementName, int waitTimeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < waitTimeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.name(elementName))) != null) {
                        if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(elementName))) != null) {
                            elementFound = true;
                        } else {
                            elementFound = false;
                            System.err.println("[Error] Element found but is not visible.");
                        }

                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] Failed to find element by name '" + elementName + "'");
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByLinkTextNoExceptions(String elementText, int waitTimeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < waitTimeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(elementText))) != null) {
                        if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(elementText))) != null) {
                            elementFound = true;
                        } else {
                            elementFound = false;
                            System.err.println("[Error] Element found but is not visible.");
                        }

                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] Failed to find element by link text '" + elementText + "'");
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean checkIfCheckBoxeIsNotCheckedByXpathUsingActions(String elementXpath) {
        String propertyValue = "";
        try {

            this.waitForElementByXpath(elementXpath);

            propertyValue = Driver.findElement(By.xpath(elementXpath)).getAttribute("checked");

            if (!propertyValue.equalsIgnoreCase("true")) {
                WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
                elementToClick.click();
            }

            return true;
        } catch (Exception e) {
            System.err.println("Error checking if all checkboxes are checked - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String getElementAttributeByXpath(String elementXpath, String attributeName) {
        String propertyValue = "";
        try {
            this.waitForElementByXpath(elementXpath);

            propertyValue = Driver.findElement(By.xpath(elementXpath)).getAttribute(attributeName);

        } catch (Exception e) {
            System.err.println("[Error] Finding element by Xpath and retrieving attribute '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

        }

        if (propertyValue == null) {
            propertyValue = "";
        }

        return propertyValue;
    }

//     public String getSelectedDropdownOptionTextByXpath(String elementXpath) {
//        try {
//            waitForElementByXpath(elementXpath);
//            Select dropDownList = new Select(Driver.findElement(By.xpath(elementXpath)));
//            String selectedValue = dropDownList.getFirstSelectedOption().getText();
//
//            return selectedValue;
//        } catch (Exception e) {
//            System.err.println("[Error] Failed to retrieve selected dropdown option index using Id - " + e.getMessage());
//            this.DriverExceptionDetail = e.getMessage();
//            return null;
//        }
//    }
    public String retrieveValueByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            retrievedText = elementToRead.getAttribute("value");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve value from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public boolean waitUntilElementEnabledByXpath(String elementXpath) {
        boolean isEnabled = false;
        try {
            int counter = 0;
            isEnabled = false;
            WebDriverWait wait = new WebDriverWait(Driver, 2);

            while (!isEnabled && counter < ApplicationConfig.WaitTimeout()) {
                if (wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath))) != null) {
                    isEnabled = true;
                    break;
                } else {
                    counter++;
                    //Thread.sleep(500);
                }

            }
        } catch (Exception e) {
            System.err.println("Error waiting for element to be enabled - " + e.getMessage());
        }
        return isEnabled;
    }

    public boolean waitForElementByXpath(String elementXpath) {
        System.out.println("[INFO] Waiting For Element by Xpath : " + elementXpath);
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean moveToElementAndWaitByXpath(String elementXpath) {
        try {
            Actions moveTo = new Actions(Driver);
            moveTo.moveToElement(Driver.findElement(By.xpath(elementXpath)));
            moveTo.perform();
            Thread.sleep(2000);
            return true;
        } catch (Exception e) {
            System.err.println("Error moving to element - " + elementXpath + " - " + e.getStackTrace().toString());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean waitForElementByXpath(String elementXpath, Integer timeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean isElementDisplayedAtIndexbyXpath(String elementXpath, Integer index) {

        boolean elementFound = false;
        int counter = 0;

        try {
            Thread.sleep(3000);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                if (counter == index) {
                    if (Element.isDisplayed()) {
                        elementFound = true;
                        break;
                    } else {
                        elementFound = false;
                        break;
                    }
                }
                counter++;
            }

            return elementFound;

        } catch (Exception e) {
            System.err.println("[Error] row number where a status is found inside a table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean waitForElementByXpathVisibility(String elementXpath, Integer timeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))) != null) {
                        if (wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementXpath))) != null) {
                            elementFound = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByXpathVisibility(String elementXpath) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))) != null) {
                        if (wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementXpath))) != null) {
                            elementFound = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByXpathVissible(String elementXpath, Integer timeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))) == null) {
                        elementFound = false;
                        break;
                    } else {
                        elementFound = true;
                    }

                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByXpathTest(String elementXpath, Integer timeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))) != null && wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }

                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementByXpathNoError(String elementXpath, Integer timeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, timeout);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                    return false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

            return elementFound;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public void pause(int milisecondsToWait) {
        try {
            Thread.sleep(milisecondsToWait);
        } catch (Exception e) {

        }
    }

    public void shutDown() {
        retrievedTestValues = null;
        try {

            Driver.quit();
            //CloseChromeInstances();
        } catch (Exception e) {
            System.err.println("Error shutting down driver - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        _isDriverRunning = false;
    }

    public void takeScreenShot(String screenShotDescription, boolean isError) {
        String imageFilePathString = "";

        try {
            StringBuilder imageFilePathBuilder = new StringBuilder();
            // add date time folder and test case id folder
            imageFilePathBuilder.append(reportDirectory).append("\\");
            imageFilePathBuilder.append(String.format("%03d", screenShotFolderCounter)).append(" - ");
            imageFilePathBuilder.append(testCaseId).append("\\");
            imageFilePathBuilder.append(String.format("%03d", screenShotCounter));
            imageFilePathBuilder.append(" - ");
            if (isError) {
                imageFilePathBuilder.append("FAILED_");
            } else {
                imageFilePathBuilder.append("PASSED_");
            }

            //imageFilePathBuilder.append(testCaseId).append(" ");
            imageFilePathBuilder.append(screenShotDescription);

            imageFilePathBuilder.append(".png");

            imageFilePathString = imageFilePathBuilder.toString();

            File screenShot = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
            FileUtils.moveFile(screenShot, new File(imageFilePathString.toString()));
            screenShotCounter++;
        } catch (Exception e) {
            System.err.println("[Error] could not take screenshot - " + imageFilePathString.toString() + " - " + e.getMessage());
        }
    }

    public void takeScreenShotIe(String screenShotDescription, boolean isError) {
        String imageFilePathString = "";
        try {
            try {
                StringBuilder imageFilePathBuilder = new StringBuilder();
                // add date time folder and test case id folder
                imageFilePathBuilder.append(reportDirectory).append("\\");
                imageFilePathBuilder.append(String.format("%03d", screenShotFolderCounter)).append(" - ");
                imageFilePathBuilder.append(testCaseId).append("\\");
                imageFilePathBuilder.append(String.format("%03d", screenShotCounter));
                imageFilePathBuilder.append(" - ");
                if (isError) {
                    imageFilePathBuilder.append("FAILED_");
                } else {
                    imageFilePathBuilder.append("PASSED_");
                }

                imageFilePathBuilder.append(screenShotDescription);

                imageFilePathBuilder.append(".png");

                imageFilePathString = imageFilePathBuilder.toString();

                Robot robot = new Robot();

                Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
                ImageIO.write(screenFullImage, ".png", new File(imageFilePathString));
            } catch (AWTException e) {
                System.err.println(e);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    public boolean selectByTextFromDropDownListUsingXpath(String elementXpath, String valueToSelect) {
        try {
            waitForElementByXpath(elementXpath);
            Select dropDownList = new Select(Driver.findElement(By.id("BusinessNatureID")));

            dropDownList.selectByVisibleText(valueToSelect);
            return true;
        } catch (Exception e) {
            System.err.println("Error selecting from dropdownlist by text using Id - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean selectByTextFromDropDownListusingXpath(String elementXpath, String valueToSelect) {
        try {
            waitForElementByXpath(elementXpath);
            Select dropDownList = new Select(Driver.findElement(By.xpath(elementXpath)));

            dropDownList.selectByVisibleText(valueToSelect);

            return true;
        } catch (Exception e) {
            System.err.println("Error selecting from dropdownlist by text using xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String generateDateTimeString() {
        Date dateNow = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");

        return dateFormat.format(dateNow).toString();
    }

    public String generateDateTimeString(String format) {
        Date dateNow = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat(format);

        return dateFormat.format(dateNow).toString();
    }

    public String generateNextFirstDayOfTheMonth(String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            Date dateNow = new Date();
            Calendar cal = new GregorianCalendar();

            cal.setTime(dateNow);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            if (day == 1) {
                return dateFormat.format(cal.getTime()).toString();
            }

            cal.add(Calendar.MONTH, 1);
            cal.set(Calendar.DAY_OF_MONTH, 1);

            System.out.println("[Info] Successfully generated next first day of the month - '" + dateFormat.format(cal.getTime()).toString() + "'");
            return dateFormat.format(cal.getTime()).toString();
        } catch (Exception e) {
            System.err.println("[Error] Unable to generate the next first day of the month - " + e.getMessage());
            return "";
        }

    }

    public String generateFirstDayOfTheCurrentMonth(String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
            Date dateNow = new Date();
            Calendar cal = new GregorianCalendar();

            cal.setTime(dateNow);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            if (day == 1) {
                return dateFormat.format(cal.getTime()).toString();
            }

            cal.set(Calendar.DAY_OF_MONTH, 1);

            System.out.println("[Info] Successfully generated first day of the current month - '" + dateFormat.format(cal.getTime()).toString() + "'");
            return dateFormat.format(cal.getTime()).toString();
        } catch (Exception e) {
            System.err.println("[Error] Unable to generate the first day of the current month - " + e.getMessage());
            return "";
        }

    }

    public void CloseChromeInstances() {
        try {
            if (browserType.equals(Enums.BrowserType.Chrome)) {
                String TASKLIST = "tasklist";
                String KILL = "taskkill /IM ";
                String line;
                String serviceName = "chrome.exe";
                Process p = Runtime.getRuntime().exec(TASKLIST);
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        p.getInputStream()));
                System.out.println("Closing Chrome tasks...");
                while ((line = reader.readLine()) != null) {

                    if (line.contains(serviceName)) {
                        Runtime.getRuntime().exec(KILL + serviceName);
                    }
                }
            }
        } catch (Exception ex) {

        }
    }

    public boolean compareValues(String ElementId, String valueToCompare) {
        try {
            WebElement Element = Driver.findElement(By.id(ElementId));
            String valueFromElement = Element.getAttribute("value");

            if (valueFromElement.toUpperCase().trim().equals(valueToCompare.toUpperCase().trim())) {
                System.out.println("Specified values found: " + valueFromElement + " AND " + valueToCompare);
                return true;
            } else {
                System.err.println("Specified values do not match : " + valueFromElement + " AND " + valueToCompare);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("[ERROR] Failed to find specified element : " + ex.getMessage());
            return false;
        }
    }

    public boolean compareValuesWithSubString(String ElementId, int StartValue, int EndValue, String valueToCompare) {
        try {

            WebElement Element = Driver.findElement(By.id(ElementId));
            String valueFromElement = Element.getAttribute("value").substring(StartValue, EndValue);

            if (valueFromElement.toUpperCase().trim().equals(valueToCompare.toUpperCase().trim())) {
                System.out.println("Specified values found: " + valueFromElement + " AND " + valueToCompare);
                return true;
            } else {
                System.err.println("Specified values do not match : " + valueFromElement + " AND " + valueToCompare);
                return false;
            }
        } catch (Exception ex) {
            System.err.println("[ERROR] Failed to find specified element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean CheckForPrescenceOfAnElementUsingId(String containerId, String ElementID) {
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement DivList = Driver.findElement(By.id(containerId));
            List<WebElement> Elements = DivList.findElements(By.id(ElementID));
            return Elements.size() != 0;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean CheckForPrescenceOfAnElementUsingSingleId(String ElementID) {
        try {
            SeleniumDriverInstance.waitForElementById(ElementID);

            WebElement DivList = Driver.findElement(By.id(ElementID));
            List<WebElement> Elements = DivList.findElements(By.id(ElementID));
            return Elements.size() != 0;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean CheckForPrescenceOfAnElementUsingClassName(String containerXpath, String ElementClassName) {
        try {
            SeleniumDriverInstance.waitForElementByXpath(containerXpath);

            WebElement DivList = Driver.findElement(By.xpath(containerXpath));
            List<WebElement> Elements = DivList.findElements(By.className(ElementClassName));
            return Elements.size() != 0;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean CheckForPrescenceOfAnElementUsingName(String ElementName) {
        try {
            SeleniumDriverInstance.waitForElementByName(ElementName);

            WebElement DivList = Driver.findElement(By.name(ElementName));
            List<WebElement> Elements = DivList.findElements(By.className(ElementName));
            return Elements.size() != 0;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean CheckForPrescenceOfAnElementUsingLinkText(String containerId, String ElementLinkText) {
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement DivList = Driver.findElement(By.id(containerId));
            List<WebElement> Elements = DivList.findElements(By.linkText(ElementLinkText));
            return Elements.size() != 0;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean CheckForPrescenceOfAnElementUsingLinkTextSingle(String ElementLinkText) {
        try {
            SeleniumDriverInstance.waitForElementByLinkText(ElementLinkText);

            WebElement DivList = Driver.findElement(By.linkText(ElementLinkText));
            return DivList != null;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean CheckForPrescenceOfAnElementUsingPartialLinkTextSingle(String ElementLinkText) {
        try {
            SeleniumDriverInstance.waitForElementByPartialLinkText(ElementLinkText);

            WebElement DivList = Driver.findElement(By.partialLinkText(ElementLinkText));
            return DivList != null;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean CheckForPrescenceOfAnElementUsingXpath(String containerId, String Xpath) {
        try {
            SeleniumDriverInstance.waitForElementById(containerId);

            WebElement DivList = Driver.findElement(By.id(containerId));
            List<WebElement> Elements = DivList.findElements(By.xpath(Xpath));
            return Elements.size() != 0;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public Boolean ClickEmbeddedTableButtonUsingFirstCellText(String containerID, String tableXpath, String subTag, String EmbeddedTag, String validationText, String ButtonXpath) {
        String firstCellText = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerID);

            WebElement div = Driver.findElement(By.id(containerID));
            System.out.println("Found div");
            WebElement table = div.findElement(By.xpath(tableXpath));
            System.out.println("Found table");
            List<WebElement> rows = table.findElements(By.tagName(subTag));
            int rowCount = 1;
            for (WebElement row : rows) {
                System.out.println("Row - " + rowCount);
                List<WebElement> cells = row.findElements(By.tagName(EmbeddedTag));

                if (cells == null || cells.size() < 1) {
                    continue;
                }
                WebElement firstCell = cells.get(0);
                System.out.println("Found cells: " + cells.size());
                firstCellText = firstCell.getText();

                if (firstCellText.toUpperCase().trim().equals(validationText.toUpperCase().trim())) {
                    System.out.println(firstCellText + " = " + validationText);
                    WebElement button = row.findElement(By.xpath(ButtonXpath));
                    System.out.println("Button found, about to click!!!!!");
                    button.click();

                    return true;
                }
            }
            return true;
        } catch (Exception ex) {
            System.out.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean nestedHoverOverElementAndClickByXpath(String ParentElementXpath, String SubElementXpath, String ChildElementXpath) {
        try {

            Actions actions = new Actions(Driver);
            WebElement Div = Driver.findElement(By.xpath(ParentElementXpath));
            actions.moveToElement(Div);
            SeleniumDriverInstance.pause(5000);
            actions.perform();
            WebElement SubElement = Driver.findElement(By.xpath(SubElementXpath));
            actions.moveToElement(SubElement);
            SeleniumDriverInstance.pause(5000);
            actions.perform();

            WebElement ChildElement = Driver.findElement(By.xpath(ChildElementXpath));
            actions.moveToElement(ChildElement);
            SeleniumDriverInstance.pause(500);
            actions.click();
            actions.perform();
            return true;
        } catch (Exception e) {
            System.err.println("Failed to hover over element and click sub element by ID and Xpath  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean nestedHoverOverJobsElementAndClickByXpath(String ParentElementXpath, String SubElementXpath, String ChildElementXpath) {
        try {
            if (!this.waitForElementByXpath(ParentElementXpath)) {
                return false;
            }
//            SeleniumDriverInstance.pause(5000);
            Actions actions = new Actions(Driver);
            WebElement Div = Driver.findElement(By.xpath(ParentElementXpath));
            actions.moveToElement(Div);
            actions.perform();
            if (!this.waitForElementByXpath(SubElementXpath)) {
                return false;
            }
            //SeleniumDriverInstance.pause(5000);
            WebElement SubElement = Driver.findElement(By.xpath(SubElementXpath));
            actions.moveToElement(SubElement);
            actions.perform();
            if (!this.waitForElementByXpath(ChildElementXpath)) {
                return false;
            }
            //SeleniumDriverInstance.pause(1000);
            WebElement ChildElement = Driver.findElement(By.xpath(ChildElementXpath));
            actions.moveToElement(ChildElement);
            SeleniumDriverInstance.pause(1000);
            actions.click();
            actions.perform();
            return true;
        } catch (Exception e) {
            System.err.println("Failed to hover over element and click sub element by ID and Xpath  - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean ClickEmbeddedTableButtonUsingCellTextAndButtonText(String containerID, String tableXpath, String subTag, String EmbeddedTag, String validationText, String ButtonTag, String ButtonValText) {
        String ButtonText = "";
        String firstCellText = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerID);

            WebElement div = Driver.findElement(By.id(containerID));
            System.out.println("Found div");
            WebElement table = div.findElement(By.xpath(tableXpath));
            System.out.println("Found table");
            List<WebElement> rows = table.findElements(By.tagName(subTag));
            int rowCount = 1;
            for (WebElement row : rows) {
                System.out.println("Row - " + rowCount);
                List<WebElement> cells = row.findElements(By.tagName(EmbeddedTag));

                if (cells == null || cells.size() < 1) {
                    continue;
                }
                WebElement firstCell = cells.get(0);
                System.out.println("Found cells: " + cells.size());
                firstCellText = firstCell.getText();
                System.out.println("First cell: " + firstCellText + " while the Validation text: " + validationText);

                if (firstCellText.toUpperCase().trim().equals(validationText.toUpperCase().trim())) {
                    System.out.println("firstCell = " + firstCellText + "   &   Validation Text = " + validationText);
                    System.out.println(firstCellText + " = " + validationText);
                    List<WebElement> buttons = row.findElements(By.tagName(ButtonTag));
                    System.out.println("Buttons found, about to click!!!!!");
                    for (WebElement button : buttons) {
                        ButtonText = button.getText();
                        System.out.println("Found : " + ButtonText + " button.");
                        if (ButtonText.toUpperCase().trim().equals(ButtonValText.toUpperCase())) {
                            System.out.println("Clicking button:         Button Text: " + ButtonText + "  <===>  " + ButtonValText);
                            button.click();
                            System.out.println("Clicking button");
                            return true;
                        }
                    }
                    return true;
                }
                rowCount++;
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean ClickListItemUsingDivId(String containerID, String parentTagName, String childTagName, String EmbeddedParentTag, String validationText) {
        String ChildElementText = "";

        try {
            SeleniumDriverInstance.waitForElementById(containerID);

            WebElement div = Driver.findElement(By.id(containerID));
            System.out.println("[INFO] Found Div" + containerID);
            List<WebElement> ParentElements = div.findElements(By.tagName(parentTagName));
            System.out.println("[INFO] Found parent element: " + parentTagName);

            int rowCount = 1;
            for (WebElement ParentElement : ParentElements) {
                System.out.println("Row - " + rowCount);
                List<WebElement> ChildElements = ParentElement.findElements(By.tagName(childTagName));
                System.out.println("Making a list of child elements");

                int itemCount = 1;
                for (WebElement ChildElement : ChildElements) {
                    System.out.println("[INFORMATION] Found these Child elements: " + ChildElement.getText());
                    List<WebElement> EmbeddedParentElements = ChildElement.findElements(By.tagName(EmbeddedParentTag));

                    for (WebElement EmbeddedParentElement : EmbeddedParentElements) {
                        ChildElementText = EmbeddedParentElement.getText();
                        System.out.println(ChildElementText);
                        System.out.println("These are embedded tags: " + EmbeddedParentElement.getText());

                        if (ChildElementText.toUpperCase().trim().equals(validationText.toUpperCase().trim())) {
                            System.out.println("About to click child element button");
                            ChildElement.click();
                            System.out.println("Child element button click");
                            return true;
                        }
                    }
                    itemCount++;
                }
                rowCount++;
                return true;
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean ClickListItemUsingDivId2(String divID, String aTagName, String spanTag, String validationText) {
        String ChildElementText = "";

        try {
            SeleniumDriverInstance.waitForElementById(divID);

            WebElement div = Driver.findElement(By.id(divID));
            System.out.println("[INFO] Found Div" + divID);
            List<WebElement> ParentElements = div.findElements(By.tagName(aTagName));
            System.out.println("[INFO] Found parent element: " + aTagName);

            int itemCount = 1;
            for (WebElement ParentElement : ParentElements) {
                System.out.println("[INFORMATION] Found these Child elements: " + ParentElement.getText());
                List<WebElement> ChildElements = ParentElement.findElements(By.tagName(spanTag));

                for (WebElement ChildElement : ChildElements) {
                    ChildElementText = ChildElement.getText();
                    System.out.println(ChildElementText);
                    System.out.println("These are embedded tags: " + ChildElement.getText());

                    if (ChildElementText.toUpperCase().trim().equals(validationText.toUpperCase().trim())) {
                        System.out.println("About to click child element button");
                        ChildElement.click();
                        System.out.println("Child element button click");
                        return true;
                    }
                }
                itemCount++;
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean ClickSubMenuItemUsingContainerID(String containerID, String parentTagName, String childTagName, String SubTagName, String validationText) {
        String SubElementText = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerID);

            WebElement div = Driver.findElement(By.id(containerID));
            System.out.println("[INFO] Found Div" + containerID);
            List<WebElement> ParentElements = div.findElements(By.tagName(parentTagName));
            System.out.println("[INFO] Found parent element: " + parentTagName);

            int rowCount = 1;
            for (WebElement ParentElement : ParentElements) {
                System.out.println("Row - " + rowCount);
                List<WebElement> ChildElements = ParentElement.findElements(By.tagName(childTagName));
                System.out.println("Making a list of child elements");

                int itemCount = 1;
                for (WebElement ChildElement : ChildElements) {
                    System.out.println("[INFORMATION] Found these Child elements: " + ChildElement.getText());
                    WebElement subElement = ChildElement.findElement(By.tagName(SubTagName));
                    SubElementText = subElement.getText();
                    System.out.println(SubElementText);
                    System.out.println("These are embedded tags: " + subElement.getText());

                    if (SubElementText.toUpperCase().trim().equals(validationText.toUpperCase().trim())) {
                        System.out.println("About to click child element button");
                        subElement.click();
                        System.out.println("Child element button click");
                        return true;
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean validateLiveTrackingDeCartaDropDownList(String paneClassName, String dropdownTagName, String dropdownElementsTagName, String optionTextToValidate) {
        try {
            this.waitForElementByClassName(paneClassName);
            WebElement rightPane = Driver.findElement(By.className(paneClassName));

            WebElement dropdown = rightPane.findElement(By.tagName(dropdownTagName));

            List<WebElement> dropdownElements = dropdown.findElements(By.tagName(dropdownElementsTagName));

            for (int i = 0; i < dropdownElements.size(); i++) {
                if (dropdownElements.get(i).getText().contains(optionTextToValidate)) {
                    return true;
                }
            }

            return false;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to validate '" + optionTextToValidate + "' was the the map street dropdown - " + ex.getMessage());
            return false;
        }
    }

    public int validateLiveTrackingAssetsDisplay(String tableXpath) {

        int numberOfAssets = 0;

        try {
            WebElement assetsListTable = Driver.findElement(By.xpath(tableXpath));

            WebElement tbody = assetsListTable.findElement(By.tagName("tbody"));

            List<WebElement> assetsTableRows = tbody.findElements(By.tagName("tr"));

            numberOfAssets = assetsTableRows.size();

            return numberOfAssets;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to validate the assets tab exists " + ex.getMessage());
            return -1;
        }
    }

    public boolean ClickItemUsingContainerIdAndLists(String containerID, String Elementxpath, String subChildTag, String ValidationText) {
        String elementText = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerID);

            WebElement div = Driver.findElement(By.id(containerID));
            System.out.println("[INFO] Found div: " + containerID);
            WebElement element = div.findElement(By.xpath(Elementxpath));
            System.out.println("[INFO] Found primary element: " + element.getText());
            WebElement subChild = element.findElement(By.tagName(subChildTag));
            System.out.println("SUBCHILD ELEMENT: " + subChild.getText());

            elementText = subChild.getText();
            System.out.println("Looking for: " + elementText);

            if (elementText.toUpperCase().trim().equals(ValidationText.toUpperCase().trim())) {
                System.out.println("About to click element");
                //SeleniumDriverInstance.highlightElement(Driver, subChild);
                Actions action = new Actions(Driver);
                action.moveToElement(subChild);
                action.perform();
                this.pause(2000);
                action.doubleClick(subChild);
                action.perform();

//                subChild.click();
                return true;
            }

            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage() + "   element: " + elementText);
            return false;
        }
    }

    public boolean ClickItemUsingContainerIdAndList(String containerID, String Elementxpath, String subChildTag, String ValidationText) {
        String elementText = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerID);

            WebElement div = Driver.findElement(By.id(containerID));
            System.out.println("[INFO] Found div: " + containerID);
            WebElement element = div.findElement(By.xpath(Elementxpath));
            System.out.println("[INFO] Found primary element: " + element.getText());
            List<WebElement> subChilds = element.findElements(By.tagName(subChildTag));

            for (WebElement subChild : subChilds) {
                System.out.println("SUBCHILD ELEMENT: " + subChild.getText());
                elementText = subChild.getText();
                System.out.println("Looking for: " + elementText);

                if (elementText.toUpperCase().trim().equals(ValidationText.toUpperCase().trim())) {
                    System.out.println("About to click element");
                    //SeleniumDriverInstance.highlightElement(Driver, subChild);
//                    Actions action = new Actions(Driver);
//                    action.moveToElement(subChild);
//                    action.perform();
                    this.pause(2000);
                    subChild.click();
//                    action.doubleClick(subChild);
//                    action.perform();
                    return true;
                }
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage() + "   element: " + elementText);
            return false;
        }
    }

    public boolean ClickLinkElementViaTagUsingContainerID(String containerID, String ElementTag, String ValidationText) {
        String elementText = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerID);

            WebElement div = Driver.findElement(By.id(containerID));
            System.out.println("Found div");
            List<WebElement> LinkElements = div.findElements(By.tagName(ElementTag));

            for (WebElement LinkElement : LinkElements) {
                elementText = LinkElement.getText().toUpperCase().trim();
                System.out.println("Looking for: " + elementText);

                if (elementText.equals(ValidationText.toUpperCase().trim())) {
                    System.out.println("About to click Link Element");

                    LinkElement.click();
                    this.pause(1000);
                }

                return true;
            }

            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage() + "   element: " + elementText);
            return false;
        }
    }

    public boolean ElementHighlighter(String containerID, String Elementxpath, String subChildTag, String ValidationText) {
        String elementText = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerID);

            WebElement div = Driver.findElement(By.id(containerID));
            System.out.println("[INFO] Found div: " + containerID);
            WebElement element = div.findElement(By.xpath(Elementxpath));
            System.out.println("[INFO] Found primary element: " + element.getText());
            List<WebElement> subChilds = element.findElements(By.tagName(subChildTag));

            for (WebElement subChild : subChilds) {
                System.out.println("SUBCHILD ELEMENT: " + subChild.getText());

                elementText = subChild.getText();
                System.out.println("Looking for: " + elementText);

                if (elementText.toUpperCase().trim().equals(ValidationText.toUpperCase().trim())) {
                    System.out.println("About to highlight element");
                    SeleniumDriverInstance.highlightElement(Driver, subChild);
                    return true;
                }
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage() + "   element: " + elementText);
            return false;
        }
    }

    public void highlightElement(WebDriver Driver, WebElement element) {
        for (int i = 0; i < 1; i++) {
            JavascriptExecutor js = (JavascriptExecutor) Driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: blue; border: 2px solid blue;");
        }
    }

    public boolean ClickItemUsingContainerIdAndListItems(String containerID, String Elementxpath, String subChildTag, String ValidationText) {
        String elementText = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerID);

            WebElement div = Driver.findElement(By.id(containerID));
            System.out.println("[INFO] Found div: " + containerID);
            WebElement element = div.findElement(By.xpath(Elementxpath));
            System.out.println("[INFO] Found primary element: " + element.getText());
            List<WebElement> subChilds = element.findElements(By.tagName(subChildTag));

            for (WebElement subChild : subChilds) {
                System.out.println("SUBCHILD ELEMENT: " + subChild.getText());

                elementText = subChild.getText();
                System.out.println("Looking for: " + elementText);

                if (elementText.toUpperCase().trim().equals(ValidationText.toUpperCase().trim())) {
                    System.out.println("About to click element");
                    //SeleniumDriverInstance.highlightElement(Driver, subChild);
                    Actions action = new Actions(Driver);
                    action.moveToElement(subChild);
                    action.perform();
                    this.pause(2000);
                    action.doubleClick(subChild);
                    action.perform();
                    return true;
                }
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage() + "   element: " + elementText);
            return false;
        }
    }

    public boolean ClickElementUsingContainerIDandElementTag(String ContainerID, String ElementTag) {
        try {
            SeleniumDriverInstance.waitForElementById(ContainerID);

            WebElement div = Driver.findElement(By.id(ContainerID));
            System.out.println("[INFO] Found div @:" + ContainerID);
            WebElement element = div.findElement(By.tagName(ElementTag));
            System.out.println("[INFO] found element @:" + ElementTag);

            System.out.println("About to click the element");
            element.click();

            return true;

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean uploadFileUsingElementIdAndFileLocation(String browseButtonId, String fileLocation) {
        try {
            WebElement fileUpload = Driver.findElement(By.id(browseButtonId));
            fileUpload.sendKeys(fileLocation);
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean selectRadioButtonUsingElementXpathAndBoolean(String radioButtonXpath, boolean mustBeSelected) {
        try {
            WebElement radioButton = Driver.findElement(By.xpath(radioButtonXpath));

            if (mustBeSelected == true) {
                radioButton.click();
            }
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean validateSelectedRadioButtonUsingXpath(String radioButtonXpath) {
        try {
            WebElement radioButton = Driver.findElement(By.xpath(radioButtonXpath));

            radioButton.isSelected();

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean validateAndSelectRadioButtonUsingXpath(String radioButtonXpath) {
        try {
            WebElement radioButton = Driver.findElement(By.xpath(radioButtonXpath));
            SeleniumDriverInstance.pause(500);
            if (!radioButton.isSelected()) {
                radioButton.click();
            }

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean selectRadioButtonUsingElementIdAndBoolean(String radioButtonId, boolean mustBeSelected) {
        try {
            WebElement radioButton = Driver.findElement(By.id(radioButtonId));

            if (mustBeSelected == true) {
                radioButton.click();
            }
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public Boolean SelectFromEmbeddedTableElementByXpathUsingContainerXpath(String containerId, String ParentTag, String ChildTag, String validationText, String ListContainerId, String ItemTag, String ItemText) {
        String ChildElementText = "";
        String ListItemText = "";
        try {
            SeleniumDriverInstance.waitForElementById(containerId);
            WebElement Div = Driver.findElement(By.id(containerId));
            List<WebElement> ParentElements = Div.findElements(By.tagName(ParentTag));

            for (WebElement ParentElement : ParentElements) {
                List<WebElement> ChildElements = ParentElement.findElements(By.tagName(ChildTag));

                for (WebElement ChildElement : ChildElements) {
                    ChildElementText = ChildElement.findElement(By.tagName(ChildTag)).getText();

                    if (ChildElementText == null) {
                        continue;
                    }

                    System.out.println("Detected child element text :" + ChildElementText);

                    if (ChildElementText.equals(validationText)) {
                        System.out.println("About to click: " + ChildElementText);
                        ParentElement.click();
                        System.out.println("Clicked: " + ChildElementText);
                        WebElement ListContainer = Driver.findElement(By.id(ListContainerId));
                        System.out.println("Found Container Element: " + ListContainer.getText());
                        List<WebElement> ListItems = ListContainer.findElements(By.tagName(ItemTag));
                        System.out.println("Listing List Items");
                        SeleniumDriverInstance.pause(500);
                        for (WebElement ListItem : ListItems) {
                            ListItemText = ListItem.getText();
                            System.out.println("Found ListElement: " + ListItemText);

                            if (ListItemText.equals(ItemText)) {
                                ListItem.click();
                                System.out.println("Clicking Item :" + ListItem.getText());
                                return true;
                            }
                        }
                    }
                }
            }
            System.err.println("[ERROR] failed to find element : " + ItemText);
            return false;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public void pressKey(Keys keyToPress) {
        try {
            Actions action = new Actions(Driver);
            action.sendKeys(keyToPress);
            action.perform();
        } catch (Exception e) {
            this.DriverExceptionDetail = e.getMessage();
            System.err.println("[Error] Failed to send keypress to element - " + keyToPress);

        }
    }

    public void pressALT_F4(Keys keyToPress, Keys keyToPress2) {
        try {
            Actions action = new Actions(Driver);
            action.sendKeys(keyToPress);
            action.sendKeys(keyToPress2);
            action.perform();
        } catch (Exception e) {
            this.DriverExceptionDetail = e.getMessage();
            System.err.println("[Error] Failed to send keypress to element - " + keyToPress);

        }
    }

    public boolean uploadFileUsingElementXpathAndFileLocation(String browseButtonXpath, String fileLocation) {
        try {
            WebElement fileUpload = Driver.findElement(By.xpath(browseButtonXpath));
            fileUpload.sendKeys(fileLocation);
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public void copyKeys() {
        try {
            Actions action = new Actions(Driver);
            action.sendKeys(Keys.CONTROL, "c");
            action.perform();
        } catch (Exception e) {
            this.DriverExceptionDetail = e.getMessage();
            System.err.println("[Error] Failed to send keypress to element - Contoll + C");

        }
    }

    public void pressKey(Keys keyToPress, int NumberOfPresses) {
        try {
            for (int i = 0; i <= NumberOfPresses; i++) {
                Actions action = new Actions(Driver);
                action.sendKeys(keyToPress);

                action.perform();
            }
        } catch (Exception e) {
            this.DriverExceptionDetail = e.getMessage();
            System.err.println("[Error] Failed to send keypress to element - " + keyToPress);

        }
    }

    public Boolean ClickElementOnDropdownListByXpathAndText(String FormXpath, String paragraphXpath, String dropdown, String valueToSelect) {
        String firstCellText = "";
        try {
            SeleniumDriverInstance.waitForElementByXpath(FormXpath);

            WebElement formxpath = Driver.findElement(By.xpath(FormXpath));
            System.out.println("Found div");
            WebElement Paragraph = formxpath.findElement(By.xpath(paragraphXpath));
            System.out.println("Found table");
            WebElement dropdownItem = formxpath.findElement(By.xpath(dropdown));
            dropdownItem.click();
            return true;
        } catch (Exception ex) {
            System.out.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public Boolean SelectElementOnDropdownListByXpathAndText(String FormXpath, String paragraphXpath, String dropdown, String Div, String ULtagName, String liTagName, String valueToSelect) {
        String firstCellText = "";
        try {
            SeleniumDriverInstance.waitForElementByXpath(FormXpath);

            WebElement formxpath = Driver.findElement(By.xpath(FormXpath));
            System.out.println("Found div");
            WebElement Paragraph = formxpath.findElement(By.xpath(paragraphXpath));
            System.out.println("Found Paragraph");
            WebElement dropdownItem = formxpath.findElement(By.xpath(dropdown));
            dropdownItem.click();

            //selecting on the dropdown list
            WebElement DropdownDiv = Driver.findElement(By.xpath(Div));
            System.out.println("Found div");
            WebElement ListItemsUL = DropdownDiv.findElement(By.tagName(ULtagName));
            List<WebElement> ListItemsLI = ListItemsUL.findElements(By.tagName(liTagName));
            System.out.println("Listing List Items");
            SeleniumDriverInstance.pause(500);
            for (WebElement ListItem : ListItemsLI) {
                String ListItemText = ListItem.getText().toUpperCase();
                System.out.println("Found ListElement: " + ListItemText);

                if (ListItemText.equals(valueToSelect)) {
                    ListItem.click();
                    //System.out.println("Clicking Item :" + ListItem.getText());                                
                    return true;
                }

            }
        } catch (Exception ex) {
            System.out.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public Boolean SelectButtonOnByFormXpath(String FormXpath, String paragraphXpath, String buttonToClick) {
        String firstCellText = "";
        try {
            SeleniumDriverInstance.waitForElementByXpath(FormXpath);

            WebElement formxpath = Driver.findElement(By.xpath(FormXpath));
            System.out.println("Found div");
            WebElement ButtonToClick = formxpath.findElement(By.xpath(buttonToClick));
            ButtonToClick.click();

        } catch (Exception ex) {
            System.out.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean selectFromDropDownListUsingXpath(String elementXpath, String valueToSelect) {
        try {
            waitForElementByXpath(elementXpath);
            Select dropDownList = new Select(Driver.findElement(By.xpath(elementXpath)));
            WebElement formxpath = Driver.findElement(By.xpath(elementXpath));
            formxpath.click();
            dropDownList.selectByVisibleText(valueToSelect);
            return true;
        } catch (Exception e) {
            System.err.println("Error selecting from dropdownlist by text using Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean selectByValueFromDropDownListUsingXpath(String elementXpath, String valueToSelect) {
        try {
            waitForElementByXpath(elementXpath);
            Select dropDownList = new Select(Driver.findElement(By.xpath(elementXpath)));
            WebElement formxpath = Driver.findElement(By.xpath(elementXpath));
            formxpath.click();
            dropDownList.selectByValue(valueToSelect);
            return true;
        } catch (Exception e) {
            System.err.println("Error selecting from dropdownlist by text using Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean clickElementUsingParentChild(String parentElementtagName, String childElementTagName, String childElementtext) {
        try {
            //this.waitForElementBytagName(parentElementtagName);
            List<WebElement> parents = Driver.findElements(By.tagName(parentElementtagName));
            try {

                for (WebElement parent : parents) {
                    List<WebElement> children = parent.findElements(By.tagName(childElementTagName));
                    for (WebElement child : children) {
                        String mathcingText = child.getText();
                        if (mathcingText.equalsIgnoreCase(childElementtext)) {
                            child.click();
                            return true;
                        }
                    }
                }
            } catch (Exception ex) {
                System.err.println("[ERROR] failed to find element by tagname: " + childElementTagName + " - " + ex.getMessage());
                return false;
            }
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find parent element by tagName: " + parentElementtagName + " - " + ex.getMessage());
            return false;
        }
        return false;
    }

    public boolean ClickelementThroughTagnameandText(String parentElementXpath, String ChildTagname, String InnerChildTagName, String Text) {
        try {
            List<WebElement> parents = Driver.findElements(By.xpath(parentElementXpath));
            try {

                for (WebElement parent : parents) {
                    List<WebElement> links = parent.findElements(By.tagName(ChildTagname));

                    for (WebElement link : links) {

                        List<WebElement> spans = link.findElements(By.tagName(InnerChildTagName));

                        for (WebElement span : spans) {

                            String spantext = span.getText();

                            if (spantext.contains(Text)) {
                                span.click();
                                return true;
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                System.err.println("[ERROR] failed to find element by tagname: " + ChildTagname + " - " + ex.getMessage());
                return false;
            }
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find parent element by tagName: " + parentElementXpath + " - " + ex.getMessage());
            return false;
        }
        return false;
    }

    public boolean SelectFromTabelLinks(String elementXpath, String textToSearch) {
        try {
            System.out.println(elementXpath);
            List<WebElement> spans = Driver.findElements(By.xpath(elementXpath));
            if (spans == null) {
                System.out.println("Span is null");
                return false;
            } else {
                System.out.println("Number of elements found " + spans.size());
            }

            for (WebElement span : spans) {
                String Linktext = span.getText();
                if (Linktext.equalsIgnoreCase(textToSearch)) {
                    span.click();
                    System.out.println("Found match for Link amongst the list, Selecting - " + textToSearch);
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            System.err.println("Error searching for element - " + textToSearch + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public boolean ClickByParentAndChildTagNameAndClassNamesFromInnerDIV(String ParentXpath, String ChildTagName, String InnerChildTagName, String InnerChildClassName) {
        try {

            this.pause(2000);
            List<WebElement> parents = Driver.findElements(By.xpath(ParentXpath));
            if (parents == null) {
                System.err.println("Parent list is null");
                return false;
            } else {
                System.out.println("Number of parent elements found " + parents.size());
            }
            for (WebElement parent : parents) {
                try {
                    List<WebElement> lis = parent.findElements(By.tagName(ChildTagName));
                    System.out.println("Found child element, text : " + lis.size());

                    for (WebElement li : lis) {
                        List<WebElement> icons = li.findElements(By.tagName(InnerChildTagName));
                        for (WebElement i : icons) {
                            if (i.getAttribute("class").equals(InnerChildClassName)) {
                                i.click();
                                return true;
                            }
                        }
                    }

                } catch (Exception ex) {
                    System.err.println("Error searching for element - " + ex.getMessage());
                    this.DriverExceptionDetail = ex.getMessage();
                    return false;
                }
            }
            return false;
        } catch (Exception ex) {
            System.err.println("Error searching for element - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public boolean ClickElementByParentClassNameandChildTagName(String ParentClassName, String ChildTagName, String InnerChildTagName, String Text) {
        try {

            this.pause(2000);
            List<WebElement> parents = Driver.findElements(By.className(ParentClassName));
            if (parents == null) {
                System.err.println("Parent list is null");
                return false;
            } else {
                System.out.println("Number of parent elements found " + parents.size());
            }
            for (WebElement parent : parents) {
                try {
                    List<WebElement> Divs = parent.findElements(By.tagName(ChildTagName));
                    System.out.println("Found child element, text : " + Divs.size());

                    for (WebElement Div : Divs) {
                        List<WebElement> Spans = Div.findElements(By.tagName(InnerChildTagName));
                        for (WebElement span : Spans) {
                            String Assets = span.getText();

                            if (Assets.equalsIgnoreCase(Text)) {
                                span.click();
                                return true;
                            }
                        }
                    }

                } catch (Exception ex) {
                    System.err.println("Error searching for element - " + ex.getMessage());
                    this.DriverExceptionDetail = ex.getMessage();
                    return false;
                }
            }
            return false;
        } catch (Exception ex) {
            System.err.println("Error searching for element - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public boolean ClickByParentAndChildTagNameAndInnerTagnameFromInnerDIV(String ParentXpath, String ChildTagName, String SiblingTagname, String InnerChildTagName, String Text) {
        try {

            this.pause(2000);
            List<WebElement> parents = Driver.findElements(By.xpath(ParentXpath));
            if (parents == null) {
                System.err.println("Parent list is null");
                return false;
            } else {
                System.out.println("Number of parent elements found " + parents.size());
            }
            for (WebElement parent : parents) {
                try {
                    List<WebElement> uls = parent.findElements(By.tagName(ChildTagName));
                    System.out.println("Found child element, text : " + uls.size());

                    for (WebElement ul : uls) {
                        List<WebElement> lis = ul.findElements(By.tagName(SiblingTagname));
                        System.out.println("Found child element, text : " + lis.size());

                        for (WebElement li : lis) {
                            List<WebElement> spans = li.findElements(By.tagName(InnerChildTagName));
                            System.out.println("Found child element, text : " + spans.size());

                            for (WebElement span : spans) {
                                String Texttosearch = span.getText();
                                if (Texttosearch.equals(Text)) {
                                    span.click();
                                    return true;
                                }
                            }
                        }
                    }

                } catch (Exception ex) {
                    System.err.println("Error searching for element - " + ex.getMessage());
                    this.DriverExceptionDetail = ex.getMessage();
                    return false;
                }
            }
            return false;
        } catch (Exception ex) {
            System.err.println("Error searching for element - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public String checkElementTypeById(String elementId) {
        WebElement element = Driver.findElement(By.id(elementId));
        try {
            WebElement child = null;
            child = element.findElement(By.tagName("option"));
            if (child == null) {
                return "textbox";
            } else {
                return "dropDownList";
            }

        } catch (Exception ex) {
            System.err.println("Error selecting from dropdownlist by text using Id - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return ex.getMessage();
        }
    }

    public boolean ClickEmbeddedRowUsingCellTextAndButtonText(String Div, String tableXpath, String Tbody, String tableRow, String TableD, String ValueToSelect) {
        String ButtonText = "";
        String firstCellText = "";
        try {
            SeleniumDriverInstance.waitForElementByXpath(Div);
            //div
            WebElement div = Driver.findElement(By.xpath(Div));
            System.out.println("Found div");
            //table
            WebElement table = div.findElement(By.xpath(tableXpath));
            System.out.println("Found table");

            WebElement tBody = div.findElement(By.tagName(Tbody));
            System.out.println("Found table body");

            List<WebElement> rows = tBody.findElements(By.tagName(tableRow));
            int rowCount = 1;
            for (WebElement row : rows) {

////                System.out.println("Row - " + rowCount);
                List<WebElement> cells = row.findElements(By.tagName(TableD));
                for (WebElement insidecells : cells) {

                    String cellvalue = insidecells.getText().toUpperCase();
                    String selectValue = ValueToSelect.substring(0, 4);
                    if (cellvalue.contains(ValueToSelect.toUpperCase())) {
                        System.out.println("selecting:<===>  " + ValueToSelect);
                        insidecells.click();
                        return true;
                    }
                }

            }

            rowCount++;
            return true;

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean enterTextonEmbeddedTextBoxByXpath(String elementXpath, String textToEnter) {
        try {
            //div 1
            WebElement Div1 = Driver.findElement(By.xpath("//*[@id=\"contacts\"]/div[1]"));

            //div 2
            WebElement div2 = Div1.findElement(By.xpath("//*[@id=\"contacts\"]/div[1]/div"));

            //div 3
            WebElement elementToTypeIn = div2.findElement(By.xpath(elementXpath));
            this.waitForElementByXpath(elementXpath);

//            WebElement elementToTypeIn = div3.findElement(By.xpath(elementXpath));
//            List <WebElement> cells = div3.findElements(By.xpath("//*[@id=\"contacts\"]/div[1]/div/div"));
//            for(WebElement insidecells : cells)
//            {
//                System.out.println("Clicking button"+ insidecells);
//            }
            if (!elementToTypeIn.getText().isEmpty()) {
                elementToTypeIn.clear();
            }
            Actions typeText = new Actions(Driver);
            typeText.moveToElement(elementToTypeIn);
            typeText.click(elementToTypeIn);
            typeText.sendKeys(elementToTypeIn, textToEnter);
            typeText.click(elementToTypeIn);
            typeText.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error entering text - " + elementXpath + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean enterText(String textToEnter) {
        try {
//            JavascriptExecutor js = (JavascriptExecutor)Driver;
//            
//            this.waitForElementByXpath(elementXpath);
//            WebElement elementToTypeIn = Driver.findElement(By.xpath(elementXpath));
//            
//           
//            elementToTypeIn.clear();

//            typeText.moveToElement(elementToTypeIn);
//            js.executeScript("arguments[0].style.visibility='visible';", elementXpath);
//            typeText.click(elementToTypeIn);
            Actions typeText = new Actions(Driver);
            typeText.sendKeys(textToEnter);
            typeText.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error entering text - " + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public Boolean selectdropdownContainerUsingXpath(String Div1Xpath, String Div2Xpath, String TableXpath, String Div3Xpath, String Div4Xpath, String ListBoxId, String Tag, String ValueToselect, String DropdownID) {
        try {
//            SeleniumDriverInstance.waitForElementById(containerId);                      

            WebElement div1 = Driver.findElement(By.xpath(Div1Xpath));
            System.out.println("Found div");
            WebElement div2 = div1.findElement(By.xpath(Div2Xpath));

            System.out.println("Found table");
            WebElement Div3 = div2.findElement(By.xpath(TableXpath));
            Div3.click();
            SeleniumDriverInstance.pause(2000);
            WebElement SelectDiv1 = div2.findElement(By.xpath(Div3Xpath));
            WebElement SelectDiv2 = SelectDiv1.findElement(By.xpath(Div4Xpath));

//        
            WebElement cells = SelectDiv2.findElement(By.id(ListBoxId));
            List<WebElement> value = cells.findElements(By.tagName(Tag));

            for (WebElement row : value) {
                String selectvalue = row.getText();
                if (selectvalue.toUpperCase().equals(ValueToselect.toUpperCase())) {
                    row.click();
                }

            }

            Select dropDownList = new Select(Div3.findElement(By.id(DropdownID)));
            dropDownList.selectByVisibleText(ValueToselect);

            return true;
        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element : " + ex.getMessage());
            return false;
        }
    }

    public boolean ClickEmbeddedRowUsingCellTextAndButtonText(String Div, String table, String tbody, String tr, String Cell, String SelectionDiv, String Ultag, String LItag, String Organization) {

        try {

            SeleniumDriverInstance.waitForElementByXpath(Div);
            WebElement tableelement = Driver.findElement(By.xpath(Div));
            System.out.println("Found table");

            WebElement mytable = tableelement.findElement(By.tagName(table));
            System.out.println("Found table body");

            WebElement tableBody = mytable.findElement(By.tagName(tbody));
            WebElement tableRow = tableBody.findElement(By.tagName(tr));
            WebElement tableCell = tableRow.findElement(By.xpath(Cell));
            tableCell.click();
            SeleniumDriverInstance.pause(2000);

            WebElement ListDiv2 = Driver.findElement(By.xpath(SelectionDiv));
            WebElement tableBodyULTagName = ListDiv2.findElement(By.tagName(Ultag));
            List<WebElement> rows = tableBodyULTagName.findElements(By.tagName(LItag));
            for (WebElement row : rows) {

                String selectvalue = row.getText();
                if (selectvalue.toUpperCase().equals(Organization.toUpperCase())) {
                    row.click();
                    break;
                }

            }

            return true;

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean DoubleClickEmbeddedElement(String Div, String table, String tbody, String tr, String Cell) {

        try {

            SeleniumDriverInstance.waitForElementByXpath(Div);
            WebElement tableelement = Driver.findElement(By.xpath(Div));
            System.out.println("Found table");

            WebElement mytable = tableelement.findElement(By.tagName(table));
            System.out.println("Found table body");

            WebElement tableBody = mytable.findElement(By.tagName(tbody));
            WebElement tableRow = tableBody.findElement(By.tagName(tr));
            WebElement tableCell = tableRow.findElement(By.xpath(Cell));
            tableCell.click();
            tableCell.click();
            //SeleniumDriverInstance.pause(2000);

            return true;

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean ClickElementAndSelectFromADropdownList(String ElementToSelectXpath, String SelectionDiv, String Ultag, String LItag, String ValueToSelect) {

        try {

            SeleniumDriverInstance.waitForElementByXpath(ElementToSelectXpath);
            WebElement tableelement = Driver.findElement(By.xpath(ElementToSelectXpath));
            tableelement.click();

            WebElement ListDiv2 = tableelement.findElement(By.xpath(SelectionDiv));
            WebElement tableBodyULTagName = ListDiv2.findElement(By.tagName(Ultag));
            List<WebElement> rows = tableBodyULTagName.findElements(By.tagName(LItag));
            for (WebElement row : rows) {

                String selectvalue = row.getText();
                if (selectvalue.toUpperCase().equals(ValueToSelect)) {
                    row.click();
                    break;
                }

            }

            return true;

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean ClickEmbeddedRowUsingCellButtonXpath(String parent, String child1, String child2, String Child3, String cellXpath) {
        try {
            WebElement Div = Driver.findElement(By.xpath(parent));
            WebElement tableName = Div.findElement(By.tagName(child1));
            WebElement LowerGradetableBody = tableName.findElement(By.tagName(child2));
            WebElement tablerow = LowerGradetableBody.findElement(By.tagName(Child3));

            WebElement tableElement = tablerow.findElement(By.xpath(cellXpath));
            tableElement.click();

            return true;

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to click cell by xpath: " + ex.getMessage());
            return false;
        }
    }

    public boolean enterTextByCss(String elementId, String textToEnter) {

        try {
            System.out.println("Attempting to enable element - " + elementId);
            JavascriptExecutor js = (JavascriptExecutor) SeleniumDriverInstance.Driver;
            js.executeScript("document.getElementById('" + elementId + "').removeAttribute('disabled')");
            System.out.println("Element enabled successfully - " + elementId);
            WebElement select = Driver.findElement(By.id(elementId));
            select.sendKeys(textToEnter);

            return true;
        } catch (Exception e) {
            System.err.println("Failed to enable specifed element - " + e.getMessage());
            return false;
        }

    }

    public boolean uploadFileUsingElementIdAndFileLocations(String browseButtonId, String fileLocation) {

        try {

            WebElement select = Driver.findElement(By.name(browseButtonId));
            pause(200);

            select.sendKeys(fileLocation);
            pause(200);

        } catch (Exception ex) {

            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
        return true;
    }

    public boolean nestedHoverOverEmbededElementAndClickByXpath(String ParentElementXpath, String SubElementXpath, String ChildElementXpath) {
        try {

            WebElement ListDiv2 = Driver.findElement(By.xpath(ParentElementXpath));
            WebElement tableBodyULTagName = ListDiv2.findElement(By.tagName(SubElementXpath));

            return true;

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }

    }

    public boolean selectUsingCellTextAndButtonText(String DivXpath, String ParenttagName, String ChildTagName, String ValueToSelect) {
        String ButtonText = "";
        String firstCellText = "";

        try {
            WebElement ListDiv2 = Driver.findElement(By.xpath(DivXpath));
            WebElement tableBodyULTagName = ListDiv2.findElement(By.tagName(ParenttagName));
            List<WebElement> rows = tableBodyULTagName.findElements(By.tagName(ChildTagName));
            for (WebElement row : rows) {

                String selectvalue = row.getText();
                if (selectvalue.toUpperCase().contains(ValueToSelect.toUpperCase())) {
                    row.click();
                    break;
                }

            }

            return true;

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean selectTextUsingASubtringedValue(String DivXpath, String ParenttagName, String ChildTagName, String selectValue) {
        String ButtonText = "";
        String firstCellText = "";

        try {
            WebElement ListDiv2 = Driver.findElement(By.xpath(DivXpath));
            WebElement tableBodyULTagName = ListDiv2.findElement(By.tagName(ParenttagName));
            List<WebElement> rows = tableBodyULTagName.findElements(By.tagName(ChildTagName));
            for (WebElement row : rows) {

                String cellvalue = row.getText().toUpperCase();
                String selectionValue = selectValue.substring(0, 5);
                if (cellvalue.toUpperCase().contains(selectValue.toUpperCase())) {
                    System.out.println("selecting:<===>  " + selectValue);
                    row.click();
                    break;

                }

            }

            return true;

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    //Container Class Name = jspPane
    public List<String> getElementsValueUsingParentChildTagName(String containerClassName) {
        List<String> values = new ArrayList<>();
        try {
            WebElement container = Driver.findElement(By.xpath(containerClassName));
            List<WebElement> divs = container.findElements(By.tagName("div"));
            for (WebElement div : divs) {
                try {
                    values.add(div.getAttribute("dest"));
                } catch (Exception ex) {

                }
            }

        } catch (Exception ex) {
            System.err.println("Could not find elements" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return values;
        }
        return values;
    }

    public int getElementsCountByXpath(String itemXpath) {
        int count = 0;
        try {
            List<WebElement> list = Driver.findElements(By.xpath(itemXpath));

            count = list.size();

            int a = 0;
            a = a + 1;

        } catch (Exception ex) {
            System.err.println("Could not find elements" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return count;
        }
        return count;
    }

    public int getMixtTelematicRowsCountByXpath(String elementXpath) {
        int count = 0;
        try {
            WebElement table = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> tableRows = table.findElements(By.tagName("tr"));

            count = tableRows.size();

            int a = 0;
            a = a + 1;

        } catch (Exception ex) {
            System.err.println("Could not find elements" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return count;
        }
        return count;
    }

    public int getMixtTelematicDaysInMonthCountByXpath(String elementXpath) {
        int count = 0;
        try {
            WebElement table = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> tableRows = table.findElements(By.xpath(elementXpath));

            count = tableRows.size();

            int a = 0;
            a = a + 1;

        } catch (Exception ex) {
            System.err.println("Could not find elements" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return count;
        }
        return count;
    }

    public boolean selectUsingCellTextAndButtonText(String DivXpath, String ParenttagName, String ChildTagName, String TagName, String ValueToSelect) {
        String ButtonText = "";
        String firstCellText = "";

        try {
            WebElement ListDiv2 = Driver.findElement(By.xpath(DivXpath));
            WebElement tableBodynavTagName = ListDiv2.findElement(By.tagName(ParenttagName));
            WebElement tableBodyULTagName = tableBodynavTagName.findElement(By.tagName(ChildTagName));
            List<WebElement> rows = tableBodyULTagName.findElements(By.tagName(TagName));
            for (WebElement row : rows) {

                String selectvalue = row.getText();
                if (selectvalue.toUpperCase().equals(ValueToSelect.toUpperCase())) {
                    row.click();
                    break;
                }

            }

            return true;

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean selectUsingCellTextAndButtonbyxpath(String DivXpath, String ParenttagName, String ChildTagName, String TagName, String InnerTagName, String ButtonClass, String buttonClass, String ValueToSelect, String Button) {
        String ButtonText = "";
        String firstCellText = "";

        try {
            WebElement ListDiv2 = Driver.findElement(By.xpath(DivXpath));
            WebElement tableTagName = ListDiv2.findElement(By.tagName(ParenttagName));
            WebElement tableBodyTagName = tableTagName.findElement(By.tagName(ChildTagName));
            WebElement tableRowTagName = tableBodyTagName.findElement(By.tagName(TagName));
//            WebElement tabledataTagName = tableRowTagName.findElement(By.xpath(InnerTagName));//("//*[@id=\"job-grid\"]/div[4]/table/tbody/tr[1]/td[12]"));
            List<WebElement> rows = tableRowTagName.findElements(By.tagName(ButtonClass));

            for (WebElement row : rows) {

                String tabledata = row.getAttribute(buttonClass);
                if (tabledata.toUpperCase().equals(ValueToSelect.toUpperCase())) {
                    Actions moveTo = new Actions(Driver);
                    moveTo.moveToElement(Driver.findElement(By.xpath(Button)));
                    pause(2000);
                    moveTo.click();
                    moveTo.perform();
//                     WebElement Button = row.findElement(By.xpath(ValueToSelect));
//                     
//                     Button.click();
                    break;
                }

            }

            return true;

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public boolean selectUsingTextAndButtonbyxpath(String DivXpath, String ParenttagName, String ChildTagName, String TagName, String InnerTagName, String ButtonClass, String ValidationText, String ValueToSelect, String Button) {
        String ButtonText = "";
        String firstCellText = "";

        try {
            WebElement ListDiv2 = Driver.findElement(By.xpath(DivXpath));
            WebElement tableTagName = ListDiv2.findElement(By.tagName(ParenttagName));
            WebElement tableBodyTagName = tableTagName.findElement(By.tagName(ChildTagName));
//            WebElement tableRowTagName = tableBodyTagName.findElement(By.tagName(TagName));
            List<WebElement> rows = tableBodyTagName.findElements(By.tagName(TagName));

            for (WebElement row : rows) {
                boolean found = false;
                List<WebElement> InnerRows = row.findElements(By.tagName(ButtonClass));
                for (WebElement Myrow : InnerRows) {
                    String tabledata = Myrow.getText();

                    if (tabledata.toUpperCase().contains("RemTestGradeSystem".toUpperCase())) {
                        found = true;
                        Actions moveTo = new Actions(Driver);
                        moveTo.moveToElement(row.findElement(By.linkText("Delete")));
                        moveTo.click();
                        moveTo.perform();
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }

            return true;

        } catch (Exception ex) {
            System.err.println("[ERROR] failed to find element: " + ex.getMessage());
            return false;
        }
    }

    public String setDateFormat(String inputFormat, String inputDate, String outputFormat) {
        try {
            //Converts string to date
            String expectedPattern = inputFormat;
            SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
            String userInput = inputDate;
            Date date = formatter.parse(userInput);

            //Sets the date format
            SimpleDateFormat dateFormat = new SimpleDateFormat(outputFormat);

            return dateFormat.format(date).toString();
        } catch (Exception ex) {
            System.err.println("[ERROR] Failed to convert date '" + inputDate + "': " + ex.getMessage());
            return inputDate;
//            return false;
        }
    }

    public boolean enterApportionmentByName(String beneficiaryName, String apportionment, Integer totalBeneficiaries) {
        int loopCount = 1;
        int tableRow = 16;
        String retrievedText;

        try {
            while (loopCount <= totalBeneficiaries - 1) {
                tableRow++;
                retrievedText = retrieveTextByXpath("//*[@id=\"frmCbmre\"]/tbody/tr[" + tableRow + "]/td[2]");

                if (retrievedText.contains(beneficiaryName)) {
                    enterTextByName("frmAportion7" + loopCount + "0", apportionment);
                    return true;
                }

                if (loopCount == totalBeneficiaries) {
                    System.err.println("[Error] Failed to enter Apportionment : '" + apportionment + "' for Beneficiary : '" + beneficiaryName + "' - Beneficiary not found.");
                    return false;
                }
                loopCount++;
            }
            return true;
        } catch (Exception ex) {
            System.err.println("[Error] Failed to enter Apportionment : '" + apportionment + "' for Beneficiary : '" + beneficiaryName + "' - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
    }

    public String findTableRowXpathByXpath(String tableXpath, String searchText) {
        try {
            int rowCount = Driver.findElements(By.xpath(tableXpath + "tr")).size();

            for (int i = 2; i < rowCount; i++) {
                String currentRowXpath = tableXpath + "tr[" + i + "]/";
                String currentRowText = retrieveTextByXpath(currentRowXpath + "td[1]/a/span");

                if (currentRowText.contains(searchText)) {
                    System.out.println("[Info] Successfully found the search text : '" + searchText + "' at Xpath : '" + currentRowXpath + "'");
                    return currentRowXpath;
                }
            }

            System.err.println("[Error] Failed to find the search text : '" + searchText + "'");
            return "";
        } catch (Exception ex) {
            System.err.println("[Error] Failed to find the search text : '" + searchText + "' - " + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return "";
        }
    }

    public String SplitAndReturnStringPart(String splitText, String splitBy, int returnPartPosition) {
        try {
            String[] splitParts = splitText.split(splitBy);
            return splitParts[returnPartPosition].trim();
        } catch (Exception e) {
            System.err.println("[Error] Failed to split the text : '" + splitText + "' by '" + splitBy + "' - " + e.getMessage());
            return "";
        }
    }

    public Map<String, String> retrieveValues(String superParent, String parentElementCss, String childElementCss, String innerChildLabelCss, String innerChildValueCss, int position) {
        Map<String, String> values = new HashMap<>();
        try {
            int count = 1;
            WebElement span = Driver.findElement(By.id(superParent));
            WebElement parentElement = span.findElement(By.id(parentElementCss));
            List<WebElement> children = parentElement.findElements(By.className(childElementCss));
            if (children.isEmpty()) {
                System.out.println("No sub-elements found - null value was returned");
            } else {
                System.out.println("Number of elements found: " + children.size());
                for (WebElement child : children) {
                    if (checkIfElementHasChildren(child)) {
                        try {
                            List<WebElement> innerChildrenLabels = child.findElements(By.className(innerChildLabelCss));
                            List<WebElement> innerChildrenValues = child.findElements(By.className(innerChildValueCss));
                            values.put(innerChildrenLabels.get(position).getText(), innerChildrenValues.get(position).getText());
                            values.put(innerChildrenLabels.get(position + 1).getText(), innerChildrenValues.get(position + 1).getText());

                        } catch (Exception ex) {

                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println("[Error] Failed to find element by Id: " + parentElementCss + "' - " + ex.getMessage());
            return null;
        }
        return values;
    }

    public boolean checkIfElementHasChildren(WebElement element) {
        List<WebElement> subElements = element.findElements(By.xpath(".//*"));
        return (subElements.size() > 1);
    }

    public boolean checkIfGroupIsExpanded(String elementName) {
        try {
            WebElement element = Driver.findElement(By.name(elementName));
            return element.getAttribute("src").contains("/th/test/img/mnu/tv/minus.gif");

        } catch (Exception ex) {
            System.err.println("[Error] Failed to find element by name: " + elementName + "' - " + ex.getMessage());
            return false;
        }

    }

    public String findParentComponentPlan(String componentName) {
        String plan = "";
        for (TestEntity testEntity : testDataList) {
            if (testEntity.TestCaseId.contains("AddComponent")) {
                if (testEntity.TestParameters.containsKey("Component Name")) {
                    String value = testEntity.getData("Component Name");
                    if (value.contains(componentName)) {
                        plan = testEntity.getData("Plan");
                        return plan;
                    }

                }
            }
        }
        return plan;
    }

    public String checkIfTableIsPresent(String tableXpath, String tableHeaderClassName, String tableHeader) {
        String returnString = "Table Not Found";
        try {
            WebElement table = Driver.findElement(By.id(tableXpath));
            if (table == null) {
                System.out.println("Table not found with xpath: " + tableXpath);
            } else {
                try {
                    List<WebElement> subElements = table.findElements(By.className(tableHeaderClassName));
                    if (subElements == null) {
                        System.out.println("Table Data not found with class name of: " + tableHeaderClassName);
                    } else {
                        for (WebElement subElement : subElements) {
                            if (subElement.getText().equals(tableHeader)) {
                                returnString = "Table Found";
                            }
                        }
                    }
                } catch (Exception ex) {
                    System.err.println("[Error] Failed to find element with the header of: " + tableHeader + " by xpath: " + tableXpath + "' - " + ex.getMessage());
                    return returnString;
                }
            }
        } catch (Exception e) {
            System.err.println("[Error] Failed to find element by xpath: " + tableXpath + "' - " + e.getMessage());
            return returnString;
        }
        return returnString;
    }

    public boolean checkAccounts(String tableId, String rowClassName) {
        try {
            WebElement table = Driver.findElement(By.id(tableId));
            try {
                List<WebElement> accounts = table.findElements(By.className(rowClassName));
                return !accounts.isEmpty();
            } catch (Exception ex) {
                System.err.println("[Error] Failed to find elements by class name: " + rowClassName + "' - " + ex.getMessage());
                return false;
            }
        } catch (Exception ex) {
            System.err.println("[Error] Failed to find element by id: " + tableId + "' - " + ex.getMessage());
            return false;
        }
    }

    public boolean clickElementUsingJavascript() {
        JavascriptExecutor js = (JavascriptExecutor) Driver;
        js.executeScript("onclick=processOnClick('btncbmin3', 'undefined');");
        return true;
    }

    public boolean getCheckboxState(String elementName) {
        boolean defaultReturn = false;
        try {
            WebElement checkbox = Driver.findElement(By.name(elementName));
            defaultReturn = checkbox.isSelected();
        } catch (Exception ex) {
            System.err.println("[Error] Failed to find element by name: " + elementName + "' - " + ex.getMessage());
            return defaultReturn;
        }
        return defaultReturn;
    }

    public boolean hoverOverElementUsingJavascriptAndClickElementByXpath(String elementXpath) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Driver;
            js.executeScript("onmouseover=menus['0'].exec('0',2)");
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            js = (JavascriptExecutor) Driver;
            js.executeScript("arguments[0].click();", elementToClick);
            System.out.println("[Info]Successfully found and clicked element '" + elementXpath + "' using javascript...proceeding");
            return true;
        } catch (Exception ex) {
            System.err.println("[Error] Failed to find element by xpath: [" + elementXpath + "] and clicking element using Javascript --> " + ex.getMessage());
            return false;
        }
    }

    public boolean clickOnColumnChooserList(String elementXpath, String columnToChooseXpath) {
        try {
            //System.out.println("[INFO] Clicking element by Xpath : " + elementXpath);
            waitForElementByXpath(elementXpath);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            waitForElementByXpath(columnToChooseXpath);
            WebElement colToClick = Driver.findElement(By.xpath(columnToChooseXpath));
            try {
                colToClick.findElement(By.tagName("i"));
            } catch (Exception ex) {
                colToClick.click();
                return true;
            }
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean checkAccounts(String tableId, String tagName, String rowClassName) {
        boolean defaultReturn = false;
        try {
            WebElement table = Driver.findElement(By.id(tableId));
            try {
                List<WebElement> accounts = table.findElements(By.tagName(tagName));
                if (accounts.isEmpty()) {
                    return false;
                } else {
                    for (WebElement account : accounts) {
                        if (account.getAttribute("class").contains(rowClassName)) {
                            List<WebElement> subElements = account.findElements(By.tagName("td"));
                            String elementText = subElements.get(5).getText();
                            if (elementText.equalsIgnoreCase("Savings Account")) {
                                defaultReturn = true;
                            }

                            if (elementText.equalsIgnoreCase("Current Account")) {
                                defaultReturn = true;
                            }

                            if (elementText.equalsIgnoreCase("Credit Card")) {
                                defaultReturn = true;
                            }

                            if (elementText.equalsIgnoreCase("Foreign Bank Account")) {
                                defaultReturn = true;
                            }
                        }

                    }
                }
            } catch (Exception ex) {
                System.err.println("[Error] Failed to find elements by class name: " + rowClassName + "' - " + ex.getMessage());
                return defaultReturn;
            }
        } catch (Exception ex) {
            System.err.println("[Error] Failed to find element by id: " + tableId + "' - " + ex.getMessage());
            return defaultReturn;
        }
        return defaultReturn;
    }

    public List<String> getAllOptionsFromDropDownListUsingName(String elementName) {
        List<String> values = new ArrayList<>();
        try {
            waitForElementByName(elementName);
            Select element = new Select(Driver.findElement(By.tagName(elementName)));
            List<WebElement> options = element.getOptions();
            for (WebElement option : options) {
                values.add(option.getText());
            }
            return values;
        } catch (Exception ex) {
            System.err.println("[Error] Failed to find element by name: [" + elementName + "] and retreiving text from all the options --> " + ex.getMessage());
            return values;
        }
    }

    public List<String> getAllOptionsFromDropDownListUsingXpath(String elementXpath) {
        List<String> values = new ArrayList<>();
        try {
            waitForElementByName(elementXpath);
            Select element = new Select(Driver.findElement(By.xpath(elementXpath)));
            List<WebElement> options = element.getOptions();
            for (WebElement option : options) {
                values.add(option.getText());
            }
            return values;
        } catch (Exception ex) {
            System.err.println("[Error] Failed to find element by name: [" + elementXpath + "] and retreiving text from all the options --> " + ex.getMessage());
            return values;
        }
    }

    public boolean selectOrEnterTextInElementUsinName(String elementName, String value) {
        try {
            WebElement element = Driver.findElement(By.name(elementName));
            if (element.getTagName().equalsIgnoreCase("input")) {
                this.enterTextByName(elementName, value);
                return true;
            } else if (element.getTagName().equalsIgnoreCase("select")) {
                this.selectByTextFromDropDownListUsingName(elementName, value);
                return true;
            }
        } catch (Exception ex) {
            System.err.println("Could not find elements" + ex.getMessage());
            this.DriverExceptionDetail = ex.getMessage();
            return false;
        }
        return false;
    }

    public boolean CheckPresenceOfTheScrollBar() {
        /*  String execScript = "return document.documentElement.scrollWidth>document.documentElement.clientWidth;";
         JavascriptExecutor scrollBarPresent = (JavascriptExecutor) Driver;
         Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
         */
        JavascriptExecutor javascript = (JavascriptExecutor) Driver;
        Boolean test = (Boolean) javascript.executeScript("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
        if (test == true) {
            System.err.println("Scrollbar is present.");
        } else if (test == false) {
            System.err.println("Scrollbar is not present.");
        }

        return test;
    }

    public boolean scrollToElement(String elementXpath) {
        try {
            WebElement element = Driver.findElement(By.xpath(elementXpath));
            ((JavascriptExecutor) Driver).executeScript("arguments[0].scrollIntoView(true);", element);

            return true;
        } catch (Exception e) {
            System.err.println("Error scrolling to element - " + elementXpath + " - " + e.getStackTrace());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

    }

    public String DriverUtility() {
        Capabilities cap = ((RemoteWebDriver) Driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        System.out.println(browserName);

        return browserName;
    }

    public boolean moveToElementByXpath(String elementXpath) {
        try {
            Actions moveTo = new Actions(Driver);
            moveTo.moveToElement(Driver.findElement(By.xpath(elementXpath)));
            moveTo.perform();
            return true;
        } catch (Exception e) {
            System.err.println("Error moving to element - " + elementXpath + " - " + e.getStackTrace().toString());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean EnterTextInAtextBox(String elementXpath, String textToEnter1, String textToEnter2) {
        try {
            waitForElementByXpath(elementXpath);
            List<WebElement> element = Driver.findElements(By.xpath(elementXpath));

            WebElement element1 = element.get(0).findElement(By.tagName("input"));
            WebElement element2 = element.get(1).findElement(By.tagName("input"));
            pause(2000);
            element1.clear();
            pause(2000);
            element2.clear();

            Actions typeText = new Actions(Driver);
            typeText.moveToElement(element1);
            typeText.click(element1);
            typeText.sendKeys(element1, textToEnter1);
            typeText.click(element1);
            pause(2000);
            typeText.moveToElement(element2);
            typeText.click(element2);
            typeText.sendKeys(element2, textToEnter2);
            typeText.click(element2);
            typeText.perform();

            return true;

        } catch (Exception e) {
            System.err.println("Error entering text into a text box - " + elementXpath + " - " + e.getStackTrace().toString());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

    }

    public List<String> getAssetsListOnGrid(String elementXpath, String _numberOfPages, String nextPageXpath) {
        List<String> gridData = new ArrayList<>();
        try {
            int pages = 1;
            int numberOfPages = 1;
            List<String> reportData = new ArrayList<>();
            waitForElementByXpath(_numberOfPages);
            //Get number of pages.
            String numOfPages = Driver.findElement(By.xpath(_numberOfPages)).getText();
            if (!numOfPages.equals("")) {
                numberOfPages = Integer.parseInt(numOfPages);
            }
            while (pages <= numberOfPages) {
                this.takeScreenShot("AssetListPage" + pages, false);
                reportData = new ArrayList<>();
                waitForElementByXpath(elementXpath, 13000);
                //waitForElementByXpathToStaleness(elementXpath);
                WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));
                List<WebElement> divColumns = mainDiv.findElements(By.className("column"));
                //iterate through div list
                for (WebElement _divColumns : divColumns) {
                    String innerColumnsHeader = _divColumns.findElement(By.tagName("span")).getText();
                    if (!innerColumnsHeader.equals("")) {
                        //Adding method to use
                        boolean empty = false;
                        if (reportData.size() <= 0) {
                            empty = true;
                        }
                        if (innerColumnsHeader.equals("Asset description")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.tagName("a"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else if (innerColumnsHeader.equals("Last trip")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                //Convert date to match the one on trip details
                                String timeZone = "";
                                String newDate = "";
                                if (!rows.get(i).getText().equals("")) {
                                    String dateSub = rows.get(i).getText().substring(0, 10);
                                    String timeSub = rows.get(i).getText().substring(11, 19);
                                    timeZone = rows.get(i).getText().substring(21, 24).trim();
                                    String[] dateSlipted = dateSub.split("-");
                                    newDate = dateSlipted[2] + "-" + this.getMonthAbr(Integer.parseInt(dateSlipted[1])) + "-" + dateSlipted[0];
                                }
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + newDate + "#" + timeZone;
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else {
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        }
                    }
                }
                //move to next page
                pages++;
                if (pages <= numberOfPages) {
                    this.clickElementbyXpath(nextPageXpath);
                    this.waitForElementByXpath(elementXpath);
                }

                gridData.addAll(reportData);
            }
            return gridData;
        } catch (Exception e) {
            System.err.println("Error reading assests from grid - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

            return gridData;
        }
    }

    public List<String> getDriversListOnGrid(String elementXpath, String _numberOfPages, String nextPageXpath) {
        List<String> gridData = new ArrayList<>();
        List<String> gridDataWithHeaders = new ArrayList<>();
        try {
            int pages = 1;
            int numberOfPages = 1;
            List<String> reportData = new ArrayList<>();
            String columHeaders = "";
            while (pages <= numberOfPages) {
                this.takeScreenShot("AssetListPage" + pages, false);
                reportData = new ArrayList<>();
                waitForElementByXpath(elementXpath, 13000);
                //waitForElementByXpathToStaleness(elementXpath);
                WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));
                List<WebElement> divColumns = mainDiv.findElements(By.className("column"));
                //iterate through div list
                for (WebElement _divColumns : divColumns) {
                    String innerColumnsHeader = _divColumns.findElement(By.tagName("span")).getText();

                    if (!innerColumnsHeader.equals("")) {
                        //Adding method to use
                        //Get column headers
                        if (!columHeaders.contains(innerColumnsHeader)) {
                            columHeaders += innerColumnsHeader + "#";
                        }
                        boolean empty = false;
                        if (reportData.size() <= 0) {
                            empty = true;
                        }
                        if (innerColumnsHeader.equals("Asset description")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.tagName("a"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else if (innerColumnsHeader.equals("Last trip")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                //Convert date to match the one on trip details
                                String timeZone = "";
                                String newDate = "";
                                if (!rows.get(i).getText().equals("")) {
                                    String dateSub = rows.get(i).getText().substring(0, 10);
                                    String timeSub = rows.get(i).getText().substring(11, 19);
                                    timeZone = rows.get(i).getText().substring(21, 24).trim();
                                    String[] dateSlipted = dateSub.split("-");
                                    newDate = dateSlipted[2] + "-" + this.getMonthAbr(Integer.parseInt(dateSlipted[1])) + "-" + dateSlipted[0];
                                }
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + newDate + "#" + timeZone;
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else {
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        }
                    }
                }
                //move to next page
                pages++;
                if (pages <= numberOfPages) {
                    this.clickElementbyXpath(nextPageXpath);
                    this.waitForElementByXpath(elementXpath);
                }

                gridData.addAll(reportData);
            }
            gridDataWithHeaders.add(columHeaders);
            gridDataWithHeaders.addAll(gridData);
            return gridDataWithHeaders;
        } catch (Exception e) {
            System.err.println("Error reading assests from grid - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

            return gridData;
        }
    }

    public List<String> getAssetsListWithHeardersOnGrid(String elementXpath, String _numberOfPages, String nextPageXpath) {
        List<String> gridData = new ArrayList<>();
        List<String> gridDataWithHeaders = new ArrayList<>();
        try {
            int pages = 1;
            int numberOfPages = 1;
            List<String> reportData = new ArrayList<>();
            if (browserType.equals(Enums.BrowserType.IE)) {
                numberOfPages = Integer.parseInt(_numberOfPages);
            } else {
                waitForElementByXpath(_numberOfPages);
                //Get number of pages.
                String numOfPages = Driver.findElement(By.xpath(_numberOfPages)).getText();
                if (!numOfPages.equals("")) {
                    numberOfPages = Integer.parseInt(numOfPages);
                }
            }
//            waitForElementByXpath(_numberOfPages);
//            //Get number of pages.
//            String numOfPages = Driver.findElement(By.xpath(_numberOfPages)).getText();
//            if(!numOfPages.equals("")){
//                numberOfPages = Integer.parseInt(numOfPages);
//            }
            String columHeaders = "";
            while (pages <= numberOfPages) {
                this.takeScreenShot("AssetListPage" + pages, false);
                reportData = new ArrayList<>();
                waitForElementByXpath(elementXpath, 13000);
                waitForPresenceOfElementByXpath("//div[@class='loading-overlay'][@style='display: none;']", 10);
                WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));
                List<WebElement> divColumns = mainDiv.findElements(By.className("column"));
                //iterate through div list
                for (WebElement _divColumns : divColumns) {
                    String innerColumnsHeader = _divColumns.findElement(By.tagName("span")).getText();

                    if (!innerColumnsHeader.equals("")) {
                        //Adding method to use
                        //Get column headers
                        if (!columHeaders.contains(innerColumnsHeader)) {
                            columHeaders += innerColumnsHeader + "#";
                        }
                        boolean empty = false;
                        if (reportData.size() <= 0) {
                            empty = true;
                        }
                        if (innerColumnsHeader.equals("Asset description")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.tagName("a"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else if (innerColumnsHeader.equals("Last trip") || (innerColumnsHeader.equals("Last position")) || (innerColumnsHeader.equals("Config upload date"))) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                //Convert date to match the one on trip details
                                String timeZone = "";
                                String newDate = "";
                                if (!rows.get(i).getText().equals("")) {
                                    String dateSub = rows.get(i).getText().substring(0, 10);
                                    String timeSub = rows.get(i).getText().substring(11, 19);
                                    timeZone = rows.get(i).getText().substring(21, 24).trim();
                                    String[] dateSlipted = dateSub.split("-");
                                    newDate = dateSlipted[2] + "-" + this.getMonthAbr(Integer.parseInt(dateSlipted[1])) + "-" + dateSlipted[0];
                                }
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + newDate + "#" + timeZone;
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else {
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                String rowData = rows.get(i).getText();
                                if (innerColumnsHeader.equals("Odometer")) {
                                    rowData = rowData.trim().replaceAll("\\s", "");
                                } else if (innerColumnsHeader.equals("Engine hours")) {
                                    if (!rowData.equals("")) {
                                        double myDouble = Double.parseDouble(rowData);
                                        rowData = String.valueOf(Math.round(myDouble));
                                    }
                                }

                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rowData;
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rowData);
                                }
                            }
//                        for (int i = 0; i < rows.size(); i++) {
//                            if (empty == false) {
//                                String value = reportData.get(i) +"#"+rows.get(i).getText();
//                                reportData.set(i, value);
//                            }else{
//                                reportData.add(rows.get(i).getText()); 
//                            }
//                        }
                        }
                    }
                }
                //move to next page
                pages++;
                if (pages <= numberOfPages) {
                    if (browserType.equals(Enums.BrowserType.IE)) {
                        this.doubleClickElementByXpath(nextPageXpath);
                    } else {
                        this.clickElementbyXpath(nextPageXpath);
                    }
                    this.waitForElementByXpath(elementXpath);
                }

                gridData.addAll(reportData);
            }
            gridDataWithHeaders.add(columHeaders);
            gridDataWithHeaders.addAll(gridData);
            return gridDataWithHeaders;
        } catch (Exception e) {
            System.err.println("Error reading assests from grid - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

            return gridData;
        }
    }

    public String getMonthAbr(int month) {
        String monthAbr = "";
        switch (month) {
            case 1:
                monthAbr = "Jan";
                break;
            case 2:
                monthAbr = "Feb";
                break;
            case 3:
                monthAbr = "Mar";
                break;
            case 4:
                monthAbr = "Apr";
                break;
            case 5:
                monthAbr = "May";
                break;
            case 6:
                monthAbr = "Jun";
                break;
            case 7:
                monthAbr = "Jul";
                break;
            case 8:
                monthAbr = "Aug";
                break;
            case 9:
                monthAbr = "Sep";
                break;
            case 10:
                monthAbr = "Oct";
                break;
            case 11:
                monthAbr = "Nov";
                break;
            case 12:
                monthAbr = "Dec";
                break;
            default:
                monthAbr = "Invalid month";
                break;
        }

        return monthAbr;
    }

    public boolean selcetAllColumnsOnColumnChooserByXpath(String columnChooserButtonRelativeXpath, String columnChooserListRelativeXpath) {
        try {
            waitForElementByXpath(columnChooserButtonRelativeXpath);

            WebElement elementToClick = Driver.findElement(By.xpath(columnChooserButtonRelativeXpath));
            elementToClick.click();
            //
            waitForElementByXpath(columnChooserListRelativeXpath);
            List<WebElement> listElements = Driver.findElements(By.xpath(columnChooserListRelativeXpath));
            int numberOfCols = listElements.size();
            //System.out.println("[INFO] Clicking element by Xpath : " + columnChooserButtonRelativeXpath);
            do {
                waitForElementByXpath(columnChooserListRelativeXpath);
                List<WebElement> listElementsToClick = Driver.findElements(By.xpath(columnChooserListRelativeXpath));
                for (WebElement _listElements : listElements) {
                    try {
                        _listElements.findElement(By.tagName("i"));

                    } catch (Exception ex) {
                        _listElements.click();
                        break;
                    }
                }
                waitForElementByXpath(columnChooserButtonRelativeXpath);

                WebElement clickColumnChooserButton = Driver.findElement(By.xpath(columnChooserButtonRelativeXpath));
                clickColumnChooserButton.click();
                numberOfCols--;
            } while (numberOfCols > 0);

            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean returnToPreviousTab(String previousTab) {
        try {
            SeleniumDriverInstance.Driver.switchTo().window(previousTab);
        } catch (Exception e) {
            System.err.println("Failed to return to previous tab - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
        return true;
    }

    public boolean waitForElementVisibiltyByXpath(String elementXpath) {
        try {
            System.out.println("[INFO] Clicking element by Xpath : " + elementXpath);
            waitForElementByXpath(elementXpath);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            WebDriverWait wait = new WebDriverWait(Driver, ApplicationConfig.WaitTimeout());
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
            wait.until(ExpectedConditions.elementToBeClickable(elementToClick));
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(elementToClick));

            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public List<String> getActivityTimeLineReportData(String elementXpath) {
        try {
            waitForElementByXpath(elementXpath);
            List<WebElement> tableList = Driver.findElements(By.xpath(elementXpath));
            List<String> _headers = new ArrayList<>();
            List<String> _data = new ArrayList<>();
            for (int i = 0; i < tableList.size(); i++) {
                WebElement innerTableHead = tableList.get(i).findElement(By.tagName("thead"));

                List<WebElement> tableHeaders = innerTableHead.findElements(By.tagName("th"));
                // And iterate over them, getting the cells
                for (WebElement _tableHeader : tableHeaders) {
                    _headers.add(_tableHeader.getText());
                }
                WebElement innerTableBody = tableList.get(i).findElement(By.tagName("tbody"));
                List<WebElement> tableBody = innerTableBody.findElements(By.tagName("td"));
                // And iterate over them, getting the cells
                for (WebElement _tableBody : tableBody) {
                    _data.add(_tableBody.getText());
                }

            }
            //Create new List to return
            List<String> reportData = new ArrayList<>();
            for (int i = 0; i < _headers.size(); i++) {
                if (_headers.get(i).contains("Start time") || _headers.get(i).contains("End time")) {
                    //Convert date to match the one on trip details
                    Date newDate = new Date(_data.get(i).substring(0, _data.get(i).length() - 4));
                    SimpleDateFormat df3 = new SimpleDateFormat("yyyy-MM-dd");
                    reportData.add(_headers.get(i) + "=" + df3.format(newDate));
                } else {
                    reportData.add(_headers.get(i) + "=" + _data.get(i));
                }
            }
            return reportData;
        } catch (Exception e) {
            System.err.println("Error: reading Activity TimeLine Report Data - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public List<String> getTripSummaryDataOnPopUp(String elementXpath) {
        try {
            waitForElementByXpath(elementXpath);
            WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));

            List<String> reportData = new ArrayList<>();
            List<WebElement> innerDivs = mainDiv.findElements(By.tagName("div"));
            for (WebElement _innerDivs : innerDivs) {
                List<WebElement> innerLabels = _innerDivs.findElements(By.tagName("label"));
                reportData.add(innerLabels.get(0).findElement(By.tagName("strong")).getText() + "=" + innerLabels.get(1).getText());
            }

            return reportData;
        } catch (Exception e) {
            System.err.println("Error reading Trip Summary Data On Pop Up - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public String retrieveTextByXpathUsingAttribute(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            retrievedText = elementToRead.getAttribute("innerHTML");
            //retrievedText = elementToRead.getAttribute("innerText");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public List<String> getAssetsListOnGrid(String elementXpath) {
        List<String> gridData = new ArrayList<>();
        try {
            int pages = 1;
            int numberOfPages = 1;
            List<String> reportData = new ArrayList<>();
            //Get number of pages.

            while (pages <= numberOfPages) {
                this.takeScreenShot("AssetListPage" + pages, false);
                reportData = new ArrayList<>();
                waitForElementByXpath(elementXpath, 13000);
                //waitForElementByXpathToStaleness(elementXpath);
                WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));
                List<WebElement> divColumns = mainDiv.findElements(By.className("column"));
                //iterate through div list
                for (WebElement _divColumns : divColumns) {
                    String innerColumnsHeader = _divColumns.findElement(By.tagName("span")).getText();
                    if (!innerColumnsHeader.equals("")) {
                        //Adding method to use
                        boolean empty = false;
                        if (reportData.size() <= 0) {
                            empty = true;
                        }
                        if (innerColumnsHeader.equals("Asset description")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.tagName("a"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else {
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        }
                    }
                }
                //move to next page
                pages++;

                gridData.addAll(reportData);
            }
            return gridData;
        } catch (Exception e) {
            System.err.println("Error reading assests from grid - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

            return gridData;
        }
    }

    public boolean CheckIfElementDisplayedByXpath(String elementXpath) {
        try {
            waitForElementByXpath(elementXpath, 60);
            WebElement element = Driver.findElement(By.xpath(elementXpath));

            return element.isDisplayed();

        } catch (Exception e) {
            System.err.println("failed to find element by xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean verifyElementAbsent(String elementXpath) {
        try {
            Driver.findElement(By.xpath(elementXpath));
            System.out.println("Element Present");
            return true;

        } catch (NoSuchElementException e) {
            System.out.println("Element absent");
            return false;
        }
    }

    public boolean waitForPresenceOfElementByXpath(String elementXpath, Integer timeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForfElementToBeClickableByXpath(String elementXpath, Integer timeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForfElementToBeClickableByXpath(String elementXpath) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForElementToBeClickableByXpath(String elementXpath) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitForWebElementToBeClickable(WebElement element) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.elementToBeClickable(element)) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] waiting for web element '" + element + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public String retrievetextFromDropdownByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            retrievedText = elementToRead.getText();
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveTextFromDropdownByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);
            List<WebElement> alloptions = new Select(Driver.findElement(By.xpath(elementXpath))).getOptions();
            for (WebElement options : alloptions) {
                retrievedText += "\n" + options.getText();
            }

            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public int getAssetRowNumberListOnGrid(String elementXpath) {

        int rowNum = 0;
        try {
            int pages = 1;
            int numberOfPages = 1;
            List<String> reportData = new ArrayList<>();
            //Get number of pages.

            while (pages <= numberOfPages) {
                this.takeScreenShot("AssetListPage" + pages, false);
                reportData = new ArrayList<>();
                waitForElementByXpath(elementXpath, 13000);
                //waitForElementByXpathToStaleness(elementXpath);
                WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));
                List<WebElement> divColumns = mainDiv.findElements(By.className("column"));
                //iterate through div list
                for (WebElement _divColumns : divColumns) {
                    String innerColumnsHeader = _divColumns.findElement(By.tagName("span")).getText();
                    if (!innerColumnsHeader.equals("")) {
                        //Adding method to use
                        boolean empty = false;

                        if (reportData.size() <= 0) {
                            empty = true;
                        }
                        if (innerColumnsHeader.equals("Engine hours")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.tagName("div"));
                            for (int i = 1; i < rows.size(); i++) {
                                String ro = rows.get(i).getText();

                                if (!rows.get(i).getText().equals("")) {
                                    rowNum = i;
                                    break;

                                }
                            }
                            if (rowNum == 1) {
                                break;
                            }
                        }
                    }
                }
                //move to next page
                pages++;
            }
            return rowNum - 1;

        } catch (Exception e) {
            System.err.println("Error reading assests from grid - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return rowNum;
        }
    }

    public String retrieveMixTelematicTextByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            Point coordinates = elementToRead.getLocation();
            Robot robot = new Robot();
            robot.mouseMove(coordinates.getX(), coordinates.getY() + 65); //Number 65 should vary
            Thread.sleep(3000);
            retrievedText = elementToRead.getText();
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public String retrieveMixTelematicPageNameByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            retrievedText = elementToRead.getAttribute("breadcrumb-title");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return retrievedText;
    }

    public String retrieveMixTelematicDisabledByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            retrievedText = elementToRead.getAttribute("disabled");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return retrievedText;
    }

    public String verifyUlListByXpath(String elementXpath, String columns) {
        try {
            //System.out.println("[INFO] Clicking element by Xpath : " + elementXpath);
            waitForElementByXpath(elementXpath);
            WebElement columnsElement = Driver.findElement(By.xpath(elementXpath));

            List<String> parameterCols = new LinkedList(Arrays.asList(columns.split(";")));

            List<WebElement> colToVerify = columnsElement.findElements(By.tagName("a"));
            for (WebElement _colToVerify : colToVerify) {
                boolean found = false;
                String index = "";
                for (String paraCol : parameterCols) {
                    //loop through parameter cols
                    if (_colToVerify.getText().equals(paraCol)) {
                        index = paraCol;
                        found = true;
                    }
                }
                if (found) {
                    //remove if found to lessen the size
                    parameterCols.remove(index);
                }
            }
            if (parameterCols.size() != 0) {
                System.out.println("[INFO] Error missing columns : " + parameterCols.toString());
                System.err.println("[Error] Error missing columns : " + parameterCols.toString());
                return parameterCols.toString();
            }

            return "";
        } catch (Exception e) {
            System.err.println("[Error] Failed to verify columns list by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return "Error";
        }
    }

    public static void incrementScreenShotFolderCounter() {
        SeleniumDriverUtility.screenShotFolderCounter++;
    }

    public static void resetScreenShotCounter(Integer screenShotCounter) {
        SeleniumDriverUtility.screenShotCounter = screenShotCounter;
    }

    public static void resetScreenShotFolderCounter(Integer screenShotFolderCounter) {
        SeleniumDriverUtility.screenShotFolderCounter = screenShotFolderCounter;
    }

    public String generateDateTimeStampVaule() {
        try {
            String dynamicRegNo = "";

            dynamicRegNo = SeleniumDriverInstance.generateDateTimeString("yyyy-MM-dd_HH-mm-ss");
            dynamicRegNo = dynamicRegNo.replace('-', ' ').replace('_', ' ').trim().replaceAll("\\s", "");

            return dynamicRegNo;
        } catch (Exception e) {
            System.err.println("[Error] Failed to generate DateTimeStamp Vaule - " + e.getMessage());
            return null;
        }
    }

    public List<String> getAssetsAndHeardersListOnGrid(String elementXpath, String _numberOfPages, String nextPageXpath) {
        List<String> gridData = new ArrayList<>();
        List<String> gridDataWithHeaders = new ArrayList<>();
        try {
            int pages = 1;
            int numberOfPages = 1;
            List<String> reportData = new ArrayList<>();
            waitForElementByXpath(_numberOfPages);
            //Get number of pages.
            String numOfPages = Driver.findElement(By.xpath(_numberOfPages)).getText();
            if (!numOfPages.equals("")) {
                numberOfPages = Integer.parseInt(numOfPages);
            }
            String columHeaders = "";
            while (pages <= numberOfPages) {
                this.takeScreenShot("AssetListPage" + pages, false);
                reportData = new ArrayList<>();
                waitForElementByXpath(elementXpath, 13000);
                //waitForElementByXpathToStaleness(elementXpath);
                WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));
                List<WebElement> divColumns = mainDiv.findElements(By.className("column"));
                //iterate through div list
                for (WebElement _divColumns : divColumns) {
                    String innerColumnsHeader = _divColumns.findElement(By.tagName("span")).getText();

                    if (!innerColumnsHeader.equals("")) {
                        //Adding method to use
                        //Get column headers
                        if (!columHeaders.contains(innerColumnsHeader)) {
                            columHeaders += innerColumnsHeader + "#";
                        }
                        boolean empty = false;
                        if (reportData.size() <= 0) {
                            empty = true;
                        }
                        if (innerColumnsHeader.equals("Descrizione risorsa")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.tagName("a"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else if (innerColumnsHeader.equals("Ultimo percorso")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                //Convert date to match the one on trip details
                                String timeZone = "";
                                String newDate = "";
                                if (!rows.get(i).getText().equals("")) {
                                    String dateSub = rows.get(i).getText().substring(0, 10);
                                    String timeSub = rows.get(i).getText().substring(11, 19);
                                    timeZone = rows.get(i).getText().substring(21, 24).trim();
                                    String[] dateSlipted = dateSub.split("-");
                                    newDate = dateSlipted[2] + "-" + this.getMonthAbr(Integer.parseInt(dateSlipted[1])) + "-" + dateSlipted[0];
                                }
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + newDate + "#" + timeZone;
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else {
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        }
                    }
                }
                //move to next page
                pages++;
                if (pages <= numberOfPages) {
                    this.clickElementbyXpath(nextPageXpath);
                    this.waitForElementByXpath(elementXpath);
                }

                gridData.addAll(reportData);
            }
            gridDataWithHeaders.add(columHeaders);
            gridDataWithHeaders.addAll(gridData);
            return gridDataWithHeaders;
        } catch (Exception e) {
            System.err.println("Error reading assests from grid - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

            return gridData;
        }

    }

    public String retrievetextFromDropdownByXpath1(String elementXpath) {
        String retrievedText = "";

        try {

            Select dropdown = new Select(Driver.findElement(By.xpath(elementXpath)));

            WebElement firstselectedoption = dropdown.getFirstSelectedOption();

            String selectedText = firstselectedoption.getText();

            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return selectedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public Boolean ClickEditDataOnTableByXpath(String elementXpath, int num) {
        try {
            Thread.sleep(5000);

            List<WebElement> divRows = Driver.findElements(By.xpath(elementXpath));
            int count = 0;

            for (WebElement _divData : divRows) {

                if (count == num) {
                    _divData.click();
                    return true;
                }
                count++;
            }

            return false;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public int EditDataOnTableByXpath(String elementXpath, String Value) {
        try {
            Thread.sleep(5000);
            int count = 0;
            Boolean found = false;
            List<String> reportData = new ArrayList<>();
            WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> divRows = mainDiv.findElements(By.tagName("tr"));

            for (WebElement _divColumns : divRows) {

                List<WebElement> tds = _divColumns.findElements(By.tagName("td"));

                for (WebElement _divData : tds) {
                    if (_divData.getText().equals(Value)) {
                        return count;
                    }

                }
                count++;

            }
            return count;

        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return 0;
        }
    }

    public int MixTelematicsCertificateValidityPeriodAndReminderPeriodValuesInspectionByXpath(String elementXpath, String ActionButtonXpath, String editTabXpath) {
        try {
            Thread.sleep(5000);
            int count = 0;
            Boolean found = false;
            WebElement table = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> rows = table.findElements(By.tagName("tr"));
            WebElement ActionButton = Driver.findElement(By.xpath(ActionButtonXpath));
            WebElement edit = Driver.findElement(By.xpath(editTabXpath));
            java.util.Iterator<WebElement> i = rows.iterator();
            while (i.hasNext()) {
                ActionButton.click();
                edit.click();
                //div[@class='row-actions']//a[@class='btn-actions']/../../../../li[2]
                //div[@class='row-actions']//li[2]//a[@class='btn-actions']
                WebElement row = i.next();
                System.out.println(row.getText());
                count++;
            }
            return count;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return 0;
        }
    }

    public List<String> CheckDataOnTableByXpath(String elementXpath) {
        try {
            Thread.sleep(5000);
            List<String> reportData = new ArrayList<>();
            WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));
            WebElement divRows = mainDiv.findElement(By.tagName("tr"));
            List<WebElement> tds = divRows.findElements(By.tagName("td"));
            for (WebElement _divColumns : tds) {
                if (!_divColumns.getText().equals("")) {
                    reportData.add(_divColumns.getText());
                }

            }

            return reportData;

        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public String generateDateTimeStampValue() {
        try {
            String dynamicRegNo = "";

            dynamicRegNo = SeleniumDriverInstance.generateDateTimeString();
            dynamicRegNo = dynamicRegNo.replace('-', ' ').replace('_', ' ').trim().replaceAll("\\s", "").replaceAll("PM", "").replaceAll("AM", "");

            return dynamicRegNo;
        } catch (Exception e) {
            System.err.println("[Error] Failed to generate DateTimeStamp Vaule - " + e.getMessage());
            return null;
        }
    }

    public int getAssetRowOnGridListWithCertainFeatures(String elementXpath, String _numberOfPages, String nextPageXpath, String feature1, String feature2) {
        List<String> gridData = new ArrayList<>();
        try {
            int pages = 1;
            int numberOfPages = 1;
            List<String> reportData = new ArrayList<>();
            waitForElementByXpath(_numberOfPages);
            //Get number of pages.
            String numOfPages = Driver.findElement(By.xpath(_numberOfPages)).getText();
            if (!numOfPages.equals("")) {
                numberOfPages = Integer.parseInt(numOfPages);
            }
            while (pages <= numberOfPages) {
                this.takeScreenShot("AssetListPage" + pages, false);
                reportData = new ArrayList<>();
                waitForElementByXpath(elementXpath, 13000);
                //waitForElementByXpathToStaleness(elementXpath);
                WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));
                List<WebElement> divColumns = mainDiv.findElements(By.className("column"));
                //iterate through div list
                for (WebElement _divColumns : divColumns) {
                    String innerColumnsHeader = _divColumns.findElement(By.tagName("span")).getText();
                    if (!innerColumnsHeader.equals("")) {
                        //Adding method to use
                        boolean empty = false;
                        if (reportData.size() <= 0) {
                            empty = true;
                        }
                        if (innerColumnsHeader.equals("Asset description")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.tagName("a"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else if (innerColumnsHeader.equals("Last trip")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                //Convert date to match the one on trip details
                                String timeZone = "";
                                String newDate = "";
                                if (!rows.get(i).getText().equals("")) {
                                    String dateSub = rows.get(i).getText().substring(0, 10);
                                    String timeSub = rows.get(i).getText().substring(11, 19);
                                    timeZone = rows.get(i).getText().substring(21, 24).trim();
                                    String[] dateSlipted = dateSub.split("-");
                                    newDate = dateSlipted[2] + "-" + this.getMonthAbr(Integer.parseInt(dateSlipted[1])) + "-" + dateSlipted[0];
                                }
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + newDate + "#" + timeZone;
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else {
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        }
                    }
                }

                gridData.addAll(reportData);
                if (gridData.size() > 0) {
                    for (int i = 0; i < gridData.size(); i++) {
                        if ((gridData.get(i).contains(feature1))
                                && (gridData.get(i).contains(feature2))) {
                            //Get row number for asset to click
                            return i;
                        }
                    }
                }

                //move to next page
                pages++;
                if (pages <= numberOfPages) {
                    this.clickElementbyXpath(nextPageXpath);
                    this.waitForElementByXpath(elementXpath);
                }

            }
            return -1;
        } catch (Exception e) {
            System.err.println("Error finding assests from grid - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

            return -1;
        }
    }

    public List<String> getPassengersAndHeardersListOnGrid(String elementXpath, String _numberOfPages, String nextPageXpath) {
        List<String> gridData = new ArrayList<>();
        List<String> gridDataWithHeaders = new ArrayList<>();
        try {
            int pages = 1;
            int numberOfPages = 1;
            List<String> reportData = new ArrayList<>();
            String columHeaders = "";
            while (pages <= numberOfPages) {
                this.takeScreenShot("PassengersListPage" + pages, false);
                reportData = new ArrayList<>();
                waitForElementByXpath(elementXpath, 13000);
                WebElement mainTable = Driver.findElement(By.xpath(elementXpath));

                List<WebElement> tableRows = mainTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
                //Get Headers
                String headerTextXpath = "//div[@id-property=\"'passengerId'\"]//table//thead//th//span[contains(@ng-hide,'column.title')]";
                List<WebElement> tableHeader = Driver.findElements(By.xpath(headerTextXpath));
                //String headerTextXpath = "//span[contains(@ng-hide,'column.title')]";
                for (WebElement _tableHeader : tableHeader) {
                    columHeaders += _tableHeader.getText() + "#";
                }

                //Get table data
                boolean empty = true;
                for (WebElement _tableRows : tableRows) {
                    List<WebElement> rows = _tableRows.findElements(By.tagName("td"));
                    String value = "";
                    for (int i = 1; i < rows.size(); i++) {
                        value += rows.get(i).findElement(By.tagName("span")).getText() + "#";
                    }
                    reportData.add(value);
                }
                pages++;

                gridData.addAll(reportData);
            }
            gridDataWithHeaders.add(columHeaders);
            gridDataWithHeaders.addAll(gridData);
            return gridDataWithHeaders;
        } catch (Exception e) {
            System.err.println("Error reading passengers from grid - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

            return gridData;
        }

    }

    public boolean deSelectColumnChooserList(String elementXpath, String columnToChooseXpath) {
        try {
            System.out.println("[INFO] Clicking element by Xpath : " + columnToChooseXpath);
            waitForElementByXpath(elementXpath);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            waitForElementByXpath(columnToChooseXpath);
            WebElement colToClick = Driver.findElement(By.xpath(columnToChooseXpath));
            try {
                WebElement icon = colToClick.findElement(By.tagName("i"));
                if (icon.getAttribute("style").equals("")) {
                    colToClick.click();
                }
                return true;
            } catch (Exception ex) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String getCssValueByXpath(String elementXpath, String css) {
        String cssValue = "";
        try {
            System.out.println("[INFO]Get css value - " + css + " element by Xpath : " + elementXpath);
            waitForElementByXpath(elementXpath);
            WebElement element = Driver.findElement(By.xpath(elementXpath));
            cssValue = element.getCssValue(css);
            System.out.println("[INFO]Returned css value : " + cssValue);
            return cssValue;
        } catch (Exception e) {
            System.err.println("[Error] Failed to get element css value by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return cssValue;
        }
    }

    public boolean waitForInvisibilityOfElementByXpath(String elementXpath, Integer timeout) {
        boolean elementFound = false;
        System.out.println("[INFO] Waiting For Invisibility Of Element by Xpath : " + elementXpath);
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public String getElementEnabledStatusByXpath(String elementXpath) {
        System.out.println("[INFO] Getting Element Status By Xpath : " + elementXpath);
        String isDisabled = "";
        try {
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));

            isDisabled = elementToClick.getAttribute("disabled");

        } catch (Exception e) {
            System.err.println("Error getting element status - " + e.getMessage());
        }
        return isDisabled;
    }

    public boolean checkElementEnabledByXpath(String elementXpath) {
        System.out.println("[INFO] Getting Element Status By Xpath : " + elementXpath);
        boolean isDisabled = false;
        String IsDisabledString;
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));

            IsDisabledString = elementToClick.getAttribute("disabled");

            if (IsDisabledString.equals("true")) {
                isDisabled = true;
            }

        } catch (Exception e) {
            System.err.println("Error getting element status - " + e.getMessage());
        }
        return isDisabled;
    }

    public int getRowCount(String rowElementXpath) {
        return Driver.findElements(By.xpath(rowElementXpath)).size();
    }

    public String retrieveReportCategoryTextByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);
            String value = Driver.findElement(By.xpath(elementXpath)).getAttribute("value");

            List<WebElement> selectedValues = Driver.findElement(By.xpath(elementXpath)).findElements(By.tagName("option"));
            for (WebElement _options : selectedValues) {
                if (_options.getAttribute("value").equals(value)) {
                    retrievedText = _options.getText();
                }
            }
            //retrievedText = elementToRead.getAttribute("innerText");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public boolean dragElementToRelativeElementByXpath(String sourceElementXpath, String targetElementXpath) {
        try {
            System.out.println("[Info]Performing drag and drop for element - " + sourceElementXpath);

            WebElement sourceElement = Driver.findElement(By.xpath(sourceElementXpath));
            WebElement targetElement = Driver.findElement(By.xpath(targetElementXpath));
            Actions builder = new Actions(Driver);
            builder.click(sourceElement);
            builder.clickAndHold(sourceElement);
            builder.perform();
            this.pause(1000);
            builder.moveToElement(targetElement).perform();
            builder.release(targetElement);
            builder.perform();

            return true;

        } catch (Exception e) {
            System.err.println("[Error] Failed to drag element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean DragElementByXpath(String sourceElementXpath, String targetElementXpath) {
        try {
            System.out.println("[Info]Performing drag and drop for element - " + sourceElementXpath);

            WebElement sourceElement = Driver.findElement(By.xpath(sourceElementXpath));
            WebElement targetElement = Driver.findElement(By.xpath(targetElementXpath));
            Actions builder = new Actions(Driver);
            builder.moveToElement(sourceElement).perform();
            builder.clickAndHold(sourceElement);
            builder.perform();
            this.pause(1000);
            builder.moveToElement(targetElement).perform();
            builder.release(targetElement);
            builder.perform();

            return true;

        } catch (Exception e) {
            System.err.println("[Error] Failed to drag element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean DragAndDropElementByXpath(String sourceElementXpath, String targetElementXpath) {
        try {

            System.out.println("[Info]Performing drag and drop for element - " + sourceElementXpath);

            WebElement sourceElement = Driver.findElement(By.xpath(sourceElementXpath));
            WebElement targetElement = Driver.findElement(By.xpath(targetElementXpath));
            Actions builder = new Actions(Driver);
            builder.moveToElement(sourceElement).perform();
            builder.clickAndHold(sourceElement);
            builder.perform();
            this.pause(1000);
            builder.moveToElement(targetElement).perform();
            builder.release(targetElement);
            this.pause(2000);
            builder.perform();

            return true;

        } catch (Exception e) {
            System.err.println("[Error] Failed to drag element by Xpath - " + e.getMessage());
            System.out.println("[Error] Failed to drag element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean DragAndDropElementOffsetByXpath(String sourceElementXpath, String targetElementXpath, int xOffSet, int yOffSet) {
        try {

            System.out.println("[Info]Performing drag and drop for element - " + sourceElementXpath);

            WebElement sourceElement = Driver.findElement(By.xpath(sourceElementXpath));
            WebElement targetElement = Driver.findElement(By.xpath(targetElementXpath));
            Actions builder = new Actions(Driver);
            builder.moveToElement(sourceElement).perform();
            builder.clickAndHold(sourceElement);
            builder.perform();
            this.pause(1000);
            builder.moveToElement(targetElement, xOffSet, yOffSet).perform();
            builder.release();
            this.pause(2000);
            builder.perform();

            return true;

        } catch (Exception e) {
            System.err.println("[Error] Failed to drag element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean DragAndDropElementOffsetByXpath(String sourceElementXpath, int xOffSet, int yOffSet) {
        try {

            System.out.println("[Info]Performing drag and drop for element - " + sourceElementXpath);

            WebElement sourceElement = Driver.findElement(By.xpath(sourceElementXpath));
            Actions builder = new Actions(Driver);
            builder.moveToElement(sourceElement).perform();
            builder.clickAndHold(sourceElement);
            builder.perform();
            this.pause(1000);
            builder.moveToElement(sourceElement, xOffSet, yOffSet).perform();
            builder.release();
            this.pause(2000);
            builder.perform();

            return true;

        } catch (Exception e) {
            System.err.println("[Error] Failed to drag element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String extractSiteFromOrganisationGroupByXpath(String elementXpath, String siteToNotExtract) {
        String extractedSite = "";
        try {
            System.out.println("[Info]Extracting sites from  - " + elementXpath);
            String site1 = "", site2 = "";
            List<WebElement> liElement = Driver.findElement(By.xpath(elementXpath)).findElements(By.tagName("li"));
            for (WebElement _list : liElement) {
                List<WebElement> listDetails = _list.findElements(By.tagName("span"));
                for (WebElement _details : listDetails) {
                    site1 += _details.getText() + "#";
                }
                if (site1.contains(siteToNotExtract)) {
                    site1 = "";
                } else {
                    break;
                }
            }
            for (WebElement _list : liElement) {
                List<WebElement> listDetails = _list.findElements(By.tagName("span"));
                for (WebElement _details : listDetails) {
                    site2 += _details.getText() + "#";
                }
                if (site2.contains(siteToNotExtract) || (site2.contains(site1))) {
                    site2 = "";
                } else {
                    break;
                }
            }
            return site1 + ";" + site2;

        } catch (Exception e) {
            System.err.println("[Error] Failed to extract sited on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return extractedSite;
        }
    }

    public String extractSiteDetailsFromOrganisationGroupByXpath(String elementXpath) {
        String extractedSite = "";
        try {
            System.out.println("[Info]Extracting site details from  - " + elementXpath);
            List<WebElement> liElement = Driver.findElement(By.xpath(elementXpath)).findElements(By.tagName("span"));
            for (WebElement _list : liElement) {
                extractedSite += _list.getText() + "#";
            }
            return extractedSite;

        } catch (Exception e) {
            System.err.println("[Error] Failed to extract site details by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return extractedSite;
        }
    }

    public String extractAssetDetailsAndSelectFromOrganisationGroupByXpath(String elementXpath, String assestToSelect) {
        String extractedSite = "";
        try {
            int _assestToSelect = Integer.parseInt(assestToSelect);
            System.out.println("[Info]Extracting  and Selecting Asset details from  - " + elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            for (int i = 2; i < liElement.size(); i++) {
                WebElement assetDetails = liElement.get(i).findElement(By.tagName("span"));
                extractedSite += assetDetails.getText() + "; ";
                assetDetails.click();
                _assestToSelect--;
                if (_assestToSelect <= 0) {
                    return extractedSite;
                }

            }
            return extractedSite;

        } catch (Exception e) {
            System.err.println("[Error] Failed to extract and Select asset details on oraganisation by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return extractedSite;
        }
    }

    public Boolean CheckIfElementIsEnabled(String elementXpath) {
        try {
            Thread.sleep(3000);
            waitForElementByXpath(elementXpath);
            WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));

            Boolean IsEnabled = mainDiv.isEnabled();

            String disabled = mainDiv.getAttribute("disabled");

            return IsEnabled;

//
//            if (disabled == null || disabled.equals("true")) {
//                IsEnabled = true;
//            } else {
//                IsEnabled = false;
//            }
//            return IsEnabled;
        } catch (Exception e) {
            System.err.println("Error checking if element is enabled - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public Boolean CheckIfElementIsSelected(String elementXpath) {
        try {
            waitForElementByXpath(elementXpath);
            boolean mainDiv = Driver.findElement(By.xpath(elementXpath)).isSelected();

            return mainDiv == true;
        } catch (Exception e) {
            System.err.println("Error checking if element is selected - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public Boolean CheckIfElementIsDisabled(String elementXpath) {
        Boolean IsDisabled = false;
        try {
            Thread.sleep(3000);
            waitForElementByXpath(elementXpath);
            WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));

            IsDisabled = mainDiv.isEnabled();

            String disa = mainDiv.getAttribute("disabled");

            IsDisabled = !(disa == null || disa.equals("false"));

            return IsDisabled;

        } catch (Exception e) {
            System.err.println("Error checking if element is enabled - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            IsDisabled = false;
        }
        return IsDisabled;
    }

//    
    public boolean isElementEnabled(String elementXpath) {
        waitForElementByXpath(elementXpath, 10);

        WebElement element = Driver.findElement(By.xpath(elementXpath));

        return element.isEnabled();
    }

    public List<String> returnListOfElementsOnADropdownByXpath(String elementXpath) {
        try {
            Thread.sleep(5000);
            List<String> reportData = new ArrayList<>();
            WebElement Dropdown = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> divRows = Dropdown.findElements(By.tagName("option"));

            for (WebElement _divData : divRows) {
                reportData.add(_divData.getText());
            }

            return reportData;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public List<String> returnListOfElementsByXpath(String elementXpath) {
        try {
            Thread.sleep(5000);
            List<String> reportData = new ArrayList<>();
            WebElement Dropdown = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> divRows = Dropdown.findElements(By.tagName("li"));

            for (WebElement _divData : divRows) {
                reportData.add(_divData.getText());
            }

            return reportData;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public Boolean CheckIfElementIsARadioButton(String elementXpath) {
        try {
            Thread.sleep(5000);
            String isRadio = "";
            WebElement Dropdown = Driver.findElement(By.xpath(elementXpath));

            isRadio = Dropdown.getAttribute("type");
            return isRadio.equals("radio");

        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public List<String> retrieveListOfElements(String elementXpath) {
        try {
            Thread.sleep(5000);

            List<String> reportData = new ArrayList<>();
            WebElement element1 = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> divRows = element1.findElements(By.tagName("li"));

            for (WebElement _divData : divRows) {
                reportData.add(_divData.getText());
            }

            return reportData;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public int retrieveListOfElementsTableRow(String elementXpath) {
        try {
            Thread.sleep(5000);

            List<WebElement> element1 = Driver.findElements(By.xpath(elementXpath));

            return element1.size();
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return 0;
        }
    }

    public List<String> retrieveListOfOptionsElements(String elementXpath) {
        try {
            Thread.sleep(5000);

            List<String> reportData = new ArrayList<>();
            WebElement element1 = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> divRows = element1.findElements(By.tagName("option"));

            for (WebElement _divData : divRows) {
                reportData.add(_divData.getText());
            }

            return reportData;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public List<String> checkIfAllccheckBoxesAreCheckedByXpath(String elementXpath) {
        try {
            Thread.sleep(5000);
            int count = 1;
            List<String> reportData = new ArrayList<>();
            WebElement element1 = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> divRows = element1.findElements(By.tagName("input"));
            List<WebElement> Groups = element1.findElements(By.tagName("span"));

            for (WebElement _divData : divRows) {
                boolean selected = _divData.isSelected();

                if (!_divData.isSelected()) {
                    reportData.add(Groups.get(count).getText());
                    System.err.println("Error- Element " + Groups.get(count).getText() + "is not checked");
                }
                count++;

            }

            return reportData;
        } catch (Exception e) {
            System.err.println("Error checking if all checkboxes are checked - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public boolean ClickListOfElementsWithExpander(String elementXpath) {
        try {
            Thread.sleep(5000);

            List<WebElement> divRows = Driver.findElements(By.xpath(elementXpath));

            for (WebElement _divData : divRows) {
                _divData.click();
                break;
            }

            return true;

        } catch (Exception e) {
            System.err.println("Error Clicking element from a list - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String extractAssetDetailsAndDeselectOrSelectFromOrganisationGroupByXpath(String elementXpath, String assestToSelect) {
        String extractedSite = "";
        String unSelected = "Deselected Assets: ";
        String toSelectAssets = "Selected Assets: ";
        String alreadySelected = "Default Selected: ";
        try {
            int numberOfSelected = 0;

            int _assestToSelect = Integer.parseInt(assestToSelect);
            System.out.println("[Info]Extracting  and Selecting Asset details from  - " + elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            //get selected assets
            for (int i = 2; i < liElement.size(); i++) {
                WebElement assetSelected = liElement.get(i).findElement(By.tagName("input"));
                //get Selected assets
                try {
                    if (assetSelected.getAttribute("checked").equals("true")) {
                        numberOfSelected++;
                        WebElement assetDetails = liElement.get(i).findElement(By.tagName("span"));
                        alreadySelected += assetDetails.getText() + "; ";
                        if (numberOfSelected > 1) {
                            assetDetails.click();
                            unSelected += assetDetails.getText() + "; ";
                        }
                    }
                } catch (Exception e) {
                }
            }
            //If one asset is selected, select more
            if (numberOfSelected == 1) {
                for (int i = 2; i < liElement.size(); i++) {
                    WebElement assetSelected = liElement.get(i).findElement(By.tagName("input"));
                    try {
                        if (assetSelected.getAttribute("checked") == null) {
                            _assestToSelect--;
                            WebElement assetDetails = liElement.get(i).findElement(By.tagName("span"));
                            if (_assestToSelect >= 0) {
                                assetDetails.click();
                                toSelectAssets += assetDetails.getText() + "; ";
                            } else {
                                break;
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
            return alreadySelected + "<br><br>" + unSelected + "<br><br>" + toSelectAssets;

        } catch (Exception e) {
            System.err.println("[Error] Failed to extract and Select asset details on oraganisation by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return extractedSite;
        }
    }

    public String getStreamToEditByXpath(String elementXpath) {
        String streamClicked = "";
        try {
            System.out.println("[Info]Clicking stream actions from  - " + elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            for (int i = 0; i < liElement.size(); i++) {
                WebElement streamElement = liElement.get(i).findElement(By.tagName("h5"));
                return streamElement.getAttribute("textContent");
            }
            return streamClicked;

        } catch (Exception e) {
            System.err.println("[Error] Failed to click stream actions by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return streamClicked;
        }

    }

    public List<String> getStreamAssetListByXpath(String elementXpath) {
        List<String> reportData = new ArrayList<>();
        try {
            System.out.println("[Info]Extracting Stream date from  - " + elementXpath);
            waitForElementByXpath(elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            for (int i = 0; i < liElement.size(); i++) {
                String assetDays = liElement.get(i).getText();
                assetDays = assetDays.substring(0, assetDays.length() - 4).trim();
                reportData.add(assetDays);
            }
            return reportData;

        } catch (Exception e) {
            System.err.println("[Error] Failed to extract and Select asset details on oraganisation by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            reportData.clear();
            return reportData;
        }
    }

    public String selectAndExtractAssetDetailsFromOrganisationGroupByXpath(String elementXpath, String assestToSelect) {
        String extractedSite = "";
        try {
            int _assestToSelect = Integer.parseInt(assestToSelect);
            System.out.println("[Info]Extracting  and Selecting Asset details from  - " + elementXpath);
            waitForElementByXpath(elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            for (int i = 0; i < liElement.size(); i++) {
                WebElement assetDetails = liElement.get(i).findElement(By.tagName("span"));
                extractedSite += assetDetails.getText() + "; ";
                assetDetails.click();
                _assestToSelect--;
                if (_assestToSelect <= 0) {
                    return extractedSite;
                }

            }
            return extractedSite;

        } catch (Exception e) {
            System.err.println("[Error] Failed to extract and Select asset details on oraganisation by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return extractedSite;
        }
    }

    public boolean messageAllColumnChooserSelect(String elementXpath, String columnToSelectXpath) {
        try {
            System.out.println("[INFO] Clicking element by Xpath : " + columnToSelectXpath);
            waitForElementByXpath(elementXpath);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            waitForElementByXpath(columnToSelectXpath);
            WebElement colToClick = Driver.findElement(By.xpath(columnToSelectXpath));
            try {
                WebElement icon = colToClick.findElement(By.tagName("i"));
                if (icon.getAttribute("style").equals("")) {
                } else {
                    colToClick.click();
                }
                return true;
            } catch (Exception ex) {
                colToClick.click();
                return true;
            }
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean customGroupsColumns(String elementXpath, String columnToSelectXpath) {
        try {
            System.out.println("[INFO] Clicking element by Xpath : " + columnToSelectXpath);
            waitForElementByXpath(elementXpath);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            waitForElementByXpath(columnToSelectXpath);
            List<WebElement> colsToClick = Driver.findElements(By.xpath(columnToSelectXpath));
            elementToClick.click();
            for (WebElement colToClick : colsToClick) {
                elementToClick.click();
                try {
                    WebElement icon = colToClick.findElement(By.tagName("i"));
                    if (icon.getAttribute("style").contains("none")) {
                        colToClick.click();
                    }

                } catch (Exception ex) {
                }
                elementToClick.click();
            }
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean viewSMSColunmChooser(String elementXpath, String columnToSelectXpath) {
        try {
            System.out.println("[INFO] Clicking element by Xpath : " + columnToSelectXpath);
            waitForElementByXpath(elementXpath);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            waitForElementByXpath(columnToSelectXpath);
            List<WebElement> colsToClick = Driver.findElements(By.xpath(columnToSelectXpath));
            elementToClick.click();
            for (WebElement colToClick : colsToClick) {
                elementToClick.click();
                try {
                    WebElement icon = colToClick.findElement(By.tagName("i"));
                    if (icon.getAttribute("style").contains("none")) {

                    }

                } catch (Exception ex) {

                }
                elementToClick.click();
            }
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public List<String> getMessageRowDetailsAndHeardersListOnGrid(String elementXpath, String tableHeaderXpath) {
        List<String> gridData = new ArrayList<>();
        List<String> gridDataWithHeaders = new ArrayList<>();
        try {

            List<String> reportData = new ArrayList<>();
            String columHeaders = "";

            this.takeScreenShot("MessagesList", false);
            reportData = new ArrayList<>();
            waitForElementByXpath(elementXpath, 13000);
            WebElement mainTable = Driver.findElement(By.xpath(elementXpath));

            List<WebElement> tableRows = mainTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
            //Get Headers

            List<WebElement> tableHeader = Driver.findElements(By.xpath(tableHeaderXpath));
            for (WebElement _tableHeader : tableHeader) {
                columHeaders += _tableHeader.getText() + "#";
            }

            //Get table data
            boolean empty = true;
            for (WebElement _tableRows : tableRows) {
                List<WebElement> rows = _tableRows.findElements(By.tagName("td"));
                String value = "";
                for (int i = 1; i < rows.size(); i++) {
                    try {
                        value += rows.get(i).findElement(By.tagName("span")).getText() + "#";
                    } catch (Exception e) {
                        value += rows.get(i).findElement(By.tagName("a")).getText() + "#";
                    }
                }
                reportData.add(value);
            }

            gridData.addAll(reportData);

            gridDataWithHeaders.add(columHeaders);
            gridDataWithHeaders.addAll(gridData);
            return gridDataWithHeaders;
        } catch (Exception e) {
            System.err.println("Error reading messages from grid - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

            return gridData;
        }

    }

    public boolean validateDateFormat(String dateParameter, String _dateFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(_dateFormat);
        dateFormat.setLenient(false);
        try {

            dateFormat.parse(dateParameter);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean validate12hrFormat(String timeParameter) {
        try {
            if ((timeParameter.contains("AM")) || (timeParameter.contains("PM"))) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public List<String> retrieveListOfElements(String elementXpath, String tagName) {
        try {
            Thread.sleep(5000);

            List<String> reportData = new ArrayList<>();
            WebElement element1 = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> divRows = element1.findElements(By.tagName(tagName));

            for (WebElement _divData : divRows) {
                reportData.add(_divData.getText());
            }

            return reportData;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public String CheckFromListIfElementIsEnabled(String elementXpath) {
        try {
//             Thread.sleep(5000);
            String classAttr;
            String ActiveTab = "";
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement _list : liElement) {
                classAttr = _list.getAttribute("class").split(" ")[1];

                if (classAttr.equals("active")) {
                    ActiveTab = _list.getText();

                    break;
                }
            }

            return ActiveTab;

        } catch (Exception e) {
            System.err.println("Error checking if element is enabled - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public String getADatesFormart() {
        try {
            Calendar calendar = Calendar.getInstance();

            // get a date to represent "today"
            Date today = calendar.getTime();

            // add one day to the date/calendar
            calendar.add(Calendar.DAY_OF_YEAR, 1);

            // now get "tomorrow"
            Date tomorrow = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-YYYY");
            // print out tomorrow's date
            System.out.println("tomorrow is: " + dateFormat.format(tomorrow));

            return dateFormat.format(tomorrow);

        } catch (Exception e) {
            System.err.println("Error checking tomorrow weekday - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }

    }

    public String CheckingTommorowsDate() {
        try {
            // get a calendar instance, which defaults to "now"
            Calendar calendar = Calendar.getInstance();

            // get a date to represent "today"
            Date today = calendar.getTime();

            // add one day to the date/calendar
            calendar.add(Calendar.DAY_OF_YEAR, 1);

            // now get "tomorrow"
            Date tomorrow = calendar.getTime();

            // print out tomorrow's date
            System.out.println("tomorrow is: " + tomorrow.toString());

            return tomorrow.toString();

        } catch (Exception e) {
            System.err.println("Error checking tomorrow weekday - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public int getNumberOfRowsInsideAtable(String elementXpath) {
        String streamClicked = "";
        try {
            System.out.println("[Info]Clicking stream actions from  - " + elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            return liElement.size();

        } catch (Exception e) {
            System.err.println("[Error] Failed to click stream actions by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return 0;
        }

    }

    public List<String> GetListItemsByXpath(String elementXpath) {
        List<String> TableData = new ArrayList<>();

        try {
            Thread.sleep(8000);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                if (!Element.getText().isEmpty()) {
                    TableData.add(Element.getText());
                }

            }

            return TableData;

        } catch (Exception e) {
            System.err.println("[Error]Failed reading elements by xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }

    }

    public Integer GetListSizeByXpath(String elementXpath) {

        try {
            Thread.sleep(8000);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            return liElement.size();

        } catch (Exception e) {
            System.err.println("[Error]Failed reading elements by xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }

    }

    public List<String> ReturnListInsideATable(String elementXpath) {

        try {
            Thread.sleep(8000);
            List<String> TableData = new ArrayList<>();
            String TableList = "";
            this.waitForElementByXpath(elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                List<WebElement> TableElement = Element.findElements(By.tagName("tr"));
                for (WebElement Elements : TableElement) {
                    if (!Elements.getText().equals("")) {
                        TableData.add(Elements.getText());
                    }

                }
                break;
            }

            return TableData;

        } catch (Exception e) {
            System.err.println("[Error] failed to click first element on a list - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }

    }

    public boolean ClickListItemAtAnIndex(String elementXpath, int rowNum) {

        int counter = 0;

        List<String> TableData = new ArrayList<>();

        try {
            Thread.sleep(5000);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                if (counter == rowNum) {
                    Element.click();
                    break;
                }
                counter++;
            }

            return true;

        } catch (Exception e) {
            System.err.println("[Error] row number where a status is found inside a table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

    }

    public int ReturnStreamNumberInsideATable(String elementXpath, String Stream) {

        try {
            Thread.sleep(8000);
            List<String> TableData = new ArrayList<>();
            int count = 0;
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                List<WebElement> TableElement = Element.findElements(By.tagName("h5"));
                for (WebElement Elements : TableElement) {
                    if (!Elements.getText().equals(Stream)) {
                        return count;
                    }
                    count++;

                }
                break;
            }

        } catch (Exception e) {
            System.err.println("[Error] failed to click first element on a list - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

        }
        return 0;
    }

    public boolean ClickListItemAtAnIndex(String elementXpath) {

        try {

            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                Element.click();
                break;

            }

            return true;

        } catch (Exception e) {
            System.err.println("[Error] failed to click first element on a list - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

    }

    public List<String> getAssetOrDriverDetailsAndHeardersListOnGrid(String elementXpath, String tableHeaderXpath) {
        List<String> gridData = new ArrayList<>();
        List<String> gridDataWithHeaders = new ArrayList<>();
        try {

            List<String> reportData = new ArrayList<>();
            String columHeaders = "";

            this.takeScreenShot("TableList", false);
            reportData = new ArrayList<>();
            waitForElementByXpath(elementXpath, 13000);
            WebElement mainTable = Driver.findElement(By.xpath(elementXpath));

            List<WebElement> tableRows = mainTable.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
            //Get Headers

            List<WebElement> tableHeader = Driver.findElements(By.xpath(tableHeaderXpath));
            for (WebElement _tableHeader : tableHeader) {
                if (!_tableHeader.getText().equals("")) {
                    columHeaders += _tableHeader.getText() + "#";
                }
            }

            //Get table data
            boolean empty = true;
            for (WebElement _tableRows : tableRows) {
                List<WebElement> rows = _tableRows.findElements(By.tagName("td"));
                String value = "";
                for (int i = 1; i <= rows.size(); i++) {
                    try {
                        value += rows.get(i).getText() + "#";
                    } catch (Exception e) {
                        //value += rows.get(i).findElement(By.tagName("a")).getText()+"#";
                    }
                }
                reportData.add(value);
            }

            gridData.addAll(reportData);

            gridDataWithHeaders.add(columHeaders);
            gridDataWithHeaders.addAll(gridData);
            return gridDataWithHeaders;
        } catch (Exception e) {
            System.err.println("Error reading data from grid - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

            return gridData;
        }

    }

    public boolean clickElementOnListByXpath(String elementXpath, int elementNum) {
        try {
            System.out.println("[INFO] Clicking element in list by Xpath : " + elementXpath);
            waitForElementByXpath(elementXpath);
            WebDriverWait wait = new WebDriverWait(Driver, ApplicationConfig.WaitTimeout());
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
            List<WebElement> elementToClick = Driver.findElements(By.xpath(elementXpath));
            elementToClick.get(elementNum).click();

            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element in list by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String clickElementOnListAndReturnTextByXpath(String elementXpath, int elementNum) {
        try {
            System.out.println("[INFO] Clicking element and returning in list by Xpath : " + elementXpath);
            waitForElementByXpath(elementXpath);
            WebDriverWait wait = new WebDriverWait(Driver, ApplicationConfig.WaitTimeout());
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
            List<WebElement> elementToClick = Driver.findElements(By.xpath(elementXpath));
            elementToClick.get(elementNum).click();

            return elementToClick.get(elementNum).getText();
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element in list and return text by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return "";
        }
    }

    public String ReturnListNotEqualTOAColour(String elementXpath, String Colour) {

        try {
            Thread.sleep(8000);
            String TableData = "";
            int count = 0;
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                String css = Element.getCssValue("color");
                if (!Element.getCssValue("color").equals(Colour)) {
                    TableData += Element.getText();
                }

            }

            return TableData;

        } catch (Exception e) {
            System.err.println("[Error] failed to click first element on a list - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

        }
        return "";
    }

    public List<String> getElementsAttributeValuesByXpath(String elementXpath, String attributeName) {
        String propertyValue = "";
        int Count = 0;
        List<String> ListItems = new ArrayList();

        try {
            this.waitForElementByXpath(elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            for (WebElement Elements : liElement) {

                if (Count < 4) {
                    propertyValue = Elements.findElement(By.tagName("a")).getAttribute(attributeName);
                    if (!propertyValue.equals("")) {
                        ListItems.add(propertyValue);
                    }
                }

                Count++;
            }

        } catch (Exception e) {
            System.err.println("[Error] Finding element by Xpath and retrieving attribute '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

        }

        if (propertyValue == null) {
            propertyValue = "";
        }

        return ListItems;
    }

    public List<String> retrieveListOfEventsTypes(String elementXpath, String tagName) {
        try {
            Thread.sleep(5000);

            List<String> reportData = new ArrayList<>();
//             WebElement element1 = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> element1 = Driver.findElements(By.xpath(elementXpath));

            for (WebElement _divData : element1) {
                int count = 0;
                List<WebElement> divRows = _divData.findElements(By.tagName(tagName));
                for (WebElement tableData : divRows) {
                    if (count == 2) {
                        reportData.add(tableData.getText());
                        break;
                    }
                    count++;
                }

            }

            return reportData;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public List<String> retrieveListOfLocations(String elementXpath, String tagName) {
        try {
            Thread.sleep(5000);

            List<String> reportData = new ArrayList<>();
//             WebElement element1 = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> element1 = Driver.findElements(By.xpath(elementXpath));

            for (WebElement _divData : element1) {
                int count = 0;
                List<WebElement> divRows = _divData.findElements(By.tagName(tagName));
                for (WebElement tableData : divRows) {
                    if (count == 1) {
                        reportData.add(tableData.getText());
                        break;
                    }
                    count++;
                }
            }
            return reportData;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public List<String> retrieveListOfSites(String elementXpath, String tagName) {
        try {
            Thread.sleep(5000);

            List<String> reportData = new ArrayList<>();
//             WebElement element1 = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> element1 = Driver.findElements(By.xpath(elementXpath));

            for (WebElement _divData : element1) {
                int count = 0;
                List<WebElement> divRows = _divData.findElements(By.tagName(tagName));
                for (WebElement tableData : divRows) {
                    if (count == 2) {
                        reportData.add(tableData.getText());
                        break;
                    }
                    count++;
                }
            }
            return reportData;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public List<String> retrieveListOfAssets(String elementXpath, String tagName) {
        try {
            Thread.sleep(5000);

            List<String> reportData = new ArrayList<>();
//             WebElement element1 = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> element1 = Driver.findElements(By.xpath(elementXpath));

            for (WebElement _divData : element1) {
                int count = 0;
                List<WebElement> divRows = _divData.findElements(By.tagName(tagName));
                for (WebElement tableData : divRows) {
                    if (count == 3) {
                        reportData.add(tableData.getText());
                        break;
                    }
                    count++;
                }
            }
            return reportData;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public List<String> retrieveListOfLocationsTypes(String elementXpath, String tagName) {
        try {
            Thread.sleep(5000);

            List<String> reportData = new ArrayList<>();
//             WebElement element1 = Driver.findElement(By.xpath(elementXpath));
            List<WebElement> element1 = Driver.findElements(By.xpath(elementXpath));

            for (WebElement _divData : element1) {
                int count = 0;
                List<WebElement> divRows = _divData.findElements(By.tagName(tagName));
                for (WebElement tableData : divRows) {
                    if (count == 2) {
                        reportData.add(tableData.getText());
                        break;
                    }
                    count++;
                }
            }
            return reportData;
        } catch (Exception e) {
            System.err.println("Error reading transaction from table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public boolean clickAndHoldElementByXpath(String elementXpath) {
        try {
            System.out.println("[Info]Performing click and hold for element - " + elementXpath);
            this.waitForElementByXpath(elementXpath);
            WebElement sourceElement = Driver.findElement(By.xpath(elementXpath));
            Actions builder = new Actions(Driver);
            builder.click(sourceElement);
            builder.clickAndHold(sourceElement);
            builder.perform();
            return true;

        } catch (Exception e) {
            System.err.println("[Error] Failed to perform click and hold element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean releaseHoldElementByXpath(String elementXpath) {
        try {
            System.out.println("[Info]Performing release for element - " + elementXpath);
            this.waitForElementByXpath(elementXpath);
            WebElement releaseElement = Driver.findElement(By.xpath(elementXpath));
            Actions builder = new Actions(Driver);
            builder.moveToElement(releaseElement).perform();
            builder.perform();
            Thread.sleep(2000);
            builder.release(releaseElement);
            builder.perform();
            return true;

        } catch (Exception e) {
            System.err.println("[Error] Failed to perform release element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean moveToElementTwiceByXpath(String elementXpath) {
        try {
            Actions moveTo = new Actions(Driver);
            moveTo.moveToElement(Driver.findElement(By.xpath(elementXpath)));
            moveTo.perform();
            moveTo.moveToElement(Driver.findElement(By.xpath(elementXpath)));
            moveTo.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error moving to element - " + elementXpath + " - " + e.getStackTrace());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean moveToElementUsingJavasciptByXpath(String elementXpath) {
        Actions moveTo = new Actions(Driver);
        WebElement element = Driver.findElement(By.xpath(elementXpath));
        try {
            //String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";

            JavascriptExecutor js = (JavascriptExecutor) Driver;
            //js.executeScript(mouseOverScript, element); 
            js.executeScript("arguments[0].onmouseover()", element);
            moveTo.moveToElement(element).build().perform();
            // moveTo.moveToElement(element,0,0).build ().perform();

            return true;
        } catch (Exception e) {
            moveTo.moveToElement(element).build().perform();
            System.err.println("Error moving to element - " + elementXpath + " - " + e.getStackTrace());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public int CheckTableRowStatus(String elementXpath, String Status) {
        String TdText = "";
        int counter = 0;
        boolean found = false;
        List<String> TableData = new ArrayList<>();

        try {
            Thread.sleep(5000);
            System.out.println("[Info]  row number where a status is foundinside a table - " + elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            String type = "";

            for (WebElement Element : liElement) {
                List<WebElement> td = Element.findElements(By.tagName("td"));
                for (WebElement tdElement : td) {

                    if (tdElement.getText().equals("Job")) {
                        type = tdElement.getText();
                    }

                    if (tdElement.getText().equals(Status) && type.equals("Job")) {
                        found = true;
                        break;
                    }

                }

                type = "";

                if (found) {
                    break;
                }
                counter++;
            }

            return counter;

        } catch (Exception e) {
            System.err.println("[Error] row number where a status is found inside a table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return 0;
        }

    }

    public List<String> ReturnListInsideATableR(String elementXpath) {

        try {
//            Thread.sleep(8000);
            List<String> TableData = new ArrayList<>();
            String TableList = "";
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                if (!Element.getText().equals("")) {
                    TableData.add(Element.getText());
                }

            }

            return TableData;

        } catch (Exception e) {
            System.err.println("[Error] failed to click first element on a list - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }

    }

    public boolean DoubleClickListItemAtAnIndex(String elementXpath) {
        try {
            Actions act = new Actions(Driver);
            Thread.sleep(8000);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                act.doubleClick(Element).perform();
                break;
            }

            return true;

        } catch (Exception e) {
            System.err.println("[Error] failed to click first element on a list - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

    }

    public boolean CheckColumnChooserList(String elementXpath, String columnToChooseXpath) {
        try {
            //System.out.println("[INFO] Clicking element by Xpath : " + elementXpath);
            waitForElementByXpath(elementXpath);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            waitForElementByXpath(columnToChooseXpath);
            WebElement colToClick = Driver.findElement(By.xpath(columnToChooseXpath));
            try {
                colToClick.findElement(By.tagName("i"));
            } catch (Exception ex) {
                colToClick.click();

                return true;
            }
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean CheckColumnChooserList(String elementXPath) {
        try {
            waitForElementByXpath(elementXPath);

            WebElement elementToClick = Driver.findElement(By.xpath(elementXPath));

            try {
                elementToClick.findElement(By.tagName("i"));
            } catch (Exception ex) {
                elementToClick.click();

                return true;
            }

            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean selectColumnChooserList(String elementXPath) {
        try {
            waitForElementByXpath(elementXPath);

            WebElement elementToClick = Driver.findElement(By.xpath(elementXPath));

            try {
                WebElement icon = elementToClick.findElement(By.tagName("i"));

                if (icon.getAttribute("style").contains("none")) {
                    elementToClick.click();
                } else {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }

            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean selectPassengerColumnChooserList(String elementXpath, String columnToChooseXpath) {
        try {
            System.out.println("[INFO] Selecting Passenger Column element by Xpath : " + columnToChooseXpath);
            waitForElementByXpath(elementXpath);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            if (!waitForElementByXpath(columnToChooseXpath, 4)) {
                elementToClick.click();
            }
            WebElement colToClick = Driver.findElement(By.xpath(columnToChooseXpath));
            try {
                WebElement icon = colToClick.findElement(By.tagName("i"));
                if (icon.getAttribute("style").contains("none")) {
                    colToClick.click();
                }
                return true;
            } catch (Exception ex) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("[Error] Failed to Selecting Passenger Column element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean selectMixRoviConfigColumnChooserList(String elementXpath, String columnToChooseXpath) {
        try {
            System.out.println("[INFO] Selecting Passenger Column element by Xpath : " + columnToChooseXpath);
            waitForElementByXpath(elementXpath);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            if (!waitForElementByXpath(columnToChooseXpath, 4)) {
                elementToClick.click();
            }
            WebElement colToClick = Driver.findElement(By.xpath(columnToChooseXpath));
            try {
                WebElement icon = colToClick.findElement(By.tagName("i"));
                if (icon.getAttribute("style").contains("none")) {
                    colToClick.click();
                }
                return true;
            } catch (Exception ex) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("[Error] Failed to Selecting Passenger Column element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String getElementLocationAndClickByXpath(String divXpath, String iconXpath) {

        try {
            System.out.println("[INFO] Getting location and clicking element by Xpath - " + iconXpath);
            Point p;
            this.waitForElementByXpath(iconXpath, 10);
            this.waitForElementByXpath(divXpath, 10);

            int divX = 0;
            int divY = 0;
            int assetX = 0;
            int assetY = 0;
            //getting location of the div
            WebElement div = Driver.findElement((By.xpath(divXpath)));
            Point divPoints = div.getLocation();
            divX = divPoints.getX();
            divY = divPoints.getY();

            //getting the location of the asset/InnerItem
            WebElement icon = Driver.findElement((By.xpath(iconXpath)));
            Point innerLoc = icon.getLocation();
            assetX = innerLoc.getX();
            assetY = innerLoc.getY();

            //get location of innerItem in respective to the outerItem
            int centerY = assetY - divY;
            int centerX = assetX - divX;

            p = new Point(centerX, centerY);

            //Click element
            Actions action = new Actions(Driver);
            action.moveToElement(div, centerX, centerY).click().build().perform();

            return p.toString();
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return " ";
        }
    }

    public boolean getElementLocationAndMoveToByXpath(String divXpath, String iconXpath) {

        try {
            System.out.println("[INFO] Getting location and moving element by Xpath - " + iconXpath);
            Point p;
            this.waitForElementByXpath(iconXpath, 10);
            this.waitForElementByXpath(divXpath, 10);

            int divX = 0;
            int divY = 0;
            int assetX = 0;
            int assetY = 0;
            //getting location of the div
            WebElement div = Driver.findElement((By.xpath(divXpath)));
            Point divPoints = div.getLocation();
            divX = divPoints.getX();
            divY = divPoints.getY();

            //getting the location of the asset/InnerItem
            WebElement icon = Driver.findElement((By.xpath(iconXpath)));
            Point innerLoc = icon.getLocation();
            assetX = innerLoc.getX();
            assetY = innerLoc.getY();

            //get location of innerItem in respective to the outerItem
            int centerY = assetY - divY;
            int centerX = assetX - divX;

            p = new Point(centerX, centerY);

            //Click element
            Actions action = new Actions(Driver);
            action.moveToElement(div, centerX, centerY).build().perform();

            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to getting location and moving element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public List<String> getEventsAndHeardersListOnGrid(String elementXpath, String _numberOfPages, String nextPageXpath) {
        List<String> gridData = new ArrayList<>();
        List<String> gridDataWithHeaders = new ArrayList<>();
        try {
            int pages = 1;
            int numberOfPages = 1;
            List<String> reportData = new ArrayList<>();
            waitForElementByXpath(_numberOfPages);
            //Get number of pages.
            String numOfPages = Driver.findElement(By.xpath(_numberOfPages)).getText();
            if (!numOfPages.equals("")) {
                numberOfPages = Integer.parseInt(numOfPages);
            }
            String columHeaders = "";
            while (pages <= numberOfPages) {
                this.takeScreenShot("EventListPage" + pages, false);
                reportData = new ArrayList<>();
                waitForElementByXpath(elementXpath, 13000);
                //waitForElementByXpathToStaleness(elementXpath);
                WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));
                List<WebElement> divColumns = mainDiv.findElements(By.className("column"));
                //iterate through div list
                for (WebElement _divColumns : divColumns) {
                    String innerColumnsHeader = _divColumns.findElement(By.tagName("span")).getText();

                    if (!innerColumnsHeader.equals("")) {
                        //Adding method to use
                        //Get column headers
                        if (!columHeaders.contains(innerColumnsHeader)) {
                            columHeaders += innerColumnsHeader + "#";
                        }
                        boolean empty = false;
                        if (reportData.size() <= 0) {
                            empty = true;
                        }
                        if (innerColumnsHeader.equals("Event name")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.tagName("a"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else if (innerColumnsHeader.equals("Last edit time")) {
                            //iterate through rows.
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                //Convert date to match the one on trip details
                                String timeZone = "";
                                String newDate = "";
                                if (!rows.get(i).getText().equals("")) {
                                    String dateSub = rows.get(i).getText().substring(0, 10);
                                    String timeSub = rows.get(i).getText().substring(11, 19);
                                    timeZone = rows.get(i).getText().substring(21, 24).trim();
                                    String[] dateSlipted = dateSub.split("-");
                                    newDate = dateSlipted[2] + "-" + this.getMonthAbr(Integer.parseInt(dateSlipted[1])) + "-" + dateSlipted[0];
                                }
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + newDate + "#" + timeZone;
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        } else {
                            List<WebElement> rows = _divColumns.findElements(By.className("cell"));
                            for (int i = 0; i < rows.size(); i++) {
                                if (empty == false) {
                                    String value = reportData.get(i) + "#" + rows.get(i).getText();
                                    reportData.set(i, value);
                                } else {
                                    reportData.add(rows.get(i).getText());
                                }
                            }
                        }
                    }
                }
                //move to next page
                pages++;
                if (pages <= numberOfPages) {
                    this.clickElementbyXpath(nextPageXpath);
                    this.waitForElementByXpath(elementXpath);
                }

                gridData.addAll(reportData);
            }
            gridDataWithHeaders.add(columHeaders);
            gridDataWithHeaders.addAll(gridData);
            return gridDataWithHeaders;
        } catch (Exception e) {
            System.err.println("Error reading EventList from grid - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

            return gridData;
        }

    }

    public boolean moveToElementByXpathAndJavaScript(String elementXpath) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Driver;
//            js.executeScript("onmouseover=menus['0'].exec('0',2)");
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            Thread.sleep(1000);
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');"
                    + "evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) "
                    + "{ arguments[0].fireEvent('onmouseover');}";
            ((JavascriptExecutor) Driver).executeScript(mouseOverScript, elementToClick);
            Thread.sleep(1000);

            return true;
        } catch (Exception e) {
            System.err.println("Error moving to element - " + elementXpath + " - " + e.getStackTrace());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String checkIfCheckBoxesAreNotCheckedByXpath(String elementXpath) {
        try {
            Thread.sleep(5000);
            int count = 1;
            String checked = "";
            List<String> reportData = new ArrayList<>();

            List<WebElement> divRows = Driver.findElements(By.xpath(elementXpath));

            for (WebElement _divData : divRows) {
                boolean selected = _divData.isSelected();

                if (_divData.isSelected()) {
                    checked += String.valueOf(count) + "*";
                    System.err.println("Error- Element is on row " + checked + " is checked");
                }

                count++;

            }

            return checked;
        } catch (Exception e) {
            System.err.println("Error checking if all checkboxes are checked - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public String checkIfCheckBoxesAreCheckedByXpath(String elementXpath) {
        try {
            Thread.sleep(5000);
            int count = 1;
            String notchecked = "";
            List<String> reportData = new ArrayList<>();

            List<WebElement> divRows = Driver.findElements(By.xpath(elementXpath));

            for (WebElement _divData : divRows) {
                boolean selected = _divData.isSelected();

                if (!_divData.isSelected()) {
                    notchecked += String.valueOf(count) + "*";
                    System.err.println("Error- Element is not checked");
                }
                count++;

            }

            return notchecked;
        } catch (Exception e) {
            System.err.println("Error checking if all checkboxes are checked - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public boolean HoverOverElementByJavaScript(String elementXpath) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Driver;
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            Thread.sleep(5000);
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');"
                    + "evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) "
                    + "{ arguments[0].fireEvent('onmouseover');}";
            Thread.sleep(1000);
            ((JavascriptExecutor) Driver).executeScript(mouseOverScript, elementToClick);
            Thread.sleep(1000);

            return true;
        } catch (Exception e) {
            System.err.println("Error moving to element - " + elementXpath + " - " + e.getStackTrace());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean HoverOverElementByXpathAndJavaScript(String elementXpath) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) Driver;
//            js.executeScript("onmouseover=menus['0'].exec('0',2)");
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            Thread.sleep(5000);
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');"
                    + "evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) "
                    + "{ arguments[0].fireEvent('onmouseover');}";
            Thread.sleep(1000);
            ((JavascriptExecutor) Driver).executeScript(mouseOverScript, elementToClick);
            Thread.sleep(1000);

//            Actions moveTo = new Actions(Driver);
//            moveTo.moveToElement(Driver.findElement(By.xpath(elementXpath)));
//            moveTo.perform();
            return true;
        } catch (Exception e) {
            System.err.println("Error moving to element - " + elementXpath + " - " + e.getStackTrace().toString());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public List<String> ReturnTableRowDataForTables(String elementXpath) {
        List<String> TableData = new ArrayList<>();
        try {
            System.out.println("[INFO] Getting table row data for element by Xpath - " + elementXpath);
            this.waitForElementByXpath(elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                List<WebElement> TableElement = Element.findElements(By.tagName("tr"));
                for (WebElement Elements : TableElement) {
                    if (!Elements.getText().equals("")) {
                        TableData.add(Elements.getText());
                    }
                }
            }

            return TableData;

        } catch (Exception e) {
            System.err.println("[Error] Failed to get table row data for element - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            TableData.clear();
            return TableData;
        }

    }

    public boolean isCheckBoxSelected(String elementXPath) {
        waitForElementByXpath(elementXPath);
        WebElement isSelected = Driver.findElement(By.xpath(elementXPath));

        return isSelected.isSelected();
    }

    public String getElementsLocation(String mapDivXpath, String iconXpath) {

        try {

            this.waitForElementByXpath(iconXpath);

            int divX = 0;
            int divY = 0;
            int assetX = 0;
            int assetY = 0;
            String points = "";
            Point p = new Point(assetX, assetY);
            //getting location of the div
            WebElement div = Driver.findElement((By.xpath(mapDivXpath)));
            Point divPoints = div.getLocation();
            divX = divPoints.getX();
            divY = divPoints.getY();

            //getting the location of the asset/InnerItem
            List<WebElement> TableElement = Driver.findElements(By.xpath(iconXpath));

            for (WebElement Elements : TableElement) {
                Point innerLoc = Elements.getLocation();
                assetX = innerLoc.getX();
                assetY = innerLoc.getY();

                //get location of innerItem in respective to the outerItem
                int centerY = assetY - divY;
                int centerX = assetX - divX;

                p = new Point(centerX, centerY);
                points = p.toString();
            }

//            Actions action = new Actions(Driver);
//            action.moveToElement(div, centerX, centerY).click().build().perform();
            return points;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return " ";
        }
    }

    public void setScreenResolution() {
        try {
            Driver.manage().window().setSize(new Dimension(1024, 768));
        } catch (Exception e) {
            System.err.println("[Error] Failed to set screen resolution - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
    }

    public void setScreenResolution(int width, int height) {
        try {
            Driver.manage().window().setSize(new Dimension(width, height));
        } catch (Exception e) {
            System.err.println("[Error] Failed to set screen resolution - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
    }

    public int getWindowHeight() {
        int height = 0;
        try {
            height = Driver.manage().window().getSize().getHeight();
        } catch (Exception e) {
            System.err.println("[Error] Failed to get window height - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }

        return height;
    }

    public int getWindowWidth() {
        int width = 0;
        try {
            width = Driver.manage().window().getSize().getWidth();
        } catch (Exception e) {
            System.err.println("[Error] Failed to get window width - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }

        return width;
    }

    public String SwitchToNewWindow() {
        // get the current window handle
        String parentHandle = SeleniumDriverInstance.Driver.getWindowHandle();
        while (parentHandle.equalsIgnoreCase(SeleniumDriverInstance.Driver.getWindowHandle())) {
            for (String winHandle : SeleniumDriverInstance.Driver.getWindowHandles()) {

                // switch focus of WebDriver to the next found window handle (that's your newly opened window)
                SeleniumDriverInstance.Driver.switchTo().window(winHandle);
            }

        }

        return parentHandle;
    }

    public void SwitchToOriginalWindow(String parentHandle) {
        parentHandle = SwitchToNewWindow();

        SeleniumDriverInstance.Driver.close(); // close newly opened window when done with it
        SeleniumDriverInstance.Driver.switchTo().window(parentHandle); // switch back to the original window
        //String winHandleBefore = SeleniumDriverInstance.Driver.getWindowHandle();

        // Switch back to original browser (first window)
        // SeleniumDriverInstance.Driver.switchTo().window(winHandleBefore);
    }

    public String CheckColourfElement(String elementXpath, String CssValue) {

        try {
            Thread.sleep(8000);

            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));

            String css = elementToClick.getCssValue(CssValue);
            return css;

        } catch (Exception e) {
            System.err.println("[Error] failed to click first element on a list - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

        }

        return "";
    }

    public String GetElementTagName(String elementXpath) {

        try {
            Thread.sleep(8000);

            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));

            String css = elementToClick.getAttribute("class");
            return css;

        } catch (Exception e) {
            System.err.println("[Error] failed to click first element on a list - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

        }

        return "";
    }

    public boolean HoverOverOneElementFromAlistByJavaScript(String elementXpath) {
        try {
//           DesiredCapabilities capabilities=new DesiredCapabilities();
//           capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
//           capabilities.setCapability("browserstack.ie.enablePopups", "true");
//           
//           Boolean isSet = capabilities.isJavascriptEnabled();

            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            String type = "";

            for (WebElement Element : liElement) {
                JavascriptExecutor js = (JavascriptExecutor) Driver;
                Thread.sleep(5000);
                String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');"
                        + "evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) "
                        + "{ arguments[0].fireEvent('onmouseover');}";
                Thread.sleep(1000);
                ((JavascriptExecutor) Driver).executeScript(mouseOverScript, Element);
                Thread.sleep(1000);

                break;
            }

            return true;
        } catch (Exception e) {
            System.err.println("Error moving to element - " + elementXpath + " - " + e.getStackTrace());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean checkIfCheckBoxISCheckedByXpath(String elementXpath) {
        try {
            Thread.sleep(1000);
//            int count = 1;
//            String notchecked = "";
//            List<String> reportData = new ArrayList<String>();

            String checked = "";
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            checked = elementToClick.getAttribute("checked");

            if (checked.equals("")) {
                return false;

            } else if (!elementToClick.isSelected()) {
                return false;
            }
//            count++;
            return true;
        } catch (Exception e) {
            System.err.println("Error checking if all checkboxes are checked - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

    }

    public boolean chcekIfElementIsCheckedByXpath2(String elementXpath) {
        try {
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));

            return elementToClick.isSelected();
        } catch (Exception e) {
            System.err.println("Error checking if all checkboxes are checked - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return false;
    }

    public int ReturnRowNumberForGivenAsset(String elementXpath, String Asset) {
        String TdText = "";
        int counter = 1;
        boolean found = false;
        List<String> TableData = new ArrayList<>();

        try {
            Thread.sleep(5000);
            System.out.println("[Info]  row number where a status is foundinside a table - " + elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            String type = "";

            for (WebElement Element : liElement) {
                List<WebElement> td = Element.findElements(By.tagName("td"));
                for (WebElement tdElement : td) {

                    if (tdElement.getText().equals(Asset)) {
                        found = true;
                        break;
                    }

                }
                if (found) {
                    return counter;
                }

                counter++;
            }

        } catch (Exception e) {
            System.err.println("[Error] row number where a status is found inside a table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

        }
        return 0;
    }

    public boolean moveToElementByXpathOffsetClick(String elementXpath, int x, int y) {

        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            Point coordinates = elementToRead.getLocation();
            Robot robot = new Robot();
            robot.mouseMove(coordinates.getX() + x, coordinates.getY() + 65 + y); //Number 65 should vary
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            Thread.sleep(3000);

            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public boolean moveToElementByXpathRobot(String elementXpath) {

        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            Point coordinates = elementToRead.getLocation();
            Robot robot = new Robot();
            robot.mouseMove(coordinates.getX(), coordinates.getY() + 65); //Number 65 should vary

            Thread.sleep(3000);

            System.out.println("[Info]Successfully moved to element by xpath - " + elementXpath);
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to move to element by xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String moveToElementAndRetrieveTextByXpath(String elementXpath, String Tooltip) {
        try {
            String retrievedText = "";
//            Actions moveTo = new Actions(Driver);
//            moveTo.moveToElement(Driver.findElement(By.xpath(elementXpath)));
//            moveTo.perform();
//            Thread.sleep(2000);

            JavascriptExecutor js = (JavascriptExecutor) Driver;
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            Thread.sleep(5000);
            String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');"
                    + "evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) "
                    + "{ arguments[0].fireEvent('onmouseover');}";
            Thread.sleep(1000);
            ((JavascriptExecutor) Driver).executeScript(mouseOverScript, elementToClick);
            Thread.sleep(1000);

            this.waitForElementByXpath(Tooltip, 1);
            WebElement elementToRead = Driver.findElement(By.xpath(Tooltip));
            retrievedText = elementToRead.getText();
            System.out.println("[Info]Text retrieved successfully from element - " + Tooltip);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("Error moving to element - " + elementXpath + " - " + e.getStackTrace());
            this.DriverExceptionDetail = e.getMessage();
            return "";
        }
    }

    public boolean drop(String elementXpath, String Asset) {
        String TdText = "";
        int counter = 1;
        boolean found = false;
        List<String> TableData = new ArrayList<>();

        try {
            Thread.sleep(5000);
            System.out.println("[Info]  row number where a status is foundinside a table - " + elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            String type = "";

            for (WebElement Element : liElement) {

                if (Element.getText().equals(Asset)) {
                    Element.click();
                    return true;
                }

            }

        } catch (Exception e) {
            System.err.println("[Error] row number where a status is found inside a table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

        }
        return false;
    }

    public boolean enterTextbyXpathUsingActions(String elementXpath, String textToEnter) {
        try {
            this.waitForElementById(elementXpath, 5);
            WebElement elementToTypeIn = Driver.findElement(By.xpath(elementXpath));
            elementToTypeIn.clear();
            Actions typeText = new Actions(Driver);
            typeText.moveToElement(elementToTypeIn);
            typeText.click(elementToTypeIn);
            typeText.sendKeys(elementToTypeIn, textToEnter);
            typeText.click(elementToTypeIn);
            typeText.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error entering text using xpath - " + elementXpath + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public void minimizeBrowserWindow() {
        Driver.manage().window().setPosition(new Point(-2000, 0));
    }

    public void showBrowserWindow() {
        Driver.manage().window().setPosition(new Point(2000, 0));
    }

    public void scrollMouseWheelUpwards() {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) Driver;
            jse.executeScript("javascript:window.scrollBy(250,350)");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.err.println("[Error] Failed to scroll up - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
    }

    public void scrollMouseWheelDownwards() {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) Driver;
            jse.executeScript("window.scrollBy(0,200)", "");
            Thread.sleep(3000);
        } catch (Exception e) {
            System.err.println("[Error] Failed to scroll down - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
    }

    public void closeWindow() {
        Driver.close();
    }

    public void SwitchToOriginalWindowNoClose(String parentHandle) {

        SeleniumDriverInstance.Driver.switchTo().window(parentHandle);

    }

    public String retrieveWindowHandle() {
        return Driver.getWindowHandle();
    }

    public List<String> GeDateFromSpanByXpath(String elementXpath) {
        List<String> TableData = new ArrayList<>();
        int count = 1;
        try {
//            Thread.sleep(8000);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                List<WebElement> date = Element.findElements(By.tagName("span"));
                for (WebElement Elements : date) {
                    String data = Elements.getText();
                    if (!data.equalsIgnoreCase("to")) {
                        TableData.add(Elements.getText());

                    }
                    count++;
                }

                break;

            }

            return TableData;

        } catch (Exception e) {
            System.err.println("[Error]Failed reading elements by xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }

    }

    public List<String> ReturnTextInsideAContainer(String elementXpath) {

        try {
            Thread.sleep(8000);
            List<String> TableData = new ArrayList<>();
            String TableList = "";
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));

            for (WebElement Element : liElement) {
                if (!Element.getText().equals("")) {
                    TableData.add(Element.getText());
                }
                break;

            }

            return TableData;

        } catch (Exception e) {
            System.err.println("[Error] failed to click first element on a list - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }
    }

    public List<String> ReturnRowNumberForAsset(String elementXpath) {

        int counter = 1;
        List<String> TableData = new ArrayList<>();

        try {
            Thread.sleep(7000);
            System.out.println("[Info]  row number where a status is foundinside a table - " + elementXpath);
            List<WebElement> liElement = Driver.findElements(By.xpath(elementXpath));
            String type = "";

            for (WebElement Element : liElement) {
                String txt = "";
                String text = "";
                List<WebElement> td = Element.findElements(By.tagName("td"));
                for (WebElement tdElement : td) {

                    txt = tdElement.getText();

                    if (counter == 1) {
                        text += txt + ": ";
                    }
                    counter++;

                }
                text += txt;
                TableData.add(text);
                counter = 1;

            }

        } catch (Exception e) {
            System.err.println("[Error] row number where a status is found inside a table - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

        }
        return TableData;
    }

    public boolean unCheckBoxesThatAreCheckedByXpath(String elementXpath) {
        try {
            Thread.sleep(5000);
            int count = 1;
            String notchecked = "";
            List<String> reportData = new ArrayList<>();

            List<WebElement> divRows = Driver.findElements(By.xpath(elementXpath));

            for (WebElement _divData : divRows) {

                if (_divData.isSelected()) {
                    _divData.click();
                }

            }

            return true;
        } catch (Exception e) {
            System.err.println("Error checking if all checkboxes are checked - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public String getElementAttribute(String elementXpath, String attributeName) {
        String propertyValue = "";
        try {
            this.waitForElementByXpath(elementXpath);

            WebElement elementToTypeIn = Driver.findElement(By.xpath(elementXpath));

            //propertyValue = elementToTypeIn.getAttribute(attributeName);
            propertyValue = Driver.findElement(By.xpath(elementXpath)).getAttribute(attributeName);

        } catch (Exception e) {
            System.err.println("[Error] Finding element by Xpath and retrieving attribute '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

        }

        if (propertyValue == null) {
            propertyValue = "";
        }

        return propertyValue;
    }

    public String getTextFromAnInputByXpath(String elementXpath, String textToGet) {
        String retrievedText = "";
        try {

            this.waitForElementByXpath(elementXpath, 2);
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));

            retrievedText = elementToRead.getAttribute(textToGet);
            System.out.println("[Info]Text retrieved successfully from element an Input - " + elementXpath);
            return retrievedText;

        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element an Input by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public boolean selectMixRoviConfigGroupColumnChooserList(String elementXpath, String columnToChooseXpath) {
        try {
            System.out.println("[INFO] Selecting Mix Rovi Config Group Colum element by Xpath : " + columnToChooseXpath);
            waitForElementByXpath(elementXpath);
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            if (!waitForElementByXpath(columnToChooseXpath, 4)) {
                elementToClick.click();
            }
            WebElement colToClick = Driver.findElement(By.xpath(columnToChooseXpath));
            try {
                WebElement icon = colToClick.findElement(By.tagName("i"));
                if (icon.getAttribute("style").contains("display: none;")) {
                    colToClick.click();
                }
                return true;
            } catch (Exception ex) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("[Error] Failed to Selecting Passenger Column element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public void clearUsingBackSpace(String elementXpath) {
        try {
            this.waitForElementByXpath(elementXpath);
            WebElement elementToErase = Driver.findElement(By.xpath(elementXpath));
            elementToErase.sendKeys(Keys.BACK_SPACE);
        } catch (Exception e) {
            System.err.println("Error clearing text - " + elementXpath + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
    }

    public boolean compareTwoValues(String value1, String Value2) {

        boolean valuesEqual = false;
        try {

            if (value1.equals(Value2)) {
                System.out.println("[Info] the two values are equal");
                valuesEqual = true;
            }

        } catch (Exception e) {
            System.err.println("[Error] The two values are not equal" + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }

        return valuesEqual;
    }

    public String retrieveElementTypeByXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);

            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            Point coordinates = elementToRead.getLocation();
            Robot robot = new Robot();
            robot.mouseMove(coordinates.getX(), coordinates.getY() + 65); //Number 65 should vary
            Thread.sleep(3000);
            retrievedText = elementToRead.getAttribute("type");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    public boolean checkIfRadioButtonISCheckedByXpath(String elementXpath) {
        try {
            Thread.sleep(1000);
            int count = 1;
            String notchecked = "";
            List<String> reportData = new ArrayList<>();

            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));

            boolean selected = elementToClick.isSelected();

            if (elementToClick.isSelected()) {
                return true;
            }
            count++;
        } catch (Exception e) {
            System.err.println("Error checking if all checkboxes are checked - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return false;
    }

    public void PressKey(String ENTER) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Get The Parent Element Of A Starting Element
    //@gjansen
    public WebElement GetParentElementByXpath(String elementXpath, int numberOfLevelsToGoUp) {
        try {

            WebElement startingElement = SeleniumDriverInstance.Driver.findElement(By.xpath(elementXpath));
            WebElement currentParent;
            WebElement newParent;

            currentParent = startingElement.findElement(By.xpath(".."));

            if (numberOfLevelsToGoUp > 1) {
                for (int i = 0; i < numberOfLevelsToGoUp; ++i) {
                    newParent = currentParent.findElement(By.xpath(".."));
                    currentParent = newParent;
                }
            }

            return currentParent;
        } catch (Exception e) {
            System.err.println("Error Getting Parent Element- " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return null;
        }

    }

    //Generates The Absolute Xpath Of An Element At Runtime
    //@gjansen
    public String GetElementXpath(WebElement childElement, String current) {
        try {
            String childTag = childElement.getTagName();
            if (childTag.equals("html")) {
                return "/html[1]" + current;
            }
            WebElement parentElement = childElement.findElement(By.xpath(".."));
            List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
            int count = 0;
            for (int i = 0; i < childrenElements.size(); i++) {
                WebElement childrenElement = childrenElements.get(i);
                String childrenElementTag = childrenElement.getTagName();
                if (childTag.equals(childrenElementTag)) {
                    count++;
                }
                if (childElement.equals(childrenElement)) {
                    return GetElementXpath(parentElement, "/" + childTag + "[" + count + "]" + current);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed To Get Element Xpath");
            return "";
        }
        return "";
    }

    // Click using javascript by Xpath
    // @gjansen
    public boolean clickElementByXpathUsingJavascript(String elementXpath) {
        try {
            WebElement element = Driver.findElement(By.xpath(elementXpath));
            JavascriptExecutor executor = (JavascriptExecutor) Driver;
            executor.executeScript("arguments[0].click();", element);
            Thread.sleep(2000);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to click Element by Xpath using Javascript " + e.getMessage());
            return false;
        }
    }

    public boolean waitForElementByXpathUsingJavascript(String elementXpath) {
        try {
            //WebElement element = Driver.findElement(By.xpath(elementXpath));
            JavascriptExecutor executor = (JavascriptExecutor) Driver;

            executor.executeScript("document.getElementByXpath('" + elementXpath + "').click();");

            //executor.executeScript("arguments[0].click();", element);
            Thread.sleep(2000);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to click Element by Xpath using Javascript " + e.getMessage());
            return false;
        }
    }

    public boolean SearchAndClickDVTAutomation(String elementXpath) {
        WebElement element = null;
        try {
            waitForElementByXpath(elementXpath);

            List<WebElement> elements = Driver.findElements(By.xpath(elementXpath));

            if (elements.size() > 1) {
                element = elements.get(1);

            } else {
                element = Driver.findElement(By.xpath(elementXpath));
            }

            element.click();
            return true;
        } catch (Exception e) {
            System.out.println("Failed to click Element by Xpath using Javascript " + e.getMessage());
            return false;
        }
    }

    public boolean SearchAndClickDVTAutomation(String elementXpath, int elementIndex) {
        WebElement element = null;
        try {
            waitForElementByXpath(elementXpath);

            List<WebElement> elements = Driver.findElements(By.xpath(elementXpath));

            if (elements.size() > 1) {

                element = elements.get(elementIndex);

                element = elements.get(elementIndex);

            } else {
                element = Driver.findElement(By.xpath(elementXpath));
            }

            element.click();
            return true;
        } catch (Exception e) {
            System.out.println("Failed to click Element by Xpath using it's index" + e.getMessage());
            return false;
        }
    }

    public boolean SearchAndSelectFromDropDown(String elementXpath, String textToSelectFromDropDown, int index) {
        Select element = null;
        try {
            waitForElementByXpath(elementXpath);

            List<WebElement> elements = Driver.findElements(By.xpath(elementXpath));

            if (elements.size() > 1) {
                element = new Select(elements.get(index));
            } else {
                element = new Select(Driver.findElement(By.xpath(elementXpath)));
            }

            element.selectByVisibleText(textToSelectFromDropDown);
            return true;
        } catch (Exception e) {
            System.out.println("Failed to select from Drop down by Xpath using it's index" + e.getMessage());
            return false;
        }
    }

    // Gets A List Of Text From Mulitple Elements That Share The Same Xpath
    // @gjansen
    public List<String> getListOfElementsTextByXpath(String elementsXpath) {
        List<WebElement> elements = Driver.findElements(By.xpath(elementsXpath));
        List<String> eleText = new ArrayList();

        for (WebElement e : elements) {
            eleText.add(e.getText());
        }

        return eleText;
    }

    // Gets A List Of Text From Mulitple Elements That Share The Same Xpath
    // @gjansen
    public List<String> getListOfElementsTextByXpathLettersOnly(String elementsXpath) {
        List<WebElement> elements = Driver.findElements(By.xpath(elementsXpath));
        List<String> eleText = new ArrayList();
        String text = "";

        for (WebElement e : elements) {
            text = e.getText();
            text = text.replaceAll("[^a-zA-Z]", "");
            eleText.add(text);
        }

        return eleText;
    }

    // Gets A List Of Styles From Multiple Elements That Share The Same Xpath
    // @gjansen
    public List<String> getListOfElementsStyleByXpath(String elementXpath) {
        List<WebElement> elements = Driver.findElements(By.xpath(elementXpath));
        List<String> styles = new ArrayList();

        for (WebElement e : elements) {
            styles.add(e.getAttribute("style"));
        }

        return styles;
    }

    // Checks If All Related Elements Are Disabled, Returning True If Thats The Case
    // @gjansen
    public boolean checkIfAllElementsAreDisabledByXpath(String elementsXpath) {
        List<WebElement> elements = Driver.findElements(By.xpath(elementsXpath));

        boolean allDisabled = true;

        while (allDisabled == true) {
            for (WebElement e : elements) {
                if (!(e.getAttribute("disabled").contains("true"))) {
                    allDisabled = false;
                }
            }
        }

        return allDisabled;
    }

    // Checks If Element Is Disabled, Returning True If Thats The Case
    // @gjansen
    public boolean checkIfElementIsDisabledByXpathNoWait(String elementXpath) {
        WebElement element = Driver.findElement(By.xpath(elementXpath));

        boolean allDisabled = true;
        if (element.getAttribute("disabled") != null) {
            if (!(element.getAttribute("disabled").contains("true"))) {
                allDisabled = false;
            }
        } else {
            allDisabled = false;
        }

        return allDisabled;
    }

    // Switch To Iframe By Xpath
    // @gjansen
    public boolean switchToIframeByXpath(String elementXpath) {
        try {
            SeleniumDriverInstance.Driver.switchTo().frame(SeleniumDriverInstance.Driver.findElement(By.xpath(elementXpath)));
        } catch (Exception e) {
            System.out.println("Failed To Switch To Iframe");
            return false;
        }

        return true;
    }

    // Switch Tabs
    // @gjansen
    public boolean pressControlTab() {
        try {
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_CONTROL);

        } catch (Exception e) {
            System.err.println("Failed to close current tab - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

        return true;
    }

    // Click All Related Elements By Xpath
    // @gjansen
    public boolean ClickAllElementByXpath(String elementXpath) {
        try {
            List<WebElement> elements = Driver.findElements(By.xpath(elementXpath));
            String xpath = "";
            for (WebElement ele : elements) {
                xpath = SeleniumDriverInstance.GetElementXpath(ele, "");

                SeleniumDriverInstance.waitForElementByXpath(xpath);

                SeleniumDriverInstance.clickElementbyXpath(xpath);
            }
        } catch (Exception e) {
            System.out.println("Failed To Click Elements");
            return false;
        }

        return true;
    }

    // Method to hover over an element to get the tooltip - clickand hold button (button must be enabled) to get tooltip
    // @sjonck
    public boolean ClickAndHold(String XPath) {
        try {
            By by = By.xpath(XPath);
            Actions action = new Actions(SeleniumDriverInstance.Driver);
            WebElement elem = SeleniumDriverInstance.Driver.findElement(by);
            action.clickAndHold(elem).build().perform();
            this.sleep(4);
        } catch (Exception E) {
            System.out.println(E);
            return false;
        }
        return true;
    }

    // Release button that was previously clicked and held - button gets 'clicked' when its released
    // If button is not released, an error will appear that no other actions can be done on this specific button
    // @sjonck
    public boolean ClickHoldRelease(String XPath) {
        //you need to release the control from the test
        try {
            By by = By.xpath(XPath);
            Actions actions = new Actions(SeleniumDriverInstance.Driver);
            WebElement elem = SeleniumDriverInstance.Driver.findElement(by);
            actions.moveToElement(elem);
            actions.release().build().perform();
        } catch (Exception E) {
            System.out.println(E);
            return false;
        }
        return true;
    }

    // @sjonck
    public boolean sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            return false;
        }
        return true;
    }

    //Click on x and y coordinates inside map, then drag circle outwards
    //@cpetersen
    public boolean ClickOnPointInMapAndDrag(String elementXpath, int x, int y) {
        try {
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            Actions action = new Actions(Driver);
            action.moveToElement(elementToRead).build().perform();
            action.clickAndHold().build().perform();
            action.moveByOffset(x, y).build().perform();
            Thread.sleep(2000);
            action.release().build().perform();
            System.out.println("[Info] Element Successfully Clicked and Dragged- " + elementXpath);
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to Click And Drag On Element - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

    }

    //maso 
    public boolean moveToMapElementUsingRobot(String elementXpath, int x, int y) {
        try {
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            Actions action = new Actions(Driver);
            action.moveToElement(elementToRead).build().perform();
            action.clickAndHold().build().perform();

            action.moveByOffset(x, y).build().perform();
            Robot robot = new Robot();
            robot.mouseMove(x, y + 65);
            Thread.sleep(2000);
            action.release().build().perform();
            System.out.println("[Info] Element Successfully Clicked and Dragged- " + elementXpath);
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to Click And Drag On Element - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

    }

    public boolean waitForElementByXpathVisibilityWithTimeOut(String elementXpath, int waitn) {
        System.out.println("Waiting For Element To Be Visible: " + elementXpath);
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < waitn) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))) != null) {
                        if (wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementXpath))) != null) {
                            elementFound = true;
                            break;
                        }
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public String retrieveDataOriginalTitleXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);

            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            Point coordinates = elementToRead.getLocation();
            Robot robot = new Robot();
            robot.mouseMove(coordinates.getX(), coordinates.getY() + 65); //Number 65 should vary
            Thread.sleep(3000);
            retrievedText = elementToRead.getAttribute("data-original-title");
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath);
            return retrievedText;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }

    }

    public void Close() {
        try {
            Actions action = new Actions(Driver);
            action.sendKeys(Keys.CONTROL, Keys.CONTROL);
            action.perform();
        } catch (Exception e) {
            this.DriverExceptionDetail = e.getMessage();
            System.err.println("[Error] Failed to send keypress to element - Contoll + C");

        }
    }

    public String retrieveElementTypeByNoRobotXpath(String elementXpath) {
        String retrievedText = "";
        try {
            this.waitForElementByXpath(elementXpath);

            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            retrievedText = elementToRead.getText();
            System.out.println("[Info]Text retrieved successfully from element - " + elementXpath + ": " + retrievedText);
            return retrievedText;
        } catch (Exception e) {
            System.err.println("[Error] Failed to retrieve text from element Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return retrievedText;
        }
    }

    //Clicks and holds for the amount of milliseconds
    //@cpetersen
    public boolean ClickHoldAndReleaseByXpath(String elementXpath, int milliseconds) {
        try {
            System.out.println("[Info]Performing click and hold for element - " + elementXpath);
            this.waitForElementByXpath(elementXpath);
            WebElement sourceElement = Driver.findElement(By.xpath(elementXpath));
            Actions builder = new Actions(Driver);
            builder.click(sourceElement);
            builder.clickAndHold(sourceElement);
            builder.perform();
            Thread.sleep(milliseconds);
            builder.release(sourceElement);

            builder.perform();
            return true;

        } catch (Exception e) {
            System.err.println("[Error] Failed to perform click and hold element by Xpath - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public int getCountOfElementsByXpath(String elementsXpath) {
        int count = 0;

        List<WebElement> elements = Driver.findElements(By.xpath(elementsXpath));

        for (WebElement e : elements) {
            ++count;
        }

        return count;
    }

    public boolean waitForElementToBeClickableByXpath(String elementXpath, int timeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                waitCount++;
            }
        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public boolean waitforelementbyxpath(String elementXpath, Integer timeout) {
        boolean elementFound = false;
        try {
            int waitCount = 0;
            Thread.sleep(5000);
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    //@gjansen
    public boolean clickElementNoErrorByXpath(String elementXpath) {
        try {
            System.out.println("[INFO] Clicking element by Xpath : " + elementXpath);
            waitForElementByXpath(elementXpath);
            WebDriverWait wait = new WebDriverWait(Driver, ApplicationConfig.WaitTimeout());
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean waitForElementWithTimeoutByXpath(String elementXpath, Integer timeout) {
        boolean elementFound = false;
        SeleniumDriverInstance.pause(20000);
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public List<WebElement> getListOfElements(String elementXpath) {
        try {
            List<WebElement> elements = Driver.findElements(By.xpath(elementXpath));
            return elements;
        } catch (Exception e) {
            System.out.println("Failed To Find Elements");
            return null;
        }
    }

    //@gjansen
    public boolean waitForElementNotClickableByXpath(String elementXpath) {
        System.out.println("[INFO] Waiting For Element by Xpath : " + elementXpath);
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    //@gjansen
    public boolean waitForElementNotClickableByXpath(String elementXpath, Integer timeout) {
        boolean elementFound = false;
        System.out.println("[INFO] Waiting For Element by Xpath : " + elementXpath);
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < timeout) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);

                    if (wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    //@gjansen
    public String getElementNoWaitAttribute(String elementXpath, String attributeName) {
        String propertyValue = "";
        System.out.println("[INFO] Retrieving Attribute Of Element by Xpath : " + elementXpath);
        try {

            WebElement elementToTypeIn = Driver.findElement(By.xpath(elementXpath));

            //propertyValue = elementToTypeIn.getAttribute(attributeName);
            propertyValue = Driver.findElement(By.xpath(elementXpath)).getAttribute(attributeName);

        } catch (Exception e) {
            System.err.println("[Error] Finding element by Xpath and retrieving attribute '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

        }

        if (propertyValue == null) {
            propertyValue = "";
        }

        return propertyValue;
    }

    public boolean TypeCtrlLetter(String letter) {
        try {

            Actions action = new Actions(Driver);
            action.sendKeys(Keys.chord(Keys.CONTROL, letter));
            action.perform();

            return true;
        } catch (Exception e) {
            System.err.println("Error Typing ctrl + " + letter + " - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    //@gjansen
    public boolean waitForElementPresenceByXpath(String elementXpath) {
        System.out.println("[INFO] Waiting For Element by Xpath : " + elementXpath);
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < ApplicationConfig.WaitTimeout()) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                //Thread.sleep(500);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    //@gjansen
    public String getElementAttributeByXpathWithPresence(String elementXpath, String attributeName) {
        String propertyValue = "";
        try {
            this.waitForElementPresenceByXpath(elementXpath);

            propertyValue = Driver.findElement(By.xpath(elementXpath)).getAttribute(attributeName);

        } catch (Exception e) {
            System.err.println("[Error] Finding element by Xpath and retrieving attribute '" + elementXpath + "' - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();

        }

        if (propertyValue == null) {
            propertyValue = "";
        }

        return propertyValue;
    }

    public boolean checkIfCheckBoxISCheckedWithNullByXpath(String elementXpath) {
        try {
            Thread.sleep(1000);
//            int count = 1;
//            String notchecked = "";
//            List<String> reportData = new ArrayList<String>();

            String checked = "";
            WebElement elementToClick = Driver.findElement(By.xpath(elementXpath));
            checked = elementToClick.getAttribute("checked");

            if (checked.equals("") || checked == null) {
                return false;

            } else if (!elementToClick.isSelected()) {
                return false;
            }
//            count++;
            return true;
        } catch (Exception e) {
            System.err.println("Error checking if all checkboxes are checked - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

    }

    //Clicks and drags Scrollbar using actions. --@cpetersen
    public boolean DragScrollbarByXpath(String elementXpath, int x, int y) {
        try {
            WebElement elementToRead = Driver.findElement(By.xpath(elementXpath));
            Actions action = new Actions(Driver);
            action.moveToElement(elementToRead).perform();
            action.clickAndHold(elementToRead).moveByOffset(x, y).release().perform();

            System.out.println("[Info] Element Successfully Clicked and Dragged- " + elementXpath);
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to Click And Drag On Element - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }

    }

    public boolean checkIfCheckBoxIsNotCheckedByXpath(String elementXpath) {
        String propertyValue = "";
        try {

            this.waitForElementByXpath(elementXpath);

            propertyValue = Driver.findElement(By.xpath(elementXpath)).getAttribute("checked");

            return !propertyValue.equalsIgnoreCase("true");

        } catch (Exception e) {
            System.err.println("Error checking if all checkboxes are checked - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }

    public Boolean CheckIfElementIsDisabled(String elementXpath, Integer timeout) {
        Boolean IsDisabled = false;
        try {
            Thread.sleep(3000);
            waitForElementByXpath(elementXpath, timeout);
            WebElement mainDiv = Driver.findElement(By.xpath(elementXpath));

            IsDisabled = mainDiv.isEnabled();

            String disa = mainDiv.getAttribute("disabled");

            IsDisabled = !(disa == null || disa.equals("false"));

            return IsDisabled;

        } catch (Exception e) {
            System.err.println("Error checking if element is enabled - " + e.getMessage());
            this.DriverExceptionDetail = e.getMessage();
            IsDisabled = false;
        }

        return IsDisabled;
    }

}
