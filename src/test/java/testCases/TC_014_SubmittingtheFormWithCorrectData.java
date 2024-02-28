package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CampusPage;
import pageObjects.CourseraCampus;
import pageObjects.ExploreCoursesInCourseraCampus;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_014_SubmittingtheFormWithCorrectData extends BaseClass {

	@Test
	public void SubmittingtheFormWithCorrectData() {
		logger.info("TC_013_AlertMessageFromFOormNegativeData is started");

		try {
			HomePage home = new HomePage(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", home.enterpriseElement());
			home.clickOnEnterprise();
			CampusPage campus = new CampusPage(driver);
			campus.clickOnSolutions();
			campus.clickOnCampusCoursera();
			CourseraCampus courseraText = new CourseraCampus(driver);
			courseraText.firstName("Gorthi");
			courseraText.lastName("Prakash");
			courseraText.Email("bhanu@cognizant.com");
			courseraText.phone("6745892356");

			courseraText.CompanyName("Anna");
			courseraText.dropdownData();
			courseraText.selectCountry();

			courseraText.selectState();

			courseraText.submitForm();

			ExploreCoursesInCourseraCampus Confirmationcampus = new ExploreCoursesInCourseraCampus(driver);

			boolean ConfirmationPageForCoursera = Confirmationcampus.ConfirmationPage();
			if (ConfirmationPageForCoursera) {
				System.out.println(Confirmationcampus.ConfirmationPageForCourseraCampus());
				Assert.assertTrue(ConfirmationPageForCoursera);
			} else {
				Assert.fail();
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_013_AlertMessageFromFOormNegativeData is completed");

	}

}
