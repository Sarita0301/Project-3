package PageFile;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.AbstractMethods;

public class SignInPage extends AbstractMethods {

	WebDriver driver;


	@FindBy(xpath="//*[@id=\"nav-link-accountList-nav-line-1\"]")
	WebElement signHover;
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]")
	WebElement LoggedHover;
	
	@FindBy(xpath="//*[@id=\"nav-flyout-ya-signin\"]/a/span")
	WebElement signInButton;
	
	@FindBy(xpath="//*[@id=\"authportal-main-section\"]/div[2]/div[2]/div[1]/form/div/div/div/h1")
	WebElement signInText;
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList-nav-line-1\"]")
	WebElement LoggedUserNameText;
	
	
	
	By emailOrMobile=By.xpath("//input[@id=\"ap_email\"]");
	By continueBtn= By.xpath("//span[@id=\"continue\"]");
	By password=By.xpath("//input[@id=\"ap_password\"]");
	By submitBtn=By.xpath("//*[@id=\"auth-signin-button\"]");
	By signOutBtn=By.xpath("//*[@id=\"nav-item-signout\"]/span");
	
	
	

	public SignInPage(WebDriver driverhere) {
		super(driverhere);
		this.driver= driverhere;
		PageFactory.initElements(driverhere,this);
	}

	public void VerifyLandedToSignInPage() throws IOException {
		//hover on Hello Sign in
		Actions ac = new Actions(driver);
		ac.moveToElement(signHover).build().perform();
		
		//Click on Sign in button
		signInButton.click();
	
		//verify landed to sign page and sign Text is visible
		Assert.assertEquals(signInText.getText(), "Sign in");
		
	}
	public void LoginWithValidData() throws IOException {
		
		//Input the valid email & Mobile no. and password
		FileInputStream fis= new FileInputStream("E:\\eclipse-workspace_Selenium\\Project-3\\src\\test\\java\\DataPackage\\DataFile");
		Properties p= new Properties();
		p.load(fis);
		String emailAndMobileNo=p.getProperty("userEmailInput");
		String Password= p.getProperty("passwordInput");
		
		driver.findElement(emailOrMobile).sendKeys(emailAndMobileNo);
		driver.findElement(continueBtn).click();
		driver.findElement(password).sendKeys(Password);
		
		//click submit button
		driver.findElement(submitBtn).click();
		
		//Verify Logged in as username is visible As "Hello,Ajay"
		Assert.assertEquals(LoggedUserNameText.getText(), "Hello, Ajay");
		
		System.out.println("Test case 18-->> Verify sign in funtion with valid data");
		
		//Click on signOut button
		Actions ac1 = new Actions(driver);
		ac1.moveToElement(LoggedHover).build().perform();
		driver.findElement(signOutBtn).click();

		//verify navigated back to sign page and sign Text is visible
		Assert.assertEquals(signInText.getText(), "Sign in");
		
		System.out.println("Test case 19-->> Verify sign Out");
		
		
		
	}


}
