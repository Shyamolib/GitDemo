package setDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import utility.baseClass;

public class stepDefinition extends baseClass{
	
	public WebDriver driver;
	LoginPage lop;
	
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
			driver = initDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^User clicks on Login Button to land on Sign page$")
	public void user_clicks_on_Login_Button_to_land_on_Sign_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		LandingPage lp = new LandingPage(driver);
		if(lp.getPopUps().size()>0){
			lp.getPopUp().click();
		}
		lop = lp.getLogin();
	}
	
	@When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		lop.getEmail().sendKeys(username);
		Thread.sleep(2000);
		lop.getPass().sendKeys(password);
		Thread.sleep(2000);
		lop.getLoginBtn().click();
		Thread.sleep(2000);
    }

	@Then("^Verify that user get error msg$")
	public void Verify_that_user_get_error_msg() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String text = lop.getErrormsg().getText();
		if(text.equalsIgnoreCase("Invalid email or password.")){
			Assert.assertTrue(true);
		}

	}
	
	@And("^Close browsers$")
	public void Close_browsers(){
		System.out.println("Commit to git");
		driver.quit();
	}


}