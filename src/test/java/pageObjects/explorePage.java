package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class explorePage extends BasePage {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	Logger log = BaseClass.getLogger();

	public explorePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "language-learning~menu-item")
	private WebElement LanguageLearningOption;

	@FindBy(xpath = "//a[normalize-space()='All Language Courses']")
	private WebElement AllLanguageCourses;

	public void clickOnLanguageLearning() {
		log.info("Click on the Language Learning option");
		LanguageLearningOption.click();
	}

	public void clickOnAllLanguageCourses() throws InterruptedException {
		js.executeScript("window.scrollBy(0, 300)");
		log.info("Click on the All Language Courses");
		Thread.sleep(10000);
		AllLanguageCourses.click();
	}

	public WebElement LanguageLearningOption() {
		// TODO Auto-generated method stub
		log.info("Returning  the Language learning");
		return LanguageLearningOption;
	}

	public WebElement AllLanguageLearningOption() {
		// TODO Auto-generated method stub
		log.info("Returning  the Language learning");
		return AllLanguageCourses;
	}

}
