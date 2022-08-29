package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	@FindBy(xpath="//a[text()='Forgot user ID or password?']") private WebElement FORGOT;
	@FindBy(xpath="//input[@placeholder='User ID']")private WebElement USERNAME;
	@FindBy(xpath="//input[@placeholder='PAN']")private WebElement PAN;
	@FindBy(xpath="(//form//label)[6]")private WebElement SMS; //All This Clickable element is dynamic so we need to find out with relative xpath
	@FindBy(xpath="//input[@placeholder='E-mail (as on account)']")private WebElement EMAIL;

	public  ForgotPasswordPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		}
	public void ClickonForgot()
	{
	FORGOT.click();
	}
	public void SwichToForgotPopup(WebDriver driver) {
		Set<String> handle = driver.getWindowHandles();
	      Iterator <String> i =handle.iterator();
	while(i.hasNext())
		{
		String popup = i.next();
		driver.switchTo().window(popup);
		   String Title=driver.getTitle();
		   if (Title.equals("Forgot password/Kite"));{
		   break;}}} 


		public void enterYourName(String name) {
			USERNAME.sendKeys(name);
		}
		
		public void enterPanNumber(String number) {
			PAN.sendKeys(number);
			}
		public void ClickonSMS() {
			SMS.click();
			
		}
		public void enterEMAIL(String email) {
			EMAIL.sendKeys(email);
		
	}
}