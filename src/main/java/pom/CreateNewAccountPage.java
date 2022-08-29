package pom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAccountPage {
	
	
	@FindBy(xpath="//a[text()=\"Don't have an account? Signup now!\"]")private WebElement SingUp;
	@FindBy(xpath="//input[@placeholder='Your 10 digit mobile number']")private WebElement mobile;
    @FindBy(xpath="//button[@id='open_account_proceed_form']")private WebElement continueTab;


public CreateNewAccountPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void clickOnSingUp() {
	SingUp.click();
}

public void switchToForgotPopUp(WebDriver driver) {
	Set<String> handles=driver.getWindowHandles();	
    Iterator <String> i=handles.iterator();
    
    while(i.hasNext()) {
    	String popup=i.next();
    	driver.switchTo().window(popup);
    	String title=driver.getTitle();
    	if(title.equals("Signup now")) {
    	break;	
    	}
    }	
}

public void enterMobilenum(String No) {
	mobile.sendKeys(No);	
}

public void clickonTab() {
	continueTab.click();
}







}
