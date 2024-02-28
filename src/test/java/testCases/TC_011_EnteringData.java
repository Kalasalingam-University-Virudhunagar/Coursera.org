package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CampusPage;
import pageObjects.CourseraCampus;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_011_EnteringData extends BaseClass {

	@Test
	public void ValidatCampusOfCoursera() {

		logger.info("TC_011_EnteringData is started");

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
			courseraText.Email("bhanu@gmail.com");
			courseraText.phone("6745892356");

			courseraText.CompanyName("Anna");
			courseraText.dropdownData();

			courseraText.selectCountry();

			courseraText.selectState();
			Assert.assertTrue(true);

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_011_EnteringData is completed");
	}

}
