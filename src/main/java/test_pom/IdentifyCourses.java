package test_pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IdentifyCourses {
    @FindBy(xpath= "//*[@id=\"react-select-2--value\"]/div[1]")
    public static WebElement Language;

    @FindBy(xpath= "//*[@id=\"react-select-2--option-0\"]/div/button/label/input")
    public static WebElement English;

    @FindBy(xpath= "//*[@id=\"react-select-3--value\"]/div[1]")
    public static WebElement Level;

    @FindBy(xpath= "//input[@value='Beginner']")
    public static WebElement Beginner;

    @FindBy(xpath = "//li[@class='ais-InfiniteHits-item'][1]//div[@class='rc-DesktopSearchCard anchor-wrapper']//h2[1]")
    public static WebElement FirstCourse;

    @FindBy(xpath = "//li[@class='ais-InfiniteHits-item'][1]//div[@class='rc-DesktopSearchCard anchor-wrapper']//h2[1]")
    public static WebElement CourseName1;

    @FindBy(xpath = "//li[@class='ais-InfiniteHits-item'][1]//div[@class='rc-DesktopSearchCard anchor-wrapper']//span[@class='ratings-text']")
    public static WebElement Rating1;

    @FindBy(xpath= "//div[@class='ProductGlance']/div/div[@class='_1tu07i3a']/div/span")
    public static WebElement Duration1;

    @FindBy(xpath = "//li[@class='ais-InfiniteHits-item'][2]//div[@class='rc-DesktopSearchCard anchor-wrapper']")
    public static WebElement SecondCourse;

    @FindBy(xpath= "//li[@class='ais-InfiniteHits-item'][2]//div[@class='rc-DesktopSearchCard anchor-wrapper']//h2")
    public static WebElement CourseName2;

    @FindBy(xpath= "//li[@class='ais-InfiniteHits-item'][2]//div[@class='rc-DesktopSearchCard anchor-wrapper']//span[@class='ratings-text']")
    public static WebElement Rating2;

    @FindBy(xpath= "//div[@class='ProductGlance']/div/div[@class='_1tu07i3a']/div/../div/span")
    public static WebElement Duration2;
}
