package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import testBase.TestBase;

public class EnterVehicleDataPageObjects extends TestBase
{
  @FindBy(id="make")	
  WebElement dd_make;
  
  @FindBy (id="model")
  WebElement dd_model;
  
  @FindBy (id="cylindercapacity")
  WebElement txt_cylindercapacity;
  
  @FindBy(xpath="//input[@id='cylindercapacity']/following-sibling::span[@class='error']")
  WebElement error_messageforcyclindercapacity;
  
  @FindBy(id="engineperformance")	
  WebElement txt_engineperformnce;

  @FindBy(id="dateofmanufacture")	
  WebElement date_dateofmanufacture;
  
  @FindBy(id="numberofseatsmotorcycle")	
  WebElement dd_numberofseats;
  
  @FindBy(id="fuel")	
  WebElement dd_fuel;
  
  @FindBy(id="listprice")	
  WebElement txt_listprice;
  
  @FindBy(id="licenseplatenumber")	
  WebElement txt_licenseplatenumber;
  
  @FindBy(id="annualmileage")	
  WebElement txt_annualmileage;
  
  @FindBy(id="nextenterinsurantdata")	
  WebElement btn_next;
  
 public EnterVehicleDataPageObjects() 
 {
	PageFactory.initElements(driver, this); 
	
}
 public void txt_cylindercapacity_() 
 {
	 txt_cylindercapacity.sendKeys("333");
 }
 public String error_messageforcyclindercapacity_()
 {
	 return error_messageforcyclindercapacity.getText();
 }
 public List<String> dd_model_()
 {
	 return cm.getDrodownOptionAsList(dd_model);
}
 //enter the vehicle data 
public void entervehicledata(HashMap<String, String> testdata) throws Exception
{
	cm.selectDropdownOption(dd_make, testdata.get("Vehicle_Make"));
	cm.selectDropdownOption(dd_model, testdata.get("Vehicle_Model"));
	//txt_cylindercapacity_();
	txt_cylindercapacity.sendKeys(testdata.get("Vehicle_CylinderCapacity"));
	txt_engineperformnce.sendKeys(testdata.get("Vehicle_Enging Performance"));
	date_dateofmanufacture.sendKeys(testdata.get("Vehicle_Date of Manufacture"));
	cm.selectDropdownOption(dd_numberofseats,testdata.get("Vehicle_No of Seats_motorcycle"));
	txt_listprice.sendKeys(testdata.get("Vehicle_List Price"));
	txt_annualmileage.sendKeys(testdata.get("Vehicle_Annual Mileage"));
	
}
public void clickOnNextButton()
{
	btn_next.click();
}
}