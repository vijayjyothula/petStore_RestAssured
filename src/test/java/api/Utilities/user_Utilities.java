package api.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class user_Utilities {

	//Read Test Data from excel sheet
	public static String TestData_Sheetpath = System.getProperty("user.dir")+"/resources/userData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	//Read Test Data from excel sheet
	public static Object[][] getTestData(String sheetname)
	{
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(TestData_Sheetpath);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try
		{
			book = WorkbookFactory.create(fis);
		}
		catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		 sheet = book.getSheet(sheetname);
		 Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
		 for(int i=0;i< sheet.getLastRowNum(); i++)
		 {
			 for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++)
			 {
				 data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			 }
		 }
		 return data;
	}
	@DataProvider(name  = "pet_User")
	public static Object[][] pet_User()
	{
		String sheetname = "pet_User";
		Object[][] data = getTestData(sheetname);
		return data;
	}
}
