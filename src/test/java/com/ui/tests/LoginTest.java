package com.ui.tests;

import static com.constants.Browser.*;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.Homepage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({ com.ui.listeners.TestListener.class })
public class LoginTest extends TestBase{

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "Valid user able to login in to application with JSON Data..", groups = { "e2e",
			"Sanity" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {

		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getusername(),
				"Jatin Sharma");

	}

	/*
	 * @Test(description =
	 * "Valid user able to login in to application with CSV data..", groups = {
	 * "e2e", "Sanity" }, dataProviderClass =
	 * com.ui.dataproviders.LoginDataProvider.class, dataProvider =
	 * "LoginTestCSVDataProvider") public void loginTestWithCSV(User user) {
	 * 
	 * assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(),
	 * user.getPassword()).getusername(), "Jatin Sharma");
	 * 
	 * }
	 * 
	 * @Test(description =
	 * "Valid user able to login in to application with Execl data..", groups = {
	 * "e2e", "Sanity" }, dataProviderClass =
	 * com.ui.dataproviders.LoginDataProvider.class, dataProvider =
	 * "LoginTestExcelDataProvider", retryAnalyzer =
	 * com.ui.listeners.MyRetrryAnalyzer.class) public void
	 * loginTestWithExcelData(User user) {
	 * 
	 * assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailAddress(),
	 * user.getPassword()).getusername(), "Jatin Sharma");
	 * 
	 * }
	 */
}
