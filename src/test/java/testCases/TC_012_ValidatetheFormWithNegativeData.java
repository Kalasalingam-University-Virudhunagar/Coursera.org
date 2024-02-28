package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CampusPage;
import pageObjects.CourseraCampus;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_012_ValidatetheFormWithNegativeData extends BaseClass {
	@Test
	public void ValidatetheFowmWithNegativeData() throws InterruptedException {
		logger.info("TC_012_ValidatetheFormWithNegativeData is started");
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
			System.out.println("dropdowndata");

			courseraText.submitForm();

			boolean status = courseraText.courseraCollegeElement();
			if (status) {
				Assert.assertTrue(status);
			} else {
				Assert.assertTrue(status);
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_012_ValidatetheFormWithNegativeData is completed");

	}

}
