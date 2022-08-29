package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports generateReports() {
	 
	ExtentSparkReporter htmlReprts=new ExtentSparkReporter("projectReport.xml");
 
	 ExtentReports reports= new ExtentReports();
	
	 reports.attachReporter(htmlReprts);
	
	reports.setSystemInfo("suite","Regression");
	
	reports.setSystemInfo("TestBy","Tabbsum");
	
	return reports;
	
	}
}
