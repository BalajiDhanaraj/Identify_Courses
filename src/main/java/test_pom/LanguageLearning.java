package test_pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.html.HTMLInputElement;

import static org.openqa.selenium.By.xpath;

public class LanguageLearning {


    @FindBy(xpath = "//input[@class='react-autosuggest__input']")
    public static WebElement search;

    @FindBy(xpath = "//div[contains(text(),'Language')]")
    public static WebElement selectLanguage;

    @FindBy(xpath = "//button[contains(text(),'Show All')]")
    public static WebElement showAll;

    @FindBy(xpath = "//div[@class=\"checkboxText\"]")
    public static WebElement langName;

    @FindBy(xpath = "//div[@class='filter-count']")
    public static WebElement langCount;

    @FindBy(xpath = "//a[contains(text(),'✕')]")
    public static WebElement closeLanguage;

    @FindBy(xpath = "//div[contains(text(),'Level')]")
    public static WebElement selectLevel;

    @FindBy(xpath = "//div@class=\"checkboxText\"]")
    public static WebElement levelName;

    @FindBy(xpath = "//div[@class=\"filter-count\"]")
    public static WebElement levelCount;



    //div[@class='filter-count']
}
