package themis.Pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import themis.TestBase.TestBase;
import themis.Util.DropDownHelper;
import themis.Util.ExcelHelper;
import themis.Util.JavaScriptHelper;
import themis.Util.ReusableMethods;
import themis.Util.VerificationHelper;
import themis.Util.WaitHelper;
import themis.Util.WindowHelper;

public class OTPage extends TestBase{
	public static final Logger log =Logger.getLogger(OTPage.class.getName());
	
	String ExcelPath=System.getProperty("user.dir")+"/src/main/java/themis/Data/GoldThemis.xlsx";
	String SheetName1="Sheet2";
	
	WaitHelper waithelper = new WaitHelper();
	WindowHelper windowhelper= new WindowHelper();
	GuardianHomePage guardianhomepage = new GuardianHomePage();
	DropDownHelper dropdownhelper = new DropDownHelper();
	ExcelHelper excelhelper = new ExcelHelper();
	VerificationHelper verificationhelper = new VerificationHelper();
	JavaScriptHelper javascripthelper = new JavaScriptHelper();
	
	//@FindBy(xpath = "//input[@ng-change='loadOrdersWithAllFilterOn()']")
	@FindBy(xpath = "//input[@id='default']")
	public WebElement AllOrders;
	
	//@FindBy(xpath = "//input[@ng-enter='search()']")
	@FindBy(xpath = "//div[@style='margin-left: 80px']//input[@type='text']")
	public WebElement TextBox;
		
	@FindBy(xpath = "//*[@id='dashboardTableOqt']/tbody/tr/td[2]/span")
	public WebElement ClickOrder;
	
	@FindBy(xpath = "//a[contains(.,'Message')]")
	public WebElement Messages;
	
	@FindBy(xpath = "//td[contains(@data-title,'Object')]")
	public WebElement TextMessage;
	
	@FindBy(xpath = "(//p[@class='contact-info ng-binding'])[13]")
	public WebElement ServiceActivationDate;
	
	
	public OTPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void launch_ApplicationFromGuardian(WebElement link) throws InterruptedException
	{
		
		windowhelper.SwitchMultipleWindow("Home in the information system");
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(guardianhomepage.GuardianFrame, 30);
		// below set of code can click on any application link present in Guardian
		guardianhomepage.launch_ApplicationFromGuardian(guardianhomepage.OT);
		waithelper.WaitForElementVisibleWithPollingTime(link, 30, 5);
		link.click();
		log.info("Clicked on"+link+" Application Link");
		driver.switchTo().defaultContent();
	}
	public void checkMessage() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		windowhelper.SwitchMultipleWindow("Service Request and Tracking");
		AllOrders.click();
		Thread.sleep(10000);
		String Order=excelhelper.getDataFromExcel(ExcelPath,SheetName1);
		System.out.println("Case Id extracted from excel::::"+Order);
		TextBox.sendKeys(Order);
		TextBox.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		javascripthelper.scrollDownVertically();
		dropdownhelper.MoveToTaskandDoubleClick(ClickOrder);
		Messages.click();
		javascripthelper.scrollDownVertically();
		waithelper.WaitForElementVisibleWithPollingTime(TextMessage, 10, 2);
		String Message=verificationhelper.getText(TextMessage);
		log.info("Message for Track Delay is:::"+Message);
	    }
	public void checkServiceActivationDate() throws ParseException, InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		windowhelper.SwitchMultipleWindow("Service Request and Tracking");
		AllOrders.click();
		Thread.sleep(10000);
		String Order=excelhelper.getDataFromExcel(ExcelPath,SheetName1);
		System.out.println("Case Id extracted from excel::::"+Order);
		TextBox.sendKeys(Order);
		TextBox.sendKeys(Keys.ENTER);
		Thread.sleep(10000);
		javascripthelper.scrollDownVertically();
		dropdownhelper.MoveToTaskandDoubleClick(ClickOrder);
		//Activation date captured from OT screen
		String serviceActDate = ServiceActivationDate.getText();
		log.info("Service Activation date is "+serviceActDate);
		// to get current date for comparison
		Calendar cal = Calendar.getInstance();
		Date todayDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
		
		
		/*
		Date todayDate = dateFormat.parse(dateFormat.format(new Date() ));*/
		String dateToCmp = todayDate.toString();
		String[] date = dateToCmp.split(" ");
		String day = date[2];
		String month = date[1];
		String year = date[5];
		String finalDate = day+" "+month+" "+year;
		
		log.info("Date to compare "+finalDate);
		if(finalDate.equals(serviceActDate))
		{
			log.info("Service Activation date is same as today's date");
		}
		else
		{
			log.info("Service Activation date is different");
		}
	}
}
	

