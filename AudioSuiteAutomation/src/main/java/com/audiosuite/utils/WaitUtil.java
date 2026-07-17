package com.audiosuite.utils;

import com.audiosuite.config.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {
	
    private static long EXPLICIT_WAIT = Long.parseLong(ConfigReader.get("explicit.wait"));

    private static WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
    } 

    public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
        return getWait(driver).until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickable(WebDriver driver, WebElement element) {
        return getWait(driver).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebDriver driver, WebElement element) {
        waitForClickable(driver, element).click();
    }


    public static boolean isElementDisplayed(WebDriver driver, By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void waitForPageLoad(WebDriver driver) {
        getWait(driver).until(webDriver ->
            ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }
    public static void waitUntilUrlContains(WebDriver driver, String urlFragment) {
		getWait(driver).until(ExpectedConditions.urlContains(urlFragment));
	}
}
