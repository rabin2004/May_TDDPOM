package dataPkg;

import org.testng.annotations.DataProvider;

public class ChangeLanguageData {
	
	@DataProvider
	public String[] languageOptions() {
		String[] data = {"english","Spanish"};
		return data;
	}

}
