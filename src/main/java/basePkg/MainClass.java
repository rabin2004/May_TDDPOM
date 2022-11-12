package basePkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {
	public static Properties prop;
	public static WebDriver driver;
	
	public MainClass() {
		try {
			prop = new Properties();	
			FileInputStream fis = new FileInputStream(new File("C:\\Users\\User\\eclipse-workspace"
					+ "\\TDDPOM_May\\src\\main\\java\\configPkg\\config.properties"));
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void intialization() {		
		System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromePath"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.valueOf(prop.
				getProperty("pageLoadTimeDuration")))); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.
				valueOf(prop.getProperty("implicitWaitDuration")))); 
		driver.get(prop.getProperty("qaEnvTestUrl"));
	}
	
	public void tearDown() {
		driver.quit();
	}

}
