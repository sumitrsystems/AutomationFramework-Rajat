package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.TestUtility;

public class WebTablePage {
    private WebDriver driver;
    private TestUtility testUtility;

    private By tableLocator = By.xpath(".//*[@id=\"leftcontainer\"]/table");

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        this.testUtility = new TestUtility(driver);
    }

    public WebElement getTable() {
        return testUtility.waitForElement(tableLocator, 10);
    }
}