package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utility.ReportUtil;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public void setup() {
        // Setup WebDriverManager to manage ChromeDriver
        WebDriverManager.chromedriver().browserVersion("123.0").driverVersion("123.0").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        ReportUtil.getInstance(driver);
    }

    @AfterClass
    public void teardown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}