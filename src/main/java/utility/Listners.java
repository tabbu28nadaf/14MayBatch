package utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listners extends BaseTest implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started"+result.getName());
	}

public void onTestSuccess(ITestResult result) {
	System.out.println("Test Passed"+result.getName());
}

public void onTestFailure(ITestResult result) {
	 try 
	 {
		ScreenShot.TakesScreenshot(driver,result.getName() );
	} 
	 catch (IOException e) 
	 {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void onTestSkipped(ITestResult result) {
	System.out.println("Test Skipped"+result.getName());
}











}
