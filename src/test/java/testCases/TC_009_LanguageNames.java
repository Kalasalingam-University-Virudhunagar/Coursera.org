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
import utilities.ExcelUtility;

public class TC_009_LanguageNames extends BaseClass {

	@Test
	public void LanguagesNames() {

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
			explore.clickOnLanguageLearning();

			explore.clickOnAllLanguageCourses();

			LanguageLearning CoursesPage = new LanguageLearning(driver);
			boolean courses = CoursesPage.coursesIsthere();
			if (courses) {

				CoursesPage.ContainsLanguages();
				List<WebElement> languages = CoursesPage.LanguagesNames();
				for (int j = 0; j < languages.size(); j++) {
					for (int i = 0; i < 1; i++) {
						String language = languages.get(j).getText();
						ExcelUtility names = new ExcelUtility(
								System.getProperty("user.dir") + "\\testData\\myfile.xlsx");
						names.setCellData("Sheet1", j, i, language);
					}
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
