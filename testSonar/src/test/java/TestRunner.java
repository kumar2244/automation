
  import java.io.File;

import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
  import cucumber.api.CucumberOptions;
  import cucumber.api.junit.Cucumber;
  
  @RunWith(Cucumber.class)
  @CucumberOptions( features = "src/test/java/features", 
  glue="",
   tags="@uiTest",
  plugin = {
		  "pretty", "html:target/cucumber-reports", "json:target/cucumber-reports/cucumber.json",
  "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
  )
  
  
  public class TestRunner {
  
  public static void writeExtentReport() { 
	  Reporter.loadXMLConfig(new File("config/report.xml")); }
  
  }
 
