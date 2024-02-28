package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LanguageLearning;
import pageObjects.explorePage;
import testBase.BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class TC_007_LanguageLearning extends BaseClass {

	@Test
	public void CheckLanguageCourse() throws InterruptedException {
		logger.info("TC_007_LanguageLearning is started");
		try {
			Thread.sleep(10000);
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

				Assert.assertTrue(courses);
			} else {
				Assert.assertTrue(courses);
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_007_LanguageLearning is completed");

	}

}
