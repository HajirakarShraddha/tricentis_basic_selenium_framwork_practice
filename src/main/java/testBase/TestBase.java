package testBase;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.EnterInsurantDataPageObjects;
import pageObjects.EnterProductDataPageObjects;
import pageObjects.EnterVehicleDataPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SelectPriceOptionPageObjects;
import reusableComponents.PropertiesOperations;

public class TestBase extends ObjectsRepo
{	
  public void LaunchandNavigateBrowser() throws Exception
  {
	  //read properties file and get browser and url 
	  PropertiesOperations po = new PropertiesOperations();
	  String browser = po.getpropertyvaluebykey("browser");
	  String url = po.getpropertyvaluebykey("url");
	  if (browser.equalsIgnoreCase("chrome"))
	  {   
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  }
	  else if(browser.equalsIgnoreCase("edge"))
	  {
		  WebDriverManager.edgedriver().setup();
		  driver = new EdgeDriver();
	  }
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	  driver.manage().window().maximize();
	  driver.get(url);
  }
  
  @BeforeMethod // it will get execute before each test case 
  
	public void setupMethod() throws Exception
	{
		LaunchandNavigateBrowser();
		homepage= new HomePageObjects();
		vehicledata = new EnterVehicleDataPageObjects();
		insdata = new EnterInsurantDataPageObjects();
		proddata = new EnterProductDataPageObjects();
		priceOptions = new SelectPriceOptionPageObjects();
	}
  
  @AfterMethod
	
	public void cleanUp()
	{
		driver.quit();
	}
}
