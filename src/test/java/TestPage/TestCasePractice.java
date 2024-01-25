package TestPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageFile.AmazonMiniTVPage;
import PageFile.CountryLanguage;
import PageFile.CreateYourAccountPage;
import PageFile.SearchProducts;
import PageFile.SignInPage;
import PageFile.amazonHomePage;
import Utility.AbstractMethods;
import Utility.ReUseableMethods;

public class TestCasePractice {
	WebDriver driver;
	amazonHomePage Hp;
	AbstractMethods Am;
	SearchProducts Sp;
	AmazonMiniTVPage TVpg;
	ReUseableMethods Rum;
	CountryLanguage cl;
	SignInPage Sip;
	CreateYourAccountPage CyAp;
	


	@FindBy(xpath="//img[@alt='settings']")
	WebElement settingBtn;

	@BeforeTest
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


	@AfterTest
	public void closeBrowser() {
		if (driver != null) {
			//driver.quit();
		}
	}
	//
	//	@Test
	//	public void VerifyThePriceFilter() throws IOException {
	//		Hp = new amazonHomePage(driver);
	//		//		Hp.verify_LandedToHomePage();
	//		//
	//		//
	//		Am = new AbstractMethods(driver);
	//		Am.sleepTimeMethod();
	//		Sp= new SearchProducts(driver);
	//		Sp.InputOnSearchTab();
	//
	//		//Sp.EnterOnSearchTab();
	//		Sp.clickOnSearchButton();
	//		Am.sleepTimeMethod();
	//		//
	//		//		//Verify landed to searched product page  and "Result " Text is visible
	//		//		Sp.verifylandedToSearchProductPage();
	//
	//		//Verify Left Refinements are visible
	//		RefinementPage Rp= new RefinementPage(driver);
	//		Rp.verifyLeftRefinementsVisiblity();
	//
	//		//		//Filter the Pricer by "Under 1000"
	//		//		PriceFilter pf= new PriceFilter(driver);
	//		//		pf.refinementBy_PriceUnder1k();
	//		//
	//		//
	//		//		//Filter the Pricer by "1000 to 5000"
	//		//		pf.refinementBy_Price1k_to_5k();
	//		//		Am.sleepTimeMethod();
	//		//
	//		//		//Filter the Pricer by "5000 to 10000"
	//		//		pf.refinementBy_Price5k_to_10k();
	//		//		Am.sleepTimeMethod();
	//		//		//Filter the Pricer by "10000 to 20000"
	//		//		pf.refinementBy_Price10k_to_20k();
	//		//		Am.sleepTimeMethod();
	//		//
	//		//		//Filter the Pricer by "over 20000"
	//		//		pf.refinementBy_Price20k();
	//		//		Am.sleepTimeMethod();
	//		//
	//		//
	//		//		//Filter the Pricer by "user specific range"
	//		//		pf.inputMinimum_And_MaximumPrice();
	//		//
	//		//		System.out.println("Test Case 4-->> Verifing the Price Filter");
	//		//
	//		//		StorageFilter sf= new StorageFilter(driver);
	//		//		sf.FourGbStorage();
	//		//		Am.sleepTimeMethod();
	//		//		sf.EightGbStorage();
	//		//		Am.sleepTimeMethod();
	//		//		sf.SixteenGbStorage();
	//		//		Am.sleepTimeMethod();
	//		//		sf.OneTwentyEightGBStorage();
	//		//		System.out.println("Test Case 5-->> Verifing the Storage Filter");
	//		//
	//		//		Am.sleepTimeMethod();
	//		//		Rp.clickOnClearOnButton();
	//		//		System.out.println("Test Case 6-->> Verifing the Clear All button from Filter");
	//		//
	////		CategoryFilter cf= new CategoryFilter(driver);
	////		cf.category_Basicphones();
	////		Am.sleepTimeMethod();
	////		driver.navigate().back();
	////		driver.navigate().refresh();
	////		cf.category_Smartphones();
	////		Am.sleepTimeMethod();
	////		System.out.println("Test Case 7-->> Verifing the Category filter");
	////
	////		//Click on different brands Filter
	////		BrandFilter bf= new BrandFilter(driver);
	////		bf.clickOnRealmeBrand();
	////		Am.sleepTimeMethod();
	////
	////		//Verify result are visible with "realme Brand"
	////		bf.verifyResult_For_FilteredBrand();
	////		Am.sleepTimeMethod();
	////
	////		Rp.clickOnClearOnButton();
	////		bf.clickOnSamsungBrand();
	////		Am.sleepTimeMethod();
	////
	////		//Verify result are visible with "Samsung Brand"
	////		bf.verifyResult_For_FilteredBrand();
	////		Am.sleepTimeMethod();
	////		System.out.println("Test Case 8-->> Verifing the Brand Filter");
	//
	////		//verify the Discount filter
	////		DiscountFilter df= new DiscountFilter(driver);
	////		df.TenPercentDiscount();
	////		Am.sleepTimeMethod();
	////		
	////		df.TwentyFivePercentDiscount();
	////		Am.sleepTimeMethod();
	////
	////		df.ThirtyFivePercentDiscount();
	////		Am.sleepTimeMethod();
	////		df.FiftyPercentDiscount();
	////		Am.sleepTimeMethod();
	////		df.SixtyPercentDiscount();
	////		Am.sleepTimeMethod();
	//		
	//		
	//		//click on amazon.in logo for rest the page
	//		Hp.clickOnAmazonInLogo_refresh();
	//		
	//		FreshProductsPage fpp= new FreshProductsPage(driver);
	//		Hp.EnterDeliverPinCode();
	//		
	//		
	//		fpp.clickOnFreshButton();
	//		Am.sleepTimeMethod();
	//		fpp.verifyTheDeliveryTextVisiblity();
	//		Am.sleepTimeMethod();
	//		fpp.verifyShopByCategoryIsVisible();
	//		Am.sleepTimeMethod();
	//
	////		
	//
	//	}

	//	@Test
	//	public void verifyAmazonMiniTVFuntion() {
	//		Hp = new amazonHomePage(driver);
	//		Hp.verify_LandedToHomePage();
	//		//Click on AmazonMiniTV Tab
	//		Hp.ClickOnMiniTVbutton();
	//		//verify landed to AmazonMiniTV Home page
	//		Hp.verify_LandedToMiniTVPg();
	//		
	//		//click on "Imported" & verify landed to same 
	//		TVpg= new AmazonMiniTVPage(driver);
	//		TVpg.clickOnImportedTab();
	//		Rum= new ReUseableMethods(driver);
	//		Rum.urlEquals("https://www.amazon.in/minitv/ct/imported");
	//		
	//		TVpg.clickOnWebseriesTab();
	//		Rum.urlEquals("https://www.amazon.in/minitv/ct/web-series");
	//		
	//		TVpg.clickOnMoviesTab();
	//		Rum.urlEquals("https://www.amazon.in/minitv/ct/movies");
	//		
	//		
	//		TVpg.clickOnRomanceTab();
	//		Rum.urlEquals("https://www.amazon.in/minitv/ct/romance");
	//		
	//		TVpg.clickOnComedyTab();
	//		Rum.urlEquals("https://www.amazon.in/minitv/ct/comedy");
	//		
	//		TVpg.clickOnSettingButton();
	//		TVpg.select_ParentalControl();
	//		driver.navigate().back();
	//		TVpg.selec_DeleteMiniTVData();
	//		TVpg.select_YesDelete();
	//		
	//		//TVpg.clickOnGoToAmazon();
	//		//Hp.verify_LandedToHomePage();
	//		System.out.println("");
	//		
	//
	//	}

	public void LanguageOnMouseHoverOnENglish() {
		//Land to home page and verify the same
		Hp = new amazonHomePage(driver);
		Hp.verify_LandedToHomePage();
		cl= new CountryLanguage(driver);
		//cl.languageENvisibility();
		cl.verifyDefault_language();
		Am= new AbstractMethods(driver);
		Am.sleepTimeMethod();

		//cl.VerifyHyperlink_LearnMore();
		//Am.sleepTimeMethod();
		//driver.navigate().back();
		Am.sleepTimeMethod();
		//cl.changeLanguageToHindi();
		//Am.sleepTimeMethod();


		//cl.changeLanguageToEnglish();
		//driver.navigate().back();
		//driver.navigate().refresh();
		cl.verifyHyperlink_ChangeCountryAndRegion();
		// Switch to the new window or tab (assuming it's the last one)
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}


		System.out.println(driver.getCurrentUrl());

	}

	@Test
	public void Verify_createAccountFunctionality() throws IOException {
		//Validate with invalid email Id
		System.out.println("********");
		//Land to home page and verify the same
		Hp = new amazonHomePage(driver);
		//Click on Hello Sign in Accounts & Lists
		//Sip = new SignInPage(driver);
		//Sip.VerifyLandedToSignInPage();
		CyAp= new CreateYourAccountPage(driver);
		CyAp.verifyCreateYourAccountWithValidData();
		

	}


}
