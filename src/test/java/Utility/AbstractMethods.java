package Utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractMethods {
	WebDriver driver;

	public AbstractMethods(WebDriver driverhere) {
		this.driver = driverhere;
		PageFactory.initElements(driverhere, this);
	}

	public void Wait_Till_Link_Is_Clickable(By FindBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(FindBy));
	}

	public void visibility_Of_Element_Located(By FindBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}

	public void sleepTimeMethod() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	
	public void scroll_Down() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(500, document.body.scrollHeight)");

	}
	public void scroll_Up() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(-500, document.body.scrollHeight)");

	}
	
	public void Hoveranyelement(WebElement el) {

		Actions ac = new Actions(driver);
		ac.moveToElement(el).build().perform();
	}

}
