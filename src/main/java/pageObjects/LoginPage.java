package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
	}
	
	private By email=By.id("user_email");
	private By pass=By.id("user_password");
	private By loginbtn=By.xpath("//input[@value='Log In']");
	private By forpas = By.xpath("//div[@class='text-center']/a");
	private By errormsg=By.xpath("//div[@class='alert alert-danger alert-show mb-5']");
	
	
	public WebElement getEmail(){
		return driver.findElement(email);
		
	}
	
	public WebElement getPass(){
		return driver.findElement(pass);
		
	}

	public WebElement getLoginBtn(){
		 
		 //ForgotPassword fop= new ForgotPassword(driver);
		 return driver.findElement(loginbtn);
		
	}
	
	public ForgotPassword getForgotPassLink(){
		 
		 //ForgotPassword fop= new ForgotPassword(driver);
		  driver.findElement(forpas).click();
		  ForgotPassword fop = new ForgotPassword(driver);
		  return fop;
		
	}
	
	public WebElement getErrormsg(){
		 
		 //ForgotPassword fop= new ForgotPassword(driver);
		  return driver.findElement(errormsg);
		 
		
	}


}
