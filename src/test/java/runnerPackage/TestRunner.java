package runnerPackage;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//featurefile and stepdefinition linkage


@CucumberOptions(
	features="src/test/java/features",
	glue="setDefinitions")
public class TestRunner extends AbstractTestNGCucumberTests{
	
	

}
