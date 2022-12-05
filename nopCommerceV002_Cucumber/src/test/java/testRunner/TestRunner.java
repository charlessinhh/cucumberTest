package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "classpath:feature" }, glue = { "classpath:stepDefinitions" }, // steps
		// file
		dryRun = false, // 'true' -> without real execution check every feature file step containing
						// every method
		// or not

		monochrome = true, plugin = { "pretty", // output in console window with every step
				"html:target/cucumber-reports/cucumber.html" // test generated in target folder
				, "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml" }

)

public class TestRunner {

}
