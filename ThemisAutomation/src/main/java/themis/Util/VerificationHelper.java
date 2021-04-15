package themis.Util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import themis.TestBase.TestBase;



	public class VerificationHelper extends TestBase{
	
	public static final Logger log =Logger.getLogger(VerificationHelper.class.getName());
	
	AlertHelper alerthelper = new AlertHelper();
	WaitHelper waithelper = new WaitHelper();
		
	public boolean isDisplayed(WebElement element){
		try{
			element.isDisplayed();
			log.info("element is Displayed.."+element.getText());
			//TestBase.logExtentReport("element is Displayed.."+element.getText());
			return true;
		}
		catch(Exception e){
			log.error("element is not Displayed..", e.getCause());
			//TestBase.logExtentReport("element is not Displayed.."+e.getMessage());
			return false;
		}
	}
	
	public boolean isNotDisplayed(WebElement element){
		try{
			element.isDisplayed();
			log.info("element is present.."+element.getText());
			//TestBase.logExtentReport("element is present.."+element.getText());
			return false;
		}
		catch(Exception e){
			log.error("element is not present..");
			return true;
		}
	}
	
	public String readValueFromElement(WebElement element){
		if(null == element){
			log.info("WebElement is null..");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status){
			log.info("Element text is .."+element.getText());
			return element.getText();
		}
		else{
			return null;
		}
	}
	public String getText(WebElement element){
		if(null == element){
			log.info("WebElement is null..");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status){
			log.info("element text is .."+element.getText());
			return element.getText();
		}
		else{
			return null;
		}
	}
	public String getTitle(){
		log.info("page title is: "+driver.getTitle());
		return driver.getTitle();
}
	
	public static String addDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyhhmmss");
        Date date = new Date();             
        System.out.println(dateFormat.format(date));
        String dateandtime = dateFormat.format(date);
        return dateandtime;
	}
	public void removePrimarySecondaryContact(WebElement element1,WebElement element2)
	{
		if(element1.isEnabled())
		{
			System.out.println("Secondary Contacts cross button is enabled");
			element1.click();
			//alerthelper.waitForAlertIsPresent1(10);
			alerthelper.acceptAlertIfPresent();
		}
		else if (element2.isEnabled())
		{
			System.out.println("Primary Contacts cross button is enabled");
			element2.click();
			alerthelper.acceptAlertIfPresent();
		}	
	}
	/*public boolean verifyValues(WebElement element){
		try{
			//log.info("element is Displayed.."+element.getAttribute("value"));
			log.info("element is Displayed.."+element.getText());
			//TestBase.logExtentReport("element is Displayed.."+element.getText());
			return true;
		}
		catch(Exception e){
			log.error("element is not Displayed..", e.getCause());
			//TestBase.logExtentReport("element is not Displayed.."+e.getMessage());
			return false;
		}
	}*/

}
