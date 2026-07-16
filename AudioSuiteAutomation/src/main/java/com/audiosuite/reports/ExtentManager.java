package com.audiosuite.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.audiosuite.config.ConfigReader;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = ConfigReader.get("report.path");
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setDocumentTitle("Audio Suite Test Report");
            spark.config().setReportName("Telesuite - ENS.Conference.IVRS (Audio Suite) v1.4.0");
            spark.config().setTheme(Theme.DARK);
            spark.config().setEncoding("UTF-8");
//           ----------- Custom CSS to add Telesoft Labs logo and adjust layout -----------
            String css =
            	    ".nav-logo {" +
            	    "margin-left: -25px !important;" +
            	    "}" +
            	    ".nav-logo .logo {" +
            	    "background-image: url('" + ConfigReader.get("report.logopath") + "') !important;" +
            	    "background-repeat: no-repeat !important;" +
            	    "background-size: contain !important;" +
            	    "background-position: left center !important;" +
            	    "width: 75px !important;" +
            	    "height: 40px !important;" +
            	    "}" +
            	    ".search-box {" +
            	    "margin-left: 40px !important;" +
            	    "}";
            spark.config().setCss(css);
  // ----------- Custom JavaScript to make the logo clickable and open in a new tab -----------
            String js =
            	    "document.querySelector('.nav-logo a').href='https://www.telesoftlabs.com/';" +
            	    "document.querySelector('.nav-logo a').target='_blank';" +
            	    "document.querySelector('link[rel=\"shortcut icon\"]').href='" + ConfigReader.get("report.logopath") + "';" +
            	    "document.querySelector('link[rel=\"apple-touch-icon\"]').href='" + ConfigReader.get("report.logopath") + "';";

            spark.config().setJs(js);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Application", "TSL Audio Suite - ENS.Conference.IVRS");
            extent.setSystemInfo("Version", "1.4.0");
            extent.setSystemInfo("Developer", "Anusha");
            extent.setSystemInfo("Environment", ConfigReader.get("env"));
            extent.setSystemInfo("Browser", ConfigReader.get("browser"));
            extent.setSystemInfo("Author", "Samprith");
        }
        return extent;
    }
}
