package themis.Pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import themis.TestBase.TestBase;
import themis.Util.WaitHelper;

public class ORPage extends TestBase{
	public static final Logger log =Logger.getLogger(ORPage.class.getName());
	
	WaitHelper waithelper = new WaitHelper();
	@FindBy(xpath = "//div[contains(text(),'Open')]")
	public WebElement OpenButton;
	
	public ORPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void openCaseNumber() throws InterruptedException
	{
		waithelper.pageLoadTime(60, TimeUnit.SECONDS);	
		OpenButton.click();
	}
}
