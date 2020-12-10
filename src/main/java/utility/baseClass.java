package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class baseClass {
	
	public WebDriver driver;
	public Properties prop;
	public Logger l;
	
	public WebDriver initDriver() throws Throwable{
		
		FileInputStream fip = new FileInputStream(".\\src\\main\\java\\com\\config\\Global.Properties");		
		prop=new Properties();
		prop.load(fip);
		//mvn test -Dbrowser=chrome
		//String bro=System.getProperty("browser");
		String bro = prop.getProperty("browser");
		l=Logger.getLogger("devpinoyLogger");
		
		
		if(bro.contains("chrome")){
			System.setProperty("webdriver.chrome.driver", ".\\Resources\\chromedriver.exe");
			ChromeOptions options= new ChromeOptions();
			if(bro.contains("headless")){
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);
			l.info("Chrome browser selected");
			
		}else if(bro.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", ".\\Resources\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 l.info("Firefox browser selected");
			
		}else if(bro.equalsIgnoreCase("ie")){
			System.getProperty("webdriver.ie.driver", "");
			 driver = new InternetExplorerDriver();
			 l.info("IE browser selected");
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenshotPath(String testCaseName,WebDriver driver) throws Throwable{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sr=ts.getScreenshotAs(OutputType.FILE);
		String destFile=System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+".png";
		FileUtils.copyFile(sr, new File(destFile));
		return destFile;
	}

}
