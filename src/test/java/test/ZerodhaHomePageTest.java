package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.testng.ITestResult;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import pojo.LaunchBrowser;
import pom.ZerodhaHomePage;
import pom.ZerodhaLoginPage;
import utility.BaseTest;
import utility.Parameterization;
import utility.Reports;

@Listeners(utility.Listners.class)

public class ZerodhaHomePageTest extends BaseTest {
	
	ExtentReports reports;
    ExtentTest test;

@BeforeTest
public void addReports() {
	 reports=Reports.generateReports();
}

//WebDriver driver;	
	
@BeforeMethod
public void LaunchBrowser() throws EncryptedDocumentException, IOException {
	
	driver=LaunchBrowser.ChromBrowser();

	String ID=Parameterization.getData("Credentials",0,1);
	String pass=Parameterization.getData("Credentials",1,1);
	String pin=Parameterization.getData("Credentials",2,1);
	test=reports.createTest("LaunchBrowser");
	ZerodhaLoginPage zerodhaloginpage=new ZerodhaLoginPage(driver);
	zerodhaloginpage.enterUserID(ID);
	zerodhaloginpage.enterPassword(pass);
	zerodhaloginpage.clickonSubmit();
	
	zerodhaloginpage.enterpinNumber(pin,driver);
	zerodhaloginpage.clickonContinue();
    //Thread.sleep(2000);
}
	
@Test	
public void searchStockTest() throws IOException {
	test=reports.createTest("searchStockTest");
	ZerodhaHomePage zerodhahomepage=new ZerodhaHomePage(driver);
	zerodhahomepage.SearchStock("Reliance", driver);
	int number=zerodhahomepage.getSearchResultNumber();
    System.out.println(number);
	//AssertJUnit.assertTrue(number>0);
    Assert.assertTrue(false);
}
@Test()
public void SearchStockAndClickOnBuy () throws IOException {
	test=reports.createTest("SearchStockAndClickOnBuy");
	ZerodhaHomePage zerodhahomepage=new ZerodhaHomePage(driver);
	zerodhahomepage.SearchStock("TATA", driver);
	zerodhahomepage.SearchAndSelectRquiredStock(driver,"TATACONSUM");
	zerodhahomepage.ClickOnBuy();
	zerodhahomepage.enerQuantity("2");
	Assert.assertTrue(true,"Buy TATACONSUM" );
}

@Test()
public void SearchStockAndClickOnSell() throws IOException {
	test=reports.createTest("SearchStockAndClickOnSell");
	ZerodhaHomePage zerodhahomepage=new ZerodhaHomePage(driver);
	zerodhahomepage.SearchStock("TATA", driver);
	zerodhahomepage.SearchAndSelectRquiredStock1(driver,"TATAMOTORS");
	zerodhahomepage.ClickOnSell();
	Assert.assertTrue(true,"Buy TATAMOTORS" );
	}
	
@Test()
public void SearchStockAndclickchart() {
	test=reports.createTest("SearchStockAndclickchart");
	ZerodhaHomePage zerodhahomepage=new ZerodhaHomePage(driver);
	zerodhahomepage.SearchStock("adani", driver);
	zerodhahomepage.SearchAndSelectRquiredStock2(driver,"ADANIGREEN");
   zerodhahomepage.ClickonChart();
	//zerodhahomepage.Clickonmarkrtdepth();
	//zerodhahomepage.ClickOnPluseOption();
	//zerodhahomepage.ClickonDelet();
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
	else
	{
		test.log(Status.SKIP,result.getName());
	}
}

@AfterTest
public void flushReport() {
	reports.flush();
}
}