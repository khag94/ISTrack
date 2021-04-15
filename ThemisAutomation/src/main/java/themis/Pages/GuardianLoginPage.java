package themis.Pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import themis.TestBase.TestBase;
import themis.Util.WaitHelper;
import themis.Util.WindowHelper;

public class GuardianLoginPage extends TestBase
{
	public static final Logger log =Logger.getLogger(GuardianLoginPage.class.getName());
	WaitHelper waithelper = new WaitHelper();
	WindowHelper windowhelper = new WindowHelper();
	
	
	@FindBy(name = "bgmainframe")	
	WebElement GuardianFrame;
	
	@FindBy(xpath = "//input[@id='user']")
	WebElement UserName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath = "//a[@id='linkValidForm']")
	WebElement LoginButton;
	
	public GuardianLoginPage()
	{
		PageFactory.initElements(driver, this);
	}


	//public GuardianHomePage Login(String un, String pwd){
	public GuardianHomePage Login(String un, String pwd) throws InterruptedException{
		driver.get(prop.getProperty("guardian_url"));
		waitForAlertIsPresent1(40);
		dismissAlertIfPresent1();
		
		//waithelper.waitForframeToBeAvailableAndSwitchToIt(GuardianFrame, 30);
		windowhelper.SwitchMultipleWindow("Guardian connection");
		UserName.sendKeys(un);
		log.info("Username entered" +un.toString());
		Password.sendKeys(pwd);
		log.info("Password entered" +pwd.toString());
		LoginButton.click();
		log.info("Clicked on Login Button");
		
		waithelper.pageLoadTime(120, TimeUnit.SECONDS);		
		return new GuardianHomePage();
	}
	public GuardianHomePage LoginMyTools(String un, String pwd) throws InterruptedException{
		driver.get(prop.getProperty("myTools_url"));
		waitForAlertIsPresent1(40);
		dismissAlertIfPresent1();
		Thread.sleep(5000);
		
		//waithelper.waitForframeToBeAvailableAndSwitchToIt(GuardianFrame, 30);
		windowhelper.SwitchMultipleWindow("Guardian connection");
		UserName.sendKeys(un);
		log.info("Username entered" +un.toString());
		Password.sendKeys(pwd);
		log.info("Password entered" +pwd.toString());
		LoginButton.click();
		log.info("Clicked on Login Button");
		
		waithelper.pageLoadTime(120, TimeUnit.SECONDS);		
		return new GuardianHomePage();
	}
	public static void dismissAlertIfPresent1(){
		if(isAlertPresent1()){
			dismissAlert1();
		}
		else{
			log.info("Alert is not present..");
		}
	}
	
	public static boolean isAlertPresent1(){
		try{
			driver.switchTo().alert();
			log.info("alert is present");
			return true;
		}
		catch(NoAlertPresentException e){
			log.info(e.getCause());
			return false;
		}
	}
	
	public static void dismissAlert1(){
		getAlert1().dismiss();
		log.info("dismiss Alert is done...");
	}
	
	public static Alert getAlert1(){
		log.info("alert test: "+driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public static void waitForAlertIsPresent1(int timeOutInSeconds) {
		try {
			log.info("waiting for Alert for :" + timeOutInSeconds + " seconds");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.alertIsPresent());
			log.info("Alert is visible now");
		} catch(NoAlertPresentException e){
			log.info("No Alert Present");
		}
	}

}
