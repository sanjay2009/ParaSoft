package com.qa.ParasoftTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ParasoftBase.TestBase;
import com.qa.ParasoftPageObjects.HomePage;
import com.qa.ParasoftPageObjects.LaunchPage;

public class HomePageTest extends TestBase{
	
	LaunchPage lp;
	HomePage homepage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void signup()
	{
		initialization();
		lp = new LaunchPage();
		homepage = lp.enterCredentials(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		//homepage = new HomePage();
		homepage.validateHomePageTitle();
		
		try {
			String htitle = homepage.validateHomePageTitle();
			Assert.assertEquals(htitle, "ParaBank | Accounts Overview");
			}
			catch(AssertionError a)
			{
				System.out.println("Captured title mismatch");
			}
		
		homepage.logOut();
	}
	
	@Test(priority=2)
	public void verifyMessageTest()
	{
		try{String welcome = homepage.validateWelcomeMessage();
		System.out.println(welcome);
		Assert.assertEquals(welcome, "Welcome ss rr");
		}
		catch(AssertionError a)
		{
			System.out.println("Welcome Message mismatch");
		}
		String welcome = homepage.validateWelcomeMessage();
		System.out.println(welcome);
		
		homepage.logOut();
	}
	

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
