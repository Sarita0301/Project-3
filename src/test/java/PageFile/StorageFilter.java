package PageFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class StorageFilter {
	WebDriver driver;
	
	By FourGbStorage = By.xpath("//*[@id=\"p_n_feature_twenty-nine_browse-bin/44349050031\"]/span/a/span");
	By EightGbStorage = By.xpath("//*[@id=\"p_n_feature_twenty-nine_browse-bin/44349047031\"]/span/a/div/label/i");
	By SixteenGbStorage = By.xpath("//*[@id=\"p_n_feature_twenty-nine_browse-bin/44349052031\"]/span/a/div/label/i");

	By One28GbStorage= By.xpath("//span[text()='128 GB']");
	
	
	
	public StorageFilter(WebDriver driverhere) {
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);
	}
	
	public void FourGbStorage() {
		driver.findElement(FourGbStorage).click();
		System.out.println("4 Gb Storage is Selected");
	}
    public void EightGbStorage() {
    	driver.findElement(EightGbStorage).click();
    	System.out.println("8 Gb Storage is Selected");
    }
    public void SixteenGbStorage() {
    	driver.findElement(SixteenGbStorage).click();
    	System.out.println("16 Gb Storage is Selected");
    }

	public void OneTwentyEightGBStorage() {
		driver.findElement(One28GbStorage).click();
		System.out.println("128 Gb Storage is Selected");
		
	}
	
	

}
