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


public class WebTablesTests extends BaseTest {

    private TestUtility testUtility;

    @BeforeMethod
    public void setUp() {
        testUtility = new TestUtility(driver);
        testUtility.loadPropertiesFile("src/main/resources/config.properties");
    }

    @Test
    public void testWebTablePassScenario() {
        String url = testUtility.getProperty("tableUrl");
        // Navigate to the web table page
        driver.get(url);

        WebTablePage webTablePage = new WebTablePage(driver);


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

    @Test
    public void testWebTableFailScenarioWithIncorrectRowsAndColumns() {
        String url = testUtility.getProperty("tableUrl");
        // Navigate to the web table page
        driver.get(url);

        WebTablePage webTablePage = new WebTablePage(driver);


        // Wait for the table element to be visible
        WebElement table = webTablePage.getTable();
        testUtility.waitForElement(By.xpath(".//*[@id=\"leftcontainer\"]/table"), 10);

        int expectedCols=4;
        int expectedRows=23;

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