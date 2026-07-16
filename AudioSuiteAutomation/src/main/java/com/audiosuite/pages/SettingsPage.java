package com.audiosuite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage  extends GenericPage {

	

	// Top level tabs
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='ENS']")
	private WebElement ensTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Voice Broadcast']")
	private WebElement voiceBroadcastTab;
	@FindBy(xpath = "//div[@role='tab' and normalize-space()='Conference']")
	private WebElement conferenceTab;

	// Common controls
	@FindBy(xpath = "//button[normalize-space()='Edit']")
	private WebElement editButton;
	@FindBy(xpath = "//button[normalize-space()='Update']")
	private WebElement updateButton;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement cancelButton;

	// ENS / Voice Broadcast shared fields
	@FindBy(id = "callTimeOut")
	private WebElement callTimeOutField;
	@FindBy(id = "maximumRetries")
	private WebElement maximumRetriesField;
	@FindBy(id = "delayBetweenEachTry")
	private WebElement delayBetweenTryField;
	@FindBy(id = "acknowledgeMessageReceipt")
	private WebElement acknowledgeMessageReceiptCheckbox;
	@FindBy(id = "maximumReplayCount")
	private WebElement maximumReplayCountField;

	// Conference - General expansion panel
	@FindBy(xpath = "//div[normalize-space()='General']")
	private WebElement generalExpansionPanel;
	@FindBy(id = "playBeep")
	private WebElement playBeepCheckbox;
	@FindBy(id = "doCliCheck")
	private WebElement doCliCheckCheckbox;
	@FindBy(id = "handRiseCode")
	private WebElement handRiseCodeField;
	@FindBy(id = "allowMuteUnmuteStatus")
	private WebElement allowMuteUnmuteStatusCheckbox;
	@FindBy(id = "withdrawHandRiseCode")
	private WebElement withdrawHandRiseCodeField;
	@FindBy(id = "addOnFlyMemberInMuteMode")
	private WebElement addOnFlyMemberInMuteModeCheckbox;
	@FindBy(id = "selfMuteCode")
	private WebElement selfMuteCodeField;
	@FindBy(id = "selfUnmuteCode")
	private WebElement selfUnmuteCodeField;
	@FindBy(id = "autoDialOnlyIfInitiatorLoggedIn")
	private WebElement autoDialOnlyIfInitiatorLoggedInCheckbox;
	@FindBy(id = "enableSelfMuteUnmute")
	private WebElement enableSelfMuteUnmuteCheckbox;

	// Conference - Chairperson expansion panel
	@FindBy(xpath = "//div[normalize-space()='Chairperson']")
	private WebElement chairpersonExpansionPanel;
	@FindBy(id = "recEnableCode")
	private WebElement recEnableCodeField;
	@FindBy(id = "recDisableCode")
	private WebElement recDisableCodeField;
	@FindBy(id = "bgmEnableCode")
	private WebElement bgmEnableCodeField;
	@FindBy(id = "bgmDisableCode")
	private WebElement bgmDisableCodeField;
	@FindBy(id = "muteCode")
	private WebElement muteCodeField;
	@FindBy(id = "unmuteCode")
	private WebElement unmuteCodeField;
	@FindBy(id = "lockCode")
	private WebElement lockCodeField;
	@FindBy(id = "unlockCode")
	private WebElement unlockCodeField;
	@FindBy(id = "entryExitBeepEnableCode")
	private WebElement entryExitBeepEnableCodeField;
	@FindBy(id = "entryExitBeepDisableCode")
	private WebElement entryExitBeepDisableCodeField;
	@FindBy(id = "chairpersonEnableCode")
	private WebElement chairpersonEnableCodeField;

	// Conference - Outbound Call Settings expansion panel
	@FindBy(xpath = "//div[normalize-space()='Outbound Call Settings']")
	private WebElement outboundCallExpansionPanel;

	public SettingsPage(WebDriver driver) {
		super(driver);
	}

	// Tab navigation
	public void openEnsSettingsTab() {
		ensTab.click();
	}

	public void openVoiceBroadcastSettingsTab() {
		voiceBroadcastTab.click();
	}

	public void openConferenceSettingsTab() {
		conferenceTab.click();
	}

	public void clickEdit() {
		editButton.click();
	}

	public void clickUpdate() {
		updateButton.click();
	}

	public void clickCancel() {
		cancelButton.click();
	}

	// ENS / Voice Broadcast settings (common fields)
	public void enterMaximumRetries(String retries) {
		maximumRetriesField.clear();
		maximumRetriesField.sendKeys(retries);
	}

	public void enterDelayBetweenEachTry(String delaySeconds) {
		delayBetweenTryField.clear();
		delayBetweenTryField.sendKeys(delaySeconds);
	}

	public String getCallTimeOut() {
		return callTimeOutField.getText().trim();
	}

	public void checkAcknowledgeMessageReceipt() {
		acknowledgeMessageReceiptCheckbox.click();
	}

	public void enterMaximumReplayCount(String count) {
		maximumReplayCountField.clear();
		maximumReplayCountField.sendKeys(count);
	}

	public void updateEnsSettings(String maxRetries, String delaySeconds, String maxReplayCount) {
		openEnsSettingsTab();
		clickEdit();
		enterMaximumRetries(maxRetries);
		enterDelayBetweenEachTry(delaySeconds);
		enterMaximumReplayCount(maxReplayCount);
		clickUpdate();
	}

	public void updateVoiceBroadcastSettings(String maxRetries, String delaySeconds, String maxReplayCount) {
		openVoiceBroadcastSettingsTab();
		clickEdit();
		enterMaximumRetries(maxRetries);
		enterDelayBetweenEachTry(delaySeconds);
		enterMaximumReplayCount(maxReplayCount);
		clickUpdate();
	}

	// Conference - General panel
	public void openGeneralExpansionPanel() {
		generalExpansionPanel.click();
	}

	public void checkPlayBeep() {
		playBeepCheckbox.click();
	}

	public void checkDoCliCheck() {
		doCliCheckCheckbox.click();
	}

	public void enterHandRiseCode(String code) {
		handRiseCodeField.clear();
		handRiseCodeField.sendKeys(code);
	}

	public void checkAllowMuteUnmuteStatus() {
		allowMuteUnmuteStatusCheckbox.click();
	}

	public void enterWithdrawHandRiseCode(String code) {
		withdrawHandRiseCodeField.clear();
		withdrawHandRiseCodeField.sendKeys(code);
	}

	public void checkAddOnFlyMemberInMuteMode() {
		addOnFlyMemberInMuteModeCheckbox.click();
	}

	public void enterSelfMuteCode(String code) {
		selfMuteCodeField.clear();
		selfMuteCodeField.sendKeys(code);
	}

	public void enterSelfUnmuteCode(String code) {
		selfUnmuteCodeField.clear();
		selfUnmuteCodeField.sendKeys(code);
	}

	public void checkAutoDialOnlyIfInitiatorLoggedIn() {
		autoDialOnlyIfInitiatorLoggedInCheckbox.click();
	}

	public void checkEnableSelfMuteUnmute() {
		enableSelfMuteUnmuteCheckbox.click();
	}

	// Conference - Chairperson panel
	public void openChairpersonExpansionPanel() {
		chairpersonExpansionPanel.click();
	}

	public void enterRecEnableCode(String code) {
		recEnableCodeField.clear();
		recEnableCodeField.sendKeys(code);
	}

	public void enterRecDisableCode(String code) {
		recDisableCodeField.clear();
		recDisableCodeField.sendKeys(code);
	}

	public void enterBgmEnableCode(String code) {
		bgmEnableCodeField.clear();
		bgmEnableCodeField.sendKeys(code);
	}

	public void enterBgmDisableCode(String code) {
		bgmDisableCodeField.clear();
		bgmDisableCodeField.sendKeys(code);
	}

	public void enterMuteCode(String code) {
		muteCodeField.clear();
		muteCodeField.sendKeys(code);
	}

	public void enterUnmuteCode(String code) {
		unmuteCodeField.clear();
		unmuteCodeField.sendKeys(code);
	}

	public void enterLockCode(String code) {
		lockCodeField.clear();
		lockCodeField.sendKeys(code);
	}

	public void enterUnlockCode(String code) {
		unlockCodeField.clear();
		unlockCodeField.sendKeys(code);
	}

	public void enterEntryExitBeepEnableCode(String code) {
		entryExitBeepEnableCodeField.clear();
		entryExitBeepEnableCodeField.sendKeys(code);
	}

	public void enterEntryExitBeepDisableCode(String code) {
		entryExitBeepDisableCodeField.clear();
		entryExitBeepDisableCodeField.sendKeys(code);
	}

	public void enterChairpersonEnableCode(String code) {
		chairpersonEnableCodeField.clear();
		chairpersonEnableCodeField.sendKeys(code);
	}

	// Conference - Outbound Call Settings panel
	public void openOutboundCallExpansionPanel() {
		outboundCallExpansionPanel.click();
	}

	public void updateConferenceGeneralSettings(String handRiseCode, String selfMuteCode, String selfUnmuteCode) {
		openConferenceSettingsTab();
		openGeneralExpansionPanel();
		clickEdit();
		enterHandRiseCode(handRiseCode);
		enterSelfMuteCode(selfMuteCode);
		enterSelfUnmuteCode(selfUnmuteCode);
		clickUpdate();
	}

	public void updateConferenceOutboundCallSettings(String maxRetries, String delaySeconds) {
		openConferenceSettingsTab();
		openOutboundCallExpansionPanel();
		clickEdit();
		enterMaximumRetries(maxRetries);
		enterDelayBetweenEachTry(delaySeconds);
		clickUpdate();
	}
}
