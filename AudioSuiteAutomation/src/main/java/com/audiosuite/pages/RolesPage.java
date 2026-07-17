package com.audiosuite.pages;

import com.audiosuite.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RolesPage extends GenericPage {

	

	@FindBy(id = "rolesTable")
	private WebElement rolesTable;
	@FindBy(css = ".add-role-icon")
	private WebElement addRoleButton;
	@FindBy(css = ".roles-filter")
	private WebElement filterField;

	// Add New Role Section
	@FindBy(id = "roleName")
	private WebElement roleNameField;
	@FindBy(css = ".role-name-required-message")
	private WebElement roleNameRequiredMsg;
	@FindBy(css = ".save-icon")
	private WebElement saveIcon;
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	private WebElement deleteConfirmYes;

	public RolesPage(WebDriver driver) {
		super(driver);
	}

	public boolean isRolesTableDisplayed() {
		return rolesTable.isDisplayed();
	}

	public void filterRoles(String keyword) {
		filterField.clear();
		filterField.sendKeys(keyword);
	}

	public void clickAddRole() {
		addRoleButton.click();
	}

	public void enterRoleName(String roleName) {
		roleNameField.clear();
		roleNameField.sendKeys(roleName);
	}


	public void addRole(String roleName, String... permissions) {
		clickAddRole();
		enterRoleName(roleName);
		for (String permission : permissions) {
		}
		saveIcon.click();
	}

	public boolean isRoleNameRequiredMessageDisplayed() {
		return roleNameRequiredMsg.isDisplayed();
	}

	private String rowByRoleNameXpath(String roleName) {
		return "//table[@id='rolesTable']//td[normalize-space()='" + roleName + "']/ancestor::tr";
	}

	public void editRole(String roleName) {
	}

	public void saveEditedRole() {
		saveIcon.click();
	}

	public void deleteRole(String roleName) {
		deleteConfirmYes.click();
	}
}
