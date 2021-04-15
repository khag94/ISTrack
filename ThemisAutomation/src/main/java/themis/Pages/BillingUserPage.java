package themis.Pages;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import themis.TestBase.*;

import themis.Util.ExcelHelper;
import themis.Util.JavaScriptHelper;
import themis.Util.ReusableMethods;
import themis.Util.WaitHelper;
import themis.Util.WindowHelper;

public class BillingUserPage extends TestBase
{
public static final Logger log =Logger.getLogger(BillingUserPage.class.getName());

	
	ExcelHelper excelhelper = new ExcelHelper();
	WindowHelper windowhelper = new WindowHelper();
	ReusableMethods reuse = new ReusableMethods();
	WaitHelper waithelper = new WaitHelper();
	
	@FindBy(name = "PegaGadget0Ifr")
	public WebElement BE_Frame;
	
	@FindBy(xpath = "//input[@id='OrderNumber']")
	public WebElement GoldOrder;
	
	@FindBy(xpath = "//button[@title='Filter the list']")
	public WebElement SearchOrder;
	
	@FindBy(xpath = "//a[contains(text(),'BillingIS')]")
	public WebElement BillingISTask;
	
	@FindBy(xpath = "//a[contains(text(),'BillingERS')]")
	public WebElement BillingERSTask;
	
	@FindBy(xpath = "//input[contains(@type,'checkbox')]")
	public WebElement FullyCompletedCheckbox;
	
	@FindBy(id = "FinalInvoiceNumber")
	public WebElement FinalInvoiceNumber; 
	
	@FindBy(id = "InvoiceNumber1")
	public WebElement InvoiceNumber;
	
	@FindBy(xpath = "//button[@title='Complete this assignment']")
	public WebElement Submit; 
	
	String SheetName2="Sheet2";
	String ExcelPath=System.getProperty("user.dir")+"/src/main/java/themis/Data/GoldThemis.xlsx";
	
	public BillingUserPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void searchOrder() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		
			driver.switchTo().defaultContent();
			String Order=excelhelper.getDataFromExcel(ExcelPath,SheetName2);
			log.info("Case Id extracted from excel::::"+Order);
			GoldOrder.sendKeys(Order);
			waithelper.waitForElement(SearchOrder, 10);
			SearchOrder.click();
			Thread.sleep(5000);
		}
			
	
	public void billingERS() throws InterruptedException, IOException
	{
		try{
		windowhelper.SwitchMultipleWindow("User");
		reuse.takeScreenshot("BillingUser/Columns");
		BillingERSTask.click();
		//waithelper.WaitForElementVisibleWithPollingTime(BillingERSTask, 10, 2);
		waithelper.waitForframeToBeAvailableAndSwitchToIt(BE_Frame, 20);
		InvoiceNumber.sendKeys("1213");
		FinalInvoiceNumber.sendKeys("1213");
		FullyCompletedCheckbox.click();
		Thread.sleep(4000);
		Submit.click();
		Thread.sleep(5000);
		//driver.switchTo().defaultContent();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void billingIS() throws InterruptedException, IOException
	{
		windowhelper.SwitchMultipleWindow("User");
		reuse.takeScreenshot("BillingUser/Columns");
		BillingISTask.click();
		//waithelper.WaitForElementVisibleWithPollingTime(BillingISTask, 10, 2);
		waithelper.waitForframeToBeAvailableAndSwitchToIt(BE_Frame, 20);
		InvoiceNumber.sendKeys("1213");
		FullyCompletedCheckbox.click();
		Thread.sleep(4000);
		Submit.click();
		Thread.sleep(5000);
		//driver.switchTo().defaultContent();
	
	
	}
}
