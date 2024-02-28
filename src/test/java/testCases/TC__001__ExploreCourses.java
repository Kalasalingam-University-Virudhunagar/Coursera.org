package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class TC__001__ExploreCourses extends BaseClass {

	@Test
	public void SearchTheCourse() {

		logger.info("TC__001__ExploreCourses is started");

		try {
			HomePage HP = new HomePage(driver);
			HP.Course("Web Development");
			HP.Search();
			Assert.assertTrue(true);

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC__001__ExploreCourses is completed");

	}

}
