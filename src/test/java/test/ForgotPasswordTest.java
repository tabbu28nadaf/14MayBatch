package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import pojo.LaunchBrowser;
import pom.ForgotPasswordPage;
import utility.BaseTest;
import utility.Parameterization;
import utility.Reports;

@Listeners(utility.Listners.class) 

public class ForgotPasswordTest extends BaseTest {

	ExtentReports reports;
    ExtentTest test;


//WebDriver driver;
@BeforeTest
public void addReports() {
	reports=Reports.generateReports();
}
	
	@BeforeMethod
public void LaunchBrowser() {
	driver=LaunchBrowser.ChromBrowser();	

	
	}

	@Test
	public void ValidateForgotPasswordLink() throws EncryptedDocumentException, IOException, InterruptedException  {
		
           String name=Parameterization.getData("Credentials",4, 1);
		   String number = Parameterization.getData("Credentials",5, 1);
		   String email = Parameterization.getData("Credentials",6, 0);
		   
		   test=reports.createTest("ValidateForgotPasswordLink");
		   ForgotPasswordPage forgotpage=new ForgotPasswordPage(driver);
		   
		   forgotpage.ClickonForgot();
		   forgotpage.SwichToForgotPopup(driver);
	       forgotpage.enterYourName(name);
	       forgotpage.enterPanNumber(number);
	     //forgotpage.ClickonSMS();
		   forgotpage.enterEMAIL(email);
           //Thread.sleep(5000);
	}
	
@AfterMethod
public void postTest(ITestResult result) {
	if(result.getStatus()==ITestResult.FAILURE) 
	{
		test.log(Status.FAIL,result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS) 
	{
	test.log(Status.PASS,result.getName());
    }
	else {
		test.log(Status.SKIP,result.getTestName());
	}
    }

@AfterTest
public void flushReport() 
{
	reports.flush();
}





}





















