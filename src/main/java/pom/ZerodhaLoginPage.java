package pom;

import java.time.Duration;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLoginPage {

	@FindBy(xpath="//input[@id='userid']")private WebElement UserID;
	@FindBy(xpath="//input[@id='password']")private WebElement Password; 	
	@FindBy(xpath="//button[@class='button-orange wide']")private WebElement Submit;	
	@FindBy(xpath="//input[@id='pin']")private WebElement PIN;
	@FindBy(xpath="//button[@type='submit']")private WebElement SubmitPin;
	@FindBy(xpath="//a[text()='Forgot user ID or password?']")private WebElement ForgotPass;	
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement SingUp;	
		
		
		public ZerodhaLoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
		
	public void enterUserID(String ID) 
	{
	UserID.sendKeys(ID);	
	}

	public void enterPassword(String pass) 
	{
	Password.sendKeys(pass);	
	}

	public void clickonSubmit() 
	{
		Submit.click();	
	}

	public void enterpinNumber(String pinNumber,WebDriver driver) 
	{
	//WebDriverWait wait= new WebDriverWait(driver,Duration.ofMillis(2000));//ExplicitWait
	//wait.until(ExpectedConditions.visibilityOf(PIN));
	FluentWait<WebDriver>wait=new FluentWait<WebDriver>(driver);//fluentwait
	wait.withTimeout(Duration.ofMillis(2000));
	wait.pollingEvery(Duration.ofMillis(100));
	wait.ignoring(Exception.class);
	wait.until(ExpectedConditions.visibilityOf(PIN));
	PIN.sendKeys(pinNumber);
	}

	public void clickonContinue() 
	{
		SubmitPin.click();
	}

	public void clickonForgotPassword() 
	{
		ForgotPass.click();
	}

    public void clickOnSingUp() {
    	SingUp.click();	
    }
	
	
	public void switchToSingUpPopUp(WebDriver driver) {
    Set<String> handles=driver.getWindowHandles();	
    Iterator <String> i=handles.iterator();
    
    while(i.hasNext()) {
    	String popup=i.next();
    	driver.switchTo().window(popup);
    	String title=driver.getTitle();
    	if(title.equals("Forgot password/Kite")) {
    	break;	
    	}
    }
    }

public void clickOnForgot() {
	ForgotPass.click();
}
	
	public void switchToForgotPopUp(WebDriver driver) {
	Set<String> handles=driver.getWindowHandles();	
    Iterator <String> i=handles.iterator();
    
    while(i.hasNext()) {
    	String popup=i.next();
    	driver.switchTo().window(popup);
    	String title=driver.getTitle();
    	if(title.equals("")) {
    	break;	
    	}
    }	
}





















}
