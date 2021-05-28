package themis.Pages;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import themis.TestBase.TestBase;
import themis.Util.AlertHelper;
import themis.Util.ExcelHelper;
import themis.Util.WaitHelper;

public class OFPage extends TestBase{
	public static final Logger log =Logger.getLogger(OFPage.class.getName());
	
	String ExcelPath=System.getProperty("user.dir")+"/src/main/java/themis/Data/GoldThemis.xlsx";
	String SheetName2="Sheet3";
	
	WaitHelper waithelper = new WaitHelper();
	ExcelHelper excelhelper = new ExcelHelper();
	AlertHelper alerthelper = new AlertHelper();
	
	@FindBy(name = "PegaGadget1Ifr")
	public WebElement OF_Frame;
	
	@FindBy(linkText = "Assess Order")
	public WebElement AssessOrder;

	@FindBy(xpath = "//input[@class='autocomplete_input ac_']")
	public WebElement VendorName;
	
	@FindBy(xpath = "//input[@id='ERSOrder']")
	public WebElement EquipmentResale;
	
	@FindBy(xpath = "//*[@id='ProcessSelected6']")
	public WebElement WarehouseStagingProcess;
	
	@FindBy(xpath = "//*[@id='ProcessSelected7']")
	public WebElement TrackWarehouseDeliveryProcess;
	
	@FindBy(xpath = "//input[@id='MaintenanceOrder']")
	public WebElement Maintenance;
	
	@FindBy(xpath = "//input[@id='VBSOrder']")
	public WebElement VendorBrandedServices;
	
	@FindBy(xpath = "//input[@id='InterventionOrder']")
	public WebElement OnlineIntervention;
	
	@FindBy(xpath = "(//span[@class='match-highlight'])[1]")
	public WebElement SelectVendor;
	
	@FindBy(xpath = "//div[contains(text(),'Get Sub-Process List')]")
	public WebElement GetSubProcessList;
	
	@FindBy(id = "IsSerialNumberRequiredfalse")
	public WebElement SerialNumber;
	
	@FindBy(id = "IsItUrgentCasefalse")
	public WebElement UrgentCase;
	
	@FindBy(xpath = "//button[@title='Complete this assignment']")
	public WebElement Submit;
	
	@FindBy(id = "ConfirmPlan")
	public WebElement ConfirmPlan;
	
	@FindBy(xpath = "//tbody/tr/td/div/table/tbody/tr[1]/td[2]/span")
	public WebElement CaseId;
	
	@FindBy(xpath = "//input[@id='OCDOrder']")
	public WebElement OCDServices;
	
	@FindBy(xpath = "//input[@id='ManagedOrder']") //new added
	public WebElement Managed;
	
	@FindBy(xpath = "//input[@id='EAMOrder']")	//new added
	public WebElement EAM;
	
	@FindBy(xpath = "//input[@id='ProcessSelected9']")	//new added
	public WebElement WareHouseStagingCheckBox;
	
	@FindBy(xpath = "//input[@id='ProcessSelected10']")	//new added
	public WebElement TrackWareHouseDeliveryCheckBox;
	
	@FindBy(xpath = "//input[@id='ProcessSelected12']")	//new added
	public WebElement OnsiteInterventionCheckBox;
	
	@FindBy(xpath = "//input[@id='WelcomeLetter']")
	public WebElement WL;
	@FindBy(xpath = "//input[@id='VBSOrder']")
	public WebElement VBS; 
	
	public OFPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void assessOrder() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 30);
		AssessOrder.click();
		waithelper.pageLoadTime(30, TimeUnit.SECONDS);	
		VendorName.sendKeys("CISCO");
		Thread.sleep(6000);
		SelectVendor.click();
		Thread.sleep(4000);
		//waithelper.waitForElement(EquipmentResale, 20);
		EquipmentResale.click();
		Thread.sleep(3000);
		GetSubProcessList.click();
		//waithelper.waitForElement(SerialNumber, 20);
		Thread.sleep(3000);
		SerialNumber.click();
		Thread.sleep(3000);
		UrgentCase.click();	
		Thread.sleep(3000);
		Submit.click();
		waithelper.waitForElement(ConfirmPlan, 20);
		ConfirmPlan.click();
		Submit.click();
		Thread.sleep(12000);
	}
	public void assessOrder_ERSDirect() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 30);
		AssessOrder.click();
		waithelper.pageLoadTime(30, TimeUnit.SECONDS);	
		VendorName.sendKeys("CISCO");
		Thread.sleep(6000);
		SelectVendor.click();
		Thread.sleep(4000);
		//waithelper.waitForElement(EquipmentResale, 20);
		EquipmentResale.click();
		Thread.sleep(3000);
		GetSubProcessList.click();
		//waithelper.waitForElement(SerialNumber, 20);
		Thread.sleep(3000);
		//WarehouseStagingProcess.click();// to uncheck
		//Thread.sleep(3000);
		//TrackWarehouseDeliveryProcess.click();
		//Thread.sleep(3000);
		SerialNumber.click();
		Thread.sleep(3000);
		UrgentCase.click();	
		Thread.sleep(3000);
		Submit.click();
		waithelper.waitForElement(ConfirmPlan, 20);
		ConfirmPlan.click();
		Thread.sleep(3000);
		Submit.click();
		
		Thread.sleep(12000);
	}
	public void assessVendorBrandedServicesOrder() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 30);
		AssessOrder.click();
		waithelper.pageLoadTime(30, TimeUnit.SECONDS);	
		VendorName.sendKeys("CISCO");
		Thread.sleep(6000);
		SelectVendor.click();
		Thread.sleep(4000);
		VendorBrandedServices.click();
		Thread.sleep(3000);
		GetSubProcessList.click();
		//waithelper.waitForElement(SerialNumber, 20);
		Thread.sleep(3000);
		SerialNumber.click();
		Thread.sleep(3000);
		UrgentCase.click();	
		Thread.sleep(3000);
		Submit.click();
		waithelper.waitForElement(ConfirmPlan, 20);
		ConfirmPlan.click();
		Submit.click();
		Thread.sleep(12000);
	}
	public void assessOrder_ERSDirectPlusVBS() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 30);
		AssessOrder.click();
		waithelper.pageLoadTime(30, TimeUnit.SECONDS);	
		VendorName.sendKeys("CISCO");
		Thread.sleep(6000);
		SelectVendor.click();
		Thread.sleep(4000);
		//waithelper.waitForElement(EquipmentResale, 20);
		EquipmentResale.click();
		Thread.sleep(3000);
		VendorBrandedServices.click();
		GetSubProcessList.click();
		//waithelper.waitForElement(SerialNumber, 20);
		Thread.sleep(3000);
		//WarehouseStagingProcess.click();// to uncheck
		//Thread.sleep(3000);
		//TrackWarehouseDeliveryProcess.click();//uncheck
		//Thread.sleep(3000);
		SerialNumber.click();
		Thread.sleep(3000);
		UrgentCase.click();	
		Thread.sleep(3000);
		Submit.click();
		waithelper.waitForElement(ConfirmPlan, 20);
		ConfirmPlan.click();
		Thread.sleep(3000);
		Submit.click();
		
		Thread.sleep(12000);
	}
	public void assessOnlineInterventionOrder() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 30);
		AssessOrder.click();
		waithelper.pageLoadTime(30, TimeUnit.SECONDS);	
		VendorName.sendKeys("CISCO");
		Thread.sleep(6000);
		SelectVendor.click();
		Thread.sleep(4000);
		OnlineIntervention.click();
		Thread.sleep(3000);
		GetSubProcessList.click();
		//waithelper.waitForElement(SerialNumber, 20);
		Thread.sleep(3000);
		SerialNumber.click();
		Thread.sleep(3000);
		UrgentCase.click();	
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(8000);
		waithelper.waitForElement(ConfirmPlan, 20);
		ConfirmPlan.click();
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(8000);
	}
	public void assessMaintenanceOrder() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 30);
		AssessOrder.click();
		waithelper.pageLoadTime(30, TimeUnit.SECONDS);	
		VendorName.sendKeys("CISCO");
		Thread.sleep(6000);
		SelectVendor.click();
		Thread.sleep(4000);
		Maintenance.click();
		Thread.sleep(3000);
		GetSubProcessList.click();
		//waithelper.waitForElement(SerialNumber, 20);
		Thread.sleep(3000);
		SerialNumber.click();
		Thread.sleep(3000);
		UrgentCase.click();	
		Thread.sleep(3000);
		Submit.click();
		waithelper.waitForElement(ConfirmPlan, 20);
		ConfirmPlan.click();
		Submit.click();
		Thread.sleep(12000);
	}
	public void assessMaintenancePlusOnsiteInterventionOrder() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 30);
		AssessOrder.click();
		waithelper.pageLoadTime(30, TimeUnit.SECONDS);	
		VendorName.sendKeys("CISCO");
		Thread.sleep(6000);
		SelectVendor.click();
		Thread.sleep(4000);
		Maintenance.click();
		Thread.sleep(3000);
		OnlineIntervention.click();
		Thread.sleep(3000);
		GetSubProcessList.click();
		//waithelper.waitForElement(SerialNumber, 20);
		Thread.sleep(3000);
		SerialNumber.click();
		Thread.sleep(3000);
		UrgentCase.click();	
		Thread.sleep(3000);
		Submit.click();
		waithelper.waitForElement(ConfirmPlan, 20);
		ConfirmPlan.click();
		Submit.click();
		Thread.sleep(12000);
	}
	
	public void assessOCDServices() throws InterruptedException //new function added
	{
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 30);
		AssessOrder.click();
		waithelper.pageLoadTime(30, TimeUnit.SECONDS);
		VendorName.sendKeys("CISCO");
		Thread.sleep(6000);
		SelectVendor.click();
		Thread.sleep(4000);
		OCDServices.click();
		Thread.sleep(3000);
		GetSubProcessList.click();
		Thread.sleep(3000);
		SerialNumber.click();
		Thread.sleep(3000);
		UrgentCase.click();
		Thread.sleep(3000);
		Submit.click();
		waithelper.waitForElement(ConfirmPlan, 20);
		ConfirmPlan.click();
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(12000);
	}
	
	public void assessEAMManaged() throws InterruptedException	//new function added
	{
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 30);
		AssessOrder.click();
		waithelper.pageLoadTime(30, TimeUnit.SECONDS);
		VendorName.sendKeys("CISCO");
		Thread.sleep(6000);
		SelectVendor.click();
		Thread.sleep(4000);
		
		Managed.click();
		Thread.sleep(3000);
		
		EAM.click();
		Thread.sleep(3000);
		
		GetSubProcessList.click();
		Thread.sleep(3000);
		SerialNumber.click();
		Thread.sleep(3000);
		UrgentCase.click();	
		Thread.sleep(3000);
		Submit.click();
		waithelper.waitForElement(ConfirmPlan, 20);
		ConfirmPlan.click();
		Submit.click();
		Thread.sleep(12000);
	}
	
	public void assessEAMManagedWithoutCheckBox() throws InterruptedException	//new function added
	{
		driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 30);
		AssessOrder.click();
		waithelper.pageLoadTime(30, TimeUnit.SECONDS);
		VendorName.sendKeys("CISCO");
		Thread.sleep(6000);
		SelectVendor.click();
		Thread.sleep(4000);
		
		Managed.click();
		Thread.sleep(3000);
		
		EAM.click();
		Thread.sleep(3000);
		
		GetSubProcessList.click();
		Thread.sleep(3000);
		
		WareHouseStagingCheckBox.click();
		Thread.sleep(3000);
		TrackWareHouseDeliveryCheckBox.click();
		Thread.sleep(3000);
		OnsiteInterventionCheckBox.click();
		Thread.sleep(10000);
		
		SerialNumber.click();
		Thread.sleep(3000);
		UrgentCase.click();	
		Thread.sleep(3000);
		Submit.click();
		waithelper.waitForElement(ConfirmPlan, 20);
		ConfirmPlan.click();
		Submit.click();
		Thread.sleep(12000);
	}
	
	public void captureCaseId()
	{
		String Text1=CaseId.getText();
		log.info("Case Id captured::::"+Text1);
		Assert.assertNotNull(Text1);
		excelhelper.updateResult(ExcelPath, SheetName2, Text1);
		System.out.println("Excel Sheet updated with Case Id"+Text1);
	}
	
	public void assessOrderVendorWelcome() throws InterruptedException
    {
           driver.switchTo().defaultContent();
           waithelper.waitForframeToBeAvailableAndSwitchToIt(OF_Frame, 30);
           AssessOrder.click();
           waithelper.pageLoadTime(30, TimeUnit.SECONDS); 
           VendorName.sendKeys("CISCO");
           Thread.sleep(10000);
           SelectVendor.click();
           Thread.sleep(10000);
           //waithelper.waitForElement(EquipmentResale, 20);
           VBS.click();
           Thread.sleep(10000);
           WL.click();
           Thread.sleep(10000);
           GetSubProcessList.click();
           //waithelper.waitForElement(SerialNumber, 20);
           Thread.sleep(10000);
           SerialNumber.click();
           Thread.sleep(3000);
           UrgentCase.click(); 
           Thread.sleep(3000);
           Submit.click();
           Thread.sleep(8000);
           waithelper.waitForElement(ConfirmPlan, 30);
           ConfirmPlan.click();
           Submit.click();
           Thread.sleep(8000);
    }
}

