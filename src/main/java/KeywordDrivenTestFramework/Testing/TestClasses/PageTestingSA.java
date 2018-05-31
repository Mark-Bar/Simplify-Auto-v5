package KeywordDrivenTestFramework.Testing.TestClasses;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;
import KeywordDrivenTestFramework.Testing.PageObjects.Main_Object;
import KeywordDrivenTestFramework.Utilities.SeleniumDriverUtility;
import com.gargoylesoftware.htmlunit.javascript.host.Window;

import static java.awt.SystemColor.window;

/**
 * Created by Mark.Barfoot on 2016-10-14.
 */
public class PageTestingSA extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public PageTestingSA(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!PageTest()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

    public boolean PageTest() {

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersHome())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test Started", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersJobPage())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("careers24.com jobs", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersEngineering())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("careers24.com engineering-and-construction", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersFinance())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersHospitality())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersMarketing())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersOffice())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersTech())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersGraduate())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersGraduateTech())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersGraduateMarketing())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersGraduateHospitality())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersGraduateEngineering())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersGraduateFinance())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersGraduateOffice())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersGraduateSkills())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersGraduateCV())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersGraduateInterview())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersGraduateHired())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersGraduateResources())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCourses())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCoursesAll())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCoursesGraduate())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCoursesEngineering())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCoursesFinance())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCoursesHospitality())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCoursesMarketing())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCoursesOffice())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCoursesTech())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCoursesGeneral())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompanies())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchNum())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchA())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchB())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchC())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchD())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchE())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchF())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchH())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchI())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchJ())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchK())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchL())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchM())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchN())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchO())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchP())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchQ())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchR())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchS())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchT())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchU())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchV())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchW())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchX())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchY())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompaniesSearchZ())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCompanyReviews())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersReviews())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdvice())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdviceCV())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdviceInterviews())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdviceJobHunt())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdviceMoney())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdviceWorkLife())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdviceGrowth())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdviceManagement())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersAdviceRecruiting())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRecruiters())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRecruiterRegister())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCities())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegions())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsEastCape())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsKwaNatal())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsNorthWest())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionFreeState())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsLimpopo())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsNorthernCape())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsGauteng())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsMpumalanga())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsWesternCape())) {
            return false;
        }

        //Cities Start

        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCities())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesAtlantic())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesBLoemfontein())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesNorthernCape())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesDeaar())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesDurbanNorth())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesDurbanSouth())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesEastRand())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesErmelo())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesJohannesburg())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesKroonstad())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesMafikeng())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesOverberg())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesPE())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesSouthernPeninsula())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesStellenbosch())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesVanderbijlpark())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesWelkom())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesWildCoast())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesBarberton())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesCapeFlats())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesSouthernSuburbs())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesDrakensberg())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesDurbanNorthernSuburbs())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesDurbanWesternSuburbs())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesEmalahleni())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesGardenRoute())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesKimberley())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesKZNMidlands())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesMalalane())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesPietermaritzburg())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesSpringbok())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesTzaneen())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesVereeniging())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesWestCoast())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesBethlehem())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesCapeTown())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesWinelands())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesDurban())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesDurbanSouthCoast())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesEastLondon())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesEmkhondo())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesHelderberg())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesKlerksdorp())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesTrichardt())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesMbobela())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesPolokwane())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesRustenburg())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesStanderton())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesUpington())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesVryburg())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersCitiesWestRand())) {
            return false;
        }

        //Cities End

        //Regions Start

        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegions())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsEastCape())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsKwaNatal())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsNorthWest())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionFreeState())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsLimpopo())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsNorthernCape())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsGauteng())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsMpumalanga())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersRegionsWesternCape())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);

        //Regions End

        //Sector Start

        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypes())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesAcademic())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesAdvertising())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesAviation())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesCallCentre())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesConstruction())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesDefence())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesEducation())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesEnvironmental())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesFMCG())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesGraduate())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesHospitality())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesInsurance())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesIT())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesLogistics())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesMarketResearch())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesMedical())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesNonProfit())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesCommunication())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesPurchasing())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesResearch())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesSecurity())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesSports())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesTechnology())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesTravel())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesAccounting())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesAgriculture())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesBanking())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesChemical())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesConsulting())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesDesign())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesEngineering())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesFashion())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesGeneral())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesHealthAndSafety())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesHR())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesInternet())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesLegal())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesManagement())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesMarketing())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesMining())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesPetrochemical())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesProcurement())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesRealEstate())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesRetail())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesSocialService())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesStockbroking())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesTelecoms())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesWarehousing())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesAdmin())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesAutomative())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesBusinessManagement())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesClothing())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesCruiseShip())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesEcommerce())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesEntertainment())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesFinance())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesParastatals())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesFitnessAndBeauty())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesImportExport())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesInvestment())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesLifestyle())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesManufacturing())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesMedia())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesMotoring())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesPharmaceutical())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesProperty())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesRecruitment())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesSales())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesSoftSkills())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesTechnical())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);
        if (!SeleniumDriverInstance.navigateTo(Main_Object.CareersWorkTypesTradesAndServices())) {
            return false;
        }
        SeleniumDriverInstance.takeScreenShot("Test", false);

//        if (!SeleniumDriverInstance.navigateTo(Main_Object.AdviceArray())) {
//            return false;
//        }
//        SeleniumDriverInstance.takeScreenShot("Test", false);

        //Sector End

        //Advice Start

//         String[] arrayAdvice = {"http://www.careers24.com/career-advice/cv-cover-letter-advice","http://www.careers24.com/career-advice/interview-tips","http://www.careers24.com/career-advice/job-hunting","http://www.careers24.com/career-advice/money","http://www.careers24.com/career-advice/work-life","http://www.careers24.com/career-advice/career-growth","http://www.careers24.com/career-advice/management-advice","http://www.careers24.com/career-advice/recruiting","http://www.careers24.com/career-advice/job-hunting/the-top-25-jobs-with-the-rarest-skills-in-south-africa-20161017","http://www.careers24.com/career-advice/money/jobs-with-the-highest-minimum-wages-in-south-africa-20161018","http://www.careers24.com/career-advice/work-life/meet-fulton-clinton-jamieson-craftsman-20161018","http://www.careers24.com/career-advice/job-hunting/how-to-change-roles-internally-20161014","http://www.careers24.com/career-advice/management-advice/the-10-commandments-of-teamwork-20161013","http://www.careers24.com/career-advice/job-hunting/want-to-work-for-makro-read-this-20160805","http://www.careers24.com/career-advice/work-life/things-to-consider-before-dating-a-co-worker-20161013","http://www.careers24.com/career-advice/job-hunting/why-limpopo-is-the-best-place-to-work-20161010","http://www.careers24.com/career-advice/job-hunting/11-characteristics-that-might-indicate-a-career-in-coding-and-software-development-is-right-for-you-20161011","http://www.careers24.com/career-advice/job-hunting/4-jobs-that-make-accounting-seem-fun-20161005","http://www.careers24.com/career-advice/cv-cover-letter-advice/the-worst-real-life-cv-mistakes-ever-20160826","http://www.careers24.com/career-advice/cv-cover-letter-advice/the-most-common-cv-trick-school-leavers-use-on-their-cvs-20160824","http://www.careers24.com/career-advice/interview-tips/what-recruiters-actually-discuss-after-your-interview-20160929","http://www.careers24.com/career-advice/interview-tips/how-to-and-how-not-to-answer-tell-me-about-yourself-20160902","http://www.careers24.com/companies-hiring","http://www.careers24.com/now-hiring/6825-salvage-management-disposals/","http://www.careers24.com/now-hiring/13875-sfg-engineering-services/","http://www.careers24.com/now-hiring/1242-standard-bank-group/","http://www.careers24.com/now-hiring/17146-turner-townsend/","http://www.careers24.com/now-hiring/11301-siemens-pty-ltd/","http://www.careers24.com/now-hiring/16798-makro-sa/","http://www.careers24.com/now-hiring/6909-cavi-brands/","http://www.careers24.com/now-hiring/425-mr-price-group/","http://www.careers24.com/liberty-financial-advisers","http://www.careers24.com/career-advice/money/7-money-myths-affecting-your-level-of-success-20161005","http://www.careers24.com/career-advice/career-growth/6-things-intelligent-people-will-never-reveal-at-work-20160930","http://www.careers24.com/career-advice/career-growth/10-ways-lifelong-learning-will-benefit-your-personal-success-20160926","http://www.careers24.com/career-advice/management-advice/the-real-reasons-why-millennials-are-leaving-your-company-20161004","http://www.careers24.com/career-advice/recruiting/how-to-effectively-recruit-job-seekers-online-20160823","http://www.careers24.com/career-advice/recruiting/how-to-recruit-passive-job-seekers-20160819","http://www.careers24.com/career-advice/tags/topics/money","http://www.careers24.com/career-advice/tags/topics/careerpride","http://www.careers24.com/career-advice/tags/topics/work_life","http://www.careers24.com/career-advice/interview-tips/how-to-ace-a-panel-interview-20150609","http://www.careers24.com/career-advice/videos","http://www.careers24.com/jobs/alert/","http://www.careers24.com/download/","http://www.careers24.com/candidate/get-started/","http://www.careers24.com/candidate/profile/?afterlogin=true#cvupload","http://www.careers24.com/jobs/adverts/1028874-icu-registered-nurse-mossel-bay-western-cape/","http://www.careers24.com/jobs/adverts/1028873-php-developer-johannesburg/","http://www.careers24.com/jobs/adverts/1028872-software-developer-cape-town/","http://www.careers24.com/jobs/adverts/1028871-senior-surgical-registered-nurse-mossel-bay-western-cape/","http://www.careers24.com/jobs/adverts/1028870-java-developer-cape-town/","http://www.careers24.com/terms/","http://www.careers24.com/24com/","http://www.careers24.com/info/contact/","http://www.careers24.com/recruiters/","http://www.news24.com/","http://www.olx.co.za/","http://www.property24.com/","http://www.careers24.com/info/faq/","http://m.careers24.com/","http://www.careers24.com/now-hiring/","http://www.careers24.com/sitemap/","http://www.careers24.com/testimonials/"};
//
//         for (int i = 0; i < arrayAdvice.length; i++){
//             SeleniumDriverInstance.navigateTo(arrayAdvice[i]);
//             SeleniumDriverInstance.takeScreenShot("WEB", false);
//         }

//        String[] arrayWeb = {};
//        for (int i = 0; i < arrayWeb.length; i++){
//            SeleniumDriverInstance.navigateTo(arrayWeb[i]);
//            SeleniumDriverInstance.takeScreenShot("WEBSA", false);
//        }

         //Advice End

        String[] arrayMobi = {"http://m.careers24.com/","http://m.careers24.com/tech","http://m.careers24.com/contact","http://m.careers24.com/testimonials/","http://m.careers24.com/info/faq/","http://m.careers24.com/login/","http://m.careers24.com/featured-companies/","http://m.careers24.com/company-reviews","http://m.careers24.com/candidate/shortlist/","http://m.careers24.com/jobs/browse/regions/","http://m.careers24.com/career-advice/","http://m.careers24.com/office","http://m.careers24.com/register/","http://m.careers24.com/candidate/alerts/alert/","http://m.careers24.com/marketing","http://m.careers24.com/training/","http://m.careers24.com/graduate","http://m.careers24.com/jobs/browse/cities/","http://m.careers24.com/terms","http://m.careers24.com/hospitality","http://m.careers24.com/finance","http://m.careers24.com/testimonials/create","http://m.careers24.com/jobs/"};

        for (int i = 0; i < arrayMobi.length; i++){
            SeleniumDriverInstance.navigateTo(arrayMobi[i]);
            SeleniumDriverInstance.takeScreenShot("MOBISA", false);
        }

        return true;
    }
}
