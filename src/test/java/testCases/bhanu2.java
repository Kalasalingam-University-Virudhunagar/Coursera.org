package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bhanu2 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		
		driver.manage().window().maximize();
		driver.get("https://www.coursera.org/");
		driver.findElement(By.xpath("//input[@placeholder='What do you want to learn?']")).sendKeys("Web Development");
		
		driver.findElement(By.xpath("//button[@class='nostyle search-button']/div[@class='magnifier-wrapper']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='cds-react-aria-50']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='cds-react-aria-78']")).click();
	}

}
