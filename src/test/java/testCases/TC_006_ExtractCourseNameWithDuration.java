package testCases;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.CoursePageAfterFilteration;
import pageObjects.CoursesPage;
import pageObjects.HomePage;
import pageObjects.courseInformationPage;
import testBase.BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class TC_006_ExtractCourseNameWithDuration extends BaseClass {

	@Test
	public void CourseWithDuration() throws InterruptedException {
		logger.info("TC_006_ExtractCourseNameWithDuration is started");
		try {
			HomePage HP = new HomePage(driver);
			HP.Course("Web Development");
			HP.Search();
			CoursesPage Courses = new CoursesPage(driver);
			Thread.sleep(4000);
			Courses.clickonEnglishLanguage();

			Courses.clickonBeginersLevel();
			System.out.println("bhanu");
			CoursePageAfterFilteration CourseInfo = new CoursePageAfterFilteration(driver);

			List<WebElement> courseName = CourseInfo.courseNames();
			List<WebElement> clickablebutton = CourseInfo.ClickablebuttonOFNextPage();
			Set<String> windows;
			String parent, child, grand;
			courseInformationPage info = new courseInformationPage(driver);
			int k = 0;
			// System.out.println(" courseName "+" "+"DurationOfCourse");
			for (int i = 0; i < 2; i++) {

				System.out.println(courseName.get(i).getText());
				WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
				mywait.until(ExpectedConditions.elementToBeClickable(clickablebutton.get(i))).click();

				Thread.sleep(5000);
				windows = driver.getWindowHandles();
				if (k == 0) {
					Iterator it = windows.iterator();
					parent = (String) it.next();

					child = (String) it.next();
					driver.switchTo().window(child);
				} else if (k == 1) {
					Iterator it = windows.iterator();
					parent = (String) it.next();

					child = (String) it.next();
					grand = (String) it.next();
					driver.switchTo().window(grand);

				} else {
					break;
				}
				Thread.sleep(5000);
				System.out.println(info.Duration().getText());
				driver.switchTo().window(parent);
				parent = null;
				child = null;
				windows = null;
				k = k + 1;
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_006_ExtractCourseNameWithDuration is completed");
	}

}
