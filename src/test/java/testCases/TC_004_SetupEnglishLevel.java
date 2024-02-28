package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.HomePage;
import testBase.BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class TC_004_SetupEnglishLevel extends BaseClass {
	@Test
	public void languageSetup() {
		logger.info("TC_004_SetupEnglishLevel is started");
		try {
			HomePage HP = new HomePage(driver);
			HP.Course("Web Development");
			HP.Search();
			CoursesPage Courses = new CoursesPage(driver);

			Courses.clickonEnglishLanguage();

			Courses.clickonBeginersLevel();

			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_004_SetupEnglishLevel is completed");
	}

}
