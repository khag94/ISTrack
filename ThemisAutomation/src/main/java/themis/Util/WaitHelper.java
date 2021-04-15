package themis.Util;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import themis.TestBase.TestBase;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitHelper extends TestBase{

	public static final Logger log =Logger.getLogger(WaitHelper.class.getName());
	
	public void setImplicitWait(long timeout, TimeUnit unit) {
		log.info("Implicit Wait has been set to: " + timeout);
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

	
	private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
	}

	
	public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds,
			int pollingEveryInMiliSec) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}

	
	public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("element is clickable now");
	}


	public boolean waitForElementNotPresent(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("element is invisibile now");
		return status;
	}

	public void waitForframeToBeAvailableAndSwitchToIt(WebElement element, long timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is available and switched");
	}

	
	private Wait<WebDriver> getfluentWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
		return fWait;
	}
	
	public WebElement waitForElement(WebElement element, int timeOutInSeconds, int pollingEveryInMiliSec){
		Wait<WebDriver> fwait = getfluentWait(timeOutInSeconds, pollingEveryInMiliSec);
		fwait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public void pageLoadTime(long timeout, TimeUnit unit){
		log.info("waiting for page to load for : "+ unit+ " seconds");
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		driver.manage().window().maximize();
		log.info("page is loaded");
	}
	
	
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}
	
	public void waitForAlertIsPresent(int timeOutInSeconds) {
		try {
			log.info("waiting for Alert for :" + timeOutInSeconds + " seconds");
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.alertIsPresent());
			log.info("Alert is visible now");
		} catch(NoAlertPresentException e){
			log.info("No Alert Present");
		}
	}
	
	
	public static void resolveAllAlerts(int timeout, boolean accept) {
	    while (isAlertPresent(timeout)) {
	        resolveAlert(accept);
	    }
	}


	private static boolean isAlertPresent(int timeout) {
	    try {
	        Alert a = new WebDriverWait(driver, timeout).until(ExpectedConditions.alertIsPresent());
	        if (a != null) {
	            return true;
	        } else {
	            throw new TimeoutException();
	        }
	    } catch (TimeoutException e) {
	        // log the exception;
	        return false;
	    }
	}

	private static void resolveAlert(boolean accept) {
	    if (accept) {
	        driver.switchTo().alert().accept();
	    } else {
	        driver.switchTo().alert().dismiss();
	    }
	}
	
	

}
	
	