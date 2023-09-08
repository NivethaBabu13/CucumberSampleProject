package testRunner;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//import io.cucumber.testng.CucumberOptions.SnippetType;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/features/login.feature"},
		//dryRun = true,
		snippets =  SnippetType.CAMELCASE,
		glue = "steps"
		)

public class Runner {
	
}
