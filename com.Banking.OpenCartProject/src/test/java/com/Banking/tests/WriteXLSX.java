package com.Banking.tests;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteXLSX {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Hanumanth docs\\xls Files\\test1.xls");

		
		
		
		
		HSSFWorkbook readable_workbook = new HSSFWorkbook(fis);
		
		
		

		HSSFSheet readable_sheet = readable_workbook.getSheet("Sheet1");

		
		
		
		// Create First Row
		HSSFRow row1 = readable_sheet.createRow(0);
		
		
		
		
		

		HSSFCell r1c1 = row1.createCell(0);
		
		
		

		r1c1.setCellValue("Emd Id");
		
		
		

		HSSFCell r1c2 = row1.createCell(1);

		r1c2.setCellValue("NAME");
		
		
		

		HSSFCell r1c3 = row1.createCell(2);

		r1c3.setCellValue("AGE");
		
		
		

		// Create Second Row

		HSSFRow row2 = readable_sheet.createRow(1);

		HSSFCell r2c1 = row2.createCell(0);

		r2c1.setCellValue("1");
		
		

		HSSFCell r2c2 = row2.createCell(1);

		r2c2.setCellValue("sai");
		
		
		

		HSSFCell r2c3 = row2.createCell(2);

		r2c3.setCellValue("4");
		
		
		
		

		// Create Third Row

		HSSFRow row3 = readable_sheet.createRow(2);

		HSSFCell r3c1 = row3.createCell(0);

		r3c1.setCellValue("2");
		
		
		

		HSSFCell r3c2 = row3.createCell(1);

		r3c2.setCellValue("Akki");
		
		
		

		HSSFCell r3c3 = row3.createCell(2);

		r3c3.setCellValue("3");
		
		
		

		FileOutputStream writable_Excel = new FileOutputStream("C:\\Hanumanth docs\\xls Files\\test1.xls");

		
		
		
		readable_workbook.write(writable_Excel);

		
		
		
		System.out.println("Save the readable workbook into writable_Excel");
	}
}
