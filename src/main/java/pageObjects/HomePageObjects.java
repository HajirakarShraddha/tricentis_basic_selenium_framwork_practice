package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePageObjects extends TestBase
{

	//WebDriver driver= new ChromeDriver();
 @FindBy(id="nav_automobile")
 WebElement link_automobile;
 
 @FindBy(id="nav_truck")
 WebElement link_truck;
 
 @FindBy(id="nav_motorcycle")
 WebElement link_motorcycle;
 
 @FindBy(id="nav_camper")
 WebElement link_camper;
 
 //constructor to initiLIZE EACH ELEMents 
 
 public HomePageObjects() 
 {
	 PageFactory.initElements(driver, this);
 }
 
 // method to click on motorcycle link on homepage 
 
 public void link_motorcycle_()
 {
	 link_motorcycle.click();
 }

}
