package PageFile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RefinementPage {
	WebDriver driver;

	@FindBy(xpath="//*[@id=\"p_90/6741118031\"]/span/a/span")
	WebElement GetItBy2morow;
	
	@FindBy(xpath="//span[text()='Clear all']")
	WebElement clearAllbtn;
	

	public RefinementPage(WebDriver driverhere) {
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);

	}

public void clickOnClearOnButton() {
	clearAllbtn.click();
}


	public void verifyLeftRefinementsVisiblity() {
		List<WebElement> LeftRefinementList=driver.findElements(By.id("s-refinements"));
		//for storing the suggestion list
		Assert.assertTrue(LeftRefinementList.get(0).isDisplayed(), "Left refinement list is not visible.");


		// printting the left refinement of searched product page
		//		if (!LeftRefinementList.isEmpty()) {
		//			// Print each suggestion
		//			System.out.println("Left refinement list:");
		//			Am= new AbstractMethods(driver);
		//			Am.sleepTimeMethod();
		//			for (WebElement LeftRefinement : LeftRefinementList) {
		//				System.out.println(LeftRefinement.getText());
		//			}
		//			// Assertion to check if the left refinement list is visible
		//			
		//		} else {
		//			System.out.println("No search Left refinement found.");
		//		}

	}

	public void delivery_GetItByTomorrow() {
		GetItBy2morow.click();
		System.out.println("GetIt By Tomorrow is selected");
	}
	
}
