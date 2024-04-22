package test;
import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.TestUtility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelWriteTest extends BaseTest {
    private TestUtility testUtility;
    @BeforeMethod
    public void setUp() {
        testUtility = new TestUtility(driver);
        testUtility.loadPropertiesFile("src/main/resources/config.properties");
    }
    @Test
    public void testWriteDataToExcel() throws IOException {
        String filePath = testUtility.getProperty("testdata.xlsx.path");
        File file = new File(filePath);
        if (!file.exists()) {
            throw new AssertionError("File does not exist: " + filePath);
        }

        String sheetName = "Sheet1";
        Map<String, String> data = new HashMap<>();
        data.put("email", "test@example.com");
        data.put("password", "password123");

        // Get the number of rows before the data addition
        int initialRowCount = TestUtility.getRowCountInExcel(filePath, sheetName);

        try {
            TestUtility.writeDataToExcel(filePath, sheetName, data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get the number of rows after the data addition
        int finalRowCount = TestUtility.getRowCountInExcel(filePath, sheetName);

        // Assert that the final row count is one more than the initial row count
        Assert.assertEquals(finalRowCount, initialRowCount + 1, "Data was not added successfully to the Excel file");
    }

    @Test
    public void testWriteDataToExcelFailScenario() throws IOException {
        String filePath = testUtility.getProperty("testdata.xlsx.path");
        File file = new File(filePath);
        if (!file.exists()) {
            throw new AssertionError("File does not exist: " + filePath);
        }

        String sheetName = "Sheet1";
        Map<String, String> data = new HashMap<>();
        data.put("email", "tester@ample.com");
        data.put("password", "password754");

        // Get the number of rows before the data addition
        int initialRowCount = TestUtility.getRowCountInExcel(filePath, sheetName);

        try {
            TestUtility.writeDataToExcel(filePath, sheetName, data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Get the number of rows after the data addition
        int finalRowCount = TestUtility.getRowCountInExcel(filePath, sheetName);

        // Assert that the final row count is one more than the initial row count
        Assert.assertEquals(finalRowCount, initialRowCount, "Data was not added successfully to the Excel file");
    }
}