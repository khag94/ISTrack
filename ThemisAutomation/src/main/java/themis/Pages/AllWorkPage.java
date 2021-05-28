package themis.Pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import themis.TestBase.TestBase;
import themis.Util.ExcelHelper;
import themis.Util.ReusableMethods;
import themis.Util.VerificationHelper;
import themis.Util.WaitHelper;

public class AllWorkPage extends TestBase{
	public static final Logger log =Logger.getLogger(AllWorkPage.class.getName());
	
	ExcelHelper excelhelper = new ExcelHelper();
	WaitHelper waithelper = new WaitHelper();
	VerificationHelper verificationhelper = new VerificationHelper();
	ReusableMethods reuse = new ReusableMethods();
	
	String ExcelPath=System.getProperty("user.dir")+"/src/main/java/themis/Data/GoldThemis.xlsx";
	String SheetName1="Sheet2";
	
	@FindBy(xpath = "(//input[contains(@id,'OrderNumber')])[1]")
	public WebElement GoldOrderNumber;
	
	@FindBy(xpath = "//button[contains(@name,'SearchAllCases_pyPortal_13')]")
	public WebElement SearchGoldOrder;
	
	@FindBy(xpath = "(//div[@class='oflowDivM '][contains(.,'New Order')])[1]")
	public WebElement NewOrderTask;
		
	@FindBy(xpath = "(//div[@class='oflowDivM '][contains(.,'EquipmentProcurement')])[1]")
	public WebElement EquipmentProcurementTask;
	
	@FindBy(xpath = "(//div[@class='oflowDivM '][contains(.,'Track Supplier Delivery (SP)')])[1]")
	public WebElement TrackSupplierDeliverySPTask;
	
	@FindBy(xpath = "(//div[@class='oflowDivM '][contains(.,'ServiceProcurement')])[1]")
	public WebElement ServiceProcurementTask;
	
	@FindBy(xpath = "(//div[@class='oflowDivM '][contains(.,'Track Supplier Delivery (EP)')])[1]")
	public WebElement TrackSupplierDeliveryTask;
	
	@FindBy(xpath = "(//div[@class='oflowDivM '][contains(.,'TrackWareHouseDelivery')])[1]")
	public WebElement TrackWareHouseDeliveryTask;

	@FindBy(xpath = "(//div[@class='oflowDivM '][contains(.,'AcceptanceERS')])[1]")
	public WebElement AcceptanceERSTask;
	
	@FindBy(xpath = "(//div[@class='oflowDivM '][contains(.,'WareHouseStaging')])[1]")
	public WebElement WarehousingStaging;
	
	@FindBy(xpath = "//tr[@id='$PWorkListEmbedTask$ppxResults$l2']//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//span//a[contains(@href,'#')][contains(text(),'Service Procurement OCD')]")
	public WebElement ServiceProcurementOCDTask; //added by kp
	
	@FindBy(xpath = "//tr[@id='$PWorkListEmbedTask$ppxResults$l4']//td[contains(@class,'wrapText')]//div[contains(@class,'oflowDivM')]//span//a[contains(@href,'#')][contains(text(),'AcceptanceIS')]")
	public WebElement AcceptanceISTask; //added by kp
	
	@FindBy(xpath = "//label[contains(.,'All Work')]")
	public WebElement AllWork;
	
	@FindBy(xpath = "//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th")
	public List<WebElement> AllWorkTable;
	
	
	@FindBy(xpath = "//div[6]/div[3]/div/div/div/div/div[2]/span/div/table/tbody/tr/td/div/div/div/div[2]/div[2]/div/div/div/span/div/table[2]/tbody/tr/td/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th")
	public List<WebElement> AllWorkTableNew;
	
	@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[1]")
	public WebElement Column1;
	
	@FindBy(xpath = "//body[@id='yui-gen11']/div[@id='layout-doc']/div[@id='l2']/div[@id='yui-gen14']/div[@id='laygen2']/div[@id='PEGA_LU_C']/div[@id='RULE_KEY']/div[@id='CT']/span[contains(@class,'inspector-span')]/div[@id='RULE_KEY']/table[contains(@role,'presentation')]/tbody/tr/td[contains(@class,'dataLabelWrite')]/div[@id='RULE_KEY']/div[@id='workarea']/div[@id='PEGA_TABBED0']/div[contains(@class,'yui-content tabContent')]/div[@id='INNERDIV-SubSectionMgrWAGadgetB']/div[@id='RULE_KEY']/span[contains(@class,'inspector-span')]/div[@id='RULE_KEY']/span[contains(@class,'inspector-span')]/div[@id='RULE_KEY']/table[@id='EXPAND-OUTERFRAME']/tbody/tr/td/div[@id='PEGA_GRID2']/div[@id='PEGA_GRID_SKIN']/div[@id='PEGA_GRID_CONTENT']/table[@id='gridLayoutTable']/tbody/tr/td[contains(@class,'mainGridTableCell')]/div[@id='gridBody_right']/table[@id='bodyTbl_right']/tbody/tr[contains(@class,'cellCont')]/th[2]/div[1]/div[1]/div[1]")
	public WebElement Column2;
	
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[3]")
	@FindBy(xpath = "//div[@id='PEGA_GRID2']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[@class='oflowDiv']//div[contains(@class,'divCont wrapHeader')]//div[contains(@class,'cellIn')][contains(text(),'Associated Gold#')]")
	public WebElement Column3;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[4]")
	@FindBy(xpath = "//div[@id='PEGA_GRID2']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont wrapHeader')]//div[contains(@class,'cellIn')][contains(text(),'Customer Name')]")
	public WebElement Column4;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[5]")
	@FindBy(xpath = "//div[@id='PEGA_GRID2']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[@class='oflowDiv']//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')][contains(text(),'Case ID')]")
	public WebElement Column5;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[6]")
	@FindBy(xpath = "//div[@id='PEGA_GRID2']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[@class='oflowDiv']//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')][contains(text(),'Task ID')]")
	public WebElement Column6;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[7]")
	@FindBy(xpath = "//body[@id='yui-gen11']/div[@id='layout-doc']/div[@id='l2']/div[@id='yui-gen14']/div[@id='laygen2']/div[@id='PEGA_LU_C']/div[@id='RULE_KEY']/div[@id='CT']/span[contains(@class,'inspector-span')]/div[@id='RULE_KEY']/table[contains(@role,'presentation')]/tbody/tr/td[contains(@class,'dataLabelWrite')]/div[@id='RULE_KEY']/div[@id='workarea']/div[@id='PEGA_TABBED0']/div[contains(@class,'yui-content tabContent')]/div[@id='INNERDIV-SubSectionMgrWAGadgetB']/div[@id='RULE_KEY']/span[contains(@class,'inspector-span')]/div[@id='RULE_KEY']/span[contains(@class,'inspector-span')]/div[@id='RULE_KEY']/table[@id='EXPAND-OUTERFRAME']/tbody/tr/td/div[@id='PEGA_GRID2']/div[@id='PEGA_GRID_SKIN']/div[@id='PEGA_GRID_CONTENT']/table[@id='gridLayoutTable']/tbody/tr/td[contains(@class,'mainGridTableCell')]/div[@id='gridBody_right']/table[@id='bodyTbl_right']/tbody/tr[contains(@class,'cellCont')]/th[7]/div[1]/div[1]/div[1]")
	public WebElement Column7;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[8]")
	@FindBy(xpath = "//div[contains(text(),'Task Status')]")
	public WebElement Column8;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[9]")
	@FindBy(xpath = "//div[@id='PEGA_GRID2']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont wrapHeader')]//div[contains(@class,'cellIn')][contains(text(),'Sub Task Name')]")
	public WebElement Column9;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[10]")
	@FindBy(xpath = "//div[contains(text(),'Current Owner')]")
	public WebElement Column10;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[11]")
	@FindBy(xpath = "//div[contains(text(),'Sub Task Deadline')]")
	public WebElement Column11;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[12]")
	@FindBy(xpath = "//div[@id='PEGA_GRID2']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')][contains(text(),'Can Start')]")
	public WebElement Column12;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[13]")
	@FindBy(xpath = "//div[@id='PEGA_GRID3']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')]//span//span[contains(@class,'leftJustifyStyle')][contains(text(),'ITDD')]")
	public WebElement Column13;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[14]")
	@FindBy(xpath = "//div[@id='PEGA_GRID2']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')]//span//span[contains(@class,'leftJustifyStyle')][contains(text(),'ITDD')]")
	public WebElement Column14;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[15]")
	@FindBy(xpath = "//div[@id='PEGA_GRID2']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')]//span//span[contains(@class,'leftJustifyStyle')][contains(text(),'RTDD')]")
	public WebElement Column15;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[16]")
	@FindBy(xpath = "//div[@id='PEGA_GRID2']//div[@id='PEGA_GRID_SKIN']//div[@id='PEGA_GRID_CONTENT']//table[@id='gridLayoutTable']//tbody//tr//td[contains(@class,'mainGridTableCell')]//div[@id='gridBody_right']//table[@id='bodyTbl_right']//tbody//tr[contains(@class,'cellCont')]//th[contains(@class,'pointerStyle')]//div[contains(@class,'oflowDiv')]//div[contains(@class,'divCont')]//div[contains(@class,'cellIn')]//span//span[contains(@class,'leftJustifyStyle')][contains(text(),'IST-EDD')]")
	public WebElement Column16;
	
	//@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[17]")
	@FindBy(xpath = "//div[contains(@class,'divCont wrapHeader')]//div[contains(@class,'cellIn')][contains(text(),'Date Delta')]")
	public WebElement Column17;
	
	@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[18]")
	public WebElement Column18;
	
	@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[19]")
	public WebElement Column19;
	
	@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[20]")
	public WebElement Column20;
	
	@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[21]")
	public WebElement Column21;
	
	@FindBy(xpath = "(//div/div/div/div/div/div[2]/table/tbody/tr/td[2]/div/table/tbody/tr/th)[22]")
	public WebElement Column22;
	public AllWorkPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void orderSearchAllWork() throws Throwable, InvalidFormatException, IOException
	{
		driver.switchTo().defaultContent();
		AllWork.click();
		//Thread.sleep(5000);
		waithelper.pageLoadTime(5, TimeUnit.SECONDS);
		String Order=excelhelper.getDataFromExcel(ExcelPath,SheetName1);
		log.info("Gold order imported from excel"+Order);
		GoldOrderNumber.sendKeys(Order);
		SearchGoldOrder.click();
		Thread.sleep(7000);
	}
	
	public void captureTaskNames() throws InterruptedException
	{
		
		String Task1 = verificationhelper.getText(NewOrderTask);
		System.out.println("Task1 name is:: "+ Task1);
		String Task2=verificationhelper.getText(EquipmentProcurementTask);
		System.out.println("Task2 name is:: "+ Task2);
		String Task3=verificationhelper.getText(TrackSupplierDeliveryTask);
		System.out.println("Task3 name is:: "+ Task3);
		String Task4=verificationhelper.getText(WarehousingStaging);
		System.out.println("Task4 name is:: "+ Task4);
		String Task5=verificationhelper.getText(AcceptanceERSTask);
		System.out.println("Task5 name is:: "+ Task5);
		Thread.sleep(10000);
	}
	
	public void captureTaskNames_VBSOrder() throws InterruptedException
	{
		
		String Task1 = verificationhelper.getText(NewOrderTask);
		System.out.println("Task1 name is:: "+ Task1);
		String Task2=verificationhelper.getText(TrackSupplierDeliverySPTask);
		System.out.println("Task2 name is:: "+ Task2);
		String Task3=verificationhelper.getText(ServiceProcurementTask);
		System.out.println("Task3 name is:: "+ Task3);
		String Task4=verificationhelper.getText(AcceptanceERSTask);
		System.out.println("Task4 name is:: "+ Task4);
		Thread.sleep(10000);
		}
	
	public void captureTaskNames_OCDServices() throws InterruptedException //function added by kp
	{
		String Task1 = verificationhelper.getText(NewOrderTask);
		System.out.println("Task name is: " + Task1);
		
		String Task2 = verificationhelper.getText(ServiceProcurementOCDTask);
		System.out.println("Task name is: " + Task2);
		
		String Task3 = verificationhelper.getText(AcceptanceISTask);
		System.out.println("Task name is: " + Task3);
		Thread.sleep(5000);
	}
		
	
	public void checkColumnNamesAndCount() throws IOException
	{
		
		reuse.takeScreenshot("AllWorkColumns/column_names");
		reuse.checkColumnNamesAndCount(AllWorkTable);
		}
		
	public void checkColumnNamesAndCount_new() throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		reuse.takeScreenshot("AllWorkColumns/column_names");
		reuse.checkColumnNamesAndCount(AllWorkTableNew);
		Thread.sleep(10000);
		}
	
	public void compareColumnNames_odmuser_new()
	{
		
		/*String Col1 = verificationhelper.getText(Column1);
		Assert.assertEquals(Col1, " "); */
		
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
		Assert.assertEquals(Col8, "Task Status");
		String Col9 = verificationhelper.getText(Column9);
		Assert.assertEquals(Col9, "Sub Task Name");
		String Col10 = verificationhelper.getText(Column10);
		Assert.assertEquals(Col10, "Current Owner");
		String Col11 = verificationhelper.getText(Column11);
		Assert.assertEquals(Col11, "Sub Task Deadline");
		String Col12 = verificationhelper.getText(Column12);
		Assert.assertEquals(Col12, "Can Start");
		String Col14 = verificationhelper.getText(Column14);
		Assert.assertEquals(Col14, "ITDD");
		String Col15 = verificationhelper.getText(Column15);
		Assert.assertEquals(Col15, "RTDD");
		String Col16 = verificationhelper.getText(Column16);
		Assert.assertEquals(Col16, "IST-EDD");
		String Col17 = verificationhelper.getText(Column17);
		Assert.assertEquals(Col17, "Date Delta");
		}
	public void compareColumnNames_odmuser()
	{
		
		/*String Col1 = verificationhelper.getText(Column1);
		Assert.assertEquals(Col1, " ");*/
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
		Assert.assertEquals(Col8, "Task Status");
		String Col9 = verificationhelper.getText(Column9);
		Assert.assertEquals(Col9, "Sub Task Name");
		String Col10 = verificationhelper.getText(Column10);
		Assert.assertEquals(Col10, "Current Owner");
		String Col11 = verificationhelper.getText(Column11);
		Assert.assertEquals(Col11, "Sub Task Deadline");
		String Col12 = verificationhelper.getText(Column12);
		Assert.assertEquals(Col12, "Can Start");
		String Col13 = verificationhelper.getText(Column13);
		Assert.assertEquals(Col13, "Plan Type");
		String Col14 = verificationhelper.getText(Column14);
		Assert.assertEquals(Col14, "ITDD");
		String Col15 = verificationhelper.getText(Column15);
		Assert.assertEquals(Col15, "RTDD");
		String Col16 = verificationhelper.getText(Column16);
		Assert.assertEquals(Col16, "IST-EDD");
		String Col17 = verificationhelper.getText(Column17);
		Assert.assertEquals(Col17, "Date Delta");
		String Col18 = verificationhelper.getText(Column18);
		Assert.assertEquals(Col18, "Last Replan");
		String Col19 = verificationhelper.getText(Column19);
		Assert.assertEquals(Col19, "Last Replan Effect");
		String Col20 = verificationhelper.getText(Column20);
		Assert.assertEquals(Col20, "Delay Count");
		String Col21 = verificationhelper.getText(Column21);
		Assert.assertEquals(Col21, "Applied Delay");
		
		/*
		Old column names
		Assert.assertEquals(Col2, "Urgency");
		Assert.assertEquals(Col3, "GoldOrderNumber");
		Assert.assertEquals(Col4, "Expedite Case");
		Assert.assertEquals(Col5, "Missing Info");
		Assert.assertEquals(Col6, "Customer Name");
		Assert.assertEquals(Col7, "CaseID");
		Assert.assertEquals(Col8, "Task ID");
		Assert.assertEquals(Col9, "Task Name");
		Assert.assertEquals(Col10, "Task Status");
		Assert.assertEquals(Col11, "Sub Task Name");
		Assert.assertEquals(Col12, "Sub Task Deadline");
		Assert.assertEquals(Col13, "Can Start");
		Assert.assertEquals(Col14, "PlanType");
		Assert.assertEquals(Col15, "Original Customer Agreed Delivery Date(ITDD)");
		Assert.assertEquals(Col16, "Current Customer Agreed Delivery Date");
		Assert.assertEquals(Col17, "Current Themis Estimated Delivery Date");
		Assert.assertEquals(Col18, "Date Delta");
		Assert.assertEquals(Col19, "Last Replan");
		Assert.assertEquals(Col20, "Last Replan Effect");
		Assert.assertEquals(Col21, "DelayCount");
		Assert.assertEquals(Col22, "AppliedDelay");
		*/
		}
		
	public void compareColumnNames_ProcurementUser()
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
		Assert.assertEquals(Col8, "Task Status");
		String Col9 = verificationhelper.getText(Column9);
		Assert.assertEquals(Col9, "Sub Task Name");
		String Col10 = verificationhelper.getText(Column10);
		Assert.assertEquals(Col10, "Current Owner");
		String Col11 = verificationhelper.getText(Column11);
		Assert.assertEquals(Col11, "Sub Task Deadline");
		String Col12 = verificationhelper.getText(Column12);
		Assert.assertEquals(Col12, "Can Start");
		//String Col13 = verificationhelper.getText(Column13);
		//Assert.assertEquals(Col13, "Plan Type");
		String Col14 = verificationhelper.getText(Column14);
		Assert.assertEquals(Col14, "ITDD");
		String Col15 = verificationhelper.getText(Column15);
		Assert.assertEquals(Col15, "RTDD");
		String Col16 = verificationhelper.getText(Column16);
		Assert.assertEquals(Col16, "IST-EDD");
		String Col17 = verificationhelper.getText(Column17);
		Assert.assertEquals(Col17, "Date Delta");
	/*	String Col18 = verificationhelper.getText(Column18);
		Assert.assertEquals(Col18, "Last Replan");
		String Col19 = verificationhelper.getText(Column19);
		Assert.assertEquals(Col19, "Last Replan Effect");
		String Col20 = verificationhelper.getText(Column20);
		Assert.assertEquals(Col20, "Delay Count");
		String Col21 = verificationhelper.getText(Column21);
		Assert.assertEquals(Col21, "Applied Delay"); */
		
		/*
		Assert.assertEquals(Col2, "Urgency");
		Assert.assertEquals(Col3, "GoldOrderNumber");
		Assert.assertEquals(Col4, "Expedite Case");
		Assert.assertEquals(Col5, "Missing Info");
		Assert.assertEquals(Col6, "Customer Name");
		Assert.assertEquals(Col7, "CaseID");
		Assert.assertEquals(Col8, "Task ID");
		Assert.assertEquals(Col9, "Task Name");
		Assert.assertEquals(Col10, "Task Status");
		Assert.assertEquals(Col11, "Sub Task Name");
		Assert.assertEquals(Col12, "Sub Task Deadline");
		Assert.assertEquals(Col13, "Can Start");
		Assert.assertEquals(Col14, "PlanType");
		Assert.assertEquals(Col15, "Original Customer Agreed Delivery Date(ITDD)");
		Assert.assertEquals(Col16, "Current Customer Agreed Delivery Date");
		Assert.assertEquals(Col17, "Current Themis Estimated Delivery Date");
		Assert.assertEquals(Col18, "Date Delta");
		Assert.assertEquals(Col19, "Last Replan");
		Assert.assertEquals(Col20, "Last Replan Effect");
		Assert.assertEquals(Col21, "DelayCount");
		Assert.assertEquals(Col22, "AppliedDelay");
		*/
		}
		
	
}
