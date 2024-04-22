package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class TestUtility {
    WebDriver driver;

    WebDriverWait wait;
    Properties properties;

    private By successMessageLocator = By.xpath("//h3[@class='demo']");

    public TestUtility(WebDriver driver) {
        this.driver = driver;
        this.properties = new Properties();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loadPropertiesFile("src/main/resources/config.properties");

    }

    public int getRowCount(By rowLocator) {
        List<WebElement> rows = driver.findElements(rowLocator);
        return rows.size();
    }

    public int getColumnCount(By columnLocator) {
        List<WebElement> columns = driver.findElements(columnLocator);
        return columns.size();
    }

    public String readCellData(By tableLocator, int rowIndex, int columnIndex) {
        WebElement table = driver.findElement(tableLocator);
        WebElement row = table.findElements(By.tagName("tr")).get(rowIndex);
        WebElement cell = row.findElements(By.tagName("td")).get(columnIndex);
        return cell.getText();
    }

    public WebElement waitForElement(By locator, int timeout) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(Exception.class);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public boolean fileUpload() {
        // Fetch the file path from the config.properties file
        String filePathString = getProperty("filePath");

        // Convert the file path to a StringBuilder
        StringBuilder filePath = new StringBuilder(filePathString);
        System.out.println("File path: " + filePath);
        // Check if filePath is not null
        if (filePath != null) {
            // Locate the file upload element
            WebElement uploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uploadfile_0")));

            // Enter the file path onto the file-selection input field
            uploadElement.sendKeys(filePath);

            // Check the "I accept the terms of service" check box
            WebElement termsCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("terms")));
            termsCheckbox.click();

            // Click the "UploadFile" button
            WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("send")));
            uploadButton.click();

            // Wait for the success message to be displayed
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessageLocator));
            if (successMessage.isDisplayed()) {
                System.out.println("File uploaded successfully.");
                return true;
            } else {
                System.out.println("File upload failed.");
                return false;
            }

        } else {
            System.out.println("File path is not set in the config.properties file.");
            return false;
        }
    }

    public void loadPropertiesFile(String filePath) {
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public WebElement getSuccessMessage() {

        return waitForElement(successMessageLocator, 30);
    }
}