package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaHomePage {

@FindBy(xpath="//span[text()='Dashboard']")private WebElement Dashboard;
@FindBy(xpath="//span[text()='Orders']")private WebElement Orders;
@FindBy(xpath="//span[text()='Holdings']")private WebElement Holdings;
@FindBy(xpath="//span[text()='Positions']")private WebElement Positions;
@FindBy(xpath="//span[text()='Funds']")private WebElement Funds; 
@FindBy(xpath="//span[text()='Apps']")private WebElement Apps; 

@FindBy(xpath="// input[@icon='search']")private WebElement SearchField;
@FindBy(xpath="//span[@class='tradingsymbol']")private List <WebElement> SearchResult;

@FindBy(xpath="//button[@data-balloon='Buy']")private WebElement SearchBuy;
@FindBy(xpath="//input[@label='Qty.']")private WebElement QTY;
@FindBy(xpath="(//button[@type='button'])[3]")private WebElement CANCEL;
@FindBy(xpath="//button[@data-balloon='Sell']")private WebElement SearchSell;


@FindBy(xpath="//span[@class='icon icon-align-center']")private WebElement MarketDepth;
@FindBy(xpath="//span[@class='icon icon-trending-up']")private WebElement Chart;
@FindBy(xpath="//span[@class='icon icon-trash']")private WebElement Delet;
@FindBy(xpath="//span[@class='icon icon-ellipsis']")private WebElement MoreOption;
@FindBy(xpath="//span[@class='icon icon-plus']")private WebElement pluse;




public ZerodhaHomePage (WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void SearchStock(String stock,WebDriver driver) {
	SearchField.sendKeys(stock);
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(1000));
    wait.until(ExpectedConditions.visibilityOf(SearchField));

}

public  int getSearchResultNumber() {
	   int listsize=SearchResult.size();
        return listsize;
}

public void SearchAndSelectRquiredStock(WebDriver driver,String Rquierdstock) {
	//SearchStock(stock, driver);//we can call searchstock method here which give stock which we requiered
for(int a=0;a<SearchResult.size();a++) {
	WebElement s=SearchResult.get(a);
    String StockName=s.getText();
 
    if(StockName.equals(Rquierdstock)) {
    	Actions action=new Actions (driver);
        action.moveToElement(s);
        action.perform();
        break;
    }}}

public void ClickOnBuy() {
	SearchBuy.click();
}

public void enerQuantity(String qty) {
	QTY.sendKeys(qty);
}
public void clickOnCancel() {
	CANCEL.click();
}

public void SearchAndSelectRquiredStock1(WebDriver driver,String Rquierdstock) {
	//SearchStock(stock, driver);//we can call searchstock method here which give stock which we requiered
for(int a=0;a<SearchResult.size();a++) {
	WebElement s=SearchResult.get(a);
    String StockName=s.getText();
 
    if(StockName.equals(Rquierdstock)) {
    	Actions action=new Actions (driver);
        action.moveToElement(s);
        action.perform();
        break;
    }}}

public void ClickOnSell() {
	SearchSell.click();
}

public void SearchAndSelectRquiredStock2(WebDriver driver,String Rquierdstock) {
	for(int a=0;a<SearchResult.size();a++) {
		WebElement s=SearchResult.get(a);
	    String StockName=s.getText();
	 
	    if(StockName.equals(Rquierdstock)) {
	    	Actions action=new Actions (driver);
	        action.moveToElement(s);
	        action.perform();
	        break;
	    }}
	
}
public void ClickonChart() {
	Chart.click();		
}

public void Clickonmarkrtdepth() {
	 MarketDepth.click();	
}
public void ClickonDelet() {
	 Delet.click();	
}

public void ClickonMoreOption() {
	 MoreOption.click();	
}
public void ClickOnPluseOption() {
	pluse.click();
}
}

