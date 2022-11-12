package dataPkg;

import org.testng.annotations.DataProvider;

public class SearchFunctionalityData {

	@DataProvider
	public String[] positiveSearchFunctionalityData() {
		String[] data = {"apple","samsung","lg","pixel"}; 
		return data;
	}
}
