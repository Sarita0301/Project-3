package TestPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageFile.AboutUsPage;
import PageFile.AddToCartPage;
import PageFile.AmazonMiniTVPage;
import PageFile.BrandFilter;
import PageFile.CategoryFilter;
import PageFile.CountryLanguage;
import PageFile.CreateYourAccountPage;
import PageFile.DiscountFilter;
import PageFile.PriceFilter;
import PageFile.ProductPage;
import PageFile.RefinementPage;
import PageFile.SearchProducts;
import PageFile.SignInPage;
import PageFile.StorageFilter;
import PageFile.TodaysDealPage;
import PageFile.amazonHomePage;
import Utility.AbstractMethods;
import Utility.ReUseableMethods;

public class Automation_Test_AmazonIN {
	WebDriver driver;
	amazonHomePage Hp;
	AbstractMethods Am;
	SearchProducts Sp;
	AmazonMiniTVPage TVpg;
	ReUseableMethods Rum;
	CountryLanguage cl;
	SignInPage Sip;
	CreateYourAccountPage CyAp;
	ProductPage Pp;
	AddToCartPage Acp;
	TodaysDealPage Tdp;
	AboutUsPage Ausp;


	@BeforeMethod
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


	@AfterMethod
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test(priority=1)
	public void verifyHomePage() throws IOException {
		//Verify Navigated to Home Page
		Hp = new amazonHomePage(driver);
		Hp.verify_LandedToHomePage();

		//Sleep Time
		Am = new AbstractMethods(driver);
		Am.sleepTimeMethod();

		System.out.println("Test Case 1-->> Verifing the Home Page visible");
	}

	@Test(priority=2)
	public void verifySearchTab_EnterKeys_or_SearchButton() throws IOException {
		//Verify Navigated to Home Page
		Hp = new amazonHomePage(driver);
		Hp.verify_LandedToHomePage();

		//Sleep time
		Am = new AbstractMethods(driver);
		Am.sleepTimeMethod();

		//Verify search tab and get the suggestion of product list
		Sp= new SearchProducts(driver);
		Sp.InputOnSearchTab();
		Sp.VerifySearchProducts();
		Sp.EnterOnSearchTab();


		System.out.println("Test Case 2-->> Verifing the Search Tab and get the suggestion list visible");


		driver.navigate().back();
		driver.navigate().refresh();

		//Search Product "charger" & get charger suggestion's
		Sp= new SearchProducts(driver);
		Sp.InputOnSearchTab();

		//Click on Search Button & Verifying it's enabled
		Sp.clickOnSearchButton();

		//Verify Landed to searched product result page		
		Sp.verifylandedToSearchProductPage();

		System.out.println("Test Case 3-->> Verifing the Home Page visible");


	}	

	@Test(priority=3)
	public void VerifyThePriceFilter() throws IOException {
		Hp = new amazonHomePage(driver);
		Hp.verify_LandedToHomePage();


		Am = new AbstractMethods(driver);
		Am.sleepTimeMethod();
		Sp= new SearchProducts(driver);
		Sp.InputOnSearchTab();

		//Sp.EnterOnSearchTab();
		Sp.clickOnSearchButton();
		Am.sleepTimeMethod();

		//Verify landed to searched product page  and "Result " Text is visible
		Sp.verifylandedToSearchProductPage();

		//Verify Left Refinements are visible
		RefinementPage Rp= new RefinementPage(driver);
		Rp.verifyLeftRefinementsVisiblity();

		//Filter the Pricer by "Under 1000"
		PriceFilter pf= new PriceFilter(driver);
		pf.refinementBy_PriceUnder1k();


		//Filter the Pricer by "1000 to 5000"
		pf.refinementBy_Price1k_to_5k();
		Am.sleepTimeMethod();

		//Filter the Pricer by "5000 to 10000"
		pf.refinementBy_Price5k_to_10k();
		Am.sleepTimeMethod();
		//Filter the Pricer by "10000 to 20000"
		pf.refinementBy_Price10k_to_20k();
		Am.sleepTimeMethod();

		//Filter the Pricer by "over 20000"
		pf.refinementBy_Price20k();
		Am.sleepTimeMethod();


		//Filter the Pricer by "user specific range"
		pf.inputMinimum_And_MaximumPrice();

		System.out.println("Test Case 4-->> Verifing the Price Filter");


		//Change filter by storage 4GB, 8GB, 16GB and 128GB
		StorageFilter sf= new StorageFilter(driver);
		sf.FourGbStorage();
		Am.sleepTimeMethod();
		sf.EightGbStorage();
		Am.sleepTimeMethod();
		sf.SixteenGbStorage();
		Am.sleepTimeMethod();
		sf.OneTwentyEightGBStorage();
		System.out.println("Test Case 5-->> Verifing the Storage Filter");

		Am.sleepTimeMethod();
		Rp.clickOnClearOnButton();
		System.out.println("Test Case 6-->> Verifing the Clear All button from Filter");


		CategoryFilter cf= new CategoryFilter(driver);
		cf.category_Basicphones();
		Am.sleepTimeMethod();
		//cf.category_Smartphones();
		//Am.sleepTimeMethod();
		System.out.println("Test Case 7-->> Verifing the Category filter");
		driver.navigate().back();


		//Click on different brands Filter
		BrandFilter bf= new BrandFilter(driver);
		bf.clickOnRealmeBrand();
		Am.sleepTimeMethod();


		//Verify result are visible with "realme Brand"
		bf.verifyResult_For_FilteredBrand();
		Am.sleepTimeMethod();

		Rp.clickOnClearOnButton();
		bf.clickOnSamsungBrand();
		Am.sleepTimeMethod();

		//Verify result are visible with "Samsung Brand"
		bf.verifyResult_For_FilteredBrand();
		Am.sleepTimeMethod();

		System.out.println("Test Case 8-->> Verifing the Brand Filter");
		
	
		//verify the Discount filter
		DiscountFilter df= new DiscountFilter(driver);
		df.TenPercentDiscount();
		Am.sleepTimeMethod();

		df.TwentyFivePercentDiscount();
		Am.sleepTimeMethod();

		df.ThirtyFivePercentDiscount();
		Am.sleepTimeMethod();
		df.FiftyPercentDiscount();
		Am.sleepTimeMethod();
		df.SixtyPercentDiscount();
		Am.sleepTimeMethod();

		System.out.println("Test Case 9-->> Verifing the Discount Filter");


		//click on amazon.in logo for rest the page
		Hp.clickOnAmazonInLogo_refresh();
		Hp.verify_LandedToHomePage();

		System.out.println("Test Case 10-->> Verifing the Amazon.in logo button");



	}
	@Test(priority=4)
	public void verifyAmazonMiniTVFuntion() {
		Hp = new amazonHomePage(driver);
		Hp.verify_LandedToHomePage();
		//Click on AmazonMiniTV Tab
		Hp.ClickOnMiniTVbutton();
		//verify landed to AmazonMiniTV Home page
		Hp.verify_LandedToMiniTVPg();

		//click on "Imported" & verify landed to same 
		TVpg= new AmazonMiniTVPage(driver);
		TVpg.clickOnImportedTab();
		Rum= new ReUseableMethods(driver);
		Rum.urlEquals("https://www.amazon.in/minitv/ct/imported");


		//click on "Web series" & verify landed to same 
		TVpg.clickOnWebseriesTab();
		Rum.urlEquals("https://www.amazon.in/minitv/ct/web-series");


		//click on "Movies" & verify landed to same 
		TVpg.clickOnMoviesTab();
		Rum.urlEquals("https://www.amazon.in/minitv/ct/movies");


		//click on "Romance" & verify landed to same 
		TVpg.clickOnRomanceTab();
		Rum.urlEquals("https://www.amazon.in/minitv/ct/romance");


		//click on "Comedy" & verify landed to same 
		TVpg.clickOnComedyTab();
		Rum.urlEquals("https://www.amazon.in/minitv/ct/comedy");

		System.out.println("Test Case 11--> Amazon Mini Tv page different tab function");

		//click on "Setting" & select the parental control
		TVpg.clickOnSettingButton();
		TVpg.select_ParentalControl();
		driver.navigate().back();
		//click on "delete Data" & Verify navigate back to home page

		TVpg.selec_DeleteMiniTVData();
		Hp.verify_LandedToHomePage();
		System.out.println("Test Case 12-->> verify settings features of mini tv page");


		//TVpg.clickOnGoToAmazon();
		//Hp.verify_LandedToHomePage();
	}


	@Test(priority=5)
	public void LanguageOnMouseHoverOnENglish() {
		//Land to home page and verify the same
		Hp = new amazonHomePage(driver);
		Hp.verify_LandedToHomePage();
		
		cl= new CountryLanguage(driver);
		cl.verifyDefault_language();
		
		Am= new AbstractMethods(driver);
		Am.sleepTimeMethod();
		
		Hp = new amazonHomePage(driver);
		Hp.verify_LandedToHomePage();
		
		cl.VerifyHyperlink_LearnMore();
		Am.sleepTimeMethod();
		driver.navigate().back();
		
		
		cl.changeLanguageToHindi();
		Am.sleepTimeMethod();
		driver.navigate().back();

		
		Hp = new amazonHomePage(driver);
		Hp.verify_LandedToHomePage();
		
		cl.verifyHyperlink_ChangeCountryAndRegion();
		// Switch to the new window or tab (assuming it's the last one)
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}
		System.out.println(driver.getCurrentUrl());

	}

	@Test(priority=6)
	public void Verify_SignInPage() throws IOException {
		//Validate with invalid email Id
		System.out.println("********");
		//Land to home page and verify the same
		Hp = new amazonHomePage(driver);
		//Click on Hello Sign in Accounts & Lists
		Sip = new SignInPage(driver);
		Sip.VerifyLandedToSignInPage();
		Sip.LoginWithValidData();
	}

	@Test(priority=7)
	public void Verify_createAccountFunctionality() throws IOException {

		//Land to home page and verify the same
		Hp = new amazonHomePage(driver);
		//Click on Hello Sign in Accounts & Lists
		//Sip = new SignInPage(driver);
		//Sip.VerifyLandedToSignInPage();
		CyAp= new CreateYourAccountPage(driver);
		CyAp.verifyCreateYourAccountWithValidData();


	}
	@Test(priority=8)
	public void viewProductDetails_And_AddProductToCart() {
		Hp = new amazonHomePage(driver);
		Pp= new ProductPage(driver);
		Pp.VerifyFirstProductDetailsVisiblity();
		Acp= new AddToCartPage(driver);
		Acp.verifyAddtoCartPage();
	}
	
	@Test(priority=9)
	public void TodayDealsTabFunction() {
		Hp= new amazonHomePage(driver);
		
		Tdp= new TodaysDealPage(driver);
		Tdp.DealOfDay();
		Tdp.TodaysDealsTab();
		Tdp.ClothingDeal();
		System.out.println("Test Case -->> Today's Deals Tab");
		
	}
	@Test(priority=10)
	public void verifyAboutUs_atfooterHomePage() {
		Hp= new amazonHomePage(driver);
		
		Ausp= new AboutUsPage(driver);
		Ausp.FooterElement();
		Ausp.AboutUs();
		Ausp.Careers();
		
		
		System.out.println("Test Case -->> Verify About Us on Footer of home page");
		
	}

}





//	@Test(priority=3)
//	public void verifyHomePagesearchWith_SearchButton() throws IOException {
//		Hp = new amazonHomePage(driver);
//		Hp.verify_LandedToHomePage();
//
//
//		Am = new AbstractMethods(driver);
//		Am.sleepTimeMethod();
//
//		//Search Product "charger" & get charger suggestion's
//		Sp= new SearchProducts(driver);
//		Sp.InputOnSearchTab();
//		//		Sp.VerifySearchProducts();
//
//		//Click on Search Button & Verifying it's enabled
//		Sp.clickOnSearchButton();
//
//		//Verify Landed to searched product result page		
//		Sp.verifylandedToSearchProductPage();
//
//
//		System.out.println("Test Case 3-->> Verifing the Home Page visible");
//	}


