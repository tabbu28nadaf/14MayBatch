package pojo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static WebDriver ChromBrowser() {
		
		ChromeOptions option = new ChromeOptions();//to disable the notifications
		 
	   option.addArguments("--disable-notifications");		
		
		//System.setProperty("webdriver.chrome.driver","C:\\Documents\\software\\chromedriver_win32\\chromedriver.exe");
	    
	   WebDriverManager.chromedriver().setup();//instead of doing udating path every time use webdrivermanager class setup method 
		
	   WebDriver driver=new ChromeDriver(option);
	  
	   driver.navigate().to("https://kite.zerodha.com/");
	    
	   driver.manage().window().maximize();
	
	   driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));//ImplicitWait 
	    
	    
	   return driver;
	}






}