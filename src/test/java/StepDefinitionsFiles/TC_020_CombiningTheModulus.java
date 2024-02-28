package StepDefinitionsFiles;

import org.openqa.selenium.WebDriver;

import factory.CucumberBaseClass;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LanguageLearning;

public class TC_020_CombiningTheModulus {
	WebDriver driver = CucumberBaseClass.getDriver();

	@When("click on coursera Home Page")
	public void click_on_coursera_home_page() {
		HomePage home = new HomePage(driver);
		home.BackTohomePage();
	}

	@When("Close the Language Box")
	public void close_the_language_box() {
		LanguageLearning language = new LanguageLearning(driver);
		language.LanguageBoxClosing();

	}

}
