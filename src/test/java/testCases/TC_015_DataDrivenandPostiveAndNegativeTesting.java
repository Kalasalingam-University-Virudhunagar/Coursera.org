package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CampusPage;
import pageObjects.CourseraCampus;
import pageObjects.ExploreCoursesInCourseraCampus;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_015_DataDrivenandPostiveAndNegativeTesting extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String FirstName, String LastName, String Email, String PhoneNo, String COmpany,
			String res) throws InterruptedException {

		logger.info("TC_015_DataDrivenandPostiveAndNegativeTesting is started");
		try {

			Thread.sleep(2000);
			HomePage home = new HomePage(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", home.enterpriseElement());

			home.clickOnEnterprise();
			CampusPage campus = new CampusPage(driver);
			campus.clickOnSolutions();
			campus.clickOnCampusCoursera();
			CourseraCampus courseraText = new CourseraCampus(driver);
			Thread.sleep(5000);
			courseraText.firstName(FirstName);
			courseraText.lastName(LastName);
			courseraText.Email(Email);
			courseraText.phone(PhoneNo);

			courseraText.CompanyName(COmpany);

			courseraText.dropdownData();
			courseraText.selectCountry("India");
			Thread.sleep(2000);
			courseraText.selectState();

			courseraText.submitForm();

			Thread.sleep(10000);

			ExploreCoursesInCourseraCampus Confirmationcampus = new ExploreCoursesInCourseraCampus(driver);
			boolean ConfirmationPageForCoursera = Confirmationcampus.ConfirmationPage();
			System.out.println(ConfirmationPageForCoursera);
			Thread.sleep(10000);
			if (res.equalsIgnoreCase("Valid")) {
				if (ConfirmationPageForCoursera == true) {

					Assert.assertTrue(true);
				} else {
					Assert.fail();
				}
			}
			if (res.equalsIgnoreCase("Invalid")) {
				if (ConfirmationPageForCoursera == false) {

					Assert.assertTrue(true);
				} else {
					Assert.fail();
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("TC_015_DataDrivenandPostiveAndNegativeTesting is started");

	}

}
