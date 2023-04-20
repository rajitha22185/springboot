package com.ojas.configure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.ojas.model.Book;



public class ExcelSheets {
public static boolean excelReport(List<Book> list) {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
         boolean flag =false;
		try {
			FileOutputStream out = new FileOutputStream(new File("C:/Users/ra22185/Downloads/01_SB_DATA_JPA_CRUD/src/main/java/com/ojas/resources/ListExcel.xls"));

			HSSFSheet sheet = workbook.createSheet("sheet1");

			int rownum = 0;
			for (Book b : list) {
				Row row = sheet.createRow(rownum++);
			
				Cell cell1 = row.createCell(0);
				Cell cell2 = row.createCell(1);
				Cell cell3 = row.createCell(2);
			
				cell1.setCellValue((Integer) b.getBid());
				cell2.setCellValue((String) b.getName());
				cell3.setCellValue((String) b.getAuthor());
	
			}

			try {
				workbook.write(out);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.close();
				flag=true;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Written successfully on disk.");
		return flag;
		
		
		
		
	}
}
