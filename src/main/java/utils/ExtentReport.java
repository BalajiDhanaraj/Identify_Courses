package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReport {
    public static ExtentReports report;

    /******************* Report Generation ********************/
    public static ExtentReports getReportInstance() {

        if (report == null) {
            String reportName = DateUtils.getTimeStamp() + ".html";
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Test_reports/" +reportName);
            report = new ExtentReports();
            report.attachReporter(htmlReporter);

            report.setSystemInfo("OS", "MAC 11.3.1");
            report.setSystemInfo("Environment", "UAT");
            report.setSystemInfo("Build Number", "10.8.1");
            report.setSystemInfo("Browser", "Chrome");

            htmlReporter.config().setDocumentTitle("UAT UI Automation Results");
            htmlReporter.config().setReportName("All Headlines UI Test Report");
            htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
            htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");

        }
        return report;
    }
}
