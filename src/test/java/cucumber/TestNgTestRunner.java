package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber", glue="YaminiBarla.stepDefinitions",
					monochrome=true,tags="@ErrorValidation",plugin= {"html:target/cucumber.html"})

public class TestNgTestRunner extends AbstractTestNGCucumberTests {

	
	
}
