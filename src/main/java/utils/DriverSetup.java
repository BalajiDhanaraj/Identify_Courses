package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverSetup extends ReadProperties{
    public static WebDriver driver;
    /******************* Invoke Browser ********************/
    public static void invokeBrowsers(String browserName,String url) {

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/test_drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/test_drivers/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(url);
    }
}
