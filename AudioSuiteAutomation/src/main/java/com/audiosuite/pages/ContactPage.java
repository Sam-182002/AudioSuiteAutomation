package com.audiosuite.pages;

import com.audiosuite.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactPage extends GenericPage {

	

	@FindBy(id = "contactsTable")
	private WebElement contactsTable;
	@FindBy(css = ".add-contact-icon")
	private WebElement addContactIcon;

	// Filter / Search
	@FindBy(css = ".branch-name")
	private WebElement branchNameText;
	@FindBy(id = "groupNameFilter")
	private WebElement groupNameDropdown;
	@FindBy(id = "autoGenerateAccessCode")
	private WebElement autoGenerateAccessCodeCheckbox;
	@FindBy(id = "accessToAll")
	private WebElement accessToAllCheckbox;
	@FindBy(css = ".contacts-search-bar")
	private WebElement searchBar;

	// Add/Edit Contact form fields
	@FindBy(id = "groupName")
	private WebElement groupNameField;
	@FindBy(id = "memberName")
	private WebElement memberNameField;
	@FindBy(id = "phoneNumber")
	private WebElement phoneNumberField;
	@FindBy(id = "alternateNumber")
	private WebElement alternateNumberField;
	@FindBy(id = "accessCode")
	private WebElement accessCodeField;
	@FindBy(id = "emailId")
	private WebElement emailIdField;
	@FindBy(id = "contactType")
	private WebElement contactTypeDropdown;
	@FindBy(css = ".save-icon")
	private WebElement saveIcon;
	@FindBy(css = ".cancel-icon")
	private WebElement cancelIcon;
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	private WebElement deleteConfirmYes;
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	private WebElement saveConfirmYes;

	// Import / Export
	@FindBy(xpath = "//button[normalize-space()='Import']")
	private WebElement importButton;
	@FindBy(id = "browseImportFile")
	private WebElement browseButton;
	@FindBy(xpath = "//button[normalize-space()='Save']")
	private WebElement importSaveButton;
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement importCancelButton;
	@FindBy(xpath = "//button[normalize-space()='Export']")
	private WebElement exportButton;
	@FindBy(css = ".download-sample-icon")
	private WebElement downloadSampleButton;
	@FindBy(css = ".invalid-file-format-message")
	private WebElement invalidFileFormatMsg;

	@FindBy(css = ".items-per-page")
	private WebElement itemsPerPageDropdown;
	@FindBy(css = ".pagination-next")
	private WebElement nextPageButton;
	@FindBy(css = ".pagination-prev")
	private WebElement prevPageButton;

	public ContactPage(WebDriver driver) {
		super(driver);
	}

	public boolean isContactsTableDisplayed() {
		return contactsTable.isDisplayed();
	}

	public void searchContact(String keyword) {
		searchBar.clear();
		searchBar.sendKeys(keyword);
	}

	public void filterByGroup(String groupName) {
		new Select(groupNameDropdown).selectByVisibleText(groupName);
	}

	public void checkAutoGenerateAccessCode() {
		autoGenerateAccessCodeCheckbox.click();
	}

	public void checkAccessToAll() {
		accessToAllCheckbox.click();
	}

	public String getBranchName() {
		return branchNameText.getText().trim();
	}

	// Add contact
	public void clickAddContact() {
		addContactIcon.click();
	}

	public void addContact(String groupName, String memberName, String phoneNumber, String alternateNumber,
			String accessCode, String emailId, String contactType) {
		clickAddContact();
		groupNameField.clear();
		groupNameField.sendKeys(groupName);
		memberNameField.clear();
		memberNameField.sendKeys(memberName);
		phoneNumberField.clear();
		phoneNumberField.sendKeys(phoneNumber);
		if (alternateNumber != null && !alternateNumber.isEmpty()) {
			alternateNumberField.clear();
			alternateNumberField.sendKeys(alternateNumber);
		}
		if (accessCode != null && !accessCode.isEmpty()) {
			accessCodeField.clear();
			accessCodeField.sendKeys(accessCode);
		}
		emailIdField.clear();
		emailIdField.sendKeys(emailId);
		new Select(contactTypeDropdown).selectByVisibleText(contactType);
		saveIcon.click();
		saveConfirmYes.click();
	}

	private String rowByMemberNameXpath(String memberName) {
		return "//table[@id='contactsTable']//td[normalize-space()='" + memberName + "']/ancestor::tr";
	}

	public void editContact(String memberName) {
	}

	public void saveEditedContact() {
		saveIcon.click();
		saveConfirmYes.click();
	}

	public void cancelEditContact() {
		cancelIcon.click();
	}

	public void deleteContact(String memberName) {
	
		deleteConfirmYes.click();
	}

	// Import / Export
	public void clickImport() {
		importButton.click();
	}

	public void importContacts(String filePath) {
		clickImport();
		browseButton.clear();
		browseButton.sendKeys(filePath);
		importSaveButton.click();
	}

	public void cancelImport() {
		importCancelButton.click();
	}

	public void exportContacts() {
		exportButton.click();
	}

	public void downloadSampleFile() {
		downloadSampleButton.click();
	}

	public boolean isInvalidFileFormatMessageDisplayed() {
		return invalidFileFormatMsg.isDisplayed();
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
