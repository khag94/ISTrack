package themis.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import themis.TestBase.TestBase;
import themis.Util.WaitHelper;
import themis.Util.WindowHelper;
import themis.Util.DropDownHelper;

public class GuardianHomePage extends TestBase 
{
	public static final Logger log =Logger.getLogger(GuardianHomePage.class.getName());
	WaitHelper waithelper = new WaitHelper();
	WindowHelper windowhelper= new WindowHelper();
	
	@FindBy(xpath = "//a[contains(.,'GOLD UAT')]")
	public WebElement GoldUAT;
	
	//@FindBy(xpath = "//a[contains(.,'Order Tracking (OT)  UAT')]")
	@FindBy(xpath  = "//a[contains(text(),'SRT - UAT')]")
	public WebElement OT;
	
	@FindBy(xpath = "//a[contains(.,'GOLD Sandbox')]")
	public WebElement GOLDSandbox;
	
	@FindBy(xpath = "(//*[contains(text(),'GOLD')])[2]")
	public WebElement GOLDProdlink;
	
	@FindBy(name = "bgmainframe")
	WebElement GuardianFrame;
	
	@FindBy(xpath = "//input[contains(@type,'text')]")
	public WebElement GOLDProd;
	
	
	public GuardianHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void launch_ApplicationFromGuardian(WebElement link) throws InterruptedException
	{
		//windowhelper.SwitchMultipleWindow("Home in the information system");
		windowhelper.SwitchMultipleWindow("Bureau Mon SI");
		driver.switchTo().defaultContent();
		//waithelper.waitForframeToBeAvailableAndSwitchToIt(GuardianFrame, 30);
		windowhelper.SwitchMultipleWindow("Bureau Mon SI");
		// below set of code can click on any application link present in Guardian
		waithelper.WaitForElementVisibleWithPollingTime(link, 30, 5);
		link.click();
		log.info("Clicked on Application Link");
		driver.switchTo().defaultContent();
	}
	public void launchApplicationFromMyTools(WebElement link) throws InterruptedException
	{
		windowhelper.SwitchMultipleWindow("Portfolio - mytools");
		driver.switchTo().defaultContent();
		//waithelper.waitForframeToBeAvailableAndSwitchToIt(GuardianFrame, 30);
		GOLDProd.sendKeys("Gold");
		Thread.sleep(5000);
		waithelper.WaitForElementVisibleWithPollingTime(link, 30, 5);
		link.click();
		log.info("Clicked on Application Link");
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
	}	
}
