package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SelectPriceOptionPageObjects extends TestBase
{
	@FindBy(id="nextsendquote")
	WebElement btn_next;
	
	//Initialization of elements 
public SelectPriceOptionPageObjects()
{
	PageFactory.initElements(driver, this);
}
	
	//To get Price based on selected option/Plan
public String getPriceForSelectedOption(String plan)
{
	String dataxpath = "//table[@id='priceTable']//tr[1]//td[@data-label='"+plan+"']/span";
	return driver.findElement(By.xpath(dataxpath)).getText();
	
}
public void SelectPriceOption(String plan)
{
	String dataxpath = "//input[@name='Select Option' and @value='"+plan+"']/parent::label";
	driver.findElement(By.xpath(dataxpath)).click();
	
}
public void clicOnNextButton()
{
	btn_next.click();
}
}
