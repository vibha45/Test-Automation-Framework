package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	private static ExtentReports extentReports;// the purpose of making this extent report variable as static variable
												// at class level to only use one extent report
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static void setupSparkReporter(String reportName) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//"+reportName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
	}

	public static void createExtentTest(String testName) {
		ExtentTest test = extentReports.createTest(testName);
		extentTest.set(test);
	}

	public static ExtentTest getTest() {
		return extentTest.get();
	}

	public static void flushReport() {
		extentReports.flush();	// it will tell once the all execution done, then dumped the data in to html
		// file
	}
}
