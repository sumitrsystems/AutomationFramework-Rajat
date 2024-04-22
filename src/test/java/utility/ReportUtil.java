package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReportUtil {
    private static ReportUtil instance = null;
    private ExtentReports extent;
    private ExtentTest test;
    private WebDriver driver;

    private ReportUtil(WebDriver driver) {
        this.driver = driver;
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static synchronized ReportUtil getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new ReportUtil(driver);
        }
        return instance;
    }

    @BeforeMethod
    public void beforeMethod() {
        test = extent.createTest("Test Name", "Test Description");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Case Failed is " + result.getName());
            test.fail(result.getThrowable());

            // Take screenshot
            if (driver != null) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Path destination = Paths.get("Screenshots", result.getName() + ".png");
                Files.copy(screenshot.toPath(), destination);
                test.addScreenCaptureFromPath(destination.toString());
            } else {
                System.out.println("Driver is not initialized");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Case Skipped is " + result.getName());
        }
    }

    public void startTest(String testName) {
        test = extent.createTest(testName);
    }

    public void log(Status status, String details) {
        test.log(status, details);
    }

    public void flushReports() {
        if (extent != null) {
            extent.flush();
        } else {
            throw new IllegalStateException("ExtentReports not initialized. Call getInstance() before flush().");
        }
    }
}