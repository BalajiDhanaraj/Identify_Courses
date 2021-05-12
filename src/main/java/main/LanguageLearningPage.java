package main;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test_pom.LanguageLearning;
import utils.CaptureScreenshots;
import utils.DriverSetup;
import utils.ExtentReport;
import utils.ReadProperties;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class LanguageLearningPage extends DriverSetup {

    public ExtentReports report = ExtentReport.getReportInstance();
    public ExtentTest logger;

    public void searchCourse() {

        waitload(10);

        PageFactory.initElements(driver, LanguageLearning.class);

        LanguageLearning.search.sendKeys("Language Learning" + Keys.ENTER);

    }


    public void selectLanguage() {

        // Extract all the language with its total count
        try {
            PageFactory.initElements(driver, LanguageLearning.class);

            LanguageLearning.selectLanguage.click();

            LanguageLearning.showAll.click();
            TakeScreenshot();
            // String all = LanguageLearning.langName.getText();
            List<WebElement> langName = driver.findElements(By.xpath("//div[@class=\"checkboxText\"]"));
            List<WebElement> langCount = driver.findElements(By.xpath("//div[@class='filter-count']"));
            logger.createNode(" ");
            logger.createNode(" The Language Names: ");
            logger.createNode(" ");
            List<String> lang_list = new ArrayList<String>();
            List<String> lang_count_list = new ArrayList<String>();
            for (WebElement name : langName) {
                String Lang_names = name.getText();
                lang_list.add(Lang_names);
            }
            for (WebElement count : langCount) {
                String Lang_count = count.getText();
                lang_count_list.add(Lang_count);
            }

            for (int i = 0; i < lang_list.size(); i++) {
                    logger.createNode(" Language Names and Language Count --- " + lang_list.get(i) + "--" + lang_count_list.get(i));
            }
        }catch (Exception e){
            logger.createNode(System.err.toString());
            logger.createNode(String.valueOf(Status.FAIL),"Failed"+e.getMessage());
        }

        logger.createNode(" ");
        LanguageLearning.closeLanguage.click();
    }


    public void selectLevel() {
        // Extract all the levels with its total count
        // List<WebElement>
        waitload(10);
        LanguageLearning.selectLevel.click();
        List<WebElement> Levelcount = driver.findElements(By.xpath("//div[@class=\"filter-count\"]"));
        List<WebElement> Levelname = driver.findElements(By.xpath("//div[@class='checkboxText']"));
        logger.createNode(" ");
        // level name //div[@class="Select-option"]
        logger.createNode("Total count of Level : " + Levelcount.size());

        List<String> level_name_list=new ArrayList<String>();
        List<String> level_count_list = new ArrayList<String>();
        for (WebElement levelname : Levelname){
            String Level_Name = levelname.getText();
            level_name_list.add(Level_Name);
        }
        for (WebElement langcount : Levelcount) {
            String Level_Count = langcount.getText();
            level_count_list.add(Level_Count);
        }
        for(int i=0;i<level_name_list.size();i++){
                logger.createNode(" Level --- "+ level_name_list.get(i) +"--"+level_count_list.get(i));
        }


        logger.createNode(" ");
        driver.close();
    }

    /******************* wait load **************************/
    public static void waitload(int value) {
        driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
    }

    public void invokeReadProperties(){
        ReadProperties.ConfigFileReader();
    }

    public static void TakeScreenshot(){
        CaptureScreenshots.TakeScreenshot(driver,"Regression_language");
    }

    public void closeBrowser() {
        report.flush();
        driver.quit();
    }

}
