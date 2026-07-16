package com.audiosuite.pages;

import com.audiosuite.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CLILocationPage extends GenericPage {



	@FindBy(id = "cliLocationTable")
	private WebElement cliLocationTable;
	@FindBy(css = ".add-cli-location-icon")
	private WebElement addNewIcon;
	@FindBy(css = ".cli-location-filter")
	private WebElement filterBar;

	// Add New Record fields
	@FindBy(id = "cli")
	private WebElement cliField;
	@FindBy(id = "location")
	private WebElement locationField;
	@FindBy(id = "browseVoiceFile")
	private WebElement voiceFileBrowseButton;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveButton;

	// Import / Export
	@FindBy(xpath = "//button[normalize-space()='Export']")
	private WebElement exportButton;
	@FindBy(xpath = "//button[normalize-space()='Import']")
	private WebElement importButton;
	@FindBy(css = ".download-sample-icon")
	private WebElement downloadSampleButton;

	@FindBy(css = ".items-per-page")
	private WebElement itemsPerPageDropdown;
	@FindBy(css = ".pagination-next")
	private WebElement nextPageButton;
	@FindBy(css = ".pagination-prev")
	private WebElement prevPageButton;

	public CLILocationPage(WebDriver driver) {
		super(driver);
	}

	public boolean isCliLocationTableDisplayed() {
		return cliLocationTable.isDisplayed();
	}

	public void filterRecords(String keyword) {
		filterBar.clear();
		filterBar.sendKeys(keyword);
	}

	public void clickAddNew() {
		addNewIcon.click();
	}

	public void addCliLocationMapping(String cli, String location, String voiceFilePath) {
		clickAddNew();
		cliField.clear();
		cliField.sendKeys(cli);
		locationField.clear();
		locationField.sendKeys(location);
		voiceFileBrowseButton.clear();
		voiceFileBrowseButton.sendKeys(voiceFilePath);
		saveButton.click();
	}

	

	public void exportRecords() {
		exportButton.click();
	}

	public void importRecords(String filePath) {
		importButton.click();

	}

	public void downloadSampleFile() {
		downloadSampleButton.click();
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
