package themis.Pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import themis.TestBase.TestBase;
import themis.Util.AssertionHelper;
import themis.Util.DropDownHelper;
import themis.Util.ExcelHelper;
import themis.Util.JavaScriptHelper;
import themis.Util.ReusableMethods;
import themis.Util.VerificationHelper;
import themis.Util.WaitHelper;
import themis.Util.WindowHelper;


public class CreateCasePage extends TestBase{

	public static final Logger log =Logger.getLogger(CreateCasePage.class.getName());
	WindowHelper windowhelper = new WindowHelper();
	DropDownHelper dropdownhelper = new DropDownHelper();
	ExcelHelper excelhelper = new ExcelHelper();
	WaitHelper waithelper = new WaitHelper();
	ReusableMethods reusablemethods = new ReusableMethods();
	String ExcelPath=System.getProperty("user.dir")+"/src/main/java/themis/Data/GoldThemis.xlsx";
	String SheetName1="Sheet2";
	
	//@FindBy(xpath = "//button[@title='Menu collapsed. Click to expand.']")
	@FindBy(xpath = "//td[@valign='middle'][contains(.,'New')]")
	public WebElement New;
	
	@FindBy(xpath = "//a[contains(.,'Create Case')]")
	public WebElement CreateCase;
	
	@FindBy(name = "PegaGadget0Ifr")
	public WebElement NewFrame;
	
	@FindBy(xpath = "//input[contains(@id,'GoldOrderNumber')]")
	public WebElement GoldOrder;
	
	@FindBy(xpath = "//button[@title='Search']")
	public WebElement SearchGoldOrder;
	
	@FindBy(xpath = "(//select[@id='BillingAccountNumber'])[1]")
	public WebElement BillingAccountNumber;
	
	@FindBy(xpath = "(//input[@id='CustomerRequestedDeliveryDate'])")
	public WebElement CustomerRequestedDeliveryDate;
	
	@FindBy(xpath = "(//input[@id='InitialTargetDeliveryDate'])")
	public WebElement InitialTargetDeliveryDate;	
	
	@FindBy(xpath = "//span[contains(text(),'GO')]")
	public WebElement GoldUSID;
	
	@FindBy(xpath = "//div[contains(text(),'Create')]")
	//@FindBy(xpath = "//div[@class='pzbtn-mid'][contains(.,'Create')]")
	public WebElement CreateButton;
	
	@FindBy(xpath = "//label[contains(.,'FPC Details')]")
	public WebElement FPCButton;
	
	@FindBy(xpath = "//input[@id='MonthlyCharge1']")
	public WebElement MonthlyCharge;
	
	@FindBy(xpath = "//input[@id='OneOffcharge1']")
	public WebElement OffCharge;
	
	public CreateCasePage()
	{
		PageFactory.initElements(driver, this);
	}
	public void createNewCase() throws InterruptedException
	{
		windowhelper.SwitchMultipleWindow("Manager");
		dropdownhelper.MoveToTaskandClick(New);
		//CreateCase.click();
		dropdownhelper.MoveToTaskandClick(CreateCase);
	}
	public void searchGoldOrder() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		String Order=excelhelper.getDataFromExcel(ExcelPath,SheetName1);
		waithelper.waitForframeToBeAvailableAndSwitchToIt(NewFrame, 30);
		GoldOrder.sendKeys(Order);
		SearchGoldOrder.click();
		Thread.sleep(10000);
	}
	public void verifyData()
	{
		//verificationhelper.readValueFromElement(BillingAccountNumber);
		String BillingNumber=BillingAccountNumber.getAttribute("value");
		log.info("Billing Account Number captured from IS Track Page::"+BillingNumber);
		String GoldUSID1=GoldUSID.getText();
		log.info("Gold USID captured from IS Track Page::"+GoldUSID1);
		String Rdd=CustomerRequestedDeliveryDate.getAttribute("value");
		log.info("Customer Requested Delivery Date::"+Rdd);
		String Tdd=InitialTargetDeliveryDate.getAttribute("value");
		log.info("Initial Target Delivery Date::"+Tdd);
	}
	public void createButtonClick() throws Exception
	{
		waithelper.waitForElement(CreateButton, 30);
		Thread.sleep(4000);
		CreateButton.click();
	}
	public void checkPricingDetails() throws InterruptedException, IOException
	{
		waithelper.WaitForElementVisibleWithPollingTime(FPCButton,30,5);
		FPCButton.click();
		Thread.sleep(5000);
		String FileName="Pricing/FPCDetails";
		reusablemethods.takeScreenshot(FileName);
		/*String MonthlyCharge1=MonthlyCharge.getAttribute("value");
		System.out.println("Monthly Charge displayed is "+MonthlyCharge1);
		Assert.assertNotNull(MonthlyCharge1);	
		String OffCharge1 = OffCharge.getAttribute("value");
		System.out.println("Monthly Charge displayed is "+OffCharge1);
		Assert.assertNotNull(OffCharge1);
	*/
	}
}
