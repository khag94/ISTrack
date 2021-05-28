package TestCases;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.AfterClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import themis.Pages.AllWorkPage;
import themis.Pages.BillingUserPage;
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
import themis.Pages.TaskCompletionPage;
import themis.TestBase.TestBase;
import themis.Util.AutoGenerateMail;
import themis.Util.WaitHelper;

public class ISTrackOrderProcessingAMTestCase extends TestBase {
	public static final Logger log =Logger.getLogger(ISTrackOrderProcessingAMTestCase.class.getName());
	
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
	BillingUserPage billinguserpage;
	GuardianHomePage guardianhomepage;
	GuardianLoginPage guardianloginpage;
	AutoGenerateMail autogeneratemail;
	OTPage otpage;
	
	public ISTrackOrderProcessingAMTestCase()
	{
		super();
	}
	
	@BeforeClass
	//@BeforeSuite
	public void Message()
	{
		log.info("IS Track Automated regression on AM Environment started");
	}
	@AfterClass
	//@AfterSuite
	public void automaticReport() throws AddressException, InvalidFormatException, InterruptedException, IOException, MessagingException
	{
		autogeneratemail.GenerateMail();
		driver.quit();
	}
	@BeforeMethod
	
	public void Init() throws InterruptedException
	{
		initialization();
		istrackloginpage = new ISTrackLoginPage();
		createcasepage = new CreateCasePage();
		orpage = new ORPage();
		ofpage = new OFPage();
		allworkpage = new AllWorkPage();
		myworkpage = new MyWorkPage();
		taskcompletionpage = new TaskCompletionPage();
		mygrouppage = new MyGroupPage();
		goldorderpage = new GoldOrderPage();
		goldorderstatuscheckpage = new GoldOrderStatusCheckPage();
		otpage= new OTPage();
		guardianhomepage = new GuardianHomePage();
		guardianloginpage = new GuardianLoginPage();
		billinguserpage = new BillingUserPage();
		//jiraissue = new JiraIssue(Constants.JIRA_URL, Constants.JIRA_USERNAME, Constants.JIRA_PASSWORD, Constants.JIRA_PROJECT);;
		
	}

	@Test(priority=1)
	public void newCaseGenerationISTrack() throws Throwable
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
		ofpage.assessOrder();
		log.info("################### End Assess Order Task ###################"); 
		
		log.info("################### Start capturing case id ###################"); 
		ofpage.captureCaseId();
		log.info("################### End Capturing Case Id ###################");
		
		log.info("################### Start Searching order in All Works ###################");
		allworkpage.orderSearchAllWork();
		log.info("################### End Searching order in All Works ###################");
		
		log.info("################### Start Capturing Task Names in All Works ###################");
		allworkpage.checkColumnNamesAndCount_new();
		allworkpage.compareColumnNames_odmuser_new();
		log.info("################### End Capturing Task Names in My Works ###################");
		
		log.info("################### Start Capturing Task Names in All Works ###################");
		allworkpage.captureTaskNames();
		log.info("################### End Capturing Task Names in All Works ###################");
		
		log.info("################### Start Searching order in My Works ###################");
		myworkpage.orderSearchMyWork();
		log.info("################### End Searching order in My Works ###################");
		
		log.info("################### Start Capturing Task Names in My Works ###################");
		myworkpage.captureTaskNamesAndSelectCheckbox();
		log.info("################### End Capturing Task Names in My Works ###################");
		
		log.info("################### Start Re-assigning user ###################");
		myworkpage.reassignTask();
		log.info("################### End Re-assigning user ###################"); 
		
		log.info("################### Start capturing column names and count in My work ###################");
		myworkpage.checkColumnNamesAndCount();
		myworkpage.compareColumnNames_odmuser();
		log.info("################### End capturing column names and count in My Work ###################");
		

		log.info("################### Start Single click check on New Order click ###################");
		myworkpage.singleClickCheck_ValidateOrder();
		log.info("################### End Single click check on New Order click ###################");
		
		log.info("################### Start Validate Order ###################");
		taskcompletionpage.validateOrder();
		log.info("################### End Validate Order ###################");
		myworkpage.logOff();
	}
	
	@Test(priority=2)
	public void checkManageStatusInGold() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		log.info("################### Start login in Guardian Application ###################");
		guardianloginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("################### End login in Guardian Application ###################");
		
		log.info("################### Start launching GOLD UAT ###################");
		guardianhomepage.launch_ApplicationFromGuardian(guardianhomepage.GoldUAT);
		log.info("################### End launching GOLD UAT ###################");
		
		log.info("################### Start searching GOLD order ###################");
		goldorderpage.searchOrderForStatus();
		log.info("################### End searching GOLD order ###################");
		
		log.info("################### Start checking GOLD order Manage status  ###################");
		goldorderstatuscheckpage.statusCheck("Manage");
		log.info("################### End checking GOLD order Manage status  ###################");
		
		goldorderstatuscheckpage.checkTOS_APD();
		goldorderstatuscheckpage.checkReviseTDD();
	}	
	
	@Test(priority=3)
	public void rejectByProcurementUser() throws InvalidFormatException, IOException, Throwable
	{
		log.info("################### Start login in IS Track Application ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack1"), prop.getProperty("password_ISTrack"));
		log.info("################### End login in IS Track Application ###################");
		
		log.info("####################### Start searching Gold Order in All Works ########################");
		allworkpage.orderSearchAllWork();
		log.info("####################### End searching Gold order in All Works ###########################");
		
		log.info("################### Start capturing column names and count in All Work ###################");
		allworkpage.checkColumnNamesAndCount();
		allworkpage.compareColumnNames_ProcurementUser();
		log.info("################### End capturing column names and count in All Work ###################");
		
		log.info("####################### Start searching case in My Works ########################");
		myworkpage.caseSearchMyWork();
		log.info("####################### End searching case in My Works ########################");
		
		log.info("################### Start capturing column names and count in My work ###################");
		myworkpage.checkColumnNamesAndCount();
		myworkpage.compareColumnNames_ProcurementUser();
		log.info("################### End capturing column names and count in My work ###################");
		
	/*	log.info("####################### Start searching & rejecting Equipment Procurement in My Works ########################");
		taskcompletionpage.searchCase();
		taskcompletionpage.rejectEquipmentProcurement();
		log.info("####################### End searching & rejecting Equipment Procurement in My Works ########################");	*/
		
		myworkpage.logOff();
		
	}
	
	@Test(priority=4)
	public void taskCompletionByProcurementUserISTrack() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException, ParseException
	{
	/*	log.info("################### Start login in IS Track Application as OQM User ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack4"), prop.getProperty("password_ISTrack"));
		log.info("################### End login in IS Track Application as OQM User ###################");
		
		log.info("####################### Start searching case ########################");
		taskcompletionpage.searchCase();
		log.info("####################### End searching case ########################");
		
		log.info("################### Starting reject resolved process by OQMUser ###################");
		mygrouppage.equipmentProcurement();
		log.info("################### Reject resolved done by OQMUser ###################");
		myworkpage.logOff();	*/
		
		log.info("################### Start login in IS Track Application as Procurement User ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack1"), prop.getProperty("password_ISTrack"));
		log.info("################### End login in IS Track Application ###################");
		
		log.info("################### Starting Completion of Equipment Procurement Task ###################");
		taskcompletionpage.searchCase();
		taskcompletionpage.equipmentProcurement();
		log.info("################### End Completion of Equipment Procurement Task ###################");
		
		log.info("################### Starting Completion of Track Supplier Delivery(EP) Task ###################");
		taskcompletionpage.searchCase();
		taskcompletionpage.trackSupplierDelivery();
		log.info("################### End Completion of Track Supplier Delivery(EP) Task ###################");
		
		log.info("################### Starting Completion of WareHouse Staging Task ###################");
		taskcompletionpage.searchCase();
		taskcompletionpage.warehouseStaging();
		log.info("################### End Completion of WareHouse Staging Task ###################");
		
		log.info("################### Starting Completion of Track WareHouse Delivery Task ###################");
		taskcompletionpage.searchCase();
		taskcompletionpage.trackWarehouseDelivery();
		log.info("################### End Completion of Track WareHouse Delivery Task ###################");
		
		myworkpage.logOff();
		
	}
	
	@Test(priority=5)
	public void acceptanceERSByOdmUserISTrack() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		log.info("################### Start login in IS Track Application as ODM User ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack"), prop.getProperty("password_ISTrack"));
		log.info("###################  End login in IS Track Application ###################");
			
		taskcompletionpage.searchCase();
			
		log.info("################### Starting Completion of Acceptance ERS Task ###################");
		taskcompletionpage.acceptanceERS();
		log.info("################### Starting Completion of Track Acceptance ERS Task ###################");
			
		myworkpage.logOff();
	}
		
	

	
	@Test(priority=6)
	public void checkRFS_RFBAndSRTMessageCheck() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{
		log.info("################### Start login in Guardian Application ###################");
		guardianloginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("################### End login in Guardian Application ###################");
		
		log.info("################### Start launching GOLD UAT ###################");
		guardianhomepage.launch_ApplicationFromGuardian(guardianhomepage.GoldUAT);
		log.info("################### End launching GOLD UAT ###################");
		
		log.info("################### Start searching GOLD Order ###################");
		goldorderpage.searchOrderForStatus();
		log.info("################### End searching GOLD Order ###################");
		
		log.info("################### Start cheking RFS & RFB ###################");
		goldorderstatuscheckpage.checkRFS_RFB();
		log.info("################### End cheking RFS & RFB ###################");
		//guardianhomepage.launch_ApplicationFromGuardian(guardianhomepage.OT);
		//Thread.sleep(10000);
		//otpage.checkMessage();
	}
	
	@Test(priority=7)
	public void billingSupervisorISTrack() throws InvalidFormatException, IOException, Throwable
	{
		log.info("################### Start login in IS Track Application as Billing Supervisor ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack2"), prop.getProperty("password_ISTrack"));
		log.info("################### End login in IS Track Application ###################");
		
		log.info("################### Start capturing column names and count in My work ###################");
		mygrouppage.checkColumnNamesAndCount_MyWork();
		myworkpage.compareColumnNames_BillingSupervisor();
		log.info("################### End capturing column names and count in My work ###################");
		
		mygrouppage.goldOrderSearchMyGroup();
		
		log.info("################### Start capturing column names and count in My Group ###################");
		mygrouppage.checkColumnNamesAndCount_MyGroup();
		mygrouppage.compareColumnNamesMyGroup_BillingSupervisor();
		log.info("################### End capturing column names and count in My Group ###################");
		
		log.info("################### Start assigning task to Billing User ###################");
		mygrouppage.assign();
		log.info("################### End assigning task ###################");
		
		myworkpage.logOff();
	}
	
	//@Test(priority=10,dependsOnMethods="billingAssignment")
/*	@Test(priority=8)
	public void billingUser1() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{
		istrackloginpage.Login(prop.getProperty("username_ISTrack3"), prop.getProperty("password_ISTrack"));
		billinguserpage.searchOrder();
		//myworkpage.compareColumnNamesMyWork_BillingUser1();
		billinguserpage.billingERS();
		myworkpage.logOff();
	}
	
	@Test(priority=9)
	//@Test(priority=11,dependsOnMethods="billingERS")
	public void checkCompletedTasks() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		istrackloginpage.Login(prop.getProperty("username_ISTrack"), prop.getProperty("password_ISTrack"));
		taskcompletionpage.searchCase();
		taskcompletionpage.checkCloseTasks();
		myworkpage.logOff();
	}	*/
	
	
	@Test(priority=8)
		public void checkGoldOrderAcceptanceStatus() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
		{
			log.info("################### Start login in Guardian Application ###################");
			guardianloginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
			log.info("################### End login in Guardian Application ###################");
			
			log.info("################### Start launching GOLD UAT ###################");
			guardianhomepage.launch_ApplicationFromGuardian(guardianhomepage.GoldUAT);
			log.info("################### End launching GOLD UAT ###################");
			
			log.info("################### Start searching Order and checking status ###################");
			goldorderpage.searchOrderForStatus();
			goldorderstatuscheckpage.statusCheck("Acceptance");
			goldorderstatuscheckpage.approveAcceptance();
			log.info("################### End searching Order and checking status ###################");
		}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

