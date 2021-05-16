package testcases;

import main_page.IdentifyCoursePage;
import org.testng.annotations.Test;

public class IdentifyCourseTest extends IdentifyCoursePage {

    @Test(priority = 1,groups ={"Smoke Suite","Regression Suite"})
    public void invoke() throws Exception{
        logger=report.createTest("Invoked browser successfully ");
        invokeReadProperties();
    }

    @Test(priority = 2,groups = {"Smoke Suite","Regression Suite"})
    public void SearchCourse() throws Exception{
        logger = report.createTest(" Search Course ");
        searchCourse();
    }

    @Test(priority = 3,groups = {"Smoke Suite","Regression Suite"})
    public void SelectLanguage() throws Exception{
        logger = report.createTest(" Select Languages ");
        selectLanguage();
    }
    @Test(priority = 4,groups = {"Smoke Suite","Regression Suite"})
    public void SelectLevel() throws Exception{
        logger = report.createTest(" Select Languages ");
        selectLevel();
    }

    @Test(priority = 5,groups = {"Smoke Suite","Regression Suite"})
    public void FirstCourse() throws Exception{
        logger = report.createTest(" First Course Details ");
        firstCourse();
    }

    @Test(priority = 6,groups = {"Smoke Suite","Regression Suite"})
    public void SecondCourse() throws Exception{
        logger = report.createTest(" Second Course Details ");
        secondCourse();
    }

    @Test(priority = 7,groups = {"Smoke Suite","Regression Suite"})
    public void Close() throws Exception{
        logger = report.createTest(" Close Browser Successfully ");
        closeBrowser();
    }

}
