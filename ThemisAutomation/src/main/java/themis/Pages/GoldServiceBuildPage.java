package themis.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import themis.TestBase.TestBase;
import themis.Util.AlertHelper;
import themis.Util.DropDownHelper;
import themis.Util.ExcelHelper;
import themis.Util.JavaScriptHelper;
import themis.Util.WaitHelper;
import themis.Util.WindowHelper;

public class GoldServiceBuildPage extends TestBase{
	public static final Logger log =Logger.getLogger(GoldServiceBuildPage.class.getName());
	
	public static String Text1;
	WaitHelper waithelper = new WaitHelper();
	WindowHelper windowhelper = new WindowHelper();
	DropDownHelper dropdownhelper = new DropDownHelper();
	JavaScriptHelper javascripthelper = new JavaScriptHelper();
	AlertHelper alerthelper = new AlertHelper();
	ExcelHelper excelhelper = new ExcelHelper();
	
	String ExcelPath=System.getProperty("user.dir")+"/src/main/java/themis/Data/GoldThemis.xlsx";
	String SheetName1="Sheet2";

	@FindBy(xpath = ".//img[@title='Add GOLD USID']")
	public WebElement GoldUSID;
	
	@FindBy(xpath = ".//input[@type='text']")
	public WebElement NumberOfInstances;
	
	@FindBy(xpath = ".//input[@value='OK']")
	public WebElement SelectInstance;
	
	@FindBy(xpath = "//img[contains(@class,'butSave')]")
	public WebElement SaveOrder;
	
	@FindBy(xpath= "//input[@id='orderNumber']")
	public WebElement OrderNumber;
	
	@FindBy(xpath= "//img[@name='WFCompleteTask']")
	public WebElement CompleteTask;
		
	@FindBy(xpath = "//div[@id='WFActionPopup']/table/tbody/tr[2]/td/nobr")
	public WebElement Submit;
	
	@FindBy(xpath = "//table[@id='LeftNavBar']/tbody/tr[2]/td/table/tbody/tr[@title='Service build']/td")
	public WebElement ServiceBuildLink;

	public GoldServiceBuildPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void ServiceBuildLink() throws InterruptedException
	{
		javascripthelper.scrollToElement(ServiceBuildLink);
		waithelper.WaitForElementVisibleWithPollingTime(ServiceBuildLink, 30, 5);
		ServiceBuildLink.click();
	}
	
	public void selectGoldUSID() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(GoldUSID, 30, 5);
		GoldUSID.click();
		windowhelper.switchToWindow(1);
		NumberOfInstances.sendKeys("1");
		SelectInstance.click();
	}
	public void completeTask() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(CompleteTask, 30, 5);
		dropdownhelper.moveTillSubTaskandClick(CompleteTask, Submit);
		waithelper.waitForAlertIsPresent(5);
		alerthelper.acceptAlert();
		Thread.sleep(5000);
	}
	public void captureGoldOrder() throws InterruptedException
	{
		SaveOrder.click();
		//Temporary wait
		Thread.sleep(60000);
		String Text1=OrderNumber.getAttribute("value");
		System.out.println("Gold Order captured::::"+Text1);
		Assert.assertNotNull(Text1);
		excelhelper.updateGoldOrderInExcel(ExcelPath, SheetName1, Text1);
		System.out.println("Excel Sheet updated with Gold Order");
	}
}
