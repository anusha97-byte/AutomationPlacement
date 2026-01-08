package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	@Test
	public void loginWithValidCeredentials() throws IOException
	{
		String user=ExcelUtility.getStringData(1, 0,"loginpage");
		String pass=ExcelUtility.getStringData(1, 1,"loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterpassword(pass);
		loginpage.clickSignin();
		boolean dashboarddisplay=loginpage.isDashboardDisplayedAfterLogin();
		Assert.assertTrue(dashboarddisplay);
	}
	@Test
	public void loginWithBothInvalidCeredentials() throws IOException
	{
		String user=ExcelUtility.getStringData(2, 0, "loginpage");
		String pass=ExcelUtility.getStringData(2, 1,"loginpage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername(user);
		loginpage.enterpassword(pass);
		loginpage.clickSignin();
		boolean alertdisplay=loginpage.isAlertDisplayedAfterWrongCredentialsEntered();
		Assert.assertTrue(alertdisplay);
	}
}
