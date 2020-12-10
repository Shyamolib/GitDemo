package Training;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utility.baseClass;

public class validateTitle extends baseClass{
	public WebDriver driver;
	
	@BeforeTest
	public void init() throws Throwable{
		
		driver = initDriver();
		
		
		
	}
	
	@Test
	public void basePageNavigationTitle() throws Throwable{
		
		driver.get(prop.getProperty("url"));
		LandingPage lp= new LandingPage(driver);
		String title = lp.getFCourses().getText();
		Assert.assertEquals(title, "FEATURED COURSE123S");
		
	}
	
	@AfterTest 
	public void tearDown(){
		driver.close();
	}
	

}
