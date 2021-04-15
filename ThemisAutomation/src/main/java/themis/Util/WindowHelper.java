package themis.Util;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import themis.TestBase.TestBase;




public class WindowHelper extends TestBase {
	
	
	public static final Logger log =Logger.getLogger(WindowHelper.class.getName());

	
	
	public void switchToParentWindow() {
		log.info("switching to parent window...");
		driver.switchTo().defaultContent();
	}

	public void switchToChildAndGetTitle()
	{
		for(String Child_window : driver.getWindowHandles()) 
		{
			driver.switchTo().window(Child_window);   
			System.out.println("Window got switched to"+Child_window);
			log.info(driver.getTitle());	
		}
	}
	
	public void switchToWindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == index) {
				log.info("switched to : "+index + " window");
				driver.switchTo().window(window);
				driver.manage().window().maximize();				
			} else {
				i++;
			}
		}
	}

	
	public void closeAllTabsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainwindow = driver.getWindowHandle();

		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainwindow)) {
				driver.close();
			}
		}
		log.info("switched to main window");
		driver.switchTo().window(mainwindow);
	}
	
	/**
	 * This method will do browser back navigation
	 */
	public void navigateBack(){
		log.info("navigating back");
		driver.navigate().back();
	}
	
	public void navigateForward(){
		log.info("navigating forward");
		driver.navigate().forward();
	}
	
	public void SwitchMultipleWindow(String PageTitle) throws InterruptedException
	{
		Thread.sleep(5000);
		Set < String > s = driver.getWindowHandles();   
	    Iterator < String > ite = s.iterator();
	    int i = 1;
	    while (ite.hasNext() && i <= s.size())
	    {
	    	String popupHandle = ite.next().toString();
	    	Thread.sleep(2000);
	        driver.switchTo().window(popupHandle);
	        Thread.sleep(2000);
	        System.out.println("Window title is : "+driver.getTitle());
	        log.info("Window title is : "+driver.getTitle());
	         i++;
	          if(driver.getTitle().equals(PageTitle))
	        {
	        	Thread.sleep(2000);
	        	driver.switchTo().window(popupHandle).getTitle().equals(PageTitle);
	        	Thread.sleep(2000);
	        	System.out.println("After Switch Window title is : "+driver.getTitle());
	        	 log.info("After Switch Window title is : "+driver.getTitle());
	        	driver.manage().window().maximize();
	        	 log.info("Window Maximized");
	        	break;
	        }
	    }
	}
	
	public void SwitchtoGuadianandClosePopWindow() {
		String Guardian = driver.getWindowHandle();  //will keep current window to switch back
		for(String winHandle : driver.getWindowHandles()){
		   if (driver.switchTo().window(winHandle).getTitle().equals("Information sur le Mot de Passe")) 
		   {
		     	driver.close();
		 
		   		}
		   else if (driver.switchTo().window(winHandle).getTitle().equals("Internal server error")) {
		     	driver.close();
		
		   		}
		   driver.switchTo().window(Guardian);
		 }
	}
	
	
	public void SwitchMultipleWindowURL(String PageURL) throws InterruptedException
	{
		Thread.sleep(5000);
		Set < String > s = driver.getWindowHandles();   
	    Iterator < String > ite = s.iterator();
	    int i = 1;
	    while (ite.hasNext() && i <= s.size())
	    {
	    	String popupHandle = ite.next().toString();
	    	Thread.sleep(2000);
	        driver.switchTo().window(popupHandle);
	        Thread.sleep(2000);
	        System.out.println("Window title is : "+driver.getCurrentUrl());
	         i++;
	          if(driver.getCurrentUrl().contains(PageURL))
	        {
	        	Thread.sleep(2000);
	        	driver.switchTo().window(popupHandle).getCurrentUrl().contains(PageURL);
	        	Thread.sleep(2000);
	        	System.out.println("After Switch Window title is : "+driver.getCurrentUrl());
	        	driver.manage().window().maximize();
	        	break;
	        }
	          
	        
	    }
	}
	
	public void SwitchMultipleWindowNotEqual(String PageTitle) throws InterruptedException
	{
		Thread.sleep(5000);
		Set < String > s = driver.getWindowHandles();   
	    Iterator < String > ite = s.iterator();
	    int i = 1;
	    while (ite.hasNext() && i <= s.size())
	    {
	    	String popupHandle = ite.next().toString();
	    	Thread.sleep(2000);
	        driver.switchTo().window(popupHandle);
	        Thread.sleep(2000);
	        System.out.println("Window title is : "+driver.getTitle());
	        log.info("Window title is : "+driver.getTitle());
	         i++;
	          if(!driver.getTitle().equalsIgnoreCase(PageTitle))
	        {
	        	Thread.sleep(2000);
	        	driver.switchTo().window(popupHandle);
	        	Thread.sleep(2000);
	        	System.out.println("After Switch Window title is : "+driver.getTitle());
	        	 log.info("After Switch Window title is : "+driver.getTitle());
	        	driver.manage().window().maximize();
	        	 log.info("Window Maximized");
	        	break;
	        }
	          
	        
	    }
	}
	

	
	

}
