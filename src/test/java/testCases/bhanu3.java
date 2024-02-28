package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bhanu3 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		
		driver.manage().window().maximize();
		driver.get("https://www.coursera.org/");
		WebElement enter = driver.findElement(By.xpath("//a[normalize-space()='For Enterprise']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", enter);
		//js.executeScript("arguments[0].click();", enter);
		
		
		//driver.findElement(By.xpath("(//ul[@class='rc-SubFooterSection__content-column-links'])[5]/li[10]")).click();
		driver.findElement(By.xpath("//a[normalize-space()='For Enterprise']")).click();
		System.out.println("bhanu");
		driver.findElement(By.xpath("//a[normalize-space()='Solutions']")).click();
		System.out.println("bhanu");
		driver.findElement(By.xpath("//p[normalize-space()='Coursera for Campus']")).click();
		System.out.println("bhanu");
		//WebElement courseraCampus = driver.findElement(By.className("cds-119 css-1h2ut4q cds-121"));
		//System.out.println(courseraCampus.getText());
		driver.findElement(By.id("FirstName")).sendKeys("Gorthi");
		System.out.println("bhanu");
		driver.findElement(By.id("LastName")).sendKeys("What");
		System.out.println("bhanu");
		driver.findElement(By.id("Email")).sendKeys("bhanuprakashgorthi@gmail.com");
		System.out.println("bhanu");
		driver.findElement(By.id("Phone")).sendKeys("9192939495");
		System.out.println("bhanu");
		WebElement TypeOfInstitution = driver.findElement(By.xpath("//select"));
		TypeOfInstitution.click();
		List<WebElement> InstitutinTypes = driver.findElements(By.xpath("//select[@id='Institution_Type__c']/option"));
		System.out.println(InstitutinTypes.size());
		Select InstitutionType = new Select(TypeOfInstitution);
		InstitutionType.selectByIndex(1);
		
		System.out.println("bhanu");
		
		driver.findElement(By.id("Company")).sendKeys("Anna");
		WebElement TypeOfJob = driver.findElement(By.id("Title"));
		TypeOfJob.click();
		List<WebElement> jobTypes = driver.findElements(By.xpath("//select[@id='Title']/option"));
		System.out.println(jobTypes.size());
		Select JobRole = new Select(TypeOfJob);
		JobRole.selectByIndex(1);
		WebElement TypeOfDepartment = driver.findElement(By.xpath("(//select)[3]"));
		TypeOfDepartment.click();
		List<WebElement> departments = driver.findElements(By.xpath("//select[@id='Department']/option"));
		System.out.println(departments.size());
		Select Department = new Select(TypeOfDepartment);
		Department.selectByIndex(1);
		WebElement NeedsOfRole = driver.findElement(By.id("What_the_lead_asked_for_on_the_website__c"));
		NeedsOfRole.click();
		List<WebElement> needsofJob = driver.findElements(By.xpath("//select[@id='What_the_lead_asked_for_on_the_website__c']/option"));
		System.out.println(needsofJob.size());
		Select needs = new Select(NeedsOfRole);
		needs.selectByIndex(1);
		WebElement countries = driver.findElement(By.id("Country"));
		js.executeScript("window.scrollBy(0, 300)");
		System.out.println("yes");
		countries.click();
		List<WebElement> TotalNoOfCountries = driver.findElements(By.xpath("//select[@id='Country']/option"));
		System.out.println(TotalNoOfCountries.size());
		Select Country = new Select(countries);
		Country.selectByVisibleText("India");
		boolean stat = driver.findElement(By.id("State")).isDisplayed();
		System.out.println(stat);
		Thread.sleep(10000);
		
		
		
		if(driver.findElement(By.id("State")).isDisplayed()) {
			WebElement States = driver.findElement(By.id("State"));
			
			States.click();
			List<WebElement> TotalNoOfstates = driver.findElements(By.xpath("//select[@id='State']/option"));
			System.out.println(TotalNoOfstates.size());
			Select state = new Select(States);
			state.selectByIndex(1);
		}
		if(driver.findElement(By.id("Self_reported_employees_to_buy_for__c")).isDisplayed()) {
			WebElement learners = driver.findElement(By.id("Self_reported_employees_to_buy_for__c"));
			learners.click();
			List<WebElement> expectLearners = driver.findElements(By.xpath("//select[@id='Self_reported_employees_to_buy_for__c']/option"));
			System.out.println(expectLearners.size());
			Select NoOfLearners = new Select(learners);
			NoOfLearners.selectByIndex(1);
			
		}
		
		
		Thread.sleep(10000);
		WebElement submit = driver.findElement(By.xpath("//span[@class='mktoButtonWrap mktoRound']/button"));
		js.executeScript("window.scrollBy(0, 300)");
		submit.click();
		WebElement alert = driver.findElement(By.xpath("//div[@id='ValidMsgEmail']"));
		System.out.println(alert.getText());
		System.out.println("Prakash, Gorthi");
		
		
		
	}

}
