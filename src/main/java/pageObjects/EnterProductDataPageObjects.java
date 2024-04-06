package pageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class EnterProductDataPageObjects extends TestBase
{

	 @FindBy(id="startdate")	
	  WebElement date_startdate;
	 
	 @FindBy(id="insurancesum")	
	  WebElement dd_insurancesum;
	 
	 @FindBy(id="meritrating")	
	  WebElement dd_meritrating;
	 
	 @FindBy(id="damageinsurance")	
	  WebElement dd_damageinsurance;
	 
	 @FindBy(xpath="//input[@name='Optional Products[]']/parent::label")	
	  List<WebElement> chk_OptionalProducts;
	 
	 @FindBy(id="courtesycar")	
	  WebElement dd_courtesycar;
	 
	 @FindBy(id="preventerinsurancedata")	
	  WebElement btn_prev;
	  
	  @FindBy(id="nextselectpriceoption")	
	  WebElement btn_next;
	
	public EnterProductDataPageObjects() 
	{
		PageFactory.initElements(driver, this); 
		
	}
	
	public void enterProductData(HashMap<String, String> testdata) throws Exception
	{
		date_startdate.sendKeys(testdata.get("Product_start date"));
		Thread.sleep(3000);
		cm.selectDropdownOption(dd_insurancesum, testdata.get("Product_insurancesum"));
		cm.selectDropdownOption(dd_damageinsurance, testdata.get("Product_damageinsurance"));
		cm.selectCheckBoxes(chk_OptionalProducts, testdata.get("Product_OptionalProducts"));
		
		/*cm.selectDropdownOption(dd_insurancesum,testdata.get("Product_insurancesum"));
		cm.selectDropdownOption(dd_damageinsurance,testdata.get("Product_damageinsurance"));
		cm.selectCheckBoxes(chk_OptionalProducts,testdata.get("Product_OptionalProducts"));*/
	}
public void clickOnNextbutton()
{
	btn_next.click();
}

}
