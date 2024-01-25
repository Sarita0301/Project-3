package PageFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeactureFilter {

	WebDriver driver;

	By realme=By.xpath("//*[@id=\"p_89/realme\"]/span/a/div/label/i");
	By samsung=By.xpath("//*[@id=\"p_89/Samsung\"]/span/a/span");
	@FindBy(xpath="//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[7]/div/div/span/div/div/div/div[2]/div")
	WebElement resultBrandText;
	

	public FeactureFilter(WebDriver driverhere) {
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);
	}
}
