package themis.Util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.nio.file.*;

import themis.TestBase.TestBase;


public class ReusableMethods extends TestBase
{
	public static final Logger log =Logger.getLogger(ReusableMethods.class.getName());
	public void checkColumnNamesAndCount(List<WebElement> ele) throws IOException
	{
		try
		{
			
			log.info(" NO of COlumns : "+ele.size());
			for(WebElement list : ele)
			{
				
				log.info("List Of Columns are::::"+list.getText());	
			}
		}
		catch(StaleElementReferenceException ex) 
		{
			log.info(ex.getMessage());
		}	
	}
	public void takeScreenshot(String FileName) throws IOException
	{
		Path screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE).toPath();
		System.out.println("screenshot done");
		BufferedImage img = ImageIO.read(screen.toFile());
		ImageIO.write(img, "jpg", screen.toFile()); 
		String currentDir1 = System.getProperty("user.dir");
		String filenamewithtime =  new SimpleDateFormat("yyyy-MM-dd HH-mm-ss'.txt'").format(new Date());
		File dest=new File(currentDir1 + "/ApplicationScreenshots/" + FileName + "_"+filenamewithtime + ".jpg");
		Files.copy(screen, dest.toPath());
		System.out.println("image copied");  
	}
	
	public static String getLatestFile() throws IOException
	{
		String currentDir1 = System.getProperty("user.dir");
		Path path = Files.walk(Paths.get(currentDir1+"//reports"))
		.filter(Files::isRegularFile).sorted((x,y)->
		{ int val = 0;
			try {
				val = -(new Date(Files.getLastModifiedTime(x).toMillis()).compareTo(new Date(Files.getLastModifiedTime(y).toMillis())));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return val;
		}).findFirst().get();
		return path.toString();
}
}
