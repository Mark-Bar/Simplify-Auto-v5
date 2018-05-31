/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KeywordDrivenTestFramework.Testing.PageObjects;

import KeywordDrivenTestFramework.Core.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author
 */
public class Main_Object extends BaseClass {

    public static String Alphabet;

    public static String PageTitle = "Careers24 | Find & Apply For Jobs & Vacancies Online";

    public static String NavigateToCareers24SAUrl() {
        return currentEnvironment.Careers24URL;
    }

    public static String NavigateToSimplifyUrl() {
        return currentEnvironment.SimplifyURL;
    }

    public static String SimplifyUrl() {return "https://www.simplify.hr";}

    public static String CareersNGmobiUrl() {
        return "http://m.careers24.com.ng/register";
    }

    public static String CareersSAwebUrl() {
        return "http://www.careers24.com";
    }

    public static String CareersNGMainUrl() {
        return "http://www.careers24.com.ng";
    }

    public static String CareersSAadminURL() {
        return "https://admin.careers24.com";
    }

    //Signup SA Web Objects Start
    public static String SignUpClient() {
        return "//*[@id=\"pnlLoggedOut\"]/a";
    }

    public static String SignupEmail() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmail\"]";
    }

    public static String SignupPass() {
        return "//*[@id=\"uxPassword\"]";
    }

    public static String WorkExperience() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxCurrentStatus\"]/tbody/tr[1]/td/label";
    } //*[@id="ctl00_contentPrimaryPlaceHolder_uxCurrentStatus"]/tbody/tr[1]/td/label

    public static String MonthDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlFirstJobStartMonth\"]";
    }

    public static String MonthDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlFirstJobStartMonth\"]/option[2]";
    }

    public static String YearDropSignup() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlFirstJobStartYear\"]";
    }

    public static String YearDropSignup1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlFirstJobStartYear\"]/option[4]";
    }

    public static String SignUpClick() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_btnSignUp\"]";
    }

    public static String FirstName() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxFirstName\"]";
    }

    public static String LastName() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxLastName\"]";
    }

    public static String ContactNumber() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxTelephone\"]";
    }

    public static String Id() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxIDNumber\"]";
    }

    public static String DobDayDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxDateOfBirth_d\"]";
    }

    public static String DobDayDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxDateOfBirth_d\"]/option[4]";
    }

    public static String DobMonthDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxDateOfBirth_m\"]";
    }

    public static String DobMonthDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxDateOfBirth_m\"]/option[4]";
    }

    public static String DobYearDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxDateOfBirth_y\"]";
    }

    public static String DobYearDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxDateOfBirth_y\"]/option[4]";
    }

    public static String Gender() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_radGender\"]/tbody/tr[1]/td/label";
    }

    public static String Race() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxRaceId\"]";
    }

    public static String Race1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxRaceId\"]/option[2]";
    }

    public static String Location() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxLocation\"]";
    }

    public static String Location1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxLocation\"]/option[2]";
    }

    public static String Education() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlEducation\"]";
    }

    public static String Education1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlEducation\"]/option[2]";
    }

    public static String Next1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_btnSave\"]";
    }

    public static String JobTitle() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxJobTitle\"]";
    }

    public static String CompanyName() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxCompanyName\"]";
    }

    public static String WorkLocation() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxLocation\"]";
    }

    public static String WorkSectorDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_ddlSectors\"]";
    }

    public static String WorkSectorDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_ddlSectors\"]/option[2]";
    }

    public static String ContractTypeDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxJobTypeID\"]";
    }

    public static String ContractTypeDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxJobTypeID\"]/option[2]";
    }

    public static String StartMonthDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateFromMonth\"]";
    }

    public static String StartMonthDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateFromMonth\"]/option[2]";
    }

    public static String StartYearDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateFromYear\"]";
    }

    public static String StartYearDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateFromYear\"]/option[6]";
    }

    public static String EndMonthDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateToMonth\"]";
    }

    public static String EndMonthDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateToMonth\"]/option[4]";
    }

    public static String EndYearDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateToYear\"]";
    }

    public static String EndYearDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateToYear\"]/option[3]";
    }

    public static String Salary() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxSalary\"]";
    }

    public static String Save1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxSave\"]";
    }

    public static String NewWorkHistory() {
        return "//*[@id=\"lnkAddHist\"]";
    }

    public static String JobTitle2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxJobTitle\"]";
    }

    public static String CompanyName2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxCompanyName\"]";
    }

    public static String WorkLocation2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxLocation\"]";
    }

    public static String WorkSectorDropV2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_ddlSectors\"]";
    }

    public static String WorkSectorDrop1V2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_ddlSectors\"]/option[2]";
    }

    public static String ContractTypeDropV2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxJobTypeID\"]";
    }

    public static String ContractTypeDrop1V2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxJobTypeID\"]/option[2]";
    }

    public static String StartMonthDropV2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateFromMonth\"]";
    }

    public static String StartMonthDrop1V2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateFromMonth\"]/option[2]";
    }

    public static String StartYearDropV2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateFromYear\"]";
    }

    public static String StartYearDrop1V2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateFromYear\"]/option[6]";
    }

    public static String EndMonthDropV2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateToMonth\"]";
    }

    public static String EndMonthDrop1V2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateToMonth\"]/option[4]";
    }

    public static String EndYearDropV2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateToYear\"]";
    }

    public static String EndYearDrop1V2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateToYear\"]/option[3]";
    }

    public static String SalaryV2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxSalary\"]";
    }

    public static String Save1V2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxSave\"]";
    }

    public static String HistoryNext() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxNext\"]";
    }

    public static String EducationInstitution() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxInstitution\"]";
    }

    public static String EducationName() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxQualification\"]";
    }

    public static String EducationYearDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxYearCompleted\"]";
    }

    public static String EducationYearDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxYearCompleted\"]/option[3]";
    }

    public static String EducationNext() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_btnSave\"]";
    }

// Signup SA Web objects End

// Signup SA Mobi objects Start

    public static String CareersSAmobiUrl() {
        return "http://m.careers24.com/register/";
    }

    public static String CareersSAmobiEmail() {
        return "//*[@id=\"ContentPlaceHolder1_uxEmail\"]";
    }

    public static String CareersSAmobiPass() {
        return "//*[@id=\"uxPassword\"]";
    }

    public static String CareersSAmobiStartMonth() {
        return "//*[@id=\"ContentPlaceHolder1_uxCurrentStatus\"]/tbody/tr[1]/td/label";
    }

    public static String CareersSAmobiStartMonth1() {
        return "//*[@id=\"ContentPlaceHolder1_ddlFirstJobStartMonth\"]/option[5]";
    }

    public static String CareersSAmobiStartYear() {
        return "//*[@id=\"ContentPlaceHolder1_ddlFirstJobStartYear\"]";
    }

    public static String CareersSAmobiStartYear1() {
        return "//*[@id=\"ContentPlaceHolder1_ddlFirstJobStartYear\"]/option[5]";
    }

    public static String CareersSAmobiSignUp() {
        return "//*[@id=\"ContentPlaceHolder1_btnSignUp\"]";
    }

    public static String CareersSAmobiFirstName() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxFirstName\"]";
    }

    public static String CareersSAmobiLastName() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxLastName\"]";
    }

    public static String CareersSAmobiTelephone() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxTelephone\"]";
    }

    public static String CareersSAmobiID() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxIDNumber\"]";
    }

    public static String CareersSAmobiDOBdayDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxDateOfBirth_d\"]";
    }

    public static String CareersSAmobiDOBdayDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxDateOfBirth_d\"]/option[7]";
    }

    public static String CareersSAmobiDOBmonthDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxDateOfBirth_m\"]";
    }

    public static String CareersSAmobiDOBmonthDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxDateOfBirth_m\"]/option[3]";
    }

    public static String CareersSAmobiDOByearDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxDateOfBirth_y\"]";
    }

    public static String CareersSAmobiDOByearDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxDateOfBirth_y\"]/option[20]";
    }

    public static String CareersSAmobiGender() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_radGender\"]/tbody/tr[1]/td/label";
    }

    public static String CareersSAmobiRaceDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxRaceId\"]";
    }

    public static String CareersSAmobiRaceDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxRaceId\"]/option[2]";
    }

    public static String CareersSAmobiLocationDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxLocation\"]";
    }

    public static String CareersSAmobiLocationDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxLocation\"]/option[3]";
    }

    public static String CareersSAmobiEduDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_ddlEducation\"]";
    }

    public static String CareersSAmobiEduDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_ddlEducation\"]/option[5]";
    }

    public static String CareersSAmobiNext() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_btnSave\"]";
    }

    public static String CareersSAmobiJobTitle() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxJobTitle\"]";
    }

    public static String CareersSAmobiCompany() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxCompanyName\"]";
    }

    public static String CareersSAmobiCity() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxLocation\"]";
    }

    public static String CareersSAmobiSectorDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxSectorID\"]";
    }

    public static String CareersSAmobiSectorDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxSectorID\"]/option[4]";
    }

    public static String CareersSAmobiContractDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxJobTypeID\"]";
    }

    public static String CareersSAmobiContractDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxJobTypeID\"]/option[3]";
    }

    public static String CareersSAmobiStartMonthDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxDateFromMonth\"]";
    }

    public static String CareersSAmobiStartMonthDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxDateFromMonth\"]/option[5]";
    }

    public static String CareersSAmobiStartYearDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxDateFromYear\"]";
    }

    public static String CareersSAmobiStartYearDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxDateFromYear\"]/option[20]";
    }

    public static String CareersSAmobiEndMonthDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxDateToMonth\"]";
    }

    public static String CareersSAmobiEndMonthDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxDateToMonth\"]/option[6]";
    }

    public static String CareersSAmobiEndYearDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxDateToYear\"]";
    }

    public static String CareersSAmobiEndYearDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxDateToYear\"]/option[4]";
    }

    public static String CareersSAmobiSalary() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxSalary\"]";
    }

    public static String CareersSAmobiNext1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxRegisterSave\"]";
    }

    public static String CareersSAmobiNext2() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxWorkExperience_uxNext\"]";
    }

    public static String CareersSAmobiInstitute() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxInstitution\"]";
    }

    public static String CareersSAmobiQualification() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxQualification\"]";
    }

    public static String CareersSAmobiYearCompleteDrop() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxYearCompleted\"]";
    }

    public static String CareersSAmobiYearCompleteDrop1() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_uxYearCompleted\"]/option[3]";
    }

    public static String CareersSAmobiNextLast() {
        return "//*[@id=\"ContentPlaceHolder1_ContentPlaceHolder1_btnSave\"]";
    }

// signup SA Mobi objects End

// Signup NG web objects Start

    public static String CareersNGUrl() {
        return "http://www.careers24.com.ng/";
    }

    public static String CareersNGSignup() {
        return "//*[@id=\"pnlLoggedOut\"]/a";
    }

    public static String CareersNGemail() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmail\"]";
    }

    public static String CareersNGpass() {
        return "//*[@id=\"uxPassword\"]";
    }

    public static String CareersNGexp() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxCurrentStatus\"]/tbody/tr[1]/td/label";
    }

    public static String CareersNGmonthDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlFirstJobStartMonth\"]";
    }

    public static String CareersNGmonthDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlFirstJobStartMonth\"]/option[4]";
    }

    public static String CareersNGyearDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlFirstJobStartYear\"]";
    }

    public static String CareersNGyearDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlFirstJobStartYear\"]/option[20]";
    }

    public static String CareersNGnext1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_btnSignUp\"]";
    }

    public static String CareersNGfirstName() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxFirstName\"]";
    }

    public static String CareersNGlastName() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxLastName\"]";
    }

    public static String CareersNGnumber() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxTelephone\"]";
    }

    public static String CareersNGdobDayDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxDateOfBirth_d\"]";
    }

    public static String CareersNGdobDayDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxDateOfBirth_d\"]/option[8]";
    }

    public static String CareersNGdobMonthDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxDateOfBirth_m\"]";
    }

    public static String CareersNGdobMonthDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxDateOfBirth_m\"]/option[6]";
    }

    public static String CareersNGdobYearDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxDateOfBirth_y\"]";
    }

    public static String CareersNGdobYearDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxDateOfBirth_y\"]/option[30]";
    }

    public static String CareersNGgender() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_radGender\"]/tbody/tr[1]/td/label";
    }

    public static String CareersNGraceDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxRaceId\"]";
    }

    public static String CareersNGraceDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxRaceId\"]/option[2]";
    }

    public static String CareersNGlocationDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxLocation\"]";
    }

    public static String CareersNGlocationDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxLocation\"]/option[6]";
    }

    public static String CareersNGeducationDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlEducation\"]";
    }

    public static String CareersNGeducationDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlEducation\"]/option[3]";
    }

    public static String CareersNGnext2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_btnSave\"]";
    }

    public static String CareersNGjobTitle() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxJobTitle\"]";
    }

    public static String CareersNGcompany() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxCompanyName\"]";
    }

    public static String CareersNGWorkHere() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxCurrentJob\"]";
    }

    public static String CareersNGcity() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxLocation\"]";
    }

    public static String CareersNGsectorDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_ddlSectors\"]";
    }

    public static String CareersNGsectorDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_ddlSectors\"]/option[7]";
    }

    public static String CareersNGcontractDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxJobTypeID\"]";
    }

    public static String CareersNGcontractDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxJobTypeID\"]/option[2]";
    }

    public static String CareersNGstartMonthDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateFromMonth\"]";
    }

    public static String CareersNGstartMonthDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateFromMonth\"]/option[4]";
    }

    public static String CareersNGstartYearDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateFromYear\"]";
    }

    public static String CareersNGstartYearDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateFromYear\"]/option[15]";
    }

    public static String CareersNGendMonthDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateToMonth\"]";
    }

    public static String CareersNGendMonthDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateToMonth\"]/option[3]";
    }

    public static String CareersNGendYearDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateToYear\"]";
    }

    public static String CareersNGendYearDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxDateToYear\"]/option[4]";
    }

    public static String CareersNGsalary() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxSalary\"]";
    }

    public static String CareersNGnext3() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_1_uxSave\"]";
    }

    public static String CareersNGaddWorkHistory() {
        return "//*[@id=\"lnkAddHist\"]";
    }

    public static String CareersNGjobTitle2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxJobTitle\"]";
    }

    public static String CareersNGcompany2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxCompanyName\"]";
    }

    public static String CareersNGcity2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxLocation\"]";
    }

    public static String CareersNGsectorDrop2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_ddlSectors\"]";
    }

    public static String CareersNGsectorDrop12() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_ddlSectors\"]/option[7]";
    }

    public static String CareersNGcontractDrop2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxJobTypeID\"]";
    }

    public static String CareersNGcontractDrop12() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxJobTypeID\"]/option[2]";
    }

    public static String CareersNGstartMonthDrop2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateFromMonth\"]";
    }

    public static String CareersNGstartMonthDrop12() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateFromMonth\"]/option[3]";
    }

    public static String CareersNGstartYearDrop2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateFromYear\"]";
    }

    public static String CareersNGstartYearDrop12() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateFromYear\"]/option[16]";
    }

    public static String CareersNGendMonthDrop2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateToMonth\"]";
    }

    public static String CareersNGendMonthDrop12() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateToMonth\"]/option[3]";
    }

    public static String CareersNGendYearDrop2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateToYear\"]";
    }

    public static String CareersNGendYearDrop12() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxDateToYear\"]/option[4]";
    }

    public static String CareersNGsalary2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxSalary\"]";
    }

    public static String CareersNGnext32() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxSave\"]";
    }

    public static String CareersNGnext4() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxEmploymentDetails_uxWorkHistory_whi_2_uxNext\"]";
    }


// Signup NG web objects End

    //Login Objects Start
    public static String Login() {
        return "//*[@id=\"pnlLoggedOut\"]/a[2]";
    }

    public static String Email() {
        return "//*[@id=\"uxEmail\"]";
    } //*[@id="uxEmail"]

    public static String Password() {
        return "//*[@id=\"ctl00_ctl00_C24header1_C24login1_uxPassword\"]";
    }

    public static String LoginButton() {
        return "//*[@id=\"ctl00_ctl00_C24header1_C24login1_uxLogin\"]";
    }
//Login Objects End


    //BAlerts Objects Start
    public static String ProfileAlert() {
        return "//*[@id=\"ctl00_C24header1_liLnkForJobSeekers\"]/div/a";
    }

    public static String MyAlerts() {
        return "//*[@id=\"ctl00_C24header1_liLnkForJobSeekers\"]/div/ul/li[3]/a";
    }

    public static String Al1() {
        return "//*[@id=\"career_tools\"]/ul/li[1]/a/span";
    }

    public static String AlertName1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxSearchName\"]";
    }

    public static String AlertJobTitle() {
        return "//*[@id=\"uxAlertKeywords\"]";
    }

    public static String AlertLocationDrop() {
        return "//*[@id=\"locationName\"]";
    }

    public static String AlertLocationDrop1() {
        return "//*[@id=\"locationContent\"]/li[2]/span";
    }

    public static String AlertSector() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxSector_chkBoxList\"]";
    }

    public static String AlertSector1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxSector_chkBoxList_2\"]";
    }

    public static String AlertJobType() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxJobType\"]"; //*[@id="ctl00_contentPrimaryPlaceHolder_uxJobType"]
    }

    public static String AlertJobType1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxJobType\"]/option[2]"; //*[@id="ctl00_contentPrimaryPlaceHolder_uxJobType"]/option[2]
    }

    public static String AlertSalary() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_txtSalary\"]";
    }

    public static String AlertCompanyDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlCompany\"]";
    }

    public static String AlertCompanyDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ddlCompany\"]/option[2]";
    }

    public static String AlertSave() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_uxSaveButton\"]";
    }

    public static String NewAlert() {
        return "//*[@id=\"aspnetForm\"]/div[4]/div/article/section[2]/a";
    }

    public static String LogOut() {
        return "//*[@id=\"pnlLoggedIn\"]/a[2]";
    }
//BAlerts Objects End

    //JobPosting Objects Start
    public static String ModelVacancyButton() {
        return "//*[@id=\"welcomeModal\"]/div/div[2]/section[1]/button[1]";
    }

    public static String SelectVacancy() {
        return "//*[@id=\"divMyVacancies\"]/div/div[2]/table/tbody/tr[1]/td[3]/a";
    }

    public static String VancancyButtonNav() {
        return "http://www.careers24.com/recruiter/job/";
    }//*[@id="sidebar"]/ul/li[6]

    public static String DuplicateVacancy() {
        return "//*[@id=\"btnDupe\"]";
    }

    public static String JobAdTitle() {
        return "//*[@id=\"txtVacancyTitle\"]";
    }

    public static String JobTypeTitle() {
        return "//*[@id=\"txtSearchTitle-tokenfield\"]";
    }

    public static String JobTypeSelect() {
        return "//*[@id=\"ui-id-63\"]";
    }

    public static String Description() {
        return "//*[@id=\"aspnetForm\"]/div[3]/div/section/div[2]/div[8]/span/table/tbody/tr[2]/td/iframe";
    }
    //*[@id="aspnetForm"]/div[3]/div/section/div[2]/div[8]/span/table/tbody/tr[2]/td/iframe
    //*[@id="aspnetForm"]/div[3]/div/section/div[1]/div[8]/span/table/tbody/tr[2]/td
    //*[@id="aspnetForm"]/div[3]/div/section/div[1]/div[8]/span/table/tbody/tr[2]
    //*[@id="uxDescription"]
    //*[@id="aspnetForm"]/div[3]/div/section/div[1]/div[8]/span/table/tbody/tr[2]/td

//JobPosting Objects End

    //Reviews Objects Start
    public static String ReviewsNavigate() {
        return "http://www.careers24.com/company-reviews/";
    }

    public static String ReviewCompanyButton() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_FeaturedCompanyReviews_rptTopRated_ctl00_pnlBackground\"]/div[1]/a";
    }

    public static String ReviewEmployerName() {
        return "//*[@id=\"txtCompanyName\"]";
    }

    public static String ReviewContinue() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_btnContinue\"]";
    }

    public static String ReviewsEmployerRate() {
        return "//*[@id=\"spanRating\"]/label[1]";
    }

    public static String ReviewsEmployeeType() {
        return "//*[@id=\"radIsCurrentEmployee\"]/tbody/tr[2]/td/label";
    }

    public static String ReviewStartMonthDrop() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_ddlStartMonth\"]";
    }

    public static String ReviewStartMonthDrop1() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_ddlStartMonth\"]/option[2]";
    }

    public static String ReviewsStartYearDrop() {
        return "//*[@id=\"ddlStartYear\"]";
    }

    public static String ReviewsStartYearDrop1() {
        return "//*[@id=\"ddlStartYear\"]/option[11]";
    }

    public static String ReviewsLastYearDrop() {
        return "//*[@id=\"ddlEndYear\"]";
    }

    public static String ReviewsLastYearDrop1() {
        return "//*[@id=\"ddlEndYear\"]/option[4]";
    }

    public static String ReviewsEmploymentStatusDrop() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_ddlEmploymentStatus\"]";
    }

    public static String ReviewsEmploymentStatusDrop1() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_ddlEmploymentStatus\"]/option[3]";
    }

    public static String ReviewsJobTitle() {
        return "//*[@id=\"txtJobTitle\"]";
    }

    public static String ReviewsCompanyTitle() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_txtReviewTitle\"]";
    }

    public static String ReviewsPros() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_txtPros\"]";
    }

    public static String ReviewsCons() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_txtCons\"]";
    }

    public static String ReviewsAdvice() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_txtAdvice\"]";
    }

    public static String ReviewsOpportunity() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_ratCareerOpportunities_spanRating\"]/label[1]";
    }

    public static String ReviewsBenefits() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_ratCompensation_spanRating\"]/label[1]";
    }

    public static String ReviewsBalance() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_ratWorkLifBalance_spanRating\"]/label[1]";
    }

    public static String ReviewsManagement() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_ratSeniorManagement_spanRating\"]/label[1]";
    }

    public static String ReviewsCulture() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_ratCultureAndValues_spanRating\"]/label[1]";
    }

    public static String ReviewsRecommend() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_radRecommendLikelihood\"]/tbody/tr[1]/td/label";
    }

    public static String ReviewsNext() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_btnNext\"]";
    }

    public static String ReviewsSalary() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_txtSalary\"]";
    }

    public static String ReviewsSalaryTypeDrop() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpSalaryUnitId\"]";
    }

    public static String ReviewsSalaryTypeDrop1() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpSalaryUnitId\"]/option[3]";
    }

    public static String ReviewsSalaryBonus() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_pnlForm\"]/div/div[4]/table/tbody/tr[2]/td/label";
    }

    public static String ReviewsSalaryNext() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_btnNext\"]";
    }

    public static String ReviewsCompanyBenefits() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_ucRating_spanRating\"]/label[1]";
    }

    public static String ReviewsBenefitsFeedback() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_txtDetails\"]";
    }

    public static String ReviewsEmployeeDiscount() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_pnlForm\"]/div/div[10]/label[1]";
    }

    public static String ReviewsWorkFromHome() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_pnlForm\"]/div/div[13]/label[2]";
    }

    public static String ReviewsMaternity() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_pnlForm\"]/div/div[16]/label[3]";
    }

    public static String ReviewsPension() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_pnlForm\"]/div/div[19]/label[1]";
    }

    public static String ReviewsVacation() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_pnlForm\"]/div/div[22]/label[1]"; //*[@id="ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_pnlForm"]/div/div[22]/label[1]
    }

    public static String ReviewsDiversity() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_pnlForm\"]/div/div[25]/label[3]";
    }

    public static String ReviewsAssistance() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_pnlForm\"]/div/div[28]/label[1]";
    }

    public static String ReviewsApprenticeship() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_pnlForm\"]/div/div[31]/label[2]";
    }

    public static String ReviewsDisability() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_pnlForm\"]/div/div[34]/label[3]";
    }

    public static String ReviewsBenefitsNext() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_btnNext\"]";
    }

    public static String ReviewsInterviewJobTitle() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_txtJobTitle\"]";
    }

    public static String ReviewsInterviewDescribe() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_txtDetails\"]";
    }

    public static String ReviewsInterviewQuestions() {
        return "//*[@id=\"iq1\"]";
    }

    public static String ReviewsInterviewDifficulty() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpDifficulty\"]"; //*[@id="ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpDifficulty"]
    }

    public static String ReviewsInterviewDifficulty1() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpDifficulty\"]/option[2]";
    }

    public static String ReviewsInterviewOffer() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_pnlForm\"]/div/div[13]/label[1]";
    }

    public static String ReviewsInterviewSource() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpInterviewSource\"]";
    }

    public static String ReviewsInterviewSource1() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpInterviewSource\"]/option[3]";
    }

    public static String ReviewsInterviewAmount() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_txtInterviewCount\"]";
    }

    public static String ReviewsInterviewLength() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_txtProcessDuration\"]";
    }

    public static String ReviewsInterviewLengthDrop() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpProcessDurationUnit\"]";
    }

    public static String ReviewsInterviewLengthDrop1() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpProcessDurationUnit\"]/option[2]";
    }

    public static String ReviewsInterviewWhenMonthDrop() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpWhenMonth\"]";
    }

    public static String ReviewsInterviewWhenMonthDrop1() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpWhenMonth\"]/option[4]";
    }

    public static String ReviewsInterviewWhenYearDrop() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpWhenYear\"]";
    }

    public static String ReviewsInterviewWhenYearDrop1() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_drpWhenYear\"]/option[3]";
    }

    public static String ReviewsInterviewWhere() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_txtWhere\"]";
    }

    public static String ReviewsInterviewStages() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_chkPhoneScreening\"]";
    }

    public static String ReviewsInterviewNext() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_btnNext\"]";
    }
//Reviews Objects End

    //SA Site Page Objects Start
    public static String CareersHome() {
        return "http://www.careers24.com/";
    }

    public static String CareersJobPage() {
        return "http://www.careers24.com/jobs/lc-south-africa/?sort=dateposted";
    }

    public static String CareersEngineering() {
        return "http://www.careers24.com/engineering-and-construction";
    }

    public static String CareersFinance() {
        return "http://www.careers24.com/finance";
    }

    public static String CareersHospitality() {
        return "http://www.careers24.com/hospitality";
    }

    public static String CareersMarketing() {
        return "http://www.careers24.com/marketing";
    }

    public static String CareersOffice() {
        return "http://www.careers24.com/office";
    }

    public static String CareersTech() {
        return "http://www.careers24.com/tech";
    }

    public static String CareersGraduate() {
        return "http://www.careers24.com/graduate/";
    }

    public static String CareersGraduateTech() {
        return "http://www.careers24.com/jobs/ve-graduate/se-internet,it,technology/";
    }

    public static String CareersGraduateMarketing() {
        return "http://www.careers24.com/jobs/ve-graduate/se-advertising,business-management,design-services,marketing,media/";
    }

    public static String CareersGraduateHospitality() {
        return "http://www.careers24.com/jobs/ve-graduate/se-hospitality,logistics,travel-and-tourism/";
    }

    public static String CareersGraduateEngineering() {
        return "http://www.careers24.com/jobs/ve-graduate/se-engineering,manufacturing,technical/";
    }

    public static String CareersGraduateFinance() {
        return "http://www.careers24.com/jobs/ve-graduate/se-accounting,banking,finance,investment,stockbroking/";
    }

    public static String CareersGraduateOffice() {
        return "http://www.careers24.com/jobs/ve-graduate/se-admin,defence,logistics,warehousing/";
    }

    public static String CareersGraduateSkills() {
        return "http://www.careers24.com/graduate/what-can-I-do-with-my-skills";
    }

    public static String CareersGraduateCV() {
        return "http://www.careers24.com/graduate/is-my-cv-good-enough";
    }

    public static String CareersGraduateInterview() {
        return "http://www.careers24.com/graduate/How-to-ace-my-interview";
    }

    public static String CareersGraduateHired() {
        return "http://www.careers24.com/graduate/help-ive-been-hired";
    }

    public static String CareersGraduateResources() {
        return "http://www.careers24.com/graduate/help-ive-been-hired";
    }

    public static String CareersCourses() {
        return "http://www.careers24.com/training/";
    }

    public static String CareersCoursesAll() {
        return "http://www.careers24.com/training/results/";
    }

    public static String CareersCoursesGraduate() {
        return "http://www.careers24.com/training/results/?v=graduate";
    }

    public static String CareersCoursesEngineering() {
        return "http://www.careers24.com/training/results/?v=engineering-and-construction";
    }

    public static String CareersCoursesFinance() {
        return "http://www.careers24.com/training/results/?v=finance";
    }

    public static String CareersCoursesHospitality() {
        return "http://www.careers24.com/training/results/?v=hospitality";
    }

    public static String CareersCoursesMarketing() {
        return "http://www.careers24.com/training/results/?v=marketing";
    }

    public static String CareersCoursesOffice() {
        return "http://www.careers24.com/training/results/?v=office";
    }

    public static String CareersCoursesTech() {
        return "http://www.careers24.com/training/results/?v=tech";
    }

    public static String CareersCoursesGeneral() {
        return "http://www.careers24.com/training/results/?v=general";
    }

    public static String CareersCompanies() {
        return "http://www.careers24.com/companies-hiring/";
    }

    public static String CareersCompaniesSearchNum() {
        return "http://www.careers24.com/now-hiring/-/";
    }

    public static String CareersCompaniesSearchA() {
        return "http://www.careers24.com/now-hiring/";
    }

    public static String CareersCompaniesSearchB() {
        return "http://www.careers24.com/now-hiring/b/";
    }

    public static String CareersCompaniesSearchC() {
        return "http://www.careers24.com/now-hiring/c/";
    }

    public static String CareersCompaniesSearchD() {
        return "http://www.careers24.com/now-hiring/d/";
    }

    public static String CareersCompaniesSearchE() {
        return "http://www.careers24.com/now-hiring/e/";
    }

    public static String CareersCompaniesSearchF() {
        return "http://www.careers24.com/now-hiring/f/";
    }

    public static String CareersCompaniesSearchG() {
        return "http://www.careers24.com/now-hiring/g/";
    }

    public static String CareersCompaniesSearchH() {
        return "http://www.careers24.com/now-hiring/h/";
    }

    public static String CareersCompaniesSearchI() {
        return "http://www.careers24.com/now-hiring/i/";
    }

    public static String CareersCompaniesSearchJ() {
        return "http://www.careers24.com/now-hiring/j/";
    }

    public static String CareersCompaniesSearchK() {
        return "http://www.careers24.com/now-hiring/k/";
    }

    public static String CareersCompaniesSearchL() {
        return "http://www.careers24.com/now-hiring/l/";
    }

    public static String CareersCompaniesSearchM() {
        return "http://www.careers24.com/now-hiring/m/";
    }

    public static String CareersCompaniesSearchN() {
        return "http://www.careers24.com/now-hiring/n/";
    }

    public static String CareersCompaniesSearchO() {
        return "http://www.careers24.com/now-hiring/o/";
    }

    public static String CareersCompaniesSearchP() {
        return "http://www.careers24.com/now-hiring/p/";
    }

    public static String CareersCompaniesSearchQ() {
        return "http://www.careers24.com/now-hiring/q/";
    }

    public static String CareersCompaniesSearchR() {
        return "http://www.careers24.com/now-hiring/r/";
    }

    public static String CareersCompaniesSearchS() {
        return "http://www.careers24.com/now-hiring/s/";
    }

    public static String CareersCompaniesSearchT() {
        return "http://www.careers24.com/now-hiring/t/";
    }

    public static String CareersCompaniesSearchU() {
        return "http://www.careers24.com/now-hiring/u/";
    }

    public static String CareersCompaniesSearchV() {
        return "http://www.careers24.com/now-hiring/v/";
    }

    public static String CareersCompaniesSearchW() {
        return "http://www.careers24.com/now-hiring/w/";
    }

    public static String CareersCompaniesSearchX() {
        return "http://www.careers24.com/now-hiring/x/";
    }

    public static String CareersCompaniesSearchY() {
        return "http://www.careers24.com/now-hiring/y/";
    }

    public static String CareersCompaniesSearchZ() {
        return "http://www.careers24.com/now-hiring/z/";
    }

    public static String CareersCompanyReviews() {
        return "http://www.careers24.com/company-reviews/";
    }

    public static String CareersReviews() {
        return "http://www.careers24.com/reviews/next/";
    }

    public static String CareersAdvice() {
        return "http://www.careers24.com/career-advice/";
    }

    public static String CareersAdviceCV() {
        return "http://www.careers24.com/career-advice/cv-cover-letter-advice";
    }

    public static String CareersAdviceInterviews() {
        return "http://www.careers24.com/career-advice/interview-tips";
    }

    public static String CareersAdviceJobHunt() {
        return "http://www.careers24.com/career-advice/job-hunting";
    }

    public static String CareersAdviceMoney() {
        return "http://www.careers24.com/career-advice/money";
    }

    public static String CareersAdviceWorkLife() {
        return "http://www.careers24.com/career-advice/work-life";
    }

    public static String CareersAdviceGrowth() {
        return "http://www.careers24.com/career-advice/career-growth";
    }

    public static String CareersAdviceManagement() {
        return "http://www.careers24.com/career-advice/management-advice";
    }

    public static String CareersAdviceRecruiting() {
        return "http://www.careers24.com/career-advice/recruiting";
    }

    public static String CareersRecruiters() {
        return "http://www.careers24.com/recruiters/";
    }

    public static String CareersRecruiterRegister() {
        return "http://www.careers24.com/recruiter/register/";
    }

    //Cities Urls Start

    public static String CareersCities() {
        return "http://www.careers24.com/jobs/browse/cities/";
    }

    public static String CareersCitiesAtlantic() {
        return "http://www.careers24.com/jobs/lc-atlantic-seaboard/";
    }

    public static String CareersCitiesBLoemfontein() {
        return "http://www.careers24.com/jobs/lc-bloemfontein/";
    }

    public static String CareersCitiesNorthernCape() {
        return "http://www.careers24.com/jobs/lc-cape-town-northern-suburbs/";
    }

    public static String CareersCitiesDeaar() {
        return "http://www.careers24.com/jobs/lc-de-aar/";
    }

    public static String CareersCitiesDurbanNorth() {
        return "http://www.careers24.com/jobs/lc-durban-north-coast/";
    }

    public static String CareersCitiesDurbanSouth() {
        return "http://www.careers24.com/jobs/lc-durban-southern-suburbs/";
    }

    public static String CareersCitiesEastRand() {
        return "http://www.careers24.com/jobs/lc-east-rand/";
    }

    public static String CareersCitiesErmelo() {
        return "http://www.careers24.com/jobs/lc-ermelo/";
    }

    public static String CareersCitiesJohannesburg() {
        return "http://www.careers24.com/jobs/lc-johannesburg/";
    }

    public static String CareersCitiesKroonstad() {
        return "http://www.careers24.com/jobs/lc-kroonstad/";
    }

    public static String CareersCitiesMafikeng() {
        return "http://www.careers24.com/jobs/lc-mafikeng/";
    }

    public static String CareersCitiesOverberg() {
        return "http://www.careers24.com/jobs/lc-overberg/";
    }

    public static String CareersCitiesPE() {
        return "http://www.careers24.com/jobs/lc-port-elizabeth/";
    }

    public static String CareersCitiesSouthernPeninsula() {
        return "http://www.careers24.com/jobs/lc-southern-peninsula/";
    }

    public static String CareersCitiesStellenbosch() {
        return "http://www.careers24.com/jobs/lc-stellenbosch/";
    }

    public static String CareersCitiesVanderbijlpark() {
        return "http://www.careers24.com/jobs/lc-vanderbijlpark/";
    }

    public static String CareersCitiesWelkom() {
        return "http://www.careers24.com/jobs/lc-welkom/";
    }

    public static String CareersCitiesWildCoast() {
        return "http://www.careers24.com/jobs/lc-wild-coast/";
    }

    public static String CareersCitiesBarberton() {
        return "http://www.careers24.com/jobs/lc-barberton/";
    }

    public static String CareersCitiesCapeFlats() {
        return "http://www.careers24.com/jobs/lc-cape-flats/";
    }

    public static String CareersCitiesSouthernSuburbs() {
        return "http://www.careers24.com/jobs/lc-cape-town-southern-suburbs/";
    }

    public static String CareersCitiesDrakensberg() {
        return "http://www.careers24.com/jobs/lc-drakensberg/";
    }

    public static String CareersCitiesDurbanNorthernSuburbs() {
        return "http://www.careers24.com/jobs/lc-durban-northern-suburbs/";
    }

    public static String CareersCitiesDurbanWesternSuburbs() {
        return "http://www.careers24.com/jobs/lc-durban-western-suburbs/";
    }

    public static String CareersCitiesEmalahleni() {
        return "http://www.careers24.com/jobs/lc-emalahleni/";
    }

    public static String CareersCitiesGardenRoute() {
        return "http://www.careers24.com/jobs/lc-garden-route/";
    }

    public static String CareersCitiesKimberley() {
        return "http://www.careers24.com/jobs/lc-kimberley/";
    }

    public static String CareersCitiesKZNMidlands() {
        return "http://www.careers24.com/jobs/lc-kzn-midlands/";
    }

    public static String CareersCitiesMalalane() {
        return "http://www.careers24.com/jobs/lc-malalane/";
    }

    public static String CareersCitiesPietermaritzburg() {
        return "http://www.careers24.com/jobs/lc-pietermaritzburg/";
    }

    public static String CareersCitiesSpringbok() {
        return "http://www.careers24.com/jobs/lc-springbok/";
    }

    public static String CareersCitiesTzaneen() {
        return "http://www.careers24.com/jobs/lc-tzaneen/";
    }

    public static String CareersCitiesVereeniging() {
        return "http://www.careers24.com/jobs/lc-vereeniging/";
    }

    public static String CareersCitiesWestCoast() {
        return "http://www.careers24.com/jobs/lc-west-coast/";
    }

    public static String CareersCitiesBethlehem() {
        return "http://www.careers24.com/jobs/lc-bethlehem/";
    }

    public static String CareersCitiesCapeTown() {
        return "http://www.careers24.com/jobs/lc-cape-town/";
    }

    public static String CareersCitiesWinelands() {
        return "http://www.careers24.com/jobs/lc-cape-winelands/";
    }

    public static String CareersCitiesDurban() {
        return "http://www.careers24.com/jobs/lc-durban/";
    }

    public static String CareersCitiesDurbanSouthCoast() {
        return "http://www.careers24.com/jobs/lc-durban-south-coast/";
    }

    public static String CareersCitiesEastLondon() {
        return "http://www.careers24.com/jobs/lc-east-london/";
    }

    public static String CareersCitiesEmkhondo() {
        return "http://www.careers24.com/jobs/lc-emkhondo/";
    }

    public static String CareersCitiesHelderberg() {
        return "http://www.careers24.com/jobs/lc-helderberg/";
    }

    public static String CareersCitiesKlerksdorp() {
        return "http://www.careers24.com/jobs/lc-klerksdorp/";
    }

    public static String CareersCitiesTrichardt() {
        return "http://www.careers24.com/jobs/lc-louis-trichardt/";
    }

    public static String CareersCitiesMbobela() {
        return "http://www.careers24.com/jobs/lc-mbombela/";
    }

    public static String CareersCitiesPolokwane() {
        return "http://www.careers24.com/jobs/lc-polokwane/";
    }

    public static String CareersCitiesRustenburg() {
        return "http://www.careers24.com/jobs/lc-rustenburg/";
    }

    public static String CareersCitiesStanderton() {
        return "http://www.careers24.com/jobs/lc-standerton/";
    }

    public static String CareersCitiesUpington() {
        return "http://www.careers24.com/jobs/lc-upington/";
    }

    public static String CareersCitiesVryburg() {
        return "http://www.careers24.com/jobs/lc-vryburg/";
    }

    public static String CareersCitiesWestRand() {
        return "http://www.careers24.com/jobs/lc-west-rand/";
    }

    //Cities Urls End

    //Region Urls Start

    public static String CareersRegions() {
        return "http://www.careers24.com/jobs/browse/regions/";
    }

    public static String CareersRegionsEastCape() {
        return "http://www.careers24.com/jobs/lc-eastern-cape/";
    }

    public static String CareersRegionsKwaNatal() {
        return "http://www.careers24.com/jobs/lc-kwazulu-natal/";
    }

    public static String CareersRegionsNorthWest() {
        return "http://www.careers24.com/jobs/lc-north-west/";
    }

    public static String CareersRegionFreeState() {
        return "http://www.careers24.com/jobs/lc-free-state/";
    }

    public static String CareersRegionsLimpopo() {
        return "http://www.careers24.com/jobs/lc-limpopo/";
    }

    public static String CareersRegionsNorthernCape() {
        return "http://www.careers24.com/jobs/lc-northern-cape/";
    }

    public static String CareersRegionsGauteng() {
        return "http://www.careers24.com/jobs/lc-gauteng/";
    }

    public static String CareersRegionsMpumalanga() {
        return "http://www.careers24.com/jobs/lc-mpumalanga/";
    }

    public static String CareersRegionsWesternCape() {
        return "http://www.careers24.com/jobs/lc-western-cape/";
    }

    //Region Urls End

    //Sector Url Start
    public static String CareersWorkTypes() {
        return "http://www.careers24.com/jobs/browse/work-types/";
    }

    public static String CareersWorkTypesAcademic() {
        return "http://www.careers24.com/jobs/se-academic/";
    }

    public static String CareersWorkTypesAdvertising() {
        return "http://www.careers24.com/jobs/se-advertising/";
    }

    public static String CareersWorkTypesAviation() {
        return "http://www.careers24.com/jobs/se-aviation/";
    }

    public static String CareersWorkTypesCallCentre() {
        return "http://www.careers24.com/jobs/se-call-centre/";
    }

    public static String CareersWorkTypesConstruction() {
        return "http://www.careers24.com/jobs/se-construction/";
    }

    public static String CareersWorkTypesDefence() {
        return "http://www.careers24.com/jobs/se-defence/";
    }

    public static String CareersWorkTypesEducation() {
        return "http://www.careers24.com/jobs/se-education/";
    }

    public static String CareersWorkTypesEnvironmental() {
        return "http://www.careers24.com/jobs/se-environmental/";
    }

    public static String CareersWorkTypesFMCG() {
        return "http://www.careers24.com/jobs/se-fmcg/";
    }

    public static String CareersWorkTypesGraduate() {
        return "http://www.careers24.com/jobs/se-graduate/";
    }

    public static String CareersWorkTypesHospitality() {
        return "http://www.careers24.com/jobs/se-hospitality/";
    }

    public static String CareersWorkTypesInsurance() {
        return "http://www.careers24.com/jobs/se-insurance/";
    }

    public static String CareersWorkTypesIT() {
        return "http://www.careers24.com/jobs/se-it/";
    }

    public static String CareersWorkTypesLogistics() {
        return "http://www.careers24.com/jobs/se-logistics/";
    }

    public static String CareersWorkTypesMarketResearch() {
        return "http://www.careers24.com/jobs/se-market-research/";
    }

    public static String CareersWorkTypesMedical() {
        return "http://www.careers24.com/jobs/se-medical/";
    }

    public static String CareersWorkTypesNonProfit() {
        return "http://www.careers24.com/jobs/se-ngo-and-non-profit/";
    }

    public static String CareersWorkTypesCommunication() {
        return "http://www.careers24.com/jobs/se-pr-and-communication/";
    }

    public static String CareersWorkTypesPurchasing() {
        return "http://www.careers24.com/jobs/se-purchasing/";
    }

    public static String CareersWorkTypesResearch() {
        return "http://www.careers24.com/jobs/se-research/";
    }

    public static String CareersWorkTypesSecurity() {
        return "http://www.careers24.com/jobs/se-security/";
    }

    public static String CareersWorkTypesSports() {
        return "http://www.careers24.com/jobs/se-sports/";
    }

    public static String CareersWorkTypesTechnology() {
        return "http://www.careers24.com/jobs/se-technology/";
    }

    public static String CareersWorkTypesTravel() {
        return "http://www.careers24.com/jobs/se-travel-and-tourism/";
    }

    public static String CareersWorkTypesAccounting() {
        return "http://www.careers24.com/jobs/se-accounting/";
    }

    public static String CareersWorkTypesAgriculture() {
        return "http://www.careers24.com/jobs/se-agriculture/";
    }

    public static String CareersWorkTypesBanking() {
        return "http://www.careers24.com/jobs/se-banking/";
    }

    public static String CareersWorkTypesChemical() {
        return "http://www.careers24.com/jobs/se-chemical/";
    }

    public static String CareersWorkTypesConsulting() {
        return "http://www.careers24.com/jobs/se-consulting/";
    }

    public static String CareersWorkTypesDesign() {
        return "http://www.careers24.com/jobs/se-design-services/";
    }

    public static String CareersWorkTypesEngineering() {
        return "http://www.careers24.com/jobs/se-engineering/";
    }

    public static String CareersWorkTypesFashion() {
        return "http://www.careers24.com/jobs/se-fashion/";
    }

    public static String CareersWorkTypesGeneral() {
        return "http://www.careers24.com/jobs/se-general/";
    }

    public static String CareersWorkTypesHealthAndSafety() {
        return "http://www.careers24.com/jobs/se-health-and-safety/";
    }

    public static String CareersWorkTypesHR() {
        return "http://www.careers24.com/jobs/se-human-resources/";
    }

    public static String CareersWorkTypesInternet() {
        return "http://www.careers24.com/jobs/se-internet/";
    }

    public static String CareersWorkTypesLegal() {
        return "http://www.careers24.com/jobs/se-legal/";
    }

    public static String CareersWorkTypesManagement() {
        return "http://www.careers24.com/jobs/se-management/";
    }

    public static String CareersWorkTypesMarketing() {
        return "http://www.careers24.com/jobs/se-marketing/";
    }

    public static String CareersWorkTypesMining() {
        return "http://www.careers24.com/jobs/se-mining/";
    }

    public static String CareersWorkTypesPetrochemical() {
        return "http://www.careers24.com/jobs/se-petrochemical/";
    }

    public static String CareersWorkTypesProcurement() {
        return "http://www.careers24.com/jobs/se-procurement/";
    }

    public static String CareersWorkTypesRealEstate() {
        return "http://www.careers24.com/jobs/se-real-estate/";
    }

    public static String CareersWorkTypesRetail() {
        return "http://www.careers24.com/jobs/se-retail/";
    }

    public static String CareersWorkTypesSocialService() {
        return "http://www.careers24.com/jobs/se-social-services/";
    }

    public static String CareersWorkTypesStockbroking() {
        return "http://www.careers24.com/jobs/se-stockbroking/";
    }

    public static String CareersWorkTypesTelecoms() {
        return "http://www.careers24.com/jobs/se-telecommunications/";
    }

    public static String CareersWorkTypesWarehousing() {
        return "http://www.careers24.com/jobs/se-warehousing/";
    }

    public static String CareersWorkTypesAdmin() {
        return "http://www.careers24.com/jobs/se-admin/";
    }

    public static String CareersWorkTypesAutomative() {
        return "http://www.careers24.com/jobs/se-automotive/";
    }

    public static String CareersWorkTypesBusinessManagement() {
        return "http://www.careers24.com/jobs/se-business-management/";
    }

    public static String CareersWorkTypesClothing() {
        return "http://www.careers24.com/jobs/se-clothing/";
    }

    public static String CareersWorkTypesCruiseShip() {
        return "http://www.careers24.com/jobs/se-cruise-ship/";
    }

    public static String CareersWorkTypesEcommerce() {
        return "http://www.careers24.com/jobs/se-e-commerce/";
    }

    public static String CareersWorkTypesEntertainment() {
        return "http://www.careers24.com/jobs/se-entertainment/";
    }

    public static String CareersWorkTypesFinance() {
        return "http://www.careers24.com/jobs/se-finance/";
    }

    public static String CareersWorkTypesParastatals() {
        return "http://www.careers24.com/jobs/se-government-and-parastatals/";
    }

    public static String CareersWorkTypesFitnessAndBeauty() {
        return "http://www.careers24.com/jobs/se-health-fitness-and-beauty/";
    }

    public static String CareersWorkTypesImportExport() {
        return "http://www.careers24.com/jobs/se-import-and-export/";
    }

    public static String CareersWorkTypesInvestment() {
        return "http://www.careers24.com/jobs/se-investment/";
    }

    public static String CareersWorkTypesLifestyle() {
        return "http://www.careers24.com/jobs/se-lifestyle/";
    }

    public static String CareersWorkTypesManufacturing() {
        return "http://www.careers24.com/jobs/se-manufacturing/";
    }

    public static String CareersWorkTypesMedia() {
        return "http://www.careers24.com/jobs/se-media/";
    }

    public static String CareersWorkTypesMotoring() {
        return "http://www.careers24.com/jobs/se-motoring/";
    }

    public static String CareersWorkTypesPharmaceutical() {
        return "http://www.careers24.com/jobs/se-pharmaceutical/";
    }

    public static String CareersWorkTypesProperty() {
        return "http://www.careers24.com/jobs/se-property/";
    }

    public static String CareersWorkTypesRecruitment() {
        return "http://www.careers24.com/jobs/se-recruitment/";
    }

    public static String CareersWorkTypesSales() {
        return "http://www.careers24.com/jobs/se-sales/";
    }

    public static String CareersWorkTypesSoftSkills() {
        return "http://www.careers24.com/jobs/se-soft-skills/";
    }

    public static String CareersWorkTypesTechnical() {
        return "http://www.careers24.com/jobs/se-technical/";
    }

    public static String CareersWorkTypesTradesAndServices() {
        return "http://www.careers24.com/jobs/se-trades-and-services/";
    }

    //Sector Url End


// SA Site Page Objects End

// NG Site Page Objects Start


// NG Site Page Objects End

//ContactUs Start

    public static String ContactUsUrl() {
        return "http://www.careers24.com/info/contact/";
    }

    public static String ContactUsName() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_uxContactForm_uxName\"]";
    }

    public static String ContactUsEmail() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_uxContactForm_uxEmail\"]";
    }

    public static String ContactUsNumber() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_uxContactForm_uxTelephone\"]";
    }

    public static String ContactUsType() {
        return "//*[@id=\"jsbtn\"]";
    }

    public static String ContactUsReasonDrop() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_uxContactForm_jsFeedbackReason\"]";
    }

    public static String ContactUsReasonDrop1() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_uxContactForm_jsFeedbackReason\"]/option[3]";
    }

    public static String ContactUsMessage() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_uxContactForm_uxMessage\"]";
    }

    public static String ContactUsSend() {
        return "//*[@id=\"ctl00_ctl00_contentPrimaryPlaceHolder_contentMainAreaPlaceHolder_uxContactForm_uxSubmitButton\"]";
    }

//ContactUs End


    //Profile Improvement Start
    public static String ProfileLinURL() {
        return "http://www.careers24.com/candidate/profile/";
    }

    public static String ProfileImproveLink() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ctl04_divBox\"]/div[2]/ul/li[3]/a";
    } //http://www.careers24.com/candidate/profile/?wizard=improve

    public static String ImprovementJobTitle() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxJobTitle\"]";
    }

    public static String ImprovementCompany() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxCompanyName\"]";
    }

    public static String ImprovementLocation() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxLocation\"]";
    }

    public static String ImprovementSectorDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_ddlSectors\"]";
    }

    public static String ImprovementSectorDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_ddlSectors\"]/option[3]";
    }

    public static String ImprovementContractDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxJobTypeID\"]";
    }

    public static String ImprovementContractDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxJobTypeID\"]/option[3]";
    }

    public static String ImprovementDuties() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxDuties\"]";
    }

    public static String ImprovementStartMonthDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxDateFromMonth\"]";
    }

    public static String ImprovementStartMonthDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxDateFromMonth\"]/option[3]";
    }

    public static String ImprovementStartYearDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxDateFromYear\"]";
    }

    public static String ImprovementStartYearDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxDateFromYear\"]/option[10]";
    }

    public static String ImprovementEndMonthDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxDateToMonth\"]";
    }

    public static String ImprovementEndMonthDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxDateToMonth\"]/option[5]";
    }

    public static String ImprovementEndYearDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxDateToYear\"]";
    }

    public static String ImprovementEndYearDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxDateToYear\"]/option[5]";
    }

    public static String ImprovementSalary() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxSalary\"]";
    }

    public static String ImprovementLeaving() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_uxWorkHistory_whi_1_uxReasonForLeaving\"]";
    }

    public static String ImprovementSave1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_btnSaveEmpHist\"]";
    }

    public static String ImprovementQualificationLevelDrop() {
        return "//*[@id=\"uxEducationLevelID\"]";
    }

    public static String ImprovementQualificationLevelDrop1() {
        return "//*[@id=\"uxEducationLevelID\"]/option[5]";
    }

    public static String ImprovementQualification() {
        return "//*[@id=\"uxQualification\"]";
    }

    public static String ImprovementInstitution() {
        return "//*[@id=\"uxInstitution\"]";
    }

    public static String ImprovementYearCompleteDrop() {
        return "//*[@id=\"uxYearCompleted\"]";
    }

    public static String ImprovementYearCompleteDrop1() {
        return "//*[@id=\"uxYearCompleted\"]/option[3]";
    }

    public static String ImprovementMajors() {
        return "//*[@id=\"uxMajorsSubjects\"]";
    }

    public static String ImprovementSave2() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_Education1_uxSaveEducation\"]";
    }

    public static String ImproveSkill() {
        return "//*[@id=\"uxSkill\"]";
    }

    public static String ImproveLevelDrop() {
        return "//*[@id=\"uxRankingID\"]";
    }

    public static String ImproveLevelDrop1() {
        return "//*[@id=\"uxRankingID\"]/option[2]";
    }

    public static String ImproveExperienceDrop() {
        return "//*[@id=\"uxYearsExperienceID\"]";
    }

    public static String ImproveExperienceDrop1() {
        return "//*[@id=\"uxYearsExperienceID\"]/option[2]";
    }

    public static String ImproveSave3() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_Skill_uxSave\"]";
    }

    public static String ImproveCoverSkip() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_CoverNote_btnCancelCareerSummary\"]";
    }

    public static String ImproveDesiredJob() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_NextJob_uxDesiredJobTitle\"]";
    }

    public static String ImproveJobType() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_NextJob_uxJobTypeIDs_1\"]";
    }

    public static String ImproveDesiredSalaryMin() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_NextJob_uxDesiredSalaryFrom\"]";
    }

    public static String ImproveDesiredSalaryMax() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_NextJob_uxDesiredSalaryTo\"]";
    }

    public static String ImproveDesiredSalaryTimesDrop() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_NextJob_uxDesiredSalaryUnitID\"]";
    }

    public static String ImproveDesiredSalaryTimesDrop1() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_NextJob_uxDesiredSalaryUnitID\"]/option[1]";
    }

    public static String ImproveSave4() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_NextJob_uxSaveNextJob\"]";
    }

    public static String ImprovePhotoFinish() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ImproveProfile_AccountSettings_btnSaveAccountsettings\"]";
    }

//Profile Improvement END


//DropDowns START

    //SA
    public static String HomeLocationDrop() {
        return "//*[@id=\"rootItem\"]/span";
    }

    public static String HomeSearch() {
        return "//*[@id=\"inSearch\"]";
    }

    public static String JobsNav() {
        return "//*[@id=\"ctl00_ctl00_C24header1_linksContainer\"]/li[1]/div/a";
    }

    public static String EngConstNav() {
        return "//*[@id=\"ctl00_c24Verticalnavmenu_rprNavMenu_ctl02_lnknavItem\"]";
    }

    public static String EngConstLocation() {
        return "//*[@id=\"ddlLocations\"]";
    }

    public static String EngConstLocation1() {
        return "//*[@id=\"ddlLocations\"]/option[3]";
    }

    public static String FinanceNav() {
        return "//*[@id=\"ctl00_ctl00_c24Verticalnavmenu_rprNavMenu_ctl03_lnknavItem\"]";
    }

    public static String FinanceLocation() {
        return "//*[@id=\"ddlLocations\"]";
    }

    public static String FinanceLocation1() {
        return "//*[@id=\"ddlLocations\"]/option[5]";
    }

    public static String HospitalityNav() {
        return "//*[@id=\"ctl00_ctl00_c24Verticalnavmenu_rprNavMenu_ctl04_lnknavItem\"]";
    }

    public static String HospitalityLocation() {
        return "//*[@id=\"ddlLocations\"]";
    }

    public static String HospitalityLocation1() {
        return "//*[@id=\"ddlLocations\"]/option[5]";
    }

    public static String MarketMediaNav() {
        return "//*[@id=\"ctl00_ctl00_c24Verticalnavmenu_rprNavMenu_ctl05_lnknavItem\"]";
    }

    public static String MarketMedLocation() {
        return "//*[@id=\"ddlLocations\"]";
    }

    public static String MarketMedLocation1() {
        return "//*[@id=\"ddlLocations\"]/option[6]";
    }

    public static String OfficeNav() {
        return "//*[@id=\"ctl00_ctl00_c24Verticalnavmenu_rprNavMenu_ctl06_lnknavItem\"]";
    }

    public static String OfficeLocation() {
        return "//*[@id=\"ddlLocations\"]";
    }

    public static String OfficeLocation1() {
        return "//*[@id=\"ddlLocations\"]";
    }

    public static String TechNav() {
        return "//*[@id=\"ctl00_ctl00_c24Verticalnavmenu_rprNavMenu_ctl07_lnknavItem\"]";
    }

    public static String TechLocation() {
        return "//*[@id=\"ddlLocations\"]";
    }

    public static String TechLocation1() {
        return "//*[@id=\"ddlLocations\"]/option[7]";
    }

    public static String GraduationNav() {
        return "//*[@id=\"ctl00_ctl00_C24header1_linksContainer\"]/li[2]/div/a";
    }

    public static String GraduateLocation() {
        return "//*[@id=\"uxLocation\"]";
    }

    public static String GraduateLocation1() {
        return "//*[@id=\"uxLocation\"]/option[3]";
    }

    //End SA

    //NG

    public static String JobsNavNG() {
        return "//*[@id=\"ctl00_ctl00_C24header1_linksContainer\"]/li[1]/div/a";
    }

    public static String EngConstNavNG() {
        return "//*[@id=\"ctl00_c24Verticalnavmenu_rprNavMenu_ctl02_lnknavItem\"]";
    }

    public static String EngConstLocationNG() {
        return "//*[@id=\"ddlLocations\"]";
    }

    public static String EngConstLocation1NG() {
        return "//*[@id=\"ddlLocations\"]/option[3]";
    }

    public static String FinanceNavNG() {
        return "//*[@id=\"ctl00_ctl00_c24Verticalnavmenu_rprNavMenu_ctl03_lnknavItem\"]";
    }

    public static String FinanceLocationNG() {
        return "//*[@id=\"ddlLocations\"]";
    }

    public static String FinanceLocation1NG() {
        return "//*[@id=\"ddlLocations\"]/option[5]";
    }

    public static String MarketMediaNavNG() {
        return "//*[@id=\"ctl00_ctl00_c24Verticalnavmenu_rprNavMenu_ctl04_lnknavItem\"]";
    }

    public static String MarketMedLocationNG() {
        return "//*[@id=\"ddlLocations\"]";
    }

    public static String MarketMedLocation1NG() {
        return "//*[@id=\"ddlLocations\"]/option[6]";
    }

    public static String OfficeNavNG() {
        return "//*[@id=\"ctl00_ctl00_c24Verticalnavmenu_rprNavMenu_ctl05_lnknavItem\"]";
    }

    public static String OfficeLocationNG() {
        return "//*[@id=\"ddlLocations\"]";
    }

    public static String OfficeLocation1NG() {
        return "//*[@id=\"ddlLocations\"]/option[3]";
    }

    public static String TechNavNG() {
        return "//*[@id=\"ctl00_ctl00_c24Verticalnavmenu_rprNavMenu_ctl06_lnknavItem\"]";
    }

    public static String TechLocationNG() {
        return "//*[@id=\"ddlLocations\"]";
    }

    public static String TechLocation1NG() {
        return "//*[@id=\"ddlLocations\"]/option[7]";
    }

    //End NG

//DropDowns END

//ShareThis START

    public static String JobPageNavigate() {
        return "http://www.careers24.com/jobs/lc-south-africa/?sort=dateposted";
    }

    public static String EmailShare() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ShareTeaser1_datestamp\"]/ul/li[1]/a";
    }

    public static String FacebookShare() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ShareTeaser1_datestamp\"]/ul/li[2]/a";
    }

    public static String FacebookLink() {
        return "https://www.facebook.com/sharer/sharer.php?u=http://www.careers24.com/jobs/lc-east-rand/kw-admin-clerk/";
    }

    public static String TwitterShare() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ShareTeaser1_datestamp\"]/ul/li[3]/a";
    }

    public static String TwitterShareLink() {
        return "https://twitter.com/login?redirect_after_login=%2Fhome%3Fstatus%3Dhttp%3A%2F%2Fwww.careers24.com%2Fjobs%2Flc-east-rand%2Fkw-admin-clerk%2F%2520-%2520Find%2520your%2520next%2520job%21%2520on%2520http%3A%2F%2Fwww.careers24.com%2C%2520leading%2520job%2520portal%2520in%2520SA%2520wi...";
    }

    public static String LinkedIn() {
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_ShareTeaser1_datestamp\"]/ul/li[4]/a";
    }

    public static String LinkedInLink() {
        return "https://www.linkedin.com/uas/login?session_redirect=https%3A%2F%2Fwww%2Elinkedin%2Ecom%2FshareArticle%3Fsource%3Dwww%252Ecareers24%252Ecom%26title%3DAdmin%2BClerk%2BJobs%2Bin%2BEast%2BRand%26summary%3Dhttp%253A%252F%252Fwww%252Ecareers24%252Ecom%2Bis%2Ba%2Bleading%2Bjob%2Bportal%2Bin%2BSouth%2BAfrica%2Bwith%2Bthousands%2Bof%2Bvacancies%252E%2BFind%2Byour%2Bnext%2Bjob%2Bnow%2521%26mini%3Dtrue%26url%3Dhttp%253A%252F%252Fwww%252Ecareers24%252Ecom%252Fjobs%252Flc-east-rand%252Fkw-admin-clerk%252F";
    }

    public static String CareerAdviceShareNav() {
        return "http://www.careers24.com/career-advice/cv-cover-letter-advice/4-online-courses-to-help-you-improve-your-cv-writing-skills-immediately-20170207";
    }

    public static String CareersAdviceShareFaceBook() {
        return "//*[@id=\"aspnetForm\"]/div[4]/div[3]/div/article/div[1]/ul/li[2]/a";
    }

    public static String CareersAdviceShareFaceBookLink() {
        return "https://www.facebook.com/sharer/sharer.php?s=100&p[url]=http://www.careers24.com/career-advice/cv-cover-letter-advice/4-online-courses-to-help-you-improve-your-cv-writing-skills-immediately-20170207&p[images][0]=&p[title]=&p[summary]=";
    }

    public static String CareersAdviceShareTwitter() {
        return "//*[@id=\"aspnetForm\"]/div[4]/div[3]/div/article/div[1]/ul/li[3]/a";
    }

    public static String CareersAdviceShareTwitterLink() {
        return "https://twitter.com/login?redirect_after_login=%2Fhome%3Fstatus%3Dhttp%3A%2F%2Fwww.careers24.com%2Fcareer-advice%2Fcv-cover-letter-advice%2F4-online-courses-to-help-you-improve-your-cv-writing-skills-immediately-20170207";
    }

    public static String CareersAdviceShareLinkedIn() {
        return "//*[@id=\"aspnetForm\"]/div[4]/div[3]/div/article/div[1]/ul/li[4]/a";
    }

    public static String CareersAdviceShareLinkedInLink() {
        return "https://www.linkedin.com/uas/login?session_redirect=https%3A%2F%2Fwww%2Elinkedin%2Ecom%2FshareArticle%3Ftitle%3D%26mini%3Dtrue%26url%3Dhttp%253A%252F%252Fwww%252Ecareers24%252Ecom%252Fcareer-advice%252Fcv-cover-letter-advice%252F4-online-courses-to-help-you-improve-your-cv-writing-skills-immediately-20170207";
    }

    public static String CareersAdviceShareGoogle() {
        return "//*[@id=\"aspnetForm\"]/div[4]/div[3]/div/article/div[1]/ul/li[5]/a";
    }

    public static String CareersAdviceShareGoogleLink() {
        return "https://plus.google.com/up/accounts/upgrade/?continue=https://plus.google.com/share?url%3Dhttp://www.careers24.com/career-advice/cv-cover-letter-advice/4-online-courses-to-help-you-improve-your-cv-writing-skills-immediately-20170207";
    }

    public static String CareersAdviceShareEmail() {
        return "//*[@id=\"aspnetForm\"]/div[4]/div[3]/div/article/div[1]/ul/li[7]/a";
    }

//ShareThis END

//Footer Testing START

    public static String FooterTerms() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[1]/p[3]/a";
    }

    public static String AboutUs() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[2]/ul/li[1]/a";
    }

    public static String FooterContactUs() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[2]/ul/li[2]/a";
    }

    public static String AdvertiseWithUS() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[2]/ul/li[3]/a";
    }

    public static String News24() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divPartnerSites\"]/ul/li[1]/a";
    }

    public static String OLX() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divPartnerSites\"]/ul/li[2]/a";
    }

    public static String Property24() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divPartnerSites\"]/ul/li[3]/a";
    }

    public static String AppDown() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_lnkAppDownload\"]";
    }

    public static String FAQ() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[4]/ul/li[2]/a";
    }

    public static String Mobile() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_linkMobileSite\"]";
    }

    public static String RecDirectory() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[4]/ul/li[4]/a";
    }

    public static String SiteMap() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[4]/ul/li[5]/a";
    }

    public static String Testimonials() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[4]/ul/li[6]/a";
    }

    public static String Widgets() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[4]/ul/li[7]/a";
    }

    public static String FollowTwitter() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[6]/div/span[1]/a";
    }

    public static String FollowFacebook() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_lnkFacebookGenericUrl\"]";
    }

    public static String FollowGoogle() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[6]/div/span[3]/a";
    }

    public static String FollowLinkedIn() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[6]/div/span[4]/a";
    }

    public static String FollowInsta() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_divFooter\"]/div[6]/div/span[5]/a";
    }

    public static String FooterLocationDrop() {
        return "//*[@id=\"ctl00_contentFullFooterPlaceHolder_C24footer1_ddlPicker\"]/a";
    }

//Footer Testing END

//Vacancy Count Breakdown START

    public static String AdminLoginUserSA() {
        return "//*[@id=\"uxUsername\"]";
    }

    public static String AdminLoginPassSA() {
        return "//*[@id=\"uxPassword\"]";
    }

    public static String AdminLoginButton() {
        return "//*[@id=\"uxLogin\"]";
    }

    public static String VacancyCountNav() {
        return "https://admin.careers24.com/modules/reporting/vacancycounts/";
    }

    public static String OrderByLocation() {
        return "//*[@id=\"ctl00_MainContent_gvVacancyCounts\"]/tbody/tr[1]/th[1]/a";
    }

    public static String OrderBySector() {
        return "//*[@id=\"ctl00_MainContent_gvVacancyCounts\"]/tbody/tr[1]/th[2]/a";
    }

    public static String OrderByCount() {
        return "//*[@id=\"ctl00_MainContent_gvVacancyCounts\"]/tbody/tr[1]/th[3]/a";
    }

    public static String OrderByURL() {
        return "//*[@id=\"ctl00_MainContent_gvVacancyCounts\"]/tbody/tr[1]/th[4]/a";
    }


//Vacancy Count Breakdown END

//Active Companies START

    public static String ActiveCompaniesNav() {
        return "https://admin.careers24.com/reporting/companies/";
    }

//Active Companies END

//Candidate Aquisition Report By Source START

    public static String CandidateAquisitionReportSourceUrl() {
        return "https://admin.careers24.com//reporting/acquisition/";
    }

    public static String DateFrom() {
        return "/html/body/div[2]/div[3]/div/div/div/div[1]/div[1]/span[2]/span/span/span";
    }

    public static String SeeCandidates() {
        return "//*[@id=\"results\"]/div/table/tbody/tr[2]/td[2]/a";
    }

    public static String SourceDrillDown() {
        return "//*[@id=\"results\"]/div/table/tbody/tr[2]/td[6]/a";
    }

    public static String SectorDrillDown() {
        return "//*[@id=\"results\"]/div/table/tbody/tr[2]/td[7]/a";
    }

//Candidate Aquisition Report By Source END

//Candidate Aquisition Report By Sector START

    public static String CandidateAquisitionReportSectorUrl() {
        return "https://admin.careers24.com//reporting/acquisitionsector/";
    }

    public static String DateFromSec() {
        return "/html/body/div[2]/div[3]/div/div/div/div[1]/div[1]/span[2]/span/span/span";
    }

    public static String SourceDrillDownSec() {
        return "//*[@id=\"sector-results\"]/div[2]/table/tbody/tr[2]/td[5]/a";
    }

    public static String TopPostedJobTitles() {
        return "//*[@id=\"sector-results\"]/div[2]/table/tbody/tr[2]/td[6]/a";
    }

    public static String TopSearchedJobdDrillDown() {
        return "//*[@id=\"sector-results\"]/div[2]/table/tbody/tr[2]/td[7]/a";
    }

//Candidate Aquisition Report By Sector END

// Recruiter Applicants Quality START

    public static String RecruiterApplicantsQuality() {
        return "https://admin.careers24.com/reporting/applicationrelevancy/";
    }

    public static String DateFromQuality() {
        return "/html/body/div[2]/div[3]/div/div/div/div[1]/div[1]/span[2]/span/span/span";
    }

// Recruiter Applicants Quality END

// Recruiter Applicants Quality Drilldown START

    public static String RecruiterApplicantsQualityDrillDownUrl() {
        return "https://admin.careers24.com/reporting/applicationrelevancydetail/";
    }


// Recruiter Applicants Quality Drilldown END

//Applications and Matched Applications START

    public static String ApplicationsAndMatchedApplicationUrl() {
        return "https://admin.careers24.com/reporting/acquisitionapplicationmatch/";
    }

//Applications and Matched Applications END

//Listings START

    public static String ListingUrl() {
        return "https://admin.careers24.com/Dashboard/Listings";
    }

    public static String ListFilter() {
        return "//*[@id=\"ddlTimePeriod\"]";
    }

    public static String ByMonth() {
        return "//*[@id=\"ddlTimePeriod\"]/option[2]";
    }

    public static String ByWeek() {
        return "//*[@id=\"ddlTimePeriod\"]/option[1]";
    }

    public static String TotalListingsBlock() {
        return "//*[@id=\"listings-above-fold\"]/div[1]"; //*[@id="listings-above-fold"]/div[2]/div/div
    }

    public static String NewListingSABlock() {
        return "//*[@id=\"listings-above-fold\"]/div[2]";
    }

    public static String TotalListingsNGBLock() {
        return "//*[@id=\"listings-above-fold\"]/div[3]";
    }

    public static String NewListingsNGBlock() {
        return "//*[@id=\"listings-above-fold\"]/div[4]";
    }

    public static String ComparativeListingsSA() {
        return "//*[@id=\"comparativelisting_sa_panel\"]";
    }

    public static String ComparativeListingsNG() {
        return "//*[@id=\"comparativelisting_ng_panel\"]";
    }

    public static String TotalListingsSAGraph() {
        return "//*[@id=\"totallisting_sa_panel\"]";
    }

    public static String TotalListingsNGGraph() {
        return "//*[@id=\"totallisting_ng_panel\"]";
    }

    public static String ListingsByTypeSA() {
        return "//*[@id=\"listings-stuck-in-the-middle\"]/div[3]/div/div";
    }

    public static String ListingByTypeNG() {
        return "//*[@id=\"listings-stuck-in-the-middle\"]/div[4]/div/div";
    }

    public static String TopSectorsSA() {
        return "//*[@id=\"listings-stuck-in-the-middle\"]/div[5]/div/div";
    }

    public static String TopSectorsNG() {
        return "//*[@id=\"listings-stuck-in-the-middle\"]/div[6]/div/div";
    }

    public static String TopLocationsSA() {
        return "//*[@id=\"listings-stuck-in-the-middle\"]/div[7]/div/div";
    }

    public static String TopLocationsNG() {
        return "//*[@id=\"listings-stuck-in-the-middle\"]/div[8]/div/div";
    }

//Listings END


//Candidate Engagement START

    public static String CandidateEngagementUrl() {
        return "https://admin.careers24.com/dashboard/candidateengagement";
    }

    public static String TotalRegCandidatesZA() {
        return "//*[@id=\"candidate-engage-above-fold\"]/div[1]/div/div";
    }

    public static String TotalCompletedProfilesZA() {
        return "//*[@id=\"candidate-engage-above-fold\"]/div[2]/div/div";
    }

    public static String TotalRegCandidatesNG() {
        return "//*[@id=\"candidate-engage-above-fold\"]/div[3]/div/div";
    }

    public static String TotalCompletedProfilesNG() {
        return "//*[@id=\"candidate-engage-above-fold\"]/div[4]/div/div";
    }

    public static String TotalRegCandidatesKE() {
        return "//*[@id=\"candidate-engage-above-fold\"]/div[5]/div/div";
    }

    public static String TotalCompletedProfilesKE() {
        return "//*[@id=\"candidate-engage-above-fold\"]/div[6]/div/div";
    }

    public static String RealTimeSessionWebZA() {
        return "//*[@id=\"active-sessions\"]/div[1]/div/div";
    }

    public static String RealTimeSessionsMobiZA() {
        return "//*[@id=\"active-sessions\"]/div[2]/div/div";
    }

    public static String TotalSessionsAppZA() {
        return "//*[@id=\"active-sessions\"]/div[3]/div/div";
    }

    public static String RealTimeSessionsWebNG() {
        return "//*[@id=\"active-sessions\"]/div[4]/div/div";
    }

    public static String RealTimeSessionsMobiNG() {
        return "//*[@id=\"active-sessions\"]/div[5]/div/div";
    }

    public static String TotalSessionsAppNG() {
        return "//*[@id=\"active-sessions\"]/div[6]/div/div";
    }

    public static String CandidateRegSAGraph() {
        return "//*[@id=\"totalregistrations_sa_panel\"]";
    }

    public static String CandidateRegNGGraph() {
        return "//*[@id=\"totalregistrations_ng_panel\"]";
    }

    public static String JobApplicationsSAGraph() {
        return "//*[@id=\"totalapplications_sa_panel\"]";
    }
    public static String SessionsSA(){
        return "//*[@id=\"totalsessions_sa_panel\"]";
    }
    public static String SessionsNG(){
        return "//*[@id=\"totalsessions_ng_panel\"]";
    }
    public static String TimeOnSiteMinutesSA(){
        return "//*[@id=\"totaltimeonsite_sa_panel\"]";
    }
    public static String TimeOnSiteMinutesNG(){
        return "//*[@id=\"totaltimeonsite_ng_panel\"]";
    }
    public static String PageViewsSA(){
        return "//*[@id=\"pageviews_sa_panel\"]";
    }
    public static String PageViewsNG(){
        return "//*[@id=\"pageviews_ng_panel\"]";
    }
    public static String PageViewsPerSessionSA(){
        return "//*[@id=\"pageviewssess_sa_panel\"]";
    }
    public static String PageViewsPerSessionNG(){
        return "//*[@id=\"pageviewssess_ng_panel\"]";
    }


//Candidate Engagement END

//Recruiter Engagement START

    public static String RecruiterEngagementUrl(){
        return "https://admin.careers24.com/dashboard/recruiterengagement";
    }
    public static String Filter(){
        return "//*[@id=\"ddlTimePeriod\"]";
    }
//    public static String WeekFilter(){
//        return "//*[@id=\"ddlTimePeriod\"]/option[1]";
//    }
//    public static String MonthFilter(){
//        return "//*[@id=\"ddlTimePeriod\"]/option[2]";
//    }
    public static String TotalActiveRecruitersSA(){
        return "//*[@id=\"recruiter-engage-summary\"]/div[1]/div/div";
    }
    public static String TotalActiveRecruitersNG(){
        return "//*[@id=\"recruiter-engage-summary\"]/div[2]/div/div";
    }
    public static String TotalActivePayGSA(){
        return "//*[@id=\"recruiter-engage-summary\"]/div[3]/div/div";
    }
    public static String TotalActivePayGNG(){
        return "//*[@id=\"recruiter-engage-summary\"]/div[4]/div/div";
    }
    public static String AverageJobsPostedSA(){
        return "//*[@id=\"recruiter-engage-vacancy\"]/div[1]/div/div";
    }
    public static String AverageCvDownloadSA(){
        return "//*[@id=\"recruiter-engage-vacancy\"]/div[2]/div/div";
    }
    public static String AverageJobsPostedNG(){
        return "//*[@id=\"recruiter-engage-vacancy\"]/div[3]/div/div";
    }
    public static String AverageCvDowloadNG(){
        return "//*[@id=\"recruiter-engage-vacancy\"]/div[4]/div/div";
    }
    public static String AverageApplicationsSA(){
        return "//*[@id=\"recruiter-engage-vacancy\"]/div[5]/div/div";
    }
    public static String AverageClicksExternalJobsSA(){
        return "//*[@id=\"recruiter-engage-vacancy\"]/div[6]/div/div";
    }
    public static String AverageApplicationsNG(){
        return "//*[@id=\"recruiter-engage-vacancy\"]/div[7]/div/div";
    }
    public static String AverageClicksExternalJobsNG(){
        return "//*[@id=\"recruiter-engage-vacancy\"]/div[8]/div/div";
    }
    public static String CandidateSearchesGraphSA(){
        return "//*[@id=\"totalsearches_sa_panel\"]";
    }
    public static String CandidateSearchesGraphNG(){
        return "//*[@id=\"totalsearches_ng_panel\"]";
    }
    public static String CvDownloadsGraphSA(){
        return "//*[@id=\"cv_chart_sa_panel\"]";
    }
    public static String CvDownloadsGraphNG(){
        return "//*[@id=\"cv_chart_ng_panel\"]";
    }

//Recruiter Engagement END

//Sales and Revenue START

    public static String SalesAndRevenueUrl(){
        return "https://admin.careers24.com/dashboard/salesandrevenue";
    }
    public static String SFliter(){
        return "//*[@id=\"ddlTimePeriod\"]";
    }
    public static String NewContractTarget(){
        return "//*[@id=\"sales-and-revenue-monthly-component\"]/div[1]/div";
    }
    public static String AdHocSales(){
        return "//*[@id=\"sales-and-revenue-monthly-component\"]/div[2]/div";
    }
    public static String ChurnRate(){
        return "//*[@id=\"sales-and-revenue-monthly-component\"]/div[3]/div";
    }
    public static String NetAddClients(){
        return "//*[@id=\"sales-and-revenue-monthly-component\"]/div[4]/div";
    }
    public static String SalesTeam(){
        return "//*[@id=\"sales-and-revenue-monthly-component\"]/div[5]/div";
    }
    public static String NewContractValueMonth(){
        return "//*[@id=\"newContractValuePerMonth_panel\"]";
    }
    public static String NewContractValueAccumulated(){
        return "//*[@id=\"newContractValueAccumulated_panel\"]";
    }
    public static String NewContractsMonth(){
        return "//*[@id=\"contract_count_chart_new_panel\"]";
    }
    public static String NewContractsAccumulated(){
        return "//*[@id=\"contract_count_chart_accum_panel\"]";
    }
    public static String AverageContractDurationMonth(){
        return "//*[@id=\"contract_avg_duration_panel\"]";
    }
    public static String AverageContractValueMonth(){
        return "//*[@id=\"contract_avg_value_panel\"]";
    }
    public static String Revenue(){
        return "//*[@id=\"total_monthly_revenue_graph_panel\"]";
    }
    public static String OperatingResult(){
        return "//*[@id=\"operating_cost_graph_panel\"]";
    }

//Sales and Revenue END


//CandidatesPage START

    public static String CandidatePageUrl(){
        return "https://admin.careers24.com/data/candidate/";
    }
    public static String FilterRef(){
        return "//*[@id=\"txt-ref\"]";
    }
    public static String FilterName(){
        return "//*[@id=\"txt-name\"]";
    }
    public static String FilterSurname(){
        return "//*[@id=\"txt-surname\"]";
    }
    public static String FilterEmail(){
        return "//*[@id=\"txt-email\"]";
    }
    public static String FilterActiveDrop(){
        return "//*[@id=\"filter-status\"]";
    }
    public static String FilterActiveDrop1(){
        return "//*[@id=\"filter-status\"]/option[2]";
    }
    public static String FilterSearchBtn(){
        return "//*[@id=\"btn-search\"]";
    }
    public static String FilterPager(){
        return "//*[@id=\"pagination-demo\"]";
    }
    public static String FilterPage2(){
        return "//*[@id=\"pagination-demo\"]/li[4]/a";
    }
    public static String ViewApplicationsBtn(){
        return "/html/body/div[2]/div[3]/div/div/div/div[3]/div/div/table/tbody/tr[2]/td[9]/a[2]";
    }
    public static String EditCandidateBtn(){
        return "/html/body/div[2]/div[3]/div/div/div/div[3]/div/div/table/tbody/tr[2]/td[9]/a[3]";
    }


//CandidatesPage END

//RecruitersPage START

    public static String RecruitersPageUrl(){
        return "https://admin.careers24.com/moderation/recruiters/";
    }

//RecruitersPage END

//RecruiterLogin START

    public static String LogIn(){
        return "//*[@id=\"pnlLoggedOut\"]/a[2]";
    }
    public static String LoginRecEmail(){
        return "//*[@id=\"uxEmail\"]";
    }
    public static String LoginRecPassword(){
        return "//*[@id=\"ctl00_ctl00_C24header1_C24login1_uxPassword\"]";
    }
    public static String LoginRecBtn(){
        return "//*[@id=\"ctl00_ctl00_C24header1_C24login1_uxLogin\"]";
    }

//RecruiterLogin END

//RecruiterSignUpSA START

    public static String SignUpLink(){
        return "//*[@id=\"pnlLoggedOut\"]/a";
    }
    public static String RegisterAsRecruiter(){
        return "//*[@id=\"ctl00_contentPrimaryPlaceHolder_divRecruiterSignUp\"]/p/a";
    }
    public static String RecFirstName(){
        return "//*[@id=\"ctl00_MainContent_uxFirstName\"]";
    }
    public static String RecLastName(){
        return "//*[@id=\"ctl00_MainContent_uxLastName\"]";
    }
    public static String RecEmail(){
        return "//*[@id=\"ctl00_MainContent_uxEmail\"]";
    }
    public static String RecEmailConfirm(){
        return "//*[@id=\"ctl00_MainContent_uxEmailConfirm\"]";
    }
    public static String RecPassword(){
        return "//*[@id=\"ctl00_MainContent_uxPassword\"]";
    }
    public static String RecContactNo(){
        return "//*[@id=\"ctl00_MainContent_uxContactNumber\"]";
    }
    public static String RecCompanyName(){
        return "//*[@id=\"ctl00_MainContent_uxCompanyName\"]";
    }
    public static String RecAddresss(){
        return "//*[@id=\"ctl00_MainContent_uxAddressLine1\"]";
    }
    public static String RecCity(){
        return "//*[@id=\"ctl00_MainContent_uxAddressCity\"]";
    }
    public static String RecPostCode(){
        return "//*[@id=\"ctl00_MainContent_uxAddressPostCode\"]";
    }
    public static String RecTC(){
        return "//*[@id=\"ctl00_MainContent_uxAcceptTerms\"]";
    }
    public static String RecNext1(){
        return "//*[@id=\"ctl00_MainContent_btnNext\"]";
    }
    public static String RecLogOut(){
        return "/html/body/header/section/div/div/div[3]/div/nav/div]";
    }

//RecruiterSignUp SA END

//CandidateSearch START

    public static String ModelClick(){
        return "//*[@id=\"welcomeModal\"]/div/div[1]/section/div[2]/div[2]/button";
    }
    public static String CandidateSearchNav(){
        return "//*[@id=\"ctl00_ucSideBar_liCandidateSearch\"]/a";
    }
    public static String ClickBlank(){
        return "//*[@id=\"Div1\"]/ul";
    }
    public static String CurrentJobEntry1(){
        return "//*[@id=\"Div1\"]/ul/li[1]/div/div/div[3]/span/input";
    }
    public static String CurrentJobEntry2(){
        return "//*[@id=\"Div1\"]/ul/li[1]/div/div/div[3]/span/input";
    }
    public static String CurrentJobEntry3(){
        return "//*[@id=\"Div1\"]/ul/li[1]/div/div/div[3]/span/input";
    }
    public static String Keyword1(){
        return "//*[@id=\"Div1\"]/ul/li[2]/div/div/div[3]/input";
    }
    public static String Keyword2(){
        return "//*[@id=\"Div1\"]/ul/li[2]/div/div/div[3]/input";
    }
    public static String Keyword3(){
        return "//*[@id=\"Div1\"]/ul/li[2]/div/div/div[3]/input";
    }
    public static String LocationDrop(){
        return "//*[@id=\"ctl00_scripts_ctl00_uxLocation_locationName\"]"; //*[@id="ctl00_scripts_ctl00_uxLocation_locationName"]
    }
    public static String LocationDrop1(){
        return "//*[@id=\"ctl00_scripts_ctl00_uxLocation_locationContent\"]/li[1]"; //*[@id="ctl00_scripts_ctl00_uxLocation_locationContent"]/li[1]
    }
//CandidateSearch END

//*****************ATS TESTING OBJECTS START*****************

    public static String RecDashURL(){ return "https://simplify.hr/Vacancies";}

    //Registering Recruiter START

    public static String SimplifyRegUrl(){
        return "https://www.simplify.hr/Account/Register";
    }
    public static String SimplifyRegFirstName(){
        return "//*[@id=\"FirstName\"]";
    }
    public static String SimplifyRegLastName(){
        return "//*[@id=\"LastName\"]";
    }
    public static String SimplifyRegCompanyEmail(){
        return "//*[@id=\"Email\"]";
    }
    public static String SimplifyRegPassword(){
        return "//*[@id=\"Password\"]";
    }
    public static String SimplifyRegNowButton() {
        return "/html/body/div/div/div/div[2]/form/div[6]/input";
    }
    public static String SimplifyCompanyName(){
        return "//*[@id=\"CompanyName\"]";
    }
    public static String SimplifyCompanyWeb(){
        return "//*[@id=\"CompanyWebsite\"]";
    }
    public static String SimplifyTel(){
        return "//*[@id=\"PhoneNumber\"]";
    }
    public static String SimplifyCompanyIndustryDrop(){
        return "//*[@id=\"ddlIndustry\"]";
    }
    public static String SimplifyCompanyIndustryDrop1(){
        return "//*[@id=\"ddlIndustry\"]/option[2]";
    }
    public static String SimplifyEmployeesDrop(){
        return "//*[@id=\"ddlNoOfEmployess\"]";
    }
    public static String SimplifyEmployeesDrop1(){
        return "//*[@id=\"ddlNoOfEmployess\"]/option[2]";
    }
    public static String SimplifyGetStartedBtn(){
        return "/html/body/div/div/div/div[2]/div/form/div[7]/input";
    }

    //Registering Recruiter END

    //Recruiter login START

    public static String SimplifyLoginUrl(){
        return "https://simplify.hr/account/login";
    }
    public static String SimplifyLoginEmail(){
        return "//*[@id=\"Email\"]"; //*[@id="Email"]
    }
    public static String SimplifyLoginPassword(){
        return "//*[@id=\"Password\"]";
    }
    public static String SimplifyLoginBtn(){
        return "/html/body/div/div/form/div[2]/div[3]/div/input";
    }

    //Recruiter Login END

    //Vacancy Details START

    public static String SimplifyPostUrl(){
        return "https://simplify.hr/Vacancies/Vacancy";
    }
    public static String SimplifyJobTitle(){
        return "//*[@id=\"Vacancy_JobTitle\"]";
    }
    public static String SimplifyDepartmentDrop(){
        return "//*[@id=\"ddlDivision\"]";
    }
    public static String SimplifyDepartmentDrop1(){
        return "//*[@id=\"ddlDivision\"]/option[2]";
    }
    public static String SimplifyBusinessUnitDrop() {return "//*[@id=\"ddlBusinessUnit\"]";}
    public static String SimplifyBusinessUnitDrop1() {return "//*[@id=\"ddlBusinessUnit\"]/option[2]";}
    // Description field is handled by TinyMce
    public static String EmployTypeDrop(){
        return "//*[@id=\"Vacancy_EmploymentTypeId\"]";
    }
    public static String EmployTypeDrop1(){
        return "//*[@id=\"Vacancy_EmploymentTypeId\"]/option[2]";
    }
    public static String MinExperienceDrop(){
        return "//*[@id=\"Vacancy_ExperienceLevelId\"]";
    }
    public static String MinExperienceDrop1(){
        return "//*[@id=\"Vacancy_ExperienceLevelId\"]/option[2]";
    }
    public static String PrimaryIndustryDrop(){
        return "//*[@id=\"Vacancy_IndustryId\"]";
    }
    public static String PrimaryIndustryDrop1(){
        return "//*[@id=\"Vacancy_IndustryId\"]/option[2]";
    }
    public static String JobFunctionDrop(){
        return "//*[@id=\"Vacancy_FunctionalAreaId\"]";
    }
    public static String JobFunctionDrop1(){
        return "//*[@id=\"Vacancy_FunctionalAreaId\"]/option[5]";
    }
    public static String MinSalary(){
        return "//*[@id=\"Vacancy_SalaryMin\"]";
    }
    public static String MaxSalary(){
        return "//*[@id=\"Vacancy_SalaryMax\"]";
    }
    public static String LocationCountryDrop(){
        return "//*[@id=\"Vacancy_CountryId\"]";
    }
    public static String LocationCountryDrop1(){
        return "//*[@id=\"Vacancy_CountryId\"]/option[5]";
    }
    public static String LocationState(){
        return "//*[@id=\"Vacancy_Address1\"]";
    }
    public static String LocationCity(){
        return "//*[@id=\"Vacancy_CityName\"]";
    }
    public static String PostCode(){
        return "//*[@id=\"Vacancy_Address3\"]";
    }
    public static String SensitiveMinSalary(){
        return "//*[@id=\"Vacancy_InternalSalaryMin\"]";
    }
    public static String SensitiveMaxSalary(){
        return "//*[@id=\"Vacancy_InternalSalaryMax\"]";
    }
    public static String InternalNotes(){
        return "//*[@id=\"Vacancy_InternalNotes\"]";
    }
    public static String SaveAndContinue() {return"//*[@id=\"vacancy-save-and-continue\"]";}

    public static String AddNewMemDrop() {return"//*[@id=\"panel-heading\"]";}
    public static String AddNewMemFirstName() {return"//*[@id=\"txtFirstName\"]";}
    public static String AddNewMemLastName() {return "//*[@id=\"txtLastName\"]";}
    public static String AddNewMemEmail() {return "//*[@id=\"txtEmailTM\"]";}
    public static String SendInvite() { return "//*[@id=\"sendInvite\"]";}

    public static String SelectExistingExternalMemberDrop() {return "//*[@id=\"vacancy-form\"]/div/div[3]/div[6]/div/div[1]/select";}
    public static String SelectExistingExternalMemberDrop1() {return "//*[@id=\"vacancy-form\"]/div/div[3]/div[6]/div/div[1]/select/option[3]";}
    public static String AddExistingExternalMemberAddBtn() {return "//*[@id=\"addExistingExternalTeamMember\"]";}

    public static String InviteExternalRecruitersDrop() {return "//*[@id=\"btnInviteExternalRecruiters\"]";}
    public static String InviteExternalFullName() {return "//*[@id=\"txtFullName\"]";} //*[@id="txtFullName"]
    public static String InviteExternalEmail() {return "//*[@id=\"txtEmail\"]";}
    public static String InviteExternalCompany() {return "//*[@id=\"txtCompanyName\"]";} //*[@id="txtCompanyName"]
    public static String InviteExternalBtn() {return "//*[@id=\"externalRecContainer\"]/div[3]/div[1]/button";} //*[@id="externalRecContainer"]/div[3]/div[1]/button
    public static String PublishBtn(){
        return "//*[@id=\"vacancy-publish\"]";
    }
    //Vacancy Details END

    //Add Candidate START

    public static String CandidateDashURL() {return "https://simplify.hr/Candidates/Index";}
    public static String AddCandidateDrop() {return "/html/body/div[1]/div[3]/div[8]/div[1]/div/button";}
    public static String AddCandidateManually() {return "/html/body/div[1]/div[3]/div[8]/div[1]/div/ul/li[1]/a";}
    public static String AddCandidateFirstName() {return "//*[@id=\"FirstName\"]";}
    public static String AddCandidateLastName() {return "//*[@id=\"LastName\"]";}
    public static String AddCandidateEmail() {return "//*[@id=\"Email\"]";}
    public static String AddCandidateCountryDrop() {return "//*[@id=\"CountryId\"]";}
    public static String AddCandidateProvince() {return "//*[@id=\"Address2\"]";} //*[@id="Address2"]
    public static String AddCandidateCity() {return "//*[@id=\"CityName\"]";}
    public static String AddCandidateAddress() {return "//*[@id=\"Address1\"]";}
    public static String AddCandidatePostCode() {return "//*[@id=\"Address3\"]";}
    public static String AddCandidatePhone() {return "//*[@id=\"Phone\"]";}
    public static String AddCandidateEthnicityDrop() {return "//*[@id=\"candidateEthnicity\"]";}
    public static String AddCandidateEthnicityDrop1() {return "//*[@id=\"candidateEthnicity\"]/option[2]";}
    public static String AddCandidateGenderDrop() {return "//*[@id=\"candidateGender\"]";}
    public static String AddCandidateGenderDrop1() {return "//*[@id=\"candidateGender\"]/option[2]";}
    public static String AddCandidateNationalityDrop() {return "//*[@id=\"Nationality\"]";}
    public static String AddCandidateNationalityDrop1() {return "//*[@id=\"Nationality\"]/option[2]";}
    public static String AddCandidateSubmitBtn() {return "/html/body/div[1]/div[3]/form/div[1]/div/div[2]/button";}
       //---- Candidate description handled by tinymce instance


    //Add Candidate END

    //Candidate Functions START

    public static String CandidateSelect() {return "//*[@id=\"canidatesList\"]/div[1]/div[3]/span/a/span";}
    public static String VacancyAssignClick() {return "//*[@id=\"lnkAssignCandiateToVacancy\"]";}
    public static String VacancyAssignSelect() {return "//*[@id=\"shareVacanciesModal\"]/div/div/div[3]/div[1]/input";}
    public static String VacancyAssignSubmitBtn() {return "//*[@id=\"btnAddCandidatesToVacancies\"]";}
    public static String AddTag() {return "//*[@id=\"addTag\"]";}
    public static String InputTags() {return "//*[@id=\"tagName\"]";}
       //enterPress function is used in Automated case
    public static String AddSkill() {return "//*[@id=\"summaryText\"]/div[20]/div/span/div[1]/button";}
    public static String EnterSkill() {return "/html/body/div[1]/div[3]/div[5]/div[1]/div[1]/div/div/div[2]/div/div[1]/div[20]/div/span/div[2]/input";}
       //enterPress function is used in Automated case
    public static String CandidateEditBtn() {return "//*[@id=\"btnEditSummary\"]";}
    public static String SummaryClick() {return "//*[@id=\"mceu_11-body\"]";}
    //TinyMce instance
    public static String CoverNoteClick() {return "//*[@id=\"mceu_27-body\"]";}
    //TinyMce instance
    public static String DetailsFirstName() {return "//*[@id=\"txtFirstName\"]";}
    public static String DetailsLastName() {return "//*[@id=\"txtLastName\"]";}
    public static String DetailsEmail() {return "//*[@id=\"txtEmail\"]";}
    public static String DetailsCurrentJobTitle() {return "//*[@id=\"txtTitle\"]";}
    public static String DetailsCountry() {return "//*[@id=\"CountryId\"]";}
    public static String DetailsProvince() {return "//*[@id=\"txtProvince\"]";}
    public static String DetailsCity() {return "//*[@id=\"txtCity\"]";}
    public static String DetailsPhone() {return "//*[@id=\"txtPhone\"]";}
    public static String DetailsEthnicityDrop() {return "//*[@id=\"EthnicityId\"]";}
    public static String DetailsEthnicityDrop1() {return "//*[@id=\"EthnicityId\"]/option[3]";}
    public static String DetailsGenderDrop() {return "//*[@id=\"GenderId\"]";}
    public static String DetailsGenderDrop1() {return "//*[@id=\"GenderId\"]/option[1]";}
    public static String DetailsFacebook() {return "//*[@id=\"txtFacebook\"]";}
    public static String DetailsTwitter() {return "//*[@id=\"txtTwitter\"]";}
    public static String DetailsLinkedIn() {return "//*[@id=\"txtLinkedIn\"]";}
    public static String DetailsGoolePlus() {return "//*[@id=\"txtGooglePlus\"]";}
    public static String DetailsSaveBtn() {return "//*[@id=\"form0\"]/div[27]/button[2]";} //*[@id="form0"]/div[27]/button[2]
    public static String CandidateExperienceTab() {return "//*[@id=\"left-candidate-section\"]/div/ul/li[2]/a";}
    public static String AddExperienceBtn() {return "//*[@id=\"btnAddWorkExperience\"]";}
    public static String AddExperienceJobTitle() {return "//*[@id=\"txtJobTitleWE\"]";}
    public static String AddExperienceCompany() {return "//*[@id=\"txtCompanyNameWE\"]";}
    public static String AddExperienceStartDate() {return "//*[@id=\"dateFromWE\"]";}
    public static String AddExperienceEndDate() {return "//*[@id=\"dateToWE\"]";}
    public static String AddExperienceSummary() {return "//*[@id=\"txtSummaryWE\"]";}
    public static String AddExperienceSaveBtn() {return "//*[@id=\"btnSaveWorkExperience\"]";}

    public static String AddEducationBtn() {return "//*[@id=\"btnAddEducation\"]";}
    public static String AddEducationFieldOfStudy() {return "//*[@id=\"txtFieldOfStudy\"]";}
    public static String AddEducationSchool() {return "//*[@id=\"txtSchool\"]";}
    public static String AddEducationStartDate() {return "//*[@id=\"dateFromEducation\"]";}
    public static String AddEducationEndDate() {return "//*[@id=\"dateToEducation\"]";}
    public static String AddEducationSaveBtn() {return "//*[@id=\"btnSaveEducation\"]";}

    public static String ResumeTab() {return "//*[@id=\"left-candidate-section\"]/div/ul/li[3]/a";}

    public static String QuestionnaireTab() {return "//*[@id=\"questionnaireNav\"]";}
    public static String SelectQuestionnaireDrop() {return "//*[@id=\"questionnaireDropDown\"]";}
    public static String SelectQuestionnaireDrop1() {return "//*[@id=\"questionnaireDropDown\"]/option[2]";}
    public static String SendQuestionnaireBtn() {return "//*[@id=\"sendQuestionnaire\"]";}
    public static String CreateNewQuestionnaire() {return "//*[@id=\"addQuestionnaire\"]";}
    public static String QuestionnaireName() {return "//*[@id=\"questionnaireTitle\"]";}
    public static String Question() {return "//*[@id=\"question-input\"]";} //*[@id="question-input"]
    public static String QuestionTypeDrop() {return "//*[@id=\"question-1\"]/div[2]/div[1]/select";}
    public static String QuestionTypeDropMultiChoice() {return "//*[@id=\"question-1\"]/div[2]/div[1]/select/option[2]";}
    public static String QuestionChoiceOption1() {return "//*[@id=\"question-1\"]/div[3]/div[1]/div/div/div[2]/input";}
    public static String AddOption() {return "//*[@id=\"question-1\"]/div[3]/div[2]/div/a";}
    public static String QuestionChoiceOption2() {return "//*[@id=\"question-1\"]/div[3]/div[1]/div[2]/div/div[2]/input";}
    public static String QuestionChoiceOption3() {return "//*[@id=\"question-1\"]/div[3]/div[1]/div[3]/div/div[2]/input";}
    public static String QuestionTypeDropCheckBox() {return "//*[@id=\"question-1\"]/div[2]/div[1]/select/option[3]";}
    public static String QuestionTypeDropParagraph() {return "//*[@id=\"question-1\"]/div[2]/div[1]/select/option[4]";}
    public static String AddNewQuestionBtn() {return "//*[@id=\"addQuestion\"]";} //*[@id="addQuestion"]
    public static String SaveQuestionnaire() {return "//*[@id=\"saveQuestionnaire\"]";}
    public static String DocumentsTab() {return "//*[@id=\"left-candidate-section\"]/div/ul/li[5]/a";}
    public static String TimeLineTab() {return "//*[@id=\"right-candidate-section\"]/div/ul/li[1]/a";}
    public static String EmailCandidateBtn() {return "//*[@id=\"btnEmailCandidate\"]";}
    public static String EmailBody() {return "//*[@id=\"EmailMessage\"]";}
    public static String SendEmailBtn() {return "//*[@id=\"btnSendEmail\"]";}

    public static String NotesTab() {return "//*[@id=\"lnkNotes\"]";}
    public static String NoteDetails() {return "//*[@id=\"txtAreaNewNote\"]";}
    public static String AddNoteBtn() {return "//*[@id=\"addCandidateNote\"]";}

    public static String EvaluationTab() {return "//*[@id=\"right-candidate-section\"]/div/ul/li[3]/a";}
    public static String SubmitEvaluationBtn() {return "//*[@id=\"SubmitNewFeedback\"]";}
    public static String EvaluationDetails() {return "//*[@id=\"evaluation-form\"]/div[2]/textarea";}
    public static String EvaluationRatingExcellent() {return "//*[@id=\"evaluation-rating\"]/div[4]/label";}
    public static String SaveEvaluationBtn() {return "//*[@id=\"SaveEvaluation\"]";}

    public static String ReferencesTab() {return "//*[@id=\"right-candidate-section\"]/div/ul/li[4]/a";}
    public static String ReferencesFullName() {return "//*[@id=\"txtFullNameReference\"]";}
    public static String ReferencesEmail() {return "//*[@id=\"txtEmailReference\"]";}
    public static String ReferencesPhone() {return "//*[@id=\"txtPhoneNumberReference\"]";}
    public static String ReferencesProfessional() {return "//*[@id=\"ProfessionalReference\"]";}
    public static String ReferencesOccupation() {return "//*[@id=\"txtOccupationReference\"]";}
    // public static String ReferencesCompany() {return "//*[@id=\"companyContainerReference\"]";}
    public static String SendRequest() {return "//*[@id=\"addReferenceContainer\"]/div[8]/button[2]";}

    //Candidate Functions END

    //Create Tasks START

    public static String TasksURL() {return "https://simplify.hr/UserTask/Index";}
    public static String AddNewTask() {return "//*[@id=\"btnAddTask\"]";}
    public static String AddNewTaskName() {return "//*[@id=\"txtName\"]";}
    public static String AddNewTaskDescription() {return "//*[@id=\"txtDescription\"]";}
    public static String AddNewTaskAssignToUserDrop() {return "//*[@id=\"ddlUsers\"]";}
    public static String AddNewTaskAssignToUserDrop1() {return "//*[@id=\"ddlUsers\"]/option[2]";}
    public static String AddNewTaskDueDate() {return "//*[@id=\"txtDueDate\"]";}
    public static String AddNewTaskSave() {return "//*[@id=\"btnConfirmYes\"]";}

    //Create Tasks END


    //Submit candidate CV via portal START

    public static String CanCvSubmitURL() { return "https://simplify-hr.simplify.hr/Company/SubmitCv";}
    public static String CanCvSubmitFirstName() { return "//*[@id=\"ApplicationForm_FirstName\"]";}
    public static String CanCvSubmitLastName() { return "//*[@id=\"ApplicationForm_LastName\"]";}
    public static String CanCVSubmitEmail() { return "//*[@id=\"ApplicationForm_Email\"]";}
    public static String CanCVSubmitGenderDrop() { return "//*[@id=\"ApplicationForm_GenderId\"]";}
    public static String CanCVSubmitGenderDrop1() { return "//*[@id=\"ApplicationForm_GenderId\"]/option[2]";}
    public static String CanCvSubmitNationalityDrop() { return "//*[@id=\"ApplicationForm_Nationality\"]";}
    public static String CanCvSubmitNationalityDrop1() { return "//*[@id=\"ApplicationForm_Nationality\"]/option[1]";}
    public static String CanCvSubmitIdNumber() { return "//*[@id=\"ApplicationForm_SaIdNumber\"]";}
    public static String CanCvSubmitPhone() { return "//*[@id=\"ApplicationForm_Phone\"]";}
    public static String CanCvSubmitEthnicity() { return "//*[@id=\"ApplicationForm_Ethnicity\"]";}
    public static String CanCvSubmitEthnicity1() { return "//*[@id=\"ApplicationForm_Ethnicity\"]/option[2]";}
    public static String CanCvSubmitExperienceSummary() { return "//*[@id=\"ApplicationForm_ExperienceSummary\"]";}
    public static String CanCvSubmitHistoryTitle() { return "//*[@id=\"title\"]";}
    public static String CanCvSubmitHistoryCompany() { return "//*[@id=\"company\"]";}
    public static String CanCvSubmitHistoryFromDate() { return "//*[@id=\"dateFromPicker\"]/input";}
    public static String CanCvSubmitHistoryToDate() { return "//*[@id=\"weTo\"]";}
    public static String CanCvSubmitHistorySummary() { return "//*[@id=\"work-history-container\"]/div[2]/div[3]/textarea";}
    public static String CanCvSubmitHistorySave() { return "//*[@id=\"work-history-container\"]/div[2]/div[4]/button";}






    //Submit candidate CV via portal START


    //*****************ATS TESTING OBJECTS START*****************



    //Utilities

    public static WebDriver Driver;

    public static void navigateTo(WebDriver driver, String pageUrl) {
        driver.navigate().to(pageUrl);
    }

    public static boolean enterTextByXpath(WebDriver driver, String elementXpath, String textToEnter) {
        try {
            System.out.println("[INFO] step 1 : " + elementXpath);
            Main_Object.waitForElementByXpath(driver, elementXpath);
            WebElement elementToTypeIn = driver.findElement(By.xpath(elementXpath));

            elementToTypeIn.sendKeys(Keys.chord(Keys.CONTROL, "a"), textToEnter);



        } catch (Exception e) {
            System.err.println("Error entering text - " + elementXpath + " - " + e.getMessage());
//          this.DriverExceptionDetail = e.getMessage();
        }
        return true;
    }

    public static boolean waitForElementByXpath(WebDriver driver, String elementXpath) {
        System.out.println("[INFO] Waiting For Element by Xpath : " + elementXpath);
        boolean elementFound = false;
        try {
            int waitCount = 0;
            while (!elementFound && waitCount < 15) {
                try {
                    WebDriverWait wait = new WebDriverWait(Driver, 1);
                    if (wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath))) != null) {
                        elementFound = true;
                        System.out.println("[INFO] Found Element by Xpath : " + elementXpath);
                        break;
                    }
                } catch (Exception e) {
                    elementFound = false;
                }
                Thread.sleep(100);
                waitCount++;
            }

        } catch (Exception e) {
            System.err.println("[Error] waiting for element by Xpath '" + elementXpath + "' - " + e.getMessage());
//            this.DriverExceptionDetail = e.getMessage();
        }
        return elementFound;
    }

    public static boolean clickElementbyXpath(WebDriver driver, String elementXpath) {
        try {
            System.out.println("[INFO] Clicking element by Xpath : " + elementXpath);
            Main_Object.waitForElementByXpath(driver, elementXpath);
//            WebDriverWait wait = new WebDriverWait(Driver, 15);
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
            WebElement elementToClick = driver.findElement(By.xpath(elementXpath));
            elementToClick.click();
            return true;
        } catch (Exception e) {
            System.err.println("[Error] Failed to click on element by Xpath - " + e.getMessage());
//            this.DriverExceptionDetail = e.getMessage();
            return false;
        }
    }


    public static boolean findElementsByXpath(WebDriver driver, String elementLinkText) {

        try {
//            Main_Object.waitForElementByXpath(driver, elementLinkText);
            driver.findElement(By.xpath(elementLinkText));
            return true;
        } catch (Exception e) {
            System.err.println("Error reading text from element - " + elementLinkText + " error - " + e.getMessage());
            return false;
        }
    }

    public static boolean enterTextByTmce(WebDriver driver) {
        try {
            JavascriptExecutor jsx = (JavascriptExecutor)driver;
            jsx.executeScript("tinymce.activeEditor.execCommand('mceInsertContent', false, 'This is test data used to populate tinymce instances for automation testing purposes')");

            return true;

        } catch (Exception e) {
            System.err.println("Error entering text -" + e.getMessage());
            return false;
        }
    }

    public static boolean enterPressTags(WebDriver driver) {

        driver.findElement(By.id("tagName")).sendKeys(Keys.RETURN);

        return true;

    }




    //Candidate Functions END

    //Applications START

    public static String AppUrl(){
        return "https://local.simplify.hr/Vacancies/Vacancy/5";
    }
    public static String AppTabClick(){
        return "/html/body/div[3]/div[2]/div/ul/li[2]/a";
    }
    public static String AppHeadLine(){
        return "//*[@id=\"divRadioSelections\"]/div[4]/div[2]/label[3]"; }
    public static String AppPhone(){
        return "//*[@id=\"divRadioSelections\"]/div[5]/div[2]/label[1]";
    }
    public static String AppAddress(){
        return "//*[@id=\"divRadioSelections\"]/div[6]/div[2]/label[1]";
    }
    public static String AppPhoto(){
        return "//*[@id=\"divRadioSelections\"]/div[7]/div[2]/label[1]";
    }
    public static String AppCvUpload(){
        return "//*[@id=\"divRadioSelections\"]/div[9]/div[2]/label[1]";
    }
    public static String AppExperience(){
        return "//*[@id=\"divRadioSelections\"]/div[10]/div[2]/label[1]";
    }
    public static String AppWorkHistory(){
        return "//*[@id=\"divRadioSelections\"]/div[11]/div[2]/label[1]";
    }
    public static String AppEducation(){
        return "//*[@id=\"divRadioSelections\"]/div[12]/div[2]/label[1]";
    }
    public static String AppCoverLater(){
        return "//*[@id=\"divRadioSelections\"]/div[14]/div[2]/label[1]";
    }
    public static String AppAddQuestion(){
        return "//*[@id=\"addQuestion\"]";
    }
    public static String AppQuestionTitle(){
        return "//*[@id=\"questionnaireTitle\"]";
    }
    public static String AppQuestion(){
        return "";
    }
    public static String AppQuestionType(){
        return "//*[@id=\"questionModule\"]/div/input";
    }
    public static String AppChoice(){
        return "//*[@id=\"questionModule\"]/div/div[2]/select";
    }
    public static String AppChoiceResultDrop(){
        return "//*[@id=\"questionModule\"]/div/div[3]/div/div/input";
    }
    public static String AppChoiceResultDrop1(){
        return "//*[@id=\"questionModule\"]/div/div[3]/div/div/input/option[2]";
    }
    public static String AppSaveAndContinue(){
        return "/html/body/div[3]/div[1]/div/div/span/a[2]";
    }

    //Applications END





//ATS TESTING OBJECTS END



}//END OF CODE


