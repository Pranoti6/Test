package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage {

	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (xpath="(//div[@class='eFQ30H'][6])")
	private WebElement home;
	
	@FindBy(xpath="//a[text()='Kitchen & Dining']")
	private WebElement kitchenAndDining;
	
   public Homepage(WebDriver driver) {
	   
	   PageFactory.initElements(driver, this);
	   wait=new WebDriverWait(driver,20);
        this.driver=driver;
   }
   
   public void clickHome() {
	   wait.until(ExpectedConditions.visibilityOf(home));
	   Actions act=new Actions(driver);
	   act.moveToElement(home).perform();
			   
   }
	public void clickKitchenAndDining() {
		wait.until(ExpectedConditions.visibilityOf(kitchenAndDining));
	Actions act=new Actions(driver);
	act.moveToElement(kitchenAndDining).click().build().perform();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
