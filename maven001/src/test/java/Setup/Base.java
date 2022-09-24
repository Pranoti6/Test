package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	
	public static WebDriver openTheChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\selnium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		return driver;
	}
	public static WebDriver openTheEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", "C:\\selnium\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
		return driver;
	}
	
	public static WebDriver openTheFireFoxBrowser() {
		System.setProperty("webdriver.fireFox.driver", "C:\\selnium\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver=new FirefoxDriver();
		return driver;
	}
	
	

}
