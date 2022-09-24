package test01;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Setup.Base;
import pages.Flipkartlogin;


import pages.HpLaptop;

import pages.SearchFunctionality;
import pages.Shoppingcart;
import utils.Utility;

public class TestClass2Flipkart extends Base {

	private WebDriver driver;
	private Flipkartlogin flipkartlogin;
   private SearchFunctionality searchlap;
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
	     searchlap= new SearchFunctionality(driver);
		  shoppingcart=new Shoppingcart(driver);
	    }

	 @BeforeMethod
	 public void loginfunctionality() throws InterruptedException, EncryptedDocumentException, IOException {
		 driver.get("https://www.flipkart.com/");
		String userName= Utility.fetchExcelsheetdata(0, 1, 0);
	     flipkartlogin.sendUserName(userName);
	     String passWord=Utility.fetchExcelsheetdata(0, 1, 1);
		 flipkartlogin.sendPassword(passWord);
		 flipkartlogin.clickLogin();
			   Thread.sleep(5000);
	 }

     @Test
     public void searchFunctionality() throws InterruptedException, EncryptedDocumentException, IOException {
    	 TestID= "T1001";
    	String laptop= Utility.fetchExcelsheetdata(0, 2, 0);
    	 searchlap.sendSearch(laptop);
    	 searchlap.clickSearchButton();
    	 String clickSearchButtonURL= driver.getCurrentUrl();
    	 String clickSearchButtonTitle=driver.getTitle();
        Thread.sleep(5000);
    	 Assert.assertEquals(clickSearchButtonURL, "https://www.flipkart.com/search?q=laptops&otracker=search&otracker1=search&marketplace="
    	 		+ "FLIPKART&as-show=off&as=off");
        Assert.assertEquals(clickSearchButtonTitle, "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, "
        		+ "Books & More. Best Offers!");
        JavascriptExecutor js= (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(5000);
        HpLaptop brand= new HpLaptop(driver);
         brand.clickBrand();
         brand.clickhp();
         String HplaptopURL= driver.getCurrentUrl();
    	Assert.assertEquals(HplaptopURL, "https://www.flipkart.com/search?q=laptops&otracker=search&otracker1=search&marketplace=FLIPKART&as-"
   		+ "show=off&as=off&p%5B%5D=facets.brand%255B%255D%3D");
   
     }
 	@AfterMethod
 		public void logoutFunctionality(ITestResult result) throws InterruptedException, IOException {
 		
 		if(ITestResult.FAILURE==result.getStatus()) {
 			Utility.captureScreenshot(driver, TestID);
 		}
 		 shoppingcart.clickMyAccount();
 		 Thread.sleep(3000);
 		 shoppingcart.clicklogout();
 		 Thread.sleep(5000);
 	
     }
 	@AfterClass
 		public void cleanPomObjects() {
 		flipkartlogin=null;
 		searchlap=null;
 		shoppingcart=null;
 	}
     
 	@AfterTest
	    public void closebrowser() {
		driver.quit();
		driver=null;
		System.gc();
 	  }
 	  
}
