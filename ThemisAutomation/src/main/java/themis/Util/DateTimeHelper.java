package themis.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DateTimeHelper
{
	
	@Test
	public void incrementDate() throws ParseException
	{
		/*
		 * Calendar calendar = Calendar.getInstance();
		 * System.out.println(calendar.getTime());// print today's date
		 * calendar.add(Calendar.DATE, 1); System.out.println(calendar.getTime());//
		 * print modified date which is tomorrow's date
		 */
		String dt = "01-Jan-2018";  // Start date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(dt));
		c.add(Calendar.DATE, -1);  // number of days to add
		dt = sdf.format(c.getTime());  // dt is now the new date
		System.out.println(dt);
	}
	
	public long DateDiff(String Datetime1,String Datetime2 ) throws ParseException
	{

			String date1 = Datetime1;
			String date2 = Datetime2;

			//HH converts hour in 24 hours format (0-23), day calculation
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

			Date d1 = null;
			Date d2 = null;

			
				d1 = format.parse(date1);
				d2 = format.parse(date2);

				//in milliseconds
				long diff = d2.getTime() - d1.getTime();

				long diffSeconds = diff / 1000 % 60;
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffDays = diff / (24 * 60 * 60 * 1000);

				System.out.println("############# Diff between DateTime ###############");
				System.out.println(diffDays + " days, ");
				System.out.println(diffHours + " hours, ");
				System.out.println(diffMinutes + " minutes, ");
				System.out.println(diffSeconds + " seconds.");
				System.out.println("###################################################");
				
				return diffHours;
	}
		public String currentDate()
		{
			DateFormat dateFormat = new SimpleDateFormat("MM/d/yyyy");
			Date date = new Date();
			String date1=dateFormat.format(date);
			System.out.println(date1);
			String date2[]=(date1.split(" ")[0]).split("/");
			String fdate=date2[1];
			System.out.println("Final date is"+fdate);
			return fdate;
		}
}
