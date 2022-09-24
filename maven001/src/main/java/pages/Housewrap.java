package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Housewrap {
	
	@FindBy (xpath=" //button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCart;
	
	@FindBy (xpath="//div[@class='_3qX0zy']")
	private WebElement logobutton;
	

	
	
	
	public Housewrap(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
  public void clickAddToCart() {
	  addToCart.click();
  }
  public void clickLogoButton() {
	  logobutton.click();
  }
}
