package themis.Report;

import org.joda.time.DateTime;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	public static ExtentReports extent;

    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            //extent = new ExtentReports(workingDir+"\\reports\\ISTRACKAutomationReport.html", true);
            extent = new ExtentReports(workingDir+"\\reports\\ISTRACKAutomationReport_"+DateTime.now().toString("yyyy_MM_dd_HH_mm_ss")+".html");
            extent.addSystemInfo("User Name", "IS_TRACK");
    		//extent.addSystemInfo("Environment", Env);
    		extent.addSystemInfo("Browser Version", "68");
        }
        return extent;

    }
}
