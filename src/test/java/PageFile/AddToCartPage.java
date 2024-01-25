package PageFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddToCartPage {
	WebDriver driver;


	@FindBy(xpath="/html/body/div[2]/div/div[5]/div[3]/div[1]/div[3]/div/div[1]/div/div[1]/div/div/div[1]/div/div[2]/div[4]/div[4]/div/form/div/div[1]/span/span/span/input")
	WebElement AddTOCartBtn;	

	@FindBy(xpath="//*[@id=\"attachDisplayAddBaseAlert\"]/div/h4")
	WebElement AddedTocartText;

	@FindBy(xpath="//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")
	WebElement cartBtn;

	@FindBy(xpath="/html/body/div[1]/div[1]/div[4]/div[5]/div/div[2]/div[1]/div/div[1]/div[1]/h1")
	WebElement shoppingCartText;
	
	@FindBy(xpath="//*[@id=\"sc-buy-box-ptc-button\"]/span/input")
	WebElement proceedToBuyBtn;

	public AddToCartPage(WebDriver driverhere) {
		this.driver= driverhere;
		PageFactory.initElements(driverhere,this);
	}

	public void verifyAddtoCartPage() {
		AddTOCartBtn.click();
		//Verify Product added to cart is visible
		Assert.assertTrue(AddedTocartText.isDisplayed(), "Product is not added to cart");
		cartBtn.click();
		Assert.assertTrue(shoppingCartText.isDisplayed(), "shopping cart is visible");
		System.out.println("Test Case 22-->> Add to Cart");
	}

}
