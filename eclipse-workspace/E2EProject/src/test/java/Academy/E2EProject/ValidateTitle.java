package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class ValidateTitle extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
@Test
	
	public void validateTitle() throws IOException {
		
	
		LandingPage ladingPage=new LandingPage(driver);
		Assert.assertEquals(ladingPage.getTitle().getText(), "FEATURED COURSE");
		log.info("Successfully validated text message");
	}

@AfterTest
public void tearDown() {
	driver.close();
}
}
