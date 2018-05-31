package KeywordDrivenTestFramework.Testing.TestClasses;

import KeywordDrivenTestFramework.Core.BaseClass;
import KeywordDrivenTestFramework.Entities.Enums;
import KeywordDrivenTestFramework.Entities.TestEntity;
import KeywordDrivenTestFramework.Entities.TestResult;

/**
 * Created by Mark.Barfoot on 2016-10-25.
 */
public class PageTestingNG extends BaseClass {
    TestEntity testData;
    int counter = 1;

    public PageTestingNG(TestEntity testData) {
        this.testData = testData;

    }

    public TestResult executeTest() {

        this.setStartTime();
        if (!PageTestNG()) {
            SeleniumDriverInstance.takeScreenShot(counter + " - Failed to navigate to Sign up", true);
            counter++;
            return new TestResult(testData, Enums.ResultStatus.FAIL, "Failed to navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
        }

        return new TestResult(testData, Enums.ResultStatus.PASS, "Successfully navigate to Sign up", this.getTotalExecutionTime());// SeleniumDriverInstance.errorScreenshotPath);
    }

public boolean PageTestNG() {
    String[] arrayWebNG = {"http://www.careers24.com.ng/","http://www.careers24.com.ng/jobs/alert/","http://www.careers24.com.ng/info/contact/","http://www.careers24.com.ng/recruiters/","http://www.careers24.com.ng/info/faq/","http://www.careers24.com.ng/now-hiring/","http://www.careers24.com.ng/testimonials/","http://www.careers24.com.ng/graduate/","http://www.careers24.com.ng/training/","http://www.careers24.com.ng/companies-hiring/","http://www.careers24.com.ng/company-reviews/","http://www.careers24.com.ng/career-advice/","http://www.careers24.com.ng/recruiters","http://www.careers24.com.ng/jobs/","http://www.careers24.com.ng/engineering-and-construction","http://www.careers24.com.ng/finance","http://www.careers24.com.ng/marketing","http://www.careers24.com.ng/office","http://www.careers24.com.ng/tech","http://www.careers24.com.ng/jobs/shortlist/","http://www.careers24.com.ng/terms/","http://www.careers24.com.ng/graduate-subscribe/","http://www.careers24.com.ng/graduate/what-can-I-do-with-my-skills","http://www.careers24.com.ng/graduate/is-my-cv-good-enough","http://www.careers24.com.ng/graduate/How-to-ace-my-interview","http://www.careers24.com.ng/graduate/help-ive-been-hired","http://www.careers24.com.ng/graduate/the-ambitious-grads-starter-pack","http://www.careers24.com.ng/candidate/profile/"};

    for (int i = 0; i < arrayWebNG.length; i++){
        SeleniumDriverInstance.navigateTo(arrayWebNG[i]);
        SeleniumDriverInstance.takeScreenShot("MOBISA", false);
    }
    return true;
}
}
