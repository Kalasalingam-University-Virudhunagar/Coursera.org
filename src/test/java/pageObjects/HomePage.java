package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class HomePage extends BasePage {
	Logger log = BaseClass.getLogger();

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='What do you want to learn?']")
	private WebElement whatDoYouWantToLearn;

	@FindBy(xpath = "//button[@class='nostyle search-button']/div[@class='magnifier-wrapper']")
	private WebElement submitSearch;

	@FindBy(xpath = "//span[normalize-space()='Explore']")
	private WebElement explore;

	@FindBy(xpath = "//a[normalize-space()='For Enterprise']")
	private WebElement enterprise;

	@FindBy(xpath = "//a[normalize-space()='Careers']")
	private WebElement careers;

	@FindBy(xpath = "//img[@alt='Coursera']")
	private WebElement CourseraHomePage;

	public void BackTohomePage() {

		log.info("Back to the Coursera Home Page");

		CourseraHomePage.click();
	}

	public void Course(String CourseName) {

		log.info("Searching the Web Development Courses");
		whatDoYouWantToLearn.sendKeys(CourseName);
	}

	public void Search() {
		log.info("Click on the Search option");
		submitSearch.click();
	}

	public WebElement ExploreButton() {
		log.info("Mouse hover to Explore option");
		return explore;
	}

	public void clickOnEnterprise() {

		log.info("Click on the EnterPrise");
		enterprise.click();
	}

	public WebElement enterpriseElement() {
		log.info("Scroll into the enterprise Webelement");
		return careers;
	}

}
