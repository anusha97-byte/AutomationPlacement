package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	WebDriver driver;
	@FindBy(xpath="//input[@placeholder='Username']")WebElement username;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement submit;
	@FindBy(xpath="//a[text()='Home']") WebElement dashboard;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	
	public void enterUsername(String user)
	{
		username.sendKeys(user);
	}
	public void enterpassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void clickSignin()
	{
		submit.click();
	}
	
	public boolean isDashboardDisplayedAfterLogin()
	{
		return dashboard.isDisplayed();
	}
	public boolean isAlertDisplayedAfterWrongCredentialsEntered()
	{
		return alert.isDisplayed();
	}
	
}
