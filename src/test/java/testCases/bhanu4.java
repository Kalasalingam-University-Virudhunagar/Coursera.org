package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import testBase.BaseClass;

public class bhanu4 {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		
		driver.manage().window().maximize();
		/*driver.get("https://www.coursera.org/campus?utm_campaign=website&utm_content=corp-to-home-footer-for-enterprise&utm_medium=coursera&utm_source=enterprise");
		
		try {
			WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(5));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			WebElement element = driver.findElement(By.id("Country"));
			js.executeScript("arguments.scrollIntoView(true);",element);
			//boolean status = driver.findElement(By.id("State")).isDisplayed();
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("State")));
			
				System.out.println("it is there");
			
		}
		catch(Exception e) {
			System.out.println("NotThere");
		}
		
		WebElement NeedsOfRole = driver.findElement(By.id("What_the_lead_asked_for_on_the_website__c"));
		NeedsOfRole.click();
		List<WebElement> needsofJob = driver.findElements(By.xpath("//select[@id='What_the_lead_asked_for_on_the_website__c']/option"));
		String b = needsofJob.get(2).getText();
		System.out.println(b);
		Select needs = new Select(NeedsOfRole);
		needs.selectByVisibleText(b);
		NeedsOfRole.click();*/
		for(int j=1;j<5;j++) {
			driver.get("https://www.coursera.org/campus?utm_campaign=website&utm_content=corp-to-home-footer-for-enterprise&utm_medium=coursera&utm_source=enterprise");
			for(int i=1;i<=5;i++) {
				System.out.println(i);
				WebElement selects = driver.findElement(By.xpath("(//select)[" +i+ "]"));
				selects.click();
				List<WebElement> categories = driver.findElements(By.xpath("(//select)[" +i+ "]/option"));
				Select dataPass = new Select(selects);
				dataPass.selectByIndex(BaseClass.randomeNumber(categories.size()));
				System.out.println("Completed");
				
			
		}
		
		
	}
	}

}
