package test;

import common.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RadioCheckboxPage;
import pages.RegistrationPage;
import utility.TestUtility;


public class DropDownValueSelectTest extends BaseTest {

    private TestUtility testUtility;
    private RegistrationPage registrationPage;
    @BeforeMethod
    public void setUp() {
        testUtility = new TestUtility(driver);
        testUtility.loadPropertiesFile("src/main/resources/config.properties");
        registrationPage = new RegistrationPage(driver);
    }



    @Test
    public void testSelectionOfDropDownValue() {
        String url = testUtility.getProperty("registrationUrl");
        driver.get(url);
        registrationPage.selectCountry("ANTARCTICA");
        Assert.assertEquals(registrationPage.getSelectedCountry(), "ANTARCTICA", "Selected country is not as expected");
        registrationPage.selectFruits("Banana", 1);
        Assert.assertTrue(registrationPage.isFruitSelected("Banana"), "Banana is not selected in the fruits dropdown");
    }
    @Test
    public void testSelectionOfDropDownValueFailScenario() {
        String url = testUtility.getProperty("registrationUrl");
        driver.get(url);
        registrationPage.selectCountry("ANTARCTICA");
        Assert.assertNotEquals(registrationPage.getSelectedCountry(), "ANTARCTICA", "Selected country is not as expected");
        registrationPage.selectFruits("Banana", 1);
        Assert.assertFalse(registrationPage.isFruitSelected("Banana"), "Banana is not selected in the fruits dropdown");
    }

}