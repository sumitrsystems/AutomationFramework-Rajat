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


public class LoginWithExcelDataProviderTests extends BaseTest {

    private TestUtility testUtility;

    @BeforeMethod
    public void setUp() {
        testUtility = new TestUtility(driver);
        testUtility.loadPropertiesFile("src/main/resources/config.properties");
    }

    @Test(dataProvider = "excelDataFirstRow", dataProviderClass = ExcelDataProvider.class)
    public void testLoginPassScenario(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        SuccessPage successPage = new SuccessPage(driver);
        String expectedUrl = testUtility.getProperty("expectedUrl");
        String actualUrl = successPage.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Actual URL after login is not as expected");
    }

    @Test(dataProvider = "excelDataSecondRow", dataProviderClass = ExcelDataProvider.class)
    public void testLoginFailScenario(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enter_Email(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        SuccessPage successPage = new SuccessPage(driver);
        String expectedUrl = testUtility.getProperty("expectedUrl");
        String actualUrl = successPage.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Actual URL after login is not as expected");
    }





}