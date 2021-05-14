package testcases;
import main.FormFillingPage;
import org.testng.annotations.Test;

public class FormFillingTest extends FormFillingPage {

    @Test(priority = 1,groups = {"Smoke Suite","Regression Suite"})
    public void invoke() throws Exception{
        logger=report.createTest("Invoked browser successfully");
        invokeReadProperties();
    }

    @Test(priority = 2,groups = {"Smoke Suite","Regression Suite"})
    public void ClickForEnterprise() throws Exception{
        logger = report.createTest(" Clicked For Enterprise ");
        ForEnterprise();
    }

    @Test(priority = 3,groups = {"Smoke Suite","Regression Suite"})
    public void FillingForm() throws Exception{
        logger = report.createTest(" Filling Form ");
        FillForm();
    }


    @Test(priority = 4,groups = {"Smoke Suite","Regression Suite"})
    public void Close() throws Exception{
        logger = report.createTest(" Close Browser Successfully ");
        closeBrowser();
    }

}
