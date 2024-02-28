package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger; //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	// public static WebDriver driver = null;
	public static WebDriver driver;// parallel testing
	public static Logger logger = getLogger();
	public Properties p;

	@BeforeMethod
	@Parameters({ "os", "browser" })
	public void setup(String os, String br) throws IOException

	{
		// loading properties file

		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		// loading log4j

		logger.info("Loading properties file");

		if (p.getProperty("execution_env").equalsIgnoreCase("remote"))

		{
			logger.info("Execution in Remote Environment");

			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os
			if (os.equalsIgnoreCase("windows")) {
				logger.info("Execution in windows");
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac"))

			{
				logger.info("Execution in MAC");
				capabilities.setPlatform(Platform.MAC);
			} else {
				logger.info("No Matching operating System");
				System.out.println("No matching os..");
				return;
			}

			// browser
			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				logger.info("Execution in  chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				logger.info("Execution in edge");
				break;
			default:
				System.out.println("No matching browser..");
				return;
			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			logger.info("Grid Link");

		} else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			// launching browser based on condition - locally
			logger.info("Execution in Local Environment");
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				logger.info("Running in chrome");
				break;
			case "edge":
				driver = new EdgeDriver();
				logger.info("Running in edge");
				break;
			default:
				System.out.println("No matching browser..");
				return;
			}
		}

		logger.info("Giving implicit wait");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		logger.info("Maximize the window");
		driver.manage().window().maximize();
		logger.info("Navigating to the Url");
		driver.get(p.getProperty("appURL"));

	}

	@AfterMethod
	public void tearDown() {
		logger.info("quiting the browser");
		driver.quit();
	}

	public static WebDriver getDriver() {
		return BaseClass.getDriver();
	}

	public static Logger getLogger() {

		logger = LogManager.getLogger();// Log4j
		logger.info("Created logger file");
		return logger;
	}

	public static int randomeNumber(int k) {

		int randomNum = ThreadLocalRandom.current().nextInt(3, k - 1);

		return randomNum;
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}
}
