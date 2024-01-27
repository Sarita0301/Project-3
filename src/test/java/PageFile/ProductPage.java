package PageFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[8]/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div/img")
	WebElement firstProduct;
	
	@FindBy(xpath="//*[@id=\"add-to-cart-button\"]")
	WebElement AddToCartBtn;
	
	
	public ProductPage(WebDriver driverhere) {
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);
	}
	public void VerifyFirstProductDetailsVisiblity() {
		firstProduct.click();
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
		}
		System.out.println(driver.getTitle());
		System.out.println("Test Case 21-->> verify the product details page");
	}

}
