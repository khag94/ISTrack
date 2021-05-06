package TestCases;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import themis.Pages.GoldOrderPage;
import themis.Pages.GuardianHomePage;
import themis.Pages.GuardianLoginPage;
import themis.TestBase.TestBase;

public class GoldOrderCopy extends TestBase{
	
	GuardianHomePage guardianhomepage;
	GuardianLoginPage guardianloginpage;
	GoldOrderPage goldorderpage;
	String ExcelPath = System.getProperty("user.dir")+"/src/main/java/themis/Data/GoldThemis.xlsx";
	String SheetName = "Sheet1";
	String SheetName1 = "Sheet2";
	
	public GoldOrderCopy() {
		super();
	}
	
	
	public static final Logger log =Logger.getLogger(GoldOrderCopy.class.getName());
	
	@BeforeTest
	public void init() throws InterruptedException
	{
		initialization();
		guardianloginpage = new GuardianLoginPage();
		guardianhomepage= new GuardianHomePage();
		goldorderpage = new GoldOrderPage();
	}
	
	
	@Test(priority=1)
	public void launchGuardianApp() throws InterruptedException
	{
		log.info("####################### Start login into Guardian Application #######################");
		guardianhomepage = guardianloginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("####################### End login into Guardian Application #######################");
		
		guardianhomepage.launch_ApplicationFromGuardian(guardianhomepage.GoldUAT);
		
	}
	
	@Test(priority=2)
	public void copyGoldOrder() throws Throwable
	{
		goldorderpage.goldOrderLinkClick();
		Thread.sleep(5000);
		
		log.info("################### Start searching Gold Order ###################");
		goldorderpage.orderSearchAllWork();
		log.info("################### End searching Gold Order ###################");
		
		goldorderpage.copyOrder();
	}
	
	
	
	@AfterClass
	public void quitGoldApp()
	{
		driver.quit();
	}

}
