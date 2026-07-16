package com.audiosuite.pages;


import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.audiosuite.utils.LogUtil;

public class EmergencyPage extends GenericPage {
	public static final Logger log = LogUtil.getLogger(EmergencyPage.class);
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	// Tabs
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Emergency']")
	private WebElement emergencyTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Live']")
	private WebElement liveTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Completed']")
	private WebElement completedTab;

	// Table & Actions
	@FindBy(id = "emergencyTable")
	private WebElement emergencyTable;
	@FindBy(xpath = "//button[contains(@mattooltip,'New Emergency')]")
	private WebElement addNewIcon;
	@FindBy(xpath = "//mat-cell[contains(@class,'scheduleName')]//div[contains(text(),'Test')]/following::mat-cell/div/label")
	private WebElement emergencyButton;
	@FindBy(xpath = "//h2[contains(text(),'Are you sure you want to trigger the Emergency?')]")
	private WebElement confirmTriggerDailogbox;
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	private WebElement confirmTriggerYes;
	
	// Pagination
	@FindBy(css = ".items-per-page")
	private WebElement itemsPerPageDropdown;
	@FindBy(css = ".pagination-next")
	private WebElement nextPageButton;
	@FindBy(css = ".pagination-prev")
	private WebElement prevPageButton;

	public EmergencyPage(WebDriver driver) {
		super(driver);
	}

	// Tabs
	public void openEmergencyTab() {
		emergencyTab.click();
	}

	public void openLiveTab() {
		liveTab.click();
	}

	public void openCompletedTab() {
		completedTab.click();
	}

	public boolean isEmergencyTableDisplayed() {
		return emergencyTable.isDisplayed();
	}



	// Add New Emergency
	public void clickAddNew() throws InterruptedException {
		addNewIcon.click();
		Thread.sleep(1000); // Wait for the new emergency dialog to appear
		log.info("Clicked on Add New Emergency icon.");
		
	}

	// Trigger via GUI Emergency button
	public void triggerEmergencyButton() {
		wait.until(ExpectedConditions.elementToBeClickable(emergencyButton));
		emergencyButton.click();
		log.info("Clicked on Emergency button to trigger.");
		if(confirmTriggerDailogbox.isDisplayed()) {
			confirmTriggerYes.click();
		}
		
	}

	// Pagination
	public void setItemsPerPage(String value) {
		new Select(itemsPerPageDropdown).selectByVisibleText(value);
	}

	public void goToNextPage() {
		nextPageButton.click();
	}

	public void goToPrevPage() {
		prevPageButton.click();
	}
}
