package com.audiosuite.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BroadcastPage extends GenericPage {

	

	// Tabs
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='All']")
	private WebElement allTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Scheduled']")
	private WebElement scheduledTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Running']")
	private WebElement runningTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Completed']")
	private WebElement completedTab;

	@FindBy(id = "broadcastTable")
	private WebElement broadcastTable;
	@FindBy(css = ".add-broadcast-icon")
	private WebElement addNewIcon;

	@FindBy(css = ".items-per-page")
	private WebElement itemsPerPageDropdown;
	@FindBy(css = ".pagination-next")
	private WebElement nextPageButton;
	@FindBy(css = ".pagination-prev")
	private WebElement prevPageButton;

	public BroadcastPage(WebDriver driver) {
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

	public boolean isBroadcastTableDisplayed() {
		return broadcastTable.isDisplayed();
	}

	private String rowByNameXpath(String broadcastName) {
		return "//table[@id='broadcastTable']//td[normalize-space()='" + broadcastName + "']/ancestor::tr";
	}

//	public void editBroadcast(String broadcastName) {
//		WaitUtil.click(driver, By.xpath(rowByNameXpath(broadcastName) + "//i[contains(@class,'edit-icon')]"));
//	}
//
//	public void suspendBroadcast(String broadcastName) {
//		WaitUtil.click(driver, By.xpath(rowByNameXpath(broadcastName) + "//i[contains(@class,'suspend-icon')]"));
//	}
//
//	public void pauseBroadcast(String broadcastName) {
//		WaitUtil.click(driver, By.xpath(rowByNameXpath(broadcastName) + "//i[contains(@class,'pause-icon')]"));
//	}
//
//	public void resumeBroadcast(String broadcastName) {
//		WaitUtil.click(driver, By.xpath(rowByNameXpath(broadcastName) + "//i[contains(@class,'resume-icon')]"));
//	}
//
//	public void viewBroadcast(String broadcastName) {
//		WaitUtil.click(driver, By.xpath(rowByNameXpath(broadcastName) + "//i[contains(@class,'view-icon')]"));
//	}
//
//	public void deleteBroadcast(String broadcastName) {
//		WaitUtil.click(driver, By.xpath(rowByNameXpath(broadcastName) + "//i[contains(@class,'delete-icon')]"));
//	}
//
//	public void viewBroadcastInformation(String broadcastName) {
//		WaitUtil.click(driver, By.xpath(rowByNameXpath(broadcastName) + "//i[contains(@class,'info-icon')]"));
//	}
//
//	public void repeatBroadcast(String broadcastName) {
//		WaitUtil.click(driver, By.xpath(rowByNameXpath(broadcastName) + "//i[contains(@class,'repeat-icon')]"));
//	}
//
//	public void viewBroadcastReport(String broadcastName) {
//		WaitUtil.click(driver, By.xpath(rowByNameXpath(broadcastName) + "//i[contains(@class,'description-icon')]"));
//	}

	public NewBroadcastPage clickAddNew() {
		addNewIcon.click();
		return new NewBroadcastPage(driver);
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
