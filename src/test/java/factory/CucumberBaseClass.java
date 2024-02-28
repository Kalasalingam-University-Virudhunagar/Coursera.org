package factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import testBase.BaseClass;

public class CucumberBaseClass {

	public static WebDriver driver = null;
	static Properties p;

	static Logger logger = BaseClass.getLogger();

	public static WebDriver setup1(String os, String br) throws IOException

	{

		logger.info("Cucumber reports");

		if (getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {

			DesiredCapabilities capabilities = new DesiredCapabilities();

			// os
			if (os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching os..");

			}

			// browser
			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser..");
			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

		} else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			// launching browser based on condition - locally
			switch (br.toLowerCase()) {
			case "chrome":

				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser..");
				driver = null;
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();
		return driver;

	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties getProperties() {
		FileReader file = null;
		try {
			file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		p = new Properties();
		try {
			p.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public static int randomeNumber(int k) {

		int randomNum = ThreadLocalRandom.current().nextInt(3, k - 1);

		return randomNum;
	}

}
