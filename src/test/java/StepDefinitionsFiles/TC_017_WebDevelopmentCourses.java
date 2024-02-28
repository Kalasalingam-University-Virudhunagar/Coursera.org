package StepDefinitionsFiles;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.CucumberBaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CoursePageAfterFilteration;
import pageObjects.CoursesPage;
import pageObjects.HomePage;
import pageObjects.courseInformationPage;
import testBase.BaseClass;

public class TC_017_WebDevelopmentCourses {
	WebDriver driver = CucumberBaseClass.getDriver();
	HomePage HP = new HomePage(driver);
	CoursesPage Courses = new CoursesPage(driver);
	Logger log = BaseClass.getLogger();

	@When("passing the parameter {string}")
	public void passing_the_parameter(String string) {

		HP.Course("Web Development");

	}

	@When("and Click on the Search")
	public void and_click_on_the_search() {
		HP.Search();

	}

	@When("click on english Language")

	public void click_on_english_language() {
		log.info("TC_017_WebDevelopmentCourses test Case is Started");
		Courses.clickonEnglishLanguage();

	}

	@When("click on Begineer level")
	public void click_on_begineer_level() {
		Courses.clickonBeginersLevel();
	}

	@Then("Retriving the details of two courses")
	public void retriving_the_details_of_two_courses() throws InterruptedException {
		CoursePageAfterFilteration CourseInfo = new CoursePageAfterFilteration(driver);

		List<WebElement> courseName = CourseInfo.courseNames();
		List<WebElement> Ratings = CourseInfo.Stars();
		List<WebElement> clickablebutton = CourseInfo.ClickablebuttonOFNextPage();
		Set<String> windows;
		String parent, child, grand;
		courseInformationPage info = new courseInformationPage(driver);
		int k = 0;
		System.out.println("        courseName       " + " " + "            ratings" + " " + "NoOfReviewers");
		for (int i = 0; i < 2; i++) {
			System.out.println(courseName.get(i).getText() + "       " + Ratings.get(i).getText());
			WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
			mywait.until(ExpectedConditions.elementToBeClickable(clickablebutton.get(i))).click();

			Thread.sleep(10000);
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
		log.info("TC_017_WebDevelopmentCourses test Case is completed");

	}

}
