package util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Util {
	// Browser location
	public static final String FIREFOX_LOCATION = "C://WebDrivers//geckodriver.exe";

	// Excel details
	public static final String FILE_PATH = "C:\\Eclipse\\Guru99BankProject\\testdata.xlsx"; // file path
	public static final String SHEET_NAME = "Data"; // sheet name
	public static final String TABLE_NAME = "testData"; // table name

	// Delay time for the website to launch completely
	public static final int WAIT_TIME = 30;

	public static final String BASE_URL = "http://www.demo.guru99.com/V4/";

	public static final String USER_ID_VALUE = "mngr463116";
	public static final String PASSOWRD_ID_VALUE = "atAhama";

	// Expected output
	public static final String EXEPCTED_TITLE = "Guru99 Bank Manager HomePage";
	public static final String EXEPCTED_ERROR = "User or Password is not valid";

	// Get the data from the Excel
	public static String[][] getDataFromTheEcel(String xlFilePath, String sheetName, String tableName)
			throws IOException {
		System.out.println("Entered getDataFromTheEcel");
		// Declaring two dimensions array to store all the test data read from the excel
		String[][] tabArray = null;

		// Get the workbook file by providing the path of excel file
		// create an object of FileInputStream class to read excel file
		FileInputStream fis = new FileInputStream(FILE_PATH);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		System.out.println("workbook created !!!!!!!!!! ");

		// get sheet number
		int sheetCnt = workbook.getNumberOfSheets();
		System.out.println("sheet Count !!!!!!!!!! " + sheetCnt);
		for (int cn = 0; cn <= sheetCnt; cn++) {

			XSSFSheet sheet = workbook.getSheetAt(cn);
			//System.out.println("sheet created !!!!!!!!!! " + sheet);

			/*
			 * // Find the row count int rowCount = sheet.getLastRowNum() -
			 * sheet.getFirstRowNum(); System.out.println("The row count is " + rowCount);
			 */

			// get number of rows from sheet
			int rows = sheet.getPhysicalNumberOfRows();

			// get number of cell from row

			int cells = sheet.getRow(cn).getPhysicalNumberOfCells();
			tabArray = new String[rows][cells];

			for (int i = 1; i < rows; i++) {
				//System.out.println("i iss-------" + i);
				// get cell count in that row
				int cellCount = sheet.getRow(i).getLastCellNum();
				System.out.println("cellCount iss *******" + cellCount);
				for (int j = 0; j < cells; j++) {
					//System.out.println("i is " + i + " j is " + j);
					//System.out.println("The value is " + sheet.getRow(i).getCell(j).getStringCellValue());
					tabArray[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					//System.out.println(tabArray[i][j] + " ");
				}
			}
		}

		return tabArray;

	}

}
