package pageObjects;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterInsurantDataPageObjects extends TestBase
{

	  @FindBy(id="firstname")	
	  WebElement txt_firstname;
	  
	  @FindBy(id="lastname")	
	  WebElement txt_lastname;
	  
	  @FindBy(id="birthdate")	
	  WebElement date_birthdate;
	  
	  @FindBy(xpath="//input[@name='Gender']/parent::label")
	  List<WebElement> rd_Gender;
	  
	  @FindBy(id="streetaddress")	
	  WebElement txt_streetaddress;
	  
	  @FindBy(id="country")	
	  WebElement dd_country;
	  
	  @FindBy(id="zipcode")	
	  WebElement txt_zipcode;
	  
	  @FindBy(id="city")	
	  WebElement txt_city;
	  
	  @FindBy(id="occupation")	
	  WebElement dd_occupation;
	  
	  @FindBy(xpath="//input[@name='Hobbies']/parent::label")	
	  List<WebElement> chk_Hobbies;
	  
	  @FindBy(id="website")	
	  WebElement txt_website;
	  
	  @FindBy(id="preventervehicledata")	
	  WebElement btn_prev;
	  
	  @FindBy(id="nextenterproductdata")	
	  WebElement btn_next;
	  
	  public void clicOnNext()
	  {
		  btn_next.click();
	  }
	  
	  public EnterInsurantDataPageObjects() 
	  {
	 	PageFactory.initElements(driver, this); 
	 	
	 }
	 //enter Insurance Data
	  public void enterInsuranceData(HashMap<String, String> testdata) throws Exception{
		  {
			  txt_firstname.sendKeys(testdata.get("Insurant_FirstName"));
			  txt_lastname.sendKeys(testdata.get("Insurant_LastName"));
			  date_birthdate.sendKeys(testdata.get("Insurant_birthdate"));
			  cm.selectRadioButtonValue(rd_Gender, testdata.get("Insurant_gender"));
			  txt_streetaddress.sendKeys(testdata.get("Insurant_address"));
			  cm.selectDropdownOption(dd_country, testdata.get("Insurant_country"));
			  txt_zipcode.sendKeys(testdata.get("Insurant_zipcode"));
			  txt_city.sendKeys(testdata.get("Insurant_city"));
			  cm.selectDropdownOption(dd_occupation, testdata.get("Insurant_occupation"));
			  cm.selectCheckBoxes(chk_Hobbies, testdata.get("Insurant_Hobby"));
			  //upload picture 
			  txt_website.sendKeys(testdata.get("Insurant_website"));
		  }
	  }
}
