package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CampusPage;
import pageObjects.CourseraCampus;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_010_ValidatCampusOfCoursera extends BaseClass {

	@Test
	public void ValidatCampusOfCoursera() {
		logger.info("TC_010_ValidatCampusOfCoursera is started");

		try {
			HomePage home = new HomePage(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", home.enterpriseElement());
			home.clickOnEnterprise();
			CampusPage campus = new CampusPage(driver);
			campus.clickOnSolutions();
			campus.clickOnCampusCoursera();
			CourseraCampus courseraText = new CourseraCampus(driver);
			boolean coursera = courseraText.courseraCollegeElement();
			System.out.println(coursera);
			if (coursera) {
				System.out.println(courseraText.courseraCollegeText());
				Assert.assertTrue(true);
			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_010_ValidatCampusOfCoursera is started");
	}

}
