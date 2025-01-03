package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

import static com.utility.PropertiesUtil.*;

import java.io.IOException;

public final class Homepage extends BrowserUtility {
	private static final By SIGN_IN_LINK_LOCATOR= By.xpath("//a[contains(text(),\"Sign in\")]");
	Logger logger =LoggerUtility.getLogger(this.getClass());

	public Homepage(Browser browser, boolean isHeadless) {
		super(browser,isHeadless);//to call the parent class constructor from the child constructor
		goToWebsite(JSONUtility.readJSONData(QA).getUrl());
		//goToWebsite("http://www.automationpractice.pl");
		
	}

	public Homepage(WebDriver driver) {
		super(driver); // To Call the Parent Class constructor from the child constructor
		goToWebsite(JSONUtility.readJSONData(QA).getUrl());
	}
	public LoginPage goToLoginPage() 
	{
		logger.info("Trying to click and go to sigin page");
		clickon(SIGN_IN_LINK_LOCATOR);
		LoginPage loginpage=new LoginPage(getDriver());
		return loginpage;
	}

	
	

}
