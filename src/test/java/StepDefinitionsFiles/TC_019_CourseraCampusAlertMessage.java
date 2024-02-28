package StepDefinitionsFiles;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.CucumberBaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CampusPage;
import pageObjects.CourseraCampus;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_019_CourseraCampusAlertMessage {
	WebDriver driver = CucumberBaseClass.getDriver();
	HomePage home = new HomePage(driver);
	CampusPage campus = new CampusPage(driver);
	CourseraCampus courseraText = new CourseraCampus(driver);
	Logger log = BaseClass.getLogger();

	@When("Scroll the page upto the enterprise element")
	public void scroll_the_page_upto_the_enterprise_element() {
		log.info("TC_019_CourseraCampusAlertMessage is started");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", home.enterpriseElement());
	}

	@When("click on the enterprise")
	public void click_on_the_enterprise() {
		home.clickOnEnterprise();
	}

	@When("click on the Solutions")
	public void click_on_the_solutions() {
		campus.clickOnSolutions();
	}

	@When("click on the campus Coursera")
	public void click_on_the_campus_coursera() {
		campus.clickOnCampusCoursera();
	}

	@When("Enter the form data with invalid data")
	public void enter_the_form_data() {
		courseraText.firstName("Gorthi");
		courseraText.lastName("Prakash");
		courseraText.Email("bhanu@gmail.com");
		courseraText.phone("6745892356");
		courseraText.CompanyName("Anna");
		courseraText.dropdownData();
		courseraText.selectCountry();
		courseraText.selectState();

	}

	@Then("Submit the Form")
	public void submit_the_form() throws InterruptedException {
		courseraText.submitForm();
	}

	@Then("Retrive the error message")
	public void retrive_the_error_message() {
		boolean status = courseraText.Alert();
		if (status) {
			System.out.println(courseraText.AlertMessage());
			log.error(courseraText.AlertMessage());
			Assert.assertTrue(status);
		} else {
			Assert.assertTrue(status);
		}
		log.info("TC_019_CourseraCampusAlertMessage is Completed");
	}

}
