package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		
		 prop=new Properties();
		FileInputStream fs=new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		prop.load(fs);
		String browserName= prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\eclipse-workspace\\E2EProject\\chromedriver.exe");
			 driver= new ChromeDriver();
			
		}
		else if (browserName.equals("IE")) {
			driver= new InternetExplorerDriver();
		}
		else if(browserName.equals("Firefox")) {
			driver= new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String getScreenshotPath(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}
