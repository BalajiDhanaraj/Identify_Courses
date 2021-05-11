package main;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import test_pom.LanguageLearning;
import utils.CaptureScreenshots;
import utils.DriverSetup;
import utils.ExtentReport;
import utils.ReadProperties;

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

        PageFactory.initElements(driver, LanguageLearning.class);

        LanguageLearning.selectLanguage.click();

        LanguageLearning.showAll.click();
        TakeScreenshot();
       // String all = LanguageLearning.langName.getText();
        List<WebElement> langName = driver.findElements(By.xpath("//div[@class=\"checkboxText\"]"));

        logger.createNode(" ");
        logger.createNode(" The Language Names: ");
        logger.createNode(" ");
        for (WebElement langname : langName){
            String name = langname.getText();
//            System.out.println("name"+name);
            logger.createNode("Language Name: "+name);
        }

        logger.createNode(" ");
        LanguageLearning.closeLanguage.click();
    }


    public void selectLevel() {
        // Extract all the levels with its total count
        // List<WebElement>
        waitload(10);
        LanguageLearning.selectLevel.click();
        List<WebElement> countLevel = driver.findElements(By.xpath("//div[@class=\"filter-count\"]"));

        logger.createNode(" ");
        // level name //div[@class="Select-option"]
        logger.createNode("Total count of Level : " + countLevel.size());
        for (WebElement lang2 : countLevel) {
            String levels = lang2.getText();
            logger.createNode(" Levels: "+levels);
            // Reporter.log("\n");
//            System.out.println("levels"+levels);
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
