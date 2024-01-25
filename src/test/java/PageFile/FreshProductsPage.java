package PageFile;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utility.AbstractMethods;

public class FreshProductsPage {

	WebDriver driver;
	AbstractMethods Am;

	@FindBy(xpath="//a[@href='/fresh?ref_=nav_cs_fresh']")
	WebElement freshBtn;
	
	@FindBy(xpath="//img[@alt='Slot Availability']")
	WebElement deliveryText;
	
	@FindBy(id="contentGrid_7588")
	WebElement ShopByCategory;


	public FreshProductsPage(WebDriver driverhere) {
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);
	}

	public void clickOnFreshButton() {
		freshBtn.click();
	}

	public void verifyTheDeliveryTextVisiblity() {
		Assert.assertTrue(deliveryText.isDisplayed(), "Delivery as fast as 4 hours loginto check slots:-is not visible");
		System.out.println(deliveryText.getText());
	}
	public void verifyShopByCategoryIsVisible() {
		Assert.assertTrue(ShopByCategory.isDisplayed(), "Shop-By-Category is not visible");
		List<WebElement> ShopByCategoryList= driver.findElements(By.id("contentGrid_7588"));


		//for storing the suggestion list
		if (!ShopByCategoryList.isEmpty()) {
			// Print each suggestion
			System.out.println("Shop By Category:");
			Am= new AbstractMethods(driver);
			Am.sleepTimeMethod();
			for (WebElement ShopByCategory : ShopByCategoryList) {
				System.out.println(ShopByCategory.getText());
			}
		} else {
			System.out.println("No search suggestions found.");
		}

	}
}
