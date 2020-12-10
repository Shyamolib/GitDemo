package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
public WebDriver driver;
	
	public ForgotPassword(WebDriver driver){
		this.driver=driver;
	}
	
	private By emailid = By.xpath("//input[@id='user_email']");
	private By instrbtn = By.xpath("//input[@value='Send Me Instruction']");
	
	
	public WebElement getEmail(){
		
		 return driver.findElement(emailid);
		 
		
	}
	
	public WebElement getInstrBtn(){
		
		 return driver.findElement(instrbtn);
		 
		
	}

}
