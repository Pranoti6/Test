package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveFromCart {
	
	@FindBy (xpath="//span[text()='Cart']")
	private WebElement cart;
			
    @FindBy (xpath="//div[text()='Remove']")
    private WebElement remove;
   
    @FindBy(xpath=" //div[@class='_3dsJAO _24d-qY FhkMJZ']")
    private WebElement remove1;
 
    
    public RemoveFromCart(WebDriver driver) {
    	PageFactory.initElements(driver, this);
    	
    }

   public void clickonCart() {
	   cart.click();
   }
  public void clickonremove() throws InterruptedException {
	  remove.click();
	  Thread.sleep(3000);
	  remove1.click();
  }
}
