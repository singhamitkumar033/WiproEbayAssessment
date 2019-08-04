package RunnerClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/*@RunWith(Cucumber.class)*/
@CucumberOptions(features = "Features", glue = {
		"stepDefinition" }, monochrome = true, strict = true, dryRun = false, plugin = { "pretty",
				"html:target/Destination" })
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}