package utility;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {
    private ReportUtil reportUtil;

    public TestListener() {
        this.reportUtil = ReportUtil.getInstance(null);
    }

    @Override
    public void onTestStart(ITestResult result) {
        reportUtil.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        reportUtil.log(Status.PASS, "Test Case Passed is " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            reportUtil.getResult(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            reportUtil.log(Status.FAIL, "Test failed");
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        reportUtil.log(Status.SKIP, "Test Case Skipped is " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented
    }

    @Override
    public void onStart(ITestContext context) {
        // Not implemented
    }

    @Override
    public void onFinish(ITestContext context) {
        reportUtil.flushReports();
    }
}