package day40;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

//Excel File--->Workbook--->Sheets--->Rows----Cells
public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata40\\data.xlsx");//dynamically deal location, here user.dir" tell current project location
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
    	XSSFSheet sheet=workbook.getSheet("Sheet1");  //XSSFSheet  sheet=workbook.getSheetAt(0);
    	
	/*	//Print specific cell data
		System.out.println(sheet.getRow(1).getCell(0)); //1 Way - Java
		
		XSSFRow row=sheet.getRow(1); //2 Way
		XSSFCell cell=row.getCell(0);
		System.out.println(cell); //Java  */
		
		//Print total number of count of row and column
		int totalRows=sheet.getLastRowNum();
		int totalCells=sheet.getRow(0).getLastCellNum();
		System.out.println("number of rows:"+ totalRows); //5 row count from 0 and cell count from 1
		System.out.println("number of cells:"+ totalCells);  //4
		
	   //Print full data of sheet
		for(int r=0;r<=totalRows;r++)
		{
			XSSFRow currentRow=sheet.getRow(r);	//get rows	
			
			for(int c=0;c<totalCells;c++)
			{
				XSSFCell cell=currentRow.getCell(c); //get cell value
				System.out.print(cell.toString()+"\t"); //\t will give Tabular form data and .toString() used to get data in string formate
			}
			System.out.println();	// New line after each row
		}  
		
		workbook.close();
		file.close();
	}

}








