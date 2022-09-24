package test01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Setup.Base;
import pages.Flipkartlogin;
import pages.Homepage;
import pages.Housewrap;
import pages.KitchenCookware;
import pages.RemoveFromCart;
import pages.Shoppingcart;
import utils.Utility;

public class TestClass1Flipkart extends Base{
	
	private WebDriver driver;
	private Housewrap housewrap;
	private Flipkartlogin flipkartlogin;
	private Homepage homepage;
	private KitchenCookware kitchenCookWare;
	private SoftAssert soft;
	private Shoppingcart shoppingcart;
	private String TestID;

	@Parameters ("browser")
	@BeforeTest
		public void launchTheBrowser(String browserName) {
		if(browserName.equals("Chrome"))
		{
			driver=openTheChromeBrowser();
		}
		if(browserName.equals("Edge"))
		{
	    driver=openTheEdgeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@BeforeClass
		public void createPomObjects() { 
		 flipkartlogin=new Flipkartlogin(driver);
		 homepage=new Homepage(driver);
		 kitchenCookWare=new KitchenCookware(driver);
		 housewrap= new Housewrap(driver);
		  shoppingcart=new Shoppingcart(driver);
	   	}
	
	 @BeforeMethod
	 	public void loginfunctionality() throws InterruptedException, EncryptedDocumentException, IOException {
		 driver.get("https://www.flipkart.com/");
		String data= Utility.fetchExcelsheetdata(0, 1, 0);
		 flipkartlogin.sendUserName(data);
		String data1= Utility.fetchExcelsheetdata(0, 1, 1);
		 flipkartlogin.sendPassword(data1);
		 flipkartlogin.clickLogin();
			   Thread.sleep(5000);
		 soft= new SoftAssert();
	 	}
	  @Test
	  	public void addToCart() throws InterruptedException {
		  
		 TestID="T1001";
		
		 homepage.clickHome();
		 Thread.sleep(5000);
		 homepage.clickKitchenAndDining();	
		 Thread.sleep(5000);
	     kitchenCookWare.clickFOKRIMMagic();
		 Thread.sleep(5000);
	     ArrayList<String>newPage=new ArrayList<String>(driver.getWindowHandles());
		 String addressOfforkrimmagic=newPage.get(1);
		 driver.switchTo().window(addressOfforkrimmagic);
		 housewrap.clickAddToCart();
	     Thread.sleep(5000);
		 String addToCartURL=driver.getCurrentUrl()  ;
		 String cartTitle=driver.getTitle();
		
		 Assert.assertEquals(addToCartURL, "https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART");
		 Assert.assertEquals(cartTitle, "Shopping Cart | Flipkart.com");
		
		  Thread.sleep(5000);
	  }
	@Test

		public void removecart() throws InterruptedException {
		TestID="T1002";
		 Thread.sleep(3000);
		 housewrap= new Housewrap(driver);
		 housewrap.clickLogoButton();
		 driver.navigate().refresh();
		 RemoveFromCart removefromcart=new RemoveFromCart(driver);
		 removefromcart.clickonCart();
		 Thread.sleep(3000);
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,300)");
		 removefromcart.clickonremove();
		 String removefromcartURL= driver.getCurrentUrl();
		 String removefromcartTitle=driver.getTitle();
		 
		 soft.assertEquals(removefromcartURL, "https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART");
		 soft.assertEquals(removefromcartTitle, "Shopping Cart | Flipkart.com");
		 soft.assertAll();
		 }
	 
	@AfterMethod
	public void logoutFunctionality() throws InterruptedException {
		   shoppingcart.clickMyAccount();
		 Thread.sleep(3000);
		 shoppingcart.clicklogout();
		 Thread.sleep(5000);
		 
		}
	  
	@AfterClass
	public void cleanPomObjects() {
		housewrap =null;
		flipkartlogin=null;
		homepage=null;
		kitchenCookWare=null;
	}
    @AfterTest
	    public void closebrowser() {
		driver.quit();
		driver=null;
		System.gc();
	   }
	
	
	
}
