package themis.Pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import themis.TestBase.TestBase;
import themis.Util.WaitHelper;
import themis.Util.WindowHelper;

public class ISTrackLoginPage extends TestBase{
	public static final Logger log =Logger.getLogger(ISTrackLoginPage.class.getName());
	WindowHelper windowhelper = new WindowHelper();
	WaitHelper waithelper = new WaitHelper();
	GuardianHomePage guardianhomepage=new GuardianHomePage();
	
	@FindBy(id = "txtUserID")
	public WebElement Username;
	
	@FindBy(id = "txtPassword")
	public WebElement Password;
	
	@FindBy(id = "sub")
	public WebElement Signin;
	
	public ISTrackLoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Login(String un, String pwd){
		log.info("IS Track AM Environment Login");
		driver.get(prop.getProperty("ISTrack_url"));
		//log.info("IS Track Production Environment Login");
		//driver.get(prop.getProperty("ISTrack_url2"));
		//log.info("IS Track E1 Environment Login");
		//driver.get(prop.getProperty("ISTrack_url"));
		//waithelper.waitForframeToBeAvailableAndSwitchToIt(GuardianFrame, 30);
		Username.sendKeys(un);
		log.info("Username entered " +un.toString());
		Password.sendKeys(pwd);
		log.info("Password entered " +pwd.toString());
		Signin.click();
		log.info("Clicked on Login Button");
		waithelper.pageLoadTime(120, TimeUnit.SECONDS);		
	}
	
	public void Login_Prod(String un, String pwd){
		
		log.info("IS Track Production Environment Login");
		driver.get(prop.getProperty("ISTrack_url2"));
		//waithelper.waitForframeToBeAvailableAndSwitchToIt(GuardianFrame, 30);
		Username.sendKeys(un);
		log.info("Username entered " +un.toString());
		Password.sendKeys(pwd);
		log.info("Password entered " +pwd.toString());
		Signin.click();
		log.info("Clicked on Login Button");
		waithelper.pageLoadTime(120, TimeUnit.SECONDS);		
	}
	
}
