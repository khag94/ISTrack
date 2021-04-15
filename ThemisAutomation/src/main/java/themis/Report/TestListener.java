package themis.Report;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.relevantcodes.extentreports.LogStatus;

import themis.JiraIssue.RestAssuredTesting;
import themis.TestBase.TestBase;


public class TestListener extends TestBase implements ITestListener {
	
	RestAssuredTesting rest = new RestAssuredTesting();
	 private static String getTestMethodName(ITestResult iTestResult) {
	        return iTestResult.getMethod().getConstructorOrMethod().getName();
	    }
	    
	    //Before starting all tests, below method runs.
	   // @Override
	    public void onStart(ITestContext iTestContext) {
	        System.out.println("I am in onStart method " + iTestContext.getName());
	        iTestContext.setAttribute("WebDriver", this.driver);
	        
	        
	    }
	 
	    //After ending all tests, below method runs.
	   // @Override
	    public void onFinish(ITestContext iTestContext) {
	        System.out.println("I am in onFinish method " + iTestContext.getName());
	        //Do tier down operations for extentreports reporting!
	        ExtentTestManager.endTest();
	        ExtentManager.getReporter().flush();
	    }
	 
	  //  @Override
	    public void onTestStart(ITestResult iTestResult) {
	        System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start");
	        //Start operation for extentreports.
	        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),"");
	    }
	 
	  //  @Override
	    public void onTestSuccess(ITestResult iTestResult) {
	        System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed");
	        //Extentreports log operation for passed tests.
	        ExtentTestManager.getTest().log(LogStatus.PASS, getTestMethodName(iTestResult)+ " Test passed");
	    }
	 
	  //  @Override
	    public void onTestFailure(ITestResult iTestResult) {
	        System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed");
	     //   ExtentTestManager.getTest().log(LogStatus.FAIL, getTestMethodName(iTestResult)+ " Test failed");
	        //Get driver from BaseTest and assign to local webdriver variable.
	       // Object testClass = iTestResult.getInstance();
	       // driver = ((TestBase) testClass).driver;
	 
	        //Take base64Screenshot screenshot.
	        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
	                getScreenshotAs(OutputType.BASE64);
	        
	        ExtentTestManager.getTest().log(LogStatus.FAIL, getTestMethodName(iTestResult)+ " Test failed",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	        String Description = iTestResult.getThrowable().toString();
	        log.info("Description of failed test case method is :::"+Description);
	        String imagePath = captureScreen(iTestResult.getName());
	        /*
	        try {
				rest.finalJiraIssue(imagePath,Description);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //Extentreports log and screenshot operations for failed tests.
	      //  ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
	        	catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        */
	        
	    }
	 
	  //  @Override
	    public void onTestSkipped(ITestResult iTestResult) {
	        System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped");
	        //Extentreports log operation for skipped tests.
	        ExtentTestManager.getTest().log(LogStatus.SKIP,getTestMethodName(iTestResult)+ " Test Skipped");
	    }
	 
	 //   @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	    }
	    
	    public String captureScreen(String fileName){
			if(driver == null){
				log.info("driver is null..");
				return null;
			}
			if(fileName==""){
				fileName = "blank";
			}
			Reporter.log("captureScreen method called");
			File destFile = null;
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			File screFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try{
				destFile = new File(reportDirectory+"/"+Env+"_"+fileName+"_"+formater.format(calendar.getTime())+".png");
				//destFile = new File(reportDirectery+"/QA_"+fileName+"_"+formater.format(calendar.getTime())+".png");
				Files.copy(screFile.toPath(), destFile.toPath());
				Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100' width='100'/></a>");
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return destFile.toString();
		}
}
