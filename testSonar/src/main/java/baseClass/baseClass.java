package baseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;



public class baseClass {
	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(baseClass.class);
	
	public void launchWebsite(String url) {
		driver.get(url);
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
}
