package PageFile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AboutUsPage {
	
	
		WebDriver driver;

		By FooterElement = By.xpath("//div[@id=\"navFooter\"]");
		By AboutUs = By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[1]/a");
		By Careers = By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[2]/a");

		public AboutUsPage(WebDriver driverhere) {
			this.driver = driverhere;
		PageFactory.initElements(driverhere, this);
		}

		public void FooterElement() {
			driver.findElement(FooterElement);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FooterElement);
		}

		public void AboutUs() {
			driver.findElement(AboutUs).click();
			
			driver.navigate().back();
		}

		public void Careers() {
			driver.findElement(Careers).click();
			
		}

	

}
