package utils;

import main.FormFillingPage;
import main.IdentifyCoursePage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    /******************* Read Configure File Properties ********************/
    public static void ConfigFileReader(){
        BufferedReader reader; Properties properties;
        String propertyFilePath =   System.getProperty("user.dir") + "/Test_configuration/config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
       DriverSetup.invokeBrowsers(properties.getProperty("browserName"), properties.getProperty("WebsiteURL"));
    }

}
