package testcases;
import main_page.LanguageLearningPage;
import org.testng.annotations.Test;

public class LanguageLearningTest extends LanguageLearningPage {
    @Test(priority = 1,groups = {"Smoke Suite","Regression Suite"})
    public void invoke() throws Exception{
            logger=report.createTest("Invoked Browser Successfully ");
            invokeReadProperties();
    }

    @Test(priority = 2,groups = {"Smoke Suite","Regression Suite"})
    public void SearchCourse() throws Exception{
            logger = report.createTest(" Search Course For Language Learning ");
            searchCourse();
    }

    @Test(priority = 3,groups = {"Smoke Suite","Regression Suite"})
    public void SelectLanguage() throws Exception{
            logger = report.createTest(" Select Language ");
            selectLanguage();
    }

    @Test(priority = 4,groups = {"Smoke Suite","Regression Suite"})
    public void selectLevels() throws Exception{
            logger = report.createTest(" Total Count Of Level ");
            selectLevel();
    }

    @Test(priority = 5,groups = {"Smoke Suite","Regression Suite"})
    public void Close() throws Exception{
            logger = report.createTest(" Browser Closed Successfully ");
            closeBrowser();

    }
}
