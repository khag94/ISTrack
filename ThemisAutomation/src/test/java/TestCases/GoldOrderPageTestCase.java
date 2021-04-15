package TestCases;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import themis.Pages.GoldOrderPage;
import themis.Pages.GoldOrderPricingPage;
import themis.Pages.GoldServiceBuildPage;
import themis.Pages.GuardianHomePage;
import themis.Pages.GuardianLoginPage;
import themis.TestBase.TestBase;
import themis.Util.ExcelHelper;
public class GoldOrderPageTestCase extends TestBase {
	
	public static final Logger log =Logger.getLogger(GoldOrderPageTestCase.class.getName());
	GuardianHomePage guardianhomepage;
	GuardianLoginPage guardianloginpage;
	GoldOrderPage goldorderpage;
	GoldServiceBuildPage goldservicebuildpage;
	GoldOrderPricingPage goldorderpricingpage;
	String ExcelPath=System.getProperty("user.dir")+"/src/main/java/themis/Data/GoldThemis.xlsx";
	String SheetName="Sheet1";
	String SheetName1="Sheet2";
	
	
	public GoldOrderPageTestCase()
	{
		super();
	}
	
	@BeforeTest
	public void Init() throws InterruptedException
	{
		
		//initialization();
		guardianloginpage=new GuardianLoginPage();
		guardianhomepage=new GuardianHomePage();
		goldorderpage=new GoldOrderPage();
		goldservicebuildpage = new GoldServiceBuildPage();
		goldorderpricingpage = new GoldOrderPricingPage();
		guardianhomepage.launch_ApplicationFromGuardian(guardianhomepage.GoldUAT);
		
	}
	
	@DataProvider
	public Object[][] ExcelRead(){
		Object data[][] = ExcelHelper.getTestDataExcel(ExcelPath,SheetName);
		return data;
	}	
	
	/*@Test(priority=1)
	public void launchfortesting() throws InterruptedException
	{
		
			guardianhomepage.launch_ApplicationFromGuardian(guardianhomepage.GOLDProd);
			
	}*/

	@Test(priority=2)
	public void clickOnOrdersLink() throws InterruptedException 
	{
		
		log.info("################### Start click on Orders Link ###################");
		goldorderpage.goldOrderLinkClick();
		log.info("################### End click on Orders Link ###################");
	}

	@Test(priority=3,dependsOnMethods="clickOnOrdersLink",dataProvider="ExcelRead")
	public void createGoldOrder(String CustomerNumber,String Contract,String ServiceContact,String CATFLag)
			throws InterruptedException
, EncryptedDocumentException, InvalidFormatException, IOException
	{
		log.info("################### Start click on CreateOrder and then New Link ###################");
		goldorderpage.createOrderClick();
		log.info("################### End click on CreateOrder and then New Link ###################");
		
		log.info("################### Start Selecting Contracting Party ###################");
		goldorderpage.selectContractingParty(CustomerNumber);
		log.info("################### End Selecting Contracting Party ###################");
		
		log.info("################### Start Selecting Contract ###################");
		goldorderpage.selectContract(Contract);
		log.info("################### End Selecting Contract ###################");
		
		log.info("################### Start Selecting Service Acceptance ###################");
		goldorderpage.selectServiceAcceptance(ServiceContact);
		log.info("################### End Selecting Service Acceptance ###################");
		
		log.info("################### Start Entering Order Term ###################");
		goldorderpage.orderTerm();
		log.info("################### End Entering Order Term ###################");
		
		log.info("################### Start Entering Comments ###################");
		goldorderpage.comments();
		log.info("################### End Entering Comments ###################");
		
		log.info("################### Start Selecting Site Survey ###################");
		goldorderpage.siteSurvey();
		log.info("################### End Selecting Site Survey ###################");
		
		log.info("################### Start Selecting EarlyDelivery ###################");
		goldorderpage.requestEarlyDelivery();
		log.info("################### End Selecting EarlyDelivery ###################");
		
		log.info("################### Start Selecting Non Quoto Reason ###################");
		goldorderpage.nonQuotoReason();
		log.info("################### End Selecting Non Quoto Reason ###################");
		
		log.info("################### Start Selecting Sales Compaign ###################");
		goldorderpage.salesCompaign();
		log.info("################### End Selecting Sales Compaign ###################");
		
		log.info("################### Start Selecting Billing Profile ###################");
		goldorderpage.selectBillingProfile();
		log.info("################### End Selecting Billing Profile ###################");
		
		log.info("################### Start Selecting Local Site ###################");
		goldorderpage.selectLocalsite();
		log.info("################### End Selecting Local Site ###################");
		
		log.info("################### Start Entering Reference Number ###################");
		goldorderpage.setRefNumber();
		log.info("################### End Entering Reference Number ###################");
		
		log.info("################### Start Entering RFB ###################");
		goldorderpage.setRfb();
		log.info("################### End Entering RFB ###################");
		
		log.info("################### Start Entering Requested Delivery Date ###################");
		goldorderpage.clickRDD();
		goldorderpage.setCurrentDate();
		log.info("################### End Entering Requested Delivery Date ###################");
		
		log.info("################### Start Selecting Product Service ###################");
		goldorderpage.selectProduct();
		log.info("################### End Selecting Product Service ###################");
		
		log.info("################### Start Selecting Lead Time Basis ###################");
		goldorderpage.selectLeadTimeBasis();
		log.info("################### End Selecting Lead Time Basis ###################");
		
		log.info("################### Start Selecting Installation Preferences ###################");
		goldorderpage.selectInstallationPreferences();
		log.info("################### End Selecting Installation Preferences ###################");
	
		log.info("################### Start click on ServiceBuild Link ###################");
		goldservicebuildpage.ServiceBuildLink();
		log.info("################### End click on ServiceBuild Link ###################");
			
		log.info("################### Start click on Select GoldUSID Link ###################");
		goldservicebuildpage.selectGoldUSID();
		log.info("################### End click on Select GoldUSID Link ###################");
		goldservicebuildpage.captureGoldOrder();
		log.info("################### Start completing task ###################");
		goldservicebuildpage.completeTask();
		log.info("################### End completing task ###################");
		
		log.info("################### Start searching Gold Order ###################");
		goldorderpage.searchOrder();
		log.info("################### End searching Gold Order ###################");	
		
		log.info("################### Start Edit Order ###################");
		goldorderpage.editOrder();
		log.info("################### End Edit Order ###################");
			
		log.info("################### Start selecting CAT Flag  ###################");
		goldorderpage.selectCAT(CATFLag);
		log.info("################### End selecting CAT Flag  ###################");
			
		log.info("################### Start submitting technical order ###################");
		goldorderpage.submitSRF2notRequired();
		log.info("################### End submitting technical order ###################");
			
		log.info("################### Start searching gold order ###################");
		goldorderpage.searchOrder();
		log.info("################### End searching gold order ###################");
			
		log.info("################### Start Editing gold order ###################");
		goldorderpage.editOrder();
		log.info("################### End Editing gold order ###################");
			
		log.info("################### Start Editing Pricing charge ###################");
		goldorderpricingpage.inputPricingCharge();
		log.info("################### End Editing Pricing charge ###################");
			
		log.info("################### Start Submitting Pricing Order ###################");
		goldorderpage.submitPricingOrder();
		log.info("################### End Submitting Pricing Order ###################");
			
		log.info("################### Start Searching Gold Order ###################");
		goldorderpage.searchOrder();
		log.info("################### End Searching Gold Order ###################");
			
		log.info("################### Start Editing Gold Order ###################");
		goldorderpage.editOrder();
		log.info("################### End Editing Gold Order ###################");
			
		log.info("################### Start Selecting Early Local Validation ###################");
		goldorderpage.selectEarlyLocalValidation();
		log.info("################### End Selecting Early Local Validation ###################");
			
		log.info("################### Start Searching Gold Order ###################");
		goldorderpage.searchOrder();
		log.info("################### End Searching Gold Order ###################");
			
		log.info("################### Start Editing Gold Order ###################");
		goldorderpage.editOrder();
		log.info("################### End Editing Gold Order ###################");
			
		log.info("################### Start Sending Customer Signature Date ###################");
		goldorderpage.sendCustomerSignatureDate();
		log.info("################### End Sending Customer Signature Date ###################");
		
		log.info("################### Start Searching Gold Order after sending Customer Signature Date ###################");
		goldorderpage.searchOrder();
		log.info("################### End Searching Gold Order after sending Customer Signature Date ###################");
		
		//goldorderpage.checkAcceptanceNotes();
		
	}
	
	@AfterClass
	public void quitGoldApp()
	{
		driver.quit();
	}
}
	
