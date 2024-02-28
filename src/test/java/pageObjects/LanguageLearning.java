package pageObjects;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class LanguageLearning extends BasePage {

	Logger log = BaseClass.getLogger();

	public LanguageLearning(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@data-e2e='NumberOfResultsSection']/span")
	private WebElement Courses;

	// @FindBy(xpath="(//div[@class='cds-199
	// cds-formGroup-groupWrapper'])[3]/div/label/div/span")
	@FindBy(xpath = "(//div[@class='cds-199 cds-formGroup-groupWrapper'])[4]/div/label/div/span/span")
	private List<WebElement> levels;

	@FindBy(xpath = "//div[@data-testid='search-filter-group-Language']/div[2]/button/span")
	private WebElement LanguageNamesBox;

	@FindBy(xpath = "(//span[@class='cds-button-label'])[14]")
	private WebElement closingLanguagesBox;

	public void LanguageBoxClosing() {

		log.info("Closing the Language Box");
		closingLanguagesBox.click();
	}

	public WebElement LanguageClosingElement() {
		log.info("Returning the Language Box WebElement");
		return closingLanguagesBox;
	}

	@FindBy(xpath = "//div[@id='checkbox-group']/div/label/div/span")
	private List<WebElement> ListOfLanguageNames;

	public boolean coursesIsthere() {
		log.info("Checking the Courses is available or not");
		if (Courses.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public List<WebElement> LevelsOfLanguages() {
		return levels;
	}

	public void ContainsLanguages() {
		log.info("Show all the language names");
		LanguageNamesBox.click();
	}

	public List<WebElement> LanguagesNames() {
		log.info("List of Language Names");
		return ListOfLanguageNames;
	}

}
