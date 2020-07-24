package com.qa.ParasoftTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ParasoftBase.TestBase;
import com.qa.ParasoftPageObjects.HomePage;
import com.qa.ParasoftPageObjects.LaunchPage;
import com.qa.ParasoftPageObjects.OpenNewAccount;
import com.qa.ParasoftPageObjects.RegisterPage;



public class LoginTestCase extends TestBase{
	
	LaunchPage lp;
	HomePage hp;
	
	
	public LoginTestCase()
	{
		super();
	}
	
	@BeforeMethod
	public void signup()
	{
		initialization();
		lp = new LaunchPage();
	}
	
	@Test(priority=1)
	public void validateLaunchPageTitleTest()
	{
		
		String tt = lp.LaunchPageTitle();
		Assert.assertEquals("ParaBank1 | Welcome | Online Banking", tt);
		hp.logOut();
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		lp.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));
		String welcome = hp.validateWelcomeMessage();
		System.out.println(welcome);
		hp.logOut();
	}
	
		
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
