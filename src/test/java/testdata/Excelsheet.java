package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelsheet {
public static  int J = 0;
	public static Workbook book;
	public static Sheet sheet;

	
	public static Object[][] readdata(String Sheetname) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(
					"C:\\Users\\win\\eclipse-workspace\\HRManagement\\src\\test\\java\\testdata\\Details.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException a) {
			a.printStackTrace();
		}
		sheet = book.getSheet(Sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			for (int J = 0; J < sheet.getRow(0).getLastCellNum(); J++);
			data[i][J] = sheet.getRow(i + 1).getCell(J).toString();

		}
		return data;
	}

}
