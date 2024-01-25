package PageFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CreateYourAccountPage {

	WebDriver driver;
	SignInPage Sip;

	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div/div[2]/div[2]/span/span/a")
	WebElement createYourAcBtn;

	@FindBy(xpath="//*[@id=\"ap_register_form\"]/div/div/h1")
	WebElement creatAccountText;

	@FindBy(xpath="//*[@id=\"auth-country-picker-container\"]/span/span")
	WebElement countryCode;

	@FindBy(xpath="//a[@id=\"auth-country-picker_92\"]")
	WebElement visibleCountryCode;

	@FindBy(xpath="//form[@id=\"ap_register_form\"]/div/div/div[4]/div/div[1]/div/i")
	WebElement passwordRistrictMassage;

	@FindBy(xpath="//div[@id=\"mobileClaimDisclosureMessageRelaxed\"]")
	WebElement mobileNoVerifyMassage;


	@FindBy(xpath="//input[@id=\"auth-pv-enter-code\"]")
	WebElement OTPPage;

	@FindBy(xpath="//*[@id=\"authportal-main-section\"]/div[2]/div/div[3]/div/h1")
	WebElement verifymobileText;


	By firstName=By.xpath("//input[@id=\"ap_customer_name\"]");
	By mobileNo=By.xpath("//input[@id=\"ap_phone_number\"]");
	By emailId=By.xpath("//input[@id=\"ap_email\"]");
	By passwordCreateYourAc=By.xpath("//*[@id=\"ap_password\"]");
	By verifyMobileNumButton=By.xpath("//input[@id=\"continue\"]");




	public CreateYourAccountPage(WebDriver driverhere) {
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);

	}
	public void verifyCreateYourAccountWithValidData() throws IOException {

		//click on sign page
		Sip= new SignInPage(driver);
		Sip.VerifyLandedToSignInPage();

		//click on create your amazon account button
		createYourAcBtn.click();

		//verify landed to create account page
		Assert.assertTrue(creatAccountText.getText().contains("Create Account"), "did not landed to create account page");

		// Enter the First Name & Last Name
		//Input the valid  Enter the First Name & Last Name
		FileInputStream fis= new FileInputStream("E:\\eclipse-workspace_Selenium\\Project-3\\src\\test\\java\\DataPackage\\DataFile");
		Properties p= new Properties();
		p.load(fis);
		String firstAndLastNameInput=p.getProperty("firstAndLastName");
		driver.findElement(firstName).sendKeys(firstAndLastNameInput);

		//Input the mobile no. with country code
		String mobileNoInput=p.getProperty("MobileNo");
		driver.findElement(mobileNo).sendKeys(mobileNoInput);

		//verify country code is automatically select based on geographic location
		//countryCode.sendKeys("India");
		//Assert.assertTrue(visibleCountryCode.isDisplayed(), "Country code India is not visible");


		//Input the email Id
		String emailIDInput=p.getProperty("emailId");
		driver.findElement(emailId).sendKeys(emailIDInput);

		//Input the password
		String passInput=p.getProperty("passCreateYourAc");
		driver.findElement(passwordCreateYourAc).sendKeys(passInput);

		//verify massage is visible "Passwords must be at least 6 characters."
		Assert.assertTrue(passwordRistrictMassage.isDisplayed(), "At leat 6 char password massage is not visible");		

		//verify "to verify your mobile" text is visible
		Assert.assertTrue(mobileNoVerifyMassage.isDisplayed(),"TO verify your number will send temporary code-- massage not visible");

		//click on verify mobile no. button
		driver.findElement(verifyMobileNumButton).click();

		System.out.println("Your account is created");

		System.out.println("Test Case 20-->> Create your account with valid inputs");

	}
}
