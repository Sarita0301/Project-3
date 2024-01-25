package PageFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div")
	WebElement firstProduct;
	
	@FindBy(xpath="/html/body/div[2]/div/div[5]/div[3]/div[1]/div[3]/div/div[1]/div/div[1]/div/div/div[1]/div/div[2]/div[4]/div[4]/div/form/div/div[1]/span/span/span/input")
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
