package TestCases;

import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import themis.Pages.AllWorkPage;
import themis.Pages.CreateCasePage;
import themis.Pages.GoldOrderPage;
import themis.Pages.GoldOrderStatusCheckPage;
import themis.Pages.GuardianHomePage;
import themis.Pages.GuardianLoginPage;
import themis.Pages.ISTrackLoginPage;
import themis.Pages.MyGroupPage;
import themis.Pages.MyWorkPage;
import themis.Pages.OFPage;
import themis.Pages.ORPage;
import themis.Pages.OTPage;
import themis.Pages.POCMUser1Page;
import themis.Pages.TaskCompletionPage;
import themis.TestBase.TestBase;
import themis.Util.AutoGenerateMail;
import themis.Util.WaitHelper;

public class ISTrackEAMManagedWithoutCheckBoxAMTestCase extends TestBase{
	
	public static final Logger log = Logger.getLogger(ISTrackEAMManagedWithCheckBoxAMTestCase.class.getName());
	
	ISTrackLoginPage istrackloginpage;
	CreateCasePage createcasepage;
	ORPage orpage;
	OFPage ofpage;
	AllWorkPage allworkpage;
	MyWorkPage myworkpage;
	TaskCompletionPage taskcompletionpage;
	GoldOrderStatusCheckPage goldorderstatuscheckpage;
	GoldOrderPage goldorderpage;
	MyGroupPage mygrouppage;
	POCMUser1Page pocmuser1page;
	GuardianHomePage guardianhomepage;
	GuardianLoginPage  guardianloginpage;
	AutoGenerateMail autogeneratemail;
	OTPage otpage;
	WaitHelper waithelper;

	
	
	public ISTrackEAMManagedWithoutCheckBoxAMTestCase()
	{
		super();
	}
	
	@BeforeClass
	public void Message()
	{
		log.info("ISTrack Automated Regression on AM Environment Started");
	}
	
	@AfterClass
	public void AutomaticReport() throws AddressException, InvalidFormatException, InterruptedException, IOException, MessagingException
	{
		autogeneratemail.GenerateMail();
		driver.quit();
	
	}
	
	@BeforeMethod
	public void init() throws InterruptedException
	{
		initialization();
		istrackloginpage = new ISTrackLoginPage ();
		createcasepage = new CreateCasePage();
		orpage = new ORPage();
		ofpage = new OFPage();
		allworkpage = new AllWorkPage();
		myworkpage = new MyWorkPage();
		taskcompletionpage = new TaskCompletionPage();
		goldorderstatuscheckpage = new GoldOrderStatusCheckPage();
		goldorderpage = new GoldOrderPage();
		mygrouppage = new MyGroupPage();
		pocmuser1page =  new POCMUser1Page();
		guardianhomepage = new GuardianHomePage();
		guardianloginpage = new GuardianLoginPage();
		autogeneratemail = new AutoGenerateMail();
		otpage = new OTPage();
		waithelper = new WaitHelper();
	}

	
	@Test(priority=1)
	public void newCaseGeneration() throws Throwable
	{
		log.info("################### Start login in IS Track Application ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack"), prop.getProperty("password_ISTrack"));
		log.info("################### End login in IS Track Application ###################");
		
		log.info("################### Start new case creation ###################");
		createcasepage.createNewCase();
		log.info("################### End new case creation ###################");
		
		log.info("################### Start searching Gold Order ###################");
		createcasepage.searchGoldOrder();
		log.info("################### End searching Gold Order ###################");
		
		log.info("################### Start verifying Gold USID ###################");
		createcasepage.verifyData();
		log.info("################### End verifying Gold USID ###################");
		
		log.info("################### Start Checking Pricing details coming from Gold ###################");
		createcasepage.checkPricingDetails();
		log.info("################### End Checking Pricing details coming from Gold ###################");
		
		createcasepage.createButtonClick();
		
		log.info("################### Start Opening Case number ###################");
		orpage.openCaseNumber();
		log.info("################### End Opening Case number ###################");
		
		log.info("################### Start Assess Order Task ###################");
		ofpage.assessEAMManagedWithoutCheckBox();
		log.info("################### End Assess Order Task ###################"); 
		
		log.info("################### Start capturing case id ###################"); 
		ofpage.captureCaseId();
		log.info("################### End Capturing Case Id ###################");
		
		log.info("################### Start Searching order in All Works ###################");
		allworkpage.orderSearchAllWork();
		log.info("################### End Searching order in All Works ###################");
		
		log.info("################### Start Capturing Task Names in All Works ###################");
		//allworkpage.captureTaskNames();
		log.info("################### End Capturing Task Names in All Works ###################");
		
		log.info("################### Start Searching order in My Works ###################");
		myworkpage.orderSearchMyWork();
		log.info("################### End Searching order in My Works ###################");
		
		log.info("################### Start Capturing Task Names in My Works ###################");
		myworkpage.captureTaskNamesEAMManagedWithoutCheckBoxAndSelectCheckBox();
		log.info("################### End Capturing Task Names in My Works ###################");
		
		log.info("################### Start Re-assigning user ###################");
		myworkpage.reassignTask();
		log.info("################### End Re-assigning user ###################");
		
		log.info("################### Start Single click check on New Order click ###################");
		myworkpage.singleClickCheck_ValidateOrder();
		log.info("################### End Single click check on New Order click ###################");
		log.info("################### Start Validate Order ###################");
		taskcompletionpage.validateEAMManaged();
		log.info("################### End Validate Order ###################");
		myworkpage.logOff();
		
		
	}
	@Test(priority=2)
	public void taskCompletionByProcurementUser() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, ParseException
	{
		log.info("################### Start login in IS Track Application as Procurement User ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack1"), prop.getProperty("password_ISTrack"));
		log.info("################### End login in IS Track Application ###################");
		
		log.info("################### Starting Completion of Service Procurement Task ###################");
		taskcompletionpage.searchCase();
		taskcompletionpage.serviceProcurement();
		log.info("################### End Completion of Service Procurement Task ###################");
		
		log.info("################### Starting Completion of Equipment Procurement Task ###################");
		taskcompletionpage.searchCase();
		taskcompletionpage.equipmentProcurement();
		log.info("################### End Completion of Equipment Procurement Task ###################");
		
		log.info("################### Starting Completion of Track Supplier Delivery(EP) Task ###################");
		taskcompletionpage.searchCase();
		taskcompletionpage.trackSupplierDeliveryEPIndirect();
		log.info("################### End Completion of Track Supplier Delivery(EP) Task ###################");
		
		log.info("################### Starting Completion of Track Supplier Delivery(SP) Task ###################");
		taskcompletionpage.searchCase();
		taskcompletionpage.trackSupplierDeliverySP();
		log.info("################### End Completion of Track Supplier Delivery(SP) Task ###################");
		
		log.info("################### Starting Completion of Contract Upload Task ###################");
		taskcompletionpage.searchCase();
		taskcompletionpage.ContractUploadODMUser();
		log.info("################### End Completion of Contract Upload Task ###################");
	}
	
	
	@Test(priority=3)
	public void pocmSupervisor() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		log.info("################### Start login in IS Track Application as POCMSupervisor ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack7"), prop.getProperty("password_ISTrack"));
		log.info("################### End login in IS Track Application ###################");
		
		mygrouppage.goldOrderSearchMyGroup();
		mygrouppage.assigntoPOCMUser1();
		myworkpage.logOff();
	}
	
	
	@Test(priority=4)
	public void pocmUser1() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{
		log.info("################### Start login in IS Track Application as POCMUser1 ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack8"), prop.getProperty("password_ISTrack"));
		log.info("################### End login in IS Track Application ###################");
		
		pocmuser1page.searchOrder();
		pocmuser1page.contractUpload();
		
		myworkpage.logOff();
	}
	
	
	@Test(priority=5)
	public void acceptanceIS() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		log.info("################### Start login in IS Track Application ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack"), prop.getProperty("password_ISTrack"));
		log.info("################### End login in IS Track Application ###################");
		
		taskcompletionpage.searchCase();
		taskcompletionpage.acceptanceIS();
		
		taskcompletionpage.searchCase();
		Thread.sleep(10000);
		myworkpage.logOff();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
