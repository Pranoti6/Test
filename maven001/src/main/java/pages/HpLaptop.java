package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HpLaptop {
	@FindBy (xpath="(//div[@class='_213eRC _2ssEMF'])[2]") 
	private WebElement brand;
	
	@FindBy (xpath="(//div[@class='_24_Dny'])[7]") 
	private WebElement hp;
	
	
	public HpLaptop(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickBrand() {
		brand.click();
	}
	public void clickhp() {
		hp.click();
	}
	

}
