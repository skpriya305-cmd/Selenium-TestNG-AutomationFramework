package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
	public static String getCellData(int row, int col ) throws IOException
	{
		FileInputStream fis = new FileInputStream("C:/Users/skpri/eclipse-workspace/AutomationFramework/TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Login");

		
        String data = sheet.getRow(row).getCell(col).toString();
        workbook.close();
        return data;
		
	}
	
	public static String getyear(int row, int col ) throws IOException
	{
		FileInputStream fis = new FileInputStream("C:/Users/skpri/eclipse-workspace/AutomationFramework/TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Year");
        

		
        String year = sheet.getRow(row).getCell(col).getStringCellValue();
        workbook.close();
        fis.close();
        return year;
		
	}
	
}


