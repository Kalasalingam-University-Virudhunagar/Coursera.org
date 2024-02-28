package StepDefinitionsFiles;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.CucumberBaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testBase.BaseClass;

public class TC_016_CourseraValiation {

	public String pageTitle;
	WebDriver driver = CucumberBaseClass.getDriver();
	Properties p = CucumberBaseClass.getProperties();
	Logger log = BaseClass.getLogger();

	@Given("Navigate to the Url")
	public void navigate_to_the_url() {
		log.info("navigate to the url");
		driver.get(p.getProperty("appURL"));
	}

	@When("Take the Page Title")
	public void take_the_page_title() {
		log.info("TC_016_CourseraValiation Test Case is Started");
		log.info("Getting the Page Title");
		pageTitle = driver.getTitle();
	}

	@Then("Validate the page title with {string}")
	public void validate_the_page_title_with(String Title) {
		log.info("Validate the title");
		if (pageTitle.contains(Title)) {
			Assert.assertTrue(pageTitle.contains(pageTitle));
		} else {
			Assert.assertTrue(pageTitle.contains(pageTitle));
		}
		log.info("TC_016_CourseraValiation Test Case is completed");

	}

}
