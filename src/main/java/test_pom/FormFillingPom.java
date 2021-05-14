package test_pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormFillingPom {

    @FindBy(id = "FirstName")
    public static WebElement Fname;

    @FindBy(id = "LastName")
    public static WebElement Lname;

    @FindBy(id = "C4C_Job_Title__c")
    public static WebElement JobFunction;

    @FindBy(id = "Title")
    public static WebElement Jobtitle;

    @FindBy(id = "Email")
    public static WebElement Email;

    @FindBy(id = "Phone")
    public static WebElement Phone;

    @FindBy(id = "Company")
    public static WebElement Institutename;

    @FindBy(id = "Institution_Type__c")
    public static WebElement InstituteType;

    @FindBy(id = "Primary_Discipline__c")
    public static WebElement PrimaryDisipline;

    @FindBy(id = "Country")
    public static WebElement Country;

    @FindBy(id = "State")
    public static WebElement State;

    @FindBy(xpath = "//*[@id=\"mktoForm_1512\"]/div[20]/span/button")
    public static WebElement Submit;

    @FindBy(id = "ValidMsgEmail")
    public static WebElement ErrorMessage;
}
