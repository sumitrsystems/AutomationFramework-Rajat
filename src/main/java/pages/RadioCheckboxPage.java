package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.TestUtility;

public class RadioCheckboxPage {
    private WebDriver driver;
    private TestUtility testUtility;

    private By radio1 = By.id("vfb-7-1");
    private By radio2 = By.id("vfb-7-2");
    private By checkbox = By.id("vfb-6-0");

    public RadioCheckboxPage(WebDriver driver) {
        this.driver = driver;
        this.testUtility = new TestUtility(driver);
        driver.get("https://demo.guru99.com/test/radio.html");
    }

    public WebElement getRadio1() {
        return testUtility.waitForElement(radio1, 10);
    }

    public WebElement getRadio2() {
        return testUtility.waitForElement(radio2, 10);
    }

    public WebElement getCheckbox() {
        return testUtility.waitForElement(checkbox, 10);
    }
}