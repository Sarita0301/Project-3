package PageFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.AbstractMethods;
import Utility.ReUseableMethods;

public class amazonHomePage extends AbstractMethods {
	
	ReUseableMethods Rum;

	WebDriver driver;
	
	
	@FindBy(xpath="//button[@class='a-button-text']")
	WebElement continueShoppingBtn;

	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement amazonInLogo;
	
	@FindBy(xpath="//a[@id='nav-global-location-popover-link']")
	WebElement deliverToPincodeHP;
	
	@FindBy(xpath="//*[@id=\"nav-orders\"]/span[1]")
	WebElement returnsAndOrdersBtn;
	
	@FindBy(xpath="//*[@id=\"a-page\"]/section/div/div[2]/div[1]/h1")
	WebElement yourOrderText;
	

	
	//span[@id='glow-ingress-line2']
	@FindBy(xpath="//input[@id='GLUXZipUpdateInput']")
	WebElement pincodeInput;
	// //input[@type='submit' and @aria-labelledby='GLUXZipUpdate-announce']
	@FindBy(xpath="//*[@id=\\\"GLUXZipUpdate\\\"]/span/input")
	WebElement applyBtn;
	
	@FindBy(xpath="//a[@href='/minitv?ref_=nav_avod_desktop_topnav\']")
	WebElement MiniTVBtn;
		
	public amazonHomePage(WebDriver driverhere) {
		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);
	}
	
	public void verify_LandedToHomePage() {
		Rum= new ReUseableMethods(driver);
		
		Rum.titleEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		}
	
	public void clickOnAmazonInLogo_refresh() {
		amazonInLogo.click();
	}
	
	public void EnterDeliverPinCode() {
		deliverToPincodeHP.click();
		pincodeInput.sendKeys("400070");
		// Use XPath to locate the "Apply" button
        String xpathExpression = "//input[@aria-labelledby='s-refinements-otc-type-title' and @value='Apply']";
        WebElement applyButton = driver.findElement(By.xpath(xpathExpression));
	applyButton.click();
																					
	}
	public void ClickOnMiniTVbutton() {
		MiniTVBtn.click();
	}
	public void verify_LandedToMiniTVPg() {
		Rum= new ReUseableMethods(driver);
		Rum.titleEquals("Amazon miniTV - Watch Free Web Series, Movies, Short Films & K-Dramas Online");
		}
	
	public void verify_returnsAndOrder() {
		returnsAndOrdersBtn.click();
		Assert.assertEquals(yourOrderText.getText(), "Your Orders");
		System.out.println("Test Case 20-->> verify returns & order function");
	}
	
}
