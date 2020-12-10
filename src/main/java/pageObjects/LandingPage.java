package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	public WebDriver driver;
	//public WebDriverWait wait;
	
	public LandingPage(WebDriver driver){
		
		this.driver=driver;
		//PageFactory.initElements(this.driver, LandingPage.class);
		
	}
	
	/*@FindBy(xpath="//a[@href='https://rahulshettyacademy.com/sign_in/']")
	public WebElement login;*/
	
	private By signin=By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
	private By fCourses=By.xpath("//div[@class='text-center']/h2");
	private By navBar=By.xpath("//ul[@class='nav navbar-nav navbar-right']/li/a");
	private By popup = By.xpath("//button[text()='NO THANKS']");
	public LoginPage getLogin(){
		
		 driver.findElement(signin).click();
		 LoginPage lop = new LoginPage(driver);
		 return lop;
	}
	
	public WebElement getFCourses(){
		return driver.findElement(fCourses);
	}
	
	public WebElement getNavBar(){
		return driver.findElement(navBar);
	}
	public List<WebElement> getPopUps(){
		return driver.findElements(popup);
	}
	public WebElement getPopUp(){
		return driver.findElement(popup);
	}
}
