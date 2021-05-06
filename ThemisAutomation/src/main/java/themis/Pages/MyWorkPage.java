package themis.Pages;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import themis.TestBase.TestBase;
import themis.Util.AssertionHelper;
import themis.Util.DropDownHelper;
import themis.Util.ExcelHelper;
import themis.Util.JavaScriptHelper;
import themis.Util.ReusableMethods;
import themis.Util.VerificationHelper;
import themis.Util.WaitHelper;

public class MyWorkPage extends TestBase{
	public static final Logger log =Logger.getLogger(MyWorkPage.class.getName());
	
	ExcelHelper excelhelper = new ExcelHelper();
	WaitHelper waithelper = new WaitHelper();
	DropDownHelper dropdownhelper= new DropDownHelper();
	VerificationHelper verificationhelper = new VerificationHelper();
	AssertionHelper asserthelper = new AssertionHelper(); 
	ReusableMethods reuse = new ReusableMethods();
	JavaScriptHelper javascripthelper = new JavaScriptHelper();
	
	String ExcelPath=System.getProperty("user.dir")+"/src/main/java/themis/Data/GoldThemis.xlsx";
	String SheetName1="Sheet2";
	String SheetName2="Sheet3";
	
	@FindBy(xpath = "(//input[contains(@id,'OrderNumber')])[2]")
	public WebElement GoldOrderNumber;
	
	@FindBy(xpath = "(//input[contains(@id,'OBSCaseId')])[2]")
	public WebElement CaseId;
	
	//@FindBy(xpath = "//button[contains(@name,'Search_pyPortal_11')]")
	@FindBy(xpath = "//button[contains(@name,'Search_pyPortal_140')]")
	public WebElement SearchGoldOrder;
	
	@FindBy(xpath = "(//a[contains(.,'New Order')])[2]")
	public WebElement NewOrderTask;
	
	//@FindBy(xpath = "(//a[contains(.,'Validate Order')])")
	@FindBy(xpath = "//tr[@id='$PWorkListEmbedTask$ppxResults$l3']//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//span//a[contains(@href,'#')][contains(text(),'Validate Order')]")
	public WebElement ValidateOrderTask;
		
	@FindBy(xpath = "//input[contains(@id,'SelectedTask3')]")
	public WebElement NewOrderCheckBox;
	
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask2']")
	public WebElement SecondRowCheckBox;
	
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask3']")
	public WebElement ThirdRowCheckBox;
	
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask4']")
	public WebElement FourthRowCheckBox;
	
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask5']")
	public WebElement FifthRowCheckBox;
	
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask6']")
	public WebElement SixthRowCheckBox;
	
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask7']")
	public WebElement SeventhRowCheckBox;
	
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask8']")
	public WebElement EightRowCheckBox;
	
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask9']")
	public WebElement NinthRowCheckBox;
	
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask11']")
	public WebElement EleventhRowCheckBox;
	
	@FindBy(xpath = "//a[contains(text(),'EquipmentProcurement')]")
	public WebElement EquipmentProcurementTask;
	
	@FindBy(xpath = "//a[contains(text(),'ServiceProcurement')]")
	public WebElement ServiceProcurementTask;
	
	@FindBy(xpath = "//a[contains(text(),'ContractUpload')]")
	public WebElement ContractUploadTask;
	
	@FindBy(xpath = "//a[contains(text(),'OnsiteIntervention')]")
	public WebElement OnsiteInterventionTask;
	
	//@FindBy(xpath = "//input[contains(@id,'SelectedTask2')]")
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask2']")
	public WebElement EquipmentProcurementCheckBox;
	
	@FindBy(xpath = "//a[contains(text(),'AcceptanceERS')]")
	public WebElement AcceptanceERSTask;
	
	@FindBy(xpath = "//input[contains(@id,'SelectedTask1')]")
	public WebElement AcceptanceERSCheckBox;
	
	@FindBy(xpath = "//a[contains(text(),'WareHouseStaging')]")
	public WebElement WarehouseStagingTask;
	
	//@FindBy(xpath = "//input[contains(@id,'SelectedTask4')]")
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask4']")
	public WebElement WarehouseStagingCheckBox;
	
	@FindBy(xpath = "//a[contains(text(),'Track Supplier Delivery (EP)')]")
	public WebElement TrackSupplierDeliveryTask;
	
	@FindBy(xpath = "//a[contains(text(),'Track Supplier Delivery (SP)')]")
	public WebElement TrackSupplierDeliveryServiceTask;
	
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask9']")
	public WebElement TrackSupplierDeliveryServiceCheckBox; //added by kp
	
	//@FindBy(xpath = "//input[contains(@id,'SelectedTask5')]")
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask5']")
	public WebElement TrackSupplierDeliveryCheckBox;
	
	//@FindBy(xpath = "//a[contains(text(),'TrackWareHouseDelivery")
	@FindBy(xpath = "//a[contains(text(),'TrackWareHouseDelivery')]")
	public WebElement TrackWareHouseDeliveryTask;
	
	//@FindBy(xpath = "//input[contains(@id,'SelectedTask6')]")
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask6']")
	public WebElement TrackWareHouseDeliveryCheckBox;
	
	@FindBy(xpath = "//tr[@id='$PWorkListEmbedTask$ppxResults$l2']//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//span//a[contains(@href,'#')][contains(text(),'Service Procurement OCD')]")
	public WebElement ServiceProcurementOCDTask; //added by kp
	
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask2']")
	public WebElement ServiceProcurementOCDCheckBox; //added by kp
	
	@FindBy(xpath = "//tr[@id='$PWorkListEmbedTask$ppxResults$l4']//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//span//a[contains(@href,'#')][contains(text(),'AcceptanceIS')]")
	public WebElement AcceptanceISTask; //added by kp
	
	@FindBy(xpath = "//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//input[@id='SelectedTask4']")
	public WebElement AcceptanceISCheckBox;
	
	//@FindBy(xpath = "//select[@id='AssignOperator']")
	//@FindBy(xpath = "//*[contains(@name,'pAssignOperator')]")
	@FindBy(xpath ="//div[contains(@class,'flex flex-row')]//div[@id='RULE_KEY']//span[@class='inspector-span']//div[@id='RULE_KEY']//fieldset[@class='subheaderFieldSetStyle']//table[@id='EXPAND-OUTERFRAME']//tbody//tr//td//table[@role='presentation']//tbody//tr//td[@class='dataValueWrite']//nobr//input[@id='AssignOperator']")
	public WebElement User;
	
	@FindBy(xpath = "//span[@class='match-highlight']")	//added by KP
	public WebElement SelectProcurementUser;
	
	@FindBy(xpath = "//button[contains(.,'Reassign')]")
	public WebElement Reassign;
	
	@FindBy(xpath = "//label[contains(text(),'My Work')]")
	public WebElement MyWork;
	
	//@FindBy(xpath = "//button[contains(@name,'Search_pyPortal_12')]")
	@FindBy(xpath = "//button[contains(@name,'Search_pyPortal_141')]")
	public WebElement ClearSearchButton;
	
	//@FindBy(xpath = "//a[contains(@title,'Log off')]")
	@FindBy(xpath = "//img[contains(@title,'Log off ')]")
	public WebElement LogOff;
	
	@FindBy(xpath = "//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th")
	public List<WebElement> MyWorkTable;
	
	@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[1]")
	public WebElement Column1;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[2]")
	//@FindBy(xpath = "//body[@id='yui-gen11']/div[@id='layout-doc']/div[@id='l2']/div[@id='yui-gen14']/div[@id='laygen2']/div[@id='PEGA_LU_C']/div[@id='RULE_KEY']/div[@id='CT']/span[contains(@class,'inspector-span')]/div[@id='RULE_KEY']/table[contains(@role,'presentation')]/tbody/tr/td[contains(@class,'dataLabelWrite')]/div[@id='RULE_KEY']/div[@id='workarea']/div[@id='PEGA_TABBED0']/div[contains(@class,'yui-content tabContent')]/div[@id='INNERDIV-SubSectionMgrWAGadgetBB']/div[contains(@class,'clearfix')]/div[contains(@class,'flex flex-row')]/div[@id='RULE_KEY']/span[contains(@class,'inspector-span')]/div[@id='RULE_KEY']/table[@id='EXPAND-OUTERFRAME']/tbody/tr/td/div[@id='PEGA_GRID4']/div[@id='PEGA_GRID_SKIN']/div[@id='PEGA_GRID_CONTENT']/table[@id='gridLayoutTable']/tbody/tr/td[contains(@class,'mainGridTableCell')]/div[@id='gridBody_right']/table[@id='bodyTbl_right']/tbody/tr[contains(@class,'cellCont')]/th[1]/div[1]/div[1]/div[1]")
	@FindBy(xpath = "//div[contains(@class,'divCont wrapHeader')]//div[contains(@class,'cellIn')][normalize-space()='Gold#']")
	public WebElement Column2;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[3]")
	@FindBy(xpath = "//div[@id='PEGA_GRID4']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont wrapHeader')]//div[contains(@class,'cellIn')][contains(text(),'Associated Gold#')]")
	public WebElement Column3;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[4]")
	@FindBy(xpath = "//div[@id='PEGA_GRID4']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont wrapHeader')]//div[contains(@class,'cellIn')][contains(text(),'Customer Name')]")
	public WebElement Column4;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[5]")
	@FindBy(xpath = "//div[@id='PEGA_GRID4']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')][contains(text(),'Case ID')]")
	public WebElement Column5;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[6]")
	@FindBy(xpath = "//table/tbody/tr/td/div/div/div[2]/table[@id='gridLayoutTable']/tbody/tr/td[2]/div/table/tbody/tr/th[6]")
	public WebElement Column6;
	
	//@FindBy(xpath = "//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[7]")
	@FindBy(xpath = "//body[@id='yui-gen11']/div[@id='layout-doc']/div[@id='l2']/div[@id='yui-gen14']/div[@id='laygen2']/div[@id='PEGA_LU_C']/div[@id='RULE_KEY']/div[@id='CT']/span[contains(@class,'inspector-span')]/div[@id='RULE_KEY']/table[contains(@role,'presentation')]/tbody/tr/td[contains(@class,'dataLabelWrite')]/div[@id='RULE_KEY']/div[@id='workarea']/div[@id='PEGA_TABBED0']/div[contains(@class,'yui-content tabContent')]/div[@id='INNERDIV-SubSectionMgrWAGadgetBB']/div[contains(@class,'clearfix')]/div[contains(@class,'flex flex-row')]/div[@id='RULE_KEY']/span[contains(@class,'inspector-span')]/div[@id='RULE_KEY']/table[@id='EXPAND-OUTERFRAME']/tbody/tr/td/div[@id='PEGA_GRID4']/div[@id='PEGA_GRID_SKIN']/div[@id='PEGA_GRID_CONTENT']/table[@id='gridLayoutTable']/tbody/tr/td[contains(@class,'mainGridTableCell')]/div[@id='gridBody_right']/table[@id='bodyTbl_right']/tbody/tr[contains(@class,'cellCont')]/th[6]/div[1]/div[1]/div[1]")
	public WebElement Column7;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[8]")
	@FindBy(xpath = "//div[@id='PEGA_GRID4']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont wrapHeader')]//div[contains(@class,'cellIn')][contains(text(),'Select Task to Reassign')]")
	public WebElement Column8;
	
	@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[9]")
	public WebElement Column9;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[10]")
	//@FindBy(xpath = "//div[@id='PEGA_GRID6']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont wrapHeader')]//div[contains(@class,'cellIn')][contains(text(),'Sub Task Name')]")
	//public WebElement Column10;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[11]")
	@FindBy(xpath = "//div[contains(text(),'Select Sub task to Reassign')]")
	public WebElement Column11;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[12]")
	@FindBy(xpath = "//div[contains(text(),'Sub Task Dead Line')]")
	public WebElement Column12;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[13]")
	@FindBy(xpath = "//div[@id='PEGA_GRID4']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')][contains(text(),'Can Start')]")
	public WebElement Column13;
	
	@FindBy(xpath = "//div[contains(text(),'Dead Line')]")
	public WebElement Column14;

	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[15]")
	@FindBy(xpath = "//div[@id='PEGA_GRID4']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')]//span//span[contains(@class,'leftJustifyStyle')][contains(text(),'ITDD')]")
	public WebElement Column15;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[16]")
	@FindBy(xpath = "//div[@id='PEGA_GRID4']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')]//span//span[contains(@class,'leftJustifyStyle')][contains(text(),'RTDD')]")
	public WebElement Column16;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[17]")
	@FindBy(xpath = "//div[@id='PEGA_GRID4']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')]//span//span[contains(@class,'leftJustifyStyle')][contains(text(),'IST-EDD')]")
	public WebElement Column17;
	
	//@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[18]")
	@FindBy(xpath = "//div[@id='PEGA_GRID4']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')][contains(text(),'Date Delta')]")
	public WebElement Column18;
	
	//@FindBy(xpath = "//div[contains(text(),'Dead Line')]")
	//public WebElement Column19;
	
	@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[20]")
	public WebElement Column20;
	
	@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[21]")
	public WebElement Column21;
	
	@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[22]")
	public WebElement Column22;
	
	@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[23]")
	public WebElement Column23;
	
	@FindBy(xpath = "(//table/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[24]")
	public WebElement Column24;
	
	
	//Billing Supervisor Column names
	@FindBy(xpath = "//div[contains(text(),'Obj Name')]")
	public WebElement Column25;
	
	@FindBy(xpath = "//div[contains(text(),'Gold Order Number')]")
	public WebElement Column26;
	
	@FindBy(xpath = "//div[contains(text(),'Is Urgent Case')]")
	public WebElement Column27;
	
	@FindBy(xpath = "//div[contains(text(),'Missing Info')]")
	public WebElement Column28;
	
	@FindBy(xpath = "//div[contains(text(),'Customer Name')]")
	public WebElement Column29;
	
	@FindBy(xpath = "//div[contains(text(),'Case ID')]")
	public WebElement Column30;
	
	@FindBy(xpath = "//div[contains(text(),'Task ID')]")
	public WebElement Column31;
	
	@FindBy(xpath = "//body[contains(@class,'harnessBody')]/div[@id='PEGA_HARNESS']/form[contains(@autocomplete,'off')]/div[@id='HARNESS_CONTENT']/table[contains(@class,'ie-table-fix containerBody')]/tbody/tr/td/div[contains(@class,'harnessBodyNoHead')]/div[@id='RULE_KEY']/span[contains(@class,'inspector-span')]/div[@id='RULE_KEY']/table[@id='EXPAND-OUTERFRAME']/tbody/tr/td/div[@id='PEGA_GRID0']/div[@id='PEGA_GRID_SKIN']/div[@id='PEGA_GRID_CONTENT']/table[@id='gridLayoutTable']/tbody/tr/td[contains(@class,'mainGridTableCell')]/div[@id='gridBody_right']/table[@id='bodyTbl_right']/tbody/tr[contains(@class,'cellCont')]/th[8]/div[1]/div[1]/div[1]")
	public WebElement Column32;
	
	@FindBy(xpath = "//div[contains(text(),'Select Task to Reassign')]")
	public WebElement Column33;
	
	@FindBy(xpath = "//div[contains(text(),'Sub Task Name')]")
	public WebElement Column34;
	
	@FindBy(xpath = "//div[contains(text(),'Select Sub task to Reassign')]")
	public WebElement Column35;
	
	@FindBy(xpath = "//div[contains(text(),'Dead Line')]")
	public WebElement Column36;
	
	@FindBy(xpath = "//div[contains(text(),'Can Start')]")
	public WebElement Column37;
	
	@FindBy(xpath = "//div[contains(text(),'Plan Type')]")
	public WebElement Column38;
	
	
	public MyWorkPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void orderSearchMyWork() throws Throwable, InvalidFormatException, IOException
	{
		
		driver.switchTo().defaultContent();
		MyWork.click();
		//waithelper.waitForElement(GoldOrderNumber, 30);
		Thread.sleep(20000);
		ClearSearchButton.click();
		Thread.sleep(5000);
		String Order=excelhelper.getDataFromExcel(ExcelPath,SheetName1);
		System.out.println("Gold Order imported from Excel"+Order);
		
		//waithelper.waitForframeToBeAvailableAndSwitchToIt(NewFrame, 30);
		
		GoldOrderNumber.sendKeys(Order);
		Thread.sleep(8000);
		SearchGoldOrder.click();
		Thread.sleep(10000);
		}
		
	
	public void caseSearchMyWork() throws Throwable, InvalidFormatException, IOException
	{
		
		driver.switchTo().defaultContent();
		MyWork.click();
		//waithelper.waitForElement(GoldOrderNumber, 30);
		Thread.sleep(4000);
		ClearSearchButton.click();
		Thread.sleep(5000);
		String Case=excelhelper.getDataFromExcel(ExcelPath,SheetName2);
		System.out.println("Gold Order imported from Excel"+Case);
		
		//waithelper.waitForframeToBeAvailableAndSwitchToIt(NewFrame, 30);
		
		CaseId.sendKeys(Case);
		Thread.sleep(8000);
		SearchGoldOrder.click();
		}
	
	public void captureTaskNamesAndSelectCheckbox() throws InterruptedException
    {
          
           String Task2=verificationhelper.getText(EquipmentProcurementTask);
           log.info("Task Captured from IS Track Application in My work tab "+Task2);
           Thread.sleep(5000);                           
    //  javascripthelper.clickElement(EquipmentProcurementCheckBox);
           EquipmentProcurementCheckBox.click();
           Thread.sleep(15000);                           
           String Task4=verificationhelper.getText(WarehouseStagingTask);
           log.info("Task Captured from IS Track Application in My work tab "+Task4);
           Thread.sleep(5000);                            
           //javascripthelper.clickElement(WarehouseStagingCheckBox);
           WarehouseStagingCheckBox.click();
           Thread.sleep(15000);
           String Task5=verificationhelper.getText(TrackSupplierDeliveryTask);
           log.info("Task Captured from IS Track Application in My work tab "+Task5);
           Thread.sleep(5000);                            
    //javascripthelper.clickElement(TrackSupplierDeliveryCheckBox);
           TrackSupplierDeliveryCheckBox.click();
           Thread.sleep(15000);
                       
           String Task6=verificationhelper.getText(TrackWareHouseDeliveryTask);
           log.info("Task Captured from IS Track Application in My work tab "+Task6);
           Thread.sleep(5000);
           TrackWareHouseDeliveryCheckBox.click();
           //javascripthelper.clickElement(TrackWareHouseDeliveryCheckBox);
           Thread.sleep(15000);
           }
	
	/*public void captureTaskNamesAndSelectCheckbox() throws InterruptedException
	{
		
		String Task2=verificationhelper.getText(EquipmentProcurementTask);
		log.info("Task Captured from IS Track Application in My work tab "+Task2);
		EquipmentProcurementCheckBox.click();
		Thread.sleep(3000);		
				
		String Task4=verificationhelper.getText(WarehouseStagingTask);
		log.info("Task Captured from IS Track Application in My work tab "+Task4);
		WarehouseStagingCheckBox.click();
		Thread.sleep(3000);
		
		String Task5=verificationhelper.getText(TrackSupplierDeliveryTask);
		log.info("Task Captured from IS Track Application in My work tab "+Task5);
		TrackSupplierDeliveryCheckBox.click();
		Thread.sleep(3000);
				
		String Task6=verificationhelper.getText(TrackWareHouseDeliveryTask);
		log.info("Task Captured from IS Track Application in My work tab "+Task6);
		TrackWareHouseDeliveryCheckBox.click();
		Thread.sleep(3000);
		} */
	
	public void captureTaskNamesVBSOrderAndSelectCheckbox() throws InterruptedException
	{
		String Task2=verificationhelper.getText(ServiceProcurementTask);
		log.info("Task Captured from IS Track Application in My work tab "+Task2);
		ThirdRowCheckBox.click();
		Thread.sleep(3000);		
				
		String Task5=verificationhelper.getText(TrackSupplierDeliveryServiceTask);
		log.info("Task Captured from IS Track Application in My work tab "+Task5);
		FourthRowCheckBox.click();
		Thread.sleep(3000);		
	}
	
	public void captureTaskNamesMaintenanceOrderAndSelectCheckbox() throws InterruptedException
	{
		String Task2=verificationhelper.getText(ContractUploadTask);
		log.info("Task Captured from IS Track Application in My work tab "+Task2);
		FifthRowCheckBox.click();
		Thread.sleep(3000);		
				
		String Task5=verificationhelper.getText(ServiceProcurementTask);
		log.info("Task Captured from IS Track Application in My work tab "+Task5);
		ThirdRowCheckBox.click();
		Thread.sleep(3000);		
	}
	
	public void captureTaskNamesERSOrderAndSelectCheckbox() throws InterruptedException
	{
	/*	String Task2=verificationhelper.getText(EquipmentProcurementTask);
		log.info("Task Captured from IS Track Application in My work tab "+Task2);
		SecondRowCheckBox.click();
		Thread.sleep(3000);	
				
		String Task5=verificationhelper.getText(TrackSupplierDeliveryTask);
		log.info("Task Captured from IS Track Application in My work tab "+Task5);
		ThirdRowCheckBox.click();
		Thread.sleep(3000);		*/
		
		
		String Task2 = verificationhelper.getText(EquipmentProcurementTask);
		log.info("Task Captured from IS Track Application in My Work Tab" + Task2);
		Thread.sleep(5000);
		EquipmentProcurementCheckBox.click();
		log.info("Clicked on Equipment Procurement Task Chechkbox");
		Thread.sleep(5000);
		
		String Task4 = verificationhelper.getText(WarehouseStagingTask);
		log.info("Task Captured from IS Track Application in My Work Tab" + Task4);
		Thread.sleep(5000);
		WarehouseStagingCheckBox.click();
		log.info("Clicked on Warehouse Staging Task Chechkbox");
		Thread.sleep(5000);
		
		String Task5 = verificationhelper.getText(TrackSupplierDeliveryTask);
		log.info("Task Captured from IS Track Application in My Work Tab" + Task5);
		Thread.sleep(5000);
		TrackSupplierDeliveryCheckBox.click();
		log.info("Clicked on TrackSupplier Delivery Task Chechkbox");
		Thread.sleep(5000);
		
		String Task6 = verificationhelper.getText(TrackWareHouseDeliveryTask);
		log.info("Task Captured from IS Track Application in My Work Tab" + Task6);
		Thread.sleep(5000);
		TrackWareHouseDeliveryCheckBox.click();
		log.info("Clicked on Warehouse Staging Task Chechkbox");
		Thread.sleep(5000);
		
		
		
	}
	
	public void captureTaskNamesERSOrderPlusVBSSelectCheckbox() throws InterruptedException
	{
	/*	String Task2=verificationhelper.getText(EquipmentProcurementTask);
		log.info("Task Captured from IS Track Application in My work tab "+Task2);
		SecondRowCheckBox.click();
		Thread.sleep(3000);		
				
		String Task5=verificationhelper.getText(TrackSupplierDeliveryTask);
		log.info("Task Captured from IS Track Application in My work tab "+Task5);
		ThirdRowCheckBox.click();
		Thread.sleep(3000);	*/
		
		String Task2 = verificationhelper.getText(EquipmentProcurementTask);
		log.info("Task Captured fom IS Track Application in My Work tab " + Task2);
		//EquipmentProcurementCheckBox.click();
		FourthRowCheckBox.click();
		log.info("Clicked on Equipment Procurement Chechkbox");
		Thread.sleep(5000);
		
		String Task3 = verificationhelper.getText(TrackSupplierDeliveryServiceTask);
		log.info("Task Captured fom IS Track Application in My Work tab " + Task3);
		//TrackSupplierDeliveryServiceCheckBox.click();
		SecondRowCheckBox.click();
		log.info("Clicked on Track Supplier Delivery Service CheckBox");
		Thread.sleep(5000);
		
		
		String Task4 = verificationhelper.getText(WarehouseStagingTask);
		log.info("Task Captured from IS Track Application in My Work Tab" + Task4);
		Thread.sleep(5000);
		//WarehouseStagingCheckBox.click();
		EightRowCheckBox.click();
		log.info("Clicked on Warehouse Staging Task Chechkbox");
		Thread.sleep(5000);
		
		String Task5 = verificationhelper.getText(TrackSupplierDeliveryTask);
		log.info("Task Captured from IS Track Application in My Work Tab" + Task5);
		Thread.sleep(5000);
		//TrackSupplierDeliveryCheckBox.click();
		SeventhRowCheckBox.click();
		log.info("Clicked on TrackSupplier Delivery Task Chechkbox");
		Thread.sleep(5000);
		
		String Task6 = verificationhelper.getText(TrackWareHouseDeliveryTask);
		log.info("Task Captured from IS Track Application in My Work Tab" + Task6);
		Thread.sleep(5000);
		//TrackWareHouseDeliveryCheckBox.click();
		ThirdRowCheckBox.click();
		log.info("Clicked on Warehouse Staging Task Chechkbox");
		Thread.sleep(5000);
	}
	
	public void captureTaskNamesOCDServicesAndSelectCheckBox() throws InterruptedException	//new function added
	{
		String Task2 = verificationhelper.getText(ServiceProcurementOCDTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task2);
		Thread.sleep(5000);
		ServiceProcurementOCDCheckBox.click();
		log.info("Clicked on Service Procurement OCD Chechkbox");
	}
	
	public void captureTaskNamesEAMManagedAndSelectCheckBox() throws InterruptedException	//new function added
	{
		String Task2 = verificationhelper.getText(EquipmentProcurementTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task2);
		Thread.sleep(5000);
		//EquipmentProcurementCheckBox.click();
		ThirdRowCheckBox.click();
		log.info("Clicked on Equipment Procurement Chechkbox");
		
		String Task3 = verificationhelper.getText(ContractUploadTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task3);
		Thread.sleep(5000);
		SecondRowCheckBox.click();
		log.info("Clicked on Contrack Upload Chechkbox");
		
		
		String Task4 = verificationhelper.getText(OnsiteInterventionTask);
		log.info("Task Captured from IS Track Application from My Work Tab " + Task4);
		Thread.sleep(5000);
		EleventhRowCheckBox.click();
		//FourthRowCheckBox.click();
		log.info("Clicked on Onsite Intervention Chechkbox");
		
		String Task5 = verificationhelper.getText(TrackSupplierDeliveryTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task5);
		Thread.sleep(5000);
		//SixthRowCheckBox.click();
		SeventhRowCheckBox.click();
		log.info("Clicked on Track Supplier Delivery Chechkbox");
		
		String Task6 = verificationhelper.getText(TrackWareHouseDeliveryTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task6);
		Thread.sleep(5000);
		//EightRowCheckBox.click();
		NinthRowCheckBox.click();
		log.info("Clicked on Track Warehouse Delivery Chechkbox");
		
		String Task7 = verificationhelper.getText(WarehouseStagingTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task7);
		Thread.sleep(5000);
		//NinthRowCheckBox.click();
		FifthRowCheckBox.click();
		log.info("Clicked on Warehouse Staging Chechkbox");
		
		String Task8 = verificationhelper.getText(TrackSupplierDeliveryServiceTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task8);
		Thread.sleep(5000);
		//SeventhRowCheckBox.click();
		EightRowCheckBox.click();
		log.info("Clicked on Track Supplier Delivery SP Chechkbox");
		
		String Task9 = verificationhelper.getText(ServiceProcurementTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task9);
		Thread.sleep(5000);
		SixthRowCheckBox.click();
		log.info("Clicked on Service Procurement Chechkbox");
		
		
	}
	
	public void captureTaskNamesEAMManagedWithoutCheckBoxAndSelectCheckBox() throws InterruptedException
	{
		
		String Task1 = verificationhelper.getText(TrackSupplierDeliveryServiceTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task1);
		Thread.sleep(5000);
		FourthRowCheckBox.click();
		log.info("Clicked on Track Supplier Delivery SP Chechkbox");
		
		String Task2 = verificationhelper.getText(ServiceProcurementTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task2);
		Thread.sleep(5000);
		FifthRowCheckBox.click();
		log.info("Clicked on Service Procurement Chechkbox");
		
		String Task3 = verificationhelper.getText(TrackSupplierDeliveryTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task3);
		Thread.sleep(5000);
		SixthRowCheckBox.click();
		log.info("Clicked on Track Supplier Delivery Chechkbox");
		
		String Task4 = verificationhelper.getText(ContractUploadTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task4);
		Thread.sleep(5000);
		//SeventhRowCheckBox.click();
		SecondRowCheckBox.click();
		log.info("Clicked on Contrack Upload Chechkbox");
		
		
		String Task5 = verificationhelper.getText(EquipmentProcurementTask);
		log.info("Task Captured from IS Track Application in My Work Tab " + Task5);
		Thread.sleep(5000);
		//EightRowCheckBox.click();
		ThirdRowCheckBox.click();
		log.info("Clicked on Equipment Procurement Chechkbox");
	}
		
	public void reassignTask() throws InterruptedException
	{
		//waithelper.waitForElement(User, 20, 10);
		//dropdownhelper.selectUsingVisibleText(User, "Procurement User");
		User.sendKeys("Procurementuser");
		//waithelper.waitForElement(Reassign, 10);
		//Thread.sleep(5000);
		//SelectProcurementUser.click();
		Thread.sleep(20000);
		javascripthelper.clickElement(Reassign);
		log.info("Reassign button is clicked");
		Thread.sleep(5000);
	}
	
	/*public void reassignTask() throws InterruptedException
	{
		waithelper.waitForElement(User, 20, 10);
		//dropdownhelper.selectUsingVisibleText(User, "Procurement User");
		User.sendKeys("Procurementuser");
		//waithelper.waitForElement(Reassign, 10);
		Thread.sleep(4000);
		Reassign.click();
		log.info("Reassign button is clicked");
		Thread.sleep(4000);
	} */
	
	public void checkColumnNamesAndCount() throws InterruptedException, IOException
	{
		Thread.sleep(5000);
		reuse.takeScreenshot("MyWorkColumns/column_names");
		reuse.checkColumnNamesAndCount(MyWorkTable);
		Thread.sleep(10000);
	}
	public void compareColumnNames_odmuser()
	{
		/*String Col1 = verificationhelper.getText(Column1);
		Assert.assertEquals(Col1, "");*/
		String Col2 = verificationhelper.getText(Column2);
		Assert.assertEquals(Col2, "Gold#");
		String Col3 = verificationhelper.getText(Column3);
		Assert.assertEquals(Col3, "Associated Gold#");
		String Col4 = verificationhelper.getText(Column4);
		Assert.assertEquals(Col4, "Customer Name");
		String Col5 = verificationhelper.getText(Column5);
		Assert.assertEquals(Col5, "Case ID");
		String Col6 = verificationhelper.getText(Column6);
		Assert.assertEquals(Col6, "Task ID");
		String Col7 = verificationhelper.getText(Column7);
		Assert.assertEquals(Col7, "Task Name");
		String Col8 = verificationhelper.getText(Column8);
		Assert.assertEquals(Col8, "Select Task to Reassign");
		//String Col9 = verificationhelper.getText(Column9);
		//Assert.assertEquals(Col9, "Task Status");
		//String Col10 = verificationhelper.getText(Column10);
		//Assert.assertEquals(Col10, "Sub Task Name");
		String Col11 = verificationhelper.getText(Column11);
		Assert.assertEquals(Col11, "Select Sub task to Reassign");
		String Col12 = verificationhelper.getText(Column12);
		Assert.assertEquals(Col12, "Sub Task Dead Line");
		String Col13 = verificationhelper.getText(Column13);
		Assert.assertEquals(Col13, "Can Start");
		String Col14 = verificationhelper.getText(Column14);
		Assert.assertEquals(Col14, "Dead Line");
		String Col15 = verificationhelper.getText(Column15);
		Assert.assertEquals(Col15, "ITDD");
		String Col16 = verificationhelper.getText(Column16);
		Assert.assertEquals(Col16, "RTDD");
		String Col17 = verificationhelper.getText(Column17);
		Assert.assertEquals(Col17, "IST-EDD");
		String Col18 = verificationhelper.getText(Column18);
		Assert.assertEquals(Col18, "Date Delta");
	/*	String Col19 = verificationhelper.getText(Column19);
		Assert.assertEquals(Col19, "Last Replan");
		String Col20 = verificationhelper.getText(Column20);
		Assert.assertEquals(Col20, "Last Replan Effect");
		String Col21 = verificationhelper.getText(Column21);
		Assert.assertEquals(Col21, "Delay Count");
		String Col22 = verificationhelper.getText(Column22);
		Assert.assertEquals(Col22, "Applied Delay"); */
		
		/*
		Assert.assertEquals(Col2, "Order Number");
		Assert.assertEquals(Col3, "Expedite Case");
		Assert.assertEquals(Col4, "Missing Info");
		Assert.assertEquals(Col5, "Customer Name");
		Assert.assertEquals(Col6, "Case ID");
		Assert.assertEquals(Col7, "Task ID");
		Assert.assertEquals(Col8, "Task Name");
		Assert.assertEquals(Col9, "Select Task to Reassign");
		Assert.assertEquals(Col10, "Task Status");
		Assert.assertEquals(Col11, "Sub Task Name");
		Assert.assertEquals(Col12, "Select Sub task to Reassign");
		Assert.assertEquals(Col13, "Sub Task Dead Line");
		Assert.assertEquals(Col14, "Can Start");
		Assert.assertEquals(Col15, "Plan Type");
		Assert.assertEquals(Col16, "Cisco Update");
		Assert.assertEquals(Col17, "Original Customer Agreed Delivery Date(ITDD)");
		Assert.assertEquals(Col18, "Current Customer Agreed Delivery Date");
		Assert.assertEquals(Col19, "Current IS Track Estimated Delivery Date");
		Assert.assertEquals(Col20, "Date Delta");
		Assert.assertEquals(Col21, "Last Replan");
		Assert.assertEquals(Col22, "Last Replan Effect");
		Assert.assertEquals(Col23, "Delay Count");
		Assert.assertEquals(Col24, "Applied Delay");
		*/
	}
	
	public void compareColumnNames_ProcurementUser()
	{
		//String Col1 = verificationhelper.getText(Column1);
		//Assert.assertEquals(Col1, " ");
		String Col2 = verificationhelper.getText(Column2);
		Assert.assertEquals(Col2, "Gold#");
		String Col3 = verificationhelper.getText(Column3);
		Assert.assertEquals(Col3, "Associated Gold#");
		String Col4 = verificationhelper.getText(Column4);
		Assert.assertEquals(Col4, "Customer Name");
		String Col5 = verificationhelper.getText(Column5);
		Assert.assertEquals(Col5, "Case ID");
		//String Col6 = verificationhelper.getText(Column6);
		//Assert.assertEquals(Col6, "Task ID");
		String Col7 = verificationhelper.getText(Column7);
		Assert.assertEquals(Col7, "Task Name");
		String Col8 = verificationhelper.getText(Column8);
		Assert.assertEquals(Col8, "Select Task to Reassign");
		//String Col9 = verificationhelper.getText(Column9);
		//Assert.assertEquals(Col9, "Task Status");
		//String Col10 = verificationhelper.getText(Column10);
		//Assert.assertEquals(Col10, "Sub Task Name");
		String Col11 = verificationhelper.getText(Column11);
		Assert.assertEquals(Col11, "Select Sub task to Reassign");
		//String Col12 = verificationhelper.getText(Column12);
		//Assert.assertEquals(Col12, "Sub Task Dead Line");
		String Col13 = verificationhelper.getText(Column13);
		Assert.assertEquals(Col13, "Can Start");
		String Col14 = verificationhelper.getText(Column14);
		Assert.assertEquals(Col14, "Dead Line");
		
	/*	String Col1 = verificationhelper.getText(Column1);
		Assert.assertEquals(Col1, "Gold#");
		String Col2 = verificationhelper.getText(Column2);
		Assert.assertEquals(Col2, "Associated Gold#");
		String Col3 = verificationhelper.getText(Column3);
		Assert.assertEquals(Col3, "Customer Name");
		String Col4 = verificationhelper.getText(Column4);
		Assert.assertEquals(Col4, "Case ID");
		String Col5 = verificationhelper.getText(Column5);
		Assert.assertEquals(Col5, "Task ID");
		String Col6 = verificationhelper.getText(Column6);
		Assert.assertEquals(Col6, "Task Name");
		String Col7 = verificationhelper.getText(Column7);
		Assert.assertEquals(Col7, "Select Task to Reassign");
		String Col8 = verificationhelper.getText(Column8);
		Assert.assertEquals(Col8, "Task Status");
		String Col9 = verificationhelper.getText(Column9);
		Assert.assertEquals(Col9, "Sub Task Name");
		//String Col10 = verificationhelper.getText(Column10);
		//Assert.assertEquals(Col10, "Select Sub task to Reassign");
		String Col11 = verificationhelper.getText(Column11);
		Assert.assertEquals(Col11, "Dead Line");
		String Col12 = verificationhelper.getText(Column12);
		Assert.assertEquals(Col12, "Can Start");
		String Col13 = verificationhelper.getText(Column13);
		Assert.assertEquals(Col13, "Plan Type");	*/
		
	/*	String Col1 = verificationhelper.getText(Column1);
		Assert.assertEquals(Col1, "Obj Name");
		String Col2 = verificationhelper.getText(Column2);
		Assert.assertEquals(Col2, "Gold Order Number");
		String Col3 = verificationhelper.getText(Column3);
		Assert.assertEquals(Col3, "Is Urgent Case");
		String Col4 = verificationhelper.getText(Column4);
		Assert.assertEquals(Col4, "Missing Info");
		String Col5 = verificationhelper.getText(Column5);
		Assert.assertEquals(Col5, "Customer Name");
		String Col6 = verificationhelper.getText(Column6);
		Assert.assertEquals(Col6, "Case ID");
		String Col7 = verificationhelper.getText(Column7);
		Assert.assertEquals(Col7, "Task ID");
		String Col8 = verificationhelper.getText(Column8);
		Assert.assertEquals(Col8, "Task Name");
		String Col9 = verificationhelper.getText(Column9);
		Assert.assertEquals(Col9, "Select Task to Reassign");
		String Col10 = verificationhelper.getText(Column10);
		Assert.assertEquals(Col10, "Task Status");
		String Col11 = verificationhelper.getText(Column11);
		Assert.assertEquals(Col11, "Sub Task Name");
		String Col12 = verificationhelper.getText(Column12);
		Assert.assertEquals(Col12, "Select Sub task to Reassign");
		String Col13 = verificationhelper.getText(Column13);
		Assert.assertEquals(Col13, "Dead Line");
		String Col14 = verificationhelper.getText(Column14);
		Assert.assertEquals(Col14, "Can Start");
		String Col15 = verificationhelper.getText(Column15);
		Assert.assertEquals(Col15, "Plan Type"); 	*/
		
		}
	
	public void compareColumnNames_BillingSupervisor()
	{
		String Col25 = verificationhelper.getText(Column25);
		Assert.assertEquals(Col25, "Obj Name");
		String Col26 = verificationhelper.getText(Column26);
		Assert.assertEquals(Col26, "Gold Order Number");
		String Col27 = verificationhelper.getText(Column27);
		Assert.assertEquals(Col27, "Is Urgent Case");
		String Col28 = verificationhelper.getText(Column28);
		Assert.assertEquals(Col28, "Missing Info");
		String Col29 = verificationhelper.getText(Column29);
		Assert.assertEquals(Col29, "Customer Name");
		String Col30 = verificationhelper.getText(Column30);
		Assert.assertEquals(Col30, "Case ID");
		String Col31 = verificationhelper.getText(Column31);
		Assert.assertEquals(Col31, "Task ID");
		String Col32 = verificationhelper.getText(Column32);
		Assert.assertEquals(Col32, "Task Name");
		String Col33 = verificationhelper.getText(Column33);
		Assert.assertEquals(Col33, "Select Task to Reassign");
		//String Col10 = verificationhelper.getText(Column10);
		//Assert.assertEquals(Col10, "Task Status");
		String Col34 = verificationhelper.getText(Column34);
		Assert.assertEquals(Col34, "Sub Task Name");
		String Col35 = verificationhelper.getText(Column35);
		Assert.assertEquals(Col35, "Select Sub task to Reassign");
		String Col36 = verificationhelper.getText(Column36);
		Assert.assertEquals(Col36, "Dead Line");
		String Col37 = verificationhelper.getText(Column37);
		Assert.assertEquals(Col37, "Can Start");
		String Col38 = verificationhelper.getText(Column38);
		Assert.assertEquals(Col38, "Plan Type");
		
		
	/*	String Col1 = verificationhelper.getText(Column1);
		Assert.assertEquals(Col1, "Obj Name");
		String Col2 = verificationhelper.getText(Column2);
		Assert.assertEquals(Col2, "Gold Order Number");
		String Col3 = verificationhelper.getText(Column3);
		Assert.assertEquals(Col3, "Is Urgent Case");
		String Col4 = verificationhelper.getText(Column4);
		Assert.assertEquals(Col4, "Missing Info");
		String Col5 = verificationhelper.getText(Column5);
		Assert.assertEquals(Col5, "Customer Name");
		String Col6 = verificationhelper.getText(Column6);
		Assert.assertEquals(Col6, "Case ID");
		String Col7 = verificationhelper.getText(Column7);
		Assert.assertEquals(Col7, "Task ID");
		String Col8 = verificationhelper.getText(Column8);
		Assert.assertEquals(Col8, "Task Name");
		String Col9 = verificationhelper.getText(Column9);
		Assert.assertEquals(Col9, "Select Task to Reassign");
		//String Col10 = verificationhelper.getText(Column10);
		//Assert.assertEquals(Col10, "Task Status");
		String Col11 = verificationhelper.getText(Column11);
		Assert.assertEquals(Col11, "Sub Task Name");
		String Col12 = verificationhelper.getText(Column12);
		Assert.assertEquals(Col12, "Select Sub task to Reassign");
		String Col13 = verificationhelper.getText(Column13);
		Assert.assertEquals(Col13, "Dead Line");
		//String Col14 = verificationhelper.getText(Column14);
		//Assert.assertEquals(Col14, "Can Start");
		String Col15 = verificationhelper.getText(Column15);
		Assert.assertEquals(Col15, "Plan Type");	*/
	}
	
	public void compareColumnNamesMyWork_BillingUser1()
	{
		String Col1 = verificationhelper.getText(Column1);
		Assert.assertEquals(Col1, "Urgency");
		String Col2 = verificationhelper.getText(Column2);
		Assert.assertEquals(Col2, "Gold Order Number");
		String Col3 = verificationhelper.getText(Column3);
		Assert.assertEquals(Col3, "Expedite Case");
		String Col4 = verificationhelper.getText(Column4);
		Assert.assertEquals(Col4, "Missing Info");
		String Col5 = verificationhelper.getText(Column5);
		Assert.assertEquals(Col5, "Customer Name");
		String Col6 = verificationhelper.getText(Column6);
		Assert.assertEquals(Col6, "Case ID");
		String Col7 = verificationhelper.getText(Column7);
		Assert.assertEquals(Col7, "Task ID");
		String Col8 = verificationhelper.getText(Column8);
		Assert.assertEquals(Col8, "Task Name");
		String Col9 = verificationhelper.getText(Column9);
		Assert.assertEquals(Col9, "Task Status");
		//String Col10 = verificationhelper.getText(Column10);
		//Assert.assertEquals(Col10, "Sub Task Name");
		String Col11 = verificationhelper.getText(Column11);
		Assert.assertEquals(Col11, "Sub Task Deadline");
		String Col12 = verificationhelper.getText(Column12);
		Assert.assertEquals(Col12, "Can Start");
		String Col13 = verificationhelper.getText(Column13);
		Assert.assertEquals(Col13, "Plan Type");
		//String Col14 = verificationhelper.getText(Column14);
		//Assert.assertEquals(Col14, "Cisco Update");
	}
	public void singleClickCheck() throws InterruptedException
	{
		NewOrderTask.click();// Check for single click
		Thread.sleep(10000);
	}
	
	public void singleClickCheck_ValidateOrder() throws InterruptedException
	{
		ValidateOrderTask.click();	// Check for single click
		Thread.sleep(10000);
	}
	
	public void singleClickCheck_OnlineInterventionOrder() throws InterruptedException
	{
		ValidateOrderTask.click();// Check for single click
		log.info("Validate order click is done");
		Thread.sleep(15000);
	}
	
	public void logOff() throws InterruptedException
	{
		driver.switchTo().defaultContent();
		LogOff.click();
		Thread.sleep(5000);
	}
}
