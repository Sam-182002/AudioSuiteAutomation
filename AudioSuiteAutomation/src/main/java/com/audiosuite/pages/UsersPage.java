package com.audiosuite.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.audiosuite.utils.WaitUtil;

public class UsersPage extends GenericPage {



	@FindBy(id = "usersTable")
	private WebElement usersTable;
	@FindBy(css = ".add-user-icon")
	private WebElement addUserIcon;
	@FindBy(css = ".users-filter")
	private WebElement filterSearchBar;
	@FindBy(css = ".items-per-page")
	private WebElement itemsPerPageDropdown;
	@FindBy(css = ".pagination-next")
	private WebElement nextPageButton;
	@FindBy(css = ".pagination-prev")
	private WebElement prevPageButton;

	// Add/Edit User form fields
	@FindBy(id = "username")
	private WebElement usernameField;
	@FindBy(id = "email")
	private WebElement emailField;
	@FindBy(id = "role")
	private WebElement roleDropdown;
	@FindBy(id = "branch")
	private WebElement branchDropdown;
	@FindBy(id = "moduleEns")
	private WebElement modulesEnsCheckbox;
	@FindBy(id = "moduleConference")
	private WebElement modulesConferenceCheckbox;
	@FindBy(id = "moduleVoiceBroadcast")
	private WebElement modulesVoiceBroadcastCheckbox;
	@FindBy(css = ".save-icon")
	private WebElement saveIcon;
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	private WebElement deleteConfirmYes;

	public UsersPage(WebDriver driver) {
		super(driver);
	}

	public boolean isUsersTableDisplayed() {
		return usersTable.isDisplayed();
	}

	public void searchUser(String keyword) {
		filterSearchBar.clear();
		filterSearchBar.sendKeys(keyword);
	}

	public void clickAddUser() {
		addUserIcon.click();
	}

	public void addUser(String username, String email, String role, String branch, boolean ens, boolean conference,
			boolean voiceBroadcast) {
		clickAddUser();
		usernameField.clear();
		usernameField.sendKeys(username);
		emailField.clear();
		emailField.sendKeys(email);
		new Select(roleDropdown).selectByVisibleText(role);
		new Select(branchDropdown).selectByVisibleText(branch);
		if (ens)
			modulesEnsCheckbox.click();
		if (conference)
			modulesConferenceCheckbox.click();
		if (voiceBroadcast)
			modulesVoiceBroadcastCheckbox.click();
		saveIcon.click();
	}

	private String rowByUsernameXpath(String username) {
		return "//table[@id='usersTable']//td[normalize-space()='" + username + "']/ancestor::tr";
	}

	public void editUser(String username) {
	}

	public void deleteUser(String username) {
		deleteConfirmYes.click();
	}

	public boolean isAddUserDisabled() {
		return addUserIcon.getAttribute("disabled") != null;
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
