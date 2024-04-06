package testBase;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;

import pageObjects.EnterInsurantDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionPageObjects;
import reusableComponents.CommonMethods;

public class ObjectsRepo { 

	 public static WebDriver driver;
	 public static ExtentReports extent;
	 public static com.aventstack.extentreports.ExtentTest test;
	 public static HomePageObjects homepage;
	 public static EnterVehicleDataPageObjects vehicledata;
	 public static EnterInsurantDataPageObjects insdata;
	 public static EnterProductDataPageObjects proddata;
	 public static SelectPriceOptionPageObjects priceOptions;
	
	 public CommonMethods cm = new CommonMethods();

	// public static CommonMethods elements;
}
