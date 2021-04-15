package themis.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import themis.TestBase.TestBase;



public class ExcelHelper extends TestBase {
	
	public static final Logger log =Logger.getLogger(ExcelHelper.class.getName());

	public static final Object[][] ResultOrder = null;
	
	VerificationHelper verification = new VerificationHelper();

	
	public static Workbook book;
	public static Sheet sheet;

	public static Object[][] getTestDataExcel(String ExcelLocation, String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(ExcelLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

			}
		}
		return data;

	}
	
	/*public static Object[][] setTestDataGoldOrder(String ExcelLocation, String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(ExcelLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				 data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				//String sValue1=rownum.getCell(0).toString();       
				//String ResultOrder = ((String) data[i][k]).replaceAll("[^\\d.-]", "");

			}
		}
	//	return ResultOrder;
		return data;

	}*/

	/*
	 * public Object[][] getExcelData(String excelLocation, String sheetName) {
	 * 
	 * try { Object dataSets[][] = null; FileInputStream file = new
	 * FileInputStream(new File(excelLocation)); // Create Workbook instance
	 * XSSFWorkbook workbook = new XSSFWorkbook(file);
	 * 
	 * // Get sheet Name from Workbook XSSFSheet sheet =
	 * workbook.getSheet(sheetName);
	 * 
	 * // count number of active rows in excel sheet int totalRow =
	 * sheet.getLastRowNum(); System.out.println(totalRow); // count active columns
	 * in row int totalColumn = sheet.getRow(0).getLastCellNum();
	 * 
	 * dataSets = new Object[totalRow][totalColumn-1];
	 * 
	 * // Iterate Through each Rows one by one. Iterator<Row> rowIterator =
	 * sheet.iterator(); int i = 0; while (rowIterator.hasNext()) { i++; // for
	 * Every row , we need to iterator over columns Row row = rowIterator.next();
	 * Iterator<Cell> cellIterator = row.cellIterator(); int j = 0; while
	 * (cellIterator.hasNext()) {
	 * 
	 * Cell cell = cellIterator.next(); if
	 * (cell.getStringCellValue().contains("Start")) { i = 0; break; } switch
	 * (cell.getCellTypeEnum()) { case STRING: dataSets[i-1][j++] =
	 * cell.getStringCellValue(); break; case NUMERIC: dataSets[i-1][j++] =
	 * cell.getNumericCellValue(); break; case BOOLEAN: dataSets[i-1][j++] =
	 * cell.getBooleanCellValue(); case FORMULA: dataSets[i-1][j++] =
	 * cell.getCellFormula(); break;
	 * 
	 * default: System.out.println("no matching enum date type found"); break; } } }
	 * return dataSets; } catch (Exception e) { e.printStackTrace(); } return null;
	 * }
	 */

	public void updateResult(String excelLocation, String sheetName, String testCaseName, String testStatus) {
		try {
			FileInputStream file = new FileInputStream(new File(excelLocation));
			// Create Workbook instance
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get sheet Name from Workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active rows in excel sheet
			int totalRow = sheet.getLastRowNum() + 1;
			for (int i = 1; i < totalRow; i++) {
				XSSFRow r = sheet.getRow(i);
				String ce = r.getCell(0).getStringCellValue();
				if (ce.contains(testCaseName)) {
					r.createCell(1).setCellValue(testStatus);
					file.close();
					log.info("result updated..");
					FileOutputStream out = new FileOutputStream(new File(excelLocation));
					workbook.write(out);
					out.close();
					break;
				}
			}
		} catch (Exception e) {

		}
	}
	
	public void updateGoldOrderInExcel(String ExcelLocation, String SheetName, String Text) {
		try {
				System.out.println("order to be stored in Excel::::"+Text);
				String Result = Text.replaceAll("[^a-zA-Z0-9-]", "");
				System.out.println("order:"+Result);
				FileInputStream fis=new FileInputStream(ExcelLocation);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sheet=wb.getSheet(SheetName);      
				int rowsnum = sheet.getLastRowNum();
				Row row1 = sheet.createRow(rowsnum+1);
				Cell cell1 = row1.createCell(0);
				
				cell1.setCellValue(Result);
				FileOutputStream fout = new FileOutputStream(ExcelLocation); 
				wb.write(fout);         
				fout.close();
			}
		 catch (Exception e) {

		}
	}
	/*public String setGoldOrder(String ExcelLocation, String SheetName ) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		FileInputStream fis=new FileInputStream(ExcelLocation);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet =wb.getSheet(SheetName);         
		int rowsnum = sheet.getLastRowNum();
		Row rownum = sheet.getRow(rowsnum);
		String sValue1=rownum.getCell(0).toString();       
		String ResultOrder = sValue1.replaceAll("[^\\d.-]", "");
		
		System.out.println("order:"+ResultOrder);
		return ResultOrder;
		}*/

	/*
	 * public static void main(String[] args) { ExcelHelper excelHelper = new
	 * ExcelHelper(); String excelLocation =
	 * ResourceHelper.getResourcePath("src/main/java/flip/Data/FlipData.xlsx"); //
	 * Object[][] data = excelHelper.getExcelData(excelLocation, "loginData"); //
	 * System.out.println(data); // excelHelper.updateResult(excelLocation,
	 * "TestScripts", "Login", "PASS"); // excelHelper.updateResult(excelLocation,
	 * "TestScripts", "Registration", "FAIL"); //
	 * excelHelper.updateResult(excelLocation, "TestScripts", "Add to Cart",
	 * "PASS");
	 * 
	 * }
	 */
	
public String getDataFromExcel(String ExcelLocation,String SheetName) throws EncryptedDocumentException, InvalidFormatException, IOException

{                                 

//     System.out.println("order:"+result_order);

	FileInputStream fis=new FileInputStream(ExcelLocation);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sheet =wb.getSheet(SheetName);         
	int rowsnum = sheet.getLastRowNum();
	Row rownum = sheet.getRow(rowsnum);
	String Order=rownum.getCell(0).toString();       
	return Order;
	//driver.findElement(fetchObject(sObjectName)).sendKeys(result_order);
	//Thread.sleep(3000);
	//break;

}  

	public void FlipOutputExcel(String SUID, String SheetName, String Environment)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream opfis1 = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/FlipData/FLIPData.xlsx");
		Workbook opwb1 = WorkbookFactory.create(opfis1);
		Sheet opsheet = opwb1.getSheet(SheetName);
		int oprowsnum = opsheet.getLastRowNum();
		Row row1 = opsheet.createRow(oprowsnum + 1);
		Cell cell1 = row1.createCell(0);
		Cell cell2 = row1.createCell(1);
		Cell cell3 = row1.createCell(2);
		/*
		 * Cell cell4 = row1.createCell(3); Cell cell5 = row1.createCell(4);
		 */

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		System.out.println(dateFormat.format(date));

		cell1.setCellValue(SUID);
		cell2.setCellValue(dateFormat.format(date));
		cell3.setCellValue(Environment);
		/*
		 * cell4.setCellValue(cDATE); cell5.setCellValue(oDDP);
		 */

		FileOutputStream opfout = new FileOutputStream(
				System.getProperty("user.dir") + "/src/main/java/FlipData/FLIPData.xlsx");
		opwb1.write(opfout);
		opfout.close();
	}

	public void FlipOutputExcelSingleRowUpdate(String SUID, String SheetName, String Environment)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		FileInputStream opfis1 = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/java/FlipData/Data.xlsx");
		Workbook opwb1 = WorkbookFactory.create(opfis1);
		Sheet opsheet = opwb1.getSheet(SheetName);
		int oprowsnum = opsheet.getFirstRowNum();
		Row row1 = opsheet.createRow(oprowsnum + 1);
		// Row row1 = opsheet.getRow(oprowsnum+1);
		Cell cell1 = row1.createCell(0);
		Cell cell2 = row1.createCell(1);
		Cell cell3 = row1.createCell(2);
		/*
		 * Cell cell4 = row1.createCell(3); Cell cell5 = row1.createCell(4);
		 */

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		System.out.println(dateFormat.format(date));

		cell1.setCellValue(SUID);
		cell2.setCellValue(dateFormat.format(date));
		cell3.setCellValue(Environment);
		/*
		 * cell4.setCellValue(cDATE); cell5.setCellValue(oDDP);
		 */

		FileOutputStream opfout = new FileOutputStream(
				System.getProperty("user.dir") + "/src/main/java/FlipData/Data.xlsx");
		opwb1.write(opfout);
		opfout.close();
	}

	public void FlipPOCMRowUpdate(String SheetName)throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		FileInputStream file = new FileInputStream(new File("C:\\Scripts\\FLIP_InterfaceRegressionSuite\\Template\\POCMEngagement.xlsx"));
		Workbook opwb1 = WorkbookFactory.create(file);
		Sheet opsheet = opwb1.getSheet(SheetName);
		
		  int oprowsnum = opsheet.getFirstRowNum();
		  
		  for(int i=1;i<=6;i++)
		  {
		  Row row1 =opsheet.getRow(oprowsnum+i);
		  Cell cell1 = row1.getCell(17); 
		  cell1.setCellValue("FCW"+VerificationHelper.addDateTime());
		  System.out.println("Serial No Updated in Excel : FCW"+VerificationHelper.addDateTime());
		  log.info("Serial No Updated in Excel : FCW"+VerificationHelper.addDateTime());
		  Thread.sleep(2000);
		  }
		

		/*
		 * cell1.setCellValue(SUID); cell2.setCellValue(dateFormat.format(date));
		 * cell3.setCellValue(Environment);
		 */
		/*
		 * cell4.setCellValue(cDATE); cell5.setCellValue(oDDP);
		 */

		  FileOutputStream opfout = new FileOutputStream(new File("C:\\Scripts\\FLIP_InterfaceRegressionSuite\\Template\\POCMEngagement.xlsx"));
		opwb1.write(opfout);
		opfout.close();
	}
	
	@Test
	public void FlipPOCMRenewalUpdate()throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		FileInputStream file = new FileInputStream(new File("C:\\Scripts\\FLIP_InterfaceRegressionSuite\\Template\\POCMEngagement.xlsx"));
		Workbook opwb1 = WorkbookFactory.create(file);
		Sheet opsheet = opwb1.getSheet("POCMEngagementFile");
		
		 // int oprowsnum = opsheet.getFirstRowNum();
		int oprowsnum = opsheet.getLastRowNum();
		  for(int i=1;i<oprowsnum;i++)
		  {
		  Row row1 =opsheet.getRow(i);
		  Cell cell1 = row1.getCell(21); 
		  System.out.println(cell1.toString().trim());
		  
			/*
			 * cell1.setCellValue("FCW"+VerificationHelper.addDateTime());
			 * System.out.println("Serial No Updated in Excel : FCW"+VerificationHelper.
			 * addDateTime());
			 * log.info("Serial No Updated in Excel : FCW"+VerificationHelper.addDateTime())
			 * ;
			 */
		  Thread.sleep(2000);
		  }
		

		/*
		 * cell1.setCellValue(SUID); cell2.setCellValue(dateFormat.format(date));
		 * cell3.setCellValue(Environment);
		 */
		/*
		 * cell4.setCellValue(cDATE); cell5.setCellValue(oDDP);
		 */

		  FileOutputStream opfout = new FileOutputStream(new File("C:\\Scripts\\FLIP_InterfaceRegressionSuite\\Template\\POCMEngagement.xlsx"));
		opwb1.write(opfout);
		opfout.close();
	}
	public void updateResult(String ExcelLocation, String SheetName, String Text) {
		try {
				System.out.println("order to be stored in Excel::::"+Text);
				//String Result = Text.replaceAll("[^a-zA-Z0-9-]", "");
				//System.out.println("order:"+Result);
				FileInputStream fis=new FileInputStream(ExcelLocation);
				Workbook wb=WorkbookFactory.create(fis);
				Sheet sheet=wb.getSheet(SheetName);     
				int rowsnum = sheet.getLastRowNum();
				Row row1 = sheet.createRow(rowsnum+1);
				//Cell cell1 = row1.createCell(1);
				Cell cell1 = row1.createCell(0);
				cell1.setCellValue(Text);
				FileOutputStream fout = new FileOutputStream(ExcelLocation); 
				wb.write(fout);         
				fout.close();
			}
		 catch (Exception e) {

		}
	}

}
