package reusableComponents;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.ObjectsRepo;

public class ExtentSetup extends ObjectsRepo{
	public static ExtentReports setupExtentReport() 
	{
		//How to get current Date 
		SimpleDateFormat dateformate = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String currentdate = dateformate.format(date);
		String reportpath = System.getProperty("user.dir")+"/Reports/ExecutionReport_"+currentdate+".html";
		ExtentSparkReporter sparkreport= new ExtentSparkReporter(reportpath);
		extent = new ExtentReports();
		extent.attachReporter(sparkreport);
		sparkreport.config().setDocumentTitle("DocumentTitle");
		sparkreport.config().setTheme(Theme.DARK);
		sparkreport.config().setReportName("Error message Test");
		return extent;
		
		/*ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		extent.createTest("MyFirstTest")
		  .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
		extent.flush();*/

	}

}
