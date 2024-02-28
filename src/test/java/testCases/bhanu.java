package testCases;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.courseInformationPage;

public class bhanu {
	
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		
		driver.manage().window().maximize();
		driver.get("https://www.coursera.org/");
		System.out.println(driver.getTitle());
		System.out.println("This is the title");
		driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']")).sendKeys("Web Development");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='nostyle search-button']/div[@class='magnifier-wrapper']")).click();
		Thread.sleep(5000);
		List<WebElement> courseName = driver.findElements(By.xpath("//h3[@class='cds-CommonCard-title css-1sktkql']"));
		List<WebElement> NextcourseName = driver.findElements(By.xpath("//div[@class='cds-ProductCard-gridCard']"));
		WebElement duration;
		Set<String> windows;
		String parent,child,grand;
		int k=0;
		//System.out.println("        courseName               "+" "+"DurationOfCourse");
		for(int i=0;i<2;i++) {
			
			
			System.out.println(courseName.get(i).getText());
			WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
			mywait.until(ExpectedConditions.elementToBeClickable(NextcourseName.get(i))).click();
		    i=0;
			Thread.sleep(5000);
            windows =  driver.getWindowHandles();
			if(k==0) {
				Iterator it=windows.iterator();
				parent = (String) it.next();
				
				child = (String) it.next();
				driver.switchTo().window(child);
			}
			else if(k==1){
				Iterator it=windows.iterator();
				parent = (String) it.next();
				
				child = (String) it.next();
				grand = (String) it.next();
				driver.switchTo().window(grand);
				
				
			}
			else {
				break;
			}
			/*Iterator it=windows.iterator();
			parent = (String) it.next();
			
			child = (String) it.next();
			driver.switchTo().window(child);*/
			Thread.sleep(5000);
			System.out.println("bhanu");
			
			System.out.println("bhnau");
			System.out.println(driver.findElement(By.xpath("(//div[contains(text(),'hours')])[2]")).getText());
			
			driver.switchTo().window(parent);
			parent = null;
			child = null;
			windows = null;
			k = k+1;
			Thread.sleep(5000);
		}
	}

}
