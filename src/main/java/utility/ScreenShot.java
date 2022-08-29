package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class ScreenShot {
public static void TakesScreenshot(WebDriver driver,String name) throws IOException {//user defined method
		
		String date=  ScreenShot.date();//calling date method inside the ScreenShot method by using classname    
		
		TakesScreenshot sc=((TakesScreenshot)driver);//upcasting driver to TakeScreeshot
		 
		File source = sc.getScreenshotAs(OutputType.FILE);//
		
        File destination=new File("C:\\Users\\HP\\eclipse-workspace\\KiteZerodha\\ScreenShots\\"+name+""+date+".jpg");
        
        FileHandler.copy(source, destination);
		}
public static String date() {
      
	DateTimeFormatter dtf= DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");//format the time date an time as required
	  
    LocalDateTime currentTime= LocalDateTime.now();//return current time      
      
    String d=dtf.format(currentTime);//format the time given by Now()method to required method and return string
	 
    return d;
}
}