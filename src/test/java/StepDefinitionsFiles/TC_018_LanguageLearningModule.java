package StepDefinitionsFiles;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import factory.CucumberBaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.LanguageLearning;
import pageObjects.explorePage;
import testBase.BaseClass;

public class TC_018_LanguageLearningModule {
	WebDriver driver = CucumberBaseClass.getDriver();
	Logger log = BaseClass.getLogger();
	HomePage Home = new HomePage(driver);
	Actions act = new Actions(driver);
	boolean courses;
	explorePage explore = new explorePage(driver);
	LanguageLearning CoursesPage = new LanguageLearning(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@When("Mouse Over to explore option")
	public void mouse_over_to_explore_option() {
		log.info("TC_018_LanguageLearningModule is started");
		act.moveToElement(Home.ExploreButton()).build().perform();
	}

	@When("click on the language Learning")
	public void click_on_the_language_learning() {
		js.executeScript("arguments[0].scrollIntoView();", explore.LanguageLearningOption());
		explore.clickOnLanguageLearning();
	}

	@When("click on the All language Courses")
	public void click_on_the_all_language_courses() throws InterruptedException {
		js.executeScript("arguments[0].scrollIntoView();", explore.AllLanguageLearningOption());
		explore.clickOnAllLanguageCourses();
	}

	@Then("check the driver is on the browser language page or not and Count the languages")
	public void check_the_driver_is_on_the_browser_language_page_or_not_and_count_the_languages() {
		courses = CoursesPage.coursesIsthere();
		if (courses) {
			CoursesPage.ContainsLanguages();
			List<WebElement> languages = CoursesPage.LanguagesNames();
			System.out.println("The Languages count in Language learning is " + languages.size());
			Assert.assertTrue(courses);
		} else {
			Assert.assertTrue(courses);
		}
	}

	@Then("count the display the levels")
	public void count_the_display_the_levels() {

		if (courses) {
			List<WebElement> levels = CoursesPage.LevelsOfLanguages();
			System.out.println("The Levels of languages is  " + levels.size());

			for (int i = 0; i < levels.size(); i++) {
				System.out.println(levels.get(i).getText());

			}
			Assert.assertTrue(courses);
		} else {
			Assert.assertTrue(courses);
		}
		log.info("TC_018_LanguageLearningModule is Completed");

	}

}
