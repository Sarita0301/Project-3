package PageFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DiscountFilter {

	WebDriver driver;

	By TenPercent=By.xpath("//span[text()='10% Off or more']");
	By TwentyFivePercent=By.xpath("//span[text()='25% Off or more']");
	By ThirtyFivePercent=By.xpath("//span[text()='35% Off or more']");
	By FiftyPercent=By.xpath("//span[text()='50% Off or more']");
	By SixtyPercent=By.xpath("//span[text()='60% Off or more']");
	

	public DiscountFilter(WebDriver driverhere) {
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);
	}
	
	public void TenPercentDiscount() {
		driver.findElement(TenPercent).click();
	}


	public void TwentyFivePercentDiscount() {
		driver.findElement(TwentyFivePercent).click();
	}
	
	public void ThirtyFivePercentDiscount() {
		driver.findElement(ThirtyFivePercent).click();
	}

	public void FiftyPercentDiscount() {
		driver.findElement(FiftyPercent).click();
	}
	public void SixtyPercentDiscount() {
		driver.findElement(SixtyPercent).click();
	}
	}