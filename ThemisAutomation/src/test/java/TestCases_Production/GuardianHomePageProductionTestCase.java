package TestCases_Production;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import themis.Pages.GuardianHomePage;
import themis.Pages.GuardianLoginPage;
import themis.TestBase.TestBase;



public class GuardianHomePageProductionTestCase extends TestBase
{
	public static final Logger log =Logger.getLogger(GuardianHomePageProductionTestCase.class.getName());
	GuardianHomePage guardianhomepage;
	GuardianLoginPage guardianloginpage;
	
	public GuardianHomePageProductionTestCase()
	{
		super();
	}
	
	@BeforeTest
	//@BeforeMethod
	//@Test
	public void Init() throws InterruptedException, AddressException, InvalidFormatException, IOException, MessagingException
	{
		initialization();
		guardianloginpage=new GuardianLoginPage();
		guardianhomepage=new GuardianHomePage();
	}
	
	@Test(priority=1)
	public void Launch_MyTools_Application() throws InterruptedException
	{
		log.info("################### Start Login into Guardian Application ###################");
		guardianhomepage=guardianloginpage.LoginMyTools(prop.getProperty("username"), prop.getProperty("password"));
		log.info("################### End Login into Guardian Application ###################");
	}
	
	 

}



