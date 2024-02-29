package testRunner;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import StepDefinitionsFiles.Hooks;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "@target/rerun.txt" },
		// features = { ".//Features/CourseraValidation.feature",
		// ".//Features/WebDevelopmentCourses.feature" },
		// features= {".//Features/InputDatatoFeature.feature"},
		// features = { ".//Features" },
		// features= {".//Features/Integration.feature"},
		// features = { ".//Features/LanguageLearning.feature" },
		// ".//Features/WebDevelopmentCourses.feature" },
		// features= {".//Features/LanguageLearning.feature"},
		// features= {".//Features/CourseraCampus.feature"},
		glue = "StepDefinitionsFiles", tags = "@smoke or @regression or @retest", plugin = { "pretty",
				"html:reports/myreport.html", "rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },

		dryRun = false,

		monochrome = true, publish = true

)
public class TestRunner extends AbstractTestNGCucumberTests {

	@BeforeClass
	public void set(ITestContext context) {
		Hooks.setTestParameters(context);
	}

}
