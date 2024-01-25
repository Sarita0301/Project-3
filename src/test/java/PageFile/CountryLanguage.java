package PageFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.AbstractMethods;
import Utility.ReUseableMethods;

public class CountryLanguage extends AbstractMethods{


	WebDriver driver;
	ReUseableMethods Rum;

	@FindBy(xpath="//a[@id='icp-nav-flyout']")
	WebElement eNMouseHover;
	
	@FindBy(xpath="/html/body/div[1]/header/div/div[1]/div[3]/div/a[1]/span/span[1]")
	WebElement HiMouseHover;

	@FindBy(xpath="//*[@id=\"icp-nav-flyout\"]/span/span[2]/div")
	WebElement defaultLang;

	By learnMoreOption= By.linkText("Learn more");
	//@FindBy(xpath="/html/body/div[1]/header/div/div[3]/div[13]/div[2]/a[9]/span/div")
	//WebElement LearMoreOption;

	@FindBy(xpath="//*[@id=\"nav-flyout-icp\" and @class=\"nav-coreFlyout nav-flyout\"]/div[2]/a[2]/span/i")
	WebElement hindiOption;

	@FindBy(xpath="/html/body/div[1]/header/div/div[3]/div[13]/div[2]/a[1]/span/i")
	WebElement englishOption;

	@FindBy(xpath="/html/body/div[1]/header/div/div[3]/div[14]/div[2]/a[10]/span/div")
	WebElement changeCountryRegionLink;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[2]/div[2]/div[1]/span/span/span/span")
	WebElement countryDropdown;
	
	@FindBy(xpath="//*[@id=\"icp-save-button\"]/span/input")
	WebElement goToWebsite;

	public CountryLanguage(WebDriver driverhere) {
		super(driverhere);
		this.driver= driverhere;
		PageFactory.initElements(driverhere, this);
	}

	public void verifyDefault_language() {
		Actions actions = new Actions(driver);
		// Hover over the "EN" element
		actions.moveToElement(eNMouseHover).perform();
		//verify defult language "EN"
		Assert.assertEquals(defaultLang.getText(), "EN");
		System.out.println("Test Case 13-->> Verify the defauly language ENglish");
		sleepTimeMethod();

	}
	public void VerifyHyperlink_LearnMore() {
		Actions actions = new Actions(driver);
		// Hover over the "EN" element
		actions.moveToElement(eNMouseHover).perform();

		//Click on LearnMore Option
		//LearMoreOption.click();
		driver.findElement(learnMoreOption).click();
		//driver.findElement(By.partialLinkText("Learn More")).click();
		//verify landed to learn more page

		Rum=new ReUseableMethods(driver);
		Rum.urlEquals("https://www.amazon.in/hz/cs/help?ref_=icp_language_help&nodeId=GARKQZZYZ542RGWK");
		System.out.println("Test case 14-->> Verify Country dropdown learn More option");
		sleepTimeMethod();
	}

	public void changeLanguageToHindi() {
		Actions actions = new Actions(driver);
		actions.moveToElement(eNMouseHover).perform();
		hindiOption.click();
		
		System.out.println("Test case 15-->> Verify Country dropdown Change language hindi");
		
	}
	public void changeLanguageToEnglish() {
		Actions actions = new Actions(driver);
		actions.moveToElement(eNMouseHover).build().perform();
		englishOption.click();
		System.out.println("Test case 16-->> Verify Country dropdown learn More option");
		

	}

	public void verifyHyperlink_ChangeCountryAndRegion() {
		Actions actions = new Actions(driver);
		actions.moveToElement(HiMouseHover).perform();
		changeCountryRegionLink.click();
	
		// Click on the dropdown to open it
		countryDropdown.click();

		// Locate the specific option within the dropdown (replace "United Kingdom" with the actual option text)
		WebElement optionCanada = driver.findElement(By.xpath("//*[@id=\"icp-dropdown_3\"]"));

		// Click on the desired option
		optionCanada.click();
		
		goToWebsite.click();
		
		System.out.println("Test case 17-->> Verify Change Country And Region option from India to Canada");
		
	}
}


