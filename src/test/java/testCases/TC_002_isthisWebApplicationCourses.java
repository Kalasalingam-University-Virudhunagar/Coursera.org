package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.CoursesPage;
import pageObjects.HomePage;
import testBase.BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class TC_002_isthisWebApplicationCourses extends BaseClass {
	@Test
	public void WebApplicationCourses() {
		logger.info("TC_002_isthisWebApplicationCourses is started");
		try {
			HomePage HP = new HomePage(driver);
			HP.Course("Web Development");
			HP.Search();
			CoursesPage Courses = new CoursesPage(driver);

			if (Courses.WebResults().getText().contains("Web Development")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail();
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_002_isthisWebApplicationCourses is completed");
	}
}
