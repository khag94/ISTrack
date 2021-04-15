package themis.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import themis.TestBase.TestBase;
import themis.Util.DropDownHelper;
import themis.Util.WaitHelper;

public class GoldOrderPricingPage extends TestBase
{
	public static final Logger log =Logger.getLogger(GoldOrderPricingPage.class.getName());
	
	DropDownHelper dropdownhelper = new DropDownHelper();
	WaitHelper waithelper = new WaitHelper();
	
	@FindBy(xpath = "//table[@id='LeftNavBar']/tbody/tr[2]/td/table/tbody/tr[7]/td")
	public WebElement PricingLink;
	
	@FindBy(xpath = "//*[@id='QuoteLineItems']/tr[2]/td[14]")
	public WebElement Charge1;
	
	@FindBy(xpath = "//*[@id='QuoteLineItems']/tr[2]/td[14]/input")
	public WebElement Charge1Input;
	
	@FindBy(xpath = "//*[@id='QuoteLineItems']/tr[2]/td[15]")
	public WebElement Charge2;
	
	@FindBy(xpath = "//*[@id='QuoteLineItems']/tr[2]/td[15]/input")
	public WebElement Charge2Input;
	
	@FindBy(xpath = "(//*[@class='actionText'])[1]")
	public WebElement PricingSubmit;
	
	
	public GoldOrderPricingPage(){
		PageFactory.initElements(driver, this);
	}
	public void inputPricingCharge() throws InterruptedException
	{
		waithelper.WaitForElementVisibleWithPollingTime(PricingLink, 10, 3);
		PricingLink.click();
		Thread.sleep(4000);
		dropdownhelper.MoveToTaskandDoubleClick(Charge1);
		Charge1Input.clear();
		Charge1Input.sendKeys("10");
		Thread.sleep(4000);
		dropdownhelper.MoveToTaskandDoubleClick(Charge2);
		Charge2Input.clear();
		Charge2Input.sendKeys("10");
		Thread.sleep(4000);
		PricingSubmit.click();
	}
	
}
