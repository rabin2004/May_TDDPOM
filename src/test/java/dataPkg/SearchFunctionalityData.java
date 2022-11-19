package dataPkg;

import org.testng.annotations.DataProvider;

public class SearchFunctionalityData {

	@DataProvider
	public String[] positiveSearchFunctionalityData() {
		String[] data = {"apple","samsung","lg","pixel"}; 
		return data;
	}
	
	@DataProvider
	public String[] negativeSearchFunctionalityData() {
		String[] data = {"873483724983278429HKHFEHFEHFJHJAHFLDFLK",
						"873483723874734983278429HKHFEHFEHFJHJAHFLDFLK"}; 
		return data;
	}
}
