package day40;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File--->Workbook--->Sheets--->Rows----Cells

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata40\\myfile.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Data");
		
		XSSFRow row1=sheet.createRow(0);
			row1.createCell(0).setCellValue("Java");
			row1.createCell(1).setCellValue(19);
			row1.createCell(2).setCellValue("Automation");

		XSSFRow row2=sheet.createRow(1);
			row2.createCell(0).setCellValue("Python");
			row2.createCell(1).setCellValue(3);
			row2.createCell(2).setCellValue("Automation");
			
		XSSFRow row3=sheet.createRow(2);
			row3.createCell(0).setCellValue("C#");
			row3.createCell(1).setCellValue(5);
			row3.createCell(2).setCellValue("Automation");

			
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is creataed.....");
			
	}

}