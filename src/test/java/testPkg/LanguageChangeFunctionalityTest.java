package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePkg.MainClass;
import pageFactoryPkg.ChangeLanguagePage;
import pageFactoryPkg.HomePage;

public class LanguageChangeFunctionalityTest extends MainClass{

	static HomePage hp;
	static ChangeLanguagePage clp;
	
	@BeforeClass
	public void loadBrowser() {
		intialization();
		hp = new HomePage();
		clp = new ChangeLanguagePage();
	}
	
	@AfterClass
	public void closeBrowser() {
		tearDown();
	}
	
	@BeforeMethod
	public void validationChangeLanguagePage() {
		hp.clickLanguageChangeOption();
		Assert.assertEquals(clp.getChangeLanguagePageTitle(), 
				prop.getProperty("ChangeLanguagePageTitle"));
	}
	
	@Test(dataProviderClass=dataPkg.ChangeLanguageData.class, dataProvider="languageOptions")
	public void quickChangeLanguageFunctionalityTest(String langSelected) {
		if(langSelected.equalsIgnoreCase("english")) {
			clp.clickEnglishLangOption();
			Assert.assertEquals(clp.languageSettingHeaderTxt(), 
					prop.getProperty("languageHeaderEnglish"));
		}else if(langSelected.equalsIgnoreCase("spanish")) {
			clp.clickSpanishLangOption();;
			Assert.assertEquals(clp.languageSettingHeaderTxt(), 
					prop.getProperty("languageHeaderSpanish"));
		}
	}
	
}
