package TestCases;
 
import java.io.IOException;
 
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
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
 
public class ScopeVendorBrandedServicesWelcomeLetter extends TestBase {
               
	public static final Logger log =Logger.getLogger(ScopeVendorBrandedServicesWelcomeLetter.class.getName());
    
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
               
               
    public ScopeVendorBrandedServicesWelcomeLetter()
    {
    	super();
    }
    
    @BeforeTest
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
    	ofpage.assessOrderVendorWelcome();
    	log.info("################### Start Assess Order Task ###################");
    	
    	log.info("################### Start capturing case id ###################");
    	ofpage.captureCaseId();
    	log.info("################### End capturing case id ###################");
    	
    	log.info("################### Start Searching order in All Works ###################");                                
    	allworkpage.orderSearchAllWork();                                
    	log.info("################### End Searching order in All Works ###################");
    	
    	log.info("################### Start Searching order in My Works ###################");                       
    	myworkpage.orderSearchMyWork();
    	log.info("################### End Searching order in My Works ###################");
                               
    	log.info("################### Start Capturing Task Names in My Works ###################");                               
    	myworkpage.captureTaskNamesAndSelectCheckBoxVBS_WL();                              
    	log.info("################### End Capturing Task Names in My Works ###################");
                              
    	log.info("################### Start Re-assigning user ###################");                             
    	myworkpage.reassignTask();                               
    	log.info("################### End Re-assigning user ###################");
                               
    	log.info("################### Start capturing column names and count in My Work ###################");                                
    	myworkpage.checkColumnNamesAndCount();                               
    	log.info("################### End capturing column names and count in My Work ###################");
    	
    	log.info("################### Start Single click check on New Order click ###################");
    	myworkpage.singleClickCheck_ValidateOrder();
    	log.info("################### End Single click check on New Order click ###################");
    	
    	log.info("################### Start Validate Order ###################");
    	taskcompletionpage.validateOrderVendorWelcome();
    	log.info("################### End Validate Order ###################");
    	
    	myworkpage.logOff();
  
    }
    
    @Test(priority=2)     
    public void taskCompletionByProcurementUserISTrack() throws InvalidFormatException, IOException, Throwable    
    {    	
    	log.info("################### Start login in IS Track Application as Procurement User ###################");
		istrackloginpage.Login(prop.getProperty("username_ISTrack1"), prop.getProperty("password_ISTrack"));
		log.info("################### End login in IS Track Application ###################");
    	
    	log.info("################### Start Searching Case ###################");
    	taskcompletionpage.searchCase();
    	log.info("################### End Searching Case ###################");
    	
    	log.info("################### Starting Completion of Service Procurement Task ###################");
    	taskcompletionpage.serviceProcurement();
    	log.info("################### End Completion of Service Procurement Task ###################");
    	
    	log.info("################### Start Searching Case ###################");
    	taskcompletionpage.searchCase();
    	log.info("################### End Searching Case ###################");
    	
    	log.info("################### Starting Completion Track Supplier Delivery SP Task ###################");
    	taskcompletionpage.trackSupplierDeliverySP(); 
    	log.info("################### End Completion Track Supplier Delivery SP Task ###################");
    	
    	log.info("################### Start Searching Case ###################");
    	taskcompletionpage.searchCase(); 
    	log.info("################### End Searching Case ###################");
    	
    	log.info("################### Starting Completion Welcome Letter Task ###################");
    	taskcompletionpage.WelcomeLetter(); 
    	log.info("################### End Completion Welcome Letter Task ###################");
    	myworkpage.logOffSRT();              
                
    }
                
    @Test(priority=3) 
    public void taskCompletionODMUserISTrack() throws InvalidFormatException, IOException, Throwable     
    {   
    	log.info("################### Start login in IS Track Application as ODM User ###################");
    	istrackloginpage.Login(prop.getProperty("username_ISTrack"), prop.getProperty("password_ISTrack"));
    	log.info("################### End login in IS Track Application ###################");
    	
    	log.info("################### Start Searching Case ###################");
    	taskcompletionpage.searchCase();
    	log.info("################### End Searching Case ###################");
    	
    	log.info("################### Starting Completion Acceptance ERS Task ###################");
    	taskcompletionpage.acceptanceERS();
    	log.info("################### End Completion Acceptance ERS Task ###################");
    	
    }
    
    @AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}