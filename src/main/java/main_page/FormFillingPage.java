package main_page;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import test_pom.FormFillingPom;
import utils.CaptureScreenshots;
import utils.DriverSetup;
import utils.ExtentReport;
import utils.ReadProperties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FormFillingPage extends DriverSetup {

    public ExtentReports report = ExtentReport.getReportInstance();
    public ExtentTest logger;

    /******************* Click FOr Enterprise And Navigate To Filling Form ********************/
    public void ForEnterprise()
    {
        //Wait
        waitload(10);
        //Click "For Enterprise"
        logger.createNode(" ");
        logger.createNode(" Clicked For Enterprise Successfully");
        logger.createNode(" ");

        driver.findElement(By.xpath("//a[contains(text(),'For Enterprise')]")).click();

    }
    /******************* Filling Form ********************/
    public void FillForm() throws IOException
    {

        //Look into Courses for Campus under Product
        waitload(10);
        String parentWindow = driver.getWindowHandle();
        Actions action = new Actions(driver);
        WebElement ProductHover = driver.findElement(By.xpath("//a[text()=\"Products\"]"));
        action.moveToElement(ProductHover);
        action.build().perform();

        driver.findElement(By.xpath("//*[@id=\"menu-item-4901\"]/a")).click();
        waitload(20);
        //Locate the excel sheet to be read
        File src = new File(System.getProperty("user.dir") + "/Test_data/HackathonExcel.xlsx");
        FileInputStream stream = new FileInputStream(src);
        XSSFWorkbook book = new XSSFWorkbook(stream);
        XSSFSheet sheet = book.getSheet("Sheet1");

        //Fill the "Ready to transform" form from the data given in excel sheet
        String FirstName = sheet.getRow(1).getCell(0).getStringCellValue();
        String LastName = sheet.getRow(1).getCell(1).getStringCellValue();
        String JobTitle = sheet.getRow(1).getCell(2).getStringCellValue();
        String Email = sheet.getRow(1).getCell(3).getStringCellValue();
        double PhoneNumber = sheet.getRow(1).getCell(4).getNumericCellValue();
        //Change the phone number from integer to string
        String phone = String.valueOf(PhoneNumber);
        String InstituteName = sheet.getRow(1).getCell(5).getStringCellValue();

        waitload(10);

        Set<String> handle = driver.getWindowHandles();
        for (String childWindow : handle)
        {
            driver.switchTo().window(childWindow);
        }

        try
        {
            //Fill the "Ready to transform" form from the data given in excel sheet
            waitload(10);

            PageFactory.initElements(driver, FormFillingPom.class);
            FormFillingPom.Fname.sendKeys(FirstName);

            FormFillingPom.Lname.sendKeys(LastName);

            Select select = new Select(FormFillingPom.JobFunction);
            select.selectByIndex(1);

            FormFillingPom.Jobtitle.sendKeys(JobTitle);

            FormFillingPom.Email.sendKeys(Email);

            FormFillingPom.Phone.sendKeys(phone);

            FormFillingPom.Institutename.sendKeys(InstituteName);

            Select select1 = new Select(FormFillingPom.InstituteType);
            select1.selectByVisibleText("Government");

            Select select2 = new Select(FormFillingPom.PrimaryDisipline);
            select2.selectByVisibleText("Computer Science");

            Select select3 = new Select(FormFillingPom.Country);
            select3.selectByVisibleText("India");

            Select select4 = new Select(FormFillingPom.State);
            select4.selectByVisibleText("Tamil Nadu");

            FormFillingPom.Submit.click();

            //Capture the error message & display
            waitload(10);

            logger.createNode( " ");
            logger.createNode(" Form Filling Error Message ");
            String Error = FormFillingPom.ErrorMessage.getText();
            logger.createNode("Error : "+Error);
            logger.createNode(" ");

            TakeScreenshot();

            logger.createNode(" ");
            logger.createNode(" ScreenShot Taken Successfully ");
            logger.createNode(" ");

            driver.close();
            driver.switchTo().window(parentWindow);
        }

        catch (Exception e)
        {
           logger.createNode(" The Error Message"+e);
        }
    }

    /******************* wait load **************************/
    public static void waitload(int value) {
        driver.manage().timeouts().implicitlyWait(value, TimeUnit.SECONDS);
    }

    /******************* Read Properties ********************/
    public void invokeReadProperties(){

        logger.createNode(" ");
        logger.createNode(" Fetching Data From Configuration File & Browser Launched Successfully ");
        logger.createNode(" ");

        ReadProperties.ConfigFileReader();

    }

    /******************* Take Screenshot ********************/
    public static void TakeScreenshot(){
        CaptureScreenshots.TakeScreenshot(driver,"FormFillingRegression");
    }
    /******************* Close Browser ********************/
    public void closeBrowser() {

        logger.createNode(" ");
        logger.createNode(" Browser Closed Successfully ");
        logger.createNode(" ");

        report.flush();
        driver.quit();
    }


}
