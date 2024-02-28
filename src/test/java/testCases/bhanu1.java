package testCases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class bhanu1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.get("https://www.coursera.org/");
		WebElement Explore = driver.findElement(By.xpath("//span[normalize-space()='Explore']"));
		Actions act = new Actions(driver);
		act.moveToElement(Explore).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement LanguageLearning = driver.findElement(By.id("language-learning~menu-item"));
		LanguageLearning.click();

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(8000);

		driver.findElement(By.xpath("//a[normalize-space()='All Language Courses']")).click();

		List<WebElement> levels = driver
				.findElements(By.xpath("(//div[@class='cds-199 cds-formGroup-groupWrapper'])[3]/div/label/div/span"));
		for (int i = 0; i < levels.size(); i++) {
			System.out.println(levels.get(i).getText());

		}
		driver.findElement(By.xpath("//div[@data-testid='search-filter-group-Language']/div[2]/button/span")).click();
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\myfile.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet();
		List<WebElement> languages = driver.findElements(By.xpath("//div[@id='checkbox-group']/div/label/div/span"));

		for (int j = 0; j < languages.size(); j++) {
			XSSFRow currentrow = sheet.createRow(j);
			for (int i = 0; i < 1; i++) {
				if (currentrow.getCell(i) == null) {
					String language = languages.get(j).getText();
					currentrow.createCell(i).setCellValue(language);
				} else {
					String language = languages.get(j).getText();
					currentrow.getCell(i).setCellValue(language);

				}

			}

		}
		workbook.write(file);
		workbook.close();
		file.close();

		System.out.println("Writing is done!!!!");

	}

}
