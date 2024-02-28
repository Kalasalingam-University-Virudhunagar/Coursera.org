package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class CampusPage extends BasePage {

	Logger log = BaseClass.getLogger();

	public CampusPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		super(driver);
	}

	@FindBy(xpath = "//a[normalize-space()='Solutions']")
	private WebElement solutions;

	@FindBy(xpath = "//p[normalize-space()='Coursera for Campus']")
	private WebElement courseraCampus;

	public void clickOnSolutions() {
		log.info("Clicking on the Solution");
		solutions.click();
	}

	public void clickOnCampusCoursera() {
		log.info("Click on the Course Campus option");
		courseraCampus.click();
	}

}
