package themis.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import themis.Util.AlertHelper;
import themis.Util.WebEventListeners;

public class TestBase {
	
	

	// public static String Env =System.getProperty("propertyName");

	/*
	 * public static String Suite1 =System.getProperty("suiteXmlFile"); public
	 * static String[] parts = Suite1.split("\\."); public static String Suite =
	 * parts[0];
	 */
	
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListeners eventListener;
	public static DesiredCapabilities capabilities;
	public static FirefoxProfile profile;
	public static InternetExplorerOptions options;
	public static String Env="AM";
	public static String Url="http://themisam.equant.com/prweb/O2NV4ErAPF1xLsZZ4QkQhVYKJDwTslO-*/!STANDARD";//AM
	public static String Env1="E1";
	public static String Env2="Production";
	public static String Url1="http://10.238.114.158:9500/prweb/O2NV4ErAPF1xLsZZ4QkQhVYKJDwTslO-*/!STANDARD";//E1
	public static String Url2="http://themisprod.equant.com/prweb/O2NV4ErAPF1xLsZZ4QkQhVYKJDwTslO-*/!STANDARD";//Prod
	public static String Subject="IS TRACK Automated Report";

	// public static ExtentReports extent;
	// public static ExtentTest test;

	public static File reportDirectory;

	// public static String downloadPath =
	// "C:\\Users\\XMJF0501\\Downloads\\TemplateDownload";
	
	@BeforeSuite
	public void init()
	{
		String workingDir = System.getProperty("user.dir");
		reportDirectory = new File(workingDir+"\\screenshots");
		
	}

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/themis/Config/UAT.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

	}

	public static void initialization() throws InterruptedException {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			capabilities = DesiredCapabilities.firefox();
			profile = new FirefoxProfile();
			profile.setPreference("security.ssl.enable_ocsp_stapling", false);
			profile.setPreference("security.ssl.errorReporting.automatic", false);
			
				profile.setPreference("security.tls.version.min", 1);
			
			profile.setPreference("intl.accept_languages", "en");

			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.manager.showWhenStarting", false);
			// Set downloadPath
			// profile.setPreference("browser.download.dir", downloadPath);
			// Set File Open &amp; Save preferences
			profile.setPreference("browser.helperApps.neverAsk.openFile",
					"text/csv,text/xlsx,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
					"text/csv,text/xlsx,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			profile.setPreference("browser.helperApps.alwaysAsk.force", false);
			profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
			profile.setPreference("browser.download.manager.focusWhenStarting", false);
			profile.setPreference("browser.download.manager.useWindow", false);
			profile.setPreference("browser.download.manager.showAlertOnComplete", false);
			profile.setPreference("browser.download.manager.closeWhenDone", false);
			

			// profile.setPreference("marionette", true);

			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			 //System.setProperty("webdriver.firefox.marionette",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
			//capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			driver = new FirefoxDriver(capabilities);
			
		} else if (browserName.equalsIgnoreCase("IE")) {
			capabilities = DesiredCapabilities.internetExplorer();

			options = new InternetExplorerOptions();

			options.setCapability("intl.accept_languages", "en");
			options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			options.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
			options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

			options.setCapability("browser.download.folderList", 2);
			options.setCapability("browser.download.manager.showWhenStarting", false);
			// Set downloadPath
			// options.setCapability("browser.download.dir", downloadPath);
			// Set File Open &amp; Save preferences
			options.setCapability("browser.helperApps.neverAsk.openFile",
					"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			options.setCapability("browser.helperApps.neverAsk.saveToDisk",
					"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			options.setCapability("browser.helperApps.alwaysAsk.force", false);
			options.setCapability("browser.download.manager.alertOnEXEOpen", false);
			options.setCapability("browser.download.manager.focusWhenStarting", false);
			options.setCapability("browser.download.manager.useWindow", false);
			options.setCapability("browser.download.manager.showAlertOnComplete", false);
			options.setCapability("browser.download.manager.closeWhenDone", false);

			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
			//driver = new InternetExplorerDriver(capabilities);
			driver = new RemoteWebDriver(capabilities);
		} else if (browserName.equalsIgnoreCase("Phantom")) {
			System.setProperty("phantomjs.binary.path", "C:\\JAR\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
			driver = new PhantomJSDriver();
		}
		else if(browserName.equalsIgnoreCase("EdgeChromium"))
		{
			//ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.setBinary(
			//System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
			System.setProperty("webdriver.edge.driver",
	                System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
	              //  EdgeOptions edgeOptions = new EdgeOptions().merge(chromeOptions);
	               // driver = new EdgeDriver(edgeOptions);
			driver = new EdgeDriver();
			//DesiredCapabilities m_capability = DesiredCapabilities.edge();
			//WebDriver driver = new EdgeDriver(m_capability);
			//driver = new RemoteWebDriver(m_capability);
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		 eventListener = new WebEventListeners();
		 e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

		//driver.get(prop.getProperty("guardian_url"));
		//waitForAlertIsPresent1(40);
		//dismissAlertIfPresent1();
	}
	
	
	public static void dismissAlertIfPresent1(){
		if(isAlertPresent1()){
			dismissAlert1();
		}
		else{
			log.info("Alert is not present..");
		}
	}
	
	public static boolean isAlertPresent1(){
		try{
			driver.switchTo().alert();
			log.info("alert is present");
			return true;
		}
		catch(NoAlertPresentException e){
			log.info(e.getCause());
			return false;
		}
	}
	
	public static void dismissAlert1(){
		getAlert1().dismiss();
		log.info("dismiss Alert is done...");
	}
	
	public static Alert getAlert1(){
		log.info("alert test: "+driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	
	public static void waitForAlertIsPresent1(int timeOutInSeconds) {
		try {
			log.info("waiting for Alert for :" + timeOutInSeconds + " seconds");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.alertIsPresent());
			log.info("Alert is visible now");
		} catch(NoAlertPresentException e){
			log.info("No Alert Present");
		}
	}
	
	

}

