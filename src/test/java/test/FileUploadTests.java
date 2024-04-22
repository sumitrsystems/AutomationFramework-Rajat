package test;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RadioCheckboxPage;
import pages.SuccessPage;
import pages.WebTablePage;
import utility.ExcelDataProvider;
import utility.JsonDataProvider;
import utility.TestUtility;


public class FileUploadTests extends BaseTest {

    private TestUtility testUtility;

    @BeforeMethod
    public void setUp() {
        testUtility = new TestUtility(driver);
        testUtility.loadPropertiesFile("src/main/resources/config.properties");
    }




    @Test
    public void testFileUploadPassScenario() {
        String url = testUtility.getProperty("fileUploadUrl");
        // Navigate to the file upload page
        driver.get(url);

        // Use fileUpload method from TestUtility class
        Assert.assertTrue(testUtility.fileUpload());

    }

    @Test
    public void testFileUploadFailScenario() {
        String url = testUtility.getProperty("fileUploadUrl");
        // Navigate to the file upload page
        driver.get(url);

        // Use fileUpload method from TestUtility class
        // This assertion will fail because the file upload should not be successful
        Assert.assertFalse(testUtility.fileUpload(), "File upload was successful");
    }






}