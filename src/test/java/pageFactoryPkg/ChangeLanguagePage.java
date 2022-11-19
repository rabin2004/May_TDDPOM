package pageFactoryPkg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePkg.MainClass;

public class ChangeLanguagePage extends MainClass{
	
	@FindBy(id="icp-language-heading")
	WebElement languageSettingHeader;
	@FindBy(xpath="//input[@value='en_US']/following-sibling::i")
	WebElement englishLanguageRadioBtn;
	@FindBy(xpath="//input[@value='es_US']/following-sibling::i")
	WebElement spanishLanguageRadioBtn;
	@FindBy(xpath="//input[@aria-labelledby='icp-save-button-announce']")
	WebElement saveChangesBtn;

	public ChangeLanguagePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String languageSettingHeaderTxt() {
		return languageSettingHeader.getText().trim();
	}
	
	public void clickEnglishLangOption() {
		englishLanguageRadioBtn.click();
	}
	
	public void clickSpanishLangOption() {
		spanishLanguageRadioBtn.click();
	}
	
	public void clickSaveChanges() {
		saveChangesBtn.click();
	}
	
	public String getChangeLanguagePageTitle() {
		return driver.getTitle();
	}
}
