package TestPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import PageFile.amazonHomePage;
import Utility.AbstractMethods;

public class Automation_Test_AmazonIN {
	WebDriver driver;
	amazonHomePage Hp;
	AbstractMethods Am;

	@Test
	public void setUp() throws FileNotFoundException {
		try {
			FileInputStream fis= new FileInputStream("E:\\eclipse-workspace_Selenium\\Project-3\\src\\test\\java\\DataPackage\\DataFile");
			Properties p = new Properties();
			p.load(fis);
			//initializing the browser's
			String browser = p.getProperty("browser");
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver(); 
			}
			//opening the url
			String url = p.getProperty("url");
			driver.get(url);
			driver.manage().window().maximize();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println(driver.getTitle());
	}
	
	
	@AfterClass
	public void closeBrowser() {
		 if (driver != null) {
	           driver.quit();
	        }
	}
	
	@Test
	public void verifyHomePage() {
		Hp = new amazonHomePage(driver);
		Hp.verify_LandedToHomePage();
		Am = new AbstractMethods(driver);
		Am.sleepTimeMethod();
		System.out.println(driver.getTitle());
	}
}
