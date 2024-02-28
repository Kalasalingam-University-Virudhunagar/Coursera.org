package pageObjects;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;

public class CoursePageAfterFilteration extends BasePage {

	Logger log = BaseClass.getLogger();

	public CoursePageAfterFilteration(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h3[@class='cds-CommonCard-title css-1sktkql']")
	List<WebElement> courseName;

	@FindBy(xpath = "//p[@class='cds-119 css-11uuo4b cds-121']")
	List<WebElement> Ratings;

	@FindBy(xpath = "//div[@class='product-reviews css-pn23ng']/p[2]")
	List<WebElement> reviewers;

	@FindBy(xpath = "//div[@class='cds-ProductCard-gridCard']")
	List<WebElement> buttonOFNextPage;

	public List<WebElement> courseNames() {
		log.info("Returning the List of WebElements for Ratings of Course");
		return courseName;
	}

	public List<WebElement> Stars() {
		log.info("Returning the List of WebElements for Stars of Course");
		return Ratings;
	}

	public List<WebElement> NoOfReview() {
		log.info("Returning the List of WebElements for reviewers Count of Course");
		return reviewers;
	}

	public List<WebElement> ClickablebuttonOFNextPage() {
		log.info("Go through the Specific Course Page");
		return buttonOFNextPage;
	}

}
