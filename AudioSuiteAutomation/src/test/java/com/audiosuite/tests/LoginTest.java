package com.audiosuite.tests;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.audiosuite.config.ConfigReader;
import com.audiosuite.pages.DashboardPage;
import com.audiosuite.pages.LoginPage;
import com.audiosuite.utils.LogUtil;
import com.audiosuite.utils.WaitUtil;
import com.audiosuite.utils.WebDriverUtility;

public class LoginTest {

	WebDriverUtility wutil = new WebDriverUtility();
	public static final Logger log = LogUtil.getLogger(LoginTest.class);
	private WebDriver driver;

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return new Object[][] {
			{ "support@telesoftlabs.com", "Telesuite@8765", true },
			{ "anusha@telesoft.in", "Wrong@1234", false },
			{ "samprithPs@gmail.com", "Wrong@13444", false }
		};
	}

	@Test(dataProvider = "loginData")
	public void testLogin(String username, String password, boolean isValidLogin) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.get(ConfigReader.get("base.url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);

		SoftAssert softAssert = new SoftAssert();

		if (!isValidLogin) {
//----------------Verify invalid credentials snackbar and close browser-----------------

			Thread.sleep(1000);
			String snackMessage = loginPage.getSnackMessage();
			log.info("Snack message for invalid login: " + snackMessage);
			softAssert.assertEquals(snackMessage, "Invalid email or password",
					"Snack message mismatch for invalid login.");
			softAssert.assertAll();
			return;
		}

//----------------Handle session dialogbox if it appears------------------

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ZERO);
			if (loginPage.sessionDialogBox.isDisplayed()) {
				log.info("Session dialog box detected. Handling session dialog...");
				Thread.sleep(500);
				loginPage.sessionDialogButton.click();
				Thread.sleep(500);
				loginPage.login(username, password);
				log.info("session dialog handled.");
			}
		} catch (NoSuchElementException e) {
			log.info("Session dialog box not displayed. Skipping.");
		} finally {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}

//------------Branch dialogbox if it appears ---------------------

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ZERO);
			if (loginPage.branchDialogBox.isDisplayed()) {
				log.info("Branch selection dialog box detected. Handling branch selection...");
				loginPage.branchDialogBoxButton.click();
				loginPage.selectBranch("Bangalore");
				log.info("Branch selection dialog handled.");
				Thread.sleep(500);
			}
		} catch (NoSuchElementException e) {
			log.info("Branch selection dialog box not displayed. Skipping.");
		} finally {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}

//----------------Verify the URL after login-----------------

		

		softAssert.assertEquals(loginPage.getSnackMessage(), "Login successful", "Snack message mismatch after login.");

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.logout();
		WaitUtil.waitUntilUrlContains(driver, "login");

		softAssert.assertAll();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			log.info("Browser closed successfully.");
		}
	}
}