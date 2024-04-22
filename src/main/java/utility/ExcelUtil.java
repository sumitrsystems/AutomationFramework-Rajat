package utility;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelUtil {
    public static Object[][] readExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the Excel file.");
        }

        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][columnCount];
        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // Skip the header row
        int i = 0;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.getCell(j);
                data[i][j] = cell.getStringCellValue();
            }
            i++;
        }
        file.close();
        return data;
    }
}