package com.audiosuite.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.audiosuite.utils.LogUtil;


public class RecordingsPage extends GenericPage {
	
	public static  Logger log = LogUtil.getLogger(RecordingsPage.class);


	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Play Messages']")
	private WebElement playMessagesTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='ENS Voice Files']")
	private WebElement ensVoiceFilesTab;

	
	@FindBy(css = "//mat-label[contains(text(),'Filter')]/preceding::input")
	private WebElement filterSearchBar;
	@FindBy(xpath = "//button[@mattooltip='Add New Recording']")
	private WebElement addNewButton;

	@FindBy(xpath = "//mat-row[1]/mat-cell[count(//mat-header-cell[normalize-space()='Description']/preceding-sibling::mat-header-cell)+1]//input")
	private WebElement descriptionField;
	@FindBy(xpath = "//input[@type='file']")
	private WebElement voiceFileBrowseBtn;
	@FindBy(xpath = "//button[@mattooltip='Save Changes']")
	private WebElement saveRecordingBtn;

	@FindBy(css = ".items-per-page")
	private WebElement itemsPerPageDropdown;
	@FindBy(css = ".pagination-next")
	private WebElement nextPageButton;
	@FindBy(css = ".pagination-prev")
	private WebElement prevPageButton;

	public RecordingsPage(WebDriver driver) {
		super(driver);
	}

	public void openPlayMessagesTab() {
		playMessagesTab.click();
	}

	public void openEnsVoiceFilesTab() {
		ensVoiceFilesTab.click();
	}

	
	public void filterRecordings(String keyword) {
		filterSearchBar.clear();
		filterSearchBar.sendKeys(keyword);
	}

	public void clickAddNew() {
		addNewButton.click();
	}

	public void addVoiceFile(String description, String filePath) throws InterruptedException {
		clickAddNew();
		descriptionField.clear();
		log.info("Entering description: " + description);
		descriptionField.sendKeys(description);Thread.sleep(1000);
		log.info("Uploading voice file: " + filePath);
		voiceFileBrowseBtn.sendKeys(filePath);Thread.sleep(1000);
		saveRecordingBtn.click();
		log.info("Clicked Save Changes button.");
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
