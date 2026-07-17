package com.audiosuite.pages;

import com.audiosuite.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class NewConferencePage extends GenericPage {


	// Conference Details Section
	@FindBy(id = "conferenceName")
	private WebElement conferenceNameField;
	@FindBy(id = "description")
	private WebElement descriptionField;
	@FindBy(id = "startDate")
	private WebElement startDateField;
	@FindBy(id = "endDate")
	private WebElement endDateField;
	@FindBy(id = "startTime")
	private WebElement startTimeField;
	@FindBy(id = "endTime")
	private WebElement endTimeField;
	@FindBy(id = "selectCli")
	private WebElement selectCliDropdown;
	@FindBy(id = "tollFreeNumber")
	private WebElement tollFreeNumberField;
	@FindBy(xpath = "//input[@type='radio' and @value='Public']")
	private WebElement publicRadio;
	@FindBy(xpath = "//input[@type='radio' and @value='Private']")
	private WebElement privateRadio;

	// Options Section
	@FindBy(id = "recordConference")
	private WebElement recordConferenceCheckbox;
	@FindBy(id = "initiatedTriggeredConference")
	private WebElement initiatedTriggeredConferenceCheckbox;

	// Participants Section
	@FindBy(css = ".max-freelines")
	private WebElement maxFreelinesText;
	@FindBy(css = ".max-contacts")
	private WebElement maxContactsText;
	@FindBy(css = ".member-count")
	private WebElement memberCountText;
	@FindBy(id = "selectAllParticipants")
	private WebElement selectAllCheckbox;
	@FindBy(id = "autoDialAll")
	private WebElement autoDialAllCheckbox;

	// Add Member
	@FindBy(css = ".add-member-icon")
	private WebElement addMemberIcon;
	@FindBy(id = "memberGroupName")
	private WebElement memberGroupNameField;
	@FindBy(id = "memberName")
	private WebElement memberNameField;
	@FindBy(id = "memberPhoneNumber")
	private WebElement memberPhoneNumberField;
	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addMemberButton;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement cancelMemberButton;

	// Recurrence Dialog
	@FindBy(xpath = "//button[normalize-space()='Recurrence']")
	private WebElement recurrenceButton;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Daily']")
	private WebElement dailyTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Weekly']")
	private WebElement weeklyTab;
	@FindBy(id = "recurrenceStartDate")
	private WebElement recurrenceStartDate;
	@FindBy(id = "recurrenceEndDate")
	private WebElement recurrenceEndDate;
	@FindBy(id = "recurEveryDays")
	private WebElement recurEveryDaysField;
	@FindBy(id = "recurEveryWeeks")
	private WebElement recurEveryWeeksField;
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	private WebElement recurrenceOkButton;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement recurrenceCancelButton;

	// Export Contacts
	@FindBy(css = ".export-contacts-icon")
	private WebElement exportContactsButton;

	// Controls
	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement confirmDialogOk;
	@FindBy(css = ".validation-dialog-message")
	private WebElement validationDialogMsg;
	@FindBy(css = ".success-message")
	private WebElement successMessage;

	public NewConferencePage(WebDriver driver) {
		super(driver);
	}

	public void enterConferenceName(String name) {
		conferenceNameField.clear();
		conferenceNameField.sendKeys(name);
	}

	public void enterDescription(String desc) {
		descriptionField.clear();
		descriptionField.sendKeys(desc);
	}

	public void enterStartDate(String date) {
		startDateField.clear();
		startDateField.sendKeys(date);
	}

	public void enterEndDate(String date) {
		endDateField.clear();
		endDateField.sendKeys(date);
	}

	public void enterStartTime(String time) {
		startTimeField.clear();
		startTimeField.sendKeys(time);
	}

	public void enterEndTime(String time) {
		endTimeField.clear();
		endTimeField.sendKeys(time);
	}

	public void selectCli(String cli) {
		new Select(selectCliDropdown).selectByVisibleText(cli);
	}

	public String getTollFreeNumber() {
		return tollFreeNumberField.getText().trim();
	}

	public void selectSchedulePublic() {
		publicRadio.click();
	}

	public void selectSchedulePrivate() {
		privateRadio.click();
	}

	public void checkRecordConference() {
		recordConferenceCheckbox.click();
	}

	public void checkInitiatedTriggeredConference() {
		initiatedTriggeredConferenceCheckbox.click();
	}

	// Participants
	public String getMaxFreelines() {
		return maxFreelinesText.getText().trim();
	}

	public String getMaxContacts() {
		return maxContactsText.getText().trim();
	}

	public String getMemberCount() {
		return memberCountText.getText().trim();
	}

	public void checkSelectAll() {
		selectAllCheckbox.click();
	}

	public void checkAutoDialAll() {
		autoDialAllCheckbox.click();
	}

	// Add Member
	public void openAddMemberDialog() {
		addMemberIcon.click();
	}

	public void addMember(String groupName, String memberName, String phoneNumber) {
		openAddMemberDialog();
		memberGroupNameField.clear();
		memberGroupNameField.sendKeys(groupName);
		memberNameField.clear();
		memberNameField.sendKeys(memberName);
		memberPhoneNumberField.clear();
		memberPhoneNumberField.sendKeys(phoneNumber);
		addMemberButton.click();
	}

	public void cancelAddMember() {
		cancelMemberButton.click();
	}

	// Recurrence
	public void openRecurrenceDialog() {
		recurrenceButton.click();
	}

	public void setDailyRecurrence(String startDate, String endDate, String everyNDays) {
		openRecurrenceDialog();
		dailyTab.click();
		recurrenceStartDate.clear();
		recurrenceStartDate.sendKeys(startDate);
		recurrenceEndDate.clear();
		recurrenceEndDate.sendKeys(endDate);
		recurEveryDaysField.clear();
		recurEveryDaysField.sendKeys(everyNDays);
		recurrenceOkButton.click();
	}

	public void setWeeklyRecurrence(String startDate, String endDate, String everyNWeeks, String... days) {
		openRecurrenceDialog();
		weeklyTab.click();
		recurrenceStartDate.clear();
		recurrenceStartDate.sendKeys(startDate);
		recurrenceEndDate.clear();
		recurrenceEndDate.sendKeys(endDate);
		recurEveryWeeksField.clear();
		recurEveryWeeksField.sendKeys(everyNWeeks);
		for (String day : days) {
			
		}
		recurrenceOkButton.click();
	}

	public void cancelRecurrence() {
		recurrenceCancelButton.click();
	}

	// Export contacts
	public void exportContacts() {
		exportContactsButton.click();
	}

	// Controls
	public void clickSave() {
		saveButton.click();
	}

	public void clickCancel() {
		cancelButton.click();
	}

	public void confirmSave() {
		confirmDialogOk.click();
	}

	public boolean isValidationMessageDisplayed() {
		return validationDialogMsg.isDisplayed();
	}

	public String getValidationMessage() {
		return validationDialogMsg.getText().trim();
	}

	public boolean isSaveSuccessful() {
		return successMessage.isDisplayed();
	}

	public ConferencePage saveConference(String name, String description) {
		enterConferenceName(name);
		enterDescription(description);
		clickSave();
		confirmSave();
		return new ConferencePage(driver);
	}
}
