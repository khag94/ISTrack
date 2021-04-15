package themis.Pages;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import themis.TestBase.TestBase;
import themis.Util.AlertHelper;
import themis.Util.DropDownHelper;
import themis.Util.ReusableMethods;
import themis.Util.VerificationHelper;
import themis.Util.WaitHelper;
import themis.Util.WindowHelper;

public class GoldOrderStatusCheckPage extends TestBase {

	public static final Logger log =Logger.getLogger(GoldOrderStatusCheckPage.class.getName());
	
	VerificationHelper verificationhelper = new VerificationHelper();
	WindowHelper windowhelper = new WindowHelper();
	DropDownHelper dropdownhelper = new DropDownHelper();
	ReusableMethods reusablemethods= new ReusableMethods();
	WaitHelper waithelper = new WaitHelper();
	AlertHelper alerthelper = new AlertHelper();
	
	@FindBy(xpath = "//table[@class='contentPane']/tbody/tr/td/table/tbody/tr[1]/td[3]/span")
	public WebElement Status;
	
	@FindBy(linkText = "Revised Target Delivery Date Details")
	public WebElement ReviseTDD;
	
	@FindBy(xpath = "//input[@id='rtdd']")
	public WebElement TDD;
	
	@FindBy(xpath = "//textarea[@id='reasonRtdd']")
	public WebElement Reason;
	
	@FindBy(xpath = "//img[@name='View details']")
	public WebElement ViewDetails;
	
	@FindBy(xpath= "//img[@name='WFCompleteTask']")
	public WebElement CompleteTask;
	
	@FindBy(xpath = "//div[@id='WFActionPopup']/table/tbody/tr[2]/td/nobr")
	public WebElement Approve;
	
	@FindBy(xpath = "//img[@title='Provisioning Reference Number']")
	public WebElement ProvisioningReferenecNumberAuto;
	
	
	public GoldOrderStatusCheckPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void statusCheck(String ActualStatus) throws InterruptedException
	//public void statusCheck() throws InterruptedException
	{
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
		String StatusText=verificationhelper.getText(Status);
		log.info("Order status in Gold is :  "+StatusText);
		Assert.assertEquals(StatusText,ActualStatus);
	}
	public void checkTOS_APD() throws InterruptedException
	{
		ProvisioningReferenecNumberAuto.click();
		windowhelper.SwitchMultipleWindow("Provisioning Reference Number");
		List<WebElement> ls = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));
		System.out.println(ls);
		
		for(WebElement list : ls)
		{
			//System.out.println("TOS::::APD::::USID:::: is"+list.getText());
			System.out.println("TOS::::APD::::USID");
		}
		driver.close();
	}
	public void checkReviseTDD() throws InterruptedException
	{
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
		ReviseTDD.click();
		windowhelper.SwitchMultipleWindow("Revised Target Delivery Date Details");
		String TDD1=TDD.getText();
		Assert.assertNotNull(TDD1);
		String Reason1=Reason.getText();
		Assert.assertNotNull(Reason1);
	}
	public void checkRFS_RFB() throws InterruptedException, IOException
	{
		windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
		statusCheck("Acceptance");
		//statusCheck();
		ProvisioningReferenecNumberAuto.click();
		windowhelper.SwitchMultipleWindow("Provisioning Reference Number");
		dropdownhelper.moveToTask(ViewDetails);
		reusablemethods.takeScreenshot("Gold/RFS_RFB");
		Thread.sleep(5000);
		//driver.close();
		//windowhelper.SwitchMultipleWindow("Orange Business Services GOLD");
		//driver.close();
	}
	public void approveAcceptance() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(CompleteTask, 30, 5);
		dropdownhelper.moveTillSubTaskandClick(CompleteTask, Approve);
		waithelper.waitForAlertIsPresent(5);
		alerthelper.acceptAlert();
		Thread.sleep(10000);
		log.info("acceptance is approved and order is moved to Billing");
	}
}


