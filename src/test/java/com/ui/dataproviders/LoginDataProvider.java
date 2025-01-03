package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelUtitlity;

public class LoginDataProvider {
	@DataProvider(name="LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider()
	{
		Gson gson=new Gson();
		File file =new File(System.getProperty("user.dir")+"\\testData\\logindata.json");
		FileReader filereader =null;
		try {
			 filereader=new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TestData testdata=gson.fromJson(filereader, TestData.class);
		List<Object[]>dataToReturn=new ArrayList<Object[]>();
		for(User user:testdata.getData())
		{
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();
		
	}
@DataProvider(name="LoginTestCSVDataProvider")
 public Iterator<User> loginCSVDataProvider()
 {
	 return CSVReaderUtility.readCSVFile("loginData.csv");
 }
@DataProvider(name="LoginTestExcelDataProvider")
public Iterator<User> loginExcelDataProvider()
{
	return ExcelUtitlity.readExcelFile("logindata.xlsx");
}
}
