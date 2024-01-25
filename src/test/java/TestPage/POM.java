package TestPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageFile.FreshProductsPage;
import PageFile.SearchProducts;
import PageFile.amazonHomePage;

public class POM {

	WebDriver driver;

	@Test
	public void verifyamazon() {

		try {
			WebDriver driver= new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			amazonHomePage hp= new amazonHomePage(driver);
			hp.verify_LandedToHomePage();
			
			SearchProducts sp= new SearchProducts(driver);
			sp.InputOnSearchTab();
			sp.clickOnSearchButton();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
	

	

}
