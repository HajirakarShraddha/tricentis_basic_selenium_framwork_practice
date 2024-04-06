package reusableComponents;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	public List<String> getDrodownOptionAsList(WebElement element)
	{
		//get dropdown options as list of String for compare
		Select s1 = new Select(element);
		 List<WebElement> ddoptions_model = s1.getOptions();
		 List<String> actuacontents = new ArrayList<String>();
		 for (WebElement ref : ddoptions_model) 
		 {
			 actuacontents.add(ref.getText());
	     }
		 return actuacontents;
	}
	
	//common method for radio button 
	public void selectRadioButtonValue(List<WebElement> element , String valueToBeSelected)
	
	{
		for (WebElement ref : element)
		{ 
			if(ref.getText().equalsIgnoreCase(valueToBeSelected))
			{
				ref.click();
				break;
			}
			
		}
	}
	//common Method for selecting Check boxes 
	
public void selectCheckBoxes(List<WebElement> element , String check )
{
	String[] checksArray = check.split(",");
	for (String str : checksArray) 
	{
		for (WebElement ele : element)
		{
			if(ele.getText().equalsIgnoreCase(str))
			{
				ele.click();
				break;
			}
		}
	}
	
}
	
	// common method to select dropdown in current app
	public void selectDropdownOption(WebElement element,String valuetobeselected) throws Exception
	{
		Select s2= new Select(element);
		try
		{
		s2.selectByVisibleText(valuetobeselected);
		}
		catch (Exception e)
		{
			throw new Exception ("Value is not present in the Dropedown for WebElement :" +element + "Value to be selected is : "+valuetobeselected );
		}
	}
}
