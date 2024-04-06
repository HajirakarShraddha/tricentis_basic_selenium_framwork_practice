package insuranceCalculation_Motorcycle;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import testBase.TestBase;

public class ErrorTest_Motorcycle extends TestBase
{
	
 @Test (enabled = false)
 public void errorMessage_cylindercapacityField() throws Exception 
 { 
	 // To verify validation message for cylinder Capacity in motorcycle page and enter value more than 2000 to check  the message 
	 // verify error message 
	 // 1 Open browser and navigate to url - manage in @BeforeMethod in TestBase Class
	// 2. click on motorcycle option 
	 //HomePageObjects hompage = new HomePageObjects();
	 homepage.link_motorcycle_();
	 //3. enter cylinder capacity 
	 //EnterVehicleDataPageObjects vehicledata = new EnterVehicleDataPageObjects();
	 vehicledata.txt_cylindercapacity_();
	 test.log(Status.PASS, "Cylinder Capacity is filled with data : 333333");
	 //4 verify the error message 
	 String ActualErrorMessage = vehicledata.error_messageforcyclindercapacity_();
	 String expectedErrorMessage = "Must be a number between 1 and 2000";
	 Assert.assertEquals(ActualErrorMessage, expectedErrorMessage, "Error message is wrong for cylinder cpacity field");
 }
 
 @Test (enabled = false)
 public void errorMessage_failedtest() throws Exception 
 { 
	 // To verify validation message for cylinder Capacity in motorcycle page and enter value more than 2000 to check  the message 
	 // verify error message 
	 // 1 Open browser and navigate to url - manage in @BeforeMethod in TestBase Class
	// 2. click on motorcycle option 
	 //HomePageObjects hompage = new HomePageObjects();
	 homepage.link_motorcycle_();
	 //3. enter cylinder capacity 
	 //EnterVehicleDataPageObjects vehicledata = new EnterVehicleDataPageObjects();
	 vehicledata.txt_cylindercapacity_();
	 test.log(Status.PASS, "Cylinder Capacity is filled with data : 333333");
	 //4 verify the error message 
	 String ActualErrorMessage = vehicledata.error_messageforcyclindercapacity_();
	 String expectedErrorMessage = "Must be a number between 1 and 9000";
	 Assert.assertEquals(ActualErrorMessage, expectedErrorMessage, "Error message is wrong for cylinder cpacity field");
 }
}