package com.ui.listeners;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetrryAnalyzer implements IRetryAnalyzer{
	//private  static final int MAX_NuMBER_OF_ATTEMPTS=Integer.parseInt(PropertiesUtil.readProperty(Env.QA,"MAX_NuMBER_OF_ATTEMPTS"));
	private  static final int MAX_NuMBER_OF_ATTEMPTS=JSONUtility.readJSONData(Env.QA).getMAX_NuMBER_OF_ATTEMPTS();
      private  static int currentAttempt=1;
	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt<=MAX_NuMBER_OF_ATTEMPTS)
		{
			currentAttempt++;
			return true;
		}
		return false;
	}

	
}
