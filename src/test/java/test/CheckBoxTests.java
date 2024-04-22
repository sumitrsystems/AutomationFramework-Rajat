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


public class CheckBoxTests extends BaseTest {

    private TestUtility testUtility;

    @BeforeMethod
    public void setUp() {
        testUtility = new TestUtility(driver);
        testUtility.loadPropertiesFile("src/main/resources/config.properties");
    }


    @Test
    public void testCheckboxPassScenario() {
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
    public void testCheckboxFailScenario() {
        RadioCheckboxPage radioCheckboxPage = new RadioCheckboxPage(driver);

        WebElement option1 = radioCheckboxPage.getCheckbox();

        // Toggle the checkbox
        option1.click();
        Assert.assertTrue(option1.isSelected(), "Checkbox is not toggled on after click");

        // Toggle the checkbox again
        option1.click();

        // This assertion will fail because the checkbox should not be selected after the second click
        Assert.assertTrue(option1.isSelected(), "Checkbox is not toggled off after second click");
    }

}