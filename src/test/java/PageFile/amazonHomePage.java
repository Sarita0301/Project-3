package PageFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.AbstractMethods;
import Utility.ReUseableMethods;

public class amazonHomePage extends AbstractMethods {
	
	ReUseableMethods Rum;

	WebDriver driver;
	
	
	@FindBy(xpath="//button[@class='a-button-text']")
	WebElement continueShoppingBtn;


	public amazonHomePage(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);
	}
	
	public void verify_LandedToHomePage() {
		Rum= new ReUseableMethods(driver);
		
		Rum.titleEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		}
}
