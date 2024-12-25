package day40;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File--->Workbook--->Sheets--->Rows----Cells

public class WritingDatainSpecifRowAndCell {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfileRandom.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Data");
		
		XSSFRow row=sheet.createRow(3);
		XSSFCell cell=row.createCell(4);
		
		cell.setCellValue("WELCOME");
		
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is creataed.....");
			
	}

}
