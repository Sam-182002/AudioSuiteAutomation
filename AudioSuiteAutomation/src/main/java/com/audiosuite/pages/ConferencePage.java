package com.audiosuite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.audiosuite.utils.WaitUtil;

public class ConferencePage extends GenericPage {



	// Tabs
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='All']")
	private WebElement allTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Scheduled']")
	private WebElement scheduledTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Running']")
	private WebElement runningTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Completed']")
	private WebElement completedTab;

	@FindBy(id = "conferenceTable")
	private WebElement conferenceTable;
	@FindBy(css = ".add-conference-icon")
	private WebElement addNewIcon;

	@FindBy(css = ".items-per-page")
	private WebElement itemsPerPageDropdown;
	@FindBy(css = ".pagination-next")
	private WebElement nextPageButton;
	@FindBy(css = ".pagination-prev")
	private WebElement prevPageButton;

	public ConferencePage(WebDriver driver) {
		super(driver);
		
	}

	public void openAllTab() {
		allTab.click();
	}

	public void openScheduledTab() {
		scheduledTab.click();
	}

	public void openRunningTab() {
		runningTab.click();
	}

	public void openCompletedTab() {
		completedTab.click();
	}

	public boolean isConferenceTableDisplayed() {
		return conferenceTable.isDisplayed();
	}

	private String rowByNameXpath(String conferenceName) {
		return "//table[@id='conferenceTable']//td[normalize-space()='" + conferenceName + "']/ancestor::tr";
	}

	public void editConference(String conferenceName) {
	}

	public StatusPage launchConference(String conferenceName) {
	
		return new StatusPage(driver);
	}

	public void viewConference(String conferenceName) {
	}

	public void deleteConference(String conferenceName) {
		
	}

	public void viewConferenceInformation(String conferenceName) {
	}

	public void repeatConference(String conferenceName) {
		 
	}

	public void viewConferenceReport(String conferenceName) {
		
	}

	public NewConferencePage clickAddNew() {
		addNewIcon.click();
		return new NewConferencePage(driver);
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
