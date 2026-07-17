package com.audiosuite.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverUtility {
	
	
	//----------------- Browser Operations -----------------
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}

	public void navigateForward(WebDriver driver) {
		driver.navigate().forward();
	}

	
	// ----------------- Wait Utilities----------------------
	
	
	public void implicitWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void waitForElementToBeVisible(WebDriver driver, WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	//----------------- Dropdown Utilities -----------------
	
	public void selectDropdown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void selectDropdown(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void selectDropdown(String text, WebElement element) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	//----------------- Mouse Actions -----------------
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}

	//----------------- JavaScript Utilities ----------------- 
	
	public void scrollBy(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(arguments[0],arguments[1])", x, y);
	}

	public void clickUsingJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void sendKeysUsingJS(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1]", element, value);
	}

	// ----------------- Frame Utilities -----------------
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	//----------------- Alert Utilities -----------------
	
	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendTextToAlert(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// ----------------- Screenshot Utility -----------------
	
	public String captureScreenshot(WebDriver driver, String screenshotName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		String path = "./screenshots/" + screenshotName + ".png";

		File dest = new File(path);

		FileHandler.copy(src, dest);

		return path;
	}

	// ----------------- Window Handling -----------------
	
	public void switchToWindow(WebDriver driver, String partialUrl) {

		Set<String> allWindowIds = driver.getWindowHandles();

		for (String id : allWindowIds) {

			driver.switchTo().window(id);

			if (driver.getCurrentUrl().contains(partialUrl)) {
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expTitle) {

		Set<String> allWindowIds = driver.getWindowHandles();

		for (String id : allWindowIds) {

			driver.switchTo().window(id);

			if (driver.getTitle().contains(expTitle)) {
				break;
			}
		}
	}

	// ----------------- Get Current Information -----------------
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
}
