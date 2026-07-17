package com.audiosuite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GenericPage {
	
	protected WebDriver driver;
   
    @FindBy(xpath = "//simple-snack-bar/span")
    public WebElement snackMessage;
    
    @FindBy(xpath = "//h2[@class='mat-dialog-content']")
    public WebElement errorMessage;
  
    public String getErrorMessage() {
		return errorMessage.getText();
	}
    public String getSnackMessage() {
        return snackMessage.getText();
    }
    public GenericPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
