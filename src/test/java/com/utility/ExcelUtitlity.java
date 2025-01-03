package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelUtitlity {

	public static Iterator<User> readExcelFile(String fileName) {

		File file = new File(System.getProperty("user.dir") + "\\testData\\"+fileName);
		XSSFWorkbook workbook = null;
		Row row;
		Cell emailAddresscell;
		Cell passwordcell;
		User user;
		List<User> userlist = null;
		Iterator<Row> rowiterator;
		XSSFSheet xssfsheet;
		try {
			workbook = new XSSFWorkbook(file);
			userlist = new ArrayList<User>();
			xssfsheet = workbook.getSheet("LoginSheet");
			rowiterator = xssfsheet.iterator();
			rowiterator.next();
			while (rowiterator.hasNext()) {
				row = rowiterator.next();
				emailAddresscell = row.getCell(0);
				passwordcell = row.getCell(1);
				user = new User(emailAddresscell.toString(), passwordcell.toString());
				userlist.add(user);
				workbook.close();
			}
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
         return userlist.iterator();
	}

}
