package com.audiosuite.pages;

import com.audiosuite.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage extends GenericPage {



	// Header Bar
	@FindBy(css = ".header-user-info")
	private WebElement userInfo;
	@FindBy(id = "branchDropdown")
	private WebElement branchDropdown;
	@FindBy(xpath = "//mat-icon[text()='account_circle']")
	private WebElement profileIcon;
	@FindBy(xpath = "//button[@mattooltip='Logout']")
	private WebElement logoutButton;

	// Navigation Panel
	@FindBy(xpath = "//mat-list-item[@mattooltip='Dashboard']")
	private WebElement dashboardMenu;
	@FindBy(xpath = "//mat-list-item[@mattooltip='Emergency']")
	private WebElement emergencyMenu;

	@FindBy(xpath = "//mat-icon[text()='notifications_active']/following::mat-icon[text()='more_vert']")
	private WebElement recordingsMenu;
	@FindBy(xpath = "//button[@mattooltip='Recordings']")
	private WebElement recordingsButton;
	
	@FindBy(xpath = "//mat-list-item[@mattooltip='Broadcast']")
	private WebElement broadcastMenu;
	@FindBy(xpath = "//mat-list-item[@mattooltip='Conference']")
	private WebElement conferenceMenu;
	@FindBy(xpath = "//mat-list-item[@mattooltip='Users']")
	private WebElement usersMenu;
	@FindBy(xpath = "//mat-list-item[@mattooltip='Contacts']")
	private WebElement contactsMenu;
	@FindBy(xpath = "//mat-list-item[@mattooltip='Reports']")
	private WebElement reportsMenu;
	@FindBy(xpath = "//mat-list-item[@mattooltip='Roles']")
	private WebElement rolesMenu;
	@FindBy(xpath = "//mat-list-item[@mattooltip='Settings']")
	private WebElement settingsIcon;
	@FindBy(xpath = "//mat-list-item[contains(@mattooltip,'CLI Location')]")
	private WebElement cliLocationMenu;

	// Duration & Tabs
	@FindBy(id = "selectedDuration")
	private WebElement durationDropdown;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Voice']")
	private WebElement voiceTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='WhatsApp']")
	private WebElement whatsAppTab;

	// Main Workspace widgets
	@FindBy(css = ".billing-summary-widget")
	private WebElement billingSummaryWidget;
	@FindBy(css = ".calls-count-chart")
	private WebElement callsCountChart;
	@FindBy(css = ".channels-usage-widget")
	private WebElement channelsUsageWidget;
	@FindBy(id = "scheduleTable")
	private WebElement scheduleTable;
	@FindBy(css = ".whatsapp-reply-status-chart")
	private WebElement whatsappReplyChart;
	@FindBy(css = ".whatsapp-broadcast-status-chart")
	private WebElement whatsappBroadcastStatusChart;

	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	public boolean isDashboardDisplayed() {
		return billingSummaryWidget.isDisplayed();
	}

	// Branch switching
	public void switchBranch(String branchName) {
		branchDropdown.click();
		
	}

	// Profile / Logout
	public void openProfileMenu() {
		profileIcon.click();
	}

	public void logout() {
		openProfileMenu();
		logoutButton.click();
	}

	// Navigation
	public void goToDashboard() {
		dashboardMenu.click();
	}

	public void goToEmergency() {
		emergencyMenu.click();
	}
	
	public void goToRecordings() {
		Actions actions = new Actions(driver);
		emergencyMenu.click();
		actions.moveToElement(recordingsMenu).click().perform();
	    WaitUtil.waitForVisibility(driver, recordingsButton);
	    actions.moveToElement(recordingsButton).click().perform();
	}

	public void goToBroadcast() {
		broadcastMenu.click();
	}

	public void goToConference() {
		conferenceMenu.click();
	}

	public void goToUsers() {
		usersMenu.click();
	}

	public void goToContacts() {
		contactsMenu.click();
	}

	public void goToReports() {
		reportsMenu.click();
	}

	public void goToRoles() {
		rolesMenu.click();
	}

	public void goToSettings() {
		settingsIcon.click();
	}

	public void goToCliLocation() {
		cliLocationMenu.click();
	}

	// Duration filter
	public void selectDuration(String duration) {
		new Select(durationDropdown).selectByVisibleText(duration);
	}

	// Tabs
	public void openVoiceTab() {
		voiceTab.click();
	}

	public void openWhatsAppTab() {
		whatsAppTab.click();
	}

	// Widget checks
	public boolean isBillingSummaryVisible() {
		return billingSummaryWidget.isDisplayed();
	}

	public boolean isCallsCountChartVisible() {
		return callsCountChart.isDisplayed();
	}

	public boolean isChannelsUsageVisible() {
		return channelsUsageWidget.isDisplayed();
	}

	public boolean isScheduleTableVisible() {
		return scheduleTable.isDisplayed();
	}

	public boolean isWhatsAppReplyChartVisible() {
		return whatsappReplyChart.isDisplayed();
	}

	public boolean isWhatsAppBroadcastStatusChartVisible() {
		return whatsappBroadcastStatusChart.isDisplayed();
	}
}
