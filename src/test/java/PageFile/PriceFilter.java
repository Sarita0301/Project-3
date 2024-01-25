package PageFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PriceFilter {
WebDriver driver;

@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div/div/div/div[4]/ul[1]/span/span[1]/li/span/a/span")
WebElement Under1K;

@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[6]/ul[1]/span/span[2]/li/span/a/span")
WebElement OneKto5K;


@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[6]/ul[1]/span/span[3]/li/span/a/span")
WebElement FiveKto10K;

@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[6]/ul[1]/span/span[4]/li/span/a/span")
WebElement TenKto20K;

@FindBy(xpath="/html/body/div[1]/div[1]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[6]/ul[1]/span/span[5]/li/span/a/span")
WebElement Over20K;


@FindBy(xpath="//input[@id=\"low-price\"]")
WebElement minPrice;

@FindBy(xpath="//input[@id=\"high-price\"]")
WebElement maxPrice;

@FindBy(xpath="//input[@class='a-button-input' and @type='submit']")
WebElement GoBtn;



By SearchFilter=By.xpath("//*[@id=\"/1318505031\"]/span/a");

public PriceFilter(WebDriver driverhere) {
	this.driver=driverhere;
	PageFactory.initElements(driverhere, this);
}
	
	
	public void refinementBy_PriceUnder1k() {
		Under1K.click();
		System.out.println("under 1K");
	}
	public void refinementBy_Price1k_to_5k() {
		OneKto5K.click();
	}
	public void refinementBy_Price5k_to_10k() {
		FiveKto10K.click();
	}
	public void refinementBy_Price10k_to_20k() {
		TenKto20K.click();
	}
	public void refinementBy_Price20k() {
		Over20K.click();
	}
	
	public void verifySearchFilter() {
		driver.findElement(SearchFilter).isDisplayed();
	}
	
	public void inputMinimum_And_MaximumPrice() throws IOException{
		FileInputStream fis = new FileInputStream("E:\\eclipse-workspace_Selenium\\Project-3\\src\\test\\java\\DataPackage\\DataFile");
		Properties p= new Properties();
		p.load(fis);
		String MiniPrice= p.getProperty("MinimumPrice");
		String MaxPrice= p.getProperty("MaximumPrice");
		
		minPrice.sendKeys(MiniPrice);
		maxPrice.sendKeys(MaxPrice);
		GoBtn.click();
		
	}
	//*[@id="p_36/1318503031"]/span/a/span
}
