package simplePackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Samplecodesecretkey extends ObjectRepo{

	public static WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public void launchBrowser() throws Exception {
		
		String browser = PropertiesOperation.getPropertyValuebyKey("Browser");
		String url = PropertiesOperation.getPropertyValuebyKey("Url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//ChromeOptions Chrome_Options = new ChromeOptions();
			//Chrome_Options.addArguments("--incognito");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver();
			FirefoxOptions Firefox_Options = new FirefoxOptions();
			Firefox_Options.addArguments("-private");
			driver=new FirefoxDriver(Firefox_Options);
		}
		else if(browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver();
			EdgeOptions Edge_Options = new EdgeOptions();
			Edge_Options.addArguments("InPrivate");
			driver = new EdgeDriver(Edge_Options);
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Test
	public void setup() throws Exception {
		launchBrowser();
		
		loginpage = new LoginPage();
		Thread.sleep(1000);
		loginpage.EnterLoginCredential();
	}
	
}
