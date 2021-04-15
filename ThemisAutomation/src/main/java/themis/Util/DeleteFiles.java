package themis.Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

public class DeleteFiles {
		
	public static final Logger log =Logger.getLogger(DeleteFiles.class.getName());	
	public static String file1; 
	 
	    public static void DeleteFile()
	    {
	    String files; 
	    File file = new File("C:\\Users\\XMJF0501\\Downloads\\TemplateDownload");
	    File[] listOfFiles = file.listFiles(); 
	    for (int i = 0; i < listOfFiles.length; i++) 
	    {
	        if (listOfFiles[i].isFile()) 
	        {
	            files = listOfFiles[i].getName();
	            System.out.println("File name is : "+files);
	            log.info("File name is : "+files);
	         //   if(!files.equalsIgnoreCase("Scan.pdf"))
	          //  {
	                boolean issuccess=new File(listOfFiles[i].toString()).delete();
	                System.err.println("Deletion Success "+issuccess);
	                log.info("Deletion Success "+issuccess);
	         //   }
	            
	            
	        }
	    }
	
	    }
	    
	    public static String FileFromFolder() {
			
	    	
	 	    File file = new File("C:\\Users\\XMJF0501\\Downloads\\TemplateDownload");
	 	    File[] listOfFiles = file.listFiles(); 
	 	    for (int i = 0; i < listOfFiles.length; i++) 
		 	    {
		 	        if (listOfFiles[i].isFile()) 
		 	        {
		 	        	file1 = listOfFiles[i].getName();
		 	            System.out.println("File name is : "+file1);
		 	           log.info("File name is : "+file1);          
		 	        }
	
		 	    }
	 	    return file1;
	    }
	    
	    public static void deleteFiles() throws IOException
		{
			String currentDir1 = System.getProperty("user.dir");
			System.out.println(">>>>" + currentDir1);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -90);
			Date dateBefore90Days = cal.getTime();
			System.out.println(dateBefore90Days);
			Files.walk(Paths.get(currentDir1+"//ApplicationScreenshots"))
			.filter(Files::isRegularFile).filter(x -> { boolean f = false;
					try {
						f = dateBefore90Days.compareTo(new Date(Files.getLastModifiedTime(x).toMillis()))>0;
						//System.out.println(f);
					} catch (IOException e) {
						e.printStackTrace();
					} return f;
			}).forEach(path -> {
		        try {
		            Files.delete(path);
		            log.info("Older file with name: " + path.toString() + " got deleted");
		        } catch (IOException ex) {
		            // 
		        }
		    });
}
}