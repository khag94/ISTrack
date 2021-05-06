package themis.Pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import themis.TestBase.TestBase;
import themis.Util.WaitHelper;
import themis.Util.WindowHelper;
import themis.Util.AlertHelper;
import themis.Util.DateTimeHelper;
import themis.Util.DropDownHelper;
import themis.Util.ExcelHelper;
import themis.Util.JavaScriptHelper;
import themis.Util.VerificationHelper;
public class GoldOrderPage extends TestBase
{
	public static final Logger log =Logger.getLogger(GoldOrderPage.class.getName());
	
	//public static String Text1;
	
	WaitHelper waithelper = new WaitHelper();
	WindowHelper windowhelper= new WindowHelper();
	DropDownHelper dropdownhelper = new DropDownHelper();
	DateTimeHelper datetimehelper= new DateTimeHelper();
	JavaScriptHelper javascripthelper= new JavaScriptHelper();
	AlertHelper alerthelper= new AlertHelper();
	ExcelHelper excelhelper = new ExcelHelper();
	VerificationHelper verificationhelper = new VerificationHelper();
	

	String ExcelPath=System.getProperty("user.dir")+"/src/main/java/themis/Data/GoldThemis.xlsx";
	String SheetName1="Sheet2";
	
	@FindBy(xpath = "//*[@id='headMenu']/li[2]/a/span")
	public WebElement OrdersLink;
	
	@FindBy(xpath = "//*[@id='CreateOrderImg']")
	public WebElement CreateOrder;
	
	@FindBy(xpath = "//div[@id='CreateOrderPopUp']/table/tbody/tr[2]/td[2]/nobr")
	public WebElement New;
	
	@FindBy(css = ".sqSelect")
	public WebElement Select ;
	
	@FindBy(id = "organizationIdValCustomer")
	public WebElement CustomerId;
	
	@FindBy(id = "searchButton")
	public WebElement Search;
	
	@FindBy(xpath = "//img[@alt='Select a Contract']")
	public WebElement SelectContract;
	
	@FindBy(xpath = "//input[@id='nameValContract']")
	public WebElement ContractId;
	
	@FindBy(xpath = ".//*[@id='grid_row_1']/td[3] ")
	public WebElement SelectThirdRow;
	
	@FindBy(xpath = "//img[@title='Select Service Acceptance Contact.']")
	public WebElement SelectServiceAcceptance;
	
	@FindBy(xpath = ".//*[@id='nameValContact']")
	public WebElement ValContact;
	
	@FindBy(xpath = "//input[@id='orderTerm']")
	public WebElement OrderTerm;
	
	@FindBy(xpath = ".//*[@id='addcc2']/textarea")
	public WebElement TextArea;
	
	@FindBy(xpath = "//select[@id='customerSiteSurvey']")
	public WebElement SiteSurvey;
	
	@FindBy(id = "customerRequestedEarlyDelivery")
	public WebElement RequestEarlyDelivery;
	
	@FindBy(xpath = "//select[@id='NonQUOTOOrderReason']")
	public WebElement NonQuotoReason;
	
	@FindBy(xpath = "//select[@id='salescampaign']")
	public WebElement SalesCompaign;
	
	@FindBy(xpath = "//img[@alt='Select a Billing Profile']")
	public WebElement BillingProfile;
	
	@FindBy(xpath = "//img[@alt='Select a Local Site']")
	public WebElement LocalSite;
	
	@FindBy(id = "countryValSite")
	public WebElement CountryValSite;
	
	@FindBy(name = "idoRefNb")
	public WebElement RefNumber;
	
	@FindBy(id = "rfbExceptionDays")
	public WebElement RFB;
	
	@FindBy(xpath = "//*[@id='requestedDate']/img[1]")
	public WebElement RequestedDeliveryDate;
	
	@FindBy(id = "chooseServiceDropDown")
	public WebElement SelectProduct;
	
	@FindBy(xpath="//img[@alt='Select Lead Time Basis']")
	public WebElement LeadTimeBasis;
	
	@FindBy(id="installationPreferences")
	public WebElement InstallationPreferences;
	
	@FindBy(xpath = "//*[@id='LeftErrorBar']/tbody/tr[3]/td[2]")
	public WebElement GoldOrder;
	
	@FindBy(id = "orderNb")
	public WebElement OrderNumber;
	
	@FindBy(css = "#grid_row_1>td")
	public WebElement SelectOrder ;
	
	@FindBy(xpath = "//img[@alt='Edit this order']")
	public WebElement EditOrder ;
	
	@FindBy(id = "custAcceptTesting")
	public WebElement CAT ;
	
	//@FindBy(xpath = "(//img[@title='Unselect this Secondary contact'])")
	@FindBy(xpath = "//td[contains(text(),'Secondary Contact')]")
	public WebElement SecondaryContact;
	
	//@FindBy(xpath = "(//img[@title='Unselect this Primary contact'])") 
	@FindBy(xpath = "//td[contains(text(),'Primary Contact')]")
	public WebElement PrimaryContact;
	
	@FindBy(xpath = "//img[@name='WFCompleteTask']") 
	public WebElement CompleteTask;
	
	@FindBy(xpath = "//div[@id='WFActionPopup']/table/tbody/tr[5]/td[2]/nobr") 
	public WebElement SubmitSRF2NotRequired;
	
	@FindBy(xpath = "//div[@id='WFActionPopup']/table/tbody/tr[5]/td[2]") 
	public WebElement SubmitOrder;
	
	@FindBy(css = "#earlyLocalSiteValid")
	public WebElement EarlyLocalSite;
	
	@FindBy(xpath="//div[@id='WFActionPopup']/table/tbody/tr[2]/td[2]")
	public WebElement Submit;
	
	@FindBy(xpath = "//span[@id='custSigDate']/img")
	public WebElement SelectCSD;
	
	@FindBy(xpath = "//td[contains(text(),'All orders')]")
	public WebElement AllOrdersClick;
	
	@FindBy(xpath = "//table[@id='LeftNavBar']/tbody/tr[2]/td/table/tbody/tr[8]/td")
	public WebElement NotesClick;
	
	@FindBy(xpath = "//table/tbody/tr[2]/td/table/tbody[2]/tr[1]/td[6]")
	public WebElement Notes;
	
	@FindBy(xpath = "//img[@class='butOptionsBlueRollover_image']")
	public WebElement OPTIONS;
	
	public GoldOrderPage()
	
	{
		PageFactory.initElements(driver, this);
	}
	public void goldOrderLinkClick() throws InterruptedException
	{
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
		Thread.sleep(5000);
		javascripthelper.closeAlert();
		waithelper.WaitForElementVisibleWithPollingTime(OrdersLink, 30, 10);
		OrdersLink.click();
	}
	public void createOrderClick() throws InterruptedException
	{
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
		javascripthelper.scrollIntoView(CreateOrder);
		Thread.sleep(2000);
		waithelper.WaitForElementVisibleWithPollingTime(CreateOrder, 30, 10);
		dropdownhelper.moveTillSubTaskandClick(CreateOrder,New);
	}
	public void selectContractingParty(String CustomerNumber) throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(Select, 30, 5);
		Select.click();
		windowhelper.SwitchMultipleWindow("Select Contracting Party for Order");
		driver.manage().window().maximize();
		CustomerId.sendKeys(CustomerNumber);
		Search.click();
		SelectThirdRow.click();
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
	}
	public void selectContract(String Contract) throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(SelectContract, 30, 5);
		SelectContract.click();
		windowhelper.SwitchMultipleWindow("Select Contract for Order");
		driver.manage().window().maximize();
		ContractId.sendKeys(Contract);
		Search.click();	
		SelectThirdRow.click();
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
	}
	public void selectServiceAcceptance(String ServiceContact) throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(SelectServiceAcceptance, 30, 5);
		SelectServiceAcceptance.click();
		windowhelper.SwitchMultipleWindow("Select Service Acceptance Contact.");
		driver.manage().window().maximize();
		ValContact.sendKeys(ServiceContact);
		Search.click();
		SelectThirdRow.click();
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
	}
	public void orderTerm() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(OrderTerm, 30, 5);
		OrderTerm.sendKeys("2");
	}
	public void comments() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(TextArea, 30, 5);
		TextArea.clear();
		TextArea.sendKeys("IS TRACK AUTOMATION TESTING .DON'T USE THE ORDER");
	}
	public void siteSurvey() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(SiteSurvey, 30, 5);
		dropdownhelper.selectUsingVisibleText(SiteSurvey,"no");
	}
	public void requestEarlyDelivery() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(RequestEarlyDelivery, 30, 5);
		dropdownhelper.selectUsingVisibleText(RequestEarlyDelivery,"no");
	}
	public void nonQuotoReason() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(NonQuotoReason, 30, 5);
		dropdownhelper.selectUsingVisibleText(NonQuotoReason,"Customer exception");
	}
	public void salesCompaign() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(SalesCompaign, 30, 5);
		dropdownhelper.selectUsingVisibleText(SalesCompaign,"Organic Growth");
	}
	public void selectBillingProfile() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(BillingProfile, 30, 5);
		BillingProfile.click();
		windowhelper.SwitchMultipleWindow("Select Billing Profile for Order");
		driver.manage().window().maximize();
		SelectThirdRow.click();	
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
	}
	public void selectLocalsite() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(LocalSite, 30, 5);
		LocalSite.click();
		windowhelper.SwitchMultipleWindow("Select Local Site for Order");
		driver.manage().window().maximize();
		CountryValSite.sendKeys("india");
		Search.click();
		SelectThirdRow.click();
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
	}
	public void setRefNumber() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(RefNumber, 30, 5);
		RefNumber.sendKeys("ab123");
	}
	public void setRfb() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(RFB, 30, 5);
		RFB.clear();
		RFB.sendKeys("0");
	}
	public void clickRDD()
	{
		RequestedDeliveryDate.click();
	}
	public void setCurrentDate() throws InterruptedException
	{
		windowhelper.SwitchMultipleWindow("Calendar");
		datetimehelper.currentDate();
		String dateFromGoldPage=datetimehelper.currentDate();
		System.out.println("Date from Gold Order Page function"+dateFromGoldPage);
		List<WebElement> ls = driver.findElements(By.xpath("//table//tbody//tr//td"));
		System.out.println(ls);
		log.info("################### Start Selecting Date from Date Picker ###################");
		for(WebElement datepick: ls)
		{
			if(datepick.getText().equals(dateFromGoldPage))
			{
				datepick.click();
				break;
			}	
			log.info("################### End Selecting Date from Date Picker ###################");
		}
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
	}
	public void selectProduct() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(SelectProduct, 30, 5);
		dropdownhelper.selectUsingValue(SelectProduct,"B1UZZZUUUGKEBGGFT4Z1MUQ5LYNW54ZZ");//MLAN IS Companion Services
	}
	public void selectLeadTimeBasis() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(LeadTimeBasis, 30, 5);
		LeadTimeBasis.click();
		windowhelper.SwitchMultipleWindow("Select Lead Time Basis");
		SelectThirdRow.click();
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
	}
	public void selectInstallationPreferences() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(InstallationPreferences, 30, 5);
		InstallationPreferences.sendKeys("Local Business Hours(LBH)");
		Thread.sleep(4000);
	}
	/*public void captureGoldData()
	{
		//Text1=verificationhelper.getText(GoldOrder);
		String Text1=GoldOrder.getText();
		//String sText=Text1.toString();
		System.out.println("Gold Order captured"+Text1);
		Assert.assertNotNull(Text1);
		excelhelper.updateGoldOrderInExcel(ExcelPath, SheetName1, Text1);
		System.out.println("Excel Sheet updated with Gold Order");
	}*/
	public void searchOrderAfterExtraction(String Order) throws InterruptedException
	{
		OrdersLink.click();
		String ResultOrder = Order.replaceAll("[^\\d.-]", "");
		System.out.println("Gold Order after replacing "+ResultOrder);
		OrderNumber.sendKeys(ResultOrder);
		Search.click();
		SelectOrder.click();
	}
	
	public void searchOrderForStatus() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		Thread.sleep(5000);
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
		javascripthelper.closeAlert();
		waithelper.WaitForElementVisibleWithPollingTime(OrdersLink, 30, 10);
		OrdersLink.click();
		String Order=excelhelper.getDataFromExcel(ExcelPath,SheetName1);
		System.out.println("Order extracted from excel::::"+Order);
		OrderNumber.sendKeys(Order);
		Search.click();
		waithelper.waitForElement(SelectOrder, 10);
		SelectOrder.click();
	}
	public void searchOrder() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
		OrdersLink.click();
		AllOrdersClick.click();
		alerthelper.acceptAlertIfPresent();
		String Order=excelhelper.getDataFromExcel(ExcelPath,SheetName1);
		System.out.println("Order extracted from excel::::"+Order);
		OrderNumber.clear();
		OrderNumber.sendKeys(Order);
		Search.click();
		waithelper.waitForElement(SelectOrder, 10);
		SelectOrder.click();
	}
	public void editOrder() throws InterruptedException{
		EditOrder.click();
		Thread.sleep(7000);
		alerthelper.acceptAlertIfPresent();
		Thread.sleep(60000);
		Thread.sleep(60000);
		Thread.sleep(60000);
	}
	public void selectCAT(String CATFlag) throws InterruptedException{
		dropdownhelper.selectUsingVisibleText(CAT, CATFlag);
		Thread.sleep(3000);
		verificationhelper.removePrimarySecondaryContact(SecondaryContact,PrimaryContact);
	}
	public void submitSRF2notRequired() throws InterruptedException{
		javascripthelper.scrollIntoView(CompleteTask);
		dropdownhelper.moveTillSubTaskandClick(CompleteTask, SubmitSRF2NotRequired);
		alerthelper.acceptAlert();
		Thread.sleep(5000);
	}	
	public void submitPricingOrder() throws InterruptedException
	{
		javascripthelper.scrollIntoView(CompleteTask);
		dropdownhelper.moveTillSubTaskandClick(CompleteTask, SubmitOrder);
		alerthelper.acceptAlert();
		Thread.sleep(5000);
	}
	public void selectEarlyLocalValidation() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(EarlyLocalSite, 10, 30);
		dropdownhelper.selectUsingVisibleText(EarlyLocalSite, "no");
		dropdownhelper.moveTillSubTaskandClick(CompleteTask, Submit);
		Thread.sleep(3000);
	}
	
	public void sendCustomerSignatureDate() throws InterruptedException
	{
		SelectCSD.click();
		setCurrentDate();
		javascripthelper.scrollIntoView(CompleteTask);
		dropdownhelper.moveTillSubTaskandClick(CompleteTask, Submit);
		Thread.sleep(3000);
		alerthelper.acceptAlert();
		Thread.sleep(8000);
	}
	public void checkAcceptanceNotes() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{
		searchOrder();
		NotesClick.click();
		String NotesText=Notes.getText();
		log.info("Acceptance Notes are:::"+NotesText);
	}
	
	public void orderSearchAllWork() throws Throwable, InvalidFormatException, IOException	//new function added
	{
		waithelper.pageLoadTime(5, TimeUnit.SECONDS);
		String Order=excelhelper.getDataFromExcel(ExcelPath,SheetName1);
		log.info("Gold order imported from excel"+Order);
		OrderNumber.sendKeys(Order);
		Search.click();
		SelectOrder.click();
		Thread.sleep(7000);
	}
	
	public void copyOrder() throws InterruptedException
	{
		OPTIONS.click();
		Thread.sleep(2000);
		
	}
}
