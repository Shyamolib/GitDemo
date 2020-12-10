package Training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utility.baseClass;

public class HomePage extends baseClass {

	public WebDriver driver;

	@BeforeTest
	public void init() throws Throwable {

		driver = initDriver();

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String email, String password) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);

		//wait.until(ExpectedConditions.elementToBeClickable(lp.getLogin())).click();

		// lp.getLogin().click();

		//LoginPage lop = new LoginPage(driver);
		LoginPage lop = lp.getLogin();

		lop.getEmail().sendKeys(email);
		Thread.sleep(2000);
		lop.getPass().sendKeys(password);
		Thread.sleep(2000);
		lop.getLoginBtn().click();
		Thread.sleep(2000);
		ForgotPassword fop = lop.getForgotPassLink();
		Thread.sleep(2000);
		fop.getEmail().sendKeys("xxx");
		Thread.sleep(2000);
		fop.getInstrBtn().click();
		
		

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] obj = new Object[2][2];
		obj[0][0] = "abc@gmail.com";
		obj[0][1] = "pass1";

		obj[1][0] = "xyz@gmail.com";
		obj[1][1] = "pass2";

		return obj;

	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
