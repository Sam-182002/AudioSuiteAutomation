package com.audiosuite.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.audiosuite.utils.LogUtil;


public class LoginPage extends GenericPage {
	
	public static final Logger log = LogUtil.getLogger(LoginPage.class);

	// Login Box
	@FindBy(xpath = "//input[@formcontrolname='username']")
	private WebElement emailField;	
	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement passwordField;	
	@FindBy(xpath = "//button[contains(@aria-label,'Hide Password')]")
	private WebElement passwordEyeIcon;	
	@FindBy(xpath = "//button/span[text()='Login']")
	private WebElement loginButton;
	@FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
	private WebElement forgotPasswordLnk;
	
	@FindBy(css = ".login-error")
	private WebElement loginErrorMessage;
	
	@FindBy(xpath = "//h2[contains(text(),'You will be logged out from all other sessions. Are you sure you want to proceed?')]")
	public WebElement sessionDialogBox;
	@FindBy(xpath = "//span[text()='Yes']")
	public WebElement sessionDialogButton;
	
	
	// Branch Selection Dialog
	@FindBy(xpath = "//h2[text()='Select a Branch']")
	public WebElement branchDialogBox;
	@FindBy(xpath = "//h2[text()='Select a Branch']/following-sibling::mat-select")
	public WebElement branchDialogBoxButton;
	@FindBy(xpath = "//mat-option/span")
	private List<WebElement> selectBranch;

	// Forgot Password Dialog
	@FindBy(id = "forgotPasswordEmail")
	private WebElement forgotPwdEmailField;
	
	@FindBy(xpath = "//button[normalize-space()='Send OTP']")
	private WebElement sendOtpButton;

	// Set Password Dialog
	@FindBy(id = "setPasswordEmail")
	private WebElement setPwdEmailField;
	
	@FindBy(id = "otp")
	private WebElement otpField;
	
	@FindBy(id = "newPassword")
	private WebElement newPasswordField;
	
	@FindBy(id = "confirmPassword")
	private WebElement confirmPasswordFld;
	
	@FindBy(xpath = "//button[normalize-space()='Set Password']")
	private WebElement setPasswordButton;
	
	@FindBy(xpath = "//button[normalize-space()='Resend OTP']")
	private WebElement resendOtpButton;
	
	@FindBy(css = ".set-password-success")
	private WebElement setPwdSuccessMsg;

	// Footer
	@FindBy(css = ".footer-copyright")
	private WebElement copyrightText;

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void clickLogin() {
		loginButton.click();
	}
	
	public void togglePasswordVisibility() {
		passwordEyeIcon.click();
	}

	public void login(String email, String password) throws InterruptedException {
		emailField.sendKeys(email);
		log.info("Entered email: " + email);
		passwordField.sendKeys(password);
		log.info("Entered password."+password);
		loginButton.click();
		log.info("Clicked on login button.");	  
	}
	

	public boolean isErrorDisplayed() {
		return loginErrorMessage.isDisplayed();
	}

	public String getErrorMessage() {
		return loginErrorMessage.getText().trim();
	}
	
	public boolean isSessionDialogDisplayed() {
	    try {
	        return sessionDialogBox.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	// Branch Selection Dialog
	public boolean isBranchDialogDisplayed() {
	    try {
	        return branchDialogBox.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

	public void selectBranch(String branchName) {
		for (WebElement branch : selectBranch) {
			if (branch.getText().trim().equalsIgnoreCase(branchName)) {
				branch.click();
				log.info("Selected branch: " + branchName);
				break;
			}
		}
	}

	// Forgot Password flow
	public void clickForgotPassword() {
		forgotPasswordLnk.click();
	}

	public void enterForgotPasswordEmail(String email) {
		forgotPwdEmailField.clear();
		forgotPwdEmailField.sendKeys(email);
	}

	public void clickSendOtp() {
		sendOtpButton.click();
	}

	public void requestOtp(String email) {
		clickForgotPassword();
		enterForgotPasswordEmail(email);
		clickSendOtp();
	}

	// Set Password flow
	public void enterOtp(String otp) {
		otpField.clear();
		otpField.sendKeys(otp);
	}

	public void enterNewPassword(String newPassword) {
		newPasswordField.clear();
		newPasswordField.sendKeys(newPassword);
	}

	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordFld.clear();
		confirmPasswordFld.sendKeys(confirmPassword);
	}

	public void clickSetPassword() {
		setPasswordButton.click();
	}

	public void clickResendOtp() {
		resendOtpButton.click();
	}

	public void setNewPassword(String otp, String newPassword, String confirmPassword) {
		enterOtp(otp);
		enterNewPassword(newPassword);
		enterConfirmPassword(confirmPassword);
		clickSetPassword();
	}

	public boolean isPasswordResetSuccessful() {
		return setPwdSuccessMsg.isDisplayed();
	}

	public String getCopyrightText() {
		return copyrightText.getText().trim();
	}
}
