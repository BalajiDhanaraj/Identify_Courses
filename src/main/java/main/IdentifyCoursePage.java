package main;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_pom.IdentifyCoursesPom;
import utils.CaptureScreenshots;
import utils.DriverSetup;
import utils.ExtentReport;
import utils.ReadProperties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class IdentifyCoursePage extends DriverSetup {

    public ExtentReports report = ExtentReport.getReportInstance();
    public ExtentTest logger;
    String parentWindow;


    /******************* Search Course ********************/
    public void searchCourse()
    {

        driver.findElement(By.className("react-autosuggest__input")).click();
        //Enter web development courses and click enter key
        driver.findElement(By.className("react-autosuggest__input")).sendKeys("web development courses" + Keys.ENTER);
    }

    /******************* Select Language ********************/
    public void selectLanguage()
    {

            PageFactory.initElements(driver, IdentifyCoursesPom.class);
            // Look for Language
            IdentifyCoursesPom.Language.click();
            waitload(30);
            logger.createNode(" ");
            waitload(10);
            logger.createNode(" The Selected Language: English ");
            logger.createNode(" ");
            //Select English Language
            IdentifyCoursesPom.English.click();

    }

    /******************* Select Level ********************/
    public void selectLevel()
    {

            // Look for Level
            IdentifyCoursesPom.Level.click();
            logger.createNode(" ");
            logger.createNode(" Clicking Beginner Level: Beginner ");
            logger.createNode(" ");
            //Select Beginner Level
            IdentifyCoursesPom.Beginner.click();

    }

    /******************* First Course ********************/
    public void firstCourse()
    {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        WebDriverWait wait=new WebDriverWait(driver,20);

        logger.createNode(" ");
        logger.createNode(" Details of First Course : ");
        logger.createNode(" ");
        TakeScreenshot();
        //Extract the name of the first course
        waitload(30);
        String courseName1= IdentifyCoursesPom.CourseName1.getText();
        logger.createNode("Course Name - " + courseName1);

        //Extract the rating of the first course
        String courseRating1= IdentifyCoursesPom.Rating1.getText();
        logger.createNode("Course Rating - " + courseRating1);

        parentWindow=driver.getWindowHandle();

        wait.until(ExpectedConditions.elementToBeClickable(IdentifyCoursesPom.FirstCourse));
        IdentifyCoursesPom.FirstCourse.click();

        Set<String> handles1=driver.getWindowHandles();

        for(String childWindow1:handles1)
        {
            if(!childWindow1.contentEquals(parentWindow))
            {
                //Navigate to child window
                driver.switchTo().window(childWindow1);
                //Extract the duration of the first course
                waitload(30);
                String courseDuration1= IdentifyCoursesPom.Duration1.getText();
                logger.createNode("Course Duration - " + courseDuration1);

                driver.close();
            }
            //Get back to Parent window
            driver.switchTo().window(parentWindow);
        }
    }

    /******************* Second Course ********************/
    public void secondCourse()
    {
        waitload(30);
        IdentifyCoursesPom.SecondCourse.click();

        logger.createNode(" ");
        logger.createNode("Details of Second Course :");
        logger.createNode(" ");

        // Extract the name of the second course
        waitload(30);
        String courseName2 = IdentifyCoursesPom.CourseName2.getText();
        logger.createNode("Course Name - " + courseName2);

        // Extract the rating of the second course
        waitload(30);
        String courseRating2 = IdentifyCoursesPom.Rating2.getText();
        logger.createNode("Course Rating - " + courseRating2);

        Set<String> handles2 = driver.getWindowHandles();
        // Get into the Child Window
        for (String childWindow2 : handles2) {
            if (!childWindow2.contentEquals(parentWindow)) {

                // Navigate to child window
                driver.switchTo().window(childWindow2);

                // Extract the duration of the second course
                waitload(30);
                String courseDuration2 = IdentifyCoursesPom.Duration2.getText();
                logger.createNode("Course Duration - " + courseDuration2);

                waitload(30);
                driver.close();
            }
        }
        // Get back to Parent window
        driver.switchTo().window(parentWindow);

    }

    /******************* wait load **************************/
    public static void waitload(int value) {
        driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
    }
    /******************* Read Properties ********************/
    public void invokeReadProperties(){
        ReadProperties.ConfigFileReader();
    }
    /******************* Take Screenshot ********************/
    public static void TakeScreenshot(){
        CaptureScreenshots.TakeScreenshot(driver,"IdentifyCourseRegression");
    }

    /******************* Close Browser ********************/
    public void closeBrowser() {
        report.flush();
        driver.quit();
    }
}
