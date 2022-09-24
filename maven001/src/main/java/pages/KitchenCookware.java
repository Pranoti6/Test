package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KitchenCookware {
private	WebDriver driver;
	@FindBy (xpath="//div[@class='_4ddWXP'][1]")
	private WebElement houseWrap;
	
	public KitchenCookware(WebDriver driver) {
		PageFactory.initElements(driver, this);
	    this.driver=driver;
	}

     public void clickFOKRIMMagic() {
    	WebDriverWait wait=new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.visibilityOf(houseWrap));
    	 
    	 houseWrap.click();
     }

}
