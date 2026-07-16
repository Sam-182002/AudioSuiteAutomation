package com.audiosuite.pages;

import com.audiosuite.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StatusPage extends GenericPage {

	

	@FindBy(css = ".conference-name-header")
	private WebElement conferenceNameHeader;

	// Left-side menu icons
	@FindBy(css = ".call-icon")
	private WebElement callIcon;
	@FindBy(css = ".disconnect-icon")
	private WebElement disconnectIcon;
	@FindBy(css = ".mute-icon")
	private WebElement muteIcon;
	@FindBy(css = ".unmute-icon")
	private WebElement unmuteIcon;
	@FindBy(css = ".select-all-icon")
	private WebElement selectAllIcon;
	@FindBy(css = ".disperse-icon")
	private WebElement disperseIcon;
	@FindBy(css = ".force-remove-icon")
	private WebElement forceRemoveIcon;
	@FindBy(css = ".add-member-icon")
	private WebElement addMemberIcon;
	@FindBy(css = ".prevent-new-members-icon")
	private WebElement preventNewMembersIcon;
	@FindBy(css = ".refresh-icon")
	private WebElement refreshIcon;
	@FindBy(css = ".conference-settings-icon")
	private WebElement settingsIcon;

	// Confirmation dialogs
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	private WebElement confirmYesButton;
	@FindBy(xpath = "//button[normalize-space()='No']")
	private WebElement confirmNoButton;

	// Add Member dialog
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='new']")
	private WebElement addMemberNewTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Existing']")
	private WebElement addMemberExistingTab;
	@FindBy(id = "newGroupName")
	private WebElement newGroupNameField;
	@FindBy(id = "newMemberName")
	private WebElement newMemberNameField;
	@FindBy(id = "newPhoneNumber")
	private WebElement newPhoneNumberField;
	@FindBy(xpath = "//button[normalize-space()='Add Member']")
	private WebElement addMemberButton;
	@FindBy(xpath = "//button[normalize-space()='Add Group']")
	private WebElement addGroupButton;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement cancelAddMemberButton;

	@FindBy(id = "existingGroupName")
	private WebElement existingGroupNameDropdown;
	@FindBy(id = "existingMemberName")
	private WebElement existingMemberNameDropdown;
	@FindBy(id = "existingPhoneType")
	private WebElement existingPhoneTypeDropdown;

	// Settings dialog tabs
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Conference']")
	private WebElement settingsConferenceTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Participants']")
	private WebElement settingsParticipantsTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Command']")
	private WebElement settingsCommandTab;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement settingsSaveButton;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement settingsCancelButton;

	// Status bar
	@FindBy(css = ".status-members-count")
	private WebElement membersCountText;
	@FindBy(css = ".status-groups-count")
	private WebElement groupsCountText;
	@FindBy(css = ".status-present-count")
	private WebElement presentCountText;
	@FindBy(css = ".status-absent-count")
	private WebElement absentCountText;
	@FindBy(css = ".status-owner-name")
	private WebElement ownerNameText;
	@FindBy(css = ".status-max-contacts")
	private WebElement maxContactsText;
	@FindBy(css = ".status-date-time")
	private WebElement dateTimeText;

	public StatusPage(WebDriver driver) {
		super(driver);
	}

	public String getConferenceName() {
		return conferenceNameHeader.getText().trim();
	}

	// Member selection helpers
	private By memberByName(String memberName) {
		return By.xpath("//div[contains(@class,'member-box')][.//span[normalize-space()='" + memberName + "']]");
	}

	public void selectMember(String memberName) {
		
	}

	public void callMember() {
		callIcon.click();
	}

	public void disconnectMember() {
		disconnectIcon.click();
	}

	public void muteMember() {
		muteIcon.click();
	}

	public void unmuteMember() {
		unmuteIcon.click();
	}

	public void selectAllMembers() {
		selectAllIcon.click();
	}

	public void disperseConference() {
		disperseIcon.click();
		confirmYesButton.click();
	}

	public void forceRemoveAllMembers() {
		forceRemoveIcon.click();
		confirmYesButton.click();
	}

	public void preventNewMembers() {
		preventNewMembersIcon.click();
	}

	public void refreshStatusPage() {
		refreshIcon.click();
	}

	// Add Member dialog
	public void openAddMemberDialog() {
		addMemberIcon.click();
	}

	public void addNewMember(String groupName, String memberName, String phoneNumber) {
		openAddMemberDialog();
		addMemberNewTab.click();
		newGroupNameField.clear();
		newGroupNameField.sendKeys(groupName);
		newMemberNameField.clear();
		newMemberNameField.sendKeys(memberName);
		newPhoneNumberField.clear();
		newPhoneNumberField.sendKeys(phoneNumber);
		addMemberButton.click();
	}

	public void addExistingMember(String groupName, String memberName, String phoneType) {
		openAddMemberDialog();
		addMemberExistingTab.click();
		new Select(existingGroupNameDropdown).selectByVisibleText(groupName);
		new Select(existingMemberNameDropdown).selectByVisibleText(memberName);
		new Select(existingPhoneTypeDropdown).selectByVisibleText(phoneType);
		addMemberButton.click();
	}

	public void addExistingGroup(String groupName) {
		openAddMemberDialog();
		addMemberExistingTab.click();
		new Select(existingGroupNameDropdown).selectByVisibleText(groupName);
		addGroupButton.click();
	}

	public void cancelAddMember() {
		cancelAddMemberButton.click();
	}

	// Conference Settings dialog
	public void openSettings() {
		settingsIcon.click();
	}

	public void openSettingsConferenceTab() {
		settingsConferenceTab.click();
	}

	public void openSettingsParticipantsTab() {
		settingsParticipantsTab.click();
	}

	public void openSettingsCommandTab() {
		settingsCommandTab.click();
	}

	public void checkOption(String checkboxLabel) {
		
	}

	public void saveSettings() {
		settingsSaveButton.click();
	}

	public void cancelSettings() {
		settingsCancelButton.click();
	}

	// Status Bar
	public String getMembersCount() {
		return membersCountText.getText().trim();
	}

	public String getGroupsCount() {
		return groupsCountText.getText().trim();
	}

	public String getPresentCount() {
		return presentCountText.getText().trim();
	}

	public String getAbsentCount() {
		return absentCountText.getText().trim();
	}

	public String getOwnerName() {
		return ownerNameText.getText().trim();
	}

	public String getMaxContacts() {
		return maxContactsText.getText().trim();
	}

	public String getDateTime() {
		return dateTimeText.getText().trim();
	}
}
