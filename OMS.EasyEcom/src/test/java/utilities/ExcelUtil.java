package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static Workbook workbook;
    public static Sheet sheet;

    public static void loadExcel(String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\OmsTestData.xlsx");
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
    }

    public static String getCellData(int row, int col) {
        return sheet.getRow(row).getCell(col).getStringCellValue();
    }

    public static int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }
}
