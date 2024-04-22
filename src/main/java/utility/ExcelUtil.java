package utility;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

public class ExcelUtil {
    public static Object[][] readExcelData(String fileName, String sheetName) {
        // Use the ClassLoader to find the file
        URL resourceUrl = ClassLoader.getSystemResource(fileName);
        if (resourceUrl == null) {
            throw new RuntimeException("Cannot find resource: " + fileName);
        }
        File file = new File(resourceUrl.getFile());

        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook = WorkbookFactory.create(fis);
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
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Error reading Excel file: " + fileName, e);
        }
    }
}