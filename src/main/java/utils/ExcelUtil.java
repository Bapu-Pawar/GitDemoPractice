package utils;

 
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    private static Workbook workbook;

    public static void loadExcel(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            workbook = WorkbookFactory.create(fis);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load Excel file");
        }
    }

    public static String getCellData(String sheetName, int row, int col) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row rowData = sheet.getRow(row);
        Cell cell = rowData.getCell(col);
        return cell.toString();
    }
}
