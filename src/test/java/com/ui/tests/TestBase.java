package com.ui.tests;

import static com.constants.Browser.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.Homepage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	protected Homepage homepage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
        private boolean isLambdatest;
       
    @Parameters({"browser","isLambdaTest","isHeadless"})    
	@BeforeMethod(description = "To Launch the homepage")
	public void setUp(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadless,ITestResult result) {
    	this.isLambdatest = isLambdaTest;
		WebDriver lambdadriver;
		if(isLambdatest)
		{
			lambdadriver=LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			 homepage =new Homepage(lambdadriver);
		}else
		{
			//Running the test on LocalMachine
		logger.info("Loads the homepage of the website");
		homepage = new Homepage(Browser.valueOf(browser.toUpperCase()),true);
		}
	}
	
	public BrowserUtility getInstance()
	{
		return homepage;
	}
	@AfterMethod(description = "Tear down the browser!!")
	public void tearDown()
	{
		if(isLambdatest)
		{
			LambdaTestUtility.quitSession(); // quit or close the browsersession on LT
		} else {
			homepage.quit(); // local
		}
	}
}

