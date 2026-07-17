package com.audiosuite.base;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.audiosuite.config.ConfigReader;
import com.audiosuite.pages.DashboardPage;
import com.audiosuite.pages.LoginPage;
import com.audiosuite.reports.ExtentManager;
import com.audiosuite.utils.JavaUtility;
import com.audiosuite.utils.LogUtil;
import com.audiosuite.utils.WebDriverUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass {

	public static WebDriver driver;
	public static ExtentReports ereport;
	public static ExtentTest test;
	public JavaUtility jutil = new JavaUtility();
	ExtentManager em = new ExtentManager();
	WebDriverUtility wutil = new WebDriverUtility();
	public static  Logger log = LogUtil.getLogger(BaseClass.class);

	@BeforeSuite
	public void openBrowser() throws InterruptedException {
		ereport = ExtentManager.getInstance();
		log.info("Extent Report Configured");

		try {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			log.info("Launching Chrome browser...");
			driver = new ChromeDriver(options);
			log.info("Chrome browser launched successfully.");
			wutil.maximize(driver);
			log.info("Browser window maximized.");
			wutil.implicitWait(driver, 5);
			String url = ConfigReader.get("base.url");
			driver.get(url);
			log.info("Opened application URL: " + url);
		} catch (Exception e) {
			log.error("Browser initialization failed: {}", e.getMessage(), e);
			throw new RuntimeException("Browser initialization failed.", e);
		}

//----------------Login to the application-----------------

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));

//------------Branch dialogbox if it appears ---------------------		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		// Handle session dialog if it appears
		if (loginPage.isSessionDialogDisplayed()) {
			log.info("Session dialog detected.");
			loginPage.sessionDialogButton.click();
			Thread.sleep(1000);
			loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
			log.info("Session dialog handled.");
		}
//------------Branch dialogbox if it appears ---------------------	
		if (loginPage.isBranchDialogDisplayed()) {
			log.info("Branch dialog detected.");
			Thread.sleep(1000);
			loginPage.branchDialogBoxButton.click();
			loginPage.selectBranch("Bangalore");
			log.info("Branch selected.");
		}

	

//----------------Verify the URL after login-----------------

		String expectedUrl = ConfigReader.get("base.url") + "main";
		Thread.sleep(1000);
		String actualUrl = wutil.getCurrentUrl(driver);

		if (!actualUrl.equals(expectedUrl)) {
			log.error("Login failed. Expected URL: {}, Actual URL: {}", expectedUrl, actualUrl);
		}

		SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals(actualUrl, expectedUrl);
		softAssert.assertEquals(loginPage.getSnackMessage(), "Login successful", "Snack message mismatch after login.");
		softAssert.assertAll();

		log.info("Login  completed successfully.");
	}

//    @BeforeMethod
//	public void login() throws IOException {
//		
//	}
//
//	@BeforeMethod
//	public void login() throws IOException {
//		
//	}
//
//	@AfterMethod
//	public void logout() {
//     
//		log.info("Logged out successfully");
//
//	}
//
//	@AfterClass
//	public void closeBrowser() {
//		
//	}

	@AfterSuite(alwaysRun = true)
	public void reportBackup() {
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.logout();
		try {
			if (driver != null) {
				driver.quit();
				log.info("Browser closed successfully.");
			}
		} finally {
			if (ereport != null) {
				ereport.flush();
				log.info("Extent Report flushed successfully.");
			}
		}
	}
}