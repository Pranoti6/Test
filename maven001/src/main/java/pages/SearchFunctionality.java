package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFunctionality {
	
	@FindBy (xpath="//input[@placeholder='Search for products, brands and more']") 
	private WebElement search;
	@FindBy (xpath="//button[@class='L0Z3Pu']") 
	private WebElement searchButton;
	
	public SearchFunctionality(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void sendSearch(String searchlap) {
		search.sendKeys(searchlap);
	}
	public void clickSearchButton() {
		searchButton.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
