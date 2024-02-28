package testCases;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LanguageLearning;
import pageObjects.explorePage;
import testBase.BaseClass;

public class TC_008_LevelsOfLanguages extends BaseClass {

	@Test
	public void LanguageLevels() {
		logger.info("TC_008_LevelsOfLanguages is started");
		try {
			HomePage Home = new HomePage(driver);
			Actions act = new Actions(driver);
			act.moveToElement(Home.ExploreButton()).build().perform();
			explorePage explore = new explorePage(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", explore.LanguageLearningOption());
			explore.clickOnLanguageLearning();
			js.executeScript("arguments[0].scrollIntoView();", explore.AllLanguageLearningOption());

			explore.clickOnAllLanguageCourses();
			LanguageLearning CoursesPage = new LanguageLearning(driver);
			boolean courses = CoursesPage.coursesIsthere();
			if (courses) {

				List<WebElement> levels = CoursesPage.LevelsOfLanguages();
				for (int i = 0; i < levels.size(); i++) {
					System.out.println(levels.get(i).getText());

				}
				Assert.assertTrue(courses);
			} else {
				Assert.assertTrue(courses);
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_008_LevelsOfLanguages is completed");

	}

}
