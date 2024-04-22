package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import common.BaseTest;
import utility.ExcelDataProvider;
import utility.JsonDataProvider;
import utility.TestUtility;



public class WebElementsTest extends BaseTest {

    private TestUtility testUtility;

    @BeforeMethod
    public void setUp() {
        testUtility = new TestUtility(driver);
        testUtility.loadPropertiesFile("src/main/resources/config.properties");
    }

    @Test(dataProvider = "excelDataFirstRow", dataProviderClass = ExcelDataProvider.class)
    public void testButton(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        SuccessPage successPage = new SuccessPage(driver);
        String expectedUrl = testUtility.getProperty("expectedUrl");
        String actualUrl = successPage.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Actual URL after login is not as expected");
    }

    @Test(dataProvider = "jsonDataFirstSet", dataProviderClass = JsonDataProvider.class)
    public void testText(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);

        // Test text
        WebElement emailField = driver.findElement(By.id("email"));
        Assert.assertEquals(emailField.getAttribute("value"), email, "Email field text is not as expected");

        WebElement passwordField = driver.findElement(By.name("passwd"));
        Assert.assertEquals(passwordField.getAttribute("value"), password, "Password field text is not as expected");

        // Clear the text fields
        emailField.clear();
        passwordField.clear();
        Assert.assertEquals(emailField.getAttribute("value"), "", "Email field is not cleared");
        Assert.assertEquals(passwordField.getAttribute("value"), "", "Password field is not cleared");
    }

    @Test
    public void testRadioButton() {
        RadioCheckboxPage radioCheckboxPage = new RadioCheckboxPage(driver);

        WebElement radio1 = radioCheckboxPage.getRadio1();
        WebElement radio2 = radioCheckboxPage.getRadio2();

        // Select radio button 1
        radio1.click();
        Assert.assertTrue(radio1.isSelected(), "Radio Button Option 1 is not selected after click");

        // Select radio button 2
        radio2.click();
        Assert.assertTrue(radio2.isSelected(), "Radio Button Option 2 is not selected after click");
        Assert.assertFalse(radio1.isSelected(), "Radio Button Option 1 is still selected after Radio Button Option 2 is clicked");
    }

    @Test
    public void testCheckbox() {
        RadioCheckboxPage radioCheckboxPage = new RadioCheckboxPage(driver);

        WebElement option1 = radioCheckboxPage.getCheckbox();

        // Toggle the checkbox
        option1.click();
        Assert.assertTrue(option1.isSelected(), "Checkbox is not toggled on after click");

        // Toggle the checkbox again
        option1.click();
        Assert.assertFalse(option1.isSelected(), "Checkbox is not toggled off after click");
    }


    @Test
    public void testFileUpload() {
        String url = testUtility.getProperty("fileUploadUrl");
        // Navigate to the file upload page
        driver.get(url);

        TestUtility testUtility = new TestUtility(driver);

        // Use fileUpload method from TestUtility class
        Assert.assertTrue(testUtility.fileUpload());

    }


    @Test
    public void testTable() {
        String url = testUtility.getProperty("tableUrl");
        // Navigate to the web table page
        driver.get(url);

        WebTablePage webTablePage = new WebTablePage(driver);
        TestUtility testUtility = new TestUtility(driver);

        // Wait for the table element to be visible
        WebElement table = webTablePage.getTable();
        testUtility.waitForElement(By.xpath(".//*[@id=\"leftcontainer\"]/table"), 10);

        int expectedCols=5;
        int expectedRows=26;

        // Count the number of columns
        int cols = testUtility.getColumnCount(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
        System.out.println("No of cols are : " + cols);
        Assert.assertEquals(cols, expectedCols, "The number of columns is not as expected");

        // Count the number of rows
        int rows = testUtility.getRowCount(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.println("No of rows are : " + rows);
        Assert.assertEquals(rows, expectedRows, "The number of rows is not as expected");
    }



}