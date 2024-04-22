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


public class RadioButtonTests extends BaseTest {

    private TestUtility testUtility;

    @BeforeMethod
    public void setUp() {
        testUtility = new TestUtility(driver);
        testUtility.loadPropertiesFile("src/main/resources/config.properties");
    }



    @Test
    public void testRadioButtonPassScenario() {
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
    public void testRadioButtonFailScenario() {
        RadioCheckboxPage radioCheckboxPage = new RadioCheckboxPage(driver);

        WebElement radio1 = radioCheckboxPage.getRadio1();
        WebElement radio2 = radioCheckboxPage.getRadio2();

        // Select radio button 1
        radio1.click();
        Assert.assertTrue(radio1.isSelected(), "Radio Button Option 1 is not selected after click");

        // Select radio button 2
        radio2.click();
        Assert.assertTrue(radio2.isSelected(), "Radio Button Option 2 is not selected after click");

        // This assertion will fail because radio button 1 should not be selected after radio button 2 is clicked
        Assert.assertTrue(radio1.isSelected(), "Radio Button Option 1 is not deselected after Radio Button Option 2 is clicked");
    }





}