package themis.Pages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import themis.TestBase.TestBase;
import themis.Util.AlertHelper;
import themis.Util.DateTimeHelper;
import themis.Util.DropDownHelper;
import themis.Util.ExcelHelper;
import themis.Util.JavaScriptHelper;
import themis.Util.ReusableMethods;
import themis.Util.VerificationHelper;
import themis.Util.WaitHelper;
import themis.Util.WindowHelper;

public class TaskCompletionPage extends TestBase{
	public static final Logger log =Logger.getLogger(TaskCompletionPage.class.getName());
	
	
	DateTimeHelper datetimehelper = new DateTimeHelper();
	
	String ExcelPath=System.getProperty("user.dir")+"/src/main/java/themis/Data/GoldThemis.xlsx";
	String TestFile=System.getProperty("user.dir")+"\\src\\main\\java\\themis\\Data\\Test.txt";
	String TestPDF=System.getProperty("user.dir")+"\\src\\main\\java\\themis\\Data\\sample.pdf";
	String SheetName2="Sheet3";
	
	
	ExcelHelper excelhelper = new ExcelHelper();
	AlertHelper alerthelper = new AlertHelper();
	WaitHelper waithelper = new WaitHelper();
	WindowHelper windowhelper = new WindowHelper();
	DropDownHelper dropdownhelper = new DropDownHelper();
	JavaScriptHelper javascripthelper = new JavaScriptHelper();
	ReusableMethods reusablemethods = new ReusableMethods();
	VerificationHelper verificationhelper = new VerificationHelper();
	
	
	@FindBy(xpath = "//input[contains(@value,'CaseID')]")
	public WebElement CaseNumber;
	
	@FindBy(linkText = "Validate Order")
	public WebElement ValidateOrder;
	
	@FindBy(linkText = "Capture Intervention Info")
	public WebElement CaptureInterventionInfo;
	
	//@FindBy(linkText = "Create Vendor Website Order")
	@FindBy(xpath = "//a[contains(text(),'Create Vendor Website Order')]")
	public WebElement CreateVendorWebsiteOrder;
	
	@FindBy(linkText = "End of Provisioning")
	public WebElement EndofProvisioning;
	
	@FindBy(linkText = "Engage POCM Team")
	public WebElement EngagePOCMTeam;
	
	@FindBy(linkText = "Capture Estimated Ship Date")
	public WebElement CaptureEstimatedShipDate;
	
	@FindBy(linkText = "Engage SAMI for CO-Brand Enrollment")
	public WebElement CoBrandEnrollmentTask;
	
	@FindBy(linkText = "Complete Service Acceptance Test")
	public WebElement CompleteServiceAcceptanceTest;
	
	@FindBy(linkText = "Create Oracle PR") //added by kp
	public WebElement CreateOraclePR;
	
	@FindBy(linkText  = "Raise Clarify PO")	//added by kp
	public WebElement RaiseClarifyPO;
	
	@FindBy(name = "PegaGadget0Ifr")
	public WebElement C_Frame;
	
	@FindBy(name = "PegaGadget1Ifr")
	public WebElement EP_Frame;
	
	@FindBy(name = "PegaGadget2Ifr")
	public WebElement OF_Frame;
	
	@FindBy(name = "PegaGadget3Ifr")
	public WebElement WS_Frame;
	
	@FindBy(name = "PegaGadget4Ifr")
	public WebElement TW_Frame;
		
	@FindBy(id = "EquipMargin")
	public WebElement EquipmentMargin;
	
	@FindBy(id = "SiteIdRefNumber")
	public WebElement SiteIdRefNumber;
	
	@FindBy(id = "VBSMargin")
	public WebElement VBSMargin;
	
	@FindBy(xpath = "//input[@id='VenWebRef1']")
	public WebElement VendorOrderRef;
	
	@FindBy(xpath = "//input[@id='SvcQuoteRef1']")
	public WebElement ServiceQuoteRef;
	
	//@FindBy(xpath = "//select[contains(@name,'pIsSiteIdCreated')]")
	@FindBy(xpath = "//select[contains(@id,'IsSiteIdCreated')]")
	public WebElement SiteIdCreated;
	
	@FindBy(xpath = "//input[contains(@name,'pActualDelDate')]")
	public WebElement ActualDelDate;
	
	@FindBy(xpath = "(//span[@id='close'])[2]")
	public WebElement Close2;
	
	@FindBy(xpath = "//input[@id='OraclePRRef1']")
	public WebElement PurchaseRequisitionRef;
	
	
	@FindBy(id = "SvcContractNum1")
	public WebElement ServiceContactNum;
		
	@FindBy(xpath = "(//img[@class='inactvIcon'])[1]")
	public WebElement Date1;
	
	@FindBy(xpath = "(//img[@class='inactvIcon'])[2]")
	public WebElement Date2;
	
	@FindBy(xpath = "//button[@title='Complete this assignment']")
	public WebElement Submit;
	
	@FindBy(xpath = "(//span[@class='match-highlight'])[1]")
	public WebElement SelectVendor;
	
	@FindBy(id = "IsSORSellPricetrue")
	public WebElement IsSORSellPricetrue;
	
	@FindBy(id = "EstimatedShipDataAvaltrue")
	public WebElement EstimatedShipDataAvaltrue;
	
	@FindBy(id = "IsAlignedtrue")
	public WebElement IsAlignedtrue;
	
	@FindBy(id = "IsEqualCodetrue")
	public WebElement IsEqualCodetrue;
	
	@FindBy(id = "OraclePRRef1")
	public WebElement OraclePRRef1;
	
	@FindBy(id = "PORef1")
	public WebElement PORef1;
	
	@FindBy(xpath = "//input[@id='ActualDelDate1']")
	public WebElement ActualDelDate1;
	
	@FindBy(id = "VendorSalesOrderRef1")
	public WebElement ConfirmVendorSalesOrderRef;
	
	@FindBy(xpath = "//input[@id='CarrierName1']")
	public WebElement CarrierName;
	
	@FindBy(xpath = "//input[@id='AirwayBillRef1']")
	public WebElement AirwayBillRef;
	
	@FindBy(id = "IsPODAttachedTWHtrue")
	public WebElement IsPODAttachedTWHtrue;
	
	@FindBy(id = "IsPODAttachedEPtrue")
	public WebElement IsPODAttachedEPtrue;
	
	@FindBy(xpath = "//input[@id='MACHXPORef1']")	//new added
	public WebElement MachxCaseRef;
	
	@FindBy(xpath = "(//span[contains(@class,'textIn')])[2]")
	public WebElement DownButton;
	
	@FindBy(xpath = "//td[contains(text(),'Attachments')]")
	public WebElement AttachmentButton;
	
	@FindBy(xpath = "//button[contains(@tabindex,'0')]")
	public WebElement AddButton;
	
	@FindBy(xpath = "//input[@id='StagingReqNumber1']")
	public WebElement StagingRequestNumber;
	
	@FindBy(xpath = "//a[contains(.,'Attach file(s)')]")
	public WebElement Attach;
	
	@FindBy(linkText = "Engage Shipment")
	public WebElement EngageShipment;
	
	@FindBy(xpath = "//input[@id='$PpyAttachmentPage$ppxAttachName']")
	public WebElement FileName;
	
	@FindBy(xpath = "//*[@id='pyCategory']")
	public WebElement Category;
	
	@FindBy(linkText = "Engage For Staging")
	public WebElement EngageForstaging;
	
	@FindBy(linkText = "Capture Delivery Details")
	public WebElement CaptureDeliveryDetails;
	
	@FindBy(xpath = "//*[@id='ModalButtonSubmit']")
	public WebElement ModalSubmit;
	
	@FindBy(id = "IsStaggingCompletedtrue")
	public WebElement IsStaggingCompletedtrue;
	
	@FindBy(xpath = "//a[contains(.,'Other Actions')]")
	public WebElement OtherActions;
	
	@FindBy(xpath = "//a[@class='ActionLink']")	//Name has to be changed later
    public WebElement otherActions;
	
	@FindBy(xpath = "//td[contains(.,'Track Delay And Escalatio...')]")
	public WebElement TrackDelay; 
	
	@FindBy(xpath = "//select[@id='DelayReason']")
	public WebElement DelayReason; 
	
	@FindBy(xpath = "//select[@id='SubCategoryDelayReason']")
	public WebElement SubCategory;
	
	@FindBy(xpath = "//input[contains(@name,'pDelayedEndDate')]")
	public WebElement DelayedEndDate;
	
	//@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[3]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[13]/td[3]/div[1]")
	@FindBy(xpath = "//table[@id='gridLayoutTable']/tbody/tr/td[2]/div/table/tbody/tr[11]/td[3]")
	
	public WebElement EngageShipmentDeadline; 
	
	@FindBy(xpath = "//img[contains(@title,'Attachments')]")
	public WebElement AttachmentImage;
	
	@FindBy(xpath="(//div[contains(text(),'Customer Signature Date')]//following::div/span[1])[1]")
	public WebElement CustomerSignatureDate;
	
	@FindBy(xpath = "//a[contains(@class,'ActionLink')]")
	public WebElement ActionsLink; 
	
	@FindBy(xpath = "//td[contains(@title,'Refresh this work item')]")
	public WebElement Refresh; 
	
	@FindBy(xpath = "//input[contains(@type,'checkbox')]")
	public WebElement FullyCompletedCheckbox; 
	
	@FindBy(id = "IsReceipttrue")
	public WebElement IsReceipttrue;
	
	@FindBy(id = "IsManualPOtrue")
	public WebElement IsManualPOtrue;
	
	@FindBy(id = "IsKPIMissedfalse")
	public WebElement IsKPIMissedfalse;
	
	@FindBy(id = "IsCustomizeReqfalse")
	public WebElement IsCustomizeReqfalse;
	
	@FindBy(id = "IsBackBillingfalse")
	public WebElement IsBackBillingfalse;
	
	@FindBy(id = "IsEveryThingDeliveredtrue")
	public WebElement IsEveryThingDeliveredtrue;
	
	@FindBy(id = "SCNSendToCustomertrue")
	public WebElement SCNSendToCustomertrue;
	
	@FindBy(id = "CustomerDisputefalse")
	public WebElement CustomerDisputefalse;
	
	@FindBy(id = "IsPOSharedWithOCDtrue")	//added by kp
	public WebElement IsPOSharedWithOCDtrue;
	
	@FindBy(id = "IsReceiptCompletedtrue")
	public WebElement IsReceiptCompletedtrue;	//added by kp
	
	@FindBy(id = "//input[@id='HasSIAttachedSRFtrue']") //new added
	public WebElement HasSIAttachedSRFtrue;
	
	@FindBy(xpath = "//div[contains(text(),'Check for SCN updates')]")
	public WebElement CheckForSCNUpdates;
	
	@FindBy(id = "FirstCountry1") 
	public WebElement FirstCountry1;
	
	@FindBy(xpath = "//input[@id='ShipReqNum1']") 
	public WebElement ShipmentRequestNumber;
	
	@FindBy(xpath="(//div[contains(text(),'Customer Approval Date')]//following::div/span[1])[1]")
	public WebElement CustomerApproval;
	
	@FindBy(xpath = "/html/body/div[2]/form/div[3]/table/tbody/tr/td/div/div/span[3]/div/table/tbody/tr/td[1]/div/span[2]/div/span/div/div/div[2]/div[8]/div/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[3]/div/div/span/span")
	public WebElement EquipmentMarginDate; 
	
	@FindBy(xpath = "/html/body/div[2]/form/div[3]/table/tbody/tr/td/div/div/span[3]/div/table/tbody/tr/td[1]/div/span[2]/div/span/div/div/div[2]/div[8]/div/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[4]/div/div/span")
	public WebElement CustomeDate;
	
	@FindBy(xpath = "/html/body/div[2]/form/div[3]/table/tbody/tr/td/div/div/span[3]/div/table/tbody/tr/td[1]/div/span[2]/div/span/div/div/div[2]/div[8]/div/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[2]/div/div/span")
	public WebElement InitialTargetDelivery;
	
	@FindBy(xpath = "//a[contains(.,'Case Data')]")
	public WebElement CaseData;
	
	
	@FindBy(xpath = "/html/body/div[2]/form/div[3]/table/tbody/tr/td/div/div/span[3]/div/table/tbody/tr/td[1]/div/span[2]/div/span/div/div/div[2]/div[8]/div/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div/div/span")
	public WebElement Customer;
	
	@FindBy(xpath = "//td[contains(.,'Order Familiarization')]")
	public WebElement OrderFam;
	
	@FindBy(xpath="(//div[contains(text(),'Initial Target Delivery Date')]//following::div/span[1])[1]")
	//@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/span[2]/div[1]/span[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[8]/span[1]")
	public WebElement iTDD;
	
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[3]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[2]/td[4]/div[1]/div[1]/a[1]")
	public WebElement TaskStatus1;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[3]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[3]/td[4]/div[1]/div[1]/a[1]")
	public WebElement TaskStatus2;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[3]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[4]/td[4]/div[1]/div[1]/a[1]")
	public WebElement TaskStatus3;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[3]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[5]/td[4]/div[1]/div[1]/a[1]")
	public WebElement TaskStatus4;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[3]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[6]/td[4]/div[1]/div[1]/a[1]")
	public WebElement TaskStatus5;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[3]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[7]/td[4]/div[1]/div[1]/a[1]")
	public WebElement TaskStatus6;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/span[1]/div[1]/span[2]/div[1]/div[1]/span[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/table[3]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[8]/td[4]/div[1]/div[1]/a[1]")
	public WebElement TaskStatus7;
	
	@FindBy(xpath = "//td[contains(@title,'Reject')]")
	public WebElement Reject;
	
	@FindBy(xpath = "//select[contains(@name,'pRejectReason')]")
	public WebElement RejectReason;
	
	@FindBy(xpath = "//textarea[contains(@name,'pRejectRemarks')]")
	public WebElement RejectRemarks;
	
	@FindBy(xpath = "//a[contains(@title,'Save this work item')]")
	public WebElement SaveButton;
	
	@FindBy(xpath = "//input[@class='autocomplete_input highlight']")
	public WebElement VendorName;
	
	@FindBy(xpath = "//input[@id='VendorSalesOrderRef1']") //new added
	public WebElement VendorRef;
	
	@FindBy(xpath = "//input[@id='SvcContractNum1']")	//new added
	public WebElement ServiceContract;
	
	@FindBy(xpath = "//a[contains(text(),'Validate Order')]")
    public WebElement Validateorder;
	
	@FindBy(xpath = "//input[@id='VBSMargin']")
    public WebElement VendorMargin;
	
	@FindBy(xpath = "//input[@id='EndDate1']")
	public WebElement EndDate;
	
	@FindBy(xpath = "//input[@id='ClarifyRef1']")
	public WebElement ClarifyRef;
	
	@FindBy(xpath = "//input[@id='ClarifyPORef1']")	//new added
	public WebElement ClarifyPORef;
	
	@FindBy(xpath = "//input[@id='DispatchRef1']")
	public WebElement DispatchRef;

	@FindBy(xpath = "//li[@id='Tab3']//img")
	public WebElement AttachWelcomeletter;

	@FindBy(xpath = "//a[contains(text(),'Attach Welcome Letter')]")
	public WebElement AttachWelcomeLetter;
	
	@FindBy(xpath = "//span[@id='$PpyWorkPage$pWelcomeLetterDetails$pRequestedDateSpan']//img[contains(@class,'inactvIcon')]")
	public WebElement RequestedDate;               

	@FindBy(xpath = "//span[@id='$PpyWorkPage$pWelcomeLetterDetails$pWLReceivedDateSpan']//img[contains(@class,'inactvIcon')]")
	public WebElement ReceivedDate;

	@FindBy(xpath = "//span[@id='$PpyWorkPage$pWelcomeLetterDetails$pCompletionDateSpan']//img[contains(@class,'inactvIcon')]")
	public WebElement CompletionDate;
	
	
	
	public TaskCompletionPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void searchCase() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		windowhelper.SwitchMultipleWindow("Manager");
		windowhelper.switchToParentWindow();
		String Case=excelhelper.getDataFromExcel(ExcelPath,SheetName2);
		log.info("Case Id extracted from excel::::"+Case);
		CaseNumber.clear();
		Thread.sleep(3000);
		CaseNumber.sendKeys(Case);
		CaseNumber.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		alerthelper.acceptAlertIfPresent();
		Thread.sleep(5000);
		
	}
	public void validateOrder() throws InterruptedException
	{
		Thread.sleep(10000);
		windowhelper.switchToParentWindow();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 20);
//		ValidateOrder.click();
		EquipmentMargin.sendKeys("123");
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
		/*
        String IntialdeliveryDate=iTDD.getText();
        log.info("IntialdeliveryDate:::"+IntialdeliveryDate);
        Thread.sleep(2000);
        String CustomerApprovalDate = CustomerApproval.getText();
        log.info("CustomerApprovalDate:::"+CustomerApprovalDate);
        Thread.sleep(2000);
        String CustomerSignature =  CustomerSignatureDate.getText();
        log.info("CustomerSignatureDate:::"+CustomerSignature);
        Thread.sleep(3000);
        javascripthelper.scrollIntoView(CaseData);
        Thread.sleep(2000);
        CaseData.click();
        Thread.sleep(2000);
        OrderFam.click();
        Thread.sleep(30000);
         //validateOrderDetails.click();
        String CustomerSignatureDate = Customer.getText();
        log.info("CaseSignatureDate:::"+CustomerSignatureDate);
        Thread.sleep(3000);
        Assert.assertEquals(CustomerSignature, CustomerSignatureDate);
        Thread.sleep(3000);
        String InitialTargetDeliveryDate = InitialTargetDelivery.getText();
        log.info("CaseInitialTargetDeliveryDate"+InitialTargetDeliveryDate);
        Thread.sleep(3000);
        Assert.assertEquals(IntialdeliveryDate, InitialTargetDeliveryDate);
        Thread.sleep(3000);
        String CustomerApproval = CustomeDate.getText();
        log.info("CaseCustomerApproval"+CustomerApproval);
        Thread.sleep(3000);
        Assert.assertEquals(CustomerApprovalDate, CustomerApproval);
        Thread.sleep(3000);
        String EquipmentMargin =EquipmentMarginDate.getText();
        log.info("EquipmentMargin"+EquipmentMargin); 
        */
		//Submit.click();// submit for revise TDD
		//Thread.sleep(3000);
	}
	public void validateVBSOrder() throws InterruptedException
	{
		//Thread.sleep(10000);
		windowhelper.switchToParentWindow();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 20);
		VBSMargin.sendKeys("123");
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
		//Submit.click();// submit for revise TDD
		//Thread.sleep(3000);
	}
	public void validateERSVBSOrder() throws InterruptedException
	{
		Thread.sleep(10000);
		windowhelper.switchToParentWindow();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 20);
		EquipmentMargin.sendKeys("123");
		Thread.sleep(2000);
		VBSMargin.sendKeys("123");
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
		//Submit.click();// submit for revise TDD
		//Thread.sleep(3000);
	}
	public void validateOnlineIntervention() throws InterruptedException
	{
		windowhelper.switchToParentWindow();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 20);
		Submit.click();
		Thread.sleep(5000);
		dropdownhelper.selectUsingVisibleText(SiteIdCreated,"Yes");
		Thread.sleep(5000);
		SiteIdRefNumber.sendKeys("Site123");
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
		//Submit.click();
	}
	
	public void validateEAMManaged() throws InterruptedException	//new function added
	{
		Thread.sleep(10000);
		windowhelper.switchToParentWindow();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 20);
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
		dropdownhelper.selectUsingVisibleText(SiteIdCreated,"Yes");
		Thread.sleep(5000);
		SiteIdRefNumber.sendKeys("Site123");
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(9000);
	}
	
	public void rejectEquipmentProcurement() throws InterruptedException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		CreateVendorWebsiteOrder.click();
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		Thread.sleep(16000);
		OtherActions.click();
		Reject.click();
		Thread.sleep(4000);
		//dropdownhelper.selectUsingVisibleText(RejectReason,"Incorrect BAN");
		RejectRemarks.sendKeys("Reject Case");
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(3000);
	}
	public void equipmentProcurement() throws InterruptedException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		CreateVendorWebsiteOrder.click();
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		VendorOrderRef.sendKeys("Vendor123");
		Submit.click();
		Thread.sleep(3000); //k
		IsSORSellPricetrue.click();
		Thread.sleep(3000);
		IsAlignedtrue.click();
		Thread.sleep(3000);
		IsEqualCodetrue.click();
		Thread.sleep(3000);
		OraclePRRef1.sendKeys("123");
		Submit.click();
		Thread.sleep(3000); //k
		PORef1.sendKeys("123");
		Submit.click();
		Thread.sleep(7000);
		Submit.click();
		Thread.sleep(7000);
		ConfirmVendorSalesOrderRef.sendKeys("123");
		Submit.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(13000);
		Close2.click();
		Thread.sleep(5000);
	}
	
	public void serviceProcurement() throws InterruptedException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		CreateVendorWebsiteOrder.click();
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		Thread.sleep(2000);
		VendorOrderRef.sendKeys("Vendor123");
		ServiceQuoteRef.sendKeys("Service123");
		Thread.sleep(3000);
		Submit.click();
		//IsSORSellPricetrue.click();
		//Thread.sleep(3000);
		//IsAlignedtrue.click();
		//Thread.sleep(3000);
		//IsEqualCodetrue.click();
		Thread.sleep(5000);
		OraclePRRef1.sendKeys("123");
		Submit.click();
		Thread.sleep(5000);
		PORef1.sendKeys("123");
		Submit.click();
		Thread.sleep(7000);
		Submit.click();
		Thread.sleep(7000);
		ConfirmVendorSalesOrderRef.sendKeys("123");
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		Close2.click();
		Thread.sleep(5000);
	}
	
	public void coBrandEnrollment() throws InterruptedException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		CoBrandEnrollmentTask.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		Thread.sleep(5000);
		Submit.click();
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		Close2.click();
		Thread.sleep(3000);
	}
	public void trackSupplierDelivery() throws InterruptedException, ParseException
	{
		
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		CaptureEstimatedShipDate.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		Thread.sleep(10000);
		//EstimatedShipDataAvaltrue.click();
		javascripthelper.clickElement(EstimatedShipDataAvaltrue);
		Thread.sleep(13000);
		setCurrentDate(Date1);//Estimated Ship date
		Thread.sleep(15000);
		FirstCountry1.click();
		FirstCountry1.sendKeys("JAPAN");
		Submit.click();
		Thread.sleep(18000);
		setCurrentDate(Date1);// Ship Out Date
		Thread.sleep(10000);
		//setAfterDate(Date2); // Actual Delivery date
		setAfterDate_New(ActualDelDate);
		Thread.sleep(13000);
		CarrierName.sendKeys("CISCO");
		AirwayBillRef.sendKeys("123");
		IsPODAttachedEPtrue.click();
		Thread.sleep(13000);
		javascripthelper.scrollhorizontally();
		Thread.sleep(13000);
		javascripthelper.scrollIntoView(DownButton);
		DownButton.click();
		Thread.sleep(3000);
		AttachmentButton.click();
		Thread.sleep(13000);
		javascripthelper.scrollhorizontally();
		dropdownhelper.MoveToTaskandClick(AddButton);
		Thread.sleep(5000);
		Attach.click();
		Thread.sleep(12000);
		FileName.sendKeys(TestFile);
		Thread.sleep(13000);
		dropdownhelper.selectUsingVisibleText(Category, "Warehouse POD");
		//dropdownhelper.selectUsingVisibleText(Category, "Customer POD");
		Thread.sleep(13000);
		ModalSubmit.click();
		Thread.sleep(13000);
		//IsPODAttachedEPtrue.click();
		//Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Close2.click();
		Thread.sleep(3000);
	}
	public void warehouseStaging() throws InterruptedException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		EngageForstaging.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		StagingRequestNumber.sendKeys("123");
		Submit.click();
		IsStaggingCompletedtrue.click();
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		Close2.click();
		Thread.sleep(13000);
	}
	
	public void warehouseStagingEAMManaged() throws InterruptedException		//new function added
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		EngageForstaging.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		//StagingRequestNumber.sendKeys("123");
		Submit.click();
		Thread.sleep(3000);
		IsStaggingCompletedtrue.click();
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(15000);
		driver.switchTo().defaultContent();
		Close2.click();
		Thread.sleep(13000);
	}
	
	public void trackWarehouseDelivery() throws ParseException, InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		EngageShipment.click();
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		Thread.sleep(20000);
		OtherActions.click();
		Thread.sleep(20000);
		TrackDelay.click();
		dropdownhelper.selectUsingVisibleText(DelayReason, "Customs Delay");
		dropdownhelper.selectUsingVisibleText(SubCategory, "Custom Clearance Delay");
		Thread.sleep(10000);
		//setAfterDate(Date1);
		setAfterDate_New(DelayedEndDate);
		Submit.click();
		Thread.sleep(13000);
		
		driver.switchTo().defaultContent();
		searchCase();
		Thread.sleep(30000);
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 30);
		ActionsLink.click();
		Refresh.click();
		
		Thread.sleep(15000);
		waithelper.pageLoadTime(15, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		javascripthelper.scrollDownVertically();
		//javascripthelper.scrollToElement(EngageShipment);
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		reusablemethods.takeScreenshot("Tasks/Deadline");
		String deadline=verificationhelper.getText(EngageShipmentDeadline);
		log.info("Deadline captured is"+deadline);
		
		//driver.switchTo().defaultContent();
		//waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		//javascripthelper.scrollDownVertically();
		
		EngageShipment.click();
		alerthelper.acceptAlertIfPresent();
		Thread.sleep(3000);
		
		
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		ShipmentRequestNumber.sendKeys("123");
		Submit.click();
		Thread.sleep(13000);		
		CarrierName.sendKeys("DHL");
		AirwayBillRef.sendKeys("987");
		setCurrentDate(Date1);//ship out date
		//setAfterDate(Date2);// Actual Delivery date must be after ship out date
		setAfterDate_New(ActualDelDate);
		Thread.sleep(10000);
		IsPODAttachedTWHtrue.click();
		Thread.sleep(15000);
		
		javascripthelper.scrollhorizontally();
		Thread.sleep(13000);
		AttachmentImage.click();
		Thread.sleep(15000);
		//new code
		dropdownhelper.MoveToTaskandClick(AddButton);
		Thread.sleep(15000);
		Attach.click();
		Thread.sleep(3000);
		FileName.sendKeys(TestFile);
		Thread.sleep(13000);
		dropdownhelper.selectUsingVisibleText(Category, "Customer POD");
		Thread.sleep(3000);
		ModalSubmit.click();
		Thread.sleep(14000);
		Submit.click();
		Thread.sleep(7000);
		driver.switchTo().defaultContent();
		Close2.click();
		Thread.sleep(5000);
		/*
		
		//javascripthelper.scrollIntoView(DownButton);
		//DownButton.click();
		Thread.sleep(3000);
		//AttachmentButton.click();
		Thread.sleep(3000);
		javascripthelper.scrollhorizontally();
		dropdownhelper.MoveToTaskandClick(AddButton);
		Thread.sleep(5000);
		Attach.click();
		FileName.sendKeys(TestFile);
		Thread.sleep(3000);
		dropdownhelper.selectUsingVisibleText(Category, "Customer POD");
		ModalSubmit.click();
		Thread.sleep(4000);
		
	
		Submit.click();
		Thread.sleep(7000);
			*/
	}
	
	//new function added
	public void trackWarehouseDeliveryEAMManaged() throws ParseException, InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		EngageShipment.click();
		alerthelper.acceptAlertIfPresent();
		Thread.sleep(3000);		
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		ShipmentRequestNumber.sendKeys("123");
		Submit.click();
		Thread.sleep(13000);		
		CarrierName.sendKeys("DHL");
		AirwayBillRef.sendKeys("987");
		setCurrentDate(Date1);//ship out date
		//setAfterDate(Date2);// Actual Delivery date must be after ship out date
		setAfterDate_New(ActualDelDate);
		Thread.sleep(10000);
		IsPODAttachedTWHtrue.click();
		Thread.sleep(15000);
		
		javascripthelper.scrollhorizontally();
		Thread.sleep(13000);
		AttachmentImage.click();
		Thread.sleep(15000);
		//new code
		dropdownhelper.MoveToTaskandClick(AddButton);
		Thread.sleep(15000);
		Attach.click();
		Thread.sleep(3000);
		FileName.sendKeys(TestFile);
		Thread.sleep(13000);
		dropdownhelper.selectUsingVisibleText(Category, "Customer POD");
		Thread.sleep(3000);
		ModalSubmit.click();
		Thread.sleep(14000);
		Submit.click();
		Thread.sleep(7000);
		driver.switchTo().defaultContent();
		Close2.click();
		Thread.sleep(5000);
	}
	
	public void acceptanceERS() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		EndofProvisioning.click();
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		setCurrentDate(Date1);
		//setCurrentDate(Date2);
		//FullyCompletedCheckbox.click();
		SaveButton.click();
		//driver.switchTo().defaultContent();
		searchCase();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		EndofProvisioning.click();
		alerthelper.acceptAlertIfPresent();
		Thread.sleep(6000);
		windowhelper.switchToParentWindow();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		
		Submit.click();
		Thread.sleep(4000);
		//driver.switchTo().defaultContent();
		searchCase();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		CompleteServiceAcceptanceTest.click();
		alerthelper.acceptAlertIfPresent();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
	/*	IsReceipttrue.click();
		Thread.sleep(2000);
		IsManualPOtrue.click();
		Thread.sleep(2000);
		IsKPIMissedfalse.click();
		Thread.sleep(2000);
		IsCustomizeReqfalse.click();
		Thread.sleep(2000);
		IsBackBillingfalse.click();
		Thread.sleep(2000);
		IsEveryThingDeliveredtrue.click();	*/
		Submit.click();
		Thread.sleep(5000);
		
		alerthelper.acceptAlertIfPresent();
		Thread.sleep(5000);
		//waithelper.WaitForElementVisibleWithPollingTime(SCNSendToCustomertrue, 20, 3);
		SCNSendToCustomertrue.click();
		Thread.sleep(4000);
		CustomerDisputefalse.click();
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(10000);
		alerthelper.acceptAlertIfPresent();
		waithelper.waitForElement(CheckForSCNUpdates, 10);
		Thread.sleep(3000);
		CheckForSCNUpdates.click();
		Thread.sleep(10000);
		Submit.click(); 
		Thread.sleep(13000);
		//setCurrentDate(Date1);
		//setCurrentDate(Date2);
		Submit.click(); 
		Thread.sleep(10000);
		//Close2.click();
		//Thread.sleep(3000);
	}
	
	public void trackSupplierDeliveryEP() throws InterruptedException, ParseException //new function added
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		RaiseClarifyPO.click();
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		Thread.sleep(10000);
		ClarifyPORef.sendKeys("123");
		Submit.click();
		Thread.sleep(5000);
		javascripthelper.clickElement(EstimatedShipDataAvaltrue);
		Thread.sleep(10000);
		setCurrentDate(Date1);//Estimated Ship date
		Thread.sleep(10000);
		FirstCountry1.click();
		FirstCountry1.sendKeys("JAPAN");
		Submit.click();
		Thread.sleep(18000);
		setCurrentDate(Date1);// Ship Out Date
		Thread.sleep(10000);
		//setAfterDate(Date2); // Actual Delivery date
		setAfterDate_New(ActualDelDate);
		Thread.sleep(13000);
		CarrierName.sendKeys("CISCO");
		AirwayBillRef.sendKeys("123");
		IsPODAttachedEPtrue.click();
		Thread.sleep(13000);
		javascripthelper.scrollhorizontally();
		Thread.sleep(13000);
		javascripthelper.scrollIntoView(DownButton);
		DownButton.click();
		Thread.sleep(3000);
		AttachmentButton.click();
		Thread.sleep(13000);
		javascripthelper.scrollhorizontally();
		dropdownhelper.MoveToTaskandClick(AddButton);
		Thread.sleep(5000);
		Attach.click();
		Thread.sleep(12000);
		FileName.sendKeys(TestFile);
		Thread.sleep(13000);
		dropdownhelper.selectUsingVisibleText(Category, "Warehouse POD");
		//dropdownhelper.selectUsingVisibleText(Category, "Customer POD");
		Thread.sleep(13000);
		ModalSubmit.click();
		Thread.sleep(13000);
		//IsPODAttachedEPtrue.click();
		//Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
		MachxCaseRef.sendKeys("123");
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Close2.click();
		Thread.sleep(3000);
		
	}
	
	public void trackSupplierDeliveryEPIndirect() throws InterruptedException, ParseException	//new function added
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		RaiseClarifyPO.click();
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		Thread.sleep(10000);
		ClarifyPORef.sendKeys("123");
		Submit.click();
		Thread.sleep(5000);
		javascripthelper.clickElement(EstimatedShipDataAvaltrue);
		Thread.sleep(10000);
		setCurrentDate(Date1);//Estimated Ship date
		Thread.sleep(10000);
		FirstCountry1.click();
		FirstCountry1.sendKeys("JAPAN");
		Submit.click();
		Thread.sleep(18000);
		setCurrentDate(Date1);// Ship Out Date
		Thread.sleep(10000);
		//setAfterDate(Date2); // Actual Delivery date
		setAfterDate_New(ActualDelDate);
		Thread.sleep(13000);
		CarrierName.sendKeys("CISCO");
		AirwayBillRef.sendKeys("123");
		IsPODAttachedEPtrue.click();
		Thread.sleep(13000);
		javascripthelper.scrollhorizontally();
		Thread.sleep(13000);
		javascripthelper.scrollIntoView(DownButton);
		DownButton.click();
		Thread.sleep(3000);
		AttachmentButton.click();
		Thread.sleep(13000);
		javascripthelper.scrollhorizontally();
		dropdownhelper.MoveToTaskandClick(AddButton);
		Thread.sleep(5000);
		Attach.click();
		Thread.sleep(12000);
		FileName.sendKeys(TestFile);
		Thread.sleep(13000);
		//dropdownhelper.selectUsingVisibleText(Category, "Warehouse POD");
		dropdownhelper.selectUsingVisibleText(Category, "Customer POD");
		Thread.sleep(13000);
		ModalSubmit.click();
		Thread.sleep(13000);
		//IsPODAttachedEPtrue.click();
		//Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
		MachxCaseRef.sendKeys("123");
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		Close2.click();
		Thread.sleep(3000);
	}

	public void trackSupplierDeliverySP() throws InterruptedException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		CaptureDeliveryDetails.click();
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		VendorName.sendKeys("CISCO");
		Thread.sleep(10000);
		VendorRef.sendKeys("123");
		Thread.sleep(2000);
		ServiceContract.sendKeys("566");
		Thread.sleep(2000);
		setCurrentDate(Date1);
		Thread.sleep(1000);
		setCurrentDate(Date2);
		Thread.sleep(2000);
		Submit.click();
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		Close2.click();
	}
	
	public void onsiteIntervention() throws InterruptedException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		CaptureInterventionInfo.click();
		Thread.sleep(3000);
		windowhelper.switchToParentWindow();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		ClarifyRef.sendKeys("123");
		Thread.sleep(2000);
		DispatchRef.sendKeys("123");
		Thread.sleep(3000);
		setCurrentDate(Date1);
		Thread.sleep(3000);
		setCurrentDate(Date2);
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(7000);
		driver.switchTo().defaultContent();
		Close2.click();
		Thread.sleep(5000);
	}
	
	public void ContractUploadODMUser() throws ParseException, InterruptedException	//new function added
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		EngagePOCMTeam.click();
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		Thread.sleep(5000);
		//HasSIAttachedSRFtrue.click();
		Submit.click();
		Thread.sleep(10000);

	}
	
	public void acceptanceIS() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		EndofProvisioning.click();
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		setCurrentDate(Date1);
		//setCurrentDate(Date2);
		//FullyCompletedCheckbox.click(); //This checkbox is checked by default
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(3000);
		searchCase();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		CompleteServiceAcceptanceTest.click();
		alerthelper.acceptAlertIfPresent();
		Thread.sleep(6000);
		windowhelper.switchToParentWindow();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		
	/*	IsKPIMissedfalse.click();	// Now Radio buttons are selected auto selected
		Thread.sleep(3000);
		IsCustomizeReqfalse.click();
		Thread.sleep(3000);
		IsBackBillingfalse.click();
		Thread.sleep(3000);
		IsEveryThingDeliveredtrue.click();
		Thread.sleep(3000);		*/
		
		Submit.click();
		Thread.sleep(3000);
		SCNSendToCustomertrue.click();
		Thread.sleep(4000);
		CustomerDisputefalse.click();
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(10000);
		alerthelper.acceptAlertIfPresent();
		waithelper.waitForElement(CheckForSCNUpdates, 10);
		CheckForSCNUpdates.click();
		Thread.sleep(10000);
		Submit.click(); 
		//Thread.sleep(3000);
		//Submit.click(); 
		Thread.sleep(7000);
		Submit.click();
		Thread.sleep(5000);
	}
	
	public void serviceProcurementOCD() throws InterruptedException	//added by kp
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		CreateOraclePR.click();
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		PurchaseRequisitionRef.sendKeys("123");
		Submit.click();
		Thread.sleep(5000);
		PORef1.sendKeys("123");
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
		Submit.click();
		Thread.sleep(5000);
		IsPOSharedWithOCDtrue.click();
		Thread.sleep(2000);
		IsReceiptCompletedtrue.click();
		Thread.sleep(2000);
		Submit.click();
		Thread.sleep(5000);
	}
	
	public void engagePOCMTask() throws InterruptedException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		Thread.sleep(3000);
		EngagePOCMTeam.click();
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);
		Thread.sleep(4000);
		//HasSIAttachedSRFtrue.click();
		Thread.sleep(2000);
		Submit.click();
		Thread.sleep(5000);
	}
	
	public void validateOCDOrder() throws InterruptedException //added by kp
	{
		Thread.sleep(10000);
		windowhelper.switchToParentWindow();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 20);
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(5000);
	}
	
    public void validateOrderVendorWelcome() throws InterruptedException
    {                
    	Thread.sleep(5000);
		windowhelper.switchToParentWindow();
    	//Validateorder.click();                                                    
    	waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 20);                                    
    	//ValidateOrder.click();                                                    
    	VendorMargin.sendKeys("123");                                                   
    	Thread.sleep(2000);                                                   
    	Submit.click();                                                   
    	Thread.sleep(10000);                                                
    }
    
    public void WelcomeLetter() throws InterruptedException
    {                   
    	waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);                    
    	AttachWelcomeLetter.click();
    	Thread.sleep(5000);
    	driver.switchTo().defaultContent();                    
    	waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 20);                    
    	setCurrentDate(RequestedDate);                    
    	setCurrentDate(ReceivedDate);                    
    	setCurrentDate(CompletionDate);
    	IsPODAttachedEPtrue.click();                    
    	Thread.sleep(5000);                    
    	//javascripthelper.scrollIntoView(DownButton);                    
    	//javascripthelper.clickElement(DownButton);                    
    	//Thread.sleep(10000);                    
    	//javascripthelper.scrollUpVertically();                    
    	AttachWelcomeletter.click();                    
    	Thread.sleep(3000);                    
    	javascripthelper.scrollIntoView(AddButton);                    
    	Thread.sleep(5000);                    
    	javascripthelper.scrollUpVertically();                    
    	Thread.sleep(3000);                    
    	//javascripthelper.clickElement(AddButton);                    
    	//AddButton.click();                    
    	waithelper.WaitForElementVisibleWithPollingTime(AddButton, 30, 10);                    
    	AddButton.click();                    
    	((JavascriptExecutor)driver).executeScript("arguments[0].checked = true;", AddButton);                   
    	//dropdownhelper.moveTillSubTaskandClick(AddButton,Attach);                    
    	Thread.sleep(10000);                    
    	Attach.click();                    
    	Thread.sleep(10000);                    
    	//FileName.click();                    
    	//Thread.sleep(10000);                    
    	FileName.sendKeys(TestPDF);                    
    	Thread.sleep(3000);                  
    	dropdownhelper.selectUsingVisibleText(Category, "PDF");                    
    	Thread.sleep(2000);                    
    	ModalSubmit.click();                    
    	Thread.sleep(10000);                    
    	//otherActions.click();                    
    	//Thread.sleep(15000);                    
    	Submit.click();
    	Thread.sleep(6000);
    	//driver.switchTo().defaultContent();
    }
	
	public void checkCloseTasks() throws IOException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		reusablemethods.takeScreenshot("Tasks/Alltaskscomplete");
		String taskStatus1=verificationhelper.getText(TaskStatus1);
		Assert.assertEquals(taskStatus1,"Completed");
		String taskStatus2=verificationhelper.getText(TaskStatus2);
		Assert.assertEquals(taskStatus2,"Completed");
		String taskStatus3=verificationhelper.getText(TaskStatus3);
		Assert.assertEquals(taskStatus3,"Completed");
		String taskStatus4=verificationhelper.getText(TaskStatus4);
		Assert.assertEquals(taskStatus4,"Completed");
		String taskStatus5=verificationhelper.getText(TaskStatus5);
		Assert.assertEquals(taskStatus5,"Completed");
		String taskStatus6=verificationhelper.getText(TaskStatus6);
		Assert.assertEquals(taskStatus6,"Completed");
		String taskStatus7=verificationhelper.getText(TaskStatus7);
		Assert.assertEquals(taskStatus7,"Completed");
	}
	public void checkCloseTasks_OnlineIntervention() throws IOException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		reusablemethods.takeScreenshot("Tasks/Alltaskscomplete");
		String taskStatus1=verificationhelper.getText(TaskStatus1);
		Assert.assertEquals(taskStatus1,"Completed");
		String taskStatus2=verificationhelper.getText(TaskStatus2);
		String taskStatus3=verificationhelper.getText(TaskStatus3);
		Assert.assertEquals(taskStatus3,"Completed");
		String taskStatus4=verificationhelper.getText(TaskStatus4);
		Assert.assertEquals(taskStatus4,"Completed");
	}
	public void checkCloseTasks_Maintenance() throws IOException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		reusablemethods.takeScreenshot("Tasks/Alltaskscomplete");
		String taskStatus1=verificationhelper.getText(TaskStatus1);
		Assert.assertEquals(taskStatus1,"Completed");
		String taskStatus2=verificationhelper.getText(TaskStatus2);
		Assert.assertEquals(taskStatus2,"Completed");
		String taskStatus3=verificationhelper.getText(TaskStatus3);
		Assert.assertEquals(taskStatus3,"Completed");
		String taskStatus4=verificationhelper.getText(TaskStatus4);
		Assert.assertEquals(taskStatus4,"Completed");
		String taskStatus5=verificationhelper.getText(TaskStatus5);
		Assert.assertEquals(taskStatus5,"Completed");
	}
	public void checkCloseTasks_Maintenance_OnsiteIntervention() throws IOException
	{
		waithelper.waitForframeToBeAvailableAndSwitchToIt(C_Frame, 20);
		reusablemethods.takeScreenshot("Tasks/Alltaskscomplete");
		String taskStatus1=verificationhelper.getText(TaskStatus1);
		Assert.assertEquals(taskStatus1,"Completed");
		String taskStatus2=verificationhelper.getText(TaskStatus2);
		Assert.assertEquals(taskStatus2,"Completed");
		String taskStatus3=verificationhelper.getText(TaskStatus3);
		Assert.assertEquals(taskStatus3,"Completed");
		String taskStatus4=verificationhelper.getText(TaskStatus4);
		Assert.assertEquals(taskStatus4,"Completed");
		String taskStatus5=verificationhelper.getText(TaskStatus5);
		Assert.assertEquals(taskStatus5,"Completed");
		String taskStatus6=verificationhelper.getText(TaskStatus5);
		Assert.assertEquals(taskStatus6,"Completed");
	}
	public void setCurrentDate(WebElement ele) throws InterruptedException
	{
		ele.click();
		String dateFrom=datetimehelper.currentDate();	
		List<WebElement> ls = driver.findElements(By.xpath("//*[@id='controlCalBody']/tr/td/a"));
		System.out.println(ls);
		log.info("################### Start Selecting Date from Date Picker ###################");
		for(WebElement datepick: ls)
		{
			if(datepick.getText().equals(dateFrom))
			{
				datepick.click();
				break;
			}	
			
			log.info("################### End Selecting Date from Date Picker ###################");
		}
	}
	public void setAfterDate(WebElement ele) throws ParseException, InterruptedException
	{
		String tddDate=driver.findElement(By.xpath("//table/tbody/tr/td/div/table/tbody/tr[4]/td[8]")).getText();
		String[] date_td = tddDate.split(" ");
		String on_date = date_td[1];    
		String monthName = date_td[0];
		String Year = date_td[2];   
		System.out.println("MonthName:"+monthName);
		//changing the month from Jan to 01		
		DateTimeFormatter parser = DateTimeFormatter.ofPattern("MMM").withLocale(Locale.ENGLISH);
		TemporalAccessor accessor = parser.parse(monthName);
		int monthNumber = accessor.get(ChronoField.MONTH_OF_YEAR);
		System.out.println("MonthNumber:"+monthNumber); 
		DateFormat dateFormat = new SimpleDateFormat("d");
		Date myDate = dateFormat.parse(on_date);
		// Use the Calendar class to add days either 1 or more number of days
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(myDate);
		
		calendar.add(Calendar.DAY_OF_YEAR, 4);
		
		Date afterDate = calendar.getTime();
		String result = dateFormat.format(afterDate);
		System.out.println("result::"+result);
		//if(result.equals("31"))
		if(result.equals("01"))
		{ 
			if(tddDate.equals("31 Dec 2020"))
			{
				System.out.println("New date:"+result); 
     
				// int Month_diff = monthNumber-1;
				int Month_diff = monthNumber-12;
				System.out.println(Month_diff);
   
				String new_month = new Integer(Month_diff).toString();       
				String new_day = new Integer(result).toString();
				if(new_month.equals("0"))
				{
					new_month = "01";
				}

				int new_year = Integer.parseInt(Year);
				//int Year_diff = new_year-1;
				int Year_diff = new_year+1;
				// System.out.println(Year_diff);
       
				String new_date = new_day + new_month + Year_diff;
				//System.out.println(new_date);
                
				//get current date
				Date date =  new Date();
				SimpleDateFormat nDateFormat = new SimpleDateFormat("dd-MM-YYYY");
				String todayDate = nDateFormat.format(date);
				// System.out.println("Current Date:" +todayDate);
				ele.click();
				Thread.sleep(2000);
				String[] curr_date = todayDate.split("-");
				String curr_mon = curr_date[1];
				//System.out.println(curr_mon);
				int curr_mon1 = Integer.parseInt(curr_mon);
				int target_mon = Integer.parseInt(new_month);
				//System.out.println("Target_month:"+target_mon);
				int mov_month =  target_mon - curr_mon1; 
				//System.out.println("mov_month::"+mov_month);
				//int move_month=Math.abs(mov_month);
				for(int k=0; k<mov_month; k++)
				{         
					driver.findElement(By.xpath(".//*[@id='nextMonth']/a")).click();         
				}
        
				Thread.sleep(2000);
				List<WebElement> columns = driver.findElements(By.xpath("//*[@id='controlCalBody']/tr/td/a"));
				for (WebElement cell: columns) 
				{
					if (cell.getText().equals(result))
					{
						cell.click();
						break;
					}
				}
        
			}
		}
		else
		{         
        //Click and open the calendar
			ele.click();
			Thread.sleep(2000);
       
               
			//get current date
			Date date =  new Date();
			SimpleDateFormat nDateFormat = new SimpleDateFormat("dd-MM-YYYY");
			String todayDate = nDateFormat.format(date);
			System.out.println("Current Date:" +todayDate);      
			String[] curr_date = todayDate.split("-");
			String curr_mon = curr_date[1];
			String curr_year = curr_date[2];
			System.out.println(curr_mon);
			//get month diff
			int curr_mon1 = Integer.parseInt(curr_mon);
			int mon_diff = monthNumber - curr_mon1;
			//int mon_diff = curr_mon1 - monthNumber;
			System.out.println(mon_diff);
			int month_diff=Math.abs(mon_diff);
			System.out.println(month_diff);
			//get year diff
			int curr_year1 = Integer.parseInt(curr_year);
			int target_year = Integer.parseInt(Year);
			int Year_diff = target_year - curr_year1;
			System.out.println(Year_diff);
			//move the calendar to target year
			for(int i=0; i<Year_diff; i++)
			{
				System.out.println("i count:" +i);
				driver.findElement(By.xpath(".//*[@id='nextYear']/a")).click();
			}
			Thread.sleep(2000);
			//move the calendar to target month
			
			for(int j=0;j<month_diff;j++)
			{
				System.out.println("j count:" +j);
				driver.findElement(By.xpath(".//*[@id='nextMonth']/a")).click();
				Thread.sleep(1000);
				System.out.println("J loop ended");
			}
			
			Thread.sleep(2000);
			System.out.println("Click correct date"+result);
			
			List<WebElement> columns = driver.findElements(By.xpath("//*[@id='controlCalBody']/tr/td/a"));
			for (WebElement cell: columns) 
			{
				//System.out.println("For loop started for date");
				if (cell.getText().equals(result))
				{
					
					cell.click();
					//System.out.println("Click date done");
					break;
				}
			}              

		}
	}
	
	public void setAfterDate_New(WebElement ele) throws ParseException, InterruptedException
	{
		String tddDate=driver.findElement(By.xpath("//table/tbody/tr/td/div/table/tbody/tr[4]/td[8]")).getText();
		//String[] dates = {"Jul 24, 2020","Jul 25, 2020", "Feb 29, 2020", 
		//		"Feb 28, 2019","Dec 31, 2020", "Aug 31, 2020"};
		
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
			cal.setTime(sdf.parse(tddDate));
			//System.out.println("///////////" + tddDate);
			log.info(cal.getTime().toString());
			int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
			log.info("Calculated Day of week "+day_of_week);
			if (day_of_week == 7){  		// case of Saturday
				cal.add(Calendar.DATE, 2);
			}else if (day_of_week == 6){    // case of Friday
				cal.add(Calendar.DATE, 3);
			}else{							// case of Sun, Mon, Tue, Wed, Thur
				cal.add(Calendar.DATE, 1);
			}
				
			String date = cal.getTime().toString();
			log.info("Final date selected is "+date);
			//DateFormat originalFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
			String formatedDate = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.YEAR);
			System.out.println("formatedDate : " + formatedDate);    
			ele.sendKeys(formatedDate);
	}
}