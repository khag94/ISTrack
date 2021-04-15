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

public class POCMUser1Page extends TestBase
{
public static final Logger log =Logger.getLogger(POCMUser1Page.class.getName());

	
	ExcelHelper excelhelper = new ExcelHelper();
	WindowHelper windowhelper = new WindowHelper();
	ReusableMethods reuse = new ReusableMethods();
	WaitHelper waithelper = new WaitHelper();
	
	@FindBy(name = "PegaGadget0Ifr")
	public WebElement CU_Frame;
	
	@FindBy(xpath = "//input[@id='OrderNumber']")
	public WebElement GoldOrder;
	
	@FindBy(xpath = "//button[@title='Filter the list']")
	public WebElement SearchOrder;
	
	@FindBy(xpath = "//a[contains(text(),'ContractUpload')]")
	public WebElement ContractUploadTask;
	
	@FindBy(xpath = "//button[@title='Complete this assignment']")
	public WebElement Submit;
	
	@FindBy(xpath = "//input[@id='IsDataLoadCompletedtrue']")
	public WebElement DataLoad; 
	
	String SheetName2="Sheet2";
	String ExcelPath=System.getProperty("user.dir")+"/src/main/java/themis/Data/GoldThemis.xlsx";
	
	public POCMUser1Page()
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
		}
	
	public void contractUpload() throws InterruptedException, IOException
	{
		windowhelper.SwitchMultipleWindow("SAMI User");
		reuse.takeScreenshot("POCMUser1/Columns");
		ContractUploadTask.click();
		//waithelper.WaitForElementVisibleWithPollingTime(BillingISTask, 10, 2);
		waithelper.waitForframeToBeAvailableAndSwitchToIt(CU_Frame, 20);
		DataLoad.click();
		waithelper.WaitForElementClickable(Submit, 10);
		Submit.click();
		Thread.sleep(5000);
	}
}
