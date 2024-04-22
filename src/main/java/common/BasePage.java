package common;

import org.openqa.selenium.WebDriver;
import utility.TestUtility;

public class BasePage {
    protected WebDriver driver;
    protected TestUtility testUtility;

    public BasePage(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        this.driver = driver;
        this.testUtility = new TestUtility(driver);
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }
}