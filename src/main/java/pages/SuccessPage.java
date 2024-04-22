package pages;

import org.openqa.selenium.WebDriver;
import utility.TestUtility;

public class SuccessPage {
    private WebDriver driver;

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
        TestUtility testUtility = new TestUtility(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}