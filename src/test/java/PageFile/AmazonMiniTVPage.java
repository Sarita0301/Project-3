package PageFile;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonMiniTVPage {
	WebDriver driver;

	@FindBy(xpath="//img[@alt='Click to visit Amazon Store']")
	WebElement GoToAmazon;

	@FindBy(xpath="//span[text()='Imported']")
	WebElement ImportedTab;

	@FindBy(xpath="//span[text()='Web Series']")
	WebElement WebSeriesTab;

	@FindBy(xpath="//span[text()='Movies']")
	WebElement MoviesTab;

	@FindBy(xpath="//span[text()='Romance']")
	WebElement RomanceTab;

	@FindBy(xpath="//span[text()='Comedy']")
	WebElement ComedyTab;

	@FindBy(xpath="//img[@alt='settings']")
	WebElement settingBtn;
	
	@FindBy(xpath="//*[@id=\"appContainer\"]/nav/div[3]/div[2]/div/div[1]")
	WebElement parentalControl;
	@FindBy(xpath="//*[@id=\"appContainer\"]/nav/div[3]/div[2]/div/div[2]/div")
	WebElement deleteMiniTVdata;
	
	@FindBy(xpath="//button[text()='Yes, I want to']")
	WebElement yesButton;
	
	@FindBy(xpath="//div[@class='AppNavbar_settingsDropDown__vwTVi']")
	WebElement select;
	
	@FindBy(xpath="//*[@id=\"dialog\"]/div[1]/img")
	WebElement Xbutton;

	public AmazonMiniTVPage(WebDriver driverhere) {
		//		super(driverhere);
		this.driver=driverhere;
		PageFactory.initElements(driverhere, this);
	}
	public void clickOnGoToAmazon() {
		GoToAmazon.click();
	}
	public void clickOnImportedTab() {
		ImportedTab.click();
	}

	public void clickOnWebseriesTab() {
		WebSeriesTab.click();
	}

	public void clickOnMoviesTab() {
		MoviesTab.click();
	}

	public void clickOnRomanceTab() {
		RomanceTab.click();
	}
	public void clickOnComedyTab() {
		ComedyTab.click();
	}

	public void clickOnSettingButton() {
		settingBtn.click();
	}
	public void select_ParentalControl() {
		parentalControl.click();
		Xbutton.click();
	}
	public void selec_DeleteMiniTVData() {
		deleteMiniTVdata.click();
	}
	public void select_YesDelete() {
		yesButton.click();
	}

}
