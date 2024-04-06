package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import testBase.ObjectsRepo;

public class ListnersImplementation extends ObjectsRepo implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		//before test case start 
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test case : "+result.getMethod().getMethodName()+ " is passed.");
		
	}
	

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test case : "+result.getMethod().getMethodName()+ " is Failed.");
		test.log(Status.FAIL, result.getThrowable());
		
		// take screentshot for failed test cases 
		
		File src =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		SimpleDateFormat dateformate = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String currentdate = dateformate.format(date);
		String screenshotPath = System.getProperty("user.dir") + "/Reports/ScreenShots/"+currentdate+".jpeg";
		File Dest = new File (screenshotPath);
		try {
			FileUtils.copyFile(src, Dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshotPath,"Failed Test case screenshot");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}
 
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		//setup method call 
		extent = ExtentSetup.setupExtentReport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// close extent 
		extent.flush();	
	}
}
