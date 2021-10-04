package maximo.myrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		plugin= {"pretty","json:target/cucumber.json" }, 
		features = { ".//Fetatures/" }, 
		glue = {"maximo.stepdefinations","maximo.hooks"}, 				
		dryRun = false, 
		monochrome = true, 
		strict = false,
		tags = { "@smoketest" })
public class MaximoRunner extends AbstractTestNGCucumberTests {

}