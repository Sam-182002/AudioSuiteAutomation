package com.audiosuite.tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import com.audiosuite.base.BaseClass;
import com.audiosuite.config.ConfigReader;
import com.audiosuite.pages.DashboardPage;
import com.audiosuite.pages.RecordingsPage;
import com.audiosuite.utils.LogUtil;




public class RecordingsTest extends BaseClass {
	public static  Logger log = LogUtil.getLogger(RecordingsTest.class);
	ConfigReader configReader = new ConfigReader();

@Test
	public void testRecordingsFunctionality() throws InterruptedException {
	log.info("Starting Recordings Functionality Test");
	DashboardPage dashboardPage = new DashboardPage(driver);
	RecordingsPage recordingsPage = new RecordingsPage(driver);
	dashboardPage.goToRecordings();
<<<<<<< HEAD
	//recordingsPage.addVoiceFile("Code 999Black", configReader.getConfigData("voiceFilePath.Code_Black"));
=======
	recordingsPage.addVoiceFile("Code 999Black", configReader.getConfigData("voiceFilePath.Code_Black"));
>>>>>>> 423841aa85f2b92229b38dd3beae47495ab0dc74
	Thread.sleep(2000);	
	}

}
