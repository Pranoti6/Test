package test01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Flipkartlogin;
import pages.Homepage;
import pages.Housewrap;
import pages.KitchenCookware;
import pages.RemoveFromCart;
import pages.Shoppingcart;
import utils.Utility;

public class TestClass {
	
	public static void main(String[]args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		 System.setProperty("webdriver.chrome.driver","C:\\selnium\\chromedriver_win32 (1)\\chromedriver.exe");
		 
		   WebDriver driver= new ChromeDriver();
		   
		   driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		   
		   driver.get("https://www.flipkart.com/");
		   
		Flipkartlogin flipkartlogin=new Flipkartlogin(driver);
		String userName= Utility.fetchExcelsheetdata(0, 1, 0);
		flipkartlogin.sendUserName(userName);
	 String passWord=Utility.fetchExcelsheetdata(0, 1, 1);
		flipkartlogin.sendPassword(passWord);
		flipkartlogin.clickLogin();
		   
		String homepageURL =driver.getCurrentUrl();
		   
		   if(homepageURL.equals("https://www.flipkart.com/")) {
			   System.out.println("homepageURL is Verified");
		   }
		   else
		   {
			   System.out.println("homepageURL is wrong");
		   }
		   Thread.sleep(5000);
		Homepage homepage=new Homepage(driver);
		homepage.clickHome();
		Thread.sleep(5000);
		homepage.clickKitchenAndDining();	
		String kitchenAndDiningURL=driver.getCurrentUrl();
		System.out.println(kitchenAndDiningURL);
		if(kitchenAndDiningURL.equals("https://www.flipkart.com/kitchen-cookware-serveware/pr?count=40&otracker=CLP_lhs&sid=upp&fm=neo%2Fmerchandising&iid=M_261e02e2-5497-"
				+ "4161-96d7-3e3902e769db_1_372UD5BXDFYS_MC.4EYWRCGS3WUT&otracker=hp_rich_navigation_4_1.navigationCard.RICH_NAVIGATION_Home~Kitchen%2B%2526%2BDining_4EYWRCGS3WUT&otracker1=hp_rich_navigation_PINNED_"
				+ "neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_4_L1_view-all&cid=4EYWRCGS3WUT"))
	
		    {
			System.out.println("kitchenAndDinning URL is verified");
		    }
	     else
		  {
		 System.out.println("URL is wrong");  
		  }  
		
		 KitchenCookware kitchenCookWare=new KitchenCookware(driver);
		
		 kitchenCookWare.clickFOKRIMMagic();
		
		 String fokrimmagic=driver.getCurrentUrl();
		
		 if(fokrimmagic.equals("https://www.flipkart.com/fokrim-magic-trio-peeler-slicers-shredders-fruits-"
				+ "vegetables-spiralizer-julienne-cutter-grater-kitchen-helper-vegetable-fruit-slicer/p/itm671f"
				+ "f71a56dd6?pid=CPRG3HYVEVBTXPQH&lid=LSTCPRG3HYVEVBTXPQHBE9XUY&marketplace=FLIPKART&store=upp"
				+ "&srno=b_1_2&otracker=CLP_lhs&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV"
				+ "_EXPANDABLE_navigationCard_cc_4_L1_view-all&fm=organic&iid=en_p1RuV0dg8tsq%2F8kveOxvHT1q9XUpLbriemtsYoFcH09PLeI2Rw"
				+ "7ygMZIpT1bDjkiV2sXPQffTfZvamgp4bHN9w%3D%3D&ppt=browse&ppn=browse"))
		{
			System.out.println("forkrimmagic URL is Verified");
		}
		else
		{
			System.out.println("URL is Wrong");
		}
		
		ArrayList<String>newPage=new ArrayList<String>(driver.getWindowHandles());
		
		String addressOfforkrimmagic=newPage.get(1);
		
		driver.switchTo().window(addressOfforkrimmagic);
		
		Housewrap housewrap= new Housewrap(driver);
		
	    housewrap.clickAddToCart();
		 
		String addToCartURL=driver.getCurrentUrl()  ;
		   
		 if(addToCartURL.equals("https://www.flipkart.com/viewcart?exploreMode=true&preference=FLIPKART"))
		 {
			 System.out.println("addToCartURL is Verified");
		 }
		 else
		 {
			 System.out.println("URL is Wrong");
		 }
		 Thread.sleep(3000);
		 housewrap.clickLogoButton();
		 driver.navigate().refresh();
		 RemoveFromCart removefromcart=new RemoveFromCart(driver);
		 removefromcart.clickonCart();
		 Thread.sleep(3000);
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,150)");
		 removefromcart.clickonremove();
		 
		 Shoppingcart shoppingcart=new Shoppingcart(driver);
		 shoppingcart.clickMyAccount();
		 Thread.sleep(3000);
		 shoppingcart.clicklogout();
		 
		String logoutURL= driver.getCurrentUrl();
		   if(logoutURL.equals("https://www.flipkart.com/"))

		   {
			   System.out.println("logoutURL is verified");
		   }
		   else
		   {
			   System.out.println("URL is wrong");
		   }
	
	}

}
