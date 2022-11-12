package pageFactoryPkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.MainClass;

public class HomePage extends MainClass{
	// Creating page factory:
		// 1. Create webElement -> @FindBy
		// 2. Initialize webElement with driver instance -> in constructor
		// 3. define action to be performed with the element in a method
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchTxtBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterProductInSearchTxtBox(String product) {
		searchTxtBox.sendKeys(product);
	}
	
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHomePageURL() {
		return driver.getCurrentUrl();
	}
}