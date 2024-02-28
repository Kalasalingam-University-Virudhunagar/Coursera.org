package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.HomePage;
import testBase.BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class TC_003_SetupBeginnersLevel extends BaseClass {

	@Test
	public void BeginnersLevel() throws InterruptedException {
		logger.info("TC_003_SetupBeginnersLevel is started");
		try {
			HomePage HP = new HomePage(driver);
			HP.Course("Web Development");
			HP.Search();
			CoursesPage Courses = new CoursesPage(driver);

			Courses.clickonBeginersLevel();
			Thread.sleep(5000);
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_003_SetupBeginnersLevel is completed");

	}

}
