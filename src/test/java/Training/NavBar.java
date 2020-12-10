package Training;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import utility.baseClass;

public class NavBar extends baseClass {
	
	public WebDriver driver;
	
	@BeforeTest
	public void init() throws Throwable{
		
		driver = initDriver();
		
		
		
	}
	
	@Test
	public void basePageNavigationNavBar() throws Throwable{
		
		driver.get(prop.getProperty("url"));
		LandingPage lp= new LandingPage(driver);
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.close();
	}
}
