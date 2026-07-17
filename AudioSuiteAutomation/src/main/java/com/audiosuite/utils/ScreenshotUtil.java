package com.audiosuite.utils;

import com.audiosuite.config.ConfigReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
	ConfigReader configReader = new ConfigReader();

    public  String capture(WebDriver driver, String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = testName + "_" + timestamp + ".png";
        String filePath = configReader.getConfigData("screenshot.path") + fileName;

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);
            dest.getParentFile().mkdirs();
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot saved: " + filePath);
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
        return filePath;
    }
}
