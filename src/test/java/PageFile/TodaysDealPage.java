package PageFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodaysDealPage {

	WebDriver driver;

	@FindBy(xpath="//*[@id=\"nav-xshop\"]/a[3]")
	WebElement todaysDealBtn;

	By SeeAllDeals = By.xpath("//div[@id=\"nav-subnav\"]/a[2]/span");
	
	By DealOfDay = By.xpath("//*[@id=\"anonCarousel2\"]/ol/li[2]/a/span[1]/img");
	By Clothing = By.xpath("//*[@id=\"anonCarousel2\"]/ol/li[8]/a/span[1]/img");


	public TodaysDealPage(WebDriver driverhere) {
		this.driver=driverhere;
		PageFactory.initElements(driverhere,this);
	}	


	public void TodaysDealsTab() {
		todaysDealBtn.click();
		driver.findElement(SeeAllDeals).click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
	}

	public void DealOfDay() {
		todaysDealBtn.click();
		driver.findElement(DealOfDay).click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
	}
	public void ClothingDeal() {
		todaysDealBtn.click();
		driver.findElement(Clothing).click();
		System.out.println(driver.getTitle());

	}



}
