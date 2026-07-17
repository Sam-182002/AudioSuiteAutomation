package com.audiosuite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReportsPage extends GenericPage {



	@FindBy(id = "selectDuration")
	private WebElement selectDurationDropdown;
	@FindBy(id = "reportStartDate")
	private WebElement startDateField;
	@FindBy(id = "reportEndDate")
	private WebElement endDateField;
	@FindBy(id = "selectApp")
	private WebElement selectAppDropdown;
	@FindBy(id = "selectCli")
	private WebElement selectCliDropdown;
	@FindBy(id = "selectLocation")
	private WebElement selectLocationDropdown;
	@FindBy(id = "selectReportType")
	private WebElement selectReportTypeDropdown;
	@FindBy(id = "selectDid")
	private WebElement selectDidDropdown;
	@FindBy(xpath = "//button[normalize-space()='Show Report']")
	private WebElement showReportButton;
	@FindBy(css = ".report-result-container")
	private WebElement reportResultContainer;

	public ReportsPage(WebDriver driver) {
		super(driver);
	}

	public void selectDuration(String duration) {
		new Select(selectDurationDropdown).selectByVisibleText(duration);
	}

	public void selectDateRange(String startDate, String endDate) {
		selectDuration("Date between Analysis");
		startDateField.clear();
		startDateField.sendKeys(startDate);
		endDateField.clear();
		endDateField.sendKeys(endDate);
	}

	public void selectApp(String app) {
		new Select(selectAppDropdown).selectByVisibleText(app);
	}

	public void selectCli(String cli) {
		new Select(selectCliDropdown).selectByVisibleText(cli);
	}

	public void selectLocation(String location) {
		new Select(selectLocationDropdown).selectByVisibleText(location);
	}

	public void selectReportType(String reportType) {
		new Select(selectReportTypeDropdown).selectByVisibleText(reportType);
	}

	public void selectDid(String did) {
		new Select(selectDidDropdown).selectByVisibleText(did);
	}

	public void clickShowReport() {
		showReportButton.click();
	}

	public boolean isReportDisplayed() {
		return reportResultContainer.isDisplayed();
	}

	public void generateEnsReport(String duration, String cli, String location, String reportType, String did) {
		selectDuration(duration);
		selectApp("ENS");
		selectCli(cli);
		selectLocation(location);
		selectReportType(reportType);
		selectDid(did);
		clickShowReport();
	}

	public void generateVoiceBroadcastReport(String duration, String reportType, String did) {
		selectDuration(duration);
		selectApp("Voice Broadcast");
		selectReportType(reportType);
		selectDid(did);
		clickShowReport();
	}

	public void generateConferenceReport(String duration, String reportType, String did) {
		selectDuration(duration);
		selectApp("Conference");
		selectReportType(reportType);
		selectDid(did);
		clickShowReport();
	}
}
