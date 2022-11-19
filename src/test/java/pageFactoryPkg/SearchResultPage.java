package pageFactoryPkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.MainClass;

public class SearchResultPage extends MainClass{
	
	@FindBy(xpath="//span[@class='a-color-state a-text-bold']")
	WebElement searchResultHeader;
	@FindBy(xpath="//a[@href='/ref=nav_logo']")
	WebElement amazonIconToGobackToHomePage;
	@FindBy(xpath="//span[text()='No results for ']")
	WebElement noResultErrorMsg;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String returnSearchResultHeader() {
		return searchResultHeader.getText();
	}
	
	public String returnSearchResultPageTitle() {
		return driver.getTitle();
	}
	
	public void clickAmazonIcon() {
		amazonIconToGobackToHomePage.click();
	}
	
	public boolean visibilityOfNoResultErrorMsg() {
		return noResultErrorMsg.isDisplayed();
	}

}
