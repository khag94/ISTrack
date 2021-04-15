package themis.Util;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.imageio.ImageIO;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import themis.Report.TestListener;
import themis.TestBase.TestBase;

import themis.Util.*;


public class AutoGenerateMail extends TestBase
{      
	static TestListener testlistener = new TestListener() ;
	
	@Test
	public void GenerateMail() throws InterruptedException, InvalidFormatException, IOException, AddressException, MessagingException
	//public void GenerateMail(String SSubject,List<String> L1,List<String> L2) throws InterruptedException, IOException, MessagingException
	{
		DateFormat dateFormat1 = new SimpleDateFormat("dd/MMM/yyyy");
		Date date1 = new Date();
		System.out.println(dateFormat1.format(date1)); 	
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		Thread.sleep(3000);

		//Taking Screenshots
		String latestFile= ReusableMethods.getLatestFile();
		System.out.println("Latest File imported is:: "+latestFile);
		driver.get("file:///"+latestFile);
	//in case of generating report and mail only
		//String ReportPath = ResourceHelper.getResourcePath("/reports/ISTRACKAutomationReport_2020_04_20_10_12_40.html");
		//driver.get("file:///"+ReportPath);
		//Thread.sleep(10000);
		driver.navigate().refresh();
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele1 = driver.findElement(By.xpath("//a[@class='dashboard-view']//i[@class='mdi-action-track-changes']")); 	        	 
		Thread.sleep(10000);
		ele1.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		//WebElement ele2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[@class='dashboard-view']")));
		//WebElement picture=driver.findElement(By.xpath("//canvas[@id='test-analysis']"));
		WebElement ele2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='dashboard-view']")));
		Thread.sleep(10000);
		File screen2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println("table screenshot done");
		int ImageWidth1 = ele2.getSize().getWidth();
		System.out.println(ImageWidth1);
		int ImageHeight1 = ele2.getSize().getHeight();
		System.out.println(ImageHeight1);
		Point point1 = ele2.getLocation();
		int xcord1= point1.getX();
		System.out.println(xcord1);
		int ycord1 = point1.getY();
		System.out.println(ycord1);
		BufferedImage img = ImageIO.read(screen2);
		//BufferedImage dest = img.getSubimage(xcord1, ycord1, ImageWidth1, ImageHeight1);
		ImageIO.write(img, "png", screen2); 
		String currentDir1 = System.getProperty("user.dir");
		//Files.copy(screen2, new File(currentDir1 + "screenshots/" + "cases" + ".jpg"));
		Files.copy(screen2, new File(currentDir1 + "/ReportScreenshot/" + "piechart" + ".png"));
		System.out.println("copied");    	
		Thread.sleep(2000);
		System.out.println("Start mail");
		//Mail

		String to = "parminder.kaur@orange.com";
		String from = "parminder.kaur@orange.com";
		final String username = "parminder.kaur@orange.com";
		final String password = "";
		String host = "mx-us.equant.com";
		//String host="fed-appsq.itn.ftgroup";

	//*******************************************************************************************************************************
		//String subject = "["+Env+"]["+dateFormat1.format(date1)+"] "+Subject+" Automated Report";     	        
		//String subject = "["+dateFormat1.format(date1)+"] "+SSubject+" Automated Report";
		//String subject = " Automated Report";
		StringBuffer body = new StringBuffer("<html><body><p><font color=\"blue\">Hello  All,<br><br>");
//Env1 is E1 Environment
		//body.append("Please find the below "+Subject+" "+"on"+" "+Env1+" "+"Environment :<br><br>");
//Env is AM Environment
		//body.append("Please find the below "+Subject+" "+"on"+" "+Env+" "+"Environment :<br><br>");
//Env is Prod
		body.append("Please find the below "+Subject+" "+"on"+" "+Env2+" "+"Environment :<br><br>");
//URL used
		//body.append("IS TRACK URL used : "+Url+" </font></p><br>");//AM
		//body.append("IS TRACK URL used : "+Url1+" </font></p><br>");//E1
		body.append("IS TRACK URL used : "+Url2+" </font></p><br>");//Prod
	/*
	for(int i=0;i<L1.size();i++)
	{
		body.append(SSubject+" : "+L1.get(i)+"  "+L2.get(i)+"<br>");
		System.out.println(SSubject+" : "+L1.get(i)+"  "+L2.get(i));
	}
	*/
	
	
//**********************************************Test cases in body*************************************************************************************
		
		WebElement ele=driver.findElement(By.xpath("//i[contains(@class,'mdi-action-dashboard')]"));
		ele.click();
		Thread.sleep(5000);
		List<WebElement> TestCount=driver.findElements(By.xpath("//span[@class='test-name']"));
		System.out.println("No of Test :"+TestCount);
		body.append("<table>");
		body.append("<style>");
		body.append("table,th,td{border:1px dotted black;border-collapse:collapse;padding:5px;font-size:15px}");
		body.append("th{background:orange}");
		//body.append("th{background:purple}");
		body.append("</style>");
		body.append("<tr>");
		body.append("<th>Status</th>");
		body.append("<th>TimeStamp</th>");
		body.append("<th>TestCaseExecuted</th>");
		body.append("</tr>");

		for (int i=0;i<TestCount.size();i++)
		{
			String TestName = TestCount.get(i).getText().toString().trim();
			System.out.println("Test Name is : " +TestName);
			TestCount.get(i).click();
			Thread.sleep(3000);
			int TestCountInside = driver.findElements(By.xpath("//div[@class='card-panel details-view']/div[@class='details-container']/div[@class='test-body']/div[@class='test-steps']/table[@class='bordered table-results']/tbody/tr")).size();
			System.out.println("Total Test Case Count "+TestCountInside);
			String Xpath1="//div[@class='card-panel details-view']/div[@class='details-container']/div[@class='test-body']/div[@class='test-steps']/table[@class='bordered table-results']/tbody/tr[";
			String Xpath2="]/td[1]";
			String Xpath3="//div[@class='card-panel details-view']/div[@class='details-container']/div[@class='test-body']/div[@class='test-steps']/table[@class='bordered table-results']/tbody/tr[";
			String Xpath4="]/td[2]";
			String Xpath5="//div[@class='card-panel details-view']/div[@class='details-container']/div[@class='test-body']/div[@class='test-steps']/table[@class='bordered table-results']/tbody/tr[";
			String Xpath6="]/td[3]";

			for(int t=1;t<=TestCountInside;t++)
			{
				String Status=Xpath1+t+Xpath2;
				String StatusTest = driver.findElement(By.xpath(Status)).getAttribute("title").toString();
				String TestTime=Xpath3+t+Xpath4;
				String TestTimeTest = driver.findElement(By.xpath(TestTime)).getText().toString();
				String TestNameInside=Xpath5+t+Xpath6;
				String TestCaseName = driver.findElement(By.xpath(TestNameInside)).getText().toString();
				body.append("<tr>");
				if(StatusTest.equalsIgnoreCase("pass"))
				{
					body.append("<p><font color=\"green\">");
					body.append("<td>"+StatusTest+"</td>");
					body.append("<td>"+TestTimeTest+"</td>");
					body.append("<td>"+TestCaseName+"</td>");
					body.append("</p></font>");
				}
				else if(StatusTest.equalsIgnoreCase("fail"))
				{
					body.append("<p><font color=\"red\">");
					body.append("<td>"+StatusTest+"</td>");
					body.append("<td>"+TestTimeTest+"</td>");
					body.append("<td>"+TestCaseName+"</td>");
					body.append("</p></font>");
				}
			
				else if(StatusTest.equalsIgnoreCase("skip"))
				{
					body.append("<p><font color=\"pink\">");
					body.append("<td>"+StatusTest+"</td>");
					body.append("<td>"+TestTimeTest+"</td>");
					body.append("<td>"+TestCaseName+"</td>");
					body.append("</p></font>");
				}
					body.append("</tr>");		
			}

		}

		body.append("</table>");
	
		//body.append("</body></html>");
	//***************************************************************************************************************************************	
		body.append("</font><p>");
		body.append("<img style=\"border:10px solid black\" src=\"cid:image2\" width=\"90%\" height=\"60%\"/><br>" );
		body.append("<p><font color=\"blue\">This is automatic report.</font></p><br><br><br>");
		//body.append("<html><body><p><font color=\"blue\">Thanks & Regards,<br>"+"IS TRACK Automation Team</body></html>");
		body.append("<html><body><font color=\"blue\">Thanks & Regards,<br>"+"IS TRACK Automation Team</body></html>");

	// inline images
		Map<String, String> inlineImages = new HashMap<String, String>();
		//inlineImages.put("image2", currentDir1+"/screenshots/" + "piechart" + ".jpg");
		inlineImages.put("image2", currentDir1+"/ReportScreenshot/" + "piechart" + ".png");
		System.out.println("Image is attached");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", 25);
		props.put("mail.smtp.ssl.trust", host);
		props.put("mail.user", username);
		props.put("mail.password", password);

	// creates a new session with an authenticator
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		// creates a new e-mail message
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		msg.setSubject(Subject);
		msg.setSentDate(new Date());

		// creates message part
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(body.toString(), "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		// adds inline image attachments
		if (inlineImages != null && inlineImages.size() > 0) 
		{
			Set<String> setImageID = inlineImages.keySet();
			for (String contentId : setImageID)
			{
				MimeBodyPart imagePart = new MimeBodyPart();
				imagePart.setHeader("Content-ID", "<" + contentId + ">");
				imagePart.setDisposition(MimeBodyPart.INLINE);
				String imageFilePath = inlineImages.get(contentId);
				try {
					imagePart.attachFile(imageFilePath);
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				multipart.addBodyPart(imagePart);
			}
		}
		msg.setContent(multipart);
		Transport.send(msg);  
	}
}

