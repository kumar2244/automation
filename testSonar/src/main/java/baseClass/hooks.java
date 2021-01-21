
package baseClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooks extends baseClass {
	private static int pageLoadTimeout = 120;
	private static int webElementTimeout = 60;

	@Before
	public void initialization(Scenario scenario) {

		System.out.println("*****************Test Begins*****************");

		System.setProperty("webdriver.chrome.driver", "./src/main/java/driver/chromedriver.exe"); // if(driver.equals(null))
																									// driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(webElementTimeout, TimeUnit.SECONDS);
	}

	@After
	public void quitBrowser(Scenario scenario) throws IOException {
		takeScreenshotIfTestFails(scenario);
		driver.quit();
		System.out.println("*****************Test Ends*****************");
		System.out.println("*************Generating Report*************");
	}

	public void takeScreenshotIfTestFails(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				File screenshot_with_scenario_name = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot_with_scenario_name,
						new File("./target/test-report/" + scenario.getName() + ".png"));
				System.out.println("Name of Failed Scenario:" + scenario.getName());
				System.out.println("Failed test screenshot :"+ "target/test-report/"+scenario.getName() + ".png");
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}
		}
	}
}
