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


public class LoginWithJsonDataProviderTests extends BaseTest {

    private TestUtility testUtility;

    @BeforeMethod
    public void setUp() {
        testUtility = new TestUtility(driver);
        testUtility.loadPropertiesFile("src/main/resources/config.properties");
    }



    @Test(dataProvider = "jsonDataFirstSet", dataProviderClass = JsonDataProvider.class)
    public void testLoginJsonPassScenario(String email, String password) {
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

    @Test(dataProvider = "jsonDataSecondSet", dataProviderClass = JsonDataProvider.class)
    public void testLoginJsonFailScenario(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enter_Email(email);
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





}