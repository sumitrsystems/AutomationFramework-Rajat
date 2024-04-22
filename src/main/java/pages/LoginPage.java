package pages;

import common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.TestUtility;

public class LoginPage extends BasePage
{
    private WebDriver driver;
    private TestUtility testUtility;

    private By emailField = By.id("email");


    private By emailInput = By.id("e-mail");
    private By passwordField = By.name("passwd");
    private By loginButton = By.id("SubmitLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
        this.testUtility = new TestUtility(driver);
        navigateTo("https://demo.guru99.com/test/login.html");
    }
    public void enterEmail(String email) {
        WebElement emailElement = testUtility.waitForElement(emailField, 10);
        emailElement.sendKeys(email);
    }

    public void enter_Email(String email) {
        WebElement emailElement = testUtility.waitForElement(emailInput, 10);
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = testUtility.waitForElement(passwordField, 10);
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButtonElement = testUtility.waitForElement(loginButton, 10);
        loginButtonElement.click();
    }
}