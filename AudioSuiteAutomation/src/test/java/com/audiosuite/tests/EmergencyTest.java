package com.audiosuite.tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.audiosuite.base.BaseClass;
import com.audiosuite.pages.DashboardPage;
import com.audiosuite.pages.EmergencyPage;
import com.audiosuite.pages.NewEmergencyPage;
import com.audiosuite.utils.JavaUtility;
import com.audiosuite.utils.LogUtil;




public class EmergencyTest extends BaseClass {
	JavaUtility jutil = new JavaUtility();
	public static  Logger log = LogUtil.getLogger(EmergencyTest.class);
	@Test
public void testEmergencyFunctionality() throws InterruptedException {
	EmergencyPage emergencyPage = new EmergencyPage(driver);
	NewEmergencyPage newEmergencyPage = new NewEmergencyPage(driver);
	DashboardPage dashboardPage = new DashboardPage(driver);
	
	log.info("Starting Emergency Functionality Test");
	dashboardPage.goToEmergency();
	emergencyPage.clickAddNew();
	newEmergencyPage.saveEmergency("Test", "Testing", "1234567",1);Thread.sleep(1000);
	newEmergencyPage.expandSecurityOptions();	Thread.sleep(1000);
	newEmergencyPage.addAccessCode("1245"); 
	newEmergencyPage.addCliTrigger("7894561230");
	newEmergencyPage.clickSave(); log.info("Clicked Save button.");	
	if (newEmergencyPage.isErrorMessageDisplayed()) {
	    log.error("Error message displayed: {}", newEmergencyPage.getErrorMessage());
	    newEmergencyPage.handleValidationMessage();
	} else {
		log.info("No error message displayed after saving emergency.");
		newEmergencyPage.confirmSave();
		log.info("Confirmed Save action.");
	}
	SoftAssert softAssert = new SoftAssert();
	softAssert.assertEquals(newEmergencyPage.getSnackMessage(), "Emergency is Saved Successfully.");
	softAssert.assertAll();
	log.info("Emergency Functionality Test completed successfully");
	}
}
