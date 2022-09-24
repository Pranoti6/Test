package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shoppingcart {
	private WebDriver driver;
	
	@FindBy (xpath="(//div[@class='_28p97w'])[1]")
	private WebElement myAccount;
	
	@FindBy (xpath="//div[text()='Logout']")
	private WebElement logout;
	
	
	public Shoppingcart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickMyAccount() {
		Actions act=new Actions(driver);
		act.moveToElement(myAccount).build().perform();
	}
   public void clicklogout() {
	   logout.click();
   }
}
