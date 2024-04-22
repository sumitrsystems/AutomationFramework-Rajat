package utility;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class ExcelDataProvider {
    @DataProvider(name = "excelDataFirstRow")
    public Object[][] provideData() {
        Object[][] data = new Object[1][2]; // Only one row with two columns (email and password)
        Object[][] allData = ExcelUtil.readExcelData("data/testdata.xlsx", "Sheet1");
        data[0][0] = allData[0][0]; // First row email
        data[0][1] = allData[0][1]; // First row password
        return data;
    }
    @DataProvider(name = "excelDataSecondRow")
    public Object[][] provideSecondRowData() {
        Object[][] data = new Object[1][2]; // Only one row with two columns (email and password)
        Object[][] allData = ExcelUtil.readExcelData("data/testdata.xlsx", "Sheet1");
        data[0][0] = allData[1][0]; // Second row email
        data[0][1] = allData[1][1]; // Second row password
        return data;
    }
}