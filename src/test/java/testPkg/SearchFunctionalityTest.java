package testPkg;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePkg.MainClass;
import pageFactoryPkg.HomePage;
import pageFactoryPkg.SearchResultPage;

public class SearchFunctionalityTest extends MainClass{
	static HomePage hp;
	static SearchResultPage srp;
	
	@BeforeClass
	public void loadBrowser() {
		intialization();
		hp = new HomePage();
		srp = new SearchResultPage();
	}
	
	@AfterClass
	public void closeBrowser() {
		tearDown();
	}
	
	@BeforeMethod
	public void validationHomePage() {
		Assert.assertTrue(hp.getHomePageTitle().contains(prop.getProperty("homepageTitle")));
	}
	
	@AfterMethod
	public void backToHomePage() {
		srp.clickAmazonIcon();
	}
	
	@Test(dataProviderClass = dataPkg.SearchFunctionalityData.class, 
			dataProvider = "positiveSearchFunctionalityData")
	public void positiveSearchFunctionality(String product) {
		hp.enterProductInSearchTxtBox(product);
		hp.clickSearchBtn();
		Assert.assertTrue(srp.returnSearchResultPageTitle().contains(product));
		Assert.assertTrue(srp.returnSearchResultHeader().contains(product));
	}
	
	@Test(dataProviderClass = dataPkg.SearchFunctionalityData.class, 
			dataProvider = "negativeSearchFunctionalityData")
	public void negativeSearchFunctionalityTest(String product) {
		hp.enterProductInSearchTxtBox(product);
		hp.clickSearchBtn();
		Assert.assertTrue(srp.visibilityOfNoResultErrorMsg());
	}
	
	
	
	
	

}
