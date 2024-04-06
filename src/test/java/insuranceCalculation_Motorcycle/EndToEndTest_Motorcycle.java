package insuranceCalculation_Motorcycle;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

import reusableComponents.ExcelOperations;
import testBase.TestBase;

public class EndToEndTest_Motorcycle extends TestBase
{
	@Test(enabled = false)
public void insuranCalculate_VolvoMotor() throws Exception
{
	//WebDriverManager.chromedriver().setup();
	System.out.println(driver.getTitle());
}
	@Test(enabled = false)
	public void insuranCalculate_FordMotor() throws Exception
	{
		//WebDriverManager.chromedriver().setup();
		System.out.println(driver.getCurrentUrl());
		// open browser and navigate to url 
		// login and select 
		// Actual Test cases 
		// logout and close browser 
	}
	
	@Test (enabled = false)
	public void verifyModeldropdownOptions()
	{
		//navigate to app and click on motorcycle link 
		 homepage.link_motorcycle_();
		// get drop down content 
		List<String> actualValues = vehicledata.dd_model_();
		test.log(Status.INFO, "Actual dropdown values for model dropdown list are:"+actualValues);
		// expected values 
		 List<String> expectedOptions = Arrays.asList("– please select –", "Scooter", "Three-Wheeler", "Moped" , "Motorcycle");
		 test.log(Status.INFO, "Expected dropdown values for model dropdown list are:"+expectedOptions);
		 // compare 
		Assert.assertEquals(actualValues, expectedOptions,"Error in dropdown options comaparision of Model Dropdown");
	}
	
	ExcelOperations excel = new ExcelOperations("InsurancePremium");
	@Test(enabled = true,dataProvider = "vehdata")
	public void insuranceCalculate(Object obj1) throws Exception

	{
		HashMap<String, String> testdata = (HashMap<String, String>) obj1;
		
		System.out.println(testdata);
		test.log(Status.INFO, "Testdata used for the execution"+testdata);
		homepage.link_motorcycle_();
		vehicledata.entervehicledata(testdata);
		vehicledata.clickOnNextButton();
		insdata.enterInsuranceData(testdata);
		insdata.clicOnNext();
		proddata.enterProductData(testdata);
		proddata.clickOnNextbutton();
		
		//String expectedSilverPlanPrice = "231.00";
		//String actual =  priceOptions.getPriceForSelectedOption("Silver");
		
		Assert.assertEquals(testdata.get("PriceValidation_Gold"), priceOptions.getPriceForSelectedOption("Gold"), "Pricing for Gold plan is not matched");
		Assert.assertEquals(testdata.get("PriceValidation_Silver"), priceOptions.getPriceForSelectedOption("Silver"), "Pricing for Silver plan is not matched");
		Assert.assertEquals(testdata.get("PriceValidation_Platinum"), priceOptions.getPriceForSelectedOption("Platinum"), "Pricing for Platinum plan is not matched");
		Assert.assertEquals(testdata.get("PriceValidation_Ultimate"), priceOptions.getPriceForSelectedOption("Ultimate"), "Pricing for Ultimate plan is not matched");
		
		priceOptions.SelectPriceOption(testdata.get("SelectOption"));
		priceOptions.clicOnNextButton();
	}
	
	//@Dataprovider method -- return Object Array 
	@DataProvider (name = "vehdata")
	public Object [][] testDataSupplier() throws EncryptedDocumentException, IOException {
		Object [][] obj = new Object[excel.getRowCount()][1];
		for (int i = 1; i <= excel.getRowCount(); i++) {
			HashMap<String, String> testdata =	excel.getTestDataInMap(i);
			obj[i-1][0] = testdata;	
		}
		return obj;
		
	}
}