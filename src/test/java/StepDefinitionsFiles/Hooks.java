package StepDefinitionsFiles;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import factory.CucumberBaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import testBase.BaseClass;

public class Hooks {
	public static String browser;
	public static String os;
	Logger log = BaseClass.getLogger();
	WebDriver driver;
	Properties p;

	@Before
	public void setUp() throws IOException, InterruptedException {
		log.info("Initializing the Browser setup");
		driver = CucumberBaseClass.setup1(os, browser);

	}

	public static void setTestParameters(ITestContext context) {
		browser = context.getCurrentXmlTest().getParameter("browser");
		os = context.getCurrentXmlTest().getParameter("os");
	}

	@After
	public void quitting(Scenario scenario) throws InterruptedException {
		log.info("Quiting the browser");

		driver.quit();

		driver = null;

	}

	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		log.info("Taking the Screen shot after every step");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		scenario.attach(fileContent, "image/png", "screenshot");

	}
}
