// In FileUploadPage.java
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.TestUtility;

public class FileUploadPage {
    private WebDriver driver;
    private TestUtility testUtility;

    private By successMessageLocator = By.xpath("//h3[@class='demo']"); // Replace with the actual locator

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
        this.testUtility = new TestUtility(driver);
    }

    public WebElement getSuccessMessage() {
        return testUtility.waitForElement(successMessageLocator, 30);
    }
}