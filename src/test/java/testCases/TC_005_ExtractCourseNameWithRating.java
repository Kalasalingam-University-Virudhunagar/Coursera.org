package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.CoursePageAfterFilteration;
import pageObjects.CoursesPage;
import pageObjects.HomePage;
import testBase.BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class TC_005_ExtractCourseNameWithRating extends BaseClass {

	@Test
	public void ExtractCoursesWithRating() throws InterruptedException {
		logger.info("TC_005_ExtractCourseNameWithRating is started");

		try {
			HomePage HP = new HomePage(driver);
			HP.Course("Web Development");
			HP.Search();
			CoursesPage Courses = new CoursesPage(driver);

			Courses.clickonEnglishLanguage();
			Thread.sleep(5000);

			Courses.clickonBeginersLevel();
			System.out.println("bhanu");
			Thread.sleep(5000);
			CoursePageAfterFilteration CourseInfo = new CoursePageAfterFilteration(driver);

			List<WebElement> courseName = CourseInfo.courseNames();
			List<WebElement> Ratings = CourseInfo.Stars();
			List<WebElement> reviewers = CourseInfo.NoOfReview();
			System.out.println("        courseName       " + " " + "            ratings" + " " + "NoOfReviewers");
			for (int i = 0; i < 2; i++) {
				System.out.println(courseName.get(i).getText() + "       " + Ratings.get(i).getText() + " "
						+ reviewers.get(i).getText());
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_005_ExtractCourseNameWithRating is completed");

	}

}
