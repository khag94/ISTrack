package TestCases;

import java.io.IOException;
import java.util.List;

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

public class ISTrackOnsiteInterventionProcessingAMTestCase extends TestBase {
	public static final Logger log =Logger.getLogger(ISTrackOnsiteInterventionProcessingAMTestCase.class.getName());
	
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
	
	
	public ISTrackOnsiteInterventionProcessingAMTestCase()
	{
		super();
	}
	
	@BeforeClass
	public void Message()
	{
		log.info("IS Track Automated regression on AM Environment started");
	}
	
	@AfterClass
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
		ofpage.assessOnlineInterventionOrder();
		log.info("################### End Assess Order Task ###################");
		
		log.info("################### Start capturing case id ###################");
		ofpage.captureCaseId();
		log.info("################### End Capturing Case Id ###################");
		
		log.info("################### Start Searching order in All Works ###################");
		allworkpage.orderSearchAllWork();
		log.info("################### End Searching order in All Works ###################");
		
		log.info("################### Start Searching order in My Works ###################");
		myworkpage.orderSearchMyWork();
		log.info("################### End Searching order in My Works ###################");
		
		log.info("################### Start Capturing Task Names in My Works ###################");
		myworkpage.captureTaskNamesAndSelectCheckBoxOnsiteIntervention();
		log.info("################### End Capturing Task Names in My Works ###################");
		
		log.info("################### Start Re-assigning user ###################");
		myworkpage.reassignTask();
		log.info("################### End Re-assigning user ###################");
		
		log.info("################### Start Single click check on New Order click ###################");
		myworkpage.singleClickCheck_ValidateOrder();
		log.info("################### End Single click check on New Order click ###################");
		
		log.info("################### Start Validate Order ###################");
		taskcompletionpage.validateOnlineIntervention();
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
	public void taskCompletionByProcurementUserISTrack() throws InvalidFormatException, IOException, Throwable
	{
		log.info("################### Start login in IS Track Application as Procurement User ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack1"), prop.getProperty("password_ISTrack"));
		log.info("################### End login in IS Track Application ###################");
		
		//log.info("######################### Start Searching Order in All Works ############################");
		//allworkpage.orderSearchAllWork();
		//log.info("######################### End Searching Order in All Works ############################");
		
		log.info("######################### Start Searching Order in My Works ############################");
		//myworkpage.caseSearchMyWork();
		taskcompletionpage.searchCase();
		log.info("######################### End Searching Order in My Works ############################");
		
		log.info("######################### Start Completing Online Intervention task ####################");
		taskcompletionpage.onsiteIntervention();
		log.info("######################### End Completing Online Intervention task ####################");
		
		myworkpage.logOff();
	}
	
	@Test(priority=4)
	public void acceptanceISByOdmUserISTrack() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{
		log.info("################### Start login in IS Track Application as ODM User ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack"), prop.getProperty("password_ISTrack"));
		log.info("###################  End login in IS Track Application ###################");
		
		log.info("######################### Start Searching Order ############################");
		taskcompletionpage.searchCase();
		log.info("######################### End Searching Order ############################");
		
		log.info("######################### Start Completing acceptanceIS task ####################");
		taskcompletionpage.acceptanceIS();
		log.info("######################### End Completing acceptanceIS task ####################");
	}
	
	@Test(priority=5)
	public void checkRFS_RFBInGold() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
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
	}
	
	@Test(priority=6)
	public void billingSupervisorISTrack() throws InvalidFormatException, IOException, Throwable
	{
		log.info("################### Start login in IS Track Application as Billing Supervisor ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack2"), prop.getProperty("password_ISTrack"));
		log.info("################### End login in IS Track Application as Billing Supervisor ###################");
	
		log.info("################## Billing Supervisor starts assigning order to Billing User1 ####################");
		mygrouppage.goldOrderSearchMyGroup();
		mygrouppage.assign();
		log.info("################## Billing Supervisor ends assigning order to Billing User1 ####################");
		
		myworkpage.logOff();
	}
	
/*	@Test(priority=6)
	public void billingUser1() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException
	{
		istrackloginpage.Login(prop.getProperty("username_ISTrack3"), prop.getProperty("password_ISTrack"));
		billinguserpage.searchOrder();
		log.info("################## Start completing Billing ERS task  ####################");
		billinguserpage.billingIS();
		log.info("################## End completing Billing ERS task  ####################");
		
		myworkpage.logOff();
	}
	
	@Test(priority=7)
	public void checkCompletedTasks() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		istrackloginpage.Login(prop.getProperty("username_ISTrack"), prop.getProperty("password_ISTrack"));
		taskcompletionpage.searchCase();
		taskcompletionpage.checkCloseTasks_OnlineIntervention();
		myworkpage.logOff();
	}	*/
	
	@Test(priority=7)
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

