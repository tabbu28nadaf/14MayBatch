package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.LaunchBrowser;
import pom.CreateNewAccountPage;
import utility.Parameterization;

public class CreateNewaccontTest {
	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		driver=LaunchBrowser.ChromBrowser();	
	}
	@Test
	public void SingUpPge() throws EncryptedDocumentException, IOException, InterruptedException {
		CreateNewAccountPage singup=new	CreateNewAccountPage(driver);
		String N=Parameterization.getData("Credentials",7,1);
		
		singup.clickOnSingUp();
		singup.switchToForgotPopUp(driver);
		singup.enterMobilenum(N);
		singup.clickonTab();
	
	//driver.getTitle();
	}
}