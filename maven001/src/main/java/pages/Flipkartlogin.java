package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Flipkartlogin {
	
	@FindBy (xpath="//input[@class='_2IX_2- VJZDxU']") 
	private WebElement userName;
	
	@FindBy (xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']")
	private WebElement passWord;
	
	@FindBy (xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	private WebElement login;
	
	
	public Flipkartlogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

	
	public void sendUserName(String user) {
		userName.sendKeys(user);

	}
    public void sendPassword(String pass) {
    	passWord.sendKeys(pass);
    }
    public void clickLogin() {
    	login.click();
    }

}
