package PageFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CategoryFilter {
	WebDriver driver;

	By smartphones=By.xpath("//span[text()='Smartphones']");
	By basicPhone=By.xpath("//span[text()='Basic Mobiles']");

	public CategoryFilter(WebDriver driverhere) {
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);
	}
	
	public void category_Smartphones() {
		driver.findElement(smartphones).click();
	}


	public void category_Basicphones() {
		driver.findElement(basicPhone).click();
	}

}
