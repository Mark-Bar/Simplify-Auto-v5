/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Utilities;

import KeywordDrivenTestFramework.Entities.Enums.BrowserType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author Brendan
 */
public final class ApplicationConfig {

    public Properties appConfig;
    private String appConfigFilePath = "config.properties";

    private static String ExcelInputFile, ReportFileDirectory, browserTypeConfig, MyPageUrl, mailingList, seeTestExecutablePath;
    private static String emailSender, emailHost;
    private static int WaitTimeout;
    public static BrowserType browserType;

    public static int WaitTimeout() {
        return WaitTimeout;
    }

    public static String InputFileName() {
        return ExcelInputFile;
    }

    public static String SeeTestExecutablePath() {
        return seeTestExecutablePath;
    }

    public static String MyPageUrl() {
        return MyPageUrl;
    }

    public static String ReportFileDirectory() {
        return ReportFileDirectory;
    }

    public static BrowserType SelectedBrowser() {
        return browserType;
    }

    public static String EmailHost() {
        return emailHost;
    }

    public static String[] MailingList() {
        return mailingList.split(";");
    }

    public static String EmailSender() {
        return emailSender;
    }

    public ApplicationConfig() {

        try {
            loadConfigurationSettings();
        } catch (Exception e) {
            // One or more of the appConfig values could not be found in the config file - 
            // Reload default values and read from file. 
            generateDefaultConfigurationFile();
            loadExistingConfigurationFile();
            loadConfigurationSettings();
        }

    }

    private void loadConfigurationSettings() {
        if (!loadExistingConfigurationFile()) {
            generateDefaultConfigurationFile();
        }
        try {
            ExcelInputFile = appConfig.getProperty("ExcelInputFile");
            ReportFileDirectory = appConfig.getProperty("ReportFileDirectory");
            MyPageUrl = appConfig.getProperty("MyPageUrl");

            mailingList = appConfig.getProperty("MailingList");
            emailSender = appConfig.getProperty("EmailSender");
            emailHost = appConfig.getProperty("EmailHost");

            WaitTimeout = Integer.parseInt(appConfig.getProperty("WaitTimeout"));
            seeTestExecutablePath = appConfig.getProperty("SeeTestExecutablePath");
            browserType = resolveBrowserType();
        } catch (Exception e) {
            System.out.println("Error Loading application configuration...see stack trace:");
        }

    }

    private BrowserType resolveBrowserType() {
        browserTypeConfig = appConfig.getProperty("BrowserType");

        switch (browserTypeConfig) {
            case "IE":
                return BrowserType.IE;
            case "FireFox":
                return BrowserType.FireFox;
            case "Chrome":
                return BrowserType.Chrome;
            case "Safari":
                return BrowserType.Safari;
            default:
                return BrowserType.Chrome;
        }
    }

    private void generateDefaultConfigurationFile() {
        try {
            appConfig = new Properties();
            appConfig.setProperty("ExcelInputFile", "Keyword Input.xls");
            appConfig.setProperty("ReportFileDirectory", "KeywordDrivenTestReports\\");
            appConfig.setProperty("BrowserType", "Chrome");
            appConfig.setProperty("WaitTimeout", "15");
            appConfig.setProperty("MyPageUrl", "spree.co.za");

            appConfig.setProperty("MailingList", "brendan@testheroes.co.za");
            appConfig.setProperty("EmailSender", "Spree");
            appConfig.setProperty("EmailHost", "localhost");

            appConfig.store(new FileOutputStream(appConfigFilePath), null);

        } catch (Exception e) {
            System.out.println("Error Loading default configuration...see stack trace:");
        }
    }

    private boolean loadExistingConfigurationFile() {
        try {
            if (appConfig == null) {
                appConfig = new Properties();
            }
            appConfig.load(new FileInputStream(appConfigFilePath));
            return true;

        } catch (Exception e) {
            System.out.println("Configuration file not found, reverting to default configuration...see stack trace:");
            System.out.println("Loading default configuration");
            return false;
        }
    }
}
