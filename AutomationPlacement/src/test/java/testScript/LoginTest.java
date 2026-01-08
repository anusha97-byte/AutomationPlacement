package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends Base
{
	@Test
	public void loginWithValidCeredentials()
	{
		String user="Admin";
		String pass="admin";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterpassword(pass);
		loginpage.clickSignin();
		boolean dashboarddisplay=loginpage.isDashboardDisplayedAfterLogin();
		Assert.assertTrue(dashboarddisplay);
	}
	@Test
	public void loginWithBothInvalidCeredentials()
	{
		String user="12443";
		String pass="865jf";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterpassword(pass);
		loginpage.clickSignin();
		boolean alertdisplay=loginpage.isAlertDisplayedAfterWrongCredentialsEntered();
		Assert.assertTrue(alertdisplay);
	}
}
