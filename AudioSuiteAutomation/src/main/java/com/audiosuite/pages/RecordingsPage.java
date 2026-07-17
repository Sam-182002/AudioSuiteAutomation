package com.audiosuite.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
  // Update Voice Files
	public void updateVoiceFile(String FileName,String description, String filePath) throws InterruptedException {
		driver.findElement(By.xpath("//mat-cell[contains(text(),'"+FileName+"')]/following-sibling::mat-cell/button[@mattooltip='Edit Recording']")).click();
		descriptionField.clear();
		log.info("Updating description to: " + description);
		descriptionField.sendKeys(description);Thread.sleep(1000);
		log.info("Uploading new voice file: " + filePath);
		voiceFileBrowseBtn.sendKeys(filePath);Thread.sleep(1000);
		saveRecordingBtn.click();
		log.info("Clicked Save Changes button.");
	}
	// Delete Voice Files
	public void deleteVoiceFile(String FileName) throws InterruptedException {
		driver.findElement(By.xpath("//mat-cell[contains(text(),'"+FileName+"')]/following-sibling::mat-cell/button[@mattooltip='Delete Recording']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		log.info("Clicked Yes to confirm deletion of voice file: " + FileName);
		Thread.sleep(1000); 
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
