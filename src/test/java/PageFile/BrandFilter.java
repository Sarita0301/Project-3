package PageFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BrandFilter {

	WebDriver driver;

	By realme=By.xpath("//*[@id=\"p_89/realme\"]/span/a/div/label/i");
	By samsung=By.xpath("//*[@id=\"p_89/Samsung\"]/span/a/span");
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[7]/div/div/span/div/div/div/div[2]/div")
	WebElement resultBrandText;
	

	public BrandFilter(WebDriver driverhere) {
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);
	}
	
	public void clickOnRealmeBrand() {
		driver.findElement(realme).click();
	}


	public void clickOnSamsungBrand() {
		driver.findElement(samsung).click();
	}

	public void verifyResult_For_FilteredBrand() {
		Assert.assertTrue(resultBrandText.getText().contains("realme"), "Shorted Brand products are not visible");
	System.out.println(resultBrandText.isDisplayed());
	}
	
}
