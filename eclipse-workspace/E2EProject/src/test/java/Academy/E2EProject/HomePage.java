package Academy.E2EProject;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class HomePage extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String username, String password,String text) throws IOException {
		
		driver.get(prop.getProperty("url"));
		LandingPage ladingPage=new LandingPage(driver);
		ladingPage.getLogin().click();
		
		LoginPage loginPage =new LoginPage(driver);
		loginPage.getEmail().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		log.info(text);
		loginPage.getLogin().click();
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object [][] data= new Object[2][3];
		data[0][0]= "palpallabi89@gmail.com";
		data[0][1]="123456";
		data[0][2]="Restricted User";
		
		data[1][0]="pallabi.cse@gmail.com";
		data[1][1]="23456";
		data[1][2]="UnRestriceted User";
		return data;
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
}
