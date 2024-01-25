package PageFile;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.AbstractMethods;

public class SearchProducts {
	AbstractMethods Am;
	WebDriver driver;

	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchTab;

	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/span/div/div/span")
	WebElement searchProductText;

	@FindBy(id="nav-search-submit-button")
	WebElement searchBtn;

	
	public SearchProducts(WebDriver driverhere) {
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);
	}

	public void InputOnSearchTab() throws IOException {
		FileInputStream fis = new FileInputStream("E:\\eclipse-workspace_Selenium\\Project-3\\src\\test\\java\\DataPackage\\DataFile");
		Properties p= new Properties();
		p.load(fis);
		String product1= p.getProperty("Product1");
		searchTab.sendKeys(product1);
	}

	public void EnterOnSearchTab() throws IOException {
		//searchTab.sendKeys(Keys.ENTER);
		searchTab.sendKeys(Keys.ARROW_DOWN);
		searchTab.sendKeys(Keys.ARROW_DOWN);
		searchTab.sendKeys(Keys.ENTER);	

	}
	public void clickOnSearchButton() {
		searchTab.sendKeys(Keys.ARROW_DOWN);
		searchBtn.click();
		Boolean searchzzz=searchBtn.isEnabled();
		assertTrue(searchBtn.isEnabled(), "Search Button is not enabled");
		System.out.println("Search button :"+searchzzz);
	}

	public void verifylandedToSearchProductPage() {
		Assert.assertTrue(searchProductText.isDisplayed(), "didn't landed to result");
		System.out.println("0000");        
	}


	public void	VerifySearchProducts() throws IOException {

		//Element for suggestion list
		List<WebElement> suggestionList = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));

		//for storing the suggestion list
		if (!suggestionList.isEmpty()) {
			// Print each suggestion
			System.out.println("Search Suggestions:");
			Am= new AbstractMethods(driver);
			Am.sleepTimeMethod();
			for (WebElement suggestion : suggestionList) {
				System.out.println(suggestion.getText());
			}
		} else {
			System.out.println("No search suggestions found.");
		}

	}

	

}
