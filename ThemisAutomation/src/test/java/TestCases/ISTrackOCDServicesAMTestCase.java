package TestCases;

import java.io.IOException;
import java.text.ParseException;
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

public class ISTrackOCDServicesAMTestCase extends TestBase {
	
	public static final Logger log = Logger.getLogger(ISTrackOCDServicesAMTestCase.class.getName());
	
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
	GuardianHomePage guardianhomepage;
	GuardianLoginPage  guardianloginpage;
	AutoGenerateMail autogeneratemail;
	OTPage otpage;
	
	
	public ISTrackOCDServicesAMTestCase()
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
		guardianhomepage = new GuardianHomePage();
		guardianloginpage = new GuardianLoginPage();
		autogeneratemail = new AutoGenerateMail();
		otpage = new OTPage();
		
	}
	
	@Test(priority=1)
	public void newCaseGeneration() throws Throwable
	{
		log.info("################ Start Login to IS Track Application (Priority 1) ################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack"), prop.getProperty("password_ISTrack"));
		log.info("################ End Login to IS Track Application ################");
		
		log.info("################ Start New Case Creation ################");
		createcasepage.createNewCase();
		log.info("################ End New Case Creation ################");
		
		log.info("################ Start GOLD Order Search ################");
		createcasepage.searchGoldOrder();
		log.info("################ End GOLD Order Search ################");
		
		log.info("################ Start verifying GOLD USID ################");
		createcasepage.verifyData();
		log.info("################ End verifying GOLD USID ################");
		
		log.info("################### Start Checking Pricing details coming from GOLD ###################");
		createcasepage.checkPricingDetails();
		log.info("################### End Checking Pricing details coming from GOLD ###################");
		
		createcasepage.createButtonClick();
		log.info("################ Clicked on Create button ################");
		
		log.info("################### Start Opening Case number ###################");
		orpage.openCaseNumber();
		log.info("################### End Opening Case number ###################");
		
		log.info("################### Start Assess Order Task ###################");
		ofpage.assessOCDServices();
		log.info("################### End Assess Order Task ###################");
		
		log.info("################### Start capturing case id ###################");
		ofpage.captureCaseId();
		log.info("################### End capturing case id ###################");
		
		log.info("################### Start Searching order in All Works ###################");
		allworkpage.orderSearchAllWork();
		log.info("################### End Searching order in All Works ###################");
		
		log.info("################### Start Capturing Task Names in All Works ###################");
		//allworkpage.captureTaskNames_OCDServices();
		log.info("################### End Capturing Task Names in All Works ###################");
		
		log.info("################### Start Searching order in My Works ###################");
		myworkpage.orderSearchMyWork();
		log.info("################### End Searching order in My Works ###################");
		
		log.info("################### Start Capturing Task Names in My Works ###################");
		myworkpage.captureTaskNamesOCDServicesAndSelectCheckBox();
		log.info("################### End Capturing Task Names in My Works ###################");
		
		log.info("################### Start Re-assigning user ###################");
		myworkpage.reassignTask();
		log.info("################### End Re-assigning user ###################");
		
		log.info("################### Start Single click check on New Order click ###################");
		myworkpage.singleClickCheck_ValidateOrder();
		log.info("################### End Single click check on New Order click ###################");
		
		log.info("################### Start Validate Order ###################");
		taskcompletionpage.validateOCDOrder();
		log.info("################### End Validate Order ###################");
		
		myworkpage.logOff();
		
	}
	
	
	@Test(priority=2)
	public void taskCompletion() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		log.info("################ Start Login to IS Track Application (Priority 2) ################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack1"), prop.getProperty("password_ISTrack"));
		log.info("################ End Login to IS Track Application ################");
		
		taskcompletionpage.searchCase();
		taskcompletionpage.serviceProcurementOCD();
		
		myworkpage.logOff();
		
	}
	
	@Test(priority=3)
	public void acceptanceIS() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		log.info("################ Start Login to IS Track Application (Priority 3) ################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack"), prop.getProperty("password_ISTrack"));
		log.info("################ End Login to IS Track Application ################");
		
		taskcompletionpage.searchCase();
		taskcompletionpage.acceptanceIS();
		myworkpage.logOff();
	}	

	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}
