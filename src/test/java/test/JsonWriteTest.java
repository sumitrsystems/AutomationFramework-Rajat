package test;

import common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.JsonTestUtility;
import utility.TestUtility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonWriteTest extends BaseTest {

    private TestUtility testUtility;
    @BeforeMethod
    public void setUp() {
        testUtility = new TestUtility(driver);
        testUtility.loadPropertiesFile("src/main/resources/config.properties");
    }
    @Test
    public void testWriteDataToJson() throws IOException {
        String filePath = testUtility.getProperty("testdata.json.path");
        File file = new File(filePath);
        if (!file.exists()) {
            throw new AssertionError("File does not exist: " + filePath);
        }

        Map<String, String> data = new HashMap<>();
        data.put("email", "test@example.com");
        data.put("password", "password123");

        // Get the number of data sets before the data addition
        int initialDataCount = JsonTestUtility.getJsonDataCount(filePath);

        JsonTestUtility.writeDataToJson(filePath, data);

        // Get the number of data sets after the data addition
        int finalDataCount = JsonTestUtility.getJsonDataCount(filePath);

        // Assert that the final data count is one more than the initial data count
        Assert.assertEquals(finalDataCount, initialDataCount + 1, "Data was not added successfully to the JSON file");
    }

    @Test
    public void testWriteDataToJsonFailScenario() throws IOException {
        String filePath = testUtility.getProperty("testdata.json.path");
        File file = new File(filePath);
        if (!file.exists()) {
            throw new AssertionError("File does not exist: " + filePath);
        }

        Map<String, String> data = new HashMap<>();
        data.put("email", "tester@ample.com");
        data.put("password", "password143");

        // Get the number of data sets before the data addition
        int initialDataCount = JsonTestUtility.getJsonDataCount(filePath);

        JsonTestUtility.writeDataToJson(filePath, data);

        // Get the number of data sets after the data addition
        int finalDataCount = JsonTestUtility.getJsonDataCount(filePath);

        // Assert that the final data count is one more than the initial data count
        Assert.assertEquals(finalDataCount, initialDataCount, "Data was not added successfully to the JSON file");
    }
}