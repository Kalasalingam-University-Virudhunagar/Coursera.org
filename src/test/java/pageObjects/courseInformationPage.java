package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class courseInformationPage extends BasePage {

	Logger log = BaseClass.getLogger();

	public courseInformationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "(//div[contains(text(),'hours')])[2]")
	WebElement courseDuration;

	public WebElement Duration() {
		log.info("Returning the Course Duration WebElement");
		return courseDuration;
	}

}
