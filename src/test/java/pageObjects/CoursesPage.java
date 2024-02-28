package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class CoursesPage extends BasePage {

	Logger log = BaseClass.getLogger();

	public CoursesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@data-e2e='NumberOfResultsSection']/span")
	WebElement ResultsForWebApplicatio;

	@FindBy(xpath = "//div[contains(@data-testid,'Beginner')]")
	WebElement Beginers;

	@FindBy(xpath = "//input[@id='cds-react-aria-94']")
	WebElement BeginersView;

	@FindBy(xpath = "//div[contains(@data-testid,'English')]")
	WebElement Language;

	public WebElement WebResults() {
		log.info("Returning  the web development courses webElement");
		return ResultsForWebApplicatio;
	}

	public void clickonBeginersLevel() {
		log.info("Clicking on the Beginners level");
		Beginers.click();

	}

	public void clickonEnglishLanguage() {
		log.info("Clicking on the langugae");
		Language.click();

	}

	public WebElement englishElement() {
		log.info("Returning the english Web Element");
		return Language;
	}

}
