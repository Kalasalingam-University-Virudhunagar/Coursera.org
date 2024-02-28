package pageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;

public class CourseraCampus extends BasePage {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	Logger log = BaseClass.getLogger();

	public CourseraCampus(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[@class='cds-119 css-1h2ut4q cds-121']")
	private WebElement courseraCollege;

	@FindBy(id = "FirstName")
	private WebElement FirstName;

	@FindBy(id = "LastName")
	private WebElement LastName;

	@FindBy(id = "Email")
	private WebElement Email;

	@FindBy(id = "Phone")
	private WebElement Phone;

	@FindBy(xpath = "//select")
	private WebElement Institution;

	@FindBy(id = "Company")
	private WebElement Company;

	@FindBy(id = "Title")
	private WebElement Title;

	@FindBy(xpath = "(//select)[3]")
	private WebElement Department;

	@FindBy(xpath = "//select[@id='What_the_lead_asked_for_on_the_website__c']")
	private WebElement needs;

	@FindBy(xpath = "//select[@id='Department']/option")
	private List<WebElement> departments;

	@FindBy(id = "Country")
	private WebElement Country;

	@FindBy(xpath = "//span[@class='mktoButtonWrap mktoRound']/button")
	private WebElement submit;

	@FindBy(xpath = "//select[@id='State']")
	private WebElement State;

	@FindBy(xpath = "//select[@id='Institution_Type__c']/option")
	private List<WebElement> InstitutionTypes;

	@FindBy(xpath = "//select[@id='Title']/option")
	private List<WebElement> jobTypes;

	@FindBy(xpath = "//select[@id='What_the_lead_asked_for_on_the_website__c']/option")
	private List<WebElement> needsofJob;

	@FindBy(xpath = "//select[@id='Country']/option")
	private List<WebElement> TotalNoOfCountries;

	@FindBy(xpath = "//select[@id='State']/option")
	private List<WebElement> TotalNoOfstates;

	@FindBy(xpath = "//select[@id='Self_reported_employees_to_buy_for__c']/option")
	private List<WebElement> expectLearners;

	@FindBy(id = "Self_reported_employees_to_buy_for__c")
	private WebElement Learners;

	@FindBy(xpath = "//div[@id='ValidMsgEmail']")
	private WebElement alert;

	public int Institutions() {
		log.info("Total no of Institution Types");
		return InstitutionTypes.size();
	}

	public int Jobs() {
		log.info("Total no of Jobs Types");
		return jobTypes.size();
	}

	public int noOfDepartments() {
		log.info("Total no of departments");
		return departments.size();
	}

	public WebElement FirstNameElement() {
		log.info("WebElement of FirstName");
		return FirstName;
	}

	public int needForJobs() {
		log.info("Total size of job needs");
		return needsofJob.size();
	}

	public int nOfCountries() {
		log.info("Total no of Countries");
		return TotalNoOfCountries.size();
	}

	public int StatesCount() {
		log.info("Total No of States");
		return TotalNoOfstates.size();
	}

	public int learnersexpecting() {
		log.info("Except listeners");
		return expectLearners.size();
	}

	public boolean Alert() {
		log.info("if Alert Web Element is displayed it return true if not it throws false");
		if (alert.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public String AlertMessage() {
		log.info("Alert Message");
		return alert.getText();
	}

	public boolean courseraCollegeElement() {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollTo(0, 0);");
		log.info("Checking the course college page");
		boolean college = courseraCollege.isDisplayed();
		if (college) {
			return college;
		} else {
			return college;
		}
	}

	public String courseraCollegeText() {
		log.info("Course College Text");
		return courseraCollege.getText();
	}

	public void firstName(String firstName) {
		log.info("Sending the first name");
		FirstName.sendKeys(firstName);
	}

	public void lastName(String lastName) {
		log.info("Sending the Last Name");
		LastName.sendKeys(lastName);
	}

	public void Email(String email) {
		log.info("sending the email");
		Email.sendKeys(email);
	}

	public void phone(String phon) {
		log.info("Sending the phone number");
		Phone.sendKeys(phon);
	}

	public void InstitutionType() {
		log.info("Selecting the data in drop down of Institution types ");
		Institution.click();
		int TotalnoOfinstitutionTypes = Institutions();
		Select InstitutionType = new Select(Institution);
		InstitutionType.selectByIndex(BaseClass.randomeNumber(TotalnoOfinstitutionTypes));

	}

	public void CompanyName(String IsCompany) {
		log.info("Sending the Company name");
		Company.sendKeys(IsCompany);
	}

	public void jobTypes() {
		log.info("Selecting the data in drop down of Job Type");
		Title.click();
		int TotalnoOfJobTypes = Jobs();
		Select JobRole = new Select(Title);
		JobRole.selectByIndex(BaseClass.randomeNumber(TotalnoOfJobTypes));
	}

	public void selectDepartment() {
		log.info("Selecting the data in drop down of Department");
		Department.click();
		int TotalnoOfDepartments = noOfDepartments();
		Select Sector = new Select(Department);
		Sector.selectByIndex(BaseClass.randomeNumber(TotalnoOfDepartments));
	}

	public void needsofRole() throws InterruptedException {
		log.info("Selecting the data in drop down of Job needs");
		needs.click();
		int TotalnoOfjobneeds = needForJobs();
		int a = BaseClass.randomeNumber(TotalnoOfjobneeds);
		List<WebElement> needsrole = needsofJob;

		Select wants = new Select(needs);

		wants.selectByVisibleText(needsrole.get(a).getText());

	}

	public void selectCountry() {
		log.info("Selecting the data in drop down of Country");
		Country.click();
		int TotalnoOfcountries = nOfCountries();
		Select CountryIs = new Select(Country);
		CountryIs.selectByIndex(BaseClass.randomeNumber(TotalnoOfcountries));
		Country.click();

	}

	public void selectCountry(String india) {
		log.info("Sending the data of Country");
		Country.click();
		Select CountryIs = new Select(Country);
		CountryIs.selectByVisibleText(india);

	}

	public void stateSelection() {
		log.info("Checking  the state dropdown if it is  present");

		boolean status = State.isDisplayed();

		if (status) {
			log.info("Selecting the data in drop down of Country");
			State.click();
			int TotalnoOfStatesCount = StatesCount();

			Select Base = new Select(State);
			Base.selectByIndex(BaseClass.randomeNumber(TotalnoOfStatesCount));
		}

	}

	public void selectState() {
		log.info("Checking  the state dropdown if it is  present");
		log.info("Selecting the data in drop down of Country");
		try {
			WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));

			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='State']")));

			State.click();
			int TotalnoOfStatesCount = StatesCount();

			Select Base = new Select(State);
			Base.selectByIndex(BaseClass.randomeNumber(TotalnoOfStatesCount));

		} catch (Exception e) {

		}

	}

	public WebElement stat() {
		log.info("Returning the state");
		return State;
	}

	public boolean selectListeners() {
		try {
			WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(2));

			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Self_reported_employees_to_buy_for__c")));
			Learners.click();
			int TotalnoOfLearners = learnersexpecting();

			int a = BaseClass.randomeNumber(TotalnoOfLearners);

			Select NoOfLearners = new Select(Learners);
			NoOfLearners.selectByIndex(a);
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public WebElement Listeners() {
		log.info("Returning the listeners webelemet");
		return Learners;
	}

	public void submitForm() throws InterruptedException {

		js.executeScript("window.scrollBy(0, 200)");
		log.info("clicking on the submit");

		submit.click();

	}

	public boolean stateisDisplayed() {
		if (State.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean LearnersisDisplayed() {
		if (Learners.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public void dropdownData() {
		log.info("Selecting the data in drop down of Institution types ");
		log.info("Selecting the data in drop down of Job Type");
		log.info("Selecting the data in drop down of Department");
		log.info("Selecting the data in drop down of Job needs");
		int k = 0;

		for (int i = 1; i <= 4; i++) {

			if (k == 0) {
				if (i == 3) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0, 300)");
					List<WebElement> checkTheWebElement = driver.findElements(By.xpath("(//select)[" + i + "]"));
					if (checkTheWebElement.size() == 1) {
						WebElement selects = driver.findElement(By.xpath("(//select)[" + i + "]"));
						selects.click();
						List<WebElement> categories = driver.findElements(By.xpath("(//select)[" + i + "]/option"));
						Select dataPass = new Select(selects);
						dataPass.selectByIndex(BaseClass.randomeNumber(categories.size()));

					}

				} else {

					List<WebElement> checkTheWebElement = driver.findElements(By.xpath("(//select)[" + i + "]"));

					if (checkTheWebElement.size() == 1) {
						WebElement selects = driver.findElement(By.xpath("(//select)[" + i + "]"));
						selects.click();
						List<WebElement> categories = driver.findElements(By.xpath("(//select)[" + i + "]/option"));
						Select dataPass = new Select(selects);
						dataPass.selectByIndex(BaseClass.randomeNumber(categories.size()));

					}

				}
			}

		}

	}
}
