package themis.Pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import themis.TestBase.TestBase;
import themis.Util.DropDownHelper;
import themis.Util.ExcelHelper;
import themis.Util.JavaScriptHelper;
import themis.Util.ReusableMethods;
import themis.Util.VerificationHelper;
import themis.Util.WaitHelper;
import themis.Util.WindowHelper;

public class MyGroupPage extends TestBase{
	public static final Logger log =Logger.getLogger(MyGroupPage.class.getName());
	
	ExcelHelper excelhelper = new ExcelHelper();
	ReusableMethods reuse = new ReusableMethods();
	DropDownHelper dropdownhelper = new DropDownHelper();
	WindowHelper windowhelper= new WindowHelper();
	JavaScriptHelper javascripthelper = new JavaScriptHelper();
	WaitHelper waithelper = new WaitHelper();
	VerificationHelper verificationhelper = new VerificationHelper();
	
	
	String SheetName1="Sheet2";
	String ExcelPath=System.getProperty("user.dir")+"\\src\\main\\java\\themis\\Data\\GoldThemis.xlsx";
	
	@FindBy(xpath = "//label[contains(text(),'My Group')]")
	public WebElement MyGroup;
	
	@FindBy(xpath = "//table[@id='gridLayoutTable']/tbody/tr/td[2]/div/table/tbody/tr/th")
	//@FindBy(xpath = "/html[1]/body[1]/div[2]/form[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/span[1]/div[1]/table[2]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th")
	public List<WebElement> MyWorkTable;
	
	@FindBy(xpath = "//input[@id='OrderNumber']")
	public WebElement GoldOrder;
	
	@FindBy(xpath = "//input[contains(@name,'pOrderNumber')]")
	public WebElement SetGoldOrder;
	
	@FindBy(xpath = "//button[contains(@title,'Filter the list')]")
	public WebElement SearchOrder;
	
	@FindBy(xpath = "//input[@name='$PpyPortal$pSearchPage$pOrderNumber']")
	public WebElement enterOrder;
	
	@FindBy(xpath = "//table[@id='ViewTable']/tbody/tr/th")
	public List<WebElement> MyGroupTable;
	
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	public WebElement CheckboxSelect;
	
	@FindBy(xpath = "//select[@id='AssignOperator']")
	public WebElement Operator;
	
	@FindBy(xpath = "//div[@class='pzbtn-mid']")
	public WebElement ProcessAssignment;
	
	//@FindBy(xpath = "//button[@name='SearchSupervisorgroup_pyPortal_11']")
	@FindBy(xpath = "//button[contains(@title,'Clear Search Fields')]")
	public WebElement ClearSearchButton;
	
	@FindBy(xpath = "//input[contains(@tabindex,'0')]")
	public WebElement SelectCheckBox;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[2]")
	public WebElement Column2;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[3]")
	public WebElement Column3;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[4]")
	public WebElement Column4;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[5]")
	public WebElement Column5;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[6]")
	public WebElement Column6;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[7]")
	public WebElement Column7;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[8]")
	public WebElement Column8;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[9]")
	public WebElement Column9;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[10]")
	public WebElement Column10;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[11]")
	public WebElement Column11;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[12]")
	public WebElement Column12;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[13]")
	public WebElement Column13;
	
	@FindBy(xpath = "(//table[@id='ViewTable']/tbody/tr/th)[14]")
	public WebElement Column14;
	
	@FindBy(xpath = "//label[contains(text(),'My Work')]")
	public WebElement MyWork;
	
	@FindBy(xpath = "//a[contains(.,'EquipmentProcurement')]")
	public WebElement EquipmentProcureMentTask;
	
	@FindBy(xpath = "//td[contains(.,'Reject-Resolved')]")
	public WebElement RejectResolved;
	
	@FindBy(xpath = "//a[contains(.,'Other Actions')]")
	public WebElement OtherActions;

	@FindBy(xpath = "//select[contains(@name,'pReassignReason')]")
	public WebElement ReassignReason;
	
	@FindBy(xpath = "//button[@title='Complete this assignment']")
	public WebElement Submit;
	
	@FindBy(xpath = "//select[@id='AssignOperator']")
	public WebElement AssignOperator;
	
	@FindBy(xpath = "//button[contains(@name,'Search_pyPortal_141')]")
	public WebElement ClearSearchMyWork;
	
	/*@FindBy(name = "PegaGadget0Ifr")
	public WebElement EP_Frame;*/
	
	@FindBy(id = "PWGadget3Ifr")
	public WebElement EP_Frame;
	
	@FindBy(id = "PWGadget1Ifr")
	public WebElement MyGroup_Frame;
	
	@FindBy(id = "PWGadget0Ifr")
	public WebElement MyWork_Frame;
	
	
	public MyGroupPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void goldOrderSearchMyGroup() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException 
	{
		//windowhelper.SwitchMultipleWindow("Supervisor");
		driver.switchTo().defaultContent();
		MyGroup.click();
		Thread.sleep(5000);
		//waithelper.pageLoadTime(5, TimeUnit.SECONDS);
		String Order=excelhelper.getDataFromExcel(ExcelPath,SheetName1);
		System.out.println("Gold order imported from excel"+Order);
		//driver.switchTo().frame(1);
		waithelper.waitForframeToBeAvailableAndSwitchToIt(MyGroup_Frame, 10);
		log.info("My Group frame switched");
		ClearSearchButton.click();
		//waithelper.WaitForElementVisibleWithPollingTime(SetGoldOrder, 10, 3);
		Thread.sleep(10000);
		SetGoldOrder.sendKeys(Order);
		Thread.sleep(5000);
		SearchOrder.click();
		Thread.sleep(20000);
	}
	public void checkColumnNamesAndCount_MyWork() throws IOException, InterruptedException
	{
		windowhelper.SwitchMultipleWindow("Supervisor");
		//driver.switchTo().frame(0);
		waithelper.waitForframeToBeAvailableAndSwitchToIt(MyWork_Frame, 20);
		log.info("My Work frame switched");
		reuse.takeScreenshot("MyWorkColumns/column_names");
		log.info("My work Columns Screenshot is done");
		reuse.checkColumnNamesAndCount(MyWorkTable);
	}


	public void checkColumnNamesAndCount_MyGroup() throws IOException
	{
		reuse.takeScreenshot("MyGroupColumns/column_names");
		reuse.checkColumnNamesAndCount(MyGroupTable);
	}
	public void assign() throws InterruptedException
	{
		waithelper.waitForElement(CheckboxSelect, 10);
		CheckboxSelect.click();
		dropdownhelper.selectUsingVisibleText(Operator, "BillingUser1");
		ProcessAssignment.click();
		Thread.sleep(10000);
	}
	public void assigntoSAMIUser() throws InterruptedException
	{
		waithelper.waitForElement(CheckboxSelect, 10);
		CheckboxSelect.click();
		dropdownhelper.selectUsingVisibleText(Operator, "SAMIUser");
		ProcessAssignment.click();
		Thread.sleep(10000);
	}
	public void assigntoPOCMUser1() throws InterruptedException
	{
		waithelper.waitForElement(CheckboxSelect, 10);
		CheckboxSelect.click();
		dropdownhelper.selectUsingVisibleText(Operator, "POCMUser1");
		ProcessAssignment.click();
		Thread.sleep(10000);
	}
	public void compareColumnNamesMyGroup_BillingSupervisor()
	{
		String Col2 = verificationhelper.getText(Column2);
		Assert.assertEquals(Col2, "Urgency");
		String Col3 = verificationhelper.getText(Column3);
		Assert.assertEquals(Col3, "Order Number");
		String Col4 = verificationhelper.getText(Column4);
		Assert.assertEquals(Col4, "Expedite Case");
		String Col5 = verificationhelper.getText(Column5);
		Assert.assertEquals(Col5, "Missing Info");
		String Col6 = verificationhelper.getText(Column6);
		Assert.assertEquals(Col6, "Customer Name");
		String Col7 = verificationhelper.getText(Column7);
		Assert.assertEquals(Col7, "Case ID");
		String Col8 = verificationhelper.getText(Column8);
		Assert.assertEquals(Col8, "Task ID");
		String Col9 = verificationhelper.getText(Column9);
		Assert.assertEquals(Col9, "Task Name");
		String Col10 = verificationhelper.getText(Column10);
		Assert.assertEquals(Col10, "Task Status");
		String Col12 = verificationhelper.getText(Column11);
		Assert.assertEquals(Col12, "Sub Task Name");
		String Col13 = verificationhelper.getText(Column12);
		Assert.assertEquals(Col13, "Sub Task Deadline");
		String Col15 = verificationhelper.getText(Column13);
		Assert.assertEquals(Col15, "Can Start");
		String Col16 = verificationhelper.getText(Column14);
		Assert.assertEquals(Col16, "Plan Type");
	}
	public void equipmentProcurement() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	{
		
		windowhelper.SwitchMultipleWindow("OQM User");
		driver.switchTo().defaultContent();
		Thread.sleep(14000);
		MyGroup.click();
		Thread.sleep(5000);
		String Order=excelhelper.getDataFromExcel(ExcelPath,SheetName1);
		System.out.println("Gold order imported from excel"+Order);
		waithelper.waitForframeToBeAvailableAndSwitchToIt(MyGroup_Frame, 10);
		log.info("My Group frame switched");
		Thread.sleep(8000);
		ClearSearchButton.click();
		Thread.sleep(4000);
		javascripthelper.sendData(SetGoldOrder, Order);
		Thread.sleep(3000);
		SearchOrder.click();
		Thread.sleep(3000);
		SelectCheckBox.click();
		Thread.sleep(3000);
		dropdownhelper.selectUsingVisibleText(AssignOperator,"OQMUser");
		Thread.sleep(3000);
		ProcessAssignment.click(); 
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		MyWork.click();
		Thread.sleep(4000);
		//driver.switchTo().frame(0);
		waithelper.waitForframeToBeAvailableAndSwitchToIt(MyWork_Frame, 10);
		log.info("My Work frame switched");
		ClearSearchMyWork.click();
		Thread.sleep(5000);
		enterOrder.sendKeys(Order);
		Thread.sleep(8000);
		SearchOrder.click();
		Thread.sleep(5000);
		EquipmentProcureMentTask.click();
		Thread.sleep(60000);
	/*	driver.switchTo().defaultContent();
		waithelper.waitForframeToBeAvailableAndSwitchToIt(EP_Frame, 10);
		Thread.sleep(18000);
		OtherActions.click();
	
		RejectResolved.click();
		Thread.sleep(3000);
		dropdownhelper.selectUsingVisibleText(ReassignReason,"Invalid issue");
		Thread.sleep(3000);
		Submit.click();
		Thread.sleep(3000);	*/
	}
}