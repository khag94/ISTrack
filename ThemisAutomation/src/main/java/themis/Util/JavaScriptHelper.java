package themis.Util;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import themis.TestBase.TestBase;




public class JavaScriptHelper extends TestBase {
	
	
	public static final Logger log =Logger.getLogger(JavaScriptHelper.class.getName());

	public Object executeScript(String script){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	
	
	public Object executeScript(String script, Object...args){
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script,args);
	}
	
	public void scrollToElement(WebElement element){
		log.info("scroll to WebElement...");
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	
	
	public void scrollToElementAndClick(WebElement element){
		scrollToElement(element);
		element.click();
		log.info("element is clicked: "+element.toString());
	}
	
	
	public void scrollIntoView(WebElement element){
		log.info("scroll till web element");
		executeScript("arguments[0].scrollIntoView()",element);
	}
	
	
	public void scrollIntoViewAndClick(WebElement element){
		scrollIntoView(element);
		element.click();
		log.info("element is clicked: "+element.toString());
	}
	
	
	public void scrollDownVertically(){
		log.info("scrolling down vertically...");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	
	public void scrollUpVertically(){
		log.info("scrolling up vertically...");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	
	public void scrollhorizontally(){
		log.info("scrolling right horizontally...");
		executeScript("window.scrollBy(2000,0)");
	}
	
	
	public void scrollDownByPixel(int pixel){
		executeScript("window.scrollBY(0,"+pixel+")");
	}
	
	public void scrollUpByPixel(int pixel){
		executeScript("window.scrollBY(0,-"+pixel+")");
	}
	
	
	public void zoomInBy100Percentage(){
		executeScript("document.body.style.zoom='100%'");
	}
	

	public void zoomInBy60Percentage(){
		executeScript("document.body.style.zoom='40%'");
	}
	

	public void clickElement(WebElement element){
		executeScript("arguments[0].click();", element);
	}
	
	public void HideCursor(){
		executeScript("document.body.style.cursor = 'none';");
	}
	public void closeAlert()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("closeSplashScreen();reloadScrollBars();");
	
	} 
	public void sendData(WebElement element,String Value)
	{
		//executeScript("document.getElementById('comment').value=\'"+Value+"\';");
		//executeScript("document.getElementById(element).value=\'"+Value+"\';");
		executeScript("arguments[0].value=\'"+Value+"\';", element);
	}


}
