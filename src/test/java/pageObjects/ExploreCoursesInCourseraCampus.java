package pageObjects;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class ExploreCoursesInCourseraCampus extends BasePage {

	Logger log = BaseClass.getLogger();

	public ExploreCoursesInCourseraCampus(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='cds-9 BlockLayout-contentGrid css-o73ff cds-11 cds-grid-item cds-56']/h1")
	WebElement CourseraCampusConfirmationPage;

	public boolean ConfirmationPage() {

		try {
			log.info("Confirmation page for company students");
			List<WebElement> confirmation = driver.findElements(
					By.xpath("//div[@class='cds-9 BlockLayout-contentGrid css-o73ff cds-11 cds-grid-item cds-56']/h1"));
			System.out.println(confirmation.size());
			if (confirmation.size() >= 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public String ConfirmationPageForCourseraCampus() {
		log.info("Returning the Confirmation page");
		return CourseraCampusConfirmationPage.getText();

	}

}
