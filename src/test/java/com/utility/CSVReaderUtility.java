package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {

	public static Iterator<User> readCSVFile(String fileName) {
		File file = new File(System.getProperty("user.dir") + "\\testData\\"+fileName);
		FileReader filereader = null;
		CSVReader csvreader;
		String[] line;
		List<User> listuser=null;
		User userdata;
		try {
			filereader = new FileReader(file);
			csvreader = new CSVReader(filereader);
			csvreader.readNext();// it will give us row-1 column header
			listuser = new ArrayList<User>();
			while ((line = csvreader.readNext()) != null) {
				userdata = new User(line[0], line[1]);
				listuser.add(userdata);
			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
         return listuser.iterator();
	}

}
