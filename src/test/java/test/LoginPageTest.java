package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parameterization;
import utility.ScreenShot; 

@Listeners(utility.Listners.class)

public class LoginPageTest extends BaseTest {

//WebDriver driver;

@BeforeMethod
public void launchBrowser() {
	driver=LaunchBrowser.ChromBrowser();	
}
@Test
public void ZerodhaLoginTest() throws EncryptedDocumentException, IOException, InterruptedException {
	
	String ID=Parameterization.getData("Credentials",0,1);
	String pass=Parameterization.getData("Credentials",1,1);
	String pin=Parameterization.getData("Credentials",2,1);
	
	ZerodhaLoginPage zerodhaloginpage=new ZerodhaLoginPage(driver);
	zerodhaloginpage.enterUserID(ID);
	zerodhaloginpage.enterPassword(pass);
	zerodhaloginpage.clickonSubmit();
	
	zerodhaloginpage.enterpinNumber(pin,driver);
	zerodhaloginpage.clickonContinue();
    //Thread.sleep(2000);
	Assert.assertTrue(false);
}

//@AfterMethod
//public void closeBrowser() {
	//driver.close();
//}


}



















