package com.audiosuite.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.audiosuite.utils.LogUtil;

<<<<<<< HEAD
=======

>>>>>>> 423841aa85f2b92229b38dd3beae47495ab0dc74
public class NewEmergencyPage extends GenericPage {

	Actions actions = new Actions(driver);
	public static final Logger log = LogUtil.getLogger(NewEmergencyPage.class);

	// Emergency Details Section
	@FindBy(id = "scheduleName")
	private WebElement emergencyNameField;
	@FindBy(id = "description")
	private WebElement descriptionField;
	@FindBy(name = "outboundcli")
	private WebElement outboundCliField;

	@FindBy(xpath = "//div[contains(@class,'mat-radio-label-content') and contains(normalize-space(),'Information')]")
	private WebElement broadcastTypeInfoRadio;
	@FindBy(xpath = "//div[contains(@class,'mat-radio-label-content') and contains(normalize-space(),'Alert')]")
	private WebElement broadcastTypeAlertRadio;
	@FindBy(name = "voiceChecked")
	private WebElement broadcastModeVoiceRadio;
	@FindBy(name = "whatsappChecked")
	private WebElement broadcastModeWhatsAppRadio;
	@FindBy(name = "receipientChecked")
	private WebElement addRecipientNameCheckbox;

	// Action & Value
	@FindBy(xpath = "(//div[contains(@class,'mat-select-arrow')]/parent::div[contains(@class,'select-trigger')])[1]")
	private WebElement actionDropdown;
	@FindBy(xpath = "//mat-option[@value='Record & Play']")
	private WebElement actionRecordAndPlay;
	@FindBy(xpath = "//mat-option[@value='Play message']")
	private WebElement actionPlayMessage;
	@FindBy(xpath = "//mat-option[@value='Text-To-Speech']")
	private WebElement actionTextToSpeech;
	@FindBy(xpath = "//mat-select[@placeholder='Select a voice file']")
	private WebElement playMessageVoiceFileDropdown;
	@FindBy(xpath = "//textarea[@placeholder='Enter message here']")
	private WebElement textToSpeechTextArea;

// ------- Security Options---------

	@FindBy(xpath = "//mat-panel-title[text()='Security Options']")
	private WebElement securityOptionsDropdown;
	@FindBy(id = "CLITrigger")
	private WebElement cliTriggerCheckbox;
	@FindBy(xpath = "//th[text()='CLI']/following::button[@mattooltip='Add']")
	private WebElement cliAddButton;
	@FindBy(id = "clinumber")
	private WebElement cliNumber;
// ---------------- Access Code ----------
	@FindBy(id = "accesscodeFLAG-input")
	private WebElement accessCodeCheckbox;
	@FindBy(id = "accesscode")
	private WebElement accessCode;

	@FindBy(id = "selectDid")
	private WebElement selectDidDropdown;
	@FindBy(id = "selectIvrsKey")
	private WebElement selectIvrsKeyDropdown;
	@FindBy(id = "tollFreeNumber")
	private WebElement tollFreeNumberField;
	@FindBy(id = "selectEnsVoiceFile")
	private WebElement selectEnsVoiceFileDropdown;
//-------------accessType --------------
<<<<<<< HEAD
	@FindBy(xpath = "//div[contains(@class,'mat-radio') and contains(normalize-space(),'Public')]")
	private WebElement publicRadio;
	@FindBy(xpath = "//div[contains(@class,'mat-radio') and contains(normalize-space(),'Private')]")
=======
	@FindBy(xpath = "//mat-radio-group[@name='accessType']/descendant::div[contains(normalize-space(),'Public')]")
	private WebElement publicRadio;
	@FindBy(xpath = "//mat-radio-group[@name='accessType']/descendant::div[contains(normalize-space(),'Private')]")
>>>>>>> 423841aa85f2b92229b38dd3beae47495ab0dc74
	private WebElement privateRadio;

	// Participants Section
	@FindBy(id = "groupheader")
	private WebElement memberCount;
	@FindBy(xpath = "//input[contains(@name,'group.ischecked')]")
	private WebElement Contactscheckbox;
	@FindBy(xpath = "//input[contains(@name,'group.ischecked')]")
	private List<WebElement> numberOfGroups;

	@FindBy(css = ".participant-group-checkbox")
	private WebElement participantGroupCheckboxAll;
	@FindBy(css = ".excel-upload-icon")
	private WebElement excelUploadIcon;
	@FindBy(id = "importGroupName")
	private WebElement importGroupNameField;
	@FindBy(id = "importFileName")
	private WebElement importFileNameField;
	@FindBy(id = "browseFile")
	private WebElement browseButton;
	@FindBy(xpath = "//button[normalize-space()='Import']")
	private WebElement importButton;
	@FindBy(xpath = "//button[normalize-space()='Clear']")
	private WebElement clearButton;

	// Add Member Dialog
	@FindBy(xpath = "//button[@mattooltip='Add Person']")
	private WebElement addMemberIcon;
	@FindBy(id = "newGroupName")
	private WebElement memberGroupNameField;
	@FindBy(id = "newMemberName")
	private WebElement memberNameField;
	@FindBy(id = "newPhoneNo")
	private WebElement memberPhoneNumberField;
	@FindBy(xpath = "//button[normalize-space()='Add']")
	private WebElement addMemberButton;
	@FindBy(xpath = "//button[normalize-space()='Close']")
	private WebElement cancelMemberButton;
	@FindBy(xpath = "//button[normalize-space()='Close']")
	private WebElement closeButton;
<<<<<<< HEAD
=======
	
>>>>>>> 423841aa85f2b92229b38dd3beae47495ab0dc74

	// Controls
	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//button[normalize-space()='Save & Trigger']")
	private WebElement saveAndTriggerBtn;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement cancelButton;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement confirmDialogOk;
	@FindBy(xpath = "//h2[contains(text(),'already exist.')]")
	private WebElement validationDialogMsg;
	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement validationOkButton;

	public NewEmergencyPage(WebDriver driver) {
		super(driver);
	}

	public void enterEmergencyName(String name) {
		emergencyNameField.clear();
		emergencyNameField.sendKeys(name);
	}

	public void enterDescription(String description) {
		descriptionField.clear();
		descriptionField.sendKeys(description);
	}

	public void enterOutboundCli(String cli) {
		outboundCliField.clear();
		outboundCliField.sendKeys(cli);
	}

	public void selectBroadcastTypeInformation() {
		broadcastTypeInfoRadio.click();
		log.info("Selected Broadcast Type: Information");
	}

	public void selectBroadcastTypeAlert() {
		broadcastTypeAlertRadio.click();
		log.info("Selected Broadcast Type: Alert");
	}

	public void selectBroadcastModeVoice() {
		broadcastModeVoiceRadio.click();
		log.info("Selected Broadcast Mode: Voice");
	}

	public void selectBroadcastModeWhatsApp() {
		broadcastModeWhatsAppRadio.click();
		log.info("Selected Broadcast Mode: WhatsApp");
	}

	public void checkAddRecipientName() {
		addRecipientNameCheckbox.click();
	}

	public void selectActionRecordAndPlay() {
		actionRecordAndPlay.click();
	}

	public void selectActionPlayMessage(String voiceFile) {
		actionPlayMessage.click();
		new Select(playMessageVoiceFileDropdown).selectByVisibleText(voiceFile);
	}

	public void selectActionTextToSpeech(String text) {
		actionTextToSpeech.click();
		textToSpeechTextArea.clear();
		textToSpeechTextArea.sendKeys(text);

	}

	public void expandSecurityOptions() {
		securityOptionsDropdown.click();
	}

	public void addCliTrigger(String clinumber) {
		cliTriggerCheckbox.click();
		cliAddButton.click();
		cliNumber.sendKeys(clinumber);
		log.info("Checked CLI Trigger and added CLI number: " + clinumber);
	}

	public void addAccessCode(String accessNumber) throws InterruptedException {
		Thread.sleep(500);
		actions.moveToElement(accessCodeCheckbox).click().perform();
		accessCode.sendKeys(accessNumber);
		log.info("Checked Access Code and entered code: " + accessNumber);
	}

	public void selectDid(String did) {
		new Select(selectDidDropdown).selectByVisibleText(did);
	}

	public void selectIvrsKey(String key) {
		new Select(selectIvrsKeyDropdown).selectByVisibleText(key);
	}

	public String getTollFreeNumber() {
		return tollFreeNumberField.getText().trim();
	}

	public void selectEnsVoiceFile(String voiceFile) {
		new Select(selectEnsVoiceFileDropdown).selectByVisibleText(voiceFile);
	}

	public void selectSchedulePublic() {
		publicRadio.click();
		log.info("Selected Schedule: Public");
	}

	public void selectSchedulePrivate() {
		privateRadio.click();
		log.info("Selected Schedule: Private");
	}

<<<<<<< HEAD
=======

>>>>>>> 423841aa85f2b92229b38dd3beae47495ab0dc74
	// Import Contacts
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

	public void addMembers(String groupName, String memberName, String phoneNumber) {
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

	public boolean isValidationMessageDisplayed() {
		try {
			return validationDialogMsg.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public String getValidationMessage() {
		return validationDialogMsg.getText().trim();
	}

	public void handleValidationMessage() throws InterruptedException {
		Thread.sleep(1000); // Wait for the validation dialog to appear
		validationOkButton.click();
	}
<<<<<<< HEAD

	public boolean isErrorMessageDisplayed() {
		try {
			return errorMessage.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void selectMembers(int groupCount) {
		int actualCount = numberOfGroups.size() - 1;
		if (groupCount > actualCount) {
			log.error("Group count exceeds available groups. Available groups: " + actualCount);
			return;
		}
		WebElement selectMembers = driver
				.findElement(By.xpath("//input[contains(@name,'group.ischecked-" + groupCount + "')]"));
		actions.moveToElement(selectMembers).click().perform();
	}

	public void addMember(int groupCount) {
		List<WebElement> MembersList = driver.findElements(By.xpath("//input[contains(@name,'group.ischecked')]"));
		if (!MembersList.isEmpty()) {
=======
	
	public boolean isErrorMessageDisplayed() {
	    try {
	        return errorMessage.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	
	public void selectMembers(int groupCount) {	
		int actualCount = numberOfGroups.size()-1;
		if (groupCount > actualCount ) {
			log.error("Group count exceeds available groups. Available groups: " + actualCount);
			return;
		}
		WebElement selectMembers = driver.findElement(By.xpath("//input[contains(@name,'group.ischecked-"+groupCount+"')]"));
		actions.moveToElement(selectMembers).click().perform();
	}
	
	public void addMember(int groupCount) {
		List<WebElement> MembersList = driver.findElements(By.xpath("//input[contains(@name,'group.ischecked')]"));
	    if (!MembersList.isEmpty())  {
>>>>>>> 423841aa85f2b92229b38dd3beae47495ab0dc74
			selectMembers(groupCount);
			log.info("Members is displayed and selected.");
		} else {
			log.info("No Members is not displayed.");
			log.info("Manually add members to the group before proceeding.");
			addMemberIcon.click();
			addMembers("TestGroup", "TestMember", "1234567890");
			log.info("Added member to the group.");
			closeButton.click();
		}
	}

<<<<<<< HEAD
	public void saveEmergency(String name, String description, String outboundCli, int groupCount)
			throws InterruptedException {
=======
	
	public void saveEmergency(String name, String description, String outboundCli,int groupCount) throws InterruptedException {
>>>>>>> 423841aa85f2b92229b38dd3beae47495ab0dc74
		enterEmergencyName(name);
		Thread.sleep(500);
		log.info("Entered Emergency Name: " + name);
		enterDescription(description);
		Thread.sleep(500);
		log.info("Entered Description: " + description);
		enterOutboundCli(outboundCli);
		log.info("Entered Outbound CLI: " + outboundCli);
		Thread.sleep(1000);
		addMember(groupCount);
	}

	// Controls
	public void clickSave() {
		saveButton.click();
	}
<<<<<<< HEAD

	public void clickSaveAndTrigger() {
		saveAndTriggerBtn.click();
	}

	public void clickCancel() {
		cancelButton.click();
	}

=======
	public void clickSaveAndTrigger() {
		saveAndTriggerBtn.click();
	}
	public void clickCancel() {
		cancelButton.click();
	}
>>>>>>> 423841aa85f2b92229b38dd3beae47495ab0dc74
	public void confirmSave() {
		confirmDialogOk.click();
	}
}
