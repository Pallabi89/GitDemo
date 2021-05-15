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

public class ValidateNavigationBar extends base {
		public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
@BeforeTest

public void initialize() throws IOException {
	driver = initializeDriver();
	driver.get(prop.getProperty("url"));
}
	
@Test
	
	public void validateNavigationBar() throws IOException {
		LandingPage ladingPage=new LandingPage(driver);
		Assert.assertTrue(ladingPage.getNavBar().isDisplayed());
		log.info("Navigation bar is displayed");
		
	}

@AfterTest
public void tearDown() {
	driver.close();
}
}
