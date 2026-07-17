package com.audiosuite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class NewBroadcastPage extends GenericPage {



	// Voice Broadcast Details Section
<<<<<<< HEAD
	@FindBy(id = "scheduleName")
	private WebElement broadcastNameField;
	@FindBy(id = "description")
	private WebElement descriptionField;
	@FindBy(id = "startdate")
	private WebElement startDateField;
	@FindBy(id = "enddate")
	private WebElement endDateField;
	@FindBy(id = "timeSlotFrom")
	private WebElement startTimeField;
	@FindBy(id = "timeSlotTo")
=======
	@FindBy(id = "broadcastName")
	private WebElement broadcastNameField;
	@FindBy(id = "description")
	private WebElement descriptionField;
	@FindBy(id = "startDate")
	private WebElement startDateField;
	@FindBy(id = "endDate")
	private WebElement endDateField;
	@FindBy(id = "startTime")
	private WebElement startTimeField;
	@FindBy(id = "endTime")
>>>>>>> 423841aa85f2b92229b38dd3beae47495ab0dc74
	private WebElement endTimeField;
	@FindBy(id = "selectCli")
	private WebElement selectCliDropdown;
	@FindBy(id = "tollFreeNumber")
	private WebElement tollFreeNumberField;
	@FindBy(id = "autoPause")
	private WebElement autoPauseField;
	@FindBy(id = "autoResume")
	private WebElement autoResumeField;
<<<<<<< HEAD
	@FindBy(xpath = "//div[contains(@class,'mat-radio') and contains(normalize-space(),'Public')]")
	private WebElement publicRadio;
	@FindBy(xpath = "//div[contains(@class,'mat-radio') and contains(normalize-space(),'Private')]")
=======
	@FindBy(xpath = "//input[@type='radio' and @value='Public']")
	private WebElement publicRadio;
	@FindBy(xpath = "//input[@type='radio' and @value='Private']")
>>>>>>> 423841aa85f2b92229b38dd3beae47495ab0dc74
	private WebElement privateRadio;

	// Voice Files Selection (IVR)
	@FindBy(css = ".download-ivr-template-icon")
	private WebElement downloadIvrTemplateIcon;
	@FindBy(xpath = "//button[normalize-space()='Import IVR']")
	private WebElement importIvrMenuButton;
	@FindBy(id = "ivrAction")
	private WebElement ivrActionDropdown;
	@FindBy(id = "ivrValue")
	private WebElement ivrValueField;

	// Participants Section
	@FindBy(css = ".max-freelines")
	private WebElement maxFreelinesText;
	@FindBy(css = ".max-contacts")
	private WebElement maxContactsText;
	@FindBy(css = ".member-count")
	private WebElement memberCountText;
	@FindBy(css = ".excel-upload-icon")
	private WebElement excelUploadIcon;
	@FindBy(id = "importGroupName")
	private WebElement importGroupNameField;
	@FindBy(id = "importFileName")
	private WebElement importFileNameField;
	@FindBy(xpath = "//button[normalize-space()='Import']")
	private WebElement importButton;
	@FindBy(xpath = "//button[normalize-space()='Clear']")
	private WebElement clearButton;

	// Add Member Dialog
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

	public NewBroadcastPage(WebDriver driver) {
		super(driver);
	}

	public void enterBroadcastName(String name) {
		broadcastNameField.clear();
		broadcastNameField.sendKeys(name);
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

	public void enterAutoPause(String time) {
		autoPauseField.clear();
		autoPauseField.sendKeys(time);
	}

	public void enterAutoResume(String time) {
		autoResumeField.clear();
		autoResumeField.sendKeys(time);
	}

	public void selectSchedulePublic() {
		publicRadio.click();
	}

	public void selectSchedulePrivate() {
		privateRadio.click();
	}

	// IVR
	public void downloadIvrTemplate() {
		downloadIvrTemplateIcon.click();
	}

	public void importIvrMenu(String filePath) {
		importIvrMenuButton.click();

	}

	public void selectIvrAction(String action) {
		new Select(ivrActionDropdown).selectByVisibleText(action);
	}

	public void enterIvrValue(String value) {
		ivrValueField.clear();
		ivrValueField.sendKeys(value);
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

	public void openExcelImport() {
		excelUploadIcon.click();
	}

	public void importContacts(String groupName, String filePath) {
		openExcelImport();
		if (groupName != null && !groupName.isEmpty()) {
			importGroupNameField.clear();
			importGroupNameField.sendKeys(groupName);
		}
		importFileNameField.clear();
		importFileNameField.sendKeys(filePath);
		importButton.click();
	}

	public void clearImport() {
		clearButton.click();
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

	public BroadcastPage saveBroadcast(String name, String description) {
		enterBroadcastName(name);
		enterDescription(description);
		clickSave();
		confirmSave();
		return new BroadcastPage(driver);
	}
}
